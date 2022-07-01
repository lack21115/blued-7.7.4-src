package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class k implements s {
  private final e a;
  
  private final Inflater b;
  
  private int c;
  
  private boolean d;
  
  k(e parame, Inflater paramInflater) {
    if (parame != null) {
      if (paramInflater != null) {
        this.a = parame;
        this.b = paramInflater;
        return;
      } 
      throw new IllegalArgumentException("inflater == null");
    } 
    throw new IllegalArgumentException("source == null");
  }
  
  private void c() throws IOException {
    int i = this.c;
    if (i == 0)
      return; 
    i -= this.b.getRemaining();
    this.c -= i;
    this.a.h(i);
  }
  
  public long a(c paramc, long paramLong) throws IOException {
    int i = paramLong cmp 0L;
    if (i >= 0) {
      if (!this.d) {
        if (i == 0)
          return 0L; 
        while (true) {
          boolean bool = b();
          try {
            o o = paramc.e(1);
            i = (int)Math.min(paramLong, (8192 - o.c));
            i = this.b.inflate(o.a, o.c, i);
            if (i > 0) {
              o.c += i;
              paramLong = paramc.b;
              long l = i;
              paramc.b = paramLong + l;
              return l;
            } 
            if (this.b.finished() || this.b.needsDictionary()) {
              c();
              if (o.b == o.c) {
                paramc.a = o.b();
                p.a(o);
              } 
              return -1L;
            } 
          } catch (DataFormatException dataFormatException) {
            throw new IOException(dataFormatException);
          } 
          if (!bool)
            continue; 
          throw new EOFException("source exhausted prematurely");
        } 
      } 
      throw new IllegalStateException("closed");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("byteCount < 0: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public t a() {
    return this.a.a();
  }
  
  public final boolean b() throws IOException {
    if (!this.b.needsInput())
      return false; 
    c();
    if (this.b.getRemaining() == 0) {
      if (this.a.e())
        return true; 
      o o = (this.a.c()).a;
      this.c = o.c - o.b;
      this.b.setInput(o.a, o.b, this.c);
      return false;
    } 
    throw new IllegalStateException("?");
  }
  
  public void close() throws IOException {
    if (this.d)
      return; 
    this.b.end();
    this.d = true;
    this.a.close();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */