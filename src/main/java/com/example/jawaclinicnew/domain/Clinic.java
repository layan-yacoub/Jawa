package com.example.jawaclinicnew.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clinic")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clinic_id")
    private Long clinicId;
    @Column(name = "clinic_name")
    private String clinicName;
    @Column(name = "created_at")
    private LocalDateTime created_at;
    @Column(name = "created_by")
    private Integer created_by;
    @Column(name="status")
    private boolean status;

    //stuff  Lists
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // One-to-many relationship with stuff
    private List<Stuff> stuff = new ArrayList<>();

}
