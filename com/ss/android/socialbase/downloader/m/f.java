package com.ss.android.socialbase.downloader.m;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.b.h;
import com.ss.android.socialbase.downloader.b.i;
import com.ss.android.socialbase.downloader.d.ae;
import com.ss.android.socialbase.downloader.d.x;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.e.c;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.g.b;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.i.c;
import com.ss.android.socialbase.downloader.impls.l;
import com.ss.android.socialbase.downloader.k.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class f {
  private static final String a = f.class.getSimpleName();
  
  private static final Pattern b = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
  
  private static String c = null;
  
  private static volatile SparseArray<Boolean> d = new SparseArray();
  
  private static volatile SparseArray<List<ae>> e = new SparseArray();
  
  private static final char[] f = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  private static Pattern g = null;
  
  private static Pattern h = null;
  
  private static Boolean i;
  
  private static Boolean j;
  
  public static double a(long paramLong) {
    return paramLong / 1048576.0D;
  }
  
  public static long a(c paramc) {
    if (paramc == null)
      return -1L; 
    String str = paramc.a("Content-Length");
    if (TextUtils.isEmpty(str) && c.a(1))
      return b(paramc); 
    try {
      return Long.parseLong(str);
    } catch (NumberFormatException numberFormatException) {
      return -1L;
    } 
  }
  
  public static long a(String paramString) {
    if (paramString == null)
      return -1L; 
    String[] arrayOfString = paramString.split("/");
    if (arrayOfString.length >= 2)
      try {
        return Long.parseLong(arrayOfString[1]);
      } catch (NumberFormatException numberFormatException) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("parse instance length failed with ");
        stringBuilder.append(paramString);
        a.d(str, stringBuilder.toString());
      }  
    return -1L;
  }
  
  private static i a(File paramFile, String paramString) {
    if (TextUtils.isEmpty(paramString))
      return i.a; 
    String str = b.a(paramFile);
    return TextUtils.isEmpty(str) ? i.c : (!str.equals(paramString) ? i.d : i.a);
  }
  
  public static i a(String paramString1, String paramString2, String paramString3) {
    if (TextUtils.isEmpty(paramString3))
      return i.a; 
    File file = new File(paramString1, paramString2);
    if (!file.exists())
      return i.b; 
    String str = b.a(file);
    return TextUtils.isEmpty(str) ? i.c : (!str.equals(paramString3) ? i.d : i.a);
  }
  
  public static com.ss.android.socialbase.downloader.g.f a(String paramString1, String paramString2, int paramInt) throws a {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
      File file = new File(paramString1, paramString2);
      if (!file.exists() || !file.isDirectory()) {
        if (!file.exists())
          try {
            File file1 = new File(paramString1);
            if (!file1.exists() || !file1.isDirectory())
              if (!file1.exists()) {
                if (!file1.mkdirs())
                  throw new a(1030, "download savePath directory can not created"); 
              } else {
                file1.delete();
                throw new a(1031, "download savePath is not directory");
              }  
            file.createNewFile();
          } catch (IOException iOException) {
            throw new a(1036, iOException);
          }  
        return new com.ss.android.socialbase.downloader.g.f(file, paramInt);
      } 
      throw new a(1035, new IOException(String.format("path is :%s, path is directory:%B:", new Object[] { iOException, Boolean.valueOf(file.isDirectory()) })));
    } 
    throw new a(1021, new IOException("path must be not empty"));
  }
  
  public static String a(c paramc, String paramString) {
    String str2 = g(paramc.a("Content-Disposition"));
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = d(paramString); 
    return str1;
  }
  
  public static String a(String paramString1, String paramString2) {
    return (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) ? null : String.format("%s%s%s", new Object[] { paramString1, File.separator, paramString2 });
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null)
      return a(paramArrayOfbyte, 0, paramArrayOfbyte.length); 
    throw new NullPointerException("bytes is null");
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramArrayOfbyte != null) {
      if (paramInt1 >= 0 && paramInt1 + paramInt2 <= paramArrayOfbyte.length) {
        int k = paramInt2 * 2;
        char[] arrayOfChar = new char[k];
        int i = 0;
        int j = 0;
        while (i < paramInt2) {
          int m = paramArrayOfbyte[i + paramInt1] & 0xFF;
          int n = j + 1;
          char[] arrayOfChar1 = f;
          arrayOfChar[j] = arrayOfChar1[m >> 4];
          j = n + 1;
          arrayOfChar[n] = arrayOfChar1[m & 0xF];
          i++;
        } 
        return new String(arrayOfChar, 0, k);
      } 
      throw new IndexOutOfBoundsException();
    } 
    throw new NullPointerException("bytes is null");
  }
  
  public static <K> HashMap<Integer, K> a(SparseArray<K> paramSparseArray) {
    if (paramSparseArray == null)
      return null; 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int j = paramSparseArray.size();
    for (int i = 0; i < j; i++)
      hashMap.put(Integer.valueOf(paramSparseArray.keyAt(i)), paramSparseArray.valueAt(i)); 
    return (HashMap)hashMap;
  }
  
  public static List<b> a(List<b> paramList) {
    SparseArray sparseArray1 = new SparseArray();
    SparseArray sparseArray2 = new SparseArray();
    for (b b1 : paramList) {
      if (b1 == null)
        continue; 
      if (b1.d()) {
        sparseArray1.put(b1.s(), b1);
        List list = (List)sparseArray2.get(b1.s());
        if (list != null) {
          Iterator<b> iterator = list.iterator();
          while (iterator.hasNext())
            ((b)iterator.next()).a(b1); 
          b1.a(list);
        } 
        continue;
      } 
      b b2 = (b)sparseArray1.get(b1.b());
      if (b2 != null) {
        List<b> list4 = b2.g();
        List<b> list3 = list4;
        if (list4 == null) {
          list3 = new ArrayList();
          b2.a(list3);
        } 
        b1.a(b2);
        list3.add(b1);
        continue;
      } 
      List<b> list2 = (List)sparseArray2.get(b1.b());
      List<b> list1 = list2;
      if (list2 == null) {
        list1 = new ArrayList();
        sparseArray2.put(b1.b(), list1);
      } 
      list1.add(b1);
    } 
    ArrayList<Object> arrayList = new ArrayList();
    for (int i = 0; i < sparseArray1.size(); i++)
      arrayList.add(sparseArray1.get(sparseArray1.keyAt(i))); 
    return arrayList.isEmpty() ? paramList : arrayList;
  }
  
  public static List<e> a(List<e> paramList, String paramString, long paramLong1, long paramLong2) {
    ArrayList<e> arrayList = new ArrayList();
    if (paramList != null && paramList.size() > 0)
      for (e e : paramList) {
        if (e != null)
          arrayList.add(e); 
      }  
    if (!TextUtils.isEmpty(paramString))
      arrayList.add(new e("If-Match", paramString)); 
    arrayList.add(new e("Accept-Encoding", "identity"));
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("range CurrentOffset:");
    stringBuilder.append(paramLong1);
    stringBuilder.append(" EndOffset:");
    stringBuilder.append(paramLong2);
    a.b(str, stringBuilder.toString());
    if (paramLong2 == 0L) {
      str = String.format("bytes=%s-", new Object[] { String.valueOf(paramLong1) });
    } else {
      str = String.format("bytes=%s-%s", new Object[] { String.valueOf(paramLong1), String.valueOf(paramLong2) });
    } 
    arrayList.add(new e("Range", str));
    return arrayList;
  }
  
  public static List<e> a(List<e> paramList, String paramString, b paramb) {
    return a(paramList, paramString, paramb.m(), paramb.p());
  }
  
  private static void a(int paramInt, boolean paramBoolean, a parama) {
    synchronized (d) {
      List list = (List)e.get(paramInt);
      if (list != null)
        for (ae ae : list) {
          if (ae != null) {
            if (paramBoolean) {
              ae.a();
              continue;
            } 
            ae.a(parama);
          } 
        }  
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("handleTempSaveCallback id:");
      stringBuilder.append(paramInt);
      a.b(str, stringBuilder.toString());
      d.remove(paramInt);
      return;
    } 
  }
  
  public static <K> void a(SparseArray<K> paramSparseArray, Map<Integer, K> paramMap) {
    if (paramMap != null) {
      if (paramSparseArray == null)
        return; 
      for (Integer integer : paramMap.keySet()) {
        if (integer != null) {
          K k = paramMap.get(integer);
          paramSparseArray.put(integer.intValue(), k);
        } 
      } 
    } 
  }
  
  public static void a(c paramc) {
    if (paramc == null)
      return; 
    c(paramc.k(), paramc.h());
    c(paramc.l(), paramc.m());
    if (paramc.be())
      b(paramc); 
  }
  
  public static void a(c paramc, ae paramae) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("saveFileAsTargetName targetName is ");
    stringBuilder.append(paramc.n());
    a.b(str, stringBuilder.toString());
    try {
    
    } finally {
      paramc = null;
      str = a;
      stringBuilder = new StringBuilder();
      stringBuilder.append("saveFileAsTargetName throwable ");
      stringBuilder.append(paramc.getMessage());
      a.b(str, stringBuilder.toString());
      if (paramae != null)
        paramae.a(new a(1038, b((Throwable)paramc, "saveFileAsTargetName"))); 
    } 
  }
  
  public static void a(c paramc, x paramx, ae paramae) {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/m/f.a : Ljava/lang/String;
    //   3: astore #6
    //   5: new java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore #7
    //   14: aload #7
    //   16: ldc_w 'saveFileAsTargetName targetName is '
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload #7
    //   25: aload_0
    //   26: invokevirtual n : ()Ljava/lang/String;
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload #6
    //   35: aload #7
    //   37: invokevirtual toString : ()Ljava/lang/String;
    //   40: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   43: getstatic com/ss/android/socialbase/downloader/m/f.d : Landroid/util/SparseArray;
    //   46: astore #7
    //   48: aload #7
    //   50: monitorenter
    //   51: getstatic com/ss/android/socialbase/downloader/m/f.d : Landroid/util/SparseArray;
    //   54: aload_0
    //   55: invokevirtual g : ()I
    //   58: invokevirtual get : (I)Ljava/lang/Object;
    //   61: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   64: if_acmpne -> 945
    //   67: iconst_1
    //   68: istore_3
    //   69: goto -> 72
    //   72: iload_3
    //   73: ifeq -> 143
    //   76: getstatic com/ss/android/socialbase/downloader/m/f.a : Ljava/lang/String;
    //   79: ldc_w 'has another same task is saving temp file'
    //   82: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_2
    //   86: ifnull -> 139
    //   89: getstatic com/ss/android/socialbase/downloader/m/f.e : Landroid/util/SparseArray;
    //   92: aload_0
    //   93: invokevirtual g : ()I
    //   96: invokevirtual get : (I)Ljava/lang/Object;
    //   99: checkcast java/util/List
    //   102: astore #6
    //   104: aload #6
    //   106: astore_1
    //   107: aload #6
    //   109: ifnonnull -> 131
    //   112: new java/util/ArrayList
    //   115: dup
    //   116: invokespecial <init> : ()V
    //   119: astore_1
    //   120: getstatic com/ss/android/socialbase/downloader/m/f.e : Landroid/util/SparseArray;
    //   123: aload_0
    //   124: invokevirtual g : ()I
    //   127: aload_1
    //   128: invokevirtual put : (ILjava/lang/Object;)V
    //   131: aload_1
    //   132: aload_2
    //   133: invokeinterface add : (Ljava/lang/Object;)Z
    //   138: pop
    //   139: aload #7
    //   141: monitorexit
    //   142: return
    //   143: getstatic com/ss/android/socialbase/downloader/m/f.a : Ljava/lang/String;
    //   146: astore #6
    //   148: new java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial <init> : ()V
    //   155: astore #8
    //   157: aload #8
    //   159: ldc_w 'saveTempFileStatusMap put id:'
    //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload #8
    //   168: aload_0
    //   169: invokevirtual g : ()I
    //   172: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload #6
    //   178: aload #8
    //   180: invokevirtual toString : ()Ljava/lang/String;
    //   183: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   186: getstatic com/ss/android/socialbase/downloader/m/f.d : Landroid/util/SparseArray;
    //   189: aload_0
    //   190: invokevirtual g : ()I
    //   193: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   196: invokevirtual put : (ILjava/lang/Object;)V
    //   199: aload #7
    //   201: monitorexit
    //   202: new java/io/File
    //   205: dup
    //   206: aload_0
    //   207: invokevirtual l : ()Ljava/lang/String;
    //   210: aload_0
    //   211: invokevirtual m : ()Ljava/lang/String;
    //   214: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   217: astore #6
    //   219: new java/io/File
    //   222: dup
    //   223: aload_0
    //   224: invokevirtual k : ()Ljava/lang/String;
    //   227: aload_0
    //   228: invokevirtual h : ()Ljava/lang/String;
    //   231: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   234: astore #7
    //   236: aload #7
    //   238: invokevirtual exists : ()Z
    //   241: ifeq -> 521
    //   244: getstatic com/ss/android/socialbase/downloader/m/f.a : Ljava/lang/String;
    //   247: ldc_w 'targetFile exist'
    //   250: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload_0
    //   254: invokevirtual aS : ()Lcom/ss/android/socialbase/downloader/b/i;
    //   257: astore #8
    //   259: aload #8
    //   261: getstatic com/ss/android/socialbase/downloader/b/i.a : Lcom/ss/android/socialbase/downloader/b/i;
    //   264: if_acmpne -> 298
    //   267: getstatic com/ss/android/socialbase/downloader/m/f.a : Ljava/lang/String;
    //   270: ldc_w 'tempFile not exist , targetFile exists and md5 check valid'
    //   273: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_2
    //   277: ifnull -> 286
    //   280: aload_2
    //   281: invokeinterface a : ()V
    //   286: aload_0
    //   287: invokevirtual g : ()I
    //   290: iconst_1
    //   291: aconst_null
    //   292: invokestatic a : (IZLcom/ss/android/socialbase/downloader/e/a;)V
    //   295: goto -> 955
    //   298: aload #6
    //   300: invokevirtual exists : ()Z
    //   303: ifne -> 950
    //   306: new com/ss/android/socialbase/downloader/e/a
    //   309: dup
    //   310: sipush #1005
    //   313: ldc_w 'Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s'
    //   316: iconst_5
    //   317: anewarray java/lang/Object
    //   320: dup
    //   321: iconst_0
    //   322: aload_0
    //   323: invokevirtual l : ()Ljava/lang/String;
    //   326: aastore
    //   327: dup
    //   328: iconst_1
    //   329: aload_0
    //   330: invokevirtual m : ()Ljava/lang/String;
    //   333: aastore
    //   334: dup
    //   335: iconst_2
    //   336: aload_0
    //   337: invokevirtual k : ()Ljava/lang/String;
    //   340: aastore
    //   341: dup
    //   342: iconst_3
    //   343: aload_0
    //   344: invokevirtual h : ()Ljava/lang/String;
    //   347: aastore
    //   348: dup
    //   349: iconst_4
    //   350: aload #8
    //   352: invokevirtual name : ()Ljava/lang/String;
    //   355: aastore
    //   356: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   359: invokespecial <init> : (ILjava/lang/String;)V
    //   362: astore #9
    //   364: aload_2
    //   365: ifnull -> 376
    //   368: aload_2
    //   369: aload #9
    //   371: invokeinterface a : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   376: aload_0
    //   377: invokevirtual g : ()I
    //   380: iconst_0
    //   381: aload #9
    //   383: invokestatic a : (IZLcom/ss/android/socialbase/downloader/e/a;)V
    //   386: iconst_0
    //   387: istore_3
    //   388: goto -> 391
    //   391: iload_3
    //   392: istore #4
    //   394: aload #7
    //   396: invokevirtual delete : ()Z
    //   399: ifne -> 604
    //   402: iload_3
    //   403: ifne -> 441
    //   406: iload_3
    //   407: istore #4
    //   409: aload_1
    //   410: ifnull -> 604
    //   413: aload_1
    //   414: aload_0
    //   415: new com/ss/android/socialbase/downloader/e/a
    //   418: dup
    //   419: sipush #1038
    //   422: ldc_w 'tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed'
    //   425: invokespecial <init> : (ILjava/lang/String;)V
    //   428: aload_0
    //   429: invokevirtual q : ()I
    //   432: invokestatic a : (Lcom/ss/android/socialbase/downloader/d/x;Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;I)V
    //   435: iload_3
    //   436: istore #4
    //   438: goto -> 604
    //   441: new java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial <init> : ()V
    //   448: astore #9
    //   450: aload #9
    //   452: ldc_w 'delete targetPath file existed with md5 check invalid status:'
    //   455: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload #9
    //   461: aload #8
    //   463: invokevirtual name : ()Ljava/lang/String;
    //   466: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload #9
    //   472: ldc_w ' failed!'
    //   475: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: new com/ss/android/socialbase/downloader/e/a
    //   482: dup
    //   483: sipush #1037
    //   486: aload #9
    //   488: invokevirtual toString : ()Ljava/lang/String;
    //   491: invokespecial <init> : (ILjava/lang/String;)V
    //   494: astore #8
    //   496: aload_2
    //   497: ifnull -> 508
    //   500: aload_2
    //   501: aload #8
    //   503: invokeinterface a : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   508: aload_0
    //   509: invokevirtual g : ()I
    //   512: iconst_0
    //   513: aload #8
    //   515: invokestatic a : (IZLcom/ss/android/socialbase/downloader/e/a;)V
    //   518: goto -> 955
    //   521: aload #6
    //   523: invokevirtual exists : ()Z
    //   526: ifne -> 961
    //   529: new com/ss/android/socialbase/downloader/e/a
    //   532: dup
    //   533: sipush #1005
    //   536: ldc_w 'Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist'
    //   539: iconst_4
    //   540: anewarray java/lang/Object
    //   543: dup
    //   544: iconst_0
    //   545: aload_0
    //   546: invokevirtual l : ()Ljava/lang/String;
    //   549: aastore
    //   550: dup
    //   551: iconst_1
    //   552: aload_0
    //   553: invokevirtual m : ()Ljava/lang/String;
    //   556: aastore
    //   557: dup
    //   558: iconst_2
    //   559: aload_0
    //   560: invokevirtual k : ()Ljava/lang/String;
    //   563: aastore
    //   564: dup
    //   565: iconst_3
    //   566: aload_0
    //   567: invokevirtual h : ()Ljava/lang/String;
    //   570: aastore
    //   571: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   574: invokespecial <init> : (ILjava/lang/String;)V
    //   577: astore #8
    //   579: aload_2
    //   580: ifnull -> 591
    //   583: aload_2
    //   584: aload #8
    //   586: invokeinterface a : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   591: aload_0
    //   592: invokevirtual g : ()I
    //   595: iconst_0
    //   596: aload #8
    //   598: invokestatic a : (IZLcom/ss/android/socialbase/downloader/e/a;)V
    //   601: goto -> 955
    //   604: iload #4
    //   606: ifeq -> 944
    //   609: aload #6
    //   611: aload_0
    //   612: invokevirtual A : ()Ljava/lang/String;
    //   615: invokestatic a : (Ljava/io/File;Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/b/i;
    //   618: astore #8
    //   620: aload #8
    //   622: getstatic com/ss/android/socialbase/downloader/b/i.a : Lcom/ss/android/socialbase/downloader/b/i;
    //   625: if_acmpeq -> 743
    //   628: new com/ss/android/socialbase/downloader/e/a
    //   631: dup
    //   632: sipush #1038
    //   635: ldc_w 'Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile md5 is invalid : %s'
    //   638: iconst_5
    //   639: anewarray java/lang/Object
    //   642: dup
    //   643: iconst_0
    //   644: aload_0
    //   645: invokevirtual l : ()Ljava/lang/String;
    //   648: aastore
    //   649: dup
    //   650: iconst_1
    //   651: aload_0
    //   652: invokevirtual m : ()Ljava/lang/String;
    //   655: aastore
    //   656: dup
    //   657: iconst_2
    //   658: aload_0
    //   659: invokevirtual k : ()Ljava/lang/String;
    //   662: aastore
    //   663: dup
    //   664: iconst_3
    //   665: aload_0
    //   666: invokevirtual h : ()Ljava/lang/String;
    //   669: aastore
    //   670: dup
    //   671: iconst_4
    //   672: aload #8
    //   674: invokevirtual name : ()Ljava/lang/String;
    //   677: aastore
    //   678: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   681: invokespecial <init> : (ILjava/lang/String;)V
    //   684: astore #7
    //   686: aload_2
    //   687: ifnull -> 698
    //   690: aload_2
    //   691: aload #7
    //   693: invokeinterface a : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   698: aload_0
    //   699: invokevirtual g : ()I
    //   702: iconst_0
    //   703: aload #7
    //   705: invokestatic a : (IZLcom/ss/android/socialbase/downloader/e/a;)V
    //   708: aload #6
    //   710: invokevirtual delete : ()Z
    //   713: ifne -> 944
    //   716: aload_1
    //   717: ifnull -> 944
    //   720: aload_1
    //   721: aload_0
    //   722: new com/ss/android/socialbase/downloader/e/a
    //   725: dup
    //   726: sipush #1038
    //   729: ldc_w 'tempFile md5 is invalid ,but delete failed'
    //   732: invokespecial <init> : (ILjava/lang/String;)V
    //   735: aload_0
    //   736: invokevirtual q : ()I
    //   739: invokestatic a : (Lcom/ss/android/socialbase/downloader/d/x;Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;I)V
    //   742: return
    //   743: aload #6
    //   745: aload #7
    //   747: invokestatic b : (Ljava/io/File;Ljava/io/File;)Z
    //   750: istore #5
    //   752: iload #5
    //   754: iconst_1
    //   755: ixor
    //   756: istore_3
    //   757: aconst_null
    //   758: astore_1
    //   759: goto -> 765
    //   762: astore_1
    //   763: iconst_0
    //   764: istore_3
    //   765: iload_3
    //   766: ifeq -> 849
    //   769: aload_1
    //   770: astore #6
    //   772: aload_1
    //   773: ifnonnull -> 826
    //   776: new com/ss/android/socialbase/downloader/e/a
    //   779: dup
    //   780: sipush #1038
    //   783: ldc_w 'Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)'
    //   786: iconst_4
    //   787: anewarray java/lang/Object
    //   790: dup
    //   791: iconst_0
    //   792: aload_0
    //   793: invokevirtual l : ()Ljava/lang/String;
    //   796: aastore
    //   797: dup
    //   798: iconst_1
    //   799: aload_0
    //   800: invokevirtual m : ()Ljava/lang/String;
    //   803: aastore
    //   804: dup
    //   805: iconst_2
    //   806: aload_0
    //   807: invokevirtual k : ()Ljava/lang/String;
    //   810: aastore
    //   811: dup
    //   812: iconst_3
    //   813: aload_0
    //   814: invokevirtual h : ()Ljava/lang/String;
    //   817: aastore
    //   818: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   821: invokespecial <init> : (ILjava/lang/String;)V
    //   824: astore #6
    //   826: aload_2
    //   827: ifnull -> 838
    //   830: aload_2
    //   831: aload #6
    //   833: invokeinterface a : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   838: aload_0
    //   839: invokevirtual g : ()I
    //   842: iconst_0
    //   843: aload #6
    //   845: invokestatic a : (IZLcom/ss/android/socialbase/downloader/e/a;)V
    //   848: return
    //   849: aload_2
    //   850: ifnull -> 859
    //   853: aload_2
    //   854: invokeinterface a : ()V
    //   859: aload_0
    //   860: invokevirtual g : ()I
    //   863: iconst_1
    //   864: aconst_null
    //   865: invokestatic a : (IZLcom/ss/android/socialbase/downloader/e/a;)V
    //   868: return
    //   869: astore_0
    //   870: aload #7
    //   872: monitorexit
    //   873: aload_0
    //   874: athrow
    //   875: astore_0
    //   876: getstatic com/ss/android/socialbase/downloader/m/f.a : Ljava/lang/String;
    //   879: astore_1
    //   880: new java/lang/StringBuilder
    //   883: dup
    //   884: invokespecial <init> : ()V
    //   887: astore #6
    //   889: aload #6
    //   891: ldc_w 'saveFileAsTargetName throwable '
    //   894: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: pop
    //   898: aload #6
    //   900: aload_0
    //   901: invokevirtual getMessage : ()Ljava/lang/String;
    //   904: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: pop
    //   908: aload_1
    //   909: aload #6
    //   911: invokevirtual toString : ()Ljava/lang/String;
    //   914: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   917: aload_2
    //   918: ifnull -> 944
    //   921: aload_2
    //   922: new com/ss/android/socialbase/downloader/e/a
    //   925: dup
    //   926: sipush #1038
    //   929: aload_0
    //   930: ldc_w 'saveFileAsTargetName'
    //   933: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;)Ljava/lang/String;
    //   936: invokespecial <init> : (ILjava/lang/String;)V
    //   939: invokeinterface a : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   944: return
    //   945: iconst_0
    //   946: istore_3
    //   947: goto -> 72
    //   950: iconst_1
    //   951: istore_3
    //   952: goto -> 391
    //   955: iconst_0
    //   956: istore #4
    //   958: goto -> 604
    //   961: iconst_1
    //   962: istore #4
    //   964: goto -> 604
    // Exception table:
    //   from	to	target	type
    //   43	51	875	finally
    //   51	67	869	finally
    //   76	85	869	finally
    //   89	104	869	finally
    //   112	131	869	finally
    //   131	139	869	finally
    //   139	142	869	finally
    //   143	202	869	finally
    //   202	276	875	finally
    //   280	286	875	finally
    //   286	295	875	finally
    //   298	364	875	finally
    //   368	376	875	finally
    //   376	386	875	finally
    //   394	402	875	finally
    //   413	435	875	finally
    //   441	496	875	finally
    //   500	508	875	finally
    //   508	518	875	finally
    //   521	579	875	finally
    //   583	591	875	finally
    //   591	601	875	finally
    //   609	686	875	finally
    //   690	698	875	finally
    //   698	716	875	finally
    //   720	742	875	finally
    //   743	752	762	com/ss/android/socialbase/downloader/e/a
    //   743	752	875	finally
    //   776	826	875	finally
    //   830	838	875	finally
    //   838	848	875	finally
    //   853	859	875	finally
    //   859	868	875	finally
    //   870	873	869	finally
    //   873	875	875	finally
  }
  
  public static void a(c paramc, String paramString) throws a {
    if (paramc != null && !TextUtils.isEmpty(paramString)) {
      if (paramString.equals(paramc.h()))
        return; 
      File file1 = new File(paramc.k(), paramString);
      File file2 = new File(paramc.k(), paramc.h());
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("copyFileFromExistFileWithSameName: existFile:");
      stringBuilder.append(file1.getPath());
      stringBuilder.append(" targetFile:");
      stringBuilder.append(file2.getPath());
      Log.e(str, stringBuilder.toString());
      if (!file2.exists() || file2.delete()) {
        if ((a(file1, file2) ^ true) == 0)
          return; 
        throw new a(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", new Object[] { paramc.k(), paramString, paramc.k(), paramc.h() }));
      } 
      throw new a(1037, "targetPath file exists but can't delete");
    } 
  }
  
  public static void a(IOException paramIOException, String paramString) throws a {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    paramString = b(paramIOException, str);
    if (!(paramIOException instanceof java.net.ConnectException)) {
      if (!(paramIOException instanceof java.net.UnknownHostException)) {
        if (!(paramIOException instanceof java.net.NoRouteToHostException)) {
          if (!(paramIOException instanceof java.net.UnknownServiceException)) {
            if (!(paramIOException instanceof java.net.PortUnreachableException)) {
              if (!(paramIOException instanceof java.net.SocketTimeoutException)) {
                if (!(paramIOException instanceof java.net.SocketException)) {
                  if (!(paramIOException instanceof java.net.HttpRetryException)) {
                    if (!(paramIOException instanceof java.net.ProtocolException)) {
                      if (!(paramIOException instanceof java.net.MalformedURLException)) {
                        if (!(paramIOException instanceof java.io.FileNotFoundException)) {
                          if (!(paramIOException instanceof java.io.InterruptedIOException)) {
                            if (!(paramIOException instanceof java.io.UnsupportedEncodingException)) {
                              if (!(paramIOException instanceof java.io.EOFException)) {
                                if (!(paramIOException instanceof okhttp3.internal.http2.StreamResetException)) {
                                  if (!(paramIOException instanceof javax.net.ssl.SSLException)) {
                                    if (g(paramIOException))
                                      throw new a(1006, paramString); 
                                    throw new a(1023, paramString);
                                  } 
                                  throw new a(1011, paramString);
                                } 
                                throw new a(1067, paramString);
                              } 
                              throw new a(1066, paramString);
                            } 
                            throw new a(1065, paramString);
                          } 
                          throw new a(1064, paramString);
                        } 
                        throw new a(1063, paramString);
                      } 
                      throw new a(1062, paramString);
                    } 
                    throw new a(1061, paramString);
                  } 
                  throw new a(1060, paramString);
                } 
                throw new a(1059, paramString);
              } 
              throw new a(1048, paramString);
            } 
            throw new a(1058, paramString);
          } 
          throw new a(1057, paramString);
        } 
        throw new a(1056, paramString);
      } 
      throw new a(1055, paramString);
    } 
    throw new a(1041, paramString);
  }
  
  public static void a(Throwable paramThrowable, String paramString) throws a {
    String str;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString;
    } else {
      str = "";
    } 
    if (!(paramThrowable instanceof a)) {
      if (!(paramThrowable instanceof javax.net.ssl.SSLHandshakeException)) {
        if (!a(paramThrowable)) {
          if (!e(paramThrowable)) {
            if (!f(paramThrowable)) {
              if (!b(paramThrowable)) {
                if (!c(paramThrowable)) {
                  if (!d(paramThrowable)) {
                    if (paramThrowable instanceof IOException) {
                      a((IOException)paramThrowable, paramString);
                      return;
                    } 
                    throw new a(1000, b(paramThrowable, str));
                  } 
                  throw new a(1041, b(paramThrowable, str));
                } 
                throw new a(1049, b(paramThrowable, str));
              } 
              throw new a(1047, b(paramThrowable, str));
            } 
            throw new c(1004, 416, b(paramThrowable, str));
          } 
          throw new c(1004, 412, b(paramThrowable, str));
        } 
        throw new a(1048, b(paramThrowable, str));
      } 
      throw new a(1011, b(paramThrowable, str));
    } 
    a a = (a)paramThrowable;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("-");
    stringBuilder.append(a.b());
    a.a(stringBuilder.toString());
    throw a;
  }
  
  public static boolean a() {
    Boolean bool1 = i;
    if (bool1 != null)
      return bool1.booleanValue(); 
    String str = c(b.B());
    boolean bool = false;
    if (str != null && str.contains(":")) {
      i = Boolean.valueOf(false);
    } else {
      boolean bool2 = bool;
      if (str != null) {
        bool2 = bool;
        if (str.equals(b.B().getPackageName()))
          bool2 = true; 
      } 
      i = Boolean.valueOf(bool2);
    } 
    return i.booleanValue();
  }
  
  public static boolean a(int paramInt) {
    return (paramInt == 200 || paramInt == 201 || paramInt == 0);
  }
  
  public static boolean a(int paramInt, String paramString) {
    boolean bool1 = c.a(16777216);
    boolean bool = false;
    null = false;
    if (bool1) {
      if (paramInt == 206 || paramInt == 1)
        null = true; 
      return null;
    } 
    if (paramInt >= 400)
      return false; 
    if (paramInt != 206 && paramInt != 1) {
      null = bool;
      return "bytes".equals(paramString) ? true : null;
    } 
    return true;
  }
  
  public static boolean a(int paramInt, String paramString1, String paramString2) {
    return (paramInt == -3 && !d(paramString1, paramString2));
  }
  
  public static boolean a(Context paramContext) {
    boolean bool = false;
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager == null)
        return false; 
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      boolean bool1 = bool;
      if (networkInfo != null) {
        if (!networkInfo.isAvailable())
          return false; 
        int i = networkInfo.getType();
        bool1 = bool;
        if (1 == i)
          bool1 = true; 
      } 
      return bool1;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static boolean a(Context paramContext, String paramString) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString))
        return false; 
      bool1 = bool2;
      if (paramContext.checkCallingOrSelfPermission(paramString) == 0)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static boolean a(a parama) {
    return (parama != null && parama.a() == 1051);
  }
  
  public static boolean a(a parama, c paramc) {
    if (parama == null)
      return false; 
    int i = parama.a();
    return (i != 1000 && i != 1032 && i != 1033 && i != 1034 && i != 1008 && i != 1026 && i != 1027 && i != 1044) ? ((i == 1020) ? true : ((i != 1049 && i != 1055 && i != 1006 && paramc != null && paramc.Z() < 8388608L))) : true;
  }
  
  public static boolean a(c paramc, boolean paramBoolean, String paramString) {
    if (!paramBoolean && !TextUtils.isEmpty(paramc.k())) {
      if (TextUtils.isEmpty(paramc.h()))
        return false; 
      try {
        if ((new File(paramc.k(), paramc.h())).exists()) {
          i i1 = a(paramc.k(), paramc.h(), paramString);
          i i2 = i.a;
          if (i1 == i2)
            return true; 
        } 
      } catch (OutOfMemoryError outOfMemoryError) {
        outOfMemoryError.printStackTrace();
      } 
    } 
    return false;
  }
  
  public static boolean a(File paramFile1, File paramFile2) throws a {
    return a(paramFile1, paramFile2, true);
  }
  
  public static boolean a(File paramFile1, File paramFile2, boolean paramBoolean) throws a {
    if (paramFile1 != null && paramFile2 != null)
      try {
        if (paramFile1.exists() && !paramFile1.isDirectory()) {
          String str;
          if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath()))
            return false; 
          File file = paramFile2.getParentFile();
          if (file == null || file.mkdirs() || file.isDirectory()) {
            str = a;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("copyFile: srcFile:");
            stringBuilder2.append(paramFile1.getPath());
            stringBuilder2.append(" destFile:");
            stringBuilder2.append(paramFile2.getPath());
            Log.e(str, stringBuilder2.toString());
            if (!paramFile2.exists() || paramFile2.canWrite() || paramFile2.delete())
              return true; 
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Destination '");
            stringBuilder1.append(paramFile2);
            stringBuilder1.append("' exists but is read-only and delete failed");
            throw new IOException(stringBuilder1.toString());
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Destination '");
          stringBuilder.append(str);
          stringBuilder.append("' directory cannot be created");
          throw new a(1053, stringBuilder.toString());
        } 
      } catch (a a) {
        throw a;
      } finally {
        paramFile1 = null;
        a((Throwable)paramFile1, "CopyFile");
      }  
    return false;
  }
  
  public static boolean a(Throwable paramThrowable) {
    boolean bool = false;
    if (paramThrowable == null)
      return false; 
    String str = i(paramThrowable);
    if (!(paramThrowable instanceof java.net.SocketTimeoutException)) {
      boolean bool1 = bool;
      if (!TextUtils.isEmpty(str)) {
        if (!str.contains("time out")) {
          bool1 = bool;
          return str.contains("Time-out") ? true : bool1;
        } 
      } else {
        return bool1;
      } 
    } 
    return true;
  }
  
  public static boolean a(List<e> paramList1, List<e> paramList2) {
    return (paramList1 == paramList2) ? true : ((paramList1 != null) ? ((paramList2 == null) ? false : ((paramList1.size() != paramList2.size()) ? false : (new HashSet(paramList1)).equals(new HashSet<e>(paramList2)))) : false);
  }
  
  public static long b(c paramc) {
    if (paramc == null)
      return -1L; 
    String str = paramc.a("Content-Range");
    if (TextUtils.isEmpty(str))
      return -1L; 
    try {
      Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(str);
      if (matcher.find()) {
        long l1 = Long.parseLong(matcher.group(1));
        long l2 = Long.parseLong(matcher.group(2));
        return l2 - l1 + 1L;
      } 
    } catch (Exception exception) {
      String str1 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("parse content-length from content-range failed ");
      stringBuilder.append(exception);
      a.d(str1, stringBuilder.toString());
    } 
    return -1L;
  }
  
  public static long b(List<b> paramList) {
    Iterator<b> iterator = paramList.iterator();
    long l;
    for (l = 0L; iterator.hasNext(); l += ((b)iterator.next()).o());
    return l;
  }
  
  public static String b(String paramString) {
    return TextUtils.isEmpty(paramString) ? null : String.format("%s.temp", new Object[] { paramString });
  }
  
  public static String b(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1) && TextUtils.isEmpty(paramString2))
      return null; 
    if (!TextUtils.isEmpty(paramString2))
      paramString1 = paramString2; 
    return paramString1;
  }
  
  public static String b(Throwable paramThrowable, String paramString) {
    if (paramString == null)
      return i(paramThrowable); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("-");
    stringBuilder.append(i(paramThrowable));
    return stringBuilder.toString();
  }
  
  public static void b(c paramc) {
    if (paramc == null)
      return; 
    JSONObject jSONObject = a.a(paramc).d("anti_hijack_dir");
    if (jSONObject != null) {
      String str = jSONObject.optString("install_desc");
      if (!TextUtils.isEmpty(str))
        c(paramc.k(), str); 
      h(paramc.k());
    } 
  }
  
  private static void b(File paramFile1, File paramFile2, boolean paramBoolean) throws IOException {
    if (!paramFile2.exists() || !paramFile2.isDirectory()) {
      long l1;
      long l2;
      FileChannel fileChannel1;
      FileOutputStream fileOutputStream;
      FileChannel fileChannel2;
      FileInputStream fileInputStream = new FileInputStream(paramFile1);
      try {
        fileChannel1 = fileInputStream.getChannel();
      } finally {
        paramFile1 = null;
      } 
      while (true) {
        if (l1 < l2) {
          long l3 = l2 - l1;
          if (l3 > 31457280L)
            l3 = 31457280L; 
          l3 = fileChannel2.transferFrom(fileChannel1, l1, l3);
          if (l3 != 0L) {
            l1 += l3;
            continue;
          } 
        } 
        if (fileChannel2 != null)
          fileChannel2.close(); 
        fileOutputStream.close();
        if (fileChannel1 != null)
          fileChannel1.close(); 
        fileInputStream.close();
        l1 = paramFile1.length();
        long l = paramFile2.length();
        if (l1 == l) {
          if (paramBoolean)
            paramFile2.setLastModified(paramFile1.lastModified()); 
          return;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Failed to copy full contents from '");
        stringBuilder1.append(paramFile1);
        stringBuilder1.append("' to '");
        stringBuilder1.append(paramFile2);
        stringBuilder1.append("' Expected length: ");
        stringBuilder1.append(l1);
        stringBuilder1.append(" Actual: ");
        stringBuilder1.append(l);
        throw new IOException(stringBuilder1.toString());
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Destination '");
    stringBuilder.append(paramFile2);
    stringBuilder.append("' exists but is a directory");
    throw new IOException(stringBuilder.toString());
  }
  
  public static boolean b() {
    return (!c() && b.b() && l.a(true).g());
  }
  
  public static boolean b(int paramInt) {
    return (paramInt == 206 || paramInt == 200);
  }
  
  public static boolean b(long paramLong) {
    return (paramLong == -1L);
  }
  
  public static boolean b(Context paramContext) {
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager == null)
        return false; 
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      return (networkInfo == null) ? false : networkInfo.isConnected();
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static boolean b(a parama) {
    if (parama instanceof c) {
      c c = (c)parama;
      if (c.c() == 412 || c.c() == 416)
        return true; 
    } 
    return false;
  }
  
  public static boolean b(File paramFile1, File paramFile2) throws a {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("moveFile1: src:");
    stringBuilder.append(paramFile1.getPath());
    stringBuilder.append(" dest:");
    stringBuilder.append(paramFile2.getPath());
    Log.e(str, stringBuilder.toString());
    boolean bool2 = paramFile1.renameTo(paramFile2);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = a(paramFile1, paramFile2);
      try {
        str = a;
        stringBuilder = new StringBuilder();
        stringBuilder.append("moveFile2: src:");
        stringBuilder.append(paramFile1.getPath());
        stringBuilder.append(" dest:");
        stringBuilder.append(paramFile2.getPath());
        Log.e(str, stringBuilder.toString());
        return bool1;
      } finally {
        paramFile1 = null;
      } 
    } 
    return bool1;
  }
  
  public static boolean b(Throwable paramThrowable) {
    boolean bool2 = false;
    if (paramThrowable == null)
      return false; 
    String str = i(paramThrowable);
    if (paramThrowable instanceof c) {
      c c = (c)paramThrowable;
      if ((c != null && c.c() == 403) || (!TextUtils.isEmpty(str) && str.contains("403")))
        return true; 
    } 
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str)) {
      bool1 = bool2;
      if (str.contains("Forbidden"))
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static long c(String paramString) throws a {
    try {
      StatFs statFs = new StatFs(paramString);
      if (Build.VERSION.SDK_INT >= 18)
        return statFs.getAvailableBytes(); 
      long l = statFs.getAvailableBlocks();
      return l * i;
    } catch (IllegalArgumentException illegalArgumentException) {
      throw new a(1050, illegalArgumentException);
    } finally {
      paramString = null;
    } 
  }
  
  private static long c(List<b> paramList) {
    long l2 = -1L;
    long l1 = l2;
    if (paramList != null) {
      l1 = l2;
      if (!paramList.isEmpty()) {
        Iterator<b> iterator = paramList.iterator();
        l1 = -1L;
        while (iterator.hasNext()) {
          b b = iterator.next();
          if (b != null && (b.n() <= b.p() || b.p() == 0L) && (l1 == -1L || l1 > b.n()))
            l1 = b.n(); 
        } 
      } 
    } 
    return l1;
  }
  
  public static h c(int paramInt) {
    h h = h.a;
    if (paramInt == h.b.ordinal())
      return h.b; 
    if (paramInt == h.c.ordinal())
      h = h.c; 
    return h;
  }
  
  public static String c(Context paramContext) {
    String str = c;
    if (!TextUtils.isEmpty(str))
      return str; 
    try {
      int i = Process.myPid();
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      if (activityManager != null) {
        Iterator<ActivityManager.RunningAppProcessInfo> iterator = activityManager.getRunningAppProcesses().iterator();
        while (iterator.hasNext()) {
          ActivityManager.RunningAppProcessInfo runningAppProcessInfo = iterator.next();
          if (runningAppProcessInfo.pid == i) {
            if (a.a()) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("processName = ");
              stringBuilder.append(runningAppProcessInfo.processName);
              a.b("Process", stringBuilder.toString());
            } 
            c = runningAppProcessInfo.processName;
            return c;
          } 
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    c = e();
    return c;
  }
  
  public static void c(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
      File file = new File(paramString1, paramString2);
      if (file.exists()) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("deleteFile: ");
        stringBuilder.append(paramString1);
        stringBuilder.append("/");
        stringBuilder.append(paramString2);
        Log.e(str, stringBuilder.toString());
        file.delete();
      } 
    } 
  }
  
  public static boolean c() {
    Boolean bool = j;
    if (bool != null)
      return bool.booleanValue(); 
    String str = c(b.B());
    if (str != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b.B().getPackageName());
      stringBuilder.append(":downloader");
      if (str.equals(stringBuilder.toString())) {
        j = Boolean.valueOf(true);
        return j.booleanValue();
      } 
    } 
    j = Boolean.valueOf(false);
    return j.booleanValue();
  }
  
  public static boolean c(c paramc) {
    return a(paramc, paramc.Y(), paramc.A());
  }
  
  public static boolean c(c paramc) {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramc == null)
      return false; 
    if (c.a(8)) {
      if ("chunked".equals(paramc.a("Transfer-Encoding")) || a(paramc) == -1L)
        bool1 = true; 
      return bool1;
    } 
    bool1 = bool2;
    if (a(paramc) == -1L)
      bool1 = true; 
    return bool1;
  }
  
  public static boolean c(Throwable paramThrowable) {
    boolean bool2 = false;
    if (paramThrowable == null)
      return false; 
    String str = i(paramThrowable);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str)) {
      bool1 = bool2;
      if (str.contains("network not available"))
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static long d(c paramc) {
    if (paramc == null)
      return -1L; 
    List<b> list = b.p().c(paramc.g());
    int i = paramc.aV();
    long l2 = 0L;
    if (i == 1)
      return paramc.Z(); 
    long l1 = l2;
    if (list != null) {
      l1 = l2;
      if (list.size() > 1) {
        long l = c(list);
        l1 = l2;
        if (l >= 0L)
          l1 = l; 
      } 
    } 
    return l1;
  }
  
  public static String d(String paramString) {
    if (paramString != null)
      try {
        if (paramString.length() == 0)
          return null; 
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(paramString.getBytes("UTF-8"));
        return a(messageDigest.digest());
      } catch (Exception exception) {
        return null;
      }  
    return null;
  }
  
  public static boolean d() {
    return (Looper.getMainLooper() == Looper.myLooper());
  }
  
  public static boolean d(String paramString1, String paramString2) {
    return (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) ? false : (new File(paramString1, paramString2)).exists();
  }
  
  public static boolean d(Throwable paramThrowable) {
    boolean bool2 = false;
    if (paramThrowable == null)
      return false; 
    String str = i(paramThrowable);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str)) {
      bool1 = bool2;
      if (str.contains("Exception in connect"))
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static long e(c paramc) {
    long l2 = 0L;
    if (paramc == null)
      return 0L; 
    List<b> list = b.p().c(paramc.g());
    int i = paramc.aV();
    boolean bool = true;
    if (i <= 1)
      bool = false; 
    long l1 = l2;
    if (paramc.aQ())
      if (bool) {
        l1 = l2;
        if (list != null) {
          l1 = l2;
          if (i == list.size())
            return b(list); 
        } 
      } else {
        l1 = paramc.Z();
      }  
    return l1;
  }
  
  private static String e() {
    Exception exception;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("/proc/");
      stringBuilder.append(Process.myPid());
      stringBuilder.append("/cmdline");
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(stringBuilder.toString()), "iso-8859-1"));
      return null;
    } finally {
      exception = null;
    } 
    if (exception != null)
      try {
        exception.close();
        return null;
      } catch (Exception exception1) {
        return null;
      }  
  }
  
  public static boolean e(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return true; 
    String str = c(b.B());
    return (str != null && str.equals(paramString));
  }
  
  public static boolean e(Throwable paramThrowable) {
    boolean bool2 = false;
    if (paramThrowable == null)
      return false; 
    String str = i(paramThrowable);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str)) {
      bool1 = bool2;
      if (str.contains("Precondition Failed"))
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static String f(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramString.length();
    for (int i = 0; i < j; i++) {
      char c = paramString.charAt(i);
      if (c <= '\037' || c >= '') {
        stringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
      } else {
        stringBuilder.append(c);
      } 
    } 
    return stringBuilder.toString();
  }
  
  public static boolean f(Throwable paramThrowable) {
    boolean bool2 = false;
    if (paramThrowable == null)
      return false; 
    String str = i(paramThrowable);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str)) {
      bool1 = bool2;
      if (str.contains("Requested Range Not Satisfiable"))
        bool1 = true; 
    } 
    return bool1;
  }
  
  private static String g(String paramString) {
    if (paramString == null)
      return null; 
    try {
      if (g == null)
        g = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\""); 
      Matcher matcher2 = g.matcher(paramString);
      if (matcher2.find())
        return matcher2.group(1); 
      if (h == null)
        h = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)"); 
      Matcher matcher1 = h.matcher(paramString);
      return matcher1.find() ? matcher1.group(1) : null;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static boolean g(Throwable paramThrowable) {
    String str;
    boolean bool1;
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramThrowable == null)
      return false; 
    if (paramThrowable instanceof a) {
      a a = (a)paramThrowable;
      int i = a.a();
      if (i == 1006)
        return true; 
      if (i == 1023 || i == 1039 || i == 1040 || i == 1054 || i == 1064) {
        i = 1;
      } else {
        i = 0;
      } 
      bool1 = bool3;
      if (i != 0) {
        str = a.getMessage();
        bool1 = bool2;
        if (!TextUtils.isEmpty(str)) {
          bool1 = bool2;
          if (str.contains("ENOSPC"))
            bool1 = true; 
        } 
        return bool1;
      } 
    } else {
      bool1 = bool3;
      if (str instanceof IOException) {
        str = i((Throwable)str);
        bool1 = bool3;
        if (!TextUtils.isEmpty(str)) {
          bool1 = bool3;
          if (str.contains("ENOSPC"))
            bool1 = true; 
        } 
      } 
    } 
    return bool1;
  }
  
  private static void h(String paramString) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("deleteDirIfEmpty on thread: ");
    stringBuilder.append(Thread.currentThread());
    Log.w(str, stringBuilder.toString());
    if (!TextUtils.isEmpty(paramString)) {
      File file = new File(paramString);
      if (file.isDirectory() && !file.delete())
        Log.w(a, "deleteDirIfEmpty return false"); 
    } 
  }
  
  public static boolean h(Throwable paramThrowable) {
    if (!(paramThrowable instanceof a))
      return false; 
    int i = ((a)paramThrowable).a();
    return (i == 1055 || i == 1023 || i == 1041 || i == 1022 || i == 1048 || i == 1056 || i == 1057 || i == 1058 || i == 1059 || i == 1060 || i == 1061 || i == 1067 || i == 1049 || i == 1047 || i == 1051 || i == 1004 || i == 1011 || i == 1002 || i == 1013);
  }
  
  public static String i(Throwable paramThrowable) {
    if (paramThrowable == null)
      return ""; 
    try {
      return paramThrowable.toString();
    } finally {
      paramThrowable = null;
      paramThrowable.printStackTrace();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\m\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */