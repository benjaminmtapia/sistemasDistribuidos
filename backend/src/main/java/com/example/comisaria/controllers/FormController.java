package com.example.comisaria.controllers;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.example.comisaria.models.Form;
import com.example.comisaria.repositories.FormRepository;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
@RestController
@RequestMapping("/forms")
@CrossOrigin(origins = "*")

public class FormController{

  @Autowired
  FormRepository FormRepository;
  @Autowired
  JavaMailSender emailSender;
  @GetMapping("/")
  public ArrayList<Form> getAllForms(){
    return FormRepository.findAll();
  }

  @PostMapping(path="/add")
  public Form createNewForm(@RequestBody Form form){
    //dates
    Calendar initialDate = Calendar.getInstance();
    Date actualTime = initialDate.getTime();
    Date endingTime = form.addHours(actualTime,3);
    form.setInitialDate(actualTime);
    form.setFinalDate(endingTime);
    //destiny and email arrangements
    String destiny = form.getEmail();
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(destiny);
    message.setSubject("Permiso Temporal");
    String emailBody =  "Estimado " + form.getName() +":\n";
    emailBody+= "Se adjunta su permiso temporal por motivo: "+form.getReason()+"\n";
    emailBody+= "Dirección: "+form.getAddress()+"\n";
    emailBody+= "Fecha de inicio: "+actualTime+"\n";
    emailBody+= "Fecha de Término: "+endingTime+"\n";
    message.setText(emailBody);
    //System.out.println(emailBody);
    emailSender.send(message);
    return FormRepository.save(form);
  }
}
