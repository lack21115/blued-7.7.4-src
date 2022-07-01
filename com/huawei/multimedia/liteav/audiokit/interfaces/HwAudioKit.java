package com.huawei.multimedia.liteav.audiokit.interfaces;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.multimedia.liteav.audioengine.IHwAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import java.util.ArrayList;
import java.util.List;

public class HwAudioKit {
  private static final List<Integer> a = new ArrayList<Integer>(0);
  
  private Context b = null;
  
  private IHwAudioEngine c = null;
  
  private boolean d = false;
  
  private FeatureKitManager e = FeatureKitManager.a();
  
  private IBinder f = null;
  
  private ServiceConnection g = new ServiceConnection(this) {
      public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        HwAudioKit.a(this.a, IHwAudioEngine.Stub.a(param1IBinder));
        TXCLog.i("HwAudioKit.HwAudioKit", "onServiceConnected");
        if (HwAudioKit.a(this.a) != null) {
          HwAudioKit.a(this.a, true);
          TXCLog.i("HwAudioKit.HwAudioKit", "onServiceConnected, mIHwAudioEngine is not null");
          HwAudioKit.b(this.a).a(0);
          HwAudioKit hwAudioKit = this.a;
          HwAudioKit.a(hwAudioKit, HwAudioKit.c(hwAudioKit).getPackageName(), "1.0.1");
          HwAudioKit.a(this.a, param1IBinder);
        } 
      }
      
      public void onServiceDisconnected(ComponentName param1ComponentName) {
        TXCLog.i("HwAudioKit.HwAudioKit", "onServiceDisconnected");
        HwAudioKit.a(this.a, (IHwAudioEngine)null);
        HwAudioKit.a(this.a, false);
        HwAudioKit.b(this.a).a(4);
      }
    };
  
  private IBinder.DeathRecipient h = new IBinder.DeathRecipient(this) {
      public void binderDied() {
        HwAudioKit.e(this.a).unlinkToDeath(HwAudioKit.d(this.a), 0);
        HwAudioKit.b(this.a).a(6);
        TXCLog.e("HwAudioKit.HwAudioKit", "service binder died");
        HwAudioKit.b(this.a, null);
      }
    };
  
  public HwAudioKit(Context paramContext, IAudioKitCallback paramIAudioKitCallback) {
    this.e.a(paramIAudioKitCallback);
    this.b = paramContext;
  }
  
  private void a(Context paramContext) {
    TXCLog.i("HwAudioKit.HwAudioKit", "bindService, mIsServiceConnected = %b", new Object[] { Boolean.valueOf(this.d) });
    FeatureKitManager featureKitManager = this.e;
    if (featureKitManager != null && !this.d)
      featureKitManager.a(paramContext, this.g, "com.huawei.multimedia.audioengine.HwAudioEngineService"); 
  }
  
  private void a(IBinder paramIBinder) {
    this.f = paramIBinder;
    try {
      if (this.f != null) {
        this.f.linkToDeath(this.h, 0);
        return;
      } 
    } catch (RemoteException remoteException) {
      this.e.a(5);
      TXCLog.e("HwAudioKit.HwAudioKit", "serviceLinkToDeath, RemoteException");
    } 
  }
  
  private void a(String paramString1, String paramString2) {
    TXCLog.i("HwAudioKit.HwAudioKit", "serviceInit");
    try {
      if (this.c != null && this.d) {
        this.c.a(paramString1, paramString2);
        return;
      } 
    } catch (RemoteException remoteException) {
      TXCLog.e("HwAudioKit.HwAudioKit", "isFeatureSupported,RemoteException ex : %s", new Object[] { remoteException.getMessage() });
    } 
  }
  
  public void a() {
    TXCLog.i("HwAudioKit.HwAudioKit", "initialize");
    Context context = this.b;
    if (context == null) {
      TXCLog.i("HwAudioKit.HwAudioKit", "mContext is null");
      this.e.a(7);
      return;
    } 
    if (!this.e.a(context)) {
      TXCLog.i("HwAudioKit.HwAudioKit", "not install AudioKitEngine");
      this.e.a(2);
      return;
    } 
    a(this.b);
  }
  
  public boolean a(FeatureType paramFeatureType) {
    if (paramFeatureType == null)
      return false; 
    TXCLog.i("HwAudioKit.HwAudioKit", "isFeatureSupported, type = %d", new Object[] { Integer.valueOf(paramFeatureType.a()) });
    try {
      if (this.c != null && this.d)
        return this.c.a(paramFeatureType.a()); 
    } catch (RemoteException remoteException) {
      TXCLog.e("HwAudioKit.HwAudioKit", "isFeatureSupported,RemoteException ex : %s", new Object[] { remoteException.getMessage() });
    } 
    return false;
  }
  
  public <T extends AudioFeaturesKit> T b(FeatureType paramFeatureType) {
    FeatureKitManager featureKitManager = this.e;
    return (featureKitManager != null && paramFeatureType != null) ? featureKitManager.a(paramFeatureType.a(), this.b) : null;
  }
  
  public void b() {
    TXCLog.i("HwAudioKit.HwAudioKit", "destroy, mIsServiceConnected = %b", new Object[] { Boolean.valueOf(this.d) });
    if (this.d) {
      this.d = false;
      this.e.a(this.b, this.g);
    } 
  }
  
  public enum FeatureType {
    a(1);
    
    private int b;
    
    FeatureType(int param1Int1) {
      this.b = param1Int1;
    }
    
    public int a() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\multimedia\liteav\audiokit\interfaces\HwAudioKit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */