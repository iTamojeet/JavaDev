package com.example.service.impl;

import com.example.dto.UserDto;
import com.example.entity.Users;
import com.example.exception.UserNotFoundException;
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
    public UserDto saveUser(UserDto userDto) {
        Users u = modelMapper.map(userDto, Users.class);
        Users saved = userRepository.save(u);
        return modelMapper.map(saved, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(r->modelMapper.map(r, UserDto.class))
                .toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        Users u = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user not found"));
        return modelMapper.map(u, UserDto.class);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        Users u = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user not found"));
        u.setFull_name(userDto.getFull_name());
        u.setAge(userDto.getAge());
        u.setEmail(userDto.getEmail());
        u.setPhone(userDto.getPhone());
        u.getAddress().setCity(userDto.getAddressDto().getCity());
        u.getAddress().setState(userDto.getAddressDto().getState());
        u.getAddress().setPin_code(userDto.getAddressDto().getPin_code());
        Users saved = userRepository.save(u);
        return modelMapper.map(saved, UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
