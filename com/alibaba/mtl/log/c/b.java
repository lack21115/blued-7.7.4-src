package com.alibaba.mtl.log.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alibaba.mtl.log.e.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class b implements a {
  a a;
  
  String aa = "SELECT * FROM %s ORDER BY %s ASC LIMIT %s";
  
  String ab = "SELECT count(*) FROM %s";
  
  String ac = "DELETE FROM log where _id in ( select _id from log  ORDER BY _id ASC LIMIT %d )";
  
  protected b(Context paramContext) {
    this.a = new a(this, paramContext);
  }
  
  private void a(Cursor paramCursor) {
    if (paramCursor != null)
      try {
        return;
      } finally {
        paramCursor = null;
      }  
  }
  
  public int a(List<com.alibaba.mtl.log.model.a> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 342
    //   6: aload_1
    //   7: invokeinterface size : ()I
    //   12: ifne -> 18
    //   15: goto -> 342
    //   18: aload_0
    //   19: getfield a : Lcom/alibaba/mtl/log/c/b$a;
    //   22: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   25: astore #10
    //   27: aload #10
    //   29: ifnull -> 275
    //   32: aload #10
    //   34: invokevirtual beginTransaction : ()V
    //   37: iconst_0
    //   38: istore_3
    //   39: iconst_1
    //   40: istore #5
    //   42: iconst_0
    //   43: istore_2
    //   44: iload_3
    //   45: aload_1
    //   46: invokeinterface size : ()I
    //   51: if_icmpge -> 231
    //   54: new java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial <init> : ()V
    //   61: astore #11
    //   63: aload #11
    //   65: aload_1
    //   66: iload_3
    //   67: invokeinterface get : (I)Ljava/lang/Object;
    //   72: checkcast com/alibaba/mtl/log/model/a
    //   75: getfield id : I
    //   78: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload #11
    //   84: ldc ''
    //   86: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload #10
    //   92: ldc 'log'
    //   94: ldc '_id=?'
    //   96: iconst_1
    //   97: anewarray java/lang/String
    //   100: dup
    //   101: iconst_0
    //   102: aload #11
    //   104: invokevirtual toString : ()Ljava/lang/String;
    //   107: aastore
    //   108: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   111: i2l
    //   112: lstore #8
    //   114: lload #8
    //   116: lconst_0
    //   117: lcmp
    //   118: ifgt -> 176
    //   121: ldc 'UTSqliteLogStore'
    //   123: iconst_4
    //   124: anewarray java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: ldc '[delete]  '
    //   131: aastore
    //   132: dup
    //   133: iconst_1
    //   134: aload_1
    //   135: iload_3
    //   136: invokeinterface get : (I)Ljava/lang/Object;
    //   141: checkcast com/alibaba/mtl/log/model/a
    //   144: getfield id : I
    //   147: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   150: aastore
    //   151: dup
    //   152: iconst_2
    //   153: ldc ' ret:'
    //   155: aastore
    //   156: dup
    //   157: iconst_3
    //   158: lload #8
    //   160: invokestatic valueOf : (J)Ljava/lang/Long;
    //   163: aastore
    //   164: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: iconst_0
    //   168: istore #6
    //   170: iload_2
    //   171: istore #4
    //   173: goto -> 217
    //   176: ldc '6005'
    //   178: aload_1
    //   179: iload_3
    //   180: invokeinterface get : (I)Ljava/lang/Object;
    //   185: checkcast com/alibaba/mtl/log/model/a
    //   188: getfield T : Ljava/lang/String;
    //   191: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   194: istore #7
    //   196: iload #5
    //   198: istore #6
    //   200: iload_2
    //   201: istore #4
    //   203: iload #7
    //   205: ifne -> 217
    //   208: iload_2
    //   209: iconst_1
    //   210: iadd
    //   211: istore #4
    //   213: iload #5
    //   215: istore #6
    //   217: iload_3
    //   218: iconst_1
    //   219: iadd
    //   220: istore_3
    //   221: iload #6
    //   223: istore #5
    //   225: iload #4
    //   227: istore_2
    //   228: goto -> 44
    //   231: aload #10
    //   233: invokevirtual setTransactionSuccessful : ()V
    //   236: aload #10
    //   238: invokevirtual endTransaction : ()V
    //   241: aload_0
    //   242: getfield a : Lcom/alibaba/mtl/log/c/b$a;
    //   245: aload #10
    //   247: invokevirtual a : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   250: goto -> 294
    //   253: astore_1
    //   254: aload #10
    //   256: invokevirtual setTransactionSuccessful : ()V
    //   259: aload #10
    //   261: invokevirtual endTransaction : ()V
    //   264: aload_0
    //   265: getfield a : Lcom/alibaba/mtl/log/c/b$a;
    //   268: aload #10
    //   270: invokevirtual a : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   273: aload_1
    //   274: athrow
    //   275: ldc 'UTSqliteLogStore'
    //   277: iconst_1
    //   278: anewarray java/lang/Object
    //   281: dup
    //   282: iconst_0
    //   283: ldc 'db is null'
    //   285: aastore
    //   286: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: iconst_0
    //   290: istore #5
    //   292: iconst_0
    //   293: istore_2
    //   294: ldc 'UTSqliteLogStore'
    //   296: iconst_4
    //   297: anewarray java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: ldc 'delete '
    //   304: aastore
    //   305: dup
    //   306: iconst_1
    //   307: aload_1
    //   308: invokeinterface size : ()I
    //   313: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   316: aastore
    //   317: dup
    //   318: iconst_2
    //   319: ldc ' isSuccess:'
    //   321: aastore
    //   322: dup
    //   323: iconst_3
    //   324: iload #5
    //   326: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   329: aastore
    //   330: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   333: aload_0
    //   334: monitorexit
    //   335: iload_2
    //   336: ireturn
    //   337: astore_1
    //   338: aload_0
    //   339: monitorexit
    //   340: aload_1
    //   341: athrow
    //   342: aload_0
    //   343: monitorexit
    //   344: iconst_0
    //   345: ireturn
    //   346: astore #11
    //   348: goto -> 236
    //   351: astore #11
    //   353: goto -> 241
    //   356: astore #11
    //   358: goto -> 259
    //   361: astore #11
    //   363: goto -> 264
    // Exception table:
    //   from	to	target	type
    //   6	15	337	finally
    //   18	27	337	finally
    //   32	37	253	finally
    //   44	114	253	finally
    //   121	167	253	finally
    //   176	196	253	finally
    //   231	236	346	finally
    //   236	241	351	finally
    //   241	250	337	finally
    //   254	259	356	finally
    //   259	264	361	finally
    //   264	275	337	finally
    //   275	289	337	finally
    //   294	333	337	finally
  }
  
  public ArrayList<com.alibaba.mtl.log.model.a> a(String paramString, int paramInt) {
    ArrayList<com.alibaba.mtl.log.model.a> arrayList;
    /* monitor enter ThisExpression{ObjectType{com/alibaba/mtl/log/c/b}} */
    StringBuilder stringBuilder = null;
    if (paramInt <= 0) {
      try {
        arrayList = (ArrayList)Collections.EMPTY_LIST;
        return arrayList;
      } finally {
        paramString = null;
      } 
    } else {
      ArrayList<com.alibaba.mtl.log.model.a> arrayList1 = new ArrayList(paramInt);
      try {
        SQLiteDatabase sQLiteDatabase = this.a.getWritableDatabase();
      } finally {
        paramString = null;
      } 
    } 
    /* monitor exit ThisExpression{ObjectType{com/alibaba/mtl/log/c/b}} */
    return arrayList;
  }
  
  public boolean a(List<com.alibaba.mtl.log.model.a> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 369
    //   6: aload_1
    //   7: invokeinterface size : ()I
    //   12: istore_2
    //   13: iload_2
    //   14: ifne -> 20
    //   17: goto -> 369
    //   20: aconst_null
    //   21: astore #8
    //   23: iconst_0
    //   24: istore #4
    //   26: iconst_0
    //   27: istore_3
    //   28: aload_0
    //   29: getfield a : Lcom/alibaba/mtl/log/c/b$a;
    //   32: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   35: astore #7
    //   37: aload #7
    //   39: ifnull -> 242
    //   42: aload #7
    //   44: astore #8
    //   46: aload #7
    //   48: invokevirtual beginTransaction : ()V
    //   51: iconst_0
    //   52: istore_2
    //   53: iload_2
    //   54: aload_1
    //   55: invokeinterface size : ()I
    //   60: if_icmpge -> 231
    //   63: aload_1
    //   64: iload_2
    //   65: invokeinterface get : (I)Ljava/lang/Object;
    //   70: checkcast com/alibaba/mtl/log/model/a
    //   73: astore #8
    //   75: aload #8
    //   77: ifnull -> 224
    //   80: new android/content/ContentValues
    //   83: dup
    //   84: invokespecial <init> : ()V
    //   87: astore #9
    //   89: aload #9
    //   91: ldc 'eventId'
    //   93: aload #8
    //   95: getfield T : Ljava/lang/String;
    //   98: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload #9
    //   103: ldc 'priority'
    //   105: aload #8
    //   107: getfield U : Ljava/lang/String;
    //   110: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload #9
    //   115: ldc 'content'
    //   117: aload #8
    //   119: invokevirtual i : ()Ljava/lang/String;
    //   122: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload #9
    //   127: ldc 'time'
    //   129: aload #8
    //   131: getfield W : Ljava/lang/String;
    //   134: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload #9
    //   139: ldc '_index'
    //   141: aload #8
    //   143: getfield X : Ljava/lang/String;
    //   146: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload #7
    //   151: ldc 'log'
    //   153: ldc ''
    //   155: aload #9
    //   157: invokevirtual insert : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   160: lstore #5
    //   162: lload #5
    //   164: ldc2_w -1
    //   167: lcmp
    //   168: ifne -> 174
    //   171: goto -> 260
    //   174: ldc 'UTSqliteLogStore'
    //   176: bipush #6
    //   178: anewarray java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: ldc_w '[insert] '
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: aload #8
    //   191: getfield X : Ljava/lang/String;
    //   194: aastore
    //   195: dup
    //   196: iconst_2
    //   197: ldc ' isSuccess:'
    //   199: aastore
    //   200: dup
    //   201: iconst_3
    //   202: iconst_1
    //   203: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   206: aastore
    //   207: dup
    //   208: iconst_4
    //   209: ldc_w 'ret'
    //   212: aastore
    //   213: dup
    //   214: iconst_5
    //   215: lload #5
    //   217: invokestatic valueOf : (J)Ljava/lang/Long;
    //   220: aastore
    //   221: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: iload_2
    //   225: iconst_1
    //   226: iadd
    //   227: istore_2
    //   228: goto -> 53
    //   231: iconst_1
    //   232: istore_3
    //   233: goto -> 260
    //   236: astore_1
    //   237: iconst_1
    //   238: istore_3
    //   239: goto -> 297
    //   242: aload #7
    //   244: astore #8
    //   246: ldc 'UTSqliteLogStore'
    //   248: iconst_1
    //   249: anewarray java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: ldc 'db is null'
    //   256: aastore
    //   257: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload #7
    //   262: ifnull -> 275
    //   265: aload #7
    //   267: invokevirtual setTransactionSuccessful : ()V
    //   270: aload #7
    //   272: invokevirtual endTransaction : ()V
    //   275: aload_0
    //   276: getfield a : Lcom/alibaba/mtl/log/c/b$a;
    //   279: astore_1
    //   280: aload_1
    //   281: aload #7
    //   283: invokevirtual a : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   286: goto -> 333
    //   289: astore_1
    //   290: iload #4
    //   292: istore_3
    //   293: aload #8
    //   295: astore #7
    //   297: ldc 'UTSqliteLogStore'
    //   299: ldc_w 'insert error'
    //   302: aload_1
    //   303: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   306: aload_1
    //   307: invokestatic a : (Ljava/lang/Throwable;)V
    //   310: aload #7
    //   312: ifnull -> 325
    //   315: aload #7
    //   317: invokevirtual setTransactionSuccessful : ()V
    //   320: aload #7
    //   322: invokevirtual endTransaction : ()V
    //   325: aload_0
    //   326: getfield a : Lcom/alibaba/mtl/log/c/b$a;
    //   329: astore_1
    //   330: goto -> 280
    //   333: aload_0
    //   334: monitorexit
    //   335: iload_3
    //   336: ireturn
    //   337: astore_1
    //   338: aload #7
    //   340: ifnull -> 353
    //   343: aload #7
    //   345: invokevirtual setTransactionSuccessful : ()V
    //   348: aload #7
    //   350: invokevirtual endTransaction : ()V
    //   353: aload_0
    //   354: getfield a : Lcom/alibaba/mtl/log/c/b$a;
    //   357: aload #7
    //   359: invokevirtual a : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   362: aload_1
    //   363: athrow
    //   364: astore_1
    //   365: aload_0
    //   366: monitorexit
    //   367: aload_1
    //   368: athrow
    //   369: aload_0
    //   370: monitorexit
    //   371: iconst_1
    //   372: ireturn
    //   373: astore_1
    //   374: goto -> 270
    //   377: astore_1
    //   378: goto -> 275
    //   381: astore_1
    //   382: goto -> 320
    //   385: astore_1
    //   386: goto -> 325
    //   389: astore #8
    //   391: goto -> 348
    //   394: astore #8
    //   396: goto -> 353
    // Exception table:
    //   from	to	target	type
    //   6	13	364	finally
    //   28	37	289	finally
    //   46	51	289	finally
    //   53	75	236	finally
    //   80	162	236	finally
    //   174	224	236	finally
    //   246	260	289	finally
    //   265	270	373	finally
    //   270	275	377	finally
    //   275	280	364	finally
    //   280	286	364	finally
    //   297	310	337	finally
    //   315	320	381	finally
    //   320	325	385	finally
    //   325	330	364	finally
    //   343	348	389	finally
    //   348	353	394	finally
    //   353	364	364	finally
  }
  
  public void c(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/alibaba/mtl/log/c/b$a;
    //   6: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull -> 83
    //   14: new java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore #4
    //   23: aload #4
    //   25: aload_1
    //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload #4
    //   32: ldc_w ' < ?'
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_3
    //   40: ldc 'log'
    //   42: aload #4
    //   44: invokevirtual toString : ()Ljava/lang/String;
    //   47: iconst_1
    //   48: anewarray java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: aload_2
    //   54: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   57: aastore
    //   58: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   61: pop
    //   62: aload_0
    //   63: getfield a : Lcom/alibaba/mtl/log/c/b$a;
    //   66: astore_1
    //   67: aload_1
    //   68: aload_3
    //   69: invokevirtual a : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   72: goto -> 97
    //   75: aload_0
    //   76: getfield a : Lcom/alibaba/mtl/log/c/b$a;
    //   79: astore_1
    //   80: goto -> 67
    //   83: ldc 'UTSqliteLogStore'
    //   85: iconst_1
    //   86: anewarray java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: ldc 'db is null'
    //   93: aastore
    //   94: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    //   105: astore_1
    //   106: goto -> 75
    // Exception table:
    //   from	to	target	type
    //   2	10	100	finally
    //   14	62	105	finally
    //   62	67	100	finally
    //   67	72	100	finally
    //   75	80	100	finally
    //   83	97	100	finally
  }
  
  public void clear() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/alibaba/mtl/log/c/b$a;
    //   6: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull -> 31
    //   14: aload_1
    //   15: ldc 'log'
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   22: pop
    //   23: aload_0
    //   24: getfield a : Lcom/alibaba/mtl/log/c/b$a;
    //   27: aload_1
    //   28: invokevirtual a : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	34	finally
    //   14	31	34	finally
  }
  
  public void e(int paramInt) {
    if (paramInt <= 0)
      return; 
    SQLiteDatabase sQLiteDatabase = this.a.getWritableDatabase();
    if (sQLiteDatabase != null) {
      try {
        sQLiteDatabase.execSQL(String.format(this.ac, new Object[] { Integer.valueOf(paramInt) }));
      } finally {
        Exception exception;
      } 
      this.a.a(sQLiteDatabase);
      return;
    } 
    i.a("UTSqliteLogStore", new Object[] { "db is null" });
  }
  
  public int g() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/alibaba/mtl/log/c/b$a;
    //   6: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore #6
    //   11: iconst_0
    //   12: istore_2
    //   13: iconst_0
    //   14: istore_3
    //   15: iconst_0
    //   16: istore_1
    //   17: aload #6
    //   19: ifnull -> 118
    //   22: aconst_null
    //   23: astore #4
    //   25: aload #6
    //   27: aload_0
    //   28: getfield ab : Ljava/lang/String;
    //   31: iconst_1
    //   32: anewarray java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: ldc 'log'
    //   39: aastore
    //   40: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   43: aconst_null
    //   44: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore #5
    //   49: aload #5
    //   51: ifnull -> 79
    //   54: aload #5
    //   56: astore #4
    //   58: aload #5
    //   60: invokeinterface moveToFirst : ()Z
    //   65: pop
    //   66: aload #5
    //   68: astore #4
    //   70: aload #5
    //   72: iconst_0
    //   73: invokeinterface getInt : (I)I
    //   78: istore_1
    //   79: aload_0
    //   80: aload #5
    //   82: invokespecial a : (Landroid/database/Cursor;)V
    //   85: aload_0
    //   86: getfield a : Lcom/alibaba/mtl/log/c/b$a;
    //   89: astore #4
    //   91: aload #4
    //   93: aload #6
    //   95: invokevirtual a : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   98: goto -> 134
    //   101: aload_0
    //   102: aload #4
    //   104: invokespecial a : (Landroid/database/Cursor;)V
    //   107: aload_0
    //   108: getfield a : Lcom/alibaba/mtl/log/c/b$a;
    //   111: astore #4
    //   113: iload_2
    //   114: istore_1
    //   115: goto -> 91
    //   118: ldc 'UTSqliteLogStore'
    //   120: iconst_1
    //   121: anewarray java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: ldc 'db is null'
    //   128: aastore
    //   129: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: iload_3
    //   133: istore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: iload_1
    //   137: ireturn
    //   138: astore #4
    //   140: aload_0
    //   141: monitorexit
    //   142: aload #4
    //   144: athrow
    //   145: astore #5
    //   147: goto -> 101
    // Exception table:
    //   from	to	target	type
    //   2	11	138	finally
    //   25	49	145	finally
    //   58	66	145	finally
    //   70	79	145	finally
    //   79	91	138	finally
    //   91	98	138	finally
    //   101	113	138	finally
    //   118	132	138	finally
  }
  
  class a extends SQLiteOpenHelper {
    private SQLiteDatabase a;
    
    private AtomicInteger e = new AtomicInteger();
    
    a(b this$0, Context param1Context) {
      super(param1Context, "ut.db", null, 2);
    }
    
    public void a(SQLiteDatabase param1SQLiteDatabase) {
      /* monitor enter ThisExpression{InnerObjectType{ObjectType{com/alibaba/mtl/log/c/b}.Lcom/alibaba/mtl/log/c/b$a;}} */
      if (param1SQLiteDatabase == null) {
        /* monitor exit ThisExpression{InnerObjectType{ObjectType{com/alibaba/mtl/log/c/b}.Lcom/alibaba/mtl/log/c/b$a;}} */
        return;
      } 
      try {
        if (this.e.decrementAndGet() == 0 && this.a != null) {
          this.a.close();
          this.a = null;
        } 
      } finally {}
      /* monitor exit ThisExpression{InnerObjectType{ObjectType{com/alibaba/mtl/log/c/b}.Lcom/alibaba/mtl/log/c/b$a;}} */
    }
    
    public SQLiteDatabase getWritableDatabase() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield e : Ljava/util/concurrent/atomic/AtomicInteger;
      //   6: invokevirtual incrementAndGet : ()I
      //   9: iconst_1
      //   10: if_icmpne -> 37
      //   13: aload_0
      //   14: aload_0
      //   15: invokespecial getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
      //   18: putfield a : Landroid/database/sqlite/SQLiteDatabase;
      //   21: goto -> 37
      //   24: astore_1
      //   25: ldc 'TAG'
      //   27: ldc 'e'
      //   29: aload_1
      //   30: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
      //   33: aload_1
      //   34: invokestatic a : (Ljava/lang/Throwable;)V
      //   37: aload_0
      //   38: getfield a : Landroid/database/sqlite/SQLiteDatabase;
      //   41: astore_1
      //   42: aload_0
      //   43: monitorexit
      //   44: aload_1
      //   45: areturn
      //   46: astore_1
      //   47: aload_0
      //   48: monitorexit
      //   49: aload_1
      //   50: athrow
      // Exception table:
      //   from	to	target	type
      //   2	21	24	finally
      //   25	37	46	finally
      //   37	42	46	finally
    }
    
    public void onCreate(SQLiteDatabase param1SQLiteDatabase) {
      param1SQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS log (_id INTEGER PRIMARY KEY AUTOINCREMENT, eventId TEXT,priority TEXT, streamId TEXT, time TEXT, content TEXT, _index TEXT )");
    }
    
    public void onOpen(SQLiteDatabase param1SQLiteDatabase) {
      Cursor cursor = null;
      try {
        Cursor cursor1 = param1SQLiteDatabase.rawQuery("PRAGMA journal_mode=DELETE", null);
        cursor = cursor1;
      } finally {
        Exception exception;
      } 
      b.a(this.a, cursor);
      super.onOpen(param1SQLiteDatabase);
    }
    
    public void onUpgrade(SQLiteDatabase param1SQLiteDatabase, int param1Int1, int param1Int2) {
      if (param1Int1 == 1 && param1Int2 == 2)
        try {
          return;
        } finally {
          param1SQLiteDatabase = null;
        }  
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */