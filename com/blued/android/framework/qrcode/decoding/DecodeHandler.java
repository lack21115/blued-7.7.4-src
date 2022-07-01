package com.blued.android.framework.qrcode.decoding;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;

final class DecodeHandler extends Handler {
  private static final String a = DecodeHandler.class.getSimpleName();
  
  private final MultiFormatReader b = new MultiFormatReader();
  
  private final OnCaptureHandlerListener c;
  
  DecodeHandler(OnCaptureHandlerListener paramOnCaptureHandlerListener, Hashtable<DecodeHintType, Object> paramHashtable) {
    this.b.a(paramHashtable);
    this.c = paramOnCaptureHandlerListener;
  }
  
  private static void a(PlanarYUVLuminanceSource paramPlanarYUVLuminanceSource, Bundle paramBundle) {
    int[] arrayOfInt = paramPlanarYUVLuminanceSource.f();
    int i = paramPlanarYUVLuminanceSource.g();
    Bitmap bitmap = Bitmap.createBitmap(arrayOfInt, 0, i, i, paramPlanarYUVLuminanceSource.h(), Bitmap.Config.ARGB_8888);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
    paramBundle.putParcelable("barcode_bitmap", (Parcelable)bitmap);
  }
  
  private void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: invokestatic currentTimeMillis : ()J
    //   3: lstore #6
    //   5: aload_1
    //   6: arraylength
    //   7: newarray byte
    //   9: astore #10
    //   11: iconst_0
    //   12: istore #4
    //   14: iload #4
    //   16: iload_3
    //   17: if_icmpge -> 70
    //   20: iconst_0
    //   21: istore #5
    //   23: iload #5
    //   25: iload_2
    //   26: if_icmpge -> 61
    //   29: aload #10
    //   31: iload #5
    //   33: iload_3
    //   34: imul
    //   35: iload_3
    //   36: iadd
    //   37: iload #4
    //   39: isub
    //   40: iconst_1
    //   41: isub
    //   42: aload_1
    //   43: iload #4
    //   45: iload_2
    //   46: imul
    //   47: iload #5
    //   49: iadd
    //   50: baload
    //   51: bastore
    //   52: iload #5
    //   54: iconst_1
    //   55: iadd
    //   56: istore #5
    //   58: goto -> 23
    //   61: iload #4
    //   63: iconst_1
    //   64: iadd
    //   65: istore #4
    //   67: goto -> 14
    //   70: aload_0
    //   71: getfield c : Lcom/blued/android/framework/qrcode/decoding/OnCaptureHandlerListener;
    //   74: invokeinterface b : ()Landroid/graphics/Rect;
    //   79: astore_1
    //   80: iload_3
    //   81: aload_1
    //   82: getfield left : I
    //   85: aload_1
    //   86: invokevirtual width : ()I
    //   89: iadd
    //   90: if_icmplt -> 109
    //   93: iload_2
    //   94: istore #4
    //   96: iload_2
    //   97: aload_1
    //   98: getfield top : I
    //   101: aload_1
    //   102: invokevirtual height : ()I
    //   105: iadd
    //   106: if_icmpge -> 137
    //   109: invokestatic d : ()Landroid/content/Context;
    //   112: ldc 'window'
    //   114: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   117: checkcast android/view/WindowManager
    //   120: invokeinterface getDefaultDisplay : ()Landroid/view/Display;
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual getWidth : ()I
    //   130: istore_3
    //   131: aload_1
    //   132: invokevirtual getHeight : ()I
    //   135: istore #4
    //   137: invokestatic a : ()Lcom/blued/android/framework/qrcode/camera/CameraManager;
    //   140: aload #10
    //   142: iload_3
    //   143: iload #4
    //   145: aload_0
    //   146: getfield c : Lcom/blued/android/framework/qrcode/decoding/OnCaptureHandlerListener;
    //   149: invokeinterface b : ()Landroid/graphics/Rect;
    //   154: invokevirtual a : ([BIILandroid/graphics/Rect;)Lcom/google/zxing/PlanarYUVLuminanceSource;
    //   157: astore #10
    //   159: new com/google/zxing/BinaryBitmap
    //   162: dup
    //   163: new com/google/zxing/common/HybridBinarizer
    //   166: dup
    //   167: aload #10
    //   169: invokespecial <init> : (Lcom/google/zxing/LuminanceSource;)V
    //   172: invokespecial <init> : (Lcom/google/zxing/Binarizer;)V
    //   175: astore_1
    //   176: aload_0
    //   177: getfield b : Lcom/google/zxing/MultiFormatReader;
    //   180: aload_1
    //   181: invokevirtual a : (Lcom/google/zxing/BinaryBitmap;)Lcom/google/zxing/Result;
    //   184: astore_1
    //   185: aload_0
    //   186: getfield b : Lcom/google/zxing/MultiFormatReader;
    //   189: invokevirtual a : ()V
    //   192: goto -> 214
    //   195: astore_1
    //   196: aload_0
    //   197: getfield b : Lcom/google/zxing/MultiFormatReader;
    //   200: invokevirtual a : ()V
    //   203: aload_1
    //   204: athrow
    //   205: aload_0
    //   206: getfield b : Lcom/google/zxing/MultiFormatReader;
    //   209: invokevirtual a : ()V
    //   212: aconst_null
    //   213: astore_1
    //   214: aload_1
    //   215: ifnull -> 329
    //   218: invokestatic currentTimeMillis : ()J
    //   221: lstore #8
    //   223: getstatic com/blued/android/framework/qrcode/decoding/DecodeHandler.a : Ljava/lang/String;
    //   226: astore #11
    //   228: new java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial <init> : ()V
    //   235: astore #12
    //   237: aload #12
    //   239: ldc 'Found barcode ('
    //   241: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload #12
    //   247: lload #8
    //   249: lload #6
    //   251: lsub
    //   252: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload #12
    //   258: ldc ' ms):\\n'
    //   260: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload #12
    //   266: aload_1
    //   267: invokevirtual toString : ()Ljava/lang/String;
    //   270: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload #11
    //   276: aload #12
    //   278: invokevirtual toString : ()Ljava/lang/String;
    //   281: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   284: pop
    //   285: aload_0
    //   286: getfield c : Lcom/blued/android/framework/qrcode/decoding/OnCaptureHandlerListener;
    //   289: invokeinterface aZ_ : ()Landroid/os/Handler;
    //   294: sipush #2002
    //   297: aload_1
    //   298: invokestatic obtain : (Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   301: astore_1
    //   302: new android/os/Bundle
    //   305: dup
    //   306: invokespecial <init> : ()V
    //   309: astore #11
    //   311: aload #10
    //   313: aload #11
    //   315: invokestatic a : (Lcom/google/zxing/PlanarYUVLuminanceSource;Landroid/os/Bundle;)V
    //   318: aload_1
    //   319: aload #11
    //   321: invokevirtual setData : (Landroid/os/Bundle;)V
    //   324: aload_1
    //   325: invokevirtual sendToTarget : ()V
    //   328: return
    //   329: aload_0
    //   330: getfield c : Lcom/blued/android/framework/qrcode/decoding/OnCaptureHandlerListener;
    //   333: invokeinterface aZ_ : ()Landroid/os/Handler;
    //   338: sipush #2001
    //   341: invokestatic obtain : (Landroid/os/Handler;I)Landroid/os/Message;
    //   344: invokevirtual sendToTarget : ()V
    //   347: return
    //   348: astore_1
    //   349: goto -> 205
    // Exception table:
    //   from	to	target	type
    //   176	185	348	com/google/zxing/ReaderException
    //   176	185	195	finally
  }
  
  public void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    if (i != 2000) {
      if (i != 4002)
        return; 
      Looper.myLooper().quit();
      return;
    } 
    a((byte[])paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\qrcode\decoding\DecodeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */