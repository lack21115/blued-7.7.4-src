package com.qiniu.pili.droid.crash;

import android.content.Context;
import android.os.Build;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class d {
  private Context a;
  
  d(Context paramContext) {
    this.a = paramContext;
  }
  
  private void c(i parami) {
    parami.a(ReportField.a, String.valueOf(System.currentTimeMillis() / 1000L));
    parami.a(ReportField.b, k.a());
    parami.a(ReportField.c, "android");
    parami.a(ReportField.d, Build.VERSION.RELEASE);
    parami.a(ReportField.e, "3.1.1");
    parami.a(ReportField.f, this.a.getPackageName());
    parami.a(ReportField.g, k.b(this.a));
    parami.a(ReportField.h, k.e(this.a));
    parami.a(ReportField.i, k.c(this.a));
    parami.a(ReportField.j, k.d(this.a));
    parami.a(ReportField.k, "1.0");
  }
  
  boolean a(i parami) {
    String str1;
    if (parami.b() != null) {
      str1 = k.a(parami.b());
      String str = str1.substring(str1.lastIndexOf("Caused by"));
      if (str.substring(0, str.indexOf("...")).contains("com.qiniu.pili.droid.shortvideo")) {
        parami.a(ReportField.q, str1).a(ReportField.l, "java");
        return true;
      } 
      return false;
    } 
    String str2 = parami.a("backtrace");
    Matcher matcher = Pattern.compile("([a-z]+_){1,2}[a-z]+.so").matcher(str2);
    if (matcher.find()) {
      str1 = matcher.group(0);
    } else {
      str1 = "";
    } 
    if (b.b.contains(str1) || str2.contains("com.qiniu.pili.droid.shortvideo")) {
      parami.a(ReportField.s, str2).a(ReportField.o, str1).a(ReportField.l, parami.a("Crash type"));
      return true;
    } 
    return false;
  }
  
  void b(i parami) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial c : (Lcom/qiniu/pili/droid/crash/i;)V
    //   5: aload_1
    //   6: ldc 'java stacktrace'
    //   8: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   11: ifnonnull -> 49
    //   14: aload_1
    //   15: getstatic com/qiniu/pili/droid/crash/ReportField.q : Lcom/qiniu/pili/droid/crash/ReportField;
    //   18: invokevirtual a : (Lcom/qiniu/pili/droid/crash/ReportField;)Ljava/lang/String;
    //   21: astore_2
    //   22: aload_1
    //   23: getstatic com/qiniu/pili/droid/crash/ReportField.m : Lcom/qiniu/pili/droid/crash/ReportField;
    //   26: aload_2
    //   27: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   30: invokevirtual a : (Lcom/qiniu/pili/droid/crash/ReportField;Ljava/lang/String;)Lcom/qiniu/pili/droid/crash/i;
    //   33: pop
    //   34: aload_1
    //   35: getstatic com/qiniu/pili/droid/crash/ReportField.n : Lcom/qiniu/pili/droid/crash/ReportField;
    //   38: aload_2
    //   39: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   42: invokevirtual a : (Lcom/qiniu/pili/droid/crash/ReportField;Ljava/lang/String;)Lcom/qiniu/pili/droid/crash/i;
    //   45: pop
    //   46: goto -> 49
    //   49: ldc 'native'
    //   51: aload_1
    //   52: getstatic com/qiniu/pili/droid/crash/ReportField.l : Lcom/qiniu/pili/droid/crash/ReportField;
    //   55: invokevirtual a : (Lcom/qiniu/pili/droid/crash/ReportField;)Ljava/lang/String;
    //   58: invokevirtual equals : (Ljava/lang/Object;)Z
    //   61: ifeq -> 167
    //   64: aload_1
    //   65: ldc 'build id'
    //   67: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   70: astore_2
    //   71: aload_2
    //   72: ifnull -> 87
    //   75: aload_1
    //   76: getstatic com/qiniu/pili/droid/crash/ReportField.p : Lcom/qiniu/pili/droid/crash/ReportField;
    //   79: aload_2
    //   80: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   83: invokevirtual a : (Lcom/qiniu/pili/droid/crash/ReportField;Ljava/lang/String;)Lcom/qiniu/pili/droid/crash/i;
    //   86: pop
    //   87: aload_1
    //   88: ldc 'stack'
    //   90: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   93: astore_2
    //   94: aload_2
    //   95: ifnull -> 107
    //   98: aload_1
    //   99: getstatic com/qiniu/pili/droid/crash/ReportField.r : Lcom/qiniu/pili/droid/crash/ReportField;
    //   102: aload_2
    //   103: invokevirtual a : (Lcom/qiniu/pili/droid/crash/ReportField;Ljava/lang/String;)Lcom/qiniu/pili/droid/crash/i;
    //   106: pop
    //   107: aload_1
    //   108: ldc 'signal'
    //   110: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   113: astore_2
    //   114: aload_2
    //   115: ifnull -> 127
    //   118: aload_1
    //   119: getstatic com/qiniu/pili/droid/crash/ReportField.w : Lcom/qiniu/pili/droid/crash/ReportField;
    //   122: aload_2
    //   123: invokevirtual a : (Lcom/qiniu/pili/droid/crash/ReportField;Ljava/lang/String;)Lcom/qiniu/pili/droid/crash/i;
    //   126: pop
    //   127: aload_1
    //   128: ldc 'code'
    //   130: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   133: astore_2
    //   134: aload_2
    //   135: ifnull -> 147
    //   138: aload_1
    //   139: getstatic com/qiniu/pili/droid/crash/ReportField.x : Lcom/qiniu/pili/droid/crash/ReportField;
    //   142: aload_2
    //   143: invokevirtual a : (Lcom/qiniu/pili/droid/crash/ReportField;Ljava/lang/String;)Lcom/qiniu/pili/droid/crash/i;
    //   146: pop
    //   147: aload_1
    //   148: ldc 'fault addr'
    //   150: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   153: astore_2
    //   154: aload_2
    //   155: ifnull -> 167
    //   158: aload_1
    //   159: getstatic com/qiniu/pili/droid/crash/ReportField.y : Lcom/qiniu/pili/droid/crash/ReportField;
    //   162: aload_2
    //   163: invokevirtual a : (Lcom/qiniu/pili/droid/crash/ReportField;Ljava/lang/String;)Lcom/qiniu/pili/droid/crash/i;
    //   166: pop
    //   167: ldc 'anr'
    //   169: aload_1
    //   170: getstatic com/qiniu/pili/droid/crash/ReportField.l : Lcom/qiniu/pili/droid/crash/ReportField;
    //   173: invokevirtual a : (Lcom/qiniu/pili/droid/crash/ReportField;)Ljava/lang/String;
    //   176: invokevirtual equals : (Ljava/lang/Object;)Z
    //   179: ifeq -> 207
    //   182: aload_1
    //   183: getstatic com/qiniu/pili/droid/crash/ReportField.u : Lcom/qiniu/pili/droid/crash/ReportField;
    //   186: new com/qiniu/pili/droid/crash/e
    //   189: dup
    //   190: invokespecial <init> : ()V
    //   193: aload_0
    //   194: getfield a : Landroid/content/Context;
    //   197: invokevirtual a : (Landroid/content/Context;)Ljava/lang/String;
    //   200: invokevirtual a : (Lcom/qiniu/pili/droid/crash/ReportField;Ljava/lang/String;)Lcom/qiniu/pili/droid/crash/i;
    //   203: pop
    //   204: goto -> 207
    //   207: aload_1
    //   208: ldc 'tname'
    //   210: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   213: astore_2
    //   214: aload_2
    //   215: ifnonnull -> 236
    //   218: aload_1
    //   219: getstatic com/qiniu/pili/droid/crash/ReportField.v : Lcom/qiniu/pili/droid/crash/ReportField;
    //   222: aload_1
    //   223: invokevirtual a : ()Ljava/lang/Thread;
    //   226: invokevirtual getName : ()Ljava/lang/String;
    //   229: invokevirtual a : (Lcom/qiniu/pili/droid/crash/ReportField;Ljava/lang/String;)Lcom/qiniu/pili/droid/crash/i;
    //   232: pop
    //   233: goto -> 245
    //   236: aload_1
    //   237: getstatic com/qiniu/pili/droid/crash/ReportField.v : Lcom/qiniu/pili/droid/crash/ReportField;
    //   240: aload_2
    //   241: invokevirtual a : (Lcom/qiniu/pili/droid/crash/ReportField;Ljava/lang/String;)Lcom/qiniu/pili/droid/crash/i;
    //   244: pop
    //   245: aload_1
    //   246: getstatic com/qiniu/pili/droid/crash/ReportField.t : Lcom/qiniu/pili/droid/crash/ReportField;
    //   249: invokestatic c : ()Ljava/lang/String;
    //   252: invokevirtual a : (Lcom/qiniu/pili/droid/crash/ReportField;Ljava/lang/String;)Lcom/qiniu/pili/droid/crash/i;
    //   255: pop
    //   256: return
    //   257: astore_2
    //   258: goto -> 49
    //   261: astore_2
    //   262: goto -> 207
    //   265: astore_2
    //   266: goto -> 245
    //   269: astore_1
    //   270: return
    // Exception table:
    //   from	to	target	type
    //   22	46	257	java/lang/Exception
    //   182	204	261	java/lang/Exception
    //   218	233	265	java/lang/Exception
    //   245	256	269	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\crash\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */