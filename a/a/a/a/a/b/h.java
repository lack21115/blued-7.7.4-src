package a.a.a.a.a.b;

import a.a.a.a.a.a.h.d;
import a.a.a.a.a.a.h.f;
import a.a.a.a.a.a.h.g;
import a.a.a.a.a.b.i.i;
import a.a.a.a.a.b.i.o;
import a.a.a.a.a.e.e;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qiniu.pili.droid.streaming.PreviewAppearance;
import com.qiniu.pili.droid.streaming.StreamingPreviewCallback;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import java.lang.ref.WeakReference;

public final class h implements Runnable {
  public StreamingPreviewCallback a;
  
  public g b;
  
  public d c;
  
  public o d;
  
  public i e;
  
  public byte[] f;
  
  public volatile b g;
  
  public volatile boolean h;
  
  public final Object i = new Object();
  
  public volatile boolean j;
  
  public void a() {
    // Byte code:
    //   0: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   3: ldc 'SurfaceDataReader'
    //   5: ldc 'stopReading +'
    //   7: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield i : Ljava/lang/Object;
    //   14: astore_2
    //   15: aload_2
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield h : Z
    //   21: ifne -> 37
    //   24: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   27: ldc 'SurfaceDataReader'
    //   29: ldc 'stopReading as not Running-'
    //   31: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_2
    //   35: monitorexit
    //   36: return
    //   37: aload_2
    //   38: monitorexit
    //   39: aload_0
    //   40: getfield g : La/a/a/a/a/b/h$b;
    //   43: ifnull -> 86
    //   46: aload_0
    //   47: getfield g : La/a/a/a/a/b/h$b;
    //   50: aconst_null
    //   51: invokevirtual removeCallbacksAndMessages : (Ljava/lang/Object;)V
    //   54: aload_0
    //   55: getfield g : La/a/a/a/a/b/h$b;
    //   58: aload_0
    //   59: getfield g : La/a/a/a/a/b/h$b;
    //   62: iconst_1
    //   63: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   66: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   69: pop
    //   70: aload_0
    //   71: getfield g : La/a/a/a/a/b/h$b;
    //   74: aload_0
    //   75: getfield g : La/a/a/a/a/b/h$b;
    //   78: iconst_5
    //   79: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   82: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   85: pop
    //   86: aload_0
    //   87: getfield i : Ljava/lang/Object;
    //   90: astore_2
    //   91: aload_2
    //   92: monitorenter
    //   93: aload_0
    //   94: getfield h : Z
    //   97: istore_1
    //   98: iload_1
    //   99: ifeq -> 112
    //   102: aload_0
    //   103: getfield i : Ljava/lang/Object;
    //   106: invokevirtual wait : ()V
    //   109: goto -> 93
    //   112: aload_2
    //   113: monitorexit
    //   114: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   117: ldc 'SurfaceDataReader'
    //   119: ldc 'stopReading -'
    //   121: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   124: return
    //   125: astore_3
    //   126: aload_2
    //   127: monitorexit
    //   128: aload_3
    //   129: athrow
    //   130: astore_3
    //   131: aload_2
    //   132: monitorexit
    //   133: aload_3
    //   134: athrow
    //   135: astore_3
    //   136: goto -> 93
    // Exception table:
    //   from	to	target	type
    //   17	36	130	finally
    //   37	39	130	finally
    //   93	98	125	finally
    //   102	109	135	java/lang/InterruptedException
    //   102	109	125	finally
    //   112	114	125	finally
    //   126	128	125	finally
    //   131	133	130	finally
  }
  
  public void a(int paramInt, SurfaceTexture paramSurfaceTexture) {
    synchronized (this.i) {
      if (this.j) {
        if (paramSurfaceTexture.getTimestamp() == 0L) {
          e.g.d("SurfaceDataReader", "HEY: got SurfaceTexture with timestamp of zero");
          return;
        } 
        this.g.sendMessage(this.g.obtainMessage(2, paramInt, 0, paramSurfaceTexture));
      } 
      return;
    } 
  }
  
  public final void a(a parama) {
    this.f = new byte[parama.c];
    b(parama);
  }
  
  public void a(StreamingPreviewCallback paramStreamingPreviewCallback) {
    this.a = paramStreamingPreviewCallback;
  }
  
  public void a(Object paramObject) {
    if (this.g != null)
      this.g.removeCallbacksAndMessages(null); 
    e.g.c("SurfaceDataReader", "startReading()");
    a("SrcDataReader");
    if (this.g != null)
      this.g.sendMessage(this.g.obtainMessage(0, paramObject)); 
  }
  
  public final void a(String paramString) {
    synchronized (this.i) {
      if (this.h) {
        e.g.d("SurfaceDataReader", "Reading thread running when start requested");
        return;
      } 
      this.h = true;
      Thread thread = new Thread(this, paramString);
      thread.setPriority(10);
      thread.start();
      while (true) {
        boolean bool = this.j;
        if (!bool) {
          try {
            this.i.wait();
          } catch (InterruptedException interruptedException) {}
          continue;
        } 
        return;
      } 
    } 
  }
  
  public final void b() {
    e.g.c("SurfaceDataReader", "handleStopRecording");
    if (this.g != null)
      this.g.removeMessages(2); 
    c();
  }
  
  public void b(int paramInt, SurfaceTexture paramSurfaceTexture) {
    if (this.e == null || this.b == null) {
      null = e.g;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ERROR. handleFrameAvailable mTextureI420Reader:");
      stringBuilder.append(this.e);
      stringBuilder.append(",mInputWindowSurface:");
      stringBuilder.append(this.b);
      null.c("SurfaceDataReader", stringBuilder.toString());
      return;
    } 
    long l = System.currentTimeMillis();
    synchronized (f.d) {
      o o1 = this.d;
      int j = 0;
      paramInt = o1.a(0, paramInt);
      null = this.e.a(paramInt);
      e e = e.g;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("process cost:");
      stringBuilder.append(System.currentTimeMillis() - l);
      e.a("SurfaceDataReader", stringBuilder.toString());
      if (null != null) {
        int k = null.length;
        byte b1 = 0;
        paramInt = j;
        j = b1;
        while (paramInt < k) {
          Object object = null[paramInt];
          object.rewind();
          object.get(this.f, j, object.capacity());
          j += object.capacity();
          paramInt++;
        } 
      } 
      this.e.a();
      null = this.a;
      if (null != null)
        null.onPreviewFrame(this.f, this.d.a(), this.d.b(), 0, PLFourCC.FOURCC_I420, null.getTimestamp()); 
      return;
    } 
  }
  
  public final void b(a parama) {
    try {
      this.c = new d(parama.f, 0);
      g g1 = new g(this.c, 2, 2);
      this.b = g1;
      g1.d();
      int j = parama.d;
      int k = parama.e;
      int m = parama.a;
      int n = parama.b;
      o o1 = new o();
      this.d = o1;
      o1.a(j, k, true);
      this.d.a(m, n, 0.0F, 0.0F, 1.0F, 1.0F, PreviewAppearance.ScaleType.FULL);
      i i1 = new i();
      this.e = i1;
      i1.a(j, k);
      return;
    } catch (Exception exception) {
      e e = e.g;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("exception:");
      stringBuilder.append(exception.getMessage());
      e.d("SurfaceDataReader", stringBuilder.toString());
      return;
    } 
  }
  
  public final void c() {
    e.g.c("SurfaceDataReader", "release");
    this.a = null;
    g g1 = this.b;
    if (g1 != null) {
      g1.g();
      this.b = null;
    } 
    o o1 = this.d;
    if (o1 != null) {
      o1.e();
      this.d = null;
    } 
    i i1 = this.e;
    if (i1 != null) {
      i1.b();
      this.e = null;
    } 
    d d1 = this.c;
    if (d1 != null) {
      d1.b();
      this.c = null;
    } 
  }
  
  public void run() {
    Looper.prepare();
    synchronized (this.i) {
      this.g = new b(this);
      this.j = true;
      this.i.notify();
      Looper.loop();
      e.g.c("SurfaceDataReader", "Encoder thread exiting");
      synchronized (this.i) {
        this.h = false;
        this.j = false;
        this.g.removeCallbacksAndMessages(null);
        this.g = null;
        this.i.notify();
        return;
      } 
    } 
  }
  
  public static final class a {
    public final int a;
    
    public final int b;
    
    public final int c;
    
    public final int d;
    
    public final int e;
    
    public final Object f;
    
    public a(int param1Int1, int param1Int2, int param1Int3, int param1Int4, Object param1Object) {
      this.a = param1Int1;
      this.b = param1Int2;
      this.d = param1Int3;
      this.e = param1Int4;
      this.c = param1Int3 * param1Int4 * 3 / 2;
      this.f = param1Object;
    }
  }
  
  public static class b extends Handler {
    public WeakReference<h> a;
    
    public b(h param1h) {
      this.a = new WeakReference<h>(param1h);
    }
    
    public void handleMessage(Message param1Message) {
      int i = param1Message.what;
      Object object = param1Message.obj;
      h h = this.a.get();
      e e = e.g;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("EncoderHandler what:");
      stringBuilder.append(i);
      stringBuilder.append(",reader=");
      stringBuilder.append(h);
      e.c("SurfaceDataReader", stringBuilder.toString());
      if (h == null) {
        e.g.d("SurfaceDataReader", "EncoderHandler.handleMessage: encoder is null");
        return;
      } 
      if (i != 0) {
        if (i != 1) {
          StringBuilder stringBuilder1;
          if (i != 2) {
            if (i == 5) {
              Looper.myLooper().quit();
              return;
            } 
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Unhandled msg what=");
            stringBuilder1.append(i);
            throw new RuntimeException(stringBuilder1.toString());
          } 
          h.b(((Message)stringBuilder1).arg1, (SurfaceTexture)object);
          return;
        } 
        h.a(h);
        return;
      } 
      h.a(h, (h.a)object);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */