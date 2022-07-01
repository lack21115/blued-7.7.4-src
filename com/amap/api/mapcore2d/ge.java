package com.amap.api.mapcore2d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationOption;

public final class ge extends Handler {
  gd a = null;
  
  public ge() {}
  
  public ge(Looper paramLooper, gd paramgd) {
    super(paramLooper);
    this.a = paramgd;
  }
  
  public final void handleMessage(Message paramMessage) {
    String str;
    Exception exception;
    switch (paramMessage.what) {
      default:
        return;
      case 1007:
        try {
          return;
        } finally {
          paramMessage = null;
          gu.a((Throwable)paramMessage, "ClientActionHandler", "ACTION_DESTROY");
        } 
      case 1006:
        try {
          return;
        } finally {
          exception = null;
        } 
        gu.a(exception, "ClientActionHandler", str);
        return;
      case 1005:
        try {
          return;
        } finally {
          exception = null;
        } 
        gu.a(exception, "ClientActionHandler", str);
        return;
      case 1004:
        try {
          return;
        } finally {
          exception = null;
        } 
        gu.a(exception, "ClientActionHandler", str);
        return;
      case 1003:
        try {
          Inner_3dMap_locationListener inner_3dMap_locationListener = (Inner_3dMap_locationListener)((Message)str).obj;
          return;
        } finally {
          exception = null;
        } 
        gu.a(exception, "ClientActionHandler", str);
        return;
      case 1002:
        try {
          Inner_3dMap_locationListener inner_3dMap_locationListener = (Inner_3dMap_locationListener)((Message)str).obj;
          return;
        } finally {
          exception = null;
        } 
        gu.a(exception, "ClientActionHandler", str);
        return;
      case 1001:
        break;
    } 
    try {
      Inner_3dMap_locationOption inner_3dMap_locationOption = (Inner_3dMap_locationOption)((Message)str).obj;
      return;
    } finally {
      exception = null;
    } 
    gu.a(exception, "ClientActionHandler", str);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */