package lk.puLeeNa.LibManagement.util;

import java.util.UUID;

public class UtilData {
    // Generate Respective IDs

    public static String generateBookId(){
        return "B/"+ UUID.randomUUID();
    }
    public static String generateMemberId(){
        return "M/"+ UUID.randomUUID();
    }
    public static String generateStaffId() {
        return "S/" + UUID.randomUUID();
    }
    public static String generateLendingId() {
        return "L/" + UUID.randomUUID();
    }
}
