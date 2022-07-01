package com.idlefish.flutterboost;

import android.content.Intent;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import java.util.HashMap;
import java.util.Map;

public class ContainerRecord implements IContainerRecord {
  private final FlutterViewContainerManager a;
  
  private final IFlutterViewContainer b;
  
  private final String c;
  
  private int d = 0;
  
  private MethodChannelProxy e = new MethodChannelProxy();
  
  ContainerRecord(FlutterViewContainerManager paramFlutterViewContainerManager, IFlutterViewContainer paramIFlutterViewContainer) {
    Map map = paramIFlutterViewContainer.o();
    if (map != null && map.containsKey("__container_uniqueId_key__")) {
      this.c = String.valueOf(map.get("__container_uniqueId_key__"));
    } else {
      this.c = a(this);
    } 
    this.a = paramFlutterViewContainerManager;
    this.b = paramIFlutterViewContainer;
  }
  
  public static String a(Object paramObject) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("-");
    stringBuilder.append(paramObject.hashCode());
    return stringBuilder.toString();
  }
  
  public String a() {
    return this.c;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt1, int paramInt2, Map<String, Object> paramMap) {
    this.a.a(this, paramInt1, paramInt2, paramMap);
  }
  
  public void a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {}
  
  public void a(Intent paramIntent) {}
  
  public IFlutterViewContainer b() {
    return this.b;
  }
  
  public int c() {
    return this.d;
  }
  
  public void d() {
    Utils.a();
    if (this.d != 0)
      Debuger.b("state error"); 
    this.d = 1;
    MethodChannelProxy.a(this.e);
  }
  
  public void e() {
    Utils.a();
    int i = this.d;
    if (i != 1 && i != 3)
      Debuger.b("state error"); 
    this.d = 2;
    this.a.a(this);
    MethodChannelProxy.b(this.e);
    this.b.m().a();
  }
  
  public void f() {
    Utils.a();
    if (this.d != 2)
      Debuger.b("state error"); 
    this.d = 3;
    MethodChannelProxy.c(this.e);
    if (b().l().isFinishing())
      MethodChannelProxy.d(this.e); 
    this.b.m().b();
    this.a.b(this);
  }
  
  public void g() {
    Utils.a();
    if (this.d != 3)
      Debuger.b("state error"); 
    this.d = 4;
    MethodChannelProxy.d(this.e);
    this.a.c(this);
    this.a.a(this, -1, -1, (Map<String, Object>)null);
    this.a.c();
  }
  
  public void h() {
    Utils.a();
    int i = this.d;
    if (i == 0 || i == 4)
      Debuger.b("state error"); 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("type", "backPressedCallback");
    hashMap.put("name", this.b.n());
    hashMap.put("uniqueId", this.c);
    FlutterBoost.a().e().a("lifecycle", hashMap);
  }
  
  public void i() {}
  
  class MethodChannelProxy {
    private int b = 0;
    
    private MethodChannelProxy(ContainerRecord this$0) {}
    
    private void a() {
      if (this.b == 0) {
        b("didInitPageContainer", ContainerRecord.a(this.a).n(), ContainerRecord.a(this.a).o(), ContainerRecord.b(this.a));
        this.b = 1;
      } 
    }
    
    private void b() {
      b("didShowPageContainer", ContainerRecord.a(this.a).n(), ContainerRecord.a(this.a).o(), ContainerRecord.b(this.a));
      this.b = 2;
    }
    
    private void c() {
      if (this.b < 3) {
        a("didDisappearPageContainer", ContainerRecord.a(this.a).n(), ContainerRecord.a(this.a).o(), ContainerRecord.b(this.a));
        this.b = 3;
      } 
    }
    
    private void d() {
      if (this.b < 4) {
        a("willDeallocPageContainer", ContainerRecord.a(this.a).n(), ContainerRecord.a(this.a).o(), ContainerRecord.b(this.a));
        this.b = 4;
      } 
    }
    
    public void a(String param1String1, String param1String2, Map param1Map, String param1String3) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("pageName", param1String2);
      hashMap.put("params", param1Map);
      hashMap.put("uniqueId", param1String3);
      FlutterBoost.a().e().b(param1String1, hashMap);
    }
    
    public void b(String param1String1, String param1String2, Map param1Map, String param1String3) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("pageName", param1String2);
      hashMap.put("params", param1Map);
      hashMap.put("uniqueId", param1String3);
      FlutterBoost.a().e().a(param1String1, hashMap);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\ContainerRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */