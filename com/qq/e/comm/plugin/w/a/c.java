package com.qq.e.comm.plugin.w.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.net.URLEncoder;
import java.util.concurrent.Exchanger;

public class c {
  private static volatile AlertDialog a;
  
  public static int a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
    if (!StringUtil.isEmpty(paramString2) || !StringUtil.isEmpty(paramString1)) {
      CharSequence charSequence;
      Intent intent;
      ResolveInfo resolveInfo = b(paramContext, paramString1, paramString2);
      if (StringUtil.isEmpty(paramString2) || resolveInfo != null) {
        try {
          Uri uri;
          paramString2 = a(paramString2, paramString3, paramString4);
          boolean bool = StringUtil.isEmpty(paramString2);
          paramString3 = null;
          if (bool) {
            paramString2 = null;
          } else {
            uri = Uri.parse(paramString2);
          } 
        } finally {
          paramContext = null;
          GDTLogger.report("ExceptionIn DownClickRunnable.startInstalledAPP", (Throwable)paramContext);
        } 
      } else {
        return 0;
      } 
      if (charSequence == null) {
        charSequence = paramString3;
      } else {
        charSequence = charSequence.toString();
      } 
      if (!paramBoolean || a(paramContext, (String)charSequence)) {
        GDTLogger.d("deep link startActivity");
        paramContext.startActivity(intent);
        return 1;
      } 
      GDTLogger.d("deep link cancel startActivity");
      return 2;
    } 
    return 0;
  }
  
  public static Intent a(Context paramContext, String paramString, Uri paramUri) {
    if (paramUri == null)
      return StringUtil.isEmpty(paramString) ? null : paramContext.getPackageManager().getLaunchIntentForPackage(paramString).addFlags(268435456); 
    Intent intent = new Intent();
    intent.setData(paramUri);
    intent.setAction("android.intent.action.VIEW");
    if (!(paramContext instanceof android.app.Activity))
      intent.addFlags(268435456); 
    if (!StringUtil.isEmpty(paramString))
      intent.setPackage(paramString); 
    return intent;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3) {
    if (StringUtil.isEmpty(paramString1))
      return paramString1; 
    String str = paramString2;
    if (StringUtil.isEmpty(paramString2))
      str = "unknown"; 
    paramString2 = paramString3;
    if (StringUtil.isEmpty(paramString3))
      paramString2 = "unknown"; 
    return paramString1.replaceAll("\\$\\{platform\\}", URLEncoder.encode("e.qq.com")).replaceAll("\\$\\{adid\\}", URLEncoder.encode(str)).replaceAll("\\$\\{clickid\\}", URLEncoder.encode(paramString2)).replaceAll("\\$\\{traceurl\\}", "none");
  }
  
  public static void a() {
    if (a != null)
      try {
        a.dismiss();
        return;
      } finally {
        Exception exception = null;
      }  
  }
  
  private static boolean a(Context paramContext, String paramString) {
    boolean bool;
    Exchanger<Boolean> exchanger = new Exchanger();
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    } 
    AlertDialog.Builder builder = new AlertDialog.Builder(paramContext, bool);
    String str = paramString;
    if (paramString == null)
      str = "APP"; 
    builder.setMessage(String.format("前往“%s”了解更多", new Object[] { str }));
    builder.setCancelable(false);
    builder.setPositiveButton("前往", new DialogInterface.OnClickListener(exchanger) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            try {
              return;
            } finally {
              param1DialogInterface = null;
              param1DialogInterface.printStackTrace();
            } 
          }
        });
    builder.setNegativeButton("取消", new DialogInterface.OnClickListener(exchanger) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            try {
              return;
            } finally {
              param1DialogInterface = null;
              param1DialogInterface.printStackTrace();
            } 
          }
        });
    builder.setOnCancelListener(new DialogInterface.OnCancelListener(exchanger) {
          public void onCancel(DialogInterface param1DialogInterface) {
            try {
              return;
            } finally {
              param1DialogInterface = null;
              param1DialogInterface.printStackTrace();
            } 
          }
        });
    y.a(new Runnable(builder, exchanger) {
          public void run() {
            try {
              c.a();
              return;
            } finally {
              Exception exception = null;
              exception.printStackTrace();
            } 
          }
        });
    try {
      return ((Boolean)exchanger.exchange(Boolean.valueOf(false))).booleanValue();
    } finally {
      str = null;
    } 
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2) {
    return (b(paramContext, paramString1, paramString2) != null);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    return (a(paramContext, paramString1, paramString2, paramString3, paramString4, false) != 0);
  }
  
  public static ResolveInfo b(Context paramContext, String paramString1, String paramString2) {
    ResolveInfo resolveInfo;
    boolean bool = StringUtil.isEmpty(paramString2);
    String str = null;
    if (bool)
      return null; 
    Uri uri = Uri.parse(a(paramString2, (String)null, (String)null));
    paramString2 = str;
    if (!"http".equalsIgnoreCase(uri.getScheme())) {
      paramString2 = str;
      if (!"https".equalsIgnoreCase(uri.getScheme())) {
        Intent intent = a(paramContext, paramString1, uri);
        resolveInfo = paramContext.getPackageManager().resolveActivity(intent, 65536);
      } 
    } 
    return resolveInfo;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\w\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */