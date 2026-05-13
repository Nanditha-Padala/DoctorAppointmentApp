package com.interim.doctorAppointmentBooking.repository;

import com.interim.doctorAppointmentBooking.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
