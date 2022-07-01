package com.alipay.security.mobile.module.d;

import com.alipay.security.mobile.module.http.v2.a;
import java.io.File;
import org.json.JSONObject;

public final class b {
  private File a = null;
  
  private a b = null;
  
  public b(String paramString, a parama) {
    this.a = new File(paramString);
    this.b = parama;
  }
  
  private static String a(String paramString) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("type", "id");
      jSONObject.put("error", paramString);
      return jSONObject.toString();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/io/File;
    //   6: astore #5
    //   8: aload #5
    //   10: ifnonnull -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield a : Ljava/io/File;
    //   20: invokevirtual exists : ()Z
    //   23: ifeq -> 332
    //   26: aload_0
    //   27: getfield a : Ljava/io/File;
    //   30: invokevirtual isDirectory : ()Z
    //   33: ifeq -> 332
    //   36: aload_0
    //   37: getfield a : Ljava/io/File;
    //   40: invokevirtual list : ()[Ljava/lang/String;
    //   43: arraylength
    //   44: ifne -> 50
    //   47: goto -> 332
    //   50: new java/util/ArrayList
    //   53: dup
    //   54: invokespecial <init> : ()V
    //   57: astore #7
    //   59: aload_0
    //   60: getfield a : Ljava/io/File;
    //   63: invokevirtual list : ()[Ljava/lang/String;
    //   66: astore #5
    //   68: aload #5
    //   70: arraylength
    //   71: istore_2
    //   72: iconst_0
    //   73: istore #4
    //   75: iconst_0
    //   76: istore_1
    //   77: iload_1
    //   78: iload_2
    //   79: if_icmpge -> 101
    //   82: aload #7
    //   84: aload #5
    //   86: iload_1
    //   87: aaload
    //   88: invokeinterface add : (Ljava/lang/Object;)Z
    //   93: pop
    //   94: iload_1
    //   95: iconst_1
    //   96: iadd
    //   97: istore_1
    //   98: goto -> 77
    //   101: aload #7
    //   103: invokestatic sort : (Ljava/util/List;)V
    //   106: aload #7
    //   108: aload #7
    //   110: invokeinterface size : ()I
    //   115: iconst_1
    //   116: isub
    //   117: invokeinterface get : (I)Ljava/lang/Object;
    //   122: checkcast java/lang/String
    //   125: astore #6
    //   127: aload #7
    //   129: invokeinterface size : ()I
    //   134: istore_2
    //   135: invokestatic getInstance : ()Ljava/util/Calendar;
    //   138: invokevirtual getTime : ()Ljava/util/Date;
    //   141: astore #5
    //   143: new java/text/SimpleDateFormat
    //   146: dup
    //   147: ldc 'yyyyMMdd'
    //   149: invokespecial <init> : (Ljava/lang/String;)V
    //   152: aload #5
    //   154: invokevirtual format : (Ljava/util/Date;)Ljava/lang/String;
    //   157: astore #5
    //   159: new java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial <init> : ()V
    //   166: astore #8
    //   168: aload #8
    //   170: aload #5
    //   172: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload #8
    //   178: ldc '.log'
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload #6
    //   186: astore #5
    //   188: iload_2
    //   189: istore_1
    //   190: aload #6
    //   192: aload #8
    //   194: invokevirtual toString : ()Ljava/lang/String;
    //   197: invokevirtual equals : (Ljava/lang/Object;)Z
    //   200: ifeq -> 244
    //   203: aload #7
    //   205: invokeinterface size : ()I
    //   210: istore_1
    //   211: iload_1
    //   212: iconst_2
    //   213: if_icmpge -> 219
    //   216: aload_0
    //   217: monitorexit
    //   218: return
    //   219: aload #7
    //   221: aload #7
    //   223: invokeinterface size : ()I
    //   228: iconst_2
    //   229: isub
    //   230: invokeinterface get : (I)Ljava/lang/Object;
    //   235: checkcast java/lang/String
    //   238: astore #5
    //   240: iload_2
    //   241: iconst_1
    //   242: isub
    //   243: istore_1
    //   244: aload_0
    //   245: getfield a : Ljava/io/File;
    //   248: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   251: aload #5
    //   253: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   256: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   259: astore #5
    //   261: iload_1
    //   262: istore_2
    //   263: iload #4
    //   265: istore_3
    //   266: aload_0
    //   267: getfield b : Lcom/alipay/security/mobile/module/http/v2/a;
    //   270: aload #5
    //   272: invokeinterface a : (Ljava/lang/String;)Z
    //   277: ifne -> 287
    //   280: iload_1
    //   281: iconst_1
    //   282: isub
    //   283: istore_2
    //   284: iload #4
    //   286: istore_3
    //   287: iload_3
    //   288: iload_2
    //   289: if_icmpge -> 329
    //   292: aload #7
    //   294: iload_3
    //   295: invokeinterface get : (I)Ljava/lang/Object;
    //   300: checkcast java/lang/String
    //   303: astore #5
    //   305: new java/io/File
    //   308: dup
    //   309: aload_0
    //   310: getfield a : Ljava/io/File;
    //   313: aload #5
    //   315: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   318: invokevirtual delete : ()Z
    //   321: pop
    //   322: iload_3
    //   323: iconst_1
    //   324: iadd
    //   325: istore_3
    //   326: goto -> 287
    //   329: aload_0
    //   330: monitorexit
    //   331: return
    //   332: aload_0
    //   333: monitorexit
    //   334: return
    //   335: astore #5
    //   337: aload_0
    //   338: monitorexit
    //   339: aload #5
    //   341: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	335	finally
    //   16	47	335	finally
    //   50	72	335	finally
    //   82	94	335	finally
    //   101	184	335	finally
    //   190	211	335	finally
    //   219	240	335	finally
    //   244	261	335	finally
    //   266	280	335	finally
    //   292	322	335	finally
  }
  
  public final void a() {
    (new Thread(new c(this))).start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */