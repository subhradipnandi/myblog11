package com.myblog.myblog11.service;

import com.myblog.myblog11.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostDto getPostById(long id);



    List<PostDto> getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);

    //Post createPost(PostDto postDto);
}
