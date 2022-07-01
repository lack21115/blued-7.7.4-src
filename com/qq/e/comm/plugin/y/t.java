package com.qq.e.comm.plugin.y;

import android.database.sqlite.SQLiteDatabase;
import com.qq.e.comm.plugin.util.ak;
import java.util.List;
import java.util.Set;

class t<DataType extends n> {
  private final String a;
  
  private final String b;
  
  private final String c;
  
  private int d = 0;
  
  private i e;
  
  private a<DataType> f;
  
  t(String paramString, a<DataType> parama) {
    this.a = paramString;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("create table ");
    stringBuilder.append(paramString);
    stringBuilder.append("(id integer primary key autoincrement,content text not null,ts long not null)");
    this.b = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("id not in (select id from ");
    stringBuilder.append(paramString);
    stringBuilder.append(" order by ts desc limit ");
    stringBuilder.append(1000);
    stringBuilder.append(")");
    this.c = stringBuilder.toString();
    this.f = parama;
  }
  
  List<DataType> a() {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #6
    //   9: aconst_null
    //   10: astore #4
    //   12: aconst_null
    //   13: astore_2
    //   14: aload_0
    //   15: getfield e : Lcom/qq/e/comm/plugin/y/i;
    //   18: invokevirtual getReadableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore_3
    //   22: aload_3
    //   23: aload_0
    //   24: getfield a : Ljava/lang/String;
    //   27: iconst_2
    //   28: anewarray java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc 'id'
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc 'content'
    //   40: aastore
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: ldc 'ts'
    //   47: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore #4
    //   52: aload #4
    //   54: ifnull -> 168
    //   57: aload #4
    //   59: astore_2
    //   60: aload #4
    //   62: invokeinterface getCount : ()I
    //   67: ifgt -> 73
    //   70: goto -> 168
    //   73: aload #4
    //   75: astore_2
    //   76: aload #4
    //   78: invokeinterface moveToNext : ()Z
    //   83: ifeq -> 219
    //   86: aload #4
    //   88: astore_2
    //   89: aload #4
    //   91: aload #4
    //   93: ldc 'id'
    //   95: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   100: invokeinterface getInt : (I)I
    //   105: istore_1
    //   106: aload #4
    //   108: astore_2
    //   109: aload #4
    //   111: aload #4
    //   113: ldc 'content'
    //   115: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   120: invokeinterface getString : (I)Ljava/lang/String;
    //   125: astore #5
    //   127: aload #4
    //   129: astore_2
    //   130: aload_0
    //   131: getfield f : Lcom/qq/e/comm/plugin/y/t$a;
    //   134: iload_1
    //   135: aload #5
    //   137: invokeinterface b : (ILjava/lang/String;)Ljava/lang/Object;
    //   142: checkcast com/qq/e/comm/plugin/y/n
    //   145: astore #5
    //   147: aload #5
    //   149: ifnull -> 73
    //   152: aload #4
    //   154: astore_2
    //   155: aload #6
    //   157: aload #5
    //   159: invokeinterface add : (Ljava/lang/Object;)Z
    //   164: pop
    //   165: goto -> 73
    //   168: aload #4
    //   170: astore_2
    //   171: new java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial <init> : ()V
    //   178: astore #5
    //   180: aload #4
    //   182: astore_2
    //   183: aload #5
    //   185: ldc 'Read stat 0 from table: '
    //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload #4
    //   193: astore_2
    //   194: aload #5
    //   196: aload_0
    //   197: getfield a : Ljava/lang/String;
    //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload #4
    //   206: astore_2
    //   207: aload #5
    //   209: invokevirtual toString : ()Ljava/lang/String;
    //   212: iconst_0
    //   213: anewarray java/lang/Object
    //   216: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: aload #4
    //   221: ifnull -> 231
    //   224: aload #4
    //   226: invokeinterface close : ()V
    //   231: aload_3
    //   232: ifnull -> 284
    //   235: aload_3
    //   236: astore_2
    //   237: aload_2
    //   238: invokevirtual close : ()V
    //   241: goto -> 284
    //   244: astore #5
    //   246: aload_2
    //   247: astore #4
    //   249: aload_3
    //   250: astore_2
    //   251: goto -> 258
    //   254: astore #5
    //   256: aconst_null
    //   257: astore_2
    //   258: ldc 'Read stat db failed'
    //   260: aload #5
    //   262: invokestatic e : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   265: aload #4
    //   267: ifnull -> 277
    //   270: aload #4
    //   272: invokeinterface close : ()V
    //   277: aload_2
    //   278: ifnull -> 284
    //   281: goto -> 237
    //   284: new java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial <init> : ()V
    //   291: astore_2
    //   292: aload_2
    //   293: ldc 'Read stat data: '
    //   295: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload_2
    //   300: aload #6
    //   302: invokeinterface size : ()I
    //   307: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_2
    //   312: ldc ' from table: '
    //   314: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_2
    //   319: aload_0
    //   320: getfield a : Ljava/lang/String;
    //   323: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload_2
    //   328: invokevirtual toString : ()Ljava/lang/String;
    //   331: iconst_0
    //   332: anewarray java/lang/Object
    //   335: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: aload #6
    //   340: areturn
    //   341: astore_3
    //   342: aload #4
    //   344: ifnull -> 354
    //   347: aload #4
    //   349: invokeinterface close : ()V
    //   354: aload_2
    //   355: ifnull -> 362
    //   358: aload_2
    //   359: invokevirtual close : ()V
    //   362: aload_3
    //   363: athrow
    //   364: astore_2
    //   365: goto -> 284
    //   368: astore_2
    //   369: goto -> 362
    // Exception table:
    //   from	to	target	type
    //   14	22	254	finally
    //   22	52	244	finally
    //   60	70	244	finally
    //   76	86	244	finally
    //   89	106	244	finally
    //   109	127	244	finally
    //   130	147	244	finally
    //   155	165	244	finally
    //   171	180	244	finally
    //   183	191	244	finally
    //   194	204	244	finally
    //   207	219	244	finally
    //   237	241	364	finally
    //   258	265	341	finally
    //   358	362	368	finally
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase) throws Throwable {
    paramSQLiteDatabase.execSQL(this.b);
    this.d = 0;
  }
  
  public void a(i parami) {
    this.e = parami;
    this.d = a().size();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Stat db init: total ");
    stringBuilder.append(this.a);
    stringBuilder.append(" count=");
    stringBuilder.append(this.d);
    ak.a(stringBuilder.toString(), new Object[0]);
  }
  
  void a(List<DataType> paramList) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 405
    //   4: aload_1
    //   5: invokeinterface size : ()I
    //   10: ifgt -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield e : Lcom/qq/e/comm/plugin/y/i;
    //   18: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore #4
    //   23: aload #4
    //   25: invokevirtual beginTransaction : ()V
    //   28: new java/lang/StringBuilder
    //   31: dup
    //   32: ldc 'insert into '
    //   34: invokespecial <init> : (Ljava/lang/String;)V
    //   37: astore #5
    //   39: aload #5
    //   41: aload_0
    //   42: getfield a : Ljava/lang/String;
    //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload #5
    //   51: ldc ' ('
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload #5
    //   59: ldc 'content'
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload #5
    //   67: ldc ', '
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #5
    //   75: ldc 'ts'
    //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload #5
    //   83: ldc ') '
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_1
    //   90: iconst_0
    //   91: invokeinterface get : (I)Ljava/lang/Object;
    //   96: checkcast com/qq/e/comm/plugin/y/n
    //   99: astore #6
    //   101: aload #5
    //   103: ldc 'select ''
    //   105: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload #5
    //   111: aload #6
    //   113: invokeinterface b : ()Ljava/lang/String;
    //   118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload #5
    //   124: ldc '', '
    //   126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload #5
    //   132: aload #6
    //   134: invokeinterface c : ()J
    //   139: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_1
    //   144: invokeinterface size : ()I
    //   149: istore_3
    //   150: iconst_1
    //   151: istore_2
    //   152: iload_2
    //   153: iload_3
    //   154: if_icmpge -> 218
    //   157: aload_1
    //   158: iload_2
    //   159: invokeinterface get : (I)Ljava/lang/Object;
    //   164: checkcast com/qq/e/comm/plugin/y/n
    //   167: astore #6
    //   169: aload #5
    //   171: ldc ' union all select ''
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload #5
    //   179: aload #6
    //   181: invokeinterface b : ()Ljava/lang/String;
    //   186: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload #5
    //   192: ldc '', '
    //   194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload #5
    //   200: aload #6
    //   202: invokeinterface c : ()J
    //   207: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: iload_2
    //   212: iconst_1
    //   213: iadd
    //   214: istore_2
    //   215: goto -> 152
    //   218: aload #4
    //   220: aload #5
    //   222: invokevirtual toString : ()Ljava/lang/String;
    //   225: invokevirtual execSQL : (Ljava/lang/String;)V
    //   228: aload #4
    //   230: aload_0
    //   231: getfield a : Ljava/lang/String;
    //   234: aload_0
    //   235: getfield c : Ljava/lang/String;
    //   238: aconst_null
    //   239: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   242: istore_2
    //   243: aload_1
    //   244: invokeinterface size : ()I
    //   249: istore_3
    //   250: new java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial <init> : ()V
    //   257: astore #5
    //   259: aload #5
    //   261: ldc 'Insert stat:'
    //   263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload #5
    //   269: aload_1
    //   270: invokeinterface size : ()I
    //   275: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload #5
    //   281: ldc ', delete stat: '
    //   283: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload #5
    //   289: iload_2
    //   290: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload #5
    //   296: ldc ' from table: '
    //   298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload #5
    //   304: aload_0
    //   305: getfield a : Ljava/lang/String;
    //   308: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload #5
    //   314: invokevirtual toString : ()Ljava/lang/String;
    //   317: iconst_0
    //   318: anewarray java/lang/Object
    //   321: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   324: aload #4
    //   326: invokevirtual setTransactionSuccessful : ()V
    //   329: aload_0
    //   330: aload_0
    //   331: getfield d : I
    //   334: iload_3
    //   335: iload_2
    //   336: isub
    //   337: iadd
    //   338: putfield d : I
    //   341: aload #4
    //   343: ifnull -> 405
    //   346: aload #4
    //   348: astore_1
    //   349: aload_1
    //   350: invokevirtual endTransaction : ()V
    //   353: aload_1
    //   354: invokevirtual close : ()V
    //   357: return
    //   358: astore #5
    //   360: aload #4
    //   362: astore_1
    //   363: aload #5
    //   365: astore #4
    //   367: goto -> 374
    //   370: astore #4
    //   372: aconst_null
    //   373: astore_1
    //   374: ldc 'Insert stat db failed'
    //   376: aload #4
    //   378: invokestatic e : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   381: aload_1
    //   382: ifnull -> 405
    //   385: goto -> 349
    //   388: astore #4
    //   390: aload_1
    //   391: ifnull -> 402
    //   394: aload_1
    //   395: invokevirtual endTransaction : ()V
    //   398: aload_1
    //   399: invokevirtual close : ()V
    //   402: aload #4
    //   404: athrow
    //   405: return
    //   406: astore_1
    //   407: return
    //   408: astore_1
    //   409: goto -> 402
    // Exception table:
    //   from	to	target	type
    //   14	23	370	finally
    //   23	150	358	finally
    //   157	211	358	finally
    //   218	341	358	finally
    //   349	357	406	finally
    //   374	381	388	finally
    //   394	402	408	finally
  }
  
  void a(Set<Integer> paramSet) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 246
    //   4: aload_1
    //   5: invokeinterface size : ()I
    //   10: ifne -> 14
    //   13: return
    //   14: aload_1
    //   15: invokeinterface iterator : ()Ljava/util/Iterator;
    //   20: astore_1
    //   21: new java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial <init> : ()V
    //   28: astore_3
    //   29: aload_3
    //   30: ldc '('
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_1
    //   37: invokeinterface hasNext : ()Z
    //   42: ifeq -> 56
    //   45: aload_3
    //   46: aload_1
    //   47: invokeinterface next : ()Ljava/lang/Object;
    //   52: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_1
    //   57: invokeinterface hasNext : ()Z
    //   62: ifeq -> 75
    //   65: aload_3
    //   66: ldc ','
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: goto -> 45
    //   75: aload_3
    //   76: ldc ')'
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_0
    //   83: getfield e : Lcom/qq/e/comm/plugin/y/i;
    //   86: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   89: astore_1
    //   90: aload_0
    //   91: getfield a : Ljava/lang/String;
    //   94: astore #4
    //   96: new java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial <init> : ()V
    //   103: astore #5
    //   105: aload #5
    //   107: ldc 'id in '
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload #5
    //   115: aload_3
    //   116: invokevirtual toString : ()Ljava/lang/String;
    //   119: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_1
    //   124: aload #4
    //   126: aload #5
    //   128: invokevirtual toString : ()Ljava/lang/String;
    //   131: aconst_null
    //   132: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   135: istore_2
    //   136: new java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial <init> : ()V
    //   143: astore_3
    //   144: aload_3
    //   145: ldc 'Delete stat count: '
    //   147: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_3
    //   152: iload_2
    //   153: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_3
    //   158: ldc ' from table: '
    //   160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_3
    //   165: aload_0
    //   166: getfield a : Ljava/lang/String;
    //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_3
    //   174: invokevirtual toString : ()Ljava/lang/String;
    //   177: iconst_0
    //   178: anewarray java/lang/Object
    //   181: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload_0
    //   185: aload_0
    //   186: getfield d : I
    //   189: iload_2
    //   190: isub
    //   191: putfield d : I
    //   194: aload_0
    //   195: getfield d : I
    //   198: ifge -> 206
    //   201: aload_0
    //   202: iconst_0
    //   203: putfield d : I
    //   206: aload_1
    //   207: ifnull -> 246
    //   210: aload_1
    //   211: invokevirtual close : ()V
    //   214: return
    //   215: astore_3
    //   216: goto -> 222
    //   219: astore_3
    //   220: aconst_null
    //   221: astore_1
    //   222: ldc 'Delete stat db failed'
    //   224: aload_3
    //   225: invokestatic e : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   228: aload_1
    //   229: ifnull -> 246
    //   232: goto -> 210
    //   235: astore_3
    //   236: aload_1
    //   237: ifnull -> 244
    //   240: aload_1
    //   241: invokevirtual close : ()V
    //   244: aload_3
    //   245: athrow
    //   246: return
    //   247: astore_1
    //   248: return
    //   249: astore_1
    //   250: goto -> 244
    // Exception table:
    //   from	to	target	type
    //   82	90	219	finally
    //   90	206	215	finally
    //   210	214	247	finally
    //   222	228	235	finally
    //   240	244	249	finally
  }
  
  public long b() {
    return this.d;
  }
  
  public void b(SQLiteDatabase paramSQLiteDatabase) throws Throwable {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("drop table if exists ");
    stringBuilder.append(this.a);
    paramSQLiteDatabase.execSQL(stringBuilder.toString());
    this.d = 0;
  }
  
  static interface a<DataType> {
    DataType b(int param1Int, String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\y\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */