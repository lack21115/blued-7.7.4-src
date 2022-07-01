package com.bytedance.embedapplog.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import com.bytedance.embedapplog.util.h;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.json.JSONObject;

class o extends c {
  private final Context e;
  
  o(Context paramContext) {
    super(false, false);
    this.e = paramContext;
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    String str;
    try {
      str = Settings.Secure.getString(this.e.getContentResolver(), "android_id");
    } catch (Exception exception) {
      h.c("", exception);
      exception = null;
    } 
    if (!i.d((String)exception) || "9774d56d682e549c".equals(exception)) {
      SharedPreferences sharedPreferences = this.e.getSharedPreferences("snssdk_openudid", 0);
      String str1 = sharedPreferences.getString("openudid", null);
      str = str1;
      if (!i.d(str1)) {
        String str2;
        str1 = (new BigInteger(64, new SecureRandom())).toString(16);
        str = str1;
        if (str1.charAt(0) == '-')
          str = str1.substring(1); 
        int i = 13 - str.length();
        str1 = str;
        if (i > 0) {
          StringBuilder stringBuilder = new StringBuilder();
          while (i > 0) {
            stringBuilder.append('F');
            i--;
          } 
          stringBuilder.append(str);
          str2 = stringBuilder.toString();
        } 
        str = a("openudid.dat", str2);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("openudid", str);
        editor.apply();
      } 
    } 
    paramJSONObject.put("openudid", str);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */