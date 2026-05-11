package com.interim.doctorAppointmentBooking.service;

import com.interim.doctorAppointmentBooking.entity.User;
import com.interim.doctorAppointmentBooking.repository.UserRepository;
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
