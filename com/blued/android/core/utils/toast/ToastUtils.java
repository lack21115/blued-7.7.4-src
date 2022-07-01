package com.blued.android.core.utils.toast;

import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public final class ToastUtils {
  private static IToastInterceptor a;
  
  private static IToastStrategy b;
  
  private static IToastStyle c;
  
  private static Toast d;
  
  public static TextView a(Context paramContext) {
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setColor(c.i());
    gradientDrawable.setCornerRadius(c.h());
    TextView textView = new TextView(paramContext);
    textView.setId(16908299);
    textView.setTextColor(c.j());
    textView.setTextSize(0, c.k());
    if (Build.VERSION.SDK_INT >= 16) {
      textView.setPaddingRelative(c.l(), c.m(), c.f(), c.g());
    } else {
      textView.setPadding(c.l(), c.m(), c.f(), c.g());
    } 
    textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    if (Build.VERSION.SDK_INT >= 16) {
      textView.setBackground((Drawable)gradientDrawable);
    } else {
      textView.setBackgroundDrawable((Drawable)gradientDrawable);
    } 
    if (Build.VERSION.SDK_INT >= 21)
      textView.setZ(c.d()); 
    if (c.e() > 0)
      textView.setMaxLines(c.e()); 
    return textView;
  }
  
  private static void a() {
    if (d != null)
      return; 
    throw new IllegalStateException("ToastUtils has not been initialized");
  }
  
  public static void a(int paramInt1, int paramInt2) {
    a();
    try {
      a(d.getView().getContext().getResources().getText(paramInt1), paramInt2);
      return;
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      a(String.valueOf(paramInt1), paramInt2);
      return;
    } 
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3) {
    a();
    int i = paramInt1;
    if (Build.VERSION.SDK_INT >= 17)
      i = Gravity.getAbsoluteGravity(paramInt1, d.getView().getResources().getConfiguration().getLayoutDirection()); 
    d.setGravity(i, paramInt2, paramInt3);
  }
  
  public static void a(Application paramApplication) {
    a(paramApplication);
    if (a == null)
      a(new ToastInterceptor()); 
    if (b == null)
      a(new ToastStrategy()); 
    if (c == null)
      a(new ToastStyle((Context)paramApplication)); 
    if (b((Context)paramApplication)) {
      if (Build.VERSION.SDK_INT == 25) {
        a(new SafeToast(paramApplication));
      } else {
        a(new BaseToast(paramApplication));
      } 
    } else {
      a(new SupportToast(paramApplication));
    } 
    a((View)a(paramApplication.getApplicationContext()));
    a(c.a(), c.b(), c.c());
  }
  
  public static void a(View paramView) {
    a();
    a(paramView);
    if (paramView.getContext() instanceof Application) {
      Toast toast = d;
      if (toast != null) {
        toast.cancel();
        d.setView(paramView);
      } 
      return;
    } 
    throw new IllegalArgumentException("The view must be initialized using the context of the application");
  }
  
  public static void a(Toast paramToast) {
    a(paramToast);
    d = paramToast;
    IToastStrategy iToastStrategy = b;
    if (iToastStrategy != null)
      iToastStrategy.a(d); 
  }
  
  public static void a(IToastInterceptor paramIToastInterceptor) {
    a(paramIToastInterceptor);
    a = paramIToastInterceptor;
  }
  
  public static void a(IToastStrategy paramIToastStrategy) {
    a(paramIToastStrategy);
    b = paramIToastStrategy;
    Toast toast = d;
    if (toast != null)
      b.a(toast); 
  }
  
  public static void a(IToastStyle paramIToastStyle) {
    a(paramIToastStyle);
    c = paramIToastStyle;
    Toast toast = d;
    if (toast != null) {
      toast.cancel();
      toast = d;
      toast.setView((View)a(toast.getView().getContext().getApplicationContext()));
      d.setGravity(c.a(), c.b(), c.c());
    } 
  }
  
  public static void a(CharSequence paramCharSequence, int paramInt) {
    // Byte code:
    //   0: ldc com/blued/android/core/utils/toast/ToastUtils
    //   2: monitorenter
    //   3: invokestatic a : ()V
    //   6: getstatic com/blued/android/core/utils/toast/ToastUtils.a : Lcom/blued/android/core/utils/toast/IToastInterceptor;
    //   9: getstatic com/blued/android/core/utils/toast/ToastUtils.d : Landroid/widget/Toast;
    //   12: aload_0
    //   13: invokeinterface a : (Landroid/widget/Toast;Ljava/lang/CharSequence;)Z
    //   18: istore_2
    //   19: iload_2
    //   20: ifeq -> 27
    //   23: ldc com/blued/android/core/utils/toast/ToastUtils
    //   25: monitorexit
    //   26: return
    //   27: getstatic com/blued/android/core/utils/toast/ToastUtils.b : Lcom/blued/android/core/utils/toast/IToastStrategy;
    //   30: aload_0
    //   31: iload_1
    //   32: invokeinterface a : (Ljava/lang/CharSequence;I)V
    //   37: ldc com/blued/android/core/utils/toast/ToastUtils
    //   39: monitorexit
    //   40: return
    //   41: astore_0
    //   42: ldc com/blued/android/core/utils/toast/ToastUtils
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	41	finally
    //   27	37	41	finally
  }
  
  private static void a(Object paramObject) {
    if (paramObject != null)
      return; 
    throw new NullPointerException("are you ok?");
  }
  
  private static boolean b(Context paramContext) {
    NotificationManager notificationManager;
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    if (i >= 24) {
      notificationManager = (NotificationManager)paramContext.getSystemService("notification");
      if (notificationManager != null)
        return notificationManager.areNotificationsEnabled(); 
    } else if (Build.VERSION.SDK_INT >= 19) {
      AppOpsManager appOpsManager = (AppOpsManager)notificationManager.getSystemService("appops");
      ApplicationInfo applicationInfo = notificationManager.getApplicationInfo();
      String str = notificationManager.getApplicationContext().getPackageName();
      i = applicationInfo.uid;
      try {
        Class<?> clazz = Class.forName(AppOpsManager.class.getName());
        i = ((Integer)clazz.getMethod("checkOpNoThrow", new Class[] { int.class, int.class, String.class }).invoke(appOpsManager, new Object[] { Integer.valueOf(((Integer)clazz.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), str })).intValue();
        return (i == 0);
      } catch (ClassNotFoundException|NoSuchMethodException|NoSuchFieldException|java.lang.reflect.InvocationTargetException|IllegalAccessException|RuntimeException classNotFoundException) {
        return true;
      } 
    } 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\toast\ToastUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */