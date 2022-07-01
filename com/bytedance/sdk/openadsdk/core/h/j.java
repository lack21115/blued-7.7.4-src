package com.bytedance.sdk.openadsdk.core.h;

import android.util.Log;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.concurrent.atomic.AtomicInteger;

public class j {
  private static AtomicInteger a = new AtomicInteger(1);
  
  protected static void a(int paramInt) {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramInt != 1 && paramInt != 2)
      return; 
    try {
    
    } finally {
      Exception exception = null;
      paramInt = 0;
    } 
    if (paramInt != 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("switch status changed: ");
      stringBuilder.append(a());
      Log.e("SdkSwitch", stringBuilder.toString());
      if (a()) {
        o.b();
        return;
      } 
      try {
        if (o.c() != null)
          o.c().b(); 
        if (o.e() != null)
          o.e().b(); 
      } finally {
        stringBuilder = null;
      } 
      try {
      
      } finally {}
    } 
  }
  
  public static boolean a() {
    return (a.get() == 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\h\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */