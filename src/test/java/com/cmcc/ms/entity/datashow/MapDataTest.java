package com.cmcc.ms.entity.datashow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

/**
 *
 * @author zhangxu-ws
 */
public class MapDataTest {

    /**
     * Run the Integer getId() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetId() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));

        Integer result = fixture.getId();

        assertNotNull(result);
        assertEquals("1", result.toString());
        assertEquals(1L, result.longValue());
        assertEquals(1.0f, result.floatValue(), 1.0f);
        assertEquals((short) 1, result.shortValue());
        assertEquals((byte) 1, result.byteValue());
        assertEquals(1, result.intValue());
        assertEquals(1.0, result.doubleValue(), 1.0);
    }

    /**
     * Run the Double getIdc() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetIdc() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));

        Double result = fixture.getIdc();

        assertNotNull(result);
        assertEquals("1.0", result.toString());
        assertEquals(1L, result.longValue());
        assertEquals(1.0f, result.floatValue(), 1.0f);
        assertEquals((short) 1, result.shortValue());
        assertEquals((byte) 1, result.byteValue());
        assertEquals(1, result.intValue());
        assertEquals(1.0, result.doubleValue(), 1.0);
        assertEquals(false, result.isNaN());
        assertEquals(false, result.isInfinite());
    }

    /**
     * Run the String getProvince() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetProvince() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));


    }

    /**
     * Run the String getTimestr() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetTimestr() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));

        String result = fixture.getTimestr();

        assertEquals(null, result);
    }

    /**
     * Run the Double getpCache() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetpCache() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));

        Double result = fixture.getpCache();

        assertNotNull(result);
        assertEquals("1.0", result.toString());
        assertEquals(1L, result.longValue());
        assertEquals(1.0f, result.floatValue(), 1.0f);
        assertEquals((short) 1, result.shortValue());
        assertEquals((byte) 1, result.byteValue());
        assertEquals(1, result.intValue());
        assertEquals(1.0, result.doubleValue(), 1.0);
        assertEquals(false, result.isNaN());
        assertEquals(false, result.isInfinite());
    }

    /**
     * Run the Double getpOtt() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetpOtt() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));

        Double result = fixture.getpOtt();

        assertNotNull(result);
        assertEquals("1.0", result.toString());
        assertEquals(1L, result.longValue());
        assertEquals(1.0f, result.floatValue(), 1.0f);
        assertEquals((short) 1, result.shortValue());
        assertEquals((byte) 1, result.byteValue());
        assertEquals(1, result.intValue());
        assertEquals(1.0, result.doubleValue(), 1.0);
        assertEquals(false, result.isNaN());
        assertEquals(false, result.isInfinite());
    }

    /**
     * Run the Double getuCache() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetuCache() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));

        Double result = fixture.getuCache();

        assertNotNull(result);
        assertEquals("1.0", result.toString());
        assertEquals(1L, result.longValue());
        assertEquals(1.0f, result.floatValue(), 1.0f);
        assertEquals((short) 1, result.shortValue());
        assertEquals((byte) 1, result.byteValue());
        assertEquals(1, result.intValue());
        assertEquals(1.0, result.doubleValue(), 1.0);
        assertEquals(false, result.isNaN());
        assertEquals(false, result.isInfinite());
    }

    /**
     * Run the Double getuCdn() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetuCdn() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));

        Double result = fixture.getuCdn();

        assertNotNull(result);
        assertEquals("1.0", result.toString());
        assertEquals(1L, result.longValue());
        assertEquals(1.0f, result.floatValue(), 1.0f);
        assertEquals((short) 1, result.shortValue());
        assertEquals((byte) 1, result.byteValue());
        assertEquals(1, result.intValue());
        assertEquals(1.0, result.doubleValue(), 1.0);
        assertEquals(false, result.isNaN());
        assertEquals(false, result.isInfinite());
    }

    /**
     * Run the void setCreatetime(Date) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetCreatetime() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));
        Date createtime = new Date();

        fixture.setCreatetime(createtime);

    }

    /**
     * Run the void setId(Integer) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetId() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));
        Integer id = new Integer(1);

        fixture.setId(id);

    }

    /**
     * Run the void setIdc(Double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetIdc() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));
        Double idc = new Double(1.0);

        fixture.setIdc(idc);

    }

    /**
     * Run the void setProvince(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetProvince() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));
        String province = null;

        fixture.setProvince(province);

    }

    /**
     * Run the void setTimestr(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetTimestrk() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));
        String timestr = "";

        fixture.setTimestr(timestr);

    }

    /**
     * Run the void setTimestr(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetTimestr() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));
        String timestr = null;

        fixture.setTimestr(timestr);

    }

    /**
     * Run the void setpCache(Double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetpCache() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));
        Double pCache = new Double(1.0);

        fixture.setpCache(pCache);

    }

    /**
     * Run the void setpOtt(Double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetpOtt() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));
        Double pOtt = new Double(1.0);

        fixture.setpOtt(pOtt);

    }

    /**
     * Run the void setuCache(Double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetuCache() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));
        Double uCache = new Double(1.0);

        fixture.setuCache(uCache);

    }

    /**
     * Run the void setuCdn(Double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetuCdn() throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setpOtt(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setpCache(new Double(1.0));
        fixture.setuCdn(new Double(1.0));
        Double uCdn = new Double(1.0);

        fixture.setuCdn(uCdn);

    }

    /**
     * Run the Date getCreatetime() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetCreatetime()
        throws Exception {
        MapData fixture = new MapData();
        fixture.setIdc(new Double(1.0));
        fixture.setpOtt(new Double(1.0));
        fixture.setpCache(new Double(1.0));
        fixture.setuCache(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setId(new Integer(1));
        fixture.setuCdn(new Double(1.0));

        Date result = fixture.getCreatetime();

        assertNotNull(result);
    }

    
    /**
     * Launch the test.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(MapDataTest.class);
    }
}
