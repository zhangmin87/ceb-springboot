package com.ceb.exterior.encoder;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Created by Chaos on 2016/10/8.
 */
public class BASE64TextEncoder implements TextEncoder {
    @Override
    public String encode(String plainText) {
        return encode(plainText, DEFAULT_ENCODING);
    }

    @Override
    public String encode(String plainText, String encoding) {

        String result = null;
        try {
            result =  Base64.getEncoder().encodeToString(plainText.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
        }
        return result;
    }

    public String decode(String s, String encoding) {
        String result = null;
        try {
            return new String(Base64.getDecoder().decode(s), encoding);
        } catch (UnsupportedEncodingException e) {
        }
        return result;
    }

    public String decode(String s) {
        return decode(s, DEFAULT_ENCODING);
    }
}
