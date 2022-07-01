package com.huawei.updatesdk.a.a.c.i;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.updatesdk.a.a.c.i.c.b;

public class a {
  private static final Uri a = Uri.parse("content://telephony/carriers/preferapn");
  
  private static final Uri b = Uri.parse("content://telephony/carriers/preferapn/0");
  
  private static final Uri c = Uri.parse("content://telephony/carriers/preferapn/1");
  
  public static a a(Context paramContext) throws SecurityException {
    // Byte code:
    //   0: new com/huawei/updatesdk/a/a/c/i/a$a
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore #4
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_2
    //   14: astore_1
    //   15: invokestatic d : ()Z
    //   18: ifeq -> 31
    //   21: aload_2
    //   22: astore_1
    //   23: aload_0
    //   24: invokestatic c : (Landroid/content/Context;)Landroid/database/Cursor;
    //   27: astore_0
    //   28: goto -> 38
    //   31: aload_2
    //   32: astore_1
    //   33: aload_0
    //   34: invokestatic e : (Landroid/content/Context;)Landroid/database/Cursor;
    //   37: astore_0
    //   38: aload_0
    //   39: ifnonnull -> 54
    //   42: aload_0
    //   43: ifnull -> 52
    //   46: aload_0
    //   47: invokeinterface close : ()V
    //   52: aconst_null
    //   53: areturn
    //   54: aload_0
    //   55: astore_1
    //   56: aload_0
    //   57: invokeinterface moveToNext : ()Z
    //   62: ifeq -> 134
    //   65: aload_0
    //   66: astore_1
    //   67: aload_3
    //   68: aload_0
    //   69: aload_0
    //   70: ldc '_id'
    //   72: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   77: invokeinterface getString : (I)Ljava/lang/String;
    //   82: invokevirtual b : (Ljava/lang/String;)V
    //   85: aload_0
    //   86: astore_1
    //   87: aload_3
    //   88: aload_0
    //   89: aload_0
    //   90: ldc 'name'
    //   92: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   97: invokeinterface getString : (I)Ljava/lang/String;
    //   102: invokevirtual c : (Ljava/lang/String;)V
    //   105: aload_0
    //   106: astore_1
    //   107: aload_3
    //   108: aload_0
    //   109: aload_0
    //   110: ldc 'apn'
    //   112: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   117: invokeinterface getString : (I)Ljava/lang/String;
    //   122: invokestatic getDefault : ()Ljava/util/Locale;
    //   125: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   128: invokevirtual a : (Ljava/lang/String;)V
    //   131: goto -> 54
    //   134: aload_0
    //   135: ifnull -> 180
    //   138: goto -> 174
    //   141: astore_0
    //   142: goto -> 211
    //   145: astore_2
    //   146: goto -> 160
    //   149: astore_2
    //   150: goto -> 197
    //   153: astore_0
    //   154: goto -> 211
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_0
    //   160: aload_0
    //   161: astore_1
    //   162: ldc 'ApnUtil'
    //   164: ldc 'getDefaultAPN, Exception: '
    //   166: aload_2
    //   167: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   170: aload_0
    //   171: ifnull -> 180
    //   174: aload_0
    //   175: invokeinterface close : ()V
    //   180: aload_3
    //   181: astore_0
    //   182: aload_3
    //   183: invokevirtual b : ()Ljava/lang/String;
    //   186: ifnonnull -> 191
    //   189: aconst_null
    //   190: astore_0
    //   191: aload_0
    //   192: areturn
    //   193: astore_2
    //   194: aload #4
    //   196: astore_0
    //   197: aload_0
    //   198: astore_1
    //   199: ldc 'ApnUtil'
    //   201: ldc 'getDefaultAPN, SecurityException: '
    //   203: aload_2
    //   204: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   207: aload_0
    //   208: astore_1
    //   209: aload_2
    //   210: athrow
    //   211: aload_1
    //   212: ifnull -> 221
    //   215: aload_1
    //   216: invokeinterface close : ()V
    //   221: aload_0
    //   222: athrow
    // Exception table:
    //   from	to	target	type
    //   15	21	193	java/lang/SecurityException
    //   15	21	157	java/lang/Exception
    //   15	21	153	finally
    //   23	28	193	java/lang/SecurityException
    //   23	28	157	java/lang/Exception
    //   23	28	153	finally
    //   33	38	193	java/lang/SecurityException
    //   33	38	157	java/lang/Exception
    //   33	38	153	finally
    //   56	65	149	java/lang/SecurityException
    //   56	65	145	java/lang/Exception
    //   56	65	141	finally
    //   67	85	149	java/lang/SecurityException
    //   67	85	145	java/lang/Exception
    //   67	85	141	finally
    //   87	105	149	java/lang/SecurityException
    //   87	105	145	java/lang/Exception
    //   87	105	141	finally
    //   107	131	149	java/lang/SecurityException
    //   107	131	145	java/lang/Exception
    //   107	131	141	finally
    //   162	170	141	finally
    //   199	207	153	finally
    //   209	211	153	finally
  }
  
  private static Cursor b(Context paramContext) {
    return paramContext.getContentResolver().query(b, null, null, null, null);
  }
  
  private static Cursor c(Context paramContext) {
    Cursor cursor1;
    if (b.a().a() == 0) {
      Cursor cursor = b(paramContext);
      cursor1 = cursor;
      if (cursor == null)
        cursor1 = d(paramContext); 
    } else {
      Cursor cursor = d(paramContext);
      cursor1 = cursor;
      if (cursor == null)
        cursor1 = b(paramContext); 
    } 
    Cursor cursor2 = cursor1;
    if (cursor1 == null)
      cursor2 = e(paramContext); 
    return cursor2;
  }
  
  private static Cursor d(Context paramContext) {
    return paramContext.getContentResolver().query(c, null, null, null, null);
  }
  
  private static Cursor e(Context paramContext) {
    return paramContext.getContentResolver().query(a, null, null, null, null);
  }
  
  public static boolean f(Context paramContext) {
    try {
      a a1 = a(paramContext);
      if (a1 != null) {
        if (a1.a() != null) {
          boolean bool = a1.a().contains("wap");
          if (bool)
            return true; 
        } 
        return false;
      } 
      return true;
    } catch (SecurityException securityException) {
      com.huawei.updatesdk.a.a.b.a.a.a.a("ApnUtil", "isWap(), SecurityException: ", securityException);
      return false;
    } 
  }
  
  public static class a {
    private String a;
    
    private String b;
    
    public String a() {
      return this.b;
    }
    
    public void a(String param1String) {
      this.b = param1String;
    }
    
    public String b() {
      return this.a;
    }
    
    public void b(String param1String) {
      this.a = param1String;
    }
    
    public void c(String param1String) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\c\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */