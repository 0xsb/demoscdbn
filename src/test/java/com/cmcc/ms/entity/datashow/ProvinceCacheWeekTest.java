package com.cmcc.ms.entity.datashow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

/**
 *
 * @author zhangxu-ws
 */
public class ProvinceCacheWeekTest {

    /**
     * Run the Integer getId() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetIda() throws Exception {
        ProvinceCacheWeek fixture = new ProvinceCacheWeek();
        fixture.setTrafficout(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setCreatetime(new Date());

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
     * Run the String getProvince() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetProvinceb() throws Exception {
        ProvinceCacheWeek fixture = new ProvinceCacheWeek();
        fixture.setTrafficout(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setCreatetime(new Date());

        String result = fixture.getProvince();

        assertEquals(null, result);
    }

    /**
     * Run the String getTimestr() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetTimestrc() throws Exception {
        ProvinceCacheWeek fixture = new ProvinceCacheWeek();
        fixture.setTrafficout(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setCreatetime(new Date());

        String result = fixture.getTimestr();

        assertEquals(null, result);
    }

    /**
     * Run the Double getTrafficin() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetTrafficind() throws Exception {
        ProvinceCacheWeek fixture = new ProvinceCacheWeek();
        fixture.setTrafficout(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setCreatetime(new Date());

        Double result = fixture.getTrafficin();

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
     * Run the Double getTrafficout() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetTrafficoute() throws Exception {
        ProvinceCacheWeek fixture = new ProvinceCacheWeek();
        fixture.setTrafficout(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setCreatetime(new Date());

        Double result = fixture.getTrafficout();

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
    public void testSetCreatetimef() throws Exception {
        ProvinceCacheWeek fixture = new ProvinceCacheWeek();
        fixture.setTrafficout(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setCreatetime(new Date());
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
    public void testSetIdg() throws Exception {
        ProvinceCacheWeek fixture = new ProvinceCacheWeek();
        fixture.setTrafficout(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setCreatetime(new Date());
        Integer id = new Integer(1);

        fixture.setId(id);

    }

    /**
     * Run the void setProvince(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetProvinceh() throws Exception {
        ProvinceCacheWeek fixture = new ProvinceCacheWeek();
        fixture.setTrafficout(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setCreatetime(new Date());
        String province = "测试";

        fixture.setProvince(province);

    }

    /**
     * Run the void setTimestr(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetTimestrq() throws Exception {
        ProvinceCacheWeek fixture = new ProvinceCacheWeek();
        fixture.setTrafficout(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setCreatetime(new Date());
        String timestr = null;

        fixture.setTimestr(timestr);

    }

    /**
     * Run the void setTrafficin(Double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetTrafficins() throws Exception {
        ProvinceCacheWeek fixture = new ProvinceCacheWeek();
        fixture.setTrafficout(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setCreatetime(new Date());
        Double trafficin = new Double(1.0);

        fixture.setTrafficin(trafficin);

    }

    /**
     * Run the void setTrafficout(Double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetTrafficoutt() throws Exception {
        ProvinceCacheWeek fixture = new ProvinceCacheWeek();
        fixture.setTrafficout(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setCreatetime(new Date());
        Double trafficout = new Double(1.0);

        fixture.setTrafficout(trafficout);

    }

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(ProvinceCacheWeekTest.class);
    }
}
