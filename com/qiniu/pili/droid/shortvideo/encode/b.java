package com.qiniu.pili.droid.shortvideo.encode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;

public class b {
  private int a;
  
  private int b;
  
  private int c = 0;
  
  private int d = 0;
  
  private int e = -1;
  
  private int f;
  
  private int g = -1;
  
  private int h = 0;
  
  private boolean i = false;
  
  private OutputStream j;
  
  private Bitmap k;
  
  private byte[] l;
  
  private byte[] m;
  
  private int n;
  
  private byte[] o;
  
  private boolean[] p = new boolean[256];
  
  private int q = 7;
  
  private int r = -1;
  
  private boolean s = false;
  
  private boolean t = true;
  
  private boolean u = false;
  
  private int v = 10;
  
  private void a(String paramString) throws IOException {
    for (int i = 0; i < paramString.length(); i++)
      this.j.write((byte)paramString.charAt(i)); 
  }
  
  private int b(int paramInt) {
    byte[] arrayOfByte = this.o;
    if (arrayOfByte == null)
      return -1; 
    int k = 0;
    int m = arrayOfByte.length;
    int j = 0;
    for (int i = 16777216; k < m; i = n) {
      arrayOfByte = this.o;
      int i1 = k + 1;
      int n = (paramInt >> 16 & 0xFF) - (arrayOfByte[k] & 0xFF);
      int i3 = i1 + 1;
      i1 = (paramInt >> 8 & 0xFF) - (arrayOfByte[i1] & 0xFF);
      k = (paramInt >> 0 & 0xFF) - (arrayOfByte[i3] & 0xFF);
      int i2 = n * n + i1 * i1 + k * k;
      k = i3 / 3;
      i1 = j;
      n = i;
      if (this.p[k]) {
        i1 = j;
        n = i;
        if (i2 < i) {
          n = i2;
          i1 = k;
        } 
      } 
      k = i3 + 1;
      j = i1;
    } 
    return j;
  }
  
  private void b() {
    byte[] arrayOfByte = this.l;
    int i = arrayOfByte.length;
    int k = i / 3;
    this.m = new byte[k];
    b b1 = new b(this, arrayOfByte, i, this.v);
    this.o = b1.d();
    int j = 0;
    i = 0;
    while (true) {
      byte[] arrayOfByte1 = this.o;
      if (i < arrayOfByte1.length) {
        byte b2 = arrayOfByte1[i];
        int n = i + 2;
        arrayOfByte1[i] = arrayOfByte1[n];
        arrayOfByte1[n] = b2;
        this.p[i / 3] = false;
        i += 3;
        continue;
      } 
      int m = 0;
      i = j;
      while (i < k) {
        arrayOfByte1 = this.l;
        j = m + 1;
        byte b2 = arrayOfByte1[m];
        m = j + 1;
        j = b1.a(b2 & 0xFF, arrayOfByte1[j] & 0xFF, arrayOfByte1[m] & 0xFF);
        this.p[j] = true;
        this.m[i] = (byte)j;
        i++;
        m++;
      } 
      this.l = null;
      this.n = 8;
      this.q = 7;
      i = this.e;
      if (i != -1)
        this.f = b(i); 
      return;
    } 
  }
  
  private int[] b(Bitmap paramBitmap) {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int[] arrayOfInt = new int[i * j];
    paramBitmap.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
    return arrayOfInt;
  }
  
  private void c() {
    int i = this.k.getWidth();
    int j = this.k.getHeight();
    if (i != this.a || j != this.b) {
      Bitmap bitmap = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.RGB_565);
      (new Canvas(bitmap)).drawBitmap(this.k, 0.0F, 0.0F, new Paint());
      this.k = bitmap;
    } 
    int[] arrayOfInt = b(this.k);
    this.l = new byte[arrayOfInt.length * 3];
    for (i = 0; i < arrayOfInt.length; i++) {
      j = arrayOfInt[i];
      int k = i * 3;
      byte[] arrayOfByte = this.l;
      int m = k + 1;
      arrayOfByte[k] = (byte)(j >> 0 & 0xFF);
      arrayOfByte[m] = (byte)(j >> 8 & 0xFF);
      arrayOfByte[m + 1] = (byte)(j >> 16 & 0xFF);
    } 
  }
  
  private void c(int paramInt) throws IOException {
    this.j.write(paramInt & 0xFF);
    this.j.write(paramInt >> 8 & 0xFF);
  }
  
  private void d() throws IOException {
    int i;
    boolean bool;
    this.j.write(33);
    this.j.write(249);
    this.j.write(4);
    if (this.e == -1) {
      bool = false;
      i = 0;
    } else {
      bool = true;
      i = 2;
    } 
    int j = this.r;
    if (j >= 0)
      i = j & 0x7; 
    this.j.write(bool | i << 2 | 0x0 | 0x0);
    c(this.h);
    this.j.write(this.f);
    this.j.write(0);
  }
  
  private void e() throws IOException {
    this.j.write(44);
    c(this.c);
    c(this.d);
    c(this.a);
    c(this.b);
    if (this.t) {
      this.j.write(0);
      return;
    } 
    this.j.write(this.q | 0x80);
  }
  
  private void f() throws IOException {
    c(this.a);
    c(this.b);
    this.j.write(this.q | 0xF0);
    this.j.write(0);
    this.j.write(0);
  }
  
  private void g() throws IOException {
    this.j.write(33);
    this.j.write(255);
    this.j.write(11);
    a("NETSCAPE2.0");
    this.j.write(3);
    this.j.write(1);
    c(this.g);
    this.j.write(0);
  }
  
  private void h() throws IOException {
    OutputStream outputStream = this.j;
    byte[] arrayOfByte = this.o;
    outputStream.write(arrayOfByte, 0, arrayOfByte.length);
    int j = this.o.length;
    for (int i = 0; i < 768 - j; i++)
      this.j.write(0); 
  }
  
  private void i() throws IOException {
    (new a(this, this.a, this.b, this.m, this.n)).b(this.j);
  }
  
  public void a(int paramInt) {
    this.h = paramInt / 10;
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.a = paramInt1;
    this.b = paramInt2;
    if (this.a < 1)
      this.a = 320; 
    if (this.b < 1)
      this.b = 240; 
    this.u = true;
  }
  
  public void a(boolean paramBoolean) {
    this.g = paramBoolean ^ true;
  }
  
  public boolean a() {
    boolean bool;
    if (!this.i)
      return false; 
    this.i = false;
    try {
      this.j.write(59);
      this.j.flush();
      if (this.s)
        this.j.close(); 
      bool = true;
    } catch (IOException iOException) {
      bool = false;
    } 
    this.f = 0;
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = null;
    this.o = null;
    this.s = false;
    this.t = true;
    return bool;
  }
  
  public boolean a(Bitmap paramBitmap) {
    boolean bool = false;
    if (paramBitmap != null) {
      if (!this.i)
        return false; 
      try {
        if (!this.u)
          a(paramBitmap.getWidth(), paramBitmap.getHeight()); 
        this.k = paramBitmap;
        c();
        b();
        if (this.t) {
          f();
          h();
          if (this.g >= 0)
            g(); 
        } 
        d();
        e();
        if (!this.t)
          h(); 
        i();
        this.t = false;
        return true;
      } catch (IOException iOException) {
        return false;
      } 
    } 
    return bool;
  }
  
  public boolean a(OutputStream paramOutputStream) {
    boolean bool = false;
    if (paramOutputStream == null)
      return false; 
    this.s = false;
    this.j = paramOutputStream;
    try {
      a("GIF89a");
      bool = true;
    } catch (IOException iOException) {}
    this.i = bool;
    return bool;
  }
  
  class a {
    int a;
    
    int b = 12;
    
    int c;
    
    int d = 4096;
    
    int[] e = new int[5003];
    
    int[] f = new int[5003];
    
    int g = 5003;
    
    int h = 0;
    
    boolean i = false;
    
    int j;
    
    int k;
    
    int l;
    
    int m = 0;
    
    int n = 0;
    
    int[] o = new int[] { 
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535 };
    
    int p;
    
    byte[] q = new byte[256];
    
    private int s;
    
    private int t;
    
    private byte[] u;
    
    private int v;
    
    private int w;
    
    private int x;
    
    a(b this$0, int param1Int1, int param1Int2, byte[] param1ArrayOfbyte, int param1Int3) {
      this.s = param1Int1;
      this.t = param1Int2;
      this.u = param1ArrayOfbyte;
      this.v = Math.max(2, param1Int3);
    }
    
    private int a() {
      int i = this.w;
      if (i == 0)
        return -1; 
      this.w = i - 1;
      byte[] arrayOfByte = this.u;
      i = this.x;
      this.x = i + 1;
      return arrayOfByte[i] & 0xFF;
    }
    
    void a(byte param1Byte, OutputStream param1OutputStream) throws IOException {
      byte[] arrayOfByte = this.q;
      int i = this.p;
      this.p = i + 1;
      arrayOfByte[i] = param1Byte;
      if (this.p >= 254)
        c(param1OutputStream); 
    }
    
    void a(int param1Int) {
      for (int i = 0; i < param1Int; i++)
        this.e[i] = -1; 
    }
    
    void a(int param1Int, OutputStream param1OutputStream) throws IOException {
      this.j = param1Int;
      int j = 0;
      this.i = false;
      this.a = this.j;
      this.c = b(this.a);
      this.k = 1 << param1Int - 1;
      param1Int = this.k;
      this.l = param1Int + 1;
      this.h = param1Int + 2;
      this.p = 0;
      int i = a();
      for (param1Int = this.g; param1Int < 65536; param1Int *= 2)
        j++; 
      int k = this.g;
      a(k);
      b(this.k, param1OutputStream);
      param1Int = i;
      label39: while (true) {
        int m = a();
        if (m != -1) {
          int i1 = (m << this.b) + param1Int;
          i = m << 8 - j ^ param1Int;
          int[] arrayOfInt = this.e;
          if (arrayOfInt[i] == i1) {
            param1Int = this.f[i];
            continue;
          } 
          int n = i;
          if (arrayOfInt[i] >= 0) {
            n = k - i;
            int i2 = i;
            if (i == 0) {
              n = 1;
              i2 = i;
            } 
            while (true) {
              i2 -= n;
              i = i2;
              if (i2 < 0)
                i = i2 + k; 
              arrayOfInt = this.e;
              if (arrayOfInt[i] == i1) {
                param1Int = this.f[i];
                continue label39;
              } 
              i2 = i;
              if (arrayOfInt[i] < 0) {
                n = i;
                break;
              } 
            } 
          } 
          b(param1Int, param1OutputStream);
          param1Int = this.h;
          if (param1Int < this.d) {
            arrayOfInt = this.f;
            this.h = param1Int + 1;
            arrayOfInt[n] = param1Int;
            this.e[n] = i1;
          } else {
            a(param1OutputStream);
          } 
          param1Int = m;
          continue;
        } 
        b(param1Int, param1OutputStream);
        b(this.l, param1OutputStream);
        return;
      } 
    }
    
    void a(OutputStream param1OutputStream) throws IOException {
      a(this.g);
      int i = this.k;
      this.h = i + 2;
      this.i = true;
      b(i, param1OutputStream);
    }
    
    final int b(int param1Int) {
      return (1 << param1Int) - 1;
    }
    
    void b(int param1Int, OutputStream param1OutputStream) throws IOException {
      int i = this.m;
      int[] arrayOfInt = this.o;
      int j = this.n;
      this.m = i & arrayOfInt[j];
      if (j > 0) {
        this.m |= param1Int << j;
      } else {
        this.m = param1Int;
      } 
      this.n += this.a;
      while (this.n >= 8) {
        a((byte)(this.m & 0xFF), param1OutputStream);
        this.m >>= 8;
        this.n -= 8;
      } 
      if (this.h > this.c || this.i)
        if (this.i) {
          i = this.j;
          this.a = i;
          this.c = b(i);
          this.i = false;
        } else {
          i = ++this.a;
          if (i == this.b) {
            this.c = this.d;
          } else {
            this.c = b(i);
          } 
        }  
      if (param1Int == this.l) {
        while (this.n > 0) {
          a((byte)(this.m & 0xFF), param1OutputStream);
          this.m >>= 8;
          this.n -= 8;
        } 
        c(param1OutputStream);
      } 
    }
    
    void b(OutputStream param1OutputStream) throws IOException {
      param1OutputStream.write(this.v);
      this.w = this.s * this.t;
      this.x = 0;
      a(this.v + 1, param1OutputStream);
      param1OutputStream.write(0);
    }
    
    void c(OutputStream param1OutputStream) throws IOException {
      int i = this.p;
      if (i > 0) {
        param1OutputStream.write(i);
        param1OutputStream.write(this.q, 0, this.p);
        this.p = 0;
      } 
    }
  }
  
  class b {
    private int b;
    
    private byte[] c;
    
    private int d;
    
    private int e;
    
    private int[][] f;
    
    private int[] g = new int[256];
    
    private int[] h = new int[256];
    
    private int[] i = new int[256];
    
    private int[] j = new int[32];
    
    public b(b this$0, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      this.c = param1ArrayOfbyte;
      this.d = param1Int1;
      this.e = param1Int2;
      this.f = new int[256][];
      for (param1Int1 = 0; param1Int1 < 256; param1Int1++) {
        int[][] arrayOfInt1 = this.f;
        arrayOfInt1[param1Int1] = new int[4];
        int[] arrayOfInt = arrayOfInt1[param1Int1];
        param1Int2 = (param1Int1 << 12) / 256;
        arrayOfInt[2] = param1Int2;
        arrayOfInt[1] = param1Int2;
        arrayOfInt[0] = param1Int2;
        this.i[param1Int1] = 256;
        this.h[param1Int1] = 0;
      } 
    }
    
    private void a(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5) {
      int j = param1Int2 - param1Int1;
      int i = j;
      if (j < -1)
        i = -1; 
      param1Int1 = param1Int2 + param1Int1;
      j = param1Int1;
      if (param1Int1 > 256)
        j = 256; 
      int k = param1Int2 + 1;
      param1Int2--;
      param1Int1 = 1;
      while (true) {
        if (k < j || param1Int2 > i) {
          int[] arrayOfInt = this.j;
          int m = param1Int1 + 1;
          int n = arrayOfInt[param1Int1];
          param1Int1 = k;
          if (k < j) {
            arrayOfInt = this.f[k];
            try {
              arrayOfInt[0] = arrayOfInt[0] - (arrayOfInt[0] - param1Int3) * n / 262144;
              arrayOfInt[1] = arrayOfInt[1] - (arrayOfInt[1] - param1Int4) * n / 262144;
              arrayOfInt[2] = arrayOfInt[2] - (arrayOfInt[2] - param1Int5) * n / 262144;
            } catch (Exception exception) {}
            param1Int1 = k + 1;
          } 
          if (param1Int2 > i) {
            arrayOfInt = this.f[param1Int2];
            try {
              arrayOfInt[0] = arrayOfInt[0] - (arrayOfInt[0] - param1Int3) * n / 262144;
              arrayOfInt[1] = arrayOfInt[1] - (arrayOfInt[1] - param1Int4) * n / 262144;
              arrayOfInt[2] = arrayOfInt[2] - n * (arrayOfInt[2] - param1Int5) / 262144;
            } catch (Exception exception) {}
            param1Int2--;
            k = param1Int1;
            param1Int1 = m;
            continue;
          } 
          k = param1Int1;
          param1Int1 = m;
          continue;
        } 
        return;
      } 
    }
    
    private int b(int param1Int1, int param1Int2, int param1Int3) {
      int n = -1;
      int i = 0;
      int k = -1;
      int m = Integer.MAX_VALUE;
      int j;
      for (j = Integer.MAX_VALUE; i < 256; j = i2) {
        int[] arrayOfInt1 = this.f[i];
        int i2 = arrayOfInt1[0] - param1Int1;
        int i1 = i2;
        if (i2 < 0)
          i1 = -i2; 
        int i3 = arrayOfInt1[1] - param1Int2;
        i2 = i3;
        if (i3 < 0)
          i2 = -i3; 
        int i4 = arrayOfInt1[2] - param1Int3;
        i3 = i4;
        if (i4 < 0)
          i3 = -i4; 
        i2 = i1 + i2 + i3;
        i1 = m;
        if (i2 < m) {
          n = i;
          i1 = i2;
        } 
        m = i2 - (this.h[i] >> 12);
        i2 = j;
        if (m < j) {
          k = i;
          i2 = m;
        } 
        arrayOfInt1 = this.i;
        j = arrayOfInt1[i] >> 10;
        arrayOfInt1[i] = arrayOfInt1[i] - j;
        arrayOfInt1 = this.h;
        arrayOfInt1[i] = arrayOfInt1[i] + (j << 10);
        i++;
        m = i1;
      } 
      int[] arrayOfInt = this.i;
      arrayOfInt[n] = arrayOfInt[n] + 64;
      arrayOfInt = this.h;
      arrayOfInt[n] = arrayOfInt[n] - 65536;
      return k;
    }
    
    private void b(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5) {
      int[] arrayOfInt = this.f[param1Int2];
      arrayOfInt[0] = arrayOfInt[0] - (arrayOfInt[0] - param1Int3) * param1Int1 / 1024;
      arrayOfInt[1] = arrayOfInt[1] - (arrayOfInt[1] - param1Int4) * param1Int1 / 1024;
      arrayOfInt[2] = arrayOfInt[2] - param1Int1 * (arrayOfInt[2] - param1Int5) / 1024;
    }
    
    public int a(int param1Int1, int param1Int2, int param1Int3) {
      int m = this.g[param1Int2];
      int i = m - 1;
      int j = -1;
      int k = 1000;
      while (true) {
        if (m < 256 || i >= 0) {
          int n = m;
          int i2 = j;
          int i1 = k;
          if (m < 256) {
            int[] arrayOfInt = this.f[m];
            i1 = arrayOfInt[1] - param1Int2;
            if (i1 >= k) {
              n = 256;
              i2 = j;
              i1 = k;
            } else {
              m++;
              n = i1;
              if (i1 < 0)
                n = -i1; 
              i2 = arrayOfInt[0] - param1Int1;
              i1 = i2;
              if (i2 < 0)
                i1 = -i2; 
              int i3 = n + i1;
              n = m;
              i2 = j;
              i1 = k;
              if (i3 < k) {
                i1 = arrayOfInt[2] - param1Int3;
                n = i1;
                if (i1 < 0)
                  n = -i1; 
                i3 += n;
                n = m;
                i2 = j;
                i1 = k;
                if (i3 < k) {
                  i2 = arrayOfInt[3];
                  i1 = i3;
                  n = m;
                } 
              } 
            } 
          } 
          m = n;
          j = i2;
          k = i1;
          if (i >= 0) {
            int[] arrayOfInt = this.f[i];
            j = param1Int2 - arrayOfInt[1];
            if (j >= i1) {
              i = -1;
              m = n;
              j = i2;
              k = i1;
              continue;
            } 
            int i3 = i - 1;
            i = j;
            if (j < 0)
              i = -j; 
            k = arrayOfInt[0] - param1Int1;
            j = k;
            if (k < 0)
              j = -k; 
            int i4 = i + j;
            m = n;
            i = i3;
            j = i2;
            k = i1;
            if (i4 < i1) {
              j = arrayOfInt[2] - param1Int3;
              i = j;
              if (j < 0)
                i = -j; 
              i4 = i + i4;
              m = n;
              i = i3;
              j = i2;
              k = i1;
              if (i4 < i1) {
                j = arrayOfInt[3];
                k = i4;
                m = n;
                i = i3;
              } 
            } 
          } 
          continue;
        } 
        return j;
      } 
    }
    
    public byte[] a() {
      byte[] arrayOfByte = new byte[768];
      int[] arrayOfInt = new int[256];
      int i;
      for (i = 0; i < 256; i++)
        arrayOfInt[this.f[i][3]] = i; 
      i = 0;
      for (int j = 0; i < 256; j++) {
        int k = arrayOfInt[i];
        int m = j + 1;
        int[][] arrayOfInt1 = this.f;
        arrayOfByte[j] = (byte)arrayOfInt1[k][0];
        j = m + 1;
        arrayOfByte[m] = (byte)arrayOfInt1[k][1];
        arrayOfByte[j] = (byte)arrayOfInt1[k][2];
        i++;
      } 
      return arrayOfByte;
    }
    
    public void b() {
      int i = 0;
      int j = 0;
      int k;
      for (k = 0; i < 256; k = n) {
        int[] arrayOfInt1 = this.f[i];
        int m = arrayOfInt1[1];
        int i1 = i + 1;
        int n = i;
        int i2 = i1;
        int i3 = n;
        n = i2;
        while (n < 256) {
          int[] arrayOfInt = this.f[n];
          i2 = m;
          if (arrayOfInt[1] < m) {
            i2 = arrayOfInt[1];
            i3 = n;
          } 
          n++;
          m = i2;
        } 
        int[] arrayOfInt2 = this.f[i3];
        if (i != i3) {
          n = arrayOfInt2[0];
          arrayOfInt2[0] = arrayOfInt1[0];
          arrayOfInt1[0] = n;
          n = arrayOfInt2[1];
          arrayOfInt2[1] = arrayOfInt1[1];
          arrayOfInt1[1] = n;
          n = arrayOfInt2[2];
          arrayOfInt2[2] = arrayOfInt1[2];
          arrayOfInt1[2] = n;
          n = arrayOfInt2[3];
          arrayOfInt2[3] = arrayOfInt1[3];
          arrayOfInt1[3] = n;
        } 
        i2 = j;
        n = k;
        if (m != j) {
          this.g[j] = k + i >> 1;
          while (true) {
            if (++j < m) {
              this.g[j] = i;
              continue;
            } 
            n = i;
            i2 = m;
            break;
          } 
        } 
        i = i1;
        j = i2;
      } 
      this.g[j] = k + 255 >> 1;
      for (i = j + 1; i < 256; i++)
        this.g[i] = 255; 
    }
    
    public void c() {
      if (this.d < 1509)
        this.e = 1; 
      int i = this.e;
      this.b = (i - 1) / 3 + 30;
      byte[] arrayOfByte = this.c;
      int i3 = this.d;
      int i4 = i3 / i * 3;
      int n = i4 / 100;
      for (i = 0; i < 32; i++)
        this.j[i] = 1024 * (1024 - i * i) * 256 / 1024; 
      i = this.d;
      if (i < 1509) {
        i = 3;
      } else if (i % 499 != 0) {
        i = 1497;
      } else if (i % 491 != 0) {
        i = 1473;
      } else if (i % 487 != 0) {
        i = 1461;
      } else {
        i = 1509;
      } 
      int i1 = 0;
      int i2 = 0;
      int k = 1024;
      int m = 32;
      int j = 2048;
      while (i1 < i4) {
        int i5 = (arrayOfByte[i2 + 0] & 0xFF) << 4;
        int i6 = (arrayOfByte[i2 + 1] & 0xFF) << 4;
        int i7 = (arrayOfByte[i2 + 2] & 0xFF) << 4;
        int i8 = b(i5, i6, i7);
        b(k, i8, i5, i6, i7);
        if (m != 0)
          a(m, i8, i5, i6, i7); 
        i6 = i2 + i;
        i5 = i6;
        if (i6 >= i3)
          i5 = i6 - this.d; 
        i7 = i1 + 1;
        i6 = n;
        if (n == 0)
          i6 = 1; 
        i1 = i7;
        i2 = i5;
        n = i6;
        if (i7 % i6 == 0) {
          m = k - k / this.b;
          i8 = j - j / 30;
          k = i8 >> 6;
          j = k;
          if (k <= 1)
            j = 0; 
          for (k = 0; k < j; k++) {
            int[] arrayOfInt = this.j;
            n = j * j;
            arrayOfInt[k] = (n - k * k) * 256 / n * m;
          } 
          i1 = i7;
          i2 = i5;
          k = m;
          m = j;
          n = i6;
          j = i8;
        } 
      } 
    }
    
    public byte[] d() {
      c();
      e();
      b();
      return a();
    }
    
    public void e() {
      for (int i = 0; i < 256; i++) {
        int[][] arrayOfInt = this.f;
        int[] arrayOfInt1 = arrayOfInt[i];
        arrayOfInt1[0] = arrayOfInt1[0] >> 4;
        arrayOfInt1 = arrayOfInt[i];
        arrayOfInt1[1] = arrayOfInt1[1] >> 4;
        arrayOfInt1 = arrayOfInt[i];
        arrayOfInt1[2] = arrayOfInt1[2] >> 4;
        arrayOfInt[i][3] = i;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\encode\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */