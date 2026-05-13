package com.internship.doctorAppointmentBooking.repository;

import com.internship.doctorAppointmentBooking.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

}
