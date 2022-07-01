package com.bytedance.sdk.openadsdk.h.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.o;
import java.lang.reflect.Method;

public class c {
  private static c e;
  
  private Context a = null;
  
  private Object b = null;
  
  private Method c = null;
  
  private Method d = null;
  
  private c() {
    this.a = o.a();
    Context context = this.a;
    if (context != null) {
      this.b = context.getSystemService("storage");
      try {
        this.c = this.b.getClass().getMethod("getVolumeList", new Class[0]);
        this.d = this.b.getClass().getMethod("getVolumeState", new Class[] { String.class });
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
  }
  
  public static c a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/h/g/c.e : Lcom/bytedance/sdk/openadsdk/h/g/c;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/h/g/c
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/h/g/c.e : Lcom/bytedance/sdk/openadsdk/h/g/c;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/h/g/c
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/h/g/c.e : Lcom/bytedance/sdk/openadsdk/h/g/c;
    //   25: ldc com/bytedance/sdk/openadsdk/h/g/c
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/h/g/c
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/h/g/c.e : Lcom/bytedance/sdk/openadsdk/h/g/c;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public boolean b() {
    Object object = this.b;
    if (object != null) {
      Method method = this.c;
      if (method != null) {
        if (this.d == null)
          return false; 
        try {
          object = method.invoke(object, new Object[0]);
          if (object != null) {
            if (object.length == 0)
              return false; 
            method = object[0].getClass().getMethod("getPath", new Class[0]);
            Method method1 = object[0].getClass().getMethod("isEmulated", new Class[0]);
            if (method != null) {
              if (method1 == null)
                return false; 
              int j = object.length;
              for (int i = 0; i < j; i++) {
                Object object1 = object[i];
                if (((Boolean)method1.invoke(object1, new Object[0])).booleanValue()) {
                  object1 = method.invoke(object1, new Object[0]);
                  boolean bool = this.d.invoke(this.b, new Object[] { object1 }).equals("mounted");
                  if (bool)
                    return true; 
                } 
              } 
            } else {
              return false;
            } 
          } else {
            return false;
          } 
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      } 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */