package com.example.jawaclinicnew.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User /*implements UserDetails*/ {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="user_id")
        private Long userId;
        @Column(name = "national_id")
        private Integer nationalId;
        @Column(name = "username" , nullable = false, unique = true)
        private String email;
        @Column(name = "password" , nullable = false)
        private String password;
        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        @Column(name="birth_of_date")
        private Date birthOfDate;
        @Column(name = "phone_number", unique = true)
        private String phoneNumber;
        @Column(name = "address")
        private String address;
        @Column(name = "created_at")
        private LocalDateTime created_at;
        @Column(name = "created_by")
        private Integer created_by;
        @Column(name="account_status")
        private boolean accountStatus; //  for user's active status
        @Enumerated(EnumType.STRING)
        private Role role;

        //Appointments Lists
        @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // One-to-many relationship with appointments
        private List<Appointment> appointments = new ArrayList<>();

        //bill  Lists
        @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // One-to-many relationship with bill
        private List<Bill> bill = new ArrayList<>();



        /*

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        private List<Token> tokens = new ArrayList<>();



        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return role.getAuthorities();
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return email;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }  }

*/


}