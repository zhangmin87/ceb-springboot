package com.ceb.exterior.encoder;


import com.ceb.exterior.digest.DigestAlgorithms;

/**
 * <p>
 * SHA加密
 * </p>
 *
 * @author summerx
 * @Date 2016-07-20 9:24 AM
 */
public class SHATextEncoder extends AbstractTextEncoder implements TextEncoder {

    @Override
    protected String getDigestAlgorithms() {
        return DigestAlgorithms.SHA_512;
    }
}
