package com.example.jawaclinicnew.requestBody;


import com.example.jawaclinicnew.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  private String firstname;
  private String lastname;
  private String email;
  private String password;
  private String phoneNumber;
  private Role role;
 // private String otp; // Field to store OTP
 // private LocalDateTime otpExpiration; // Field to store OTP expiration time
}
