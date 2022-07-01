package com.qq.e.comm.plugin.o.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ab.c.f;
import com.qq.e.comm.plugin.ab.f.a.c;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.rewardvideo.j;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends c {
  private final LinkedHashMap<String, b> a = new LinkedHashMap<String, b>();
  
  private String a(String paramString1, int paramInt, String paramString2, long paramLong) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("code", paramInt);
      JSONObject jSONObject1 = new JSONObject();
      jSONObject.put("data", jSONObject1);
      jSONObject1.put("action", paramString1);
      if (!TextUtils.isEmpty(paramString2))
        jSONObject1.put("message", paramString2); 
      if (paramLong > 0L)
        jSONObject1.put("expiredTimestamp", paramLong); 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject.toString();
  }
  
  public f<String> a(e parame, View paramView, String paramString1, String paramString2, String paramString3, String paramString4) {
    StringBuilder stringBuilder;
    b b;
    String str1 = paramString4;
    if (TextUtils.isEmpty(paramString2) || TextUtils.isEmpty(paramString3) || TextUtils.isEmpty(paramString4)) {
      parame.a(str1, 1, "Params Empty !", 1);
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append(": Params Empty !");
      GDTLogger.e(stringBuilder.toString());
      u.a(21072, 1, (c)null);
      return new f(null);
    } 
    try {
      JSONObject jSONObject = new JSONObject(paramString3);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      jSONException = null;
    } 
    if (jSONException == null) {
      stringBuilder.a(str1, 3, "Json 解析结果为空 !", 1);
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append(": Json 解析结果为空 !");
      GDTLogger.e(stringBuilder.toString());
      u.a(21072, 4, (c)null);
      return new f(null);
    } 
    paramString3 = jSONException.optString("instance_id");
    paramString4 = jSONException.optString("placement_id");
    String str3 = jSONException.optString("ext_url");
    String str2 = jSONException.optString("xflow_pos_id");
    c c1 = (new c()).a(paramString4);
    if ("registerRewardVideoAD".equals(paramString2)) {
      u.a(21012, 0, c1);
      if (TextUtils.isEmpty(paramString3) || TextUtils.isEmpty(paramString4) || TextUtils.isEmpty(str3)) {
        stringBuilder.a(str1, 0, a("onError", 4001, "传入的参数有错误", 0L), 1);
        u.a(21072, 6, c1);
        return new f(null);
      } 
      b = new b(this, (e)stringBuilder, str1);
      b.a(new a(this, GDTADManager.getInstance().getAppContext(), GDTADManager.getInstance().getAppStatus().getAPPID(), paramString4, (ADListener)new RewardVideoAD.ADListenerAdapter(b), str3, str2));
      if (this.a.size() < GDTADManager.getInstance().getSM().getInteger("maxRewardVideoAdsPerWebview", 100)) {
        this.a.put(paramString3, b);
        stringBuilder.a(str1, 0, a("onRegisterSuccess", 0, null, 0L), 1);
      } else {
        stringBuilder.a(str1, 0, a("onError", 4001, "传入的参数有错误", 0L), 1);
        u.a(21002, 0, c1);
      } 
      return new f(null);
    } 
    if ("loadRewardVideoAD".equals(b)) {
      u.a(21022, 0, c1);
      if (TextUtils.isEmpty(paramString3)) {
        u.a(21072, 2, c1);
        GDTLogger.e("loadRewardVideoAD : instanceID is empty !");
        return new f(null);
      } 
      b = this.a.get(paramString3);
      if (b != null) {
        a a1 = b.a();
        str1 = b.b();
      } else {
        str2 = null;
      } 
      if (str2 == null) {
        stringBuilder.a(str1, 0, a("onError", 4017, "广告实例尚未准备好", 0L), 1);
      } else {
        str2.loadAD();
      } 
      return new f(null);
    } 
    if ("showRewardVideoAD".equals(b)) {
      u.a(21032, 0, c1);
      if (TextUtils.isEmpty(paramString3)) {
        u.a(21072, 3, c1);
        GDTLogger.e("showRewardVideoAD : instanceID is empty !");
        return new f(null);
      } 
      b = this.a.get(paramString3);
      if (b != null) {
        a a1 = b.a();
        str1 = b.b();
      } else {
        str2 = null;
      } 
      if (str2 == null) {
        stringBuilder.a(str1, 0, a("onError", 4017, "广告实例尚未准备好", 0L), 1);
      } else {
        str2.showAD();
      } 
      return new f(null);
    } 
    u.a(21072, 5, c1);
    return new f(1000, "Unsupported action");
  }
  
  public String a() {
    return "h5RewardVideo";
  }
  
  class a extends j {
    private final String b;
    
    private final String c;
    
    public a(a this$0, Context param1Context, String param1String1, String param1String2, ADListener param1ADListener, String param1String3, String param1String4) {
      super(param1Context, param1String1, param1String2, param1ADListener);
      this.b = param1String3;
      this.c = param1String4;
    }
    
    public com.qq.e.comm.plugin.ad.b a() {
      com.qq.e.comm.plugin.ad.b b = super.a();
      b.j(1);
      b.c(this.b);
      b.d(this.c);
      return b;
    }
  }
  
  class b implements RewardVideoADListener {
    private final String b;
    
    private a.a c;
    
    private final e d;
    
    public b(a this$0, e param1e, String param1String) {
      this.d = param1e;
      this.b = param1String;
    }
    
    public a.a a() {
      return this.c;
    }
    
    public void a(a.a param1a) {
      this.c = param1a;
    }
    
    public String b() {
      return this.b;
    }
    
    public void onADClick() {
      this.d.a(this.b, 0, a.a(this.a, "onADClick", 0, null, 0L), 1);
    }
    
    public void onADClose() {
      this.d.a(this.b, 0, a.a(this.a, "onADClose", 0, null, 0L), 1);
    }
    
    public void onADExpose() {
      this.d.a(this.b, 0, a.a(this.a, "onADExpose", 0, null, 0L), 1);
    }
    
    public void onADLoad() {
      long l;
      a.a a1 = this.c;
      if (a1 == null) {
        l = 0L;
      } else {
        l = a1.getExpireTimestamp() - SystemClock.elapsedRealtime() + System.currentTimeMillis() / 1000L;
      } 
      this.d.a(this.b, 0, a.a(this.a, "onADLoad", 0, null, l), 1);
    }
    
    public void onADShow() {
      this.d.a(this.b, 0, a.a(this.a, "onADShow", 0, null, 0L), 1);
    }
    
    public void onError(AdError param1AdError) {
      this.d.a(this.b, 0, a.a(this.a, "onError", param1AdError.getErrorCode(), param1AdError.getErrorMsg(), 0L), 1);
    }
    
    public void onReward() {
      this.d.a(this.b, 0, a.a(this.a, "onReward", 0, null, 0L), 1);
    }
    
    public void onVideoCached() {
      this.d.a(this.b, 0, a.a(this.a, "onVideoCached", 0, null, 0L), 1);
    }
    
    public void onVideoComplete() {
      this.d.a(this.b, 0, a.a(this.a, "onVideoComplete", 0, null, 0L), 1);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\o\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */