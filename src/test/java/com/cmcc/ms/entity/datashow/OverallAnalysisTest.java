package com.cmcc.ms.entity.datashow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

/**
 *
 * @generatedBy CodePro at 17-8-25 上午10:54
 * @author zhangxu-ws
 * @version $Revision: 1.0 $
 */
public class OverallAnalysisTest {
    /**
     * Run the Double getBandwidth() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetBandwidtha() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));

        Double result = fixture.getBandwidth();

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
     * Run the Date getCreattime() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetCreattimeb() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));

        Date result = fixture.getCreattime();

        assertNotNull(result);
    }

    /**
     * Run the Integer getId() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetIdc() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));

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
     * Run the String getName() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetNamee() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));

        String result = fixture.getName();

        assertEquals(null, result);
    }

    /**
     * Run the Integer getPorts() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetPortse() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));

        Integer result = fixture.getPorts();

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
     * Run the String getTimestr() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetTimestrx() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));

        String result = fixture.getTimestr();

        assertEquals(null, result);
    }

    /**
     * Run the Double getTrafficins() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetTrafficinsk() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));

        Double result = fixture.getTrafficins();

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
     * Run the Double getTrafficouts() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetTrafficoutsh() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));

        Double result = fixture.getTrafficouts();

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
     * Run the void setBandwidth(Double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetBandwidthl() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));
        Double bandwidth = new Double(1.0);

        fixture.setBandwidth(bandwidth);

    }

    /**
     * Run the void setCreattime(Date) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetCreattimem() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));
        Date creattime = new Date();

        fixture.setCreattime(creattime);

    }

    /**
     * Run the void setId(Integer) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetIdi() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));
        Integer id = new Integer(1);

        fixture.setId(id);

    }

    /**
     * Run the void setName(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetNameo() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));
        String name = "测试";

        fixture.setName(name);

    }

    /**
     * Run the void setName(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetNamep() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));
        String name = null;

        fixture.setName(name);

    }

    /**
     * Run the void setPorts(Integer) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 17-8-25 上午10:54
     */
    @Test
    public void testSetPortse() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));
        Integer ports = new Integer(1);

        fixture.setPorts(ports);

    }

    /**
     * Run the void setTimestr(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetTimestrr() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));
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
    public void testSetTimestrs() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));
        String timestr = null;

        fixture.setTimestr(timestr);

    }

    /**
     * Run the void setTrafficins(Double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetTrafficinsn() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));
        Double trafficins = new Double(1.0);

        fixture.setTrafficins(trafficins);

    }

    /**
     * Run the void setTrafficouts(Double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetTrafficoutsj() throws Exception {
        OverallAnalysis fixture = new OverallAnalysis();
        fixture.setBandwidth(new Double(1.0));
        fixture.setPorts(new Integer(1));
        fixture.setId(new Integer(1));
        fixture.setTrafficins(new Double(1.0));
        fixture.setCreattime(new Date());
        fixture.setTrafficouts(new Double(1.0));
        Double trafficouts = new Double(1.0);

        fixture.setTrafficouts(trafficouts);

    }

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(OverallAnalysisTest.class);
    }
}
