package com.alipay.sdk.tid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alipay.sdk.util.c;
import java.lang.ref.WeakReference;

final class a extends SQLiteOpenHelper {
  private static final String a = "msp.db";
  
  private static final int b = 1;
  
  private WeakReference<Context> c;
  
  a(Context paramContext) {
    super(paramContext, "msp.db", null, 1);
    this.c = new WeakReference<Context>(paramContext);
  }
  
  private String c(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(paramString2);
    return stringBuilder.toString();
  }
  
  String a(String paramString1, String paramString2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aconst_null
    //   4: astore #6
    //   6: aconst_null
    //   7: astore #5
    //   9: aconst_null
    //   10: astore #7
    //   12: aload_0
    //   13: invokevirtual getReadableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore_3
    //   17: aload_3
    //   18: ldc 'select tid from tb_tid where name=?'
    //   20: iconst_1
    //   21: anewarray java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: aload_0
    //   27: aload_1
    //   28: aload_2
    //   29: invokespecial c : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   32: aastore
    //   33: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_2
    //   37: aload #7
    //   39: astore_1
    //   40: aload_2
    //   41: invokeinterface moveToFirst : ()Z
    //   46: ifeq -> 57
    //   49: aload_2
    //   50: iconst_0
    //   51: invokeinterface getString : (I)Ljava/lang/String;
    //   56: astore_1
    //   57: aload_2
    //   58: ifnull -> 67
    //   61: aload_2
    //   62: invokeinterface close : ()V
    //   67: aload_1
    //   68: astore_2
    //   69: aload_3
    //   70: ifnull -> 182
    //   73: aload_1
    //   74: astore_2
    //   75: aload_3
    //   76: invokevirtual isOpen : ()Z
    //   79: ifeq -> 182
    //   82: aload_3
    //   83: invokevirtual close : ()V
    //   86: aload_1
    //   87: astore_2
    //   88: goto -> 182
    //   91: astore_1
    //   92: goto -> 118
    //   95: aload_2
    //   96: astore_1
    //   97: goto -> 149
    //   100: astore_1
    //   101: aload #6
    //   103: astore_2
    //   104: goto -> 118
    //   107: aconst_null
    //   108: astore_1
    //   109: goto -> 149
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_3
    //   115: aload #6
    //   117: astore_2
    //   118: aload_2
    //   119: ifnull -> 128
    //   122: aload_2
    //   123: invokeinterface close : ()V
    //   128: aload_3
    //   129: ifnull -> 143
    //   132: aload_3
    //   133: invokevirtual isOpen : ()Z
    //   136: ifeq -> 143
    //   139: aload_3
    //   140: invokevirtual close : ()V
    //   143: aload_1
    //   144: athrow
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: astore_3
    //   149: aload_1
    //   150: ifnull -> 159
    //   153: aload_1
    //   154: invokeinterface close : ()V
    //   159: aload #5
    //   161: astore_2
    //   162: aload_3
    //   163: ifnull -> 182
    //   166: aload #5
    //   168: astore_2
    //   169: aload_3
    //   170: invokevirtual isOpen : ()Z
    //   173: ifeq -> 182
    //   176: aload #4
    //   178: astore_1
    //   179: goto -> 82
    //   182: aload_2
    //   183: astore_1
    //   184: aload_2
    //   185: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   188: ifne -> 209
    //   191: aload_2
    //   192: aload_0
    //   193: getfield c : Ljava/lang/ref/WeakReference;
    //   196: invokevirtual get : ()Ljava/lang/Object;
    //   199: checkcast android/content/Context
    //   202: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   205: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   208: astore_1
    //   209: aload_1
    //   210: areturn
    //   211: astore_1
    //   212: goto -> 145
    //   215: astore_1
    //   216: goto -> 107
    //   219: astore_1
    //   220: goto -> 95
    // Exception table:
    //   from	to	target	type
    //   12	17	211	java/lang/Exception
    //   12	17	112	finally
    //   17	37	215	java/lang/Exception
    //   17	37	100	finally
    //   40	57	219	java/lang/Exception
    //   40	57	91	finally
  }
  
  void a() {
    SQLiteDatabase sQLiteDatabase1 = null;
    SQLiteDatabase sQLiteDatabase2 = null;
    try {
      SQLiteDatabase sQLiteDatabase = getWritableDatabase();
      sQLiteDatabase2 = sQLiteDatabase;
      sQLiteDatabase1 = sQLiteDatabase;
      sQLiteDatabase.execSQL("drop table if exists tb_tid");
      if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
        sQLiteDatabase1 = sQLiteDatabase;
      } else {
        return;
      } 
    } catch (Exception exception) {
      sQLiteDatabase2 = sQLiteDatabase1;
      c.a(exception);
      if (sQLiteDatabase1 != null && sQLiteDatabase1.isOpen()) {
        sQLiteDatabase1.close();
        return;
      } 
    } finally {}
    sQLiteDatabase1.close();
  }
  
  String b(String paramString1, String paramString2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aconst_null
    //   4: astore #6
    //   6: aconst_null
    //   7: astore #5
    //   9: aconst_null
    //   10: astore #7
    //   12: aload_0
    //   13: invokevirtual getReadableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore_3
    //   17: aload_3
    //   18: ldc 'select key_tid from tb_tid where name=?'
    //   20: iconst_1
    //   21: anewarray java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: aload_0
    //   27: aload_1
    //   28: aload_2
    //   29: invokespecial c : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   32: aastore
    //   33: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_2
    //   37: aload #7
    //   39: astore_1
    //   40: aload_2
    //   41: invokeinterface moveToFirst : ()Z
    //   46: ifeq -> 57
    //   49: aload_2
    //   50: iconst_0
    //   51: invokeinterface getString : (I)Ljava/lang/String;
    //   56: astore_1
    //   57: aload_2
    //   58: ifnull -> 67
    //   61: aload_2
    //   62: invokeinterface close : ()V
    //   67: aload_1
    //   68: astore_2
    //   69: aload_3
    //   70: ifnull -> 179
    //   73: aload_1
    //   74: astore_2
    //   75: aload_3
    //   76: invokevirtual isOpen : ()Z
    //   79: ifeq -> 179
    //   82: aload_3
    //   83: invokevirtual close : ()V
    //   86: aload_1
    //   87: areturn
    //   88: astore_1
    //   89: goto -> 115
    //   92: aload_2
    //   93: astore_1
    //   94: goto -> 146
    //   97: astore_1
    //   98: aload #6
    //   100: astore_2
    //   101: goto -> 115
    //   104: aconst_null
    //   105: astore_1
    //   106: goto -> 146
    //   109: astore_1
    //   110: aconst_null
    //   111: astore_3
    //   112: aload #6
    //   114: astore_2
    //   115: aload_2
    //   116: ifnull -> 125
    //   119: aload_2
    //   120: invokeinterface close : ()V
    //   125: aload_3
    //   126: ifnull -> 140
    //   129: aload_3
    //   130: invokevirtual isOpen : ()Z
    //   133: ifeq -> 140
    //   136: aload_3
    //   137: invokevirtual close : ()V
    //   140: aload_1
    //   141: athrow
    //   142: aconst_null
    //   143: astore_1
    //   144: aload_1
    //   145: astore_3
    //   146: aload_1
    //   147: ifnull -> 156
    //   150: aload_1
    //   151: invokeinterface close : ()V
    //   156: aload #5
    //   158: astore_2
    //   159: aload_3
    //   160: ifnull -> 179
    //   163: aload #5
    //   165: astore_2
    //   166: aload_3
    //   167: invokevirtual isOpen : ()Z
    //   170: ifeq -> 179
    //   173: aload #4
    //   175: astore_1
    //   176: goto -> 82
    //   179: aload_2
    //   180: areturn
    //   181: astore_1
    //   182: goto -> 142
    //   185: astore_1
    //   186: goto -> 104
    //   189: astore_1
    //   190: goto -> 92
    // Exception table:
    //   from	to	target	type
    //   12	17	181	java/lang/Exception
    //   12	17	109	finally
    //   17	37	185	java/lang/Exception
    //   17	37	97	finally
    //   40	57	189	java/lang/Exception
    //   40	57	88	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    paramSQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    paramSQLiteDatabase.execSQL("drop table if exists tb_tid");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\tid\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */