package com.login.service;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.post.PostRequestDto;
import com.login.dto.post.PostResponseDto;
import org.postgresql.util.PSQLException;

import java.util.List;

public interface PostService {
    ResponseDefaultDto findAll();
    ResponseDefaultDto findById(Long id);
    ResponseDefaultDto create(PostRequestDto postDto) throws PSQLException;
    ResponseDefaultDto update(Long id, PostRequestDto postDto);
    ResponseDefaultDto delete(Long id);
}