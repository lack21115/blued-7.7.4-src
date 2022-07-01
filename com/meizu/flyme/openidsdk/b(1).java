package com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.database.Cursor;

public class b {
  public static volatile b g;
  
  public static boolean h;
  
  public OpenId a = new OpenId("udid");
  
  public OpenId b = new OpenId("oaid");
  
  public OpenId c = new OpenId("aaid");
  
  public OpenId d = new OpenId("vaid");
  
  public Boolean e;
  
  public BroadcastReceiver f;
  
  public static native ValueData a(Cursor paramCursor);
  
  public static final native b a();
  
  public static native void b(String paramString);
  
  public native OpenId a(String paramString);
  
  public final native String a(Context paramContext, OpenId paramOpenId);
  
  public final synchronized native void a(Context paramContext);
  
  public final native boolean a(Context paramContext, boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\meizu\flyme\openidsdk\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */