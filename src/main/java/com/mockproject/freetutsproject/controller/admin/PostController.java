package com.mockproject.freetutsproject.controller.admin;

import com.mockproject.freetutsproject.dto.PostDTO;
import com.mockproject.freetutsproject.util.FileUtil;
import com.mockproject.freetutsproject.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class PostController {
    @Autowired
    FileUtil fileUtil;

    @Autowired
    StringUtil stringUtil;

    @PostMapping(value = "/admin/post")
    public String createPost(PostDTO postDTO) throws IOException {
        fileUtil.writeContentToHTMLOnHardDisk(postDTO.getContentFile(), stringUtil.removeAccent(postDTO.getName()));

        return "redirect:/admin/panel";
    }
}
