package com.blued.android.framework.view.SuperToast;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.android.framework.view.SuperToast.utils.BackgroundUtils;
import com.blued.android.framework.view.SuperToast.utils.PaletteUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Style implements Parcelable {
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
      public Style a(Parcel param1Parcel) {
        return new Style(param1Parcel);
      }
      
      public Style[] a(int param1Int) {
        return new Style[param1Int];
      }
    };
  
  public int A;
  
  public int B;
  
  public int C;
  
  public int D;
  
  public int E;
  
  public String F;
  
  public Parcelable G;
  
  public int H;
  
  public int I;
  
  public boolean J;
  
  public int K;
  
  public String a;
  
  public int b;
  
  public int c;
  
  public int d;
  
  public int e;
  
  public int f;
  
  public int g;
  
  public int h;
  
  public int i;
  
  public int j;
  
  public int k;
  
  public String l;
  
  public Parcelable m;
  
  public int n;
  
  protected long o;
  
  protected boolean p;
  
  public int q;
  
  public int r;
  
  public int s;
  
  public int t;
  
  public int u;
  
  public int v;
  
  public int w;
  
  public boolean x;
  
  public boolean y;
  
  public String z;
  
  public Style() {
    this.b = 2750;
    this.c = PaletteUtils.a("9E9E9E");
    this.g = 81;
    this.i = BackgroundUtils.b(64);
    this.j = -2;
    this.k = -2;
    this.n = 2;
    this.q = 0;
    this.r = PaletteUtils.a("FFFFFF");
    this.s = 14;
    this.t = 1;
    this.A = 1;
    this.B = PaletteUtils.a("FFFFFF");
    this.C = 12;
    this.D = PaletteUtils.a("FFFFFF");
    this.K = PaletteUtils.a("FFFFFF");
    this.J = true;
  }
  
  private Style(Parcel paramParcel) {
    boolean bool1;
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readString();
    this.m = paramParcel.readParcelable(getClass().getClassLoader());
    this.n = paramParcel.readInt();
    this.o = paramParcel.readLong();
    byte b = paramParcel.readByte();
    boolean bool2 = true;
    if (b != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.p = bool1;
    this.q = paramParcel.readInt();
    this.r = paramParcel.readInt();
    this.s = paramParcel.readInt();
    this.t = paramParcel.readInt();
    this.u = paramParcel.readInt();
    this.v = paramParcel.readInt();
    this.w = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.x = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.y = bool1;
    this.z = paramParcel.readString();
    this.A = paramParcel.readInt();
    this.B = paramParcel.readInt();
    this.C = paramParcel.readInt();
    this.D = paramParcel.readInt();
    this.E = paramParcel.readInt();
    this.F = paramParcel.readString();
    this.G = paramParcel.readParcelable(getClass().getClassLoader());
    this.H = paramParcel.readInt();
    this.I = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    this.J = bool1;
    this.K = paramParcel.readInt();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeParcelable(this.m, 0);
    paramParcel.writeInt(this.n);
    paramParcel.writeLong(this.o);
    paramParcel.writeByte((byte)this.p);
    paramParcel.writeInt(this.q);
    paramParcel.writeInt(this.r);
    paramParcel.writeInt(this.s);
    paramParcel.writeInt(this.t);
    paramParcel.writeInt(this.u);
    paramParcel.writeInt(this.v);
    paramParcel.writeInt(this.w);
    paramParcel.writeByte((byte)this.x);
    paramParcel.writeByte((byte)this.y);
    paramParcel.writeString(this.z);
    paramParcel.writeInt(this.A);
    paramParcel.writeInt(this.B);
    paramParcel.writeInt(this.C);
    paramParcel.writeInt(this.D);
    paramParcel.writeInt(this.E);
    paramParcel.writeString(this.F);
    paramParcel.writeParcelable(this.G, 0);
    paramParcel.writeInt(this.H);
    paramParcel.writeInt(this.I);
    paramParcel.writeByte((byte)this.J);
    paramParcel.writeInt(this.K);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Animations {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Duration {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Frame {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface GravityStyle {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface IconPosition {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PriorityLevel {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TextSize {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Type {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TypefaceStyle {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\SuperToast\Style.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */