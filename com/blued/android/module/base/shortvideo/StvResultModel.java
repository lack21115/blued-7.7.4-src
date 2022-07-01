package com.blued.android.module.base.shortvideo;

import java.io.Serializable;

public class StvResultModel implements Serializable {
  private boolean a = true;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private int e;
  
  private int f;
  
  private long g;
  
  private long h;
  
  private boolean i = false;
  
  private String j;
  
  private int k;
  
  public void a(int paramInt) {
    this.e = paramInt;
  }
  
  public void a(long paramLong) {
    this.g = paramLong;
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public boolean a() {
    return this.a;
  }
  
  public String b() {
    return this.b;
  }
  
  public void b(int paramInt) {
    this.f = paramInt;
  }
  
  public void b(long paramLong) {
    this.h = paramLong;
  }
  
  public void b(String paramString) {
    this.c = paramString;
  }
  
  public void b(boolean paramBoolean) {
    this.i = paramBoolean;
  }
  
  public String c() {
    return this.c;
  }
  
  public void c(int paramInt) {
    this.k = paramInt;
  }
  
  public void c(String paramString) {
    this.d = paramString;
  }
  
  public long d() {
    return this.g;
  }
  
  public void d(String paramString) {
    this.j = paramString;
  }
  
  public long e() {
    return this.h;
  }
  
  public String f() {
    return this.d;
  }
  
  public int g() {
    return this.e;
  }
  
  public int h() {
    return this.f;
  }
  
  public boolean i() {
    return this.i;
  }
  
  public String j() {
    return this.j;
  }
  
  public int k() {
    return this.k;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("StvResultModel{isVideo=");
    stringBuilder.append(this.a);
    stringBuilder.append(", captureFramePath='");
    stringBuilder.append(this.b);
    stringBuilder.append('\'');
    stringBuilder.append(", firstFrameImgPath='");
    stringBuilder.append(this.c);
    stringBuilder.append('\'');
    stringBuilder.append(", videoPath='");
    stringBuilder.append(this.d);
    stringBuilder.append('\'');
    stringBuilder.append(", videoWidth=");
    stringBuilder.append(this.e);
    stringBuilder.append(", videoHeight=");
    stringBuilder.append(this.f);
    stringBuilder.append(", videoDuration=");
    stringBuilder.append(this.g);
    stringBuilder.append(", videoSize=");
    stringBuilder.append(this.h);
    stringBuilder.append(", isAutoDelete=");
    stringBuilder.append(this.i);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\base\shortvideo\StvResultModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */