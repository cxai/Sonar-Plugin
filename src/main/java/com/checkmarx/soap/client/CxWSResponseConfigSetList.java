/**
 * CxWSResponseConfigSetList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSResponseConfigSetList  extends CxWSBasicRepsonse  implements java.io.Serializable {
    private ArrayOfConfigurationSet configSetList;

    public CxWSResponseConfigSetList() {
    }

    public CxWSResponseConfigSetList(
           boolean isSuccesfull,
           String errorMessage,
           ArrayOfConfigurationSet configSetList) {
        super(
            isSuccesfull,
            errorMessage);
        this.configSetList = configSetList;
    }


    /**
     * Gets the configSetList value for this CxWSResponseConfigSetList.
     *
     * @return configSetList
     */
    public ArrayOfConfigurationSet getConfigSetList() {
        return configSetList;
    }


    /**
     * Sets the configSetList value for this CxWSResponseConfigSetList.
     *
     * @param configSetList
     */
    public void setConfigSetList(ArrayOfConfigurationSet configSetList) {
        this.configSetList = configSetList;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSResponseConfigSetList)) return false;
        CxWSResponseConfigSetList other = (CxWSResponseConfigSetList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            ((this.configSetList==null && other.getConfigSetList()==null) ||
             (this.configSetList!=null &&
              this.configSetList.equals(other.getConfigSetList())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getConfigSetList() != null) {
            _hashCode += getConfigSetList().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSResponseConfigSetList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseConfigSetList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("configSetList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ConfigSetList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfConfigurationSet"));
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
