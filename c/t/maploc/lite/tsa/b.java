package c.t.maploc.lite.tsa;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
  public double a;
  
  public double b;
  
  public double c;
  
  public float d;
  
  public b() {}
  
  public b(JSONObject paramJSONObject) throws JSONException {
    this.a = paramJSONObject.optDouble("latitude", 0.0D);
    this.b = paramJSONObject.optDouble("longitude", 0.0D);
    this.c = paramJSONObject.optDouble("altitude", 0.0D);
    this.d = (float)paramJSONObject.optDouble("accuracy", 0.0D);
  }
  
  public static Bundle a(String paramString, byte[] paramArrayOfbyte) throws IOException {
    Bundle bundle = new Bundle();
    HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(paramString)).openConnection();
    try {
      httpURLConnection.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
      httpURLConnection.setRequestMethod("POST");
      httpURLConnection.setConnectTimeout(10000);
      httpURLConnection.setDoOutput(true);
      httpURLConnection.setFixedLengthStreamingMode(paramArrayOfbyte.length);
      OutputStream outputStream = httpURLConnection.getOutputStream();
      outputStream.write(paramArrayOfbyte);
      outputStream.flush();
      outputStream.close();
      int i = httpURLConnection.getResponseCode();
      bundle.putInt("http_ret_code", i);
      if (i == 200) {
        String str = b(httpURLConnection.getHeaderField("content-type"));
        byte[] arrayOfByte = a(httpURLConnection.getInputStream());
        bundle.putInt("status", 0);
        bundle.putByteArray("data_bytes", arrayOfByte);
        bundle.putString("data_charset", str);
        return bundle;
      } 
      bundle.putInt("status", -1);
      throw new IOException("net error: retCode:".concat(String.valueOf(i)));
    } finally {
      paramArrayOfbyte = null;
    } 
  }
  
  public static boolean a(Handler paramHandler, int paramInt) {
    Message message;
    if (paramHandler == null) {
      message = null;
    } else {
      message = paramHandler.obtainMessage(paramInt);
    } 
    return (message != null && paramHandler != null) ? paramHandler.sendMessageDelayed(message, 0L) : false;
  }
  
  public static boolean a(String paramString) {
    return (paramString == null || paramString.length() == 0);
  }
  
  public static boolean a(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte == null || paramArrayOfbyte.length == 0);
  }
  
  private static byte[] a(InputStream paramInputStream) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
    byte[] arrayOfByte = new byte[256];
    while (true) {
      int i = paramInputStream.read(arrayOfByte);
      if (i != -1) {
        byteArrayOutputStream.write(arrayOfByte, 0, i);
        continue;
      } 
      paramInputStream.close();
      return byteArrayOutputStream.toByteArray();
    } 
  }
  
  private static String b(String paramString) {
    if (paramString != null) {
      String[] arrayOfString = paramString.split(";");
      int j = arrayOfString.length;
      for (int i = 0; i < j; i++) {
        String str = arrayOfString[i].trim();
        int k = str.indexOf("charset=");
        if (-1 != k)
          return str.substring(k + 8, str.length()); 
      } 
    } 
    return "GBK";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */