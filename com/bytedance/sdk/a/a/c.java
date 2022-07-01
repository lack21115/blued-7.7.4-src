package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

public final class c implements d, e, Cloneable, ByteChannel {
  private static final byte[] c = new byte[] { 
      48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
      97, 98, 99, 100, 101, 102 };
  
  o a;
  
  long b;
  
  public int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    u.a(paramArrayOfbyte.length, paramInt1, paramInt2);
    o o1 = this.a;
    if (o1 == null)
      return -1; 
    paramInt2 = Math.min(paramInt2, o1.c - o1.b);
    System.arraycopy(o1.a, o1.b, paramArrayOfbyte, paramInt1, paramInt2);
    o1.b += paramInt2;
    this.b -= paramInt2;
    if (o1.b == o1.c) {
      this.a = o1.b();
      p.a(o1);
    } 
    return paramInt2;
  }
  
  public long a(byte paramByte) {
    return a(paramByte, 0L, Long.MAX_VALUE);
  }
  
  public long a(byte paramByte, long paramLong1, long paramLong2) {
    long l = 0L;
    if (paramLong1 >= 0L && paramLong2 >= paramLong1) {
      long l1 = this.b;
      if (paramLong2 <= l1)
        l1 = paramLong2; 
      if (paramLong1 == l1)
        return -1L; 
      o o2 = this.a;
      if (o2 == null)
        return -1L; 
      long l2 = this.b;
      paramLong2 = l;
      o o1 = o2;
      if (l2 - paramLong1 < paramLong1) {
        l = l2;
        o1 = o2;
        while (true) {
          o2 = o1;
          paramLong2 = l;
          if (l > paramLong1) {
            o1 = o1.g;
            l -= (o1.c - o1.b);
            continue;
          } 
          break;
        } 
      } else {
        while (true) {
          l = (o1.c - o1.b) + paramLong2;
          o2 = o1;
          if (l < paramLong1) {
            o1 = o1.f;
            paramLong2 = l;
            continue;
          } 
          break;
        } 
      } 
      while (paramLong2 < l1) {
        byte[] arrayOfByte = o2.a;
        int j = (int)Math.min(o2.c, o2.b + l1 - paramLong2);
        int i;
        for (i = (int)(o2.b + paramLong1 - paramLong2); i < j; i++) {
          if (arrayOfByte[i] == paramByte)
            return (i - o2.b) + paramLong2; 
        } 
        paramLong1 = (o2.c - o2.b) + paramLong2;
        o2 = o2.f;
        paramLong2 = paramLong1;
      } 
      return -1L;
    } 
    throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(this.b), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  public long a(c paramc, long paramLong) {
    if (paramc != null) {
      if (paramLong >= 0L) {
        long l2 = this.b;
        if (l2 == 0L)
          return -1L; 
        long l1 = paramLong;
        if (paramLong > l2)
          l1 = l2; 
        paramc.a_(this, l1);
        return l1;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("byteCount < 0: ");
      stringBuilder.append(paramLong);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("sink == null");
  }
  
  public long a(s params) throws IOException {
    if (params != null) {
      long l = 0L;
      while (true) {
        long l1 = params.a(this, 8192L);
        if (l1 != -1L) {
          l += l1;
          continue;
        } 
        return l;
      } 
    } 
    throw new IllegalArgumentException("source == null");
  }
  
  public c a(int paramInt) {
    if (paramInt < 128) {
      b(paramInt);
      return this;
    } 
    if (paramInt < 2048) {
      b(paramInt >> 6 | 0xC0);
      b(paramInt & 0x3F | 0x80);
      return this;
    } 
    if (paramInt < 65536) {
      if (paramInt >= 55296 && paramInt <= 57343) {
        b(63);
        return this;
      } 
      b(paramInt >> 12 | 0xE0);
      b(paramInt >> 6 & 0x3F | 0x80);
      b(paramInt & 0x3F | 0x80);
      return this;
    } 
    if (paramInt <= 1114111) {
      b(paramInt >> 18 | 0xF0);
      b(paramInt >> 12 & 0x3F | 0x80);
      b(paramInt >> 6 & 0x3F | 0x80);
      b(paramInt & 0x3F | 0x80);
      return this;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected code point: ");
    stringBuilder.append(Integer.toHexString(paramInt));
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final c a(c paramc, long paramLong1, long paramLong2) {
    if (paramc != null) {
      long l1;
      long l2;
      o o2;
      u.a(this.b, paramLong1, paramLong2);
      if (paramLong2 == 0L)
        return this; 
      paramc.b += paramLong2;
      o o1 = this.a;
      while (true) {
        o2 = o1;
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramLong1 >= (o1.c - o1.b)) {
          paramLong1 -= (o1.c - o1.b);
          o1 = o1.f;
          continue;
        } 
        break;
      } 
      while (l2 > 0L) {
        o1 = o2.a();
        o1.b = (int)(o1.b + l1);
        o1.c = Math.min(o1.b + (int)l2, o1.c);
        o o3 = paramc.a;
        if (o3 == null) {
          o1.g = o1;
          o1.f = o1;
          paramc.a = o1;
        } else {
          o3.g.a(o1);
        } 
        l2 -= (o1.c - o1.b);
        o2 = o2.f;
        l1 = 0L;
      } 
      return this;
    } 
    throw new IllegalArgumentException("out == null");
  }
  
  public c a(f paramf) {
    if (paramf != null) {
      paramf.a(this);
      return this;
    } 
    throw new IllegalArgumentException("byteString == null");
  }
  
  public c a(String paramString) {
    return a(paramString, 0, paramString.length());
  }
  
  public c a(String paramString, int paramInt1, int paramInt2) {
    if (paramString != null) {
      if (paramInt1 >= 0) {
        if (paramInt2 >= paramInt1) {
          if (paramInt2 <= paramString.length()) {
            while (paramInt1 < paramInt2) {
              char c1 = paramString.charAt(paramInt1);
              if (c1 < '') {
                o o1 = e(1);
                byte[] arrayOfByte = o1.a;
                int j = o1.c - paramInt1;
                int k = Math.min(paramInt2, 8192 - j);
                int i = paramInt1 + 1;
                arrayOfByte[paramInt1 + j] = (byte)c1;
                for (paramInt1 = i; paramInt1 < k; paramInt1++) {
                  i = paramString.charAt(paramInt1);
                  if (i >= 128)
                    break; 
                  arrayOfByte[paramInt1 + j] = (byte)i;
                } 
                i = j + paramInt1 - o1.c;
                o1.c += i;
                this.b += i;
                continue;
              } 
              if (c1 < 'ࠀ') {
                b(c1 >> 6 | 0xC0);
                b(c1 & 0x3F | 0x80);
              } else if (c1 < '?' || c1 > '?') {
                b(c1 >> 12 | 0xE0);
                b(c1 >> 6 & 0x3F | 0x80);
                b(c1 & 0x3F | 0x80);
              } else {
                int j = paramInt1 + 1;
                if (j < paramInt2) {
                  i = paramString.charAt(j);
                } else {
                  i = 0;
                } 
                if (c1 > '?' || i < 56320 || i > 57343) {
                  b(63);
                  paramInt1 = j;
                  continue;
                } 
                int i = ((c1 & 0xFFFF27FF) << 10 | 0xFFFF23FF & i) + 65536;
                b(i >> 18 | 0xF0);
                b(i >> 12 & 0x3F | 0x80);
                b(i >> 6 & 0x3F | 0x80);
                b(i & 0x3F | 0x80);
                paramInt1 += 2;
                continue;
              } 
              paramInt1++;
            } 
            return this;
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("endIndex > string.length: ");
          stringBuilder2.append(paramInt2);
          stringBuilder2.append(" > ");
          stringBuilder2.append(paramString.length());
          throw new IllegalArgumentException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("endIndex < beginIndex: ");
        stringBuilder1.append(paramInt2);
        stringBuilder1.append(" < ");
        stringBuilder1.append(paramInt1);
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("beginIndex < 0: ");
      stringBuilder.append(paramInt1);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("string == null");
  }
  
  public c a(String paramString, int paramInt1, int paramInt2, Charset paramCharset) {
    if (paramString != null) {
      if (paramInt1 >= 0) {
        if (paramInt2 >= paramInt1) {
          byte[] arrayOfByte;
          if (paramInt2 <= paramString.length()) {
            if (paramCharset != null) {
              if (paramCharset.equals(u.a))
                return a(paramString, paramInt1, paramInt2); 
              arrayOfByte = paramString.substring(paramInt1, paramInt2).getBytes(paramCharset);
              return b(arrayOfByte, 0, arrayOfByte.length);
            } 
            throw new IllegalArgumentException("charset == null");
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("endIndex > string.length: ");
          stringBuilder2.append(paramInt2);
          stringBuilder2.append(" > ");
          stringBuilder2.append(arrayOfByte.length());
          throw new IllegalArgumentException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("endIndex < beginIndex: ");
        stringBuilder1.append(paramInt2);
        stringBuilder1.append(" < ");
        stringBuilder1.append(paramInt1);
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("beginIndex < 0: ");
      stringBuilder.append(paramInt1);
      throw new IllegalAccessError(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("string == null");
  }
  
  public t a() {
    return t.c;
  }
  
  public String a(long paramLong, Charset paramCharset) throws EOFException {
    u.a(this.b, 0L, paramLong);
    if (paramCharset != null) {
      if (paramLong <= 2147483647L) {
        if (paramLong == 0L)
          return ""; 
        o o1 = this.a;
        if (o1.b + paramLong > o1.c)
          return new String(g(paramLong), paramCharset); 
        String str = new String(o1.a, o1.b, (int)paramLong, paramCharset);
        o1.b = (int)(o1.b + paramLong);
        this.b -= paramLong;
        if (o1.b == o1.c) {
          this.a = o1.b();
          p.a(o1);
        } 
        return str;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("byteCount > Integer.MAX_VALUE: ");
      stringBuilder.append(paramLong);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("charset == null");
  }
  
  public void a(long paramLong) throws EOFException {
    if (this.b >= paramLong)
      return; 
    throw new EOFException();
  }
  
  public void a(byte[] paramArrayOfbyte) throws EOFException {
    int i = 0;
    while (i < paramArrayOfbyte.length) {
      int j = a(paramArrayOfbyte, i, paramArrayOfbyte.length - i);
      if (j != -1) {
        i += j;
        continue;
      } 
      throw new EOFException();
    } 
  }
  
  public void a_(c paramc, long paramLong) {
    if (paramc != null) {
      if (paramc != this) {
        u.a(paramc.b, 0L, paramLong);
        while (paramLong > 0L) {
          if (paramLong < (paramc.a.c - paramc.a.b)) {
            o o3 = this.a;
            if (o3 != null) {
              o3 = o3.g;
            } else {
              o3 = null;
            } 
            if (o3 != null && o3.e) {
              int i;
              long l1 = o3.c;
              if (o3.d) {
                i = 0;
              } else {
                i = o3.b;
              } 
              if (l1 + paramLong - i <= 8192L) {
                paramc.a.a(o3, (int)paramLong);
                paramc.b -= paramLong;
                this.b += paramLong;
                return;
              } 
            } 
            paramc.a = paramc.a.a((int)paramLong);
          } 
          o o1 = paramc.a;
          long l = (o1.c - o1.b);
          paramc.a = o1.b();
          o o2 = this.a;
          if (o2 == null) {
            this.a = o1;
            o1 = this.a;
            o1.g = o1;
            o1.f = o1;
          } else {
            o2.g.a(o1).c();
          } 
          paramc.b -= l;
          this.b += l;
          paramLong -= l;
        } 
        return;
      } 
      throw new IllegalArgumentException("source == this");
    } 
    throw new IllegalArgumentException("source == null");
  }
  
  public final byte b(long paramLong) {
    u.a(this.b, paramLong, 1L);
    long l = this.b;
    if (l - paramLong > paramLong)
      for (o o2 = this.a;; o2 = o2.f) {
        l = (o2.c - o2.b);
        if (paramLong < l)
          return o2.a[o2.b + (int)paramLong]; 
        paramLong -= l;
      }  
    paramLong -= l;
    o o1 = this.a;
    while (true) {
      o o2 = o1.g;
      l = paramLong + (o2.c - o2.b);
      o1 = o2;
      paramLong = l;
      if (l >= 0L)
        return o2.a[o2.b + (int)l]; 
    } 
  }
  
  public final long b() {
    return this.b;
  }
  
  public c b(int paramInt) {
    o o1 = e(1);
    byte[] arrayOfByte = o1.a;
    int i = o1.c;
    o1.c = i + 1;
    arrayOfByte[i] = (byte)paramInt;
    this.b++;
    return this;
  }
  
  public c b(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null)
      return b(paramArrayOfbyte, 0, paramArrayOfbyte.length); 
    throw new IllegalArgumentException("source == null");
  }
  
  public c b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramArrayOfbyte != null) {
      long l1 = paramArrayOfbyte.length;
      long l2 = paramInt1;
      long l3 = paramInt2;
      u.a(l1, l2, l3);
      paramInt2 += paramInt1;
      while (paramInt1 < paramInt2) {
        o o1 = e(1);
        int i = Math.min(paramInt2 - paramInt1, 8192 - o1.c);
        System.arraycopy(paramArrayOfbyte, paramInt1, o1.a, o1.c, i);
        paramInt1 += i;
        o1.c += i;
      } 
      this.b += l3;
      return this;
    } 
    throw new IllegalArgumentException("source == null");
  }
  
  public c c() {
    return this;
  }
  
  public c c(int paramInt) {
    o o1 = e(2);
    byte[] arrayOfByte = o1.a;
    int i = o1.c;
    int j = i + 1;
    arrayOfByte[i] = (byte)(paramInt >>> 8 & 0xFF);
    arrayOfByte[j] = (byte)(paramInt & 0xFF);
    o1.c = j + 1;
    this.b += 2L;
    return this;
  }
  
  public f c(long paramLong) throws EOFException {
    return new f(g(paramLong));
  }
  
  public void close() {}
  
  public c d() {
    return this;
  }
  
  public c d(int paramInt) {
    o o1 = e(4);
    byte[] arrayOfByte = o1.a;
    int j = o1.c;
    int i = j + 1;
    arrayOfByte[j] = (byte)(paramInt >>> 24 & 0xFF);
    j = i + 1;
    arrayOfByte[i] = (byte)(paramInt >>> 16 & 0xFF);
    i = j + 1;
    arrayOfByte[j] = (byte)(paramInt >>> 8 & 0xFF);
    arrayOfByte[i] = (byte)(paramInt & 0xFF);
    o1.c = i + 1;
    this.b += 4L;
    return this;
  }
  
  public String d(long paramLong) throws EOFException {
    return a(paramLong, u.a);
  }
  
  o e(int paramInt) {
    o o1;
    if (paramInt >= 1 && paramInt <= 8192) {
      o o2 = this.a;
      if (o2 == null) {
        this.a = p.a();
        o2 = this.a;
        o2.g = o2;
        o2.f = o2;
        return o2;
      } 
      o1 = o2.g;
      if (o1.c + paramInt <= 8192) {
        o2 = o1;
        return !o1.e ? o1.a(p.a()) : o2;
      } 
    } else {
      throw new IllegalArgumentException();
    } 
    return o1.a(p.a());
  }
  
  public String e(long paramLong) throws EOFException {
    if (paramLong >= 0L) {
      long l1 = Long.MAX_VALUE;
      if (paramLong != Long.MAX_VALUE)
        l1 = paramLong + 1L; 
      long l2 = a((byte)10, 0L, l1);
      if (l2 != -1L)
        return f(l2); 
      if (l1 < b() && b(l1 - 1L) == 13 && b(l1) == 10)
        return f(l1); 
      c c1 = new c();
      a(c1, 0L, Math.min(32L, b()));
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("\\n not found: limit=");
      stringBuilder1.append(Math.min(b(), paramLong));
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
  
  public boolean e() {
    return (this.b == 0L);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof c))
      return false; 
    paramObject = paramObject;
    long l2 = this.b;
    if (l2 != ((c)paramObject).b)
      return false; 
    long l1 = 0L;
    if (l2 == 0L)
      return true; 
    o o1 = this.a;
    paramObject = ((c)paramObject).a;
    int j = o1.b;
    int i = ((o)paramObject).b;
    while (l1 < this.b) {
      l2 = Math.min(o1.c - j, ((o)paramObject).c - i);
      int k = 0;
      while (k < l2) {
        if (o1.a[j] != ((o)paramObject).a[i])
          return false; 
        k++;
        j++;
        i++;
      } 
      if (j == o1.c) {
        o1 = o1.f;
        j = o1.b;
      } 
      if (i == ((o)paramObject).c) {
        paramObject = ((o)paramObject).f;
        i = ((o)paramObject).b;
      } 
      l1 += l2;
    } 
    return true;
  }
  
  public final f f(int paramInt) {
    return (paramInt == 0) ? f.b : new q(this, paramInt);
  }
  
  public InputStream f() {
    return new InputStream(this) {
        public int available() {
          return (int)Math.min(this.a.b, 2147483647L);
        }
        
        public void close() {}
        
        public int read() {
          return (this.a.b > 0L) ? (this.a.h() & 0xFF) : -1;
        }
        
        public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
          return this.a.a(param1ArrayOfbyte, param1Int1, param1Int2);
        }
        
        public String toString() {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.a);
          stringBuilder.append(".inputStream()");
          return stringBuilder.toString();
        }
      };
  }
  
  String f(long paramLong) throws EOFException {
    if (paramLong > 0L) {
      long l = paramLong - 1L;
      if (b(l) == 13) {
        String str1 = d(l);
        h(2L);
        return str1;
      } 
    } 
    String str = d(paramLong);
    h(1L);
    return str;
  }
  
  public void flush() {}
  
  public final long g() {
    long l2 = this.b;
    if (l2 == 0L)
      return 0L; 
    o o1 = this.a.g;
    long l1 = l2;
    if (o1.c < 8192) {
      l1 = l2;
      if (o1.e)
        l1 = l2 - (o1.c - o1.b); 
    } 
    return l1;
  }
  
  public byte[] g(long paramLong) throws EOFException {
    u.a(this.b, 0L, paramLong);
    if (paramLong <= 2147483647L) {
      byte[] arrayOfByte = new byte[(int)paramLong];
      a(arrayOfByte);
      return arrayOfByte;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("byteCount > Integer.MAX_VALUE: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public byte h() {
    if (this.b != 0L) {
      o o1 = this.a;
      int i = o1.b;
      int j = o1.c;
      byte[] arrayOfByte = o1.a;
      int k = i + 1;
      byte b = arrayOfByte[i];
      this.b--;
      if (k == j) {
        this.a = o1.b();
        p.a(o1);
        return b;
      } 
      o1.b = k;
      return b;
    } 
    throw new IllegalStateException("size == 0");
  }
  
  public void h(long paramLong) throws EOFException {
    while (paramLong > 0L) {
      o o1 = this.a;
      if (o1 != null) {
        int i = (int)Math.min(paramLong, (o1.c - this.a.b));
        long l1 = this.b;
        long l2 = i;
        this.b = l1 - l2;
        l1 = paramLong - l2;
        o1 = this.a;
        o1.b += i;
        paramLong = l1;
        if (this.a.b == this.a.c) {
          o1 = this.a;
          this.a = o1.b();
          p.a(o1);
          paramLong = l1;
        } 
        continue;
      } 
      throw new EOFException();
    } 
  }
  
  public int hashCode() {
    o o1 = this.a;
    if (o1 == null)
      return 0; 
    int i = 1;
    while (true) {
      int k = o1.b;
      int m = o1.c;
      int j = i;
      while (k < m) {
        j = j * 31 + o1.a[k];
        k++;
      } 
      o o2 = o1.f;
      o1 = o2;
      i = j;
      if (o2 == this.a)
        return j; 
    } 
  }
  
  public c i(long paramLong) {
    int j = paramLong cmp 0L;
    if (j == 0)
      return b(48); 
    boolean bool = false;
    int i = 1;
    long l = paramLong;
    if (j < 0) {
      l = -paramLong;
      if (l < 0L)
        return a("-9223372036854775808"); 
      bool = true;
    } 
    if (l < 100000000L) {
      if (l < 10000L) {
        if (l < 100L) {
          if (l >= 10L)
            i = 2; 
        } else if (l < 1000L) {
          i = 3;
        } else {
          i = 4;
        } 
      } else if (l < 1000000L) {
        if (l < 100000L) {
          i = 5;
        } else {
          i = 6;
        } 
      } else if (l < 10000000L) {
        i = 7;
      } else {
        i = 8;
      } 
    } else if (l < 1000000000000L) {
      if (l < 10000000000L) {
        if (l < 1000000000L) {
          i = 9;
        } else {
          i = 10;
        } 
      } else if (l < 100000000000L) {
        i = 11;
      } else {
        i = 12;
      } 
    } else if (l < 1000000000000000L) {
      if (l < 10000000000000L) {
        i = 13;
      } else if (l < 100000000000000L) {
        i = 14;
      } else {
        i = 15;
      } 
    } else if (l < 100000000000000000L) {
      if (l < 10000000000000000L) {
        i = 16;
      } else {
        i = 17;
      } 
    } else if (l < 1000000000000000000L) {
      i = 18;
    } else {
      i = 19;
    } 
    j = i;
    if (bool)
      j = i + 1; 
    o o1 = e(j);
    byte[] arrayOfByte = o1.a;
    i = o1.c + j;
    while (l != 0L) {
      int k = (int)(l % 10L);
      arrayOfByte[--i] = c[k];
      l /= 10L;
    } 
    if (bool)
      arrayOfByte[i - 1] = 45; 
    o1.c += j;
    this.b += j;
    return this;
  }
  
  public short i() {
    if (this.b >= 2L) {
      o o1 = this.a;
      int k = o1.b;
      int i = o1.c;
      if (i - k < 2)
        return (short)((h() & 0xFF) << 8 | h() & 0xFF); 
      byte[] arrayOfByte = o1.a;
      int j = k + 1;
      k = arrayOfByte[k];
      int m = j + 1;
      j = arrayOfByte[j];
      this.b -= 2L;
      if (m == i) {
        this.a = o1.b();
        p.a(o1);
      } else {
        o1.b = m;
      } 
      return (short)((k & 0xFF) << 8 | j & 0xFF);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("size < 2: ");
    stringBuilder.append(this.b);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public boolean isOpen() {
    return true;
  }
  
  public int j() {
    if (this.b >= 4L) {
      o o1 = this.a;
      int j = o1.b;
      int i = o1.c;
      if (i - j < 4)
        return (h() & 0xFF) << 24 | (h() & 0xFF) << 16 | (h() & 0xFF) << 8 | h() & 0xFF; 
      byte[] arrayOfByte = o1.a;
      int k = j + 1;
      j = arrayOfByte[j];
      int n = k + 1;
      k = arrayOfByte[k];
      int m = n + 1;
      byte b = arrayOfByte[n];
      n = m + 1;
      j = (j & 0xFF) << 24 | (k & 0xFF) << 16 | (b & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
      this.b -= 4L;
      if (n == i) {
        this.a = o1.b();
        p.a(o1);
        return j;
      } 
      o1.b = n;
      return j;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("size < 4: ");
    stringBuilder.append(this.b);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public c j(long paramLong) {
    if (paramLong == 0L)
      return b(48); 
    int j = Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4 + 1;
    o o1 = e(j);
    byte[] arrayOfByte = o1.a;
    int i = o1.c + j - 1;
    int k = o1.c;
    while (i >= k) {
      arrayOfByte[i] = c[(int)(0xFL & paramLong)];
      paramLong >>>= 4L;
      i--;
    } 
    o1.c += j;
    this.b += j;
    return this;
  }
  
  public short k() {
    return u.a(i());
  }
  
  public int l() {
    return u.a(j());
  }
  
  public long m() {
    if (this.b != 0L) {
      int j;
      long l2;
      int i = 0;
      long l1 = 0L;
      int k = 0;
      while (true) {
        c c1;
        o o1 = this.a;
        byte[] arrayOfByte = o1.a;
        int m = o1.b;
        int n = o1.c;
        l2 = l1;
        j = k;
        while (true) {
          k = i;
          if (m < n) {
            byte b = arrayOfByte[m];
            if (b >= 48 && b <= 57) {
              k = b - 48;
            } else {
              if (b >= 97 && b <= 102) {
                k = b - 97;
              } else if (b >= 65 && b <= 70) {
                k = b - 65;
              } else {
                if (j != 0) {
                  k = 1;
                  break;
                } 
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Expected leading [0-9a-fA-F] character but was 0x");
                stringBuilder1.append(Integer.toHexString(b));
                throw new NumberFormatException(stringBuilder1.toString());
              } 
              k += 10;
            } 
            if ((0xF000000000000000L & l2) == 0L) {
              l2 = l2 << 4L | k;
              m++;
              j++;
              continue;
            } 
            c1 = (new c()).j(l2).b(b);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Number too large: ");
            stringBuilder.append(c1.o());
            throw new NumberFormatException(stringBuilder.toString());
          } 
          break;
        } 
        if (m == n) {
          this.a = c1.b();
          p.a((o)c1);
        } else {
          ((o)c1).b = m;
        } 
        if (k == 0) {
          i = k;
          k = j;
          l1 = l2;
          if (this.a == null)
            break; 
          continue;
        } 
        break;
      } 
      this.b -= j;
      return l2;
    } 
    throw new IllegalStateException("size == 0");
  }
  
  public f n() {
    return new f(q());
  }
  
  public String o() {
    try {
      return a(this.b, u.a);
    } catch (EOFException eOFException) {
      throw new AssertionError(eOFException);
    } 
  }
  
  public String p() throws EOFException {
    return e(Long.MAX_VALUE);
  }
  
  public byte[] q() {
    try {
      return g(this.b);
    } catch (EOFException eOFException) {
      throw new AssertionError(eOFException);
    } 
  }
  
  public final void r() {
    try {
      h(this.b);
      return;
    } catch (EOFException eOFException) {
      throw new AssertionError(eOFException);
    } 
  }
  
  public int read(ByteBuffer paramByteBuffer) throws IOException {
    o o1 = this.a;
    if (o1 == null)
      return -1; 
    int i = Math.min(paramByteBuffer.remaining(), o1.c - o1.b);
    paramByteBuffer.put(o1.a, o1.b, i);
    o1.b += i;
    this.b -= i;
    if (o1.b == o1.c) {
      this.a = o1.b();
      p.a(o1);
    } 
    return i;
  }
  
  public c s() {
    c c1 = new c();
    if (this.b == 0L)
      return c1; 
    c1.a = this.a.a();
    o o1 = c1.a;
    o1.g = o1;
    o1.f = o1;
    o1 = this.a;
    while (true) {
      o1 = o1.f;
      if (o1 != this.a) {
        c1.a.g.a(o1.a());
        continue;
      } 
      c1.b = this.b;
      return c1;
    } 
  }
  
  public final f t() {
    long l = this.b;
    if (l <= 2147483647L)
      return f((int)l); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("size > Integer.MAX_VALUE: ");
    stringBuilder.append(this.b);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public String toString() {
    return t().toString();
  }
  
  public int write(ByteBuffer paramByteBuffer) throws IOException {
    if (paramByteBuffer != null) {
      int j = paramByteBuffer.remaining();
      int i = j;
      while (i > 0) {
        o o1 = e(1);
        int k = Math.min(i, 8192 - o1.c);
        paramByteBuffer.get(o1.a, o1.c, k);
        i -= k;
        o1.c += k;
      } 
      this.b += j;
      return j;
    } 
    throw new IllegalArgumentException("source == null");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */