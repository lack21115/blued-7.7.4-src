package com.blued.android.core.image.apng;

import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageLoaderOptions;
import com.blued.android.core.image.apng.decode.APNGParser;
import com.blued.android.core.image.apng.drawable.APNGDrawable;
import com.blued.android.core.image.apng.io.Reader;
import com.blued.android.core.image.apng.io.StreamReader;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class StreamApngDecoder implements ResourceDecoder<InputStream, APNGDrawable> {
  private final ResourceDecoder<ByteBuffer, APNGDrawable> a;
  
  public StreamApngDecoder(ResourceDecoder<ByteBuffer, APNGDrawable> paramResourceDecoder) {
    this.a = paramResourceDecoder;
  }
  
  private static byte[] a(InputStream paramInputStream) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
    try {
      byte[] arrayOfByte = new byte[16384];
      while (true) {
        int i = paramInputStream.read(arrayOfByte);
        if (i != -1) {
          byteArrayOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
      } 
    } catch (IOException iOException) {
      return null;
    } 
  }
  
  public Resource<APNGDrawable> a(InputStream paramInputStream, int paramInt1, int paramInt2, Options paramOptions) throws IOException {
    byte[] arrayOfByte = a(paramInputStream);
    if (arrayOfByte == null) {
      if (ImageLoader.a())
        Log.e("IMAGE", "StreamApngDecoder -- decode null!!!"); 
      return null;
    } 
    ByteBuffer byteBuffer = ByteBuffer.wrap(arrayOfByte);
    return this.a.a(byteBuffer, paramInt1, paramInt2, paramOptions);
  }
  
  public boolean a(InputStream paramInputStream, Options paramOptions) {
    if (ImageLoader.a()) {
      boolean bool = ((Boolean)paramOptions.a(ImageLoaderOptions.b)).booleanValue();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("StreamApngDecoder -- OPTION_IMAGE_LOADER_FROMAT_APNG = ");
      stringBuilder.append(bool);
      Log.e("IMAGE", stringBuilder.toString());
      if (bool) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("StreamApngDecoder -- isApng = ");
        stringBuilder.append(APNGParser.a((Reader)new StreamReader(paramInputStream)));
        Log.e("IMAGE", stringBuilder.toString());
      } 
    } 
    return (((Boolean)paramOptions.a(ImageLoaderOptions.b)).booleanValue() && APNGParser.a((Reader)new StreamReader(paramInputStream)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\StreamApngDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */