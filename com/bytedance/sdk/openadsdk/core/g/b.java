package com.bytedance.sdk.openadsdk.core.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.k;
import java.util.HashMap;

public class b {
  public static void a(Context paramContext, k paramk) {
    d.r(paramContext, paramk, "playable_preload", "preload_start", null);
  }
  
  public static void a(Context paramContext, k paramk, int paramInt, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("error_code", Integer.valueOf(paramInt));
    hashMap.put("error_reason", paramString);
    d.r(paramContext, paramk, "playable_preload", "preload_fail", hashMap);
  }
  
  public static void a(Context paramContext, k paramk, long paramLong1, long paramLong2) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("loadzip_success_time", Long.valueOf(paramLong1));
    hashMap.put("unzip_success_time", Long.valueOf(paramLong2));
    d.r(paramContext, paramk, "playable_preload", "preload_success", hashMap);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */