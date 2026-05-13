package com.internship.doctorAppointmentBooking.service;

import com.internship.doctorAppointmentBooking.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(long userId);
}
