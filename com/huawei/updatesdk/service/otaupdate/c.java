package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class c {
  private static String a;
  
  public void a(Context paramContext, String paramString, a parama) {
    boolean bool1 = com.huawei.updatesdk.b.f.b.e(paramContext, paramString);
    Boolean bool = Boolean.valueOf(false);
    if (!bool1 || !h.g().d()) {
      parama.a(bool);
      return;
    } 
    b b = new b(parama);
    b.executeOnExecutor(Executors.newSingleThreadExecutor(), (Object[])new Void[0]);
    try {
      Locale locale = Locale.ROOT;
      a = String.format(locale, "content://%s.commondata/item/4", new Object[] { paramString });
      b.get(500L, TimeUnit.MILLISECONDS);
      return;
    } catch (Exception exception) {
      b.cancel(true);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("init AutoUpdateInfo error: ");
      stringBuilder.append(exception.toString());
      Log.e("AutoUpdateUtil", stringBuilder.toString());
      parama.a(bool);
      return;
    } 
  }
  
  public static interface a {
    void a(Boolean param1Boolean);
  }
  
  static class b extends AsyncTask<Void, Void, Boolean> {
    c.a a;
    
    public b(c.a param1a) {
      this.a = param1a;
    }
    
    protected Boolean a(Void... param1VarArgs) {
      // Byte code:
      //   0: aconst_null
      //   1: astore #10
      //   3: aconst_null
      //   4: astore #9
      //   6: iconst_0
      //   7: istore_2
      //   8: iconst_0
      //   9: istore #4
      //   11: iconst_0
      //   12: istore_3
      //   13: aload #9
      //   15: astore #8
      //   17: aload #10
      //   19: astore_1
      //   20: invokestatic c : ()Lcom/huawei/updatesdk/a/b/a/a;
      //   23: invokevirtual a : ()Landroid/content/Context;
      //   26: astore #11
      //   28: aload #9
      //   30: astore #8
      //   32: aload #10
      //   34: astore_1
      //   35: invokestatic a : ()Ljava/lang/String;
      //   38: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
      //   41: astore #12
      //   43: aload #9
      //   45: astore #8
      //   47: aload #10
      //   49: astore_1
      //   50: aload #11
      //   52: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
      //   55: aload #12
      //   57: aconst_null
      //   58: aconst_null
      //   59: aconst_null
      //   60: aconst_null
      //   61: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   64: astore #9
      //   66: aload #9
      //   68: ifnull -> 207
      //   71: aload #9
      //   73: astore #8
      //   75: aload #9
      //   77: astore_1
      //   78: aload #9
      //   80: invokeinterface moveToFirst : ()Z
      //   85: ifeq -> 207
      //   88: aload #9
      //   90: astore #8
      //   92: aload #9
      //   94: astore_1
      //   95: aload #9
      //   97: aload #9
      //   99: ldc 'isagree'
      //   101: invokeinterface getColumnIndex : (Ljava/lang/String;)I
      //   106: invokeinterface getString : (I)Ljava/lang/String;
      //   111: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Boolean;
      //   114: invokevirtual booleanValue : ()Z
      //   117: istore #5
      //   119: aload #9
      //   121: astore #8
      //   123: aload #9
      //   125: astore_1
      //   126: aload #9
      //   128: aload #9
      //   130: ldc 'isopenautoupdate'
      //   132: invokeinterface getColumnIndex : (Ljava/lang/String;)I
      //   137: invokeinterface getString : (I)Ljava/lang/String;
      //   142: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Boolean;
      //   145: invokevirtual booleanValue : ()Z
      //   148: istore #6
      //   150: aload #9
      //   152: astore #8
      //   154: aload #9
      //   156: astore_1
      //   157: aload #9
      //   159: aload #9
      //   161: ldc 'isneverreminder'
      //   163: invokeinterface getColumnIndex : (Ljava/lang/String;)I
      //   168: invokeinterface getString : (I)Ljava/lang/String;
      //   173: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Boolean;
      //   176: invokevirtual booleanValue : ()Z
      //   179: istore #7
      //   181: iload_3
      //   182: istore_2
      //   183: iload #5
      //   185: ifeq -> 224
      //   188: iload_3
      //   189: istore_2
      //   190: iload #6
      //   192: ifne -> 224
      //   195: iload_3
      //   196: istore_2
      //   197: iload #7
      //   199: ifne -> 224
      //   202: iconst_1
      //   203: istore_2
      //   204: goto -> 224
      //   207: aload #9
      //   209: astore #8
      //   211: aload #9
      //   213: astore_1
      //   214: ldc 'AutoUpdateUtil'
      //   216: ldc 'cursor == null'
      //   218: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
      //   221: pop
      //   222: iload_3
      //   223: istore_2
      //   224: iload_2
      //   225: istore_3
      //   226: aload #9
      //   228: ifnull -> 321
      //   231: aload #9
      //   233: astore_1
      //   234: aload_1
      //   235: invokeinterface close : ()V
      //   240: iload_2
      //   241: istore_3
      //   242: goto -> 321
      //   245: astore_1
      //   246: goto -> 326
      //   249: astore #9
      //   251: aload_1
      //   252: astore #8
      //   254: new java/lang/StringBuilder
      //   257: dup
      //   258: invokespecial <init> : ()V
      //   261: astore #10
      //   263: aload_1
      //   264: astore #8
      //   266: aload #10
      //   268: ldc 'close cursor error: '
      //   270: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   273: pop
      //   274: aload_1
      //   275: astore #8
      //   277: aload #10
      //   279: aload #9
      //   281: invokevirtual toString : ()Ljava/lang/String;
      //   284: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   287: pop
      //   288: aload_1
      //   289: astore #8
      //   291: ldc 'AutoUpdateUtil'
      //   293: aload #10
      //   295: invokevirtual toString : ()Ljava/lang/String;
      //   298: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
      //   301: pop
      //   302: iload #4
      //   304: istore_3
      //   305: aload_1
      //   306: ifnull -> 321
      //   309: goto -> 234
      //   312: ldc 'AutoUpdateUtil'
      //   314: ldc 'cursor Execption'
      //   316: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
      //   319: iload_2
      //   320: istore_3
      //   321: iload_3
      //   322: invokestatic valueOf : (Z)Ljava/lang/Boolean;
      //   325: areturn
      //   326: aload #8
      //   328: ifnull -> 348
      //   331: aload #8
      //   333: invokeinterface close : ()V
      //   338: goto -> 348
      //   341: ldc 'AutoUpdateUtil'
      //   343: ldc 'cursor Execption'
      //   345: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
      //   348: aload_1
      //   349: athrow
      //   350: astore_1
      //   351: goto -> 312
      //   354: astore #8
      //   356: goto -> 341
      // Exception table:
      //   from	to	target	type
      //   20	28	249	java/lang/Exception
      //   20	28	245	finally
      //   35	43	249	java/lang/Exception
      //   35	43	245	finally
      //   50	66	249	java/lang/Exception
      //   50	66	245	finally
      //   78	88	249	java/lang/Exception
      //   78	88	245	finally
      //   95	119	249	java/lang/Exception
      //   95	119	245	finally
      //   126	150	249	java/lang/Exception
      //   126	150	245	finally
      //   157	181	249	java/lang/Exception
      //   157	181	245	finally
      //   214	222	249	java/lang/Exception
      //   214	222	245	finally
      //   234	240	350	java/lang/Exception
      //   254	263	245	finally
      //   266	274	245	finally
      //   277	288	245	finally
      //   291	302	245	finally
      //   331	338	354	java/lang/Exception
    }
    
    protected void a(Boolean param1Boolean) {
      c.a a1 = this.a;
      if (a1 != null)
        a1.a(param1Boolean); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */