package com.baidu.mobads.f;

import android.content.Context;
import android.util.Base64;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class b extends File {
  private static DexClassLoader f;
  
  private e a;
  
  private Class<?> b = null;
  
  private Context c = null;
  
  private PublicKey d;
  
  private IXAdLogger e = XAdSDKFoundationFacade.getInstance().getAdLogger();
  
  public b(String paramString, Context paramContext) {
    this(paramString, paramContext, (e)null);
  }
  
  public b(String paramString, Context paramContext, e parame) {
    super(paramString);
    this.c = paramContext;
    this.a = parame;
    if (parame != null)
      try {
        this.d = c("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB");
        return;
      } catch (Exception exception) {
        this.d = null;
      }  
  }
  
  private String a(File paramFile) {
    MessageDigest messageDigest1;
    Exception exception;
    StringBuilder stringBuilder;
    byte[] arrayOfByte = null;
    MessageDigest messageDigest2 = null;
    try {
    
    } catch (Exception null) {
    
    } finally {
      Exception exception1;
      exception = null;
      messageDigest1 = messageDigest2;
    } 
    messageDigest2 = messageDigest1;
    this.e.d("XAdLocalApkFile", exception.getMessage());
    if (messageDigest1 != null)
      try {
        messageDigest1.close();
        return "";
      } catch (Exception exception1) {
        this.e.d("XAdLocalApkFile", exception1.getMessage());
      }  
    return "";
  }
  
  private Class<?> b(File paramFile) {
    // Byte code:
    //   0: aload_0
    //   1: getfield e : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   4: astore_2
    //   5: new java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore_3
    //   13: aload_3
    //   14: ldc 'Android version:'
    //   16: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_3
    //   21: getstatic android/os/Build$VERSION.RELEASE : Ljava/lang/String;
    //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: ldc 'XAdLocalApkFile'
    //   31: aload_3
    //   32: invokevirtual toString : ()Ljava/lang/String;
    //   35: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: aconst_null
    //   42: astore_2
    //   43: ldc com/baidu/mobads/f/g
    //   45: monitorenter
    //   46: aload_1
    //   47: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   50: astore_3
    //   51: aload_0
    //   52: invokevirtual getClass : ()Ljava/lang/Class;
    //   55: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   58: astore #4
    //   60: aload_0
    //   61: getfield c : Landroid/content/Context;
    //   64: invokevirtual getFilesDir : ()Ljava/io/File;
    //   67: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   70: astore #5
    //   72: invokestatic currentTimeMillis : ()J
    //   75: putstatic com/baidu/mobads/constants/a.o : J
    //   78: new dalvik/system/DexClassLoader
    //   81: dup
    //   82: aload_3
    //   83: aload #5
    //   85: aconst_null
    //   86: aload #4
    //   88: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   91: astore #6
    //   93: invokestatic currentTimeMillis : ()J
    //   96: putstatic com/baidu/mobads/constants/a.p : J
    //   99: aload #6
    //   101: putstatic com/baidu/mobads/f/b.f : Ldalvik/system/DexClassLoader;
    //   104: aload_0
    //   105: getfield e : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   108: astore #7
    //   110: new java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial <init> : ()V
    //   117: astore #8
    //   119: aload #8
    //   121: ldc 'dexPath='
    //   123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload #8
    //   129: aload_3
    //   130: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload #8
    //   136: ldc ', cl='
    //   138: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload #8
    //   144: aload #4
    //   146: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload #8
    //   152: ldc ', dir='
    //   154: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload #8
    //   160: aload #5
    //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload #8
    //   168: ldc ', loader='
    //   170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload #8
    //   176: aload #6
    //   178: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload #8
    //   184: ldc ', len='
    //   186: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload #8
    //   192: aload_1
    //   193: invokevirtual length : ()J
    //   196: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload #8
    //   202: ldc ', list='
    //   204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload #8
    //   210: aload_1
    //   211: invokevirtual list : ()[Ljava/lang/String;
    //   214: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload #7
    //   220: ldc 'XAdLocalApkFile'
    //   222: aload #8
    //   224: invokevirtual toString : ()Ljava/lang/String;
    //   227: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   232: pop
    //   233: ldc 'com.baidu.mobads.container.AllInOneXAdContainerFactory'
    //   235: iconst_1
    //   236: aload #6
    //   238: invokestatic forName : (Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   241: astore_3
    //   242: ldc com/baidu/mobads/f/g
    //   244: monitorexit
    //   245: aload_3
    //   246: astore_2
    //   247: goto -> 279
    //   250: astore_3
    //   251: ldc com/baidu/mobads/f/g
    //   253: monitorexit
    //   254: aload_3
    //   255: athrow
    //   256: astore_1
    //   257: goto -> 342
    //   260: astore_3
    //   261: aload_3
    //   262: invokevirtual getMessage : ()Ljava/lang/String;
    //   265: astore_3
    //   266: aload_0
    //   267: getfield e : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   270: ldc 'XAdLocalApkFile'
    //   272: aload_3
    //   273: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   278: pop
    //   279: aload_0
    //   280: getfield e : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   283: astore_3
    //   284: new java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial <init> : ()V
    //   291: astore #4
    //   293: aload #4
    //   295: ldc 'jar.path='
    //   297: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload #4
    //   303: aload_1
    //   304: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   307: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload #4
    //   313: ldc ', clz='
    //   315: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload #4
    //   321: aload_2
    //   322: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_3
    //   327: ldc 'XAdLocalApkFile'
    //   329: aload #4
    //   331: invokevirtual toString : ()Ljava/lang/String;
    //   334: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   339: pop
    //   340: aload_2
    //   341: areturn
    //   342: aload_1
    //   343: athrow
    // Exception table:
    //   from	to	target	type
    //   43	46	260	java/lang/Exception
    //   43	46	256	finally
    //   46	245	250	finally
    //   251	254	250	finally
    //   254	256	260	java/lang/Exception
    //   254	256	256	finally
    //   261	279	256	finally
  }
  
  private String b(String paramString) {
    if (this.d != null) {
      byte[] arrayOfByte = Base64.decode(paramString, 0);
      try {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, this.d);
        return (new String(cipher.doFinal(arrayOfByte), "UTF-8")).trim();
      } catch (Exception exception) {
        this.e.e("ErrorWhileVerifySigNature", exception);
      } 
    } 
    return null;
  }
  
  private static PublicKey c(String paramString) {
    try {
      byte[] arrayOfByte = Base64.decode(paramString, 0);
      return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(arrayOfByte));
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new Exception("NoSuchAlgorithmException");
    } catch (InvalidKeySpecException invalidKeySpecException) {
      throw new Exception("InvalidKeySpecException");
    } catch (NullPointerException nullPointerException) {
      throw new Exception("NullPointerException");
    } 
  }
  
  public static DexClassLoader d() {
    return f;
  }
  
  protected void a() {
    if (this.a != null) {
      String str1 = a(new File(getAbsolutePath()));
      String str2 = b(this.a.d());
      if (str2.equalsIgnoreCase(str1))
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("doCheckApkIntegrity failed, md5sum: ");
      stringBuilder.append(str1);
      stringBuilder.append(", checksum in json info: ");
      stringBuilder.append(str2);
      throw new g.a(stringBuilder.toString());
    } 
    this.e.d("XAdLocalApkFile", "built-in apk, no need to check");
  }
  
  protected void a(String paramString) {
    renameTo(new File(paramString));
  }
  
  protected Class<?> b() {
    if (this.b == null) {
      File file = new File(getAbsolutePath());
      try {
        this.b = b(file);
      } catch (Exception exception) {
        file.delete();
      } 
    } 
    return this.b;
  }
  
  protected double c() {
    e e1 = this.a;
    return (e1 == null) ? 0.0D : e1.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */