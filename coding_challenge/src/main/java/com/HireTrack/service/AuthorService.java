package com.HireTrack.service;

import com.HireTrack.exception.ResourceNotFoundException;
import com.HireTrack.model.Author;
import com.HireTrack.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    public Author getAuthorByID(int authorId) {
       return authorRepository.findById(authorId).orElseThrow(()->new ResourceNotFoundException("invalid author id:"));
    }
}
