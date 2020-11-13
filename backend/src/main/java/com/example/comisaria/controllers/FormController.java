package com.example.comisaria.controllers;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.example.comisaria.models.Form;
import com.example.comisaria.repositories.FormRepository;

@RestController
@RequestMapping("/forms")
@CrossOrigin(origins = "*")

public class FormController{
  @Autowired
  FormRepository FormRepository;

  @GetMapping("/")
  public ArrayList<Form> getAllForms(){
    return FormRepository.findAll();
  }

  @PostMapping(path="/add")
  @ResponseBody
  public Form createNewForm(@RequestBody Form form){
    return FormRepository.save(form);
  }
}
