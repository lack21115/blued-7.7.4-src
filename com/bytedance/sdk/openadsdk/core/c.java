package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.a;
import com.bytedance.sdk.openadsdk.core.d.b;
import com.bytedance.sdk.openadsdk.core.d.d;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.g;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
  public static a a(JSONObject paramJSONObject, AdSlot paramAdSlot) {
    if (paramJSONObject == null)
      return null; 
    try {
      a a = new a();
      a.a(paramJSONObject.optString("request_id"));
      a.a(paramJSONObject.optInt("ret"));
      a.b(paramJSONObject.optString("message"));
      if (a.b() != 0)
        return null; 
      return a;
    } finally {
      paramJSONObject = null;
      paramJSONObject.printStackTrace();
    } 
  }
  
  public static k a(JSONObject paramJSONObject) {
    return (paramJSONObject == null) ? null : b(paramJSONObject, null);
  }
  
  private static boolean a(b paramb) {
    return (paramb == null) ? false : (!TextUtils.isEmpty(paramb.b()));
  }
  
  private static boolean a(f paramf) {
    return (paramf == null) ? true : (!TextUtils.isEmpty(paramf.a()) ? (TextUtils.isEmpty(paramf.b()) ? false : (!(paramf.c() != 1 && paramf.c() != 2))) : false);
  }
  
  private static boolean a(k paramk) {
    boolean bool1;
    boolean bool2 = false;
    if (paramk == null) {
      bool1 = false;
    } else {
      bool1 = true;
    } 
    if (!TextUtils.isEmpty(paramk.M())) {
      if (paramk.M().length() <= 1)
        return false; 
      if (!a(paramk.O()))
        return false; 
      int i = paramk.B();
      if ((i != 2) ? ((i != 3) ? ((i != 4) ? (i == 5 && TextUtils.isEmpty(paramk.G())) : !a(paramk.N())) : TextUtils.isEmpty(paramk.E())) : TextUtils.isEmpty(paramk.E()))
        bool1 = false; 
      if (!bool1)
        return bool1; 
      i = paramk.Q();
      if (i != 2 && i != 3 && i != 4)
        if (i != 5 && i != 15) {
          if (i != 16)
            bool2 = bool1; 
        } else {
          if (!a(paramk.z()))
            return false; 
          bool2 = bool1;
        }  
      if (!a(paramk.F()))
        return false; 
    } else {
      return bool2;
    } 
    bool2 = bool1;
  }
  
  private static boolean a(r paramr) {
    return (paramr == null) ? false : (TextUtils.isEmpty(paramr.g()) ? false : (!TextUtils.isEmpty(paramr.f())));
  }
  
  private static boolean a(List<j> paramList) {
    if (paramList == null)
      return false; 
    if (paramList.size() <= 0)
      return false; 
    for (j j : paramList) {
      if (j == null)
        return false; 
      if (TextUtils.isEmpty(j.a()))
        return false; 
    } 
    return true;
  }
  
  private static AdSlot b(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    String str1 = paramJSONObject.optString("mCodeId", "");
    int i = paramJSONObject.optInt("mImgAcceptedWidth", 0);
    int j = paramJSONObject.optInt("mImgAcceptedHeight", 0);
    float f1 = (float)paramJSONObject.optDouble("mExpressViewAcceptedWidth", 0.0D);
    float f2 = (float)paramJSONObject.optDouble("mExpressViewAcceptedHeight", 0.0D);
    int k = paramJSONObject.optInt("mAdCount", 6);
    boolean bool1 = paramJSONObject.optBoolean("mSupportDeepLink", true);
    String str2 = paramJSONObject.optString("mRewardName", "");
    int m = paramJSONObject.optInt("mRewardAmount", 0);
    String str3 = paramJSONObject.optString("mMediaExtra", "");
    String str4 = paramJSONObject.optString("mUserID", "");
    int n = paramJSONObject.optInt("mOrientation", 2);
    int i1 = paramJSONObject.optInt("mNativeAdType", 0);
    boolean bool2 = paramJSONObject.optBoolean("mIsAutoPlay", false);
    return (new AdSlot.Builder()).setCodeId(str1).setImageAcceptedSize(i, j).setExpressViewAcceptedSize(f1, f2).setAdCount(k).setSupportDeepLink(bool1).setRewardName(str2).setRewardAmount(m).setMediaExtra(str3).setUserID(str4).setOrientation(n).setNativeAdType(i1).setIsAutoPlay(bool2).build();
  }
  
  public static k b(JSONObject paramJSONObject, AdSlot paramAdSlot) {
    if (paramJSONObject == null)
      return null; 
    k k = new k();
    k.i(paramJSONObject.optInt("interaction_type"));
    k.c(paramJSONObject.optString("target_url"));
    k.h(paramJSONObject.optString("ad_id"));
    k.b(paramJSONObject.optString("source"));
    k.l(paramJSONObject.optInt("dislike_control", 0));
    k.h(paramJSONObject.optInt("play_bar_show_time", -200));
    k.a(paramJSONObject.optBoolean("is_playable"));
    k.b(paramJSONObject.optInt("playable_type", 0));
    k.a(paramJSONObject.optString("playable_style"));
    JSONObject jSONObject4 = paramJSONObject.optJSONObject("icon");
    k.b(paramJSONObject.optBoolean("screenshot", false));
    k.f(paramJSONObject.optInt("play_bar_style", 0));
    k.j(paramJSONObject.optString("market_url", ""));
    k.d(paramJSONObject.optInt("video_adaptation", 0));
    k.c(paramJSONObject.optInt("feed_video_opentype", 0));
    k.a(paramJSONObject.optJSONObject("session_params"));
    if (jSONObject4 != null) {
      j j = new j();
      j.a(jSONObject4.optString("url"));
      j.b(jSONObject4.optInt("height"));
      j.a(jSONObject4.optInt("width"));
      k.a(j);
    } 
    jSONObject4 = paramJSONObject.optJSONObject("cover_image");
    if (jSONObject4 != null) {
      j j = new j();
      j.a(jSONObject4.optString("url"));
      j.b(jSONObject4.optInt("height"));
      j.a(jSONObject4.optInt("width"));
      k.b(j);
    } 
    JSONArray jSONArray2 = paramJSONObject.optJSONArray("image");
    if (jSONArray2 != null)
      for (int i = 0; i < jSONArray2.length(); i++) {
        j j = new j();
        JSONObject jSONObject = jSONArray2.optJSONObject(i);
        j.a(jSONObject.optString("url"));
        j.b(jSONObject.optInt("height"));
        j.a(jSONObject.optInt("width"));
        k.c(j);
      }  
    jSONArray2 = paramJSONObject.optJSONArray("show_url");
    if (jSONArray2 != null)
      for (int i = 0; i < jSONArray2.length(); i++)
        k.H().add(jSONArray2.optString(i));  
    jSONArray2 = paramJSONObject.optJSONArray("click_url");
    if (jSONArray2 != null)
      for (int i = 0; i < jSONArray2.length(); i++)
        k.I().add(jSONArray2.optString(i));  
    JSONObject jSONObject3 = paramJSONObject.optJSONObject("click_area");
    if (jSONObject3 != null) {
      d d = new d();
      d.a = jSONObject3.optBoolean("click_upper_content_area", true);
      d.b = jSONObject3.optBoolean("click_upper_non_content_area", true);
      d.c = jSONObject3.optBoolean("click_lower_content_area", true);
      d.d = jSONObject3.optBoolean("click_lower_non_content_area", true);
      d.e = jSONObject3.optBoolean("click_button_area", true);
      d.f = jSONObject3.optBoolean("click_video_area", true);
      k.a(d);
    } 
    jSONObject3 = paramJSONObject.optJSONObject("adslot");
    if (jSONObject3 != null) {
      k.a(b(jSONObject3));
    } else {
      k.a(paramAdSlot);
    } 
    k.g(paramJSONObject.optInt("intercept_flag", 0));
    k.d(paramJSONObject.optString("phone_num"));
    k.e(paramJSONObject.optString("title"));
    k.f(paramJSONObject.optString("description"));
    k.g(paramJSONObject.optString("button_text"));
    k.e(paramJSONObject.optInt("ad_logo", 1));
    k.i(paramJSONObject.optString("ext"));
    k.j(paramJSONObject.optInt("image_mode"));
    JSONObject jSONObject2 = paramJSONObject.optJSONObject("app");
    jSONObject3 = paramJSONObject.optJSONObject("deep_link");
    k.a(d(jSONObject2));
    k.a(f(jSONObject3));
    JSONArray jSONArray1 = paramJSONObject.optJSONArray("filter_words");
    if (jSONArray1 != null)
      for (int i = 0; i < jSONArray1.length(); i++) {
        FilterWord filterWord = c(jSONArray1.optJSONObject(i));
        if (filterWord != null && filterWord.isValid())
          k.a(filterWord); 
      }  
    k.k(paramJSONObject.optInt("count_down"));
    k.a(paramJSONObject.optLong("expiration_time"));
    JSONObject jSONObject1 = paramJSONObject.optJSONObject("video");
    if (jSONObject1 != null)
      k.a(g(jSONObject1)); 
    jSONObject1 = paramJSONObject.optJSONObject("download_conf");
    if (jSONObject1 != null)
      k.a(e(jSONObject1)); 
    k.a(h(paramJSONObject.optJSONObject("media_ext")));
    jSONObject1 = paramJSONObject.optJSONObject("tpl_info");
    if (jSONObject1 != null) {
      k.a a = new k.a();
      a.b(jSONObject1.optString("id"));
      a.c(jSONObject1.optString("md5"));
      a.d(jSONObject1.optString("url"));
      a.e(jSONObject1.optString("data"));
      a.f(jSONObject1.optString("diff_data"));
      a.g(jSONObject1.optString("dynamic_creative"));
      a.a(jSONObject1.optString("version"));
      k.a(a);
    } 
    k.a(paramJSONObject.optInt("if_block_lp", 0));
    return k;
  }
  
  private static FilterWord c(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    try {
      FilterWord filterWord = new FilterWord();
      filterWord.setId(paramJSONObject.optString("id"));
      filterWord.setName(paramJSONObject.optString("name"));
      filterWord.setIsSelected(paramJSONObject.optBoolean("is_selected"));
      JSONArray jSONArray = paramJSONObject.optJSONArray("options");
      return filterWord;
    } finally {
      paramJSONObject = null;
    } 
  }
  
  private static b d(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    b b = new b();
    b.c(paramJSONObject.optString("app_name"));
    b.d(paramJSONObject.optString("package_name"));
    b.b(paramJSONObject.optString("download_url"));
    b.a(paramJSONObject.optInt("score", 4));
    b.b(paramJSONObject.optInt("comment_num", 6870));
    b.c(paramJSONObject.optInt("app_size", 0));
    b.a(paramJSONObject.optString("quick_app_url", ""));
    return b;
  }
  
  private static g e(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    g g = new g();
    g.d(paramJSONObject.optInt("auto_open", 1));
    g.e(paramJSONObject.optInt("download_mode", 0));
    g.c(paramJSONObject.optInt("support_multiple", 0));
    g.f(paramJSONObject.optInt("auto_control", 0));
    g.b(paramJSONObject.optInt("download_type", -1));
    g.a(paramJSONObject.optInt("if_suspend_download", 1));
    return g;
  }
  
  private static f f(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    f f = new f();
    f.a(paramJSONObject.optString("deeplink_url"));
    f.b(paramJSONObject.optString("fallback_url"));
    f.a(paramJSONObject.optInt("fallback_type"));
    return f;
  }
  
  private static r g(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    r r = new r();
    r.a(paramJSONObject.optInt("cover_height"));
    r.b(paramJSONObject.optInt("cover_width"));
    r.a(paramJSONObject.optString("resolution"));
    r.a(paramJSONObject.optLong("size"));
    r.a(paramJSONObject.optDouble("video_duration"));
    r.b(paramJSONObject.optString("cover_url"));
    r.c(paramJSONObject.optString("video_url"));
    r.d(paramJSONObject.optString("endcard"));
    r.e(paramJSONObject.optString("playable_download_url"));
    r.f(paramJSONObject.optString("file_hash"));
    r.c(paramJSONObject.optInt("if_playable_loading_show", 0));
    r.d(paramJSONObject.optInt("remove_loading_page_type", 0));
    return r;
  }
  
  private static Map<String, Object> h(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Iterator<String> iterator = paramJSONObject.keys();
    while (iterator.hasNext()) {
      String str = iterator.next();
      if (TextUtils.isEmpty(str))
        continue; 
      hashMap.put(str, paramJSONObject.opt(str));
    } 
    return (Map)hashMap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */