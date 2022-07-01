package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public final class ap implements Closeable {
  public static final Charset a = Charset.forName("US-ASCII");
  
  private final InputStream b;
  
  private final Charset c;
  
  private byte[] d;
  
  private int e;
  
  private int f;
  
  public ap(InputStream paramInputStream, Charset paramCharset) {
    this(paramInputStream, paramCharset, (byte)0);
  }
  
  private ap(InputStream paramInputStream, Charset paramCharset, byte paramByte) {
    if (paramInputStream != null && paramCharset != null) {
      if (paramCharset.equals(a)) {
        this.b = paramInputStream;
        this.c = paramCharset;
        this.d = new byte[8192];
        return;
      } 
      throw new IllegalArgumentException("Unsupported encoding");
    } 
    throw new NullPointerException();
  }
  
  private void b() throws IOException {
    InputStream inputStream = this.b;
    byte[] arrayOfByte = this.d;
    int i = inputStream.read(arrayOfByte, 0, arrayOfByte.length);
    if (i != -1) {
      this.e = 0;
      this.f = i;
      return;
    } 
    throw new EOFException();
  }
  
  public final String a() throws IOException {
    synchronized (this.b) {
      if (this.d != null) {
        if (this.e >= this.f)
          b(); 
        for (int i = this.e;; i++) {
          if (i != this.f) {
            if (this.d[i] == 10) {
              if (i != this.e) {
                byte[] arrayOfByte = this.d;
                int k = i - 1;
                if (arrayOfByte[k] == 13) {
                  String str1 = new String(this.d, this.e, k - this.e, this.c.name());
                  this.e = i + 1;
                  return str1;
                } 
              } 
              int j = i;
              String str = new String(this.d, this.e, j - this.e, this.c.name());
              this.e = i + 1;
              return str;
            } 
          } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this, this.f - this.e + 80) {
                public final String toString() {
                  int i;
                  if (this.count > 0 && this.buf[this.count - 1] == 13) {
                    i = this.count - 1;
                  } else {
                    i = this.count;
                  } 
                  try {
                    return new String(this.buf, 0, i, ap.a(this.a).name());
                  } catch (UnsupportedEncodingException unsupportedEncodingException) {
                    throw new AssertionError(unsupportedEncodingException);
                  } 
                }
              };
            while (true) {
              byteArrayOutputStream.write(this.d, this.e, this.f - this.e);
              this.f = -1;
              b();
              for (i = this.e; i != this.f; i++) {
                if (this.d[i] == 10) {
                  if (i != this.e)
                    byteArrayOutputStream.write(this.d, this.e, i - this.e); 
                  this.e = i + 1;
                  return byteArrayOutputStream.toString();
                } 
              } 
            } 
            break;
          } 
        } 
      } 
      throw new IOException("LineReader is closed");
    } 
  }
  
  public final void close() throws IOException {
    synchronized (this.b) {
      if (this.d != null) {
        this.d = null;
        this.b.close();
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */