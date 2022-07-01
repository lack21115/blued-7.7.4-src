package com.qiniu.pili.droid.shortvideo.encode;

import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.h;
import com.qiniu.pili.droid.shortvideo.f.i;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class f extends a {
  private static final boolean f = h.a().d();
  
  protected ByteBuffer e;
  
  private LinkedBlockingQueue g = new LinkedBlockingQueue();
  
  private LinkedBlockingQueue h = new LinkedBlockingQueue();
  
  private int i;
  
  private Object j = new Object();
  
  private i k = new i();
  
  private void n() {
    e.h.b(j(), "wait for frames");
    try {
      a a1 = this.g.poll(1000L, TimeUnit.MICROSECONDS);
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
      interruptedException = null;
    } 
    if (interruptedException != null && ((a)interruptedException).a != null) {
      null = e.h;
      String str = j();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("do encode frames, size = ");
      stringBuilder.append(((a)interruptedException).b);
      stringBuilder.append(", ts = ");
      stringBuilder.append(((a)interruptedException).c);
      null.b(str, stringBuilder.toString());
      if (this.e == null)
        this.e = ByteBuffer.allocateDirect(((a)interruptedException).b); 
      this.e.rewind();
      a(this.e, ((a)interruptedException).a.array(), ((a)interruptedException).b, ((a)interruptedException).c);
      synchronized (this.j) {
        int j = ((Integer)this.h.poll()).intValue();
        if (j >= 0) {
          this.k.b(j);
          null = e.h;
          str = j();
          stringBuilder = new StringBuilder();
          stringBuilder.append("buffer use done, return back ");
          stringBuilder.append(j);
          null.b(str, stringBuilder.toString());
        } else {
          e.h.d(j(), "leave the tmp buffer to gc");
        } 
        return;
      } 
    } 
  }
  
  public boolean a() {
    e.h.c(j(), "start +");
    if (!f) {
      e.h.e(j(), "start failed !");
      return false;
    } 
    this.i = 0;
    e.h.c(j(), "start -");
    return super.a();
  }
  
  public boolean a(long paramLong) {
    e.h.d(j(), "unimplemented !");
    return false;
  }
  
  public boolean a(ByteBuffer paramByteBuffer, int paramInt, long paramLong) {
    if (!f || m()) {
      e.h.d(j(), "stop is marked, not accepting anymore frames.");
      return false;
    } 
    paramLong = b(paramLong);
    if (paramLong < 0L)
      return false; 
    ByteBuffer byteBuffer = null;
    synchronized (this.j) {
      if (this.i != paramInt) {
        e e1 = e.h;
        String str1 = j();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("buffer size changed from ");
        stringBuilder1.append(this.i);
        stringBuilder1.append(" to ");
        stringBuilder1.append(paramInt);
        stringBuilder1.append(", reallocate now.");
        e1.c(str1, stringBuilder1.toString());
        this.i = paramInt;
        this.k.a();
        this.k.a(this.i, 6);
      } 
      int j = this.k.b();
      if (j >= 0) {
        byteBuffer = this.k.a(j);
        e e1 = e.h;
        String str1 = j();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("found a buffer to reuse, index: ");
        stringBuilder1.append(j);
        e1.b(str1, stringBuilder1.toString());
      } 
      null = byteBuffer;
      if (byteBuffer == null) {
        null = ByteBuffer.allocate(paramByteBuffer.capacity());
        e.h.d(j(), "cannot find a buffer to reuse, allocate a tmp one.");
      } 
      null.put(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramInt);
      e e = e.h;
      String str = j();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("input frame, size =  ");
      stringBuilder.append(paramInt);
      stringBuilder.append(", ts = ");
      stringBuilder.append(paramLong);
      e.b(str, stringBuilder.toString());
      this.h.add(Integer.valueOf(j));
      this.g.add(new a(this, (ByteBuffer)null, paramInt, paramLong));
      d();
      e = e.h;
      str = j();
      null = new StringBuilder();
      null.append("input frame done, num = ");
      null.append(this.g.size());
      e.b(str, null.toString());
      return true;
    } 
  }
  
  abstract boolean a(ByteBuffer paramByteBuffer, byte[] paramArrayOfbyte, int paramInt, long paramLong);
  
  public boolean c() {
    e.h.c(j(), "stop +");
    if (!f) {
      e.h.e(j(), "encode thread not started !");
      return false;
    } 
    e.h.c(j(), "stop -");
    return super.c();
  }
  
  abstract boolean g();
  
  abstract boolean h();
  
  abstract boolean i();
  
  abstract boolean k();
  
  public void run() {
    e.h.c(j(), "run +");
    if (!g() || !i()) {
      e.h.e(j(), "start failed !");
      if (this.d != null)
        this.d.a(false); 
      return;
    } 
    if (this.d != null)
      this.d.a(true); 
    while (true) {
      if (!m() || f()) {
        n();
        continue;
      } 
      k();
      h();
      if (this.d != null)
        this.d.b(false); 
      e.h.c(j(), "run -");
      return;
    } 
  }
  
  class a {
    public ByteBuffer a;
    
    public int b;
    
    public long c;
    
    public a(f this$0, ByteBuffer param1ByteBuffer, int param1Int, long param1Long) {
      this.a = param1ByteBuffer;
      this.b = param1Int;
      this.c = param1Long;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\encode\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */