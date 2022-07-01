package org.chromium.android_webview;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class CleanupReference$LazyHolder$1 extends Handler {
  CleanupReference$LazyHolder$1(Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    // Byte code:
    //   0: ldc 'CleanupReference.LazyHolder.handleMessage'
    //   2: invokestatic begin : (Ljava/lang/String;)V
    //   5: aload_1
    //   6: getfield obj : Ljava/lang/Object;
    //   9: checkcast org/chromium/android_webview/CleanupReference
    //   12: astore_2
    //   13: aload_1
    //   14: getfield what : I
    //   17: tableswitch default -> 135, 1 -> 47, 2 -> 40
    //   40: aload_2
    //   41: invokestatic access$300 : (Lorg/chromium/android_webview/CleanupReference;)V
    //   44: goto -> 81
    //   47: invokestatic access$200 : ()Ljava/util/Set;
    //   50: aload_2
    //   51: invokeinterface add : (Ljava/lang/Object;)Z
    //   56: pop
    //   57: goto -> 81
    //   60: ldc 'CleanupReference'
    //   62: ldc 'Bad message=%d'
    //   64: iconst_1
    //   65: anewarray java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_1
    //   71: getfield what : I
    //   74: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   77: aastore
    //   78: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: invokestatic access$100 : ()Ljava/lang/Object;
    //   84: astore_1
    //   85: aload_1
    //   86: monitorenter
    //   87: invokestatic access$000 : ()Ljava/lang/ref/ReferenceQueue;
    //   90: invokevirtual poll : ()Ljava/lang/ref/Reference;
    //   93: checkcast org/chromium/android_webview/CleanupReference
    //   96: astore_2
    //   97: aload_2
    //   98: ifnull -> 108
    //   101: aload_2
    //   102: invokestatic access$300 : (Lorg/chromium/android_webview/CleanupReference;)V
    //   105: goto -> 87
    //   108: invokestatic access$100 : ()Ljava/lang/Object;
    //   111: invokevirtual notifyAll : ()V
    //   114: aload_1
    //   115: monitorexit
    //   116: ldc 'CleanupReference.LazyHolder.handleMessage'
    //   118: invokestatic end : (Ljava/lang/String;)V
    //   121: return
    //   122: astore_2
    //   123: aload_1
    //   124: monitorexit
    //   125: aload_2
    //   126: athrow
    //   127: astore_1
    //   128: ldc 'CleanupReference.LazyHolder.handleMessage'
    //   130: invokestatic end : (Ljava/lang/String;)V
    //   133: aload_1
    //   134: athrow
    //   135: goto -> 60
    // Exception table:
    //   from	to	target	type
    //   0	40	127	finally
    //   40	44	127	finally
    //   47	57	127	finally
    //   60	81	127	finally
    //   81	87	127	finally
    //   87	97	122	finally
    //   101	105	122	finally
    //   108	116	122	finally
    //   123	125	122	finally
    //   125	127	127	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\CleanupReference$LazyHolder$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */