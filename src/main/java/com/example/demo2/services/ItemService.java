package com.example.demo2.services;

import com.example.demo2.entities.Item;

import java.util.List;

public interface ItemService {

    void save(Item item);
    void delete(Item item);
    List<Item> getAllItems();
    Item getById(int id);
}
