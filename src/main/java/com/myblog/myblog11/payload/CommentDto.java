package com.myblog.myblog11.payload;

import com.myblog.myblog11.entity.Post;
import lombok.Data;

@Data
public class CommentDto {
    private long id;

    private String text;

    private String email;

}
