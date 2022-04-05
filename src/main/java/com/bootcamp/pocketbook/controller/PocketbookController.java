package com.bootcamp.pocketbook.controller;

import com.bootcamp.pocketbook.model.Pocketbook;
import com.bootcamp.pocketbook.repository.PocketbookRepository;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PocketbookController {
    private PocketbookRepository pocketbookRepository;

    public PocketbookController(PocketbookRepository pocketbookRepository){
        this.pocketbookRepository = pocketbookRepository;
    }

    @GetMapping("/pocketbook")
    public Map<String, Pocketbook> finAll(){
        return pocketbookRepository.findAll();
    }
    @GetMapping("/pocketbook/{id}")
    public Pocketbook findById(@PathVariable String id){
        return pocketbookRepository.findById(id);
    }

    @PostMapping("/pocketbook")
    public  void createPocketbook(@RequestBody Pocketbook pocketbook){
        pocketbookRepository.save(pocketbook);
    }

    @DeleteMapping("/pocketbook/{id}")
    public void deletePocketbook(@PathVariable String id) {
        pocketbookRepository.delete(id);
    }
}
