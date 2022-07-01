package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzbe;

public interface zzal extends IInterface {
  @Deprecated
  Location zza() throws RemoteException;
  
  Location zza(String paramString) throws RemoteException;
  
  void zza(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent) throws RemoteException;
  
  void zza(PendingIntent paramPendingIntent) throws RemoteException;
  
  void zza(PendingIntent paramPendingIntent, IStatusCallback paramIStatusCallback) throws RemoteException;
  
  void zza(PendingIntent paramPendingIntent, zzaj paramzzaj, String paramString) throws RemoteException;
  
  void zza(Location paramLocation) throws RemoteException;
  
  void zza(zzai paramzzai) throws RemoteException;
  
  void zza(zzbe paramzzbe) throws RemoteException;
  
  void zza(zzl paramzzl) throws RemoteException;
  
  void zza(ActivityTransitionRequest paramActivityTransitionRequest, PendingIntent paramPendingIntent, IStatusCallback paramIStatusCallback) throws RemoteException;
  
  void zza(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, zzaj paramzzaj) throws RemoteException;
  
  void zza(LocationSettingsRequest paramLocationSettingsRequest, zzan paramzzan, String paramString) throws RemoteException;
  
  void zza(zzbe paramzzbe, zzaj paramzzaj) throws RemoteException;
  
  void zza(boolean paramBoolean) throws RemoteException;
  
  void zza(String[] paramArrayOfString, zzaj paramzzaj, String paramString) throws RemoteException;
  
  LocationAvailability zzb(String paramString) throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */