package com.myblog.myblog11.service;

import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostDto getPostById(long id);

    List<PostDto> getAllPost();
    //Post createPost(PostDto postDto);
}
