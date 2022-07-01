package com.qiniu.pili.droid.shortvideo.core;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.encode.a;
import java.nio.ByteBuffer;

public abstract class e extends j {
  protected volatile Surface a;
  
  protected a b;
  
  protected PLVideoEncodeSetting c;
  
  protected volatile boolean d;
  
  protected volatile boolean e;
  
  protected a.a f = new a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        com.qiniu.pili.droid.shortvideo.f.e e2 = com.qiniu.pili.droid.shortvideo.f.e.d;
        String str = this.a.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("got video format:");
        stringBuilder.append(param1MediaFormat.toString());
        e2.c(str, stringBuilder.toString());
        this.a.r.a(param1MediaFormat);
        e e1 = this.a;
        e1.e = true;
        e1.r();
      }
      
      public void a(Surface param1Surface) {
        com.qiniu.pili.droid.shortvideo.f.e.d.c(this.a.a(), "video encode surface created");
        this.a.a = param1Surface;
      }
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        if (this.a.l) {
          com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.d;
          String str = this.a.a();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("video encoded frame size:");
          stringBuilder.append(param1BufferInfo.size);
          stringBuilder.append(" ts:");
          stringBuilder.append(param1BufferInfo.presentationTimeUs);
          e1.b(str, stringBuilder.toString());
          this.a.r.a(param1ByteBuffer, param1BufferInfo);
        } 
      }
      
      public void a(boolean param1Boolean) {
        com.qiniu.pili.droid.shortvideo.f.e e2 = com.qiniu.pili.droid.shortvideo.f.e.d;
        String str = this.a.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video encoder started: ");
        stringBuilder.append(param1Boolean);
        e2.c(str, stringBuilder.toString());
        e e1 = this.a;
        e1.d = param1Boolean;
        if (param1Boolean) {
          e1.b();
          return;
        } 
        if (e1.s != null) {
          e1 = this.a;
          e1.i = false;
          e1.s.onError(6);
          QosManager.a().a(6);
        } 
      }
      
      public void b(boolean param1Boolean) {
        com.qiniu.pili.droid.shortvideo.f.e.d.c(this.a.a(), "video encode stopped");
        e e1 = this.a;
        e1.d = false;
        e1.e = false;
        e1.s();
      }
    };
  
  protected abstract String a();
  
  public void a(boolean paramBoolean) {
    com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.d;
    String str = a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mute: ");
    stringBuilder.append(paramBoolean);
    e1.c(str, stringBuilder.toString());
    this.q.a(paramBoolean);
  }
  
  public boolean a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: aload_0
    //   6: invokevirtual a : ()Ljava/lang/String;
    //   9: ldc 'beginSection'
    //   11: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial a : (Ljava/lang/String;)Z
    //   19: istore_2
    //   20: iload_2
    //   21: ifeq -> 43
    //   24: aload_0
    //   25: getfield b : Lcom/qiniu/pili/droid/shortvideo/encode/a;
    //   28: aload_0
    //   29: getfield t : D
    //   32: invokevirtual a : (D)V
    //   35: aload_0
    //   36: getfield b : Lcom/qiniu/pili/droid/shortvideo/encode/a;
    //   39: invokevirtual a : ()Z
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_2
    //   46: ireturn
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	47	finally
    //   24	43	47	finally
  }
  
  protected abstract void b();
  
  public boolean c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: aload_0
    //   6: invokevirtual a : ()Ljava/lang/String;
    //   9: ldc 'endSection'
    //   11: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokespecial c : ()Z
    //   18: istore_1
    //   19: iload_1
    //   20: ifeq -> 36
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield d : Z
    //   28: aload_0
    //   29: getfield b : Lcom/qiniu/pili/droid/shortvideo/encode/a;
    //   32: invokevirtual c : ()Z
    //   35: pop
    //   36: aload_0
    //   37: monitorexit
    //   38: iload_1
    //   39: ireturn
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	40	finally
    //   23	36	40	finally
  }
  
  protected boolean d() {
    return (this.d && this.j);
  }
  
  protected boolean e() {
    return (this.e && this.k);
  }
  
  protected boolean f() {
    return (!this.e && !this.k);
  }
  
  protected i g() {
    return new i(this.m, this.n, this.p, this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */