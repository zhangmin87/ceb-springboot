package com.ceb.exterior.encoder;

/**
 * <p>
 * 文本编码器
 * </p>
 *
 * @author summerx
 * @Date 2016-07-19 5:26 PM
 */
public interface TextEncoder {

    static final String DEFAULT_ENCODING = "UTF-8";

    String encode(String plainText);

    String encode(String plainText, String encoding);
}
