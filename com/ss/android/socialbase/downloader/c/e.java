package com.ss.android.socialbase.downloader.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.g.b;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.m.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class e extends c.a implements s {
  private static volatile SQLiteDatabase b;
  
  b a = null;
  
  private g c;
  
  private g d;
  
  private volatile boolean e;
  
  public e() {
    this(false);
  }
  
  public e(boolean paramBoolean) {
    if (!paramBoolean)
      return; 
    this.e = false;
    a();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, SQLiteStatement paramSQLiteStatement) {
    // Byte code:
    //   0: aload #5
    //   2: monitorenter
    //   3: new android/content/ContentValues
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: astore #6
    //   12: aload #6
    //   14: ldc 'chunkIndex'
    //   16: iload #4
    //   18: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   21: invokevirtual put : (Ljava/lang/String;Ljava/lang/Integer;)V
    //   24: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   27: ldc 'downloadChunk'
    //   29: aload #6
    //   31: ldc '_id = ? AND chunkIndex = ? AND hostChunkIndex = ?'
    //   33: iconst_3
    //   34: anewarray java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: iload_1
    //   40: invokestatic toString : (I)Ljava/lang/String;
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: iload_2
    //   47: invokestatic toString : (I)Ljava/lang/String;
    //   50: aastore
    //   51: dup
    //   52: iconst_2
    //   53: iload_3
    //   54: invokestatic toString : (I)Ljava/lang/String;
    //   57: aastore
    //   58: invokevirtual update : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   61: pop
    //   62: aload #5
    //   64: monitorexit
    //   65: return
    //   66: astore #6
    //   68: aload #5
    //   70: monitorexit
    //   71: aload #6
    //   73: athrow
    //   74: astore #5
    //   76: aload #5
    //   78: invokevirtual printStackTrace : ()V
    //   81: return
    // Exception table:
    //   from	to	target	type
    //   0	3	74	finally
    //   3	65	66	finally
    //   68	71	66	finally
    //   71	74	74	finally
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, SQLiteStatement paramSQLiteStatement) {
    // Byte code:
    //   0: aload #6
    //   2: monitorenter
    //   3: new android/content/ContentValues
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: astore #7
    //   12: aload #7
    //   14: ldc 'curOffset'
    //   16: lload #4
    //   18: invokestatic valueOf : (J)Ljava/lang/Long;
    //   21: invokevirtual put : (Ljava/lang/String;Ljava/lang/Long;)V
    //   24: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   27: ldc 'downloadChunk'
    //   29: aload #7
    //   31: ldc '_id = ? AND chunkIndex = ? AND hostChunkIndex = ?'
    //   33: iconst_3
    //   34: anewarray java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: iload_1
    //   40: invokestatic toString : (I)Ljava/lang/String;
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: iload_2
    //   47: invokestatic toString : (I)Ljava/lang/String;
    //   50: aastore
    //   51: dup
    //   52: iconst_2
    //   53: iload_3
    //   54: invokestatic toString : (I)Ljava/lang/String;
    //   57: aastore
    //   58: invokevirtual update : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   61: pop
    //   62: aload #6
    //   64: monitorexit
    //   65: return
    //   66: astore #7
    //   68: aload #6
    //   70: monitorexit
    //   71: aload #7
    //   73: athrow
    //   74: astore #6
    //   76: aload #6
    //   78: invokevirtual printStackTrace : ()V
    //   81: return
    // Exception table:
    //   from	to	target	type
    //   0	3	74	finally
    //   3	65	66	finally
    //   68	71	66	finally
    //   71	74	74	finally
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, SQLiteStatement paramSQLiteStatement) {
    // Byte code:
    //   0: aload #5
    //   2: monitorenter
    //   3: new android/content/ContentValues
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: astore #6
    //   12: aload #6
    //   14: ldc 'curOffset'
    //   16: lload_3
    //   17: invokestatic valueOf : (J)Ljava/lang/Long;
    //   20: invokevirtual put : (Ljava/lang/String;Ljava/lang/Long;)V
    //   23: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   26: ldc 'downloadChunk'
    //   28: aload #6
    //   30: ldc '_id = ? AND chunkIndex = ?'
    //   32: iconst_2
    //   33: anewarray java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: iload_1
    //   39: invokestatic toString : (I)Ljava/lang/String;
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: iload_2
    //   46: invokestatic toString : (I)Ljava/lang/String;
    //   49: aastore
    //   50: invokevirtual update : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   53: pop
    //   54: aload #5
    //   56: monitorexit
    //   57: return
    //   58: astore #6
    //   60: aload #5
    //   62: monitorexit
    //   63: aload #6
    //   65: athrow
    //   66: astore #5
    //   68: aload #5
    //   70: invokevirtual printStackTrace : ()V
    //   73: return
    // Exception table:
    //   from	to	target	type
    //   0	3	66	finally
    //   3	57	58	finally
    //   60	63	58	finally
    //   63	66	66	finally
  }
  
  private void a(int paramInt, ContentValues paramContentValues) {
    f();
    if (b == null)
      return; 
    if (f.d()) {
      ExecutorService executorService = b.m();
      if (executorService == null)
        return; 
      executorService.execute(new Runnable(this, paramInt, paramContentValues) {
            public void run() {
              e.a(this.c, this.a, this.b);
            }
          });
      return;
    } 
    b(paramInt, paramContentValues);
  }
  
  private void a(int paramInt, SQLiteStatement paramSQLiteStatement) {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull -> 5
    //   4: return
    //   5: aload_2
    //   6: monitorenter
    //   7: iload_1
    //   8: i2l
    //   9: lstore_3
    //   10: aload_2
    //   11: iconst_1
    //   12: lload_3
    //   13: invokevirtual bindLong : (IJ)V
    //   16: aload_2
    //   17: invokevirtual execute : ()V
    //   20: aload_2
    //   21: monitorexit
    //   22: return
    //   23: astore #5
    //   25: aload_2
    //   26: monitorexit
    //   27: aload #5
    //   29: athrow
    //   30: astore_2
    //   31: aload_2
    //   32: invokevirtual printStackTrace : ()V
    //   35: return
    // Exception table:
    //   from	to	target	type
    //   5	7	30	finally
    //   10	22	23	finally
    //   25	27	23	finally
    //   27	30	30	finally
  }
  
  private void a(b paramb, SQLiteStatement paramSQLiteStatement) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 34
    //   4: aload_2
    //   5: ifnonnull -> 9
    //   8: return
    //   9: aload_2
    //   10: monitorenter
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual a : (Landroid/database/sqlite/SQLiteStatement;)V
    //   16: aload_2
    //   17: invokevirtual executeInsert : ()J
    //   20: pop2
    //   21: aload_2
    //   22: monitorexit
    //   23: return
    //   24: astore_1
    //   25: aload_2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual printStackTrace : ()V
    //   34: return
    // Exception table:
    //   from	to	target	type
    //   9	11	29	finally
    //   11	23	24	finally
    //   25	27	24	finally
    //   27	29	29	finally
  }
  
  private void a(c paramc, SQLiteStatement paramSQLiteStatement) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 34
    //   4: aload_2
    //   5: ifnonnull -> 9
    //   8: return
    //   9: aload_2
    //   10: monitorenter
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual a : (Landroid/database/sqlite/SQLiteStatement;)V
    //   16: aload_2
    //   17: invokevirtual executeInsert : ()J
    //   20: pop2
    //   21: aload_2
    //   22: monitorexit
    //   23: return
    //   24: astore_1
    //   25: aload_2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual printStackTrace : ()V
    //   34: return
    // Exception table:
    //   from	to	target	type
    //   9	11	29	finally
    //   11	23	24	finally
    //   25	27	24	finally
    //   27	29	29	finally
  }
  
  private void a(List<c> paramList) {
    if (paramList == null)
      return; 
    try {
      return;
    } finally {
      paramList = null;
    } 
  }
  
  private void a(List<c> paramList, List<Integer> paramList1, SparseArray<c> paramSparseArray1, SparseArray<c> paramSparseArray2, SparseArray<List<b>> paramSparseArray) {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual size : ()I
    //   4: istore #8
    //   6: iload #8
    //   8: iflt -> 544
    //   11: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   14: ifnonnull -> 18
    //   17: return
    //   18: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore #11
    //   23: aload #11
    //   25: monitorenter
    //   26: aload_0
    //   27: invokespecial g : ()V
    //   30: aload_1
    //   31: invokeinterface isEmpty : ()Z
    //   36: istore #10
    //   38: iconst_0
    //   39: istore #7
    //   41: iload #10
    //   43: ifne -> 545
    //   46: invokestatic b : ()Lcom/ss/android/socialbase/downloader/k/a;
    //   49: ldc 'clear_invalid_task_error'
    //   51: invokevirtual a : (Ljava/lang/String;)Z
    //   54: ifeq -> 193
    //   57: aload_1
    //   58: invokeinterface size : ()I
    //   63: anewarray java/lang/String
    //   66: astore_2
    //   67: iconst_0
    //   68: istore #6
    //   70: iload #6
    //   72: aload_1
    //   73: invokeinterface size : ()I
    //   78: if_icmpge -> 105
    //   81: aload_2
    //   82: iload #6
    //   84: aload_1
    //   85: iload #6
    //   87: invokeinterface get : (I)Ljava/lang/Object;
    //   92: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   95: aastore
    //   96: iload #6
    //   98: iconst_1
    //   99: iadd
    //   100: istore #6
    //   102: goto -> 70
    //   105: new java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial <init> : ()V
    //   112: astore #12
    //   114: aload #12
    //   116: ldc 'CAST(_id AS TEXT) IN ('
    //   118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload #12
    //   124: new java/lang/String
    //   127: dup
    //   128: aload_1
    //   129: invokeinterface size : ()I
    //   134: iconst_1
    //   135: isub
    //   136: newarray char
    //   138: invokespecial <init> : ([C)V
    //   141: ldc ' '
    //   143: ldc '?,'
    //   145: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload #12
    //   154: ldc_w '?)'
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload #12
    //   163: invokevirtual toString : ()Ljava/lang/String;
    //   166: astore_1
    //   167: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   170: ldc_w 'downloader'
    //   173: aload_1
    //   174: aload_2
    //   175: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   178: pop
    //   179: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   182: ldc 'downloadChunk'
    //   184: aload_1
    //   185: aload_2
    //   186: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   189: pop
    //   190: goto -> 545
    //   193: ldc_w ', '
    //   196: aload_2
    //   197: invokestatic join : (Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   200: astore_1
    //   201: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   204: ldc_w 'downloader'
    //   207: ldc_w '_id IN (?)'
    //   210: iconst_1
    //   211: anewarray java/lang/String
    //   214: dup
    //   215: iconst_0
    //   216: aload_1
    //   217: aastore
    //   218: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   221: pop
    //   222: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   225: ldc 'downloadChunk'
    //   227: ldc_w '_id IN (?)'
    //   230: iconst_1
    //   231: anewarray java/lang/String
    //   234: dup
    //   235: iconst_0
    //   236: aload_1
    //   237: aastore
    //   238: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   241: pop
    //   242: goto -> 545
    //   245: iload #6
    //   247: iload #8
    //   249: if_icmpge -> 415
    //   252: aload_3
    //   253: iload #6
    //   255: invokevirtual keyAt : (I)I
    //   258: istore #9
    //   260: aload_3
    //   261: iload #9
    //   263: invokevirtual get : (I)Ljava/lang/Object;
    //   266: checkcast com/ss/android/socialbase/downloader/g/c
    //   269: astore_1
    //   270: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   273: ldc_w 'downloader'
    //   276: ldc_w '_id = ?'
    //   279: iconst_1
    //   280: anewarray java/lang/String
    //   283: dup
    //   284: iconst_0
    //   285: iload #9
    //   287: invokestatic valueOf : (I)Ljava/lang/String;
    //   290: aastore
    //   291: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   294: pop
    //   295: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   298: ldc_w 'downloader'
    //   301: aconst_null
    //   302: aload_1
    //   303: invokevirtual e : ()Landroid/content/ContentValues;
    //   306: invokevirtual insert : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   309: pop2
    //   310: aload_1
    //   311: invokevirtual aV : ()I
    //   314: iconst_1
    //   315: if_icmple -> 551
    //   318: aload_0
    //   319: iload #9
    //   321: invokevirtual c : (I)Ljava/util/List;
    //   324: astore_2
    //   325: aload_2
    //   326: invokeinterface size : ()I
    //   331: ifgt -> 337
    //   334: goto -> 551
    //   337: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   340: ldc 'downloadChunk'
    //   342: ldc_w '_id = ?'
    //   345: iconst_1
    //   346: anewarray java/lang/String
    //   349: dup
    //   350: iconst_0
    //   351: iload #9
    //   353: invokestatic valueOf : (I)Ljava/lang/String;
    //   356: aastore
    //   357: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   360: pop
    //   361: aload_2
    //   362: invokeinterface iterator : ()Ljava/util/Iterator;
    //   367: astore_2
    //   368: aload_2
    //   369: invokeinterface hasNext : ()Z
    //   374: ifeq -> 551
    //   377: aload_2
    //   378: invokeinterface next : ()Ljava/lang/Object;
    //   383: checkcast com/ss/android/socialbase/downloader/g/b
    //   386: astore #12
    //   388: aload #12
    //   390: aload_1
    //   391: invokevirtual g : ()I
    //   394: invokevirtual b : (I)V
    //   397: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   400: ldc 'downloadChunk'
    //   402: aconst_null
    //   403: aload #12
    //   405: invokevirtual a : ()Landroid/content/ContentValues;
    //   408: invokevirtual insert : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   411: pop2
    //   412: goto -> 368
    //   415: aload #4
    //   417: ifnull -> 507
    //   420: aload #5
    //   422: ifnull -> 507
    //   425: aload #4
    //   427: monitorenter
    //   428: aload #4
    //   430: invokevirtual size : ()I
    //   433: istore #8
    //   435: iload #7
    //   437: istore #6
    //   439: iload #6
    //   441: iload #8
    //   443: if_icmpge -> 495
    //   446: aload #4
    //   448: iload #6
    //   450: invokevirtual valueAt : (I)Ljava/lang/Object;
    //   453: checkcast com/ss/android/socialbase/downloader/g/c
    //   456: invokevirtual g : ()I
    //   459: istore #7
    //   461: aload_0
    //   462: iload #7
    //   464: invokevirtual c : (I)Ljava/util/List;
    //   467: invokestatic a : (Ljava/util/List;)Ljava/util/List;
    //   470: astore_1
    //   471: aload_1
    //   472: ifnull -> 560
    //   475: aload_1
    //   476: invokeinterface size : ()I
    //   481: ifle -> 560
    //   484: aload #5
    //   486: iload #7
    //   488: aload_1
    //   489: invokevirtual put : (ILjava/lang/Object;)V
    //   492: goto -> 560
    //   495: aload #4
    //   497: monitorexit
    //   498: goto -> 507
    //   501: astore_1
    //   502: aload #4
    //   504: monitorexit
    //   505: aload_1
    //   506: athrow
    //   507: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   510: invokevirtual setTransactionSuccessful : ()V
    //   513: aload_0
    //   514: invokespecial h : ()V
    //   517: goto -> 528
    //   520: astore_1
    //   521: aload_1
    //   522: invokevirtual printStackTrace : ()V
    //   525: goto -> 513
    //   528: aload #11
    //   530: monitorexit
    //   531: return
    //   532: astore_1
    //   533: aload_0
    //   534: invokespecial h : ()V
    //   537: aload_1
    //   538: athrow
    //   539: aload #11
    //   541: monitorexit
    //   542: aload_1
    //   543: athrow
    //   544: return
    //   545: iconst_0
    //   546: istore #6
    //   548: goto -> 245
    //   551: iload #6
    //   553: iconst_1
    //   554: iadd
    //   555: istore #6
    //   557: goto -> 245
    //   560: iload #6
    //   562: iconst_1
    //   563: iadd
    //   564: istore #6
    //   566: goto -> 439
    //   569: astore_1
    //   570: goto -> 539
    // Exception table:
    //   from	to	target	type
    //   26	38	520	finally
    //   46	67	520	finally
    //   70	96	520	finally
    //   105	190	520	finally
    //   193	242	520	finally
    //   252	334	520	finally
    //   337	368	520	finally
    //   368	412	520	finally
    //   425	428	520	finally
    //   428	435	501	finally
    //   446	471	501	finally
    //   475	492	501	finally
    //   495	498	501	finally
    //   502	505	501	finally
    //   505	507	520	finally
    //   507	513	520	finally
    //   513	517	569	finally
    //   521	525	532	finally
    //   528	531	569	finally
    //   533	539	569	finally
    //   539	542	569	finally
  }
  
  private void b(int paramInt, ContentValues paramContentValues) {
    int i = 10;
    try {
    
    } finally {
      paramContentValues = null;
      paramContentValues.printStackTrace();
    } 
  }
  
  private void b(c paramc, SQLiteStatement paramSQLiteStatement) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 48
    //   4: aload_2
    //   5: ifnonnull -> 9
    //   8: return
    //   9: aload_2
    //   10: monitorenter
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual a : (Landroid/database/sqlite/SQLiteStatement;)V
    //   16: aload_2
    //   17: aload_1
    //   18: invokevirtual f : ()I
    //   21: iconst_1
    //   22: iadd
    //   23: aload_1
    //   24: invokevirtual g : ()I
    //   27: i2l
    //   28: invokevirtual bindLong : (IJ)V
    //   31: aload_2
    //   32: invokevirtual execute : ()V
    //   35: aload_2
    //   36: monitorexit
    //   37: return
    //   38: astore_1
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual printStackTrace : ()V
    //   48: return
    // Exception table:
    //   from	to	target	type
    //   9	11	43	finally
    //   11	37	38	finally
    //   39	41	38	finally
    //   41	43	43	finally
  }
  
  private void c(c paramc) {
    f();
    if (b != null) {
      if (this.c == null)
        return; 
      if (f.d()) {
        ExecutorService executorService = b.m();
        if (executorService == null)
          return; 
        executorService.execute(new Runnable(this, paramc) {
              public void run() {
                try {
                  return;
                } finally {
                  Exception exception = null;
                  exception.printStackTrace();
                } 
              }
            });
        return;
      } 
      try {
        return;
      } finally {
        paramc = null;
      } 
    } 
  }
  
  private void d(c paramc) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual g : ()I
    //   14: invokevirtual a : (I)Z
    //   17: ifne -> 28
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial c : (Lcom/ss/android/socialbase/downloader/g/c;)V
    //   25: goto -> 68
    //   28: aload_0
    //   29: getfield c : Lcom/ss/android/socialbase/downloader/c/g;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnonnull -> 40
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: aload_0
    //   41: aload_1
    //   42: aload_0
    //   43: getfield c : Lcom/ss/android/socialbase/downloader/c/g;
    //   46: invokevirtual c : ()Landroid/database/sqlite/SQLiteStatement;
    //   49: invokespecial b : (Lcom/ss/android/socialbase/downloader/g/c;Landroid/database/sqlite/SQLiteStatement;)V
    //   52: goto -> 68
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual printStackTrace : ()V
    //   60: goto -> 68
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual printStackTrace : ()V
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Exception table:
    //   from	to	target	type
    //   9	25	63	finally
    //   28	33	63	finally
    //   40	52	55	finally
    //   56	60	63	finally
    //   64	68	71	finally
  }
  
  private void f() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   3: ifnonnull -> 89
    //   6: ldc com/ss/android/socialbase/downloader/c/e
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull -> 79
    //   17: invokestatic a : ()Lcom/ss/android/socialbase/downloader/c/a;
    //   20: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   23: putstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   26: aload_0
    //   27: new com/ss/android/socialbase/downloader/c/g
    //   30: dup
    //   31: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   34: ldc_w 'downloader'
    //   37: getstatic com/ss/android/socialbase/downloader/b/c.a : [Ljava/lang/String;
    //   40: getstatic com/ss/android/socialbase/downloader/b/c.b : [Ljava/lang/String;
    //   43: invokespecial <init> : (Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V
    //   46: putfield c : Lcom/ss/android/socialbase/downloader/c/g;
    //   49: aload_0
    //   50: new com/ss/android/socialbase/downloader/c/g
    //   53: dup
    //   54: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   57: ldc 'downloadChunk'
    //   59: getstatic com/ss/android/socialbase/downloader/b/c.c : [Ljava/lang/String;
    //   62: getstatic com/ss/android/socialbase/downloader/b/c.d : [Ljava/lang/String;
    //   65: invokespecial <init> : (Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V
    //   68: putfield d : Lcom/ss/android/socialbase/downloader/c/g;
    //   71: goto -> 79
    //   74: astore_1
    //   75: aload_1
    //   76: invokevirtual printStackTrace : ()V
    //   79: ldc com/ss/android/socialbase/downloader/c/e
    //   81: monitorexit
    //   82: return
    //   83: astore_1
    //   84: ldc com/ss/android/socialbase/downloader/c/e
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    //   89: return
    // Exception table:
    //   from	to	target	type
    //   9	13	83	finally
    //   17	71	74	finally
    //   75	79	83	finally
    //   79	82	83	finally
    //   84	87	83	finally
  }
  
  private void g() {
    b.beginTransaction();
  }
  
  private void h() {
    try {
      if (b != null && b.inTransaction())
        return; 
    } finally {
      Exception exception = null;
    } 
  }
  
  private void i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial g : ()V
    //   6: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   9: ldc_w 'downloader'
    //   12: aconst_null
    //   13: aconst_null
    //   14: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   17: pop
    //   18: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   21: ldc 'downloadChunk'
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   28: pop
    //   29: getstatic com/ss/android/socialbase/downloader/c/e.b : Landroid/database/sqlite/SQLiteDatabase;
    //   32: invokevirtual setTransactionSuccessful : ()V
    //   35: aload_0
    //   36: invokespecial h : ()V
    //   39: goto -> 50
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual printStackTrace : ()V
    //   47: goto -> 35
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: astore_1
    //   54: goto -> 64
    //   57: astore_1
    //   58: aload_0
    //   59: invokespecial h : ()V
    //   62: aload_1
    //   63: athrow
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   2	35	42	finally
    //   35	39	53	finally
    //   43	47	57	finally
    //   58	64	53	finally
  }
  
  public c a(int paramInt1, int paramInt2) {
    f();
    if (b == null)
      return null; 
    int i = 10;
    try {
      while (true) {
        boolean bool = b.isDbLockedByCurrentThread();
        if (bool)
          if (--i >= 0)
            try {
              Thread.sleep(5L);
            } finally {
              Exception exception = null;
            }   
        break;
      } 
      ContentValues contentValues = new ContentValues();
      return null;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public c a(int paramInt, long paramLong) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("status", Integer.valueOf(4));
    contentValues.put("curBytes", Long.valueOf(paramLong));
    a(paramInt, contentValues);
    return null;
  }
  
  public c a(int paramInt, long paramLong, String paramString1, String paramString2) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("status", Integer.valueOf(3));
    contentValues.put("totalBytes", Long.valueOf(paramLong));
    contentValues.put("eTag", paramString1);
    if (!TextUtils.isEmpty(paramString2))
      contentValues.put("name", paramString2); 
    a(paramInt, contentValues);
    return null;
  }
  
  public List<c> a(String paramString) {
    f();
    ArrayList<c> arrayList = new ArrayList();
    if (b != null) {
      Cursor cursor = null;
      try {
        Cursor cursor1 = b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[] { "downloader", "url" }), new String[] { paramString });
        cursor = cursor1;
        if (cursor1.moveToNext()) {
          cursor = cursor1;
          arrayList.add(new c(cursor1));
        } 
      } finally {
        paramString = null;
      } 
    } 
    return arrayList;
  }
  
  public void a() {
    a((SparseArray<c>)null, (SparseArray<List<b>>)null, (d)null);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    f();
    if (paramInt1 != 0 && paramInt3 >= 0 && paramInt4 != paramInt2 && paramInt4 >= 0 && b != null) {
      if (this.d == null)
        return; 
      if (f.d()) {
        ExecutorService executorService = b.m();
        if (executorService == null)
          return; 
        executorService.execute(new Runnable(this, paramInt1, paramInt2, paramInt3, paramInt4) {
              public void run() {
                try {
                  return;
                } finally {
                  Exception exception = null;
                  exception.printStackTrace();
                } 
              }
            });
        return;
      } 
      try {
        return;
      } finally {
        Exception exception = null;
      } 
    } 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    f();
    if (paramInt1 != 0 && paramInt2 >= 0 && paramInt3 >= 0 && paramLong >= 0L && b != null) {
      if (this.d == null)
        return; 
      if (f.d()) {
        ExecutorService executorService = b.m();
        if (executorService == null)
          return; 
        executorService.execute(new Runnable(this, paramInt1, paramInt2, paramInt3, paramLong) {
              public void run() {
                try {
                  return;
                } finally {
                  Exception exception = null;
                  exception.printStackTrace();
                } 
              }
            });
        return;
      } 
      try {
        return;
      } finally {
        Exception exception = null;
      } 
    } 
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong) {
    f();
    if (paramInt1 != 0 && paramInt2 >= 0 && paramLong >= 0L && b != null) {
      if (this.d == null)
        return; 
      if (f.d()) {
        ExecutorService executorService = b.m();
        if (executorService == null)
          return; 
        executorService.execute(new Runnable(this, paramInt1, paramInt2, paramLong) {
              public void run() {
                try {
                  return;
                } finally {
                  Exception exception = null;
                  exception.printStackTrace();
                } 
              }
            });
        return;
      } 
      try {
        return;
      } finally {
        Exception exception = null;
      } 
    } 
  }
  
  public void a(int paramInt, List<b> paramList) {}
  
  public void a(SparseArray<c> paramSparseArray, SparseArray<List<b>> paramSparseArray1) {
    try {
      HashMap hashMap1 = f.a(paramSparseArray);
      HashMap hashMap2 = f.a(paramSparseArray1);
      return;
    } finally {
      paramSparseArray = null;
    } 
  }
  
  public void a(SparseArray<c> paramSparseArray, SparseArray<List<b>> paramSparseArray1, d paramd) {
    try {
      Runnable runnable = new Runnable(this, paramSparseArray, paramSparseArray1, paramd) {
          public void run() {
            // Byte code:
            //   0: aload_0
            //   1: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   4: invokestatic a : (Lcom/ss/android/socialbase/downloader/c/e;)V
            //   7: invokestatic e : ()Landroid/database/sqlite/SQLiteDatabase;
            //   10: ifnonnull -> 14
            //   13: return
            //   14: aload_0
            //   15: getfield a : Landroid/util/SparseArray;
            //   18: astore #6
            //   20: aload #6
            //   22: astore #7
            //   24: aload #6
            //   26: ifnonnull -> 38
            //   29: new android/util/SparseArray
            //   32: dup
            //   33: invokespecial <init> : ()V
            //   36: astore #7
            //   38: aload_0
            //   39: getfield b : Landroid/util/SparseArray;
            //   42: astore #6
            //   44: aload #6
            //   46: astore #8
            //   48: aload #6
            //   50: ifnonnull -> 62
            //   53: new android/util/SparseArray
            //   56: dup
            //   57: invokespecial <init> : ()V
            //   60: astore #8
            //   62: invokestatic s : ()Lcom/ss/android/socialbase/downloader/downloader/l;
            //   65: astore #13
            //   67: new android/util/SparseArray
            //   70: dup
            //   71: invokespecial <init> : ()V
            //   74: astore #10
            //   76: new java/util/ArrayList
            //   79: dup
            //   80: invokespecial <init> : ()V
            //   83: astore #11
            //   85: new java/util/ArrayList
            //   88: dup
            //   89: invokespecial <init> : ()V
            //   92: astore #12
            //   94: aconst_null
            //   95: astore #6
            //   97: iconst_0
            //   98: istore #4
            //   100: iconst_0
            //   101: istore #5
            //   103: iconst_0
            //   104: istore_3
            //   105: invokestatic e : ()Landroid/database/sqlite/SQLiteDatabase;
            //   108: ldc 'SELECT * FROM downloader'
            //   110: aconst_null
            //   111: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
            //   114: astore #9
            //   116: aload #9
            //   118: astore #6
            //   120: aload #9
            //   122: invokeinterface moveToNext : ()Z
            //   127: ifeq -> 557
            //   130: aload #9
            //   132: astore #6
            //   134: new com/ss/android/socialbase/downloader/g/c
            //   137: dup
            //   138: aload #9
            //   140: invokespecial <init> : (Landroid/database/Cursor;)V
            //   143: astore #14
            //   145: aload #9
            //   147: astore #6
            //   149: aload #14
            //   151: invokevirtual aT : ()Z
            //   154: ifeq -> 168
            //   157: aload #9
            //   159: astore #6
            //   161: aload #14
            //   163: bipush #-5
            //   165: invokevirtual b : (I)V
            //   168: aload #9
            //   170: astore #6
            //   172: aload #14
            //   174: invokevirtual k : ()Ljava/lang/String;
            //   177: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
            //   180: ifne -> 1629
            //   183: aload #9
            //   185: astore #6
            //   187: aload #14
            //   189: invokevirtual h : ()Ljava/lang/String;
            //   192: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
            //   195: ifeq -> 201
            //   198: goto -> 1629
            //   201: aload #9
            //   203: astore #6
            //   205: new java/io/File
            //   208: dup
            //   209: aload #14
            //   211: invokevirtual k : ()Ljava/lang/String;
            //   214: aload #14
            //   216: invokevirtual h : ()Ljava/lang/String;
            //   219: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
            //   222: astore #15
            //   224: aload #9
            //   226: astore #6
            //   228: ldc 131072
            //   230: invokestatic a : (I)Z
            //   233: ifeq -> 304
            //   236: aload #9
            //   238: astore #6
            //   240: aload #14
            //   242: invokevirtual q : ()I
            //   245: iconst_1
            //   246: if_icmpne -> 266
            //   249: aload #9
            //   251: astore #6
            //   253: aload #14
            //   255: invokevirtual Z : ()J
            //   258: lconst_0
            //   259: lcmp
            //   260: ifgt -> 266
            //   263: goto -> 1619
            //   266: aload #9
            //   268: astore #6
            //   270: aload #14
            //   272: invokevirtual q : ()I
            //   275: bipush #-3
            //   277: if_icmpeq -> 1624
            //   280: aload #9
            //   282: astore #6
            //   284: aload #14
            //   286: invokevirtual aN : ()Z
            //   289: ifne -> 1624
            //   292: aload #9
            //   294: astore #6
            //   296: aload #14
            //   298: invokevirtual aM : ()V
            //   301: goto -> 1624
            //   304: aload #9
            //   306: astore #6
            //   308: aload #14
            //   310: invokevirtual q : ()I
            //   313: iconst_1
            //   314: if_icmpne -> 331
            //   317: aload #9
            //   319: astore #6
            //   321: aload #14
            //   323: invokevirtual Z : ()J
            //   326: lconst_0
            //   327: lcmp
            //   328: ifle -> 1619
            //   331: aload #9
            //   333: astore #6
            //   335: aload #14
            //   337: invokevirtual q : ()I
            //   340: bipush #-3
            //   342: if_icmpeq -> 1624
            //   345: aload #9
            //   347: astore #6
            //   349: aload #14
            //   351: invokevirtual aN : ()Z
            //   354: ifne -> 1624
            //   357: goto -> 1619
            //   360: iload_1
            //   361: istore_2
            //   362: aload #9
            //   364: astore #6
            //   366: ldc 33554432
            //   368: invokestatic a : (I)Z
            //   371: ifeq -> 407
            //   374: iload_1
            //   375: istore_2
            //   376: aload #9
            //   378: astore #6
            //   380: aload #14
            //   382: invokevirtual q : ()I
            //   385: bipush #-3
            //   387: if_icmpne -> 407
            //   390: iload_1
            //   391: istore_2
            //   392: aload #9
            //   394: astore #6
            //   396: aload #15
            //   398: invokevirtual exists : ()Z
            //   401: ifne -> 407
            //   404: goto -> 1629
            //   407: iload_2
            //   408: ifeq -> 448
            //   411: aload #9
            //   413: astore #6
            //   415: aload #11
            //   417: aload #14
            //   419: invokevirtual g : ()I
            //   422: invokestatic valueOf : (I)Ljava/lang/Integer;
            //   425: invokeinterface add : (Ljava/lang/Object;)Z
            //   430: pop
            //   431: aload #9
            //   433: astore #6
            //   435: aload #12
            //   437: aload #14
            //   439: invokeinterface add : (Ljava/lang/Object;)Z
            //   444: pop
            //   445: goto -> 116
            //   448: aload #9
            //   450: astore #6
            //   452: aload #14
            //   454: invokevirtual g : ()I
            //   457: istore_2
            //   458: aload #13
            //   460: ifnull -> 1634
            //   463: aload #9
            //   465: astore #6
            //   467: aload #13
            //   469: aload #14
            //   471: invokevirtual j : ()Ljava/lang/String;
            //   474: aload #14
            //   476: invokevirtual k : ()Ljava/lang/String;
            //   479: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;)I
            //   484: istore_1
            //   485: goto -> 488
            //   488: iload_1
            //   489: iload_2
            //   490: if_icmpeq -> 515
            //   493: aload #9
            //   495: astore #6
            //   497: aload #14
            //   499: iload_1
            //   500: invokevirtual g : (I)V
            //   503: aload #9
            //   505: astore #6
            //   507: aload #10
            //   509: iload_2
            //   510: aload #14
            //   512: invokevirtual put : (ILjava/lang/Object;)V
            //   515: aload #7
            //   517: ifnull -> 116
            //   520: aload #9
            //   522: astore #6
            //   524: aload #7
            //   526: monitorenter
            //   527: aload #7
            //   529: aload #14
            //   531: invokevirtual g : ()I
            //   534: aload #14
            //   536: invokevirtual put : (ILjava/lang/Object;)V
            //   539: aload #7
            //   541: monitorexit
            //   542: goto -> 116
            //   545: astore #13
            //   547: aload #7
            //   549: monitorexit
            //   550: aload #9
            //   552: astore #6
            //   554: aload #13
            //   556: athrow
            //   557: aload #9
            //   559: ifnull -> 579
            //   562: aload #9
            //   564: invokeinterface close : ()V
            //   569: goto -> 579
            //   572: astore #6
            //   574: aload #6
            //   576: invokevirtual printStackTrace : ()V
            //   579: aload_0
            //   580: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   583: aload #12
            //   585: invokestatic a : (Lcom/ss/android/socialbase/downloader/c/e;Ljava/util/List;)V
            //   588: aload_0
            //   589: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   592: aload #12
            //   594: aload #11
            //   596: aload #10
            //   598: aload #7
            //   600: aload #8
            //   602: invokestatic a : (Lcom/ss/android/socialbase/downloader/c/e;Ljava/util/List;Ljava/util/List;Landroid/util/SparseArray;Landroid/util/SparseArray;Landroid/util/SparseArray;)V
            //   605: aload #7
            //   607: ifnull -> 876
            //   610: aload #7
            //   612: monitorenter
            //   613: new java/util/ArrayList
            //   616: dup
            //   617: invokespecial <init> : ()V
            //   620: astore #6
            //   622: iload_3
            //   623: istore_1
            //   624: iload_1
            //   625: aload #7
            //   627: invokevirtual size : ()I
            //   630: if_icmpge -> 758
            //   633: aload #7
            //   635: iload_1
            //   636: invokevirtual keyAt : (I)I
            //   639: istore_2
            //   640: iload_2
            //   641: ifeq -> 1639
            //   644: aload #7
            //   646: iload_2
            //   647: invokevirtual get : (I)Ljava/lang/Object;
            //   650: checkcast com/ss/android/socialbase/downloader/g/c
            //   653: astore #9
            //   655: sipush #8192
            //   658: invokestatic a : (I)Z
            //   661: ifeq -> 716
            //   664: aload #9
            //   666: ifnull -> 1639
            //   669: aload #9
            //   671: invokevirtual aO : ()Z
            //   674: ifne -> 1639
            //   677: aload #9
            //   679: invokevirtual q : ()I
            //   682: bipush #-3
            //   684: if_icmpeq -> 1639
            //   687: aload #6
            //   689: aload #9
            //   691: invokevirtual g : ()I
            //   694: invokestatic valueOf : (I)Ljava/lang/Integer;
            //   697: invokeinterface add : (Ljava/lang/Object;)Z
            //   702: pop
            //   703: aload #8
            //   705: aload #9
            //   707: invokevirtual g : ()I
            //   710: invokevirtual remove : (I)V
            //   713: goto -> 1639
            //   716: aload #9
            //   718: ifnull -> 1639
            //   721: aload #9
            //   723: invokevirtual aO : ()Z
            //   726: ifne -> 1639
            //   729: aload #6
            //   731: aload #9
            //   733: invokevirtual g : ()I
            //   736: invokestatic valueOf : (I)Ljava/lang/Integer;
            //   739: invokeinterface add : (Ljava/lang/Object;)Z
            //   744: pop
            //   745: aload #8
            //   747: aload #9
            //   749: invokevirtual g : ()I
            //   752: invokevirtual remove : (I)V
            //   755: goto -> 1639
            //   758: aload #6
            //   760: invokeinterface iterator : ()Ljava/util/Iterator;
            //   765: astore #6
            //   767: aload #6
            //   769: invokeinterface hasNext : ()Z
            //   774: ifeq -> 798
            //   777: aload #7
            //   779: aload #6
            //   781: invokeinterface next : ()Ljava/lang/Object;
            //   786: checkcast java/lang/Integer
            //   789: invokevirtual intValue : ()I
            //   792: invokevirtual remove : (I)V
            //   795: goto -> 767
            //   798: aload #7
            //   800: monitorexit
            //   801: goto -> 876
            //   804: astore #6
            //   806: aload #7
            //   808: monitorexit
            //   809: aload #6
            //   811: athrow
            //   812: astore #6
            //   814: aload #6
            //   816: invokevirtual printStackTrace : ()V
            //   819: aload_0
            //   820: getfield c : Lcom/ss/android/socialbase/downloader/c/d;
            //   823: astore #6
            //   825: aload #6
            //   827: ifnull -> 903
            //   830: goto -> 887
            //   833: astore #6
            //   835: aload_0
            //   836: getfield c : Lcom/ss/android/socialbase/downloader/c/d;
            //   839: astore #9
            //   841: aload #9
            //   843: ifnull -> 862
            //   846: aload #9
            //   848: invokeinterface a : ()V
            //   853: aload_0
            //   854: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   857: iconst_1
            //   858: invokestatic a : (Lcom/ss/android/socialbase/downloader/c/e;Z)Z
            //   861: pop
            //   862: aload_0
            //   863: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   866: aload #7
            //   868: aload #8
            //   870: invokevirtual a : (Landroid/util/SparseArray;Landroid/util/SparseArray;)V
            //   873: aload #6
            //   875: athrow
            //   876: aload_0
            //   877: getfield c : Lcom/ss/android/socialbase/downloader/c/d;
            //   880: astore #6
            //   882: aload #6
            //   884: ifnull -> 903
            //   887: aload #6
            //   889: invokeinterface a : ()V
            //   894: aload_0
            //   895: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   898: iconst_1
            //   899: invokestatic a : (Lcom/ss/android/socialbase/downloader/c/e;Z)Z
            //   902: pop
            //   903: aload_0
            //   904: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   907: aload #7
            //   909: aload #8
            //   911: invokevirtual a : (Landroid/util/SparseArray;Landroid/util/SparseArray;)V
            //   914: return
            //   915: astore #9
            //   917: aload #9
            //   919: invokevirtual printStackTrace : ()V
            //   922: aload #6
            //   924: ifnull -> 944
            //   927: aload #6
            //   929: invokeinterface close : ()V
            //   934: goto -> 944
            //   937: astore #6
            //   939: aload #6
            //   941: invokevirtual printStackTrace : ()V
            //   944: aload_0
            //   945: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   948: aload #12
            //   950: invokestatic a : (Lcom/ss/android/socialbase/downloader/c/e;Ljava/util/List;)V
            //   953: aload_0
            //   954: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   957: aload #12
            //   959: aload #11
            //   961: aload #10
            //   963: aload #7
            //   965: aload #8
            //   967: invokestatic a : (Lcom/ss/android/socialbase/downloader/c/e;Ljava/util/List;Ljava/util/List;Landroid/util/SparseArray;Landroid/util/SparseArray;Landroid/util/SparseArray;)V
            //   970: aload #7
            //   972: ifnull -> 1242
            //   975: aload #7
            //   977: monitorenter
            //   978: new java/util/ArrayList
            //   981: dup
            //   982: invokespecial <init> : ()V
            //   985: astore #6
            //   987: iload #4
            //   989: istore_1
            //   990: iload_1
            //   991: aload #7
            //   993: invokevirtual size : ()I
            //   996: if_icmpge -> 1124
            //   999: aload #7
            //   1001: iload_1
            //   1002: invokevirtual keyAt : (I)I
            //   1005: istore_2
            //   1006: iload_2
            //   1007: ifeq -> 1646
            //   1010: aload #7
            //   1012: iload_2
            //   1013: invokevirtual get : (I)Ljava/lang/Object;
            //   1016: checkcast com/ss/android/socialbase/downloader/g/c
            //   1019: astore #9
            //   1021: sipush #8192
            //   1024: invokestatic a : (I)Z
            //   1027: ifeq -> 1082
            //   1030: aload #9
            //   1032: ifnull -> 1646
            //   1035: aload #9
            //   1037: invokevirtual aO : ()Z
            //   1040: ifne -> 1646
            //   1043: aload #9
            //   1045: invokevirtual q : ()I
            //   1048: bipush #-3
            //   1050: if_icmpeq -> 1646
            //   1053: aload #6
            //   1055: aload #9
            //   1057: invokevirtual g : ()I
            //   1060: invokestatic valueOf : (I)Ljava/lang/Integer;
            //   1063: invokeinterface add : (Ljava/lang/Object;)Z
            //   1068: pop
            //   1069: aload #8
            //   1071: aload #9
            //   1073: invokevirtual g : ()I
            //   1076: invokevirtual remove : (I)V
            //   1079: goto -> 1646
            //   1082: aload #9
            //   1084: ifnull -> 1646
            //   1087: aload #9
            //   1089: invokevirtual aO : ()Z
            //   1092: ifne -> 1646
            //   1095: aload #6
            //   1097: aload #9
            //   1099: invokevirtual g : ()I
            //   1102: invokestatic valueOf : (I)Ljava/lang/Integer;
            //   1105: invokeinterface add : (Ljava/lang/Object;)Z
            //   1110: pop
            //   1111: aload #8
            //   1113: aload #9
            //   1115: invokevirtual g : ()I
            //   1118: invokevirtual remove : (I)V
            //   1121: goto -> 1646
            //   1124: aload #6
            //   1126: invokeinterface iterator : ()Ljava/util/Iterator;
            //   1131: astore #6
            //   1133: aload #6
            //   1135: invokeinterface hasNext : ()Z
            //   1140: ifeq -> 1164
            //   1143: aload #7
            //   1145: aload #6
            //   1147: invokeinterface next : ()Ljava/lang/Object;
            //   1152: checkcast java/lang/Integer
            //   1155: invokevirtual intValue : ()I
            //   1158: invokevirtual remove : (I)V
            //   1161: goto -> 1133
            //   1164: aload #7
            //   1166: monitorexit
            //   1167: goto -> 1242
            //   1170: astore #6
            //   1172: aload #7
            //   1174: monitorexit
            //   1175: aload #6
            //   1177: athrow
            //   1178: astore #6
            //   1180: aload #6
            //   1182: invokevirtual printStackTrace : ()V
            //   1185: aload_0
            //   1186: getfield c : Lcom/ss/android/socialbase/downloader/c/d;
            //   1189: astore #6
            //   1191: aload #6
            //   1193: ifnull -> 903
            //   1196: goto -> 887
            //   1199: astore #6
            //   1201: aload_0
            //   1202: getfield c : Lcom/ss/android/socialbase/downloader/c/d;
            //   1205: astore #9
            //   1207: aload #9
            //   1209: ifnull -> 1228
            //   1212: aload #9
            //   1214: invokeinterface a : ()V
            //   1219: aload_0
            //   1220: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   1223: iconst_1
            //   1224: invokestatic a : (Lcom/ss/android/socialbase/downloader/c/e;Z)Z
            //   1227: pop
            //   1228: aload_0
            //   1229: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   1232: aload #7
            //   1234: aload #8
            //   1236: invokevirtual a : (Landroid/util/SparseArray;Landroid/util/SparseArray;)V
            //   1239: aload #6
            //   1241: athrow
            //   1242: aload_0
            //   1243: getfield c : Lcom/ss/android/socialbase/downloader/c/d;
            //   1246: astore #6
            //   1248: aload #6
            //   1250: ifnull -> 903
            //   1253: goto -> 887
            //   1256: astore #9
            //   1258: aload #6
            //   1260: ifnull -> 1280
            //   1263: aload #6
            //   1265: invokeinterface close : ()V
            //   1270: goto -> 1280
            //   1273: astore #6
            //   1275: aload #6
            //   1277: invokevirtual printStackTrace : ()V
            //   1280: aload_0
            //   1281: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   1284: aload #12
            //   1286: invokestatic a : (Lcom/ss/android/socialbase/downloader/c/e;Ljava/util/List;)V
            //   1289: aload_0
            //   1290: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   1293: aload #12
            //   1295: aload #11
            //   1297: aload #10
            //   1299: aload #7
            //   1301: aload #8
            //   1303: invokestatic a : (Lcom/ss/android/socialbase/downloader/c/e;Ljava/util/List;Ljava/util/List;Landroid/util/SparseArray;Landroid/util/SparseArray;Landroid/util/SparseArray;)V
            //   1306: aload #7
            //   1308: ifnull -> 1578
            //   1311: aload #7
            //   1313: monitorenter
            //   1314: new java/util/ArrayList
            //   1317: dup
            //   1318: invokespecial <init> : ()V
            //   1321: astore #6
            //   1323: iload #5
            //   1325: istore_1
            //   1326: iload_1
            //   1327: aload #7
            //   1329: invokevirtual size : ()I
            //   1332: if_icmpge -> 1460
            //   1335: aload #7
            //   1337: iload_1
            //   1338: invokevirtual keyAt : (I)I
            //   1341: istore_2
            //   1342: iload_2
            //   1343: ifeq -> 1653
            //   1346: aload #7
            //   1348: iload_2
            //   1349: invokevirtual get : (I)Ljava/lang/Object;
            //   1352: checkcast com/ss/android/socialbase/downloader/g/c
            //   1355: astore #10
            //   1357: sipush #8192
            //   1360: invokestatic a : (I)Z
            //   1363: ifeq -> 1418
            //   1366: aload #10
            //   1368: ifnull -> 1653
            //   1371: aload #10
            //   1373: invokevirtual aO : ()Z
            //   1376: ifne -> 1653
            //   1379: aload #10
            //   1381: invokevirtual q : ()I
            //   1384: bipush #-3
            //   1386: if_icmpeq -> 1653
            //   1389: aload #6
            //   1391: aload #10
            //   1393: invokevirtual g : ()I
            //   1396: invokestatic valueOf : (I)Ljava/lang/Integer;
            //   1399: invokeinterface add : (Ljava/lang/Object;)Z
            //   1404: pop
            //   1405: aload #8
            //   1407: aload #10
            //   1409: invokevirtual g : ()I
            //   1412: invokevirtual remove : (I)V
            //   1415: goto -> 1653
            //   1418: aload #10
            //   1420: ifnull -> 1653
            //   1423: aload #10
            //   1425: invokevirtual aO : ()Z
            //   1428: ifne -> 1653
            //   1431: aload #6
            //   1433: aload #10
            //   1435: invokevirtual g : ()I
            //   1438: invokestatic valueOf : (I)Ljava/lang/Integer;
            //   1441: invokeinterface add : (Ljava/lang/Object;)Z
            //   1446: pop
            //   1447: aload #8
            //   1449: aload #10
            //   1451: invokevirtual g : ()I
            //   1454: invokevirtual remove : (I)V
            //   1457: goto -> 1653
            //   1460: aload #6
            //   1462: invokeinterface iterator : ()Ljava/util/Iterator;
            //   1467: astore #6
            //   1469: aload #6
            //   1471: invokeinterface hasNext : ()Z
            //   1476: ifeq -> 1500
            //   1479: aload #7
            //   1481: aload #6
            //   1483: invokeinterface next : ()Ljava/lang/Object;
            //   1488: checkcast java/lang/Integer
            //   1491: invokevirtual intValue : ()I
            //   1494: invokevirtual remove : (I)V
            //   1497: goto -> 1469
            //   1500: aload #7
            //   1502: monitorexit
            //   1503: goto -> 1578
            //   1506: astore #6
            //   1508: aload #7
            //   1510: monitorexit
            //   1511: aload #6
            //   1513: athrow
            //   1514: astore #6
            //   1516: aload #6
            //   1518: invokevirtual printStackTrace : ()V
            //   1521: aload_0
            //   1522: getfield c : Lcom/ss/android/socialbase/downloader/c/d;
            //   1525: astore #6
            //   1527: aload #6
            //   1529: ifnull -> 1605
            //   1532: goto -> 1589
            //   1535: astore #6
            //   1537: aload_0
            //   1538: getfield c : Lcom/ss/android/socialbase/downloader/c/d;
            //   1541: astore #9
            //   1543: aload #9
            //   1545: ifnull -> 1564
            //   1548: aload #9
            //   1550: invokeinterface a : ()V
            //   1555: aload_0
            //   1556: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   1559: iconst_1
            //   1560: invokestatic a : (Lcom/ss/android/socialbase/downloader/c/e;Z)Z
            //   1563: pop
            //   1564: aload_0
            //   1565: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   1568: aload #7
            //   1570: aload #8
            //   1572: invokevirtual a : (Landroid/util/SparseArray;Landroid/util/SparseArray;)V
            //   1575: aload #6
            //   1577: athrow
            //   1578: aload_0
            //   1579: getfield c : Lcom/ss/android/socialbase/downloader/c/d;
            //   1582: astore #6
            //   1584: aload #6
            //   1586: ifnull -> 1605
            //   1589: aload #6
            //   1591: invokeinterface a : ()V
            //   1596: aload_0
            //   1597: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   1600: iconst_1
            //   1601: invokestatic a : (Lcom/ss/android/socialbase/downloader/c/e;Z)Z
            //   1604: pop
            //   1605: aload_0
            //   1606: getfield d : Lcom/ss/android/socialbase/downloader/c/e;
            //   1609: aload #7
            //   1611: aload #8
            //   1613: invokevirtual a : (Landroid/util/SparseArray;Landroid/util/SparseArray;)V
            //   1616: aload #9
            //   1618: athrow
            //   1619: iconst_1
            //   1620: istore_1
            //   1621: goto -> 360
            //   1624: iconst_0
            //   1625: istore_1
            //   1626: goto -> 360
            //   1629: iconst_1
            //   1630: istore_2
            //   1631: goto -> 407
            //   1634: iconst_0
            //   1635: istore_1
            //   1636: goto -> 488
            //   1639: iload_1
            //   1640: iconst_1
            //   1641: iadd
            //   1642: istore_1
            //   1643: goto -> 624
            //   1646: iload_1
            //   1647: iconst_1
            //   1648: iadd
            //   1649: istore_1
            //   1650: goto -> 990
            //   1653: iload_1
            //   1654: iconst_1
            //   1655: iadd
            //   1656: istore_1
            //   1657: goto -> 1326
            // Exception table:
            //   from	to	target	type
            //   105	116	915	finally
            //   120	130	915	finally
            //   134	145	915	finally
            //   149	157	915	finally
            //   161	168	915	finally
            //   172	183	915	finally
            //   187	198	915	finally
            //   205	224	915	finally
            //   228	236	915	finally
            //   240	249	915	finally
            //   253	263	915	finally
            //   270	280	915	finally
            //   284	292	915	finally
            //   296	301	915	finally
            //   308	317	915	finally
            //   321	331	915	finally
            //   335	345	915	finally
            //   349	357	915	finally
            //   366	374	915	finally
            //   380	390	915	finally
            //   396	404	915	finally
            //   415	431	915	finally
            //   435	445	915	finally
            //   452	458	915	finally
            //   467	485	915	finally
            //   497	503	915	finally
            //   507	515	915	finally
            //   524	527	915	finally
            //   527	542	545	finally
            //   547	550	545	finally
            //   554	557	915	finally
            //   562	569	572	finally
            //   610	613	812	finally
            //   613	622	804	finally
            //   624	640	804	finally
            //   644	664	804	finally
            //   669	713	804	finally
            //   721	755	804	finally
            //   758	767	804	finally
            //   767	795	804	finally
            //   798	801	804	finally
            //   806	809	804	finally
            //   809	812	812	finally
            //   814	819	833	finally
            //   917	922	1256	finally
            //   927	934	937	finally
            //   975	978	1178	finally
            //   978	987	1170	finally
            //   990	1006	1170	finally
            //   1010	1030	1170	finally
            //   1035	1079	1170	finally
            //   1087	1121	1170	finally
            //   1124	1133	1170	finally
            //   1133	1161	1170	finally
            //   1164	1167	1170	finally
            //   1172	1175	1170	finally
            //   1175	1178	1178	finally
            //   1180	1185	1199	finally
            //   1263	1270	1273	finally
            //   1311	1314	1514	finally
            //   1314	1323	1506	finally
            //   1326	1342	1506	finally
            //   1346	1366	1506	finally
            //   1371	1415	1506	finally
            //   1423	1457	1506	finally
            //   1460	1469	1506	finally
            //   1469	1497	1506	finally
            //   1500	1503	1506	finally
            //   1508	1511	1506	finally
            //   1511	1514	1514	finally
            //   1516	1521	1535	finally
          }
        };
      ExecutorService executorService = b.m();
    } finally {
      paramSparseArray = null;
    } 
  }
  
  public void a(b paramb) {
    this.a = paramb;
  }
  
  public void a(b paramb) {
    f();
    if (b != null) {
      if (this.d == null)
        return; 
      if (f.d()) {
        ExecutorService executorService = b.m();
        if (executorService == null)
          return; 
        executorService.execute(new Runnable(this, paramb) {
              public void run() {
                try {
                  return;
                } finally {
                  Exception exception = null;
                  exception.printStackTrace();
                } 
              }
            });
        return;
      } 
      try {
        return;
      } finally {
        paramb = null;
      } 
    } 
  }
  
  public boolean a(int paramInt) {
    boolean bool = false;
    try {
      return bool;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public boolean a(c paramc) {
    f();
    if (paramc != null) {
      if (b == null)
        return false; 
      if (f.d()) {
        ExecutorService executorService = b.m();
        if (executorService == null)
          return false; 
        executorService.execute(new Runnable(this, paramc) {
              public void run() {
                e.a(this.b, this.a);
              }
            });
      } else {
        d(paramc);
      } 
      return true;
    } 
    return false;
  }
  
  public c b(int paramInt) {
    f();
    if (b != null) {
      Cursor cursor;
      try {
        cursor = b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[] { "downloader", "_id" }), new String[] { Integer.toString(paramInt) });
      } finally {
        null = null;
      } 
      try {
        null.printStackTrace();
      } finally {
        if (cursor != null)
          try {
            cursor.close();
          } finally {
            cursor = null;
          }  
      } 
    } 
    return null;
  }
  
  public c b(int paramInt, long paramLong) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("status", Integer.valueOf(-1));
    contentValues.put("curBytes", Long.valueOf(paramLong));
    if (paramLong > 0L)
      contentValues.put("isFirstDownload", Integer.valueOf(0)); 
    a(paramInt, contentValues);
    return null;
  }
  
  public List<c> b(String paramString) {
    return null;
  }
  
  public void b() {
    f();
    if (b == null)
      return; 
    if (f.d()) {
      ExecutorService executorService = b.m();
      if (executorService == null)
        return; 
      executorService.execute(new Runnable(this) {
            public void run() {
              e.d(this.a);
            }
          });
      return;
    } 
    i();
  }
  
  public void b(int paramInt, List<b> paramList) {
    try {
      d(paramInt);
    } finally {
      paramList = null;
    } 
  }
  
  public void b(b paramb) {
    a(paramb);
  }
  
  public void b(c paramc) {}
  
  public c c(int paramInt, long paramLong) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("status", Integer.valueOf(-3));
    contentValues.put("curBytes", Long.valueOf(paramLong));
    Integer integer = Integer.valueOf(0);
    contentValues.put("isFirstDownload", integer);
    contentValues.put("isFirstSuccess", integer);
    a(paramInt, contentValues);
    return null;
  }
  
  public List<b> c(int paramInt) {
    ArrayList<b> arrayList = new ArrayList();
    f();
    if (b != null) {
      Cursor cursor = null;
      try {
        Cursor cursor1 = b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[] { "downloadChunk", "_id" }), new String[] { Integer.toString(paramInt) });
        while (true) {
          cursor = cursor1;
          if (cursor1.moveToNext()) {
            cursor = cursor1;
            arrayList.add(new b(cursor1));
            continue;
          } 
          if (cursor1 != null)
            try {
              return arrayList;
            } finally {
              cursor = null;
              cursor.printStackTrace();
            }  
          break;
        } 
      } finally {
        null = null;
      } 
    } 
    return arrayList;
  }
  
  public List<c> c(String paramString) {
    return null;
  }
  
  public boolean c() {
    return this.e;
  }
  
  public c d(int paramInt, long paramLong) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("status", Integer.valueOf(-2));
    contentValues.put("curBytes", Long.valueOf(paramLong));
    a(paramInt, contentValues);
    return null;
  }
  
  public List<c> d(String paramString) {
    return null;
  }
  
  public void d(int paramInt) {
    f();
    if (b != null) {
      if (this.d == null)
        return; 
      if (f.d()) {
        ExecutorService executorService = b.m();
        if (executorService == null)
          return; 
        executorService.execute(new Runnable(this, paramInt) {
              public void run() {
                try {
                  return;
                } finally {
                  Exception exception = null;
                  exception.printStackTrace();
                } 
              }
            });
        return;
      } 
      try {
        return;
      } finally {
        Exception exception = null;
      } 
    } 
  }
  
  public boolean d() {
    return false;
  }
  
  public c e(int paramInt, long paramLong) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("status", Integer.valueOf(-4));
    contentValues.put("curBytes", Long.valueOf(paramLong));
    a(paramInt, contentValues);
    return null;
  }
  
  public boolean e(int paramInt) {
    f();
    if (b != null) {
      g g1 = this.c;
      if (g1 == null)
        return false; 
      try {
        return true;
      } finally {
        g1 = null;
      } 
    } 
    return false;
  }
  
  public boolean f(int paramInt) {
    if (f.d()) {
      ExecutorService executorService = b.m();
      if (executorService == null)
        return false; 
      executorService.execute(new Runnable(this, paramInt) {
            public void run() {
              this.b.e(this.a);
              this.b.d(this.a);
            }
          });
    } else {
      e(paramInt);
      d(paramInt);
    } 
    return true;
  }
  
  public c g(int paramInt) {
    return null;
  }
  
  public c h(int paramInt) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("status", Integer.valueOf(5));
    contentValues.put("isFirstDownload", Integer.valueOf(0));
    a(paramInt, contentValues);
    return null;
  }
  
  public c i(int paramInt) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("status", Integer.valueOf(1));
    a(paramInt, contentValues);
    return null;
  }
  
  public c j(int paramInt) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("status", Integer.valueOf(-7));
    a(paramInt, contentValues);
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */