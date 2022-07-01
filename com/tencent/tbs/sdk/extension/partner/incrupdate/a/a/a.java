package com.tencent.tbs.sdk.extension.partner.incrupdate.a.a;

import android.content.Context;
import com.tencent.tbs.sdk.extension.TbsSDKExtension;
import com.tencent.tbs.sdk.extension.partner.c.g;
import com.tencent.tbs.sdk.extension.partner.incrupdate.a.b;
import com.tencent.tbs.sdk.extension.partner.incrupdate.a.d;
import com.tencent.tbs.sdk.extension.partner.incrupdate.a.f;
import com.tencent.tbs.sdk.extension.partner.incrupdate.a.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class a extends g {
  ArrayList<String> f;
  
  private Map<String, a> g;
  
  private void a(Context paramContext, File paramFile) {
    this.g = new LinkedHashMap<String, a>();
    ZipFile zipFile = new ZipFile(paramFile);
    Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
    File file = new File(TbsSDKExtension.getTbsFolderDir(paramContext), "core_share");
    String str = "";
    if (file.isDirectory()) {
      str = file.getAbsolutePath();
    } else {
      g.c("TbsSDKExtension", "so path is null");
    } 
    while (true) {
      String str1;
      File file1;
      if (enumeration.hasMoreElements()) {
        ZipEntry zipEntry = enumeration.nextElement();
        str1 = zipEntry.getName();
        if (str1 == null || str1.contains("../") || str1.equals("assets/webkit/order.info"))
          continue; 
        if (str1.endsWith("_lzma.so")) {
          StringBuilder stringBuilder5 = new StringBuilder();
          stringBuilder5.append(paramFile.getParent());
          stringBuilder5.append(File.separator);
          stringBuilder5.append("unzipTmp");
          stringBuilder5.append(File.separator);
          File file3 = new File(stringBuilder5.toString());
          if (!file3.exists())
            file3.mkdirs(); 
          StringBuilder stringBuilder4 = new StringBuilder();
          stringBuilder4.append(paramFile.getParent());
          stringBuilder4.append(File.separator);
          stringBuilder4.append("unzipTmp");
          stringBuilder4.append(File.separator);
          stringBuilder4.append("tmp.7z");
          file1 = new File(stringBuilder4.toString());
          InputStream inputStream = zipFile.getInputStream(zipEntry);
          try {
            a(inputStream, new FileOutputStream(file1), zipEntry.getCrc());
            try {
              inputStream.close();
            } catch (Exception null) {
              exception.printStackTrace();
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
            inputStream.close();
          } finally {}
        } else {
          a a1 = new a();
          a1.a = (ZipEntry)exception;
          a1.b = zipFile.getInputStream((ZipEntry)exception);
          this.g.put(exception.getName(), a1);
          continue;
        } 
      } else {
        break;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramFile.getParent());
      stringBuilder1.append(File.separator);
      stringBuilder1.append("unzipTmp");
      stringBuilder1.append(File.separator);
      File file2 = new File(stringBuilder1.toString());
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(file2.getAbsolutePath());
      stringBuilder2.append("/");
      String str2 = stringBuilder2.toString();
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(str);
      stringBuilder3.append(File.separator);
      com.tencent.tbs.sdk.extension.partner.lzma.a.a(file1, str2, stringBuilder3.toString());
      if (file1.exists())
        file1.delete(); 
      if (!file2.exists()) {
        str1 = "temp dir is not found";
      } else if (!file2.isDirectory()) {
        str1 = "temp dir is not directory";
      } else {
        int j = str1.lastIndexOf("/");
        int i = 0;
        str1 = str1.substring(0, j + 1);
        File[] arrayOfFile = file2.listFiles();
        j = arrayOfFile.length;
        while (i < j) {
          file2 = arrayOfFile[i];
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str1);
          stringBuilder.append(file2.getName());
          ZipEntry zipEntry = new ZipEntry(stringBuilder.toString());
          zipEntry.setSize(file2.length());
          zipEntry.setTime(file2.lastModified());
          zipEntry.setMethod(8);
          zipEntry.setCrc(com.tencent.tbs.sdk.extension.partner.incrupdate.a.a.a(file2));
          a a1 = new a();
          a1.a = zipEntry;
          a1.b = new FileInputStream(file2);
          this.g.put(zipEntry.getName(), a1);
          file2.delete();
          i++;
        } 
        continue;
      } 
      g.a("TbsSDKExtension", str1);
    } 
  }
  
  private void a(File paramFile) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #7
    //   3: aconst_null
    //   4: astore #5
    //   6: new java/io/FileOutputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial <init> : (Ljava/io/File;)V
    //   14: astore #6
    //   16: aload_0
    //   17: aload #6
    //   19: invokevirtual a : (Ljava/io/OutputStream;)V
    //   22: sipush #8192
    //   25: newarray byte
    //   27: astore #8
    //   29: aload_0
    //   30: getfield g : Ljava/util/Map;
    //   33: invokeinterface entrySet : ()Ljava/util/Set;
    //   38: invokeinterface iterator : ()Ljava/util/Iterator;
    //   43: astore #9
    //   45: aload #9
    //   47: invokeinterface hasNext : ()Z
    //   52: ifeq -> 265
    //   55: aload #9
    //   57: invokeinterface next : ()Ljava/lang/Object;
    //   62: checkcast java/util/Map$Entry
    //   65: invokeinterface getValue : ()Ljava/lang/Object;
    //   70: checkcast com/tencent/tbs/sdk/extension/partner/incrupdate/a/a/a$a
    //   73: astore_1
    //   74: aload_1
    //   75: getfield a : Ljava/util/zip/ZipEntry;
    //   78: astore #7
    //   80: aload_1
    //   81: getfield b : Ljava/io/InputStream;
    //   84: astore_1
    //   85: aload_1
    //   86: astore #5
    //   88: aload #7
    //   90: invokevirtual isDirectory : ()Z
    //   93: ifeq -> 111
    //   96: aload_1
    //   97: astore #5
    //   99: aload_0
    //   100: aload #6
    //   102: aload #7
    //   104: iconst_2
    //   105: invokevirtual a : (Ljava/io/OutputStream;Ljava/util/zip/ZipEntry;I)V
    //   108: goto -> 193
    //   111: aload_1
    //   112: astore #5
    //   114: aload_0
    //   115: getfield d : Ljava/util/List;
    //   118: ifnull -> 200
    //   121: iconst_0
    //   122: istore_3
    //   123: aload_1
    //   124: astore #5
    //   126: aload_0
    //   127: getfield d : Ljava/util/List;
    //   130: invokeinterface iterator : ()Ljava/util/Iterator;
    //   135: astore #10
    //   137: iload_3
    //   138: istore_2
    //   139: aload_1
    //   140: astore #5
    //   142: aload #10
    //   144: invokeinterface hasNext : ()Z
    //   149: ifeq -> 189
    //   152: aload_1
    //   153: astore #5
    //   155: aload #10
    //   157: invokeinterface next : ()Ljava/lang/Object;
    //   162: checkcast java/lang/String
    //   165: astore #11
    //   167: aload_1
    //   168: astore #5
    //   170: aload #7
    //   172: invokevirtual getName : ()Ljava/lang/String;
    //   175: aload #11
    //   177: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   180: istore #4
    //   182: iload #4
    //   184: ifeq -> 137
    //   187: iconst_1
    //   188: istore_2
    //   189: iload_2
    //   190: ifeq -> 200
    //   193: aload_1
    //   194: invokevirtual close : ()V
    //   197: goto -> 45
    //   200: aload_1
    //   201: astore #5
    //   203: aload_0
    //   204: aload #6
    //   206: aload #7
    //   208: iconst_1
    //   209: invokevirtual a : (Ljava/io/OutputStream;Ljava/util/zip/ZipEntry;I)V
    //   212: aload_1
    //   213: astore #5
    //   215: aload_0
    //   216: aload #6
    //   218: aload_1
    //   219: aload #8
    //   221: invokevirtual a : (Ljava/io/OutputStream;Ljava/io/InputStream;[B)V
    //   224: goto -> 193
    //   227: astore_1
    //   228: goto -> 258
    //   231: astore #7
    //   233: goto -> 247
    //   236: astore_1
    //   237: aconst_null
    //   238: astore #5
    //   240: goto -> 258
    //   243: astore #7
    //   245: aconst_null
    //   246: astore_1
    //   247: aload_1
    //   248: astore #5
    //   250: aload #7
    //   252: invokevirtual printStackTrace : ()V
    //   255: goto -> 193
    //   258: aload #5
    //   260: invokevirtual close : ()V
    //   263: aload_1
    //   264: athrow
    //   265: aload #6
    //   267: invokevirtual close : ()V
    //   270: return
    //   271: astore_1
    //   272: goto -> 319
    //   275: astore #5
    //   277: aload #6
    //   279: astore_1
    //   280: aload #5
    //   282: astore #6
    //   284: goto -> 300
    //   287: astore_1
    //   288: aload #5
    //   290: astore #6
    //   292: goto -> 319
    //   295: astore #6
    //   297: aload #7
    //   299: astore_1
    //   300: aload_1
    //   301: astore #5
    //   303: aload #6
    //   305: invokevirtual printStackTrace : ()V
    //   308: aload_1
    //   309: invokevirtual close : ()V
    //   312: return
    //   313: astore_1
    //   314: aload_1
    //   315: invokevirtual printStackTrace : ()V
    //   318: return
    //   319: aload #6
    //   321: invokevirtual close : ()V
    //   324: goto -> 334
    //   327: astore #5
    //   329: aload #5
    //   331: invokevirtual printStackTrace : ()V
    //   334: aload_1
    //   335: athrow
    // Exception table:
    //   from	to	target	type
    //   6	16	295	java/lang/Exception
    //   6	16	287	finally
    //   16	45	275	java/lang/Exception
    //   16	45	271	finally
    //   45	80	275	java/lang/Exception
    //   45	80	271	finally
    //   80	85	243	java/lang/Exception
    //   80	85	236	finally
    //   88	96	231	java/lang/Exception
    //   88	96	227	finally
    //   99	108	231	java/lang/Exception
    //   99	108	227	finally
    //   114	121	231	java/lang/Exception
    //   114	121	227	finally
    //   126	137	231	java/lang/Exception
    //   126	137	227	finally
    //   142	152	231	java/lang/Exception
    //   142	152	227	finally
    //   155	167	231	java/lang/Exception
    //   155	167	227	finally
    //   170	182	231	java/lang/Exception
    //   170	182	227	finally
    //   193	197	275	java/lang/Exception
    //   193	197	271	finally
    //   203	212	231	java/lang/Exception
    //   203	212	227	finally
    //   215	224	231	java/lang/Exception
    //   215	224	227	finally
    //   250	255	227	finally
    //   258	265	275	java/lang/Exception
    //   258	265	271	finally
    //   265	270	313	java/io/IOException
    //   303	308	287	finally
    //   308	312	313	java/io/IOException
    //   319	324	327	java/io/IOException
  }
  
  private void a(InputStream paramInputStream) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: aload_0
    //   8: new java/util/ArrayList
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: putfield f : Ljava/util/ArrayList;
    //   18: aload_3
    //   19: astore_2
    //   20: new java/io/BufferedReader
    //   23: dup
    //   24: new java/io/InputStreamReader
    //   27: dup
    //   28: aload_1
    //   29: ldc_w 'UTF-8'
    //   32: invokespecial <init> : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   35: sipush #512
    //   38: invokespecial <init> : (Ljava/io/Reader;I)V
    //   41: astore_3
    //   42: aload_3
    //   43: invokevirtual readLine : ()Ljava/lang/String;
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull -> 80
    //   51: aload_2
    //   52: invokevirtual trim : ()Ljava/lang/String;
    //   55: astore_2
    //   56: aload_2
    //   57: ldc 'assets/webkit/order.info'
    //   59: invokevirtual equals : (Ljava/lang/Object;)Z
    //   62: ifeq -> 68
    //   65: goto -> 42
    //   68: aload_0
    //   69: getfield f : Ljava/util/ArrayList;
    //   72: aload_2
    //   73: invokevirtual add : (Ljava/lang/Object;)Z
    //   76: pop
    //   77: goto -> 42
    //   80: aload_3
    //   81: invokevirtual close : ()V
    //   84: goto -> 92
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual printStackTrace : ()V
    //   92: aload_1
    //   93: invokevirtual close : ()V
    //   96: return
    //   97: astore_2
    //   98: goto -> 157
    //   101: astore_2
    //   102: aload_2
    //   103: astore #4
    //   105: goto -> 123
    //   108: astore #4
    //   110: aload_2
    //   111: astore_3
    //   112: aload #4
    //   114: astore_2
    //   115: goto -> 157
    //   118: astore #4
    //   120: aload #5
    //   122: astore_3
    //   123: aload_3
    //   124: astore_2
    //   125: aload #4
    //   127: invokevirtual printStackTrace : ()V
    //   130: aload_3
    //   131: ifnull -> 146
    //   134: aload_3
    //   135: invokevirtual close : ()V
    //   138: goto -> 146
    //   141: astore_2
    //   142: aload_2
    //   143: invokevirtual printStackTrace : ()V
    //   146: aload_1
    //   147: invokevirtual close : ()V
    //   150: return
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual printStackTrace : ()V
    //   156: return
    //   157: aload_3
    //   158: ifnull -> 173
    //   161: aload_3
    //   162: invokevirtual close : ()V
    //   165: goto -> 173
    //   168: astore_3
    //   169: aload_3
    //   170: invokevirtual printStackTrace : ()V
    //   173: aload_1
    //   174: invokevirtual close : ()V
    //   177: goto -> 185
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual printStackTrace : ()V
    //   185: aload_2
    //   186: athrow
    // Exception table:
    //   from	to	target	type
    //   7	18	118	java/lang/Exception
    //   7	18	108	finally
    //   20	42	118	java/lang/Exception
    //   20	42	108	finally
    //   42	47	101	java/lang/Exception
    //   42	47	97	finally
    //   51	65	101	java/lang/Exception
    //   51	65	97	finally
    //   68	77	101	java/lang/Exception
    //   68	77	97	finally
    //   80	84	87	java/io/IOException
    //   92	96	151	java/io/IOException
    //   125	130	108	finally
    //   134	138	141	java/io/IOException
    //   146	150	151	java/io/IOException
    //   161	165	168	java/io/IOException
    //   173	177	180	java/io/IOException
  }
  
  private void a(InputStream paramInputStream, ZipOutputStream paramZipOutputStream) {
    CRC32 cRC32 = null;
    while (paramInputStream.available() > 0) {
      d d = this.c.d(paramInputStream);
      List list = d.h;
      byte[] arrayOfByte = new byte[2048];
      long l = 0L;
      ZipEntry zipEntry = new ZipEntry(d.b);
      if (d.e == 0)
        cRC32 = new CRC32(); 
      paramZipOutputStream.putNextEntry(zipEntry);
      if (d.a == 1)
        while (true) {
          long l1 = 2048L + l;
          if (l1 < d.c) {
            paramInputStream.read(arrayOfByte);
            if (cRC32 != null)
              cRC32.update(arrayOfByte); 
            paramZipOutputStream.write(arrayOfByte, 0, 2048);
            l = l1;
            continue;
          } 
          int i = (int)(d.c - l);
          arrayOfByte = new byte[i];
          paramInputStream.read(arrayOfByte);
          if (cRC32 != null)
            cRC32.update(arrayOfByte); 
          paramZipOutputStream.write(arrayOfByte, 0, i);
          break;
        }  
      this.a.put(d.b, Long.valueOf(d.d));
    } 
  }
  
  private void b(File paramFile) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #7
    //   3: aconst_null
    //   4: astore #5
    //   6: new java/io/FileOutputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial <init> : (Ljava/io/File;)V
    //   14: astore #6
    //   16: aload_0
    //   17: aload #6
    //   19: invokevirtual a : (Ljava/io/OutputStream;)V
    //   22: sipush #8192
    //   25: newarray byte
    //   27: astore #8
    //   29: aload_0
    //   30: getfield f : Ljava/util/ArrayList;
    //   33: invokevirtual iterator : ()Ljava/util/Iterator;
    //   36: astore #9
    //   38: aload #9
    //   40: invokeinterface hasNext : ()Z
    //   45: ifeq -> 264
    //   48: aload #9
    //   50: invokeinterface next : ()Ljava/lang/Object;
    //   55: checkcast java/lang/String
    //   58: astore_1
    //   59: aload_0
    //   60: getfield g : Ljava/util/Map;
    //   63: aload_1
    //   64: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   69: checkcast com/tencent/tbs/sdk/extension/partner/incrupdate/a/a/a$a
    //   72: astore_1
    //   73: aload_1
    //   74: getfield a : Ljava/util/zip/ZipEntry;
    //   77: astore #7
    //   79: aload_1
    //   80: getfield b : Ljava/io/InputStream;
    //   83: astore_1
    //   84: aload_1
    //   85: astore #5
    //   87: aload #7
    //   89: invokevirtual isDirectory : ()Z
    //   92: ifeq -> 110
    //   95: aload_1
    //   96: astore #5
    //   98: aload_0
    //   99: aload #6
    //   101: aload #7
    //   103: iconst_2
    //   104: invokevirtual a : (Ljava/io/OutputStream;Ljava/util/zip/ZipEntry;I)V
    //   107: goto -> 192
    //   110: aload_1
    //   111: astore #5
    //   113: aload_0
    //   114: getfield d : Ljava/util/List;
    //   117: ifnull -> 199
    //   120: iconst_0
    //   121: istore_3
    //   122: aload_1
    //   123: astore #5
    //   125: aload_0
    //   126: getfield d : Ljava/util/List;
    //   129: invokeinterface iterator : ()Ljava/util/Iterator;
    //   134: astore #10
    //   136: iload_3
    //   137: istore_2
    //   138: aload_1
    //   139: astore #5
    //   141: aload #10
    //   143: invokeinterface hasNext : ()Z
    //   148: ifeq -> 188
    //   151: aload_1
    //   152: astore #5
    //   154: aload #10
    //   156: invokeinterface next : ()Ljava/lang/Object;
    //   161: checkcast java/lang/String
    //   164: astore #11
    //   166: aload_1
    //   167: astore #5
    //   169: aload #7
    //   171: invokevirtual getName : ()Ljava/lang/String;
    //   174: aload #11
    //   176: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   179: istore #4
    //   181: iload #4
    //   183: ifeq -> 136
    //   186: iconst_1
    //   187: istore_2
    //   188: iload_2
    //   189: ifeq -> 199
    //   192: aload_1
    //   193: invokevirtual close : ()V
    //   196: goto -> 38
    //   199: aload_1
    //   200: astore #5
    //   202: aload_0
    //   203: aload #6
    //   205: aload #7
    //   207: iconst_1
    //   208: invokevirtual a : (Ljava/io/OutputStream;Ljava/util/zip/ZipEntry;I)V
    //   211: aload_1
    //   212: astore #5
    //   214: aload_0
    //   215: aload #6
    //   217: aload_1
    //   218: aload #8
    //   220: invokevirtual a : (Ljava/io/OutputStream;Ljava/io/InputStream;[B)V
    //   223: goto -> 192
    //   226: astore_1
    //   227: goto -> 257
    //   230: astore #7
    //   232: goto -> 246
    //   235: astore_1
    //   236: aconst_null
    //   237: astore #5
    //   239: goto -> 257
    //   242: astore #7
    //   244: aconst_null
    //   245: astore_1
    //   246: aload_1
    //   247: astore #5
    //   249: aload #7
    //   251: invokevirtual printStackTrace : ()V
    //   254: goto -> 192
    //   257: aload #5
    //   259: invokevirtual close : ()V
    //   262: aload_1
    //   263: athrow
    //   264: aload #6
    //   266: invokevirtual close : ()V
    //   269: return
    //   270: astore_1
    //   271: goto -> 318
    //   274: astore #5
    //   276: aload #6
    //   278: astore_1
    //   279: aload #5
    //   281: astore #6
    //   283: goto -> 299
    //   286: astore_1
    //   287: aload #5
    //   289: astore #6
    //   291: goto -> 318
    //   294: astore #6
    //   296: aload #7
    //   298: astore_1
    //   299: aload_1
    //   300: astore #5
    //   302: aload #6
    //   304: invokevirtual printStackTrace : ()V
    //   307: aload_1
    //   308: invokevirtual close : ()V
    //   311: return
    //   312: astore_1
    //   313: aload_1
    //   314: invokevirtual printStackTrace : ()V
    //   317: return
    //   318: aload #6
    //   320: invokevirtual close : ()V
    //   323: goto -> 333
    //   326: astore #5
    //   328: aload #5
    //   330: invokevirtual printStackTrace : ()V
    //   333: aload_1
    //   334: athrow
    // Exception table:
    //   from	to	target	type
    //   6	16	294	java/lang/Exception
    //   6	16	286	finally
    //   16	38	274	java/lang/Exception
    //   16	38	270	finally
    //   38	79	274	java/lang/Exception
    //   38	79	270	finally
    //   79	84	242	java/lang/Exception
    //   79	84	235	finally
    //   87	95	230	java/lang/Exception
    //   87	95	226	finally
    //   98	107	230	java/lang/Exception
    //   98	107	226	finally
    //   113	120	230	java/lang/Exception
    //   113	120	226	finally
    //   125	136	230	java/lang/Exception
    //   125	136	226	finally
    //   141	151	230	java/lang/Exception
    //   141	151	226	finally
    //   154	166	230	java/lang/Exception
    //   154	166	226	finally
    //   169	181	230	java/lang/Exception
    //   169	181	226	finally
    //   192	196	274	java/lang/Exception
    //   192	196	270	finally
    //   202	211	230	java/lang/Exception
    //   202	211	226	finally
    //   214	223	230	java/lang/Exception
    //   214	223	226	finally
    //   249	254	226	finally
    //   257	264	274	java/lang/Exception
    //   257	264	270	finally
    //   264	269	312	java/io/IOException
    //   302	307	286	finally
    //   307	311	312	java/io/IOException
    //   318	323	326	java/io/IOException
  }
  
  protected List<b> a(d paramd) {
    if (this.e != null && this.e.size() > 0) {
      ArrayList<b> arrayList = new ArrayList();
      Iterator<String> iterator = this.e.iterator();
      while (true) {
        ArrayList<b> arrayList1 = arrayList;
        if (iterator.hasNext()) {
          String str = iterator.next();
          b b = new b();
          b.a(b.a, str);
          arrayList.add(b);
          continue;
        } 
        break;
      } 
    } else {
      paramd = null;
    } 
    return (List<b>)paramd;
  }
  
  protected List<b> a(f paramf) {
    return null;
  }
  
  public boolean a(Context paramContext, File paramFile1, File paramFile2) {
    boolean bool = false;
    Context context2 = null;
    Context context1 = null;
    try {
      ZipFile zipFile = new ZipFile(paramFile1);
    } catch (Exception exception) {
    
    } finally {
      Context context;
      paramContext = null;
    } 
    context1 = paramContext;
    exception.printStackTrace();
    if (paramContext != null)
      try {
        paramContext.close();
        return false;
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    return false;
  }
  
  public boolean a(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong) {
    byte[] arrayOfByte = new byte[8192];
    CRC32 cRC32 = new CRC32();
    while (true) {
      boolean bool2 = false;
      boolean bool1 = false;
      try {
        int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
        if (i == -1) {
          long l = cRC32.getValue();
          if (l == paramLong)
            bool1 = true; 
          try {
            paramInputStream.close();
          } catch (Exception null) {
            exception.printStackTrace();
          } 
          bool2 = bool1;
          try {
            paramOutputStream.close();
            return bool1;
          } catch (Exception null) {
            exception.printStackTrace();
            return bool2;
          } 
        } 
        paramOutputStream.write(arrayOfByte, 0, i);
        cRC32.update(arrayOfByte, 0, i);
        continue;
      } catch (Exception exception1) {
        exception1.printStackTrace();
        try {
          exception.close();
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        paramOutputStream.close();
        return false;
      } finally {}
      try {
        exception.close();
      } catch (Exception exception1) {
        exception1.printStackTrace();
      } 
      try {
        paramOutputStream.close();
      } catch (Exception exception1) {
        exception1.printStackTrace();
      } 
      throw arrayOfByte;
    } 
  }
  
  public boolean a(String paramString1, String paramString2) {
    try {
      File file = new File(paramString1);
      ZipOutputStream zipOutputStream = null;
      try {
        FileInputStream fileInputStream = new FileInputStream(file);
      } finally {
        file = null;
      } 
      if (zipOutputStream != null)
        zipOutputStream.close(); 
      if (paramString2 != null)
        paramString2.close(); 
      throw file;
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
      return false;
    } catch (Exception exception) {
      exception.printStackTrace();
      return false;
    } 
  }
  
  private class a {
    ZipEntry a;
    
    InputStream b;
    
    private a(a this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\incrupdate\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */