package com.huawei.multimedia.liteav.audiokit.interfaces;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.multimedia.liteav.audioengine.IHwAudioKaraokeFeature;
import com.tencent.liteav.basic.log.TXCLog;

public class HwAudioKaraokeFeatureKit extends AudioFeaturesKit {
  private Context a;
  
  private FeatureKitManager b = null;
  
  private boolean c = false;
  
  private IHwAudioKaraokeFeature d;
  
  private IBinder e = null;
  
  private ServiceConnection f = new ServiceConnection(this) {
      public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "onServiceConnected");
        HwAudioKaraokeFeatureKit.a(this.a, IHwAudioKaraokeFeature.Stub.a(param1IBinder));
        if (HwAudioKaraokeFeatureKit.a(this.a) != null) {
          HwAudioKaraokeFeatureKit.a(this.a, true);
          HwAudioKaraokeFeatureKit.b(this.a).a(1000);
          HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = this.a;
          HwAudioKaraokeFeatureKit.a(hwAudioKaraokeFeatureKit, HwAudioKaraokeFeatureKit.c(hwAudioKaraokeFeatureKit).getPackageName());
          HwAudioKaraokeFeatureKit.a(this.a, param1IBinder);
        } 
      }
      
      public void onServiceDisconnected(ComponentName param1ComponentName) {
        TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "onServiceDisconnected");
        HwAudioKaraokeFeatureKit.a(this.a, false);
        if (HwAudioKaraokeFeatureKit.b(this.a) != null)
          HwAudioKaraokeFeatureKit.b(this.a).a(1001); 
      }
    };
  
  private IBinder.DeathRecipient g = new IBinder.DeathRecipient(this) {
      public void binderDied() {
        TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "binderDied");
        HwAudioKaraokeFeatureKit.e(this.a).unlinkToDeath(HwAudioKaraokeFeatureKit.d(this.a), 0);
        HwAudioKaraokeFeatureKit.b(this.a).a(1003);
        HwAudioKaraokeFeatureKit.b(this.a, null);
      }
    };
  
  protected HwAudioKaraokeFeatureKit(Context paramContext) {
    this.b = FeatureKitManager.a();
    this.a = paramContext;
  }
  
  private void a(IBinder paramIBinder) {
    this.e = paramIBinder;
    if (paramIBinder != null)
      try {
        paramIBinder.linkToDeath(this.g, 0);
        return;
      } catch (RemoteException remoteException) {
        this.b.a(1002);
        TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "serviceLinkToDeath, RemoteException");
      }  
  }
  
  private void a(String paramString) {
    try {
      if (this.d != null && this.c) {
        this.d.a(paramString);
        return;
      } 
    } catch (RemoteException remoteException) {
      TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "isFeatureSupported,RemoteException ex : %s", new Object[] { remoteException.getMessage() });
    } 
  }
  
  private void b(Context paramContext) {
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "bindService");
    FeatureKitManager featureKitManager = this.b;
    if (featureKitManager != null && !this.c)
      featureKitManager.a(paramContext, this.f, "com.huawei.multimedia.audioengine.HwAudioKaraokeFeatureService"); 
  }
  
  public int a(ParameName paramParameName, int paramInt) {
    if (paramParameName == null)
      return 1807; 
    try {
      TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "parame.getParameName() = %s, parameValue = %d", new Object[] { paramParameName.a(), Integer.valueOf(paramInt) });
      if (this.d != null && this.c)
        return this.d.a(paramParameName.a(), paramInt); 
    } catch (RemoteException remoteException) {
      TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "setParameter,RemoteException ex : %s", new Object[] { remoteException.getMessage() });
    } 
    return -2;
  }
  
  public int a(boolean paramBoolean) {
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "enableKaraokeFeature, enable = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    try {
      if (this.d != null && this.c)
        return this.d.a(paramBoolean); 
    } catch (RemoteException remoteException) {
      TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "enableKaraokeFeature,RemoteException ex : %s", new Object[] { remoteException.getMessage() });
    } 
    return -2;
  }
  
  public void a() {
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "destroy, mIsServiceConnected = %b", new Object[] { Boolean.valueOf(this.c) });
    if (this.c) {
      this.c = false;
      this.b.a(this.a, this.f);
    } 
  }
  
  protected void a(Context paramContext) {
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "initialize");
    if (paramContext == null) {
      TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "initialize, context is null");
      return;
    } 
    if (!this.b.a(paramContext)) {
      this.b.a(2);
      TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "initialize, not install AudioEngine");
      return;
    } 
    b(paramContext);
  }
  
  public enum ParameName {
    a("Karaoke_reverb_mode="),
    b("Karaoke_volume="),
    c("Karaoke_eq_mode=");
    
    private String d;
    
    ParameName(String param1String1) {
      this.d = param1String1;
    }
    
    public String a() {
      return this.d;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\multimedia\liteav\audiokit\interfaces\HwAudioKaraokeFeatureKit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */