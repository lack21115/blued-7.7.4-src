package com.alibaba.fastjson;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class JSONArray extends JSON implements Serializable, Cloneable, List<Object>, RandomAccess {
  private static final long serialVersionUID = 1L;
  
  protected transient Type componentType;
  
  private final List<Object> list = new ArrayList(10);
  
  protected transient Object relatedArray;
  
  public JSONArray() {}
  
  public JSONArray(int paramInt) {}
  
  public JSONArray(List<Object> paramList) {}
  
  public void add(int paramInt, Object paramObject) {
    this.list.add(paramInt, paramObject);
  }
  
  public boolean add(Object paramObject) {
    return this.list.add(paramObject);
  }
  
  public boolean addAll(int paramInt, Collection<? extends Object> paramCollection) {
    return this.list.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends Object> paramCollection) {
    return this.list.addAll(paramCollection);
  }
  
  public void clear() {
    this.list.clear();
  }
  
  public Object clone() {
    return new JSONArray(new ArrayList(this.list));
  }
  
  public boolean contains(Object paramObject) {
    return this.list.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    return this.list.containsAll(paramCollection);
  }
  
  public boolean equals(Object paramObject) {
    return this.list.equals(paramObject);
  }
  
  public JSONArray fluentAdd(int paramInt, Object paramObject) {
    this.list.add(paramInt, paramObject);
    return this;
  }
  
  public JSONArray fluentAdd(Object paramObject) {
    this.list.add(paramObject);
    return this;
  }
  
  public JSONArray fluentAddAll(int paramInt, Collection<? extends Object> paramCollection) {
    this.list.addAll(paramInt, paramCollection);
    return this;
  }
  
  public JSONArray fluentAddAll(Collection<? extends Object> paramCollection) {
    this.list.addAll(paramCollection);
    return this;
  }
  
  public JSONArray fluentClear() {
    this.list.clear();
    return this;
  }
  
  public JSONArray fluentRemove(int paramInt) {
    this.list.remove(paramInt);
    return this;
  }
  
  public JSONArray fluentRemove(Object paramObject) {
    this.list.remove(paramObject);
    return this;
  }
  
  public JSONArray fluentRemoveAll(Collection<?> paramCollection) {
    this.list.removeAll(paramCollection);
    return this;
  }
  
  public JSONArray fluentRetainAll(Collection<?> paramCollection) {
    this.list.retainAll(paramCollection);
    return this;
  }
  
  public JSONArray fluentSet(int paramInt, Object paramObject) {
    set(paramInt, paramObject);
    return this;
  }
  
  public Object get(int paramInt) {
    return this.list.get(paramInt);
  }
  
  public BigDecimal getBigDecimal(int paramInt) {
    return TypeUtils.castToBigDecimal(get(paramInt));
  }
  
  public BigInteger getBigInteger(int paramInt) {
    return TypeUtils.castToBigInteger(get(paramInt));
  }
  
  public Boolean getBoolean(int paramInt) {
    Object object = get(paramInt);
    return (object == null) ? null : TypeUtils.castToBoolean(object);
  }
  
  public boolean getBooleanValue(int paramInt) {
    Object object = get(paramInt);
    return (object == null) ? false : TypeUtils.castToBoolean(object).booleanValue();
  }
  
  public Byte getByte(int paramInt) {
    return TypeUtils.castToByte(get(paramInt));
  }
  
  public byte getByteValue(int paramInt) {
    Object object = get(paramInt);
    return (object == null) ? 0 : TypeUtils.castToByte(object).byteValue();
  }
  
  public Type getComponentType() {
    return this.componentType;
  }
  
  public Date getDate(int paramInt) {
    return TypeUtils.castToDate(get(paramInt));
  }
  
  public Double getDouble(int paramInt) {
    return TypeUtils.castToDouble(get(paramInt));
  }
  
  public double getDoubleValue(int paramInt) {
    Object object = get(paramInt);
    return (object == null) ? 0.0D : TypeUtils.castToDouble(object).doubleValue();
  }
  
  public Float getFloat(int paramInt) {
    return TypeUtils.castToFloat(get(paramInt));
  }
  
  public float getFloatValue(int paramInt) {
    Object object = get(paramInt);
    return (object == null) ? 0.0F : TypeUtils.castToFloat(object).floatValue();
  }
  
  public int getIntValue(int paramInt) {
    Object object = get(paramInt);
    return (object == null) ? 0 : TypeUtils.castToInt(object).intValue();
  }
  
  public Integer getInteger(int paramInt) {
    return TypeUtils.castToInt(get(paramInt));
  }
  
  public JSONArray getJSONArray(int paramInt) {
    Object object = this.list.get(paramInt);
    return (object instanceof JSONArray) ? (JSONArray)object : (JSONArray)toJSON(object);
  }
  
  public JSONObject getJSONObject(int paramInt) {
    Object object = this.list.get(paramInt);
    return (object instanceof JSONObject) ? (JSONObject)object : (JSONObject)toJSON(object);
  }
  
  public Long getLong(int paramInt) {
    return TypeUtils.castToLong(get(paramInt));
  }
  
  public long getLongValue(int paramInt) {
    Object object = get(paramInt);
    return (object == null) ? 0L : TypeUtils.castToLong(object).longValue();
  }
  
  public <T> T getObject(int paramInt, Class<T> paramClass) {
    return (T)TypeUtils.castToJavaBean(this.list.get(paramInt), paramClass);
  }
  
  public Object getRelatedArray() {
    return this.relatedArray;
  }
  
  public Short getShort(int paramInt) {
    return TypeUtils.castToShort(get(paramInt));
  }
  
  public short getShortValue(int paramInt) {
    Object object = get(paramInt);
    return (object == null) ? 0 : TypeUtils.castToShort(object).shortValue();
  }
  
  public Date getSqlDate(int paramInt) {
    return TypeUtils.castToSqlDate(get(paramInt));
  }
  
  public String getString(int paramInt) {
    return TypeUtils.castToString(get(paramInt));
  }
  
  public Timestamp getTimestamp(int paramInt) {
    return TypeUtils.castToTimestamp(get(paramInt));
  }
  
  public int hashCode() {
    return this.list.hashCode();
  }
  
  public int indexOf(Object paramObject) {
    return this.list.indexOf(paramObject);
  }
  
  public boolean isEmpty() {
    return this.list.isEmpty();
  }
  
  public Iterator<Object> iterator() {
    return this.list.iterator();
  }
  
  public int lastIndexOf(Object paramObject) {
    return this.list.lastIndexOf(paramObject);
  }
  
  public ListIterator<Object> listIterator() {
    return this.list.listIterator();
  }
  
  public ListIterator<Object> listIterator(int paramInt) {
    return this.list.listIterator(paramInt);
  }
  
  public Object remove(int paramInt) {
    return this.list.remove(paramInt);
  }
  
  public boolean remove(Object paramObject) {
    return this.list.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    return this.list.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    return this.list.retainAll(paramCollection);
  }
  
  public Object set(int paramInt, Object paramObject) {
    if (paramInt == -1) {
      this.list.add(paramObject);
      return null;
    } 
    if (this.list.size() <= paramInt) {
      for (int i = this.list.size(); i < paramInt; i++)
        this.list.add(null); 
      this.list.add(paramObject);
      return null;
    } 
    return this.list.set(paramInt, paramObject);
  }
  
  public void setComponentType(Type paramType) {
    this.componentType = paramType;
  }
  
  public void setRelatedArray(Object paramObject) {
    this.relatedArray = paramObject;
  }
  
  public int size() {
    return this.list.size();
  }
  
  public List<Object> subList(int paramInt1, int paramInt2) {
    return this.list.subList(paramInt1, paramInt2);
  }
  
  public Object[] toArray() {
    return this.list.toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    return this.list.toArray(paramArrayOfT);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\JSONArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */