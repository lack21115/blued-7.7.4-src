package com.blued.android.core.image.apng.io;

import java.io.IOException;
import java.io.InputStream;

public interface Reader {
  int available() throws IOException;
  
  int b();
  
  void close() throws IOException;
  
  int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException;
  
  void reset() throws IOException;
  
  byte s_() throws IOException;
  
  long skip(long paramLong) throws IOException;
  
  InputStream t_() throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\io\Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */