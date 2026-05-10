package com.example.service;

import com.example.dto.MobileDto;

import java.util.List;

public interface MobileService {
    public MobileDto addMobile(MobileDto mobileDto);
    public List<MobileDto> getAllMobile();
    public MobileDto getMobileById(Long id);
    public MobileDto updateMobile(Long id, MobileDto mobileDto);
    public String delete(Long id);
}
