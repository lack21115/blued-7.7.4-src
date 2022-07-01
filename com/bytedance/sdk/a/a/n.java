package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

final class n implements e {
  public final c a = new c();
  
  public final s b;
  
  boolean c;
  
  n(s params) {
    if (params != null) {
      this.b = params;
      return;
    } 
    throw new NullPointerException("source == null");
  }
  
  public long a(byte paramByte) throws IOException {
    return a(paramByte, 0L, Long.MAX_VALUE);
  }
  
  public long a(byte paramByte, long paramLong1, long paramLong2) throws IOException {
    if (!this.c) {
      if (paramLong1 >= 0L && paramLong2 >= paramLong1) {
        while (paramLong1 < paramLong2) {
          long l = this.a.a(paramByte, paramLong1, paramLong2);
          if (l != -1L)
            return l; 
          l = this.a.b;
          if (l < paramLong2) {
            if (this.b.a(this.a, 8192L) == -1L)
              return -1L; 
            paramLong1 = Math.max(paramLong1, l);
          } 
        } 
        return -1L;
      } 
      throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    } 
    throw new IllegalStateException("closed");
  }
  
  public long a(c paramc, long paramLong) throws IOException {
    if (paramc != null) {
      if (paramLong >= 0L) {
        if (!this.c) {
          if (this.a.b == 0L && this.b.a(this.a, 8192L) == -1L)
            return -1L; 
          paramLong = Math.min(paramLong, this.a.b);
          return this.a.a(paramc, paramLong);
        } 
        throw new IllegalStateException("closed");
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("byteCount < 0: ");
      stringBuilder.append(paramLong);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("sink == null");
  }
  
  public t a() {
    return this.b.a();
  }
  
  public void a(long paramLong) throws IOException {
    if (b(paramLong))
      return; 
    throw new EOFException();
  }
  
  public void a(byte[] paramArrayOfbyte) throws IOException {
    try {
      a(paramArrayOfbyte.length);
      this.a.a(paramArrayOfbyte);
      return;
    } catch (EOFException eOFException) {
      int i = 0;
      while (this.a.b > 0L) {
        c c1 = this.a;
        int j = c1.a(paramArrayOfbyte, i, (int)c1.b);
        if (j != -1) {
          i += j;
          continue;
        } 
        throw new AssertionError();
      } 
      throw eOFException;
    } 
  }
  
  public boolean b(long paramLong) throws IOException {
    if (paramLong >= 0L) {
      if (!this.c) {
        while (this.a.b < paramLong) {
          if (this.b.a(this.a, 8192L) == -1L)
            return false; 
        } 
        return true;
      } 
      throw new IllegalStateException("closed");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("byteCount < 0: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public c c() {
    return this.a;
  }
  
  public f c(long paramLong) throws IOException {
    a(paramLong);
    return this.a.c(paramLong);
  }
  
  public void close() throws IOException {
    if (this.c)
      return; 
    this.c = true;
    this.b.close();
    this.a.r();
  }
  
  public String e(long paramLong) throws IOException {
    if (paramLong >= 0L) {
      long l1;
      if (paramLong == Long.MAX_VALUE) {
        l1 = Long.MAX_VALUE;
      } else {
        l1 = paramLong + 1L;
      } 
      long l2 = a((byte)10, 0L, l1);
      if (l2 != -1L)
        return this.a.f(l2); 
      if (l1 < Long.MAX_VALUE && b(l1) && this.a.b(l1 - 1L) == 13 && b(1L + l1) && this.a.b(l1) == 10)
        return this.a.f(l1); 
      c c1 = new c();
      c c2 = this.a;
      c2.a(c1, 0L, Math.min(32L, c2.b()));
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("\\n not found: limit=");
      stringBuilder1.append(Math.min(this.a.b(), paramLong));
      stringBuilder1.append(" content=");
      stringBuilder1.append(c1.n().e());
      stringBuilder1.append('…');
      throw new EOFException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("limit < 0: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public boolean e() throws IOException {
    if (!this.c)
      return (this.a.e() && this.b.a(this.a, 8192L) == -1L); 
    throw new IllegalStateException("closed");
  }
  
  public InputStream f() {
    return new InputStream(this) {
        public int available() throws IOException {
          if (!this.a.c)
            return (int)Math.min(this.a.a.b, 2147483647L); 
          throw new IOException("closed");
        }
        
        public void close() throws IOException {
          this.a.close();
        }
        
        public int read() throws IOException {
          if (!this.a.c)
            return (this.a.a.b == 0L && this.a.b.a(this.a.a, 8192L) == -1L) ? -1 : (this.a.a.h() & 0xFF); 
          throw new IOException("closed");
        }
        
        public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
          if (!this.a.c) {
            u.a(param1ArrayOfbyte.length, param1Int1, param1Int2);
            return (this.a.a.b == 0L && this.a.b.a(this.a.a, 8192L) == -1L) ? -1 : this.a.a.a(param1ArrayOfbyte, param1Int1, param1Int2);
          } 
          throw new IOException("closed");
        }
        
        public String toString() {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.a);
          stringBuilder.append(".inputStream()");
          return stringBuilder.toString();
        }
      };
  }
  
  public byte[] g(long paramLong) throws IOException {
    a(paramLong);
    return this.a.g(paramLong);
  }
  
  public byte h() throws IOException {
    a(1L);
    return this.a.h();
  }
  
  public void h(long paramLong) throws IOException {
    if (!this.c) {
      while (paramLong > 0L) {
        if (this.a.b != 0L || this.b.a(this.a, 8192L) != -1L) {
          long l = Math.min(paramLong, this.a.b());
          this.a.h(l);
          paramLong -= l;
          continue;
        } 
        throw new EOFException();
      } 
      return;
    } 
    throw new IllegalStateException("closed");
  }
  
  public short i() throws IOException {
    a(2L);
    return this.a.i();
  }
  
  public boolean isOpen() {
    return this.c ^ true;
  }
  
  public int j() throws IOException {
    a(4L);
    return this.a.j();
  }
  
  public short k() throws IOException {
    a(2L);
    return this.a.k();
  }
  
  public int l() throws IOException {
    a(4L);
    return this.a.l();
  }
  
  public long m() throws IOException {
    a(1L);
    int i = 0;
    while (true) {
      int j = i + 1;
      if (b(j)) {
        byte b = this.a.b(i);
        if ((b < 48 || b > 57) && (b < 97 || b > 102) && (b < 65 || b > 70)) {
          if (i != 0)
            break; 
          throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[] { Byte.valueOf(b) }));
        } 
        i = j;
        continue;
      } 
      break;
    } 
    return this.a.m();
  }
  
  public String p() throws IOException {
    return e(Long.MAX_VALUE);
  }
  
  public int read(ByteBuffer paramByteBuffer) throws IOException {
    return (this.a.b == 0L && this.b.a(this.a, 8192L) == -1L) ? -1 : this.a.read(paramByteBuffer);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("buffer(");
    stringBuilder.append(this.b);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */