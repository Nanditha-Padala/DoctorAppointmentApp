package com.internship.doctorAppointmentBooking.repository;

import com.internship.doctorAppointmentBooking.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
