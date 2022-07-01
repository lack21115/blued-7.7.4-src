package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class e extends a {
  private static Map<String, RemoteCallbackList<IFullScreenVideoAdInteractionListener>> a = Collections.synchronizedMap(new HashMap<String, RemoteCallbackList<IFullScreenVideoAdInteractionListener>>());
  
  private static volatile e b;
  
  public static e a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/e.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/e;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a/e
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/e.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/e;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/multipro/aidl/a/e
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/e.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/e;
    //   25: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a/e
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a/e
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/e.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/e;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/e.a : Ljava/util/Map;
    //   5: ifnull -> 306
    //   8: ldc 'recycleRes'
    //   10: aload_2
    //   11: invokevirtual equals : (Ljava/lang/Object;)Z
    //   14: ifeq -> 33
    //   17: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/e.a : Ljava/util/Map;
    //   20: aload_1
    //   21: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast android/os/RemoteCallbackList
    //   29: astore_1
    //   30: goto -> 46
    //   33: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/e.a : Ljava/util/Map;
    //   36: aload_1
    //   37: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast android/os/RemoteCallbackList
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull -> 306
    //   50: aload_1
    //   51: invokevirtual beginBroadcast : ()I
    //   54: istore #4
    //   56: iconst_0
    //   57: istore_3
    //   58: iload_3
    //   59: iload #4
    //   61: if_icmpge -> 242
    //   64: aload_1
    //   65: iload_3
    //   66: invokevirtual getBroadcastItem : (I)Landroid/os/IInterface;
    //   69: checkcast com/bytedance/sdk/openadsdk/IFullScreenVideoAdInteractionListener
    //   72: astore #5
    //   74: aload #5
    //   76: ifnull -> 314
    //   79: ldc 'onAdShow'
    //   81: aload_2
    //   82: invokevirtual equals : (Ljava/lang/Object;)Z
    //   85: ifeq -> 98
    //   88: aload #5
    //   90: invokeinterface onAdShow : ()V
    //   95: goto -> 314
    //   98: ldc 'onAdClose'
    //   100: aload_2
    //   101: invokevirtual equals : (Ljava/lang/Object;)Z
    //   104: ifeq -> 117
    //   107: aload #5
    //   109: invokeinterface onAdClose : ()V
    //   114: goto -> 314
    //   117: ldc 'onVideoComplete'
    //   119: aload_2
    //   120: invokevirtual equals : (Ljava/lang/Object;)Z
    //   123: ifeq -> 136
    //   126: aload #5
    //   128: invokeinterface onVideoComplete : ()V
    //   133: goto -> 314
    //   136: ldc 'onSkippedVideo'
    //   138: aload_2
    //   139: invokevirtual equals : (Ljava/lang/Object;)Z
    //   142: ifeq -> 155
    //   145: aload #5
    //   147: invokeinterface onSkippedVideo : ()V
    //   152: goto -> 314
    //   155: ldc 'onAdVideoBarClick'
    //   157: aload_2
    //   158: invokevirtual equals : (Ljava/lang/Object;)Z
    //   161: ifeq -> 174
    //   164: aload #5
    //   166: invokeinterface onAdVideoBarClick : ()V
    //   171: goto -> 314
    //   174: ldc 'recycleRes'
    //   176: aload_2
    //   177: invokevirtual equals : (Ljava/lang/Object;)Z
    //   180: ifeq -> 314
    //   183: aload #5
    //   185: invokeinterface onDestroy : ()V
    //   190: goto -> 314
    //   193: astore #5
    //   195: new java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial <init> : ()V
    //   202: astore #6
    //   204: aload #6
    //   206: ldc 'fullScreen2 method '
    //   208: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload #6
    //   214: aload_2
    //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload #6
    //   221: ldc ' throws Exception :'
    //   223: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: ldc 'MultiProcess'
    //   229: aload #6
    //   231: invokevirtual toString : ()Ljava/lang/String;
    //   234: aload #5
    //   236: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   239: goto -> 314
    //   242: aload_1
    //   243: invokevirtual finishBroadcast : ()V
    //   246: ldc 'recycleRes'
    //   248: aload_2
    //   249: invokevirtual equals : (Ljava/lang/Object;)Z
    //   252: ifeq -> 306
    //   255: aload_1
    //   256: invokevirtual kill : ()V
    //   259: goto -> 306
    //   262: astore_1
    //   263: new java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial <init> : ()V
    //   270: astore #5
    //   272: aload #5
    //   274: ldc 'fullScreen1 method '
    //   276: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload #5
    //   282: aload_2
    //   283: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload #5
    //   289: ldc ' throws Exception :'
    //   291: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: ldc 'MultiProcess'
    //   297: aload #5
    //   299: invokevirtual toString : ()Ljava/lang/String;
    //   302: aload_1
    //   303: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   306: aload_0
    //   307: monitorexit
    //   308: return
    //   309: astore_1
    //   310: aload_0
    //   311: monitorexit
    //   312: aload_1
    //   313: athrow
    //   314: iload_3
    //   315: iconst_1
    //   316: iadd
    //   317: istore_3
    //   318: goto -> 58
    // Exception table:
    //   from	to	target	type
    //   2	30	262	finally
    //   33	46	262	finally
    //   50	56	262	finally
    //   64	74	193	finally
    //   79	95	193	finally
    //   98	114	193	finally
    //   117	133	193	finally
    //   136	152	193	finally
    //   155	171	193	finally
    //   174	190	193	finally
    //   195	239	262	finally
    //   242	259	262	finally
    //   263	306	309	finally
  }
  
  public void executeFullVideoCallback(String paramString1, String paramString2) throws RemoteException {
    a(paramString1, paramString2);
  }
  
  public void registerFullVideoListener(String paramString, IFullScreenVideoAdInteractionListener paramIFullScreenVideoAdInteractionListener) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new android/os/RemoteCallbackList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_3
    //   10: aload_3
    //   11: aload_2
    //   12: invokevirtual register : (Landroid/os/IInterface;)Z
    //   15: pop
    //   16: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/e.a : Ljava/util/Map;
    //   19: aload_1
    //   20: aload_3
    //   21: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   26: pop
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	30	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\aidl\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */