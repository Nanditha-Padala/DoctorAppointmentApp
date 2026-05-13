package com.interim.doctorAppointmentBooking.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Doctor {


    @Id
    private Long id; // same as user id

    @OneToOne
    @MapsId
    @JoinColumn(name = "user")
    private User user;

    private String specialization;

    private double consultationFee;

    private String timings;

    private int experienceYears;

    private int rating;

    @ManyToOne
    private Hospital hospital;

    private Set<Symptom> symptoms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Set<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Set<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public Doctor(Long id, User user, String specialization, double consultationFee, String timings, int experienceYears, int rating, Hospital hospital, Set<Symptom> symptoms) {
        this.id = id;
        this.user = user;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.timings = timings;
        this.experienceYears = experienceYears;
        this.rating = rating;
        this.hospital = hospital;
        this.symptoms = symptoms;
    }
}
