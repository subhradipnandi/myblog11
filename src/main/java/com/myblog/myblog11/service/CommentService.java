package com.myblog.myblog11.service;

import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.payload.CommentDto;



public interface CommentService {
    CommentDto createComment(CommentDto commentDto, long postId);

    void deleteComment(long id);


    CommentDto updateComment(long id, long postId, CommentDto commentDto);
}
