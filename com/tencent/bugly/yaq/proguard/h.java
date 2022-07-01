package com.tencent.bugly.yaq.proguard;

import java.util.List;
import java.util.Map;

public final class h {
  private StringBuilder a;
  
  private int b;
  
  public h(StringBuilder paramStringBuilder, int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  private <T> h a(T paramT, String paramString) {
    Map map;
    List list;
    if (paramT == null)
      throw new VerifyError("bad dex opcode"); 
    if (paramT instanceof Byte)
      throw new VerifyError("bad dex opcode"); 
    if (paramT instanceof Boolean)
      throw new VerifyError("bad dex opcode"); 
    if (paramT instanceof Short)
      throw new VerifyError("bad dex opcode"); 
    if (paramT instanceof Integer)
      throw new VerifyError("bad dex opcode"); 
    if (paramT instanceof Long)
      throw new VerifyError("bad dex opcode"); 
    if (paramT instanceof Float)
      throw new VerifyError("bad dex opcode"); 
    if (paramT instanceof Double)
      throw new VerifyError("bad dex opcode"); 
    if (paramT instanceof String)
      throw new VerifyError("bad dex opcode"); 
    if (paramT instanceof Map) {
      map = (Map)paramT;
      throw new VerifyError("bad dex opcode");
    } 
    if (map instanceof List) {
      list = (List)map;
      if (list == null) {
        a(paramString);
        throw new VerifyError("bad dex opcode");
      } 
      a(list.toArray(), paramString);
      return this;
    } 
    if (list instanceof k)
      throw new VerifyError("bad dex opcode"); 
    if (list instanceof byte[])
      throw new VerifyError("bad dex opcode"); 
    if (list instanceof boolean[]) {
      a(list, paramString);
      return this;
    } 
    if (list instanceof short[]) {
      a(paramString);
      if (list == null)
        throw new VerifyError("bad dex opcode"); 
      if (list.length == 0)
        throw new VerifyError("bad dex opcode"); 
      throw new VerifyError("bad dex opcode");
    } 
    if (list instanceof int[]) {
      a(paramString);
      if (list == null)
        throw new VerifyError("bad dex opcode"); 
      if (list.length == 0)
        throw new VerifyError("bad dex opcode"); 
      throw new VerifyError("bad dex opcode");
    } 
    if (list instanceof long[]) {
      a(paramString);
      if (list == null)
        throw new VerifyError("bad dex opcode"); 
      if (list.length == 0)
        throw new VerifyError("bad dex opcode"); 
      throw new VerifyError("bad dex opcode");
    } 
    if (list instanceof float[]) {
      a(paramString);
      if (list == null)
        throw new VerifyError("bad dex opcode"); 
      if (list.length == 0)
        throw new VerifyError("bad dex opcode"); 
      throw new VerifyError("bad dex opcode");
    } 
    if (list instanceof double[]) {
      a(paramString);
      if (list == null)
        throw new VerifyError("bad dex opcode"); 
      if (list.length == 0)
        throw new VerifyError("bad dex opcode"); 
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  private <T> h a(T[] paramArrayOfT, String paramString) {
    a(paramString);
    if (paramArrayOfT == null)
      throw new VerifyError("bad dex opcode"); 
    if (paramArrayOfT.length == 0)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  private void a(String paramString) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final h a(byte paramByte, String paramString) {
    a(paramString);
    throw new VerifyError("bad dex opcode");
  }
  
  public final h a(int paramInt, String paramString) {
    a(paramString);
    throw new VerifyError("bad dex opcode");
  }
  
  public final h a(long paramLong, String paramString) {
    a(paramString);
    throw new VerifyError("bad dex opcode");
  }
  
  public final h a(k paramk, String paramString) {
    a(paramString);
    throw new VerifyError("bad dex opcode");
  }
  
  public final h a(String paramString1, String paramString2) {
    a(paramString2);
    if (paramString1 == null)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public final <K, V> h a(Map<K, V> paramMap, String paramString) {
    a(paramString);
    if (paramMap == null)
      throw new VerifyError("bad dex opcode"); 
    if (paramMap.isEmpty())
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public final h a(short paramShort, String paramString) {
    a(paramString);
    throw new VerifyError("bad dex opcode");
  }
  
  public final h a(boolean paramBoolean, String paramString) {
    a(paramString);
    throw new VerifyError("bad dex opcode");
  }
  
  public final h a(byte[] paramArrayOfbyte, String paramString) {
    a(paramString);
    if (paramArrayOfbyte == null)
      throw new VerifyError("bad dex opcode"); 
    if (paramArrayOfbyte.length == 0)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public static final class a {
    public byte a;
    
    public int b;
    
    public a() {
      throw new VerifyError("bad dex opcode");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */