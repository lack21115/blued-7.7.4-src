package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.base.zap;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zaj implements Handler.Callback {
  @NotOnlyInitialized
  private final zai zaa;
  
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zab = new ArrayList<GoogleApiClient.ConnectionCallbacks>();
  
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zac = new ArrayList<GoogleApiClient.ConnectionCallbacks>();
  
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zad = new ArrayList<GoogleApiClient.OnConnectionFailedListener>();
  
  private volatile boolean zae = false;
  
  private final AtomicInteger zaf = new AtomicInteger(0);
  
  private boolean zag = false;
  
  private final Handler zah;
  
  private final Object zai = new Object();
  
  public zaj(Looper paramLooper, zai paramzai) {
    this.zaa = paramzai;
    this.zah = (Handler)new zap(paramLooper, this);
  }
  
  public final boolean handleMessage(Message paramMessage) {
    if (paramMessage.what == 1) {
      null = (GoogleApiClient.ConnectionCallbacks)paramMessage.obj;
      synchronized (this.zai) {
        if (this.zae && this.zaa.isConnected() && this.zab.contains(null))
          null.onConnected(this.zaa.getConnectionHint()); 
        return true;
      } 
    } 
    int i = paramMessage.what;
    StringBuilder stringBuilder = new StringBuilder(45);
    stringBuilder.append("Don't know how to handle message: ");
    stringBuilder.append(i);
    Log.wtf("GmsClientEvents", stringBuilder.toString(), new Exception());
    return false;
  }
  
  public final void zaa() {
    this.zae = false;
    this.zaf.incrementAndGet();
  }
  
  public final void zaa(int paramInt) {
    Preconditions.checkHandlerThread(this.zah, "onUnintentionalDisconnection must only be called on the Handler thread");
    this.zah.removeMessages(1);
    synchronized (this.zai) {
      this.zag = true;
      ArrayList<GoogleApiClient.ConnectionCallbacks> arrayList = new ArrayList<GoogleApiClient.ConnectionCallbacks>(this.zab);
      int j = this.zaf.get();
      arrayList = arrayList;
      int k = arrayList.size();
      int i = 0;
      while (i < k) {
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks)arrayList.get(i);
        int m = i + 1;
        connectionCallbacks = connectionCallbacks;
        if (this.zae && this.zaf.get() == j) {
          i = m;
          if (this.zab.contains(connectionCallbacks)) {
            connectionCallbacks.onConnectionSuspended(paramInt);
            i = m;
          } 
        } 
      } 
      this.zac.clear();
      this.zag = false;
      return;
    } 
  }
  
  public final void zaa(Bundle paramBundle) {
    Preconditions.checkHandlerThread(this.zah, "onConnectionSuccess must only be called on the Handler thread");
    synchronized (this.zai) {
      boolean bool = this.zag;
      boolean bool1 = true;
      if (!bool) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool);
      this.zah.removeMessages(1);
      this.zag = true;
      if (this.zac.size() == 0) {
        bool = bool1;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool);
      ArrayList<GoogleApiClient.ConnectionCallbacks> arrayList = new ArrayList<GoogleApiClient.ConnectionCallbacks>(this.zab);
      int j = this.zaf.get();
      arrayList = arrayList;
      int k = arrayList.size();
      int i = 0;
      while (i < k) {
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks)arrayList.get(i);
        int m = i + 1;
        connectionCallbacks = connectionCallbacks;
        if (this.zae && this.zaa.isConnected() && this.zaf.get() == j) {
          i = m;
          if (!this.zac.contains(connectionCallbacks)) {
            connectionCallbacks.onConnected(paramBundle);
            i = m;
          } 
        } 
      } 
      this.zac.clear();
      this.zag = false;
      return;
    } 
  }
  
  public final void zaa(ConnectionResult paramConnectionResult) {
    Preconditions.checkHandlerThread(this.zah, "onConnectionFailure must only be called on the Handler thread");
    this.zah.removeMessages(1);
    synchronized (this.zai) {
      ArrayList<GoogleApiClient.OnConnectionFailedListener> arrayList = new ArrayList<GoogleApiClient.OnConnectionFailedListener>(this.zad);
      int j = this.zaf.get();
      arrayList = arrayList;
      int k = arrayList.size();
      int i = 0;
      while (i < k) {
        GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)arrayList.get(i);
        int m = i + 1;
        onConnectionFailedListener = onConnectionFailedListener;
        if (!this.zae || this.zaf.get() != j)
          return; 
        i = m;
        if (this.zad.contains(onConnectionFailedListener)) {
          onConnectionFailedListener.onConnectionFailed(paramConnectionResult);
          i = m;
        } 
      } 
      return;
    } 
  }
  
  public final void zaa(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    Preconditions.checkNotNull(paramConnectionCallbacks);
    synchronized (this.zai) {
      if (this.zab.contains(paramConnectionCallbacks)) {
        String str = String.valueOf(paramConnectionCallbacks);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 62);
        stringBuilder.append("registerConnectionCallbacks(): listener ");
        stringBuilder.append(str);
        stringBuilder.append(" is already registered");
        Log.w("GmsClientEvents", stringBuilder.toString());
      } else {
        this.zab.add(paramConnectionCallbacks);
      } 
      if (this.zaa.isConnected()) {
        null = this.zah;
        null.sendMessage(null.obtainMessage(1, paramConnectionCallbacks));
      } 
      return;
    } 
  }
  
  public final void zaa(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.zai) {
      String str;
      if (this.zad.contains(paramOnConnectionFailedListener)) {
        str = String.valueOf(paramOnConnectionFailedListener);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 67);
        stringBuilder.append("registerConnectionFailedListener(): listener ");
        stringBuilder.append(str);
        stringBuilder.append(" is already registered");
        Log.w("GmsClientEvents", stringBuilder.toString());
      } else {
        this.zad.add(str);
      } 
      return;
    } 
  }
  
  public final void zab() {
    this.zae = true;
  }
  
  public final boolean zab(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    Preconditions.checkNotNull(paramConnectionCallbacks);
    synchronized (this.zai) {
      return this.zab.contains(paramConnectionCallbacks);
    } 
  }
  
  public final boolean zab(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.zai) {
      return this.zad.contains(paramOnConnectionFailedListener);
    } 
  }
  
  public final void zac(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    Preconditions.checkNotNull(paramConnectionCallbacks);
    synchronized (this.zai) {
      String str;
      if (!this.zab.remove(paramConnectionCallbacks)) {
        str = String.valueOf(paramConnectionCallbacks);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 52);
        stringBuilder.append("unregisterConnectionCallbacks(): listener ");
        stringBuilder.append(str);
        stringBuilder.append(" not found");
        Log.w("GmsClientEvents", stringBuilder.toString());
      } else if (this.zag) {
        this.zac.add(str);
      } 
      return;
    } 
  }
  
  public final void zac(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.zai) {
      if (!this.zad.remove(paramOnConnectionFailedListener)) {
        String str = String.valueOf(paramOnConnectionFailedListener);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 57);
        stringBuilder.append("unregisterConnectionFailedListener(): listener ");
        stringBuilder.append(str);
        stringBuilder.append(" not found");
        Log.w("GmsClientEvents", stringBuilder.toString());
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */