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
        List<CategoryDTO> categoryDTOS = categoryService.loadTopLevelCategories();

        // Load news boxes
        model.addAttribute("NEWS_BOXES", loadNewsBoxesData(categoryDTOS));

        // Load widget review course
        model.addAttribute("COURSE_REVIEW", loadWidgetReviewCourseData(34));

        //load owl-carousel coupon
        model.addAttribute("COUPON", loadOwlCarouselData(38));

        //load exercise
        model.addAttribute("EXERCISE", loadExerciseData("Bài tập"));
        return "web/home";
    }

    private List<NewsBoxDTO> loadNewsBoxesData(List<CategoryDTO> categoryDTOS) {
        List<NewsBoxDTO> newsBoxes = new ArrayList<>();
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
        return newsBoxes;
    }
    private List<PostDTO> loadWidgetReviewCourseData(long id){
        CategoryDTO category = categoryService.findById(id);
        return postService.findPostByCategoryAndOrderedById(category,5);
    }
    private List<PostDTO> loadOwlCarouselData(long id){
        CategoryDTO category = categoryService.findById(id);
        return postService.findPostByCategoryAndOrderedById(category,12);
    }
    private List<PostDTO> loadExerciseData(String categoryName){
        return postService.findTop20PostByCategoryNameContainingOrderById(categoryName);
    }
}
