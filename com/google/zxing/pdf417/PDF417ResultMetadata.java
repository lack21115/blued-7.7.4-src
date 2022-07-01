package com.google.zxing.pdf417;

public final class PDF417ResultMetadata {
  private int a;
  
  private String b;
  
  private boolean c;
  
  private int d = -1;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private long h = -1L;
  
  private long i = -1L;
  
  private int j = -1;
  
  private int[] k;
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  public void a(long paramLong) {
    this.h = paramLong;
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  @Deprecated
  public void a(int[] paramArrayOfint) {
    this.k = paramArrayOfint;
  }
  
  public boolean a() {
    return this.c;
  }
  
  public void b(int paramInt) {
    this.d = paramInt;
  }
  
  public void b(long paramLong) {
    this.i = paramLong;
  }
  
  public void b(String paramString) {
    this.e = paramString;
  }
  
  public void c(int paramInt) {
    this.j = paramInt;
  }
  
  public void c(String paramString) {
    this.f = paramString;
  }
  
  public void d(String paramString) {
    this.g = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\PDF417ResultMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */