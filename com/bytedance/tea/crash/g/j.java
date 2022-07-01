package com.bytedance.tea.crash.g;

import android.util.Log;
import com.bytedance.tea.crash.h;

public final class j {
  public static void a(String paramString) {
    if (h.e().d())
      Log.i("npth", paramString); 
  }
  
  public static void a(Throwable paramThrowable) {
    if (h.e().d())
      Log.e("npth", "NPTH Catch Error", paramThrowable); 
  }
  
  public static void b(Throwable paramThrowable) {
    if (h.e().d())
      Log.w("npth", "NPTH Catch Error", paramThrowable); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\g\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */