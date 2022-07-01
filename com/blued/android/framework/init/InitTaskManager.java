package com.blued.android.framework.init;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.statistics.BluedStatistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class InitTaskManager {
  private static InitTaskManager a;
  
  private static Status b = Status.a;
  
  private ArrayList<OnResultListener> c = new ArrayList<OnResultListener>();
  
  private HandlerThread d = null;
  
  private Handler e = null;
  
  private OnTaskListBuilder f = null;
  
  private ArrayList<InitTask> g = new ArrayList<InitTask>();
  
  private int h = 0;
  
  private int i = 0;
  
  private int j = 0;
  
  private int k = 0;
  
  private long l = 0L;
  
  private long m = 0L;
  
  private JSONObject n = new JSONObject();
  
  private ConcurrentHashMap<String, Object> o = new ConcurrentHashMap<String, Object>();
  
  private Model a(Application paramApplication, String[] paramArrayOfString) {
    a("getInitModel");
    try {
      int i;
      String str3 = paramApplication.getPackageName();
      ActivityManager activityManager = (ActivityManager)paramApplication.getSystemService("activity");
      String str2 = "";
      String str1 = str2;
      if (Build.VERSION.SDK_INT >= 23) {
        List list = activityManager.getAppTasks();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("new way appTasks: ");
        stringBuilder1.append(list);
        a(stringBuilder1.toString());
        String str = str2;
        if (list != null) {
          str = str2;
          if (!list.isEmpty()) {
            Iterator<ActivityManager.AppTask> iterator = list.iterator();
            while (true) {
              str = str2;
              if (iterator.hasNext()) {
                ActivityManager.AppTask appTask = iterator.next();
                if (appTask == null)
                  continue; 
                ActivityManager.RecentTaskInfo recentTaskInfo = appTask.getTaskInfo();
                if (recentTaskInfo == null)
                  continue; 
                ComponentName componentName = recentTaskInfo.topActivity;
                if (componentName != null && str3.equals(componentName.getPackageName())) {
                  str1 = componentName.getClassName();
                  StringBuilder stringBuilder2 = new StringBuilder();
                  stringBuilder2.append("new way targetActivityClsName: ");
                  stringBuilder2.append(str1);
                  a(stringBuilder2.toString());
                  break;
                } 
                continue;
              } 
              break;
            } 
          } 
        } 
      } 
      str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        List list = activityManager.getRunningTasks(1);
        str2 = str1;
        if (list != null) {
          str2 = str1;
          if (!list.isEmpty()) {
            Iterator iterator = list.iterator();
            while (true) {
              str2 = str1;
              if (iterator.hasNext()) {
                ComponentName componentName = ((ActivityManager.RunningTaskInfo)iterator.next()).topActivity;
                if (str3.equals(componentName.getPackageName())) {
                  str2 = componentName.getClassName();
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("old way targetActivityClsName: ");
                  stringBuilder1.append(str2);
                  a(stringBuilder1.toString());
                  break;
                } 
                continue;
              } 
              break;
            } 
          } 
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("targetActivity: ");
      stringBuilder.append(str2);
      a(stringBuilder.toString());
      if (TextUtils.isEmpty(str2))
        return Model.b; 
      int j = paramArrayOfString.length;
    } finally {
      paramApplication = null;
    } 
    a("return sync");
    return Model.c;
  }
  
  public static InitTaskManager a() {
    // Byte code:
    //   0: getstatic com/blued/android/framework/init/InitTaskManager.a : Lcom/blued/android/framework/init/InitTaskManager;
    //   3: ifnonnull -> 51
    //   6: ldc com/blued/android/framework/init/InitTaskManager
    //   8: monitorenter
    //   9: getstatic com/blued/android/framework/init/InitTaskManager.a : Lcom/blued/android/framework/init/InitTaskManager;
    //   12: ifnonnull -> 39
    //   15: invokestatic m : ()Z
    //   18: ifeq -> 29
    //   21: ldc 'InitTaskManager'
    //   23: ldc ' >>> new InitTaskManager <<< '
    //   25: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   28: pop
    //   29: new com/blued/android/framework/init/InitTaskManager
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: putstatic com/blued/android/framework/init/InitTaskManager.a : Lcom/blued/android/framework/init/InitTaskManager;
    //   39: ldc com/blued/android/framework/init/InitTaskManager
    //   41: monitorexit
    //   42: goto -> 51
    //   45: astore_0
    //   46: ldc com/blued/android/framework/init/InitTaskManager
    //   48: monitorexit
    //   49: aload_0
    //   50: athrow
    //   51: getstatic com/blued/android/framework/init/InitTaskManager.a : Lcom/blued/android/framework/init/InitTaskManager;
    //   54: areturn
    // Exception table:
    //   from	to	target	type
    //   9	29	45	finally
    //   29	39	45	finally
    //   39	42	45	finally
    //   46	49	45	finally
  }
  
  private void a(Application paramApplication) {
    a("initSync");
    if (this.f != null) {
      if (b())
        return; 
      a("do initSync start");
      if (b(paramApplication))
        d(); 
      b = Status.c;
      g();
      a("do initSync end");
    } 
  }
  
  private void a(InitTask paramInitTask) {
    Handler handler = this.e;
    if (handler == null)
      return; 
    handler.post(new Runnable(this, paramInitTask) {
          public void run() {
            InitTaskManager initTaskManager = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("  run task in thread: ");
            stringBuilder.append(this.a.a());
            initTaskManager.a(stringBuilder.toString());
            this.a.b();
            initTaskManager = this.b;
            stringBuilder = new StringBuilder();
            stringBuilder.append("  finish task in thread: ");
            stringBuilder.append(this.a.a());
            initTaskManager.a(stringBuilder.toString());
            AppInfo.n().post(new Runnable(this) {
                  public void run() {
                    if (!InitTaskManager.a(this.a.b, this.a.a.e()) && this.a.a.c())
                      InitTaskManager.a(this.a.b); 
                  }
                });
          }
        });
    this.h++;
  }
  
  private boolean a(boolean paramBoolean) {
    if (paramBoolean)
      this.k--; 
    this.j++;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("-- MFA: ");
    stringBuilder.append(this.h);
    stringBuilder.append(", ");
    stringBuilder.append(this.i);
    stringBuilder.append(", ");
    stringBuilder.append(this.k);
    stringBuilder.append(", ");
    stringBuilder.append(this.j);
    a(stringBuilder.toString());
    if (this.k == 0) {
      e();
      b = Status.c;
      this.k = -1;
    } 
    if (this.j >= this.i) {
      if (b != Status.c) {
        e();
        b = Status.c;
      } 
      BluedStatistics.b().a(this.l);
      if (this.l > 500L)
        BluedStatistics.c().b("INIT_TASK_TIMES", this.l, 0, this.n.toString()); 
      g();
      return true;
    } 
    return false;
  }
  
  private void b(InitTask paramInitTask) {
    AppInfo.n().post(new Runnable(this, paramInitTask) {
          public void run() {
            InitTaskManager initTaskManager = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("  run task in ui: ");
            stringBuilder.append(this.a.a());
            initTaskManager.a(stringBuilder.toString());
            InitTaskManager.a(this.b, System.currentTimeMillis());
            this.a.b();
            long l = System.currentTimeMillis() - InitTaskManager.b(this.b);
            initTaskManager = this.b;
            stringBuilder = new StringBuilder();
            stringBuilder.append("  finished in ui: ");
            stringBuilder.append(this.a.a());
            stringBuilder.append("(");
            stringBuilder.append(l);
            stringBuilder.append(")");
            initTaskManager.a(stringBuilder.toString());
            initTaskManager = this.b;
            InitTaskManager.b(initTaskManager, InitTaskManager.c(initTaskManager) + l);
            if (InitTaskManager.d(this.b) != null && !TextUtils.isEmpty(this.a.a()))
              try {
                InitTaskManager.d(this.b).put(this.a.a(), l);
              } catch (JSONException jSONException) {
                jSONException.printStackTrace();
              }  
            if (!InitTaskManager.a(this.b, this.a.e()))
              InitTaskManager.a(this.b); 
          }
        });
    this.h++;
  }
  
  public static boolean b() {
    return (Status.c == b);
  }
  
  private boolean b(Application paramApplication) {
    b = Status.b;
    this.f.onBuild(paramApplication, this.g);
    this.j = 0;
    ArrayList<InitTask> arrayList = this.g;
    if (arrayList != null) {
      this.i = arrayList.size();
      for (InitTask initTask : this.g) {
        if (initTask != null && initTask.e())
          this.k++; 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("-- initTaskList: totalTaskCount=");
      stringBuilder.append(this.i);
      stringBuilder.append(", unfinishedNotifyTaskCount=");
      stringBuilder.append(this.k);
      a(stringBuilder.toString());
      if (this.i > 0)
        return true; 
    } 
    return false;
  }
  
  public static boolean c() {
    return (Status.b == b);
  }
  
  private void e() {
    a("notifyFinished");
    ArrayList<OnResultListener> arrayList = this.c;
    if (arrayList != null && !arrayList.isEmpty()) {
      Iterator<OnResultListener> iterator = this.c.iterator();
      while (iterator.hasNext())
        ((OnResultListener)iterator.next()).a(); 
    } 
    a("do initAsync end");
  }
  
  private void f() {
    while (this.h < this.i) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" ++ executeNextTask: ");
      stringBuilder.append(this.h);
      a(stringBuilder.toString());
      InitTask initTask = this.g.get(this.h);
      if (initTask == null) {
        this.h++;
        continue;
      } 
      if (initTask.d()) {
        a(initTask);
        if (initTask.c())
          return; 
        continue;
      } 
      b(initTask);
    } 
  }
  
  private void g() {
    ArrayList<OnResultListener> arrayList1 = this.c;
    if (arrayList1 != null) {
      arrayList1.clear();
      this.c = null;
    } 
    HandlerThread handlerThread = this.d;
    if (handlerThread != null) {
      handlerThread.quit();
      this.d = null;
    } 
    this.e = null;
    ArrayList<InitTask> arrayList = this.g;
    if (arrayList != null) {
      arrayList.clear();
      this.g = null;
    } 
    ConcurrentHashMap<String, Object> concurrentHashMap = this.o;
    if (concurrentHashMap != null) {
      concurrentHashMap.clear();
      this.o = null;
    } 
    a = null;
  }
  
  public void a(Application paramApplication, OnResultListener paramOnResultListener) {
    if (!AppInfo.m() || Looper.myLooper() == Looper.getMainLooper()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("mayInit Entry state: ");
      stringBuilder.append(b.name());
      a(stringBuilder.toString());
      if (paramOnResultListener != null && !this.c.contains(paramOnResultListener))
        this.c.add(paramOnResultListener); 
      if (this.f == null || b()) {
        e();
        return;
      } 
      if (!c()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("initWorkThread-");
        stringBuilder1.append(System.currentTimeMillis());
        this.d = new HandlerThread(stringBuilder1.toString());
        this.d.start();
        this.e = new Handler(this.d.getLooper());
        if (b(paramApplication)) {
          a("do initAsync start");
          this.n = new JSONObject();
          this.l = 0L;
          f();
        } 
      } 
      return;
    } 
    throw new IllegalStateException("InitTaskManager.getInstance().mayInt need invoke in main thread!");
  }
  
  public void a(Application paramApplication, String[] paramArrayOfString, OnTaskListBuilder paramOnTaskListBuilder) {
    this.f = paramOnTaskListBuilder;
    if (paramOnTaskListBuilder == null)
      return; 
    Model model = a(paramApplication, paramArrayOfString);
    if (Model.a == model)
      return; 
    if (Model.b == model) {
      a(paramApplication, (OnResultListener)null);
      return;
    } 
    a(paramApplication);
  }
  
  public void a(String paramString) {
    if (AppInfo.m())
      Log.d("InitTaskManager", paramString); 
  }
  
  public void d() {
    while (true) {
      int i = this.h;
      if (i < this.i) {
        InitTask initTask = this.g.get(i);
        if (initTask != null)
          if (initTask.d() && !initTask.c()) {
            new Thread(new Runnable(this, initTask) {
                  public void run() {
                    InitTaskManager initTaskManager = this.b;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("sync run task in thread: ");
                    stringBuilder.append(this.a.a());
                    initTaskManager.a(stringBuilder.toString());
                    this.a.b();
                    initTaskManager = this.b;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("sync finish task in thead: ");
                    stringBuilder.append(this.a.a());
                    initTaskManager.a(stringBuilder.toString());
                  }
                });
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sync run task: ");
            stringBuilder.append(initTask.a());
            a(stringBuilder.toString());
            initTask.b();
            stringBuilder = new StringBuilder();
            stringBuilder.append("sync finish task: ");
            stringBuilder.append(initTask.a());
            a(stringBuilder.toString());
          }  
        this.h++;
        continue;
      } 
      break;
    } 
  }
  
  enum Model {
    a, b, c;
  }
  
  public static interface OnResultListener {
    void a();
  }
  
  public static interface OnTaskListBuilder {
    void onBuild(Application param1Application, ArrayList<InitTask> param1ArrayList);
  }
  
  enum Status {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\init\InitTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */