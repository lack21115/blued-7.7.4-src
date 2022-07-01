package com.blued.android.framework.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import com.blued.android.core.AppInfo;
import com.google.gson.Gson;
import java.util.Locale;

public class LocaleUtils {
  private static final String a = LocaleUtils.class.getSimpleName();
  
  private static Locale b;
  
  private static Locale c = Locale.SIMPLIFIED_CHINESE;
  
  private static LocaleList d;
  
  private static String a(Locale paramLocale) {
    Gson gson2 = AppInfo.f();
    Gson gson1 = gson2;
    if (gson2 == null)
      gson1 = new Gson(); 
    return gson1.toJson(paramLocale);
  }
  
  public static Locale a(Context paramContext) {
    // Byte code:
    //   0: ldc com/blued/android/framework/utils/LocaleUtils
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull -> 12
    //   7: ldc com/blued/android/framework/utils/LocaleUtils
    //   9: monitorexit
    //   10: aconst_null
    //   11: areturn
    //   12: aload_0
    //   13: ldc 'local_language_file'
    //   15: iconst_0
    //   16: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   19: ldc 'local_language_key'
    //   21: ldc ''
    //   23: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: invokestatic a : (Ljava/lang/String;)Ljava/util/Locale;
    //   31: astore_0
    //   32: ldc com/blued/android/framework/utils/LocaleUtils
    //   34: monitorexit
    //   35: aload_0
    //   36: areturn
    //   37: astore_0
    //   38: ldc com/blued/android/framework/utils/LocaleUtils
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   12	32	37	finally
  }
  
  private static Locale a(String paramString) {
    Gson gson2 = AppInfo.f();
    Gson gson1 = gson2;
    if (gson2 == null)
      gson1 = new Gson(); 
    return (Locale)gson1.fromJson(paramString, Locale.class);
  }
  
  public static void a(Context paramContext, Locale paramLocale) {
    b = paramLocale;
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("local_language_file", 0).edit();
    editor.putString("local_language_key", a(paramLocale));
    editor.apply();
  }
  
  public static void a(boolean paramBoolean) {
    SharedPreferences.Editor editor = AppInfo.d().getSharedPreferences("local_language_file", 0).edit();
    editor.putBoolean("local_follow_system", paramBoolean);
    editor.apply();
  }
  
  public static boolean a() {
    return AppInfo.d().getSharedPreferences("local_language_file", 0).getBoolean("local_follow_system", true);
  }
  
  public static String b() {
    StringBuilder stringBuilder2;
    String str2 = "zh";
    try {
      StringBuilder stringBuilder;
      Locale locale2 = c();
      Locale locale1 = locale2;
      if (locale2 == null)
        locale1 = c; 
      String str5 = locale1.getLanguage();
      String str4 = locale1.getCountry();
      boolean bool = "zh".equalsIgnoreCase(str5);
      if (bool) {
        if (!"tw".equalsIgnoreCase(str4) && !"hk".equalsIgnoreCase(str4)) {
          str4 = "cn";
          null = str2;
          str2 = str4;
          stringBuilder = new StringBuilder();
          stringBuilder.append(null);
          stringBuilder.append("-");
          stringBuilder.append(str2);
          return stringBuilder.toString();
        } 
      } else {
        if ("en".equalsIgnoreCase(str5)) {
          str2 = "us";
          null = "en";
        } else {
          if ("id".equalsIgnoreCase((String)stringBuilder)) {
            null = "id";
            StringBuilder stringBuilder4 = stringBuilder;
            stringBuilder = new StringBuilder();
            stringBuilder.append(null);
            stringBuilder.append("-");
            stringBuilder.append((String)stringBuilder4);
            return stringBuilder.toString();
          } 
          null = str5;
          stringBuilder2 = stringBuilder;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append(null);
        stringBuilder.append("-");
        stringBuilder.append((String)stringBuilder2);
        return stringBuilder.toString();
      } 
    } catch (Exception exception) {
      return "";
    } 
    String str3 = "tw";
    StringBuilder stringBuilder1 = stringBuilder2;
    String str1 = str3;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append((String)stringBuilder1);
    stringBuilder3.append("-");
    stringBuilder3.append(str1);
    return stringBuilder3.toString();
  }
  
  public static Locale b(Context paramContext) {
    // Byte code:
    //   0: ldc com/blued/android/framework/utils/LocaleUtils
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore_2
    //   5: getstatic android/os/Build$VERSION.SDK_INT : I
    //   8: bipush #24
    //   10: if_icmplt -> 121
    //   13: aload_0
    //   14: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   17: invokevirtual getConfiguration : ()Landroid/content/res/Configuration;
    //   20: invokevirtual getLocales : ()Landroid/os/LocaleList;
    //   23: astore_3
    //   24: aload_2
    //   25: astore_0
    //   26: aload_3
    //   27: ifnull -> 174
    //   30: aload_2
    //   31: astore_0
    //   32: aload_3
    //   33: invokevirtual size : ()I
    //   36: ifle -> 174
    //   39: iconst_0
    //   40: istore_1
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual get : (I)Ljava/util/Locale;
    //   46: astore_0
    //   47: iload_1
    //   48: aload_3
    //   49: invokevirtual size : ()I
    //   52: if_icmpge -> 192
    //   55: aload_3
    //   56: iload_1
    //   57: invokevirtual get : (I)Ljava/util/Locale;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull -> 185
    //   65: new java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial <init> : ()V
    //   72: astore #4
    //   74: aload #4
    //   76: ldc 'getCurrentInAppLocale getLocales() '
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload #4
    //   84: iload_1
    //   85: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload #4
    //   91: ldc ' = '
    //   93: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload #4
    //   99: aload_2
    //   100: invokevirtual toString : ()Ljava/lang/String;
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: ldc 'jzb_local'
    //   109: aload #4
    //   111: invokevirtual toString : ()Ljava/lang/String;
    //   114: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   117: pop
    //   118: goto -> 185
    //   121: aload_0
    //   122: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   125: invokevirtual getConfiguration : ()Landroid/content/res/Configuration;
    //   128: getfield locale : Ljava/util/Locale;
    //   131: astore_2
    //   132: aload_2
    //   133: astore_0
    //   134: aload_2
    //   135: ifnull -> 174
    //   138: new java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial <init> : ()V
    //   145: astore_0
    //   146: aload_0
    //   147: ldc 'getCurrentInAppLocale  .locale  = '
    //   149: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_0
    //   154: aload_2
    //   155: invokevirtual toString : ()Ljava/lang/String;
    //   158: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: ldc 'jzb_local'
    //   164: aload_0
    //   165: invokevirtual toString : ()Ljava/lang/String;
    //   168: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   171: pop
    //   172: aload_2
    //   173: astore_0
    //   174: ldc com/blued/android/framework/utils/LocaleUtils
    //   176: monitorexit
    //   177: aload_0
    //   178: areturn
    //   179: astore_0
    //   180: ldc com/blued/android/framework/utils/LocaleUtils
    //   182: monitorexit
    //   183: aload_0
    //   184: athrow
    //   185: iload_1
    //   186: iconst_1
    //   187: iadd
    //   188: istore_1
    //   189: goto -> 47
    //   192: goto -> 174
    // Exception table:
    //   from	to	target	type
    //   5	24	179	finally
    //   32	39	179	finally
    //   41	47	179	finally
    //   47	61	179	finally
    //   65	118	179	finally
    //   121	132	179	finally
    //   138	172	179	finally
  }
  
  public static void b(Context paramContext, Locale paramLocale) {
    if (paramContext != null) {
      if (paramLocale == null)
        return; 
      Configuration configuration = paramContext.getResources().getConfiguration();
      if (Build.VERSION.SDK_INT >= 17) {
        configuration.setLocale(paramLocale);
      } else {
        configuration.locale = paramLocale;
      } 
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      paramContext.getResources().updateConfiguration(configuration, displayMetrics);
      a(paramContext, paramLocale);
    } 
  }
  
  public static Locale c() {
    // Byte code:
    //   0: ldc com/blued/android/framework/utils/LocaleUtils
    //   2: monitorenter
    //   3: getstatic com/blued/android/framework/utils/LocaleUtils.b : Ljava/util/Locale;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull -> 37
    //   11: invokestatic d : ()Landroid/content/Context;
    //   14: invokestatic a : (Landroid/content/Context;)Ljava/util/Locale;
    //   17: putstatic com/blued/android/framework/utils/LocaleUtils.b : Ljava/util/Locale;
    //   20: goto -> 37
    //   23: astore_0
    //   24: getstatic com/blued/android/framework/utils/LocaleUtils.a : Ljava/lang/String;
    //   27: ldc 'read locale exception'
    //   29: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   32: pop
    //   33: aload_0
    //   34: invokevirtual printStackTrace : ()V
    //   37: getstatic com/blued/android/framework/utils/LocaleUtils.b : Ljava/util/Locale;
    //   40: ifnull -> 55
    //   43: getstatic com/blued/android/framework/utils/LocaleUtils.b : Ljava/util/Locale;
    //   46: invokevirtual getLanguage : ()Ljava/lang/String;
    //   49: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   52: ifeq -> 73
    //   55: invokestatic d : ()Landroid/content/Context;
    //   58: invokestatic b : (Landroid/content/Context;)Ljava/util/Locale;
    //   61: putstatic com/blued/android/framework/utils/LocaleUtils.b : Ljava/util/Locale;
    //   64: getstatic com/blued/android/framework/utils/LocaleUtils.a : Ljava/lang/String;
    //   67: ldc 'read locale from app locale follow resouce'
    //   69: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   72: pop
    //   73: getstatic com/blued/android/framework/utils/LocaleUtils.b : Ljava/util/Locale;
    //   76: ifnull -> 91
    //   79: getstatic com/blued/android/framework/utils/LocaleUtils.b : Ljava/util/Locale;
    //   82: invokevirtual getLanguage : ()Ljava/lang/String;
    //   85: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   88: ifeq -> 106
    //   91: getstatic com/blued/android/framework/utils/LocaleUtils.c : Ljava/util/Locale;
    //   94: putstatic com/blued/android/framework/utils/LocaleUtils.b : Ljava/util/Locale;
    //   97: getstatic com/blued/android/framework/utils/LocaleUtils.a : Ljava/lang/String;
    //   100: ldc 'read locale from app locale zh ch'
    //   102: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   105: pop
    //   106: getstatic com/blued/android/framework/utils/LocaleUtils.b : Ljava/util/Locale;
    //   109: astore_0
    //   110: ldc com/blued/android/framework/utils/LocaleUtils
    //   112: monitorexit
    //   113: aload_0
    //   114: areturn
    //   115: astore_0
    //   116: ldc com/blued/android/framework/utils/LocaleUtils
    //   118: monitorexit
    //   119: aload_0
    //   120: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	115	finally
    //   11	20	23	java/lang/Exception
    //   11	20	115	finally
    //   24	37	115	finally
    //   37	55	115	finally
    //   55	73	115	finally
    //   73	91	115	finally
    //   91	106	115	finally
    //   106	110	115	finally
  }
  
  public static void c(Context paramContext) {
    if (paramContext != null)
      b(paramContext, a(paramContext)); 
  }
  
  public static void d() {
    if (Build.VERSION.SDK_INT >= 24)
      d = LocaleList.getDefault(); 
  }
  
  public static Locale e() {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #24
    //   5: if_icmplt -> 34
    //   8: getstatic com/blued/android/framework/utils/LocaleUtils.d : Landroid/os/LocaleList;
    //   11: astore_0
    //   12: aload_0
    //   13: ifnull -> 34
    //   16: aload_0
    //   17: invokevirtual size : ()I
    //   20: ifle -> 34
    //   23: getstatic com/blued/android/framework/utils/LocaleUtils.d : Landroid/os/LocaleList;
    //   26: iconst_0
    //   27: invokevirtual get : (I)Ljava/util/Locale;
    //   30: astore_1
    //   31: goto -> 38
    //   34: invokestatic getDefault : ()Ljava/util/Locale;
    //   37: astore_1
    //   38: aload_1
    //   39: astore_0
    //   40: aload_1
    //   41: ifnonnull -> 48
    //   44: invokestatic getDefault : ()Ljava/util/Locale;
    //   47: astore_0
    //   48: aload_0
    //   49: astore_1
    //   50: aload_0
    //   51: ifnonnull -> 58
    //   54: getstatic java/util/Locale.SIMPLIFIED_CHINESE : Ljava/util/Locale;
    //   57: astore_1
    //   58: aload_1
    //   59: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\LocaleUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */