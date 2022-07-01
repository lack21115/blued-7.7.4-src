package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

public class c extends a {
  private final JSONObject c;
  
  public c(Context paramContext, String paramString, JSONObject paramJSONObject) {
    super(paramContext, paramString);
    this.c = paramJSONObject;
  }
  
  private static void a(Intent paramIntent, JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
    if (paramJSONObject1 != null && paramJSONObject2 != null && paramJSONObject1.length() == paramJSONObject2.length()) {
      if (paramIntent == null)
        return; 
      Iterator<String> iterator = paramJSONObject1.keys();
      if (iterator != null)
        while (iterator.hasNext()) {
          String str1 = iterator.next();
          String str2 = paramJSONObject2.optString(str1);
          if (str2 != null)
            a(paramJSONObject1, str1, str2, paramIntent); 
        }  
    } 
  }
  
  private static void a(JSONObject paramJSONObject, String paramString1, String paramString2, Intent paramIntent) {
    byte b;
    switch (paramString2.hashCode()) {
      default:
        b = -1;
        break;
      case 64711720:
        if (paramString2.equals("boolean")) {
          b = 1;
          break;
        } 
      case 3327612:
        if (paramString2.equals("long")) {
          b = 2;
          break;
        } 
      case 104431:
        if (paramString2.equals("int")) {
          b = 0;
          break;
        } 
      case -891985903:
        if (paramString2.equals("string")) {
          b = 4;
          break;
        } 
      case -1325958191:
        if (paramString2.equals("double")) {
          b = 3;
          break;
        } 
    } 
    if (b != 0) {
      if (b != 1) {
        if (b != 2) {
          if (b != 3) {
            if (b != 4)
              return; 
            paramIntent.putExtra(paramString1, paramJSONObject.optString(paramString1));
            return;
          } 
          paramIntent.putExtra(paramString1, paramJSONObject.optDouble(paramString1));
          return;
        } 
        paramIntent.putExtra(paramString1, paramJSONObject.optLong(paramString1));
        return;
      } 
      paramIntent.putExtra(paramString1, paramJSONObject.optBoolean(paramString1));
      return;
    } 
    paramIntent.putExtra(paramString1, paramJSONObject.optInt(paramString1));
  }
  
  public Intent b() {
    String str4 = this.c.optString("action");
    String str2 = this.c.optString("category");
    int i = this.c.optInt("flags", 1342210048);
    String str1 = this.c.optString("path_extra_key");
    String str3 = this.c.optString("path_data_key");
    JSONObject jSONObject1 = this.c.optJSONObject("extra");
    JSONObject jSONObject2 = this.c.optJSONObject("extra_type");
    if (TextUtils.isEmpty(str4))
      return null; 
    Intent intent = new Intent(str4);
    if (!TextUtils.isEmpty(str2))
      intent.addCategory(str2); 
    if (!TextUtils.isEmpty(str3))
      try {
        intent.setData(Uri.parse(String.format(str3, new Object[] { this.b })));
      } finally {} 
    intent.setFlags(i);
    if (!TextUtils.isEmpty(str1))
      intent.putExtra(str1, this.b); 
    a(intent, jSONObject1, jSONObject2);
    return intent;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */