package com.frank.util;

import java.awt.image.BufferedImage;

/**
 * @author: kst
 * @date: 2024/6/3 17:53
 */
public interface ImageDPIProcessor {
    public boolean canHandle(String fileName);
    public byte[] process(final BufferedImage srcimage, final int dpi) throws Exception;
}
