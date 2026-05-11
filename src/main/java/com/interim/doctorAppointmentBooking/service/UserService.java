package com.interim.doctorAppointmentBooking.service;

import com.interim.doctorAppointmentBooking.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(long userId);
}
