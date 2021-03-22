package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.service.PostService;
import com.mockproject.freetutsproject.util.FileUtil;
import com.mockproject.freetutsproject.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Date;

@Controller
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping(value = "/admin/post")
    public String createPost(PostDTO postDTO){
        postService.save(postDTO);
        return "redirect:/admin/panel/?success";
    }
}
