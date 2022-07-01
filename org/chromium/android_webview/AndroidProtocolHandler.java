package org.chromium.android_webview;

import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;

public class AndroidProtocolHandler {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private static Class getClazz(String paramString1, String paramString2) {
    ClassLoader classLoader = ContextUtils.sApplicationContext.getClassLoader();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(".R$");
    stringBuilder.append(paramString2);
    return classLoader.loadClass(stringBuilder.toString());
  }
  
  private static int getFieldId(String paramString1, String paramString2) {
    Class clazz;
    String str = ContextUtils.sApplicationContext.getPackageName();
    try {
      clazz = getClazz(str, paramString1);
    } catch (ClassNotFoundException classNotFoundException) {
      Class clazz1 = null;
      while (true) {
        clazz = clazz1;
        if (clazz1 == null) {
          if (str != null) {
            int i = str.lastIndexOf('.');
            if (i != -1) {
              str = str.substring(0, i);
              continue;
            } 
          } 
          str = null;
          continue;
        } 
        break;
        if (str != null) {
          try {
            clazz = getClazz(str, paramString1);
            clazz1 = clazz;
          } catch (ClassNotFoundException classNotFoundException1) {}
          continue;
        } 
        throw classNotFoundException;
      } 
    } 
    return clazz.getField(paramString2).getInt(null);
  }
  
  @CalledByNative
  public static String getMimeType(InputStream paramInputStream, String paramString) {
    Uri uri = verifyUrl(paramString);
    if (uri == null)
      return null; 
    try {
      String str = uri.getPath();
      if (uri.getScheme().equals("content"))
        return ContextUtils.sApplicationContext.getContentResolver().getType(uri); 
      if (uri.getScheme().equals("file") && str.startsWith(nativeGetAndroidAssetPath())) {
        String str1 = URLConnection.guessContentTypeFromName(str);
        if (str1 != null)
          return str1; 
      } 
      try {
        return URLConnection.guessContentTypeFromStream(paramInputStream);
      } catch (IOException iOException) {
        return null;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("Unable to get mime type");
      stringBuilder.append(paramString);
      Log.e("AndroidProtocolHandler", stringBuilder.toString());
      return null;
    } 
  }
  
  private static native String nativeGetAndroidAssetPath();
  
  private static native String nativeGetAndroidResourcePath();
  
  @CalledByNative
  public static InputStream open(String paramString) {
    Uri uri = verifyUrl(paramString);
    if (uri == null)
      return null; 
    InputStream inputStream = openByScheme(uri);
    if (inputStream != null && uri.getLastPathSegment().endsWith(".svgz"))
      try {
        return new GZIPInputStream(inputStream);
      } catch (IOException iOException) {
        StringBuilder stringBuilder = new StringBuilder("Error decompressing ");
        stringBuilder.append(uri);
        stringBuilder.append(" - ");
        stringBuilder.append(iOException.getMessage());
        Log.e("AndroidProtocolHandler", stringBuilder.toString());
        return null;
      }  
    return (InputStream)iOException;
  }
  
  private static InputStream openAsset(Uri paramUri) {
    assert false;
    throw new AssertionError();
  }
  
  private static InputStream openByScheme(Uri paramUri) {
    try {
      if (paramUri.getScheme().equals("file")) {
        String str = paramUri.getPath();
        if (str.startsWith(nativeGetAndroidAssetPath()))
          return openAsset(paramUri); 
        if (str.startsWith(nativeGetAndroidResourcePath()))
          return openResource(paramUri); 
      } else if (paramUri.getScheme().equals("content")) {
        return openContent(paramUri);
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("Error opening inputstream: ");
      stringBuilder.append(paramUri);
      Log.e("AndroidProtocolHandler", stringBuilder.toString());
    } 
    return null;
  }
  
  private static InputStream openContent(Uri paramUri) {
    assert false;
    throw new AssertionError();
  }
  
  private static InputStream openResource(Uri paramUri) {
    assert false;
    throw new AssertionError();
  }
  
  private static Uri verifyUrl(String paramString) {
    StringBuilder stringBuilder;
    if (paramString == null)
      return null; 
    Uri uri = Uri.parse(paramString);
    if (uri == null) {
      stringBuilder = new StringBuilder("Malformed URL: ");
      stringBuilder.append(paramString);
      Log.e("AndroidProtocolHandler", stringBuilder.toString());
      return null;
    } 
    String str = stringBuilder.getPath();
    if (str == null || str.length() == 0) {
      stringBuilder = new StringBuilder("URL does not have a path: ");
      stringBuilder.append(paramString);
      Log.e("AndroidProtocolHandler", stringBuilder.toString());
      return null;
    } 
    return (Uri)stringBuilder;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AndroidProtocolHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */