package org.chromium.base;

import java.io.Closeable;
import java.io.IOException;

public final class StreamUtil {
  public static void closeQuietly(Closeable paramCloseable) {
    if (paramCloseable == null)
      return; 
    try {
      paramCloseable.close();
      return;
    } catch (IOException iOException) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\StreamUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */