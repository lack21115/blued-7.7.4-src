package com.bumptech.glide.load.resource.bitmap;

import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class ExifInterfaceImageHeaderParser implements ImageHeaderParser {
  public int a(InputStream paramInputStream, ArrayPool paramArrayPool) throws IOException {
    int j = (new ExifInterface(paramInputStream)).getAttributeInt("Orientation", 1);
    int i = j;
    if (j == 0)
      i = -1; 
    return i;
  }
  
  public ImageHeaderParser.ImageType a(InputStream paramInputStream) {
    return ImageHeaderParser.ImageType.UNKNOWN;
  }
  
  public ImageHeaderParser.ImageType a(ByteBuffer paramByteBuffer) {
    return ImageHeaderParser.ImageType.UNKNOWN;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\ExifInterfaceImageHeaderParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */