package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

public class GeofencingClient extends GoogleApi<Api.ApiOptions.NoOptions> {
  public GeofencingClient(Activity paramActivity) {
    super(paramActivity, LocationServices.API, null, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public GeofencingClient(Context paramContext) {
    super(paramContext, LocationServices.API, null, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task<Void> addGeofences(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent) {
    return doWrite(TaskApiCall.builder().run(new zzah(paramGeofencingRequest, paramPendingIntent)).build());
  }
  
  public Task<Void> removeGeofences(PendingIntent paramPendingIntent) {
    return doWrite(TaskApiCall.builder().run(new zzaj(paramPendingIntent)).build());
  }
  
  public Task<Void> removeGeofences(List<String> paramList) {
    return doWrite(TaskApiCall.builder().run(new zzai(paramList)).build());
  }
  
  static final class zza implements BaseImplementation.ResultHolder<Status> {
    private final TaskCompletionSource<Void> zza;
    
    public zza(TaskCompletionSource<Void> param1TaskCompletionSource) {
      this.zza = param1TaskCompletionSource;
    }
    
    public final void setFailedResult(Status param1Status) {
      this.zza.setException((Exception)new ApiException(param1Status));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\GeofencingClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */