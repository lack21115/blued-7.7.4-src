package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.idlefish.flutterboost.interfaces.IContainerManager;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.view.FlutterMain;
import java.util.HashMap;
import java.util.Map;

public class FlutterBoost {
  static FlutterBoost a;
  
  private static boolean g;
  
  private Platform b;
  
  private FlutterViewContainerManager c;
  
  private FlutterEngine d;
  
  private Activity e;
  
  private boolean f = false;
  
  private long h = 0L;
  
  private Application.ActivityLifecycleCallbacks i;
  
  public static FlutterBoost a() {
    if (a == null)
      a = new FlutterBoost(); 
    return a;
  }
  
  private void a(FlutterEngine paramFlutterEngine) {
    try {
      Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[] { FlutterEngine.class }).invoke(null, new Object[] { paramFlutterEngine });
      return;
    } catch (Exception exception) {
      Debuger.a(exception);
      return;
    } 
  }
  
  private FlutterEngine h() {
    if (this.d == null) {
      FlutterMain.startInitialization((Context)this.b.a());
      FlutterShellArgs flutterShellArgs = new FlutterShellArgs(new String[0]);
      FlutterMain.ensureInitializationComplete(this.b.a().getApplicationContext(), flutterShellArgs.toArray());
      this.d = new FlutterEngine(this.b.a().getApplicationContext(), FlutterLoader.getInstance(), new FlutterJNI(), null, false);
      a(this.d);
    } 
    return this.d;
  }
  
  public void a(long paramLong) {
    this.h = paramLong;
  }
  
  public void a(Platform paramPlatform) {
    if (g) {
      Debuger.a("FlutterBoost is alread inited. Do not init twice");
      return;
    } 
    this.b = paramPlatform;
    this.c = new FlutterViewContainerManager();
    this.i = new Application.ActivityLifecycleCallbacks(this) {
        public void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {
          FlutterBoost.a(this.a, true);
          FlutterBoost.a(this.a, param1Activity);
          if (FlutterBoost.a(this.a).e() == FlutterBoost.ConfigBuilder.b)
            this.a.b(); 
        }
        
        public void onActivityDestroyed(Activity param1Activity) {
          if (!FlutterBoost.b(this.a))
            return; 
          if (FlutterBoost.c(this.a) == param1Activity) {
            Debuger.a("Application entry background");
            if (FlutterBoost.d(this.a) != null) {
              HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
              hashMap.put("type", "background");
              this.a.e().a("lifecycle", hashMap);
            } 
            FlutterBoost.a(this.a, (Activity)null);
          } 
        }
        
        public void onActivityPaused(Activity param1Activity) {
          if (!FlutterBoost.b(this.a));
        }
        
        public void onActivityResumed(Activity param1Activity) {
          if (!FlutterBoost.b(this.a))
            return; 
          FlutterBoost.a(this.a, param1Activity);
        }
        
        public void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) {
          if (!FlutterBoost.b(this.a));
        }
        
        public void onActivityStarted(Activity param1Activity) {
          if (!FlutterBoost.b(this.a))
            return; 
          if (FlutterBoost.c(this.a) == null) {
            Debuger.a("Application entry foreground");
            if (FlutterBoost.d(this.a) != null) {
              HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
              hashMap.put("type", "foreground");
              this.a.e().a("lifecycle", hashMap);
            } 
          } 
          FlutterBoost.a(this.a, param1Activity);
        }
        
        public void onActivityStopped(Activity param1Activity) {
          if (!FlutterBoost.b(this.a))
            return; 
          if (FlutterBoost.c(this.a) == param1Activity) {
            Debuger.a("Application entry background");
            if (FlutterBoost.d(this.a) != null) {
              HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
              hashMap.put("type", "background");
              this.a.e().a("lifecycle", hashMap);
            } 
            FlutterBoost.a(this.a, (Activity)null);
          } 
        }
      };
    paramPlatform.a().registerActivityLifecycleCallbacks(this.i);
    if (this.b.e() == ConfigBuilder.a)
      b(); 
    g = true;
  }
  
  public void b() {
    if (this.d != null)
      return; 
    if (this.b.b != null)
      this.b.b.a(); 
    FlutterEngine flutterEngine = h();
    if (this.b.b != null)
      this.b.b.b(); 
    if (flutterEngine.getDartExecutor().isExecutingDart())
      return; 
    if (this.b.d() != null)
      flutterEngine.getNavigationChannel().setInitialRoute(this.b.d()); 
    DartExecutor.DartEntrypoint dartEntrypoint = new DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), this.b.c());
    flutterEngine.getDartExecutor().executeDartEntrypoint(dartEntrypoint);
  }
  
  public IContainerManager c() {
    return a.c;
  }
  
  public Platform d() {
    return a.b;
  }
  
  public FlutterBoostPlugin e() {
    return FlutterBoostPlugin.a();
  }
  
  public Activity f() {
    return a.e;
  }
  
  public FlutterEngine g() {
    return this.d;
  }
  
  public static interface BoostLifecycleListener {
    void a();
    
    void b();
  }
  
  public static class ConfigBuilder {
    public static int a = 0;
    
    public static int b = 1;
    
    public static int c = 2;
    
    public static int d = 0;
    
    public static int e = 1;
    
    private String f = "main";
    
    private String g = "/";
    
    private int h = b;
    
    private int i = d;
    
    private boolean j = false;
    
    private FlutterView.RenderMode k = FlutterView.RenderMode.texture;
    
    private Application l;
    
    private INativeRouter m = null;
    
    private FlutterBoost.BoostLifecycleListener n;
    
    public ConfigBuilder(Application param1Application, INativeRouter param1INativeRouter) {
      this.m = param1INativeRouter;
      this.l = param1Application;
    }
    
    public ConfigBuilder a(int param1Int) {
      this.h = param1Int;
      return this;
    }
    
    public ConfigBuilder a(FlutterBoost.BoostLifecycleListener param1BoostLifecycleListener) {
      this.n = param1BoostLifecycleListener;
      return this;
    }
    
    public ConfigBuilder a(FlutterView.RenderMode param1RenderMode) {
      this.k = param1RenderMode;
      return this;
    }
    
    public ConfigBuilder a(String param1String) {
      this.g = param1String;
      return this;
    }
    
    public ConfigBuilder a(boolean param1Boolean) {
      this.j = param1Boolean;
      return this;
    }
    
    public Platform a() {
      Platform platform = new Platform(this) {
          public Application a() {
            return FlutterBoost.ConfigBuilder.a(this.a);
          }
          
          public void a(Context param2Context, String param2String, Map<String, Object> param2Map1, int param2Int, Map<String, Object> param2Map2) {
            FlutterBoost.ConfigBuilder.e(this.a).a(param2Context, param2String, param2Map1, param2Int, param2Map2);
          }
          
          public boolean b() {
            return FlutterBoost.ConfigBuilder.b(this.a);
          }
          
          public String c() {
            return FlutterBoost.ConfigBuilder.c(this.a);
          }
          
          public String d() {
            return FlutterBoost.ConfigBuilder.d(this.a);
          }
          
          public int e() {
            return FlutterBoost.ConfigBuilder.f(this.a);
          }
          
          public FlutterView.RenderMode f() {
            return FlutterBoost.ConfigBuilder.g(this.a);
          }
        };
      platform.b = this.n;
      return platform;
    }
  }
  
  class null extends Platform {
    null(FlutterBoost this$0) {}
    
    public Application a() {
      return FlutterBoost.ConfigBuilder.a(this.a);
    }
    
    public void a(Context param1Context, String param1String, Map<String, Object> param1Map1, int param1Int, Map<String, Object> param1Map2) {
      FlutterBoost.ConfigBuilder.e(this.a).a(param1Context, param1String, param1Map1, param1Int, param1Map2);
    }
    
    public boolean b() {
      return FlutterBoost.ConfigBuilder.b(this.a);
    }
    
    public String c() {
      return FlutterBoost.ConfigBuilder.c(this.a);
    }
    
    public String d() {
      return FlutterBoost.ConfigBuilder.d(this.a);
    }
    
    public int e() {
      return FlutterBoost.ConfigBuilder.f(this.a);
    }
    
    public FlutterView.RenderMode f() {
      return FlutterBoost.ConfigBuilder.g(this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\FlutterBoost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */