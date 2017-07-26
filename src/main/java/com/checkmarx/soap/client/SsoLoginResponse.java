/**
 * SsoLoginResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class SsoLoginResponse  implements java.io.Serializable {
    private CxWSResponseLoginData ssoLoginResult;

    public SsoLoginResponse() {
    }

    public SsoLoginResponse(
           CxWSResponseLoginData ssoLoginResult) {
           this.ssoLoginResult = ssoLoginResult;
    }


    /**
     * Gets the ssoLoginResult value for this SsoLoginResponse.
     *
     * @return ssoLoginResult
     */
    public CxWSResponseLoginData getSsoLoginResult() {
        return ssoLoginResult;
    }


    /**
     * Sets the ssoLoginResult value for this SsoLoginResponse.
     *
     * @param ssoLoginResult
     */
    public void setSsoLoginResult(CxWSResponseLoginData ssoLoginResult) {
        this.ssoLoginResult = ssoLoginResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SsoLoginResponse)) return false;
        SsoLoginResponse other = (SsoLoginResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.ssoLoginResult==null && other.getSsoLoginResult()==null) ||
             (this.ssoLoginResult!=null &&
              this.ssoLoginResult.equals(other.getSsoLoginResult())));
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
        if (getSsoLoginResult() != null) {
            _hashCode += getSsoLoginResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SsoLoginResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">SsoLoginResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ssoLoginResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SsoLoginResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseLoginData"));
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
