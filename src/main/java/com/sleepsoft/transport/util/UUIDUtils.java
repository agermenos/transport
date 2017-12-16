package com.sleepsoft.transport.util;

import java.util.UUID;

public class UUIDUtils {
    public static String uuidString(){
        UUID uuid = UUID.randomUUID();
        String value = Long.toString(uuid.getMostSignificantBits(), 36) + '-' + Long.toString(uuid.getLeastSignificantBits(), 36);
        return value.replace("-", "").substring(0,19);
    }
}
