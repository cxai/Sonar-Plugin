/**
 * UpdateScanComment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class UpdateScanComment  implements java.io.Serializable {
    private String sessionID;

    private long scanID;

    private String comment;

    public UpdateScanComment() {
    }

    public UpdateScanComment(
           String sessionID,
           long scanID,
           String comment) {
           this.sessionID = sessionID;
           this.scanID = scanID;
           this.comment = comment;
    }


    /**
     * Gets the sessionID value for this UpdateScanComment.
     *
     * @return sessionID
     */
    public String getSessionID() {
        return sessionID;
    }


    /**
     * Sets the sessionID value for this UpdateScanComment.
     *
     * @param sessionID
     */
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }


    /**
     * Gets the scanID value for this UpdateScanComment.
     *
     * @return scanID
     */
    public long getScanID() {
        return scanID;
    }


    /**
     * Sets the scanID value for this UpdateScanComment.
     *
     * @param scanID
     */
    public void setScanID(long scanID) {
        this.scanID = scanID;
    }


    /**
     * Gets the comment value for this UpdateScanComment.
     *
     * @return comment
     */
    public String getComment() {
        return comment;
    }


    /**
     * Sets the comment value for this UpdateScanComment.
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof UpdateScanComment)) return false;
        UpdateScanComment other = (UpdateScanComment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.sessionID==null && other.getSessionID()==null) ||
             (this.sessionID!=null &&
              this.sessionID.equals(other.getSessionID()))) &&
            this.scanID == other.getScanID() &&
            ((this.comment==null && other.getComment()==null) ||
             (this.comment!=null &&
              this.comment.equals(other.getComment())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getSessionID() != null) {
            _hashCode += getSessionID().hashCode();
        }
        _hashCode += new Long(getScanID()).hashCode();
        if (getComment() != null) {
            _hashCode += getComment().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateScanComment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">UpdateScanComment"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Comment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
