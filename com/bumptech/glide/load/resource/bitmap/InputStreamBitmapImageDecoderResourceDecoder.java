package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.io.InputStream;

public final class InputStreamBitmapImageDecoderResourceDecoder implements ResourceDecoder<InputStream, Bitmap> {
  private final BitmapImageDecoderResourceDecoder a = new BitmapImageDecoderResourceDecoder();
  
  public Resource<Bitmap> a(InputStream paramInputStream, int paramInt1, int paramInt2, Options paramOptions) throws IOException {
    ImageDecoder.Source source = ImageDecoder.createSource(ByteBufferUtil.a(paramInputStream));
    return this.a.a(source, paramInt1, paramInt2, paramOptions);
  }
  
  public boolean a(InputStream paramInputStream, Options paramOptions) throws IOException {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\InputStreamBitmapImageDecoderResourceDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */