package com.ceb.exterior.encoder;

import com.ceb.exterior.digest.DigestHelper;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * <p>
 * 请在这里添加类说明.
 * </p>
 *
 * @author summerx
 * @Date 2016-07-19 5:27 PM
 */
public abstract class AbstractTextEncoder implements TextEncoder {


    @Override
    public String encode(String plainText) {
        return encode(plainText, DEFAULT_ENCODING);
    }

    @Override
    public String encode(String plainText, String encoding) {
        if (plainText == null) {
            return null;
        }

        Charset charset = Charset.defaultCharset();
        if (encoding != null) {
            charset = Charset.forName(encoding);
        }

        MessageDigest digest = DigestHelper.getDigest(getDigestAlgorithms());
        digest.update(plainText.getBytes(charset));
        byte[] bytes = digest.digest();
        StringBuffer sBuf = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            sBuf.append(Integer.toHexString((bytes[i] >> 4) & 0x0f));
            sBuf.append(Integer.toHexString((bytes[i]) & 0x0f));
        }
        return sBuf.toString();
    }

    protected abstract String getDigestAlgorithms();
}
