package com.ceb.exterior.encoder;


import com.ceb.exterior.digest.DigestAlgorithms;

/**
 * <p>
 * MD5加密
 * </p>
 *
 * @author summerx
 * @Date 2016-07-19 5:27 PM
 */
public class MD5TextEncoder extends AbstractTextEncoder implements TextEncoder {

    protected String getDigestAlgorithms() {
        return DigestAlgorithms.MD5;
    }
}
