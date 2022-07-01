package com.soft.blued.ui.msg.VideoChat;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase;
import com.blued.android.module.live_china.zegoVideoCapture.ve_gl.GlUtil;
import com.zego.zegoavkit2.videofilter.ZegoVideoFilter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

public class ZegoBeautyFilter extends ZegoVideoFilter {
  private ZegoVideoFilter.Client a = null;
  
  private HandlerThread b = null;
  
  private volatile Handler c = null;
  
  private ArrayList<PixelBuffer> d = new ArrayList<PixelBuffer>();
  
  private int e = 0;
  
  private int f = 0;
  
  private ConcurrentLinkedQueue<PixelBuffer> g = new ConcurrentLinkedQueue<PixelBuffer>();
  
  private int h = 0;
  
  private EglBase i;
  
  private int j = 0;
  
  private byte[] k = new byte[0];
  
  private PixelBuffer a() {
    return this.g.isEmpty() ? null : this.g.poll();
  }
  
  private void a(int paramInt) {
    for (int i = 0; i < paramInt; i++) {
      PixelBuffer pixelBuffer = new PixelBuffer();
      pixelBuffer.e = ByteBuffer.allocateDirect(this.h);
      this.d.add(pixelBuffer);
    } 
    this.f = paramInt;
    this.e = -1;
  }
  
  private void a(PixelBuffer paramPixelBuffer) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield e : Ljava/nio/ByteBuffer;
    //   6: invokevirtual capacity : ()I
    //   9: aload_0
    //   10: getfield h : I
    //   13: if_icmpne -> 26
    //   16: aload_0
    //   17: aload_0
    //   18: getfield f : I
    //   21: iconst_1
    //   22: iadd
    //   23: putfield f : I
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	29	finally
  }
  
  private void b() {
    if (this.i.c()) {
      this.i.f();
      int i = this.j;
      if (i != 0) {
        GLES20.glDeleteTextures(1, new int[] { i }, 0);
        this.j = 0;
      } 
    } 
    this.i.e();
    this.i = null;
  }
  
  public void allocateAndStart(ZegoVideoFilter.Client paramClient) {
    this.a = paramClient;
    this.b = new HandlerThread("video-filter");
    this.b.start();
    this.c = new Handler(this.b.getLooper());
    CountDownLatch countDownLatch = new CountDownLatch(1);
    this.c.post(new Runnable(this, countDownLatch) {
          public void run() {
            ZegoBeautyFilter.a(this.b, EglBase.a(null, EglBase.f));
            try {
              ZegoBeautyFilter.a(this.b).a();
              ZegoBeautyFilter.a(this.b).f();
              GLES20.glActiveTexture(33984);
              ZegoBeautyFilter.a(this.b, GlUtil.a(3553));
              this.a.countDown();
              return;
            } catch (RuntimeException runtimeException) {
              ZegoBeautyFilter.a(this.b).d();
              throw runtimeException;
            } 
          }
        });
    try {
      countDownLatch.await();
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
    } 
    this.d.clear();
    this.g.clear();
    this.e = 0;
    this.f = 0;
    this.h = 0;
  }
  
  public int dequeueInputBuffer(int paramInt1, int paramInt2, int paramInt3) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: iload_2
    //   4: imul
    //   5: istore_1
    //   6: iload_1
    //   7: aload_0
    //   8: getfield h : I
    //   11: if_icmple -> 38
    //   14: aload_0
    //   15: getfield h : I
    //   18: ifeq -> 28
    //   21: aload_0
    //   22: getfield d : Ljava/util/ArrayList;
    //   25: invokevirtual clear : ()V
    //   28: aload_0
    //   29: iload_1
    //   30: putfield h : I
    //   33: aload_0
    //   34: iconst_3
    //   35: invokespecial a : (I)V
    //   38: aload_0
    //   39: getfield f : I
    //   42: istore_1
    //   43: iload_1
    //   44: ifne -> 51
    //   47: aload_0
    //   48: monitorexit
    //   49: iconst_m1
    //   50: ireturn
    //   51: aload_0
    //   52: aload_0
    //   53: getfield f : I
    //   56: iconst_1
    //   57: isub
    //   58: putfield f : I
    //   61: aload_0
    //   62: getfield e : I
    //   65: istore_1
    //   66: aload_0
    //   67: getfield d : Ljava/util/ArrayList;
    //   70: invokevirtual size : ()I
    //   73: istore_2
    //   74: aload_0
    //   75: monitorexit
    //   76: iload_1
    //   77: iconst_1
    //   78: iadd
    //   79: iload_2
    //   80: irem
    //   81: ireturn
    //   82: astore #4
    //   84: aload_0
    //   85: monitorexit
    //   86: aload #4
    //   88: athrow
    // Exception table:
    //   from	to	target	type
    //   6	28	82	finally
    //   28	38	82	finally
    //   38	43	82	finally
    //   51	74	82	finally
  }
  
  public ByteBuffer getInputBuffer(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Ljava/util/ArrayList;
    //   6: invokevirtual isEmpty : ()Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: getfield d : Ljava/util/ArrayList;
    //   22: iload_1
    //   23: invokevirtual get : (I)Ljava/lang/Object;
    //   26: checkcast com/soft/blued/ui/msg/VideoChat/ZegoBeautyFilter$PixelBuffer
    //   29: getfield e : Ljava/nio/ByteBuffer;
    //   32: astore_3
    //   33: aload_3
    //   34: iconst_0
    //   35: invokevirtual position : (I)Ljava/nio/Buffer;
    //   38: pop
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: areturn
    //   43: astore_3
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_3
    //   47: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	43	finally
    //   18	39	43	finally
  }
  
  public SurfaceTexture getSurfaceTexture() {
    return null;
  }
  
  public void onProcessCallback(int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  
  public void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iconst_m1
    //   4: if_icmpne -> 10
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: aload_0
    //   11: getfield d : Ljava/util/ArrayList;
    //   14: iload_1
    //   15: invokevirtual get : (I)Ljava/lang/Object;
    //   18: checkcast com/soft/blued/ui/msg/VideoChat/ZegoBeautyFilter$PixelBuffer
    //   21: astore #7
    //   23: aload #7
    //   25: iload_2
    //   26: putfield a : I
    //   29: aload #7
    //   31: iload_3
    //   32: putfield b : I
    //   35: aload #7
    //   37: iload #4
    //   39: putfield c : I
    //   42: aload #7
    //   44: lload #5
    //   46: putfield d : J
    //   49: aload #7
    //   51: getfield e : Ljava/nio/ByteBuffer;
    //   54: iload_3
    //   55: iload #4
    //   57: imul
    //   58: invokevirtual limit : (I)Ljava/nio/Buffer;
    //   61: pop
    //   62: aload_0
    //   63: getfield g : Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   66: aload #7
    //   68: invokevirtual add : (Ljava/lang/Object;)Z
    //   71: pop
    //   72: aload_0
    //   73: aload_0
    //   74: getfield e : I
    //   77: iconst_1
    //   78: iadd
    //   79: putfield e : I
    //   82: aload_0
    //   83: getfield c : Landroid/os/Handler;
    //   86: new com/soft/blued/ui/msg/VideoChat/ZegoBeautyFilter$3
    //   89: dup
    //   90: aload_0
    //   91: invokespecial <init> : (Lcom/soft/blued/ui/msg/VideoChat/ZegoBeautyFilter;)V
    //   94: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   97: pop
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: astore #7
    //   103: aload_0
    //   104: monitorexit
    //   105: aload #7
    //   107: athrow
    // Exception table:
    //   from	to	target	type
    //   10	98	101	finally
  }
  
  public void stopAndDeAllocate() {
    CountDownLatch countDownLatch = new CountDownLatch(1);
    this.c.post(new Runnable(this, countDownLatch) {
          public void run() {
            ZegoBeautyFilter.b(this.b).destroy();
            ZegoBeautyFilter.a(this.b, (ZegoVideoFilter.Client)null);
            ZegoBeautyFilter.c(this.b);
            this.a.countDown();
          }
        });
    try {
      countDownLatch.await();
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
    } 
    this.c = null;
    this.b.quit();
    this.b = null;
  }
  
  public int supportBufferType() {
    return 16;
  }
  
  static class PixelBuffer {
    public int a;
    
    public int b;
    
    public int c;
    
    public long d;
    
    public ByteBuffer e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\VideoChat\ZegoBeautyFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */