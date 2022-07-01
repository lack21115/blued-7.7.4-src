package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.qiniu.pili.droid.shortvideo.PLAuthenticationResultCallback;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class u {
  private static boolean d = true;
  
  private Context a;
  
  private b b = b.a;
  
  private long c = 0L;
  
  private ArrayList<Integer> e = new ArrayList<Integer>();
  
  public static u a() {
    return a.a;
  }
  
  private String a(InputStream paramInputStream) {
    // Byte code:
    //   0: new java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #5
    //   9: aconst_null
    //   10: astore #4
    //   12: aconst_null
    //   13: astore_2
    //   14: new java/io/BufferedReader
    //   17: dup
    //   18: new java/io/InputStreamReader
    //   21: dup
    //   22: aload_1
    //   23: invokespecial <init> : (Ljava/io/InputStream;)V
    //   26: invokespecial <init> : (Ljava/io/Reader;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual readLine : ()Ljava/lang/String;
    //   34: astore_2
    //   35: aload_2
    //   36: ifnull -> 49
    //   39: aload #5
    //   41: aload_2
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   45: pop
    //   46: goto -> 30
    //   49: aload_0
    //   50: aload #5
    //   52: invokevirtual toString : ()Ljava/lang/String;
    //   55: invokespecial b : (Ljava/lang/String;)V
    //   58: aload_0
    //   59: aload #5
    //   61: invokevirtual toString : ()Ljava/lang/String;
    //   64: invokespecial a : (Ljava/lang/String;)V
    //   67: aload_1
    //   68: invokevirtual close : ()V
    //   71: goto -> 116
    //   74: astore_2
    //   75: goto -> 122
    //   78: astore_3
    //   79: goto -> 94
    //   82: astore_3
    //   83: aload_2
    //   84: astore_1
    //   85: aload_3
    //   86: astore_2
    //   87: goto -> 122
    //   90: astore_3
    //   91: aload #4
    //   93: astore_1
    //   94: aload_1
    //   95: astore_2
    //   96: aload_3
    //   97: invokevirtual printStackTrace : ()V
    //   100: aload_1
    //   101: ifnull -> 116
    //   104: aload_1
    //   105: invokevirtual close : ()V
    //   108: goto -> 116
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual printStackTrace : ()V
    //   116: aload #5
    //   118: invokevirtual toString : ()Ljava/lang/String;
    //   121: areturn
    //   122: aload_1
    //   123: ifnull -> 138
    //   126: aload_1
    //   127: invokevirtual close : ()V
    //   130: goto -> 138
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual printStackTrace : ()V
    //   138: aload_2
    //   139: athrow
    // Exception table:
    //   from	to	target	type
    //   14	30	90	java/lang/Exception
    //   14	30	82	finally
    //   30	35	78	java/lang/Exception
    //   30	35	74	finally
    //   39	46	78	java/lang/Exception
    //   39	46	74	finally
    //   49	67	78	java/lang/Exception
    //   49	67	74	finally
    //   67	71	111	java/io/IOException
    //   96	100	82	finally
    //   104	108	111	java/io/IOException
    //   126	130	133	java/io/IOException
  }
  
  private void a(String paramString) {
    SharedPreferences.Editor editor = this.a.getSharedPreferences("ShortVideo", 0).edit();
    editor.putString("feature", Base64.encodeToString(paramString.getBytes(), 0));
    editor.apply();
  }
  
  private void a(boolean paramBoolean) {
    d = paramBoolean;
  }
  
  private String b(Context paramContext) {
    return (paramContext != null) ? j.g(paramContext) : "";
  }
  
  private void b(PLAuthenticationResultCallback paramPLAuthenticationResultCallback) {
    if (this.a == null)
      return; 
    this.c = System.currentTimeMillis();
    Context context = this.a;
    if (context != null) {
      SharedPreferences.Editor editor = context.getSharedPreferences("ShortVideo", 0).edit();
      editor.putString("ts", Base64.encodeToString(String.valueOf(this.c).getBytes(), 0));
      editor.apply();
    } 
    (new Thread(new Runnable(this, paramPLAuthenticationResultCallback) {
          public void run() {
            u.a(this.b, this.a);
          }
        })).start();
  }
  
  private void b(String paramString) {
    try {
      JSONArray jSONArray = new JSONArray(paramString);
      this.e.clear();
      for (int i = 0; i < jSONArray.length(); i++) {
        JSONObject jSONObject = jSONArray.getJSONObject(i);
        this.e.add(Integer.valueOf(jSONObject.getInt("id")));
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
  }
  
  private void c() {
    long l = System.currentTimeMillis() - this.c;
    if (l >= 0L && l < 3600000L)
      return; 
    b((PLAuthenticationResultCallback)null);
  }
  
  private void c(PLAuthenticationResultCallback paramPLAuthenticationResultCallback) {
    (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramPLAuthenticationResultCallback) {
          public void run() {
            if (u.a(this.b) == u.b.b) {
              this.a.onAuthorizationResult(1);
              return;
            } 
            if (u.a(this.b) == u.b.c) {
              this.a.onAuthorizationResult(0);
              return;
            } 
            this.a.onAuthorizationResult(-1);
          }
        });
  }
  
  private void d(PLAuthenticationResultCallback paramPLAuthenticationResultCallback) {
    String str = b(this.a);
    if ("".equals(str))
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("https://shortvideo.qiniuapi.com/v1/zeus?appid=");
    stringBuilder.append(str);
    str = stringBuilder.toString();
    try {
      HttpsURLConnection httpsURLConnection = (HttpsURLConnection)(new URL(str)).openConnection();
      httpsURLConnection.setRequestMethod("GET");
      int i = httpsURLConnection.getResponseCode();
      if (i == 200) {
        this.b = b.b;
        a(httpsURLConnection.getInputStream());
      } else if (i == 401) {
        this.b = b.c;
      } else {
        this.b = b.a;
      } 
      if (paramPLAuthenticationResultCallback != null) {
        c(paramPLAuthenticationResultCallback);
        return;
      } 
    } catch (IOException iOException) {
      if (paramPLAuthenticationResultCallback != null)
        c(paramPLAuthenticationResultCallback); 
      iOException.printStackTrace();
    } 
  }
  
  public void a(Context paramContext) {
    if (this.a == null) {
      if (paramContext == null)
        return; 
      this.a = paramContext.getApplicationContext();
      SharedPreferences sharedPreferences = this.a.getSharedPreferences("ShortVideo", 0);
      String str1 = sharedPreferences.getString("ts", "");
      str2 = sharedPreferences.getString("feature", "");
      if (!"".equals(str1))
        this.c = Long.valueOf(new String(Base64.decode(str1, 0))).longValue(); 
      if (!"".equals(str2))
        b(new String(Base64.decode(str2, 0))); 
      for (String str2 : c.a) {
        if (a().b(paramContext).contains(str2)) {
          a().a(false);
          return;
        } 
      } 
    } 
  }
  
  public void a(PLAuthenticationResultCallback paramPLAuthenticationResultCallback) {
    b(paramPLAuthenticationResultCallback);
  }
  
  public boolean a(b.a parama) {
    boolean bool2 = d;
    boolean bool1 = true;
    if (!bool2) {
      this.b = b.b;
      return true;
    } 
    c();
    if (this.b == b.c) {
      bool1 = false;
    } else if (!this.e.isEmpty()) {
      bool1 = this.e.contains(Integer.valueOf(parama.a()));
    } 
    if (!bool1) {
      e e = e.b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("no authorized feature : ");
      stringBuilder.append(parama);
      stringBuilder.append(" status : ");
      stringBuilder.append(this.b);
      e.e("ZeusManager", stringBuilder.toString());
    } 
    return bool1;
  }
  
  public boolean a(b.a parama, PLVideoSaveListener paramPLVideoSaveListener) {
    boolean bool = a(parama);
    if (!bool && paramPLVideoSaveListener != null)
      paramPLVideoSaveListener.onSaveVideoFailed(8); 
    return bool;
  }
  
  public boolean b() {
    if (!d) {
      this.b = b.b;
      return true;
    } 
    c();
    return (this.b != b.c);
  }
  
  static class a {
    public static final u a = new u();
  }
  
  enum b {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\cor\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */