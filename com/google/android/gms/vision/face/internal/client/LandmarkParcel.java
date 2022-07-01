package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

@UsedByNative("wrapper.cc")
public final class LandmarkParcel extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzi();
  
  public final int type;
  
  private int versionCode;
  
  public final float x;
  
  public final float y;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public LandmarkParcel(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2) {
    this.versionCode = paramInt1;
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.type = paramInt2;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 1, this.versionCode);
    zzbgo.zza(paramParcel, 2, this.x);
    zzbgo.zza(paramParcel, 3, this.y);
    zzbgo.zzc(paramParcel, 4, this.type);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\face\internal\client\LandmarkParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */