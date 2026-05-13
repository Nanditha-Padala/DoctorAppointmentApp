package com.interim.doctorAppointmentBooking.repository;

import com.interim.doctorAppointmentBooking.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
