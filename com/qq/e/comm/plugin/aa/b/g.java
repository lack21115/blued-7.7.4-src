package com.qq.e.comm.plugin.aa.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.qq.e.comm.managers.GDTADManager;

public class g {
  public static String a = "#80000000";
  
  public static String b = "#40000000";
  
  public static String c = "#ff8600";
  
  public static boolean d = true;
  
  private static Context e = GDTADManager.getInstance().getAppContext();
  
  public static int a(String paramString) {
    return e.getResources().getIdentifier(paramString, "drawable", e.getPackageName());
  }
  
  public static Bitmap a(Context paramContext) {
    return !d ? null : a(paramContext, a("gdt_ic_play"));
  }
  
  private static Bitmap a(Context paramContext, int paramInt) {
    return BitmapFactory.decodeResource(paramContext.getResources(), paramInt);
  }
  
  public static void a(boolean paramBoolean) {
    d = paramBoolean;
  }
  
  public static Bitmap b(Context paramContext) {
    return !d ? null : a(paramContext, a("gdt_ic_pause"));
  }
  
  public static Bitmap c(Context paramContext) {
    return !d ? null : a(paramContext, a("gdt_ic_volume_on"));
  }
  
  public static Bitmap d(Context paramContext) {
    return !d ? null : a(paramContext, a("gdt_ic_volume_off"));
  }
  
  public static Bitmap e(Context paramContext) {
    return a(paramContext, a("gdt_ic_express_close"));
  }
  
  public static Bitmap f(Context paramContext) {
    return a(paramContext, a("gdt_ic_express_back_to_port"));
  }
  
  public static Bitmap g(Context paramContext) {
    return a(paramContext, a("gdt_ic_express_volume_on"));
  }
  
  public static Bitmap h(Context paramContext) {
    return a(paramContext, a("gdt_ic_express_volume_off"));
  }
  
  public static Bitmap i(Context paramContext) {
    return a(paramContext, a("gdt_ic_express_enter_fullscreen"));
  }
  
  public static Bitmap j(Context paramContext) {
    return a(paramContext, a("gdt_ic_express_play"));
  }
  
  public static Bitmap k(Context paramContext) {
    return a(paramContext, a("gdt_ic_express_pause"));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\aa\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */