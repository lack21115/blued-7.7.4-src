package com.amap.api.maps2d.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class TileOverlayOptions implements Parcelable {
  public static final k CREATOR = new k();
  
  private final int a = 1;
  
  private TileProvider b;
  
  private boolean c = true;
  
  private float d;
  
  private int e = 5120;
  
  private int f = 20480;
  
  private String g = null;
  
  private boolean h = true;
  
  private boolean i = true;
  
  public TileOverlayOptions() {}
  
  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean, float paramFloat) {
    this.c = paramBoolean;
    this.d = paramFloat;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public TileOverlayOptions diskCacheDir(String paramString) {
    this.g = paramString;
    return this;
  }
  
  public TileOverlayOptions diskCacheEnabled(boolean paramBoolean) {
    this.i = paramBoolean;
    return this;
  }
  
  public TileOverlayOptions diskCacheSize(int paramInt) {
    this.f = paramInt * 1024;
    return this;
  }
  
  public String getDiskCacheDir() {
    return this.g;
  }
  
  public boolean getDiskCacheEnabled() {
    return this.i;
  }
  
  public int getDiskCacheSize() {
    return this.f;
  }
  
  public int getMemCacheSize() {
    return this.e;
  }
  
  public boolean getMemoryCacheEnabled() {
    return this.h;
  }
  
  public TileProvider getTileProvider() {
    return this.b;
  }
  
  public float getZIndex() {
    return this.d;
  }
  
  public boolean isVisible() {
    return this.c;
  }
  
  public TileOverlayOptions memCacheSize(int paramInt) {
    this.e = paramInt;
    return this;
  }
  
  public TileOverlayOptions memoryCacheEnabled(boolean paramBoolean) {
    this.h = paramBoolean;
    return this;
  }
  
  public TileOverlayOptions tileProvider(TileProvider paramTileProvider) {
    this.b = paramTileProvider;
    return this;
  }
  
  public TileOverlayOptions visible(boolean paramBoolean) {
    this.c = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.a);
    paramParcel.writeValue(this.b);
    paramParcel.writeByte((byte)this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeByte((byte)this.h);
    paramParcel.writeByte((byte)this.i);
  }
  
  public TileOverlayOptions zIndex(float paramFloat) {
    this.d = paramFloat;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\TileOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */