package com.interim.doctorAppointmentBooking.repository;

import com.interim.doctorAppointmentBooking.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
