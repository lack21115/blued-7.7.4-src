package com.blued.android.module.im.biz;

import com.blued.android.module.im.grpc.OnConnectStateListener;
import com.google.protobuf.Any;

public class IMConnectorDebuger {
  private static String a;
  
  private static long b;
  
  private static OnConnectStateListener c = new OnConnectStateListener() {
      public void onConnected() {
        IMConnectorDebuger.a("connector connected");
      }
      
      public void onConnecting() {
        IMConnectorDebuger.a("connector connecting");
      }
      
      public void onDisconnected() {
        IMConnectorDebuger.a("connector disconnected");
      }
      
      public void onReceive(Any param1Any) {}
    };
  
  public static OnConnectStateListener a() {
    return c;
  }
  
  public static void a(String paramString) {
    a = paramString;
  }
  
  public static void b() {
    b = System.currentTimeMillis();
  }
  
  public static String c() {
    return a;
  }
  
  public static String d() {
    if (b == 0L)
      return "No Message"; 
    long l = (System.currentTimeMillis() - b) / 1000L;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(l);
    stringBuilder.append(" seconds ago");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\im\biz\IMConnectorDebuger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */