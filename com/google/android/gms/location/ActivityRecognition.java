package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.internal.location.zze;

public class ActivityRecognition {
  public static final Api<Api.ApiOptions.NoOptions> API;
  
  @Deprecated
  public static final ActivityRecognitionApi ActivityRecognitionApi;
  
  public static final String CLIENT_NAME = "activity_recognition";
  
  private static final Api.ClientKey<zzay> zza = new Api.ClientKey();
  
  private static final Api.AbstractClientBuilder<zzay, Api.ApiOptions.NoOptions> zzb = new zza();
  
  static {
    API = new Api("ActivityRecognition.API", zzb, zza);
    ActivityRecognitionApi = (ActivityRecognitionApi)new zze();
  }
  
  public static ActivityRecognitionClient getClient(Activity paramActivity) {
    return new ActivityRecognitionClient(paramActivity);
  }
  
  public static ActivityRecognitionClient getClient(Context paramContext) {
    return new ActivityRecognitionClient(paramContext);
  }
  
  public static abstract class zza<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzay> {
    public zza(GoogleApiClient param1GoogleApiClient) {
      super(ActivityRecognition.API, param1GoogleApiClient);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\ActivityRecognition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */