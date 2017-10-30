package com.cmcc.ms.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * redis存储实体，采用序列化方式.
 *
 * @author Lipeipei
 * @date 2016年8月18日 下午4:34:53
 */
public class SerializeUtil {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(SerializeUtil.class);

    /**
     * 序列化.
     *
     * @param object the object
     * @return the byte[]
     */
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化.
     *
     * @param bytes the bytes
     * @return the object
     */
    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 序列化存储list.
     *
     * @param list the list
     * @return the byte[]
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static byte[] serializeList(List<? extends Object> list) throws IOException {
        if (list == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] rv = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            for (Object o : list) {
                os.writeObject(o);
            }
            os.writeObject(null);
            rv = bos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("Non-serializable object", e);
        } finally {
            if (os != null) {
                os.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
        return rv;
    }

    /**
     * 反序列化.
     *
     * @param in the in
     * @return the list
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static List<Object> deserialize(byte[] in) throws IOException {
        List<Object> list = new ArrayList<Object>();
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                while (true) {
                    Object object = is.readObject();
                    if (object == null) {
                        break;
                    } else {
                        list.add(object);
                    }
                }
            }
        } catch (IOException e) {
            logger.error("Caught IOException decoding %d bytes of data", in.length, e);
        } catch (ClassNotFoundException e) {
            logger.error("Caught CNFE decoding %d bytes of data", in.length, e);
        } finally {
            if (is != null) {
                is.close();
            }
            if (bis != null) {
                bis.close();
            }
        }
        return list;
    }
}
