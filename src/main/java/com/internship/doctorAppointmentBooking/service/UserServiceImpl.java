package com.internship.doctorAppointmentBooking.service;

import com.internship.doctorAppointmentBooking.entity.User;
import com.internship.doctorAppointmentBooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long userId) {
        return userRepository.findById(userId).get();
    }
}
