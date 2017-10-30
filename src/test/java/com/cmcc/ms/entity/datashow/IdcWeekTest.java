package com.cmcc.ms.entity.datashow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

/**
 *
 * @author zhangxu-ws
 * @version $Revision: 1.0 $
 */
public class IdcWeekTest {
    /**
     * Run the Date getCreatetime() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetCreatetimea() throws Exception {
        IdcWeek fixture = new IdcWeek();
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
        fixture.setCreatetime(new Date());

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
        IdcWeek fixture = new IdcWeek();
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
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
     * Run the Double getTrafficin() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetTrafficin() throws Exception {
        IdcWeek fixture = new IdcWeek();
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
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
    public void testGetTrafficout() throws Exception {
        IdcWeek fixture = new IdcWeek();
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
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
    public void testSetCreatetime() throws Exception {
        IdcWeek fixture = new IdcWeek();
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
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
    public void testSetId() throws Exception {
        IdcWeek fixture = new IdcWeek();
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
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
    public void testSetProvince() throws Exception {
        IdcWeek fixture = new IdcWeek();
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
        fixture.setCreatetime(new Date());
        String province = "";

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
        IdcWeek fixture = new IdcWeek();
        fixture.setId(new Integer(1));
        fixture.setTrafficin(new Double(1.0));
        fixture.setTrafficout(new Double(1.0));
        fixture.setCreatetime(new Date());
        String timestr = "测试";

        fixture.setTimestr(timestr);

    }

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(IdcWeekTest.class);
    }
}
