package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "/admin/post")
    public String createPost(PostDTO postDTO){
        postService.save(postDTO);
        return "redirect:/admin/panel/?success";
    }


    @GetMapping(value = "/admin/post/update-status:{status}/{id}")
    public String updatePostStatus(@PathVariable("status") boolean status,
                                   @PathVariable("id") Long id) {
        PostDTO dto = postService.findById(id);
        postService.updateStatus(status, dto);
        return "redirect:/admin/post";
    }

    @GetMapping (value = "/admin/post")
    public String loadAdminPost(Model model) {
        List<PostDTO> posts = postService.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("CATEGORIES", categoryService.findBySubCategoriesIsNull());
        model.addAttribute("POST_DTO",new PostDTO());
        return "admin/admin-post";
    }
}
