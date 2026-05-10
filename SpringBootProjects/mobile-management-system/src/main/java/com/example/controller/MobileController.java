package com.example.controller;

import com.example.dto.MobileDto;
import com.example.service.MobileService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/mobile")
public class MobileController {

    private final MobileService mobileService;

    @PostMapping
    public ResponseEntity<MobileDto> addMobile(@Valid @RequestBody MobileDto mobileDto){
        return ResponseEntity.ok(mobileService.addMobile(mobileDto));
    }
    @GetMapping
    public ResponseEntity<List<MobileDto>> getAllMobiles(){
        return ResponseEntity.ok(mobileService.getAllMobile());
    }
    @GetMapping("{id}")
    public ResponseEntity<MobileDto> getMobileById(@PathVariable Long id){
        return ResponseEntity.ok(mobileService.getMobileById(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<MobileDto> updateMobile(@PathVariable Long id, @Valid @RequestBody MobileDto mobileDto){
        return ResponseEntity.ok(mobileService.updateMobile(id, mobileDto));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(mobileService.delete(id));
    }
}
