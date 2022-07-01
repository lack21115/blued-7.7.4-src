package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class zzbgo {
  public static void zza(Parcel paramParcel, int paramInt, double paramDouble) {
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, float paramFloat) {
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, long paramLong) {
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }
  
  public static void zza(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2, boolean paramBoolean) {
    if (paramParcelable == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt1, 0); 
      return;
    } 
    paramInt1 = zzag(paramParcel, paramInt1);
    paramParcelable.writeToParcel(paramParcel, paramInt2);
    zzah(paramParcel, paramInt1);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, String paramString, boolean paramBoolean) {
    if (paramString == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zzag(paramParcel, paramInt);
    paramParcel.writeString(paramString);
    zzah(paramParcel, paramInt);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static void zza(Parcel paramParcel, Parcelable paramParcelable, int paramInt) {
    int i = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int j = paramParcel.dataPosition();
    paramParcelable.writeToParcel(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    paramParcel.setDataPosition(i);
    paramParcel.writeInt(paramInt - j);
    paramParcel.setDataPosition(paramInt);
  }
  
  public static void zza$2d7953c6(Parcel paramParcel, int paramInt1, Parcelable[] paramArrayOfParcelable, int paramInt2) {
    if (paramArrayOfParcelable == null)
      return; 
    int i = zzag(paramParcel, paramInt1);
    int j = paramArrayOfParcelable.length;
    paramParcel.writeInt(j);
    for (paramInt1 = 0; paramInt1 < j; paramInt1++) {
      Parcelable parcelable = paramArrayOfParcelable[paramInt1];
      if (parcelable == null) {
        paramParcel.writeInt(0);
      } else {
        zza(paramParcel, parcelable, paramInt2);
      } 
    } 
    zzah(paramParcel, i);
  }
  
  public static void zza$41b439c0(Parcel paramParcel, int paramInt, String[] paramArrayOfString) {
    if (paramArrayOfString == null)
      return; 
    paramInt = zzag(paramParcel, paramInt);
    paramParcel.writeStringArray(paramArrayOfString);
    zzah(paramParcel, paramInt);
  }
  
  public static void zza$cdac282(Parcel paramParcel, int paramInt, IBinder paramIBinder) {
    if (paramIBinder == null)
      return; 
    paramInt = zzag(paramParcel, paramInt);
    paramParcel.writeStrongBinder(paramIBinder);
    zzah(paramParcel, paramInt);
  }
  
  public static int zzag(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(paramInt | 0xFFFF0000);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }
  
  public static void zzah(Parcel paramParcel, int paramInt) {
    int i = paramParcel.dataPosition();
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(i - paramInt);
    paramParcel.setDataPosition(i);
  }
  
  private static void zzb(Parcel paramParcel, int paramInt1, int paramInt2) {
    if (paramInt2 >= 65535) {
      paramParcel.writeInt(paramInt1 | 0xFFFF0000);
      paramParcel.writeInt(paramInt2);
      return;
    } 
    paramParcel.writeInt(paramInt1 | paramInt2 << 16);
  }
  
  public static void zzc(Parcel paramParcel, int paramInt1, int paramInt2) {
    zzb(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }
  
  public static void zzc(Parcel paramParcel, int paramInt, List<Parcelable> paramList, boolean paramBoolean) {
    if (paramList == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zzag(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (paramInt = 0; paramInt < j; paramInt++) {
      Parcelable parcelable = paramList.get(paramInt);
      if (parcelable == null) {
        paramParcel.writeInt(0);
      } else {
        zza(paramParcel, parcelable, 0);
      } 
    } 
    zzah(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzbgo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */