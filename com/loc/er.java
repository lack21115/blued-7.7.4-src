package com.loc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

public class er {
  static final Charset c;
  
  ByteBuffer a;
  
  int b;
  
  int d = 1;
  
  int[] e = null;
  
  int f = 0;
  
  boolean g = false;
  
  boolean h = false;
  
  int i;
  
  int[] j = new int[16];
  
  int k = 0;
  
  int l = 0;
  
  boolean m = false;
  
  CharsetEncoder n = c.newEncoder();
  
  ByteBuffer o;
  
  static {
    c = Charset.forName("UTF-8");
  }
  
  private er() {
    this.b = 1024;
    this.a = d(1024);
  }
  
  public er(ByteBuffer paramByteBuffer) {
    a(paramByteBuffer);
  }
  
  private void a(short paramShort) {
    c(2, 0);
    ByteBuffer byteBuffer = this.a;
    int i = this.b - 2;
    this.b = i;
    byteBuffer.putShort(i, paramShort);
  }
  
  private void c(int paramInt1, int paramInt2) {
    if (paramInt1 > this.d)
      this.d = paramInt1; 
    int i = this.a.capacity() - this.b + paramInt2 + 1 & paramInt1 - 1;
    while (this.b < i + paramInt1 + paramInt2) {
      int j = this.a.capacity();
      ByteBuffer byteBuffer = this.a;
      int k = byteBuffer.capacity();
      if ((0xC0000000 & k) == 0) {
        int m = k << 1;
        byteBuffer.position(0);
        ByteBuffer byteBuffer1 = d(m);
        byteBuffer1.position(m - k);
        byteBuffer1.put(byteBuffer);
        this.a = byteBuffer1;
        this.b += this.a.capacity() - j;
        continue;
      } 
      throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    } 
    e(i);
  }
  
  private int d() {
    return this.a.capacity() - this.b;
  }
  
  private static ByteBuffer d(int paramInt) {
    ByteBuffer byteBuffer = ByteBuffer.allocate(paramInt);
    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    return byteBuffer;
  }
  
  private void e() {
    if (!this.g)
      return; 
    throw new AssertionError("FlatBuffers: object serialization must not be nested.");
  }
  
  private void e(int paramInt) {
    for (int i = 0; i < paramInt; i++) {
      ByteBuffer byteBuffer = this.a;
      int j = this.b - 1;
      this.b = j;
      byteBuffer.put(j, (byte)0);
    } 
  }
  
  private void f(int paramInt) {
    ByteBuffer byteBuffer = this.a;
    int i = this.b - 4;
    this.b = i;
    byteBuffer.putInt(i, paramInt);
  }
  
  private void g(int paramInt) {
    c(4, 0);
    f(paramInt);
  }
  
  private void h(int paramInt) {
    this.e[paramInt] = d();
  }
  
  public final int a() {
    if (this.g) {
      this.g = false;
      f(this.l);
      return d();
    } 
    throw new AssertionError("FlatBuffers: endVector called without startVector");
  }
  
  public int a(CharSequence paramCharSequence) {
    int i = (int)(paramCharSequence.length() * this.n.maxBytesPerChar());
    ByteBuffer byteBuffer2 = this.o;
    if (byteBuffer2 == null || byteBuffer2.capacity() < i)
      this.o = ByteBuffer.allocate(Math.max(128, i)); 
    this.o.clear();
    if (paramCharSequence instanceof CharBuffer) {
      paramCharSequence = paramCharSequence;
    } else {
      paramCharSequence = CharBuffer.wrap(paramCharSequence);
    } 
    CoderResult coderResult = this.n.encode((CharBuffer)paramCharSequence, this.o, true);
    if (coderResult.isError())
      try {
        coderResult.throwException();
      } catch (CharacterCodingException characterCodingException) {
        throw new Error(characterCodingException);
      }  
    this.o.flip();
    ByteBuffer byteBuffer1 = this.o;
    i = byteBuffer1.remaining();
    a((byte)0);
    a(1, i, 1);
    byteBuffer2 = this.a;
    i = this.b - i;
    this.b = i;
    byteBuffer2.position(i);
    this.a.put(byteBuffer1);
    return a();
  }
  
  public final er a(ByteBuffer paramByteBuffer) {
    this.a = paramByteBuffer;
    this.a.clear();
    this.a.order(ByteOrder.LITTLE_ENDIAN);
    this.d = 1;
    this.b = this.a.capacity();
    this.f = 0;
    this.g = false;
    this.h = false;
    this.i = 0;
    this.k = 0;
    this.l = 0;
    return this;
  }
  
  public final void a(byte paramByte) {
    c(1, 0);
    ByteBuffer byteBuffer = this.a;
    int i = this.b - 1;
    this.b = i;
    byteBuffer.put(i, paramByte);
  }
  
  public final void a(int paramInt) {
    c(4, 0);
    if (p || paramInt <= d()) {
      f(d() - paramInt + 4);
      return;
    } 
    throw new AssertionError();
  }
  
  public final void a(int paramInt, byte paramByte) {
    if (this.m || paramByte != 0) {
      a(paramByte);
      h(paramInt);
    } 
  }
  
  public final void a(int paramInt1, int paramInt2) {
    if (this.m || paramInt2 != 0) {
      g(paramInt2);
      h(paramInt1);
    } 
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3) {
    e();
    this.l = paramInt2;
    paramInt1 *= paramInt2;
    c(4, paramInt1);
    c(paramInt3, paramInt1);
    this.g = true;
  }
  
  public final void a(int paramInt, long paramLong) {
    if (this.m || paramLong != 0L) {
      c(8, 0);
      ByteBuffer byteBuffer = this.a;
      int i = this.b - 8;
      this.b = i;
      byteBuffer.putLong(i, paramLong);
      h(paramInt);
    } 
  }
  
  public final void a(int paramInt, short paramShort) {
    if (this.m || paramShort != 0) {
      a(paramShort);
      h(paramInt);
    } 
  }
  
  public final void a(boolean paramBoolean) {
    if (this.m || paramBoolean) {
      c(1, 0);
      ByteBuffer byteBuffer = this.a;
      int i = this.b - 1;
      this.b = i;
      byteBuffer.put(i, (byte)paramBoolean);
      h(0);
    } 
  }
  
  public final int b() {
    if (this.e != null && this.g) {
      g(0);
      int j = d();
      int i;
      for (i = this.f - 1; i >= 0; i--) {
        boolean bool;
        int[] arrayOfInt = this.e;
        if (arrayOfInt[i] != 0) {
          bool = j - arrayOfInt[i];
        } else {
          bool = false;
        } 
        a((short)bool);
      } 
      a((short)(j - this.i));
      a((short)((this.f + 2) * 2));
      i = 0;
      label38: while (true) {
        if (i < this.k) {
          int k = this.a.capacity() - this.j[i];
          int m = this.b;
          short s = this.a.getShort(k);
          if (s == this.a.getShort(m)) {
            int n = 2;
            while (n < s) {
              if (this.a.getShort(k + n) == this.a.getShort(m + n)) {
                n += 2;
                continue;
              } 
              continue label38;
            } 
            i = this.j[i];
            break;
          } 
          i++;
          continue;
        } 
        i = 0;
        break;
      } 
      if (i != 0) {
        this.b = this.a.capacity() - j;
        this.a.putInt(this.b, i - j);
      } else {
        i = this.k;
        int[] arrayOfInt = this.j;
        if (i == arrayOfInt.length)
          this.j = Arrays.copyOf(arrayOfInt, i * 2); 
        arrayOfInt = this.j;
        i = this.k;
        this.k = i + 1;
        arrayOfInt[i] = d();
        ByteBuffer byteBuffer = this.a;
        byteBuffer.putInt(byteBuffer.capacity() - j, d() - j);
      } 
      this.g = false;
      return j;
    } 
    throw new AssertionError("FlatBuffers: endObject called without startObject");
  }
  
  public final void b(int paramInt) {
    e();
    int[] arrayOfInt = this.e;
    if (arrayOfInt == null || arrayOfInt.length < paramInt)
      this.e = new int[paramInt]; 
    this.f = paramInt;
    Arrays.fill(this.e, 0, this.f, 0);
    this.g = true;
    this.i = d();
  }
  
  public final void b(int paramInt1, int paramInt2) {
    if (this.m || paramInt2 != 0) {
      a(paramInt2);
      h(paramInt1);
    } 
  }
  
  public final void c(int paramInt) {
    c(this.d, 4);
    a(paramInt);
    this.a.position(this.b);
    this.h = true;
  }
  
  public final byte[] c() {
    int i = this.b;
    int j = this.a.capacity();
    int k = this.b;
    if (this.h) {
      byte[] arrayOfByte = new byte[j - k];
      this.a.position(i);
      this.a.get(arrayOfByte);
      return arrayOfByte;
    } 
    throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\er.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */