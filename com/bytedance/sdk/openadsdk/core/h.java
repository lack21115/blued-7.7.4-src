package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTSecAbs;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.core.g.c;
import com.bytedance.sdk.openadsdk.h.g.a;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import com.bytedance.sdk.openadsdk.utils.a;
import com.bytedance.sdk.openadsdk.utils.f;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class h {
  private static final h s = new h();
  
  private static TTCustomController v = new TTCustomController() {
    
    };
  
  private String a;
  
  private String b;
  
  private boolean c;
  
  private String d;
  
  private String e;
  
  private int f = 0;
  
  private boolean g = true;
  
  private boolean h = false;
  
  private TTGlobalAppDownloadListener i;
  
  private final Set<Integer> j = Collections.synchronizedSet(new HashSet<Integer>());
  
  private boolean k = false;
  
  private Bitmap l = null;
  
  private a m = new a();
  
  private TTDownloadEventLogger n;
  
  private TTSecAbs o;
  
  private String[] p;
  
  private TTCustomController q;
  
  private boolean r = false;
  
  private c t;
  
  private c u;
  
  private h() {
    a.a(o.a());
    this.j.add(Integer.valueOf(4));
    Context context = o.a();
    if (context instanceof Application) {
      ((Application)context).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.m);
    } else if (context != null && context.getApplicationContext() != null) {
      ((Application)context.getApplicationContext()).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.m);
    } 
    if (Build.VERSION.SDK_INT >= 26)
      try {
        return;
      } finally {
        context = null;
      }  
  }
  
  public static h c() {
    return s;
  }
  
  private static void e(String paramString) {
    y.a(paramString, "appid不能为空");
  }
  
  private static void f(String paramString) {
    y.a(paramString, "name不能为空");
  }
  
  private static void g(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      boolean bool;
      if (paramString.length() <= 1000) {
        bool = true;
      } else {
        bool = false;
      } 
      y.a(bool, "keyword超长, 最长为1000");
    } 
  }
  
  private static void h(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      boolean bool;
      if (paramString.length() <= 1000) {
        bool = true;
      } else {
        bool = false;
      } 
      y.a(bool, "data超长, 最长为1000");
    } 
  }
  
  private void t() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    String str2 = c().e();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = String.valueOf(164362); 
    hashMap.put("host_appid", str1);
    hashMap.put("sdk_version", "2.9.5.6");
    AppLog.setHeaderInfo(hashMap);
  }
  
  public void a(int paramInt) {
    if (b.b())
      a.a("sp_global_info", "title_bar_theme", Integer.valueOf(paramInt)); 
    this.f = paramInt;
  }
  
  public void a(Bitmap paramBitmap) {
    if (b.b()) {
      String str = f.a(paramBitmap);
      if (!TextUtils.isEmpty(str))
        a.a("sp_global_info", "pause_icon", str); 
    } 
    this.l = paramBitmap;
  }
  
  public void a(TTCustomController paramTTCustomController) {
    this.q = paramTTCustomController;
  }
  
  public void a(TTDownloadEventLogger paramTTDownloadEventLogger) {
    this.n = paramTTDownloadEventLogger;
  }
  
  public void a(TTGlobalAppDownloadListener paramTTGlobalAppDownloadListener) {
    this.i = paramTTGlobalAppDownloadListener;
  }
  
  public void a(TTSecAbs paramTTSecAbs) {
    this.o = paramTTSecAbs;
  }
  
  public void a(String paramString) {
    e(paramString);
    if (b.b())
      a.a("sp_global_info", "app_id", paramString); 
    this.a = paramString;
    t();
  }
  
  public void a(boolean paramBoolean) {
    if (b.b())
      a.a("sp_global_info", "is_paid", Boolean.valueOf(paramBoolean)); 
    this.c = paramBoolean;
  }
  
  public void a(int... paramVarArgs) {
    if (paramVarArgs == null)
      return; 
    try {
      this.j.clear();
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++) {
        int k = paramVarArgs[i];
        this.j.add(Integer.valueOf(k));
      } 
    } finally {
      paramVarArgs = null;
    } 
  }
  
  public void a(String[] paramArrayOfString) {
    if (b.b() && paramArrayOfString != null && paramArrayOfString.length > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      int k = paramArrayOfString.length;
      int i = 0;
      for (int j = 0; i < k; j = m) {
        String str1 = paramArrayOfString[i];
        int m = j;
        if (!TextUtils.isEmpty(str1)) {
          if (j)
            stringBuilder.append(","); 
          stringBuilder.append(str1);
          m = j + 1;
        } 
        i++;
      } 
      String str = stringBuilder.toString();
      if (!TextUtils.isEmpty(str))
        a.a("sp_global_info", "need_clear_task_reset", str); 
    } 
    this.p = paramArrayOfString;
  }
  
  public boolean a() {
    return this.m.a();
  }
  
  public boolean a(Activity paramActivity) {
    return this.m.a(paramActivity);
  }
  
  public void b(String paramString) {
    f(paramString);
    if (b.b())
      a.a("sp_global_info", "name", paramString); 
    this.b = paramString;
  }
  
  public void b(boolean paramBoolean) {
    if (b.b())
      a.a("sp_global_info", "allow_show_notify", Boolean.valueOf(paramBoolean)); 
    this.g = paramBoolean;
  }
  
  public boolean b() {
    return this.r;
  }
  
  public boolean b(int paramInt) {
    if (b.b()) {
      String str = a.b("sp_global_info", "network_state", null);
      if (!TextUtils.isEmpty(str)) {
        String[] arrayOfString = str.split(",");
        if (arrayOfString.length > 0) {
          int j = arrayOfString.length;
          for (int i = 0; i < j; i++) {
            String str1 = arrayOfString[i];
            if (!TextUtils.isEmpty(str1) && String.valueOf(paramInt).equals(str1))
              return true; 
          } 
        } 
      } 
      return false;
    } 
    return this.j.contains(Integer.valueOf(paramInt));
  }
  
  public void c(String paramString) {
    g(paramString);
    if (b.b())
      a.a("sp_global_info", "keywords", paramString); 
    this.d = paramString;
  }
  
  public void c(boolean paramBoolean) {
    if (b.b())
      a.a("sp_global_info", "allow_lp_when_screen_lock", Boolean.valueOf(paramBoolean)); 
    this.h = paramBoolean;
  }
  
  public TTCustomController d() {
    if (l.b != null)
      return l.b; 
    TTCustomController tTCustomController2 = this.q;
    TTCustomController tTCustomController1 = tTCustomController2;
    if (tTCustomController2 == null)
      tTCustomController1 = v; 
    return tTCustomController1;
  }
  
  public void d(String paramString) {
    h(paramString);
    if (b.b())
      a.a("sp_global_info", "extra_data", paramString); 
    this.e = paramString;
  }
  
  public void d(boolean paramBoolean) {
    if (b.b())
      a.a("sp_global_info", "is_use_texture", Boolean.valueOf(paramBoolean)); 
    this.k = paramBoolean;
  }
  
  public String e() {
    return b.b() ? a.b("sp_global_info", "app_id", null) : this.a;
  }
  
  public String f() {
    return b.b() ? a.b("sp_global_info", "name", null) : this.b;
  }
  
  public boolean g() {
    return b.b() ? a.a("sp_global_info", "is_paid", false) : this.c;
  }
  
  public String h() {
    return b.b() ? a.b("sp_global_info", "keywords", null) : this.d;
  }
  
  public String i() {
    return b.b() ? a.b("sp_global_info", "extra_data", null) : this.e;
  }
  
  public int j() {
    return b.b() ? a.a("sp_global_info", "title_bar_theme", 0) : this.f;
  }
  
  public boolean k() {
    return b.b() ? a.a("sp_global_info", "allow_show_notify", true) : this.g;
  }
  
  public boolean l() {
    return b.b() ? a.a("sp_global_info", "allow_lp_when_screen_lock", false) : this.h;
  }
  
  public TTDownloadEventLogger m() {
    return this.n;
  }
  
  public TTSecAbs n() {
    return this.o;
  }
  
  public void o() {
    e(this.a);
    f(this.b);
  }
  
  public c p() {
    if (this.t == null)
      this.t = new c(10, 8); 
    return this.t;
  }
  
  public c q() {
    if (this.u == null)
      this.u = new c(10, 8); 
    return this.u;
  }
  
  public boolean r() {
    return b.b() ? a.a("sp_global_info", "is_use_texture", false) : this.k;
  }
  
  public Bitmap s() {
    return b.b() ? f.a(a.b("sp_global_info", "pause_icon", null)) : this.l;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */