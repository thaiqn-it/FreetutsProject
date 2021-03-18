package com.mockproject.freetutsproject.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsBoxDTO {
    private String categoryName;
    private long id;
    private List<PostDTO> posts;
}