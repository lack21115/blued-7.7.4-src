package com.huawei.hianalytics.ab.fg;

import android.content.Context;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.bc.ik.ab.ab;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class bc {
  private static bc cd;
  
  private Context ab;
  
  private final Object bc = new Object();
  
  public static bc ab() {
    if (cd == null)
      bc(); 
    return cd;
  }
  
  private JSONObject ab(Map<String, String> paramMap) {
    JSONObject jSONObject = new JSONObject();
    if (paramMap != null)
      try {
        for (Map.Entry<String, String> entry : paramMap.entrySet())
          jSONObject.put((String)entry.getKey(), entry.getValue()); 
      } catch (JSONException jSONException) {
        ab.bc("hmsSdk", "Exception occured when transferring bundle to json");
      }  
    return jSONObject;
  }
  
  private static void bc() {
    // Byte code:
    //   0: ldc com/huawei/hianalytics/ab/fg/bc
    //   2: monitorenter
    //   3: getstatic com/huawei/hianalytics/ab/fg/bc.cd : Lcom/huawei/hianalytics/ab/fg/bc;
    //   6: ifnonnull -> 19
    //   9: new com/huawei/hianalytics/ab/fg/bc
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/huawei/hianalytics/ab/fg/bc.cd : Lcom/huawei/hianalytics/ab/fg/bc;
    //   19: ldc com/huawei/hianalytics/ab/fg/bc
    //   21: monitorexit
    //   22: return
    //   23: astore_0
    //   24: ldc com/huawei/hianalytics/ab/fg/bc
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	23	finally
  }
  
  public void ab(Context paramContext) {
    synchronized (this.bc) {
      if (this.ab != null)
        return; 
      this.ab = paramContext;
      ab.ab().ab(paramContext);
      return;
    } 
  }
  
  public void ab(String paramString, int paramInt) {
    ab.ab().ab(paramString, paramInt);
  }
  
  public void ab(String paramString1, int paramInt, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap) {
    JSONObject jSONObject = ab(paramLinkedHashMap);
    ab.ab().ab(paramString1, paramInt, paramString2, jSONObject);
  }
  
  public void ab(String paramString, Context paramContext) {
    String str = paramContext.getClass().getCanonicalName();
    ab.ab().ab(paramString, str, new JSONObject());
  }
  
  public void ab(String paramString1, Context paramContext, String paramString2, String paramString3) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("_constants", paramString3);
      ab.ab().ab(paramString1, 0, paramString2, jSONObject);
      return;
    } catch (JSONException jSONException) {
      ab.fg("hmsSdk", "onEvent():JSON structure Exception!");
      return;
    } 
  }
  
  public void ab(String paramString, Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap) {
    JSONObject jSONObject = ab(paramLinkedHashMap);
    String str = paramContext.getClass().getCanonicalName();
    ab.ab().ab(paramString, str, jSONObject);
  }
  
  public void ab(String paramString1, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap) {
    JSONObject jSONObject = ab(paramLinkedHashMap);
    ab.ab().ab(paramString1, paramString2, jSONObject);
  }
  
  public void bc(String paramString1, int paramInt, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap) {
    JSONObject jSONObject = ab(paramLinkedHashMap);
    ab.ab().ab(paramString1, paramInt, paramString2, jSONObject, System.currentTimeMillis());
  }
  
  public void bc(String paramString, Context paramContext) {
    String str = paramContext.getClass().getCanonicalName();
    ab.ab().bc(paramString, str, new JSONObject());
  }
  
  public void bc(String paramString, Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap) {
    String str = paramContext.getClass().getCanonicalName();
    JSONObject jSONObject = ab(paramLinkedHashMap);
    ab.ab().bc(paramString, str, jSONObject);
  }
  
  public void bc(String paramString1, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap) {
    JSONObject jSONObject = ab(paramLinkedHashMap);
    ab.ab().bc(paramString1, paramString2, jSONObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\fg\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */