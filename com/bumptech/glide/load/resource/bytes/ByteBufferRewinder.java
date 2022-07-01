package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.data.DataRewinder;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferRewinder implements DataRewinder<ByteBuffer> {
  private final ByteBuffer a;
  
  public ByteBufferRewinder(ByteBuffer paramByteBuffer) {
    this.a = paramByteBuffer;
  }
  
  public void b() {}
  
  public ByteBuffer c() {
    this.a.position(0);
    return this.a;
  }
  
  public static class Factory implements DataRewinder.Factory<ByteBuffer> {
    public DataRewinder<ByteBuffer> a(ByteBuffer param1ByteBuffer) {
      return new ByteBufferRewinder(param1ByteBuffer);
    }
    
    public Class<ByteBuffer> a() {
      return ByteBuffer.class;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bytes\ByteBufferRewinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */