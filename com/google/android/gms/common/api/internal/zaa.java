package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class zaa extends ActivityLifecycleObserver {
  private final WeakReference<zaa> zaa;
  
  public zaa(Activity paramActivity) {
    this(zaa.zaa(paramActivity));
  }
  
  private zaa(zaa paramzaa) {
    this.zaa = new WeakReference<zaa>(paramzaa);
  }
  
  public final ActivityLifecycleObserver onStopCallOnce(Runnable paramRunnable) {
    zaa zaa1 = this.zaa.get();
    if (zaa1 != null) {
      zaa.zaa(zaa1, paramRunnable);
      return this;
    } 
    throw new IllegalStateException("The target activity has already been GC'd");
  }
  
  static class zaa extends LifecycleCallback {
    private List<Runnable> zaa = new ArrayList<Runnable>();
    
    private zaa(LifecycleFragment param1LifecycleFragment) {
      super(param1LifecycleFragment);
      this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
    }
    
    private final void zaa(Runnable param1Runnable) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield zaa : Ljava/util/List;
      //   6: aload_1
      //   7: invokeinterface add : (Ljava/lang/Object;)Z
      //   12: pop
      //   13: aload_0
      //   14: monitorexit
      //   15: return
      //   16: astore_1
      //   17: aload_0
      //   18: monitorexit
      //   19: aload_1
      //   20: athrow
      // Exception table:
      //   from	to	target	type
      //   2	13	16	finally
    }
    
    private static zaa zab(Activity param1Activity) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokestatic getFragment : (Landroid/app/Activity;)Lcom/google/android/gms/common/api/internal/LifecycleFragment;
      //   6: astore_3
      //   7: aload_3
      //   8: ldc 'LifecycleObserverOnStop'
      //   10: ldc com/google/android/gms/common/api/internal/zaa$zaa
      //   12: invokeinterface getCallbackOrNull : (Ljava/lang/String;Ljava/lang/Class;)Lcom/google/android/gms/common/api/internal/LifecycleCallback;
      //   17: checkcast com/google/android/gms/common/api/internal/zaa$zaa
      //   20: astore_2
      //   21: aload_2
      //   22: astore_1
      //   23: aload_2
      //   24: ifnonnull -> 36
      //   27: new com/google/android/gms/common/api/internal/zaa$zaa
      //   30: dup
      //   31: aload_3
      //   32: invokespecial <init> : (Lcom/google/android/gms/common/api/internal/LifecycleFragment;)V
      //   35: astore_1
      //   36: aload_0
      //   37: monitorexit
      //   38: aload_1
      //   39: areturn
      //   40: astore_1
      //   41: aload_0
      //   42: monitorexit
      //   43: aload_1
      //   44: athrow
      // Exception table:
      //   from	to	target	type
      //   2	21	40	finally
      //   27	36	40	finally
      //   36	38	40	finally
      //   41	43	40	finally
    }
    
    public void onStop() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield zaa : Ljava/util/List;
      //   6: astore_1
      //   7: aload_0
      //   8: new java/util/ArrayList
      //   11: dup
      //   12: invokespecial <init> : ()V
      //   15: putfield zaa : Ljava/util/List;
      //   18: aload_0
      //   19: monitorexit
      //   20: aload_1
      //   21: invokeinterface iterator : ()Ljava/util/Iterator;
      //   26: astore_1
      //   27: aload_1
      //   28: invokeinterface hasNext : ()Z
      //   33: ifeq -> 53
      //   36: aload_1
      //   37: invokeinterface next : ()Ljava/lang/Object;
      //   42: checkcast java/lang/Runnable
      //   45: invokeinterface run : ()V
      //   50: goto -> 27
      //   53: return
      //   54: astore_1
      //   55: aload_0
      //   56: monitorexit
      //   57: aload_1
      //   58: athrow
      // Exception table:
      //   from	to	target	type
      //   2	20	54	finally
      //   55	57	54	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */