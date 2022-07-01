package com.amap.api.mapcore2d;

public class dk {
  private final int a = 37;
  
  private int b = 0;
  
  public dk() {
    this.b = 17;
  }
  
  public int a() {
    return this.b;
  }
  
  public dk a(byte paramByte) {
    this.b = this.b * this.a + paramByte;
    return this;
  }
  
  public dk a(char paramChar) {
    this.b = this.b * this.a + paramChar;
    return this;
  }
  
  public dk a(double paramDouble) {
    return a(Double.doubleToLongBits(paramDouble));
  }
  
  public dk a(float paramFloat) {
    this.b = this.b * this.a + Float.floatToIntBits(paramFloat);
    return this;
  }
  
  public dk a(int paramInt) {
    this.b = this.b * this.a + paramInt;
    return this;
  }
  
  public dk a(long paramLong) {
    this.b = this.b * this.a + (int)(paramLong ^ paramLong >> 32L);
    return this;
  }
  
  public dk a(Object paramObject) {
    if (paramObject == null) {
      this.b *= this.a;
      return this;
    } 
    if (paramObject.getClass().isArray()) {
      if (paramObject instanceof long[]) {
        a((long[])paramObject);
        return this;
      } 
      if (paramObject instanceof int[]) {
        a((int[])paramObject);
        return this;
      } 
      if (paramObject instanceof short[]) {
        a((short[])paramObject);
        return this;
      } 
      if (paramObject instanceof char[]) {
        a((char[])paramObject);
        return this;
      } 
      if (paramObject instanceof byte[]) {
        a((byte[])paramObject);
        return this;
      } 
      if (paramObject instanceof double[]) {
        a((double[])paramObject);
        return this;
      } 
      if (paramObject instanceof float[]) {
        a((float[])paramObject);
        return this;
      } 
      if (paramObject instanceof boolean[]) {
        a((boolean[])paramObject);
        return this;
      } 
      a((Object[])paramObject);
      return this;
    } 
    this.b = this.b * this.a + paramObject.hashCode();
    return this;
  }
  
  public dk a(short paramShort) {
    this.b = this.b * this.a + paramShort;
    return this;
  }
  
  public dk a(boolean paramBoolean) {
    this.b = this.b * this.a + (paramBoolean ^ true);
    return this;
  }
  
  public dk a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null) {
      this.b *= this.a;
      return this;
    } 
    for (int i = 0; i < paramArrayOfbyte.length; i++)
      a(paramArrayOfbyte[i]); 
    return this;
  }
  
  public dk a(char[] paramArrayOfchar) {
    if (paramArrayOfchar == null) {
      this.b *= this.a;
      return this;
    } 
    for (int i = 0; i < paramArrayOfchar.length; i++)
      a(paramArrayOfchar[i]); 
    return this;
  }
  
  public dk a(double[] paramArrayOfdouble) {
    if (paramArrayOfdouble == null) {
      this.b *= this.a;
      return this;
    } 
    for (int i = 0; i < paramArrayOfdouble.length; i++)
      a(paramArrayOfdouble[i]); 
    return this;
  }
  
  public dk a(float[] paramArrayOffloat) {
    if (paramArrayOffloat == null) {
      this.b *= this.a;
      return this;
    } 
    for (int i = 0; i < paramArrayOffloat.length; i++)
      a(paramArrayOffloat[i]); 
    return this;
  }
  
  public dk a(int[] paramArrayOfint) {
    if (paramArrayOfint == null) {
      this.b *= this.a;
      return this;
    } 
    for (int i = 0; i < paramArrayOfint.length; i++)
      a(paramArrayOfint[i]); 
    return this;
  }
  
  public dk a(long[] paramArrayOflong) {
    if (paramArrayOflong == null) {
      this.b *= this.a;
      return this;
    } 
    for (int i = 0; i < paramArrayOflong.length; i++)
      a(paramArrayOflong[i]); 
    return this;
  }
  
  public dk a(Object[] paramArrayOfObject) {
    if (paramArrayOfObject == null) {
      this.b *= this.a;
      return this;
    } 
    for (int i = 0; i < paramArrayOfObject.length; i++)
      a(paramArrayOfObject[i]); 
    return this;
  }
  
  public dk a(short[] paramArrayOfshort) {
    if (paramArrayOfshort == null) {
      this.b *= this.a;
      return this;
    } 
    for (int i = 0; i < paramArrayOfshort.length; i++)
      a(paramArrayOfshort[i]); 
    return this;
  }
  
  public dk a(boolean[] paramArrayOfboolean) {
    if (paramArrayOfboolean == null) {
      this.b *= this.a;
      return this;
    } 
    for (int i = 0; i < paramArrayOfboolean.length; i++)
      a(paramArrayOfboolean[i]); 
    return this;
  }
  
  public int hashCode() {
    return a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */