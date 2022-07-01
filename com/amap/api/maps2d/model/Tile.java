package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class Tile implements Parcelable {
  public static final j CREATOR = new j();
  
  private final int a;
  
  private final int b;
  
  private final int c;
  
  public final byte[] data;
  
  Tile(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfbyte) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.data = paramArrayOfbyte;
  }
  
  public Tile(int paramInt1, int paramInt2, byte[] paramArrayOfbyte) {
    this(1, paramInt1, paramInt2, paramArrayOfbyte);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeByteArray(this.data);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\Tile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */