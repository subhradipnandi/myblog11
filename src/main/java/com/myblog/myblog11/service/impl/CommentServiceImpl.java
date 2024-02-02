package com.myblog.myblog11.service.impl;

import com.myblog.myblog11.entity.Comment;
import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.exception.ResourceNotFoundException;
import com.myblog.myblog11.payload.CommentDto;
import com.myblog.myblog11.repository.CommentRepository;
import com.myblog.myblog11.repository.PostRepository;
import com.myblog.myblog11.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post not found with id: " + postId)
        );

//        Comment comment = new Comment();
//        comment.setEmail(commentDto.getEmail());
//        comment.setText(commentDto.getText());
//        comment.setPost(post);

        Comment comment = mapToEntity(commentDto);

        Comment savedComment = commentRepository.save(comment);

//        CommentDto dto = new CommentDto();
//        dto.setId(savedComment.getId());
//        dto.setEmail(savedComment.getEmail());
//        dto.setText(savedComment.getText());

        CommentDto dto = mapToDto(savedComment);

        return dto;
    }

    @Override
    public void deleteComment(long id) {
//        Optional<Comment> findById = commentRepository.findById(id);
//        if(findById.isPresent()){
//            commentRepository.deleteById(id);
//        }else {
//            throw new ResourceNotFoundException("Comment not found with this id:"+id);
//        }

                                 //or

            //    if I want to handle I don't need to handel that because controller always
            //send a response which is a string "Comment is deleted!!" if id is there or not

//        if(!commentRepository.existsById(id)){
//            throw new ResourceNotFoundException("Comment not found with this id:"+id);
//        }
        commentRepository.deleteById(id);;
    }

    @Override
    public CommentDto updateComment(long id, long postId, CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post not found by this id: "+postId)
        );

        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment not found by this id: " + id)
        );

//        comment.setText(commentDto.getText());
//        comment.setEmail(commentDto.getEmail());

        Comment mappedComment = mapToEntity(commentDto);
        mappedComment.setId(comment.getId());
        mappedComment.setPost(post);

        Comment savedComment = commentRepository.save(mappedComment);

        return mapToDto(savedComment);
    }

    CommentDto mapToDto(Comment comment){
        CommentDto commentDto = modelMapper.map(comment, CommentDto.class);
        return commentDto;
    }

    Comment mapToEntity(CommentDto commentDto){
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return comment;
    }
}
