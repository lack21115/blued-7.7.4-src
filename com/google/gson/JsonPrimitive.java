package com.google.gson;

import com.google.gson.internal.;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonPrimitive extends JsonElement {
  private final Object value;
  
  public JsonPrimitive(Boolean paramBoolean) {
    this.value = .Gson.Preconditions.checkNotNull(paramBoolean);
  }
  
  public JsonPrimitive(Character paramCharacter) {
    this.value = ((Character).Gson.Preconditions.checkNotNull(paramCharacter)).toString();
  }
  
  public JsonPrimitive(Number paramNumber) {
    this.value = .Gson.Preconditions.checkNotNull(paramNumber);
  }
  
  public JsonPrimitive(String paramString) {
    this.value = .Gson.Preconditions.checkNotNull(paramString);
  }
  
  private static boolean isIntegral(JsonPrimitive paramJsonPrimitive) {
    Object object = paramJsonPrimitive.value;
    boolean bool1 = object instanceof Number;
    boolean bool = false;
    null = bool;
    if (bool1) {
      object = object;
      if (!(object instanceof BigInteger) && !(object instanceof Long) && !(object instanceof Integer) && !(object instanceof Short)) {
        null = bool;
        return (object instanceof Byte) ? true : null;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  public JsonPrimitive deepCopy() {
    return this;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      if (this.value == null)
        return (((JsonPrimitive)paramObject).value == null); 
      if (isIntegral(this) && isIntegral((JsonPrimitive)paramObject))
        return (getAsNumber().longValue() == paramObject.getAsNumber().longValue()); 
      if (this.value instanceof Number && ((JsonPrimitive)paramObject).value instanceof Number) {
        double d1 = getAsNumber().doubleValue();
        double d2 = paramObject.getAsNumber().doubleValue();
        if (d1 != d2) {
          if (Double.isNaN(d1) && Double.isNaN(d2))
            return true; 
          bool = false;
        } 
        return bool;
      } 
      return this.value.equals(((JsonPrimitive)paramObject).value);
    } 
    return false;
  }
  
  public BigDecimal getAsBigDecimal() {
    Object object = this.value;
    return (object instanceof BigDecimal) ? (BigDecimal)object : new BigDecimal(object.toString());
  }
  
  public BigInteger getAsBigInteger() {
    Object object = this.value;
    return (object instanceof BigInteger) ? (BigInteger)object : new BigInteger(object.toString());
  }
  
  public boolean getAsBoolean() {
    return isBoolean() ? ((Boolean)this.value).booleanValue() : Boolean.parseBoolean(getAsString());
  }
  
  public byte getAsByte() {
    return isNumber() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
  }
  
  public char getAsCharacter() {
    return getAsString().charAt(0);
  }
  
  public double getAsDouble() {
    return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
  }
  
  public float getAsFloat() {
    return isNumber() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
  }
  
  public int getAsInt() {
    return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
  }
  
  public long getAsLong() {
    return isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString());
  }
  
  public Number getAsNumber() {
    Object object = this.value;
    return (Number)((object instanceof String) ? new LazilyParsedNumber((String)object) : object);
  }
  
  public short getAsShort() {
    return isNumber() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
  }
  
  public String getAsString() {
    return isNumber() ? getAsNumber().toString() : (isBoolean() ? ((Boolean)this.value).toString() : (String)this.value);
  }
  
  public int hashCode() {
    if (this.value == null)
      return 31; 
    if (isIntegral(this)) {
      long l = getAsNumber().longValue();
      return (int)(l >>> 32L ^ l);
    } 
    Object object = this.value;
    if (object instanceof Number) {
      long l = Double.doubleToLongBits(getAsNumber().doubleValue());
      return (int)(l >>> 32L ^ l);
    } 
    return object.hashCode();
  }
  
  public boolean isBoolean() {
    return this.value instanceof Boolean;
  }
  
  public boolean isNumber() {
    return this.value instanceof Number;
  }
  
  public boolean isString() {
    return this.value instanceof String;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\gson\JsonPrimitive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */