package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.GoogleApiManager;

public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
  private int zaa = 0;
  
  public static PendingIntent zaa(Context paramContext, PendingIntent paramPendingIntent, int paramInt) {
    return PendingIntent.getActivity(paramContext, 0, zaa(paramContext, paramPendingIntent, paramInt, true), 134217728);
  }
  
  public static Intent zaa(Context paramContext, PendingIntent paramPendingIntent, int paramInt, boolean paramBoolean) {
    Intent intent = new Intent(paramContext, GoogleApiActivity.class);
    intent.putExtra("pending_intent", (Parcelable)paramPendingIntent);
    intent.putExtra("failing_client_id", paramInt);
    intent.putExtra("notify_manager", paramBoolean);
    return intent;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    GoogleApiManager googleApiManager;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      boolean bool = getIntent().getBooleanExtra("notify_manager", true);
      this.zaa = 0;
      setResult(paramInt2, paramIntent);
      if (bool) {
        googleApiManager = GoogleApiManager.zaa((Context)this);
        if (paramInt2 != -1) {
          if (paramInt2 == 0)
            googleApiManager.zab(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1)); 
        } else {
          googleApiManager.zac();
        } 
      } 
    } else if (paramInt1 == 2) {
      this.zaa = 0;
      setResult(paramInt2, (Intent)googleApiManager);
    } 
    finish();
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {
    this.zaa = 0;
    setResult(0);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (paramBundle != null)
      this.zaa = paramBundle.getInt("resolution"); 
    if (this.zaa != 1) {
      int i;
      Bundle bundle = getIntent().getExtras();
      if (bundle == null) {
        Log.e("GoogleApiActivity", "Activity started without extras");
        finish();
        return;
      } 
      PendingIntent pendingIntent = (PendingIntent)bundle.get("pending_intent");
      Integer integer = (Integer)bundle.get("error_code");
      if (pendingIntent == null && integer == null) {
        Log.e("GoogleApiActivity", "Activity started without resolution");
        finish();
        return;
      } 
      if (pendingIntent != null)
        try {
          startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
          this.zaa = 1;
          return;
        } catch (android.content.IntentSender.SendIntentException sendIntentException) {
          Log.e("GoogleApiActivity", "Failed to launch pendingIntent", (Throwable)sendIntentException);
          finish();
          return;
        }  
      GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
      if (integer == null) {
        i = 8;
      } else {
        i = integer.intValue();
      } 
      googleApiAvailability.showErrorDialogFragment(this, i, 2, this);
      this.zaa = 1;
    } 
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    paramBundle.putInt("resolution", this.zaa);
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\GoogleApiActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */