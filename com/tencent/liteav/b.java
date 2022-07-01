package com.tencent.liteav;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class b {
  private static final String a = b.class.getSimpleName();
  
  private int b = 300;
  
  private long c = 0L;
  
  private a d;
  
  private HandlerThread e;
  
  private boolean f = false;
  
  private ByteBuffer g = null;
  
  private Bitmap h = null;
  
  private int i = 0;
  
  private int j = 0;
  
  private WeakReference<b> k = null;
  
  public b(b paramb) {
    this.k = new WeakReference<b>(paramb);
  }
  
  private void b(int paramInt1, int paramInt2) {
    if (paramInt1 > 0) {
      int i;
      if (paramInt1 >= 20) {
        i = 20;
      } else {
        i = paramInt1;
        if (paramInt1 <= 5)
          i = 5; 
      } 
      this.b = 1000 / i;
    } else {
      this.b = 200;
    } 
    long l = paramInt2;
    if (paramInt2 > 0) {
      this.c = System.currentTimeMillis() + l * 1000L;
      return;
    } 
    if (paramInt2 == 0) {
      this.c = System.currentTimeMillis() + 300000L;
      return;
    } 
    this.c = -1L;
  }
  
  private void d() {
    e();
    this.e = new HandlerThread("TXImageCapturer");
    this.e.start();
    this.d = new a(this, this.e.getLooper(), this.b, this.c);
  }
  
  private void e() {
    a a1 = this.d;
    if (a1 != null) {
      a1.removeCallbacksAndMessages(null);
      this.d = null;
    } 
    HandlerThread handlerThread = this.e;
    if (handlerThread != null) {
      handlerThread.quit();
      this.e = null;
    } 
  }
  
  private void f() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore #4
    //   5: iconst_0
    //   6: istore_2
    //   7: aload_0
    //   8: getfield k : Ljava/lang/ref/WeakReference;
    //   11: ifnull -> 283
    //   14: aload_0
    //   15: getfield f : Z
    //   18: ifeq -> 283
    //   21: aload_0
    //   22: getfield k : Ljava/lang/ref/WeakReference;
    //   25: invokevirtual get : ()Ljava/lang/Object;
    //   28: checkcast com/tencent/liteav/b$b
    //   31: astore #6
    //   33: aload #6
    //   35: ifnull -> 283
    //   38: aload_0
    //   39: getfield h : Landroid/graphics/Bitmap;
    //   42: astore #7
    //   44: aload_0
    //   45: getfield g : Ljava/nio/ByteBuffer;
    //   48: astore #5
    //   50: aload #5
    //   52: ifnonnull -> 138
    //   55: aload #7
    //   57: ifnull -> 138
    //   60: aload #7
    //   62: invokevirtual getWidth : ()I
    //   65: istore_1
    //   66: aload #7
    //   68: invokevirtual getHeight : ()I
    //   71: istore_2
    //   72: iload_1
    //   73: iload_2
    //   74: imul
    //   75: iconst_4
    //   76: imul
    //   77: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   80: astore #5
    //   82: aload #7
    //   84: aload #5
    //   86: invokevirtual copyPixelsToBuffer : (Ljava/nio/Buffer;)V
    //   89: aload #5
    //   91: invokevirtual rewind : ()Ljava/nio/Buffer;
    //   94: pop
    //   95: aload_0
    //   96: aload #5
    //   98: putfield g : Ljava/nio/ByteBuffer;
    //   101: iload_2
    //   102: istore_3
    //   103: iload_1
    //   104: istore_2
    //   105: iload_3
    //   106: istore_1
    //   107: goto -> 140
    //   110: iload_2
    //   111: istore_3
    //   112: iload_1
    //   113: istore_2
    //   114: iload_3
    //   115: istore_1
    //   116: goto -> 172
    //   119: iload_2
    //   120: istore_3
    //   121: iload_1
    //   122: istore_2
    //   123: iload_3
    //   124: istore_1
    //   125: goto -> 229
    //   128: iload_1
    //   129: istore_2
    //   130: goto -> 170
    //   133: iload_1
    //   134: istore_2
    //   135: goto -> 227
    //   138: iconst_0
    //   139: istore_1
    //   140: aload #7
    //   142: ifnull -> 283
    //   145: aload #5
    //   147: ifnull -> 283
    //   150: aload #6
    //   152: aload #7
    //   154: aload #5
    //   156: aload_0
    //   157: getfield i : I
    //   160: aload_0
    //   161: getfield j : I
    //   164: invokeinterface a : (Landroid/graphics/Bitmap;Ljava/nio/ByteBuffer;II)V
    //   169: return
    //   170: iconst_0
    //   171: istore_1
    //   172: getstatic com/tencent/liteav/b.a : Ljava/lang/String;
    //   175: astore #5
    //   177: new java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial <init> : ()V
    //   184: astore #6
    //   186: aload #6
    //   188: ldc 'bkgpush: generate bitmap pixel error '
    //   190: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload #6
    //   196: iload_2
    //   197: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload #6
    //   203: ldc '*'
    //   205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload #6
    //   211: iload_1
    //   212: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload #5
    //   218: aload #6
    //   220: invokevirtual toString : ()Ljava/lang/String;
    //   223: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)V
    //   226: return
    //   227: iconst_0
    //   228: istore_1
    //   229: getstatic com/tencent/liteav/b.a : Ljava/lang/String;
    //   232: astore #5
    //   234: new java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial <init> : ()V
    //   241: astore #6
    //   243: aload #6
    //   245: ldc 'bkgpush: generate bitmap pixel exception '
    //   247: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload #6
    //   253: iload_2
    //   254: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload #6
    //   260: ldc '*'
    //   262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload #6
    //   268: iload_1
    //   269: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload #5
    //   275: aload #6
    //   277: invokevirtual toString : ()Ljava/lang/String;
    //   280: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)V
    //   283: return
    //   284: astore #5
    //   286: iload #4
    //   288: istore_2
    //   289: goto -> 227
    //   292: astore #5
    //   294: iload_3
    //   295: istore_2
    //   296: goto -> 170
    //   299: astore #5
    //   301: goto -> 133
    //   304: astore #5
    //   306: goto -> 128
    //   309: astore #5
    //   311: goto -> 119
    //   314: astore #5
    //   316: goto -> 110
    //   319: astore #5
    //   321: goto -> 229
    //   324: astore #5
    //   326: goto -> 172
    // Exception table:
    //   from	to	target	type
    //   7	33	284	java/lang/Exception
    //   7	33	292	java/lang/Error
    //   38	50	284	java/lang/Exception
    //   38	50	292	java/lang/Error
    //   60	66	284	java/lang/Exception
    //   60	66	292	java/lang/Error
    //   66	72	299	java/lang/Exception
    //   66	72	304	java/lang/Error
    //   72	101	309	java/lang/Exception
    //   72	101	314	java/lang/Error
    //   150	169	319	java/lang/Exception
    //   150	169	324	java/lang/Error
  }
  
  public void a(int paramInt1, int paramInt2) {
    if (this.f) {
      TXCLog.w(a, "bkgpush: start background publish return when started");
      return;
    } 
    this.f = true;
    b(paramInt1, paramInt2);
    d();
    a a1 = this.d;
    if (a1 != null)
      a1.sendEmptyMessageDelayed(1001, this.b); 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bkgpush: start background publish with time:");
    stringBuilder.append((this.c - System.currentTimeMillis()) / 1000L);
    stringBuilder.append(", interval:");
    stringBuilder.append(this.b);
    TXCLog.w(str, stringBuilder.toString());
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4) {
    if (this.f) {
      TXCLog.w(a, "bkgpush: start background publish return when started");
      return;
    } 
    Bitmap bitmap = paramBitmap;
    if (paramBitmap == null) {
      try {
        String str2 = a;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("bkgpush: background publish img is empty, add default img ");
        stringBuilder1.append(paramInt3);
        stringBuilder1.append("*");
        stringBuilder1.append(paramInt4);
        TXCLog.w(str2, stringBuilder1.toString());
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        bitmap = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
        colorDrawable.draw(new Canvas(bitmap));
        String str1 = a;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("bkgpush: generate bitmap ");
        stringBuilder2.append(paramInt3);
        stringBuilder2.append("*");
        stringBuilder2.append(paramInt4);
        TXCLog.w(str1, stringBuilder2.toString());
        this.h = bitmap;
      } catch (Exception exception) {
        TXCLog.e(a, "save bitmap failed.", exception);
      } catch (Error error) {
        TXCLog.e(a, "save bitmap failed.", error);
      } 
      this.i = paramInt3;
      this.j = paramInt4;
      a(paramInt1, paramInt2);
      return;
    } 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bkgpush: generate bitmap ");
    stringBuilder.append(paramInt3);
    stringBuilder.append("*");
    stringBuilder.append(paramInt4);
    TXCLog.w(str, stringBuilder.toString());
    this.h = bitmap;
  }
  
  public boolean a() {
    return this.f;
  }
  
  public void b() {
    this.f = false;
    this.g = null;
    this.h = null;
    TXCLog.w(a, "bkgpush: stop background publish");
    e();
  }
  
  class a extends Handler {
    private int b = 300;
    
    private long c = 0L;
    
    public a(b this$0, Looper param1Looper, int param1Int, long param1Long) {
      super(param1Looper);
      this.b = param1Int;
      this.c = param1Long;
      String str = b.c();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("bkgpush:init publish time delay:");
      stringBuilder.append(this.b);
      stringBuilder.append(", end:");
      stringBuilder.append(this.c);
      TXCLog.w(str, stringBuilder.toString());
    }
    
    public void handleMessage(Message param1Message) {
      if (param1Message.what == 1001)
        try {
          b.a(this.a);
          if (this.c < 0L || System.currentTimeMillis() < this.c) {
            sendEmptyMessageDelayed(1001, this.b);
            return;
          } 
          TXCLog.w(b.c(), "bkgpush:stop background publish when timeout");
          if (b.b(this.a) != null && b.c(this.a)) {
            b.b b1 = b.b(this.a).get();
            if (b1 != null)
              b1.a(); 
            b.a(this.a, false);
            return;
          } 
        } catch (Exception exception) {
          String str = b.c();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("publish image failed.");
          stringBuilder.append(exception.getMessage());
          TXCLog.e(str, stringBuilder.toString());
        }  
    }
  }
  
  public static interface b {
    void a();
    
    void a(Bitmap param1Bitmap, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */