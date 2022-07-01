package com.qq.e.comm.plugin.z;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ab.j;
import com.qq.e.comm.plugin.t.b;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import com.qq.e.comm.plugin.t.d;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.plugin.util.t;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
  private static volatile c a;
  
  private b b = new b(aj.c(new File(aj.k(), "template")));
  
  private a c = new a(aj.c(new File(aj.k(), "map")));
  
  private String d = "https://qzs.qq.com/union/res/union_temp_v2/page/ANTempMob/tempMob.c57c184b4f1591947314638.html";
  
  private String e = "https://qzs.qq.com/union/res/union_temp_v2/page/ANTempMob/videoPlay.0246d5ae241596700948124.html";
  
  public static c a() {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/z/c.a : Lcom/qq/e/comm/plugin/z/c;
    //   3: ifnonnull -> 37
    //   6: ldc com/qq/e/comm/plugin/z/c
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/plugin/z/c.a : Lcom/qq/e/comm/plugin/z/c;
    //   12: ifnonnull -> 25
    //   15: new com/qq/e/comm/plugin/z/c
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/qq/e/comm/plugin/z/c.a : Lcom/qq/e/comm/plugin/z/c;
    //   25: ldc com/qq/e/comm/plugin/z/c
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/qq/e/comm/plugin/z/c
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/qq/e/comm/plugin/z/c.a : Lcom/qq/e/comm/plugin/z/c;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(String paramString, bb.a parama) {
    b(paramString);
    j.e().a(paramString, parama, null);
  }
  
  private void a(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("save template: dir = ");
    stringBuilder.append(paramString1);
    stringBuilder.append(", content = ");
    stringBuilder.append(paramString2);
    ak.a("TemplateManager", stringBuilder.toString());
    t.a.execute(new Runnable(this, paramString1, paramString2) {
          public void run() {
            File file = new File(aj.k(), this.a);
            if (file.exists())
              file.delete(); 
            aj.a(file, this.b);
          }
        });
  }
  
  private void b(String paramString) {
    File file = j.e().a(paramString);
    if (file != null && file.delete()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("本地缓存的旧文件已删除：");
      stringBuilder.append(paramString);
      ak.a("TemplateManager", stringBuilder.toString());
    } 
  }
  
  public static boolean b(JSONObject paramJSONObject) {
    boolean bool = true;
    if (paramJSONObject != null) {
      if (paramJSONObject.optInt("orientation", 1) == 2)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  private String c(JSONObject paramJSONObject) {
    String str = null;
    if (paramJSONObject != null) {
      str = paramJSONObject.optString("html");
      String str1 = paramJSONObject.optString("js");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("html=");
      stringBuilder.append(str);
      stringBuilder.append(" , js=");
      stringBuilder.append(str1);
      ak.a(stringBuilder.toString(), null);
      if (!TextUtils.isEmpty(str))
        c(str); 
      if (!TextUtils.isEmpty(str1))
        d(str1); 
    } 
    return str;
  }
  
  private void c(String paramString) {
    a(paramString, bb.a.a);
  }
  
  private void d(String paramString) {
    a(paramString, bb.a.c);
  }
  
  private String e(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      b.a a1 = this.b.a(paramString);
      if (a1 != null)
        return a1.a(); 
    } 
    return null;
  }
  
  private void e() {
    ak.a("TemplateManager", "downloadByDefaultUrl");
    String str1 = GDTADManager.getInstance().getSM().getString("root_html_url");
    if (!TextUtils.isEmpty(str1))
      this.d = str1; 
    c(this.d);
    String str2 = GDTADManager.getInstance().getSM().getString("root_js_url");
    str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = "https://qzs.qq.com/union/res/union_temp_v2/page/ANTempMob/tempMob.dca5a5e918.js"; 
    d(str1);
    str1 = GDTADManager.getInstance().getSM().getString("video_root_html_url");
    if (!TextUtils.isEmpty(str1))
      this.e = str1; 
    c(this.e);
    str2 = GDTADManager.getInstance().getSM().getString("video_root_js_url");
    str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = "https://qzs.qq.com/union/res/union_temp_v2/page/ANTempMob/videoPlay.2af75b9ebf.js"; 
    d(str1);
  }
  
  private int f() {
    return GDTADManager.getInstance().getSM().getInteger("tpl_id_count", 10);
  }
  
  private List<String> f(String paramString) {
    return this.c.a(paramString);
  }
  
  public JSONArray a(String paramString) {
    List<String> list = f(paramString);
    int j = Math.min(list.size(), f());
    ArrayList<JSONObject> arrayList = new ArrayList(j);
    for (int i = list.size() - 1; i >= 0 && arrayList.size() < j; i--) {
      String str = list.get(i);
      b.a a1 = this.b.a(str);
      if (a1 != null)
        arrayList.add(a1.b()); 
    } 
    return new JSONArray(arrayList);
  }
  
  public JSONObject a(JSONObject paramJSONObject) {
    if (paramJSONObject != null && TextUtils.isEmpty(paramJSONObject.optString("data"))) {
      String str = e(paramJSONObject.optString("id"));
      if (!TextUtils.isEmpty(str))
        try {
          JSONObject jSONObject = new JSONObject(paramJSONObject, new String[] { "id", "ver", "root_id", "url", "orientation" });
          jSONObject.putOpt("data", str);
          return jSONObject;
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        }  
    } 
    return paramJSONObject;
  }
  
  public void a(String paramString, List<JSONObject> paramList, com.qq.e.comm.plugin.y.c paramc) {
    Iterator<JSONObject> iterator = paramList.iterator();
    boolean bool2 = false;
    boolean bool1 = false;
    while (iterator.hasNext()) {
      JSONObject jSONObject = iterator.next();
      if (jSONObject != null) {
        boolean bool3 = this.c.a(paramString, jSONObject.optString("id"));
        boolean bool = bool2;
        if (!bool2) {
          bool = bool2;
          if (bool3)
            bool = true; 
        } 
        bool3 = this.b.a(jSONObject, paramc);
        bool2 = bool;
        if (!bool1) {
          bool2 = bool;
          if (bool3) {
            bool1 = true;
            bool2 = bool;
          } 
        } 
      } 
    } 
    if (bool2)
      a("map", this.c.toString()); 
    if (bool1)
      a("template", this.b.toString()); 
  }
  
  public void b() {
    String str2 = GDTADManager.getInstance().getSM().getString("root_json_url");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      ak.a("TemplateManager", "init jsonUrl from control server isEmpty!!!");
      str1 = "https://qzs.qq.com/union/res/union_temp_v2/page/ANTempMob/tempMob.package.json";
    } 
    com.qq.e.comm.plugin.t.b.c c1 = new com.qq.e.comm.plugin.t.b.c(str1, e.a.b, null);
    d.a().a((e)c1, com.qq.e.comm.plugin.t.c.a.a, new b(this) {
          public void a(e param1e, f param1f) {
            StringBuilder stringBuilder;
            int i = param1f.e();
            if (i == 200) {
              try {
                String str = param1f.d();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("onResponse: ");
                stringBuilder2.append(str);
                ak.a("TemplateManager", stringBuilder2.toString());
                JSONObject jSONObject1 = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject1.optJSONObject("tempMob");
                c.a(this.a, c.a(this.a, jSONObject2));
                jSONObject1 = jSONObject1.optJSONObject("videoPlay");
                c.b(this.a, c.a(this.a, jSONObject1));
                return;
              } catch (IOException iOException) {
              
              } catch (JSONException jSONException) {}
              jSONException.printStackTrace();
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("parse data error: ");
              stringBuilder1.append(jSONException.getMessage());
              stringBuilder = stringBuilder1;
            } else {
              stringBuilder = new StringBuilder();
              stringBuilder.append("request json fail statusCode = ");
              stringBuilder.append(i);
            } 
            ak.b("TemplateManager", stringBuilder.toString());
            c.a(this.a);
          }
          
          public void a(Exception param1Exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("request json fail， errormsg = ");
            stringBuilder.append(param1Exception.getMessage());
            ak.b("TemplateManager", stringBuilder.toString());
            c.a(this.a);
          }
        });
  }
  
  public String c() {
    return this.d;
  }
  
  public String d() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\z\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */