package com.huawei.agconnect.config.a;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public final class h {
  public static String a(InputStream paramInputStream, String paramString) throws UnsupportedEncodingException, IOException {
    StringWriter stringWriter = new StringWriter();
    a(new InputStreamReader(paramInputStream, paramString), stringWriter);
    return stringWriter.toString();
  }
  
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (IOException iOException) {
        Log.e("Utils", "Exception when closing the 'Closeable'.");
      }  
  }
  
  public static void a(Reader paramReader, Writer paramWriter) throws IOException {
    a(paramReader, paramWriter, new char[4096]);
  }
  
  public static void a(Reader paramReader, Writer paramWriter, char[] paramArrayOfchar) throws IOException {
    while (true) {
      int i = paramReader.read(paramArrayOfchar);
      if (-1 != i) {
        paramWriter.write(paramArrayOfchar, 0, i);
        continue;
      } 
      break;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\agconnect\config\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */