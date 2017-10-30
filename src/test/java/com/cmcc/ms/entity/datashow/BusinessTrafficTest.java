package com.cmcc.ms.entity.datashow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

/**
 *
 * @author zhangxu-ws
 */
public class BusinessTrafficTest {
    /**
     * Run the String getBusiness() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetBusinessa() throws Exception {
        BusinessTraffic bt = new BusinessTraffic();
        bt.setTrafficin(new Double(1.0));
        bt.setId(new Integer(1));
        bt.setCreatetime(new Date());

        String result = bt.getBusiness();

        assertEquals(null, result);
    }

    /**
     * Run the Integer getId() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetIdb() throws Exception {
        BusinessTraffic bt = new BusinessTraffic();
        bt.setTrafficin(new Double(1.0));
        bt.setId(new Integer(1));
        bt.setCreatetime(new Date());

        Integer result = bt.getId();

        assertNotNull(result);
        assertEquals("1", result.toString());
        assertEquals((byte) 1, result.byteValue());
        assertEquals(1L, result.longValue());
        assertEquals(1, result.intValue());
        assertEquals(1.0f, result.floatValue(), 1.0f);
        assertEquals((short) 1, result.shortValue());
        assertEquals(1.0, result.doubleValue(), 1.0);
    }

    /**
     * Run the String getName() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetNamec() throws Exception {
        BusinessTraffic bt = new BusinessTraffic();
        bt.setTrafficin(new Double(1.0));
        bt.setId(new Integer(1));
        bt.setCreatetime(new Date());

        String result = bt.getName();

        assertEquals(null, result);
    }

    /**
     * Run the String getTimestr() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetTimestrd() throws Exception {
        BusinessTraffic bt = new BusinessTraffic();
        bt.setTrafficin(new Double(1.0));
        bt.setId(new Integer(1));
        bt.setCreatetime(new Date());

        String result = bt.getTimestr();

        assertEquals(null, result);
    }

    /**
     * Run the Double getTrafficin() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetTrafficine() throws Exception {
        BusinessTraffic bt = new BusinessTraffic();
        bt.setTrafficin(new Double(1.0));
        bt.setId(new Integer(1));
        bt.setCreatetime(new Date());

        Double result = bt.getTrafficin();

        assertNotNull(result);
        assertEquals("1.0", result.toString());
        assertEquals((byte) 1, result.byteValue());
        assertEquals(1L, result.longValue());
        assertEquals(1, result.intValue());
        assertEquals(1.0f, result.floatValue(), 1.0f);
        assertEquals((short) 1, result.shortValue());
        assertEquals(1.0, result.doubleValue(), 1.0);
        assertEquals(false, result.isNaN());
        assertEquals(false, result.isInfinite());
    }

    /**
     * Run the void setBusiness(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetBusinessf() throws Exception {
        BusinessTraffic bt = new BusinessTraffic();
        bt.setTrafficin(new Double(1.0));
        bt.setId(new Integer(1));
        bt.setCreatetime(new Date());
        String business = "";

        bt.setBusiness(business);

    }

    /**
     * Run the void setBusiness(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetBusinessg() throws Exception {
        BusinessTraffic bt = new BusinessTraffic();
        bt.setTrafficin(new Double(1.0));
        bt.setId(new Integer(1));
        bt.setCreatetime(new Date());
        String business = null;

        bt.setBusiness(business);

    }

    /**
     * Run the void setCreatetime(Date) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetCreatetimeh() throws Exception {
        BusinessTraffic bt = new BusinessTraffic();
        bt.setTrafficin(new Double(1.0));
        bt.setId(new Integer(1));
        bt.setCreatetime(new Date());
        Date createtime = new Date();

        bt.setCreatetime(createtime);

    }

    /**
     * Run the void setId(Integer) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetIdk() throws Exception {
        BusinessTraffic bt = new BusinessTraffic();
        bt.setTrafficin(new Double(1.0));
        bt.setId(new Integer(1));
        bt.setCreatetime(new Date());
        Integer id = new Integer(1);

        bt.setId(id);

    }

    /**
     * Run the void setName(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetNamet() throws Exception {
        BusinessTraffic bt = new BusinessTraffic();
        bt.setTrafficin(new Double(1.0));
        bt.setId(new Integer(1));
        bt.setCreatetime(new Date());
        String name = "";

        bt.setName(name);

    }

    /**
     * Run the void setName(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetNamei() throws Exception {
        BusinessTraffic bt = new BusinessTraffic();
        bt.setTrafficin(new Double(1.0));
        bt.setId(new Integer(1));
        bt.setCreatetime(new Date());
        String name = null;

        bt.setName(name);
    }

    /**
     * Run the void setTimestr(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetTimestry() throws Exception {
        BusinessTraffic bt = new BusinessTraffic();
        bt.setTrafficin(new Double(1.0));
        bt.setId(new Integer(1));
        bt.setCreatetime(new Date());
        String timestr = "";

        bt.setTimestr(timestr);
    }

    /**
     * Run the void setTimestr(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetTimestrz() throws Exception {
        BusinessTraffic bt = new BusinessTraffic();
        bt.setTrafficin(new Double(1.0));
        bt.setId(new Integer(1));
        bt.setCreatetime(new Date());
        String timestr = null;

        bt.setTimestr(timestr);
    }

    /**
     * Run the void setTrafficin(Double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetTrafficino() throws Exception {
        BusinessTraffic bt = new BusinessTraffic();
        bt.setTrafficin(new Double(1.0));
        bt.setId(new Integer(1));
        bt.setCreatetime(new Date());
        Double trafficin = new Double(1.0);

        bt.setTrafficin(trafficin);

    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(BusinessTrafficTest.class);
    }
}
