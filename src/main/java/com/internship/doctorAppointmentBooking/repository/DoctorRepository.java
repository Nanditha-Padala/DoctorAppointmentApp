package com.internship.doctorAppointmentBooking.repository;

import com.internship.doctorAppointmentBooking.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
