package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.a.a;
import com.ss.android.socialbase.appdownloader.a.d;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.l.f;
import com.ss.android.socialbase.downloader.m.i;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {
  private static c a;
  
  private static final HashMap<String, com.ss.android.socialbase.downloader.m.a.a> b = new HashMap<String, com.ss.android.socialbase.downloader.m.a.a>();
  
  private static a c;
  
  public static int a(com.ss.android.socialbase.downloader.k.a parama) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'anti_hijack_dir'
    //   3: invokevirtual d : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   6: astore #5
    //   8: aload #5
    //   10: ifnull -> 29
    //   13: aload #5
    //   15: ldc 'dir_name'
    //   17: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   20: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   23: iconst_1
    //   24: ixor
    //   25: istore_1
    //   26: goto -> 31
    //   29: iconst_0
    //   30: istore_1
    //   31: iload_1
    //   32: ifne -> 37
    //   35: iconst_5
    //   36: ireturn
    //   37: invokestatic b : ()Lcom/ss/android/socialbase/downloader/k/a;
    //   40: ldc 'get_download_info_by_list'
    //   42: invokevirtual a : (Ljava/lang/String;)Z
    //   45: ifne -> 68
    //   48: aload_0
    //   49: ldc 'force_enable_get_download_info_by_list'
    //   51: invokevirtual a : (Ljava/lang/String;)Z
    //   54: ifeq -> 66
    //   57: ldc 'get_download_info_by_list'
    //   59: iconst_1
    //   60: invokestatic a : (Ljava/lang/String;Z)V
    //   63: goto -> 68
    //   66: iconst_4
    //   67: ireturn
    //   68: aload_0
    //   69: ldc 'anti_plans'
    //   71: invokevirtual e : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   74: astore_0
    //   75: iconst_m1
    //   76: istore_1
    //   77: aload_0
    //   78: ifnull -> 184
    //   81: aload_0
    //   82: invokevirtual length : ()I
    //   85: istore #4
    //   87: iconst_0
    //   88: istore_2
    //   89: iconst_m1
    //   90: istore_1
    //   91: iload_2
    //   92: iload #4
    //   94: if_icmpge -> 184
    //   97: aload_0
    //   98: iload_2
    //   99: invokevirtual optJSONObject : (I)Lorg/json/JSONObject;
    //   102: astore #5
    //   104: iload_1
    //   105: istore_3
    //   106: aload #5
    //   108: ifnull -> 175
    //   111: iload_1
    //   112: istore_3
    //   113: aload #5
    //   115: invokestatic a : (Lorg/json/JSONObject;)Z
    //   118: ifeq -> 175
    //   121: aload #5
    //   123: ldc 'type'
    //   125: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   128: astore #6
    //   130: ldc 'jump_file_manager'
    //   132: aload #6
    //   134: invokevirtual equals : (Ljava/lang/Object;)Z
    //   137: ifne -> 152
    //   140: iload_1
    //   141: istore_3
    //   142: ldc 'jump_file_manager_custom'
    //   144: aload #6
    //   146: invokevirtual equals : (Ljava/lang/Object;)Z
    //   149: ifeq -> 175
    //   152: aload #5
    //   154: invokestatic b : (Lorg/json/JSONObject;)Lcom/ss/android/socialbase/appdownloader/a;
    //   157: astore #5
    //   159: aload #5
    //   161: getfield b : I
    //   164: istore_3
    //   165: aload #5
    //   167: getfield b : I
    //   170: ifne -> 175
    //   173: iconst_0
    //   174: ireturn
    //   175: iload_2
    //   176: iconst_1
    //   177: iadd
    //   178: istore_2
    //   179: iload_3
    //   180: istore_1
    //   181: goto -> 91
    //   184: iload_1
    //   185: ireturn
  }
  
  public static com.ss.android.socialbase.downloader.m.a.a a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      String[] arrayOfString = paramString.split(",");
      return null;
    } finally {
      paramString = null;
    } 
  }
  
  public static String a(Throwable paramThrowable) {
    String str2 = paramThrowable.toString();
    String str1 = str2;
    if (str2.length() > 800)
      str1 = str2.substring(0, 500); 
    return str1;
  }
  
  private static void a(Context paramContext, Intent paramIntent, JSONObject paramJSONObject, b paramb) {
    if (c != null) {
      com.ss.android.socialbase.downloader.a.a.a().b(c);
      c = null;
    } 
    c = new a(paramContext, paramIntent, paramJSONObject, paramb);
    com.ss.android.socialbase.downloader.a.a.a().a(c);
  }
  
  private static void a(a parama, int paramInt) {
    if (parama.b != -1) {
      parama.b = parama.b * 10 + paramInt;
      return;
    } 
    parama.b = paramInt;
  }
  
  public static void a(c paramc) {
    a = paramc;
  }
  
  public static boolean a(Context paramContext) {
    if (paramContext == null)
      return true; 
    try {
      return (i.b() && Build.VERSION.SDK_INT < 26) ? d(paramContext) : ((Build.VERSION.SDK_INT >= 26 && (paramContext.getApplicationInfo()).targetSdkVersion >= 26) ? e(paramContext) : true);
    } finally {
      paramContext = null;
    } 
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, JSONObject paramJSONObject) {
    try {
    
    } finally {
      paramContext = null;
    } 
    return true;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, JSONObject paramJSONObject, a parama) {
    if (paramContext != null) {
      if (paramJSONObject == null)
        return false; 
      int i = paramJSONObject.optInt("max_jump_count", 0);
      if (i <= 0)
        return false; 
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences("sp_anti_hijack_config", 0);
      int j = sharedPreferences.getInt("jump_unknown_source_count", 0);
      if (j >= i)
        return false; 
      if (!a(paramContext)) {
        sharedPreferences.edit().putInt("jump_unknown_source_count", j + 1).apply();
        Intent intent = new Intent(paramContext, JumpUnknownSourceActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("intent", (Parcelable)paramIntent);
        intent.putExtra("config", paramJSONObject.toString());
        try {
          a(paramContext, intent, false);
          return true;
        } finally {
          paramContext = null;
        } 
      } 
    } 
    return false;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, boolean paramBoolean) {
    if (paramContext != null) {
      if (paramIntent == null)
        return false; 
      if (paramBoolean)
        try {
          paramIntent.putExtra("start_only_for_android", true);
          return true;
        } finally {
          paramContext = null;
        }  
      paramIntent.putExtra("start_only_for_android", true);
      paramContext.startActivity(paramIntent);
      return true;
    } 
    return false;
  }
  
  private static boolean a(Context paramContext, com.ss.android.socialbase.downloader.g.c paramc, Intent paramIntent, JSONObject paramJSONObject, boolean paramBoolean) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #7
    //   3: iconst_0
    //   4: istore #9
    //   6: iload #7
    //   8: istore #8
    //   10: aload_3
    //   11: ifnull -> 515
    //   14: aload_1
    //   15: ifnonnull -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: new com/ss/android/socialbase/appdownloader/a
    //   23: dup
    //   24: invokespecial <init> : ()V
    //   27: astore #11
    //   29: aload_3
    //   30: ldc 'type'
    //   32: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   35: astore #10
    //   37: new java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: astore #12
    //   46: aload #12
    //   48: ldc_w 'runAntiHijack type = '
    //   51: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload #12
    //   57: aload #10
    //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: ldc_w 'AntiHijackUtils'
    //   66: aload #12
    //   68: invokevirtual toString : ()Ljava/lang/String;
    //   71: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   74: iload #7
    //   76: istore #8
    //   78: aload #10
    //   80: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   83: ifne -> 515
    //   86: aload #11
    //   88: aload #10
    //   90: putfield a : Ljava/lang/String;
    //   93: aload #10
    //   95: invokevirtual hashCode : ()I
    //   98: istore #5
    //   100: iconst_1
    //   101: istore #6
    //   103: iload #5
    //   105: ldc_w -2097307557
    //   108: if_icmpeq -> 163
    //   111: iload #5
    //   113: ldc_w -1870668843
    //   116: if_icmpeq -> 147
    //   119: iload #5
    //   121: ldc_w 778176993
    //   124: if_icmpeq -> 130
    //   127: goto -> 179
    //   130: aload #10
    //   132: ldc_w 'jump_unknown_source'
    //   135: invokevirtual equals : (Ljava/lang/Object;)Z
    //   138: ifeq -> 179
    //   141: iconst_0
    //   142: istore #5
    //   144: goto -> 182
    //   147: aload #10
    //   149: ldc 'jump_file_manager_custom'
    //   151: invokevirtual equals : (Ljava/lang/Object;)Z
    //   154: ifeq -> 179
    //   157: iconst_2
    //   158: istore #5
    //   160: goto -> 182
    //   163: aload #10
    //   165: ldc 'jump_file_manager'
    //   167: invokevirtual equals : (Ljava/lang/Object;)Z
    //   170: ifeq -> 179
    //   173: iconst_1
    //   174: istore #5
    //   176: goto -> 182
    //   179: iconst_m1
    //   180: istore #5
    //   182: iload #5
    //   184: ifeq -> 394
    //   187: iload #5
    //   189: iconst_1
    //   190: if_icmpeq -> 268
    //   193: iload #5
    //   195: iconst_2
    //   196: if_icmpeq -> 210
    //   199: iload #9
    //   201: istore #7
    //   203: aload #11
    //   205: astore #10
    //   207: goto -> 470
    //   210: aload_3
    //   211: invokestatic b : (Lorg/json/JSONObject;)Lcom/ss/android/socialbase/appdownloader/a;
    //   214: astore_2
    //   215: aload_2
    //   216: getfield b : I
    //   219: ifeq -> 227
    //   222: aload_2
    //   223: astore_0
    //   224: goto -> 317
    //   227: aload_1
    //   228: invokevirtual be : ()Z
    //   231: ifne -> 255
    //   234: aload #11
    //   236: aload_1
    //   237: iconst_m1
    //   238: invokevirtual j : (I)I
    //   241: putfield b : I
    //   244: iload #9
    //   246: istore #7
    //   248: aload #11
    //   250: astore #10
    //   252: goto -> 470
    //   255: aload_0
    //   256: aload_1
    //   257: aload_3
    //   258: aload #11
    //   260: invokestatic b : (Landroid/content/Context;Lcom/ss/android/socialbase/downloader/g/c;Lorg/json/JSONObject;Lcom/ss/android/socialbase/appdownloader/a;)Z
    //   263: istore #4
    //   265: goto -> 383
    //   268: aload_3
    //   269: invokestatic b : (Lorg/json/JSONObject;)Lcom/ss/android/socialbase/appdownloader/a;
    //   272: astore_2
    //   273: aload_2
    //   274: getfield b : I
    //   277: ifeq -> 327
    //   280: new java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial <init> : ()V
    //   287: astore_0
    //   288: aload_0
    //   289: ldc_w 'runAntiHijack jump_file_manager break, error_code = '
    //   292: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_0
    //   297: aload_2
    //   298: getfield b : I
    //   301: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: ldc_w 'AntiHijackUtils'
    //   308: aload_0
    //   309: invokevirtual toString : ()Ljava/lang/String;
    //   312: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload_2
    //   316: astore_0
    //   317: iload #9
    //   319: istore #7
    //   321: aload_0
    //   322: astore #10
    //   324: goto -> 470
    //   327: aload_1
    //   328: invokevirtual be : ()Z
    //   331: ifne -> 364
    //   334: ldc_w 'AntiHijackUtils'
    //   337: ldc_w 'runAntiHijack jump_file_manager savePathRedirected error'
    //   340: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload #11
    //   345: aload_1
    //   346: iconst_m1
    //   347: invokevirtual j : (I)I
    //   350: putfield b : I
    //   353: iload #9
    //   355: istore #7
    //   357: aload #11
    //   359: astore #10
    //   361: goto -> 470
    //   364: ldc_w 'AntiHijackUtils'
    //   367: ldc_w 'runAntiHijack jump_file_manager start jumpFileManagerPage'
    //   370: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload_0
    //   374: aload_1
    //   375: aload_3
    //   376: aload #11
    //   378: invokestatic a : (Landroid/content/Context;Lcom/ss/android/socialbase/downloader/g/c;Lorg/json/JSONObject;Lcom/ss/android/socialbase/appdownloader/a;)Z
    //   381: istore #4
    //   383: iload #4
    //   385: istore #7
    //   387: aload #11
    //   389: astore #10
    //   391: goto -> 470
    //   394: getstatic android/os/Build$VERSION.SDK_INT : I
    //   397: bipush #26
    //   399: if_icmpge -> 416
    //   402: iload #9
    //   404: istore #7
    //   406: aload #11
    //   408: astore #10
    //   410: invokestatic b : ()Z
    //   413: ifeq -> 470
    //   416: aload_3
    //   417: ldc_w 'enable_for_all'
    //   420: iconst_0
    //   421: invokevirtual optInt : (Ljava/lang/String;I)I
    //   424: iconst_1
    //   425: if_icmpne -> 435
    //   428: iload #6
    //   430: istore #5
    //   432: goto -> 438
    //   435: iconst_0
    //   436: istore #5
    //   438: iload #5
    //   440: ifne -> 456
    //   443: iload #9
    //   445: istore #7
    //   447: aload #11
    //   449: astore #10
    //   451: iload #4
    //   453: ifeq -> 470
    //   456: aload_0
    //   457: aload_2
    //   458: aload_3
    //   459: aload #11
    //   461: invokestatic a : (Landroid/content/Context;Landroid/content/Intent;Lorg/json/JSONObject;Lcom/ss/android/socialbase/appdownloader/a;)Z
    //   464: istore #7
    //   466: aload #11
    //   468: astore #10
    //   470: iload #7
    //   472: ifeq -> 490
    //   475: aload_1
    //   476: invokevirtual bg : ()Landroid/os/Bundle;
    //   479: ldc_w 'anti_hijack_attempt'
    //   482: aload #10
    //   484: invokevirtual a : ()Ljava/lang/String;
    //   487: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   490: getstatic com/ss/android/socialbase/appdownloader/b.a : Lcom/ss/android/socialbase/appdownloader/b$c;
    //   493: astore_0
    //   494: iload #7
    //   496: istore #8
    //   498: aload_0
    //   499: ifnull -> 515
    //   502: aload_0
    //   503: aload_1
    //   504: aload #10
    //   506: invokeinterface a : (Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/appdownloader/a;)V
    //   511: iload #7
    //   513: istore #8
    //   515: iload #8
    //   517: ireturn
  }
  
  protected static boolean a(Context paramContext, com.ss.android.socialbase.downloader.g.c paramc, Intent paramIntent, boolean paramBoolean) {
    JSONArray jSONArray = com.ss.android.socialbase.downloader.k.a.a(paramc.g()).e("anti_plans");
    if (jSONArray != null) {
      int j = jSONArray.length();
      int i;
      for (i = 0; i < j; i++) {
        JSONObject jSONObject = jSONArray.optJSONObject(i);
        if (jSONObject != null && a(jSONObject) && a(paramContext, paramc, paramIntent, jSONObject, paramBoolean))
          return true; 
      } 
    } 
    return false;
  }
  
  private static boolean a(Context paramContext, com.ss.android.socialbase.downloader.g.c paramc, JSONObject paramJSONObject, a parama) {
    if (paramContext != null) {
      if (paramJSONObject == null)
        return false; 
      String str = paramJSONObject.optString("device_plans");
      parama.e = str;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("jumpFileManagerPage devicePlans = ");
      stringBuilder.append(str);
      com.ss.android.socialbase.downloader.f.a.b("AntiHijackUtils", stringBuilder.toString());
      if (!TextUtils.isEmpty(str)) {
        boolean bool;
        String[] arrayOfString = str.split(",");
        str = paramc.k();
        if (TextUtils.isEmpty(str))
          return false; 
        File file = new File(str);
        stringBuilder = new StringBuilder();
        int j = arrayOfString.length;
        int i = 0;
        while (true) {
          bool = true;
          if (i < j) {
            str = arrayOfString[i];
            a a1 = d.a(paramContext, str, paramJSONObject, paramc);
            if (a1 != null) {
              Intent intent = a1.b();
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("try startActivity : ");
              stringBuilder1.append(str);
              com.ss.android.socialbase.downloader.f.a.b("AntiHijackUtils", stringBuilder1.toString());
              if (intent != null) {
                if (a(file, paramc, paramJSONObject)) {
                  try {
                    stringBuilder1 = new StringBuilder();
                    break;
                  } finally {
                    intent = null;
                    com.ss.android.socialbase.downloader.f.a.a("AntiHijackUtils", "try startActivity failed : ", (Throwable)intent);
                    stringBuilder.append(str);
                    stringBuilder.append(" startActivity failed : ");
                    stringBuilder.append(a((Throwable)intent));
                  } 
                } else {
                  a(parama, 6);
                  stringBuilder.append(str);
                  stringBuilder.append(" createDescFile failed! ");
                } 
              } else {
                a(parama, 3);
                stringBuilder.append(str);
                stringBuilder.append(" resolveActivity failed! ");
              } 
            } 
            stringBuilder.append("  ");
            i++;
            continue;
          } 
          bool = false;
          paramContext = null;
          break;
        } 
        if (!bool) {
          parama.c = stringBuilder.toString();
          return bool;
        } 
        parama.d = (String)paramContext;
        parama.b = 0;
        return bool;
      } 
    } 
    return false;
  }
  
  private static boolean a(File paramFile, com.ss.android.socialbase.downloader.g.c paramc, JSONObject paramJSONObject) {
    File file;
    if (paramFile == null)
      return false; 
    String str = paramFile.getPath();
    JSONObject jSONObject1 = com.ss.android.socialbase.downloader.k.a.a(paramc.g()).d("anti_hijack_dir");
    paramJSONObject = null;
    if (jSONObject1 != null) {
      String str1 = jSONObject1.optString("install_desc");
    } else {
      jSONObject1 = null;
    } 
    JSONObject jSONObject2 = paramJSONObject;
    if (!TextUtils.isEmpty((CharSequence)jSONObject1)) {
      jSONObject2 = paramJSONObject;
      if (!TextUtils.isEmpty((CharSequence)jSONObject1)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(File.separator);
        stringBuilder.append((String)jSONObject1);
        file = new File(stringBuilder.toString());
      } 
    } 
    if (file != null)
      try {
        if (file.createNewFile())
          file.deleteOnExit(); 
        return true;
      } catch (IOException iOException) {
        return false;
      }  
    return true;
  }
  
  public static boolean a(JSONArray paramJSONArray) {
    if (paramJSONArray == null)
      return true; 
    int j = paramJSONArray.length();
    if (j == 0)
      return true; 
    int i = 0;
    boolean bool;
    for (bool = false; i < j; bool = bool1) {
      JSONObject jSONObject = paramJSONArray.optJSONObject(i);
      boolean bool1 = bool;
      if (jSONObject != null) {
        String str = jSONObject.optString("package_names");
        JSONArray jSONArray1 = jSONObject.optJSONArray("version_white");
        JSONArray jSONArray2 = jSONObject.optJSONArray("version_black");
        if (!TextUtils.isEmpty(str)) {
          if (jSONArray1 == null && jSONArray2 == null)
            return false; 
          String[] arrayOfString = str.split(",");
          bool1 = bool;
          if (arrayOfString != null) {
            int m = arrayOfString.length;
            for (int k = 0; k < m; k++) {
              com.ss.android.socialbase.downloader.m.a.a a1 = b(arrayOfString[k]);
              if (a1 != null) {
                bool1 = a(jSONArray1, jSONArray2, a1);
                bool = bool1;
                if (!bool1)
                  return false; 
              } 
            } 
            bool1 = bool;
          } 
        } else {
          return false;
        } 
      } 
      i++;
    } 
    return bool;
  }
  
  private static boolean a(JSONArray paramJSONArray, String paramString) {
    if (paramJSONArray != null) {
      if (paramString == null)
        return false; 
      int j = paramJSONArray.length();
      for (int i = 0; i < j; i++) {
        if (paramString.equalsIgnoreCase(paramJSONArray.optString(i).trim()))
          return true; 
      } 
    } 
    return false;
  }
  
  private static boolean a(JSONArray paramJSONArray1, JSONArray paramJSONArray2, com.ss.android.socialbase.downloader.m.a.a parama) {
    String str2 = parama.g();
    int i = parama.f();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i);
    stringBuilder.append("_");
    stringBuilder.append(str2);
    String str1 = stringBuilder.toString();
    if (paramJSONArray1 != null && paramJSONArray1.length() > 0) {
      if (a(paramJSONArray1, str1))
        return true; 
    } else if (paramJSONArray2 != null && paramJSONArray2.length() > 0 && !a(paramJSONArray2, str1)) {
      return true;
    } 
    return false;
  }
  
  private static boolean a(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return true; 
    String str1 = paramJSONObject.optString("device_rom");
    if (TextUtils.isEmpty(str1))
      return true; 
    String str2 = i.f();
    return TextUtils.isEmpty(str2) ? false : (str1.toLowerCase().contains(str2.toLowerCase()));
  }
  
  private static a b(JSONObject paramJSONObject) {
    a a1 = new a();
    if (paramJSONObject == null)
      return a1; 
    String str = paramJSONObject.optString("type");
    a1.a = str;
    JSONArray jSONArray = paramJSONObject.optJSONArray("device_requirements");
    try {
      return a1;
    } finally {
      paramJSONObject = null;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("checkJumpFileManagerConfig");
      stringBuilder.append(a((Throwable)paramJSONObject));
      a1.c = stringBuilder.toString();
      a(a1, 4);
    } 
  }
  
  private static com.ss.android.socialbase.downloader.m.a.a b(String paramString) {
    com.ss.android.socialbase.downloader.m.a.a a1;
    boolean bool = b.containsKey(paramString);
    String str = null;
    if (bool) {
      com.ss.android.socialbase.downloader.m.a.a a2 = b.get(paramString);
      paramString = str;
      if (a2 != null)
        return a2; 
    } else {
      com.ss.android.socialbase.downloader.m.a.a a2 = com.ss.android.socialbase.downloader.m.a.a(paramString);
      b.put(paramString, a2);
      paramString = str;
      if (a2 != null)
        a1 = a2; 
    } 
    return a1;
  }
  
  private static boolean b(Context paramContext, Intent paramIntent) {
    return a(paramContext, paramIntent, true);
  }
  
  private static boolean b(Context paramContext, com.ss.android.socialbase.downloader.g.c paramc, JSONObject paramJSONObject, a parama) {
    if (paramContext != null) {
      if (paramJSONObject == null)
        return false; 
      String str = paramc.k();
      if (TextUtils.isEmpty(str))
        return false; 
      parama.d = "custom";
      a a1 = d.a(paramContext, "custom", paramJSONObject, paramc);
      if (a1 == null || !a1.a()) {
        parama.b = 3;
        return false;
      } 
      Intent intent = a1.b();
      if (intent == null)
        return false; 
      if (a(new File(str), paramc, paramJSONObject)) {
        if (b(paramContext, intent)) {
          parama.b = 0;
          return true;
        } 
        parama.b = 1;
        return false;
      } 
      parama.b = 6;
      return false;
    } 
    return false;
  }
  
  private static boolean d(Context paramContext) {
    if (paramContext == null)
      return true; 
    try {
      return (i > 0);
    } finally {
      paramContext = null;
    } 
  }
  
  private static boolean e(Context paramContext) {
    if (paramContext == null)
      return true; 
    try {
      return paramContext.getPackageManager().canRequestPackageInstalls();
    } finally {
      paramContext = null;
    } 
  }
  
  static class a implements com.ss.android.socialbase.downloader.a.a.a {
    private final b.e a;
    
    private final int b;
    
    private JSONObject c;
    
    public a(Context param1Context, Intent param1Intent, JSONObject param1JSONObject, b.b param1b) {
      this.c = param1JSONObject;
      this.b = param1JSONObject.optInt("query_interval", 1000);
      this.a = new b.e(param1Context, param1Intent, param1b, this.b);
    }
    
    public void b() {
      if (!b.e.a(this.a)) {
        Message message = Message.obtain();
        message.what = 2;
        b.e.b(this.a).sendMessage(message);
      } 
      com.ss.android.socialbase.downloader.a.a.a().b(this);
      b.a((a)null);
    }
    
    public void c() {
      if (Build.VERSION.SDK_INT < 29) {
        int i = this.c.optInt("time_out_second", 10);
        Message message = Message.obtain();
        message.what = 1;
        b.e.b(this.a).sendMessage(message);
        if (i > 0 && i < 60) {
          message = Message.obtain();
          message.what = 2;
          b.e.b(this.a).sendMessageDelayed(message, (i * 1000));
        } 
      } 
    }
  }
  
  static interface b {
    boolean a(Context param1Context);
  }
  
  public static interface c {
    void a(com.ss.android.socialbase.downloader.g.c param1c, a param1a);
  }
  
  static class d implements Callable<Boolean> {
    private final Context a;
    
    private final b.b b;
    
    private final Handler c;
    
    private final long d;
    
    public d(Handler param1Handler, Context param1Context, b.b param1b, long param1Long) {
      this.a = param1Context;
      this.b = param1b;
      this.c = param1Handler;
      this.d = param1Long;
    }
    
    public Boolean a() throws Exception {
      try {
        boolean bool;
        if (this.b == null || this.d <= 0L || this.d > 10000L)
          return Boolean.valueOf(false); 
        Context context = this.a;
        if (context != null) {
          bool = this.b.a(context);
        } else {
          bool = false;
        } 
        Message message = Message.obtain();
        if (bool) {
          message.what = 2;
          this.c.sendMessage(message);
        } else {
          message.what = 1;
          this.c.sendMessageDelayed(message, this.d);
        } 
      } finally {
        Exception exception;
      } 
      return Boolean.valueOf(false);
    }
  }
  
  static class e implements f.a {
    private final Context a;
    
    private final Intent b;
    
    private final b.b c;
    
    private final Handler d;
    
    private final long e;
    
    private Future<Boolean> f;
    
    private boolean g = false;
    
    public e(Context param1Context, Intent param1Intent, b.b param1b, long param1Long) {
      this.a = param1Context;
      this.b = param1Intent;
      this.c = param1b;
      this.d = (Handler)new f(Looper.getMainLooper(), this);
      this.e = param1Long;
    }
    
    public void a(Message param1Message) {
      if (param1Message != null) {
        if (param1Message.what == 1) {
          long l = this.e;
          if (l > 0L) {
            if (l > 10000L)
              return; 
            this.f = com.ss.android.socialbase.downloader.downloader.b.j().submit(new b.d(this.d, this.a, this.c, this.e));
            return;
          } 
          return;
        } 
        if (param1Message.what == 2) {
          this.d.removeMessages(2);
          this.d.removeMessages(1);
          Future<Boolean> future = this.f;
          if (future != null)
            future.cancel(true); 
          if (!this.g) {
            b.a(this.a, this.b);
            this.g = true;
          } 
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */