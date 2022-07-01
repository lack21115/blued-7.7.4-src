package com.baidu.mobads.f;

import android.os.Handler;

class n implements Runnable {
  n(g paramg, g.c paramc, Handler paramHandler) {}
  
  public void run() {
    // Byte code:
    //   0: ldc com/baidu/mobads/f/g
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield c : Lcom/baidu/mobads/f/g;
    //   7: aload_0
    //   8: getfield a : Lcom/baidu/mobads/f/g$c;
    //   11: aload_0
    //   12: getfield b : Landroid/os/Handler;
    //   15: invokestatic a : (Lcom/baidu/mobads/f/g;Lcom/baidu/mobads/f/g$c;Landroid/os/Handler;)V
    //   18: ldc com/baidu/mobads/f/g
    //   20: monitorexit
    //   21: aload_0
    //   22: getfield c : Lcom/baidu/mobads/f/g;
    //   25: invokestatic g : (Lcom/baidu/mobads/f/g;)Landroid/content/SharedPreferences;
    //   28: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   33: astore_1
    //   34: aload_1
    //   35: ldc 'previousProxyVersion'
    //   37: aload_0
    //   38: getfield c : Lcom/baidu/mobads/f/g;
    //   41: invokevirtual a : ()Ljava/lang/String;
    //   44: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   49: pop
    //   50: getstatic android/os/Build$VERSION.SDK_INT : I
    //   53: bipush #9
    //   55: if_icmplt -> 65
    //   58: aload_1
    //   59: invokeinterface apply : ()V
    //   64: return
    //   65: aload_1
    //   66: invokeinterface commit : ()Z
    //   71: pop
    //   72: return
    //   73: astore_1
    //   74: aload_0
    //   75: getfield c : Lcom/baidu/mobads/f/g;
    //   78: invokestatic e : (Lcom/baidu/mobads/f/g;)Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   81: ldc 'XAdApkLoader'
    //   83: aload_1
    //   84: invokeinterface d : (Ljava/lang/String;Ljava/lang/Throwable;)I
    //   89: pop
    //   90: return
    //   91: astore_1
    //   92: ldc com/baidu/mobads/f/g
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    //   97: astore_1
    //   98: new java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial <init> : ()V
    //   105: astore_2
    //   106: aload_2
    //   107: ldc 'Load APK Failed: '
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_2
    //   114: aload_1
    //   115: invokevirtual toString : ()Ljava/lang/String;
    //   118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_2
    //   123: invokevirtual toString : ()Ljava/lang/String;
    //   126: astore_1
    //   127: aload_0
    //   128: getfield c : Lcom/baidu/mobads/f/g;
    //   131: invokestatic e : (Lcom/baidu/mobads/f/g;)Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   134: ldc 'XAdApkLoader'
    //   136: aload_1
    //   137: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   142: pop
    //   143: aload_0
    //   144: getfield c : Lcom/baidu/mobads/f/g;
    //   147: iconst_0
    //   148: invokestatic c : (Lcom/baidu/mobads/f/g;Z)V
    //   151: aload_0
    //   152: getfield c : Lcom/baidu/mobads/f/g;
    //   155: invokestatic g : (Lcom/baidu/mobads/f/g;)Landroid/content/SharedPreferences;
    //   158: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   163: astore_1
    //   164: aload_1
    //   165: ldc 'previousProxyVersion'
    //   167: aload_0
    //   168: getfield c : Lcom/baidu/mobads/f/g;
    //   171: invokevirtual a : ()Ljava/lang/String;
    //   174: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   179: pop
    //   180: getstatic android/os/Build$VERSION.SDK_INT : I
    //   183: bipush #9
    //   185: if_icmplt -> 195
    //   188: aload_1
    //   189: invokeinterface apply : ()V
    //   194: return
    //   195: aload_1
    //   196: invokeinterface commit : ()Z
    //   201: pop
    //   202: return
    //   203: astore_1
    //   204: aload_0
    //   205: getfield c : Lcom/baidu/mobads/f/g;
    //   208: invokestatic g : (Lcom/baidu/mobads/f/g;)Landroid/content/SharedPreferences;
    //   211: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   216: astore_2
    //   217: aload_2
    //   218: ldc 'previousProxyVersion'
    //   220: aload_0
    //   221: getfield c : Lcom/baidu/mobads/f/g;
    //   224: invokevirtual a : ()Ljava/lang/String;
    //   227: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   232: pop
    //   233: getstatic android/os/Build$VERSION.SDK_INT : I
    //   236: bipush #9
    //   238: if_icmplt -> 250
    //   241: aload_2
    //   242: invokeinterface apply : ()V
    //   247: goto -> 277
    //   250: aload_2
    //   251: invokeinterface commit : ()Z
    //   256: pop
    //   257: goto -> 277
    //   260: astore_2
    //   261: aload_0
    //   262: getfield c : Lcom/baidu/mobads/f/g;
    //   265: invokestatic e : (Lcom/baidu/mobads/f/g;)Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   268: ldc 'XAdApkLoader'
    //   270: aload_2
    //   271: invokeinterface d : (Ljava/lang/String;Ljava/lang/Throwable;)I
    //   276: pop
    //   277: aload_1
    //   278: athrow
    // Exception table:
    //   from	to	target	type
    //   0	3	97	finally
    //   3	21	91	finally
    //   21	64	73	finally
    //   65	72	73	finally
    //   92	95	91	finally
    //   95	97	97	finally
    //   98	151	203	finally
    //   151	194	73	finally
    //   195	202	73	finally
    //   204	247	260	finally
    //   250	257	260	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\f\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */