package com.soft.blued.tinker.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.tinker.lib.util.TinkerLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Utils {
  private static boolean a = false;
  
  public static int a(long paramLong, int paramInt) {
    return a() ? -20 : ((paramInt < 45) ? -22 : (!a(paramLong) ? -21 : 0));
  }
  
  private static String a(String paramString) {
    boolean bool;
    if (paramString == null)
      return null; 
    char[] arrayOfChar = paramString.toCharArray();
    if (arrayOfChar == null)
      return null; 
    int i = 0;
    while (true) {
      if (i < arrayOfChar.length) {
        if (arrayOfChar[i] > '') {
          arrayOfChar[i] = Character.MIN_VALUE;
          boolean bool1 = true;
          break;
        } 
        i++;
        continue;
      } 
      bool = false;
      break;
    } 
    if (bool)
      paramString = new String(arrayOfChar, 0, i); 
    return paramString;
  }
  
  public static void a(boolean paramBoolean) {
    a = paramBoolean;
  }
  
  public static boolean a() {
    return false;
  }
  
  @Deprecated
  public static boolean a(long paramLong) {
    // Byte code:
    //   0: new android/os/StatFs
    //   3: dup
    //   4: invokestatic getDataDirectory : ()Ljava/io/File;
    //   7: invokevirtual getPath : ()Ljava/lang/String;
    //   10: invokespecial <init> : (Ljava/lang/String;)V
    //   13: astore #7
    //   15: aload #7
    //   17: invokevirtual getAvailableBlocks : ()I
    //   20: i2l
    //   21: lstore_3
    //   22: aload #7
    //   24: invokevirtual getBlockSize : ()I
    //   27: istore_2
    //   28: lload_3
    //   29: iload_2
    //   30: i2l
    //   31: lmul
    //   32: lstore_3
    //   33: aload #7
    //   35: invokevirtual getBlockCount : ()I
    //   38: i2l
    //   39: lstore #5
    //   41: aload #7
    //   43: invokevirtual getBlockSize : ()I
    //   46: istore_2
    //   47: iload_2
    //   48: i2l
    //   49: lload #5
    //   51: lmul
    //   52: lstore #5
    //   54: goto -> 62
    //   57: lconst_0
    //   58: lstore_3
    //   59: lconst_0
    //   60: lstore #5
    //   62: lload #5
    //   64: lconst_0
    //   65: lcmp
    //   66: ifeq -> 77
    //   69: lload_3
    //   70: lload_0
    //   71: lcmp
    //   72: ifle -> 77
    //   75: iconst_1
    //   76: ireturn
    //   77: iconst_0
    //   78: ireturn
    //   79: astore #7
    //   81: goto -> 57
    //   84: astore #7
    //   86: goto -> 59
    // Exception table:
    //   from	to	target	type
    //   0	28	79	java/lang/Exception
    //   33	47	84	java/lang/Exception
  }
  
  public static boolean a(Throwable paramThrowable) {
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    int j = arrayOfStackTraceElement.length;
    for (int i = 0; i < j; i++) {
      String str = arrayOfStackTraceElement[i].getClassName();
      if (str != null && str.contains("de.robv.android.xposed.XposedBridge"))
        return true; 
    } 
    return false;
  }
  
  public static String b(Throwable paramThrowable) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(byteArrayOutputStream);
    try {
      while (paramThrowable.getCause() != null)
        paramThrowable = paramThrowable.getCause(); 
      paramThrowable.printStackTrace(printStream);
      String str = a(byteArrayOutputStream.toString());
    } finally {
      try {
        iOException.close();
      } catch (IOException iOException1) {
        iOException1.printStackTrace();
      } 
    } 
  }
  
  public static boolean b() {
    return a;
  }
  
  public static class ScreenState {
    public ScreenState(Context param1Context, IOnScreenOff param1IOnScreenOff) {
      IntentFilter intentFilter = new IntentFilter();
      intentFilter.addAction("android.intent.action.SCREEN_OFF");
      param1Context.registerReceiver(new BroadcastReceiver(this, param1IOnScreenOff) {
            public void onReceive(Context param2Context, Intent param2Intent) {
              String str;
              if (param2Intent == null) {
                str = "";
              } else {
                str = str.getAction();
              } 
              TinkerLog.i("Tinker.Utils", "ScreenReceiver action [%s] ", new Object[] { str });
              if ("android.intent.action.SCREEN_OFF".equals(str)) {
                Utils.ScreenState.IOnScreenOff iOnScreenOff = this.a;
                if (iOnScreenOff != null)
                  iOnScreenOff.a(); 
              } 
              param2Context.unregisterReceiver(this);
            }
          }intentFilter);
    }
    
    public static interface IOnScreenOff {
      void a();
    }
  }
  
  class null extends BroadcastReceiver {
    null(Utils this$0, Utils.ScreenState.IOnScreenOff param1IOnScreenOff) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      String str;
      if (param1Intent == null) {
        str = "";
      } else {
        str = str.getAction();
      } 
      TinkerLog.i("Tinker.Utils", "ScreenReceiver action [%s] ", new Object[] { str });
      if ("android.intent.action.SCREEN_OFF".equals(str)) {
        Utils.ScreenState.IOnScreenOff iOnScreenOff = this.a;
        if (iOnScreenOff != null)
          iOnScreenOff.a(); 
      } 
      param1Context.unregisterReceiver(this);
    }
  }
  
  public static interface IOnScreenOff {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\tinke\\util\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */