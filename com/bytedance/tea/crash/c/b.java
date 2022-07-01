package com.bytedance.tea.crash.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.tea.crash.e.a;
import com.bytedance.tea.crash.g.c;
import com.bytedance.tea.crash.g.i;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.h;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
  private static final String[] a = new String[] { "version_code", "manifest_version_code", "aid", "update_version_code" };
  
  private Context b;
  
  private JSONObject c = new JSONObject();
  
  public b(Context paramContext) {
    this.b = paramContext;
  }
  
  public static b a(Context paramContext) {
    b b1 = new b(paramContext);
    JSONObject jSONObject = b1.a();
    b1.a(jSONObject);
    b1.c(jSONObject);
    b1.d(jSONObject);
    b1.e(jSONObject);
    b1.f(jSONObject);
    b1.g(jSONObject);
    b1.b(jSONObject);
    return b1;
  }
  
  private void a(JSONObject paramJSONObject) {
    try {
      String str = this.b.getPackageName();
      PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo(str, 0);
      if (packageInfo.applicationInfo != null) {
        int i = packageInfo.applicationInfo.labelRes;
        if (i > 0)
          paramJSONObject.put("display_name", this.b.getString(i)); 
      } 
      paramJSONObject.put("sdk_version", 22130);
      paramJSONObject.put("sdk_version_name", "2.2.1-alpha.30");
      paramJSONObject.put("os", "Android");
      paramJSONObject.put("os_version", c());
      paramJSONObject.put("os_api", Build.VERSION.SDK_INT);
      paramJSONObject.put("device_model", Build.MODEL);
      paramJSONObject.put("device_brand", Build.BRAND);
      paramJSONObject.put("device_manufacturer", Build.MANUFACTURER);
      paramJSONObject.put("cpu_abi", b());
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private String b() {
    try {
      StringBuilder stringBuilder2 = new StringBuilder();
      if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0)
        for (int i = 0;; i++) {
          StringBuilder stringBuilder = stringBuilder2;
          if (i < Build.SUPPORTED_ABIS.length) {
            stringBuilder2.append(Build.SUPPORTED_ABIS[i]);
            if (i != Build.SUPPORTED_ABIS.length - 1)
              stringBuilder2.append(", "); 
            continue;
          } 
          return TextUtils.isEmpty(stringBuilder.toString()) ? "unknown" : stringBuilder.toString();
        }  
      StringBuilder stringBuilder1 = new StringBuilder(Build.CPU_ABI);
      return TextUtils.isEmpty(stringBuilder1.toString()) ? "unknown" : stringBuilder1.toString();
    } catch (Exception exception) {
      j.b(exception);
      return "unknown";
    } 
  }
  
  private void b(JSONObject paramJSONObject) {
    a a = h.a();
    if (a != null && paramJSONObject != null) {
      Map map = a.b();
      if (map != null)
        try {
          JSONObject jSONObject = new JSONObject();
          for (String str : map.keySet()) {
            if (TextUtils.isEmpty(str))
              continue; 
            Object object = map.get(str);
            if (object != null)
              jSONObject.put(str, object); 
          } 
          paramJSONObject.put("custom", jSONObject);
          return;
        } catch (Exception exception) {
          j.b(exception);
        }  
    } 
  }
  
  private String c() {
    String str = Build.VERSION.RELEASE;
    if (str.contains("."))
      return str; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(".0");
    return stringBuilder.toString();
  }
  
  private void c(JSONObject paramJSONObject) {
    try {
      String str;
      DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
      int i = displayMetrics.densityDpi;
      if (i != 120) {
        if (i != 240) {
          if (i != 320) {
            str = "mdpi";
          } else {
            str = "xhdpi";
          } 
        } else {
          str = "hdpi";
        } 
      } else {
        str = "ldpi";
      } 
      paramJSONObject.put("density_dpi", i);
      paramJSONObject.put("display_density", str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(displayMetrics.heightPixels);
      stringBuilder.append("x");
      stringBuilder.append(displayMetrics.widthPixels);
      paramJSONObject.put("resolution", stringBuilder.toString());
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void d(JSONObject paramJSONObject) {
    int i;
    try {
      String str = (this.b.getResources().getConfiguration()).locale.getLanguage();
      if (!TextUtils.isEmpty(str))
        paramJSONObject.put("language", str); 
      str = Locale.getDefault().getCountry();
      if (!TextUtils.isEmpty(str))
        paramJSONObject.put("region", str); 
      int k = TimeZone.getDefault().getRawOffset() / 3600000;
      i = k;
      if (k < -12)
        i = -12; 
    } catch (Exception exception) {
      return;
    } 
    int j = i;
    if (i > 12)
      j = 12; 
    exception.put("timezone", j);
  }
  
  private void e(JSONObject paramJSONObject) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      if (c.c()) {
        stringBuilder.append("MIUI-");
      } else if (c.d()) {
        stringBuilder.append("FLYME-");
      } else {
        String str = c.a();
        if (c.a(str))
          stringBuilder.append("EMUI-"); 
        if (!TextUtils.isEmpty(str)) {
          stringBuilder.append(str);
          stringBuilder.append("-");
        } 
      } 
      stringBuilder.append(Build.VERSION.INCREMENTAL);
      if (stringBuilder.length() > 0)
        paramJSONObject.put("rom", stringBuilder.toString()); 
      return;
    } finally {
      paramJSONObject = null;
    } 
  }
  
  private void f(JSONObject paramJSONObject) {
    try {
      paramJSONObject.put("access", i.a(this.b));
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
  
  private void g(JSONObject paramJSONObject) {
    try {
      TelephonyManager telephonyManager = (TelephonyManager)this.b.getSystemService("phone");
      if (telephonyManager != null) {
        String str2 = telephonyManager.getNetworkOperatorName();
        if (!TextUtils.isEmpty(str2))
          paramJSONObject.put("carrier", str2); 
        String str1 = telephonyManager.getNetworkOperator();
        if (!TextUtils.isEmpty(str1)) {
          paramJSONObject.put("mcc_mnc", str1);
          return;
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public JSONObject a() {
    return this.c;
  }
  
  public JSONObject a(String paramString) {
    try {
      this.c.put("device_id", paramString);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return this.c;
  }
  
  public JSONObject a(Map<String, Object> paramMap) {
    if (paramMap == null) {
      try {
        return this.c;
      } finally {}
    } else {
      for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
        if (!this.c.has((String)entry.getKey()))
          this.c.put((String)entry.getKey(), entry.getValue()); 
      } 
      String[] arrayOfString = a;
      int j = arrayOfString.length;
      for (int i = 0;; i++) {
        if (i < j) {
          String str = arrayOfString[i];
          boolean bool = paramMap.containsKey(str);
          if (bool)
            try {
              int k = Integer.parseInt((String)paramMap.get(str));
              this.c.put(str, k);
            } catch (Exception exception) {
              this.c.put(str, paramMap.get(str));
            }  
        } else {
          if (paramMap.containsKey("version_code") && !paramMap.containsKey("manifest_version_code")) {
            i = Integer.parseInt((String)paramMap.get("version_code"));
            this.c.put("manifest_version_code", i);
          } 
          if (paramMap.containsKey("iid")) {
            this.c.put("udid", paramMap.get("iid"));
            this.c.remove("iid");
          } 
          return this.c;
        } 
      } 
    } 
    return this.c;
  }
  
  public JSONObject b(String paramString) {
    try {
      if (!TextUtils.isEmpty(paramString))
        this.c.put("user_id", paramString); 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */