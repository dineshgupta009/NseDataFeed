package com.NseDataFeed.Controller;

import com.NseDataFeed.Entity.OptionChain;
import com.NseDataFeed.service.OptionChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/option")
public class OptionChainController {

    @GetMapping("/home")
    public String home(){
        return "working fine";
    }
    @Autowired
    private OptionChainService optionChainService;

    @PostMapping("/save")
    public ResponseEntity<OptionChain> saveOptionChainData(){
        try {
            optionChainService.saveOptionChainData();
            return ResponseEntity.ok().build();
        }catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
