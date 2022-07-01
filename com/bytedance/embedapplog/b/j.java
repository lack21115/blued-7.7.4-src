package com.bytedance.embedapplog.b;

import android.content.Context;
import android.util.DisplayMetrics;
import org.json.JSONObject;

class j extends c {
  private final Context e;
  
  j(Context paramContext) {
    super(true, false);
    this.e = paramContext;
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    String str6;
    StringBuilder stringBuilder6;
    String str5;
    StringBuilder stringBuilder5;
    String str4;
    StringBuilder stringBuilder4;
    String str3;
    StringBuilder stringBuilder3;
    String str2;
    StringBuilder stringBuilder2;
    DisplayMetrics displayMetrics = this.e.getResources().getDisplayMetrics();
    int i = displayMetrics.densityDpi;
    switch (i) {
      default:
        str6 = "mdpi";
        paramJSONObject.put("density_dpi", i);
        paramJSONObject.put("display_density", str6);
        stringBuilder6 = new StringBuilder();
        stringBuilder6.append(displayMetrics.heightPixels);
        stringBuilder6.append("x");
        stringBuilder6.append(displayMetrics.widthPixels);
        paramJSONObject.put("resolution", stringBuilder6.toString());
        return true;
      case 560:
      case 640:
        str5 = "xxxhdpi";
        paramJSONObject.put("density_dpi", i);
        paramJSONObject.put("display_density", str5);
        stringBuilder5 = new StringBuilder();
        stringBuilder5.append(displayMetrics.heightPixels);
        stringBuilder5.append("x");
        stringBuilder5.append(displayMetrics.widthPixels);
        paramJSONObject.put("resolution", stringBuilder5.toString());
        return true;
      case 340:
      case 360:
      case 400:
      case 420:
      case 440:
      case 480:
        str4 = "xxhdpi";
        paramJSONObject.put("density_dpi", i);
        paramJSONObject.put("display_density", str4);
        stringBuilder4 = new StringBuilder();
        stringBuilder4.append(displayMetrics.heightPixels);
        stringBuilder4.append("x");
        stringBuilder4.append(displayMetrics.widthPixels);
        paramJSONObject.put("resolution", stringBuilder4.toString());
        return true;
      case 260:
      case 280:
      case 300:
      case 320:
        str3 = "xhdpi";
        paramJSONObject.put("density_dpi", i);
        paramJSONObject.put("display_density", str3);
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(displayMetrics.heightPixels);
        stringBuilder3.append("x");
        stringBuilder3.append(displayMetrics.widthPixels);
        paramJSONObject.put("resolution", stringBuilder3.toString());
        return true;
      case 240:
        str2 = "hdpi";
        paramJSONObject.put("density_dpi", i);
        paramJSONObject.put("display_density", str2);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(displayMetrics.heightPixels);
        stringBuilder2.append("x");
        stringBuilder2.append(displayMetrics.widthPixels);
        paramJSONObject.put("resolution", stringBuilder2.toString());
        return true;
      case 120:
        break;
    } 
    String str1 = "ldpi";
    paramJSONObject.put("density_dpi", i);
    paramJSONObject.put("display_density", str1);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(displayMetrics.heightPixels);
    stringBuilder1.append("x");
    stringBuilder1.append(displayMetrics.widthPixels);
    paramJSONObject.put("resolution", stringBuilder1.toString());
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */