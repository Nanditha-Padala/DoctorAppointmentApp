package com.interim.doctorAppointmentBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interim.doctorAppointmentBooking.entity.User;
import com.interim.doctorAppointmentBooking.service.AuthService;


@RestController
@RequestMapping("/appointmentapi")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?>  register(@RequestBody User user) {
        System.out.println("1");
        String token=authService.register(user);
        if(token!=null) {
            return ResponseEntity.ok(token);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        return "helloworld";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        String token=authService.login(user);
        if(token!=null) {
            return ResponseEntity.ok(token);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/profile")
    public ResponseEntity<User> profile(){
        System.out.println("11");
        User user=authService.profile();
        return ResponseEntity.ok(user);
    }

}