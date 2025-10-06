package lk.puLeeNa.LibManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDTO implements Serializable {
    private String memberId;
    private String name;
    private String email;
    private String membershipDate;
}
