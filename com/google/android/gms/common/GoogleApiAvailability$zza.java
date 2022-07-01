package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

@SuppressLint({"HandlerLeak"})
final class GoogleApiAvailability$zza extends Handler {
  private final Context mApplicationContext;
  
  public GoogleApiAvailability$zza(GoogleApiAvailability paramGoogleApiAvailability, Context paramContext) {
    super(looper);
    Looper looper;
    this.mApplicationContext = paramContext.getApplicationContext();
  }
  
  public final void handleMessage(Message paramMessage) {
    if (paramMessage.what != 1) {
      int j = paramMessage.what;
      StringBuilder stringBuilder = new StringBuilder(50);
      stringBuilder.append("Don't know how to handle this message: ");
      stringBuilder.append(j);
      Log.w("GoogleApiAvailability", stringBuilder.toString());
      return;
    } 
    int i = this.zzfqy.isGooglePlayServicesAvailable(this.mApplicationContext);
    if (this.zzfqy.isUserResolvableError(i)) {
      GoogleApiAvailability googleApiAvailability = this.zzfqy;
      Context context = this.mApplicationContext;
      googleApiAvailability.zza$53da80fe(context, i, zzf.zza(context, i, 0, "n"));
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\GoogleApiAvailability$zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */