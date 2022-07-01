package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class f extends a {
  private static Map<String, RemoteCallbackList<IRewardAdInteractionListener>> a = Collections.synchronizedMap(new HashMap<String, RemoteCallbackList<IRewardAdInteractionListener>>());
  
  private static volatile f b;
  
  public static f a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/f.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/f;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a/f
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/f.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/f;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/multipro/aidl/a/f
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/f.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/f;
    //   25: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a/f
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a/f
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/f.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/f;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/f.a : Ljava/util/Map;
    //   5: ifnull -> 352
    //   8: ldc 'recycleRes'
    //   10: aload_2
    //   11: invokevirtual equals : (Ljava/lang/Object;)Z
    //   14: ifeq -> 33
    //   17: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/f.a : Ljava/util/Map;
    //   20: aload_1
    //   21: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast android/os/RemoteCallbackList
    //   29: astore_1
    //   30: goto -> 46
    //   33: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/f.a : Ljava/util/Map;
    //   36: aload_1
    //   37: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast android/os/RemoteCallbackList
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull -> 352
    //   50: aload_1
    //   51: invokevirtual beginBroadcast : ()I
    //   54: istore #7
    //   56: iconst_0
    //   57: istore #6
    //   59: iload #6
    //   61: iload #7
    //   63: if_icmpge -> 288
    //   66: aload_1
    //   67: iload #6
    //   69: invokevirtual getBroadcastItem : (I)Landroid/os/IInterface;
    //   72: checkcast com/bytedance/sdk/openadsdk/IRewardAdInteractionListener
    //   75: astore #8
    //   77: aload #8
    //   79: ifnull -> 360
    //   82: ldc 'onAdShow'
    //   84: aload_2
    //   85: invokevirtual equals : (Ljava/lang/Object;)Z
    //   88: ifeq -> 101
    //   91: aload #8
    //   93: invokeinterface onAdShow : ()V
    //   98: goto -> 360
    //   101: ldc 'onAdClose'
    //   103: aload_2
    //   104: invokevirtual equals : (Ljava/lang/Object;)Z
    //   107: ifeq -> 120
    //   110: aload #8
    //   112: invokeinterface onAdClose : ()V
    //   117: goto -> 360
    //   120: ldc 'onVideoComplete'
    //   122: aload_2
    //   123: invokevirtual equals : (Ljava/lang/Object;)Z
    //   126: ifeq -> 139
    //   129: aload #8
    //   131: invokeinterface onVideoComplete : ()V
    //   136: goto -> 360
    //   139: ldc 'onVideoError'
    //   141: aload_2
    //   142: invokevirtual equals : (Ljava/lang/Object;)Z
    //   145: ifeq -> 158
    //   148: aload #8
    //   150: invokeinterface onVideoError : ()V
    //   155: goto -> 360
    //   158: ldc 'onAdVideoBarClick'
    //   160: aload_2
    //   161: invokevirtual equals : (Ljava/lang/Object;)Z
    //   164: ifeq -> 177
    //   167: aload #8
    //   169: invokeinterface onAdVideoBarClick : ()V
    //   174: goto -> 360
    //   177: ldc 'onRewardVerify'
    //   179: aload_2
    //   180: invokevirtual equals : (Ljava/lang/Object;)Z
    //   183: ifeq -> 201
    //   186: aload #8
    //   188: iload_3
    //   189: iload #4
    //   191: aload #5
    //   193: invokeinterface onRewardVerify : (ZILjava/lang/String;)V
    //   198: goto -> 360
    //   201: ldc 'onSkippedVideo'
    //   203: aload_2
    //   204: invokevirtual equals : (Ljava/lang/Object;)Z
    //   207: ifeq -> 220
    //   210: aload #8
    //   212: invokeinterface onSkippedVideo : ()V
    //   217: goto -> 360
    //   220: ldc 'recycleRes'
    //   222: aload_2
    //   223: invokevirtual equals : (Ljava/lang/Object;)Z
    //   226: ifeq -> 360
    //   229: aload #8
    //   231: invokeinterface onDestroy : ()V
    //   236: goto -> 360
    //   239: astore #8
    //   241: new java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial <init> : ()V
    //   248: astore #9
    //   250: aload #9
    //   252: ldc 'reward1 ''
    //   254: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload #9
    //   260: aload_2
    //   261: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload #9
    //   267: ldc ''  throws Exception :'
    //   269: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: ldc 'MultiProcess'
    //   275: aload #9
    //   277: invokevirtual toString : ()Ljava/lang/String;
    //   280: aload #8
    //   282: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   285: goto -> 360
    //   288: aload_1
    //   289: invokevirtual finishBroadcast : ()V
    //   292: ldc 'recycleRes'
    //   294: aload_2
    //   295: invokevirtual equals : (Ljava/lang/Object;)Z
    //   298: ifeq -> 352
    //   301: aload_1
    //   302: invokevirtual kill : ()V
    //   305: goto -> 352
    //   308: astore_1
    //   309: new java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial <init> : ()V
    //   316: astore #5
    //   318: aload #5
    //   320: ldc 'reward2 ''
    //   322: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload #5
    //   328: aload_2
    //   329: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload #5
    //   335: ldc ''  throws Exception :'
    //   337: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: ldc 'MultiProcess'
    //   343: aload #5
    //   345: invokevirtual toString : ()Ljava/lang/String;
    //   348: aload_1
    //   349: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   352: aload_0
    //   353: monitorexit
    //   354: return
    //   355: astore_1
    //   356: aload_0
    //   357: monitorexit
    //   358: aload_1
    //   359: athrow
    //   360: iload #6
    //   362: iconst_1
    //   363: iadd
    //   364: istore #6
    //   366: goto -> 59
    // Exception table:
    //   from	to	target	type
    //   2	30	308	finally
    //   33	46	308	finally
    //   50	56	308	finally
    //   66	77	239	finally
    //   82	98	239	finally
    //   101	117	239	finally
    //   120	136	239	finally
    //   139	155	239	finally
    //   158	174	239	finally
    //   177	198	239	finally
    //   201	217	239	finally
    //   220	236	239	finally
    //   241	285	308	finally
    //   288	305	308	finally
    //   309	352	355	finally
  }
  
  public void executeRewardVideoCallback(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3) throws RemoteException {
    a(paramString1, paramString2, paramBoolean, paramInt, paramString3);
  }
  
  public void registerRewardVideoListener(String paramString, IRewardAdInteractionListener paramIRewardAdInteractionListener) throws RemoteException {
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
    //   16: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/f.a : Ljava/util/Map;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\aidl\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */