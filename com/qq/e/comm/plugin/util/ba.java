package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.qq.e.comm.managers.GDTADManager;

public class ba {
  private static Toast a;
  
  private static TextView b;
  
  private static void a(Context paramContext) {
    b = new TextView(paramContext);
    b.setPadding(am.a(paramContext, 20), am.a(paramContext, 12), am.a(paramContext, 20), am.a(paramContext, 12));
    b.setTextColor(-1);
    b.setTextSize(2, 16.0F);
    b.setBackgroundDrawable((Drawable)ar.a(60.0F, -16777216, 100));
    a = new Toast(paramContext);
    a.setGravity(17, 0, 0);
    a.setView((View)b);
  }
  
  private static void a(Context paramContext, String paramString) {
    if (b == null || a == null)
      a(paramContext); 
    b.setText(paramString);
  }
  
  public static void a(String paramString) {
    y.a(new Runnable(paramString) {
          public void run() {
            try {
              return;
            } finally {
              Exception exception = null;
            } 
          }
        });
  }
  
  public static void b(String paramString) {
    a(GDTADManager.getInstance().getAppContext(), paramString);
    a.setDuration(0);
    a.show();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */