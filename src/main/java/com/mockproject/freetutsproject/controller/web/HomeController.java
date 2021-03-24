package com.mockproject.freetutsproject.controller.web;

import com.mockproject.freetutsproject.dto.CategoryDTO;
import com.mockproject.freetutsproject.dto.NewsBoxDTO;
import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.service.CategoryService;
import com.mockproject.freetutsproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller (value = "homeOfWeb")
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PostService postService;

    @GetMapping(value = "/")
    public String loadHome(Model model){
        List<NewsBoxDTO> newsBoxes = new ArrayList<>();
        List<CategoryDTO> categoryDTOS = categoryService.loadTopLevelCategories();

        for (int i = 0; i < categoryDTOS.size(); i++) {
            CategoryDTO category = categoryDTOS.get(i);

            // Remove ma giam gia va khoa hoc
            if (category.getId() ==  34 || category.getId() == 38){
                categoryDTOS.remove(i);
            }
            else {
                List<PostDTO> posts = postService.findPostByCategoryAndOrderedById(category, 5);
                if (posts != null) {
                    newsBoxes.add(new NewsBoxDTO(category.getName(), category.getId(), posts));
                }
            }
        }
        model.addAttribute("NEWS_BOXES",newsBoxes);

        // Load widget review course
        CategoryDTO category = categoryService.findById((long)34);
        List<PostDTO> postList = postService.findPostByCategoryAndOrderedById(category,5);
        model.addAttribute("COURSE_REVIEW",postList);

        //load owl-carousel
        category = categoryService.findById((long)38);
        postList = postService.findPostByCategoryAndOrderedById(category,12);
        model.addAttribute("COUPON",postList);

        //load exercise
        postList =  postService.findTop20PostByCategoryNameContainingOrderById("Bài tập");
        model.addAttribute("EXERCISE",postList);
        return "web/home";
    }
}
