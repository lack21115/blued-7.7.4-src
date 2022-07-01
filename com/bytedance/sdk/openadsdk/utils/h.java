package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.d;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class h {
  private static final Map<String, a> a = Collections.synchronizedMap(new HashMap<String, a>());
  
  private static IListenerManager b;
  
  public static void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    if (b.b()) {
      com.bytedance.sdk.openadsdk.i.a.a().a(new Runnable(paramString) {
            public void run() {
              try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("handleYes-1，key=");
                stringBuilder.append(this.a);
                t.b("MultiProcess", stringBuilder.toString());
                return;
              } finally {
                Exception exception = null;
              } 
            }
          }5);
      return;
    } 
    a a = b(paramString);
    if (a == null)
      return; 
    a.a();
  }
  
  private static void a(String paramString, a parama) {
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
                  exception.printStackTrace();
                  t.e("MultiProcess", exception.toString());
                } 
              }
            }5);
        return;
      } 
      a.put(paramString, parama);
    } 
  }
  
  public static void a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1))
      return; 
    if (b.b()) {
      com.bytedance.sdk.openadsdk.i.a.a().a(new Runnable(paramString1, paramString2) {
            public void run() {
              try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("handleNo-1，key=");
                stringBuilder.append(this.a);
                stringBuilder.append("，permission=");
                stringBuilder.append(this.b);
                t.b("MultiProcess", stringBuilder.toString());
                return;
              } finally {
                Exception exception = null;
              } 
            }
          }5);
      return;
    } 
    a a = b(paramString1);
    if (a == null)
      return; 
    a.a(paramString2);
  }
  
  public static void a(String paramString, String[] paramArrayOfString, a parama) {
    if (!TextUtils.isEmpty(paramString) && paramArrayOfString != null) {
      if (paramArrayOfString.length <= 0)
        return; 
      a(paramString, parama);
      TTDelegateActivity.a(paramString, paramArrayOfString);
    } 
  }
  
  private static IListenerManager b() {
    if (b == null)
      b = d.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(o.a()).a(4)); 
    return b;
  }
  
  private static a b(String paramString) {
    return TextUtils.isEmpty(paramString) ? null : a.remove(paramString);
  }
  
  public static interface a {
    void a();
    
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */