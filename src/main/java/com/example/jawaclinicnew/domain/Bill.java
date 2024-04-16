package com.example.jawaclinicnew.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bill_id")
    private Long id;

    //foreign key with the user table
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private User patientId;

    //foreign key with the Stuff table
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Stuff doctorId;
    //we can also delete this join and join the doctor by his user_id

    //foreign key with the Appointment table
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;
    // we can take the date from the appointment table

    @Column(name = "cost")
    private double cost;
    //we can take the cost from the stuff table

}
