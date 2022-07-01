package com.bytedance.sdk.openadsdk.d;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.video.b.b;
import com.bytedance.sdk.openadsdk.downloadnew.core.b;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements c {
  private final k a;
  
  private final b b;
  
  private final Map<String, b> c = new HashMap<String, b>();
  
  private a(b paramb, k paramk) {
    this.b = paramb;
    this.a = paramk;
  }
  
  private k a(JSONObject paramJSONObject, String paramString) {
    String str;
    JSONObject jSONObject = null;
    if (paramJSONObject == null)
      return null; 
    k k1 = new k();
    k1.b(paramJSONObject);
    if (!TextUtils.isEmpty(paramString))
      k1.i(paramString); 
    if (this.a == null)
      return k1; 
    paramJSONObject = jSONObject;
    if (k1.N() != null)
      str = k1.N().b(); 
    return TextUtils.isEmpty(str) ? this.a : ((this.a.N() != null && str.equals(this.a.N().b())) ? this.a : k1);
  }
  
  public static a a(b paramb, k paramk) {
    return new a(paramb, paramk);
  }
  
  private b a(Context paramContext, k paramk, JSONObject paramJSONObject, String paramString, boolean paramBoolean) {
    b b1 = com.bytedance.sdk.openadsdk.downloadnew.a.b(paramContext, paramk, paramString);
    b1.a(new TTAppDownloadListener(this, paramJSONObject) {
          private void a(String... param1VarArgs) {
            if (param1VarArgs != null) {
              if (param1VarArgs.length % 2 != 0)
                return; 
              try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("message", "success");
                jSONObject.put("appad", this.a);
                for (int i = 0; i < param1VarArgs.length; i += 2)
                  jSONObject.put(param1VarArgs[i], param1VarArgs[i + 1]); 
                a.a(this.b).a("app_ad_event", jSONObject);
                return;
              } catch (JSONException jSONException) {
                t.b("JsAppAdDownloadManager", "JSONException");
              } 
            } 
          }
          
          public void onDownloadActive(long param1Long1, long param1Long2, String param1String1, String param1String2) {
            a(new String[] { "status", "download_active", "total_bytes", String.valueOf(param1Long1), "current_bytes", String.valueOf(param1Long2) });
          }
          
          public void onDownloadFailed(long param1Long1, long param1Long2, String param1String1, String param1String2) {
            a(new String[] { "status", "download_failed", "total_bytes", String.valueOf(param1Long1), "current_bytes", String.valueOf(param1Long2) });
          }
          
          public void onDownloadFinished(long param1Long, String param1String1, String param1String2) {
            a(new String[] { "status", "download_finished", "total_bytes", String.valueOf(param1Long), "current_bytes", String.valueOf(param1Long) });
          }
          
          public void onDownloadPaused(long param1Long1, long param1Long2, String param1String1, String param1String2) {
            a(new String[] { "status", "download_paused", "total_bytes", String.valueOf(param1Long1), "current_bytes", String.valueOf(param1Long2) });
          }
          
          public void onIdle() {
            a(new String[] { "status", "idle" });
          }
          
          public void onInstalled(String param1String1, String param1String2) {
            a(new String[] { "status", "installed" });
          }
        }false);
    b1.a(new b.a(this, paramJSONObject) {
        
        });
    b1.a(3, new com.bytedance.sdk.openadsdk.downloadnew.core.a.a(this, paramBoolean, paramContext, paramk) {
          public boolean a(int param1Int, k param1k, String param1String1, String param1String2, Object param1Object) {
            if (param1Int != 3)
              return true; 
            if (param1k != null && !TextUtils.isEmpty(param1String1)) {
              if (TextUtils.isEmpty(param1String2))
                return true; 
              boolean bool = this.a;
              boolean bool1 = false;
              if (!bool) {
                param1Int = -1;
                switch (param1String2.hashCode()) {
                  case 1685366507:
                    if (param1String2.equals("click_start"))
                      param1Int = 1; 
                    break;
                  case 1682049151:
                    if (param1String2.equals("click_pause"))
                      param1Int = 2; 
                    break;
                  case 565370917:
                    if (param1String2.equals("click_start_detail"))
                      param1Int = 0; 
                    break;
                  case -777040223:
                    if (param1String2.equals("click_open"))
                      param1Int = 4; 
                    break;
                  case -1297985154:
                    if (param1String2.equals("click_continue"))
                      param1Int = 3; 
                    break;
                } 
                bool = bool1;
                if (param1Int != 0) {
                  bool = bool1;
                  if (param1Int != 1) {
                    bool = bool1;
                    if (param1Int != 2) {
                      bool = bool1;
                      if (param1Int != 3) {
                        bool = bool1;
                        if (param1Int != 4)
                          bool = true; 
                      } 
                    } 
                  } 
                } 
                return bool;
              } 
              if (param1String2.equals("click_start")) {
                d.a(this.b, this.c, param1String1, "click_start_detail", null);
                return false;
              } 
            } 
            return true;
          }
        });
    return b1;
  }
  
  private void a(Context paramContext, k paramk) {
    if (paramContext != null && paramk != null) {
      if (paramk.N() == null)
        return; 
      b b1 = this.c.get(paramk.N().b());
      if (b1 != null)
        b1.h(); 
      if (paramContext instanceof b)
        ((b)paramContext).P(); 
    } 
  }
  
  private void a(Context paramContext, k paramk, JSONObject paramJSONObject, int paramInt, boolean paramBoolean) {
    if (paramContext != null && paramk != null && paramk.N() != null && paramJSONObject != null) {
      if (this.b == null)
        return; 
      if ((b)this.c.get(paramk.N().b()) != null)
        return; 
      String str = ah.a(paramInt);
      if (TextUtils.isEmpty(str))
        return; 
      b b1 = a(paramContext, paramk, paramJSONObject, str, paramBoolean);
      this.c.put(paramk.N().b(), b1);
    } 
  }
  
  private void a(k paramk, JSONObject paramJSONObject) {
    if (this.b != null && paramk != null) {
      if (paramk.N() == null)
        return; 
      String str = paramk.N().b();
      if (this.c.containsKey(str)) {
        this.c.remove(str);
        try {
          JSONObject jSONObject = new JSONObject();
          jSONObject.put("message", "success");
          jSONObject.put("status", "unsubscribed");
          jSONObject.put("appad", paramJSONObject);
          this.b.a("app_ad_event", jSONObject);
          return;
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
      } 
    } 
  }
  
  public void a() {
    for (com.bytedance.sdk.openadsdk.downloadnew.core.a a1 : this.c.values()) {
      if (a1 != null)
        a1.b(); 
    } 
  }
  
  public void a(Context paramContext, JSONObject paramJSONObject) {
    if (paramContext != null) {
      if (paramJSONObject == null)
        return; 
      paramJSONObject = paramJSONObject.optJSONObject("data");
      if (paramJSONObject != null)
        a(paramContext, a(paramJSONObject, (String)null)); 
    } 
  }
  
  public void a(Context paramContext, JSONObject paramJSONObject, String paramString, int paramInt, boolean paramBoolean) {
    if (paramContext != null) {
      if (paramJSONObject == null)
        return; 
      paramJSONObject = paramJSONObject.optJSONObject("data");
      if (paramJSONObject != null)
        a(paramContext, a(paramJSONObject, paramString), paramJSONObject, paramInt, paramBoolean); 
    } 
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return; 
    paramJSONObject = paramJSONObject.optJSONObject("data");
    if (paramJSONObject != null)
      a(a(paramJSONObject, (String)null), paramJSONObject); 
  }
  
  public void b() {
    for (com.bytedance.sdk.openadsdk.downloadnew.core.a a1 : this.c.values()) {
      if (a1 != null)
        a1.c(); 
    } 
  }
  
  public void b(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      if (this.b == null)
        return; 
      paramJSONObject = paramJSONObject.optJSONObject("data");
      if (paramJSONObject != null) {
        k k1 = a(paramJSONObject, (String)null);
        b b1 = this.c.get(k1.N().b());
        if (b1 != null)
          b1.g(); 
      } 
    } 
  }
  
  public void c() {
    b();
    for (com.bytedance.sdk.openadsdk.downloadnew.core.a a1 : this.c.values()) {
      if (a1 != null)
        a1.d(); 
    } 
    this.c.clear();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */