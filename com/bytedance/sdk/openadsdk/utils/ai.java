package com.bytedance.sdk.openadsdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.i.a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ai {
  private static float a = -1.0F;
  
  private static int b = -1;
  
  private static float c = -1.0F;
  
  private static int d = -1;
  
  private static int e = -1;
  
  private static WindowManager f;
  
  static {
    a(o.a());
  }
  
  public static float a(Context paramContext, float paramFloat) {
    a(paramContext);
    return paramFloat * e(paramContext) + 0.5F;
  }
  
  public static int a(Bitmap paramBitmap) {
    try {
      ArrayList<Integer> arrayList = b(paramBitmap);
      if (arrayList == null)
        return -1; 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      for (Integer integer : arrayList) {
        if (hashMap.containsKey(integer)) {
          int k = ((Integer)hashMap.get(integer)).intValue();
          hashMap.remove(integer);
          hashMap.put(integer, Integer.valueOf(k + 1));
          continue;
        } 
        hashMap.put(integer, Integer.valueOf(1));
      } 
      Iterator<Map.Entry> iterator = hashMap.entrySet().iterator();
      i = 0;
      j = 0;
    } finally {
      paramBitmap = null;
    } 
    if (i == 0)
      return -1; 
    float f = j;
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    return (int)(f / (i * j) * 1.0F * 100.0F);
  }
  
  public static int a(String paramString, Activity paramActivity) {
    if (ac.e())
      try {
        Class<?> clazz = paramActivity.getClassLoader().loadClass("android.os.SystemProperties");
        return ((Integer)clazz.getMethod("getInt", new Class[] { String.class, int.class }).invoke(clazz, new Object[] { new String(paramString), new Integer(0) })).intValue();
      } catch (ClassNotFoundException classNotFoundException) {
        classNotFoundException.printStackTrace();
      } catch (NoSuchMethodException noSuchMethodException) {
        noSuchMethodException.printStackTrace();
        return 0;
      } catch (IllegalAccessException illegalAccessException) {
        illegalAccessException.printStackTrace();
        return 0;
      } catch (IllegalArgumentException illegalArgumentException) {
        illegalArgumentException.printStackTrace();
        return 0;
      } catch (InvocationTargetException invocationTargetException) {
        invocationTargetException.printStackTrace();
        return 0;
      }  
    return 0;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2) {
    int i;
    int j;
    Bitmap bitmap;
    if (paramBitmap == null)
      return null; 
    if (paramInt1 > 0) {
      if (paramInt2 <= 0)
        return paramBitmap; 
      try {
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        bitmap = paramBitmap;
        if (i > 0) {
          if (j <= 0)
            return paramBitmap; 
        } else {
          return bitmap;
        } 
      } catch (Exception exception1) {
        return null;
      } 
    } else {
      return (Bitmap)exception1;
    } 
    Exception exception2 = exception1;
    if (paramInt1 < i) {
      if (paramInt2 >= j)
        return (Bitmap)exception1; 
      float f1 = paramInt1 / i;
      float f2 = paramInt2 / j;
      Matrix matrix = new Matrix();
      matrix.postScale(f1, f2);
      bitmap = Bitmap.createBitmap((Bitmap)exception1, 0, 0, i, j, matrix, true);
    } 
    return bitmap;
  }
  
  public static Bitmap a(WebView paramWebView) {
    paramWebView.setLayerType(1, null);
    Bitmap bitmap2 = d(paramWebView);
    Bitmap bitmap1 = bitmap2;
    if (bitmap2 == null)
      bitmap1 = c(paramWebView); 
    paramWebView.setLayerType(2, null);
    return (bitmap1 == null) ? null : a(bitmap1, bitmap1.getWidth() / 6, bitmap1.getHeight() / 6);
  }
  
  public static void a(Activity paramActivity) {
    if (paramActivity == null)
      return; 
    try {
      if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
        paramActivity.getWindow().getDecorView().setSystemUiVisibility(8);
        return;
      } 
      if (Build.VERSION.SDK_INT >= 19) {
        paramActivity.getWindow().getDecorView().setSystemUiVisibility(3842);
        paramActivity.getWindow().addFlags(134217728);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void a(Context paramContext) {
    Context context;
    if (paramContext == null) {
      context = o.a();
    } else {
      context = paramContext;
    } 
    f = (WindowManager)o.a().getSystemService("window");
    if (context == null)
      return; 
    if (a()) {
      DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
      a = displayMetrics.density;
      b = displayMetrics.densityDpi;
      c = displayMetrics.scaledDensity;
      d = displayMetrics.widthPixels;
      e = displayMetrics.heightPixels;
    } 
    if (paramContext != null && paramContext.getResources() != null && paramContext.getResources().getConfiguration() != null)
      if ((paramContext.getResources().getConfiguration()).orientation == 1) {
        int i = d;
        int j = e;
        if (i > j) {
          d = j;
          e = i;
          return;
        } 
      } else {
        int i = d;
        int j = e;
        if (i < j) {
          d = j;
          e = i;
        } 
      }  
  }
  
  public static void a(Context paramContext, k paramk, String paramString, WebView paramWebView) {
    if (paramWebView != null && paramk != null && paramk.z() == null)
      paramWebView.postDelayed(new Runnable(paramWebView, paramContext, paramk, paramString) {
            public void run() {
              Bitmap bitmap2 = ai.b((View)this.a, 0);
              Bitmap bitmap1 = bitmap2;
              if (bitmap2 == null)
                bitmap1 = ai.b(this.a); 
              a.a().c(new Runnable(this, bitmap1) {
                    public void run() {
                      ai.a(this.b.b, this.b.c, this.b.d, this.a);
                    }
                  }5);
            }
          }500L); 
  }
  
  public static void a(Context paramContext, k paramk, String paramString1, String paramString2, Bitmap paramBitmap) {
    a.a().c(new Runnable(paramContext, paramk, paramString1, paramString2, paramBitmap) {
          public void run() {
            ai.b(this.a, this.b, this.c, this.d, this.e);
          }
        }5);
  }
  
  public static void a(View paramView, float paramFloat) {
    if (paramView == null)
      return; 
    paramView.setAlpha(paramFloat);
  }
  
  public static void a(View paramView, int paramInt) {
    if (paramView != null && paramView.getVisibility() != paramInt) {
      if (!a(paramInt))
        return; 
      paramView.setVisibility(paramInt);
    } 
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Rect rect = new Rect();
    paramView.getHitRect(rect);
    rect.top -= paramInt1;
    rect.bottom += paramInt2;
    rect.left -= paramInt3;
    rect.right += paramInt4;
    m m = new m(rect, paramView);
    ((View)paramView.getParent()).setTouchDelegate(m);
  }
  
  public static void a(View paramView, View.OnClickListener paramOnClickListener, String paramString) {
    StringBuilder stringBuilder;
    if (paramView == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(" is null , can not set OnClickListener !!!");
      t.e("OnclickListener ", stringBuilder.toString());
      return;
    } 
    stringBuilder.setOnClickListener(paramOnClickListener);
  }
  
  public static void a(View paramView, View.OnTouchListener paramOnTouchListener, String paramString) {
    StringBuilder stringBuilder;
    if (paramView == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(" is null , can not set OnTouchListener !!!");
      t.e("OnTouchListener ", stringBuilder.toString());
      return;
    } 
    stringBuilder.setOnTouchListener(paramOnTouchListener);
  }
  
  private static void a(View paramView, ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramView != null && paramMarginLayoutParams != null) {
      if (paramMarginLayoutParams.leftMargin == paramInt1 && paramMarginLayoutParams.topMargin == paramInt2 && paramMarginLayoutParams.rightMargin == paramInt3 && paramMarginLayoutParams.bottomMargin == paramInt4)
        return; 
      if (paramInt1 != -3)
        paramMarginLayoutParams.leftMargin = paramInt1; 
      if (paramInt2 != -3)
        paramMarginLayoutParams.topMargin = paramInt2; 
      if (paramInt3 != -3)
        paramMarginLayoutParams.rightMargin = paramInt3; 
      if (paramInt4 != -3)
        paramMarginLayoutParams.bottomMargin = paramInt4; 
      paramView.setLayoutParams((ViewGroup.LayoutParams)paramMarginLayoutParams);
    } 
  }
  
  public static void a(TextView paramTextView, CharSequence paramCharSequence) {
    if (paramTextView != null) {
      if (TextUtils.isEmpty(paramCharSequence))
        return; 
      paramTextView.setText(paramCharSequence);
    } 
  }
  
  private static boolean a() {
    return (a < 0.0F || b < 0 || c < 0.0F || d < 0 || e < 0);
  }
  
  private static boolean a(int paramInt) {
    return (paramInt == 0 || paramInt == 8 || paramInt == 4);
  }
  
  public static int[] a(View paramView) {
    if (paramView != null && paramView.getVisibility() == 0) {
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      return arrayOfInt;
    } 
    return null;
  }
  
  public static int b(Context paramContext, float paramFloat) {
    a(paramContext);
    float f2 = e(paramContext);
    float f1 = f2;
    if (f2 <= 0.0F)
      f1 = 1.0F; 
    return (int)(paramFloat / f1 + 0.5F);
  }
  
  public static Bitmap b(View paramView, int paramInt) {
    Bitmap bitmap2 = null;
    if (paramView == null)
      return null; 
    Bitmap bitmap1 = bitmap2;
    try {
      Bitmap bitmap4;
      paramView.destroyDrawingCache();
      bitmap1 = bitmap2;
      paramView.setDrawingCacheEnabled(true);
      bitmap1 = bitmap2;
      paramView.buildDrawingCache();
      bitmap1 = bitmap2;
      Bitmap bitmap3 = paramView.getDrawingCache();
      bitmap2 = bitmap3;
      if (paramInt > 0) {
        bitmap2 = bitmap3;
        if (bitmap3 != null) {
          bitmap2 = bitmap3;
          bitmap1 = bitmap3;
          if (bitmap3.getRowBytes() * bitmap3.getHeight() >= paramInt) {
            bitmap1 = bitmap3;
            bitmap2 = f.a(bitmap3, 720, 0);
          } 
          bitmap3 = bitmap2;
          bitmap1 = bitmap2;
          if (bitmap2.getRowBytes() * bitmap2.getHeight() >= paramInt) {
            bitmap1 = bitmap2;
            bitmap3 = f.a(bitmap2, paramInt);
          } 
          bitmap2 = bitmap3;
          if (bitmap3 != null) {
            bitmap2 = bitmap3;
            bitmap1 = bitmap3;
            if (t.c()) {
              bitmap1 = bitmap3;
              paramInt = bitmap3.getRowBytes();
              bitmap1 = bitmap3;
              int i = bitmap3.getHeight();
              bitmap1 = bitmap3;
              StringBuilder stringBuilder = new StringBuilder();
              bitmap1 = bitmap3;
              stringBuilder.append("size: ");
              bitmap1 = bitmap3;
              stringBuilder.append(paramInt * i);
              bitmap1 = bitmap3;
              t.a(stringBuilder.toString());
              bitmap4 = bitmap3;
            } 
          } 
        } 
      } 
      return bitmap4;
    } catch (Exception exception) {
      return bitmap1;
    } 
  }
  
  private static ArrayList<Integer> b(Bitmap paramBitmap) {
    if (paramBitmap == null)
      return null; 
    try {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      int[] arrayOfInt = new int[i * j];
      paramBitmap.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
      ArrayList<Integer> arrayList = new ArrayList();
      return arrayList;
    } finally {
      paramBitmap = null;
    } 
  }
  
  private static void b(Context paramContext, k paramk, String paramString, Bitmap paramBitmap) {
    byte b1;
    byte b2;
    int i;
    int j;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("checkWebViewIsTransparent start .....bitmap=");
    stringBuilder.append(paramBitmap);
    stringBuilder.append(",materialMeta=");
    stringBuilder.append(paramk);
    t.b("checkWebViewIsTransparent", stringBuilder.toString());
    if (paramBitmap != null) {
      try {
        if (paramBitmap.getWidth() > 0 && paramBitmap.getHeight() > 0) {
          if (paramBitmap.isRecycled())
            return; 
          paramBitmap = f.a(paramBitmap, paramBitmap.getWidth() / 6, paramBitmap.getHeight() / 6);
          if (paramBitmap != null) {
            if (paramBitmap.isRecycled())
              return; 
            i = paramBitmap.getWidth();
            j = paramBitmap.getHeight();
            double d = (i * j);
            long l1 = (long)(0.05D * d);
            long l2 = (long)(d * 0.5D);
            b1 = 0;
            boolean bool = false;
            b2 = 0;
          } else {
            return;
          } 
        } else {
          return;
        } 
      } finally {
        paramContext = null;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("(开发者可忽略此检测异常)checkWebViewIsTransparent->throwable ex>>>");
        stringBuilder1.append(paramContext.toString());
        t.e("UIUtils", stringBuilder1.toString());
      } 
    } else {
      return;
    } 
    while (true) {
      if (b1 < j) {
        byte b = b2;
        int m = 0;
        b2 = b1;
        b1 = b;
        while (true) {
          m++;
          b3 = b;
          object = SYNTHETIC_LOCAL_VARIABLE_11;
        } 
        break;
      } 
      return;
    } 
  }
  
  public static void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramView == null)
      return; 
    ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
    if (layoutParams == null)
      return; 
    if (layoutParams instanceof ViewGroup.MarginLayoutParams)
      a(paramView, (ViewGroup.MarginLayoutParams)layoutParams, paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public static boolean b(Activity paramActivity) {
    return (a("ro.miui.notch", paramActivity) != 1 && !j((Context)paramActivity) && !l((Context)paramActivity) && !k((Context)paramActivity)) ? (c(paramActivity)) : true;
  }
  
  public static int[] b(Context paramContext) {
    if (paramContext == null)
      return null; 
    if (f == null)
      f = (WindowManager)o.a().getSystemService("window"); 
    int[] arrayOfInt = new int[2];
    WindowManager windowManager = f;
    if (windowManager != null) {
      Display display = windowManager.getDefaultDisplay();
      DisplayMetrics displayMetrics = new DisplayMetrics();
      display.getMetrics(displayMetrics);
      int k = displayMetrics.widthPixels;
      int m = displayMetrics.heightPixels;
      int j = m;
      int i = k;
      if (Build.VERSION.SDK_INT >= 14) {
        j = m;
        i = k;
        if (Build.VERSION.SDK_INT < 17) {
          i = k;
          try {
            k = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(display, new Object[0])).intValue();
            i = k;
            j = ((Integer)Display.class.getMethod("getRawHeight", new Class[0]).invoke(display, new Object[0])).intValue();
            i = k;
          } catch (Exception exception) {
            j = m;
          } 
        } 
      } 
      m = j;
      k = i;
      if (Build.VERSION.SDK_INT >= 17) {
        k = i;
        try {
          Point point = new Point();
          k = i;
          Display.class.getMethod("getRealSize", new Class[] { Point.class }).invoke(display, new Object[] { point });
          k = i;
          i = point.x;
          k = i;
          m = point.y;
          k = i;
        } catch (Exception exception) {
          m = j;
        } 
      } 
      arrayOfInt[0] = k;
      arrayOfInt[1] = m;
    } 
    if (arrayOfInt[0] <= 0 || arrayOfInt[1] <= 0) {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      arrayOfInt[0] = displayMetrics.widthPixels;
      arrayOfInt[1] = displayMetrics.heightPixels;
    } 
    return arrayOfInt;
  }
  
  public static int[] b(View paramView) {
    return (paramView != null) ? new int[] { paramView.getWidth(), paramView.getHeight() } : null;
  }
  
  public static int c(Context paramContext) {
    a(paramContext);
    return d;
  }
  
  public static int c(Context paramContext, float paramFloat) {
    return (int)(paramFloat * (paramContext.getResources().getDisplayMetrics()).density + 0.5F);
  }
  
  private static Bitmap c(WebView paramWebView) {
    Bitmap bitmap2 = null;
    WebView webView = null;
    Bitmap bitmap1 = bitmap2;
    try {
      Picture picture = paramWebView.capturePicture();
      if (picture == null)
        return null; 
      paramWebView = webView;
      bitmap1 = bitmap2;
      return bitmap;
    } finally {
      paramWebView = null;
    } 
  }
  
  private static void c(Context paramContext, k paramk, String paramString1, String paramString2, Bitmap paramBitmap) {
    if (paramBitmap != null)
      try {
        if (paramBitmap.getWidth() > 0 && paramBitmap.getHeight() > 0)
          return; 
      } finally {
        paramContext = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(开发者可忽略此检测异常)checkWebViewIsTransparent->throwable ex>>>");
        stringBuilder.append(paramContext.toString());
      }  
  }
  
  public static boolean c(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 28)
      try {
        Class<?> clazz = Class.forName("android.view.WindowInsets");
        Object object = clazz.getMethod("getDisplayCutout", new Class[0]).invoke(clazz, new Object[0]);
        if (object != null)
          return true; 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return false;
  }
  
  public static boolean c(View paramView) {
    return (paramView != null && paramView.getVisibility() == 0);
  }
  
  public static int d(Context paramContext) {
    a(paramContext);
    return e;
  }
  
  private static Bitmap d(WebView paramWebView) {
    if (paramWebView == null)
      return null; 
    try {
      paramWebView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramWebView.layout(0, 0, paramWebView.getMeasuredWidth(), paramWebView.getMeasuredHeight());
      paramWebView.setDrawingCacheEnabled(true);
      paramWebView.buildDrawingCache();
      return null;
    } finally {
      paramWebView = null;
    } 
  }
  
  public static void d(View paramView) {
    if (paramView == null)
      return; 
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F });
    objectAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(paramView) {
          public void onAnimationEnd(Animator param1Animator) {
            super.onAnimationEnd(param1Animator);
            ai.a(this.a, 8);
            ObjectAnimator.ofFloat(this.a, "alpha", new float[] { 0.0F, 1.0F }).setDuration(0L).start();
          }
        });
    objectAnimator.setDuration(800L);
    objectAnimator.start();
  }
  
  public static float e(Context paramContext) {
    a(paramContext);
    return a;
  }
  
  public static void e(View paramView) {
    if (paramView == null)
      return; 
    a(paramView, 0);
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    objectAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter() {
          public void onAnimationStart(Animator param1Animator) {
            onAnimationEnd(param1Animator);
          }
        });
    objectAnimator.setDuration(300L);
    objectAnimator.start();
  }
  
  public static int f(Context paramContext) {
    a(paramContext);
    return b;
  }
  
  public static int g(Context paramContext) {
    Context context = paramContext;
    if (paramContext == null)
      context = o.a(); 
    Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics displayMetrics = new DisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17) {
      display.getRealMetrics(displayMetrics);
    } else {
      display.getMetrics(displayMetrics);
    } 
    return displayMetrics.heightPixels;
  }
  
  public static int h(Context paramContext) {
    Context context = paramContext;
    if (paramContext == null)
      context = o.a(); 
    Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics displayMetrics = new DisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17) {
      display.getRealMetrics(displayMetrics);
    } else {
      display.getMetrics(displayMetrics);
    } 
    return displayMetrics.widthPixels;
  }
  
  public static float i(Context paramContext) {
    Context context = paramContext;
    if (paramContext == null)
      context = o.a(); 
    float f = 0.0F;
    int i = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0)
      f = context.getApplicationContext().getResources().getDimensionPixelSize(i); 
    return f;
  }
  
  public static boolean j(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   4: ldc_w 'com.huawei.android.util.HwNotchSizeUtil'
    //   7: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   10: astore_0
    //   11: aload_0
    //   12: ldc_w 'hasNotchInScreen'
    //   15: iconst_0
    //   16: anewarray java/lang/Class
    //   19: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   22: aload_0
    //   23: iconst_0
    //   24: anewarray java/lang/Object
    //   27: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast java/lang/Boolean
    //   33: invokevirtual booleanValue : ()Z
    //   36: istore_1
    //   37: iload_1
    //   38: ireturn
    //   39: astore_0
    //   40: iconst_0
    //   41: ireturn
    // Exception table:
    //   from	to	target	type
    //   0	37	39	java/lang/ClassNotFoundException
    //   0	37	39	java/lang/NoSuchMethodException
    //   0	37	39	java/lang/Exception
    //   0	37	39	finally
  }
  
  public static boolean k(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   4: ldc_w 'android.util.FtFeature'
    //   7: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   10: astore_0
    //   11: aload_0
    //   12: ldc_w 'isFeatureSupport'
    //   15: iconst_1
    //   16: anewarray java/lang/Class
    //   19: dup
    //   20: iconst_0
    //   21: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   24: aastore
    //   25: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   28: aload_0
    //   29: iconst_1
    //   30: anewarray java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: bipush #32
    //   37: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   40: aastore
    //   41: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast java/lang/Boolean
    //   47: invokevirtual booleanValue : ()Z
    //   50: istore_1
    //   51: iload_1
    //   52: ireturn
    //   53: astore_0
    //   54: iconst_0
    //   55: ireturn
    // Exception table:
    //   from	to	target	type
    //   0	51	53	java/lang/ClassNotFoundException
    //   0	51	53	java/lang/NoSuchMethodException
    //   0	51	53	java/lang/Exception
    //   0	51	53	finally
  }
  
  public static boolean l(Context paramContext) {
    return paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */