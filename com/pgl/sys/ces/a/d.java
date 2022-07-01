package com.pgl.sys.ces.a;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class d {
  public static int a;
  
  public static int b;
  
  public static int c;
  
  private static int d;
  
  private static int e;
  
  private static int f;
  
  public static String a(Context paramContext) {
    try {
      b(paramContext);
      c(paramContext);
      d(paramContext);
    } finally {}
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(c);
    stringBuilder.append("[<!>]");
    stringBuilder.append(a);
    stringBuilder.append("*");
    stringBuilder.append(b);
    stringBuilder.append("[<!>]");
    return stringBuilder.toString();
  }
  
  private static void b(Context paramContext) {
    try {
      Display display = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      Point point = new Point();
      if (Build.VERSION.SDK_INT >= 17) {
        display.getRealSize(point);
        a = point.x;
      } else if (Build.VERSION.SDK_INT >= 13) {
        display.getSize(point);
        a = point.x;
      } else {
        a = display.getWidth();
        int j = display.getHeight();
        b = j;
      } 
      int i = point.y;
    } finally {
      paramContext = null;
    } 
  }
  
  private static void c(Context paramContext) {
    if (paramContext == null)
      return; 
    try {
      new DisplayMetrics();
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      d = (int)displayMetrics.density;
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  private static void d(Context paramContext) {
    try {
      new DisplayMetrics();
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      e = (int)displayMetrics.xdpi;
      return;
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\ces\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */