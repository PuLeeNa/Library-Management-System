package lk.puLeeNa.LibManagement.config;

import lk.puLeeNa.LibManagement.dao.StaffDao;
import lk.puLeeNa.LibManagement.dto.Role;
import lk.puLeeNa.LibManagement.entities.StaffEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final StaffDao staffDao;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Check if admin user already exists
        if (staffDao.findByUsername("admin").isEmpty()) {
            StaffEntity adminUser = new StaffEntity();
            adminUser.setStaffId("S001");
            adminUser.setFirstName("Admin");
            adminUser.setLastName("User");
            adminUser.setEmail("admin@booklib.com");
            adminUser.setUsername("admin");
            adminUser.setPassword(passwordEncoder.encode("admin123"));
            adminUser.setRole(Role.ADMIN);
            adminUser.setPhone("0000000000");
            adminUser.setJoinDate(LocalDate.now());
            adminUser.setLastUpdateDate(LocalDate.now());

            staffDao.save(adminUser);
            log.info("✅ Default admin user created successfully!");
            log.info("📧 Username: admin");
            log.info("🔑 Password: admin123");
            log.info("⚠️  Please change the default password after first login!");
        } else {
            log.info("ℹ️  Admin user already exists. Skipping initialization.");
        }
    }
}
