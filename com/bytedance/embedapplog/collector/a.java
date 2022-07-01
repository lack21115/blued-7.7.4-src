package com.bytedance.embedapplog.collector;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.embedapplog.IPicker;
import com.bytedance.embedapplog.a.e;
import com.bytedance.embedapplog.d.h;
import com.bytedance.embedapplog.util.h;
import java.util.HashSet;

public class a implements Application.ActivityLifecycleCallbacks {
  private static int a = 0;
  
  private static h b;
  
  private static h c;
  
  private static long d = 0L;
  
  private static String e;
  
  private static long f = 0L;
  
  private static String g;
  
  private static int h = -1;
  
  private static Object i;
  
  private static Object j;
  
  private static final HashSet<Integer> l = new HashSet<Integer>(8);
  
  private final IPicker k;
  
  public a(IPicker paramIPicker) {
    this.k = paramIPicker;
  }
  
  public static h a(h paramh, long paramLong) {
    h h1 = (h)paramh.g();
    h1.a = paramLong;
    paramLong -= paramh.a;
    if (paramLong >= 0L) {
      h1.h = paramLong;
    } else {
      h.a(null);
    } 
    e.a((com.bytedance.embedapplog.d.a)h1);
    return h1;
  }
  
  public static h a(String paramString1, String paramString2, long paramLong, String paramString3) {
    h h1 = new h();
    if (!TextUtils.isEmpty(paramString2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append(":");
      stringBuilder.append(paramString2);
      h1.j = stringBuilder.toString();
    } else {
      h1.j = paramString1;
    } 
    h1.a = paramLong;
    h1.h = -1L;
    if (paramString3 == null)
      paramString3 = ""; 
    h1.i = paramString3;
    e.a((com.bytedance.embedapplog.d.a)h1);
    return h1;
  }
  
  public static void a(Object paramObject) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {
    l.add(Integer.valueOf(paramActivity.hashCode()));
  }
  
  public void onActivityDestroyed(Activity paramActivity) {
    l.remove(Integer.valueOf(paramActivity.hashCode()));
  }
  
  public void onActivityPaused(Activity paramActivity) {
    if (c != null)
      a(j); 
    h h1 = b;
    if (h1 != null) {
      e = h1.j;
      d = System.currentTimeMillis();
      a(b, d);
      b = null;
      if (!paramActivity.isChild()) {
        h = -1;
        i = null;
      } 
    } 
  }
  
  public void onActivityResumed(Activity paramActivity) {
    long l = System.currentTimeMillis();
    b = a(paramActivity.getClass().getName(), "", l, e);
    b.k = l.remove(Integer.valueOf(paramActivity.hashCode())) ^ true;
    if (!paramActivity.isChild())
      try {
        h = paramActivity.getWindow().getDecorView().hashCode();
        i = paramActivity;
        return;
      } catch (Exception exception) {
        h.a(exception);
      }  
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {
    a++;
    if (a == 1) {
      IPicker iPicker = this.k;
      if (iPicker != null)
        iPicker.show(true); 
    } 
  }
  
  public void onActivityStopped(Activity paramActivity) {
    if (e != null) {
      a--;
      if (a <= 0) {
        e = null;
        g = null;
        f = 0L;
        d = 0L;
        IPicker iPicker = this.k;
        if (iPicker != null)
          iPicker.show(false); 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\collector\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */