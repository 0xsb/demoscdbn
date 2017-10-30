package com.cmcc.ms.entity.datashow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

/**
 *
 * @author zhangxu-ws
 */
public class IdcDayTest {
    /**
     * Run the Date getCreatetime() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetCreatetimea() throws Exception {
        IdcDay fixture = new IdcDay();
        fixture.setTrafficin(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setCreatetime(new Date());
        fixture.setTrafficout(new Double(1.0));

        Date result = fixture.getCreatetime();

        assertNotNull(result);

    }

    /**
     * Run the Integer getId() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetIdb() throws Exception {
        IdcDay fixture = new IdcDay();
        fixture.setTrafficin(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setCreatetime(new Date());
        fixture.setTrafficout(new Double(1.0));

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
    public void testGetProvincec() throws Exception {
        IdcDay fixture = new IdcDay();
        fixture.setTrafficin(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setCreatetime(new Date());
        fixture.setTrafficout(new Double(1.0));

        String result = fixture.getProvince();

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
        IdcDay fixture = new IdcDay();
        fixture.setTrafficin(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setCreatetime(new Date());
        fixture.setTrafficout(new Double(1.0));

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
        IdcDay fixture = new IdcDay();
        fixture.setTrafficin(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setCreatetime(new Date());
        fixture.setTrafficout(new Double(1.0));

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
        IdcDay fixture = new IdcDay();
        fixture.setTrafficin(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setCreatetime(new Date());
        fixture.setTrafficout(new Double(1.0));
        Date createtime = new Date();

        fixture.setCreatetime(createtime);

    }

    /**
     * Run the void setId(Integer) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 17-8-25 上午10:54
     */
    @Test
    public void testSetIdg() throws Exception {
        IdcDay fixture = new IdcDay();
        fixture.setTrafficin(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setCreatetime(new Date());
        fixture.setTrafficout(new Double(1.0));
        Integer id = new Integer(1);

        fixture.setId(id);

    }

    /**
     * Run the void setProvince(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 17-8-25 上午10:54
     */
    @Test
    public void testSetProvince() throws Exception {
        IdcDay fixture = new IdcDay();
        fixture.setTrafficin(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setCreatetime(new Date());
        fixture.setTrafficout(new Double(1.0));
        String province = "江西";

        fixture.setProvince(province);

    }

    /**
     * Run the void setTimestr(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 17-8-25 上午10:54
     */
    @Test
    public void testSetTimestr() throws Exception {
        IdcDay fixture = new IdcDay();
        fixture.setTrafficin(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setCreatetime(new Date());
        fixture.setTrafficout(new Double(1.0));
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
    public void testSetTrafficin() throws Exception {
        IdcDay fixture = new IdcDay();
        fixture.setTrafficin(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setCreatetime(new Date());
        fixture.setTrafficout(new Double(1.0));
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
    public void testSetTrafficout() throws Exception {
        IdcDay fixture = new IdcDay();
        fixture.setTrafficin(new Double(1.0));
        fixture.setId(new Integer(1));
        fixture.setCreatetime(new Date());
        fixture.setTrafficout(new Double(1.0));
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
        new org.junit.runner.JUnitCore().run(IdcDayTest.class);
    }
}
