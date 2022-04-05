package com.bootcamp.pocketbook.repository;

import com.bootcamp.pocketbook.model.Pocketbook;

import java.util.Map;

public interface PocketbookRepositoryImpl {
    Map<String, Pocketbook> findAll();
    Pocketbook findById(String id);
    void save(Pocketbook pocketbook);
    void delete(String id);
}
