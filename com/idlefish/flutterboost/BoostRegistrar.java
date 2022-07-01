package com.idlefish.flutterboost;

import android.app.Activity;
import android.content.Context;
import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class BoostRegistrar implements FlutterPlugin, ActivityAware, PluginRegistry.Registrar {
  private final Map<String, Object> a;
  
  private final String b;
  
  private final Set<PluginRegistry.ViewDestroyListener> c = new HashSet<PluginRegistry.ViewDestroyListener>();
  
  private final Set<PluginRegistry.RequestPermissionsResultListener> d = new HashSet<PluginRegistry.RequestPermissionsResultListener>();
  
  private final Set<PluginRegistry.ActivityResultListener> e = new HashSet<PluginRegistry.ActivityResultListener>();
  
  private final Set<PluginRegistry.NewIntentListener> f = new HashSet<PluginRegistry.NewIntentListener>();
  
  private final Set<PluginRegistry.UserLeaveHintListener> g = new HashSet<PluginRegistry.UserLeaveHintListener>();
  
  private FlutterPlugin.FlutterPluginBinding h;
  
  private ActivityPluginBinding i;
  
  public BoostRegistrar(String paramString, Map<String, Object> paramMap) {
    this.b = paramString;
    this.a = paramMap;
  }
  
  private void a() {
    for (PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener : this.d)
      this.i.addRequestPermissionsResultListener(requestPermissionsResultListener); 
    for (PluginRegistry.ActivityResultListener activityResultListener : this.e)
      this.i.addActivityResultListener(activityResultListener); 
    for (PluginRegistry.NewIntentListener newIntentListener : this.f)
      this.i.addOnNewIntentListener(newIntentListener); 
    for (PluginRegistry.UserLeaveHintListener userLeaveHintListener : this.g)
      this.i.addOnUserLeaveHintListener(userLeaveHintListener); 
  }
  
  public Context activeContext() {
    return (Context)((this.i == null) ? context() : activity());
  }
  
  public Activity activity() {
    ActivityPluginBinding activityPluginBinding = this.i;
    return (activityPluginBinding != null) ? activityPluginBinding.getActivity() : ((FlutterBoost.a().f() != null) ? FlutterBoost.a().f() : null);
  }
  
  public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener paramActivityResultListener) {
    this.e.add(paramActivityResultListener);
    ActivityPluginBinding activityPluginBinding = this.i;
    if (activityPluginBinding != null)
      activityPluginBinding.addActivityResultListener(paramActivityResultListener); 
    return this;
  }
  
  public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener paramNewIntentListener) {
    this.f.add(paramNewIntentListener);
    ActivityPluginBinding activityPluginBinding = this.i;
    if (activityPluginBinding != null)
      activityPluginBinding.addOnNewIntentListener(paramNewIntentListener); 
    return this;
  }
  
  public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener) {
    this.d.add(paramRequestPermissionsResultListener);
    ActivityPluginBinding activityPluginBinding = this.i;
    if (activityPluginBinding != null)
      activityPluginBinding.addRequestPermissionsResultListener(paramRequestPermissionsResultListener); 
    return this;
  }
  
  public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener) {
    this.g.add(paramUserLeaveHintListener);
    ActivityPluginBinding activityPluginBinding = this.i;
    if (activityPluginBinding != null)
      activityPluginBinding.addOnUserLeaveHintListener(paramUserLeaveHintListener); 
    return this;
  }
  
  public PluginRegistry.Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener paramViewDestroyListener) {
    this.c.add(paramViewDestroyListener);
    return this;
  }
  
  public Context context() {
    FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.h;
    return (flutterPluginBinding != null) ? flutterPluginBinding.getApplicationContext() : null;
  }
  
  public String lookupKeyForAsset(String paramString) {
    return FlutterMain.getLookupKeyForAsset(paramString);
  }
  
  public String lookupKeyForAsset(String paramString1, String paramString2) {
    return FlutterMain.getLookupKeyForAsset(paramString1, paramString2);
  }
  
  public BinaryMessenger messenger() {
    FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.h;
    return (BinaryMessenger)((flutterPluginBinding != null) ? flutterPluginBinding.getFlutterEngine().getDartExecutor() : null);
  }
  
  public void onAttachedToActivity(ActivityPluginBinding paramActivityPluginBinding) {
    Log.v("ShimRegistrar", "Attached to an Activity.");
    this.i = paramActivityPluginBinding;
    a();
  }
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding) {
    Log.v("ShimRegistrar", "Attached to FlutterEngine.");
    this.h = paramFlutterPluginBinding;
  }
  
  public void onDetachedFromActivity() {
    Log.v("ShimRegistrar", "Detached from an Activity.");
    this.i = null;
  }
  
  public void onDetachedFromActivityForConfigChanges() {
    Log.v("ShimRegistrar", "Detached from an Activity for config changes.");
    this.i = null;
  }
  
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding) {
    Log.v("ShimRegistrar", "Detached from FlutterEngine.");
    Iterator<PluginRegistry.ViewDestroyListener> iterator = this.c.iterator();
    while (iterator.hasNext())
      ((PluginRegistry.ViewDestroyListener)iterator.next()).onViewDestroy((FlutterNativeView)null); 
    this.h = null;
  }
  
  public void onReattachedToActivityForConfigChanges(ActivityPluginBinding paramActivityPluginBinding) {
    Log.v("ShimRegistrar", "Reconnected to an Activity after config changes.");
    this.i = paramActivityPluginBinding;
    a();
  }
  
  public PlatformViewRegistry platformViewRegistry() {
    FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.h;
    return (flutterPluginBinding != null) ? flutterPluginBinding.getFlutterEngine().getPlatformViewsController().getRegistry() : null;
  }
  
  public PluginRegistry.Registrar publish(Object paramObject) {
    this.a.put(this.b, paramObject);
    return this;
  }
  
  public TextureRegistry textures() {
    FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.h;
    return (TextureRegistry)((flutterPluginBinding != null) ? flutterPluginBinding.getFlutterEngine().getRenderer() : null);
  }
  
  public FlutterView view() {
    throw new UnsupportedOperationException("The new embedding does not support the old FlutterView.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\BoostRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */