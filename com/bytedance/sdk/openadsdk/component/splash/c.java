package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.a;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.n;
import com.bytedance.sdk.openadsdk.core.d.r;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.a;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.g.a.b;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class c {
  public static File a(Context paramContext, String paramString1, String paramString2) {
    return k.a(paramContext, b.b(), paramString1, paramString2);
  }
  
  public static void a(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, k paramk, long paramLong2, n paramn) {
    String str;
    paramLong1 = SystemClock.elapsedRealtime() - paramLong1;
    if (paramBoolean1) {
      if (paramBoolean2) {
        str = "load_video_success";
      } else {
        str = "load_video_error";
      } 
    } else if (paramBoolean2) {
      str = "download_video_image_success";
    } else {
      str = "download_video_image_fail";
    } 
    if (!paramBoolean2 && paramn != null && paramn.c != null) {
      String str1 = paramn.c.getMessage();
    } else {
      paramn = null;
    } 
    if (paramBoolean1) {
      map = ah.a(paramBoolean2, paramk, paramLong1, paramLong2, (String)paramn);
      map.put("splash_show_type", Integer.valueOf(1));
      d.m(o.a(), paramk, "splash_ad", str, map);
      return;
    } 
    Map<String, Integer> map = ah.b(paramBoolean2, paramk, paramLong1, paramLong2, (String)map);
    map.put("splash_show_type", Integer.valueOf(2));
    d.l(o.a(), paramk, "splash_ad", str, map);
  }
  
  public static void a(Context paramContext) {
    try {
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public static void a(Context paramContext, AdSlot paramAdSlot) {
    try {
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public static void a(AdSlot paramAdSlot, boolean paramBoolean, long paramLong1, long paramLong2) {
    boolean bool;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = true;
    } 
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.putOpt("available_type", Integer.valueOf(bool));
      jSONObject.putOpt("creative_check_duration", Long.valueOf(paramLong2));
      d d = d.b().a(4).c(paramAdSlot.getCodeId()).b(Long.valueOf(paramLong1).intValue()).b(jSONObject.toString());
      return;
    } finally {
      paramAdSlot = null;
    } 
  }
  
  public static void a(a parama) {
    if (!b(parama))
      return; 
    k k = parama.c().get(0);
    int i = ah.d(k.P());
    r r = k.z();
    if (r != null) {
      long l = SystemClock.elapsedRealtime();
      String str3 = r.g();
      if (str3 == null) {
        a(l, true, false, k, -1L, null);
        return;
      } 
      a(k, 1);
      String str2 = r.j();
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = j.a(str3); 
      str2 = a.a(o.a()).a(String.valueOf(i), b.b());
      File file = a(o.a(), str2, str1);
      if (o.h().e(String.valueOf(i)) && !w.d(o.a())) {
        if (str1 != null && file.exists()) {
          t.b("preLoadVideo", "非wifi环境，已缓存相同url的视频文件也是可以播放的");
          a.a(o.a()).b(new n(parama, k, null));
        } 
        return;
      } 
      e.a(o.a()).a(str3, new b.a(file, str1, parama, k, l) {
            public File a(String param1String) {
              try {
                File file = this.a.getParentFile();
                if (file != null && file.exists())
                  return h.c().p().a(this.b, file); 
              } catch (IOException iOException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("datastoreGet throw IOException : ");
                stringBuilder.append(iOException.toString());
                t.e("SplashUtils", stringBuilder.toString());
              } 
              return null;
            }
            
            public void a(long param1Long1, long param1Long2) {}
            
            public void a(n<File> param1n) {
              long l1;
              if (param1n != null && param1n.a != null) {
                a.a(o.a()).b(new n(this.c, this.d, null));
                a.a(o.a()).a(new n(this.c, this.d, null));
                c.a(this.e, true, true, this.d, 0L, param1n);
                return;
              } 
              long l2 = this.e;
              k k1 = this.d;
              if (param1n == null) {
                l1 = -3L;
              } else {
                l1 = param1n.h;
              } 
              c.a(l2, true, false, k1, l1, param1n);
            }
            
            public void a(String param1String, File param1File) {
              if (param1File != null)
                a.a(o.a()).a(param1File); 
            }
            
            public File b(String param1String) {
              return this.a;
            }
            
            public void b(n<File> param1n) {
              long l1;
              long l2 = this.e;
              k k1 = this.d;
              if (param1n == null) {
                l1 = -2L;
              } else {
                l1 = param1n.h;
              } 
              c.a(l2, true, false, k1, l1, param1n);
            }
          });
    } 
  }
  
  public static void a(k paramk) {
    if (paramk != null) {
      if (paramk.x() == null)
        return; 
      if (paramk.aa() && paramk.F() != null && !paramk.F().isEmpty())
        for (j j1 : paramk.F()) {
          if (!TextUtils.isEmpty(j1.a()))
            e.a(o.a()).f().a(j1.a(), (b.b)b.a(), j1.b(), j1.c()); 
        }  
      j j = paramk.C();
      if (j != null) {
        if (TextUtils.isEmpty(j.a()))
          return; 
        e.a(o.a()).f().a(j.a(), (b.b)b.a(), j.b(), j.c());
      } 
    } 
  }
  
  public static void a(k paramk, int paramInt) {
    int i = w.c(o.a());
    byte b = 4;
    if (i != 2) {
      if (i != 3) {
        if (i != 4) {
          if (i != 5)
            b = 0; 
        } else {
          b = 1;
        } 
      } else {
        b = 3;
      } 
    } else {
      b = 2;
    } 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("splash_show_type", Integer.valueOf(paramInt));
    hashMap.put("network_status", Integer.valueOf(b));
    d.h(o.a(), paramk, "splash_ad", "network_type", hashMap);
  }
  
  public static void a(d paramd, String paramString) {
    String str = g.a(-7);
    a.a().f(paramd.b(-7).g(str).i(paramString));
  }
  
  public static boolean a(n paramn) {
    return (paramn != null && paramn.a() != null);
  }
  
  public static int b(k paramk) {
    return (paramk != null) ? ah.d(paramk.P()) : 0;
  }
  
  public static boolean b(a parama) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parama != null) {
      bool1 = bool2;
      if (parama.c() != null) {
        bool1 = bool2;
        if (!parama.c().isEmpty()) {
          bool1 = bool2;
          if (parama.c().get(0) != null)
            bool1 = true; 
        } 
      } 
    } 
    return bool1;
  }
  
  public static boolean b(n paramn) {
    return (paramn.a() != null && paramn.a().aa() && paramn.b() != null && (paramn.b()).length != 0);
  }
  
  public static int c(a parama) {
    return (parama != null) ? parama.b() : 0;
  }
  
  public static int c(n paramn) {
    if (paramn != null) {
      int j = c(paramn.c());
      int i = j;
      if (j <= 0)
        i = b(paramn.a()); 
      return i;
    } 
    return 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\splash\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */