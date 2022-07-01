package com.qiniu.pili.droid.shortvideo.gl.b;

import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.gl.a.f;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;

public class c implements Runnable {
  private Object a;
  
  private Surface b;
  
  private int c;
  
  private int d;
  
  private f e;
  
  private g f = new g();
  
  private a g;
  
  private volatile boolean h;
  
  private PLDisplayMode i;
  
  private volatile boolean j;
  
  public c(Object paramObject, Surface paramSurface, int paramInt1, int paramInt2, PLDisplayMode paramPLDisplayMode) {
    this.a = paramObject;
    this.b = paramSurface;
    this.c = paramInt1;
    this.d = paramInt2;
    this.i = paramPLDisplayMode;
  }
  
  private void a(b paramb) {
    if (!this.f.k() && paramb.b != 0 && paramb.c != 0) {
      this.f.a(this.c, this.d);
      this.f.a(paramb.b, paramb.c, this.i);
    } 
    synchronized (d.a) {
      if (this.f != null)
        this.f.b(paramb.a); 
      this.e.a(paramb.d);
      this.e.c();
      paramb.e.countDown();
      return;
    } 
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Z
    //   6: ifeq -> 22
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'SurfaceRenderer'
    //   14: ldc 'already started !!!'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: new java/lang/Thread
    //   25: dup
    //   26: aload_0
    //   27: ldc 'SurfaceRenderer'
    //   29: invokespecial <init> : (Ljava/lang/Runnable;Ljava/lang/String;)V
    //   32: invokevirtual start : ()V
    //   35: aload_0
    //   36: getfield j : Z
    //   39: ifne -> 66
    //   42: aload_0
    //   43: getfield h : Z
    //   46: istore_1
    //   47: iload_1
    //   48: ifne -> 66
    //   51: aload_0
    //   52: invokevirtual wait : ()V
    //   55: goto -> 35
    //   58: astore_2
    //   59: aload_2
    //   60: invokevirtual printStackTrace : ()V
    //   63: goto -> 35
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: astore_2
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_2
    //   73: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	69	finally
    //   22	35	69	finally
    //   35	47	69	finally
    //   51	55	58	java/lang/InterruptedException
    //   51	55	69	finally
    //   59	63	69	finally
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    this.f.c(paramFloat1, paramFloat2);
  }
  
  public void a(int paramInt) {
    this.f.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    if (this.g != null) {
      b b = new b(paramInt1, paramInt2, paramInt3, paramLong);
      a a1 = this.g;
      a1.sendMessage(a1.obtainMessage(0, b));
      try {
        b.e.await();
        return;
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
    } 
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Z
    //   6: ifne -> 22
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'SurfaceRenderer'
    //   14: ldc 'not started yet !!!'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield g : Lcom/qiniu/pili/droid/shortvideo/gl/b/c$a;
    //   26: ifnull -> 39
    //   29: aload_0
    //   30: getfield g : Lcom/qiniu/pili/droid/shortvideo/gl/b/c$a;
    //   33: invokevirtual getLooper : ()Landroid/os/Looper;
    //   36: invokevirtual quit : ()V
    //   39: aload_0
    //   40: getfield h : Z
    //   43: istore_1
    //   44: iload_1
    //   45: ifeq -> 63
    //   48: aload_0
    //   49: invokevirtual wait : ()V
    //   52: goto -> 39
    //   55: astore_2
    //   56: aload_2
    //   57: invokevirtual printStackTrace : ()V
    //   60: goto -> 39
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	66	finally
    //   22	39	66	finally
    //   39	44	66	finally
    //   48	52	55	java/lang/InterruptedException
    //   48	52	66	finally
    //   56	60	66	finally
  }
  
  public void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield j : Z
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public void run() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Z
    //   6: ifeq -> 26
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'SurfaceRenderer'
    //   14: ldc 'shared context is going to be invalid, interrupt now.'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual notify : ()V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: new com/qiniu/pili/droid/shortvideo/gl/a/d
    //   29: dup
    //   30: aload_0
    //   31: getfield a : Ljava/lang/Object;
    //   34: iconst_1
    //   35: invokespecial <init> : (Ljava/lang/Object;I)V
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_0
    //   42: new com/qiniu/pili/droid/shortvideo/gl/a/f
    //   45: dup
    //   46: aload_1
    //   47: aload_0
    //   48: getfield b : Landroid/view/Surface;
    //   51: iconst_0
    //   52: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/gl/a/d;Landroid/view/Surface;Z)V
    //   55: putfield e : Lcom/qiniu/pili/droid/shortvideo/gl/a/f;
    //   58: aload_0
    //   59: getfield e : Lcom/qiniu/pili/droid/shortvideo/gl/a/f;
    //   62: invokevirtual b : ()V
    //   65: invokestatic prepare : ()V
    //   68: aload_0
    //   69: new com/qiniu/pili/droid/shortvideo/gl/b/c$a
    //   72: dup
    //   73: aload_0
    //   74: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/gl/b/c;)V
    //   77: putfield g : Lcom/qiniu/pili/droid/shortvideo/gl/b/c$a;
    //   80: aload_0
    //   81: monitorenter
    //   82: aload_0
    //   83: iconst_1
    //   84: putfield h : Z
    //   87: aload_0
    //   88: invokevirtual notify : ()V
    //   91: aload_0
    //   92: monitorexit
    //   93: invokestatic loop : ()V
    //   96: aload_0
    //   97: getfield e : Lcom/qiniu/pili/droid/shortvideo/gl/a/f;
    //   100: invokevirtual d : ()V
    //   103: aload_1
    //   104: invokevirtual a : ()V
    //   107: aload_0
    //   108: monitorenter
    //   109: aload_0
    //   110: iconst_0
    //   111: putfield h : Z
    //   114: aload_0
    //   115: invokevirtual notify : ()V
    //   118: aload_0
    //   119: monitorexit
    //   120: return
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    //   126: astore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual printStackTrace : ()V
    //   136: getstatic com/qiniu/pili/droid/shortvideo/f/e.h : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   139: astore_2
    //   140: new java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial <init> : ()V
    //   147: astore_3
    //   148: aload_3
    //   149: ldc 'Prepares EGL display and context failed: '
    //   151: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_3
    //   156: aload_1
    //   157: invokevirtual getMessage : ()Ljava/lang/String;
    //   160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_2
    //   165: ldc 'SurfaceRenderer'
    //   167: aload_3
    //   168: invokevirtual toString : ()Ljava/lang/String;
    //   171: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_0
    //   175: monitorexit
    //   176: return
    //   177: astore_1
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	177	finally
    //   26	39	131	java/lang/RuntimeException
    //   26	39	177	finally
    //   39	41	177	finally
    //   82	93	126	finally
    //   109	120	121	finally
    //   122	124	121	finally
    //   127	129	126	finally
    //   132	176	177	finally
    //   178	180	177	finally
  }
  
  static class a extends Handler {
    private WeakReference<c> a;
    
    public a(c param1c) {
      this.a = new WeakReference<c>(param1c);
    }
    
    public void handleMessage(Message param1Message) {
      super.handleMessage(param1Message);
      c.b b = (c.b)param1Message.obj;
      c c = this.a.get();
      if (c != null)
        c.a(c, b); 
    }
  }
  
  static class b {
    public int a;
    
    public int b;
    
    public int c;
    
    public long d;
    
    public CountDownLatch e;
    
    public b(int param1Int1, int param1Int2, int param1Int3, long param1Long) {
      this.a = param1Int1;
      this.b = param1Int2;
      this.c = param1Int3;
      this.d = param1Long;
      this.e = new CountDownLatch(1);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */