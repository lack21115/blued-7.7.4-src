package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class Tile extends AbstractSafeParcelable {
  public static final Parcelable.Creator<Tile> CREATOR = new zzr();
  
  public final byte[] data;
  
  public final int height;
  
  public final int width;
  
  public Tile(int paramInt1, int paramInt2, byte[] paramArrayOfbyte) {
    this.width = paramInt1;
    this.height = paramInt2;
    this.data = paramArrayOfbyte;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.width);
    SafeParcelWriter.writeInt(paramParcel, 3, this.height);
    SafeParcelWriter.writeByteArray(paramParcel, 4, this.data, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\Tile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */