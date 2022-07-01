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
      Class<?> clazz = b;
      throw new VerifyError("bad dex opcode");
    } catch (Exception exception) {
      com.bun.lib.a.a("IdentifierManager", "reflect exception!", exception);
      try {
        if (b != null) {
          Class<?> clazz = b;
          throw new VerifyError("bad dex opcode");
        } 
      } catch (Exception exception1) {
        com.bun.lib.a.a("IdentifierManager", "reflect exception!", exception1);
      } 
      try {
        if (b != null) {
          Class<?> clazz = b;
          throw new VerifyError("bad dex opcode");
        } 
      } catch (Exception exception1) {
        com.bun.lib.a.a("IdentifierManager", "reflect exception!", exception1);
      } 
      try {
        if (b != null) {
          Class<?> clazz = b;
          throw new VerifyError("bad dex opcode");
        } 
      } catch (Exception exception1) {
        com.bun.lib.a.a("IdentifierManager", "reflect exception!", exception1);
      } 
    } 
  }
  
  public static String a(Context paramContext) {
    return a(paramContext, e);
  }
  
  private static String a(Context paramContext, Method paramMethod) {
    Object object = a;
    if (object != null && paramMethod != null)
      try {
        Object object1 = paramMethod.invoke(object, new Object[] { paramContext });
        if (object1 != null)
          return (String)object1; 
      } catch (Exception exception) {
        com.bun.lib.a.a("IdentifierManager", "invoke exception!", exception);
      }  
    return null;
  }
  
  public static boolean a() {
    return (b != null && a != null);
  }
  
  public static String b(Context paramContext) {
    return a(paramContext, c);
  }
  
  public static String c(Context paramContext) {
    return a(paramContext, d);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\k\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */