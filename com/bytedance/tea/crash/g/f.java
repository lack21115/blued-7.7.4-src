package com.bytedance.tea.crash.g;

import java.io.Closeable;

public final class f {
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        return;
      } finally {
        paramCloseable = null;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\g\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */