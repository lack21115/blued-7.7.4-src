package com.ishumei.l1111l111111Il;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ishumei.l111l11111Il.l111l1111lIl;
import com.ishumei.l111l1111l1Il.l111l11111I1l;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import com.ishumei.smantifraud.SmAntiFraud;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class l111l1111llIl implements l111l1111llIl.l1111l111111Il.l1111l111111Il, l111l1111llIl.l1111l111111Il.l111l11111lIl {
  private static final int l1111l111111Il = -1;
  
  private static final int l111l11111I1l = -3;
  
  private static int l111l11111Il = -4;
  
  private static final int l111l11111lIl = -2;
  
  private static final String l111l1111l1Il = "sm";
  
  private com.ishumei.l111l11111I1l.l111l11111lIl l111l1111lI1l = new com.ishumei.l111l11111I1l.l111l11111lIl(this, true, 1) {
      public final void run() {
        try {
          com.ishumei.l111l11111lIl.l111l11111lIl l111l11111lIl1 = com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111lIl();
          if (l111l11111lIl1 != null && l111l11111lIl1.l111l11111Il() > 0 && !l111l1111lIl.l111l1111lI1l() && l111l1111llIl.l1111l111111Il(this.l111l11111lIl).incrementAndGet() <= l111l11111lIl1.l111l11111Il()) {
            com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il((Runnable)this, 1, 1000L, false);
            return;
          } 
          l111l1111llIl.l1111l111111Il(this.l111l11111lIl).set(0);
          if (SmAntiFraud.l1111l111111Il.l11l1111I11l())
            com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111I1l(); 
          l111l1111llIl.l1111l111111Il l1111l111111Il = l111l1111llIl.l111l11111lIl(this.l111l11111lIl);
          boolean bool = l1111l111111Il.l1111l111111Il;
          if (SmAntiFraud.l1111l111111Il.l11l1111I1l())
            (new com.ishumei.l111l11111I1l.l111l11111lIl(l1111l111111Il, bool, l1111l111111Il.l111l11111lIl, false, 0L, false) {
                l111l11111lIl(l111l1111llIl this$0, boolean param1Boolean1, int param1Int, boolean param1Boolean2, long param1Long, boolean param1Boolean3) {
                  super(param1Boolean1, param1Int, false, 0L, false);
                }
                
                public final void run() {
                  try {
                    if (l111l1111llIl.l1111l111111Il.l1111l111111Il(this.l111l11111lIl) != null)
                      l111l1111llIl.l1111l111111Il.l1111l111111Il(this.l111l11111lIl, l111l1111llIl.l1111l111111Il.l1111l111111Il(this.l111l11111lIl).l111l11111Il()); 
                    if (l111l1111llIl.l1111l111111Il.l111l11111lIl(this.l111l11111lIl) != null)
                      l111l1111llIl.l1111l111111Il.l111l11111lIl(this.l111l11111lIl, l111l1111llIl.l1111l111111Il.l111l11111lIl(this.l111l11111lIl).l111l1111l1Il()); 
                    com.ishumei.l111l1111l1Il.l1111l111111Il l1111l111111Il1 = com.ishumei.l111l1111l1Il.l1111l111111Il.l1111l111111Il(l111l1111llIl.l1111l111111Il.l111l11111I1l(this.l111l11111lIl), SmAntiFraud.l1111l111111Il.l111l1111l1Il(), SmAntiFraud.l1111l111111Il.l111l11111Il());
                    boolean bool = l111l1111llIl.l1111l111111Il.l111l11111Il(this.l111l11111lIl).contains("\"encode\":1");
                    (new l111l11111I1l()).l1111l111111Il(l1111l111111Il1).l1111l111111Il(l111l1111llIl.l1111l111111Il.l111l11111Il(this.l111l11111lIl).getBytes("utf-8"), bool, null, this.l111l11111lIl.l111l11111I1l);
                    return;
                  } catch (Exception exception) {
                    return;
                  } 
                }
              }).l1111l111111Il(); 
          return;
        } catch (Exception exception) {
          return;
        } 
      }
    };
  
  private l111l11111I1l.l1111l111111Il l111l1111lIl = new l111l11111I1l.l1111l111111Il<Object>(this, true, 2) {
      public final void l1111l111111Il(String param1String) {
        try {
          JSONObject jSONObject = new JSONObject(param1String);
          int i = jSONObject.getInt("code");
          if (i != 1100) {
            l1111l111111Il("", i);
            return;
          } 
          if (this.l111l11111lIl.l11l1111I1ll) {
            SmAntiFraud.getServerIdCallback().onError(-3);
            return;
          } 
          if (!this.l111l11111I1l.l1111l111111Il(jSONObject))
            l1111l111111Il("", i); 
          return;
        } catch (Exception exception) {
          return;
        } 
      }
      
      public final boolean l1111l111111Il(String param1String, int param1Int) {
        throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
    };
  
  private AtomicInteger l111l1111llIl = new AtomicInteger(0);
  
  private l1111l111111Il l11l1111lIIl = new l1111l111111Il(this, this, true, 1, this.l111l1111lIl, "");
  
  private l111l1111llIl() {}
  
  public static l111l1111llIl l1111l111111Il() {
    return l111l11111lIl.l1111l111111Il();
  }
  
  public static String l1111l111111Il(String paramString1, String paramString2, boolean paramBoolean) {
    if (TextUtils.isEmpty(paramString2))
      return null; 
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1))
      str = "fp-it.fengkongcloud.com"; 
    if (paramString2.startsWith("http"))
      return paramString2; 
    if (str.startsWith("http")) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append(paramString2);
      return stringBuilder1.toString();
    } 
    paramString1 = str;
    if (str.equals(paramString2))
      paramString1 = "fp-it.fengkongcloud.com"; 
    if (paramBoolean) {
      StringBuilder stringBuilder = new StringBuilder("https://");
      str = paramString1;
      stringBuilder1 = stringBuilder;
      stringBuilder1.append(str);
      stringBuilder1.append(paramString2);
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder3 = new StringBuilder("http://");
    StringBuilder stringBuilder2 = stringBuilder1;
    StringBuilder stringBuilder1 = stringBuilder3;
    stringBuilder1.append((String)stringBuilder2);
    stringBuilder1.append(paramString2);
    return stringBuilder1.toString();
  }
  
  private static void l111l11111lIl(JSONObject paramJSONObject) {
    int i = paramJSONObject.optInt("c", -1);
    int j = paramJSONObject.optInt("t", -1);
    if (i >= 0) {
      if (j < 0)
        return; 
      com.ishumei.l111l11111lIl.l111l11111lIl.l1111l111111Il.l1111l111111Il().l1111l111111Il(j, i);
    } 
  }
  
  public final void l1111l111111Il(SmAntiFraud.IDeviceIdCallback paramIDeviceIdCallback, boolean paramBoolean) {
    (new Thread(new Runnable(this, paramBoolean, paramIDeviceIdCallback) {
          public final void run() {
            String str = this.l111l11111I1l.l111l11111I1l();
            if (this.l111l11111lIl) {
              (new Handler(Looper.getMainLooper())).post(new Runnable(this, str) {
                    public final void run() {
                      this.l111l11111lIl.l1111l111111Il.onResult(this.l1111l111111Il);
                    }
                  });
              return;
            } 
            this.l1111l111111Il.onResult(str);
          }
        })).start();
  }
  
  public final boolean l1111l111111Il(JSONObject paramJSONObject) {
    null = true;
    try {
      JSONObject jSONObject = paramJSONObject.getJSONObject(l111l1111lI1l.l111l11111Il("9b9a8b9e9693"));
      String str = jSONObject.optString(l111l1111lI1l.l111l11111Il("9b9a89969c9ab69b"));
      int i = jSONObject.optInt("c", -1);
      int j = jSONObject.optInt("t", -1);
      if (i >= 0 && j >= 0)
        com.ishumei.l111l11111lIl.l111l11111lIl.l1111l111111Il.l1111l111111Il().l1111l111111Il(j, i); 
      boolean bool = TextUtils.isEmpty(str);
      if (!bool)
        try {
          l11l1111I1l.l1111l111111Il().l1111l111111Il(str);
          if (SmAntiFraud.getServerIdCallback() != null) {
            SmAntiFraud.IServerSmidCallback iServerSmidCallback = SmAntiFraud.getServerIdCallback();
            StringBuilder stringBuilder = new StringBuilder("B");
            stringBuilder.append(str);
            iServerSmidCallback.onSuccess(stringBuilder.toString());
            return true;
          } 
          return null;
        } catch (Exception exception) {
          return true;
        }  
    } catch (Exception exception) {}
    return false;
  }
  
  public final String l111l11111I1l() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic l1111l111111Il : ()Lcom/ishumei/l1111l111111Il/l11l1111I1l;
    //   5: invokevirtual l111l11111lIl : ()Ljava/lang/String;
    //   8: astore_3
    //   9: aload_3
    //   10: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   13: ifne -> 44
    //   16: new java/lang/StringBuilder
    //   19: dup
    //   20: ldc 'B'
    //   22: invokespecial <init> : (Ljava/lang/String;)V
    //   25: astore #4
    //   27: aload #4
    //   29: aload_3
    //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload #4
    //   36: invokevirtual toString : ()Ljava/lang/String;
    //   39: astore_3
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_3
    //   43: areturn
    //   44: invokestatic l1111l111111Il : ()Lcom/ishumei/l1111l111111Il/l1111l111111Il;
    //   47: invokevirtual l111l11111lIl : ()Ljava/lang/String;
    //   50: astore_3
    //   51: aload_3
    //   52: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   55: ifne -> 86
    //   58: new java/lang/StringBuilder
    //   61: dup
    //   62: ldc 'D'
    //   64: invokespecial <init> : (Ljava/lang/String;)V
    //   67: astore #4
    //   69: aload #4
    //   71: aload_3
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload #4
    //   78: invokevirtual toString : ()Ljava/lang/String;
    //   81: astore_3
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_3
    //   85: areturn
    //   86: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   89: ifnonnull -> 220
    //   92: ldc '9c9e9393df989a8bbb9a89969c9ab69bdf9d8a8bdf91908bdf9c8d9a9e8b9a'
    //   94: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_3
    //   98: new java/lang/StringBuilder
    //   101: dup
    //   102: ldc 'D'
    //   104: invokespecial <init> : (Ljava/lang/String;)V
    //   107: astore #4
    //   109: aload #4
    //   111: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l11111lIl/l111l11111I1l;
    //   114: new java/lang/IllegalAccessException
    //   117: dup
    //   118: aload_3
    //   119: invokespecial <init> : (Ljava/lang/String;)V
    //   122: invokevirtual l1111l111111Il : (Ljava/lang/Throwable;)Ljava/lang/String;
    //   125: invokevirtual getBytes : ()[B
    //   128: invokestatic l111l11111lIl : ([B)Ljava/lang/String;
    //   131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload #4
    //   137: invokevirtual toString : ()Ljava/lang/String;
    //   140: astore #4
    //   142: aload_0
    //   143: monitorexit
    //   144: aload #4
    //   146: areturn
    //   147: astore #4
    //   149: new java/lang/StringBuilder
    //   152: dup
    //   153: ldc 'D'
    //   155: invokespecial <init> : (Ljava/lang/String;)V
    //   158: astore #5
    //   160: new java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial <init> : ()V
    //   167: astore #6
    //   169: aload #6
    //   171: aload_3
    //   172: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload #6
    //   178: ldc ';'
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload #6
    //   186: aload #4
    //   188: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload #5
    //   194: aload #6
    //   196: invokevirtual toString : ()Ljava/lang/String;
    //   199: invokevirtual getBytes : ()[B
    //   202: iconst_0
    //   203: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   206: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload #5
    //   212: invokevirtual toString : ()Ljava/lang/String;
    //   215: astore_3
    //   216: aload_0
    //   217: monitorexit
    //   218: aload_3
    //   219: areturn
    //   220: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   223: invokevirtual l11l1111lIIl : ()Z
    //   226: ifeq -> 452
    //   229: iconst_1
    //   230: istore_1
    //   231: goto -> 234
    //   234: invokestatic l1111l111111Il : ()Lcom/ishumei/l1111l111111Il/l1111l111111Il;
    //   237: iload_1
    //   238: invokevirtual l1111l111111Il : (I)Ljava/lang/String;
    //   241: astore_3
    //   242: aload_3
    //   243: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   246: istore_2
    //   247: iload_2
    //   248: ifne -> 365
    //   251: new java/lang/StringBuilder
    //   254: dup
    //   255: ldc 'D'
    //   257: invokespecial <init> : (Ljava/lang/String;)V
    //   260: astore #4
    //   262: aload #4
    //   264: aload_3
    //   265: invokevirtual getBytes : ()[B
    //   268: invokestatic l111l11111lIl : ([B)Ljava/lang/String;
    //   271: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload #4
    //   277: invokevirtual toString : ()Ljava/lang/String;
    //   280: astore_3
    //   281: aload_0
    //   282: monitorexit
    //   283: aload_3
    //   284: areturn
    //   285: astore_3
    //   286: new java/lang/StringBuilder
    //   289: dup
    //   290: ldc 'D'
    //   292: invokespecial <init> : (Ljava/lang/String;)V
    //   295: astore #4
    //   297: aload #4
    //   299: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l11111lIl/l111l11111I1l;
    //   302: aload_3
    //   303: invokevirtual l1111l111111Il : (Ljava/lang/Throwable;)Ljava/lang/String;
    //   306: invokevirtual getBytes : ()[B
    //   309: invokestatic l111l11111lIl : ([B)Ljava/lang/String;
    //   312: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload #4
    //   318: invokevirtual toString : ()Ljava/lang/String;
    //   321: astore_3
    //   322: aload_0
    //   323: monitorexit
    //   324: aload_3
    //   325: areturn
    //   326: astore_3
    //   327: new java/lang/StringBuilder
    //   330: dup
    //   331: ldc 'D'
    //   333: invokespecial <init> : (Ljava/lang/String;)V
    //   336: astore #4
    //   338: aload #4
    //   340: aload_3
    //   341: invokevirtual toString : ()Ljava/lang/String;
    //   344: invokevirtual getBytes : ()[B
    //   347: iconst_0
    //   348: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   351: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload #4
    //   357: invokevirtual toString : ()Ljava/lang/String;
    //   360: astore_3
    //   361: aload_0
    //   362: monitorexit
    //   363: aload_3
    //   364: areturn
    //   365: new java/lang/StringBuilder
    //   368: dup
    //   369: ldc 'D'
    //   371: invokespecial <init> : (Ljava/lang/String;)V
    //   374: astore_3
    //   375: aload_3
    //   376: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l11111lIl/l111l11111I1l;
    //   379: new java/lang/IllegalStateException
    //   382: dup
    //   383: invokespecial <init> : ()V
    //   386: invokevirtual l1111l111111Il : (Ljava/lang/Throwable;)Ljava/lang/String;
    //   389: invokevirtual getBytes : ()[B
    //   392: invokestatic l111l11111lIl : ([B)Ljava/lang/String;
    //   395: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload_3
    //   400: invokevirtual toString : ()Ljava/lang/String;
    //   403: astore_3
    //   404: aload_0
    //   405: monitorexit
    //   406: aload_3
    //   407: areturn
    //   408: astore_3
    //   409: new java/lang/StringBuilder
    //   412: dup
    //   413: ldc 'D'
    //   415: invokespecial <init> : (Ljava/lang/String;)V
    //   418: astore #4
    //   420: aload #4
    //   422: aload_3
    //   423: invokevirtual toString : ()Ljava/lang/String;
    //   426: invokevirtual getBytes : ()[B
    //   429: iconst_0
    //   430: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   433: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload #4
    //   439: invokevirtual toString : ()Ljava/lang/String;
    //   442: astore_3
    //   443: aload_0
    //   444: monitorexit
    //   445: aload_3
    //   446: areturn
    //   447: astore_3
    //   448: aload_0
    //   449: monitorexit
    //   450: aload_3
    //   451: athrow
    //   452: iconst_0
    //   453: istore_1
    //   454: goto -> 234
    // Exception table:
    //   from	to	target	type
    //   2	40	447	finally
    //   44	82	447	finally
    //   86	98	447	finally
    //   98	142	147	java/lang/Exception
    //   98	142	447	finally
    //   149	216	447	finally
    //   220	229	447	finally
    //   234	247	447	finally
    //   251	281	285	java/lang/Exception
    //   251	281	447	finally
    //   286	322	326	java/lang/Exception
    //   286	322	447	finally
    //   327	361	447	finally
    //   365	404	408	java/io/IOException
    //   365	404	447	finally
    //   409	443	447	finally
  }
  
  public String l111l11111Il() {
    boolean bool;
    com.ishumei.l111l11111lIl.l111l11111lIl l111l11111lIl1 = com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111lIl();
    int i = 0;
    if (l111l11111lIl1 == null || l111l11111lIl1.l11l1111Il()) {
      bool = true;
    } else {
      bool = false;
    } 
    int j = SmAntiFraud.l1111l111111Il.l11l1111lIIl();
    if (bool)
      i = 2; 
    return l1111l111111Il.l1111l111111Il().l1111l111111Il(j | i);
  }
  
  public final void l111l11111lIl() {
    this.l111l1111lI1l.l1111l111111Il();
  }
  
  public String l111l1111l1Il() {
    return SmAntiFraud.l1111l111111Il.l11l1111Il1l();
  }
  
  public static class l1111l111111Il {
    public static Context l111l11111Il;
    
    public static String l111l1111l1Il;
    
    boolean l1111l111111Il;
    
    l111l11111I1l.l1111l111111Il<?> l111l11111I1l;
    
    int l111l11111lIl;
    
    private String l111l1111lI1l;
    
    private l1111l111111Il l111l1111lIl;
    
    private String l111l1111llIl;
    
    private String l11l1111I11l;
    
    private l111l11111lIl l11l1111lIIl;
    
    public l1111l111111Il() {}
    
    l1111l111111Il(l1111l111111Il param1l1111l111111Il, l111l11111lIl param1l111l11111lIl, boolean param1Boolean, int param1Int, l111l11111I1l.l1111l111111Il<?> param1l1111l111111Il1, String param1String) {
      this.l111l1111llIl = null;
      this.l111l1111lI1l = null;
      this.l11l1111lIIl = null;
      this.l111l11111I1l = null;
      this.l111l1111lIl = param1l1111l111111Il;
      this.l11l1111lIIl = param1l111l11111lIl;
      this.l1111l111111Il = true;
      this.l111l11111lIl = 1;
      this.l111l11111I1l = param1l1111l111111Il1;
      this.l11l1111I11l = param1String;
    }
    
    private void l1111l111111Il(boolean param1Boolean) {
      if (SmAntiFraud.l1111l111111Il.l11l1111I1l())
        (new com.ishumei.l111l11111I1l.l111l11111lIl(this, param1Boolean, this.l111l11111lIl, false, 0L, false) {
            public final void run() {
              try {
                if (l111l1111llIl.l1111l111111Il.l1111l111111Il(this.l111l11111lIl) != null)
                  l111l1111llIl.l1111l111111Il.l1111l111111Il(this.l111l11111lIl, l111l1111llIl.l1111l111111Il.l1111l111111Il(this.l111l11111lIl).l111l11111Il()); 
                if (l111l1111llIl.l1111l111111Il.l111l11111lIl(this.l111l11111lIl) != null)
                  l111l1111llIl.l1111l111111Il.l111l11111lIl(this.l111l11111lIl, l111l1111llIl.l1111l111111Il.l111l11111lIl(this.l111l11111lIl).l111l1111l1Il()); 
                com.ishumei.l111l1111l1Il.l1111l111111Il l1111l111111Il1 = com.ishumei.l111l1111l1Il.l1111l111111Il.l1111l111111Il(l111l1111llIl.l1111l111111Il.l111l11111I1l(this.l111l11111lIl), SmAntiFraud.l1111l111111Il.l111l1111l1Il(), SmAntiFraud.l1111l111111Il.l111l11111Il());
                boolean bool = l111l1111llIl.l1111l111111Il.l111l11111Il(this.l111l11111lIl).contains("\"encode\":1");
                (new l111l11111I1l()).l1111l111111Il(l1111l111111Il1).l1111l111111Il(l111l1111llIl.l1111l111111Il.l111l11111Il(this.l111l11111lIl).getBytes("utf-8"), bool, null, this.l111l11111lIl.l111l11111I1l);
                return;
              } catch (Exception exception) {
                return;
              } 
            }
          }).l1111l111111Il(); 
    }
    
    final void l1111l111111Il() {
      l1111l111111Il(this.l1111l111111Il);
    }
    
    public static interface l1111l111111Il {
      String l111l11111Il();
    }
    
    public static interface l111l11111lIl {
      String l111l1111l1Il();
    }
  }
  
  final class null extends com.ishumei.l111l11111I1l.l111l11111lIl {
    null(l111l1111llIl this$0, boolean param1Boolean1, int param1Int, boolean param1Boolean2, long param1Long, boolean param1Boolean3) {
      super(param1Boolean1, param1Int, false, 0L, false);
    }
    
    public final void run() {
      try {
        if (l111l1111llIl.l1111l111111Il.l1111l111111Il(this.l111l11111lIl) != null)
          l111l1111llIl.l1111l111111Il.l1111l111111Il(this.l111l11111lIl, l111l1111llIl.l1111l111111Il.l1111l111111Il(this.l111l11111lIl).l111l11111Il()); 
        if (l111l1111llIl.l1111l111111Il.l111l11111lIl(this.l111l11111lIl) != null)
          l111l1111llIl.l1111l111111Il.l111l11111lIl(this.l111l11111lIl, l111l1111llIl.l1111l111111Il.l111l11111lIl(this.l111l11111lIl).l111l1111l1Il()); 
        com.ishumei.l111l1111l1Il.l1111l111111Il l1111l111111Il1 = com.ishumei.l111l1111l1Il.l1111l111111Il.l1111l111111Il(l111l1111llIl.l1111l111111Il.l111l11111I1l(this.l111l11111lIl), SmAntiFraud.l1111l111111Il.l111l1111l1Il(), SmAntiFraud.l1111l111111Il.l111l11111Il());
        boolean bool = l111l1111llIl.l1111l111111Il.l111l11111Il(this.l111l11111lIl).contains("\"encode\":1");
        (new l111l11111I1l()).l1111l111111Il(l1111l111111Il1).l1111l111111Il(l111l1111llIl.l1111l111111Il.l111l11111Il(this.l111l11111lIl).getBytes("utf-8"), bool, null, this.l111l11111lIl.l111l11111I1l);
        return;
      } catch (Exception exception) {
        return;
      } 
    }
  }
  
  public static interface l1111l111111Il {
    String l111l11111Il();
  }
  
  public static interface l111l11111lIl {
    String l111l1111l1Il();
  }
  
  static final class l111l11111lIl {
    private static final l111l1111llIl l1111l111111Il = new l111l1111llIl((byte)0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l1111l111111Il\l111l1111llIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */