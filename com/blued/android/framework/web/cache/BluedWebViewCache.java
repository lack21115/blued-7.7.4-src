package com.blued.android.framework.web.cache;

import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.blued.android.core.AppInfo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import okio.ByteString;

public class BluedWebViewCache {
  private static ArrayList<String> a = new ArrayList<String>();
  
  private static ArrayList<String> b = new ArrayList<String>();
  
  private static DiskLruCache c;
  
  private static final Map<String, String> d = new HashMap<String, String>();
  
  static {
    d.put("js", "text/javascript");
  }
  
  protected static WebResourceResponse a(WebResourceRequest paramWebResourceRequest) {
    if (paramWebResourceRequest == null)
      return null; 
    Uri uri = paramWebResourceRequest.getUrl();
    String str = paramWebResourceRequest.getMethod();
    if (uri != null && str.equalsIgnoreCase("get") && a.size() != 0) {
      StringBuilder stringBuilder;
      if (b.size() == 0)
        return null; 
      String str3 = uri.toString();
      boolean bool1 = a.contains(uri.getAuthority());
      boolean bool = true;
      if (!bool1) {
        Iterator<String> iterator = a.iterator();
        while (true) {
          if (iterator.hasNext()) {
            if (str3.startsWith(iterator.next()))
              break; 
            continue;
          } 
          bool = false;
          break;
        } 
      } 
      if (!bool)
        return null; 
      try {
        str = uri.getQueryParameter("_no_cache");
        if (!TextUtils.isEmpty(str)) {
          bool1 = str.equals("1");
          if (bool1)
            return null; 
        } 
      } catch (Exception exception) {
        if (AppInfo.m())
          Log.e("BluedWebViewCache", exception.toString()); 
      } 
      str = MimeTypeMap.getFileExtensionFromUrl(str3);
      if (TextUtils.isEmpty(str))
        return null; 
      String str2 = str.toLowerCase();
      if (!b.contains(str2))
        return null; 
      String str1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2);
      str = str1;
      if (TextUtils.isEmpty(str1)) {
        str1 = d.get(str2);
        str = str1;
        if (TextUtils.isEmpty(str1)) {
          if (!AppInfo.m())
            return null; 
          stringBuilder = new StringBuilder();
          stringBuilder.append("Not found MimeType of '");
          stringBuilder.append(str2);
          stringBuilder.append("'!");
          throw new RuntimeException(stringBuilder.toString());
        } 
      } 
      InputStream inputStream2 = b(str3);
      InputStream inputStream1 = inputStream2;
      if (inputStream2 == null) {
        inputStream1 = inputStream2;
        if (c(str3))
          inputStream1 = b(str3); 
      } 
      if (inputStream1 == null)
        return null; 
      if (AppInfo.m()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("load '");
        stringBuilder1.append(str3);
        stringBuilder1.append("' from DiskCache!");
        Log.v("BluedWebViewCache", stringBuilder1.toString());
      } 
      return new WebResourceResponse((String)stringBuilder, "UTF-8", inputStream1);
    } 
    return null;
  }
  
  private static File a() {
    File file;
    if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && AppInfo.d().getExternalCacheDir() != null) {
      file = AppInfo.d().getExternalCacheDir();
    } else {
      file = AppInfo.d().getCacheDir();
    } 
    return new File(file, "webview_cache");
  }
  
  private static String a(String paramString) {
    return ByteString.encodeUtf8(paramString).md5().hex();
  }
  
  public static void a(String... paramVarArgs) {
    if (paramVarArgs != null && paramVarArgs.length > 0) {
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++) {
        String str = paramVarArgs[i];
        if (!a.contains(str))
          a.add(str); 
      } 
    } 
    if (a.size() > 0 && c == null)
      try {
        c = DiskLruCache.a(a(), 1, 1, 10485760L);
        return;
      } catch (IOException iOException) {
        if (AppInfo.m())
          iOException.printStackTrace(); 
      }  
  }
  
  private static boolean a(String paramString, OutputStream paramOutputStream) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #6
    //   3: aconst_null
    //   4: astore #5
    //   6: new java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial <init> : (Ljava/lang/String;)V
    //   14: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   17: checkcast java/net/HttpURLConnection
    //   20: astore_3
    //   21: new java/io/BufferedInputStream
    //   24: dup
    //   25: aload_3
    //   26: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   29: sipush #30720
    //   32: invokespecial <init> : (Ljava/io/InputStream;I)V
    //   35: astore #4
    //   37: new java/io/BufferedOutputStream
    //   40: dup
    //   41: aload_1
    //   42: sipush #30720
    //   45: invokespecial <init> : (Ljava/io/OutputStream;I)V
    //   48: astore_0
    //   49: aload #4
    //   51: invokevirtual read : ()I
    //   54: istore_2
    //   55: iload_2
    //   56: iconst_m1
    //   57: if_icmpeq -> 68
    //   60: aload_0
    //   61: iload_2
    //   62: invokevirtual write : (I)V
    //   65: goto -> 49
    //   68: aload_0
    //   69: invokevirtual close : ()V
    //   72: aload #4
    //   74: invokevirtual close : ()V
    //   77: goto -> 80
    //   80: aload_3
    //   81: ifnull -> 88
    //   84: aload_3
    //   85: invokevirtual disconnect : ()V
    //   88: iconst_1
    //   89: ireturn
    //   90: astore_1
    //   91: goto -> 117
    //   94: astore_1
    //   95: goto -> 127
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_0
    //   101: goto -> 117
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_0
    //   107: goto -> 127
    //   110: astore_1
    //   111: aconst_null
    //   112: astore #4
    //   114: aload #4
    //   116: astore_0
    //   117: goto -> 227
    //   120: astore_1
    //   121: aconst_null
    //   122: astore #4
    //   124: aload #4
    //   126: astore_0
    //   127: goto -> 153
    //   130: astore_1
    //   131: aconst_null
    //   132: astore #4
    //   134: aload #4
    //   136: astore_0
    //   137: aload #6
    //   139: astore_3
    //   140: goto -> 227
    //   143: astore_1
    //   144: aconst_null
    //   145: astore #4
    //   147: aload #4
    //   149: astore_0
    //   150: aload #5
    //   152: astore_3
    //   153: invokestatic m : ()Z
    //   156: ifeq -> 195
    //   159: new java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial <init> : ()V
    //   166: astore #5
    //   168: aload #5
    //   170: ldc_w 'Error in downloadFile - '
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload #5
    //   179: aload_1
    //   180: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: ldc 'BluedWebViewCache'
    //   186: aload #5
    //   188: invokevirtual toString : ()Ljava/lang/String;
    //   191: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   194: pop
    //   195: aload_0
    //   196: ifnull -> 206
    //   199: aload_0
    //   200: invokevirtual close : ()V
    //   203: goto -> 206
    //   206: aload #4
    //   208: ifnull -> 216
    //   211: aload #4
    //   213: invokevirtual close : ()V
    //   216: aload_3
    //   217: ifnull -> 224
    //   220: aload_3
    //   221: invokevirtual disconnect : ()V
    //   224: iconst_0
    //   225: ireturn
    //   226: astore_1
    //   227: aload_0
    //   228: ifnull -> 238
    //   231: aload_0
    //   232: invokevirtual close : ()V
    //   235: goto -> 238
    //   238: aload #4
    //   240: ifnull -> 248
    //   243: aload #4
    //   245: invokevirtual close : ()V
    //   248: aload_3
    //   249: ifnull -> 256
    //   252: aload_3
    //   253: invokevirtual disconnect : ()V
    //   256: aload_1
    //   257: athrow
    //   258: astore_0
    //   259: goto -> 80
    //   262: astore_0
    //   263: goto -> 270
    //   266: astore_0
    //   267: goto -> 273
    //   270: goto -> 216
    //   273: goto -> 248
    // Exception table:
    //   from	to	target	type
    //   6	21	143	java/lang/Exception
    //   6	21	130	finally
    //   21	37	120	java/lang/Exception
    //   21	37	110	finally
    //   37	49	104	java/lang/Exception
    //   37	49	98	finally
    //   49	55	94	java/lang/Exception
    //   49	55	90	finally
    //   60	65	94	java/lang/Exception
    //   60	65	90	finally
    //   68	77	258	java/io/IOException
    //   153	195	226	finally
    //   199	203	262	java/io/IOException
    //   211	216	262	java/io/IOException
    //   231	235	266	java/io/IOException
    //   243	248	266	java/io/IOException
  }
  
  private static InputStream b(String paramString) {
    DiskLruCache diskLruCache = c;
    if (diskLruCache != null)
      try {
        DiskLruCache.Snapshot snapshot = diskLruCache.a(a(paramString));
        if (snapshot != null)
          return snapshot.a(0); 
      } catch (Exception exception) {
        if (AppInfo.m())
          exception.printStackTrace(); 
      }  
    return null;
  }
  
  public static void b(String... paramVarArgs) {
    if (paramVarArgs != null) {
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++) {
        String str = paramVarArgs[i].toLowerCase();
        if (!b.contains(str))
          b.add(str); 
      } 
    } 
  }
  
  @Nullable
  private static boolean c(String paramString) {
    DiskLruCache diskLruCache = c;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    if (diskLruCache != null) {
      boolean bool = bool3;
      try {
        DiskLruCache.Editor editor = diskLruCache.b(a(paramString));
        bool1 = bool2;
        if (editor != null) {
          bool = bool3;
          if (a(paramString, editor.a(0))) {
            bool = bool3;
            editor.a();
            bool1 = true;
          } else {
            bool = bool3;
            editor.b();
            bool1 = bool2;
          } 
        } 
        bool = bool1;
        c.a();
        return bool1;
      } catch (Exception exception) {
        bool1 = bool;
        if (AppInfo.m()) {
          exception.printStackTrace();
          bool1 = bool;
        } 
      } 
    } 
    return bool1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\web\cache\BluedWebViewCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */