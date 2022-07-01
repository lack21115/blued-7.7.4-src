package com.amap.api.maps2d;

import android.content.Context;
import android.os.RemoteException;
import com.amap.api.mapcore2d.ar;
import com.amap.api.mapcore2d.cs;
import com.amap.api.mapcore2d.cw;
import com.amap.api.mapcore2d.q;

public final class MapsInitializer {
  public static final int HTTP = 1;
  
  public static final int HTTPS = 2;
  
  private static boolean a = true;
  
  private static boolean b = false;
  
  private static int c = 1;
  
  public static String sdcardDir = "";
  
  public static boolean getNetworkEnable() {
    return a;
  }
  
  public static int getProtocol() {
    return c;
  }
  
  public static boolean getUpdateDataActiveEnable() {
    return b;
  }
  
  public static String getVersion() {
    return "6.0.0";
  }
  
  public static void initialize(Context paramContext) throws RemoteException {
    if (paramContext != null)
      ar.a = paramContext.getApplicationContext(); 
  }
  
  public static void loadWorldGridMap(boolean paramBoolean) {
    q.i = paramBoolean ^ true;
  }
  
  public static void replaceURL(String paramString1, String paramString2) {
    if (paramString1 != null) {
      if (paramString1.equals(""))
        return; 
      q.h = paramString1;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append("DIY");
      q.g = stringBuilder.toString();
      if (paramString1.contains("openstreetmap"))
        q.c = 19; 
    } 
  }
  
  public static void setApiKey(String paramString) {
    cs.a(paramString);
  }
  
  public static void setNetworkEnable(boolean paramBoolean) {
    a = paramBoolean;
  }
  
  public static void setProtocol(int paramInt) {
    boolean bool;
    c = paramInt;
    cw cw = cw.a();
    if (c == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    cw.a(bool);
  }
  
  public static void setUpdateDataActiveEnable(boolean paramBoolean) {
    b = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\MapsInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */