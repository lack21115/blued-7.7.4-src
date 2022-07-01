package com.qq.e.comm.plugin.a.d;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b extends c {
  private Handler a = new Handler(Looper.getMainLooper());
  
  private final Map<String, b> b = new ConcurrentHashMap<String, b>();
  
  private final Map<String, Long> c = new ConcurrentHashMap<String, Long>();
  
  public static b a() {
    return a.a;
  }
  
  private void a(String paramString, b paramb, long paramLong) {
    this.a.post(new Runnable(this, paramString, paramb, paramLong) {
          public void run() {
            try {
              b.a(this.d, this.a, this.b, this.c);
              return;
            } catch (Exception exception) {
              return;
            } 
          }
        });
  }
  
  private b b(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   4: astore #6
    //   6: aload_0
    //   7: getfield b : Ljava/util/Map;
    //   10: aload #6
    //   12: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast com/qq/e/comm/plugin/a/d/b$b
    //   20: astore #5
    //   22: aload #5
    //   24: ifnull -> 41
    //   27: aload #5
    //   29: astore #4
    //   31: aload #5
    //   33: getfield a : I
    //   36: bipush #8
    //   38: if_icmpne -> 129
    //   41: new com/qq/e/comm/plugin/a/d/b$b
    //   44: dup
    //   45: invokespecial <init> : ()V
    //   48: astore #4
    //   50: invokestatic h : ()Ljava/io/File;
    //   53: astore #5
    //   55: new java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial <init> : ()V
    //   62: astore #7
    //   64: aload #7
    //   66: aload #6
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload #7
    //   74: ldc '.apk'
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: new java/io/File
    //   83: dup
    //   84: aload #5
    //   86: aload #7
    //   88: invokevirtual toString : ()Ljava/lang/String;
    //   91: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   94: aload_2
    //   95: aload_1
    //   96: invokestatic a : (Ljava/io/File;Ljava/lang/String;Landroid/content/Context;)Z
    //   99: ifeq -> 115
    //   102: aload #4
    //   104: bipush #8
    //   106: putfield a : I
    //   109: bipush #100
    //   111: istore_3
    //   112: goto -> 123
    //   115: iconst_0
    //   116: istore_3
    //   117: aload #4
    //   119: iconst_0
    //   120: putfield a : I
    //   123: aload #4
    //   125: iload_3
    //   126: putfield b : I
    //   129: aload #4
    //   131: areturn
  }
  
  private void b(String paramString, b paramb, long paramLong) {
    Intent intent = new Intent();
    Context context = GDTADManager.getInstance().getAppContext();
    String str = context.getPackageName();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append(".gdtdownload");
    intent.setAction(stringBuilder2.toString());
    intent.putExtra("package", paramString);
    intent.putExtra("status", paramb.a);
    intent.putExtra("progress", paramb.b);
    intent.putExtra("totalSize", paramLong);
    intent.setPackage(str);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Before broadCast::");
    stringBuilder1.append(intent);
    GDTLogger.d(stringBuilder1.toString());
    context.sendBroadcast(intent);
  }
  
  private int c(Context paramContext, String paramString) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int a(Context paramContext, String paramString) {
    if (StringUtil.isEmpty(paramString))
      return 0; 
    int i = c(paramContext, paramString);
    if (d.a(i))
      return 1; 
    b b1 = b(paramContext, paramString);
    return (b1 != null) ? (b1.a | i) : i;
  }
  
  public void a(String paramString) {
    paramString = com.qq.e.comm.plugin.a.e.a.a(paramString);
    b b1 = this.b.get(paramString);
    if (this.c.get(paramString) == null)
      this.c.put(paramString, Long.valueOf(0L)); 
    if (b1 != null) {
      b1.b = 0;
      return;
    } 
    b1 = new b();
    b1.b = 0;
    this.b.put(paramString, b1);
  }
  
  public void a(String paramString, int paramInt) {
    long l;
    String str = com.qq.e.comm.plugin.a.e.a.a(paramString);
    b b1 = this.b.get(str);
    if (b1 != null) {
      b1.a = paramInt;
    } else {
      b1 = new b();
      b1.a = paramInt;
      this.b.put(str, b1);
    } 
    if (this.c.get(str) == null) {
      l = 0L;
    } else {
      l = ((Long)this.c.get(str)).longValue();
    } 
    a(paramString, b1.a, b1.b, l);
    a(paramString, b1, l);
  }
  
  public void a(String paramString, int paramInt, long paramLong) {
    String str = com.qq.e.comm.plugin.a.e.a.a(paramString);
    b b1 = this.b.get(str);
    if (this.c.get(str) == null)
      this.c.put(str, Long.valueOf(paramLong)); 
    boolean bool = true;
    if (b1 != null) {
      if (b1.b != paramInt) {
        b1.b = paramInt;
        paramInt = bool;
      } else {
        paramInt = 0;
      } 
    } else {
      b1 = new b();
      b1.b = paramInt;
      this.b.put(str, b1);
      paramInt = bool;
    } 
    if (paramInt != 0) {
      a(paramString, b1.a, b1.b, paramLong);
      if (b1.b % 5 == 0)
        a(paramString, b1, paramLong); 
    } 
  }
  
  public void b(String paramString) {
    a(paramString, 1, 100, 0L);
    b b1 = new b();
    b1.a = 1;
    b1.b = 100;
    a(paramString, b1, 0L);
  }
  
  static final class a {
    static b a = new b();
  }
  
  public static final class b {
    public int a;
    
    public int b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */