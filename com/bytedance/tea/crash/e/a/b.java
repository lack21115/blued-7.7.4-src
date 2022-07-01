package com.bytedance.tea.crash.e.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  private Application a;
  
  private Context b;
  
  private List<String> c = new ArrayList<String>();
  
  private List<Long> d = new ArrayList<Long>();
  
  private List<String> e = new ArrayList<String>();
  
  private List<Long> f = new ArrayList<Long>();
  
  private String g;
  
  private long h;
  
  private String i;
  
  private long j;
  
  private String k;
  
  private long l;
  
  private String m;
  
  private long n;
  
  private String o;
  
  private long p;
  
  private int q;
  
  private final Application.ActivityLifecycleCallbacks r = new Application.ActivityLifecycleCallbacks(this) {
      public void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {
        b.a(this.a, param1Activity.getClass().getName());
        b.a(this.a, System.currentTimeMillis());
        b.b(this.a).add(b.a(this.a));
        b.d(this.a).add(Long.valueOf(b.c(this.a)));
      }
      
      public void onActivityDestroyed(Activity param1Activity) {
        String str = param1Activity.getClass().getName();
        int i = b.b(this.a).indexOf(str);
        if (i > -1 && i < b.b(this.a).size()) {
          b.b(this.a).remove(i);
          b.d(this.a).remove(i);
        } 
        b.g(this.a).add(str);
        b.h(this.a).add(Long.valueOf(System.currentTimeMillis()));
      }
      
      public void onActivityPaused(Activity param1Activity) {
        b.d(this.a, param1Activity.getClass().getName());
        b.d(this.a, System.currentTimeMillis());
        b.f(this.a);
      }
      
      public void onActivityResumed(Activity param1Activity) {
        b.c(this.a, param1Activity.getClass().getName());
        b.c(this.a, System.currentTimeMillis());
        b.e(this.a);
      }
      
      public void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) {}
      
      public void onActivityStarted(Activity param1Activity) {
        b.b(this.a, param1Activity.getClass().getName());
        b.b(this.a, System.currentTimeMillis());
      }
      
      public void onActivityStopped(Activity param1Activity) {
        b.e(this.a, param1Activity.getClass().getName());
        b.e(this.a, System.currentTimeMillis());
      }
    };
  
  b(Context paramContext) {
    this.b = paramContext;
    if (this.b instanceof Application)
      this.a = (Application)paramContext; 
    c();
  }
  
  private JSONObject a(String paramString, long paramLong) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("name", paramString);
      jSONObject.put("time", paramLong);
      return jSONObject;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONObject;
    } 
  }
  
  private void c() {
    if (Build.VERSION.SDK_INT >= 14) {
      Application application = this.a;
      if (application != null)
        application.registerActivityLifecycleCallbacks(this.r); 
    } 
  }
  
  private JSONArray d() {
    JSONArray jSONArray = new JSONArray();
    List<String> list = this.c;
    if (list != null) {
      if (list.isEmpty())
        return jSONArray; 
      int i = 0;
      while (true) {
        if (i < this.c.size()) {
          try {
            jSONArray.put(a(this.c.get(i), ((Long)this.d.get(i)).longValue()));
          } finally {
            list = null;
          } 
          continue;
        } 
        return jSONArray;
      } 
    } 
    return jSONArray;
  }
  
  private JSONArray e() {
    JSONArray jSONArray = new JSONArray();
    List<String> list = this.e;
    if (list != null) {
      if (list.isEmpty())
        return jSONArray; 
      int i = 0;
      while (true) {
        if (i < this.e.size()) {
          try {
            jSONArray.put(a(this.e.get(i), ((Long)this.f.get(i)).longValue()));
          } finally {
            list = null;
          } 
          continue;
        } 
        return jSONArray;
      } 
    } 
    return jSONArray;
  }
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("last_create_activity", a(this.g, this.h));
      jSONObject.put("last_start_activity", a(this.i, this.j));
      jSONObject.put("last_resume_activity", a(this.k, this.l));
      jSONObject.put("last_pause_activity", a(this.m, this.n));
      jSONObject.put("last_stop_activity", a(this.o, this.p));
      jSONObject.put("alive_activities", d());
      jSONObject.put("finish_activities", e());
      return jSONObject;
    } catch (JSONException jSONException) {
      return jSONObject;
    } 
  }
  
  public JSONArray b() {
    JSONArray jSONArray = new JSONArray();
    try {
      ActivityManager activityManager = (ActivityManager)this.b.getSystemService("activity");
      if (activityManager == null)
        return jSONArray; 
      List list = activityManager.getRunningTasks(5);
      if (list == null)
        return jSONArray; 
      Iterator<ActivityManager.RunningTaskInfo> iterator = list.iterator();
      while (true) {
        if (iterator.hasNext()) {
          ActivityManager.RunningTaskInfo runningTaskInfo = iterator.next();
          if (runningTaskInfo != null) {
            ComponentName componentName = runningTaskInfo.baseActivity;
            if (componentName == null)
              continue; 
            try {
              JSONObject jSONObject = new JSONObject();
              jSONObject.put("id", runningTaskInfo.id);
              jSONObject.put("package_name", runningTaskInfo.baseActivity.getPackageName());
              jSONObject.put("description", runningTaskInfo.description);
              jSONObject.put("number_of_activities", runningTaskInfo.numActivities);
              jSONObject.put("number_of_running_activities", runningTaskInfo.numRunning);
              jSONObject.put("topActivity", runningTaskInfo.topActivity.toString());
              jSONObject.put("baseActivity", runningTaskInfo.baseActivity.toString());
              jSONArray.put(jSONObject);
            } catch (JSONException jSONException) {}
          } 
          continue;
        } 
        return jSONArray;
      } 
    } catch (Exception exception) {
      return jSONArray;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\e\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */