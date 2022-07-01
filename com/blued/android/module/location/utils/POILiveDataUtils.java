package com.blued.android.module.location.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.module.location.lifecycle.LiveEvent;
import com.blued.android.module.location.model.POIModel;

public class POILiveDataUtils {
  public static LiveEvent<POIModel> a(LifecycleOwner paramLifecycleOwner, Observer<POIModel> paramObserver) {
    if (paramLifecycleOwner == null || paramLifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLifecycleOwner.hashCode());
    stringBuilder.append("");
    LiveEvent<POIModel> liveEvent = new LiveEvent(stringBuilder.toString());
    liveEvent.a(paramLifecycleOwner, paramObserver);
    return liveEvent;
  }
  
  public static void a(LiveEvent<POIModel> paramLiveEvent, LifecycleOwner paramLifecycleOwner, POIModel paramPOIModel) {
    // Byte code:
    //   0: ldc com/blued/android/module/location/utils/POILiveDataUtils
    //   2: monitorenter
    //   3: aload_1
    //   4: ifnull -> 44
    //   7: aload_1
    //   8: invokeinterface getLifecycle : ()Landroidx/lifecycle/Lifecycle;
    //   13: invokevirtual getCurrentState : ()Landroidx/lifecycle/Lifecycle$State;
    //   16: getstatic androidx/lifecycle/Lifecycle$State.DESTROYED : Landroidx/lifecycle/Lifecycle$State;
    //   19: if_acmpne -> 25
    //   22: goto -> 44
    //   25: aload_0
    //   26: ifnull -> 34
    //   29: aload_0
    //   30: aload_2
    //   31: invokevirtual a : (Ljava/lang/Object;)V
    //   34: ldc com/blued/android/module/location/utils/POILiveDataUtils
    //   36: monitorexit
    //   37: return
    //   38: astore_0
    //   39: ldc com/blued/android/module/location/utils/POILiveDataUtils
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    //   44: ldc com/blued/android/module/location/utils/POILiveDataUtils
    //   46: monitorexit
    //   47: return
    // Exception table:
    //   from	to	target	type
    //   7	22	38	finally
    //   29	34	38	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\locatio\\utils\POILiveDataUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */