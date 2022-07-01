package com.qiniu.pili.droid.shortvideo.encode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.k;
import java.nio.ByteBuffer;

public abstract class a extends k {
  protected double a = 1.0D;
  
  protected volatile int b;
  
  protected volatile int c;
  
  protected a d;
  
  private volatile boolean e;
  
  private volatile long f;
  
  private volatile long g = -1L;
  
  private final Object h = new Object();
  
  public void a(double paramDouble) {
    this.a = paramDouble;
  }
  
  public void a(a parama) {
    this.d = parama;
  }
  
  public boolean a() {
    this.e = false;
    this.f = 0L;
    this.g = -1L;
    return super.a();
  }
  
  public abstract boolean a(long paramLong);
  
  public abstract boolean a(ByteBuffer paramByteBuffer, int paramInt, long paramLong);
  
  public long b() {
    return this.f;
  }
  
  protected long b(long paramLong) {
    if (!this.e) {
      this.e = true;
      this.f = paramLong;
    } 
    paramLong -= this.f;
    if (paramLong <= this.g) {
      e.h.d(j(), "timestamp fall back, ignore this frame.");
      return -1L;
    } 
    this.g = paramLong;
    return paramLong;
  }
  
  public boolean c() {
    boolean bool = super.c();
    synchronized (this.h) {
      e e = e.h;
      String str = j();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("stopping encoder, input frame count: ");
      stringBuilder.append(this.b);
      stringBuilder.append(" output frame count: ");
      stringBuilder.append(this.c);
      stringBuilder.append(" flush remaining frames: ");
      stringBuilder.append(this.b - this.c);
      e.c(str, stringBuilder.toString());
      return bool;
    } 
  }
  
  protected void d() {
    synchronized (this.h) {
      this.b++;
      return;
    } 
  }
  
  protected void e() {
    synchronized (this.h) {
      this.c++;
      return;
    } 
  }
  
  protected boolean f() {
    synchronized (this.h) {
      if (this.b > this.c)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public static interface a {
    void a(MediaFormat param1MediaFormat);
    
    void a(Surface param1Surface);
    
    void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo);
    
    void a(boolean param1Boolean);
    
    void b(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\encode\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */