package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import java.io.ByteArrayOutputStream;

public class BitmapBytesTranscoder implements ResourceTranscoder<Bitmap, byte[]> {
  private final Bitmap.CompressFormat a;
  
  private final int b;
  
  public BitmapBytesTranscoder() {
    this(Bitmap.CompressFormat.JPEG, 100);
  }
  
  public BitmapBytesTranscoder(Bitmap.CompressFormat paramCompressFormat, int paramInt) {
    this.a = paramCompressFormat;
    this.b = paramInt;
  }
  
  public Resource<byte[]> a(Resource<Bitmap> paramResource, Options paramOptions) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    ((Bitmap)paramResource.f()).compress(this.a, this.b, byteArrayOutputStream);
    paramResource.c();
    return (Resource<byte[]>)new BytesResource(byteArrayOutputStream.toByteArray());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\transcode\BitmapBytesTranscoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */