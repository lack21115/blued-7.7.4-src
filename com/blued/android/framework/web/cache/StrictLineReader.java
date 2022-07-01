package com.blued.android.framework.web.cache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class StrictLineReader implements Closeable {
  private final InputStream a;
  
  private final Charset b;
  
  private byte[] c;
  
  private int d;
  
  private int e;
  
  public StrictLineReader(InputStream paramInputStream, int paramInt, Charset paramCharset) {
    if (paramInputStream != null && paramCharset != null) {
      if (paramInt >= 0) {
        if (paramCharset.equals(Util.a)) {
          this.a = paramInputStream;
          this.b = paramCharset;
          this.c = new byte[paramInt];
          return;
        } 
        throw new IllegalArgumentException("Unsupported encoding");
      } 
      throw new IllegalArgumentException("capacity <= 0");
    } 
    throw new NullPointerException();
  }
  
  public StrictLineReader(InputStream paramInputStream, Charset paramCharset) {
    this(paramInputStream, 8192, paramCharset);
  }
  
  private void c() throws IOException {
    InputStream inputStream = this.a;
    byte[] arrayOfByte = this.c;
    int i = inputStream.read(arrayOfByte, 0, arrayOfByte.length);
    if (i != -1) {
      this.d = 0;
      this.e = i;
      return;
    } 
    throw new EOFException();
  }
  
  public String a() throws IOException {
    synchronized (this.a) {
      if (this.c != null) {
        if (this.d >= this.e)
          c(); 
        for (int i = this.d;; i++) {
          if (i != this.e) {
            if (this.c[i] == 10) {
              if (i != this.d) {
                byte[] arrayOfByte = this.c;
                int k = i - 1;
                if (arrayOfByte[k] == 13) {
                  String str1 = new String(this.c, this.d, k - this.d, this.b.name());
                  this.d = i + 1;
                  return str1;
                } 
              } 
              int j = i;
              String str = new String(this.c, this.d, j - this.d, this.b.name());
              this.d = i + 1;
              return str;
            } 
          } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this, this.e - this.d + 80) {
                public String toString() {
                  int i;
                  if (this.count > 0 && this.buf[this.count - 1] == 13) {
                    i = this.count - 1;
                  } else {
                    i = this.count;
                  } 
                  try {
                    return new String(this.buf, 0, i, StrictLineReader.a(this.a).name());
                  } catch (UnsupportedEncodingException unsupportedEncodingException) {
                    throw new AssertionError(unsupportedEncodingException);
                  } 
                }
              };
            while (true) {
              byteArrayOutputStream.write(this.c, this.d, this.e - this.d);
              this.e = -1;
              c();
              for (i = this.d; i != this.e; i++) {
                if (this.c[i] == 10) {
                  if (i != this.d)
                    byteArrayOutputStream.write(this.c, this.d, i - this.d); 
                  this.d = i + 1;
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
  
  public boolean b() {
    return (this.e == -1);
  }
  
  public void close() throws IOException {
    synchronized (this.a) {
      if (this.c != null) {
        this.c = null;
        this.a.close();
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\web\cache\StrictLineReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */