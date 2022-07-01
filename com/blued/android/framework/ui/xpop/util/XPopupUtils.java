package com.blued.android.framework.ui.xpop.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.renderscript.RenderScript;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.ImageType;
import com.blued.android.framework.ui.xpop.impl.PartShadowPopupView;
import com.blued.android.framework.ui.xpop.interfaces.XPopupImageLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

public class XPopupUtils {
  private static int a;
  
  private static Context b;
  
  public static int a() {
    Resources resources = Resources.getSystem();
    return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
  }
  
  public static int a(Context paramContext) {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  public static int a(Context paramContext, float paramFloat) {
    return (int)(paramFloat * (paramContext.getResources().getDisplayMetrics()).density + 0.5F);
  }
  
  public static int a(Window paramWindow) {
    View view = paramWindow.getDecorView();
    Rect rect = new Rect();
    view.getWindowVisibleDisplayFrame(rect);
    int i = Math.abs(view.getBottom() - rect.bottom);
    if (i <= b()) {
      a = i;
      return 0;
    } 
    return i - a;
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, float paramFloat, boolean paramBoolean) {
    if (!paramBoolean)
      paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true); 
    try {
      RenderScript renderScript = RenderScript.create(paramContext);
    } finally {
      paramBitmap = null;
    } 
    if (paramContext != null)
      paramContext.destroy(); 
    throw paramBitmap;
  }
  
  public static Bitmap a(View paramView) {
    if (paramView == null)
      return null; 
    boolean bool1 = paramView.isDrawingCacheEnabled();
    boolean bool2 = paramView.willNotCacheDrawing();
    paramView.setDrawingCacheEnabled(true);
    paramView.setWillNotCacheDrawing(false);
    Bitmap bitmap = paramView.getDrawingCache();
    if (bitmap == null) {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
      paramView.buildDrawingCache();
      bitmap = paramView.getDrawingCache();
      if (bitmap != null) {
        bitmap = Bitmap.createBitmap(bitmap);
      } else {
        bitmap = Bitmap.createBitmap(paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        paramView.draw(new Canvas(bitmap));
      } 
    } else {
      bitmap = Bitmap.createBitmap(bitmap);
    } 
    paramView.destroyDrawingCache();
    paramView.setWillNotCacheDrawing(bool2);
    paramView.setDrawingCacheEnabled(bool1);
    return bitmap;
  }
  
  public static GradientDrawable a(int paramInt, float paramFloat) {
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setShape(0);
    gradientDrawable.setColor(paramInt);
    gradientDrawable.setCornerRadius(paramFloat);
    return gradientDrawable;
  }
  
  public static void a(int paramInt, BasePopupView paramBasePopupView) {
    // Byte code:
    //   0: aload_1
    //   1: getfield l : Lcom/blued/android/framework/ui/xpop/core/PopupInfo;
    //   4: getfield r : Ljava/lang/Boolean;
    //   7: invokevirtual booleanValue : ()Z
    //   10: ifne -> 14
    //   13: return
    //   14: aload_1
    //   15: instanceof com/blued/android/framework/ui/xpop/core/PositionPopupView
    //   18: ifne -> 564
    //   21: aload_1
    //   22: instanceof com/blued/android/framework/ui/xpop/core/AttachPopupView
    //   25: ifeq -> 36
    //   28: aload_1
    //   29: instanceof com/blued/android/framework/ui/xpop/impl/PartShadowPopupView
    //   32: ifne -> 36
    //   35: return
    //   36: new java/util/ArrayList
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore #8
    //   45: aload #8
    //   47: aload_1
    //   48: invokestatic a : (Ljava/util/ArrayList;Landroid/view/ViewGroup;)V
    //   51: aconst_null
    //   52: astore #9
    //   54: aload #8
    //   56: invokevirtual iterator : ()Ljava/util/Iterator;
    //   59: astore #10
    //   61: aload #9
    //   63: astore #8
    //   65: aload #10
    //   67: invokeinterface hasNext : ()Z
    //   72: ifeq -> 95
    //   75: aload #10
    //   77: invokeinterface next : ()Ljava/lang/Object;
    //   82: checkcast android/widget/EditText
    //   85: astore #8
    //   87: aload #8
    //   89: invokevirtual isFocused : ()Z
    //   92: ifeq -> 61
    //   95: aload_1
    //   96: invokevirtual getPopupContentView : ()Landroid/view/View;
    //   99: invokevirtual getHeight : ()I
    //   102: istore #5
    //   104: aload_1
    //   105: invokevirtual getPopupContentView : ()Landroid/view/View;
    //   108: invokevirtual getWidth : ()I
    //   111: istore_3
    //   112: iload #5
    //   114: istore #4
    //   116: iload_3
    //   117: istore_2
    //   118: aload_1
    //   119: invokevirtual getPopupImplView : ()Landroid/view/View;
    //   122: ifnull -> 151
    //   125: iload #5
    //   127: aload_1
    //   128: invokevirtual getPopupImplView : ()Landroid/view/View;
    //   131: invokevirtual getMeasuredHeight : ()I
    //   134: invokestatic min : (II)I
    //   137: istore #4
    //   139: iload_3
    //   140: aload_1
    //   141: invokevirtual getPopupImplView : ()Landroid/view/View;
    //   144: invokevirtual getMeasuredWidth : ()I
    //   147: invokestatic min : (II)I
    //   150: istore_2
    //   151: aload_1
    //   152: invokevirtual getContext : ()Landroid/content/Context;
    //   155: invokestatic b : (Landroid/content/Context;)I
    //   158: istore #6
    //   160: aload #8
    //   162: ifnull -> 195
    //   165: iconst_2
    //   166: newarray int
    //   168: astore #9
    //   170: aload #8
    //   172: aload #9
    //   174: invokevirtual getLocationInWindow : ([I)V
    //   177: aload #9
    //   179: iconst_1
    //   180: iaload
    //   181: istore #5
    //   183: aload #8
    //   185: invokevirtual getMeasuredHeight : ()I
    //   188: iload #5
    //   190: iadd
    //   191: istore_3
    //   192: goto -> 200
    //   195: iconst_0
    //   196: istore #5
    //   198: iconst_0
    //   199: istore_3
    //   200: aload_1
    //   201: instanceof com/blued/android/framework/ui/xpop/impl/FullScreenPopupView
    //   204: istore #7
    //   206: iload #7
    //   208: ifne -> 229
    //   211: iload_2
    //   212: aload_1
    //   213: invokevirtual getContext : ()Landroid/content/Context;
    //   216: invokestatic a : (Landroid/content/Context;)I
    //   219: if_icmpne -> 238
    //   222: iload #4
    //   224: iload #6
    //   226: if_icmpne -> 238
    //   229: iload_3
    //   230: iload_0
    //   231: iadd
    //   232: iload #6
    //   234: if_icmpge -> 238
    //   237: return
    //   238: iload #7
    //   240: ifeq -> 288
    //   243: aload_1
    //   244: getfield r : Lcom/blued/android/framework/ui/xpop/core/FullScreenDialog;
    //   247: invokevirtual getWindow : ()Landroid/view/Window;
    //   250: invokestatic b : (Landroid/view/Window;)Z
    //   253: ifeq -> 263
    //   256: invokestatic b : ()I
    //   259: istore_2
    //   260: goto -> 265
    //   263: iconst_0
    //   264: istore_2
    //   265: iload_3
    //   266: iload_0
    //   267: iadd
    //   268: iload_2
    //   269: iadd
    //   270: iload #6
    //   272: isub
    //   273: istore_0
    //   274: aload #8
    //   276: ifnull -> 466
    //   279: iload_0
    //   280: ifle -> 466
    //   283: iload_0
    //   284: istore_2
    //   285: goto -> 514
    //   288: aload_1
    //   289: instanceof com/blued/android/framework/ui/xpop/core/CenterPopupView
    //   292: ifeq -> 347
    //   295: iload #4
    //   297: iload #6
    //   299: iadd
    //   300: iconst_2
    //   301: idiv
    //   302: iload_0
    //   303: iadd
    //   304: invokestatic a : ()I
    //   307: iadd
    //   308: iload #6
    //   310: isub
    //   311: istore_2
    //   312: iload_2
    //   313: istore_0
    //   314: aload #8
    //   316: ifnull -> 338
    //   319: iload #5
    //   321: iload_2
    //   322: isub
    //   323: istore_3
    //   324: iload_2
    //   325: istore_0
    //   326: iload_3
    //   327: ifge -> 338
    //   330: iload_2
    //   331: iload_3
    //   332: invokestatic a : ()I
    //   335: isub
    //   336: iadd
    //   337: istore_0
    //   338: iconst_0
    //   339: iload_0
    //   340: invokestatic max : (II)I
    //   343: istore_2
    //   344: goto -> 514
    //   347: aload_1
    //   348: instanceof com/blued/android/framework/ui/xpop/core/BottomPopupView
    //   351: ifeq -> 383
    //   354: iload_0
    //   355: istore_2
    //   356: aload #8
    //   358: ifnull -> 514
    //   361: iload #5
    //   363: iload_0
    //   364: isub
    //   365: istore_3
    //   366: iload_0
    //   367: istore_2
    //   368: iload_3
    //   369: ifge -> 514
    //   372: iload_0
    //   373: iload_3
    //   374: invokestatic a : ()I
    //   377: isub
    //   378: iadd
    //   379: istore_2
    //   380: goto -> 514
    //   383: aload_1
    //   384: invokestatic b : (Lcom/blued/android/framework/ui/xpop/core/BasePopupView;)Z
    //   387: ifne -> 471
    //   390: aload_1
    //   391: instanceof com/blued/android/framework/ui/xpop/core/DrawerPopupView
    //   394: ifeq -> 400
    //   397: goto -> 471
    //   400: aload_1
    //   401: invokestatic c : (Lcom/blued/android/framework/ui/xpop/core/BasePopupView;)Z
    //   404: ifeq -> 466
    //   407: iload_3
    //   408: iload_0
    //   409: iadd
    //   410: iload #6
    //   412: isub
    //   413: istore_0
    //   414: aload #8
    //   416: ifnull -> 426
    //   419: iload_0
    //   420: ifle -> 426
    //   423: goto -> 428
    //   426: iconst_0
    //   427: istore_0
    //   428: iload_0
    //   429: ifeq -> 465
    //   432: aload_1
    //   433: invokevirtual getPopupImplView : ()Landroid/view/View;
    //   436: invokevirtual animate : ()Landroid/view/ViewPropertyAnimator;
    //   439: iload_0
    //   440: ineg
    //   441: i2f
    //   442: invokevirtual translationY : (F)Landroid/view/ViewPropertyAnimator;
    //   445: ldc2_w 200
    //   448: invokevirtual setDuration : (J)Landroid/view/ViewPropertyAnimator;
    //   451: new android/view/animation/OvershootInterpolator
    //   454: dup
    //   455: fconst_0
    //   456: invokespecial <init> : (F)V
    //   459: invokevirtual setInterpolator : (Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;
    //   462: invokevirtual start : ()V
    //   465: return
    //   466: iconst_0
    //   467: istore_2
    //   468: goto -> 514
    //   471: aload_1
    //   472: getfield r : Lcom/blued/android/framework/ui/xpop/core/FullScreenDialog;
    //   475: invokevirtual getWindow : ()Landroid/view/Window;
    //   478: invokestatic b : (Landroid/view/Window;)Z
    //   481: ifeq -> 491
    //   484: invokestatic b : ()I
    //   487: istore_2
    //   488: goto -> 493
    //   491: iconst_0
    //   492: istore_2
    //   493: iload_3
    //   494: iload_0
    //   495: iadd
    //   496: iload_2
    //   497: iadd
    //   498: iload #6
    //   500: isub
    //   501: istore_0
    //   502: aload #8
    //   504: ifnull -> 466
    //   507: iload_0
    //   508: ifle -> 466
    //   511: goto -> 283
    //   514: iload_2
    //   515: ifne -> 531
    //   518: aload_1
    //   519: invokevirtual getPopupContentView : ()Landroid/view/View;
    //   522: invokevirtual getTranslationY : ()F
    //   525: fconst_0
    //   526: fcmpl
    //   527: ifeq -> 531
    //   530: return
    //   531: aload_1
    //   532: invokevirtual getPopupContentView : ()Landroid/view/View;
    //   535: invokevirtual animate : ()Landroid/view/ViewPropertyAnimator;
    //   538: iload_2
    //   539: ineg
    //   540: i2f
    //   541: invokevirtual translationY : (F)Landroid/view/ViewPropertyAnimator;
    //   544: ldc2_w 200
    //   547: invokevirtual setDuration : (J)Landroid/view/ViewPropertyAnimator;
    //   550: new android/view/animation/OvershootInterpolator
    //   553: dup
    //   554: fconst_0
    //   555: invokespecial <init> : (F)V
    //   558: invokevirtual setInterpolator : (Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;
    //   561: invokevirtual start : ()V
    //   564: return
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2) {
    if (paramInt1 <= 0 && paramInt2 <= 0)
      return; 
    ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
    if (paramInt1 > 0)
      layoutParams.width = paramInt1; 
    if (paramInt2 > 0)
      layoutParams.height = paramInt2; 
    paramView.setLayoutParams(layoutParams);
  }
  
  public static void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2) {
    a(paramViewGroup, paramInt1, paramInt2, (Runnable)null);
  }
  
  public static void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, Runnable paramRunnable) {
    paramViewGroup.post(new Runnable(paramViewGroup, paramInt1, paramInt2, paramRunnable) {
          public void run() {
            ViewGroup.LayoutParams layoutParams1 = this.a.getLayoutParams();
            View view = this.a.getChildAt(0);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            int i = this.a.getMeasuredWidth();
            int j = this.b;
            if (j != 0)
              layoutParams1.width = Math.min(i, j); 
            i = this.a.getMeasuredHeight();
            if (layoutParams2.height == -1) {
              i = ((ViewGroup)this.a.getParent()).getMeasuredHeight();
              layoutParams1.height = i;
            } 
            if (this.c != 0)
              if (layoutParams1.height == -1 || layoutParams1.height == XPopupUtils.b(this.a.getContext()) + XPopupUtils.a()) {
                layoutParams2.height = Math.min(view.getMeasuredHeight(), this.c);
                view.setLayoutParams(layoutParams2);
              } else {
                layoutParams1.height = Math.min(i, this.c);
              }  
            this.a.setLayoutParams(layoutParams1);
            Runnable runnable = this.d;
            if (runnable != null)
              runnable.run(); 
          }
        });
  }
  
  public static void a(BasePopupView paramBasePopupView) {
    if (paramBasePopupView instanceof com.blued.android.framework.ui.xpop.core.PositionPopupView)
      return; 
    boolean bool = paramBasePopupView instanceof PartShadowPopupView;
    if (!bool && paramBasePopupView instanceof com.blued.android.framework.ui.xpop.core.AttachPopupView)
      return; 
    if (bool && !b(paramBasePopupView)) {
      paramBasePopupView.getPopupImplView().animate().translationY(0.0F).setDuration(100L).start();
      return;
    } 
    paramBasePopupView.getPopupContentView().animate().translationY(0.0F).setDuration(100L).start();
  }
  
  public static void a(ArrayList<EditText> paramArrayList, ViewGroup paramViewGroup) {
    for (int i = 0; i < paramViewGroup.getChildCount(); i++) {
      View view = paramViewGroup.getChildAt(i);
      if (view instanceof EditText && view.getVisibility() == 0) {
        paramArrayList.add((EditText)view);
      } else if (view instanceof ViewGroup) {
        a(paramArrayList, (ViewGroup)view);
      } 
    } 
  }
  
  public static boolean a(float paramFloat1, float paramFloat2, Rect paramRect) {
    return (paramFloat1 >= paramRect.left && paramFloat1 <= paramRect.right && paramFloat2 >= paramRect.top && paramFloat2 <= paramRect.bottom);
  }
  
  public static int b() {
    Resources resources = Resources.getSystem();
    int i = resources.getIdentifier("navigation_bar_height", "dimen", "android");
    return (i != 0) ? resources.getDimensionPixelSize(i) : 0;
  }
  
  public static int b(Context paramContext) {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
    return displayMetrics.heightPixels;
  }
  
  public static Activity b(View paramView) {
    for (Context context = paramView.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper)context).getBaseContext()) {
      if (context instanceof Activity)
        return (Activity)context; 
    } 
    return null;
  }
  
  private static String b(ImageType paramImageType) {
    switch (null.a[paramImageType.ordinal()]) {
      default:
        return "jpeg";
      case 4:
      case 5:
        return "webp";
      case 2:
      case 3:
        return "png";
      case 1:
        break;
    } 
    return "gif";
  }
  
  public static boolean b(Window paramWindow) {
    boolean bool1;
    ViewGroup viewGroup = (ViewGroup)paramWindow.getDecorView();
    int j = viewGroup.getChildCount();
    int i = 0;
    while (true) {
      if (i < j) {
        View view = viewGroup.getChildAt(i);
        int k = view.getId();
        if (k != -1 && "navigationBarBackground".equals(viewGroup.getContext().getResources().getResourceEntryName(k)) && view.getVisibility() == 0) {
          boolean bool = true;
          break;
        } 
        i++;
        continue;
      } 
      bool1 = false;
      break;
    } 
    boolean bool2 = bool1;
    if (bool1) {
      if ((viewGroup.getSystemUiVisibility() & 0x2) == 0)
        return true; 
      bool2 = false;
    } 
    return bool2;
  }
  
  private static boolean b(BasePopupView paramBasePopupView) {
    return (paramBasePopupView instanceof PartShadowPopupView && ((PartShadowPopupView)paramBasePopupView).b);
  }
  
  private static boolean b(File paramFile, InputStream paramInputStream) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: aconst_null
    //   4: astore_3
    //   5: new java/io/BufferedOutputStream
    //   8: dup
    //   9: new java/io/FileOutputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Ljava/io/File;)V
    //   17: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   20: astore_0
    //   21: sipush #8192
    //   24: newarray byte
    //   26: astore_3
    //   27: aload_1
    //   28: aload_3
    //   29: iconst_0
    //   30: sipush #8192
    //   33: invokevirtual read : ([BII)I
    //   36: istore_2
    //   37: iload_2
    //   38: iconst_m1
    //   39: if_icmpeq -> 52
    //   42: aload_0
    //   43: aload_3
    //   44: iconst_0
    //   45: iload_2
    //   46: invokevirtual write : ([BII)V
    //   49: goto -> 27
    //   52: aload_1
    //   53: invokevirtual close : ()V
    //   56: goto -> 64
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual printStackTrace : ()V
    //   64: aload_0
    //   65: invokevirtual close : ()V
    //   68: iconst_1
    //   69: ireturn
    //   70: astore_0
    //   71: aload_0
    //   72: invokevirtual printStackTrace : ()V
    //   75: iconst_1
    //   76: ireturn
    //   77: astore #4
    //   79: aload_0
    //   80: astore_3
    //   81: aload #4
    //   83: astore_0
    //   84: goto -> 137
    //   87: astore #4
    //   89: goto -> 101
    //   92: astore_0
    //   93: goto -> 137
    //   96: astore #4
    //   98: aload #5
    //   100: astore_0
    //   101: aload_0
    //   102: astore_3
    //   103: aload #4
    //   105: invokevirtual printStackTrace : ()V
    //   108: aload_1
    //   109: invokevirtual close : ()V
    //   112: goto -> 120
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual printStackTrace : ()V
    //   120: aload_0
    //   121: ifnull -> 135
    //   124: aload_0
    //   125: invokevirtual close : ()V
    //   128: iconst_0
    //   129: ireturn
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual printStackTrace : ()V
    //   135: iconst_0
    //   136: ireturn
    //   137: aload_1
    //   138: invokevirtual close : ()V
    //   141: goto -> 149
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual printStackTrace : ()V
    //   149: aload_3
    //   150: ifnull -> 165
    //   153: aload_3
    //   154: invokevirtual close : ()V
    //   157: goto -> 165
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual printStackTrace : ()V
    //   165: aload_0
    //   166: athrow
    // Exception table:
    //   from	to	target	type
    //   5	21	96	java/io/IOException
    //   5	21	92	finally
    //   21	27	87	java/io/IOException
    //   21	27	77	finally
    //   27	37	87	java/io/IOException
    //   27	37	77	finally
    //   42	49	87	java/io/IOException
    //   42	49	77	finally
    //   52	56	59	java/io/IOException
    //   64	68	70	java/io/IOException
    //   103	108	92	finally
    //   108	112	115	java/io/IOException
    //   124	128	130	java/io/IOException
    //   137	141	144	java/io/IOException
    //   153	157	160	java/io/IOException
  }
  
  public static int c(Window paramWindow) {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    paramWindow.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
    return displayMetrics.heightPixels;
  }
  
  public static boolean c(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 17) {
      Locale locale;
      if (Build.VERSION.SDK_INT >= 24) {
        locale = paramContext.getResources().getConfiguration().getLocales().get(0);
      } else {
        locale = (locale.getResources().getConfiguration()).locale;
      } 
      return (TextUtils.getLayoutDirectionFromLocale(locale) == 1);
    } 
    return false;
  }
  
  private static boolean c(BasePopupView paramBasePopupView) {
    return (paramBasePopupView instanceof PartShadowPopupView && !((PartShadowPopupView)paramBasePopupView).b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpo\\util\XPopupUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */