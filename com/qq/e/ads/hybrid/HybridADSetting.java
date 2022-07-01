package com.qq.e.ads.hybrid;

import android.os.Parcel;
import android.os.Parcelable;

public class HybridADSetting implements Parcelable {
  public static final Parcelable.Creator<HybridADSetting> CREATOR = new Parcelable.Creator<HybridADSetting>() {
      public final HybridADSetting createFromParcel(Parcel param1Parcel) {
        return new HybridADSetting(param1Parcel);
      }
      
      public final HybridADSetting[] newArray(int param1Int) {
        return new HybridADSetting[param1Int];
      }
    };
  
  public static final int TYPE_REWARD_VIDEO = 1;
  
  private int a = 1;
  
  private int b = 44;
  
  private int c = -1;
  
  private int d = -14013133;
  
  private int e = 16;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private int i = -1776153;
  
  private int j = 16;
  
  public HybridADSetting() {}
  
  protected HybridADSetting(Parcel paramParcel) {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
  }
  
  public HybridADSetting backButtonImage(String paramString) {
    this.g = paramString;
    return this;
  }
  
  public HybridADSetting backSeparatorLength(int paramInt) {
    this.j = paramInt;
    return this;
  }
  
  public HybridADSetting closeButtonImage(String paramString) {
    this.h = paramString;
    return this;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getBackButtonImage() {
    return this.g;
  }
  
  public int getBackSeparatorLength() {
    return this.j;
  }
  
  public String getCloseButtonImage() {
    return this.h;
  }
  
  public int getSeparatorColor() {
    return this.i;
  }
  
  public String getTitle() {
    return this.f;
  }
  
  public int getTitleBarColor() {
    return this.c;
  }
  
  public int getTitleBarHeight() {
    return this.b;
  }
  
  public int getTitleColor() {
    return this.d;
  }
  
  public int getTitleSize() {
    return this.e;
  }
  
  public int getType() {
    return this.a;
  }
  
  public HybridADSetting separatorColor(int paramInt) {
    this.i = paramInt;
    return this;
  }
  
  public HybridADSetting title(String paramString) {
    this.f = paramString;
    return this;
  }
  
  public HybridADSetting titleBarColor(int paramInt) {
    this.c = paramInt;
    return this;
  }
  
  public HybridADSetting titleBarHeight(int paramInt) {
    this.b = paramInt;
    return this;
  }
  
  public HybridADSetting titleColor(int paramInt) {
    this.d = paramInt;
    return this;
  }
  
  public HybridADSetting titleSize(int paramInt) {
    this.e = paramInt;
    return this;
  }
  
  public HybridADSetting type(int paramInt) {
    this.a = paramInt;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\hybrid\HybridADSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */