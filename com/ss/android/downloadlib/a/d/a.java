package com.ss.android.downloadlib.a.d;

import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.d;
import com.ss.android.downloadlib.e.g;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class a {
  private static String a(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append("|");
    stringBuilder.append(paramString2);
    paramString1 = stringBuilder.toString();
    try {
      return Base64.encodeToString(g.a(paramString1.getBytes(), "596f823f283d4af73ead3ea6".getBytes(), "HmacSHA1"), 2);
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public static void a(c paramc, long paramLong, String paramString1, String paramString2) {
    if (paramc == null)
      return; 
    if (j.e() == null)
      return; 
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      String str1 = (j.j()).b;
      hashMap.put("from", str1);
      String str2 = String.valueOf(System.currentTimeMillis());
      hashMap.put("timestamp", str2);
      hashMap.put("signature", a(str1, str2));
      JSONObject jSONObject2 = new JSONObject();
      jSONObject2.put("ad_id", paramLong);
      jSONObject2.put("log_extra", paramString1);
      jSONObject2.put("download_url", paramc.j());
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("app_name", paramc.i());
      jSONObject1.put("package_name", paramString2);
      jSONObject1.put("package_size", paramc.ab());
      List list = paramc.B();
      if (list != null && !list.isEmpty())
        for (e e : list) {
          if (TextUtils.equals(e.a(), "User-Agent")) {
            jSONObject1.put("User-Agent", e.b());
            break;
          } 
        }  
      jSONObject2.put("request_info", jSONObject1.toString());
      hashMap.put("info", jSONObject2.toString());
      d.a().a(new Runnable(hashMap) {
            public void run() {
              j.e().a("POST", "https://i.snssdk.com/inspect/aegis/client/app/resend/", this.a, null);
            }
          });
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */