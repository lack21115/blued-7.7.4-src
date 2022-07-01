package com.tencent.bugly.yaq.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Map;

public final class j {
  private ByteBuffer a;
  
  private String b;
  
  public j() {
    this(128);
    throw new VerifyError("bad dex opcode");
  }
  
  public j(int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  private void a(int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  private void b(byte paramByte, int paramInt) {
    if (paramInt < 15) {
      paramByte = (byte)(paramInt << 4 | paramByte);
      throw new VerifyError("bad dex opcode");
    } 
    if (paramInt < 256) {
      paramByte = (byte)(paramByte | 0xF0);
      throw new VerifyError("bad dex opcode");
    } 
    new StringBuilder("tag is too large: ");
    throw new VerifyError("bad dex opcode");
  }
  
  public final int a(String paramString) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final ByteBuffer a() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(byte paramByte, int paramInt) {
    a(3);
    if (paramByte == 0) {
      b((byte)12, paramInt);
      throw new VerifyError("bad dex opcode");
    } 
    b((byte)0, paramInt);
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(int paramInt1, int paramInt2) {
    a(6);
    if (paramInt1 >= -32768 && paramInt1 <= 32767) {
      paramInt1 = (short)paramInt1;
      throw new VerifyError("bad dex opcode");
    } 
    b((byte)2, paramInt2);
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(long paramLong, int paramInt) {
    a(10);
    if (paramLong >= -2147483648L && paramLong <= 2147483647L) {
      paramInt = (int)paramLong;
      throw new VerifyError("bad dex opcode");
    } 
    b((byte)3, paramInt);
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(k paramk, int paramInt) {
    a(2);
    b((byte)10, paramInt);
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(Object paramObject, int paramInt) {
    if (paramObject instanceof Byte)
      throw new VerifyError("bad dex opcode"); 
    if (paramObject instanceof Boolean)
      throw new VerifyError("bad dex opcode"); 
    if (paramObject instanceof Short)
      throw new VerifyError("bad dex opcode"); 
    if (paramObject instanceof Integer)
      throw new VerifyError("bad dex opcode"); 
    if (paramObject instanceof Long)
      throw new VerifyError("bad dex opcode"); 
    if (paramObject instanceof Float)
      throw new VerifyError("bad dex opcode"); 
    if (paramObject instanceof Double)
      throw new VerifyError("bad dex opcode"); 
    if (paramObject instanceof String)
      throw new VerifyError("bad dex opcode"); 
    if (paramObject instanceof Map) {
      paramObject = paramObject;
      throw new VerifyError("bad dex opcode");
    } 
    if (paramObject instanceof java.util.List) {
      paramObject = paramObject;
      throw new VerifyError("bad dex opcode");
    } 
    if (paramObject instanceof k) {
      a(2);
      b((byte)10, paramInt);
      throw new VerifyError("bad dex opcode");
    } 
    if (paramObject instanceof byte[])
      throw new VerifyError("bad dex opcode"); 
    if (paramObject instanceof boolean[]) {
      a(8);
      b((byte)9, paramInt);
      paramInt = paramObject.length;
      throw new VerifyError("bad dex opcode");
    } 
    if (paramObject instanceof short[]) {
      a(8);
      b((byte)9, paramInt);
      paramInt = paramObject.length;
      throw new VerifyError("bad dex opcode");
    } 
    if (paramObject instanceof int[]) {
      a(8);
      b((byte)9, paramInt);
      paramInt = paramObject.length;
      throw new VerifyError("bad dex opcode");
    } 
    if (paramObject instanceof long[]) {
      a(8);
      b((byte)9, paramInt);
      paramInt = paramObject.length;
      throw new VerifyError("bad dex opcode");
    } 
    if (paramObject instanceof float[]) {
      a(8);
      b((byte)9, paramInt);
      paramInt = paramObject.length;
      throw new VerifyError("bad dex opcode");
    } 
    if (paramObject instanceof double[]) {
      a(8);
      b((byte)9, paramInt);
      paramInt = paramObject.length;
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(String paramString, int paramInt) {
    try {
      throw new VerifyError("bad dex opcode");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public final <T> void a(Collection<T> paramCollection, int paramInt) {
    a(8);
    b((byte)9, paramInt);
    if (paramCollection != null)
      paramCollection.size(); 
    throw new VerifyError("bad dex opcode");
  }
  
  public final <K, V> void a(Map<K, V> paramMap, int paramInt) {
    a(8);
    b((byte)8, paramInt);
    if (paramMap != null)
      paramMap.size(); 
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(short paramShort, int paramInt) {
    a(4);
    if (paramShort >= -128 && paramShort <= 127) {
      paramShort = (byte)paramShort;
      throw new VerifyError("bad dex opcode");
    } 
    b((byte)1, paramInt);
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(boolean paramBoolean, int paramInt) {
    if (paramBoolean) {
      paramInt = 1;
      paramInt = (byte)paramInt;
      throw new VerifyError("bad dex opcode");
    } 
    paramInt = 0;
    paramInt = (byte)paramInt;
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(byte[] paramArrayOfbyte, int paramInt) {
    a(paramArrayOfbyte.length + 8);
    b((byte)13, paramInt);
    b((byte)0, 0);
    paramInt = paramArrayOfbyte.length;
    throw new VerifyError("bad dex opcode");
  }
  
  public final byte[] b() {
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */