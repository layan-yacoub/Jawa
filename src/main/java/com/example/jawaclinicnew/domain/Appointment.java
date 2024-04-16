package com.example.jawaclinicnew.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointment_id")
    private Long appointmentID;

    //foreign key with the user table
    @ManyToOne
    @JoinColumn(name = "patient")
    private User patient;

    //foreign key with the Stuff table
    @ManyToOne
    @JoinColumn(name = "doctor")
    private Stuff doctor;

    @Column(name="appointment_date")
    private Date date;
    @Column(name = "start_time")
    private Timestamp start_time;
    @Column(name = "end_time")
    private Timestamp end_time;
    @Column(name="diagnosis")
    private String diagnosis;
    @Column(name = "created_at")
    private LocalDateTime created_at;
    @Column(name = "created_by")
    private Integer created_by;
    @Column(name="status")
    private boolean status; //if the patient comes or not

    //bill  Lists for every appointment we can have more than one bill depends on what the patient did
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // One-to-many relationship with bill
    private List<Bill> bill = new ArrayList<>();


}
