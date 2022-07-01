package com.amap.api.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.webkit.WebView;
import com.loc.d;
import com.loc.ej;
import com.loc.n;

public class AMapLocationClient {
  Context a;
  
  d b;
  
  public AMapLocationClient(Context paramContext) {
    if (paramContext != null)
      try {
        return;
      } finally {
        paramContext = null;
        ej.a((Throwable)paramContext, "AMClt", "ne1");
      }  
    throw new IllegalArgumentException("Context参数不能为null");
  }
  
  public AMapLocationClient(Context paramContext, Intent paramIntent) {
    if (paramContext != null)
      try {
        return;
      } finally {
        paramContext = null;
        ej.a((Throwable)paramContext, "AMClt", "ne2");
      }  
    throw new IllegalArgumentException("Context参数不能为null");
  }
  
  public AMapLocationClient(Looper paramLooper, Context paramContext) {
    if (paramContext != null)
      try {
        return;
      } finally {
        paramLooper = null;
        ej.a((Throwable)paramLooper, "AMClt", "ne3");
      }  
    throw new IllegalArgumentException("Context参数不能为null");
  }
  
  public static String getDeviceId(Context paramContext) {
    return n.y(paramContext);
  }
  
  public static void setApiKey(String paramString) {
    try {
      return;
    } finally {
      paramString = null;
      ej.a((Throwable)paramString, "AMClt", "sKey");
    } 
  }
  
  public void disableBackgroundLocation(boolean paramBoolean) {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "AMClt", "dBackL");
    } 
  }
  
  public void enableBackgroundLocation(int paramInt, Notification paramNotification) {
    try {
      return;
    } finally {
      paramNotification = null;
      ej.a((Throwable)paramNotification, "AMClt", "eBackL");
    } 
  }
  
  public AMapLocation getLastKnownLocation() {
    try {
      if (this.b != null)
        return this.b.e(); 
    } finally {
      Exception exception = null;
    } 
  }
  
  public String getVersion() {
    return "5.2.0";
  }
  
  public boolean isStarted() {
    try {
      if (this.b != null)
        return this.b.a(); 
    } finally {
      Exception exception = null;
    } 
  }
  
  public void onDestroy() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "AMClt", "onDy");
    } 
  }
  
  public void setLocationListener(AMapLocationListener paramAMapLocationListener) {
    if (paramAMapLocationListener != null)
      try {
        return;
      } finally {
        paramAMapLocationListener = null;
        ej.a((Throwable)paramAMapLocationListener, "AMClt", "sLocL");
      }  
    throw new IllegalArgumentException("listener参数不能为null");
  }
  
  public void setLocationOption(AMapLocationClientOption paramAMapLocationClientOption) {
    if (paramAMapLocationClientOption != null)
      try {
        return;
      } finally {
        paramAMapLocationClientOption = null;
        ej.a((Throwable)paramAMapLocationClientOption, "AMClt", "sLocnO");
      }  
    throw new IllegalArgumentException("LocationManagerOption参数不能为null");
  }
  
  public void startAssistantLocation() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "AMClt", "stAssLo");
    } 
  }
  
  public void startAssistantLocation(WebView paramWebView) {
    try {
      return;
    } finally {
      paramWebView = null;
      ej.a((Throwable)paramWebView, "AMClt", "sttAssL1");
    } 
  }
  
  public void startLocation() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "AMClt", "stl");
    } 
  }
  
  public void stopAssistantLocation() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "AMClt", "stAssL");
    } 
  }
  
  public void stopLocation() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "AMClt", "stl");
    } 
  }
  
  public void unRegisterLocationListener(AMapLocationListener paramAMapLocationListener) {
    try {
      return;
    } finally {
      paramAMapLocationListener = null;
      ej.a((Throwable)paramAMapLocationListener, "AMClt", "unRL");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\location\AMapLocationClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */