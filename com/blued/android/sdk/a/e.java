package com.blued.android.sdk.a;

import android.util.Base64;
import android.util.Log;
import com.blued.android.sdk.BluedSDK;
import com.google.gson.Gson;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class e {
  public static String a(String paramString, Map<String, String> paramMap) {
    String str = paramString;
    if (paramMap != null) {
      str = paramString;
      if (paramMap.size() > 0) {
        Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
        while (true) {
          str = paramString;
          if (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append((String)entry.getValue());
            str = stringBuilder.toString();
            if (paramString.indexOf("?") == -1) {
              stringBuilder = new StringBuilder();
              stringBuilder.append(paramString);
              stringBuilder.append("?");
              stringBuilder.append(str);
              paramString = stringBuilder.toString();
              continue;
            } 
            stringBuilder = new StringBuilder();
            stringBuilder.append(paramString);
            stringBuilder.append("&");
            stringBuilder.append(str);
            paramString = stringBuilder.toString();
            continue;
          } 
          break;
        } 
      } 
    } 
    return str;
  }
  
  public static String a(HttpURLConnection paramHttpURLConnection) {
    // Byte code:
    //   0: sipush #1024
    //   3: newarray byte
    //   5: astore #4
    //   7: new java/io/ByteArrayOutputStream
    //   10: dup
    //   11: invokespecial <init> : ()V
    //   14: astore_3
    //   15: aload_0
    //   16: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   19: astore_2
    //   20: aload_2
    //   21: astore_0
    //   22: goto -> 30
    //   25: aload_0
    //   26: invokevirtual getErrorStream : ()Ljava/io/InputStream;
    //   29: astore_0
    //   30: aload_0
    //   31: aload #4
    //   33: invokevirtual read : ([B)I
    //   36: istore_1
    //   37: iload_1
    //   38: iconst_m1
    //   39: if_icmpeq -> 58
    //   42: aload_3
    //   43: aload #4
    //   45: iconst_0
    //   46: iload_1
    //   47: invokevirtual write : ([BII)V
    //   50: goto -> 30
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual printStackTrace : ()V
    //   58: new java/lang/String
    //   61: dup
    //   62: aload_3
    //   63: invokevirtual toByteArray : ()[B
    //   66: invokespecial <init> : ([B)V
    //   69: areturn
    //   70: astore_2
    //   71: goto -> 25
    // Exception table:
    //   from	to	target	type
    //   15	20	70	java/io/IOException
    //   25	30	53	java/io/IOException
    //   30	37	53	java/io/IOException
    //   42	50	53	java/io/IOException
  }
  
  public static HttpURLConnection a(a parama, URL paramURL, Map<String, String> paramMap1, Map<String, String> paramMap2) {
    HttpURLConnection httpURLConnection = (HttpURLConnection)paramURL.openConnection();
    httpURLConnection.setConnectTimeout(30000);
    httpURLConnection.setReadTimeout(30000);
    httpURLConnection.setUseCaches(false);
    httpURLConnection.setDoInput(true);
    if (paramMap1 != null && paramMap1.size() > 0)
      for (Map.Entry<String, String> entry : paramMap1.entrySet())
        httpURLConnection.addRequestProperty((String)entry.getKey(), (String)entry.getValue());  
    int i = null.a[parama.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i == 4) {
            httpURLConnection.setRequestMethod("PUT");
            a(httpURLConnection, paramMap2);
            return httpURLConnection;
          } 
          throw new IllegalStateException("Unknown method type.");
        } 
        httpURLConnection.setRequestMethod("POST");
        a(httpURLConnection, paramMap2);
        return httpURLConnection;
      } 
      httpURLConnection.setRequestMethod("DELETE");
      return httpURLConnection;
    } 
    httpURLConnection.setRequestMethod("GET");
    return httpURLConnection;
  }
  
  public static Map<String, String> a(String paramString1, String paramString2, String paramString3, String paramString4) {
    Exception exception;
    StringBuilder stringBuilder;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
      String str = (new StringBuilder(paramString4)).reverse().toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramString3);
      stringBuilder2.append(str);
      str = stringBuilder2.toString();
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString2.getBytes(), "HmacSHA1");
      Mac mac = Mac.getInstance("HmacSHA1");
      mac.init(secretKeySpec);
      str = Base64.encodeToString(mac.doFinal(str.getBytes()), 2);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString1);
      stringBuilder1.append(":");
      stringBuilder1.append(str);
      str = Base64.encodeToString(stringBuilder1.toString().getBytes(), 2);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
    } catch (InvalidKeyException null) {
    
    } finally {
      exception = null;
    } 
    stringBuilder.append("Blued ");
    stringBuilder.append((String)exception);
    hashMap.put("Authorization", stringBuilder.toString());
    if (BluedSDK.DEBUG) {
      String str = BluedSDK.TAG;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("appKey:");
      stringBuilder1.append(paramString1);
      stringBuilder1.append(", appSecretKey:");
      stringBuilder1.append(paramString2);
      stringBuilder1.append(", appToken:");
      stringBuilder1.append(paramString3);
      stringBuilder1.append(", t:");
      stringBuilder1.append(paramString4);
      stringBuilder1.append(", sign:");
      stringBuilder1.append((String)exception);
      Log.v(str, stringBuilder1.toString());
    } 
    return (Map)hashMap;
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, Map<String, String> paramMap) {
    if (paramHttpURLConnection != null) {
      if (paramMap == null)
        return; 
      paramHttpURLConnection.addRequestProperty("Content-Type", "application/json");
      String str = (new Gson()).toJson(paramMap);
      DataOutputStream dataOutputStream = new DataOutputStream(paramHttpURLConnection.getOutputStream());
      dataOutputStream.writeUTF(str);
      dataOutputStream.close();
    } 
  }
  
  public enum a {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\sdk\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */