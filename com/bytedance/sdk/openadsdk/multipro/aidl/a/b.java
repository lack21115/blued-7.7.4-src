package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class b extends a {
  private static Map<String, RemoteCallbackList<ITTAppDownloadListener>> a = Collections.synchronizedMap(new HashMap<String, RemoteCallbackList<ITTAppDownloadListener>>());
  
  private static volatile b b;
  
  public static b a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/b.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/b;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a/b
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/b.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/b;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/multipro/aidl/a/b
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/b.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/b;
    //   25: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/b.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/b;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(RemoteCallbackList<ITTAppDownloadListener> paramRemoteCallbackList) {
    if (paramRemoteCallbackList != null)
      try {
        int i;
        int j = paramRemoteCallbackList.beginBroadcast();
      } finally {
        paramRemoteCallbackList = null;
      }  
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3, String paramString4) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/b.a : Ljava/util/Map;
    //   5: astore #12
    //   7: aload #12
    //   9: ifnonnull -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: ldc 'recycleRes'
    //   17: aload_2
    //   18: invokevirtual equals : (Ljava/lang/Object;)Z
    //   21: ifeq -> 114
    //   24: aload_0
    //   25: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/b.a : Ljava/util/Map;
    //   28: aload_1
    //   29: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   34: checkcast android/os/RemoteCallbackList
    //   37: invokespecial a : (Landroid/os/RemoteCallbackList;)V
    //   40: new java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial <init> : ()V
    //   47: astore #7
    //   49: aload #7
    //   51: ldc 'aidl executeMultiProcessAppDownloadCallBack recycle res, materialMd5:'
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload #7
    //   59: aload_1
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: ldc 'DMLibManager'
    //   66: aload #7
    //   68: invokevirtual toString : ()Ljava/lang/String;
    //   71: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   74: new java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial <init> : ()V
    //   81: astore_1
    //   82: aload_1
    //   83: ldc 'aidl executeMultiProcessAppDownloadCallBack recycle res, mListenerMap sizee:'
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_1
    //   90: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/b.a : Ljava/util/Map;
    //   93: invokeinterface size : ()I
    //   98: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: ldc 'DMLibManager'
    //   104: aload_1
    //   105: invokevirtual toString : ()Ljava/lang/String;
    //   108: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_0
    //   112: monitorexit
    //   113: return
    //   114: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/b.a : Ljava/util/Map;
    //   117: aload_1
    //   118: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   123: checkcast android/os/RemoteCallbackList
    //   126: astore #12
    //   128: aload #12
    //   130: ifnull -> 413
    //   133: aload #12
    //   135: invokevirtual beginBroadcast : ()I
    //   138: istore #10
    //   140: iconst_0
    //   141: istore #9
    //   143: iload #9
    //   145: iload #10
    //   147: if_icmpge -> 361
    //   150: aload #12
    //   152: iload #9
    //   154: invokevirtual getBroadcastItem : (I)Landroid/os/IInterface;
    //   157: checkcast com/bytedance/sdk/openadsdk/ITTAppDownloadListener
    //   160: astore_1
    //   161: aload_1
    //   162: ifnull -> 311
    //   165: ldc 'onIdle'
    //   167: aload_2
    //   168: invokevirtual equals : (Ljava/lang/Object;)Z
    //   171: ifeq -> 183
    //   174: aload_1
    //   175: invokeinterface onIdle : ()V
    //   180: goto -> 311
    //   183: ldc 'onDownloadActive'
    //   185: aload_2
    //   186: invokevirtual equals : (Ljava/lang/Object;)Z
    //   189: ifeq -> 208
    //   192: aload_1
    //   193: lload_3
    //   194: lload #5
    //   196: aload #7
    //   198: aload #8
    //   200: invokeinterface onDownloadActive : (JJLjava/lang/String;Ljava/lang/String;)V
    //   205: goto -> 311
    //   208: ldc 'onDownloadPaused'
    //   210: aload_2
    //   211: invokevirtual equals : (Ljava/lang/Object;)Z
    //   214: ifeq -> 233
    //   217: aload_1
    //   218: lload_3
    //   219: lload #5
    //   221: aload #7
    //   223: aload #8
    //   225: invokeinterface onDownloadPaused : (JJLjava/lang/String;Ljava/lang/String;)V
    //   230: goto -> 311
    //   233: ldc 'onDownloadFailed'
    //   235: aload_2
    //   236: invokevirtual equals : (Ljava/lang/Object;)Z
    //   239: ifeq -> 258
    //   242: aload_1
    //   243: lload_3
    //   244: lload #5
    //   246: aload #7
    //   248: aload #8
    //   250: invokeinterface onDownloadFailed : (JJLjava/lang/String;Ljava/lang/String;)V
    //   255: goto -> 311
    //   258: ldc 'onDownloadFinished'
    //   260: aload_2
    //   261: invokevirtual equals : (Ljava/lang/Object;)Z
    //   264: istore #11
    //   266: iload #11
    //   268: ifeq -> 285
    //   271: aload_1
    //   272: lload_3
    //   273: aload #7
    //   275: aload #8
    //   277: invokeinterface onDownloadFinished : (JLjava/lang/String;Ljava/lang/String;)V
    //   282: goto -> 421
    //   285: ldc 'onInstalled'
    //   287: aload_2
    //   288: invokevirtual equals : (Ljava/lang/Object;)Z
    //   291: ifeq -> 421
    //   294: aload_1
    //   295: aload #7
    //   297: aload #8
    //   299: invokeinterface onInstalled : (Ljava/lang/String;Ljava/lang/String;)V
    //   304: goto -> 421
    //   307: astore_1
    //   308: goto -> 315
    //   311: goto -> 421
    //   314: astore_1
    //   315: new java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial <init> : ()V
    //   322: astore #13
    //   324: aload #13
    //   326: ldc 'AppDownloadListenerManagerImpl MultiProcess1: '
    //   328: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload #13
    //   334: aload_2
    //   335: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload #13
    //   341: ldc ' throws Exception :'
    //   343: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: ldc 'MultiProcess'
    //   349: aload #13
    //   351: invokevirtual toString : ()Ljava/lang/String;
    //   354: aload_1
    //   355: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   358: goto -> 421
    //   361: aload #12
    //   363: invokevirtual finishBroadcast : ()V
    //   366: goto -> 413
    //   369: astore_1
    //   370: new java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial <init> : ()V
    //   377: astore #7
    //   379: aload #7
    //   381: ldc 'AppDownloadListenerManagerImpl MultiProcess2: '
    //   383: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload #7
    //   389: aload_2
    //   390: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload #7
    //   396: ldc ' throws Exception :'
    //   398: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: ldc 'MultiProcess'
    //   404: aload #7
    //   406: invokevirtual toString : ()Ljava/lang/String;
    //   409: aload_1
    //   410: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   413: aload_0
    //   414: monitorexit
    //   415: return
    //   416: astore_1
    //   417: aload_0
    //   418: monitorexit
    //   419: aload_1
    //   420: athrow
    //   421: iload #9
    //   423: iconst_1
    //   424: iadd
    //   425: istore #9
    //   427: goto -> 143
    // Exception table:
    //   from	to	target	type
    //   2	7	369	finally
    //   15	111	369	finally
    //   114	128	369	finally
    //   133	140	369	finally
    //   150	161	314	finally
    //   165	180	314	finally
    //   183	205	314	finally
    //   208	230	314	finally
    //   233	255	314	finally
    //   258	266	314	finally
    //   271	282	307	finally
    //   285	304	307	finally
    //   315	358	369	finally
    //   361	366	369	finally
    //   370	413	416	finally
  }
  
  public void executeAppDownloadCallback(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3, String paramString4) throws RemoteException {
    a(paramString1, paramString2, paramLong1, paramLong2, paramString3, paramString4);
  }
  
  public void registerTTAppDownloadListener(String paramString, ITTAppDownloadListener paramITTAppDownloadListener) throws RemoteException {
    RemoteCallbackList<ITTAppDownloadListener> remoteCallbackList = new RemoteCallbackList();
    remoteCallbackList.register((IInterface)paramITTAppDownloadListener);
    a.put(paramString, remoteCallbackList);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("aidl registerTTAppDownloadListener, materialMd5:");
    stringBuilder2.append(paramString);
    t.e("DMLibManager", stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("aidl registerTTAppDownloadListener, mListenerMap size:");
    stringBuilder1.append(a.size());
    t.e("DMLibManager", stringBuilder1.toString());
  }
  
  public void unregisterTTAppDownloadListener(String paramString, ITTAppDownloadListener paramITTAppDownloadListener) throws RemoteException {
    StringBuilder stringBuilder3;
    Map<String, RemoteCallbackList<ITTAppDownloadListener>> map = a;
    if (map == null) {
      stringBuilder3 = new StringBuilder();
      stringBuilder3.append("aidl unregisterTTAppDownloadListener mListenerMap = null, materialMd5:");
      stringBuilder3.append(paramString);
      t.e("DMLibManager", stringBuilder3.toString());
      return;
    } 
    RemoteCallbackList remoteCallbackList = (RemoteCallbackList)stringBuilder3.remove(paramString);
    if (remoteCallbackList == null) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("aidl unregisterTTAppDownloadListener cbs = null, materialMd5:");
      stringBuilder2.append(paramString);
      t.e("DMLibManager", stringBuilder2.toString());
      return;
    } 
    a((RemoteCallbackList<ITTAppDownloadListener>)stringBuilder2);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("aidl unregisterTTAppDownloadListener, materialMd5:");
    stringBuilder2.append(paramString);
    t.e("DMLibManager", stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("aidl unregisterTTAppDownloadListener, mListenerMap size:");
    stringBuilder1.append(a.size());
    t.e("DMLibManager", stringBuilder1.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\aidl\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */