package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.Utils;
import com.idlefish.flutterboost.XFlutterView;
import com.idlefish.flutterboost.XPlatformPlugin;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import com.idlefish.flutterboost.interfaces.IOperateSyncer;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterEngineProvider;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.android.SplashScreenProvider;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FlutterActivityAndFragmentDelegate implements IFlutterViewContainer {
  private static int b;
  
  protected IOperateSyncer a;
  
  private Host c;
  
  private FlutterEngine d;
  
  private FlutterSplashView e;
  
  private XFlutterView f;
  
  private XPlatformPlugin g;
  
  private boolean h;
  
  public FlutterActivityAndFragmentDelegate(Host paramHost) {
    this.c = paramHost;
  }
  
  private void r() {
    Log.d("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
    Host host = this.c;
    this.d = host.provideFlutterEngine(host.getContext());
    if (this.d != null) {
      this.h = true;
      return;
    } 
    Log.d("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this NewFlutterFragment.");
    this.h = false;
  }
  
  private void s() {
    if (this.c != null)
      return; 
    throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    Log.v("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
    this.a = FlutterBoost.a().c().a(this);
    s();
    this.f = new XFlutterView((Context)this.c.f(), FlutterBoost.a().d().f(), this.c.g());
    this.e = new FlutterSplashView(this.c.getContext());
    if (Build.VERSION.SDK_INT >= 17) {
      this.e.setId(View.generateViewId());
    } else {
      this.e.setId(486947586);
    } 
    this.e.a(this.f, this.c.provideSplashScreen());
    this.a.d();
    return (View)this.e;
  }
  
  public void a() {
    this.c = null;
    this.d = null;
    this.f = null;
    this.g = null;
  }
  
  public void a(int paramInt) {
    this.a.a(paramInt);
    s();
    if (this.d != null) {
      if (paramInt == 10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Forwarding onTrimMemory() to FlutterEngine. Level: ");
        stringBuilder.append(paramInt);
        Log.v("FlutterActivityAndFragmentDelegate", stringBuilder.toString());
        this.d.getSystemChannel().sendMemoryPressureWarning();
        return;
      } 
    } else {
      Log.w("FlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before NewFlutterFragment was attached to an Activity.");
    } 
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Lcom/idlefish/flutterboost/interfaces/IOperateSyncer;
    //   4: iload_1
    //   5: iload_2
    //   6: aload_3
    //   7: invokeinterface a : (IILandroid/content/Intent;)V
    //   12: aload_3
    //   13: ifnull -> 42
    //   16: aload_3
    //   17: ldc '_flutter_result_'
    //   19: invokevirtual getSerializableExtra : (Ljava/lang/String;)Ljava/io/Serializable;
    //   22: astore #4
    //   24: aload #4
    //   26: instanceof java/util/Map
    //   29: ifeq -> 42
    //   32: aload #4
    //   34: checkcast java/util/Map
    //   37: astore #4
    //   39: goto -> 45
    //   42: aconst_null
    //   43: astore #4
    //   45: aload_0
    //   46: getfield a : Lcom/idlefish/flutterboost/interfaces/IOperateSyncer;
    //   49: iload_1
    //   50: iload_2
    //   51: aload #4
    //   53: invokeinterface a : (IILjava/util/Map;)V
    //   58: aload_0
    //   59: invokespecial s : ()V
    //   62: aload_0
    //   63: getfield d : Lio/flutter/embedding/engine/FlutterEngine;
    //   66: ifnull -> 150
    //   69: new java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial <init> : ()V
    //   76: astore #4
    //   78: aload #4
    //   80: ldc 'Forwarding onActivityResult() to FlutterEngine:\\nrequestCode: '
    //   82: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload #4
    //   88: iload_1
    //   89: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload #4
    //   95: ldc '\\nresultCode: '
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload #4
    //   103: iload_2
    //   104: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload #4
    //   110: ldc '\\ndata: '
    //   112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload #4
    //   118: aload_3
    //   119: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: ldc 'FlutterActivityAndFragmentDelegate'
    //   125: aload #4
    //   127: invokevirtual toString : ()Ljava/lang/String;
    //   130: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield d : Lio/flutter/embedding/engine/FlutterEngine;
    //   137: invokevirtual getActivityControlSurface : ()Lio/flutter/embedding/engine/plugins/activity/ActivityControlSurface;
    //   140: iload_1
    //   141: iload_2
    //   142: aload_3
    //   143: invokeinterface onActivityResult : (IILandroid/content/Intent;)Z
    //   148: pop
    //   149: return
    //   150: ldc 'FlutterActivityAndFragmentDelegate'
    //   152: ldc 'onActivityResult() invoked before NewFlutterFragment was attached to an Activity.'
    //   154: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)V
    //   157: return
  }
  
  public void a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    this.a.a(paramInt, paramArrayOfString, paramArrayOfint);
    s();
    if (this.d != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: ");
      stringBuilder.append(paramInt);
      stringBuilder.append("\npermissions: ");
      stringBuilder.append(Arrays.toString((Object[])paramArrayOfString));
      stringBuilder.append("\ngrantResults: ");
      stringBuilder.append(Arrays.toString(paramArrayOfint));
      Log.v("FlutterActivityAndFragmentDelegate", stringBuilder.toString());
      this.d.getActivityControlSurface().onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfint);
      return;
    } 
    Log.w("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before NewFlutterFragment was attached to an Activity.");
  }
  
  public void a(Activity paramActivity, HashMap paramHashMap) {
    Intent intent = new Intent();
    if (paramHashMap != null)
      intent.putExtra("_flutter_result_", paramHashMap); 
    paramActivity.setResult(-1, intent);
  }
  
  public void a(Context paramContext) {
    s();
    if (FlutterBoost.a().d().e() == FlutterBoost.ConfigBuilder.c)
      FlutterBoost.a().b(); 
    if (this.d == null)
      r(); 
    this.g = this.c.a(this.d);
    this.c.configureFlutterEngine(this.d);
    this.c.f().getWindow().setFormat(-3);
  }
  
  public void a(Intent paramIntent) {
    this.a.a(paramIntent);
    s();
    if (this.d != null) {
      Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine.");
      this.d.getActivityControlSurface().onNewIntent(paramIntent);
      return;
    } 
    Log.w("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before NewFlutterFragment was attached to an Activity.");
  }
  
  public void a(Map<String, Object> paramMap) {
    if (paramMap != null) {
      a(this.c.f(), new HashMap<String, Object>(paramMap));
      this.c.f().finish();
      return;
    } 
    this.c.f().finish();
  }
  
  public void b() {
    Log.v("FlutterActivityAndFragmentDelegate", "onStart()");
    s();
  }
  
  public void c() {
    this.a.e();
    Log.v("FlutterActivityAndFragmentDelegate", "onResume()");
    s();
    this.d.getLifecycleChannel().appIsResumed();
    int i = b;
    if (i == 0 || i != this.c.f().hashCode()) {
      this.d.getActivityControlSurface().detachFromActivityForConfigChanges();
      this.d.getActivityControlSurface().attachToActivity(this.c.f(), this.c.getLifecycle());
      b = this.c.f().hashCode();
    } 
    XPlatformPlugin xPlatformPlugin = this.g;
    if (xPlatformPlugin != null)
      xPlatformPlugin.a(this.c.f()); 
  }
  
  public void d() {
    Log.v("FlutterActivityAndFragmentDelegate", "onPostResume()");
    s();
  }
  
  public void e() {
    Log.v("FlutterActivityAndFragmentDelegate", "onPause()");
    s();
    this.a.f();
    this.d.getLifecycleChannel().appIsInactive();
  }
  
  public void f() {
    Log.v("FlutterActivityAndFragmentDelegate", "onStop()");
    s();
  }
  
  public void g() {
    Log.v("FlutterActivityAndFragmentDelegate", "onDestroyView()");
    this.a.g();
    s();
    this.f.b();
  }
  
  public void h() {
    Log.v("FlutterActivityAndFragmentDelegate", "onDetach()");
    s();
    XPlatformPlugin xPlatformPlugin = this.g;
    if (xPlatformPlugin != null) {
      xPlatformPlugin.b(l());
      this.g = null;
    } 
    int i = b;
    if (i != 0 || i == this.c.f().hashCode())
      this.d.getActivityControlSurface().detachFromActivityForConfigChanges(); 
    Utils.a((Context)this.c.f());
  }
  
  public void i() {
    this.a.h();
    s();
  }
  
  public void j() {
    s();
    if (this.d != null) {
      Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
      this.d.getActivityControlSurface().onUserLeaveHint();
      return;
    } 
    Log.w("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before NewFlutterFragment was attached to an Activity.");
  }
  
  public void k() {
    Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onLowMemory() to FlutterEngine.");
    this.a.i();
    s();
    this.d.getSystemChannel().sendMemoryPressureWarning();
  }
  
  public Activity l() {
    return this.c.f();
  }
  
  public FlutterSplashView m() {
    return this.e;
  }
  
  public String n() {
    return this.c.i();
  }
  
  public Map o() {
    return this.c.j();
  }
  
  public void p() {}
  
  public void q() {}
  
  public static interface Host extends FlutterEngineConfigurator, FlutterEngineProvider, SplashScreenProvider {
    XPlatformPlugin a(FlutterEngine param1FlutterEngine);
    
    void configureFlutterEngine(FlutterEngine param1FlutterEngine);
    
    Activity f();
    
    FlutterView.TransparencyMode g();
    
    Context getContext();
    
    Lifecycle getLifecycle();
    
    String i();
    
    Map j();
    
    FlutterEngine provideFlutterEngine(Context param1Context);
    
    SplashScreen provideSplashScreen();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\containers\FlutterActivityAndFragmentDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */