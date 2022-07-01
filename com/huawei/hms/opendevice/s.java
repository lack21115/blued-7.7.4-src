package com.huawei.hms.opendevice;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public abstract class s {
  public static String a(InputStream paramInputStream) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    for (int i = paramInputStream.read(); -1 != i; i = paramInputStream.read())
      byteArrayOutputStream.write(i); 
    String str = byteArrayOutputStream.toString("UTF-8");
    a(paramInputStream);
    IOUtil.a(byteArrayOutputStream);
    return str;
  }
  
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (IOException iOException) {
        HMSLog.w("StreamUtil", "close IOException");
      }  
  }
  
  public static void a(HttpURLConnection paramHttpURLConnection) {
    if (paramHttpURLConnection != null)
      try {
        return;
      } finally {
        paramHttpURLConnection = null;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */