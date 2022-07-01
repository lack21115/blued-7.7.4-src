package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.StatusCallback;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.zzbe;
import com.google.android.gms.location.zzp;
import java.util.List;
import javax.annotation.Nullable;

public final class zzay extends zzh {
  private final zzap zze;
  
  public zzay(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString) {
    this(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, ClientSettings.createDefault(paramContext));
  }
  
  public zzay(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, @Nullable ClientSettings paramClientSettings) {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, paramClientSettings);
    this.zze = new zzap(paramContext, this.zzd);
  }
  
  public final void disconnect() {
    synchronized (this.zze) {
      boolean bool = isConnected();
      if (bool)
        try {
          this.zze.zzc();
          this.zze.zzd();
        } catch (Exception exception) {
          Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", exception);
        }  
      super.disconnect();
      return;
    } 
  }
  
  public final Location zza(String paramString) throws RemoteException {
    return ArrayUtils.contains((Object[])getAvailableFeatures(), zzp.zza) ? this.zze.zza(paramString) : this.zze.zza();
  }
  
  public final LocationAvailability zza() throws RemoteException {
    return this.zze.zzb();
  }
  
  public final void zza(long paramLong, PendingIntent paramPendingIntent) throws RemoteException {
    boolean bool;
    checkConnected();
    Preconditions.checkNotNull(paramPendingIntent);
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "detectionIntervalMillis must be >= 0");
    ((zzal)getService()).zza(paramLong, true, paramPendingIntent);
  }
  
  public final void zza(PendingIntent paramPendingIntent) throws RemoteException {
    checkConnected();
    Preconditions.checkNotNull(paramPendingIntent);
    ((zzal)getService()).zza(paramPendingIntent);
  }
  
  public final void zza(PendingIntent paramPendingIntent, BaseImplementation.ResultHolder<Status> paramResultHolder) throws RemoteException {
    checkConnected();
    Preconditions.checkNotNull(paramResultHolder, "ResultHolder not provided.");
    StatusCallback statusCallback = new StatusCallback(paramResultHolder);
    ((zzal)getService()).zza(paramPendingIntent, (IStatusCallback)statusCallback);
  }
  
  public final void zza(PendingIntent paramPendingIntent, zzai paramzzai) throws RemoteException {
    this.zze.zza(paramPendingIntent, paramzzai);
  }
  
  public final void zza(Location paramLocation) throws RemoteException {
    this.zze.zza(paramLocation);
  }
  
  public final void zza(ListenerHolder.ListenerKey<LocationListener> paramListenerKey, zzai paramzzai) throws RemoteException {
    this.zze.zza(paramListenerKey, paramzzai);
  }
  
  public final void zza(zzai paramzzai) throws RemoteException {
    this.zze.zza(paramzzai);
  }
  
  public final void zza(zzbc paramzzbc, PendingIntent paramPendingIntent, zzai paramzzai) throws RemoteException {
    this.zze.zza(paramzzbc, paramPendingIntent, paramzzai);
  }
  
  public final void zza(zzbc paramzzbc, ListenerHolder<LocationCallback> paramListenerHolder, zzai paramzzai) throws RemoteException {
    synchronized (this.zze) {
      this.zze.zza(paramzzbc, paramListenerHolder, paramzzai);
      return;
    } 
  }
  
  public final void zza(ActivityTransitionRequest paramActivityTransitionRequest, PendingIntent paramPendingIntent, BaseImplementation.ResultHolder<Status> paramResultHolder) throws RemoteException {
    checkConnected();
    Preconditions.checkNotNull(paramResultHolder, "ResultHolder not provided.");
    StatusCallback statusCallback = new StatusCallback(paramResultHolder);
    ((zzal)getService()).zza(paramActivityTransitionRequest, paramPendingIntent, (IStatusCallback)statusCallback);
  }
  
  public final void zza(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, BaseImplementation.ResultHolder<Status> paramResultHolder) throws RemoteException {
    checkConnected();
    Preconditions.checkNotNull(paramGeofencingRequest, "geofencingRequest can't be null.");
    Preconditions.checkNotNull(paramPendingIntent, "PendingIntent must be specified.");
    Preconditions.checkNotNull(paramResultHolder, "ResultHolder not provided.");
    zzax zzax = new zzax(paramResultHolder);
    ((zzal)getService()).zza(paramGeofencingRequest, paramPendingIntent, zzax);
  }
  
  public final void zza(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent, zzai paramzzai) throws RemoteException {
    this.zze.zza(paramLocationRequest, paramPendingIntent, paramzzai);
  }
  
  public final void zza(LocationRequest paramLocationRequest, ListenerHolder<LocationListener> paramListenerHolder, zzai paramzzai) throws RemoteException {
    synchronized (this.zze) {
      this.zze.zza(paramLocationRequest, paramListenerHolder, paramzzai);
      return;
    } 
  }
  
  public final void zza(LocationSettingsRequest paramLocationSettingsRequest, BaseImplementation.ResultHolder<LocationSettingsResult> paramResultHolder, @Nullable String paramString) throws RemoteException {
    boolean bool1;
    checkConnected();
    boolean bool2 = true;
    if (paramLocationSettingsRequest != null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.checkArgument(bool1, "locationSettingsRequest can't be null nor empty.");
    if (paramResultHolder != null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    Preconditions.checkArgument(bool1, "listener can't be null.");
    zzaz zzaz = new zzaz(paramResultHolder);
    ((zzal)getService()).zza(paramLocationSettingsRequest, zzaz, paramString);
  }
  
  public final void zza(zzbe paramzzbe, BaseImplementation.ResultHolder<Status> paramResultHolder) throws RemoteException {
    checkConnected();
    Preconditions.checkNotNull(paramzzbe, "removeGeofencingRequest can't be null.");
    Preconditions.checkNotNull(paramResultHolder, "ResultHolder not provided.");
    zzba zzba = new zzba(paramResultHolder);
    ((zzal)getService()).zza(paramzzbe, zzba);
  }
  
  public final void zza(List<String> paramList, BaseImplementation.ResultHolder<Status> paramResultHolder) throws RemoteException {
    boolean bool;
    checkConnected();
    if (paramList != null && paramList.size() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "geofenceRequestIds can't be null nor empty.");
    Preconditions.checkNotNull(paramResultHolder, "ResultHolder not provided.");
    String[] arrayOfString = paramList.<String>toArray(new String[0]);
    zzba zzba = new zzba(paramResultHolder);
    ((zzal)getService()).zza(arrayOfString, zzba, getContext().getPackageName());
  }
  
  public final void zza(boolean paramBoolean) throws RemoteException {
    this.zze.zza(paramBoolean);
  }
  
  public final void zzb(PendingIntent paramPendingIntent, BaseImplementation.ResultHolder<Status> paramResultHolder) throws RemoteException {
    checkConnected();
    Preconditions.checkNotNull(paramPendingIntent, "PendingIntent must be specified.");
    Preconditions.checkNotNull(paramResultHolder, "ResultHolder not provided.");
    zzba zzba = new zzba(paramResultHolder);
    ((zzal)getService()).zza(paramPendingIntent, zzba, getContext().getPackageName());
  }
  
  public final void zzb(ListenerHolder.ListenerKey<LocationCallback> paramListenerKey, zzai paramzzai) throws RemoteException {
    this.zze.zzb(paramListenerKey, paramzzai);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */