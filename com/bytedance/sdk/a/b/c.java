package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.a.d;
import com.bytedance.sdk.a.b.a.a.e;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public final class c implements Closeable, Flushable {
  final e a;
  
  final d b;
  
  public void close() throws IOException {
    this.b.close();
  }
  
  public void flush() throws IOException {
    this.b.flush();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */