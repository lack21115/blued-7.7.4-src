package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class j implements s {
  private int a = 0;
  
  private final e b;
  
  private final Inflater c;
  
  private final k d;
  
  private final CRC32 e = new CRC32();
  
  public j(s params) {
    if (params != null) {
      this.c = new Inflater(true);
      this.b = l.a(params);
      this.d = new k(this.b, this.c);
      return;
    } 
    throw new IllegalArgumentException("source == null");
  }
  
  private void a(c paramc, long paramLong1, long paramLong2) {
    o o;
    for (o = paramc.a; paramLong1 >= (o.c - o.b); o = o.f)
      paramLong1 -= (o.c - o.b); 
    while (paramLong2 > 0L) {
      int i = (int)(o.b + paramLong1);
      int m = (int)Math.min((o.c - i), paramLong2);
      this.e.update(o.a, i, m);
      paramLong2 -= m;
      o = o.f;
      paramLong1 = 0L;
    } 
  }
  
  private void a(String paramString, int paramInt1, int paramInt2) throws IOException {
    if (paramInt2 == paramInt1)
      return; 
    throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
  }
  
  private void b() throws IOException {
    boolean bool;
    this.b.a(10L);
    byte b = this.b.c().b(3L);
    if ((b >> 1 & 0x1) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool)
      a(this.b.c(), 0L, 10L); 
    a("ID1ID2", 8075, this.b.i());
    this.b.h(8L);
    if ((b >> 2 & 0x1) == 1) {
      this.b.a(2L);
      if (bool)
        a(this.b.c(), 0L, 2L); 
      short s1 = this.b.c().k();
      e e1 = this.b;
      long l = s1;
      e1.a(l);
      if (bool)
        a(this.b.c(), 0L, l); 
      this.b.h(l);
    } 
    if ((b >> 3 & 0x1) == 1) {
      long l = this.b.a((byte)0);
      if (l != -1L) {
        if (bool)
          a(this.b.c(), 0L, l + 1L); 
        this.b.h(l + 1L);
      } else {
        throw new EOFException();
      } 
    } 
    if ((b >> 4 & 0x1) == 1) {
      long l = this.b.a((byte)0);
      if (l != -1L) {
        if (bool)
          a(this.b.c(), 0L, l + 1L); 
        this.b.h(l + 1L);
      } else {
        throw new EOFException();
      } 
    } 
    if (bool) {
      a("FHCRC", this.b.k(), (short)(int)this.e.getValue());
      this.e.reset();
    } 
  }
  
  private void c() throws IOException {
    a("CRC", this.b.l(), (int)this.e.getValue());
    a("ISIZE", this.b.l(), (int)this.c.getBytesWritten());
  }
  
  public long a(c paramc, long paramLong) throws IOException {
    int i = paramLong cmp 0L;
    if (i >= 0) {
      if (i == 0)
        return 0L; 
      if (this.a == 0) {
        b();
        this.a = 1;
      } 
      if (this.a == 1) {
        long l = paramc.b;
        paramLong = this.d.a(paramc, paramLong);
        if (paramLong != -1L) {
          a(paramc, l, paramLong);
          return paramLong;
        } 
        this.a = 2;
      } 
      if (this.a == 2) {
        c();
        this.a = 3;
        if (this.b.e())
          return -1L; 
        throw new IOException("gzip finished without exhausting source");
      } 
      return -1L;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("byteCount < 0: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public t a() {
    return this.b.a();
  }
  
  public void close() throws IOException {
    this.d.close();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */