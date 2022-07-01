package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import com.bytedance.sdk.openadsdk.utils.ae;

class h {
  private String a;
  
  private Context b;
  
  h(Context paramContext, String paramString) {
    this.b = paramContext;
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = ""; 
    this.a = str;
  }
  
  private Context b() {
    Context context2 = this.b;
    Context context1 = context2;
    if (context2 == null)
      context1 = o.a(); 
    return context1;
  }
  
  private String c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append("_adslot");
    return stringBuilder.toString();
  }
  
  private String d() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append("_adslot_preload");
    return stringBuilder.toString();
  }
  
  private SharedPreferences f(String paramString) {
    try {
      if (b() != null)
        return b().getSharedPreferences(paramString, 0); 
    } finally {}
    return null;
  }
  
  private String g(String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "0"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append("_cache_");
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  AdSlot a() {
    try {
      boolean bool = b.b();
      return ae.a(str);
    } finally {
      Exception exception = null;
    } 
  }
  
  String a(String paramString) {
    try {
      return bool ? a.b(g(paramString), "material_data", null) : f(g(paramString)).getString("material_data", null);
    } finally {
      paramString = null;
    } 
  }
  
  void a(AdSlot paramAdSlot) {
    if (paramAdSlot != null)
      try {
        if (TextUtils.isEmpty(paramAdSlot.getCodeId()))
          return; 
        String str = ae.a(paramAdSlot);
        if (b.b())
          return; 
        return;
      } finally {
        paramAdSlot = null;
      }  
  }
  
  void a(String paramString1, String paramString2) {
    try {
      boolean bool = b.b();
      if (bool) {
        a.a(g(paramString1), "has_played", Boolean.valueOf(false));
        a.a(g(paramString1), "create_time", Long.valueOf(System.currentTimeMillis()));
        return;
      } 
      return;
    } finally {
      paramString1 = null;
    } 
  }
  
  long b(String paramString) {
    try {
      return bool ? a.a(g(paramString), "create_time", 0L) : f(g(paramString)).getLong("create_time", 0L);
    } finally {
      paramString = null;
    } 
  }
  
  void b(AdSlot paramAdSlot) {
    if (paramAdSlot != null)
      try {
        if (TextUtils.isEmpty(paramAdSlot.getCodeId()))
          return; 
        String str = ae.a(paramAdSlot);
        boolean bool = b.b();
        if (bool)
          return; 
        return;
      } finally {
        paramAdSlot = null;
      }  
  }
  
  boolean c(String paramString) {
    try {
      return null ? a.a(g(paramString), "has_played", true) : f(g(paramString)).getBoolean("has_played", true);
    } finally {
      paramString = null;
    } 
  }
  
  void d(String paramString) {
    try {
      if (b.b())
        return; 
      return;
    } finally {
      paramString = null;
    } 
  }
  
  AdSlot e(String paramString) {
    try {
      return ae.a(paramString);
    } finally {
      paramString = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\reward\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */