package com.huawei.android.hms.agent.common;

import java.io.Closeable;
import java.io.IOException;

public final class IOUtils {
  public static void close(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (IOException iOException) {
        HMSAgentLog.d("close fail");
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\common\IOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */