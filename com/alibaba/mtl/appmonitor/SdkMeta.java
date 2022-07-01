package com.alibaba.mtl.appmonitor;

import android.content.Context;
import com.alibaba.mtl.log.a;
import java.util.HashMap;
import java.util.Map;

public class SdkMeta {
  public static final String SDK_VERSION = "2.5.1.3_for_bc";
  
  private static final Map<String, String> b = new HashMap<String, String>();
  
  static {
    b.put("sdk-version", "2.5.1.3_for_bc");
  }
  
  public static Map<String, String> getSDKMetaData() {
    a.getContext();
    if (!b.containsKey("sdk-version"))
      b.put("sdk-version", "2.5.1.3_for_bc"); 
    return b;
  }
  
  public static String getString(Context paramContext, String paramString) {
    if (paramContext == null)
      return null; 
    int i = 0;
    try {
      int j = paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
    } finally {
      paramString = null;
    } 
    return (i != 0) ? paramContext.getString(i) : null;
  }
  
  public static void setExtra(Map<String, String> paramMap) {
    if (paramMap != null)
      b.putAll(paramMap); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\SdkMeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */