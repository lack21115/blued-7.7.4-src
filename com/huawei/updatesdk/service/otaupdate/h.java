package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class h {
  private static h e = new h();
  
  private static String f;
  
  private String a;
  
  private String b;
  
  private String c = null;
  
  private String d;
  
  public static h g() {
    return e;
  }
  
  public String a() {
    return !TextUtils.isEmpty(this.a) ? this.a : this.b;
  }
  
  public void a(Context paramContext, String paramString) {
    this.b = null;
    if (!com.huawei.updatesdk.b.f.b.d(paramContext, paramString))
      return; 
    long l = com.huawei.updatesdk.b.b.a.c().b(paramString);
    if (Math.abs(System.currentTimeMillis() - l) < 86400000L) {
      String str = com.huawei.updatesdk.b.b.a.c().a(paramString);
      g().a(str);
      return;
    } 
    f = String.format(Locale.ROOT, "content://%s.commondata/item/1", new Object[] { paramString });
    b b = new b(null);
    b.executeOnExecutor(Executors.newSingleThreadExecutor(), (Object[])new Void[0]);
    try {
      b.get(1000L, TimeUnit.MILLISECONDS);
      return;
    } catch (Exception exception) {
      b.cancel(true);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("init AccountZone error: ");
      stringBuilder.append(exception.toString());
      Log.e("ServiceZoneUtil", stringBuilder.toString());
      return;
    } 
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public String b() {
    return this.a;
  }
  
  public void b(String paramString) {
    this.a = paramString;
  }
  
  public String c() {
    return this.c;
  }
  
  public void c(String paramString) {
    this.d = paramString;
  }
  
  public void d(String paramString) {
    this.c = paramString;
  }
  
  public boolean d() {
    String str = this.a;
    return (str != null) ? str.equals(this.b) : true;
  }
  
  public boolean e() {
    return TextUtils.equals(this.d, "AppTouch");
  }
  
  static class b extends AsyncTask<Void, Void, String> {
    private b() {}
    
    protected String a(Void... param1VarArgs) {
      // Byte code:
      //   0: invokestatic f : ()Ljava/lang/String;
      //   3: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
      //   6: astore_1
      //   7: aconst_null
      //   8: astore_2
      //   9: aconst_null
      //   10: astore #5
      //   12: aconst_null
      //   13: astore #6
      //   15: aconst_null
      //   16: astore #4
      //   18: invokestatic c : ()Lcom/huawei/updatesdk/a/b/a/a;
      //   21: invokevirtual a : ()Landroid/content/Context;
      //   24: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
      //   27: aload_1
      //   28: aconst_null
      //   29: aconst_null
      //   30: aconst_null
      //   31: aconst_null
      //   32: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   35: astore_3
      //   36: aload_3
      //   37: ifnull -> 118
      //   40: aload #6
      //   42: astore_1
      //   43: aload_3
      //   44: invokeinterface moveToFirst : ()Z
      //   49: ifeq -> 118
      //   52: aload #6
      //   54: astore_1
      //   55: aload_3
      //   56: aload_3
      //   57: ldc 'homecountry'
      //   59: invokeinterface getColumnIndex : (Ljava/lang/String;)I
      //   64: invokeinterface getString : (I)Ljava/lang/String;
      //   69: astore_2
      //   70: aload_2
      //   71: astore_1
      //   72: invokestatic g : ()Lcom/huawei/updatesdk/service/otaupdate/h;
      //   75: aload_2
      //   76: invokevirtual a : (Ljava/lang/String;)V
      //   79: aload_2
      //   80: astore_1
      //   81: invokestatic g : ()Lcom/huawei/updatesdk/service/otaupdate/h;
      //   84: invokevirtual c : ()Ljava/lang/String;
      //   87: astore #4
      //   89: aload_2
      //   90: astore_1
      //   91: invokestatic c : ()Lcom/huawei/updatesdk/b/b/a;
      //   94: aload #4
      //   96: invokestatic currentTimeMillis : ()J
      //   99: invokevirtual a : (Ljava/lang/String;J)V
      //   102: aload_2
      //   103: astore_1
      //   104: invokestatic c : ()Lcom/huawei/updatesdk/b/b/a;
      //   107: aload #4
      //   109: aload_2
      //   110: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
      //   113: aload_2
      //   114: astore_1
      //   115: goto -> 132
      //   118: aload #6
      //   120: astore_1
      //   121: ldc 'ServiceZoneUtil'
      //   123: ldc 'cursor == null: '
      //   125: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
      //   128: pop
      //   129: aload #4
      //   131: astore_1
      //   132: aload_1
      //   133: astore_2
      //   134: aload_3
      //   135: ifnull -> 228
      //   138: aload_3
      //   139: invokeinterface close : ()V
      //   144: aload_1
      //   145: areturn
      //   146: astore_1
      //   147: goto -> 230
      //   150: astore #4
      //   152: aconst_null
      //   153: astore_1
      //   154: aload #5
      //   156: astore_3
      //   157: aload_3
      //   158: astore_2
      //   159: new java/lang/StringBuilder
      //   162: dup
      //   163: invokespecial <init> : ()V
      //   166: astore #5
      //   168: aload_3
      //   169: astore_2
      //   170: aload #5
      //   172: ldc 'close cursor error: '
      //   174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   177: pop
      //   178: aload_3
      //   179: astore_2
      //   180: aload #5
      //   182: aload #4
      //   184: invokevirtual toString : ()Ljava/lang/String;
      //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   190: pop
      //   191: aload_3
      //   192: astore_2
      //   193: ldc 'ServiceZoneUtil'
      //   195: aload #5
      //   197: invokevirtual toString : ()Ljava/lang/String;
      //   200: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
      //   203: pop
      //   204: aload_3
      //   205: ifnull -> 226
      //   208: aload_3
      //   209: invokeinterface close : ()V
      //   214: goto -> 226
      //   217: ldc 'ServiceZoneUtil'
      //   219: ldc 'cursor Execption'
      //   221: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
      //   224: aload_1
      //   225: areturn
      //   226: aload_1
      //   227: astore_2
      //   228: aload_2
      //   229: areturn
      //   230: aload_2
      //   231: ifnull -> 250
      //   234: aload_2
      //   235: invokeinterface close : ()V
      //   240: goto -> 250
      //   243: ldc 'ServiceZoneUtil'
      //   245: ldc 'cursor Execption'
      //   247: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
      //   250: aload_1
      //   251: athrow
      //   252: astore_2
      //   253: goto -> 217
      //   256: astore_2
      //   257: goto -> 217
      //   260: astore_2
      //   261: goto -> 243
      //   264: astore_1
      //   265: aload_3
      //   266: astore_2
      //   267: goto -> 230
      //   270: astore #4
      //   272: goto -> 157
      // Exception table:
      //   from	to	target	type
      //   18	36	150	java/lang/Exception
      //   18	36	146	finally
      //   43	52	270	java/lang/Exception
      //   43	52	264	finally
      //   55	70	270	java/lang/Exception
      //   55	70	264	finally
      //   72	79	270	java/lang/Exception
      //   72	79	264	finally
      //   81	89	270	java/lang/Exception
      //   81	89	264	finally
      //   91	102	270	java/lang/Exception
      //   91	102	264	finally
      //   104	113	270	java/lang/Exception
      //   104	113	264	finally
      //   121	129	270	java/lang/Exception
      //   121	129	264	finally
      //   138	144	252	java/lang/Exception
      //   159	168	146	finally
      //   170	178	146	finally
      //   180	191	146	finally
      //   193	204	146	finally
      //   208	214	256	java/lang/Exception
      //   234	240	260	java/lang/Exception
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */