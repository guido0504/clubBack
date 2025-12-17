package com.login.controller;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.post.PostRequestDto;
import com.login.service.imple.post.PostServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/post")
public class PostController {

    @Autowired
    private PostServiceImplement postServiceImplement;

    @PostMapping(value = "create")
    public ResponseDefaultDto create(@RequestBody PostRequestDto postRequestDto){
        return postServiceImplement.create(postRequestDto);
    }

    @GetMapping(value = "/findAll")
    public ResponseDefaultDto findAll(){
        return postServiceImplement.findAll();
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseDefaultDto findById(@PathVariable("id") long id){
        return postServiceImplement.findById(id);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDefaultDto update(@RequestBody @PathVariable("id") long id,@RequestBody PostRequestDto postRequestDto){
        return postServiceImplement.update(id,postRequestDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseDefaultDto delete(@PathVariable("id") long id){
        return postServiceImplement.delete(id);
    }

}
