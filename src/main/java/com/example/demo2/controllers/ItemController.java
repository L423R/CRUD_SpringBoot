package com.example.demo2.controllers;


import com.example.demo2.entities.Item;
import com.example.demo2.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {


    private ItemService service;

    @Autowired
    public void setService(ItemService service) {
        this.service = service;
    }

    @RequestMapping(path = "/")
    public String index()
    {
        return "index";
    }

    @RequestMapping(path = "/items/add", method = RequestMethod.GET)
    public  String createItem(Model model){
        model.addAttribute("item", new Item());
        return "edit";
    }

    @RequestMapping(path = "items", method = RequestMethod.POST)
    public String saveItem(Item item){
        service.save(item);
        return "redirect:/";
    }

    @RequestMapping(path = "items", method = RequestMethod.GET)
    public String getAllItems(Model model){
        model.addAttribute("items", service.getAllItems());
        return "items";
    }

    @RequestMapping(path = "/items/edit/{id}", method = RequestMethod.GET)
    public String editItem(Model model, @PathVariable(value = "id") int id){
        model.addAttribute("item",service.getById(id));
        return "edit";
    }

    @RequestMapping(path = "/items/delete/{id}",method = RequestMethod.GET)
    public String deleteItem(@PathVariable(value = "id") int id){
        service.delete(service.getById(id));
        return "redirect:/items";
    }
}
