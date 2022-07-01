package com.google.zxing.common;

import java.util.List;

public final class DecoderResult {
  private final byte[] a;
  
  private int b;
  
  private final String c;
  
  private final List<byte[]> d;
  
  private final String e;
  
  private Integer f;
  
  private Integer g;
  
  private Object h;
  
  private final int i;
  
  private final int j;
  
  public DecoderResult(byte[] paramArrayOfbyte, String paramString1, List<byte[]> paramList, String paramString2) {
    this(paramArrayOfbyte, paramString1, paramList, paramString2, -1, -1);
  }
  
  public DecoderResult(byte[] paramArrayOfbyte, String paramString1, List<byte[]> paramList, String paramString2, int paramInt1, int paramInt2) {
    int i;
    this.a = paramArrayOfbyte;
    if (paramArrayOfbyte == null) {
      i = 0;
    } else {
      i = paramArrayOfbyte.length * 8;
    } 
    this.b = i;
    this.c = paramString1;
    this.d = paramList;
    this.e = paramString2;
    this.i = paramInt2;
    this.j = paramInt1;
  }
  
  public void a(int paramInt) {
    this.b = paramInt;
  }
  
  public void a(Integer paramInteger) {
    this.f = paramInteger;
  }
  
  public void a(Object paramObject) {
    this.h = paramObject;
  }
  
  public byte[] a() {
    return this.a;
  }
  
  public int b() {
    return this.b;
  }
  
  public void b(Integer paramInteger) {
    this.g = paramInteger;
  }
  
  public String c() {
    return this.c;
  }
  
  public List<byte[]> d() {
    return this.d;
  }
  
  public String e() {
    return this.e;
  }
  
  public Object f() {
    return this.h;
  }
  
  public boolean g() {
    return (this.i >= 0 && this.j >= 0);
  }
  
  public int h() {
    return this.i;
  }
  
  public int i() {
    return this.j;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\DecoderResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */