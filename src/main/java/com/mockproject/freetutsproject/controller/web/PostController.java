package com.mockproject.freetutsproject.controller.web;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.service.PostService;
import com.mockproject.freetutsproject.util.MultiLevelCategoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller (value = "postControllerOfWeb")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MultiLevelCategoryUtil categoryUtil;

    @GetMapping(value = "post/{id}")
    public String loadPost(@PathVariable("id") String id, Model model) {
        // Get post
        PostDTO postDTO = this.postService.findById(Long.parseLong(id));

        if (postDTO != null) {
            model.addAttribute("post", postDTO);
            setOtherDataOfPostPage(postDTO, model);
        }
        return "web/post";
    }

    private void setOtherDataOfPostPage(PostDTO postDTO, Model model) {
        // set breadcrumnb
        setBreadcrumbAndRelatePosts(postDTO, model);

        // load omment object for comment form
        model.addAttribute("COMMENT", loadCommentDTO(postDTO.getId()));
    }

    private List<PostDTO> loadRelatePostData(CategoryDTO categoryDTO){
        return postService.findPostByCategoryAndAvailableTrue(categoryDTO);
    }

    private void setBreadcrumbAndRelatePosts(PostDTO postDTO, Model model){
        long categoryId = postDTO.getCategoryId();
        CategoryDTO categoryDTO = categoryService.findById(categoryId);

        // Set breadcrumb data
        List<CategoryDTO> categoryBreadcrumb = categoryUtil.getCategoryListBottomUp(categoryDTO);

        // If post belong to "Lập trình" category
        if (categoryUtil.isBelongToLapTrinh(categoryBreadcrumb)) {
            // Remove "Lập trình" since it not accessible
            categoryBreadcrumb.remove(0);

            // Set relate post
            List<PostDTO> relatePosts = loadRelatePostData(categoryDTO);
            model.addAttribute("RELATED_POSTS", relatePosts);

            // Set next and previous post
            setNextAndPreviousPost(relatePosts, model, postDTO.getId());
        }
        model.addAttribute("BREADCRUMB", categoryBreadcrumb);
    }

    private void setNextAndPreviousPost(List<PostDTO> relatePosts, Model model, Long currentPostId) {
        long previousPostId = -1;
        long nextPostId = -1;
        if (relatePosts.size() > 1) {
            for (int i = 0; i < relatePosts.size(); i++) {
                if(relatePosts.get(i).getId().equals(currentPostId)){
                    if (i == 0) {
                        nextPostId = relatePosts.get(i + 1).getId();
                    } else if (i == relatePosts.size() - 1) {
                        previousPostId = relatePosts.get(i - 1).getId();
                    } else {
                        nextPostId = relatePosts.get(i + 1).getId();
                        previousPostId = relatePosts.get(i - 1).getId();
                    }
                }
            }
        }
        model.addAttribute("PREVIOUS_POST_ID", previousPostId);
        model.addAttribute("NEXT_POST_ID", nextPostId);
    }

    private CommentDTO loadCommentDTO(Long postId) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setPostId(postId);
        return commentDTO;
    }
}
