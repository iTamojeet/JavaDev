package com.example.service.impl;

import com.example.dto.UserDto;
import com.example.exception.UserNotFound;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserDto> seeAll() {
        return userRepository.findAll()
                .stream()
                .map(x->new UserDto(x.getId(),x.getFirstName(),x.getLastName(),x.getEmail()))
                .toList();
    }

    @Override
    public UserDto seeOne(int id) {
        return modelMapper.map(userRepository.findById(id).orElseThrow(
                ()-> new UserNotFound("User with id "+id+" not found")
        ), UserDto.class);
    }

    @Override
    public List<UserDto> getByEmail(String email) {
        return userRepository.findByEmail(email)
                .stream()
                .map(r->modelMapper.map(r,UserDto.class))
                .toList();
    }
}
