package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.zzbm;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.zzf;
import org.chromium.build.BuildHooksAndroid;

public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
  private int zzfsu = 0;
  
  public static PendingIntent zza(Context paramContext, PendingIntent paramPendingIntent, int paramInt) {
    return PendingIntent.getActivity(paramContext, 0, zza(paramContext, paramPendingIntent, paramInt, true), 134217728);
  }
  
  public static Intent zza(Context paramContext, PendingIntent paramPendingIntent, int paramInt, boolean paramBoolean) {
    Intent intent = new Intent(paramContext, GoogleApiActivity.class);
    intent.putExtra("pending_intent", (Parcelable)paramPendingIntent);
    intent.putExtra("failing_client_id", paramInt);
    intent.putExtra("notify_manager", paramBoolean);
    return intent;
  }
  
  public Context createConfigurationContext(Configuration paramConfiguration) {
    if (Build.VERSION.SDK_INT < 17)
      return null; 
    if (!BuildHooksAndroid.isEnabled())
      return super.createConfigurationContext(paramConfiguration); 
    super.createConfigurationContext(paramConfiguration);
    return BuildHooksAndroid.createConfigurationContext$6263c3eb();
  }
  
  public AssetManager getAssets() {
    return !BuildHooksAndroid.isEnabled() ? super.getAssets() : BuildHooksAndroid.getAssets$49f66a90();
  }
  
  public Resources getResources() {
    return !BuildHooksAndroid.isEnabled() ? super.getResources() : BuildHooksAndroid.getResources$177d0c3c();
  }
  
  public Resources.Theme getTheme() {
    return !BuildHooksAndroid.isEnabled() ? super.getTheme() : BuildHooksAndroid.getTheme$21e91261();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    zzbm zzbm;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      boolean bool = getIntent().getBooleanExtra("notify_manager", true);
      this.zzfsu = 0;
      setResult(paramInt2, paramIntent);
      if (bool) {
        zzbm = zzbm.zzck((Context)this);
        switch (paramInt2) {
          case 0:
            zzbm.zza(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
            break;
          case -1:
            zzbm.zzaih();
            break;
        } 
      } 
    } else if (paramInt1 == 2) {
      this.zzfsu = 0;
      setResult(paramInt2, (Intent)zzbm);
    } 
    finish();
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {
    this.zzfsu = 0;
    setResult(0);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (paramBundle != null)
      this.zzfsu = paramBundle.getInt("resolution"); 
    if (this.zzfsu != 1) {
      Dialog dialog;
      Bundle bundle = getIntent().getExtras();
      if (bundle == null) {
        String str = "Activity started without extras";
      } else {
        String str;
        PendingIntent pendingIntent = (PendingIntent)bundle.get("pending_intent");
        Integer integer = (Integer)bundle.get("error_code");
        if (pendingIntent == null && integer == null) {
          str = "Activity started without resolution";
        } else {
          if (str != null) {
            try {
              startIntentSenderForResult(str.getIntentSender(), 1, null, 0, 0, 0);
              this.zzfsu = 1;
              return;
            } catch (android.content.IntentSender.SendIntentException sendIntentException) {
              Log.e("GoogleApiActivity", "Failed to launch pendingIntent", (Throwable)sendIntentException);
            } 
          } else {
            GoogleApiAvailability.getInstance();
            int i = integer.intValue();
            dialog = GoogleApiAvailability.zza((Context)this, i, zzv.zza(this, zzf.zza((Context)this, i, "d"), 2), this);
            if (dialog != null)
              GoogleApiAvailability.zza(this, dialog, "GooglePlayServicesErrorDialog", this); 
            this.zzfsu = 1;
            return;
          } 
          finish();
        } 
      } 
      Log.e("GoogleApiActivity", (String)dialog);
    } else {
      return;
    } 
    finish();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    paramBundle.putInt("resolution", this.zzfsu);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void setTheme(int paramInt) {
    if (!BuildHooksAndroid.isEnabled()) {
      super.setTheme(paramInt);
      return;
    } 
    BuildHooksAndroid.get();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\GoogleApiActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */