package com.example.service.impl;

import com.example.dto.MobileDto;
import com.example.entity.Mobile;
import com.example.exception.MobileNotFoundException;
import com.example.repository.MobileRepository;
import com.example.service.MobileService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MobileServiceImpl implements MobileService {

    private final MobileRepository mobileRepository;
    private final ModelMapper modelMapper;

    @Override
    public MobileDto addMobile(MobileDto mobileDto) {
        return modelMapper.map(mobileRepository.save(modelMapper.map(mobileDto, Mobile.class)),MobileDto.class);
    }

    @Override
    public List<MobileDto> getAllMobile() {
        return mobileRepository.findAll().stream().map(p->modelMapper.map(p,MobileDto.class)).toList();
    }

    @Override
    public MobileDto getMobileById(Long id) {
        return mobileRepository.findById(id).map(p->modelMapper.map(p,MobileDto.class))
                .orElseThrow(()->new MobileNotFoundException("Mobile paini bhai...."+id));
    }

    @Override
    public MobileDto updateMobile(Long id, MobileDto mobileDto) {
        Mobile m = mobileRepository.findById(id)
                .orElseThrow(()->new MobileNotFoundException("Mobile paini bhai...."+id));
        m.setBrand(mobileDto.brand());
        m.setPrice(mobileDto.price());
        m.setModel(mobileDto.model());
        m.setStock(mobileDto.stock());
        return modelMapper.map(m, MobileDto.class);
    }

    @Override
    public String delete(Long id) {
        mobileRepository.deleteById(id);
        return "Deleted!!!";
    }
}
