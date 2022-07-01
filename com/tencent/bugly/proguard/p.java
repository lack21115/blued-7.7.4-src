package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class p {
  private static p a;
  
  private static q b;
  
  private static boolean c = false;
  
  private p(Context paramContext, List<com.tencent.bugly.a> paramList) {
    b = new q(paramContext, paramList);
  }
  
  private int a(String paramString1, String paramString2, String[] paramArrayOfString, o paramo) {
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
    boolean bool = false;
    int j = 0;
    int i = 0;
    try {
      SQLiteDatabase sQLiteDatabase = b.getWritableDatabase();
      if (sQLiteDatabase != null)
        i = sQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString); 
      j = i;
    } finally {
      paramString1 = null;
    } 
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
    return j;
  }
  
  private long a(String paramString, ContentValues paramContentValues, o paramo) {
    long l2;
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
    long l1 = 0L;
    try {
      SQLiteDatabase sQLiteDatabase = b.getWritableDatabase();
      long l = l1;
      if (sQLiteDatabase != null) {
        l = l1;
        if (paramContentValues != null) {
          l = sQLiteDatabase.replace(paramString, "_id", paramContentValues);
          if (l >= 0L) {
            x.c("[Database] insert %s success.", new Object[] { paramString });
          } else {
            x.d("[Database] replace %s error.", new Object[] { paramString });
          } 
        } 
      } 
      l2 = l;
    } finally {
      paramString = null;
    } 
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
    return l2;
  }
  
  private Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, o paramo) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore #11
    //   5: getstatic com/tencent/bugly/proguard/p.b : Lcom/tencent/bugly/proguard/q;
    //   8: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   11: astore #12
    //   13: aload #11
    //   15: astore #10
    //   17: aload #12
    //   19: ifnull -> 67
    //   22: aload #12
    //   24: iload_1
    //   25: aload_2
    //   26: aload_3
    //   27: aload #4
    //   29: aload #5
    //   31: aload #6
    //   33: aload #7
    //   35: aload #8
    //   37: aload #9
    //   39: invokevirtual query : (ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore #10
    //   44: goto -> 67
    //   47: astore_2
    //   48: aload #11
    //   50: astore #10
    //   52: aload_2
    //   53: invokestatic a : (Ljava/lang/Throwable;)Z
    //   56: ifne -> 67
    //   59: aload_2
    //   60: invokevirtual printStackTrace : ()V
    //   63: aload #11
    //   65: astore #10
    //   67: aload_0
    //   68: monitorexit
    //   69: aload #10
    //   71: areturn
    //   72: astore_2
    //   73: aload_2
    //   74: athrow
    //   75: astore_2
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_2
    //   79: athrow
    // Exception table:
    //   from	to	target	type
    //   5	13	47	finally
    //   22	44	47	finally
    //   52	63	72	finally
    //   73	75	75	finally
  }
  
  public static p a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/p
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/p.a : Lcom/tencent/bugly/proguard/p;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/proguard/p
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/proguard/p
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static p a(Context paramContext, List<com.tencent.bugly.a> paramList) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/p
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/p.a : Lcom/tencent/bugly/proguard/p;
    //   6: ifnonnull -> 21
    //   9: new com/tencent/bugly/proguard/p
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial <init> : (Landroid/content/Context;Ljava/util/List;)V
    //   18: putstatic com/tencent/bugly/proguard/p.a : Lcom/tencent/bugly/proguard/p;
    //   21: getstatic com/tencent/bugly/proguard/p.a : Lcom/tencent/bugly/proguard/p;
    //   24: astore_0
    //   25: ldc com/tencent/bugly/proguard/p
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/tencent/bugly/proguard/p
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  private static r a(Cursor paramCursor) {
    if (paramCursor == null)
      return null; 
    try {
      r r = new r();
      r.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      r.b = paramCursor.getInt(paramCursor.getColumnIndex("_tp"));
      r.c = paramCursor.getString(paramCursor.getColumnIndex("_pc"));
      r.d = paramCursor.getString(paramCursor.getColumnIndex("_th"));
      return r;
    } finally {
      paramCursor = null;
      if (!x.a((Throwable)paramCursor))
        paramCursor.printStackTrace(); 
    } 
  }
  
  private Map<String, byte[]> a(int paramInt, o paramo) {
    Exception exception;
    HashMap<Object, Object> hashMap = null;
    paramo = null;
    try {
      List<r> list = c(paramInt);
      if (list != null) {
        hashMap = new HashMap<Object, Object>();
        try {
          return (Map)hashMap;
        } finally {
          list = null;
        } 
      } else {
        return (Map)hashMap;
      } 
    } finally {}
    hashMap = null;
    try {
      if (!x.a(exception)) {
        exception.printStackTrace();
        hashMap = null;
      } 
      return (Map)hashMap;
    } finally {}
  }
  
  private boolean a(int paramInt, String paramString, o paramo) {
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    try {
      SQLiteDatabase sQLiteDatabase = b.getWritableDatabase();
      boolean bool = bool1;
      if (sQLiteDatabase != null) {
        String str;
        if (z.a(paramString)) {
          StringBuilder stringBuilder = new StringBuilder("_id = ");
          stringBuilder.append(paramInt);
          str = stringBuilder.toString();
        } else {
          StringBuilder stringBuilder = new StringBuilder("_id = ");
          stringBuilder.append(paramInt);
          stringBuilder.append(" and _tp");
          stringBuilder.append(" = \"");
          stringBuilder.append(str);
          stringBuilder.append("\"");
          str = stringBuilder.toString();
        } 
        paramInt = sQLiteDatabase.delete("t_pf", str, null);
        x.c("[Database] deleted %s data %d", new Object[] { "t_pf", Integer.valueOf(paramInt) });
        bool = bool1;
        if (paramInt > 0)
          bool = true; 
      } 
      bool1 = bool;
    } finally {
      paramString = null;
    } 
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
    return bool1;
  }
  
  private boolean a(int paramInt, String paramString, byte[] paramArrayOfbyte, o paramo) {
    boolean bool = false;
    boolean bool1 = false;
    try {
      r r = new r();
      r.a = paramInt;
      r.f = paramString;
      r.e = System.currentTimeMillis();
      r.g = paramArrayOfbyte;
      boolean bool2 = b(r);
      bool = bool2;
    } finally {
      paramString = null;
    } 
    return bool;
  }
  
  private static r b(Cursor paramCursor) {
    if (paramCursor == null)
      return null; 
    try {
      r r = new r();
      r.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      r.e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
      return r;
    } finally {
      paramCursor = null;
      if (!x.a((Throwable)paramCursor))
        paramCursor.printStackTrace(); 
    } 
  }
  
  private boolean b(r paramr) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: iconst_0
    //   9: ireturn
    //   10: getstatic com/tencent/bugly/proguard/p.b : Lcom/tencent/bugly/proguard/q;
    //   13: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore #4
    //   18: aload #4
    //   20: ifnull -> 80
    //   23: aload_1
    //   24: invokestatic d : (Lcom/tencent/bugly/proguard/r;)Landroid/content/ContentValues;
    //   27: astore #5
    //   29: aload #5
    //   31: ifnull -> 80
    //   34: aload #4
    //   36: ldc 't_pf'
    //   38: ldc '_id'
    //   40: aload #5
    //   42: invokevirtual replace : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   45: lstore_2
    //   46: lload_2
    //   47: lconst_0
    //   48: lcmp
    //   49: iflt -> 76
    //   52: ldc '[Database] insert %s success.'
    //   54: iconst_1
    //   55: anewarray java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: ldc 't_pf'
    //   62: aastore
    //   63: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   66: pop
    //   67: aload_1
    //   68: lload_2
    //   69: putfield a : J
    //   72: aload_0
    //   73: monitorexit
    //   74: iconst_1
    //   75: ireturn
    //   76: aload_0
    //   77: monitorexit
    //   78: iconst_0
    //   79: ireturn
    //   80: aload_0
    //   81: monitorexit
    //   82: iconst_0
    //   83: ireturn
    //   84: astore_1
    //   85: aload_1
    //   86: invokestatic a : (Ljava/lang/Throwable;)Z
    //   89: ifne -> 96
    //   92: aload_1
    //   93: invokevirtual printStackTrace : ()V
    //   96: aload_0
    //   97: monitorexit
    //   98: iconst_0
    //   99: ireturn
    //   100: astore_1
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Exception table:
    //   from	to	target	type
    //   10	18	84	finally
    //   23	29	84	finally
    //   34	46	84	finally
    //   52	72	84	finally
    //   85	96	100	finally
    //   101	103	103	finally
  }
  
  private static ContentValues c(r paramr) {
    if (paramr == null)
      return null; 
    try {
      ContentValues contentValues = new ContentValues();
      if (paramr.a > 0L)
        contentValues.put("_id", Long.valueOf(paramr.a)); 
      contentValues.put("_tp", Integer.valueOf(paramr.b));
      contentValues.put("_pc", paramr.c);
      contentValues.put("_th", paramr.d);
      return contentValues;
    } finally {
      paramr = null;
      if (!x.a((Throwable)paramr))
        paramr.printStackTrace(); 
    } 
  }
  
  private List<r> c(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/tencent/bugly/proguard/p.b : Lcom/tencent/bugly/proguard/q;
    //   5: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull -> 288
    //   13: new java/lang/StringBuilder
    //   16: dup
    //   17: ldc '_id = '
    //   19: invokespecial <init> : (Ljava/lang/String;)V
    //   22: astore_2
    //   23: aload_2
    //   24: iload_1
    //   25: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: invokevirtual toString : ()Ljava/lang/String;
    //   33: astore #4
    //   35: aload_3
    //   36: ldc 't_pf'
    //   38: aconst_null
    //   39: aload #4
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnonnull -> 67
    //   53: aload_2
    //   54: ifnull -> 63
    //   57: aload_2
    //   58: invokeinterface close : ()V
    //   63: aload_0
    //   64: monitorexit
    //   65: aconst_null
    //   66: areturn
    //   67: new java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial <init> : ()V
    //   74: astore #5
    //   76: new java/util/ArrayList
    //   79: dup
    //   80: invokespecial <init> : ()V
    //   83: astore #6
    //   85: aload_2
    //   86: invokeinterface moveToNext : ()Z
    //   91: ifeq -> 177
    //   94: aload_2
    //   95: invokestatic b : (Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/r;
    //   98: astore #7
    //   100: aload #7
    //   102: ifnull -> 118
    //   105: aload #6
    //   107: aload #7
    //   109: invokeinterface add : (Ljava/lang/Object;)Z
    //   114: pop
    //   115: goto -> 85
    //   118: aload_2
    //   119: aload_2
    //   120: ldc '_tp'
    //   122: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   127: invokeinterface getString : (I)Ljava/lang/String;
    //   132: astore #7
    //   134: aload #5
    //   136: ldc_w ' or _tp'
    //   139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload #5
    //   145: ldc_w ' = '
    //   148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload #5
    //   154: aload #7
    //   156: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: goto -> 85
    //   163: ldc_w '[Database] unknown id.'
    //   166: iconst_0
    //   167: anewarray java/lang/Object
    //   170: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   173: pop
    //   174: goto -> 85
    //   177: aload #5
    //   179: invokevirtual length : ()I
    //   182: ifle -> 245
    //   185: aload #5
    //   187: ldc_w ' and _id'
    //   190: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload #5
    //   196: ldc_w ' = '
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload #5
    //   205: iload_1
    //   206: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: ldc_w '[Database] deleted %s illegal data %d.'
    //   213: iconst_2
    //   214: anewarray java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: ldc 't_pf'
    //   221: aastore
    //   222: dup
    //   223: iconst_1
    //   224: aload_3
    //   225: ldc 't_pf'
    //   227: aload #4
    //   229: iconst_4
    //   230: invokevirtual substring : (I)Ljava/lang/String;
    //   233: aconst_null
    //   234: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   237: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   240: aastore
    //   241: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   244: pop
    //   245: aload_2
    //   246: ifnull -> 255
    //   249: aload_2
    //   250: invokeinterface close : ()V
    //   255: aload_0
    //   256: monitorexit
    //   257: aload #6
    //   259: areturn
    //   260: astore_3
    //   261: goto -> 267
    //   264: astore_3
    //   265: aconst_null
    //   266: astore_2
    //   267: aload_3
    //   268: invokestatic a : (Ljava/lang/Throwable;)Z
    //   271: ifne -> 278
    //   274: aload_3
    //   275: invokevirtual printStackTrace : ()V
    //   278: aload_2
    //   279: ifnull -> 288
    //   282: aload_2
    //   283: invokeinterface close : ()V
    //   288: aload_0
    //   289: monitorexit
    //   290: aconst_null
    //   291: areturn
    //   292: astore_3
    //   293: aload_2
    //   294: ifnull -> 303
    //   297: aload_2
    //   298: invokeinterface close : ()V
    //   303: aload_3
    //   304: athrow
    //   305: astore_2
    //   306: aload_0
    //   307: monitorexit
    //   308: aload_2
    //   309: athrow
    //   310: astore #7
    //   312: goto -> 163
    // Exception table:
    //   from	to	target	type
    //   2	9	264	finally
    //   13	49	264	finally
    //   57	63	305	finally
    //   67	85	260	finally
    //   85	100	260	finally
    //   105	115	260	finally
    //   118	160	310	finally
    //   163	174	260	finally
    //   177	245	260	finally
    //   249	255	305	finally
    //   267	278	292	finally
    //   282	288	305	finally
    //   297	303	305	finally
    //   303	305	305	finally
  }
  
  private static ContentValues d(r paramr) {
    if (paramr != null) {
      if (z.a(paramr.f))
        return null; 
      try {
        ContentValues contentValues = new ContentValues();
        if (paramr.a > 0L)
          contentValues.put("_id", Long.valueOf(paramr.a)); 
        contentValues.put("_tp", paramr.f);
        contentValues.put("_tm", Long.valueOf(paramr.e));
        return contentValues;
      } finally {
        paramr = null;
      } 
    } 
    return null;
  }
  
  public final int a(String paramString1, String paramString2, String[] paramArrayOfString, o paramo, boolean paramBoolean) {
    return a(paramString1, paramString2, (String[])null, (o)null);
  }
  
  public final long a(String paramString, ContentValues paramContentValues, o paramo, boolean paramBoolean) {
    return a(paramString, paramContentValues, (o)null);
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, o paramo, boolean paramBoolean) {
    return a(false, paramString1, paramArrayOfString1, paramString2, null, null, null, null, null, null);
  }
  
  public final List<r> a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/tencent/bugly/proguard/p.b : Lcom/tencent/bugly/proguard/q;
    //   5: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore #5
    //   10: aload #5
    //   12: ifnull -> 315
    //   15: iload_1
    //   16: iflt -> 339
    //   19: new java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w '_tp = '
    //   26: invokespecial <init> : (Ljava/lang/String;)V
    //   29: astore #4
    //   31: aload #4
    //   33: iload_1
    //   34: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload #4
    //   40: invokevirtual toString : ()Ljava/lang/String;
    //   43: astore #4
    //   45: goto -> 48
    //   48: aload #5
    //   50: ldc_w 't_lr'
    //   53: aconst_null
    //   54: aload #4
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore #4
    //   65: aload #4
    //   67: ifnonnull -> 86
    //   70: aload #4
    //   72: ifnull -> 82
    //   75: aload #4
    //   77: invokeinterface close : ()V
    //   82: aload_0
    //   83: monitorexit
    //   84: aconst_null
    //   85: areturn
    //   86: new java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial <init> : ()V
    //   93: astore #7
    //   95: new java/util/ArrayList
    //   98: dup
    //   99: invokespecial <init> : ()V
    //   102: astore #6
    //   104: aload #4
    //   106: invokeinterface moveToNext : ()Z
    //   111: ifeq -> 198
    //   114: aload #4
    //   116: invokestatic a : (Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/r;
    //   119: astore #8
    //   121: aload #8
    //   123: ifnull -> 139
    //   126: aload #6
    //   128: aload #8
    //   130: invokeinterface add : (Ljava/lang/Object;)Z
    //   135: pop
    //   136: goto -> 104
    //   139: aload #4
    //   141: aload #4
    //   143: ldc '_id'
    //   145: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   150: invokeinterface getLong : (I)J
    //   155: lstore_2
    //   156: aload #7
    //   158: ldc_w ' or _id'
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload #7
    //   167: ldc_w ' = '
    //   170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload #7
    //   176: lload_2
    //   177: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: goto -> 104
    //   184: ldc_w '[Database] unknown id.'
    //   187: iconst_0
    //   188: anewarray java/lang/Object
    //   191: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   194: pop
    //   195: goto -> 104
    //   198: aload #7
    //   200: invokevirtual toString : ()Ljava/lang/String;
    //   203: astore #7
    //   205: aload #7
    //   207: invokevirtual length : ()I
    //   210: ifle -> 251
    //   213: ldc_w '[Database] deleted %s illegal data %d'
    //   216: iconst_2
    //   217: anewarray java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: ldc_w 't_lr'
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: aload #5
    //   230: ldc_w 't_lr'
    //   233: aload #7
    //   235: iconst_4
    //   236: invokevirtual substring : (I)Ljava/lang/String;
    //   239: aconst_null
    //   240: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   243: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   246: aastore
    //   247: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   250: pop
    //   251: aload #4
    //   253: ifnull -> 263
    //   256: aload #4
    //   258: invokeinterface close : ()V
    //   263: aload_0
    //   264: monitorexit
    //   265: aload #6
    //   267: areturn
    //   268: astore #5
    //   270: aload #5
    //   272: invokestatic a : (Ljava/lang/Throwable;)Z
    //   275: ifne -> 283
    //   278: aload #5
    //   280: invokevirtual printStackTrace : ()V
    //   283: aload #4
    //   285: ifnull -> 315
    //   288: aload #4
    //   290: invokeinterface close : ()V
    //   295: goto -> 315
    //   298: astore #5
    //   300: aload #4
    //   302: ifnull -> 312
    //   305: aload #4
    //   307: invokeinterface close : ()V
    //   312: aload #5
    //   314: athrow
    //   315: aload_0
    //   316: monitorexit
    //   317: aconst_null
    //   318: areturn
    //   319: astore #4
    //   321: aload_0
    //   322: monitorexit
    //   323: aload #4
    //   325: athrow
    //   326: astore #8
    //   328: goto -> 184
    //   331: astore #5
    //   333: aconst_null
    //   334: astore #4
    //   336: goto -> 270
    //   339: aconst_null
    //   340: astore #4
    //   342: goto -> 48
    // Exception table:
    //   from	to	target	type
    //   2	10	319	finally
    //   19	45	331	finally
    //   48	65	331	finally
    //   75	82	319	finally
    //   86	104	268	finally
    //   104	121	268	finally
    //   126	136	268	finally
    //   139	181	326	finally
    //   184	195	268	finally
    //   198	251	268	finally
    //   256	263	319	finally
    //   270	283	298	finally
    //   288	295	319	finally
    //   305	312	319	finally
    //   312	315	319	finally
  }
  
  public final Map<String, byte[]> a(int paramInt, o paramo, boolean paramBoolean) {
    return a(paramInt, (o)null);
  }
  
  public final void a(List<r> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 182
    //   6: aload_1
    //   7: invokeinterface size : ()I
    //   12: ifne -> 18
    //   15: goto -> 182
    //   18: getstatic com/tencent/bugly/proguard/p.b : Lcom/tencent/bugly/proguard/q;
    //   21: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull -> 174
    //   29: new java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: astore #4
    //   38: aload_1
    //   39: invokeinterface iterator : ()Ljava/util/Iterator;
    //   44: astore_1
    //   45: aload_1
    //   46: invokeinterface hasNext : ()Z
    //   51: ifeq -> 95
    //   54: aload_1
    //   55: invokeinterface next : ()Ljava/lang/Object;
    //   60: checkcast com/tencent/bugly/proguard/r
    //   63: astore_2
    //   64: aload #4
    //   66: ldc_w ' or _id'
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #4
    //   75: ldc_w ' = '
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload #4
    //   84: aload_2
    //   85: getfield a : J
    //   88: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: goto -> 45
    //   95: aload #4
    //   97: invokevirtual toString : ()Ljava/lang/String;
    //   100: astore_2
    //   101: aload_2
    //   102: astore_1
    //   103: aload_2
    //   104: invokevirtual length : ()I
    //   107: ifle -> 116
    //   110: aload_2
    //   111: iconst_4
    //   112: invokevirtual substring : (I)Ljava/lang/String;
    //   115: astore_1
    //   116: aload #4
    //   118: iconst_0
    //   119: invokevirtual setLength : (I)V
    //   122: ldc '[Database] deleted %s data %d'
    //   124: iconst_2
    //   125: anewarray java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: ldc_w 't_lr'
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: aload_3
    //   137: ldc_w 't_lr'
    //   140: aload_1
    //   141: aconst_null
    //   142: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   145: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   148: aastore
    //   149: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   152: pop
    //   153: aload_0
    //   154: monitorexit
    //   155: return
    //   156: astore_1
    //   157: aload_1
    //   158: invokestatic a : (Ljava/lang/Throwable;)Z
    //   161: ifne -> 168
    //   164: aload_1
    //   165: invokevirtual printStackTrace : ()V
    //   168: aload_0
    //   169: monitorexit
    //   170: return
    //   171: astore_1
    //   172: aload_1
    //   173: athrow
    //   174: aload_0
    //   175: monitorexit
    //   176: return
    //   177: astore_1
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    //   182: aload_0
    //   183: monitorexit
    //   184: return
    // Exception table:
    //   from	to	target	type
    //   6	15	177	finally
    //   18	25	177	finally
    //   29	45	177	finally
    //   45	92	177	finally
    //   95	101	177	finally
    //   103	116	177	finally
    //   116	122	177	finally
    //   122	153	156	finally
    //   157	168	171	finally
    //   172	174	177	finally
  }
  
  public final boolean a(int paramInt, String paramString, o paramo, boolean paramBoolean) {
    return a(555, paramString, (o)null);
  }
  
  public final boolean a(int paramInt, String paramString, byte[] paramArrayOfbyte, o paramo, boolean paramBoolean) {
    if (!paramBoolean) {
      a a = new a(this, 4, null);
      a.a(paramInt, paramString, paramArrayOfbyte);
      w.a().a(a);
      return true;
    } 
    return a(paramInt, paramString, paramArrayOfbyte, (o)null);
  }
  
  public final boolean a(r paramr) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: iconst_0
    //   9: ireturn
    //   10: getstatic com/tencent/bugly/proguard/p.b : Lcom/tencent/bugly/proguard/q;
    //   13: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore #4
    //   18: aload #4
    //   20: ifnull -> 82
    //   23: aload_1
    //   24: invokestatic c : (Lcom/tencent/bugly/proguard/r;)Landroid/content/ContentValues;
    //   27: astore #5
    //   29: aload #5
    //   31: ifnull -> 82
    //   34: aload #4
    //   36: ldc_w 't_lr'
    //   39: ldc '_id'
    //   41: aload #5
    //   43: invokevirtual replace : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   46: lstore_2
    //   47: lload_2
    //   48: lconst_0
    //   49: lcmp
    //   50: iflt -> 78
    //   53: ldc '[Database] insert %s success.'
    //   55: iconst_1
    //   56: anewarray java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: ldc_w 't_lr'
    //   64: aastore
    //   65: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   68: pop
    //   69: aload_1
    //   70: lload_2
    //   71: putfield a : J
    //   74: aload_0
    //   75: monitorexit
    //   76: iconst_1
    //   77: ireturn
    //   78: aload_0
    //   79: monitorexit
    //   80: iconst_0
    //   81: ireturn
    //   82: aload_0
    //   83: monitorexit
    //   84: iconst_0
    //   85: ireturn
    //   86: astore_1
    //   87: aload_1
    //   88: invokestatic a : (Ljava/lang/Throwable;)Z
    //   91: ifne -> 98
    //   94: aload_1
    //   95: invokevirtual printStackTrace : ()V
    //   98: aload_0
    //   99: monitorexit
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_1
    //   103: aload_1
    //   104: athrow
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Exception table:
    //   from	to	target	type
    //   10	18	86	finally
    //   23	29	86	finally
    //   34	47	86	finally
    //   53	74	86	finally
    //   87	98	102	finally
    //   103	105	105	finally
  }
  
  public final void b(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/tencent/bugly/proguard/p.b : Lcom/tencent/bugly/proguard/q;
    //   5: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull -> 93
    //   13: iload_1
    //   14: iflt -> 105
    //   17: new java/lang/StringBuilder
    //   20: dup
    //   21: ldc_w '_tp = '
    //   24: invokespecial <init> : (Ljava/lang/String;)V
    //   27: astore_2
    //   28: aload_2
    //   29: iload_1
    //   30: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_2
    //   35: invokevirtual toString : ()Ljava/lang/String;
    //   38: astore_2
    //   39: goto -> 42
    //   42: ldc '[Database] deleted %s data %d'
    //   44: iconst_2
    //   45: anewarray java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: ldc_w 't_lr'
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: aload_3
    //   57: ldc_w 't_lr'
    //   60: aload_2
    //   61: aconst_null
    //   62: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   65: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   68: aastore
    //   69: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   72: pop
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: aload_2
    //   77: invokestatic a : (Ljava/lang/Throwable;)Z
    //   80: ifne -> 87
    //   83: aload_2
    //   84: invokevirtual printStackTrace : ()V
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //   90: astore_2
    //   91: aload_2
    //   92: athrow
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: astore_2
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_2
    //   100: athrow
    //   101: astore_2
    //   102: goto -> 76
    //   105: aconst_null
    //   106: astore_2
    //   107: goto -> 42
    // Exception table:
    //   from	to	target	type
    //   2	9	96	finally
    //   17	39	101	finally
    //   42	73	101	finally
    //   76	87	90	finally
    //   91	93	96	finally
  }
  
  final class a extends Thread {
    private int a;
    
    private o b;
    
    private String c;
    
    private ContentValues d;
    
    private boolean e;
    
    private String[] f;
    
    private String g;
    
    private String[] h;
    
    private String i;
    
    private String j;
    
    private String k;
    
    private String l;
    
    private String m;
    
    private String[] n;
    
    private int o;
    
    private String p;
    
    private byte[] q;
    
    public a(p this$0, int param1Int, o param1o) {
      this.a = param1Int;
      this.b = param1o;
    }
    
    public final void a(int param1Int, String param1String, byte[] param1ArrayOfbyte) {
      this.o = param1Int;
      this.p = param1String;
      this.q = param1ArrayOfbyte;
    }
    
    public final void a(boolean param1Boolean, String param1String1, String[] param1ArrayOfString1, String param1String2, String[] param1ArrayOfString2, String param1String3, String param1String4, String param1String5, String param1String6) {
      this.e = param1Boolean;
      this.c = param1String1;
      this.f = param1ArrayOfString1;
      this.g = param1String2;
      this.h = param1ArrayOfString2;
      this.i = param1String3;
      this.j = param1String4;
      this.k = param1String5;
      this.l = param1String6;
    }
    
    public final void run() {
      Cursor cursor;
      switch (this.a) {
        default:
          return;
        case 6:
          p.a(this.r, this.o, this.p, this.b);
          return;
        case 5:
          p.a(this.r, this.o, this.b);
          return;
        case 4:
          p.a(this.r, this.o, this.p, this.q, this.b);
          return;
        case 3:
          cursor = p.a(this.r, this.e, this.c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
          if (cursor != null) {
            cursor.close();
            return;
          } 
          return;
        case 2:
          p.a(this.r, this.c, this.m, this.n, this.b);
          return;
        case 1:
          break;
      } 
      p.a(this.r, this.c, this.d, this.b);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */