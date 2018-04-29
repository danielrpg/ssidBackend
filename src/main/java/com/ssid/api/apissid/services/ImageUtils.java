package com.ssid.api.apissid.services;

import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;

public class ImageUtils {
    public static Byte[] inputStreamToByteArray(InputStream file) throws IOException {
        byte[] fileBytes = StreamUtils.copyToByteArray(file);
        Byte[] bytes = new Byte[fileBytes.length];
        int i = 0;
        for (Byte aByte : fileBytes) {
            bytes[i++] = aByte;
        }
        return bytes;
    }
}
