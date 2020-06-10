import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.security.SecureRandom;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Generator {

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    SecureRandom secureRandom = new SecureRandom();

    public String generatorHmacKey() {
        byte[] key = new byte[256 / 8];
        secureRandom.nextBytes(key);
        char[] hexChars = new char[key.length * 2];
        for (int j = 0; j < key.length; j++) {
            int v = key[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public int generatorMoveComputer(int value) {
        return secureRandom.nextInt(value);
    }

    public String generationHmac(String key, String data) {
        try {
            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
            sha256Hmac.init(secretKey);
            return Base64.encode(sha256Hmac.doFinal(data.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
