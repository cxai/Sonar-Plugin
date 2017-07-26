/**
 * CxWSLdapGroupMapping.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSLdapGroupMapping  implements java.io.Serializable {
    private int ldapServerId;

    private CxWSLdapGroup ldapGroup;

    public CxWSLdapGroupMapping() {
    }

    public CxWSLdapGroupMapping(
           int ldapServerId,
           CxWSLdapGroup ldapGroup) {
           this.ldapServerId = ldapServerId;
           this.ldapGroup = ldapGroup;
    }


    /**
     * Gets the ldapServerId value for this CxWSLdapGroupMapping.
     *
     * @return ldapServerId
     */
    public int getLdapServerId() {
        return ldapServerId;
    }


    /**
     * Sets the ldapServerId value for this CxWSLdapGroupMapping.
     *
     * @param ldapServerId
     */
    public void setLdapServerId(int ldapServerId) {
        this.ldapServerId = ldapServerId;
    }


    /**
     * Gets the ldapGroup value for this CxWSLdapGroupMapping.
     *
     * @return ldapGroup
     */
    public CxWSLdapGroup getLdapGroup() {
        return ldapGroup;
    }


    /**
     * Sets the ldapGroup value for this CxWSLdapGroupMapping.
     *
     * @param ldapGroup
     */
    public void setLdapGroup(CxWSLdapGroup ldapGroup) {
        this.ldapGroup = ldapGroup;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSLdapGroupMapping)) return false;
        CxWSLdapGroupMapping other = (CxWSLdapGroupMapping) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            this.ldapServerId == other.getLdapServerId() &&
            ((this.ldapGroup==null && other.getLdapGroup()==null) ||
             (this.ldapGroup!=null &&
              this.ldapGroup.equals(other.getLdapGroup())));
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
        _hashCode += getLdapServerId();
        if (getLdapGroup() != null) {
            _hashCode += getLdapGroup().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSLdapGroupMapping.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSLdapGroupMapping"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ldapServerId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LdapServerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ldapGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LdapGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSLdapGroup"));
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
