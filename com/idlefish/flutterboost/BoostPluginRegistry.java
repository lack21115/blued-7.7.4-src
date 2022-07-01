package com.idlefish.flutterboost;

import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BoostPluginRegistry implements PluginRegistry {
  private final Map<String, Object> a;
  
  private final BoostRegistrarAggregate b;
  
  public boolean hasPlugin(String paramString) {
    return this.a.containsKey(paramString);
  }
  
  public PluginRegistry.Registrar registrarFor(String paramString) {
    BoostRegistrar boostRegistrar;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Creating plugin Registrar for '");
    stringBuilder.append(paramString);
    stringBuilder.append("'");
    Log.v("ShimPluginRegistry", stringBuilder.toString());
    if (!this.a.containsKey(paramString)) {
      this.a.put(paramString, null);
      boostRegistrar = new BoostRegistrar(paramString, this.a);
      this.b.a(boostRegistrar);
      return boostRegistrar;
    } 
    stringBuilder = new StringBuilder();
    stringBuilder.append("Plugin key ");
    stringBuilder.append((String)boostRegistrar);
    stringBuilder.append(" is already in use");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public Object valuePublishedByPlugin(String paramString) {
    return this.a.get(paramString);
  }
  
  public static class BoostRegistrarAggregate implements FlutterPlugin, ActivityAware {
    private final Set<BoostRegistrar> a = new HashSet<BoostRegistrar>();
    
    private FlutterPlugin.FlutterPluginBinding b;
    
    private ActivityPluginBinding c;
    
    public void a(BoostRegistrar param1BoostRegistrar) {
      this.a.add(param1BoostRegistrar);
      FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.b;
      if (flutterPluginBinding != null)
        param1BoostRegistrar.onAttachedToEngine(flutterPluginBinding); 
      ActivityPluginBinding activityPluginBinding = this.c;
      if (activityPluginBinding != null)
        param1BoostRegistrar.onAttachedToActivity(activityPluginBinding); 
    }
    
    public void onAttachedToActivity(ActivityPluginBinding param1ActivityPluginBinding) {
      this.c = param1ActivityPluginBinding;
      Iterator<BoostRegistrar> iterator = this.a.iterator();
      while (iterator.hasNext())
        ((BoostRegistrar)iterator.next()).onAttachedToActivity(param1ActivityPluginBinding); 
    }
    
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding param1FlutterPluginBinding) {
      this.b = param1FlutterPluginBinding;
      Iterator<BoostRegistrar> iterator = this.a.iterator();
      while (iterator.hasNext())
        ((BoostRegistrar)iterator.next()).onAttachedToEngine(param1FlutterPluginBinding); 
    }
    
    public void onDetachedFromActivity() {
      Iterator<BoostRegistrar> iterator = this.a.iterator();
      while (iterator.hasNext())
        ((BoostRegistrar)iterator.next()).onDetachedFromActivity(); 
    }
    
    public void onDetachedFromActivityForConfigChanges() {
      Iterator<BoostRegistrar> iterator = this.a.iterator();
      while (iterator.hasNext())
        ((BoostRegistrar)iterator.next()).onDetachedFromActivity(); 
      this.c = null;
    }
    
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding param1FlutterPluginBinding) {
      Iterator<BoostRegistrar> iterator = this.a.iterator();
      while (iterator.hasNext())
        ((BoostRegistrar)iterator.next()).onDetachedFromEngine(param1FlutterPluginBinding); 
      this.b = null;
    }
    
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding param1ActivityPluginBinding) {
      Iterator<BoostRegistrar> iterator = this.a.iterator();
      while (iterator.hasNext())
        ((BoostRegistrar)iterator.next()).onReattachedToActivityForConfigChanges(param1ActivityPluginBinding); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\BoostPluginRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */