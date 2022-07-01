package com.bun.miitmdid.c.k;

import android.content.Context;
import java.lang.reflect.Method;

public class a {
  private static Object a;
  
  private static Class<?> b;
  
  private static Method c;
  
  private static Method d;
  
  private static Method e;
  
  static {
    try {
      b = Class.forName("com.android.id.impl.IdProviderImpl");
      a = b.newInstance();
    } catch (Exception exception) {
      com.bun.lib.a.a("IdentifierManager", "reflect exception!", exception);
    } 
    try {
      if (b != null)
        c = b.getMethod("getOAID", new Class[] { Context.class }); 
    } catch (Exception exception) {
      com.bun.lib.a.a("IdentifierManager", "reflect exception!", exception);
    } 
    try {
      if (b != null)
        d = b.getMethod("getVAID", new Class[] { Context.class }); 
    } catch (Exception exception) {
      com.bun.lib.a.a("IdentifierManager", "reflect exception!", exception);
    } 
    try {
      if (b != null) {
        e = b.getMethod("getAAID", new Class[] { Context.class });
        return;
      } 
    } catch (Exception exception) {
      com.bun.lib.a.a("IdentifierManager", "reflect exception!", exception);
    } 
  }
  
  public static native String a(Context paramContext);
  
  private static native String a(Context paramContext, Method paramMethod);
  
  public static native boolean a();
  
  public static native String b(Context paramContext);
  
  public static native String c(Context paramContext);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\miitmdid\c\k\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */