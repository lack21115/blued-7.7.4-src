package com.huawei.multimedia.liteav.audiokit.interfaces;

import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import com.tencent.liteav.basic.log.TXCLog;

public class FeatureKitManager {
  private static final Object a = new Object();
  
  private static final Object b = new Object();
  
  private static final Object c = new Object();
  
  private static final Object d = new Object();
  
  private static FeatureKitManager e = null;
  
  private IAudioKitCallback f = null;
  
  protected static FeatureKitManager a() {
    synchronized (b) {
      if (e == null)
        e = new FeatureKitManager(); 
      return e;
    } 
  }
  
  protected <T extends AudioFeaturesKit> T a(int paramInt, Context paramContext) {
    TXCLog.i("HwAudioKit.FeatureKitManager", "createFeatureKit, type = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramContext == null)
      return null; 
    if (paramInt != 1) {
      TXCLog.i("HwAudioKit.FeatureKitManager", "createFeatureKit, type error");
      return null;
    } 
    HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = new HwAudioKaraokeFeatureKit(paramContext);
    hwAudioKaraokeFeatureKit.a(paramContext);
    return (T)hwAudioKaraokeFeatureKit;
  }
  
  protected void a(int paramInt) {
    TXCLog.i("HwAudioKit.FeatureKitManager", "onCallBack, result = %d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (a) {
      if (b() != null)
        b().onResult(paramInt); 
      return;
    } 
  }
  
  protected void a(Context paramContext, ServiceConnection paramServiceConnection) {
    // Byte code:
    //   0: ldc 'HwAudioKit.FeatureKitManager'
    //   2: ldc 'unbindService'
    //   4: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   7: getstatic com/huawei/multimedia/liteav/audiokit/interfaces/FeatureKitManager.d : Ljava/lang/Object;
    //   10: astore_3
    //   11: aload_3
    //   12: monitorenter
    //   13: aload_1
    //   14: ifnull -> 22
    //   17: aload_1
    //   18: aload_2
    //   19: invokevirtual unbindService : (Landroid/content/ServiceConnection;)V
    //   22: aload_3
    //   23: monitorexit
    //   24: return
    //   25: astore_1
    //   26: aload_3
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   17	22	25	finally
    //   22	24	25	finally
    //   26	28	25	finally
  }
  
  protected void a(Context paramContext, ServiceConnection paramServiceConnection, String paramString) {
    // Byte code:
    //   0: getstatic com/huawei/multimedia/liteav/audiokit/interfaces/FeatureKitManager.c : Ljava/lang/Object;
    //   3: astore #4
    //   5: aload #4
    //   7: monitorenter
    //   8: aload_1
    //   9: ifnonnull -> 16
    //   12: aload #4
    //   14: monitorexit
    //   15: return
    //   16: new android/content/Intent
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: astore #5
    //   25: aload #5
    //   27: ldc 'com.huawei.multimedia.audioengine'
    //   29: aload_3
    //   30: invokevirtual setClassName : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   33: pop
    //   34: ldc 'HwAudioKit.FeatureKitManager'
    //   36: ldc 'bindService'
    //   38: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_1
    //   42: aload #5
    //   44: aload_2
    //   45: iconst_1
    //   46: invokevirtual bindService : (Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   49: pop
    //   50: goto -> 72
    //   53: astore_1
    //   54: ldc 'HwAudioKit.FeatureKitManager'
    //   56: ldc 'bindService, SecurityException, %s'
    //   58: iconst_1
    //   59: anewarray java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_1
    //   65: invokevirtual getMessage : ()Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload #4
    //   74: monitorexit
    //   75: return
    //   76: astore_1
    //   77: aload #4
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   12	15	76	finally
    //   16	34	76	finally
    //   34	50	53	java/lang/SecurityException
    //   34	50	76	finally
    //   54	72	76	finally
    //   72	75	76	finally
    //   77	80	76	finally
  }
  
  protected void a(IAudioKitCallback paramIAudioKitCallback) {
    this.f = paramIAudioKitCallback;
  }
  
  protected boolean a(Context paramContext) {
    if (paramContext == null)
      return false; 
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager != null)
      try {
        if (packageManager.getPackageInfo("com.huawei.multimedia.audioengine", 0) == null) {
          TXCLog.i("HwAudioKit.FeatureKitManager", "packageInfo is null");
          return false;
        } 
        return true;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        TXCLog.e("HwAudioKit.FeatureKitManager", "isAudioKitSupport ,NameNotFoundException");
        return false;
      }  
    return true;
  }
  
  protected IAudioKitCallback b() {
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\multimedia\liteav\audiokit\interfaces\FeatureKitManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */