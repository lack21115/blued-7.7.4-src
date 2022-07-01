package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zai extends zal {
  private final SparseArray<zaa> zad = new SparseArray();
  
  private zai(LifecycleFragment paramLifecycleFragment) {
    super(paramLifecycleFragment);
    this.mLifecycleFragment.addCallback("AutoManageHelper", this);
  }
  
  public static zai zaa(LifecycleActivity paramLifecycleActivity) {
    LifecycleFragment lifecycleFragment = getFragment(paramLifecycleActivity);
    zai zai1 = lifecycleFragment.<zai>getCallbackOrNull("AutoManageHelper", zai.class);
    return (zai1 != null) ? zai1 : new zai(lifecycleFragment);
  }
  
  private final zaa zab(int paramInt) {
    if (this.zad.size() <= paramInt)
      return null; 
    SparseArray<zaa> sparseArray = this.zad;
    return (zaa)sparseArray.get(sparseArray.keyAt(paramInt));
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    int i;
    for (i = 0; i < this.zad.size(); i++) {
      zaa zaa = zab(i);
      if (zaa != null) {
        paramPrintWriter.append(paramString).append("GoogleApiClient #").print(zaa.zaa);
        paramPrintWriter.println(":");
        zaa.zab.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      } 
    } 
  }
  
  public void onStart() {
    super.onStart();
    boolean bool = this.zaa;
    String str = String.valueOf(this.zad);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 14);
    stringBuilder.append("onStart ");
    stringBuilder.append(bool);
    stringBuilder.append(" ");
    stringBuilder.append(str);
    Log.d("AutoManageHelper", stringBuilder.toString());
    if (this.zab.get() == null)
      for (int i = 0; i < this.zad.size(); i++) {
        zaa zaa = zab(i);
        if (zaa != null)
          zaa.zab.connect(); 
      }  
  }
  
  public void onStop() {
    super.onStop();
    for (int i = 0; i < this.zad.size(); i++) {
      zaa zaa = zab(i);
      if (zaa != null)
        zaa.zab.disconnect(); 
    } 
  }
  
  protected final void zaa() {
    for (int i = 0; i < this.zad.size(); i++) {
      zaa zaa = zab(i);
      if (zaa != null)
        zaa.zab.connect(); 
    } 
  }
  
  public final void zaa(int paramInt) {
    zaa zaa = (zaa)this.zad.get(paramInt);
    this.zad.remove(paramInt);
    if (zaa != null) {
      zaa.zab.unregisterConnectionFailedListener(zaa);
      zaa.zab.disconnect();
    } 
  }
  
  public final void zaa(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    Preconditions.checkNotNull(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (this.zad.indexOfKey(paramInt) < 0) {
      bool = true;
    } else {
      bool = false;
    } 
    StringBuilder stringBuilder1 = new StringBuilder(54);
    stringBuilder1.append("Already managing a GoogleApiClient with id ");
    stringBuilder1.append(paramInt);
    Preconditions.checkState(bool, stringBuilder1.toString());
    zak zak = this.zab.get();
    boolean bool = this.zaa;
    String str = String.valueOf(zak);
    StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(str).length() + 49);
    stringBuilder2.append("starting AutoManage for client ");
    stringBuilder2.append(paramInt);
    stringBuilder2.append(" ");
    stringBuilder2.append(bool);
    stringBuilder2.append(" ");
    stringBuilder2.append(str);
    Log.d("AutoManageHelper", stringBuilder2.toString());
    paramOnConnectionFailedListener = new zaa(this, paramInt, paramGoogleApiClient, paramOnConnectionFailedListener);
    paramGoogleApiClient.registerConnectionFailedListener(paramOnConnectionFailedListener);
    this.zad.put(paramInt, paramOnConnectionFailedListener);
    if (this.zaa && zak == null) {
      String str1 = String.valueOf(paramGoogleApiClient);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 11);
      stringBuilder.append("connecting ");
      stringBuilder.append(str1);
      Log.d("AutoManageHelper", stringBuilder.toString());
      paramGoogleApiClient.connect();
    } 
  }
  
  protected final void zaa(ConnectionResult paramConnectionResult, int paramInt) {
    Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
    if (paramInt < 0) {
      Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
      return;
    } 
    zaa zaa = (zaa)this.zad.get(paramInt);
    if (zaa != null) {
      zaa(paramInt);
      GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zaa.zac;
      if (onConnectionFailedListener != null)
        onConnectionFailedListener.onConnectionFailed(paramConnectionResult); 
    } 
  }
  
  final class zaa implements GoogleApiClient.OnConnectionFailedListener {
    public final int zaa;
    
    public final GoogleApiClient zab;
    
    public final GoogleApiClient.OnConnectionFailedListener zac;
    
    public zaa(zai this$0, int param1Int, GoogleApiClient param1GoogleApiClient, GoogleApiClient.OnConnectionFailedListener param1OnConnectionFailedListener) {
      this.zaa = param1Int;
      this.zab = param1GoogleApiClient;
      this.zac = param1OnConnectionFailedListener;
    }
    
    public final void onConnectionFailed(ConnectionResult param1ConnectionResult) {
      String str = String.valueOf(param1ConnectionResult);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 27);
      stringBuilder.append("beginFailureResolution for ");
      stringBuilder.append(str);
      Log.d("AutoManageHelper", stringBuilder.toString());
      this.zad.zab(param1ConnectionResult, this.zaa);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */