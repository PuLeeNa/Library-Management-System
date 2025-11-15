package lk.puLeeNa.LibManagement.service;

import lk.puLeeNa.LibManagement.entities.StaffEntity; // or User entity
import lk.puLeeNa.LibManagement.dao.StaffDao; // or UserRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StaffDao staffDao; // Adjust based on your entity

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StaffEntity staff = staffDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return User.builder()
                .username(staff.getUsername())
                .password(staff.getPassword()) // Should be encoded
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + staff.getRole())))
                .build();
    }
}
