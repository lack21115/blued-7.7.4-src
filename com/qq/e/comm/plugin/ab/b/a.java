package com.qq.e.comm.plugin.ab.b;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.plugin.ab.c.e;
import com.qq.e.comm.plugin.ab.c.g;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  private static final Pattern a = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");
  
  private h b;
  
  private g c;
  
  public a(h paramh) {
    this.b = paramh;
    this.c = new g(paramh);
  }
  
  public static boolean a(Uri paramUri) {
    return (paramUri != null && paramUri.isHierarchical() && paramUri.getScheme().equals("gdtmsg") && paramUri.getAuthority().equals("e.qq.com"));
  }
  
  private d b(Uri paramUri) {
    String str1;
    String str2;
    String str3;
    if (paramUri != null) {
      str1 = paramUri.getPath();
      Matcher matcher = a.matcher(str1);
      if (matcher.matches()) {
        str1 = matcher.group(1);
        str2 = matcher.group(2);
        str3 = matcher.group(3);
        String str = paramUri.getQueryParameter("q");
        try {
          if (!StringUtil.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            return new d(str1, str2, str3, jSONObject);
          } 
        } catch (JSONException jSONException) {
          GDTLogger.report("Exception while json-parse JS Request Paramert Q", (Throwable)jSONException);
          return null;
        } 
      } else {
        return null;
      } 
    } else {
      return null;
    } 
    paramUri = null;
    return new d(str1, str2, str3, (JSONObject)paramUri);
  }
  
  public void a() {
    a(new c("bridge.onReceived", new String[0]));
  }
  
  public void a(b paramb) {
    if (paramb != null)
      (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramb) {
            public void run() {
              try {
                return;
              } finally {
                Exception exception = null;
                GDTLogger.report("Exception while fire JSEvent");
              } 
            }
          }); 
  }
  
  public void a(c paramc) {
    if (paramc != null)
      (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramc) {
            public void run() {
              try {
                return;
              } finally {
                Exception exception = null;
                GDTLogger.report("Exception while sending JSResponse");
              } 
            }
          }); 
  }
  
  public void a(e parame) {
    if (parame != null)
      (new Handler(Looper.getMainLooper())).post(new Runnable(this, parame) {
            public void run() {
              try {
                return;
              } finally {
                Exception exception = null;
                GDTLogger.report("Exception while sending JSResponse", exception);
              } 
            }
          }); 
  }
  
  public void a(String paramString) {
    try {
      Uri uri = Uri.parse(paramString);
      if (a(uri)) {
        d d = b(uri);
        if (d != null)
          return; 
        return;
      } 
    } finally {
      Exception exception = null;
    } 
  }
  
  public void a(String paramString, e parame) {
    this.c.a(paramString, parame);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */