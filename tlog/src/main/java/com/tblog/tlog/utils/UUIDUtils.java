package com.tblog.tlog.utils;

import java.util.UUID;

public class UUIDUtils {
    public static String UUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
