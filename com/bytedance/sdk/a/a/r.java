package com.bytedance.sdk.a.a;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface r extends Closeable, Flushable {
  t a();
  
  void a_(c paramc, long paramLong) throws IOException;
  
  void close() throws IOException;
  
  void flush() throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */