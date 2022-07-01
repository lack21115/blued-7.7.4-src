package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.h.b;
import com.bytedance.sdk.openadsdk.core.h.i;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.i.a;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;

public class p {
  private static String a(List<String> paramList) {
    if (paramList == null || paramList.isEmpty())
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < paramList.size(); i++) {
      stringBuilder.append(paramList.get(i));
      if (i != paramList.size() - 1)
        stringBuilder.append(","); 
    } 
    return stringBuilder.toString().trim();
  }
  
  private static List<String> a(String paramString) {
    return TextUtils.isEmpty(paramString) ? null : Arrays.asList(paramString.split(","));
  }
  
  public static JSONArray a(Context paramContext) {
    if (o.h().P()) {
      if (!h.c().d().alist())
        return null; 
      if (!i.d())
        return null; 
      if (!e(paramContext))
        return null; 
      a.a().c(new Runnable(paramContext) {
            public void run() {
              p.b(this.a);
            }
          },  1);
      return c(paramContext);
    } 
    return null;
  }
  
  private static void a(Context paramContext, String paramString) {
    d.a(paramContext).a("install_app_string", paramString);
  }
  
  private static void b(Context paramContext, String paramString) {
    d d = d.a(paramContext);
    d.a("install_app_incremental_string", paramString);
    d.a("apptime", System.currentTimeMillis());
  }
  
  private static JSONArray c(Context paramContext) {
    try {
      String str = d.a(paramContext).b("install_app_incremental_string", null);
      if (!TextUtils.isEmpty(str))
        return new JSONArray(a(str)); 
    } finally {
      paramContext = null;
    } 
  }
  
  private static void d(Context paramContext) {
    try {
      List<String> list = b.a().a(paramContext);
      if (list != null) {
        if (list.isEmpty())
          return; 
        List<String> list1 = a(d.a(paramContext).b("install_app_string", null));
        a(paramContext, a(list));
        if (list1 != null && !list1.isEmpty())
          list.removeAll(list1); 
        b(paramContext, a(list));
        return;
      } 
      return;
    } catch (Exception exception) {
      t.a("InstallAppUtils", "loadIncrementInstallApps error: ", exception);
      return;
    } 
  }
  
  private static boolean e(Context paramContext) {
    long l = d.a(paramContext).b("apptime", -1L).longValue();
    return (l == -1L || System.currentTimeMillis() - l > 43200000L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */