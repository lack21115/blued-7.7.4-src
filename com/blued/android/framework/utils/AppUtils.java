package com.blued.android.framework.utils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.R;

public class AppUtils {
  private static Application a;
  
  public static Application a() {
    // Byte code:
    //   0: getstatic com/blued/android/framework/utils/AppUtils.a : Landroid/app/Application;
    //   3: ifnonnull -> 85
    //   6: ldc com/blued/android/framework/utils/AppUtils
    //   8: monitorenter
    //   9: getstatic com/blued/android/framework/utils/AppUtils.a : Landroid/app/Application;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull -> 73
    //   17: ldc 'android.app.ActivityThread'
    //   19: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   22: astore_1
    //   23: aload_1
    //   24: ldc 'currentActivityThread'
    //   26: iconst_0
    //   27: anewarray java/lang/Class
    //   30: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   33: astore_0
    //   34: aload_1
    //   35: ldc 'mInitialApplication'
    //   37: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   40: astore_1
    //   41: aload_1
    //   42: iconst_1
    //   43: invokevirtual setAccessible : (Z)V
    //   46: aload_1
    //   47: aload_0
    //   48: aconst_null
    //   49: iconst_0
    //   50: anewarray java/lang/Object
    //   53: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   56: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast android/app/Application
    //   62: putstatic com/blued/android/framework/utils/AppUtils.a : Landroid/app/Application;
    //   65: goto -> 73
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual printStackTrace : ()V
    //   73: ldc com/blued/android/framework/utils/AppUtils
    //   75: monitorexit
    //   76: goto -> 85
    //   79: astore_0
    //   80: ldc com/blued/android/framework/utils/AppUtils
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    //   85: getstatic com/blued/android/framework/utils/AppUtils.a : Landroid/app/Application;
    //   88: areturn
    // Exception table:
    //   from	to	target	type
    //   9	13	79	finally
    //   17	65	68	java/lang/Exception
    //   17	65	79	finally
    //   69	73	79	finally
    //   73	76	79	finally
    //   80	83	79	finally
  }
  
  public static String a(int paramInt) {
    return a().getString(paramInt);
  }
  
  public static String a(Context paramContext) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/blued/android/framework/utils/AppUtils}} */
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      int i = (packageManager.getPackageInfo(paramContext.getPackageName(), 0)).applicationInfo.labelRes;
      if (i == 0) {
        str = String.valueOf(packageManager.getApplicationLabel(paramContext.getApplicationInfo()));
        /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/blued/android/framework/utils/AppUtils}} */
        return str;
      } 
      String str = str.getResources().getString(i);
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/blued/android/framework/utils/AppUtils}} */
      return str;
    } catch (Exception exception) {
      exception.printStackTrace();
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/blued/android/framework/utils/AppUtils}} */
      return "";
    } finally {}
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/blued/android/framework/utils/AppUtils}} */
    throw paramContext;
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean) {
    if (!StringUtils.a(paramString))
      if (Build.VERSION.SDK_INT <= 19) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", UriUtils.a(paramString));
        intent.addFlags(1);
        intent.addFlags(2);
        paramContext.sendBroadcast(intent);
        if (paramBoolean) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramContext.getResources().getString(R.string.pic_save));
          stringBuilder.append(paramString);
          AppMethods.a(stringBuilder.toString());
          return;
        } 
      } else {
        -$$Lambda$AppUtils$BjUN7IrkRMAUwsSfkkdwNp74c9E -$$Lambda$AppUtils$BjUN7IrkRMAUwsSfkkdwNp74c9E = new -$$Lambda$AppUtils$BjUN7IrkRMAUwsSfkkdwNp74c9E(paramBoolean, paramContext, paramString);
        MediaScannerConnection.scanFile(paramContext, new String[] { paramString }, null, -$$Lambda$AppUtils$BjUN7IrkRMAUwsSfkkdwNp74c9E);
      }  
  }
  
  public static boolean b() {
    return (Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\AppUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */