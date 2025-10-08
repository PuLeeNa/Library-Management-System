package lk.puLeeNa.LibManagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.puLeeNa.LibManagement.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // To generate a no-argument constructor
@AllArgsConstructor // To generate a constructor with all arguments
@Data // To generate getters, setters, toString, equals, and hashCode methods
@Entity // To specify that this class is an entity and is mapped to a database table
@Table(name="Staff")
public class StaffEntity {
    @Id // To specify the primary key of the entity
    private String staffId;
    private String firstName;
    private String lastName;
    private String email;
    private String joinDate;
    private String lastUpdateDate;
    private String phone;
    private Role role;
}
