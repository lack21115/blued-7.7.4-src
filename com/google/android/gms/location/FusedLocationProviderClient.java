package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.location.zzac;
import com.google.android.gms.internal.location.zzah;
import com.google.android.gms.internal.location.zzai;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.internal.location.zzbc;
import com.google.android.gms.internal.location.zzbj;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class FusedLocationProviderClient extends GoogleApi<Api.ApiOptions.NoOptions> {
  public static final String KEY_MOCK_LOCATION = "mockLocation";
  
  public static final String KEY_VERTICAL_ACCURACY = "verticalAccuracy";
  
  public FusedLocationProviderClient(Activity paramActivity) {
    super(paramActivity, LocationServices.API, null, (StatusExceptionMapper)new ApiExceptionMapper());
  }
  
  public FusedLocationProviderClient(Context paramContext) {
    super(paramContext, LocationServices.API, null, (StatusExceptionMapper)new ApiExceptionMapper());
  }
  
  private final zzai zza(TaskCompletionSource<Boolean> paramTaskCompletionSource) {
    return (zzai)new zzaf(this, paramTaskCompletionSource);
  }
  
  private final Task<Void> zza(zzbc paramzzbc, LocationCallback paramLocationCallback, Looper paramLooper, zza paramzza) {
    ListenerHolder listenerHolder = ListenerHolders.createListenerHolder(paramLocationCallback, zzbj.zza(paramLooper), LocationCallback.class.getSimpleName());
    zzag zzag = new zzag(this, listenerHolder);
    zzaa zzaa = new zzaa(this, zzag, paramLocationCallback, paramzza, paramzzbc, listenerHolder);
    return doRegisterEventListener(RegistrationMethods.builder().register(zzaa).unregister(zzag).withHolder(listenerHolder).build());
  }
  
  public Task<Void> flushLocations() {
    return doWrite(TaskApiCall.builder().run(zzr.zza).build());
  }
  
  public Task<Location> getCurrentLocation(int paramInt, CancellationToken paramCancellationToken) {
    zzs zzs = new zzs(this, paramCancellationToken, zzbc.zza(null, LocationRequest.create().setPriority(paramInt).setInterval(0L).setFastestInterval(0L).setExpirationDuration(30000L)).zza(true).zza(10000L));
    Task<Location> task2 = doRead(TaskApiCall.builder().run(zzs).setFeatures(new Feature[] { zzp.zzb }).build());
    Task<Location> task1 = task2;
    if (paramCancellationToken != null) {
      TaskCompletionSource taskCompletionSource = new TaskCompletionSource(paramCancellationToken);
      task2.continueWithTask(new zzy(taskCompletionSource));
      task1 = taskCompletionSource.getTask();
    } 
    return task1;
  }
  
  public Task<Location> getLastLocation() {
    return doRead(TaskApiCall.builder().run(new zzq(this)).build());
  }
  
  public Task<LocationAvailability> getLocationAvailability() {
    return doRead(TaskApiCall.builder().run(zzx.zza).build());
  }
  
  public Task<Void> removeLocationUpdates(PendingIntent paramPendingIntent) {
    return doWrite(TaskApiCall.builder().run(new zzac(paramPendingIntent)).build());
  }
  
  public Task<Void> removeLocationUpdates(LocationCallback paramLocationCallback) {
    return TaskUtil.toVoidTaskThatFailsOnFalse(doUnregisterEventListener(ListenerHolders.createListenerKey(paramLocationCallback, LocationCallback.class.getSimpleName())));
  }
  
  public Task<Void> requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent) {
    zzbc zzbc = zzbc.zza(null, paramLocationRequest);
    return doWrite(TaskApiCall.builder().run(new zzz(this, zzbc, paramPendingIntent)).build());
  }
  
  public Task<Void> requestLocationUpdates(LocationRequest paramLocationRequest, LocationCallback paramLocationCallback, Looper paramLooper) {
    return zza(zzbc.zza(null, paramLocationRequest), paramLocationCallback, paramLooper, (zza)null);
  }
  
  public Task<Void> setMockLocation(Location paramLocation) {
    return doWrite(TaskApiCall.builder().run(new zzae(paramLocation)).build());
  }
  
  public Task<Void> setMockMode(boolean paramBoolean) {
    return doWrite(TaskApiCall.builder().run(new zzab(paramBoolean)).build());
  }
  
  static interface zza {
    void zza();
  }
  
  static final class zzb extends zzd {
    private final FusedLocationProviderClient.zza zza;
    
    public zzb(TaskCompletionSource<Void> param1TaskCompletionSource, FusedLocationProviderClient.zza param1zza) {
      super(param1TaskCompletionSource);
      this.zza = param1zza;
    }
    
    public final void a_() {
      this.zza.zza();
    }
  }
  
  static abstract class zzc implements RemoteCall<zzay, TaskCompletionSource<Boolean>> {
    private boolean zza = true;
    
    final void zza(boolean param1Boolean) {
      this.zza = false;
    }
    
    protected final boolean zza() {
      return this.zza;
    }
  }
  
  static class zzd extends zzah {
    private final TaskCompletionSource<Void> zza;
    
    public zzd(TaskCompletionSource<Void> param1TaskCompletionSource) {
      this.zza = param1TaskCompletionSource;
    }
    
    public void a_() {}
    
    public final void zza(zzac param1zzac) {
      TaskUtil.setResultOrApiException(param1zzac.getStatus(), this.zza);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\FusedLocationProviderClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */