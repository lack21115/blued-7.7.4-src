package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.b.a;
import com.ss.android.socialbase.appdownloader.c.c;
import com.ss.android.socialbase.appdownloader.c.d;
import com.ss.android.socialbase.appdownloader.c.e;
import com.ss.android.socialbase.appdownloader.c.f;
import com.ss.android.socialbase.appdownloader.c.g;
import com.ss.android.socialbase.appdownloader.c.h;
import com.ss.android.socialbase.appdownloader.c.i;
import com.ss.android.socialbase.appdownloader.c.l;
import com.ss.android.socialbase.appdownloader.c.m;
import com.ss.android.socialbase.appdownloader.d.b;
import com.ss.android.socialbase.downloader.d.l;
import com.ss.android.socialbase.downloader.d.z;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.downloader.m;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.k.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d {
  private static final String a = d.class.getSimpleName();
  
  private static volatile d b = null;
  
  private static boolean l = false;
  
  private static boolean m = false;
  
  private c c;
  
  private d d;
  
  private h e;
  
  private g f;
  
  private l g;
  
  private i h;
  
  private String i;
  
  private String j;
  
  private DownloadReceiver k;
  
  private boolean n = false;
  
  private boolean o = true;
  
  private f p;
  
  private String q;
  
  private int a(g paramg, String paramString) {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/appdownloader/d.a : Ljava/lang/String;
    //   3: ldc 'start redirectSavePathIfPossible'
    //   5: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_1
    //   9: invokevirtual U : ()Lorg/json/JSONObject;
    //   12: invokestatic a : (Lorg/json/JSONObject;)Lcom/ss/android/socialbase/downloader/k/a;
    //   15: astore #10
    //   17: aload #10
    //   19: ldc 'anti_hijack_dir'
    //   21: invokevirtual d : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   24: astore #7
    //   26: iconst_1
    //   27: istore #6
    //   29: aload #7
    //   31: ifnull -> 52
    //   34: aload #7
    //   36: ldc 'ignore_task_save_path'
    //   38: iconst_0
    //   39: invokevirtual optInt : (Ljava/lang/String;I)I
    //   42: iconst_1
    //   43: if_icmpne -> 52
    //   46: iconst_1
    //   47: istore #4
    //   49: goto -> 55
    //   52: iconst_0
    //   53: istore #4
    //   55: aload_1
    //   56: invokevirtual d : ()Ljava/lang/String;
    //   59: astore #9
    //   61: aload_1
    //   62: invokevirtual L : ()Ljava/lang/String;
    //   65: astore #7
    //   67: aload #7
    //   69: astore #8
    //   71: aload #7
    //   73: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   76: ifeq -> 92
    //   79: aload_2
    //   80: aload #9
    //   82: aload_1
    //   83: invokevirtual n : ()Ljava/lang/String;
    //   86: iconst_1
    //   87: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   90: astore #8
    //   92: aload #8
    //   94: astore #7
    //   96: aload #8
    //   98: invokevirtual length : ()I
    //   101: sipush #255
    //   104: if_icmple -> 123
    //   107: aload #8
    //   109: aload #8
    //   111: invokevirtual length : ()I
    //   114: sipush #255
    //   117: isub
    //   118: invokevirtual substring : (I)Ljava/lang/String;
    //   121: astore #7
    //   123: aload #9
    //   125: astore #8
    //   127: aload #9
    //   129: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   132: ifeq -> 139
    //   135: aload #7
    //   137: astore #8
    //   139: aload_1
    //   140: invokevirtual b : ()Landroid/content/Context;
    //   143: aload #8
    //   145: aload #10
    //   147: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Lcom/ss/android/socialbase/downloader/k/a;)Ljava/lang/String;
    //   150: astore #8
    //   152: aload_1
    //   153: invokevirtual b : ()Landroid/content/Context;
    //   156: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   159: astore #9
    //   161: aload_1
    //   162: invokevirtual e : ()Ljava/lang/String;
    //   165: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   168: ifne -> 206
    //   171: iload #6
    //   173: istore #5
    //   175: aload_1
    //   176: invokevirtual e : ()Ljava/lang/String;
    //   179: aload #8
    //   181: invokevirtual equals : (Ljava/lang/Object;)Z
    //   184: ifne -> 209
    //   187: aload_1
    //   188: invokevirtual e : ()Ljava/lang/String;
    //   191: aload #9
    //   193: invokevirtual equals : (Ljava/lang/Object;)Z
    //   196: ifeq -> 206
    //   199: iload #6
    //   201: istore #5
    //   203: goto -> 209
    //   206: iconst_0
    //   207: istore #5
    //   209: getstatic com/ss/android/socialbase/appdownloader/d.a : Ljava/lang/String;
    //   212: astore #11
    //   214: new java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial <init> : ()V
    //   221: astore #12
    //   223: aload #12
    //   225: ldc 'ignoreTaskSavePath = '
    //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload #12
    //   233: iload #4
    //   235: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload #12
    //   241: ldc '\\tisSavePathDefaultOrRedirected = '
    //   243: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload #12
    //   249: iload #5
    //   251: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload #12
    //   257: ldc '\\nbuilder.getSavePath = '
    //   259: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload #12
    //   265: aload_1
    //   266: invokevirtual e : ()Ljava/lang/String;
    //   269: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload #12
    //   275: ldc '\\npossibleRedirectSavePath = '
    //   277: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload #12
    //   283: aload #8
    //   285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload #12
    //   291: ldc '\\ndefaultSavePath = '
    //   293: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload #12
    //   299: aload #9
    //   301: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload #11
    //   307: aload #12
    //   309: invokevirtual toString : ()Ljava/lang/String;
    //   312: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   315: iload #4
    //   317: ifne -> 349
    //   320: aload_1
    //   321: invokevirtual e : ()Ljava/lang/String;
    //   324: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   327: ifne -> 349
    //   330: iload #5
    //   332: ifeq -> 338
    //   335: goto -> 349
    //   338: getstatic com/ss/android/socialbase/appdownloader/d.a : Ljava/lang/String;
    //   341: ldc 'redirectSavePath error'
    //   343: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   346: bipush #7
    //   348: ireturn
    //   349: aload_0
    //   350: aload_1
    //   351: invokevirtual b : ()Landroid/content/Context;
    //   354: aload_2
    //   355: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/g/c;
    //   358: astore_2
    //   359: aload_2
    //   360: ifnull -> 405
    //   363: aload_2
    //   364: invokevirtual be : ()Z
    //   367: ifeq -> 405
    //   370: getstatic com/ss/android/socialbase/appdownloader/d.a : Ljava/lang/String;
    //   373: ldc 'relatedUrlDownload.isSavePathRedirected is true'
    //   375: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   378: aload_1
    //   379: aload_2
    //   380: invokevirtual k : ()Ljava/lang/String;
    //   383: invokevirtual c : (Ljava/lang/String;)Lcom/ss/android/socialbase/appdownloader/g;
    //   386: pop
    //   387: aload_1
    //   388: new org/json/JSONObject
    //   391: dup
    //   392: aload_2
    //   393: invokevirtual M : ()Ljava/lang/String;
    //   396: invokespecial <init> : (Ljava/lang/String;)V
    //   399: invokevirtual a : (Lorg/json/JSONObject;)Lcom/ss/android/socialbase/appdownloader/g;
    //   402: pop
    //   403: iconst_0
    //   404: ireturn
    //   405: aload_2
    //   406: ifnonnull -> 454
    //   409: ldc 'application/vnd.android.package-archive'
    //   411: aload_0
    //   412: aload #7
    //   414: aload_1
    //   415: invokevirtual n : ()Ljava/lang/String;
    //   418: invokespecial a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   421: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   424: ifeq -> 454
    //   427: getstatic com/ss/android/socialbase/appdownloader/d.a : Ljava/lang/String;
    //   430: ldc 'relatedUrlDownload is null && mimetype is apk'
    //   432: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   435: aload #10
    //   437: invokestatic a : (Lcom/ss/android/socialbase/downloader/k/a;)I
    //   440: istore_3
    //   441: iload_3
    //   442: ifne -> 452
    //   445: aload_1
    //   446: aload #8
    //   448: invokevirtual c : (Ljava/lang/String;)Lcom/ss/android/socialbase/appdownloader/g;
    //   451: pop
    //   452: iload_3
    //   453: ireturn
    //   454: aload_2
    //   455: ifnull -> 469
    //   458: getstatic com/ss/android/socialbase/appdownloader/d.a : Ljava/lang/String;
    //   461: ldc 'relatedUrlDownload is not null'
    //   463: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   466: bipush #8
    //   468: ireturn
    //   469: getstatic com/ss/android/socialbase/appdownloader/d.a : Ljava/lang/String;
    //   472: ldc 'mimetype is not apk'
    //   474: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   477: bipush #9
    //   479: ireturn
    //   480: astore_1
    //   481: goto -> 403
    // Exception table:
    //   from	to	target	type
    //   387	403	480	finally
  }
  
  private z a(e parame) {
    return (parame == null) ? null : new z(this, parame) {
        public String a() {
          return this.a.a();
        }
        
        public void a(int param1Int, c param1c, String param1String1, String param1String2) {
          if (param1Int != 1 && param1Int != 3)
            switch (param1Int) {
              default:
                return;
              case 10:
                this.a.a(param1c);
                return;
              case 9:
                this.a.a(b.B(), param1String1);
                return;
              case 8:
                this.a.a(param1Int, param1c.z(), param1String1, param1String2);
                return;
              case 5:
              case 6:
              case 7:
                break;
            }  
          this.a.a(param1Int, param1String1, param1c.q(), param1c.aw());
        }
        
        public boolean a(boolean param1Boolean) {
          return this.a.a(param1Boolean);
        }
      };
  }
  
  private c a(Context paramContext, String paramString, File paramFile) {
    return (paramContext == null || TextUtils.isEmpty(paramString) || paramFile == null) ? null : f.a(paramContext).a(paramString, paramFile.getAbsolutePath());
  }
  
  private String a(String paramString1, String paramString2) {
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      str = paramString2;
      if (paramString1.endsWith(".apk")) {
        str = paramString2;
        if (!c.d(paramString2))
          str = "application/vnd.android.package-archive"; 
      } 
    } 
    return str;
  }
  
  private List<e> a(List<e> paramList) {
    ArrayList<e> arrayList = new ArrayList();
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (paramList != null) {
      bool2 = bool3;
      if (paramList.size() > 0) {
        Iterator<e> iterator = paramList.iterator();
        while (true) {
          bool2 = bool1;
          if (iterator.hasNext()) {
            e e = iterator.next();
            if (e != null && !TextUtils.isEmpty(e.a()) && !TextUtils.isEmpty(e.b())) {
              if (e.a().equals("User-Agent"))
                bool1 = true; 
              arrayList.add(new e(e.a(), e.b()));
            } 
            continue;
          } 
          break;
        } 
      } 
    } 
    if (!bool2)
      arrayList.add(new e("User-Agent", a.a)); 
    return arrayList;
  }
  
  private void a(com.ss.android.socialbase.downloader.g.d paramd, int paramInt, boolean paramBoolean) {
    if (paramd == null)
      return; 
    paramd.n();
    c c1 = paramd.a();
    if (c1 != null)
      c1.k(paramInt); 
    if (c1 != null && paramBoolean)
      c1.m(paramBoolean); 
  }
  
  public static boolean a(Context paramContext, int paramInt) {
    return (c.a(paramContext, paramInt, true) == 1);
  }
  
  private c b(Context paramContext, String paramString) {
    List list = f.a(paramContext).a(paramString);
    if (list != null)
      for (c c1 : list) {
        if (c1 != null && c1.be())
          return c1; 
      }  
    return null;
  }
  
  public static d h() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/appdownloader/d.b : Lcom/ss/android/socialbase/appdownloader/d;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/appdownloader/d
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/appdownloader/d.b : Lcom/ss/android/socialbase/appdownloader/d;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/appdownloader/d
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/appdownloader/d.b : Lcom/ss/android/socialbase/appdownloader/d;
    //   25: ldc com/ss/android/socialbase/appdownloader/d
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/appdownloader/d
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/appdownloader/d.b : Lcom/ss/android/socialbase/appdownloader/d;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void m() {
    if (m)
      return; 
    if (this.k == null)
      this.k = new DownloadReceiver(); 
    try {
      IntentFilter intentFilter1 = new IntentFilter();
      intentFilter1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      intentFilter1.addAction("android.intent.action.BOOT_COMPLETED");
      intentFilter1.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
      IntentFilter intentFilter2 = new IntentFilter();
      intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
      intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
      intentFilter2.addDataScheme("package");
      IntentFilter intentFilter3 = new IntentFilter();
      intentFilter3.addAction("android.intent.action.MEDIA_MOUNTED");
      intentFilter3.addDataScheme("file");
      b.B().registerReceiver(this.k, intentFilter1);
      b.B().registerReceiver(this.k, intentFilter2);
      b.B().registerReceiver(this.k, intentFilter3);
      m = true;
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public int a(g paramg) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 1072
    //   4: aload_1
    //   5: invokevirtual b : ()Landroid/content/Context;
    //   8: ifnonnull -> 14
    //   11: goto -> 1072
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual f : ()Ljava/util/List;
    //   19: invokespecial a : (Ljava/util/List;)Ljava/util/List;
    //   22: astore #15
    //   24: aload_1
    //   25: invokevirtual c : ()Ljava/lang/String;
    //   28: astore #16
    //   30: aload #16
    //   32: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   35: istore #4
    //   37: iload #4
    //   39: ifeq -> 44
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_0
    //   45: aload_1
    //   46: aload #16
    //   48: invokespecial a : (Lcom/ss/android/socialbase/appdownloader/g;Ljava/lang/String;)I
    //   51: istore_2
    //   52: goto -> 101
    //   55: astore #7
    //   57: getstatic com/ss/android/socialbase/appdownloader/d.a : Ljava/lang/String;
    //   60: astore #8
    //   62: new java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial <init> : ()V
    //   69: astore #9
    //   71: aload #9
    //   73: ldc_w 'redirectSavePathIfEmpty: throwable = '
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload #9
    //   82: aload #7
    //   84: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload #8
    //   90: aload #9
    //   92: invokevirtual toString : ()Ljava/lang/String;
    //   95: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   98: pop
    //   99: iconst_4
    //   100: istore_2
    //   101: getstatic com/ss/android/socialbase/appdownloader/d.a : Ljava/lang/String;
    //   104: astore #7
    //   106: new java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial <init> : ()V
    //   113: astore #8
    //   115: aload #8
    //   117: ldc_w 'antihijackErrorCode = '
    //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload #8
    //   126: iload_2
    //   127: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload #7
    //   133: aload #8
    //   135: invokevirtual toString : ()Ljava/lang/String;
    //   138: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   141: iload_2
    //   142: ifne -> 1088
    //   145: iconst_1
    //   146: istore #4
    //   148: goto -> 151
    //   151: aload_1
    //   152: invokevirtual L : ()Ljava/lang/String;
    //   155: astore #7
    //   157: aload_1
    //   158: invokevirtual d : ()Ljava/lang/String;
    //   161: astore #10
    //   163: aload #7
    //   165: astore #8
    //   167: aload #7
    //   169: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   172: ifeq -> 190
    //   175: aload #16
    //   177: aload #10
    //   179: aload_1
    //   180: invokevirtual n : ()Ljava/lang/String;
    //   183: iload #4
    //   185: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   188: astore #8
    //   190: aload #8
    //   192: astore #7
    //   194: aload #8
    //   196: invokevirtual length : ()I
    //   199: sipush #255
    //   202: if_icmple -> 221
    //   205: aload #8
    //   207: aload #8
    //   209: invokevirtual length : ()I
    //   212: sipush #255
    //   215: isub
    //   216: invokevirtual substring : (I)Ljava/lang/String;
    //   219: astore #7
    //   221: aload #10
    //   223: astore #9
    //   225: aload #10
    //   227: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   230: ifeq -> 237
    //   233: aload #7
    //   235: astore #9
    //   237: aload_1
    //   238: invokevirtual n : ()Ljava/lang/String;
    //   241: astore #8
    //   243: aload #8
    //   245: astore #10
    //   247: aload #7
    //   249: ldc '.apk'
    //   251: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   254: ifeq -> 275
    //   257: aload #8
    //   259: astore #10
    //   261: aload_1
    //   262: invokevirtual n : ()Ljava/lang/String;
    //   265: invokestatic d : (Ljava/lang/String;)Z
    //   268: ifne -> 275
    //   271: ldc 'application/vnd.android.package-archive'
    //   273: astore #10
    //   275: aload_1
    //   276: invokevirtual e : ()Ljava/lang/String;
    //   279: astore #11
    //   281: aload_1
    //   282: invokevirtual e : ()Ljava/lang/String;
    //   285: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   288: ifeq -> 300
    //   291: aload_1
    //   292: invokevirtual b : ()Landroid/content/Context;
    //   295: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   298: astore #11
    //   300: aload #11
    //   302: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   305: ifne -> 1018
    //   308: aload #7
    //   310: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   313: ifeq -> 319
    //   316: goto -> 1018
    //   319: aload #16
    //   321: aload #11
    //   323: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   326: istore_3
    //   327: aload_1
    //   328: invokevirtual U : ()Lorg/json/JSONObject;
    //   331: invokestatic a : (Lorg/json/JSONObject;)Lcom/ss/android/socialbase/downloader/k/a;
    //   334: ldc_w 'resume_task_override_settings'
    //   337: invokevirtual a : (Ljava/lang/String;)Z
    //   340: ifeq -> 377
    //   343: invokestatic B : ()Landroid/content/Context;
    //   346: invokestatic a : (Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/downloader/f;
    //   349: iload_3
    //   350: invokevirtual h : (I)Lcom/ss/android/socialbase/downloader/g/c;
    //   353: astore #8
    //   355: aload #8
    //   357: ifnull -> 377
    //   360: aload_1
    //   361: new org/json/JSONObject
    //   364: dup
    //   365: aload #8
    //   367: invokevirtual M : ()Ljava/lang/String;
    //   370: invokespecial <init> : (Ljava/lang/String;)V
    //   373: invokevirtual a : (Lorg/json/JSONObject;)Lcom/ss/android/socialbase/appdownloader/g;
    //   376: pop
    //   377: iload_3
    //   378: aload_1
    //   379: invokevirtual U : ()Lorg/json/JSONObject;
    //   382: invokestatic a : (ILorg/json/JSONObject;)V
    //   385: aload_1
    //   386: invokevirtual K : ()Z
    //   389: istore #5
    //   391: iload #5
    //   393: ifne -> 1094
    //   396: aload #11
    //   398: aload #7
    //   400: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)Z
    //   403: ifeq -> 1094
    //   406: aload_1
    //   407: invokevirtual b : ()Landroid/content/Context;
    //   410: invokestatic a : (Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/downloader/f;
    //   413: iload_3
    //   414: invokevirtual h : (I)Lcom/ss/android/socialbase/downloader/g/c;
    //   417: ifnonnull -> 1094
    //   420: iconst_1
    //   421: istore #5
    //   423: goto -> 426
    //   426: aload_1
    //   427: invokevirtual l : ()Lcom/ss/android/socialbase/downloader/d/w;
    //   430: astore #12
    //   432: aload #12
    //   434: astore #8
    //   436: aload #12
    //   438: ifnonnull -> 1097
    //   441: aload_1
    //   442: invokevirtual g : ()Z
    //   445: ifne -> 459
    //   448: aload #12
    //   450: astore #8
    //   452: aload_1
    //   453: invokevirtual h : ()Z
    //   456: ifeq -> 1097
    //   459: aload_1
    //   460: invokevirtual p : ()Lcom/ss/android/socialbase/downloader/notification/a;
    //   463: ifnull -> 482
    //   466: new com/ss/android/socialbase/appdownloader/h
    //   469: dup
    //   470: aload_1
    //   471: invokevirtual p : ()Lcom/ss/android/socialbase/downloader/notification/a;
    //   474: invokespecial <init> : (Lcom/ss/android/socialbase/downloader/notification/a;)V
    //   477: astore #8
    //   479: goto -> 1097
    //   482: new com/ss/android/socialbase/appdownloader/h
    //   485: dup
    //   486: aload_1
    //   487: invokevirtual b : ()Landroid/content/Context;
    //   490: iload_3
    //   491: aload #9
    //   493: aload #11
    //   495: aload #7
    //   497: aload_1
    //   498: invokevirtual m : ()Ljava/lang/String;
    //   501: invokespecial <init> : (Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   504: astore #8
    //   506: aload_1
    //   507: invokevirtual N : ()Lcom/ss/android/socialbase/downloader/d/l;
    //   510: astore #13
    //   512: aload #13
    //   514: astore #12
    //   516: aload #13
    //   518: ifnonnull -> 531
    //   521: new com/ss/android/socialbase/appdownloader/d$1
    //   524: dup
    //   525: aload_0
    //   526: invokespecial <init> : (Lcom/ss/android/socialbase/appdownloader/d;)V
    //   529: astore #12
    //   531: aload_1
    //   532: invokevirtual m : ()Ljava/lang/String;
    //   535: astore #14
    //   537: aload #14
    //   539: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   542: ifne -> 559
    //   545: new org/json/JSONObject
    //   548: dup
    //   549: aload #14
    //   551: invokespecial <init> : (Ljava/lang/String;)V
    //   554: astore #13
    //   556: goto -> 568
    //   559: new org/json/JSONObject
    //   562: dup
    //   563: invokespecial <init> : ()V
    //   566: astore #13
    //   568: aload #13
    //   570: ldc_w 'auto_install_with_notification'
    //   573: aload_1
    //   574: invokevirtual i : ()Z
    //   577: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   580: pop
    //   581: aload #13
    //   583: ldc_w 'auto_install_without_notification'
    //   586: aload_1
    //   587: invokevirtual h : ()Z
    //   590: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   593: pop
    //   594: aload #13
    //   596: invokevirtual toString : ()Ljava/lang/String;
    //   599: astore #13
    //   601: aload_1
    //   602: invokevirtual g : ()Z
    //   605: ifne -> 1106
    //   608: aload_1
    //   609: invokevirtual h : ()Z
    //   612: ifeq -> 1100
    //   615: goto -> 1106
    //   618: aload_1
    //   619: invokevirtual b : ()Landroid/content/Context;
    //   622: invokestatic b : (Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/g/d;
    //   625: aload #16
    //   627: invokevirtual c : (Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/g/d;
    //   630: aload_1
    //   631: invokevirtual S : ()Ljava/util/List;
    //   634: invokevirtual b : (Ljava/util/List;)Lcom/ss/android/socialbase/downloader/g/d;
    //   637: aload #7
    //   639: invokevirtual a : (Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/g/d;
    //   642: aload #9
    //   644: invokevirtual b : (Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/g/d;
    //   647: aload #11
    //   649: invokevirtual d : (Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/g/d;
    //   652: aload_1
    //   653: invokevirtual j : ()Z
    //   656: invokevirtual b : (Z)Lcom/ss/android/socialbase/downloader/g/d;
    //   659: aload #15
    //   661: invokevirtual a : (Ljava/util/List;)Lcom/ss/android/socialbase/downloader/g/d;
    //   664: aload #12
    //   666: invokevirtual a : (Lcom/ss/android/socialbase/downloader/d/l;)Lcom/ss/android/socialbase/downloader/g/d;
    //   669: aload_1
    //   670: invokevirtual w : ()I
    //   673: invokevirtual a : (I)Lcom/ss/android/socialbase/downloader/g/d;
    //   676: aload_1
    //   677: invokevirtual x : ()I
    //   680: invokevirtual b : (I)Lcom/ss/android/socialbase/downloader/g/d;
    //   683: iload #6
    //   685: invokevirtual d : (Z)Lcom/ss/android/socialbase/downloader/g/d;
    //   688: aload #13
    //   690: invokevirtual e : (Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/g/d;
    //   693: aload #10
    //   695: invokevirtual f : (Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/g/d;
    //   698: aload_1
    //   699: invokevirtual D : ()I
    //   702: invokevirtual d : (I)Lcom/ss/android/socialbase/downloader/g/d;
    //   705: aload_1
    //   706: invokevirtual E : ()I
    //   709: invokevirtual c : (I)Lcom/ss/android/socialbase/downloader/g/d;
    //   712: aload_1
    //   713: invokevirtual k : ()Lcom/ss/android/socialbase/downloader/d/w;
    //   716: invokevirtual a : (Lcom/ss/android/socialbase/downloader/d/w;)Lcom/ss/android/socialbase/downloader/g/d;
    //   719: aload #8
    //   721: invokevirtual b : (Lcom/ss/android/socialbase/downloader/d/w;)Lcom/ss/android/socialbase/downloader/g/d;
    //   724: aload_0
    //   725: aload_1
    //   726: invokevirtual O : ()Lcom/ss/android/socialbase/appdownloader/c/e;
    //   729: invokespecial a : (Lcom/ss/android/socialbase/appdownloader/c/e;)Lcom/ss/android/socialbase/downloader/d/z;
    //   732: invokevirtual a : (Lcom/ss/android/socialbase/downloader/d/z;)Lcom/ss/android/socialbase/downloader/g/d;
    //   735: iload #5
    //   737: invokevirtual c : (Z)Lcom/ss/android/socialbase/downloader/g/d;
    //   740: aload_1
    //   741: invokevirtual s : ()Z
    //   744: invokevirtual f : (Z)Lcom/ss/android/socialbase/downloader/g/d;
    //   747: aload_1
    //   748: invokevirtual t : ()Z
    //   751: invokevirtual g : (Z)Lcom/ss/android/socialbase/downloader/g/d;
    //   754: aload_1
    //   755: invokevirtual q : ()Lcom/ss/android/socialbase/downloader/downloader/i;
    //   758: invokevirtual a : (Lcom/ss/android/socialbase/downloader/downloader/i;)Lcom/ss/android/socialbase/downloader/g/d;
    //   761: aload_1
    //   762: invokevirtual r : ()Lcom/ss/android/socialbase/downloader/downloader/h;
    //   765: invokevirtual a : (Lcom/ss/android/socialbase/downloader/downloader/h;)Lcom/ss/android/socialbase/downloader/g/d;
    //   768: aload_1
    //   769: invokevirtual o : ()Z
    //   772: invokevirtual e : (Z)Lcom/ss/android/socialbase/downloader/g/d;
    //   775: aload_1
    //   776: invokevirtual u : ()Ljava/lang/String;
    //   779: invokevirtual g : (Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/g/d;
    //   782: aload_1
    //   783: invokevirtual v : ()Ljava/lang/String;
    //   786: invokevirtual h : (Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/g/d;
    //   789: aload_1
    //   790: invokevirtual y : ()Z
    //   793: invokevirtual h : (Z)Lcom/ss/android/socialbase/downloader/g/d;
    //   796: aload_1
    //   797: invokevirtual z : ()Ljava/lang/String;
    //   800: invokevirtual i : (Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/g/d;
    //   803: aload_1
    //   804: invokevirtual A : ()Z
    //   807: invokevirtual i : (Z)Lcom/ss/android/socialbase/downloader/g/d;
    //   810: aload_1
    //   811: invokevirtual B : ()Z
    //   814: invokevirtual j : (Z)Lcom/ss/android/socialbase/downloader/g/d;
    //   817: aload_1
    //   818: invokevirtual F : ()Z
    //   821: invokevirtual l : (Z)Lcom/ss/android/socialbase/downloader/g/d;
    //   824: aload_1
    //   825: invokevirtual G : ()Z
    //   828: invokevirtual m : (Z)Lcom/ss/android/socialbase/downloader/g/d;
    //   831: aload_1
    //   832: invokevirtual J : ()Lcom/ss/android/socialbase/downloader/b/g;
    //   835: invokevirtual a : (Lcom/ss/android/socialbase/downloader/b/g;)Lcom/ss/android/socialbase/downloader/g/d;
    //   838: aload_1
    //   839: invokevirtual M : ()Lcom/ss/android/socialbase/downloader/d/x;
    //   842: invokevirtual a : (Lcom/ss/android/socialbase/downloader/d/x;)Lcom/ss/android/socialbase/downloader/g/d;
    //   845: aload_1
    //   846: invokevirtual C : ()Lcom/ss/android/socialbase/downloader/downloader/r;
    //   849: invokevirtual a : (Lcom/ss/android/socialbase/downloader/downloader/r;)Lcom/ss/android/socialbase/downloader/g/d;
    //   852: aload_1
    //   853: invokevirtual H : ()Z
    //   856: invokevirtual n : (Z)Lcom/ss/android/socialbase/downloader/g/d;
    //   859: aload_1
    //   860: invokevirtual P : ()Lcom/ss/android/socialbase/downloader/d/q;
    //   863: invokevirtual a : (Lcom/ss/android/socialbase/downloader/d/q;)Lcom/ss/android/socialbase/downloader/g/d;
    //   866: aload_1
    //   867: invokevirtual T : ()Lcom/ss/android/socialbase/downloader/d/p;
    //   870: invokevirtual a : (Lcom/ss/android/socialbase/downloader/d/p;)Lcom/ss/android/socialbase/downloader/g/d;
    //   873: aload_1
    //   874: invokevirtual I : ()Z
    //   877: invokevirtual k : (Z)Lcom/ss/android/socialbase/downloader/g/d;
    //   880: aload_1
    //   881: invokevirtual Q : ()Lcom/ss/android/socialbase/downloader/d/ac;
    //   884: invokevirtual a : (Lcom/ss/android/socialbase/downloader/d/ac;)Lcom/ss/android/socialbase/downloader/g/d;
    //   887: aload_1
    //   888: invokevirtual U : ()Lorg/json/JSONObject;
    //   891: invokevirtual a : (Lorg/json/JSONObject;)Lcom/ss/android/socialbase/downloader/g/d;
    //   894: astore #7
    //   896: aload #7
    //   898: ifnull -> 1016
    //   901: iload #6
    //   903: ifeq -> 960
    //   906: aload_1
    //   907: invokevirtual R : ()Z
    //   910: ifeq -> 960
    //   913: aload_1
    //   914: invokevirtual a : ()Landroid/app/Activity;
    //   917: ifnull -> 960
    //   920: aload_1
    //   921: invokevirtual a : ()Landroid/app/Activity;
    //   924: invokevirtual isFinishing : ()Z
    //   927: ifne -> 960
    //   930: invokestatic a : ()Z
    //   933: ifne -> 960
    //   936: aload_1
    //   937: invokevirtual a : ()Landroid/app/Activity;
    //   940: new com/ss/android/socialbase/appdownloader/d$2
    //   943: dup
    //   944: aload_0
    //   945: aload #9
    //   947: aload #7
    //   949: iload_2
    //   950: iload #4
    //   952: invokespecial <init> : (Lcom/ss/android/socialbase/appdownloader/d;Ljava/lang/String;Lcom/ss/android/socialbase/downloader/g/d;IZ)V
    //   955: invokestatic a : (Landroid/app/Activity;Lcom/ss/android/socialbase/appdownloader/c/m;)V
    //   958: iload_3
    //   959: ireturn
    //   960: getstatic com/ss/android/socialbase/appdownloader/d.a : Ljava/lang/String;
    //   963: astore #8
    //   965: new java/lang/StringBuilder
    //   968: dup
    //   969: invokespecial <init> : ()V
    //   972: astore #10
    //   974: aload #10
    //   976: ldc_w 'notification permission need not request, start download :'
    //   979: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: pop
    //   983: aload #10
    //   985: aload #9
    //   987: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: pop
    //   991: aload #8
    //   993: aload #10
    //   995: invokevirtual toString : ()Ljava/lang/String;
    //   998: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1001: aload_0
    //   1002: aload #7
    //   1004: iload_2
    //   1005: iload #4
    //   1007: invokespecial a : (Lcom/ss/android/socialbase/downloader/g/d;IZ)V
    //   1010: aload #7
    //   1012: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   1015: pop
    //   1016: iload_3
    //   1017: ireturn
    //   1018: iconst_0
    //   1019: ireturn
    //   1020: astore #7
    //   1022: aload_1
    //   1023: invokevirtual M : ()Lcom/ss/android/socialbase/downloader/d/x;
    //   1026: aconst_null
    //   1027: new com/ss/android/socialbase/downloader/e/a
    //   1030: dup
    //   1031: sipush #1003
    //   1034: aload #7
    //   1036: ldc_w 'addDownloadTask'
    //   1039: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;)Ljava/lang/String;
    //   1042: invokespecial <init> : (ILjava/lang/String;)V
    //   1045: iconst_0
    //   1046: invokestatic a : (Lcom/ss/android/socialbase/downloader/d/x;Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;I)V
    //   1049: getstatic com/ss/android/socialbase/appdownloader/d.a : Ljava/lang/String;
    //   1052: ldc_w 'add download task error:%s'
    //   1055: iconst_1
    //   1056: anewarray java/lang/Object
    //   1059: dup
    //   1060: iconst_0
    //   1061: aload #7
    //   1063: aastore
    //   1064: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1067: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1070: iconst_0
    //   1071: ireturn
    //   1072: iconst_0
    //   1073: ireturn
    //   1074: astore #8
    //   1076: goto -> 377
    //   1079: astore #13
    //   1081: aload #14
    //   1083: astore #13
    //   1085: goto -> 601
    //   1088: iconst_0
    //   1089: istore #4
    //   1091: goto -> 151
    //   1094: goto -> 426
    //   1097: goto -> 506
    //   1100: iconst_0
    //   1101: istore #6
    //   1103: goto -> 618
    //   1106: iconst_1
    //   1107: istore #6
    //   1109: goto -> 618
    // Exception table:
    //   from	to	target	type
    //   14	37	1020	finally
    //   44	52	55	finally
    //   57	99	1020	finally
    //   101	141	1020	finally
    //   151	163	1020	finally
    //   167	190	1020	finally
    //   194	221	1020	finally
    //   225	233	1020	finally
    //   237	243	1020	finally
    //   247	257	1020	finally
    //   261	271	1020	finally
    //   275	281	1020	finally
    //   281	300	1020	finally
    //   300	316	1020	finally
    //   319	355	1020	finally
    //   360	377	1074	finally
    //   377	391	1020	finally
    //   396	420	1020	finally
    //   426	432	1020	finally
    //   441	448	1020	finally
    //   452	459	1020	finally
    //   459	479	1020	finally
    //   482	506	1020	finally
    //   506	512	1020	finally
    //   521	531	1020	finally
    //   531	537	1020	finally
    //   537	556	1079	finally
    //   559	568	1079	finally
    //   568	601	1079	finally
    //   601	615	1020	finally
    //   618	896	1020	finally
    //   906	958	1020	finally
    //   960	1016	1020	finally
  }
  
  public c a() {
    return this.c;
  }
  
  public c a(Context paramContext, String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramContext == null)
        return null; 
      try {
        c c2 = a(paramContext, paramString, f());
        c c1 = c2;
        if (c2 == null)
          c1 = a(paramContext, paramString, paramContext.getFilesDir()); 
        c2 = c1;
        if (c1 == null)
          c2 = a(paramContext, paramString, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)); 
        boolean bool = a.b().a("get_download_info_by_list");
        c1 = c2;
        return c1;
      } finally {
        paramContext = null;
      } 
    } 
    return null;
  }
  
  public List<c> a(Context paramContext) {
    return f.a(paramContext).c("application/vnd.android.package-archive");
  }
  
  @Deprecated
  public void a(int paramInt) {
    int j = paramInt;
    if (paramInt < 0)
      j = 0; 
    try {
      b.v().put("failed_resume_max_count", j);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  @Deprecated
  public void a(long paramLong) {
    long l1 = paramLong;
    if (paramLong < 0L)
      l1 = 0L; 
    try {
      b.v().put("failed_resume_min_hours", l1 / 3600000.0D);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_3
    //   1: tableswitch default -> 68, -4 -> 95, -3 -> 87, -2 -> 78, -1 -> 95, 0 -> 68, 1 -> 69, 2 -> 69, 3 -> 69, 4 -> 69, 5 -> 69, 6 -> 68, 7 -> 69, 8 -> 69
    //   68: return
    //   69: aload_1
    //   70: invokestatic a : (Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/downloader/f;
    //   73: iload_2
    //   74: invokevirtual a : (I)V
    //   77: return
    //   78: aload_1
    //   79: invokestatic a : (Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/downloader/f;
    //   82: iload_2
    //   83: invokevirtual c : (I)V
    //   86: return
    //   87: aload_1
    //   88: iload_2
    //   89: iconst_1
    //   90: invokestatic a : (Landroid/content/Context;IZ)I
    //   93: pop
    //   94: return
    //   95: aload_1
    //   96: invokestatic a : (Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/downloader/f;
    //   99: iload_2
    //   100: invokevirtual e : (I)V
    //   103: return
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual printStackTrace : ()V
    //   109: return
    // Exception table:
    //   from	to	target	type
    //   69	77	104	java/lang/Exception
    //   78	86	104	java/lang/Exception
    //   87	94	104	java/lang/Exception
    //   95	103	104	java/lang/Exception
  }
  
  @Deprecated
  public void a(Context paramContext, String paramString, c paramc, d paramd, h paramh) {
    if (paramc != null)
      this.c = paramc; 
    if (paramd != null)
      this.d = paramd; 
    if (paramh != null)
      this.e = paramh; 
    if (paramContext != null && !l) {
      b.a(paramContext);
      b.a((m)new b());
      m();
      l = true;
    } 
  }
  
  public void a(g paramg) {
    this.f = paramg;
  }
  
  public void a(i parami) {
    this.h = parami;
  }
  
  public void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    this.j = paramString;
  }
  
  public void a(boolean paramBoolean) {
    this.o = paramBoolean;
  }
  
  public d b() {
    return this.d;
  }
  
  public List<c> b(Context paramContext) {
    return f.a(paramContext).d("application/vnd.android.package-archive");
  }
  
  @Deprecated
  public void b(int paramInt) {
    int j = paramInt;
    if (paramInt < 0)
      j = 0; 
    try {
      b.v().put("uninstall_resume_max_count", j);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  @Deprecated
  public void b(long paramLong) {
    long l1 = paramLong;
    if (paramLong < 0L)
      l1 = 0L; 
    try {
      b.v().put("uninstall_resume_min_hours", l1 / 3600000.0D);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void b(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      this.q = paramString; 
  }
  
  public String c() {
    return this.j;
  }
  
  public f d() {
    return this.p;
  }
  
  public boolean e() {
    return this.o;
  }
  
  public File f() {
    if (TextUtils.isEmpty(this.q))
      return null; 
    try {
      File file = new File(this.q);
      try {
        if (!file.exists()) {
          file.mkdirs();
          return file;
        } 
        File file1 = file;
        if (!file.isDirectory()) {
          file.delete();
          file.mkdirs();
          return file;
        } 
        return file1;
      } catch (Exception null) {
        return file;
      } 
    } catch (Exception exception) {
      exception = null;
    } 
    return (File)exception;
  }
  
  public String g() {
    return this.i;
  }
  
  public l i() {
    return this.g;
  }
  
  public g j() {
    return this.f;
  }
  
  public i k() {
    return this.h;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */