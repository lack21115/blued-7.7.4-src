package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.Preconditions;

public class zay extends zal {
  private final ArraySet<ApiKey<?>> zad = new ArraySet();
  
  private final GoogleApiManager zae;
  
  private zay(LifecycleFragment paramLifecycleFragment, GoogleApiManager paramGoogleApiManager) {
    this(paramLifecycleFragment, paramGoogleApiManager, GoogleApiAvailability.getInstance());
  }
  
  private zay(LifecycleFragment paramLifecycleFragment, GoogleApiManager paramGoogleApiManager, GoogleApiAvailability paramGoogleApiAvailability) {
    super(paramLifecycleFragment, paramGoogleApiAvailability);
    this.zae = paramGoogleApiManager;
    this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
  }
  
  public static void zaa(Activity paramActivity, GoogleApiManager paramGoogleApiManager, ApiKey<?> paramApiKey) {
    LifecycleFragment lifecycleFragment = getFragment(paramActivity);
    zay zay2 = lifecycleFragment.<zay>getCallbackOrNull("ConnectionlessLifecycleHelper", zay.class);
    zay zay1 = zay2;
    if (zay2 == null)
      zay1 = new zay(lifecycleFragment, paramGoogleApiManager); 
    Preconditions.checkNotNull(paramApiKey, "ApiKey cannot be null");
    zay1.zad.add(paramApiKey);
    paramGoogleApiManager.zaa(zay1);
  }
  
  private final void zad() {
    if (!this.zad.isEmpty())
      this.zae.zaa(this); 
  }
  
  public void onResume() {
    super.onResume();
    zad();
  }
  
  public void onStart() {
    super.onStart();
    zad();
  }
  
  public void onStop() {
    super.onStop();
    this.zae.zab(this);
  }
  
  protected final void zaa() {
    this.zae.zac();
  }
  
  protected final void zaa(ConnectionResult paramConnectionResult, int paramInt) {
    this.zae.zab(paramConnectionResult, paramInt);
  }
  
  final ArraySet<ApiKey<?>> zac() {
    return this.zad;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */