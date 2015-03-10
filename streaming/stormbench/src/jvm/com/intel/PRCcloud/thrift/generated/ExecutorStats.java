/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.intel.PRCcloud.thrift.generated;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutorStats implements org.apache.thrift.TBase<ExecutorStats, ExecutorStats._Fields>, java.io.Serializable, Cloneable, Comparable<ExecutorStats> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ExecutorStats");

  private static final org.apache.thrift.protocol.TField EMITTED_FIELD_DESC = new org.apache.thrift.protocol.TField("emitted", org.apache.thrift.protocol.TType.MAP, (short)1);
  private static final org.apache.thrift.protocol.TField TRANSFERRED_FIELD_DESC = new org.apache.thrift.protocol.TField("transferred", org.apache.thrift.protocol.TType.MAP, (short)2);
  private static final org.apache.thrift.protocol.TField SPECIFIC_FIELD_DESC = new org.apache.thrift.protocol.TField("specific", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ExecutorStatsStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ExecutorStatsTupleSchemeFactory());
  }

  public Map<String,Map<String,Long>> emitted; // required
  public Map<String,Map<String,Long>> transferred; // required
  public ExecutorSpecificStats specific; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EMITTED((short)1, "emitted"),
    TRANSFERRED((short)2, "transferred"),
    SPECIFIC((short)3, "specific");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // EMITTED
          return EMITTED;
        case 2: // TRANSFERRED
          return TRANSFERRED;
        case 3: // SPECIFIC
          return SPECIFIC;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EMITTED, new org.apache.thrift.meta_data.FieldMetaData("emitted", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)))));
    tmpMap.put(_Fields.TRANSFERRED, new org.apache.thrift.meta_data.FieldMetaData("transferred", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)))));
    tmpMap.put(_Fields.SPECIFIC, new org.apache.thrift.meta_data.FieldMetaData("specific", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ExecutorSpecificStats.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ExecutorStats.class, metaDataMap);
  }

  public ExecutorStats() {
  }

  public ExecutorStats(
    Map<String,Map<String,Long>> emitted,
    Map<String,Map<String,Long>> transferred,
    ExecutorSpecificStats specific)
  {
    this();
    this.emitted = emitted;
    this.transferred = transferred;
    this.specific = specific;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ExecutorStats(ExecutorStats other) {
    if (other.isSetEmitted()) {
      Map<String,Map<String,Long>> __this__emitted = new HashMap<String,Map<String,Long>>(other.emitted.size());
      for (Map.Entry<String, Map<String,Long>> other_element : other.emitted.entrySet()) {

        String other_element_key = other_element.getKey();
        Map<String,Long> other_element_value = other_element.getValue();

        String __this__emitted_copy_key = other_element_key;

        Map<String,Long> __this__emitted_copy_value = new HashMap<String,Long>(other_element_value);

        __this__emitted.put(__this__emitted_copy_key, __this__emitted_copy_value);
      }
      this.emitted = __this__emitted;
    }
    if (other.isSetTransferred()) {
      Map<String,Map<String,Long>> __this__transferred = new HashMap<String,Map<String,Long>>(other.transferred.size());
      for (Map.Entry<String, Map<String,Long>> other_element : other.transferred.entrySet()) {

        String other_element_key = other_element.getKey();
        Map<String,Long> other_element_value = other_element.getValue();

        String __this__transferred_copy_key = other_element_key;

        Map<String,Long> __this__transferred_copy_value = new HashMap<String,Long>(other_element_value);

        __this__transferred.put(__this__transferred_copy_key, __this__transferred_copy_value);
      }
      this.transferred = __this__transferred;
    }
    if (other.isSetSpecific()) {
      this.specific = new ExecutorSpecificStats(other.specific);
    }
  }

  public ExecutorStats deepCopy() {
    return new ExecutorStats(this);
  }

  @Override
  public void clear() {
    this.emitted = null;
    this.transferred = null;
    this.specific = null;
  }

  public int getEmittedSize() {
    return (this.emitted == null) ? 0 : this.emitted.size();
  }

  public void putToEmitted(String key, Map<String,Long> val) {
    if (this.emitted == null) {
      this.emitted = new HashMap<String,Map<String,Long>>();
    }
    this.emitted.put(key, val);
  }

  public Map<String,Map<String,Long>> getEmitted() {
    return this.emitted;
  }

  public ExecutorStats setEmitted(Map<String,Map<String,Long>> emitted) {
    this.emitted = emitted;
    return this;
  }

  public void unsetEmitted() {
    this.emitted = null;
  }

  /** Returns true if field emitted is set (has been assigned a value) and false otherwise */
  public boolean isSetEmitted() {
    return this.emitted != null;
  }

  public void setEmittedIsSet(boolean value) {
    if (!value) {
      this.emitted = null;
    }
  }

  public int getTransferredSize() {
    return (this.transferred == null) ? 0 : this.transferred.size();
  }

  public void putToTransferred(String key, Map<String,Long> val) {
    if (this.transferred == null) {
      this.transferred = new HashMap<String,Map<String,Long>>();
    }
    this.transferred.put(key, val);
  }

  public Map<String,Map<String,Long>> getTransferred() {
    return this.transferred;
  }

  public ExecutorStats setTransferred(Map<String,Map<String,Long>> transferred) {
    this.transferred = transferred;
    return this;
  }

  public void unsetTransferred() {
    this.transferred = null;
  }

  /** Returns true if field transferred is set (has been assigned a value) and false otherwise */
  public boolean isSetTransferred() {
    return this.transferred != null;
  }

  public void setTransferredIsSet(boolean value) {
    if (!value) {
      this.transferred = null;
    }
  }

  public ExecutorSpecificStats getSpecific() {
    return this.specific;
  }

  public ExecutorStats setSpecific(ExecutorSpecificStats specific) {
    this.specific = specific;
    return this;
  }

  public void unsetSpecific() {
    this.specific = null;
  }

  /** Returns true if field specific is set (has been assigned a value) and false otherwise */
  public boolean isSetSpecific() {
    return this.specific != null;
  }

  public void setSpecificIsSet(boolean value) {
    if (!value) {
      this.specific = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case EMITTED:
      if (value == null) {
        unsetEmitted();
      } else {
        setEmitted((Map<String,Map<String,Long>>)value);
      }
      break;

    case TRANSFERRED:
      if (value == null) {
        unsetTransferred();
      } else {
        setTransferred((Map<String,Map<String,Long>>)value);
      }
      break;

    case SPECIFIC:
      if (value == null) {
        unsetSpecific();
      } else {
        setSpecific((ExecutorSpecificStats)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case EMITTED:
      return getEmitted();

    case TRANSFERRED:
      return getTransferred();

    case SPECIFIC:
      return getSpecific();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case EMITTED:
      return isSetEmitted();
    case TRANSFERRED:
      return isSetTransferred();
    case SPECIFIC:
      return isSetSpecific();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ExecutorStats)
      return this.equals((ExecutorStats)that);
    return false;
  }

  public boolean equals(ExecutorStats that) {
    if (that == null)
      return false;

    boolean this_present_emitted = true && this.isSetEmitted();
    boolean that_present_emitted = true && that.isSetEmitted();
    if (this_present_emitted || that_present_emitted) {
      if (!(this_present_emitted && that_present_emitted))
        return false;
      if (!this.emitted.equals(that.emitted))
        return false;
    }

    boolean this_present_transferred = true && this.isSetTransferred();
    boolean that_present_transferred = true && that.isSetTransferred();
    if (this_present_transferred || that_present_transferred) {
      if (!(this_present_transferred && that_present_transferred))
        return false;
      if (!this.transferred.equals(that.transferred))
        return false;
    }

    boolean this_present_specific = true && this.isSetSpecific();
    boolean that_present_specific = true && that.isSetSpecific();
    if (this_present_specific || that_present_specific) {
      if (!(this_present_specific && that_present_specific))
        return false;
      if (!this.specific.equals(that.specific))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ExecutorStats other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetEmitted()).compareTo(other.isSetEmitted());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEmitted()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.emitted, other.emitted);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTransferred()).compareTo(other.isSetTransferred());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTransferred()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.transferred, other.transferred);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSpecific()).compareTo(other.isSetSpecific());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSpecific()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.specific, other.specific);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ExecutorStats(");
    boolean first = true;

    sb.append("emitted:");
    if (this.emitted == null) {
      sb.append("null");
    } else {
      sb.append(this.emitted);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("transferred:");
    if (this.transferred == null) {
      sb.append("null");
    } else {
      sb.append(this.transferred);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("specific:");
    if (this.specific == null) {
      sb.append("null");
    } else {
      sb.append(this.specific);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (emitted == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'emitted' was not present! Struct: " + toString());
    }
    if (transferred == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'transferred' was not present! Struct: " + toString());
    }
    if (specific == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'specific' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ExecutorStatsStandardSchemeFactory implements SchemeFactory {
    public ExecutorStatsStandardScheme getScheme() {
      return new ExecutorStatsStandardScheme();
    }
  }

  private static class ExecutorStatsStandardScheme extends StandardScheme<ExecutorStats> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ExecutorStats struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // EMITTED
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map250 = iprot.readMapBegin();
                struct.emitted = new HashMap<String,Map<String,Long>>(2*_map250.size);
                for (int _i251 = 0; _i251 < _map250.size; ++_i251)
                {
                  String _key252;
                  Map<String,Long> _val253;
                  _key252 = iprot.readString();
                  {
                    org.apache.thrift.protocol.TMap _map254 = iprot.readMapBegin();
                    _val253 = new HashMap<String,Long>(2*_map254.size);
                    for (int _i255 = 0; _i255 < _map254.size; ++_i255)
                    {
                      String _key256;
                      long _val257;
                      _key256 = iprot.readString();
                      _val257 = iprot.readI64();
                      _val253.put(_key256, _val257);
                    }
                    iprot.readMapEnd();
                  }
                  struct.emitted.put(_key252, _val253);
                }
                iprot.readMapEnd();
              }
              struct.setEmittedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TRANSFERRED
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map258 = iprot.readMapBegin();
                struct.transferred = new HashMap<String,Map<String,Long>>(2*_map258.size);
                for (int _i259 = 0; _i259 < _map258.size; ++_i259)
                {
                  String _key260;
                  Map<String,Long> _val261;
                  _key260 = iprot.readString();
                  {
                    org.apache.thrift.protocol.TMap _map262 = iprot.readMapBegin();
                    _val261 = new HashMap<String,Long>(2*_map262.size);
                    for (int _i263 = 0; _i263 < _map262.size; ++_i263)
                    {
                      String _key264;
                      long _val265;
                      _key264 = iprot.readString();
                      _val265 = iprot.readI64();
                      _val261.put(_key264, _val265);
                    }
                    iprot.readMapEnd();
                  }
                  struct.transferred.put(_key260, _val261);
                }
                iprot.readMapEnd();
              }
              struct.setTransferredIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SPECIFIC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.specific = new ExecutorSpecificStats();
              struct.specific.read(iprot);
              struct.setSpecificIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ExecutorStats struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.emitted != null) {
        oprot.writeFieldBegin(EMITTED_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.MAP, struct.emitted.size()));
          for (Map.Entry<String, Map<String,Long>> _iter266 : struct.emitted.entrySet())
          {
            oprot.writeString(_iter266.getKey());
            {
              oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.I64, _iter266.getValue().size()));
              for (Map.Entry<String, Long> _iter267 : _iter266.getValue().entrySet())
              {
                oprot.writeString(_iter267.getKey());
                oprot.writeI64(_iter267.getValue());
              }
              oprot.writeMapEnd();
            }
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.transferred != null) {
        oprot.writeFieldBegin(TRANSFERRED_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.MAP, struct.transferred.size()));
          for (Map.Entry<String, Map<String,Long>> _iter268 : struct.transferred.entrySet())
          {
            oprot.writeString(_iter268.getKey());
            {
              oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.I64, _iter268.getValue().size()));
              for (Map.Entry<String, Long> _iter269 : _iter268.getValue().entrySet())
              {
                oprot.writeString(_iter269.getKey());
                oprot.writeI64(_iter269.getValue());
              }
              oprot.writeMapEnd();
            }
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.specific != null) {
        oprot.writeFieldBegin(SPECIFIC_FIELD_DESC);
        struct.specific.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ExecutorStatsTupleSchemeFactory implements SchemeFactory {
    public ExecutorStatsTupleScheme getScheme() {
      return new ExecutorStatsTupleScheme();
    }
  }

  private static class ExecutorStatsTupleScheme extends TupleScheme<ExecutorStats> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ExecutorStats struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.emitted.size());
        for (Map.Entry<String, Map<String,Long>> _iter270 : struct.emitted.entrySet())
        {
          oprot.writeString(_iter270.getKey());
          {
            oprot.writeI32(_iter270.getValue().size());
            for (Map.Entry<String, Long> _iter271 : _iter270.getValue().entrySet())
            {
              oprot.writeString(_iter271.getKey());
              oprot.writeI64(_iter271.getValue());
            }
          }
        }
      }
      {
        oprot.writeI32(struct.transferred.size());
        for (Map.Entry<String, Map<String,Long>> _iter272 : struct.transferred.entrySet())
        {
          oprot.writeString(_iter272.getKey());
          {
            oprot.writeI32(_iter272.getValue().size());
            for (Map.Entry<String, Long> _iter273 : _iter272.getValue().entrySet())
            {
              oprot.writeString(_iter273.getKey());
              oprot.writeI64(_iter273.getValue());
            }
          }
        }
      }
      struct.specific.write(oprot);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ExecutorStats struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TMap _map274 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.MAP, iprot.readI32());
        struct.emitted = new HashMap<String,Map<String,Long>>(2*_map274.size);
        for (int _i275 = 0; _i275 < _map274.size; ++_i275)
        {
          String _key276;
          Map<String,Long> _val277;
          _key276 = iprot.readString();
          {
            org.apache.thrift.protocol.TMap _map278 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.I64, iprot.readI32());
            _val277 = new HashMap<String,Long>(2*_map278.size);
            for (int _i279 = 0; _i279 < _map278.size; ++_i279)
            {
              String _key280;
              long _val281;
              _key280 = iprot.readString();
              _val281 = iprot.readI64();
              _val277.put(_key280, _val281);
            }
          }
          struct.emitted.put(_key276, _val277);
        }
      }
      struct.setEmittedIsSet(true);
      {
        org.apache.thrift.protocol.TMap _map282 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.MAP, iprot.readI32());
        struct.transferred = new HashMap<String,Map<String,Long>>(2*_map282.size);
        for (int _i283 = 0; _i283 < _map282.size; ++_i283)
        {
          String _key284;
          Map<String,Long> _val285;
          _key284 = iprot.readString();
          {
            org.apache.thrift.protocol.TMap _map286 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.I64, iprot.readI32());
            _val285 = new HashMap<String,Long>(2*_map286.size);
            for (int _i287 = 0; _i287 < _map286.size; ++_i287)
            {
              String _key288;
              long _val289;
              _key288 = iprot.readString();
              _val289 = iprot.readI64();
              _val285.put(_key288, _val289);
            }
          }
          struct.transferred.put(_key284, _val285);
        }
      }
      struct.setTransferredIsSet(true);
      struct.specific = new ExecutorSpecificStats();
      struct.specific.read(iprot);
      struct.setSpecificIsSet(true);
    }
  }

}

