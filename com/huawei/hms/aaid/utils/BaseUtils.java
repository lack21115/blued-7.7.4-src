package com.huawei.hms.aaid.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.b;
import com.huawei.hms.opendevice.d;
import com.huawei.hms.opendevice.e;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.n;
import java.util.Map;

public class BaseUtils {
  public static void clearSubjectIds(Context paramContext) {
    i.a(paramContext).removeKey("subjectId");
  }
  
  public static void delLocalToken(Context paramContext, String paramString) {
    i.a(paramContext).c(paramString);
  }
  
  public static void deleteAllTokenCache(Context paramContext) {
    i.a(paramContext);
    i.a();
  }
  
  public static void deleteCacheData(Context paramContext, String paramString) {
    i.a(paramContext).removeKey(paramString);
  }
  
  public static String getBaseUrl(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    return e.a(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static String getCacheData(Context paramContext, String paramString, boolean paramBoolean) {
    return paramBoolean ? i.a(paramContext).a(paramString) : i.a(paramContext).getString(paramString);
  }
  
  public static String getLocalToken(Context paramContext, String paramString) {
    return i.a(paramContext).b(paramString);
  }
  
  public static String[] getSubjectIds(Context paramContext) {
    String str = i.a(paramContext).getString("subjectId");
    return TextUtils.isEmpty(str) ? new String[0] : str.split(",");
  }
  
  public static void initSecret(Context paramContext) {
    b.a(paramContext);
  }
  
  public static void reportAaidToken(Context paramContext, String paramString) {
    n.a(paramContext, paramString);
  }
  
  public static boolean saveCacheData(Context paramContext, String paramString1, String paramString2, boolean paramBoolean) {
    return paramBoolean ? i.a(paramContext).a(paramString1, paramString2) : i.a(paramContext).saveString(paramString1, paramString2);
  }
  
  public static void saveToken(Context paramContext, String paramString1, String paramString2) {
    i.a(paramContext).b(paramString1, paramString2);
  }
  
  public static String sendPostRequest(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap) {
    return d.a(paramContext, paramString1, paramString2, paramMap);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\aai\\utils\BaseUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */