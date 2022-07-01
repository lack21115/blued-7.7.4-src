package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.concurrent.CountDownLatch;

public class a {
  private static volatile a c;
  
  private Context a;
  
  private IBinderPool b;
  
  private CountDownLatch d;
  
  private final Object e = new Object();
  
  private long f = 0L;
  
  private ServiceConnection g = new ServiceConnection(this) {
      public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        a.a(this.a, IBinderPool.Stub.asInterface(param1IBinder));
        try {
          a.b(this.a).asBinder().linkToDeath(a.a(this.a), 0);
        } catch (RemoteException remoteException) {
          t.c("MultiProcess", "onServiceConnected throws :", (Throwable)remoteException);
        } 
        a.c(this.a).countDown();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onServiceConnected - binderService consume time ：");
        stringBuilder.append(System.currentTimeMillis() - a.d(this.a));
        t.b("MultiProcess", stringBuilder.toString());
      }
      
      public void onServiceDisconnected(ComponentName param1ComponentName) {
        t.c("MultiProcess", "BinderPool......onServiceDisconnected");
      }
    };
  
  private IBinder.DeathRecipient h = new IBinder.DeathRecipient(this) {
      public void binderDied() {
        t.d("MultiProcess", "binder died.");
        a.b(this.a).asBinder().unlinkToDeath(a.a(this.a), 0);
        a.a(this.a, null);
        a.e(this.a);
      }
    };
  
  private a(Context paramContext) {
    this.a = paramContext.getApplicationContext();
    a();
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a.c : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a.c : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/sdk/openadsdk/multipro/aidl/a
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/bytedance/sdk/openadsdk/multipro/aidl/a.c : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a;
    //   26: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a.c : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'MultiProcess'
    //   4: ldc 'BinderPool......connectBinderPoolService'
    //   6: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: new java/util/concurrent/CountDownLatch
    //   13: dup
    //   14: iconst_1
    //   15: invokespecial <init> : (I)V
    //   18: putfield d : Ljava/util/concurrent/CountDownLatch;
    //   21: new android/content/Intent
    //   24: dup
    //   25: aload_0
    //   26: getfield a : Landroid/content/Context;
    //   29: ldc com/bytedance/sdk/openadsdk/multipro/aidl/BinderPoolService
    //   31: invokespecial <init> : (Landroid/content/Context;Ljava/lang/Class;)V
    //   34: astore_1
    //   35: aload_0
    //   36: getfield a : Landroid/content/Context;
    //   39: aload_1
    //   40: aload_0
    //   41: getfield g : Landroid/content/ServiceConnection;
    //   44: iconst_1
    //   45: invokevirtual bindService : (Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   48: pop
    //   49: aload_0
    //   50: invokestatic currentTimeMillis : ()J
    //   53: putfield f : J
    //   56: aload_0
    //   57: getfield d : Ljava/util/concurrent/CountDownLatch;
    //   60: invokevirtual await : ()V
    //   63: goto -> 75
    //   66: astore_1
    //   67: ldc 'MultiProcess'
    //   69: ldc 'connectBinderPoolService throws: '
    //   71: aload_1
    //   72: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   2	56	78	finally
    //   56	63	66	java/lang/InterruptedException
    //   56	63	78	finally
    //   67	75	78	finally
  }
  
  public IBinder a(int paramInt) {
    try {
      if (this.b != null)
        return this.b.queryBinder(paramInt); 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\aidl\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */