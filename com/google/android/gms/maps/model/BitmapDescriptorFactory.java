package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zze;

public final class BitmapDescriptorFactory {
  public static final float HUE_AZURE = 210.0F;
  
  public static final float HUE_BLUE = 240.0F;
  
  public static final float HUE_CYAN = 180.0F;
  
  public static final float HUE_GREEN = 120.0F;
  
  public static final float HUE_MAGENTA = 300.0F;
  
  public static final float HUE_ORANGE = 30.0F;
  
  public static final float HUE_RED = 0.0F;
  
  public static final float HUE_ROSE = 330.0F;
  
  public static final float HUE_VIOLET = 270.0F;
  
  public static final float HUE_YELLOW = 60.0F;
  
  private static zze zzcm;
  
  public static BitmapDescriptor defaultMarker() {
    try {
      return new BitmapDescriptor(zzg().zzi());
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public static BitmapDescriptor defaultMarker(float paramFloat) {
    try {
      return new BitmapDescriptor(zzg().zza(paramFloat));
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public static BitmapDescriptor fromAsset(String paramString) {
    try {
      return new BitmapDescriptor(zzg().zza(paramString));
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public static BitmapDescriptor fromBitmap(Bitmap paramBitmap) {
    try {
      return new BitmapDescriptor(zzg().zza(paramBitmap));
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public static BitmapDescriptor fromFile(String paramString) {
    try {
      return new BitmapDescriptor(zzg().zzb(paramString));
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public static BitmapDescriptor fromPath(String paramString) {
    try {
      return new BitmapDescriptor(zzg().zzc(paramString));
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public static BitmapDescriptor fromResource(int paramInt) {
    try {
      return new BitmapDescriptor(zzg().zza(paramInt));
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
  
  public static void zza(zze paramzze) {
    if (zzcm != null)
      return; 
    zzcm = (zze)Preconditions.checkNotNull(paramzze);
  }
  
  private static zze zzg() {
    return (zze)Preconditions.checkNotNull(zzcm, "IBitmapDescriptorFactory is not initialized");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\BitmapDescriptorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */