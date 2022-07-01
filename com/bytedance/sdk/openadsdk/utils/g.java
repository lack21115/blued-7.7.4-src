package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.c;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class g {
  private static final Map<String, a> a = Collections.synchronizedMap(new HashMap<String, a>());
  
  private static IListenerManager b;
  
  public static void a(String paramString) {
    a(paramString, 1);
  }
  
  private static void a(String paramString, int paramInt) {
    if (TextUtils.isEmpty(paramString))
      return; 
    if (b.b()) {
      com.bytedance.sdk.openadsdk.i.a.a().a(new Runnable(paramString, paramInt) {
            public void run() {
              try {
                return;
              } finally {
                Exception exception = null;
              } 
            }
          }5);
      return;
    } 
    a a = d(paramString);
    if (a == null)
      return; 
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          a.c();
          return;
        } 
        a.c();
        return;
      } 
      a.b();
      return;
    } 
    a.a();
  }
  
  public static void a(String paramString, a parama) {
    if (!TextUtils.isEmpty(paramString)) {
      if (parama == null)
        return; 
      if (b.b()) {
        com.bytedance.sdk.openadsdk.i.a.a().a(new Runnable(paramString, parama) {
              public void run() {
                try {
                  return;
                } finally {
                  Exception exception = null;
                } 
              }
            }5);
        return;
      } 
      a.put(paramString, parama);
    } 
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, a parama) {
    if (!TextUtils.isEmpty(paramString1)) {
      if (parama == null)
        return; 
      a(paramString1, parama);
      TTDelegateActivity.a(paramString1, paramString2, paramString3);
    } 
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, a parama) {
    if (!TextUtils.isEmpty(paramString1)) {
      if (parama == null)
        return; 
      a(paramString1, parama);
      TTDelegateActivity.a(paramString1, paramString2, paramString3, paramString4, paramString5);
    } 
  }
  
  private static IListenerManager b() {
    if (b == null)
      b = c.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(o.a()).a(2)); 
    return b;
  }
  
  public static void b(String paramString) {
    a(paramString, 2);
  }
  
  public static void c(String paramString) {
    a(paramString, 3);
  }
  
  public static a d(String paramString) {
    return TextUtils.isEmpty(paramString) ? null : a.remove(paramString);
  }
  
  public static interface a {
    void a();
    
    void b();
    
    void c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */