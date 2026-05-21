package com.example.service;

import com.example.dto.UserDto;
import com.example.entity.Address;
import com.example.entity.User;
import com.example.exception.ResourceNotFoundException;
import com.example.mapper.UserMapper;
import com.example.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class UserService {

    private final UserRepository repo;
    private final UserMapper mapper;

    public UserDto create(UserDto dto) {
        User user = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(user));
    }

    public List<UserDto> getAll() {
        return repo.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public UserDto getById(Long id) {
        return mapper.toDTO(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found")));
    }

    public UserDto update(Long id, UserDto dto) {
        User user = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setAddress(new Address(
                dto.street(), dto.city(), dto.state(), dto.zipCode()
        ));

        return mapper.toDTO(repo.save(user));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}