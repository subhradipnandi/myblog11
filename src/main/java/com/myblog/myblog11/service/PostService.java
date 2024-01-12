package com.myblog.myblog11.service;

import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.payload.PostDto;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostDto getPostById(long id);
    //Post createPost(PostDto postDto);
}
