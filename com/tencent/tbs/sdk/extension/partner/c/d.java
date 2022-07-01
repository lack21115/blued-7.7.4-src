package com.tencent.tbs.sdk.extension.partner.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.tbs.sdk.extension.TbsSDKExtension;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class d {
  public static final a a = new a() {
    
    };
  
  private static final int b = 4;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static int a(Context paramContext, String paramString) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
      if (packageInfo != null)
        return packageInfo.versionCode; 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return 0;
  }
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream) {
    if (paramInputStream == null)
      return -1L; 
    byte[] arrayOfByte = new byte[4096];
    long l = 0L;
    while (true) {
      int i = paramInputStream.read(arrayOfByte);
      if (-1 != i) {
        paramOutputStream.write(arrayOfByte, 0, i);
        l += i;
        continue;
      } 
      return l;
    } 
  }
  
  public static long a(String paramString) {
    try {
      StatFs statFs = new StatFs(paramString);
      statFs.restat(paramString);
      long l = statFs.getBlockSize();
      int i = statFs.getAvailableBlocks();
      return l * i;
    } catch (Exception exception) {
      return 0L;
    } 
  }
  
  private static PackageInfo a(String paramString, int paramInt) {
    // Byte code:
    //   0: ldc 'android.content.pm.PackageParser'
    //   2: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore #6
    //   7: aload #6
    //   9: invokevirtual getDeclaredClasses : ()[Ljava/lang/Class;
    //   12: astore #5
    //   14: aload #5
    //   16: arraylength
    //   17: istore_3
    //   18: iconst_0
    //   19: istore_2
    //   20: iload_2
    //   21: iload_3
    //   22: if_icmpge -> 349
    //   25: aload #5
    //   27: iload_2
    //   28: aaload
    //   29: astore #4
    //   31: aload #4
    //   33: invokevirtual getName : ()Ljava/lang/String;
    //   36: ldc 'android.content.pm.PackageParser$Package'
    //   38: invokevirtual compareTo : (Ljava/lang/String;)I
    //   41: ifne -> 342
    //   44: goto -> 47
    //   47: aload #6
    //   49: iconst_1
    //   50: anewarray java/lang/Class
    //   53: dup
    //   54: iconst_0
    //   55: ldc java/lang/String
    //   57: aastore
    //   58: invokevirtual getConstructor : ([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   61: astore #8
    //   63: aload #6
    //   65: ldc 'parsePackage'
    //   67: iconst_4
    //   68: anewarray java/lang/Class
    //   71: dup
    //   72: iconst_0
    //   73: ldc java/io/File
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: ldc java/lang/String
    //   80: aastore
    //   81: dup
    //   82: iconst_2
    //   83: ldc android/util/DisplayMetrics
    //   85: aastore
    //   86: dup
    //   87: iconst_3
    //   88: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   91: aastore
    //   92: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   95: astore #7
    //   97: aload #6
    //   99: ldc 'collectCertificatbs'
    //   101: iconst_2
    //   102: anewarray java/lang/Class
    //   105: dup
    //   106: iconst_0
    //   107: aload #4
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   115: aastore
    //   116: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   119: astore #5
    //   121: aload #6
    //   123: ldc 'generatePackageInfo'
    //   125: iconst_5
    //   126: anewarray java/lang/Class
    //   129: dup
    //   130: iconst_0
    //   131: aload #4
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: ldc [I
    //   138: aastore
    //   139: dup
    //   140: iconst_2
    //   141: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   144: aastore
    //   145: dup
    //   146: iconst_3
    //   147: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   150: aastore
    //   151: dup
    //   152: iconst_4
    //   153: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   156: aastore
    //   157: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   160: astore #4
    //   162: aload #8
    //   164: iconst_1
    //   165: invokevirtual setAccessible : (Z)V
    //   168: aload #7
    //   170: iconst_1
    //   171: invokevirtual setAccessible : (Z)V
    //   174: aload #5
    //   176: iconst_1
    //   177: invokevirtual setAccessible : (Z)V
    //   180: aload #4
    //   182: iconst_1
    //   183: invokevirtual setAccessible : (Z)V
    //   186: aload #8
    //   188: iconst_1
    //   189: anewarray java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: aload_0
    //   195: aastore
    //   196: invokevirtual newInstance : ([Ljava/lang/Object;)Ljava/lang/Object;
    //   199: astore #6
    //   201: new android/util/DisplayMetrics
    //   204: dup
    //   205: invokespecial <init> : ()V
    //   208: astore #8
    //   210: aload #8
    //   212: invokevirtual setToDefaults : ()V
    //   215: aload #7
    //   217: aload #6
    //   219: iconst_4
    //   220: anewarray java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: new java/io/File
    //   228: dup
    //   229: aload_0
    //   230: invokespecial <init> : (Ljava/lang/String;)V
    //   233: aastore
    //   234: dup
    //   235: iconst_1
    //   236: aload_0
    //   237: aastore
    //   238: dup
    //   239: iconst_2
    //   240: aload #8
    //   242: aastore
    //   243: dup
    //   244: iconst_3
    //   245: iconst_0
    //   246: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   249: aastore
    //   250: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   253: astore_0
    //   254: aload_0
    //   255: ifnonnull -> 260
    //   258: aconst_null
    //   259: areturn
    //   260: iload_1
    //   261: bipush #64
    //   263: iand
    //   264: ifeq -> 290
    //   267: aload #5
    //   269: aload #6
    //   271: iconst_2
    //   272: anewarray java/lang/Object
    //   275: dup
    //   276: iconst_0
    //   277: aload_0
    //   278: aastore
    //   279: dup
    //   280: iconst_1
    //   281: iconst_0
    //   282: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   285: aastore
    //   286: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   289: pop
    //   290: aload #4
    //   292: aconst_null
    //   293: iconst_5
    //   294: anewarray java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload_0
    //   300: aastore
    //   301: dup
    //   302: iconst_1
    //   303: aconst_null
    //   304: aastore
    //   305: dup
    //   306: iconst_2
    //   307: iload_1
    //   308: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   311: aastore
    //   312: dup
    //   313: iconst_3
    //   314: iconst_0
    //   315: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   318: aastore
    //   319: dup
    //   320: iconst_4
    //   321: iconst_0
    //   322: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   325: aastore
    //   326: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   329: checkcast android/content/pm/PackageInfo
    //   332: astore_0
    //   333: aload_0
    //   334: areturn
    //   335: astore_0
    //   336: aload_0
    //   337: invokevirtual printStackTrace : ()V
    //   340: aconst_null
    //   341: areturn
    //   342: iload_2
    //   343: iconst_1
    //   344: iadd
    //   345: istore_2
    //   346: goto -> 20
    //   349: aconst_null
    //   350: astore #4
    //   352: goto -> 47
    // Exception table:
    //   from	to	target	type
    //   0	18	335	java/lang/Exception
    //   31	44	335	java/lang/Exception
    //   47	254	335	java/lang/Exception
    //   267	290	335	java/lang/Exception
    //   290	333	335	java/lang/Exception
  }
  
  public static FileOutputStream a(File paramFile) {
    if (paramFile.exists()) {
      if (!paramFile.isDirectory()) {
        if (!paramFile.canWrite()) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("File '");
          stringBuilder.append(paramFile);
          stringBuilder.append("' cannot be written to");
          throw new IOException(stringBuilder.toString());
        } 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("File '");
        stringBuilder.append(paramFile);
        stringBuilder.append("' exists but is a directory");
        throw new IOException(stringBuilder.toString());
      } 
    } else {
      File file = paramFile.getParentFile();
      if (file != null && !file.exists() && !file.mkdirs()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("File '");
        stringBuilder.append(paramFile);
        stringBuilder.append("' could not be created");
        throw new IOException(stringBuilder.toString());
      } 
    } 
    return new FileOutputStream(paramFile);
  }
  
  public static String a(Context paramContext) {
    String str = "";
    try {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(Environment.getExternalStorageDirectory());
      stringBuilder1.append(File.separator);
      String str1 = stringBuilder1.toString();
      str = str1;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    if (str.equals(""))
      return str; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("tencent");
    stringBuilder.append(File.separator);
    stringBuilder.append("tbs");
    stringBuilder.append(File.separator);
    stringBuilder.append((paramContext.getApplicationInfo()).packageName);
    return stringBuilder.toString();
  }
  
  private static String a(Context paramContext, File paramFile, boolean paramBoolean) {
    PackageInfo packageInfo;
    String str;
    File file = null;
    if (paramBoolean) {
      packageInfo = a(paramFile.getAbsolutePath(), 65);
    } else {
      packageInfo.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 65);
      packageInfo = null;
    } 
    if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
      Signature signature = packageInfo.signatures[0];
    } else {
      packageInfo = null;
    } 
    paramFile = file;
    if (packageInfo != null)
      str = packageInfo.toCharsString(); 
    return str;
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    int j = paramArrayOfbyte.length;
    char[] arrayOfChar = new char[j * 2];
    for (int i = 0; i < j; i++) {
      byte b = paramArrayOfbyte[i];
      int k = b >> 4 & 0xF;
      int m = i * 2;
      if (k >= 10) {
        k = k + 97 - 10;
      } else {
        k += 48;
      } 
      arrayOfChar[m] = (char)k;
      k = b & 0xF;
      if (k >= 10) {
        k = k + 97 - 10;
      } else {
        k += 48;
      } 
      arrayOfChar[m + 1] = (char)k;
    } 
    return new String(arrayOfChar);
  }
  
  public static void a(String paramString1, String paramString2) {
    File file1 = new File(paramString1);
    File file2 = new File(paramString2);
    if (file1.exists())
      file1.renameTo(file2); 
  }
  
  public static boolean a(Context paramContext, File paramFile) {
    try {
      if (!b(paramFile))
        return false; 
      if (paramContext.getApplicationContext().getPackageName().contains("com.jd.jrapp")) {
        String str = c(paramFile);
        if (str != null) {
          boolean bool = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(str);
          if (bool)
            return true; 
        } 
      } 
    } catch (Throwable throwable) {}
    String str2 = a(paramContext, paramFile, false);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[verifyTbsApk]  android api signature=");
    stringBuilder.append(str2);
    stringBuilder.toString();
    String str1 = str2;
    if (str2 == null) {
      str1 = c(paramFile);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("[verifyTbsApk]  java get signature=");
      stringBuilder1.append(str1);
      stringBuilder1.toString();
    } 
    str2 = str1;
    if (str1 == null) {
      str2 = a(paramContext, paramFile, true);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("[verifyTbsApk]  android reflection signature=");
      stringBuilder1.append(str2);
      stringBuilder1.toString();
    } 
    return !!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(str2);
  }
  
  private static Certificate[] a(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfbyte) {
    JarFile jarFile = null;
    try {
      InputStream inputStream = paramJarFile.getInputStream(paramJarEntry);
      try {
        Certificate[] arrayOfCertificate;
        while (inputStream.read(paramArrayOfbyte, 0, paramArrayOfbyte.length) != -1);
        inputStream.close();
        paramJarFile = jarFile;
        if (paramJarEntry != null)
          arrayOfCertificate = paramJarEntry.getCertificates(); 
        return arrayOfCertificate;
      } catch (IOException null) {
        InputStream inputStream1 = inputStream;
      } 
    } catch (IOException iOException) {
      paramJarEntry = null;
    } 
    if (paramJarEntry != null)
      try {
        paramJarEntry.close();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    iOException.printStackTrace();
    return null;
  }
  
  public static int b(InputStream paramInputStream, OutputStream paramOutputStream) {
    long l = a(paramInputStream, paramOutputStream);
    return (l > 2147483647L) ? -1 : (int)l;
  }
  
  public static File b(Context paramContext) {
    File file = new File(TbsSDKExtension.getTbsFolderDir(paramContext), "core_private");
    return (!file.isDirectory() && !file.mkdir()) ? null : file;
  }
  
  public static String b(String paramString1, String paramString2) {
    paramString1 = (new File(paramString1)).getAbsolutePath();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1.substring(0, paramString1.lastIndexOf("/")));
    stringBuilder.append("/");
    stringBuilder.append(paramString2);
    return stringBuilder.toString();
  }
  
  public static void b(String paramString) {
    File file = new File(paramString);
    if (file.exists())
      file.delete(); 
  }
  
  private static boolean b(File paramFile) {
    Exception exception1;
    File file = null;
    Exception exception3 = null;
    Exception exception2 = exception3;
    try {
      byte[] arrayOfByte = new byte[2];
      exception2 = exception3;
    } catch (Exception exception) {
    
    } finally {
      exception3 = null;
      exception1 = exception2;
    } 
    exception2 = exception1;
    exception3.printStackTrace();
    if (exception1 != null)
      exception1.close(); 
    return true;
  }
  
  private static String c(File paramFile) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new java/util/jar/JarFile
    //   7: dup
    //   8: aload_0
    //   9: invokespecial <init> : (Ljava/io/File;)V
    //   12: astore_1
    //   13: aload_1
    //   14: astore_0
    //   15: aload_1
    //   16: aload_1
    //   17: ldc_w 'AndroidManifest.xml'
    //   20: invokevirtual getJarEntry : (Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   23: sipush #8192
    //   26: newarray byte
    //   28: invokestatic a : (Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;[B)[Ljava/security/cert/Certificate;
    //   31: astore #4
    //   33: aload_2
    //   34: astore_0
    //   35: aload #4
    //   37: ifnull -> 55
    //   40: aload_1
    //   41: astore_0
    //   42: aload #4
    //   44: iconst_0
    //   45: aaload
    //   46: invokevirtual getEncoded : ()[B
    //   49: invokestatic a : ([B)Ljava/lang/String;
    //   52: astore_2
    //   53: aload_2
    //   54: astore_0
    //   55: aload_0
    //   56: astore_2
    //   57: aload_1
    //   58: invokevirtual close : ()V
    //   61: aload_0
    //   62: areturn
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual printStackTrace : ()V
    //   68: aload_2
    //   69: areturn
    //   70: astore_2
    //   71: goto -> 83
    //   74: astore_1
    //   75: aconst_null
    //   76: astore_0
    //   77: goto -> 102
    //   80: astore_2
    //   81: aconst_null
    //   82: astore_1
    //   83: aload_1
    //   84: astore_0
    //   85: aload_2
    //   86: invokevirtual printStackTrace : ()V
    //   89: aload_1
    //   90: ifnull -> 99
    //   93: aload_3
    //   94: astore_2
    //   95: aload_1
    //   96: invokevirtual close : ()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_1
    //   102: aload_0
    //   103: ifnull -> 118
    //   106: aload_0
    //   107: invokevirtual close : ()V
    //   110: goto -> 118
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual printStackTrace : ()V
    //   118: aload_1
    //   119: athrow
    // Exception table:
    //   from	to	target	type
    //   4	13	80	java/lang/Exception
    //   4	13	74	finally
    //   15	33	70	java/lang/Exception
    //   15	33	101	finally
    //   42	53	70	java/lang/Exception
    //   42	53	101	finally
    //   57	61	63	java/io/IOException
    //   85	89	101	finally
    //   95	99	63	java/io/IOException
    //   106	110	113	java/io/IOException
  }
  
  public static boolean c(String paramString) {
    return (new File(paramString)).exists();
  }
  
  public static interface a {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */