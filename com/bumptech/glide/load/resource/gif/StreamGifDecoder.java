package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {
  private final List<ImageHeaderParser> a;
  
  private final ResourceDecoder<ByteBuffer, GifDrawable> b;
  
  private final ArrayPool c;
  
  public StreamGifDecoder(List<ImageHeaderParser> paramList, ResourceDecoder<ByteBuffer, GifDrawable> paramResourceDecoder, ArrayPool paramArrayPool) {
    this.a = paramList;
    this.b = paramResourceDecoder;
    this.c = paramArrayPool;
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
      if (Log.isLoggable("StreamGifDecoder", 5))
        Log.w("StreamGifDecoder", "Error reading data from stream", iOException); 
      return null;
    } 
  }
  
  public Resource<GifDrawable> a(InputStream paramInputStream, int paramInt1, int paramInt2, Options paramOptions) throws IOException {
    byte[] arrayOfByte = a(paramInputStream);
    if (arrayOfByte == null)
      return null; 
    ByteBuffer byteBuffer = ByteBuffer.wrap(arrayOfByte);
    return this.b.a(byteBuffer, paramInt1, paramInt2, paramOptions);
  }
  
  public boolean a(InputStream paramInputStream, Options paramOptions) throws IOException {
    return (!((Boolean)paramOptions.a(GifOptions.b)).booleanValue() && ImageHeaderParserUtils.a(this.a, paramInputStream, this.c) == ImageHeaderParser.ImageType.GIF);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\gif\StreamGifDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */