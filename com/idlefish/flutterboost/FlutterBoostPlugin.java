package com.idlefish.flutterboost;

import android.util.Log;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FlutterBoostPlugin {
  private static FlutterBoostPlugin a;
  
  private static final Set<ActionAfterRegistered> e = new HashSet<ActionAfterRegistered>();
  
  private final MethodChannel b;
  
  private final Set<MethodChannel.MethodCallHandler> c = new HashSet<MethodChannel.MethodCallHandler>();
  
  private final Map<String, Set<EventListener>> d = new HashMap<String, Set<EventListener>>();
  
  private FlutterBoostPlugin(PluginRegistry.Registrar paramRegistrar) {
    this.b = new MethodChannel(paramRegistrar.messenger(), "flutter_boost");
    this.b.setMethodCallHandler(new MethodChannel.MethodCallHandler(this) {
          public void onMethodCall(MethodCall param1MethodCall, MethodChannel.Result param1Result) {
            String str;
            boolean bool = param1MethodCall.method.equals("__event__");
            int j = 0;
            int i = 0;
            if (bool) {
              str = (String)param1MethodCall.argument("name");
              Map map = (Map)param1MethodCall.argument("arguments");
              param1MethodCall = null;
              synchronized (FlutterBoostPlugin.a(this.a)) {
                Object[] arrayOfObject;
                Set set = (Set)FlutterBoostPlugin.a(this.a).get(str);
                if (set != null)
                  arrayOfObject = set.toArray(); 
                if (arrayOfObject != null) {
                  j = arrayOfObject.length;
                  while (i < j) {
                    ((FlutterBoostPlugin.EventListener)arrayOfObject[i]).a(str, map);
                    i++;
                  } 
                } 
              } 
            } else {
              synchronized (FlutterBoostPlugin.b(this.a)) {
                Object[] arrayOfObject = FlutterBoostPlugin.b(this.a).toArray();
                int k = arrayOfObject.length;
                for (i = j; i < k; i++)
                  ((MethodChannel.MethodCallHandler)arrayOfObject[i]).onMethodCall(param1MethodCall, (MethodChannel.Result)str); 
                return;
              } 
            } 
          }
        });
    a(new BoostMethodHandler(this));
  }
  
  public static FlutterBoostPlugin a() {
    FlutterBoostPlugin flutterBoostPlugin = a;
    if (flutterBoostPlugin != null)
      return flutterBoostPlugin; 
    throw new RuntimeException("FlutterBoostPlugin not register yet");
  }
  
  public static void a(PluginRegistry.Registrar paramRegistrar) {
    a = new FlutterBoostPlugin(paramRegistrar);
    Iterator<ActionAfterRegistered> iterator = e.iterator();
    while (iterator.hasNext())
      ((ActionAfterRegistered)iterator.next()).a(a); 
    e.clear();
  }
  
  public void a(MethodChannel.MethodCallHandler paramMethodCallHandler) {
    synchronized (this.c) {
      this.c.add(paramMethodCallHandler);
      return;
    } 
  }
  
  public void a(String paramString, Serializable paramSerializable) {
    a(paramString, paramSerializable, new MethodChannel.Result(this, paramString) {
          public void error(String param1String1, String param1String2, Object param1Object) {
            param1Object = new StringBuilder();
            param1Object.append("invoke method ");
            param1Object.append(this.a);
            param1Object.append(" error:");
            param1Object.append(param1String1);
            param1Object.append(" | ");
            param1Object.append(param1String2);
            Debuger.a(param1Object.toString());
          }
          
          public void notImplemented() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invoke method ");
            stringBuilder.append(this.a);
            stringBuilder.append(" notImplemented");
            Debuger.a(stringBuilder.toString());
          }
          
          public void success(Object param1Object) {}
        });
  }
  
  public void a(String paramString, Serializable paramSerializable, MethodChannel.Result paramResult) {
    if ("__event__".equals(paramString))
      Debuger.b("method name should not be __event__"); 
    this.b.invokeMethod(paramString, paramSerializable, paramResult);
  }
  
  public void a(String paramString, Map paramMap) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("name", paramString);
    hashMap.put("arguments", paramMap);
    this.b.invokeMethod("__event__", hashMap);
  }
  
  public void b(String paramString, Serializable paramSerializable) {
    a(paramString, paramSerializable, new MethodChannel.Result(this, paramString) {
          public void error(String param1String1, String param1String2, Object param1Object) {
            param1Object = new StringBuilder();
            param1Object.append("invoke method ");
            param1Object.append(this.a);
            param1Object.append(" error:");
            param1Object.append(param1String1);
            param1Object.append(" | ");
            param1Object.append(param1String2);
            Debuger.b(param1Object.toString());
          }
          
          public void notImplemented() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invoke method ");
            stringBuilder.append(this.a);
            stringBuilder.append(" notImplemented");
            Debuger.b(stringBuilder.toString());
          }
          
          public void success(Object param1Object) {}
        });
  }
  
  public static interface ActionAfterRegistered {
    void a(FlutterBoostPlugin param1FlutterBoostPlugin);
  }
  
  class BoostMethodHandler implements MethodChannel.MethodCallHandler {
    BoostMethodHandler(FlutterBoostPlugin this$0) {}
    
    public void onMethodCall(MethodCall param1MethodCall, MethodChannel.Result param1Result) {
      FlutterViewContainerManager flutterViewContainerManager = (FlutterViewContainerManager)FlutterBoost.a().c();
      String str = param1MethodCall.method;
      int i = str.hashCode();
      Boolean bool = Boolean.valueOf(true);
      switch (i) {
        default:
          i = -1;
          break;
        case 1791664180:
          if (str.equals("pageOnStart")) {
            i = 0;
            break;
          } 
        case -482608985:
          if (str.equals("closePage")) {
            i = 2;
            break;
          } 
        case -504772615:
          if (str.equals("openPage")) {
            i = 1;
            break;
          } 
        case -1037220475:
          if (str.equals("onShownContainerChanged")) {
            i = 3;
            break;
          } 
      } 
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              param1Result.notImplemented();
              return;
            } 
            try {
              return;
            } finally {
              param1MethodCall = null;
              param1Result.error("onShownContainerChanged", param1MethodCall.getMessage(), Log.getStackTraceString((Throwable)param1MethodCall));
            } 
          } 
          try {
            return;
          } finally {
            param1MethodCall = null;
            param1Result.error("close page error", param1MethodCall.getMessage(), Log.getStackTraceString((Throwable)param1MethodCall));
          } 
        } 
        try {
          Map<String, Object> map1 = (Map)param1MethodCall.argument("urlParams");
          return;
        } finally {
          param1MethodCall = null;
          param1Result.error("open page error", param1MethodCall.getMessage(), Log.getStackTraceString((Throwable)param1MethodCall));
        } 
      } 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      try {
        IContainerRecord iContainerRecord2 = flutterViewContainerManager.a();
        IContainerRecord iContainerRecord1 = iContainerRecord2;
        if (iContainerRecord2 == null)
          iContainerRecord1 = flutterViewContainerManager.b(); 
        if (iContainerRecord1 != null) {
          hashMap.put("name", iContainerRecord1.b().n());
          hashMap.put("params", iContainerRecord1.b().o());
          hashMap.put("uniqueId", iContainerRecord1.a());
        } 
        return;
      } finally {
        param1MethodCall = null;
        param1Result.error("no flutter page found!", param1MethodCall.getMessage(), Log.getStackTraceString((Throwable)param1MethodCall));
      } 
    }
  }
  
  class null implements FlutterViewContainerManager.OnResult {
    null(FlutterBoostPlugin this$0, MethodChannel.Result param1Result) {}
    
    public void a(Map<String, Object> param1Map) {
      MethodChannel.Result result = this.a;
      if (result != null)
        result.success(param1Map); 
    }
  }
  
  public static interface EventListener {
    void a(String param1String, Map param1Map);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\FlutterBoostPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */