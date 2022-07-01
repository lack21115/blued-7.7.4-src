package com.qiniu.pili.droid.shortvideo.core;

import java.nio.ByteBuffer;

public class a {
  public long a;
  
  private ByteBuffer b;
  
  private long c = 0L;
  
  private int d = 0;
  
  private double e = 1.0D;
  
  private a f;
  
  private long g;
  
  private boolean h;
  
  public double a() {
    return this.e;
  }
  
  public void a(double paramDouble) {
    this.e = paramDouble;
  }
  
  public void a(a parama) {
    this.f = parama;
  }
  
  public void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong) {
    paramByteBuffer.limit(paramByteBuffer.position() + paramInt);
    double d = this.e;
    if (d >= 1.0D) {
      long l = paramLong - this.g;
      int i = this.d;
      this.d = i + 1;
      if (i % d == 0.0D && this.f != null) {
        long l1 = this.a;
        if (l1 == 0L) {
          l = (long)(l / d);
        } else {
          l = l1 + l;
        } 
        this.f.a(paramByteBuffer, paramInt, l);
        this.a = l;
      } 
    } else {
      if (this.b == null)
        this.b = ByteBuffer.allocateDirect(paramByteBuffer.capacity()); 
      long l = this.c;
      if (l > 0L && paramLong > l) {
        int i = (int)(1.0D / this.e);
        this.b.flip();
        int j = this.b.limit();
        for (paramInt = 0; paramInt < i; paramInt++) {
          if (this.f != null) {
            l = this.c;
            long l1 = this.a;
            if (l1 != 0L)
              l = l1 + paramLong - l; 
            a a1 = this.f;
            ByteBuffer byteBuffer = this.b;
            a1.a(byteBuffer, byteBuffer.remaining(), l);
            this.a = l;
          } 
          this.b.position(0);
          this.b.limit(j);
        } 
      } 
      this.c = paramLong;
      this.b.clear();
      this.b.put(paramByteBuffer);
    } 
    this.g = paramLong;
  }
  
  public void a(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public void b() {
    this.b = null;
    this.c = 0L;
    this.d = 0;
  }
  
  public void b(ByteBuffer paramByteBuffer, int paramInt, long paramLong) {
    paramByteBuffer.limit(paramByteBuffer.position() + paramInt);
    double d = this.e;
    if (d >= 1.0D) {
      int i = this.d;
      this.d = i + 1;
      if (i % d == 0.0D) {
        a a1 = this.f;
        if (a1 != null) {
          a1.a(paramByteBuffer, paramInt, (long)(paramLong / d));
          return;
        } 
      } 
    } else {
      if (this.b == null)
        this.b = ByteBuffer.allocateDirect(paramByteBuffer.capacity()); 
      long l = this.c;
      if (l > 0L && paramLong > l) {
        paramInt = (int)(1.0D / this.e);
        l = (paramLong - l) / paramInt;
        this.b.flip();
        int j = this.b.limit();
        int i;
        for (i = 0; i < paramInt; i++) {
          a a1 = this.f;
          if (a1 != null) {
            ByteBuffer byteBuffer = this.b;
            a1.a(byteBuffer, byteBuffer.remaining(), (long)((this.c + i * l) / this.e));
          } 
          this.b.position(0);
          this.b.limit(j);
        } 
      } 
      this.c = paramLong;
      this.b.clear();
      this.b.put(paramByteBuffer);
    } 
  }
  
  public void c(ByteBuffer paramByteBuffer, int paramInt, long paramLong) {
    if (this.h) {
      a(paramByteBuffer, paramInt, paramLong);
      return;
    } 
    b(paramByteBuffer, paramInt, paramLong);
  }
  
  public static interface a {
    void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */