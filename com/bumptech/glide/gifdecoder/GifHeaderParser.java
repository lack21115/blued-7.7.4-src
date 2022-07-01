package com.bumptech.glide.gifdecoder;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class GifHeaderParser {
  private final byte[] a = new byte[256];
  
  private ByteBuffer b;
  
  private GifHeader c;
  
  private int d = 0;
  
  private void a(int paramInt) {
    boolean bool = false;
    while (!bool && !o() && this.c.c <= paramInt) {
      int i = m();
      if (i != 33) {
        if (i != 44) {
          if (i != 59) {
            this.c.b = 1;
            continue;
          } 
          bool = true;
          continue;
        } 
        if (this.c.d == null)
          this.c.d = new GifFrame(); 
        f();
        continue;
      } 
      i = m();
      if (i != 1) {
        if (i != 249) {
          if (i != 254) {
            if (i != 255) {
              k();
              continue;
            } 
            l();
            StringBuilder stringBuilder = new StringBuilder();
            for (i = 0; i < 11; i++)
              stringBuilder.append((char)this.a[i]); 
            if (stringBuilder.toString().equals("NETSCAPE2.0")) {
              g();
              continue;
            } 
            k();
            continue;
          } 
          k();
          continue;
        } 
        this.c.d = new GifFrame();
        e();
        continue;
      } 
      k();
    } 
  }
  
  private int[] b(int paramInt) {
    byte[] arrayOfByte = new byte[paramInt * 3];
    int[] arrayOfInt = null;
    try {
      this.b.get(arrayOfByte);
      int[] arrayOfInt1 = new int[256];
      int i = 0;
      int j = 0;
      while (true) {
        arrayOfInt = arrayOfInt1;
        if (i < paramInt) {
          int k = j + 1;
          j = arrayOfByte[j];
          int m = k + 1;
          arrayOfInt1[i] = (j & 0xFF) << 16 | 0xFF000000 | (arrayOfByte[k] & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
          j = m + 1;
          i++;
          continue;
        } 
        break;
      } 
    } catch (BufferUnderflowException bufferUnderflowException) {
      if (Log.isLoggable("GifHeaderParser", 3))
        Log.d("GifHeaderParser", "Format Error Reading Color Table", bufferUnderflowException); 
      this.c.b = 1;
    } 
    return arrayOfInt;
  }
  
  private void c() {
    this.b = null;
    Arrays.fill(this.a, (byte)0);
    this.c = new GifHeader();
    this.d = 0;
  }
  
  private void d() {
    a(2147483647);
  }
  
  private void e() {
    m();
    int i = m();
    this.c.d.g = (i & 0x1C) >> 2;
    int j = this.c.d.g;
    boolean bool = true;
    if (j == 0)
      this.c.d.g = 1; 
    GifFrame gifFrame = this.c.d;
    if ((i & 0x1) == 0)
      bool = false; 
    gifFrame.f = bool;
    j = n();
    i = j;
    if (j < 2)
      i = 10; 
    this.c.d.i = i * 10;
    this.c.d.h = m();
    m();
  }
  
  private void f() {
    boolean bool1;
    this.c.d.a = n();
    this.c.d.b = n();
    this.c.d.c = n();
    this.c.d.d = n();
    int i = m();
    boolean bool2 = false;
    if ((i & 0x80) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    int j = (int)Math.pow(2.0D, ((i & 0x7) + 1));
    GifFrame gifFrame = this.c.d;
    if ((i & 0x40) != 0)
      bool2 = true; 
    gifFrame.e = bool2;
    if (bool1) {
      this.c.d.k = b(j);
    } else {
      this.c.d.k = null;
    } 
    this.c.d.j = this.b.position();
    j();
    if (o())
      return; 
    GifHeader gifHeader = this.c;
    gifHeader.c++;
    this.c.e.add(this.c.d);
  }
  
  private void g() {
    do {
      l();
      byte[] arrayOfByte = this.a;
      if (arrayOfByte[0] != 1)
        continue; 
      byte b1 = arrayOfByte[1];
      byte b2 = arrayOfByte[2];
      this.c.m = (b2 & 0xFF) << 8 | b1 & 0xFF;
    } while (this.d > 0 && !o());
  }
  
  private void h() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 6; i++)
      stringBuilder.append((char)m()); 
    if (!stringBuilder.toString().startsWith("GIF")) {
      this.c.b = 1;
      return;
    } 
    i();
    if (this.c.h && !o()) {
      GifHeader gifHeader = this.c;
      gifHeader.a = b(gifHeader.i);
      gifHeader = this.c;
      gifHeader.l = gifHeader.a[this.c.j];
    } 
  }
  
  private void i() {
    boolean bool;
    this.c.f = n();
    this.c.g = n();
    int i = m();
    GifHeader gifHeader = this.c;
    if ((i & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    gifHeader.h = bool;
    this.c.i = (int)Math.pow(2.0D, ((i & 0x7) + 1));
    this.c.j = m();
    this.c.k = m();
  }
  
  private void j() {
    m();
    k();
  }
  
  private void k() {
    int i;
    do {
      i = m();
      int j = Math.min(this.b.position() + i, this.b.limit());
      this.b.position(j);
    } while (i > 0);
  }
  
  private void l() {
    this.d = m();
    if (this.d > 0) {
      int j = 0;
      int i = 0;
      while (true) {
        int k = i;
        try {
          if (j < this.d) {
            k = i;
            i = this.d - j;
            k = i;
            this.b.get(this.a, j, i);
            j += i;
            continue;
          } 
          break;
        } catch (Exception exception) {
          if (Log.isLoggable("GifHeaderParser", 3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error Reading Block n: ");
            stringBuilder.append(j);
            stringBuilder.append(" count: ");
            stringBuilder.append(k);
            stringBuilder.append(" blockSize: ");
            stringBuilder.append(this.d);
            Log.d("GifHeaderParser", stringBuilder.toString(), exception);
          } 
          this.c.b = 1;
        } 
        return;
      } 
    } 
  }
  
  private int m() {
    try {
      byte b = this.b.get();
      return b & 0xFF;
    } catch (Exception exception) {
      this.c.b = 1;
      return 0;
    } 
  }
  
  private int n() {
    return this.b.getShort();
  }
  
  private boolean o() {
    return (this.c.b != 0);
  }
  
  public GifHeaderParser a(ByteBuffer paramByteBuffer) {
    c();
    this.b = paramByteBuffer.asReadOnlyBuffer();
    this.b.position(0);
    this.b.order(ByteOrder.LITTLE_ENDIAN);
    return this;
  }
  
  public void a() {
    this.b = null;
    this.c = null;
  }
  
  public GifHeader b() {
    if (this.b != null) {
      if (o())
        return this.c; 
      h();
      if (!o()) {
        d();
        if (this.c.c < 0)
          this.c.b = 1; 
      } 
      return this.c;
    } 
    throw new IllegalStateException("You must call setData() before parseHeader()");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\gifdecoder\GifHeaderParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */