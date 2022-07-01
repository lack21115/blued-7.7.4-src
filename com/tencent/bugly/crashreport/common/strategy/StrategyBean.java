package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.z;
import java.util.Map;

public class StrategyBean implements Parcelable {
  public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() {
    
    };
  
  public static String a = "http://rqd.uu.qq.com/rqd/sync";
  
  public static String b = "http://android.bugly.qq.com/rqd/async";
  
  public static String c = "http://android.bugly.qq.com/rqd/async";
  
  public static String d;
  
  public long e = -1L;
  
  public long f = -1L;
  
  public boolean g;
  
  public boolean h;
  
  public boolean i;
  
  public boolean j;
  
  public boolean k;
  
  public boolean l;
  
  public boolean m;
  
  public boolean n;
  
  public boolean o;
  
  public long p;
  
  public long q;
  
  public String r;
  
  public String s;
  
  public String t;
  
  public String u;
  
  public Map<String, String> v;
  
  public int w;
  
  public long x;
  
  public long y;
  
  public StrategyBean() {
    this.g = true;
    this.h = true;
    this.i = true;
    this.j = true;
    this.k = false;
    this.l = true;
    this.m = true;
    this.n = true;
    this.o = true;
    this.q = 30000L;
    this.r = b;
    this.s = c;
    this.t = a;
    this.w = 10;
    this.x = 300000L;
    this.y = -1L;
    this.f = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("S(@L@L");
    stringBuilder.append("@)");
    d = stringBuilder.toString();
    stringBuilder.setLength(0);
    stringBuilder.append("*^@K#K");
    stringBuilder.append("@!");
    this.u = stringBuilder.toString();
  }
  
  public StrategyBean(Parcel paramParcel) {
    boolean bool = true;
    this.g = true;
    this.h = true;
    this.i = true;
    this.j = true;
    this.k = false;
    this.l = true;
    this.m = true;
    this.n = true;
    this.o = true;
    this.q = 30000L;
    this.r = b;
    this.s = c;
    this.t = a;
    this.w = 10;
    this.x = 300000L;
    this.y = -1L;
    try {
      boolean bool1;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("S(@L@L");
      stringBuilder.append("@)");
      d = stringBuilder.toString();
      this.f = paramParcel.readLong();
      if (paramParcel.readByte() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.g = bool1;
      if (paramParcel.readByte() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.h = bool1;
      if (paramParcel.readByte() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.i = bool1;
      this.r = paramParcel.readString();
      this.s = paramParcel.readString();
      this.u = paramParcel.readString();
      this.v = z.b(paramParcel);
      if (paramParcel.readByte() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.j = bool1;
      if (paramParcel.readByte() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.k = bool1;
      if (paramParcel.readByte() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.n = bool1;
      if (paramParcel.readByte() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.o = bool1;
      this.q = paramParcel.readLong();
      if (paramParcel.readByte() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.l = bool1;
      if (paramParcel.readByte() == 1) {
        bool1 = bool;
      } else {
        bool1 = false;
      } 
      this.m = bool1;
      this.p = paramParcel.readLong();
      this.w = paramParcel.readInt();
      this.x = paramParcel.readLong();
      this.y = paramParcel.readLong();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeLong(this.f);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeByte((byte)this.h);
    paramParcel.writeByte((byte)this.i);
    paramParcel.writeString(this.r);
    paramParcel.writeString(this.s);
    paramParcel.writeString(this.u);
    z.b(paramParcel, this.v);
    paramParcel.writeByte((byte)this.j);
    paramParcel.writeByte((byte)this.k);
    paramParcel.writeByte((byte)this.n);
    paramParcel.writeByte((byte)this.o);
    paramParcel.writeLong(this.q);
    paramParcel.writeByte((byte)this.l);
    paramParcel.writeByte((byte)this.m);
    paramParcel.writeLong(this.p);
    paramParcel.writeInt(this.w);
    paramParcel.writeLong(this.x);
    paramParcel.writeLong(this.y);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\common\strategy\StrategyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */