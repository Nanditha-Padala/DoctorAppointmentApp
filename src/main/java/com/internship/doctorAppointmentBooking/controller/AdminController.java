package com.internship.doctorAppointmentBooking.controller;

import com.internship.doctorAppointmentBooking.entity.User;
import com.internship.doctorAppointmentBooking.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointmentapi/admin")
public class AdminController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userServiceImpl.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable long userId){
        return userServiceImpl.getUser(userId);
    }

}
