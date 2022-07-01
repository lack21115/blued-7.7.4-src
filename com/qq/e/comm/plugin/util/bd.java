package com.qq.e.comm.plugin.util;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.WindowManager;
import com.qq.e.comm.plugin.d.a;
import com.qq.e.comm.plugin.d.b;

public class bd {
  public static Activity a(Context paramContext) {
    Activity activity = null;
    if (paramContext == null)
      return null; 
    if (paramContext instanceof Activity)
      return (Activity)paramContext; 
    if (paramContext instanceof ContextWrapper)
      activity = a(((ContextWrapper)paramContext).getBaseContext()); 
    return activity;
  }
  
  public static void a(Context paramContext, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic a : (Landroid/content/Context;)Lcom/qq/e/comm/plugin/d/b;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull -> 37
    //   9: iload_1
    //   10: iconst_4
    //   11: iand
    //   12: ifle -> 25
    //   15: iconst_1
    //   16: istore_2
    //   17: aload_3
    //   18: iload_2
    //   19: invokestatic a : (Lcom/qq/e/comm/plugin/d/b;Z)V
    //   22: goto -> 37
    //   25: iload_1
    //   26: bipush #8
    //   28: iand
    //   29: ifle -> 37
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -> 17
    //   37: aload_0
    //   38: invokestatic a : (Landroid/content/Context;)Landroid/app/Activity;
    //   41: astore_0
    //   42: aload_0
    //   43: ifnull -> 113
    //   46: aload_0
    //   47: invokevirtual getActionBar : ()Landroid/app/ActionBar;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull -> 78
    //   55: iload_1
    //   56: iconst_2
    //   57: iand
    //   58: ifle -> 68
    //   61: aload_3
    //   62: invokevirtual hide : ()V
    //   65: goto -> 78
    //   68: iload_1
    //   69: iconst_1
    //   70: iand
    //   71: ifle -> 78
    //   74: aload_3
    //   75: invokevirtual show : ()V
    //   78: iload_1
    //   79: bipush #16
    //   81: iand
    //   82: ifle -> 96
    //   85: aload_0
    //   86: invokevirtual getWindow : ()Landroid/view/Window;
    //   89: sipush #1024
    //   92: invokevirtual clearFlags : (I)V
    //   95: return
    //   96: iload_1
    //   97: bipush #32
    //   99: iand
    //   100: ifle -> 113
    //   103: aload_0
    //   104: invokevirtual getWindow : ()Landroid/view/Window;
    //   107: sipush #1024
    //   110: invokevirtual addFlags : (I)V
    //   113: return
  }
  
  private static void a(b paramb, boolean paramBoolean) {
    a a = paramb.a();
    if (a == null)
      return; 
    a.a(false);
    if (paramBoolean) {
      a.b();
      return;
    } 
    a.c();
  }
  
  public static boolean a() {
    try {
      Class.forName("com.qq.e.ads.cfg.VideoOption");
      int i = Build.VERSION.SDK_INT;
      if (i >= 14)
        return true; 
    } catch (ClassNotFoundException classNotFoundException) {}
    return false;
  }
  
  private static boolean a(b paramb) {
    a a = paramb.a();
    return (a == null) ? false : a.a();
  }
  
  public static void b(Context paramContext) {
    b b = b.a(paramContext);
    if (b != null)
      a(b, false); 
    Activity activity = a(paramContext);
    if (activity != null) {
      ActionBar actionBar = activity.getActionBar();
      if (actionBar != null)
        actionBar.hide(); 
      activity.getWindow().setFlags(1024, 1024);
    } 
  }
  
  public static boolean b() {
    return (Build.VERSION.SDK_INT >= 14);
  }
  
  public static int c(Context paramContext) {
    b b = b.a(paramContext);
    int i = 0;
    if (b != null) {
      if (a(b)) {
        i = 4;
      } else {
        i = 8;
      } 
      i = 0x0 | i;
    } 
    Activity activity = a(paramContext);
    int j = i;
    if (activity != null) {
      ActionBar actionBar = activity.getActionBar();
      int k = i;
      if (actionBar != null) {
        if (actionBar.isShowing()) {
          k = 1;
        } else {
          k = 2;
        } 
        k |= i;
      } 
      WindowManager.LayoutParams layoutParams = activity.getWindow().getAttributes();
      j = k;
      if (layoutParams != null) {
        if ((layoutParams.flags & 0x400) > 0)
          return k | 0x20; 
        j = k | 0x10;
      } 
    } 
    return j;
  }
  
  public static boolean c() {
    try {
      Class.forName("com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener");
      int i = Build.VERSION.SDK_INT;
      if (i >= 14)
        return true; 
    } catch (ClassNotFoundException classNotFoundException) {}
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */