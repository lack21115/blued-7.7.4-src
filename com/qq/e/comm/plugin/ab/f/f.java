package com.qq.e.comm.plugin.ab.f;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.plugin.ab.b.c;
import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

class f {
  private static final Pattern a = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");
  
  private a b;
  
  public f(a parama) {
    this.b = parama;
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
        if ("multiAction".equals(str1))
          return new d(str2, str1, str3, null, str); 
        try {
          if (!StringUtil.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            return new d(str2, str1, str3, jSONObject);
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
    return new d(str2, str1, str3, (JSONObject)paramUri);
  }
  
  public d a(String paramString) {
    try {
      Uri uri = Uri.parse(paramString);
      if (a(uri))
        return b(uri); 
    } finally {
      Exception exception = null;
    } 
  }
  
  public void a() {
    a(new c("bridge.onReceived", new String[0]));
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\f\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */