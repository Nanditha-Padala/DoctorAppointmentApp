package com.internship.doctorAppointmentBooking.repository;

import com.internship.doctorAppointmentBooking.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
