package com.cmcc.ms.entity.datashow;

import org.junit.Test;

/**
 * The class <code>BaseDataTest</code> contains tests for the class <code>{@link BaseData}</code>.
 *
 * @author ldy
 */
public class BaseDataTest {
    /**
     * Run the Double getBandwidth() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void test(){
        BaseData baseData = new BaseData();
        String nu = "";
        baseData.setId(nu);
        baseData.setTrafficin(0d);
        baseData.setBandwidth(0d);
        baseData.setProvince(nu);
        baseData.setBusBig(nu);
        baseData.setPortName(nu);
        baseData.setDevIp(nu);
        baseData.setPortType(nu);
        baseData.setBusSmall(nu);
        baseData.setDevName(nu);
        baseData.setTrafficout(0d);
        baseData.setPeerDevice(nu);
        baseData.equals(nu);
    }


    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     * @generatedBy CodePro at 17-9-29 上午9:43
     */
    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(BaseDataTest.class);
    }
}