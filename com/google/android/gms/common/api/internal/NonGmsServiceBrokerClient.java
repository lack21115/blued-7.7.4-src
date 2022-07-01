package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;

public final class NonGmsServiceBrokerClient implements ServiceConnection, Api.Client {
  private static final String zaa = NonGmsServiceBrokerClient.class.getSimpleName();
  
  private final String zab;
  
  private final String zac;
  
  private final ComponentName zad;
  
  private final Context zae;
  
  private final ConnectionCallbacks zaf;
  
  private final Handler zag;
  
  private final OnConnectionFailedListener zah;
  
  private IBinder zai;
  
  private boolean zaj;
  
  private String zak;
  
  public NonGmsServiceBrokerClient(Context paramContext, Looper paramLooper, ComponentName paramComponentName, ConnectionCallbacks paramConnectionCallbacks, OnConnectionFailedListener paramOnConnectionFailedListener) {
    this(paramContext, paramLooper, null, null, paramComponentName, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private NonGmsServiceBrokerClient(Context paramContext, Looper paramLooper, String paramString1, String paramString2, ComponentName paramComponentName, ConnectionCallbacks paramConnectionCallbacks, OnConnectionFailedListener paramOnConnectionFailedListener) {
    boolean bool1;
    this.zaj = false;
    this.zak = null;
    this.zae = paramContext;
    this.zag = (Handler)new zap(paramLooper);
    this.zaf = paramConnectionCallbacks;
    this.zah = paramOnConnectionFailedListener;
    boolean bool2 = true;
    if (paramString1 != null && paramString2 != null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (paramComponentName == null)
      bool2 = false; 
    if (bool1 ? !bool2 : bool2) {
      this.zab = paramString1;
      this.zac = paramString2;
      this.zad = paramComponentName;
      return;
    } 
    throw new AssertionError("Must specify either package or component, but not both");
  }
  
  public NonGmsServiceBrokerClient(Context paramContext, Looper paramLooper, String paramString1, String paramString2, ConnectionCallbacks paramConnectionCallbacks, OnConnectionFailedListener paramOnConnectionFailedListener) {
    this(paramContext, paramLooper, paramString1, paramString2, null, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private final void zaa(String paramString) {
    String str = String.valueOf(this.zai);
    boolean bool = this.zaj;
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 30 + String.valueOf(str).length());
    stringBuilder.append(paramString);
    stringBuilder.append(" binder: ");
    stringBuilder.append(str);
    stringBuilder.append(", isConnecting: ");
    stringBuilder.append(bool);
  }
  
  private final void zab() {
    if (Thread.currentThread() == this.zag.getLooper().getThread())
      return; 
    throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
  }
  
  public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks) {
    zab();
    zaa("Connect started.");
    if (isConnected())
      try {
        disconnect("connect() called when already connected");
      } catch (Exception exception) {} 
    try {
      Intent intent = new Intent();
      if (this.zad != null) {
        intent.setComponent(this.zad);
      } else {
        intent.setPackage(this.zab).setAction(this.zac);
      } 
      this.zaj = this.zae.bindService(intent, this, GmsClientSupervisor.getDefaultBindFlags());
      if (!this.zaj) {
        this.zai = null;
        this.zah.onConnectionFailed(new ConnectionResult(16));
      } 
      zaa("Finished connect.");
      return;
    } catch (SecurityException securityException) {
      this.zaj = false;
      this.zai = null;
      throw securityException;
    } 
  }
  
  public final void disconnect() {
    zab();
    zaa("Disconnect called.");
    this.zae.unbindService(this);
    this.zaj = false;
    this.zai = null;
  }
  
  public final void disconnect(String paramString) {
    zab();
    this.zak = paramString;
    disconnect();
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final Feature[] getAvailableFeatures() {
    return new Feature[0];
  }
  
  public final IBinder getBinder() {
    zab();
    return this.zai;
  }
  
  public final String getEndpointPackageName() {
    String str = this.zab;
    if (str != null)
      return str; 
    Preconditions.checkNotNull(this.zad);
    return this.zad.getPackageName();
  }
  
  public final String getLastDisconnectMessage() {
    return this.zak;
  }
  
  public final int getMinApkVersion() {
    return 0;
  }
  
  public final void getRemoteService(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet) {}
  
  public final Feature[] getRequiredFeatures() {
    return new Feature[0];
  }
  
  public final Set<Scope> getScopesForConnectionlessNonSignIn() {
    return Collections.emptySet();
  }
  
  public final IBinder getServiceBrokerBinder() {
    return null;
  }
  
  public final Intent getSignInIntent() {
    return new Intent();
  }
  
  public final boolean isConnected() {
    zab();
    return (this.zai != null);
  }
  
  public final boolean isConnecting() {
    zab();
    return this.zaj;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    this.zag.post(new zabq(this, paramIBinder));
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    this.zag.post(new zabp(this));
  }
  
  public final void onUserSignOut(BaseGmsClient.SignOutCallbacks paramSignOutCallbacks) {}
  
  public final boolean providesSignIn() {
    return false;
  }
  
  public final boolean requiresAccount() {
    return false;
  }
  
  public final boolean requiresGooglePlayServices() {
    return false;
  }
  
  public final boolean requiresSignIn() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\NonGmsServiceBrokerClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */