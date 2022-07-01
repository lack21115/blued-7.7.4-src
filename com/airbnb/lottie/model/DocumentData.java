package com.airbnb.lottie.model;

public class DocumentData {
  public final String a;
  
  public final String b;
  
  public final double c;
  
  public final Justification d;
  
  public final int e;
  
  public final double f;
  
  public final double g;
  
  public final int h;
  
  public final int i;
  
  public final double j;
  
  public final boolean k;
  
  public DocumentData(String paramString1, String paramString2, double paramDouble1, Justification paramJustification, int paramInt1, double paramDouble2, double paramDouble3, int paramInt2, int paramInt3, double paramDouble4, boolean paramBoolean) {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramDouble1;
    this.d = paramJustification;
    this.e = paramInt1;
    this.f = paramDouble2;
    this.g = paramDouble3;
    this.h = paramInt2;
    this.i = paramInt3;
    this.j = paramDouble4;
    this.k = paramBoolean;
  }
  
  public int hashCode() {
    int i = (int)(((this.a.hashCode() * 31 + this.b.hashCode()) * 31) + this.c);
    int j = this.d.ordinal();
    int k = this.e;
    long l = Double.doubleToLongBits(this.f);
    return (((i * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32L)) * 31 + this.h;
  }
  
  public enum Justification {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\DocumentData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */