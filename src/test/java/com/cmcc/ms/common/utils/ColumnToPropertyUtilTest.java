package com.cmcc.ms.common.utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cmcc.ms.service.BaseTestCase;

/**
 *
 * @author zhangxu-ws
 */
public class ColumnToPropertyUtilTest extends BaseTestCase{
    

    

    /**
     * Run the String columnToProperty(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testColumnToPropertya()
        throws Exception {
        String ctp = ColumnToPropertyUtil.columnToProperty("snmp_community");
        Assert.assertNotNull(ctp);
    }

    /**
     * Run the String columnToProperty(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testColumnToPropertyb()
        throws Exception {
        String ctp = ColumnToPropertyUtil.columnToProperty2("snmp_community");
        Assert.assertNotNull(ctp);
    }



    /**
     * Run the String propertyToColumn(Object) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testPropertyToColumn()
        throws Exception {
        

        ColumnToPropertyUtil.propertyToColumn("snmp_community");

        
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *         if the initialization fails for some reason
     *
     * @generatedBy CodePro at 17-9-26 下午3:55
     */
    @Before
    public void setUp()
        throws Exception {
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *         if the clean-up fails for some reason
     *
     */
    @After
    public void tearDown()
        throws Exception {
    }

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(ColumnToPropertyUtilTest.class);
    }
}