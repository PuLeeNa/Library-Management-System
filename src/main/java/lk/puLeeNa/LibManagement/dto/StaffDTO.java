package lk.puLeeNa.LibManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDTO implements Serializable {
    private String staffId;
    private String firstName;
    private String lastName;
    private String email;
    private String joinDate;
    private LocalDate lastUpdateDate;
    private String phone;
    private Role role;
}

//{
//  "firstName": "John",
//  "lastName": "Doe",
//  "email": "ex@example.com",
//  "joinDate": "2023-10-10",
//  "phone": "0771234567",
//  "role": "ADMIN"
//        }
