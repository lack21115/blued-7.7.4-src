package com.mcxiaoke.packer.support.walle;

import java.io.Closeable;
import java.io.IOException;

final class V2Utils {
  static void a(Closeable paramCloseable) {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\mcxiaoke\packer\support\walle\V2Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */