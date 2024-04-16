package com.example.jawaclinicnew.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stuff")
public class Stuff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stuff_id")
    private Long stuffId;

    //foreign key with the user table
    @OneToOne
    @JoinColumn(name = "users")
    private User user;

    //foreign key with the user table
    @ManyToOne
    @JoinColumn(name = "clinic")
    private Clinic clinic;

    @Column(name = "available_date")
    private LocalDate available_date;
    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "end_time")
    private LocalTime endTime;
    @Column(name = "amount ")
    private double amount ;

    //Appointments Lists
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // One-to-many relationship with appointments
    private List<Appointment> appointments = new ArrayList<>();

    //bill  Lists //we can also delete this join and join the doctor by his user_id  from users table
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // One-to-many relationship with bill
    private List<Bill> bill = new ArrayList<>();

    //Booked Appointments ADD-REMOVE
    @OneToMany( fetch = FetchType.EAGER)
    private List<Appointment> bookedAppointments = new ArrayList<>();
    public List<Appointment> getBookedAppointments() {
        return bookedAppointments;
    }

    //Off Day List-add-remove
    @ElementCollection
    @CollectionTable(name = "off_days", joinColumns = @JoinColumn(name = "stuff_id"))
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "off_day")
    private List<LocalDate> offDays = new ArrayList<>();






}