package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class SettingsClient extends GoogleApi<Api.ApiOptions.NoOptions> {
  public SettingsClient(Activity paramActivity) {
    super(paramActivity, LocationServices.API, null, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public SettingsClient(Context paramContext) {
    super(paramContext, LocationServices.API, null, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task<LocationSettingsResponse> checkLocationSettings(LocationSettingsRequest paramLocationSettingsRequest) {
    return doRead(TaskApiCall.builder().run(new zzbh(paramLocationSettingsRequest)).build());
  }
  
  static final class zza implements BaseImplementation.ResultHolder<LocationSettingsResult> {
    private final TaskCompletionSource<LocationSettingsResponse> zza;
    
    public zza(TaskCompletionSource<LocationSettingsResponse> param1TaskCompletionSource) {
      this.zza = param1TaskCompletionSource;
    }
    
    public final void setFailedResult(Status param1Status) {
      this.zza.setException((Exception)new ApiException(param1Status));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\SettingsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */