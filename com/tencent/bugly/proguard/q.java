package com.tencent.bugly.proguard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.bugly.a;
import java.util.List;

public final class q extends SQLiteOpenHelper {
  public static String a = "bugly_db";
  
  private static int b = 15;
  
  private Context c;
  
  private List<a> d;
  
  public q(Context paramContext, List<a> paramList) {
    super(paramContext, stringBuilder.toString(), null, b);
    this.c = paramContext;
    this.d = paramList;
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_3
    //   3: anewarray java/lang/String
    //   6: astore #4
    //   8: aload #4
    //   10: iconst_0
    //   11: ldc 't_lr'
    //   13: aastore
    //   14: aload #4
    //   16: iconst_1
    //   17: ldc 't_ui'
    //   19: aastore
    //   20: aload #4
    //   22: iconst_2
    //   23: ldc 't_pf'
    //   25: aastore
    //   26: aload #4
    //   28: arraylength
    //   29: istore_3
    //   30: iconst_0
    //   31: istore_2
    //   32: iload_2
    //   33: iload_3
    //   34: if_icmpge -> 82
    //   37: aload #4
    //   39: iload_2
    //   40: aaload
    //   41: astore #5
    //   43: new java/lang/StringBuilder
    //   46: dup
    //   47: ldc 'DROP TABLE IF EXISTS '
    //   49: invokespecial <init> : (Ljava/lang/String;)V
    //   52: astore #6
    //   54: aload #6
    //   56: aload #5
    //   58: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_1
    //   63: aload #6
    //   65: invokevirtual toString : ()Ljava/lang/String;
    //   68: iconst_0
    //   69: anewarray java/lang/String
    //   72: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: iload_2
    //   76: iconst_1
    //   77: iadd
    //   78: istore_2
    //   79: goto -> 32
    //   82: aload_0
    //   83: monitorexit
    //   84: iconst_1
    //   85: ireturn
    //   86: astore_1
    //   87: aload_1
    //   88: invokestatic b : (Ljava/lang/Throwable;)Z
    //   91: ifne -> 98
    //   94: aload_1
    //   95: invokevirtual printStackTrace : ()V
    //   98: aload_0
    //   99: monitorexit
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	86	finally
    //   26	30	86	finally
    //   43	75	86	finally
    //   87	98	102	finally
  }
  
  public final SQLiteDatabase getReadableDatabase() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: iconst_0
    //   5: istore_1
    //   6: aload_2
    //   7: ifnonnull -> 83
    //   10: iload_1
    //   11: iconst_5
    //   12: if_icmpge -> 83
    //   15: iload_1
    //   16: iconst_1
    //   17: iadd
    //   18: istore_1
    //   19: aload_0
    //   20: invokespecial getReadableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore_3
    //   24: aload_3
    //   25: astore_2
    //   26: goto -> 6
    //   29: ldc '[Database] Try to get db(count: %d).'
    //   31: iconst_1
    //   32: anewarray java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: iload_1
    //   38: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   41: aastore
    //   42: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   45: pop
    //   46: iload_1
    //   47: iconst_5
    //   48: if_icmpne -> 61
    //   51: ldc '[Database] Failed to get db.'
    //   53: iconst_0
    //   54: anewarray java/lang/Object
    //   57: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: ldc2_w 200
    //   64: invokestatic sleep : (J)V
    //   67: goto -> 6
    //   70: astore_3
    //   71: aload_3
    //   72: invokevirtual printStackTrace : ()V
    //   75: goto -> 6
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_2
    //   86: areturn
    //   87: astore_3
    //   88: goto -> 29
    // Exception table:
    //   from	to	target	type
    //   19	24	87	finally
    //   29	46	78	finally
    //   51	61	78	finally
    //   61	67	70	java/lang/InterruptedException
    //   61	67	78	finally
    //   71	75	78	finally
  }
  
  public final SQLiteDatabase getWritableDatabase() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: iconst_0
    //   5: istore_1
    //   6: aload_2
    //   7: ifnonnull -> 78
    //   10: iload_1
    //   11: iconst_5
    //   12: if_icmpge -> 78
    //   15: iload_1
    //   16: iconst_1
    //   17: iadd
    //   18: istore_1
    //   19: aload_0
    //   20: invokespecial getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore_3
    //   24: aload_3
    //   25: astore_2
    //   26: goto -> 6
    //   29: ldc '[Database] Try to get db(count: %d).'
    //   31: iconst_1
    //   32: anewarray java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: iload_1
    //   38: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   41: aastore
    //   42: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   45: pop
    //   46: iload_1
    //   47: iconst_5
    //   48: if_icmpne -> 61
    //   51: ldc '[Database] Failed to get db.'
    //   53: iconst_0
    //   54: anewarray java/lang/Object
    //   57: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: ldc2_w 200
    //   64: invokestatic sleep : (J)V
    //   67: goto -> 6
    //   70: astore_3
    //   71: aload_3
    //   72: invokevirtual printStackTrace : ()V
    //   75: goto -> 6
    //   78: aload_2
    //   79: ifnonnull -> 100
    //   82: ldc '[Database] db error delay error record 1min.'
    //   84: iconst_0
    //   85: anewarray java/lang/Object
    //   88: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   91: pop
    //   92: goto -> 100
    //   95: astore_2
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_2
    //   103: areturn
    //   104: astore_3
    //   105: goto -> 29
    // Exception table:
    //   from	to	target	type
    //   19	24	104	finally
    //   29	46	95	finally
    //   51	61	95	finally
    //   61	67	70	java/lang/InterruptedException
    //   61	67	95	finally
    //   71	75	95	finally
    //   82	92	95	finally
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_2
    //   11: iconst_0
    //   12: invokevirtual setLength : (I)V
    //   15: aload_2
    //   16: ldc ' CREATE TABLE IF NOT EXISTS t_ui'
    //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: ldc ' ( _id'
    //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: ldc ' INTEGER PRIMARY KEY'
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: ldc ' , _tm'
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_2
    //   44: ldc ' int'
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_2
    //   51: ldc ' , _ut'
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: ldc ' int'
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_2
    //   65: ldc ' , _tp'
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_2
    //   72: ldc ' int'
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_2
    //   79: ldc ' , _dt'
    //   81: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_2
    //   86: ldc ' blob'
    //   88: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_2
    //   93: ldc ' , _pc'
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_2
    //   100: ldc ' text'
    //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_2
    //   107: ldc ' ) '
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_2
    //   114: invokevirtual toString : ()Ljava/lang/String;
    //   117: iconst_0
    //   118: anewarray java/lang/Object
    //   121: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   124: pop
    //   125: aload_1
    //   126: aload_2
    //   127: invokevirtual toString : ()Ljava/lang/String;
    //   130: iconst_0
    //   131: anewarray java/lang/String
    //   134: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload_2
    //   138: iconst_0
    //   139: invokevirtual setLength : (I)V
    //   142: aload_2
    //   143: ldc ' CREATE TABLE IF NOT EXISTS t_lr'
    //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_2
    //   150: ldc ' ( _id'
    //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_2
    //   157: ldc ' INTEGER PRIMARY KEY'
    //   159: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_2
    //   164: ldc ' , _tp'
    //   166: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_2
    //   171: ldc ' int'
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_2
    //   178: ldc ' , _tm'
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_2
    //   185: ldc ' int'
    //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_2
    //   192: ldc ' , _pc'
    //   194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_2
    //   199: ldc ' text'
    //   201: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_2
    //   206: ldc ' , _th'
    //   208: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_2
    //   213: ldc ' text'
    //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_2
    //   220: ldc ' , _dt'
    //   222: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_2
    //   227: ldc ' blob'
    //   229: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_2
    //   234: ldc ' ) '
    //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_2
    //   241: invokevirtual toString : ()Ljava/lang/String;
    //   244: iconst_0
    //   245: anewarray java/lang/Object
    //   248: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   251: pop
    //   252: aload_1
    //   253: aload_2
    //   254: invokevirtual toString : ()Ljava/lang/String;
    //   257: iconst_0
    //   258: anewarray java/lang/String
    //   261: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: aload_2
    //   265: iconst_0
    //   266: invokevirtual setLength : (I)V
    //   269: aload_2
    //   270: ldc ' CREATE TABLE IF NOT EXISTS t_pf'
    //   272: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_2
    //   277: ldc ' ( _id'
    //   279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_2
    //   284: ldc ' integer'
    //   286: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload_2
    //   291: ldc ' , _tp'
    //   293: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_2
    //   298: ldc ' text'
    //   300: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_2
    //   305: ldc ' , _tm'
    //   307: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_2
    //   312: ldc ' int'
    //   314: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_2
    //   319: ldc ' , _dt'
    //   321: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_2
    //   326: ldc ' blob'
    //   328: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload_2
    //   333: ldc ',primary key(_id'
    //   335: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload_2
    //   340: ldc ',_tp'
    //   342: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload_2
    //   347: ldc ' )) '
    //   349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload_2
    //   354: invokevirtual toString : ()Ljava/lang/String;
    //   357: iconst_0
    //   358: anewarray java/lang/Object
    //   361: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   364: pop
    //   365: aload_1
    //   366: aload_2
    //   367: invokevirtual toString : ()Ljava/lang/String;
    //   370: iconst_0
    //   371: anewarray java/lang/String
    //   374: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   377: aload_2
    //   378: iconst_0
    //   379: invokevirtual setLength : (I)V
    //   382: aload_2
    //   383: ldc ' CREATE TABLE IF NOT EXISTS t_cr'
    //   385: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_2
    //   390: ldc ' ( _id'
    //   392: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_2
    //   397: ldc ' INTEGER PRIMARY KEY'
    //   399: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload_2
    //   404: ldc ' , _tm'
    //   406: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload_2
    //   411: ldc ' int'
    //   413: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_2
    //   418: ldc ' , _s1'
    //   420: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload_2
    //   425: ldc ' text'
    //   427: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload_2
    //   432: ldc ' , _up'
    //   434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload_2
    //   439: ldc ' int'
    //   441: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_2
    //   446: ldc ' , _me'
    //   448: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_2
    //   453: ldc ' int'
    //   455: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload_2
    //   460: ldc ' , _uc'
    //   462: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload_2
    //   467: ldc ' int'
    //   469: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload_2
    //   474: ldc ' , _dt'
    //   476: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload_2
    //   481: ldc ' blob'
    //   483: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload_2
    //   488: ldc ' ) '
    //   490: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_2
    //   495: invokevirtual toString : ()Ljava/lang/String;
    //   498: iconst_0
    //   499: anewarray java/lang/Object
    //   502: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   505: pop
    //   506: aload_1
    //   507: aload_2
    //   508: invokevirtual toString : ()Ljava/lang/String;
    //   511: iconst_0
    //   512: anewarray java/lang/String
    //   515: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   518: aload_2
    //   519: iconst_0
    //   520: invokevirtual setLength : (I)V
    //   523: aload_2
    //   524: ldc ' CREATE TABLE IF NOT EXISTS dl_1002'
    //   526: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload_2
    //   531: ldc ' (_id'
    //   533: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload_2
    //   538: ldc ' integer primary key autoincrement, _dUrl'
    //   540: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload_2
    //   545: ldc ' varchar(100), _sFile'
    //   547: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload_2
    //   552: ldc ' varchar(100), _sLen'
    //   554: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload_2
    //   559: ldc ' INTEGER, _tLen'
    //   561: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload_2
    //   566: ldc ' INTEGER, _MD5'
    //   568: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload_2
    //   573: ldc ' varchar(100), _DLTIME'
    //   575: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload_2
    //   580: ldc ' INTEGER)'
    //   582: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload_2
    //   587: invokevirtual toString : ()Ljava/lang/String;
    //   590: iconst_0
    //   591: anewarray java/lang/Object
    //   594: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   597: pop
    //   598: aload_1
    //   599: aload_2
    //   600: invokevirtual toString : ()Ljava/lang/String;
    //   603: iconst_0
    //   604: anewarray java/lang/String
    //   607: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   610: aload_2
    //   611: iconst_0
    //   612: invokevirtual setLength : (I)V
    //   615: aload_2
    //   616: ldc 'CREATE TABLE IF NOT EXISTS ge_1002'
    //   618: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload_2
    //   623: ldc ' (_id'
    //   625: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload_2
    //   630: ldc ' integer primary key autoincrement, _time'
    //   632: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload_2
    //   637: ldc ' INTEGER, _datas'
    //   639: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload_2
    //   644: ldc ' blob)'
    //   646: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload_2
    //   651: invokevirtual toString : ()Ljava/lang/String;
    //   654: iconst_0
    //   655: anewarray java/lang/Object
    //   658: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   661: pop
    //   662: aload_1
    //   663: aload_2
    //   664: invokevirtual toString : ()Ljava/lang/String;
    //   667: iconst_0
    //   668: anewarray java/lang/String
    //   671: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   674: aload_2
    //   675: iconst_0
    //   676: invokevirtual setLength : (I)V
    //   679: aload_2
    //   680: ldc ' CREATE TABLE IF NOT EXISTS st_1002'
    //   682: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload_2
    //   687: ldc ' ( _id'
    //   689: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload_2
    //   694: ldc ' integer'
    //   696: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: pop
    //   700: aload_2
    //   701: ldc ' , _tp'
    //   703: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: aload_2
    //   708: ldc ' text'
    //   710: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload_2
    //   715: ldc ' , _tm'
    //   717: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: aload_2
    //   722: ldc ' int'
    //   724: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload_2
    //   729: ldc ' , _dt'
    //   731: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload_2
    //   736: ldc ' blob'
    //   738: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload_2
    //   743: ldc ',primary key(_id'
    //   745: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload_2
    //   750: ldc ',_tp'
    //   752: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload_2
    //   757: ldc ' )) '
    //   759: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: aload_2
    //   764: invokevirtual toString : ()Ljava/lang/String;
    //   767: iconst_0
    //   768: anewarray java/lang/Object
    //   771: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   774: pop
    //   775: aload_1
    //   776: aload_2
    //   777: invokevirtual toString : ()Ljava/lang/String;
    //   780: iconst_0
    //   781: anewarray java/lang/String
    //   784: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   787: goto -> 802
    //   790: astore_2
    //   791: aload_2
    //   792: invokestatic b : (Ljava/lang/Throwable;)Z
    //   795: ifne -> 802
    //   798: aload_2
    //   799: invokevirtual printStackTrace : ()V
    //   802: aload_0
    //   803: getfield d : Ljava/util/List;
    //   806: astore_2
    //   807: aload_2
    //   808: ifnonnull -> 814
    //   811: aload_0
    //   812: monitorexit
    //   813: return
    //   814: aload_0
    //   815: getfield d : Ljava/util/List;
    //   818: invokeinterface iterator : ()Ljava/util/Iterator;
    //   823: astore_2
    //   824: aload_2
    //   825: invokeinterface hasNext : ()Z
    //   830: ifeq -> 866
    //   833: aload_2
    //   834: invokeinterface next : ()Ljava/lang/Object;
    //   839: checkcast com/tencent/bugly/a
    //   842: astore_3
    //   843: aload_3
    //   844: aload_1
    //   845: invokevirtual onDbCreate : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   848: goto -> 824
    //   851: astore_3
    //   852: aload_3
    //   853: invokestatic b : (Ljava/lang/Throwable;)Z
    //   856: ifne -> 824
    //   859: aload_3
    //   860: invokevirtual printStackTrace : ()V
    //   863: goto -> 824
    //   866: aload_0
    //   867: monitorexit
    //   868: return
    //   869: astore_1
    //   870: aload_0
    //   871: monitorexit
    //   872: aload_1
    //   873: athrow
    // Exception table:
    //   from	to	target	type
    //   2	787	790	finally
    //   791	802	869	finally
    //   802	807	869	finally
    //   814	824	869	finally
    //   824	843	869	finally
    //   843	848	851	finally
    //   852	863	869	finally
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic c : ()I
    //   5: bipush #11
    //   7: if_icmplt -> 156
    //   10: ldc '[Database] Downgrade %d to %d drop tables.'
    //   12: iconst_2
    //   13: anewarray java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: iload_2
    //   19: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: iload_3
    //   26: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   29: aastore
    //   30: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   33: pop
    //   34: aload_0
    //   35: getfield d : Ljava/util/List;
    //   38: ifnull -> 103
    //   41: aload_0
    //   42: getfield d : Ljava/util/List;
    //   45: invokeinterface iterator : ()Ljava/util/Iterator;
    //   50: astore #4
    //   52: aload #4
    //   54: invokeinterface hasNext : ()Z
    //   59: ifeq -> 103
    //   62: aload #4
    //   64: invokeinterface next : ()Ljava/lang/Object;
    //   69: checkcast com/tencent/bugly/a
    //   72: astore #5
    //   74: aload #5
    //   76: aload_1
    //   77: iload_2
    //   78: iload_3
    //   79: invokevirtual onDbDowngrade : (Landroid/database/sqlite/SQLiteDatabase;II)V
    //   82: goto -> 52
    //   85: astore #5
    //   87: aload #5
    //   89: invokestatic b : (Ljava/lang/Throwable;)Z
    //   92: ifne -> 52
    //   95: aload #5
    //   97: invokevirtual printStackTrace : ()V
    //   100: goto -> 52
    //   103: aload_0
    //   104: aload_1
    //   105: invokespecial a : (Landroid/database/sqlite/SQLiteDatabase;)Z
    //   108: ifeq -> 119
    //   111: aload_0
    //   112: aload_1
    //   113: invokevirtual onCreate : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   116: aload_0
    //   117: monitorexit
    //   118: return
    //   119: ldc '[Database] Failed to drop, delete db.'
    //   121: iconst_0
    //   122: anewarray java/lang/Object
    //   125: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   128: pop
    //   129: aload_0
    //   130: getfield c : Landroid/content/Context;
    //   133: getstatic com/tencent/bugly/proguard/q.a : Ljava/lang/String;
    //   136: invokevirtual getDatabasePath : (Ljava/lang/String;)Ljava/io/File;
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull -> 156
    //   144: aload_1
    //   145: invokevirtual canWrite : ()Z
    //   148: ifeq -> 156
    //   151: aload_1
    //   152: invokevirtual delete : ()Z
    //   155: pop
    //   156: aload_0
    //   157: monitorexit
    //   158: return
    //   159: astore_1
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Exception table:
    //   from	to	target	type
    //   2	52	159	finally
    //   52	74	159	finally
    //   74	82	85	finally
    //   87	100	159	finally
    //   103	116	159	finally
    //   119	140	159	finally
    //   144	156	159	finally
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w '[Database] Upgrade %d to %d , drop tables!'
    //   5: iconst_2
    //   6: anewarray java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: iload_2
    //   12: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: iload_3
    //   19: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   22: aastore
    //   23: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   26: pop
    //   27: aload_0
    //   28: getfield d : Ljava/util/List;
    //   31: ifnull -> 96
    //   34: aload_0
    //   35: getfield d : Ljava/util/List;
    //   38: invokeinterface iterator : ()Ljava/util/Iterator;
    //   43: astore #4
    //   45: aload #4
    //   47: invokeinterface hasNext : ()Z
    //   52: ifeq -> 96
    //   55: aload #4
    //   57: invokeinterface next : ()Ljava/lang/Object;
    //   62: checkcast com/tencent/bugly/a
    //   65: astore #5
    //   67: aload #5
    //   69: aload_1
    //   70: iload_2
    //   71: iload_3
    //   72: invokevirtual onDbUpgrade : (Landroid/database/sqlite/SQLiteDatabase;II)V
    //   75: goto -> 45
    //   78: astore #5
    //   80: aload #5
    //   82: invokestatic b : (Ljava/lang/Throwable;)Z
    //   85: ifne -> 45
    //   88: aload #5
    //   90: invokevirtual printStackTrace : ()V
    //   93: goto -> 45
    //   96: aload_0
    //   97: aload_1
    //   98: invokespecial a : (Landroid/database/sqlite/SQLiteDatabase;)Z
    //   101: ifeq -> 112
    //   104: aload_0
    //   105: aload_1
    //   106: invokevirtual onCreate : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   109: aload_0
    //   110: monitorexit
    //   111: return
    //   112: ldc '[Database] Failed to drop, delete db.'
    //   114: iconst_0
    //   115: anewarray java/lang/Object
    //   118: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload_0
    //   123: getfield c : Landroid/content/Context;
    //   126: getstatic com/tencent/bugly/proguard/q.a : Ljava/lang/String;
    //   129: invokevirtual getDatabasePath : (Ljava/lang/String;)Ljava/io/File;
    //   132: astore_1
    //   133: aload_1
    //   134: ifnull -> 149
    //   137: aload_1
    //   138: invokevirtual canWrite : ()Z
    //   141: ifeq -> 149
    //   144: aload_1
    //   145: invokevirtual delete : ()Z
    //   148: pop
    //   149: aload_0
    //   150: monitorexit
    //   151: return
    //   152: astore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    // Exception table:
    //   from	to	target	type
    //   2	45	152	finally
    //   45	67	152	finally
    //   67	75	78	finally
    //   80	93	152	finally
    //   96	109	152	finally
    //   112	133	152	finally
    //   137	149	152	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */