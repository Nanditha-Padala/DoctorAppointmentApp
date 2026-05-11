package com.interim.doctorAppointmentBooking.repository;

import com.interim.doctorAppointmentBooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
}
