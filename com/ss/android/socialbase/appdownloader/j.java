package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.core.app.NotificationManagerCompat;
import com.ss.android.socialbase.appdownloader.c.m;
import com.ss.android.socialbase.appdownloader.view.a;
import com.ss.android.socialbase.downloader.downloader.b;
import java.util.ArrayList;
import java.util.List;

public class j {
  private static final String a = j.class.getSimpleName();
  
  private static List<m> b = new ArrayList<m>();
  
  private static a c;
  
  private static AlertDialog d;
  
  public static void a(Activity paramActivity, m paramm) {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/appdownloader/j
    //   2: monitorenter
    //   3: aload_1
    //   4: ifnonnull -> 11
    //   7: ldc com/ss/android/socialbase/appdownloader/j
    //   9: monitorexit
    //   10: return
    //   11: aload_0
    //   12: ifnull -> 153
    //   15: aload_0
    //   16: invokevirtual isFinishing : ()Z
    //   19: ifeq -> 25
    //   22: goto -> 153
    //   25: invokestatic B : ()Landroid/content/Context;
    //   28: ldc 'appdownloader_notification_request_title'
    //   30: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)I
    //   33: istore_2
    //   34: invokestatic B : ()Landroid/content/Context;
    //   37: ldc 'appdownloader_notification_request_message'
    //   39: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)I
    //   42: istore_3
    //   43: invokestatic B : ()Landroid/content/Context;
    //   46: ldc 'appdownloader_notification_request_btn_yes'
    //   48: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)I
    //   51: istore #4
    //   53: invokestatic B : ()Landroid/content/Context;
    //   56: ldc 'appdownloader_notification_request_btn_no'
    //   58: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)I
    //   61: istore #5
    //   63: getstatic com/ss/android/socialbase/appdownloader/j.b : Ljava/util/List;
    //   66: aload_1
    //   67: invokeinterface add : (Ljava/lang/Object;)Z
    //   72: pop
    //   73: getstatic com/ss/android/socialbase/appdownloader/j.d : Landroid/app/AlertDialog;
    //   76: ifnull -> 88
    //   79: getstatic com/ss/android/socialbase/appdownloader/j.d : Landroid/app/AlertDialog;
    //   82: invokevirtual isShowing : ()Z
    //   85: ifne -> 172
    //   88: new android/app/AlertDialog$Builder
    //   91: dup
    //   92: aload_0
    //   93: invokespecial <init> : (Landroid/content/Context;)V
    //   96: iload_2
    //   97: invokevirtual setTitle : (I)Landroid/app/AlertDialog$Builder;
    //   100: iload_3
    //   101: invokevirtual setMessage : (I)Landroid/app/AlertDialog$Builder;
    //   104: iload #4
    //   106: new com/ss/android/socialbase/appdownloader/j$3
    //   109: dup
    //   110: aload_0
    //   111: aload_1
    //   112: invokespecial <init> : (Landroid/app/Activity;Lcom/ss/android/socialbase/appdownloader/c/m;)V
    //   115: invokevirtual setPositiveButton : (ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;
    //   118: iload #5
    //   120: new com/ss/android/socialbase/appdownloader/j$2
    //   123: dup
    //   124: invokespecial <init> : ()V
    //   127: invokevirtual setNegativeButton : (ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;
    //   130: new com/ss/android/socialbase/appdownloader/j$1
    //   133: dup
    //   134: invokespecial <init> : ()V
    //   137: invokevirtual setOnKeyListener : (Landroid/content/DialogInterface$OnKeyListener;)Landroid/app/AlertDialog$Builder;
    //   140: iconst_0
    //   141: invokevirtual setCancelable : (Z)Landroid/app/AlertDialog$Builder;
    //   144: invokevirtual show : ()Landroid/app/AlertDialog;
    //   147: putstatic com/ss/android/socialbase/appdownloader/j.d : Landroid/app/AlertDialog;
    //   150: goto -> 172
    //   153: aload_1
    //   154: invokeinterface b : ()V
    //   159: ldc com/ss/android/socialbase/appdownloader/j
    //   161: monitorexit
    //   162: return
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual printStackTrace : ()V
    //   168: iconst_0
    //   169: invokestatic a : (Z)V
    //   172: ldc com/ss/android/socialbase/appdownloader/j
    //   174: monitorexit
    //   175: return
    //   176: astore_0
    //   177: ldc com/ss/android/socialbase/appdownloader/j
    //   179: monitorexit
    //   180: aload_0
    //   181: athrow
    // Exception table:
    //   from	to	target	type
    //   15	22	163	finally
    //   25	88	163	finally
    //   88	150	163	finally
    //   153	159	163	finally
    //   164	172	176	finally
  }
  
  public static void a(boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/appdownloader/j
    //   2: monitorenter
    //   3: getstatic com/ss/android/socialbase/appdownloader/j.d : Landroid/app/AlertDialog;
    //   6: ifnull -> 19
    //   9: getstatic com/ss/android/socialbase/appdownloader/j.d : Landroid/app/AlertDialog;
    //   12: invokevirtual cancel : ()V
    //   15: aconst_null
    //   16: putstatic com/ss/android/socialbase/appdownloader/j.d : Landroid/app/AlertDialog;
    //   19: getstatic com/ss/android/socialbase/appdownloader/j.b : Ljava/util/List;
    //   22: invokeinterface iterator : ()Ljava/util/Iterator;
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface hasNext : ()Z
    //   34: ifeq -> 78
    //   37: aload_1
    //   38: invokeinterface next : ()Ljava/lang/Object;
    //   43: checkcast com/ss/android/socialbase/appdownloader/c/m
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull -> 28
    //   51: iload_0
    //   52: ifeq -> 64
    //   55: aload_2
    //   56: invokeinterface a : ()V
    //   61: goto -> 28
    //   64: aload_2
    //   65: invokeinterface b : ()V
    //   70: goto -> 28
    //   73: astore_1
    //   74: aload_1
    //   75: invokevirtual printStackTrace : ()V
    //   78: ldc com/ss/android/socialbase/appdownloader/j
    //   80: monitorexit
    //   81: return
    //   82: astore_1
    //   83: ldc com/ss/android/socialbase/appdownloader/j
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	73	finally
    //   19	28	73	finally
    //   28	47	73	finally
    //   55	61	73	finally
    //   64	70	73	finally
    //   74	78	82	finally
  }
  
  public static boolean a() {
    try {
      return NotificationManagerCompat.from(b.B()).areNotificationsEnabled();
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public static void b(Activity paramActivity, m paramm) {
    if (paramActivity != null)
      try {
        if (!paramActivity.isFinishing()) {
          FragmentManager fragmentManager = paramActivity.getFragmentManager();
          c = (a)fragmentManager.findFragmentByTag(a);
          if (c == null) {
            c = new a();
            fragmentManager.beginTransaction().add((Fragment)c, a).commitAllowingStateLoss();
          } 
          return;
        } 
        return;
      } finally {
        paramActivity = null;
      }  
    paramm.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */