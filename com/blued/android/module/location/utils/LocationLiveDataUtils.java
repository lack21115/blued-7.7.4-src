package com.blued.android.module.location.utils;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.module.location.lifecycle.LiveEvent;
import com.blued.android.module.location.model.LocationModel;
import java.util.HashMap;
import java.util.Map;

public class LocationLiveDataUtils {
  private static Map<Integer, LiveEvent<Object>> a = new HashMap<Integer, LiveEvent<Object>>();
  
  public static void a(LifecycleOwner paramLifecycleOwner, Observer<LocationModel> paramObserver) {
    // Byte code:
    //   0: ldc com/blued/android/module/location/utils/LocationLiveDataUtils
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 132
    //   7: aload_0
    //   8: invokeinterface getLifecycle : ()Landroidx/lifecycle/Lifecycle;
    //   13: invokevirtual getCurrentState : ()Landroidx/lifecycle/Lifecycle$State;
    //   16: getstatic androidx/lifecycle/Lifecycle$State.DESTROYED : Landroidx/lifecycle/Lifecycle$State;
    //   19: if_acmpne -> 25
    //   22: goto -> 132
    //   25: aload_0
    //   26: invokevirtual hashCode : ()I
    //   29: istore_2
    //   30: getstatic com/blued/android/module/location/utils/LocationLiveDataUtils.a : Ljava/util/Map;
    //   33: iload_2
    //   34: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   37: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   42: ifne -> 96
    //   45: getstatic com/blued/android/module/location/utils/LocationLiveDataUtils.a : Ljava/util/Map;
    //   48: astore_3
    //   49: new java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial <init> : ()V
    //   56: astore #4
    //   58: aload #4
    //   60: ldc ''
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #4
    //   68: iload_2
    //   69: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_3
    //   74: iload_2
    //   75: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   78: new com/blued/android/module/location/lifecycle/LiveEvent
    //   81: dup
    //   82: aload #4
    //   84: invokevirtual toString : ()Ljava/lang/String;
    //   87: invokespecial <init> : (Ljava/lang/String;)V
    //   90: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: pop
    //   96: getstatic com/blued/android/module/location/utils/LocationLiveDataUtils.a : Ljava/util/Map;
    //   99: iload_2
    //   100: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   103: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   108: checkcast com/blued/android/module/location/lifecycle/LiveEvent
    //   111: astore_3
    //   112: aload_3
    //   113: ifnull -> 122
    //   116: aload_3
    //   117: aload_0
    //   118: aload_1
    //   119: invokevirtual a : (Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V
    //   122: ldc com/blued/android/module/location/utils/LocationLiveDataUtils
    //   124: monitorexit
    //   125: return
    //   126: astore_0
    //   127: ldc com/blued/android/module/location/utils/LocationLiveDataUtils
    //   129: monitorexit
    //   130: aload_0
    //   131: athrow
    //   132: ldc com/blued/android/module/location/utils/LocationLiveDataUtils
    //   134: monitorexit
    //   135: return
    // Exception table:
    //   from	to	target	type
    //   7	22	126	finally
    //   25	96	126	finally
    //   96	112	126	finally
    //   116	122	126	finally
  }
  
  public static void a(LifecycleOwner paramLifecycleOwner, LocationModel paramLocationModel) {
    // Byte code:
    //   0: ldc com/blued/android/module/location/utils/LocationLiveDataUtils
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 78
    //   7: aload_0
    //   8: invokeinterface getLifecycle : ()Landroidx/lifecycle/Lifecycle;
    //   13: invokevirtual getCurrentState : ()Landroidx/lifecycle/Lifecycle$State;
    //   16: getstatic androidx/lifecycle/Lifecycle$State.DESTROYED : Landroidx/lifecycle/Lifecycle$State;
    //   19: if_acmpne -> 25
    //   22: goto -> 78
    //   25: aload_0
    //   26: invokevirtual hashCode : ()I
    //   29: istore_2
    //   30: getstatic com/blued/android/module/location/utils/LocationLiveDataUtils.a : Ljava/util/Map;
    //   33: iload_2
    //   34: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   37: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast com/blued/android/module/location/lifecycle/LiveEvent
    //   45: astore_0
    //   46: aload_0
    //   47: ifnull -> 68
    //   50: getstatic com/blued/android/module/location/utils/LocationLiveDataUtils.a : Ljava/util/Map;
    //   53: iload_2
    //   54: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   57: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual a : (Ljava/lang/Object;)V
    //   68: ldc com/blued/android/module/location/utils/LocationLiveDataUtils
    //   70: monitorexit
    //   71: return
    //   72: astore_0
    //   73: ldc com/blued/android/module/location/utils/LocationLiveDataUtils
    //   75: monitorexit
    //   76: aload_0
    //   77: athrow
    //   78: ldc com/blued/android/module/location/utils/LocationLiveDataUtils
    //   80: monitorexit
    //   81: return
    // Exception table:
    //   from	to	target	type
    //   7	22	72	finally
    //   25	46	72	finally
    //   50	68	72	finally
  }
  
  public static void a(LocationModel paramLocationModel) {
    // Byte code:
    //   0: ldc com/blued/android/module/location/utils/LocationLiveDataUtils
    //   2: monitorenter
    //   3: getstatic com/blued/android/module/location/utils/LocationLiveDataUtils.a : Ljava/util/Map;
    //   6: invokeinterface size : ()I
    //   11: istore_1
    //   12: iload_1
    //   13: ifne -> 20
    //   16: ldc com/blued/android/module/location/utils/LocationLiveDataUtils
    //   18: monitorexit
    //   19: return
    //   20: getstatic com/blued/android/module/location/utils/LocationLiveDataUtils.a : Ljava/util/Map;
    //   23: invokeinterface entrySet : ()Ljava/util/Set;
    //   28: invokeinterface iterator : ()Ljava/util/Iterator;
    //   33: astore_2
    //   34: aload_2
    //   35: invokeinterface hasNext : ()Z
    //   40: ifeq -> 67
    //   43: aload_2
    //   44: invokeinterface next : ()Ljava/lang/Object;
    //   49: checkcast java/util/Map$Entry
    //   52: invokeinterface getValue : ()Ljava/lang/Object;
    //   57: checkcast com/blued/android/module/location/lifecycle/LiveEvent
    //   60: aload_0
    //   61: invokevirtual a : (Ljava/lang/Object;)V
    //   64: goto -> 34
    //   67: getstatic com/blued/android/module/location/utils/LocationLiveDataUtils.a : Ljava/util/Map;
    //   70: invokeinterface clear : ()V
    //   75: ldc com/blued/android/module/location/utils/LocationLiveDataUtils
    //   77: monitorexit
    //   78: return
    //   79: astore_0
    //   80: ldc com/blued/android/module/location/utils/LocationLiveDataUtils
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	79	finally
    //   20	34	79	finally
    //   34	64	79	finally
    //   67	75	79	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\locatio\\utils\LocationLiveDataUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */