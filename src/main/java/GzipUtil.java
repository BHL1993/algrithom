import lombok.extern.log4j.Log4j2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

@Log4j2
public class GzipUtil {
    public static final String GZIP_ENCODE_UTF_8 = "UTF-8";
    public static final String GZIP_ENCODE_ISO_8859_1 = "ISO-8859-1";

    /**
     * 字符串压缩为GZIP字节数组
     * @param str
     * @return byte[]
     */
    public static byte[] compress(String str) {
        return compress(str, GZIP_ENCODE_UTF_8);
    }

    /**
     * 字符串压缩为GZIP字节数组并base64编码
     * @param str
     * @return String
     */
    public static String compressToBase64(String str) {
        byte[] compress = compress(str);
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(compress);
    }

    /**
     * 字符串压缩为GZIP字节数组
     * @param str
     * @param encoding
     * @return byte[]
     */
    public static byte[] compress(String str, String encoding) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(str.getBytes());
            gzip.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return out.toByteArray();
    }

    /**
     * GZIP解压缩
     * @param bytes
     * @return byte[]
     */
    public static byte[] uncompress(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            ungzip.close();
            in.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return out.toByteArray();
    }

    /**
     * GZIP解压缩
     * @param bytes
     * @return byte[]
     */
    public static String uncompressToString(byte[] bytes) {
        return uncompressToString(bytes, GZIP_ENCODE_UTF_8);
    }

    /**
     * GZIP解压缩
     * @param bytes
     * @param encoding
     * @return String
     * */
    public static String uncompressToString(byte[] bytes, String encoding) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString(encoding);
        } catch (IOException e) {
            log.error("uncompressToString error !", e);
            throw new RuntimeException(e.getCause());
        }
    }

    /**
     * base64解码并GZIP解压缩
     * @param str
     * @return String
     */
    public static String uncompressBase64(String str) {
        byte[] bytes = Base64.getDecoder().decode(str);
        return uncompressToString(bytes);
    }

}
