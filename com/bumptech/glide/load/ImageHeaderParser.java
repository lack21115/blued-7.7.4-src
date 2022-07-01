package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface ImageHeaderParser {
  int a(InputStream paramInputStream, ArrayPool paramArrayPool) throws IOException;
  
  ImageType a(InputStream paramInputStream) throws IOException;
  
  ImageType a(ByteBuffer paramByteBuffer) throws IOException;
  
  public enum ImageType {
    GIF(true),
    JPEG(false),
    PNG(false),
    PNG_A(false),
    RAW(false),
    UNKNOWN(false),
    WEBP(false),
    WEBP_A(false);
    
    private final boolean a;
    
    static {
      PNG = new ImageType("PNG", 4, false);
      WEBP_A = new ImageType("WEBP_A", 5, true);
      WEBP = new ImageType("WEBP", 6, false);
      UNKNOWN = new ImageType("UNKNOWN", 7, false);
      $VALUES = new ImageType[] { GIF, JPEG, RAW, PNG_A, PNG, WEBP_A, WEBP, UNKNOWN };
    }
    
    ImageType(boolean param1Boolean) {
      this.a = param1Boolean;
    }
    
    public boolean hasAlpha() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\ImageHeaderParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */