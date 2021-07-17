package utility;

import java.util.Base64;

public class PassEncoder {
    public static String decode64(String encodedStr){
        Base64.Decoder decoder = Base64.getDecoder();
        return  new String(decoder.decode(encodedStr.getBytes()));
    }
}
