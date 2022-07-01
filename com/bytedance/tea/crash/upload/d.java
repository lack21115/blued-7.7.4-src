package com.bytedance.tea.crash.upload;

import android.content.Context;
import com.bytedance.tea.crash.e.h;
import com.bytedance.tea.crash.g.i;
import com.bytedance.tea.crash.h;

public final class d implements Runnable {
  private Context a;
  
  private d(Context paramContext) {
    this.a = paramContext;
  }
  
  public static void a(Context paramContext) {
    a(paramContext, 0);
  }
  
  public static void a(Context paramContext, int paramInt) {
    try {
      boolean bool = h.a().d().equals(paramContext.getPackageName());
      if (!bool)
        return; 
    } catch (Exception exception) {}
    h.b().postDelayed(new d(paramContext), paramInt);
  }
  
  public void run() {
    try {
      (new com.bytedance.tea.crash.e.d(this.a)).a(i.b(this.a));
    } finally {
      null = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\cras\\upload\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */