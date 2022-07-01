package com.amap.api.mapcore2d;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationOption;

public class cn {
  Context a;
  
  Inner_3dMap_locationManagerBase b = null;
  
  Object c = null;
  
  boolean d = false;
  
  gb e = null;
  
  da f = null;
  
  public cn(Context paramContext) {
    try {
      this.f = gk.a();
    } finally {
      Exception exception;
    } 
    this.e = new gb();
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    if (paramContext != null)
      try {
        this.a = paramContext.getApplicationContext();
        try {
          ServiceInfo serviceInfo;
          Class<?> clazz = Class.forName("com.amap.api.location.AMapLocationClient");
          ComponentName componentName = new ComponentName(this.a, "com.amap.api.location.APSService");
          paramContext = null;
          try {
            ServiceInfo serviceInfo1 = this.a.getPackageManager().getServiceInfo(componentName, 128);
            serviceInfo = serviceInfo1;
          } finally {}
        } finally {
          paramContext = null;
        } 
        return;
      } finally {
        paramContext = null;
        gu.a((Throwable)paramContext, "AMapLocationClient", "AMapLocationClient 1");
      }  
    throw new IllegalArgumentException("Context参数不能为null");
  }
  
  private Inner_3dMap_locationManagerBase b(Context paramContext) {
    Inner_3dMap_locationManagerBase inner_3dMap_locationManagerBase1;
    Inner_3dMap_locationManagerBase inner_3dMap_locationManagerBase2;
    try {
      inner_3dMap_locationManagerBase1 = ef.<Inner_3dMap_locationManagerBase>a(paramContext, this.f, db.c("YY29tLmFtYXAuYXBpLndyYXBwZXIuSW5uZXJfM2RNYXBfbG9jYXRpb25NYW5hZ2VyV3JhcHBlcg=="), gd.class, new Class[] { Context.class }, new Object[] { paramContext });
    } finally {
      Exception exception = null;
    } 
    if (inner_3dMap_locationManagerBase1 == null)
      inner_3dMap_locationManagerBase2 = new gd(paramContext); 
    return inner_3dMap_locationManagerBase2;
  }
  
  public void a() {
    try {
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "AMapLocationClient", "startLocation");
    } 
  }
  
  public void a(Inner_3dMap_locationListener paramInner_3dMap_locationListener) {
    if (paramInner_3dMap_locationListener != null)
      try {
        return;
      } finally {
        paramInner_3dMap_locationListener = null;
        gu.a((Throwable)paramInner_3dMap_locationListener, "AMapLocationClient", "setLocationListener");
      }  
    throw new IllegalArgumentException("listener参数不能为null");
  }
  
  public void a(Inner_3dMap_locationOption paramInner_3dMap_locationOption) {
    if (paramInner_3dMap_locationOption != null)
      try {
        return;
      } finally {
        paramInner_3dMap_locationOption = null;
        gu.a((Throwable)paramInner_3dMap_locationOption, "AMapLocationClient", "setLocationOption");
      }  
    throw new IllegalArgumentException("LocationManagerOption参数不能为null");
  }
  
  public void b() {
    try {
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "AMapLocationClient", "stopLocation");
    } 
  }
  
  public void c() {
    try {
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "AMapLocationClient", "onDestroy");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */