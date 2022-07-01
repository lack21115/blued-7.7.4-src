package com.blued.android.core.image.apng.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBufferWriter implements Writer {
  protected ByteBuffer a;
  
  public ByteBufferWriter() {
    c(10240);
  }
  
  public int a() {
    return this.a.position();
  }
  
  public void a(byte paramByte) {
    this.a.put(paramByte);
  }
  
  public void a(byte[] paramArrayOfbyte) {
    this.a.put(paramArrayOfbyte);
  }
  
  public byte[] b() {
    return this.a.array();
  }
  
  public void c() {
    this.a.clear();
  }
  
  public void c(int paramInt) {
    ByteBuffer byteBuffer = this.a;
    if (byteBuffer == null || paramInt > byteBuffer.capacity()) {
      this.a = ByteBuffer.allocate(paramInt);
      this.a.order(ByteOrder.LITTLE_ENDIAN);
    } 
    this.a.clear();
  }
  
  public void d(int paramInt) {
    this.a.position(paramInt + a());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\io\ByteBufferWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */