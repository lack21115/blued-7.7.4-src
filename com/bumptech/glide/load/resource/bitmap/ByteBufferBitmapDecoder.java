package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {
  private final Downsampler a;
  
  public ByteBufferBitmapDecoder(Downsampler paramDownsampler) {
    this.a = paramDownsampler;
  }
  
  public Resource<Bitmap> a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, Options paramOptions) throws IOException {
    InputStream inputStream = ByteBufferUtil.b(paramByteBuffer);
    return this.a.a(inputStream, paramInt1, paramInt2, paramOptions);
  }
  
  public boolean a(ByteBuffer paramByteBuffer, Options paramOptions) {
    return this.a.a(paramByteBuffer);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\ByteBufferBitmapDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */