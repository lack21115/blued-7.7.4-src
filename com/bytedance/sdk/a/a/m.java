package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.nio.ByteBuffer;

final class m implements d {
  public final c a = new c();
  
  public final r b;
  
  boolean c;
  
  m(r paramr) {
    if (paramr != null) {
      this.b = paramr;
      return;
    } 
    throw new NullPointerException("sink == null");
  }
  
  public t a() {
    return this.b.a();
  }
  
  public void a_(c paramc, long paramLong) throws IOException {
    if (!this.c) {
      this.a.a_(paramc, paramLong);
      u();
      return;
    } 
    throw new IllegalStateException("closed");
  }
  
  public d b(String paramString) throws IOException {
    if (!this.c) {
      this.a.a(paramString);
      return u();
    } 
    throw new IllegalStateException("closed");
  }
  
  public c c() {
    return this.a;
  }
  
  public d c(byte[] paramArrayOfbyte) throws IOException {
    if (!this.c) {
      this.a.b(paramArrayOfbyte);
      return u();
    } 
    throw new IllegalStateException("closed");
  }
  
  public d c(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    if (!this.c) {
      this.a.b(paramArrayOfbyte, paramInt1, paramInt2);
      return u();
    } 
    throw new IllegalStateException("closed");
  }
  
  public void close() throws IOException {
    if (this.c)
      return; 
    Exception exception2 = null;
    Exception exception1 = exception2;
    try {
      if (this.a.b > 0L) {
        this.b.a_(this.a, this.a.b);
        exception1 = exception2;
      } 
    } finally {}
    try {
    
    } finally {
      Exception exception = null;
      exception2 = exception1;
    } 
    this.c = true;
    if (exception2 != null)
      u.a(exception2); 
  }
  
  public void flush() throws IOException {
    if (!this.c) {
      if (this.a.b > 0L) {
        r r1 = this.b;
        c c1 = this.a;
        r1.a_(c1, c1.b);
      } 
      this.b.flush();
      return;
    } 
    throw new IllegalStateException("closed");
  }
  
  public d g(int paramInt) throws IOException {
    if (!this.c) {
      this.a.d(paramInt);
      return u();
    } 
    throw new IllegalStateException("closed");
  }
  
  public d h(int paramInt) throws IOException {
    if (!this.c) {
      this.a.c(paramInt);
      return u();
    } 
    throw new IllegalStateException("closed");
  }
  
  public d i(int paramInt) throws IOException {
    if (!this.c) {
      this.a.b(paramInt);
      return u();
    } 
    throw new IllegalStateException("closed");
  }
  
  public boolean isOpen() {
    return this.c ^ true;
  }
  
  public d k(long paramLong) throws IOException {
    if (!this.c) {
      this.a.j(paramLong);
      return u();
    } 
    throw new IllegalStateException("closed");
  }
  
  public d l(long paramLong) throws IOException {
    if (!this.c) {
      this.a.i(paramLong);
      return u();
    } 
    throw new IllegalStateException("closed");
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("buffer(");
    stringBuilder.append(this.b);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public d u() throws IOException {
    if (!this.c) {
      long l = this.a.g();
      if (l > 0L)
        this.b.a_(this.a, l); 
      return this;
    } 
    throw new IllegalStateException("closed");
  }
  
  public int write(ByteBuffer paramByteBuffer) throws IOException {
    if (!this.c) {
      int i = this.a.write(paramByteBuffer);
      u();
      return i;
    } 
    throw new IllegalStateException("closed");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */