package com.pgl.sys.ces.a;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

public class a {
  public static Application a() {
    try {
      return (Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null);
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String a(Context paramContext) {
    String str;
    try {
      str = paramContext.getPackageName();
    } finally {
      paramContext = null;
    } 
  }
  
  public static int b(Context paramContext) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).versionCode;
    } finally {
      paramContext = null;
    } 
  }
  
  public static String b() {
    Exception exception;
    try {
      String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    } finally {
      exception = null;
    } 
  }
  
  public static String c() {
    Exception exception;
    try {
      String str = Environment.getDataDirectory().getPath();
    } finally {
      exception = null;
    } 
  }
  
  public static String c(Context paramContext) {
    String str;
    try {
      str = paramContext.getFilesDir().getAbsolutePath();
    } finally {
      paramContext = null;
    } 
  }
  
  public static String d(Context paramContext) {
    String str;
    try {
      str = (paramContext.getApplicationInfo()).sourceDir;
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\ces\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */