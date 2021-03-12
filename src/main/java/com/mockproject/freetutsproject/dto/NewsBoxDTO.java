package com.mockproject.freetutsproject.dto;

import java.util.List;

public class NewsBoxDTO {
    private String categoryName;
    private long id;
    private List<PostDTO> posts;

    public NewsBoxDTO(String categoryName, long id, List<PostDTO> posts) {
        this.categoryName = categoryName;
        this.id = id;
        this.posts = posts;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }
}
