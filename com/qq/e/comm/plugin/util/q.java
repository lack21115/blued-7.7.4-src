package com.qq.e.comm.plugin.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.k;
import com.qq.e.comm.plugin.s.a;
import org.json.JSONArray;
import org.json.JSONObject;

public class q {
  public static k a(JSONObject paramJSONObject) {
    k k = new k();
    k.b = paramJSONObject.optString("float_card_title");
    k.a = paramJSONObject.optString("float_card_img");
    if (TextUtils.isEmpty(k.b) || TextUtils.isEmpty(k.a))
      return null; 
    JSONArray jSONArray = paramJSONObject.optJSONArray("float_card_tags");
    if (jSONArray != null && jSONArray.length() > 0) {
      k.c = new String[jSONArray.length()];
      int i = 0;
      int j = jSONArray.length();
      while (i < j) {
        k.c[i] = jSONArray.optString(i);
        i++;
      } 
    } 
    k.d = paramJSONObject.optString("float_card_discount");
    k.e = paramJSONObject.optString("float_card_price");
    k.f = paramJSONObject.optString("float_card_button_txt");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("parseDpaData : ");
    stringBuilder.append(k.toString());
    ak.a("DpaUtil", stringBuilder.toString());
    return k;
  }
  
  public static boolean a(a parama) {
    return (parama != null && parama.ab() != null && !TextUtils.isEmpty((parama.ab()).b) && !TextUtils.isEmpty((parama.ab()).a));
  }
  
  public static int b(a parama) {
    String str1;
    int i = Color.parseColor("#3171F4");
    if (parama == null)
      return i; 
    String str3 = GDTADManager.getInstance().getSM().getString("mdpa_card_btn_color");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getDPAButtonColor , control server : ");
    stringBuilder.append(str3);
    ak.a("DpaUtil", stringBuilder.toString());
    String str2 = str3;
    if (TextUtils.isEmpty(str3))
      str2 = "[{\"25\":\"#E22318\"},{\"1101073593\":\"#FF552E\"},{\"100783983\":\"#62AB00\"},{\"1106744181\":\"#3171F4\"},{\"1101072624\":\"#FA2A83\"}]"; 
    if (parama.a_() != 25) {
      str1 = parama.E().optString("productid");
    } else {
      str1 = "25";
    } 
    int j = i;
    try {
      JSONArray jSONArray = new JSONArray(str2);
      int k = 0;
      j = i;
      int m = jSONArray.length();
      while (true) {
        j = i;
        if (k < m) {
          j = i;
          str3 = jSONArray.getJSONObject(k).optString(str1);
          int n = i;
          j = i;
          if (!TextUtils.isEmpty(str3)) {
            j = i;
            n = Color.parseColor(str3);
          } 
          k++;
          i = n;
          continue;
        } 
        break;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return j;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */