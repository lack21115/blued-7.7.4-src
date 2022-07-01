package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

final class ReaderInputStream extends InputStream {
  private final Reader a;
  
  private final CharsetEncoder b;
  
  private final byte[] c;
  
  private CharBuffer d;
  
  private ByteBuffer e;
  
  private boolean f;
  
  private boolean g;
  
  private boolean h;
  
  ReaderInputStream(Reader paramReader, Charset paramCharset, int paramInt) {
    this(paramReader, paramCharset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), paramInt);
  }
  
  ReaderInputStream(Reader paramReader, CharsetEncoder paramCharsetEncoder, int paramInt) {
    boolean bool = true;
    this.c = new byte[1];
    this.a = (Reader)Preconditions.a(paramReader);
    this.b = (CharsetEncoder)Preconditions.a(paramCharsetEncoder);
    if (paramInt <= 0)
      bool = false; 
    Preconditions.a(bool, "bufferSize must be positive: %s", paramInt);
    paramCharsetEncoder.reset();
    this.d = CharBuffer.allocate(paramInt);
    this.d.flip();
    this.e = ByteBuffer.allocate(paramInt);
  }
  
  private static int a(Buffer paramBuffer) {
    return paramBuffer.capacity() - paramBuffer.limit();
  }
  
  private int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    paramInt2 = Math.min(paramInt2, this.e.remaining());
    this.e.get(paramArrayOfbyte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  private static CharBuffer a(CharBuffer paramCharBuffer) {
    CharBuffer charBuffer = CharBuffer.wrap(Arrays.copyOf(paramCharBuffer.array(), paramCharBuffer.capacity() * 2));
    charBuffer.position(paramCharBuffer.position());
    charBuffer.limit(paramCharBuffer.limit());
    return charBuffer;
  }
  
  private void a() throws IOException {
    if (a(this.d) == 0)
      if (this.d.position() > 0) {
        this.d.compact().flip();
      } else {
        this.d = a(this.d);
      }  
    int i = this.d.limit();
    int j = this.a.read(this.d.array(), i, a(this.d));
    if (j == -1) {
      this.f = true;
      return;
    } 
    this.d.limit(i + j);
  }
  
  private void a(boolean paramBoolean) {
    this.e.flip();
    if (paramBoolean && this.e.remaining() == 0) {
      this.e = ByteBuffer.allocate(this.e.capacity() * 2);
      return;
    } 
    this.g = true;
  }
  
  public void close() throws IOException {
    this.a.close();
  }
  
  public int read() throws IOException {
    return (read(this.c) == 1) ? UnsignedBytes.a(this.c[0]) : -1;
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    Preconditions.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    if (paramInt2 == 0)
      return 0; 
    boolean bool = this.f;
    int i = 0;
    label40: while (true) {
      int j = i;
      boolean bool1 = bool;
      if (this.g) {
        j = i + a(paramArrayOfbyte, paramInt1 + i, paramInt2 - i);
        if (j == paramInt2 || this.h)
          return (j > 0) ? j : -1; 
        this.g = false;
        this.e.clear();
        bool1 = bool;
      } 
      while (true) {
        CoderResult coderResult;
        if (this.h) {
          coderResult = CoderResult.UNDERFLOW;
        } else if (bool1) {
          coderResult = this.b.flush(this.e);
        } else {
          coderResult = this.b.encode(this.d, this.e, this.f);
        } 
        if (coderResult.isOverflow()) {
          a(true);
          i = j;
          bool = bool1;
          continue label40;
        } 
        if (coderResult.isUnderflow()) {
          if (bool1) {
            this.h = true;
            a(false);
            i = j;
            bool = bool1;
            continue label40;
          } 
          if (this.f) {
            bool1 = true;
            continue;
          } 
          a();
          continue;
        } 
        if (coderResult.isError()) {
          coderResult.throwException();
          return 0;
        } 
      } 
      break;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\ReaderInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */