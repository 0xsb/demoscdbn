package com.cmcc.ms.entity.datashow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

/**
 *
 * @author zhangxu-ws
 */
public class UnifiedCdnWeekTest {
    /**
     * Run the Date getCreatetime() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetCreatetimes() throws Exception {
        UnifiedCdnWeek fixture = new UnifiedCdnWeek();
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setId(new Integer(1));

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
    public void testGetId() throws Exception {
        UnifiedCdnWeek fixture = new UnifiedCdnWeek();
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setId(new Integer(1));

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
     * Run the Double getTrafficin() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetTrafficin() throws Exception {
        UnifiedCdnWeek fixture = new UnifiedCdnWeek();
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setId(new Integer(1));

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
    public void testGetTrafficouts() throws Exception {
        UnifiedCdnWeek fixture = new UnifiedCdnWeek();
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setId(new Integer(1));

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
    public void testSetCreatetime() throws Exception {
        UnifiedCdnWeek fixture = new UnifiedCdnWeek();
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setId(new Integer(1));
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
        UnifiedCdnWeek fixture = new UnifiedCdnWeek();
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setId(new Integer(1));
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
    public void testSetProvince() throws Exception {
        UnifiedCdnWeek fixture = new UnifiedCdnWeek();
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setId(new Integer(1));
        String province = "浙江";

        fixture.setProvince(province);

    }

    /**
     * Run the void setTimestr(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetTimestr() throws Exception {
        UnifiedCdnWeek fixture = new UnifiedCdnWeek();
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setId(new Integer(1));
        String timestr = "2017-07-25";

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
        UnifiedCdnWeek fixture = new UnifiedCdnWeek();
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setId(new Integer(1));
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
    public void testSetTrafficouts() throws Exception {
        UnifiedCdnWeek fixture = new UnifiedCdnWeek();
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
        fixture.setCreatetime(new Date());
        fixture.setId(new Integer(1));
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
        new org.junit.runner.JUnitCore().run(UnifiedCdnWeekTest.class);
    }
}
