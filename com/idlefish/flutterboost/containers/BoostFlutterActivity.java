package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XPlatformPlugin;
import io.flutter.Log;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BoostFlutterActivity extends Activity implements LifecycleOwner, FlutterActivityAndFragmentDelegate.Host {
  protected static final String b = BackgroundMode.a.name();
  
  private FlutterActivityAndFragmentDelegate a;
  
  private LifecycleRegistry c = new LifecycleRegistry(this);
  
  private void a() {
    try {
      ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
      if (activityInfo.metaData != null) {
        int i = activityInfo.metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
        if (i != -1) {
          setTheme(i);
          return;
        } 
      } else {
        Log.d("NewBoostFlutterActivity", "Using the launch theme as normal theme.");
        return;
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.e("NewBoostFlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
    } 
  }
  
  private Drawable b() {
    Drawable drawable = null;
    try {
      Bundle bundle = (getPackageManager().getActivityInfo(getComponentName(), 129)).metaData;
      if (bundle != null) {
        Integer integer = Integer.valueOf(bundle.getInt("io.flutter.embedding.android.SplashScreenDrawable"));
      } else {
        bundle = null;
      } 
      if (bundle != null) {
        if (Build.VERSION.SDK_INT > 21)
          return getResources().getDrawable(bundle.intValue(), getTheme()); 
        drawable = getResources().getDrawable(bundle.intValue());
      } 
      return drawable;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  private void c() {
    if (h() == BackgroundMode.b) {
      getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
      getWindow().setFlags(512, 512);
    } 
  }
  
  private void e() {
    if (Build.VERSION.SDK_INT >= 21) {
      Window window = getWindow();
      window.addFlags(-2147483648);
      window.setStatusBarColor(0);
      window.getDecorView().setSystemUiVisibility(1280);
    } 
  }
  
  public XPlatformPlugin a(FlutterEngine paramFlutterEngine) {
    return BoostViewUtils.a(paramFlutterEngine.getPlatformChannel());
  }
  
  public void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public View d() {
    return this.a.a((LayoutInflater)null, (ViewGroup)null, (Bundle)null);
  }
  
  public Activity f() {
    return this;
  }
  
  public FlutterView.TransparencyMode g() {
    return (h() == BackgroundMode.a) ? FlutterView.TransparencyMode.opaque : FlutterView.TransparencyMode.transparent;
  }
  
  public Context getContext() {
    return (Context)this;
  }
  
  public Lifecycle getLifecycle() {
    return (Lifecycle)this.c;
  }
  
  protected BackgroundMode h() {
    return getIntent().hasExtra("background_mode") ? BackgroundMode.valueOf(getIntent().getStringExtra("background_mode")) : BackgroundMode.a;
  }
  
  public String i() {
    return getIntent().hasExtra("url") ? getIntent().getStringExtra("url") : "";
  }
  
  public Map j() {
    return (Map)(getIntent().hasExtra("params") ? ((SerializableMap)getIntent().getSerializableExtra("params")).a() : new HashMap<Object, Object>());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    this.a.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed() {
    this.a.i();
  }
  
  public void onCreate(Bundle paramBundle) {
    a();
    super.onCreate(paramBundle);
    this.c.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    this.a = new FlutterActivityAndFragmentDelegate(this);
    this.a.a((Context)this);
    c();
    setContentView(d());
    e();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    this.a.g();
    this.a.h();
  }
  
  protected void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    this.a.a(paramIntent);
  }
  
  protected void onPause() {
    super.onPause();
    this.a.e();
    this.c.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
  }
  
  public void onPostResume() {
    super.onPostResume();
    this.a.d();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    this.a.a(paramInt, paramArrayOfString, paramArrayOfint);
  }
  
  public void onResume() {
    super.onResume();
    this.c.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    this.a.c();
  }
  
  public void onStart() {
    super.onStart();
    this.c.handleLifecycleEvent(Lifecycle.Event.ON_START);
    this.a.b();
  }
  
  public void onStop() {
    super.onStop();
    this.a.f();
  }
  
  public void onTrimMemory(int paramInt) {
    super.onTrimMemory(paramInt);
    this.a.a(paramInt);
  }
  
  public void onUserLeaveHint() {
    this.a.j();
  }
  
  public FlutterEngine provideFlutterEngine(Context paramContext) {
    return FlutterBoost.a().g();
  }
  
  public SplashScreen provideSplashScreen() {
    Drawable drawable = b();
    return (SplashScreen)((drawable != null) ? new DrawableSplashScreen(drawable, ImageView.ScaleType.CENTER, 500L) : null);
  }
  
  public enum BackgroundMode {
    a, b;
  }
  
  public static class NewEngineIntentBuilder {
    private final Class<? extends BoostFlutterActivity> a;
    
    private String b = BoostFlutterActivity.b;
    
    private String c = "";
    
    private Map d = new HashMap<Object, Object>();
    
    public NewEngineIntentBuilder(Class<? extends BoostFlutterActivity> param1Class) {
      this.a = param1Class;
    }
    
    public Intent a(Context param1Context) {
      BoostFlutterActivity.SerializableMap serializableMap = new BoostFlutterActivity.SerializableMap();
      serializableMap.a(this.d);
      return (new Intent(param1Context, this.a)).putExtra("background_mode", this.b).putExtra("destroy_engine_with_activity", false).putExtra("url", this.c).putExtra("params", serializableMap);
    }
    
    public NewEngineIntentBuilder a(BoostFlutterActivity.BackgroundMode param1BackgroundMode) {
      this.b = param1BackgroundMode.name();
      return this;
    }
    
    public NewEngineIntentBuilder a(String param1String) {
      this.c = param1String;
      return this;
    }
    
    public NewEngineIntentBuilder a(Map param1Map) {
      this.d = param1Map;
      return this;
    }
  }
  
  public static class SerializableMap implements Serializable {
    private Map<String, Object> a;
    
    public Map<String, Object> a() {
      return this.a;
    }
    
    public void a(Map<String, Object> param1Map) {
      this.a = param1Map;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\containers\BoostFlutterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */