package com.blued.android.framework.ui.xpop.util;

import com.blued.android.framework.ui.xpop.enums.ImageType;
import java.io.IOException;
import java.io.InputStream;

public class ImageHeaderParser {
  static ImageType a(InputStream paramInputStream) throws IOException {
    StreamReader streamReader = new StreamReader(paramInputStream);
    int i = streamReader.a();
    if (i == 65496)
      return ImageType.b; 
    i = i << 16 & 0xFFFF0000 | streamReader.a() & 0xFFFF;
    if (i == -1991225785) {
      streamReader.a(21L);
      return (streamReader.b() >= 3) ? ImageType.d : ImageType.e;
    } 
    if (i >> 8 == 4671814)
      return ImageType.a; 
    if (i != 1380533830)
      return ImageType.h; 
    streamReader.a(4L);
    if ((streamReader.a() << 16 & 0xFFFF0000 | streamReader.a() & 0xFFFF) != 1464156752)
      return ImageType.h; 
    i = streamReader.a() << 16 & 0xFFFF0000 | streamReader.a() & 0xFFFF;
    if ((i & 0xFFFFFF00) != 1448097792)
      return ImageType.h; 
    i &= 0xFF;
    if (i == 88) {
      streamReader.a(4L);
      return ((streamReader.b() & 0x10) != 0) ? ImageType.f : ImageType.g;
    } 
    if (i == 76) {
      streamReader.a(4L);
      return ((streamReader.b() & 0x8) != 0) ? ImageType.f : ImageType.g;
    } 
    paramInputStream.close();
    return ImageType.g;
  }
  
  static interface Reader {
    int a() throws IOException;
    
    long a(long param1Long) throws IOException;
    
    int b() throws IOException;
  }
  
  static final class StreamReader implements Reader {
    private final InputStream a;
    
    StreamReader(InputStream param1InputStream) {
      this.a = param1InputStream;
    }
    
    public int a() throws IOException {
      return this.a.read() << 8 & 0xFF00 | this.a.read() & 0xFF;
    }
    
    public long a(long param1Long) throws IOException {
      if (param1Long < 0L)
        return 0L; 
      long l;
      for (l = param1Long; l > 0L; l -= l1) {
        long l1 = this.a.skip(l);
        if (l1 <= 0L) {
          if (this.a.read() == -1)
            break; 
          l1 = 1L;
        } 
      } 
      return param1Long - l;
    }
    
    public int b() throws IOException {
      return this.a.read();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpo\\util\ImageHeaderParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */