package com.qq.e.comm.plugin.d;

import android.content.Context;
import android.view.ContextThemeWrapper;
import java.lang.reflect.Method;

public class b {
  private static Class a;
  
  private static Class b;
  
  private final Context c;
  
  private Method d;
  
  static {
    try {
      a = Class.forName("androidx.appcompat.app.AppCompatActivity");
    } catch (ClassNotFoundException classNotFoundException) {
      a = null;
    } 
    try {
      b = Class.forName("androidx.appcompat.app.AppCompatActivity");
      return;
    } catch (ClassNotFoundException classNotFoundException) {
      b = null;
    } 
  }
  
  private b(Context paramContext) {
    this.c = paramContext;
    try {
      this.d = this.c.getClass().getMethod("getSupportActionBar", new Class[0]);
      return;
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
      return;
    } 
  }
  
  public static b a(Context paramContext) {
    if (paramContext != null) {
      Class clazz = a;
      if (clazz != null && clazz.isInstance(paramContext))
        return new b(paramContext); 
      clazz = b;
      if (clazz != null && clazz.isInstance(paramContext))
        return new b(paramContext); 
      if (paramContext instanceof ContextThemeWrapper)
        return a(((ContextThemeWrapper)paramContext).getBaseContext()); 
    } 
    return null;
  }
  
  public a a() {
    try {
      return new a(this.d.invoke(this.c, new Object[0]));
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */