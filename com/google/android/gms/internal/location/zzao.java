package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzbe;

public final class zzao extends zzb implements zzal {
  zzao(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
  }
  
  public final Location zza() throws RemoteException {
    Parcel parcel = zza(7, b_());
    Location location = zzd.<Location>zza(parcel, Location.CREATOR);
    parcel.recycle();
    return location;
  }
  
  public final Location zza(String paramString) throws RemoteException {
    Parcel parcel2 = b_();
    parcel2.writeString(paramString);
    Parcel parcel1 = zza(80, parcel2);
    Location location = zzd.<Location>zza(parcel1, Location.CREATOR);
    parcel1.recycle();
    return location;
  }
  
  public final void zza(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent) throws RemoteException {
    Parcel parcel = b_();
    parcel.writeLong(paramLong);
    zzd.zza(parcel, true);
    zzd.zza(parcel, (Parcelable)paramPendingIntent);
    zzb(5, parcel);
  }
  
  public final void zza(PendingIntent paramPendingIntent) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, (Parcelable)paramPendingIntent);
    zzb(6, parcel);
  }
  
  public final void zza(PendingIntent paramPendingIntent, IStatusCallback paramIStatusCallback) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, (Parcelable)paramPendingIntent);
    zzd.zza(parcel, (IInterface)paramIStatusCallback);
    zzb(73, parcel);
  }
  
  public final void zza(PendingIntent paramPendingIntent, zzaj paramzzaj, String paramString) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, (Parcelable)paramPendingIntent);
    zzd.zza(parcel, paramzzaj);
    parcel.writeString(paramString);
    zzb(2, parcel);
  }
  
  public final void zza(Location paramLocation) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, (Parcelable)paramLocation);
    zzb(13, parcel);
  }
  
  public final void zza(zzai paramzzai) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, paramzzai);
    zzb(67, parcel);
  }
  
  public final void zza(zzbe paramzzbe) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, (Parcelable)paramzzbe);
    zzb(59, parcel);
  }
  
  public final void zza(zzl paramzzl) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, (Parcelable)paramzzl);
    zzb(75, parcel);
  }
  
  public final void zza(ActivityTransitionRequest paramActivityTransitionRequest, PendingIntent paramPendingIntent, IStatusCallback paramIStatusCallback) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, (Parcelable)paramActivityTransitionRequest);
    zzd.zza(parcel, (Parcelable)paramPendingIntent);
    zzd.zza(parcel, (IInterface)paramIStatusCallback);
    zzb(72, parcel);
  }
  
  public final void zza(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, zzaj paramzzaj) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, (Parcelable)paramGeofencingRequest);
    zzd.zza(parcel, (Parcelable)paramPendingIntent);
    zzd.zza(parcel, paramzzaj);
    zzb(57, parcel);
  }
  
  public final void zza(LocationSettingsRequest paramLocationSettingsRequest, zzan paramzzan, String paramString) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, (Parcelable)paramLocationSettingsRequest);
    zzd.zza(parcel, paramzzan);
    parcel.writeString(paramString);
    zzb(63, parcel);
  }
  
  public final void zza(zzbe paramzzbe, zzaj paramzzaj) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, (Parcelable)paramzzbe);
    zzd.zza(parcel, paramzzaj);
    zzb(74, parcel);
  }
  
  public final void zza(boolean paramBoolean) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, paramBoolean);
    zzb(12, parcel);
  }
  
  public final void zza(String[] paramArrayOfString, zzaj paramzzaj, String paramString) throws RemoteException {
    Parcel parcel = b_();
    parcel.writeStringArray(paramArrayOfString);
    zzd.zza(parcel, paramzzaj);
    parcel.writeString(paramString);
    zzb(3, parcel);
  }
  
  public final LocationAvailability zzb(String paramString) throws RemoteException {
    Parcel parcel2 = b_();
    parcel2.writeString(paramString);
    Parcel parcel1 = zza(34, parcel2);
    LocationAvailability locationAvailability = zzd.<LocationAvailability>zza(parcel1, LocationAvailability.CREATOR);
    parcel1.recycle();
    return locationAvailability;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */