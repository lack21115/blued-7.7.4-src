package com.blued.android.framework.qrcode.decoding;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

final class DecodeThread extends Thread {
  private final OnCaptureHandlerListener a;
  
  private final Hashtable<DecodeHintType, Object> b;
  
  private Handler c;
  
  private final CountDownLatch d;
  
  DecodeThread(OnCaptureHandlerListener paramOnCaptureHandlerListener, Vector<BarcodeFormat> paramVector, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield a : Lcom/blued/android/framework/qrcode/decoding/OnCaptureHandlerListener;
    //   9: aload_0
    //   10: new java/util/concurrent/CountDownLatch
    //   13: dup
    //   14: iconst_1
    //   15: invokespecial <init> : (I)V
    //   18: putfield d : Ljava/util/concurrent/CountDownLatch;
    //   21: aload_0
    //   22: new java/util/Hashtable
    //   25: dup
    //   26: iconst_3
    //   27: invokespecial <init> : (I)V
    //   30: putfield b : Ljava/util/Hashtable;
    //   33: aload_2
    //   34: ifnull -> 46
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual isEmpty : ()Z
    //   43: ifeq -> 78
    //   46: new java/util/Vector
    //   49: dup
    //   50: invokespecial <init> : ()V
    //   53: astore_1
    //   54: aload_1
    //   55: getstatic com/blued/android/framework/qrcode/decoding/DecodeFormatManager.b : Ljava/util/Vector;
    //   58: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   61: pop
    //   62: aload_1
    //   63: getstatic com/blued/android/framework/qrcode/decoding/DecodeFormatManager.c : Ljava/util/Vector;
    //   66: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   69: pop
    //   70: aload_1
    //   71: getstatic com/blued/android/framework/qrcode/decoding/DecodeFormatManager.d : Ljava/util/Vector;
    //   74: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   77: pop
    //   78: aload_0
    //   79: getfield b : Ljava/util/Hashtable;
    //   82: getstatic com/google/zxing/DecodeHintType.c : Lcom/google/zxing/DecodeHintType;
    //   85: aload_1
    //   86: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload_3
    //   91: ifnull -> 106
    //   94: aload_0
    //   95: getfield b : Ljava/util/Hashtable;
    //   98: getstatic com/google/zxing/DecodeHintType.e : Lcom/google/zxing/DecodeHintType;
    //   101: aload_3
    //   102: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: return
  }
  
  Handler a() {
    try {
      this.d.await();
    } catch (InterruptedException interruptedException) {}
    return this.c;
  }
  
  public void run() {
    Looper.prepare();
    this.c = new DecodeHandler(this.a, this.b);
    this.d.countDown();
    Looper.loop();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\qrcode\decoding\DecodeThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */