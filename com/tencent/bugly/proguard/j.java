package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class j {
  private ByteBuffer a;
  
  private String b = "GBK";
  
  public j() {
    this(128);
  }
  
  public j(int paramInt) {
    this.a = ByteBuffer.allocate(paramInt);
  }
  
  private void a(int paramInt) {
    if (this.a.remaining() < paramInt) {
      ByteBuffer byteBuffer = ByteBuffer.allocate(this.a.capacity() + paramInt << 1);
      byteBuffer.put(this.a.array(), 0, this.a.position());
      this.a = byteBuffer;
    } 
  }
  
  private void b(byte paramByte, int paramInt) {
    if (paramInt < 15) {
      byte b = (byte)(paramByte | paramInt << 4);
      this.a.put(b);
      return;
    } 
    if (paramInt < 256) {
      byte b = (byte)(paramByte | 0xF0);
      this.a.put(b);
      this.a.put((byte)paramInt);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder("tag is too large: ");
    stringBuilder.append(paramInt);
    throw new b(stringBuilder.toString());
  }
  
  public final int a(String paramString) {
    this.b = paramString;
    return 0;
  }
  
  public final ByteBuffer a() {
    return this.a;
  }
  
  public final void a(byte paramByte, int paramInt) {
    a(3);
    if (paramByte == 0) {
      b((byte)12, paramInt);
      return;
    } 
    b((byte)0, paramInt);
    this.a.put(paramByte);
  }
  
  public final void a(int paramInt1, int paramInt2) {
    a(6);
    if (paramInt1 >= -32768 && paramInt1 <= 32767) {
      a((short)paramInt1, paramInt2);
      return;
    } 
    b((byte)2, paramInt2);
    this.a.putInt(paramInt1);
  }
  
  public final void a(long paramLong, int paramInt) {
    a(10);
    if (paramLong >= -2147483648L && paramLong <= 2147483647L) {
      a((int)paramLong, paramInt);
      return;
    } 
    b((byte)3, paramInt);
    this.a.putLong(paramLong);
  }
  
  public final void a(k paramk, int paramInt) {
    a(2);
    b((byte)10, paramInt);
    paramk.a(this);
    a(2);
    b((byte)11, 0);
  }
  
  public final void a(Object paramObject, int paramInt) {
    if (paramObject instanceof Byte) {
      a(((Byte)paramObject).byteValue(), paramInt);
      return;
    } 
    if (paramObject instanceof Boolean) {
      a((byte)((Boolean)paramObject).booleanValue(), paramInt);
      return;
    } 
    if (paramObject instanceof Short) {
      a(((Short)paramObject).shortValue(), paramInt);
      return;
    } 
    if (paramObject instanceof Integer) {
      a(((Integer)paramObject).intValue(), paramInt);
      return;
    } 
    if (paramObject instanceof Long) {
      a(((Long)paramObject).longValue(), paramInt);
      return;
    } 
    if (paramObject instanceof Float) {
      float f = ((Float)paramObject).floatValue();
      a(6);
      b((byte)4, paramInt);
      this.a.putFloat(f);
      return;
    } 
    if (paramObject instanceof Double) {
      double d = ((Double)paramObject).doubleValue();
      a(10);
      b((byte)5, paramInt);
      this.a.putDouble(d);
      return;
    } 
    if (paramObject instanceof String) {
      a((String)paramObject, paramInt);
      return;
    } 
    if (paramObject instanceof Map) {
      a((Map<?, ?>)paramObject, paramInt);
      return;
    } 
    if (paramObject instanceof List) {
      a((List)paramObject, paramInt);
      return;
    } 
    if (paramObject instanceof k) {
      paramObject = paramObject;
      a(2);
      b((byte)10, paramInt);
      paramObject.a(this);
      a(2);
      b((byte)11, 0);
      return;
    } 
    if (paramObject instanceof byte[]) {
      a((byte[])paramObject, paramInt);
      return;
    } 
    if (paramObject instanceof boolean[]) {
      paramObject = paramObject;
      a(8);
      b((byte)9, paramInt);
      a(paramObject.length, 0);
      int i = paramObject.length;
      for (paramInt = 0; paramInt < i; paramInt++)
        a((byte)paramObject[paramInt], 0); 
      return;
    } 
    if (paramObject instanceof short[]) {
      paramObject = paramObject;
      a(8);
      b((byte)9, paramInt);
      a(paramObject.length, 0);
      int i = paramObject.length;
      for (paramInt = 0; paramInt < i; paramInt++)
        a(paramObject[paramInt], 0); 
      return;
    } 
    if (paramObject instanceof int[]) {
      paramObject = paramObject;
      a(8);
      b((byte)9, paramInt);
      a(paramObject.length, 0);
      int i = paramObject.length;
      for (paramInt = 0; paramInt < i; paramInt++)
        a(paramObject[paramInt], 0); 
      return;
    } 
    if (paramObject instanceof long[]) {
      paramObject = paramObject;
      a(8);
      b((byte)9, paramInt);
      a(paramObject.length, 0);
      int i = paramObject.length;
      for (paramInt = 0; paramInt < i; paramInt++)
        a(paramObject[paramInt], 0); 
      return;
    } 
    if (paramObject instanceof float[]) {
      paramObject = paramObject;
      a(8);
      b((byte)9, paramInt);
      a(paramObject.length, 0);
      int i = paramObject.length;
      for (paramInt = 0; paramInt < i; paramInt++) {
        Object object = paramObject[paramInt];
        a(6);
        b((byte)4, 0);
        this.a.putFloat(object);
      } 
      return;
    } 
    if (paramObject instanceof double[]) {
      paramObject = paramObject;
      a(8);
      b((byte)9, paramInt);
      a(paramObject.length, 0);
      int i = paramObject.length;
      for (paramInt = 0; paramInt < i; paramInt++) {
        Object object = paramObject[paramInt];
        a(10);
        b((byte)5, 0);
        this.a.putDouble(object);
      } 
      return;
    } 
    if (paramObject.getClass().isArray()) {
      paramObject = paramObject;
      a(8);
      b((byte)9, paramInt);
      a(paramObject.length, 0);
      int i = paramObject.length;
      for (paramInt = 0; paramInt < i; paramInt++)
        a(paramObject[paramInt], 0); 
      return;
    } 
    if (paramObject instanceof Collection) {
      a((Collection)paramObject, paramInt);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder("write object error: unsupport type. ");
    stringBuilder.append(paramObject.getClass());
    throw new b(stringBuilder.toString());
  }
  
  public final void a(String paramString, int paramInt) {
    byte[] arrayOfByte;
    try {
      byte[] arrayOfByte1 = paramString.getBytes(this.b);
      arrayOfByte = arrayOfByte1;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      arrayOfByte = arrayOfByte.getBytes();
    } 
    a(arrayOfByte.length + 10);
    if (arrayOfByte.length > 255) {
      b((byte)7, paramInt);
      this.a.putInt(arrayOfByte.length);
      this.a.put(arrayOfByte);
      return;
    } 
    b((byte)6, paramInt);
    this.a.put((byte)arrayOfByte.length);
    this.a.put(arrayOfByte);
  }
  
  public final <T> void a(Collection<T> paramCollection, int paramInt) {
    a(8);
    b((byte)9, paramInt);
    if (paramCollection == null) {
      paramInt = 0;
    } else {
      paramInt = paramCollection.size();
    } 
    a(paramInt, 0);
    if (paramCollection != null) {
      Iterator<T> iterator = paramCollection.iterator();
      while (iterator.hasNext())
        a(iterator.next(), 0); 
    } 
  }
  
  public final <K, V> void a(Map<K, V> paramMap, int paramInt) {
    a(8);
    b((byte)8, paramInt);
    if (paramMap == null) {
      paramInt = 0;
    } else {
      paramInt = paramMap.size();
    } 
    a(paramInt, 0);
    if (paramMap != null)
      for (Map.Entry<K, V> entry : paramMap.entrySet()) {
        a(entry.getKey(), 0);
        a(entry.getValue(), 1);
      }  
  }
  
  public final void a(short paramShort, int paramInt) {
    a(4);
    if (paramShort >= -128 && paramShort <= 127) {
      a((byte)paramShort, paramInt);
      return;
    } 
    b((byte)1, paramInt);
    this.a.putShort(paramShort);
  }
  
  public final void a(boolean paramBoolean, int paramInt) {
    a((byte)paramBoolean, paramInt);
  }
  
  public final void a(byte[] paramArrayOfbyte, int paramInt) {
    a(paramArrayOfbyte.length + 8);
    b((byte)13, paramInt);
    b((byte)0, 0);
    a(paramArrayOfbyte.length, 0);
    this.a.put(paramArrayOfbyte);
  }
  
  public final byte[] b() {
    byte[] arrayOfByte = new byte[this.a.position()];
    System.arraycopy(this.a.array(), 0, arrayOfByte, 0, this.a.position());
    return arrayOfByte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */