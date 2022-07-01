package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

@UsedByNative("wrapper.cc")
public class FaceParcel extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzb();
  
  public final float centerX;
  
  public final float centerY;
  
  public final float height;
  
  public final int id;
  
  private int versionCode;
  
  public final float width;
  
  public final float zzlhj;
  
  public final float zzlhk;
  
  public final LandmarkParcel[] zzlhl;
  
  public final float zzlhm;
  
  public final float zzlhn;
  
  public final float zzlho;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public FaceParcel(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, LandmarkParcel[] paramArrayOfLandmarkParcel, float paramFloat7, float paramFloat8, float paramFloat9) {
    this.versionCode = paramInt1;
    this.id = paramInt2;
    this.centerX = paramFloat1;
    this.centerY = paramFloat2;
    this.width = paramFloat3;
    this.height = paramFloat4;
    this.zzlhj = paramFloat5;
    this.zzlhk = paramFloat6;
    this.zzlhl = paramArrayOfLandmarkParcel;
    this.zzlhm = paramFloat7;
    this.zzlhn = paramFloat8;
    this.zzlho = paramFloat9;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 1, this.versionCode);
    zzbgo.zzc(paramParcel, 2, this.id);
    zzbgo.zza(paramParcel, 3, this.centerX);
    zzbgo.zza(paramParcel, 4, this.centerY);
    zzbgo.zza(paramParcel, 5, this.width);
    zzbgo.zza(paramParcel, 6, this.height);
    zzbgo.zza(paramParcel, 7, this.zzlhj);
    zzbgo.zza(paramParcel, 8, this.zzlhk);
    zzbgo.zza$2d7953c6(paramParcel, 9, (Parcelable[])this.zzlhl, paramInt);
    zzbgo.zza(paramParcel, 10, this.zzlhm);
    zzbgo.zza(paramParcel, 11, this.zzlhn);
    zzbgo.zza(paramParcel, 12, this.zzlho);
    zzbgo.zzah(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\face\internal\client\FaceParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */