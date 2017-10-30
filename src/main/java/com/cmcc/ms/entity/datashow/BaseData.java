package com.cmcc.ms.entity.datashow;


/**
 * The Class BaseData.
 */
public class BaseData {
    
    /** The id. */
    private String id;

    /** The province. */
    private String province;

    /** The dev name. */
    private String devName;

    /** The dev ip. */
    private String devIp;

    /** The port name. */
    private String portName;

    /** The port type. */
    private String portType;

    /** The bus big. */
    private String busBig;

    /** The bus small. */
    private String busSmall;

    /** The peer device. */
    private String peerDevice;

    /** The trafficin. */
    private Double trafficin;

    /** The trafficout. */
    private Double trafficout;

    /** The bandwidth. */
    private Double bandwidth;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * Gets the province.
     *
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the province.
     *
     * @param province the new province
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * Gets the dev name.
     *
     * @return the dev name
     */
    public String getDevName() {
        return devName;
    }

    /**
     * Sets the dev name.
     *
     * @param devName the new dev name
     */
    public void setDevName(String devName) {
        this.devName = devName == null ? null : devName.trim();
    }

    /**
     * Gets the dev ip.
     *
     * @return the dev ip
     */
    public String getDevIp() {
        return devIp;
    }

    /**
     * Sets the dev ip.
     *
     * @param devIp the new dev ip
     */
    public void setDevIp(String devIp) {
        this.devIp = devIp == null ? null : devIp.trim();
    }

    /**
     * Gets the port name.
     *
     * @return the port name
     */
    public String getPortName() {
        return portName;
    }

    /**
     * Sets the port name.
     *
     * @param portName the new port name
     */
    public void setPortName(String portName) {
        this.portName = portName == null ? null : portName.trim();
    }

    /**
     * Gets the port type.
     *
     * @return the port type
     */
    public String getPortType() {
        return portType;
    }

    /**
     * Sets the port type.
     *
     * @param portType the new port type
     */
    public void setPortType(String portType) {
        this.portType = portType == null ? null : portType.trim();
    }

    /**
     * Gets the bus big.
     *
     * @return the bus big
     */
    public String getBusBig() {
        return busBig;
    }

    /**
     * Sets the bus big.
     *
     * @param busBig the new bus big
     */
    public void setBusBig(String busBig) {
        this.busBig = busBig == null ? null : busBig.trim();
    }

    /**
     * Gets the bus small.
     *
     * @return the bus small
     */
    public String getBusSmall() {
        return busSmall;
    }

    /**
     * Sets the bus small.
     *
     * @param busSmall the new bus small
     */
    public void setBusSmall(String busSmall) {
        this.busSmall = busSmall == null ? null : busSmall.trim();
    }

    /**
     * Gets the peer device.
     *
     * @return the peer device
     */
    public String getPeerDevice() {
        return peerDevice;
    }

    /**
     * Sets the peer device.
     *
     * @param peerDevice the new peer device
     */
    public void setPeerDevice(String peerDevice) {
        this.peerDevice = peerDevice == null ? null : peerDevice.trim();
    }

    /**
     * Gets the trafficin.
     *
     * @return the trafficin
     */
    public Double getTrafficin() {
        return trafficin;
    }

    /**
     * Sets the trafficin.
     *
     * @param trafficin the new trafficin
     */
    public void setTrafficin(Double trafficin) {
        this.trafficin = trafficin;
    }

    /**
     * Gets the trafficout.
     *
     * @return the trafficout
     */
    public Double getTrafficout() {
        return trafficout;
    }

    /**
     * Sets the trafficout.
     *
     * @param trafficout the new trafficout
     */
    public void setTrafficout(Double trafficout) {
        this.trafficout = trafficout;
    }

    /**
     * Gets the bandwidth.
     *
     * @return the bandwidth
     */
    public Double getBandwidth() {
        return bandwidth;
    }

    /**
     * Sets the bandwidth.
     *
     * @param bandwidth the new bandwidth
     */
    public void setBandwidth(Double bandwidth) {
        this.bandwidth = bandwidth;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BaseData [id=" + id + ", province=" + province + ", devName=" + devName
                + ", devIp=" + devIp + ", portName=" + portName + ", portType=" + portType
                + ", busBig=" + busBig + ", busSmall=" + busSmall + ", peerDevice=" + peerDevice
                + ", trafficin=" + trafficin + ", trafficout=" + trafficout + ", bandwidth="
                + bandwidth + "]";
    }

}
