package com.interim.doctorAppointmentBooking.repository;

import com.interim.doctorAppointmentBooking.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

}
