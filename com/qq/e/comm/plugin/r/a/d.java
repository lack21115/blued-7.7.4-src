package com.qq.e.comm.plugin.r.a;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.e.a;
import com.qq.e.comm.plugin.r.b.a;
import com.qq.e.comm.plugin.r.b.b;
import com.qq.e.comm.plugin.r.b.c;
import com.qq.e.comm.plugin.t.b;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import com.qq.e.comm.plugin.util.t;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
  private static volatile d b;
  
  private Context a;
  
  private volatile b c;
  
  private long d;
  
  private boolean e;
  
  private d(Context paramContext) {
    this.a = paramContext.getApplicationContext();
    c(c.a(paramContext));
    if (c())
      a(false, true); 
  }
  
  public static d a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/r/a/d.b : Lcom/qq/e/comm/plugin/r/a/d;
    //   3: ifnonnull -> 38
    //   6: ldc com/qq/e/comm/plugin/r/a/d
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/plugin/r/a/d.b : Lcom/qq/e/comm/plugin/r/a/d;
    //   12: ifnonnull -> 26
    //   15: new com/qq/e/comm/plugin/r/a/d
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/qq/e/comm/plugin/r/a/d.b : Lcom/qq/e/comm/plugin/r/a/d;
    //   26: ldc com/qq/e/comm/plugin/r/a/d
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/qq/e/comm/plugin/r/a/d
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/qq/e/comm/plugin/r/a/d.b : Lcom/qq/e/comm/plugin/r/a/d;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private String a(boolean paramBoolean) {
    if (a.b != null) {
      String str2 = a.b.a();
      String str1 = str2;
      return TextUtils.isEmpty(str2) ? (paramBoolean ? "https://mi.ssp.qq.com/config?version=2" : "https://mi.ssp.qq.com/config") : str1;
    } 
    return paramBoolean ? "https://mi.ssp.qq.com/config?version=2" : "https://mi.ssp.qq.com/config";
  }
  
  private String b(boolean paramBoolean1, boolean paramBoolean2) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void c(String paramString) {
    this.c = new b(paramString);
  }
  
  private boolean c() {
    SM sM = GDTADManager.getInstance().getSM();
    boolean bool = false;
    if (sM.getInteger("enableMediation", 0) == 1)
      bool = true; 
    return bool;
  }
  
  private void d(String paramString) {
    t.a.execute(new Runnable(this, paramString) {
          public void run() {
            c.a(d.a(this.b), this.a);
            d.b(this.b);
          }
        });
  }
  
  private boolean d() {
    return (SDKStatus.getSDKVersionCode() < 110) ? false : GlobalSetting.isEnableMediationTool();
  }
  
  private void e() {
    if (d() && this.c != null) {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("updateTime", System.currentTimeMillis());
        jSONObject.put("enableMediation", c());
        List list = this.c.e();
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0)
          for (a a : list) {
            JSONObject jSONObject1 = new JSONObject();
            jSONObject1.put("phyPosId", a.a());
            List list1 = a.f();
            JSONArray jSONArray1 = new JSONArray();
            if (list1 != null && list1.size() > 0)
              for (c c : list1) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("name", c.a());
                jSONObject2.put("posId", c.b());
                jSONObject2.put("ext", c.g());
                jSONObject2.put("className", c.e());
                jSONArray1.put(jSONObject2);
              }  
            jSONObject1.put("network", jSONArray1);
            jSONArray.put(jSONObject1);
          }  
        jSONObject.put("layerConfigs", jSONArray);
        c.b(this.a, jSONObject.toString());
        return;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
    } 
  }
  
  public a a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      List list = this.c.e();
      if (list != null && list.size() > 0)
        for (a a : list) {
          if (TextUtils.equals(paramString, a.a()))
            return a; 
        }  
    } 
    return null;
  }
  
  public String a() {
    if (this.c != null) {
      String str2 = this.c.c();
      String str1 = str2;
      return (str2 == null) ? "" : str1;
    } 
    return "";
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Z
    //   6: ifeq -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: invokestatic elapsedRealtime : ()J
    //   15: aload_0
    //   16: getfield d : J
    //   19: lsub
    //   20: aload_0
    //   21: getfield c : Lcom/qq/e/comm/plugin/r/b/b;
    //   24: invokevirtual b : ()I
    //   27: i2l
    //   28: ldc2_w 1000
    //   31: lmul
    //   32: lcmp
    //   33: ifgt -> 43
    //   36: iload_1
    //   37: ifne -> 43
    //   40: goto -> 9
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield e : Z
    //   48: aload_0
    //   49: monitorexit
    //   50: new com/qq/e/comm/plugin/r/a/d$1
    //   53: dup
    //   54: aload_0
    //   55: invokespecial <init> : (Lcom/qq/e/comm/plugin/r/a/d;)V
    //   58: astore #4
    //   60: iload_2
    //   61: ifne -> 95
    //   64: new com/qq/e/comm/plugin/t/b/c
    //   67: dup
    //   68: aload_0
    //   69: iconst_0
    //   70: invokespecial a : (Z)Ljava/lang/String;
    //   73: getstatic com/qq/e/comm/plugin/t/b/e$a.b : Lcom/qq/e/comm/plugin/t/b/e$a;
    //   76: aload_0
    //   77: iload_1
    //   78: iconst_0
    //   79: invokespecial b : (ZZ)Ljava/lang/String;
    //   82: getstatic com/qq/e/comm/plugin/f/a.a : Ljava/nio/charset/Charset;
    //   85: invokevirtual getBytes : (Ljava/nio/charset/Charset;)[B
    //   88: invokespecial <init> : (Ljava/lang/String;Lcom/qq/e/comm/plugin/t/b/e$a;[B)V
    //   91: astore_3
    //   92: goto -> 120
    //   95: new com/qq/e/comm/plugin/t/b/g
    //   98: dup
    //   99: aload_0
    //   100: iconst_1
    //   101: invokespecial a : (Z)Ljava/lang/String;
    //   104: aload_0
    //   105: iload_1
    //   106: iconst_1
    //   107: invokespecial b : (ZZ)Ljava/lang/String;
    //   110: getstatic com/qq/e/comm/plugin/f/a.a : Ljava/nio/charset/Charset;
    //   113: invokevirtual getBytes : (Ljava/nio/charset/Charset;)[B
    //   116: invokespecial <init> : (Ljava/lang/String;[B)V
    //   119: astore_3
    //   120: ldc_w 'gdt_tag_net'
    //   123: aload_3
    //   124: invokestatic a : (Lcom/qq/e/comm/plugin/t/b/e;)Ljava/lang/String;
    //   127: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   130: invokestatic a : ()Lcom/qq/e/comm/plugin/t/c;
    //   133: aload_3
    //   134: getstatic com/qq/e/comm/plugin/t/c$a.a : Lcom/qq/e/comm/plugin/t/c$a;
    //   137: aload #4
    //   139: invokeinterface a : (Lcom/qq/e/comm/plugin/t/b/e;Lcom/qq/e/comm/plugin/t/c$a;Lcom/qq/e/comm/plugin/t/b;)V
    //   144: return
    //   145: astore_3
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_3
    //   149: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	145	finally
    //   9	11	145	finally
    //   12	36	145	finally
    //   43	50	145	finally
    //   146	148	145	finally
  }
  
  public String b() {
    if (this.c != null) {
      String str2 = this.c.d();
      String str1 = str2;
      return (str2 == null) ? "" : str1;
    } 
    return "";
  }
  
  public boolean b(String paramString) {
    return (SDKStatus.getSDKVersionCode() >= 40 && c() && this.c != null && a(paramString) != null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\r\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */