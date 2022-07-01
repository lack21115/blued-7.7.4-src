package com.alipay.android.phone.mrpc.core;

import java.io.Closeable;
import java.io.IOException;

public final class r {
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (IOException iOException) {
        return;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */