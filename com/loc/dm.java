package com.loc;

import android.os.Parcel;
import android.os.Parcelable;

public final class dm implements Parcelable {
  public static final Parcelable.Creator<dm> CREATOR = new Parcelable.Creator<dm>() {
    
    };
  
  private long a = 0L;
  
  private long b = 0L;
  
  private long c = 0L;
  
  private long d = 0L;
  
  private String e;
  
  private String f;
  
  private String g = "first";
  
  private String h = "";
  
  private String i = "";
  
  private String j = null;
  
  public final long a() {
    long l1 = this.d;
    long l2 = this.c;
    return (l1 - l2 <= 0L) ? 0L : (l1 - l2);
  }
  
  public final void a(long paramLong) {
    this.c = paramLong;
  }
  
  public final void a(String paramString) {
    this.i = paramString;
  }
  
  public final String b() {
    return this.i;
  }
  
  public final void b(long paramLong) {
    this.d = paramLong;
  }
  
  public final void b(String paramString) {
    this.j = paramString;
  }
  
  public final String c() {
    return this.j;
  }
  
  public final void c(long paramLong) {
    this.a = paramLong;
  }
  
  public final void c(String paramString) {
    this.e = paramString;
  }
  
  public final String d() {
    return this.e;
  }
  
  public final void d(long paramLong) {
    this.b = paramLong;
  }
  
  public final void d(String paramString) {
    this.f = paramString;
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final String e() {
    return this.f;
  }
  
  public final void e(String paramString) {
    this.g = paramString;
  }
  
  public final String f() {
    return this.g;
  }
  
  public final void f(String paramString) {
    this.h = paramString;
  }
  
  public final String g() {
    return this.h;
  }
  
  public final long h() {
    long l1 = this.b;
    long l2 = this.a;
    return (l1 <= l2) ? 0L : (l1 - l2);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    try {
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.f);
      paramParcel.writeString(this.g);
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.j);
      paramParcel.writeLong(this.a);
      paramParcel.writeLong(this.b);
      paramParcel.writeLong(this.c);
      paramParcel.writeLong(this.d);
      return;
    } finally {
      paramParcel = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */