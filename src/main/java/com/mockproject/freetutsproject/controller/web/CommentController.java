package com.mockproject.freetutsproject.controller.web;

import com.mockproject.freetutsproject.dto.CommentDTO;
import com.mockproject.freetutsproject.service.CommentService;
import com.mockproject.freetutsproject.service.CourseService;
import com.mockproject.freetutsproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    @Autowired
    private PostService postService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/comment/")
    public String comment(CommentDTO commentDTO) {
        if (commentDTO.getCourseId() != null) {
            Long courseId = commentDTO.getCourseId();
            if (courseService.availableById(courseId)){
                CommentDTO savedComment = commentService.save(commentDTO);
                return "redirect:web/course/" + savedComment.getCourseId();
            }
        }
        else if (commentDTO.getPostId() != null) {
            Long postId = commentDTO.getPostId();
            if (postService.availableById(postId)) {
                CommentDTO savedComment = commentService.save(commentDTO);
                return "redirect:web/post/" + savedComment.getPostId();
            }
        }
        return "error-404";
    }
}
