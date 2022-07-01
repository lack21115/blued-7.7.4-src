package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class zzbgm {
  public static int zza(Parcel paramParcel, int paramInt) {
    return ((paramInt & 0xFFFF0000) != -65536) ? (paramInt >> 16 & 0xFFFF) : paramParcel.readInt();
  }
  
  public static Parcelable zza(Parcel paramParcel, int paramInt, Parcelable.Creator paramCreator) {
    paramInt = zza(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    Parcelable parcelable = (Parcelable)paramCreator.createFromParcel(paramParcel);
    paramParcel.setDataPosition(i + paramInt);
    return parcelable;
  }
  
  private static void zza(Parcel paramParcel, int paramInt1, int paramInt2) {
    paramInt1 = zza(paramParcel, paramInt1);
    if (paramInt1 == paramInt2)
      return; 
    String str = Integer.toHexString(paramInt1);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 46);
    stringBuilder.append("Expected size ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" got ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" (0x");
    stringBuilder.append(str);
    stringBuilder.append(")");
    throw new zzbgn(stringBuilder.toString(), paramParcel);
  }
  
  public static String[] zzaa(Parcel paramParcel, int paramInt) {
    paramInt = zza(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    String[] arrayOfString = paramParcel.createStringArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfString;
  }
  
  public static void zzaf(Parcel paramParcel, int paramInt) {
    if (paramParcel.dataPosition() == paramInt)
      return; 
    StringBuilder stringBuilder = new StringBuilder(37);
    stringBuilder.append("Overread allowed size end=");
    stringBuilder.append(paramInt);
    throw new zzbgn(stringBuilder.toString(), paramParcel);
  }
  
  public static void zzb(Parcel paramParcel, int paramInt) {
    paramInt = zza(paramParcel, paramInt);
    paramParcel.setDataPosition(paramParcel.dataPosition() + paramInt);
  }
  
  public static Object[] zzb(Parcel paramParcel, int paramInt, Parcelable.Creator paramCreator) {
    paramInt = zza(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    Object[] arrayOfObject = paramParcel.createTypedArray(paramCreator);
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfObject;
  }
  
  public static ArrayList zzc(Parcel paramParcel, int paramInt, Parcelable.Creator paramCreator) {
    paramInt = zza(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ArrayList arrayList = paramParcel.createTypedArrayList(paramCreator);
    paramParcel.setDataPosition(i + paramInt);
    return arrayList;
  }
  
  public static boolean zzc(Parcel paramParcel, int paramInt) {
    zza(paramParcel, paramInt, 4);
    return (paramParcel.readInt() != 0);
  }
  
  public static int zzd(Parcel paramParcel) {
    int j = paramParcel.readInt();
    int k = zza(paramParcel, j);
    int i = paramParcel.dataPosition();
    if ((0xFFFF & j) != 20293) {
      String str = String.valueOf(Integer.toHexString(j));
      if (str.length() != 0) {
        str = "Expected object header. Got 0x".concat(str);
      } else {
        str = new String("Expected object header. Got 0x");
      } 
      throw new zzbgn(str, paramParcel);
    } 
    j = k + i;
    if (j >= i && j <= paramParcel.dataSize())
      return j; 
    StringBuilder stringBuilder = new StringBuilder(54);
    stringBuilder.append("Size read is invalid start=");
    stringBuilder.append(i);
    stringBuilder.append(" end=");
    stringBuilder.append(j);
    throw new zzbgn(stringBuilder.toString(), paramParcel);
  }
  
  public static int zzg(Parcel paramParcel, int paramInt) {
    zza(paramParcel, paramInt, 4);
    return paramParcel.readInt();
  }
  
  public static long zzi(Parcel paramParcel, int paramInt) {
    zza(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }
  
  public static float zzl(Parcel paramParcel, int paramInt) {
    zza(paramParcel, paramInt, 4);
    return paramParcel.readFloat();
  }
  
  public static double zzn(Parcel paramParcel, int paramInt) {
    zza(paramParcel, paramInt, 8);
    return paramParcel.readDouble();
  }
  
  public static String zzq(Parcel paramParcel, int paramInt) {
    paramInt = zza(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    String str = paramParcel.readString();
    paramParcel.setDataPosition(i + paramInt);
    return str;
  }
  
  public static IBinder zzr(Parcel paramParcel, int paramInt) {
    paramInt = zza(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    IBinder iBinder = paramParcel.readStrongBinder();
    paramParcel.setDataPosition(i + paramInt);
    return iBinder;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzbgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */