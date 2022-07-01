package com.huawei.hianalytics.ab.bc.ik.ab;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.ab.ab.bc;
import com.huawei.hianalytics.ab.ab.cd;
import com.huawei.hianalytics.ab.bc.bc.cd;
import com.huawei.hianalytics.ab.bc.de.ef;
import com.huawei.hianalytics.ab.bc.ik.bc.bc;
import com.huawei.hianalytics.ab.bc.ik.bc.cd;
import com.huawei.hianalytics.ab.bc.ik.cd.bc;
import com.huawei.hianalytics.ab.bc.kl.ef;
import com.huawei.hianalytics.ab.bc.kl.gh;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ab {
  private static ab bc;
  
  private static Map<String, Long> cd = new HashMap<String, Long>();
  
  private Context ab;
  
  public static ab ab() {
    return bc();
  }
  
  private static void ab(String paramString1, String paramString2, long paramLong1, long paramLong2, JSONObject paramJSONObject, String paramString3, String paramString4) {
    bc bc = new bc(paramString3, ef.ab(paramJSONObject, paramString2, String.valueOf(paramLong2), paramString4), paramString1, "oper", paramLong1);
    bc.bc().ab((com.huawei.hianalytics.ab.bc.ik.cd.ab)bc);
  }
  
  private static ab bc() {
    // Byte code:
    //   0: ldc com/huawei/hianalytics/ab/bc/ik/ab/ab
    //   2: monitorenter
    //   3: getstatic com/huawei/hianalytics/ab/bc/ik/ab/ab.bc : Lcom/huawei/hianalytics/ab/bc/ik/ab/ab;
    //   6: ifnonnull -> 19
    //   9: new com/huawei/hianalytics/ab/bc/ik/ab/ab
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/huawei/hianalytics/ab/bc/ik/ab/ab.bc : Lcom/huawei/hianalytics/ab/bc/ik/ab/ab;
    //   19: getstatic com/huawei/hianalytics/ab/bc/ik/ab/ab.bc : Lcom/huawei/hianalytics/ab/bc/ik/ab/ab;
    //   22: astore_0
    //   23: ldc com/huawei/hianalytics/ab/bc/ik/ab/ab
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/huawei/hianalytics/ab/bc/ik/ab/ab
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  private void bc(Context paramContext) {
    String str1;
    String str2 = com.huawei.hianalytics.ab.bc.bc.ab.de(paramContext);
    bc.ab(str2);
    if (gh.bc().ab()) {
      String str = com.huawei.hianalytics.ab.bc.ij.ab.ab(paramContext, "global_v2", "app_ver", "");
      com.huawei.hianalytics.ab.bc.ij.ab.bc(paramContext, "global_v2", "app_ver", str2);
      bc.bc(str);
      if (TextUtils.isEmpty(str)) {
        str1 = "app ver is first save!";
      } else {
        if (!str.equals(str2)) {
          com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "the appVers are different!");
          ab().ab("", "alltype", str);
          return;
        } 
        return;
      } 
    } else {
      str1 = "userManager.isUserUnlocked() == false";
    } 
    com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", str1);
  }
  
  private static void cd(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject) {
    long l1;
    long l3 = System.currentTimeMillis();
    boolean bool = cd.containsKey(paramString1);
    long l2 = 0L;
    if (bool) {
      l1 = ((Long)cd.get(paramString1)).longValue();
    } else {
      l1 = 0L;
    } 
    if (l1 == 0L) {
      l1 = l2;
    } else {
      l1 = l3 - l1;
    } 
    ab(paramString1, paramString3, l3, l1, paramJSONObject, paramString2, "OnPause");
  }
  
  public void ab(Context paramContext) {
    this.ab = paramContext;
    bc(paramContext);
    com.huawei.hianalytics.ab.bc.cd.ab.ab.cd().bc().de(com.huawei.hianalytics.ab.bc.bc.ab.ab());
  }
  
  public void ab(String paramString, int paramInt) {
    if (this.ab == null) {
      com.huawei.hianalytics.ab.bc.ef.ab.ef("hmsSdk", "onReport() null context or SDK was not init.");
      return;
    } 
    com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onReport: Before calling runtaskhandler()");
    ab(paramString, ef.ab(paramInt), bc.de());
  }
  
  public void ab(String paramString1, int paramInt, String paramString2, JSONObject paramJSONObject) {
    long l2 = System.currentTimeMillis();
    long l1 = l2;
    if (2 == paramInt)
      l1 = ef.ab("yyyy-MM-dd", l2); 
    bc bc = new bc(paramString2, paramJSONObject, paramString1, ef.ab(paramInt), l1);
    bc.bc().ab((com.huawei.hianalytics.ab.bc.ik.cd.ab)bc);
  }
  
  public void ab(String paramString1, int paramInt, String paramString2, JSONObject paramJSONObject, long paramLong) {
    (new ef(paramString1, ef.ab(paramInt), paramString2, paramJSONObject.toString(), paramLong)).ab();
  }
  
  public void ab(String paramString1, String paramString2) {
    if (cd.a(paramString1, paramString2)) {
      long l1 = cd.gh(paramString1, paramString2);
      long l2 = System.currentTimeMillis();
      if (l2 - l1 > 30000L) {
        com.huawei.hianalytics.ab.bc.ef.ab.ab("hmsSdk", "begin to call onReport!");
        cd.ab(paramString1, paramString2, l2);
        ab(paramString1, paramString2, bc.de());
        return;
      } 
      com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "autoReport timeout. interval < 30s ");
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("auto report is closed tag:");
    stringBuilder.append(paramString1);
    com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", stringBuilder.toString());
  }
  
  public void ab(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder;
    Context context = this.ab;
    if (context == null) {
      com.huawei.hianalytics.ab.bc.ef.ab.ef("hmsSdk", "onReport() null context or SDK was not init.");
      return;
    } 
    String str = cd.ab(context);
    if (cd.c(paramString1, paramString2) && !"WIFI".equals(str)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("strNetworkType is :");
      stringBuilder.append(str);
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", stringBuilder.toString());
      return;
    } 
    if (!TextUtils.isEmpty(str) && !"2G".equals(str)) {
      cd cd = new cd((String)stringBuilder, paramString2, paramString3);
      bc.bc().ab((com.huawei.hianalytics.ab.bc.ik.cd.ab)cd);
      return;
    } 
    com.huawei.hianalytics.ab.bc.ef.ab.ef("hmsSdk", "The network is bad.");
  }
  
  public void ab(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject) {
    if (this.ab == null) {
      com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "onPause null context or SDK was not init.");
      return;
    } 
    cd(paramString1, paramString2, paramString3, paramJSONObject);
    cd.put(paramString1, Long.valueOf(0L));
  }
  
  public void ab(String paramString1, String paramString2, JSONObject paramJSONObject) {
    ab(paramString1, "$AppOnPause", paramString2, paramJSONObject);
  }
  
  public void bc(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject) {
    long l = System.currentTimeMillis();
    cd.put(paramString1, Long.valueOf(l));
    ab(paramString1, paramString3, l, 0L, paramJSONObject, paramString2, "OnResume");
  }
  
  public void bc(String paramString1, String paramString2, JSONObject paramJSONObject) {
    bc(paramString1, "$AppOnResume", paramString2, paramJSONObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\ik\ab\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */