package com.ss.android.downloadlib.e;

import android.text.TextUtils;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class e {
  private static Map<String, a> a = Collections.synchronizedMap(new HashMap<String, a>());
  
  public static void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    a a = c(paramString);
    if (a == null)
      return; 
    a.a();
  }
  
  private static void a(String paramString, a parama) {
    if (!TextUtils.isEmpty(paramString)) {
      if (parama == null)
        return; 
      a.put(paramString, parama);
    } 
  }
  
  public static void a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1))
      return; 
    a a = c(paramString1);
    if (a == null)
      return; 
    a.a(paramString2);
  }
  
  public static void a(String[] paramArrayOfString, a parama) {
    if (paramArrayOfString != null) {
      if (paramArrayOfString.length <= 0)
        return; 
      String str = String.valueOf(System.currentTimeMillis());
      a(str, parama);
      TTDelegateActivity.a(str, paramArrayOfString);
    } 
  }
  
  public static boolean b(String paramString) {
    return j.f().a(j.a(), paramString);
  }
  
  private static a c(String paramString) {
    return TextUtils.isEmpty(paramString) ? null : a.remove(paramString);
  }
  
  public static interface a {
    void a();
    
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */