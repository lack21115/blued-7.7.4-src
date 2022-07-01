package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

class u {
  private Context a;
  
  private ba b = null;
  
  private String c = "/sdcard/Amap/RMap";
  
  private final int d = 128;
  
  public u(Context paramContext, boolean paramBoolean, an paraman) {
    this.a = paramContext;
    if (paraman == null)
      return; 
    if (paramBoolean == true) {
      this.c = paramContext.getFilesDir().getPath();
    } else {
      boolean bool = false;
      paramBoolean = bool;
      if (paraman.m != null) {
        paramBoolean = bool;
        if (!paraman.m.equals("")) {
          File file = new File(paraman.m);
          paramBoolean = file.exists();
          if (!paramBoolean)
            paramBoolean = file.mkdirs(); 
          this.c = paraman.m;
        } 
      } 
      if (!paramBoolean)
        this.c = a(this.a, this.c, paraman); 
    } 
    bg.a().b("cache_path", this.c);
  }
  
  private int a(int paramInt1, int paramInt2) {
    return paramInt1 % 128 * 128 + paramInt2 % 128;
  }
  
  public static String a(Context paramContext, String paramString, an paraman) {
    if (!Environment.getExternalStorageState().equals("mounted"))
      return paramContext.getFilesDir().getPath(); 
    File file = new File(cm.b(paramContext), paraman.b);
    if (!file.exists())
      file.mkdir(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(file.toString());
    stringBuilder.append("/");
    return stringBuilder.toString();
  }
  
  public static void a(String paramString) {
    (new Thread(new Runnable(paramString) {
          public void run() {
            try {
              return;
            } finally {
              Exception exception = null;
              exception.printStackTrace();
            } 
          }
        })).start();
  }
  
  private void a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null) {
      if (paramArrayOfbyte.length != 4)
        return; 
      byte b = paramArrayOfbyte[0];
      paramArrayOfbyte[0] = paramArrayOfbyte[3];
      paramArrayOfbyte[3] = b;
      b = paramArrayOfbyte[1];
      paramArrayOfbyte[1] = paramArrayOfbyte[2];
      paramArrayOfbyte[2] = b;
    } 
  }
  
  private byte[] a(int paramInt) {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)((0xFF00 & paramInt) >> 8), (byte)((0xFF0000 & paramInt) >> 16), (byte)((paramInt & 0xFF000000) >> 24) };
  }
  
  private String[] a(bs parambs, boolean paramBoolean) {
    int j = parambs.b / 128;
    int i = parambs.c / 128;
    j /= 10;
    i /= 10;
    String[] arrayOfString = new String[2];
    try {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.c);
      stringBuilder2.append("/");
      stringBuilder2.append(parambs.d);
      stringBuilder2.append("/");
      stringBuilder2.append(j);
      stringBuilder2.append("/");
      stringBuilder2.append(i);
      stringBuilder2.append("/");
      if (!paramBoolean) {
        File file = new File(stringBuilder2.toString());
        if (!file.exists())
          file.mkdirs(); 
      } 
      stringBuilder2.append(parambs.c());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder1.append(".idx");
      arrayOfString[0] = stringBuilder1.toString();
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(stringBuilder2.toString());
      return arrayOfString;
    } finally {
      parambs = null;
      cm.a((Throwable)parambs, "CachManager", "getCachFileName");
    } 
  }
  
  private int b(byte[] paramArrayOfbyte) {
    byte b1 = paramArrayOfbyte[0];
    byte b2 = paramArrayOfbyte[1];
    byte b3 = paramArrayOfbyte[2];
    return paramArrayOfbyte[3] << 24 & 0xFF000000 | b1 & 0xFF | b2 << 8 & 0xFF00 | b3 << 16 & 0xFF0000;
  }
  
  public static boolean b(String paramString) {
    File file = new File(paramString);
    return !file.exists() ? false : (file.isFile() ? c(paramString) : d(paramString));
  }
  
  public static boolean c(String paramString) {
    File file = new File(paramString);
    if (file.isFile() && file.exists()) {
      file.delete();
      return true;
    } 
    return false;
  }
  
  public static boolean d(String paramString) {
    String str = paramString;
    if (!paramString.endsWith(File.separator)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(File.separator);
      str = stringBuilder.toString();
    } 
    File file = new File(str);
    if (file.exists()) {
      if (!file.isDirectory())
        return false; 
      File[] arrayOfFile = file.listFiles();
      int i = 0;
      boolean bool = true;
      while (i < arrayOfFile.length) {
        if (arrayOfFile[i].isFile()) {
          boolean bool1 = c(arrayOfFile[i].getAbsolutePath());
          bool = bool1;
          if (!bool1) {
            bool = bool1;
            break;
          } 
        } else {
          boolean bool1 = d(arrayOfFile[i].getAbsolutePath());
          bool = bool1;
          if (!bool1) {
            bool = bool1;
            break;
          } 
        } 
        i++;
      } 
      if (!bool)
        return false; 
      if (file.delete())
        return true; 
    } 
    return false;
  }
  
  public int a(bs parambs) {
    byte[] arrayOfByte1;
    String[] arrayOfString;
    File file2;
    byte[] arrayOfByte2;
    try {
    
    } finally {
      parambs = null;
      cm.a((Throwable)parambs, "CachManager", "getTileFromCach");
    } 
    if (null < 0)
      return -1; 
    File file1 = new File(arrayOfString[1]);
    boolean bool = file1.exists();
    if (!bool)
      return -1; 
    try {
      RandomAccessFile randomAccessFile = new RandomAccessFile(file1, "r");
    } catch (FileNotFoundException fileNotFoundException) {
      cm.a(fileNotFoundException, "CachManager", "getTileFromCach");
      arrayOfString = null;
    } 
    if (arrayOfString == null)
      return -1; 
    long l = null;
    try {
      arrayOfString.seek(l);
    } catch (IOException iOException1) {
      cm.a(iOException1, "CachManager", "getTileFromCach");
    } 
    try {
      arrayOfString.read(arrayOfByte2, 0, 4);
    } catch (IOException iOException1) {
      cm.a(iOException1, "CachManager", "getTileFromCach");
    } 
    a(arrayOfByte2);
    null = b(arrayOfByte2);
    if (null <= 0 || null > 204800) {
      try {
        arrayOfString.close();
        return -1;
      } catch (IOException iOException) {
        cm.a(iOException, "CachManager", "getTileFromCach");
      } 
      return -1;
    } 
    file1 = file2;
    try {
      byte[] arrayOfByte = new byte[null];
      arrayOfByte1 = arrayOfByte;
      arrayOfString.read(arrayOfByte, 0, null);
    } finally {
      file2 = null;
    } 
    try {
      arrayOfString.close();
    } catch (IOException iOException1) {
      cm.a(iOException1, "CachManager", "getTileFromCach");
    } 
    return (this.b == null) ? -1 : this.b.a(arrayOfByte1, null, true, null, iOException.c());
  }
  
  public void a(ba paramba) {
    this.b = paramba;
  }
  
  public boolean a(byte[] paramArrayOfbyte, bs parambs) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_1
    //   11: arraylength
    //   12: istore_3
    //   13: iload_3
    //   14: ifgt -> 21
    //   17: aload_0
    //   18: monitorexit
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: aload_2
    //   23: iconst_0
    //   24: invokespecial a : (Lcom/amap/api/mapcore2d/bs;Z)[Ljava/lang/String;
    //   27: astore #10
    //   29: aload #10
    //   31: ifnull -> 541
    //   34: aload #10
    //   36: arraylength
    //   37: iconst_2
    //   38: if_icmpne -> 541
    //   41: aload #10
    //   43: iconst_0
    //   44: aaload
    //   45: ldc ''
    //   47: invokevirtual equals : (Ljava/lang/Object;)Z
    //   50: ifne -> 541
    //   53: aload #10
    //   55: aload #10
    //   57: arraylength
    //   58: anewarray java/lang/String
    //   61: invokestatic equals : ([Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   64: ifeq -> 70
    //   67: goto -> 541
    //   70: new java/io/File
    //   73: dup
    //   74: aload #10
    //   76: iconst_1
    //   77: aaload
    //   78: invokespecial <init> : (Ljava/lang/String;)V
    //   81: astore #9
    //   83: aload #9
    //   85: invokevirtual exists : ()Z
    //   88: istore #4
    //   90: iload #4
    //   92: ifne -> 128
    //   95: aload #9
    //   97: invokevirtual createNewFile : ()Z
    //   100: istore #4
    //   102: goto -> 119
    //   105: astore #11
    //   107: aload #11
    //   109: ldc 'CachManager'
    //   111: ldc 'addDataToCach'
    //   113: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   116: iconst_0
    //   117: istore #4
    //   119: iload #4
    //   121: ifne -> 128
    //   124: aload_0
    //   125: monitorexit
    //   126: iconst_0
    //   127: ireturn
    //   128: new java/io/RandomAccessFile
    //   131: dup
    //   132: aload #9
    //   134: ldc 'rws'
    //   136: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   139: astore #9
    //   141: goto -> 158
    //   144: astore #9
    //   146: aload #9
    //   148: ldc 'CachManager'
    //   150: ldc 'addDataToCach'
    //   152: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   155: aconst_null
    //   156: astore #9
    //   158: aload #9
    //   160: ifnonnull -> 167
    //   163: aload_0
    //   164: monitorexit
    //   165: iconst_0
    //   166: ireturn
    //   167: aload_0
    //   168: iload_3
    //   169: invokespecial a : (I)[B
    //   172: astore #11
    //   174: aload_0
    //   175: aload #11
    //   177: invokespecial a : ([B)V
    //   180: aload #9
    //   182: invokevirtual length : ()J
    //   185: lstore #5
    //   187: goto -> 204
    //   190: astore #12
    //   192: aload #12
    //   194: ldc 'CachManager'
    //   196: ldc 'addDataToCach'
    //   198: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   201: lconst_0
    //   202: lstore #5
    //   204: aload #9
    //   206: lload #5
    //   208: invokevirtual seek : (J)V
    //   211: goto -> 225
    //   214: astore #12
    //   216: aload #12
    //   218: ldc 'CachManager'
    //   220: ldc 'addDataToCach'
    //   222: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload #9
    //   227: aload #11
    //   229: invokevirtual write : ([B)V
    //   232: goto -> 246
    //   235: astore #11
    //   237: aload #11
    //   239: ldc 'CachManager'
    //   241: ldc 'addDataToCach'
    //   243: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   246: aload #9
    //   248: aload_1
    //   249: invokevirtual write : ([B)V
    //   252: goto -> 264
    //   255: astore_1
    //   256: aload_1
    //   257: ldc 'CachManager'
    //   259: ldc 'addDataToCach'
    //   261: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload #9
    //   266: invokevirtual close : ()V
    //   269: goto -> 281
    //   272: astore_1
    //   273: aload_1
    //   274: ldc 'CachManager'
    //   276: ldc 'addDataToCach'
    //   278: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   281: new java/io/File
    //   284: dup
    //   285: aload #10
    //   287: iconst_0
    //   288: aaload
    //   289: invokespecial <init> : (Ljava/lang/String;)V
    //   292: astore_1
    //   293: aload_1
    //   294: invokevirtual exists : ()Z
    //   297: istore #4
    //   299: iload #4
    //   301: ifne -> 336
    //   304: aload_1
    //   305: invokevirtual createNewFile : ()Z
    //   308: istore #4
    //   310: goto -> 327
    //   313: astore #9
    //   315: aload #9
    //   317: ldc 'CachManager'
    //   319: ldc 'addDataToCach'
    //   321: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   324: iconst_0
    //   325: istore #4
    //   327: iload #4
    //   329: ifne -> 336
    //   332: aload_0
    //   333: monitorexit
    //   334: iconst_0
    //   335: ireturn
    //   336: new java/io/RandomAccessFile
    //   339: dup
    //   340: aload_1
    //   341: ldc 'rws'
    //   343: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   346: astore_1
    //   347: goto -> 361
    //   350: astore_1
    //   351: aload_1
    //   352: ldc 'CachManager'
    //   354: ldc 'addDataToCach'
    //   356: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   359: aconst_null
    //   360: astore_1
    //   361: aload_1
    //   362: ifnonnull -> 369
    //   365: aload_0
    //   366: monitorexit
    //   367: iconst_0
    //   368: ireturn
    //   369: aload_1
    //   370: invokevirtual length : ()J
    //   373: lstore #7
    //   375: goto -> 392
    //   378: astore #9
    //   380: aload #9
    //   382: ldc 'CachManager'
    //   384: ldc 'addDataToCach'
    //   386: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   389: lconst_0
    //   390: lstore #7
    //   392: lload #7
    //   394: lconst_0
    //   395: lcmp
    //   396: ifne -> 431
    //   399: ldc 65536
    //   401: newarray byte
    //   403: astore #9
    //   405: aload #9
    //   407: iconst_m1
    //   408: invokestatic fill : ([BB)V
    //   411: aload_1
    //   412: aload #9
    //   414: invokevirtual write : ([B)V
    //   417: goto -> 431
    //   420: astore #9
    //   422: aload #9
    //   424: ldc 'CachManager'
    //   426: ldc 'addDataToCach'
    //   428: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload_0
    //   432: aload_2
    //   433: getfield b : I
    //   436: aload_2
    //   437: getfield c : I
    //   440: invokespecial a : (II)I
    //   443: istore_3
    //   444: iload_3
    //   445: ifge -> 468
    //   448: aload_1
    //   449: invokevirtual close : ()V
    //   452: goto -> 464
    //   455: astore_1
    //   456: aload_1
    //   457: ldc 'CachManager'
    //   459: ldc 'addDataToCach'
    //   461: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   464: aload_0
    //   465: monitorexit
    //   466: iconst_0
    //   467: ireturn
    //   468: iload_3
    //   469: iconst_4
    //   470: imul
    //   471: i2l
    //   472: lstore #7
    //   474: aload_1
    //   475: lload #7
    //   477: invokevirtual seek : (J)V
    //   480: goto -> 492
    //   483: astore_2
    //   484: aload_2
    //   485: ldc 'CachManager'
    //   487: ldc 'addDataToCach'
    //   489: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   492: aload_0
    //   493: lload #5
    //   495: l2i
    //   496: invokespecial a : (I)[B
    //   499: astore_2
    //   500: aload_0
    //   501: aload_2
    //   502: invokespecial a : ([B)V
    //   505: aload_1
    //   506: aload_2
    //   507: invokevirtual write : ([B)V
    //   510: goto -> 522
    //   513: astore_2
    //   514: aload_2
    //   515: ldc 'CachManager'
    //   517: ldc 'addDataToCach'
    //   519: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   522: aload_1
    //   523: invokevirtual close : ()V
    //   526: goto -> 554
    //   529: astore_1
    //   530: aload_1
    //   531: ldc 'CachManager'
    //   533: ldc 'addDataToCach'
    //   535: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   538: goto -> 554
    //   541: aload_0
    //   542: monitorexit
    //   543: iconst_0
    //   544: ireturn
    //   545: astore_1
    //   546: aload_1
    //   547: ldc 'CachManager'
    //   549: ldc 'addDataToCach'
    //   551: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   554: aload_0
    //   555: monitorexit
    //   556: iconst_1
    //   557: ireturn
    //   558: astore_1
    //   559: aload_0
    //   560: monitorexit
    //   561: aload_1
    //   562: athrow
    // Exception table:
    //   from	to	target	type
    //   10	13	558	finally
    //   21	29	545	finally
    //   34	67	545	finally
    //   70	90	545	finally
    //   95	102	105	finally
    //   107	116	545	finally
    //   128	141	144	finally
    //   146	155	545	finally
    //   167	180	545	finally
    //   180	187	190	finally
    //   192	201	545	finally
    //   204	211	214	finally
    //   216	225	545	finally
    //   225	232	235	finally
    //   237	246	545	finally
    //   246	252	255	finally
    //   256	264	545	finally
    //   264	269	272	finally
    //   273	281	545	finally
    //   281	299	545	finally
    //   304	310	313	java/io/IOException
    //   304	310	545	finally
    //   315	324	545	finally
    //   336	347	350	finally
    //   351	359	545	finally
    //   369	375	378	finally
    //   380	389	545	finally
    //   399	417	420	finally
    //   422	431	545	finally
    //   431	444	545	finally
    //   448	452	455	finally
    //   456	464	545	finally
    //   474	480	483	finally
    //   484	492	545	finally
    //   492	505	545	finally
    //   505	510	513	finally
    //   514	522	545	finally
    //   522	526	529	finally
    //   530	538	545	finally
    //   546	554	558	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */