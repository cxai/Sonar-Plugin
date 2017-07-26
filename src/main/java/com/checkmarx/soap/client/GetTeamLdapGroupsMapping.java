/**
 * GetTeamLdapGroupsMapping.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class GetTeamLdapGroupsMapping  implements java.io.Serializable {
    private String sessionId;

    private String teamId;

    public GetTeamLdapGroupsMapping() {
    }

    public GetTeamLdapGroupsMapping(
           String sessionId,
           String teamId) {
           this.sessionId = sessionId;
           this.teamId = teamId;
    }


    /**
     * Gets the sessionId value for this GetTeamLdapGroupsMapping.
     *
     * @return sessionId
     */
    public String getSessionId() {
        return sessionId;
    }


    /**
     * Sets the sessionId value for this GetTeamLdapGroupsMapping.
     *
     * @param sessionId
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    /**
     * Gets the teamId value for this GetTeamLdapGroupsMapping.
     *
     * @return teamId
     */
    public String getTeamId() {
        return teamId;
    }


    /**
     * Sets the teamId value for this GetTeamLdapGroupsMapping.
     *
     * @param teamId
     */
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetTeamLdapGroupsMapping)) return false;
        GetTeamLdapGroupsMapping other = (GetTeamLdapGroupsMapping) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.sessionId==null && other.getSessionId()==null) ||
             (this.sessionId!=null &&
              this.sessionId.equals(other.getSessionId()))) &&
            ((this.teamId==null && other.getTeamId()==null) ||
             (this.teamId!=null &&
              this.teamId.equals(other.getTeamId())));
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
        if (getSessionId() != null) {
            _hashCode += getSessionId().hashCode();
        }
        if (getTeamId() != null) {
            _hashCode += getTeamId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetTeamLdapGroupsMapping.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetTeamLdapGroupsMapping"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("teamId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "teamId"));
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
