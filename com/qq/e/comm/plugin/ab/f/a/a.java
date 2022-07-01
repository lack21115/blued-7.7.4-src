package com.qq.e.comm.plugin.ab.f.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.plugin.a.c;
import com.qq.e.comm.plugin.a.d.d;
import com.qq.e.comm.plugin.a.f;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.a.p;
import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.b.e;
import com.qq.e.comm.plugin.ab.c.f;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.util.ad;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends c {
  private AtomicBoolean a = new AtomicBoolean(false);
  
  private ConcurrentHashMap<String, String> b = new ConcurrentHashMap<String, String>();
  
  private Map<Integer, String> c = new HashMap<Integer, String>();
  
  private e d;
  
  private JSONObject e;
  
  private com.qq.e.comm.plugin.a.d.a f = new com.qq.e.comm.plugin.a.d.a(this) {
      public void a(String param1String, int param1Int1, int param1Int2, long param1Long) {
        if (param1Int1 != 128 && !TextUtils.isEmpty(param1String) && a.a(this.a).containsKey(param1String)) {
          String str = (String)a.a(this.a).get(param1String);
          JSONObject jSONObject = new JSONObject();
          try {
            jSONObject.put("code", 0);
            JSONObject jSONObject1 = new JSONObject();
            jSONObject1.put("status", a.a(this.a, param1Int1));
            jSONObject1.put("progress", param1Int2);
            jSONObject1.put("total", param1Long);
            jSONObject.put("data", jSONObject1);
          } catch (JSONException jSONException) {
            jSONException.printStackTrace();
          } 
          d d = new d(null, null, str, null);
          a.b(this.a).a(new e(d, e.a.a, jSONObject, 1));
        } 
      }
    };
  
  public a(JSONObject paramJSONObject) {
    this.e = paramJSONObject;
  }
  
  private int a(int paramInt) {
    byte b = 4;
    if (paramInt != 1) {
      if (paramInt != 4) {
        if (paramInt != 8)
          return (paramInt != 16) ? ((paramInt != 32) ? ((paramInt != 64) ? ((paramInt != 128) ? 0 : 10) : 9) : 6) : 5; 
      } else {
        return 3;
      } 
    } else {
      b = 1;
    } 
    return b;
  }
  
  private JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    for (Map.Entry<Integer, String> entry : this.c.entrySet()) {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(entry.getKey());
        stringBuilder.append("");
        jSONObject.put(stringBuilder.toString(), entry.getValue());
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
    } 
    return jSONObject;
  }
  
  private void a(e parame) {
    this.d = parame;
    if (this.a.compareAndSet(false, true))
      l.a().a(this.f); 
  }
  
  private void a(e parame, String paramString) {
    parame.a(new e(new d(null, null, paramString, null), e.a.a, null, 2));
  }
  
  private void a(e parame, String paramString, int paramInt) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("code", paramInt);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    parame.a(new e(new d(null, null, paramString, null), e.a.a, jSONObject));
  }
  
  private void a(e parame, String paramString1, String paramString2) {
    for (Map.Entry<String, String> entry : this.b.entrySet());
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
      String str = this.b.remove(paramString1);
      if (!TextUtils.isEmpty(str))
        a(parame, str); 
      this.b.put(paramString1, paramString2);
    } 
  }
  
  public int a(Context paramContext, JSONObject paramJSONObject) {
    Intent intent1;
    ak.a("gdt_tag_download_apk", "openApp()");
    String str2 = paramJSONObject.optString("url");
    String str1 = paramJSONObject.optString("packageName");
    Intent intent2 = new Intent();
    if (!TextUtils.isEmpty(str2)) {
      Uri uri = Uri.parse(str2);
      if ("http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme()))
        return 11; 
      intent2.setData(uri);
      intent2.setAction("android.intent.action.VIEW");
      if (!StringUtil.isEmpty(str1))
        intent2.setPackage(str1); 
      intent1 = intent2;
      if (paramContext.getPackageManager().resolveActivity(intent2, 65536) == null) {
        intent2 = paramContext.getPackageManager().getLaunchIntentForPackage(str1);
        if (intent2 == null)
          return 12; 
        intent2.addFlags(268435456);
        intent1 = intent2;
        if (paramContext.getPackageManager().resolveActivity(intent2, 65536) == null)
          return 12; 
      } 
    } else {
      intent2 = paramContext.getPackageManager().getLaunchIntentForPackage(str1);
      if (intent2 == null)
        return 12; 
      intent2.addFlags(268435456);
      intent1 = intent2;
      if (paramContext.getPackageManager().resolveActivity(intent2, 65536) == null)
        return 12; 
    } 
    paramContext.startActivity(intent1);
    return 0;
  }
  
  public int a(JSONObject paramJSONObject) {
    String str = paramJSONObject.optString("packageName");
    return TextUtils.isEmpty(str) ? 0 : a(l.a().a(str));
  }
  
  public f<String> a(e parame, View paramView, String paramString1, String paramString2, String paramString3, String paramString4) {
    StringBuilder stringBuilder;
    try {
      if (TextUtils.isEmpty(paramString3)) {
        JSONObject jSONObject = new JSONObject();
      } else {
        JSONObject jSONObject = new JSONObject(paramString3);
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      jSONException = null;
    } 
    if (jSONException == null)
      return new f("13"); 
    Context context = paramView.getContext();
    if ("openApp".equals(paramString2)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(a(context, (JSONObject)jSONException));
      stringBuilder.append("");
      return new f(stringBuilder.toString());
    } 
    if ("isAppInstall".equals(paramString2)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(b(context, (JSONObject)jSONException));
      stringBuilder.append("");
      return new f(stringBuilder.toString());
    } 
    if ("getDownloadStatus".equals(paramString2)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(a((JSONObject)jSONException));
      stringBuilder.append("");
      return new f(stringBuilder.toString());
    } 
    if ("pauseDownload".equals(paramString2)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(b((JSONObject)jSONException));
      stringBuilder.append("");
      return new f(stringBuilder.toString());
    } 
    if ("startDownload".equals(paramString2)) {
      a(context, (e)stringBuilder, (JSONObject)jSONException, paramString4);
      return new f(null);
    } 
    if ("resumeDownload".equals(paramString2)) {
      a((e)stringBuilder, (JSONObject)jSONException, paramString4);
      return new f(null);
    } 
    if ("registerListener".equals(paramString2)) {
      b((e)stringBuilder, (JSONObject)jSONException, paramString4);
      return new f(null);
    } 
    if ("installApp".equals(paramString2)) {
      b(context, (e)stringBuilder, (JSONObject)jSONException, paramString4);
      return new f(null);
    } 
    if ("type".equals(paramString2))
      return new f(a(context)); 
    if ("reportMsgByUrl".equals(paramString2)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(c((JSONObject)jSONException));
      stringBuilder.append("");
      return new f(stringBuilder.toString());
    } 
    GDTLogger.e("Unsupported action");
    return new f(null);
  }
  
  public String a(Context paramContext) {
    if (!ad.a(paramContext))
      return "none"; 
    int i = null.a[GDTADManager.getInstance().getDeviceStatus().getNetworkType().ordinal()];
    return (i != 1) ? ((i != 2) ? ((i != 3) ? ((i != 4) ? "unknown" : "wifi") : "2g") : "3g") : "4g";
  }
  
  public void a(Context paramContext, e parame, JSONObject paramJSONObject, String paramString) {
    byte b;
    ak.a("gdt_tag_download_apk", "startDownload(context, unJsBridge, option, callbackId)");
    String str1 = paramJSONObject.optString("packageName");
    String str2 = paramJSONObject.optString("url");
    boolean bool = true;
    if (paramJSONObject.optInt("autoInstall", 1) != 1)
      bool = false; 
    if (TextUtils.isEmpty(str1)) {
      b = 10;
    } else if (TextUtils.isEmpty(str2)) {
      b = 16;
    } else {
      String str8 = paramJSONObject.optString("launchUrl");
      String str9 = paramJSONObject.optString("appName");
      String str6 = paramJSONObject.optString("appIcon");
      if (TextUtils.isEmpty(str6))
        str6 = "unknown"; 
      String str3 = paramJSONObject.optString("adInfo");
      if (!TextUtils.isEmpty(str3)) {
        try {
          JSONObject jSONObject = new JSONObject(str3);
          String str = jSONObject.optString("clickId");
          try {
            String str10 = jSONObject.optString("productId");
            try {
              String str11 = jSONObject.optString("adId");
            } catch (JSONException null) {}
          } catch (JSONException null) {
            Object object = null;
          } 
        } catch (JSONException jSONException) {
          Object object2 = null;
          Object object1 = object2;
        } 
        jSONException.printStackTrace();
        jSONException = null;
      } 
      str3 = null;
      String str5 = str3;
      String str4 = str5;
      String str7 = str5;
    } 
    a(parame, paramString, b);
  }
  
  public void a(e parame, JSONObject paramJSONObject, String paramString) {
    byte b;
    ak.a("gdt_tag_download_apk", "resumeDownload()");
    String str = paramJSONObject.optString("packageName");
    if (TextUtils.isEmpty(str)) {
      b = 10;
    } else {
      if (l.a().b(str)) {
        a(parame, str, paramString);
        a(parame);
        return;
      } 
      b = 15;
    } 
    a(parame, paramString, b);
  }
  
  public int b(Context paramContext, JSONObject paramJSONObject) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int b(JSONObject paramJSONObject) {
    ak.a("gdt_tag_download_apk", "pauseDownload(option)");
    String str = paramJSONObject.optString("packageName");
    return TextUtils.isEmpty(str) ? 10 : (l.a().a(str, 1) ? 0 : 15);
  }
  
  public void b(Context paramContext, e parame, JSONObject paramJSONObject, String paramString) {
    int i;
    ak.a("gdt_tag_download_apk", "installApp()");
    String str = paramJSONObject.optString("packageName");
    if (TextUtils.isEmpty(str)) {
      i = 10;
    } else {
      i = l.a().a(str);
      if (!d.c(i)) {
        GDTLogger.d(String.format("install call failed(%s,%s)", new Object[] { Integer.valueOf(i), str }));
        i = 17;
      } else {
        File file = aj.h();
        if (file == null || !file.exists()) {
          a(parame, paramString, 18);
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".apk");
        file = new File(file, stringBuilder.toString());
        if (!file.exists()) {
          a(parame, paramString, 18);
          return;
        } 
        if (!(new p(paramContext)).b(file)) {
          i = 19;
        } else {
          a(parame, str, paramString);
          a(parame);
          String str1 = this.c.get(Integer.valueOf(2));
          p.a.a.a(new a(str1), str);
          return;
        } 
      } 
    } 
    a(parame, paramString, i);
  }
  
  public void b(e parame, JSONObject paramJSONObject, String paramString) {
    ak.a("gdt_tag_download_apk", "registerListener()");
    String str = paramJSONObject.optString("packageName");
    if (TextUtils.isEmpty(str)) {
      a(parame, paramString, 10);
      return;
    } 
    a(parame, str, paramString);
    a(parame);
  }
  
  public int c(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return 21; 
    int i = paramJSONObject.optInt("type");
    String str = paramJSONObject.optString("reportUrl");
    this.c.put(Integer.valueOf(i), str);
    return 0;
  }
  
  static class a implements f.a {
    private String a;
    
    public a(String param1String) {
      this.a = param1String;
    }
    
    public void a(int param1Int, String param1String, boolean param1Boolean) {
      if (param1Int == 0 && !param1Boolean)
        ah.a(this.a); 
    }
    
    public boolean a() {
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\f\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */