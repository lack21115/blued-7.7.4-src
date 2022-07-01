package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.HashMap;
import java.util.Map;

public abstract class TTSecAbs {
  public String NM_getAppKey() {
    return "df979cdb-05a7-448c-bece-92d5005a1247";
  }
  
  public Map<String, Object> NM_getCustomInfo() {
    if (h.c().e() != null) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("app_id", h.c().e());
      return (Map)hashMap;
    } 
    return null;
  }
  
  public String NM_getDeviceId() {
    return j.a(o.a());
  }
  
  public String NM_getInstallId() {
    return null;
  }
  
  public abstract String NM_pullSg();
  
  public abstract String NM_pullVer(String paramString);
  
  public abstract void NM_reportNow(String paramString);
  
  public abstract void NM_setParams(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTSecAbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */