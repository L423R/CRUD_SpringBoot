package com.example.demo2.services;


import com.example.demo2.entities.Item;
import com.example.demo2.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository repository;

    @Autowired
    public void setRepository(ItemRepository repository) {
        this.repository = repository;
    }



    public void save(Item item) {
        repository.save(item);
    }


    public void delete(Item item) {
        repository.delete(item);
    }

    public List<Item> getAllItems() {
        return repository.findAll();
    }

    public Item getById(int id) {
        Optional<Item> optional = repository.findById(id);
        return optional.get();
    }
}
