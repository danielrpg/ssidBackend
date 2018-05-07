package com.ssid.api.apissid.command;

import org.apache.tomcat.util.codec.binary.Base64;
import org.reflections.util.Utils;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;

public class ImageUtilsCommand {

    public static Byte[] decodeToImage(String imageString) {

        if (!Utils.isEmpty(imageString)) {
            BufferedImage image = null;
            byte[] imageByte;
        try {
               ByteArrayInputStream bis = new ByteArrayInputStream(Base64Utils.decodeFromString(imageString));
               image = ImageIO.read(bis);
              bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
            return byteToByte(((DataBufferByte) image.getData().getDataBuffer()).getData());
        } else {
            return null;
        }
    }

    private static Byte[] byteToByte(byte[] bytesChange) {
        if(bytesChange != null) {
            Byte[] bytes = new Byte[bytesChange.length];

            int i = 0;
            for (byte b : bytesChange) bytes[i++] = b; // Autoboxing

            return bytes;
        }else{
            return null;
        }
    }

    public static String setImageBase64(Byte[] image) {
        if (image != null) {
            byte[] bytes = new byte[image.length];
            for (int i = 0; i < image.length; i++) {
                bytes[i] = image[i];
            }
            String imageStr = Base64.encodeBase64String(bytes);
            return imageStr;
        }

        return null;
    }
}
