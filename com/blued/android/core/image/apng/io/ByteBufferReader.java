package com.blued.android.core.image.apng.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferReader implements Reader {
  private final ByteBuffer a;
  
  public ByteBufferReader(ByteBuffer paramByteBuffer) {
    this.a = paramByteBuffer;
    paramByteBuffer.position(0);
  }
  
  public int available() throws IOException {
    return this.a.limit() - this.a.position();
  }
  
  public int b() {
    return this.a.position();
  }
  
  public void close() throws IOException {}
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    this.a.get(paramArrayOfbyte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  public void reset() throws IOException {
    this.a.position(0);
  }
  
  public byte s_() throws IOException {
    return this.a.get();
  }
  
  public long skip(long paramLong) throws IOException {
    ByteBuffer byteBuffer = this.a;
    byteBuffer.position((int)(byteBuffer.position() + paramLong));
    return paramLong;
  }
  
  public InputStream t_() throws IOException {
    return new ByteArrayInputStream(this.a.array());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\io\ByteBufferReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */