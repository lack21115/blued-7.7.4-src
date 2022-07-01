package com.baidu.aip.face.stat;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Dev {
  private static final String INSTALLATION = "INSTALLATION";
  
  private String brand = "";
  
  private boolean firstRun = false;
  
  private String packagename = "";
  
  private String sdkVersion = "2.1.0.0";
  
  private String sysVersion = "";
  
  private String uniqueID = "";
  
  private String generateUniquePsuedoID(Context paramContext) {
    String str2;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("35");
    stringBuilder1.append(Build.BOARD.length() % 10);
    stringBuilder1.append(Build.BRAND.length() % 10);
    stringBuilder1.append(Build.CPU_ABI.length() % 10);
    stringBuilder1.append(Build.DEVICE.length() % 10);
    stringBuilder1.append(Build.MANUFACTURER.length() % 10);
    stringBuilder1.append(Build.MODEL.length() % 10);
    stringBuilder1.append(Build.PRODUCT.length() % 10);
    String str4 = stringBuilder1.toString();
    try {
      str2 = Build.class.getField("SERIAL").get(null).toString();
    } catch (Exception exception) {
      str2 = UUID.randomUUID().toString();
    } 
    String str3 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    String str1 = str3;
    if ("9774d56d682e549c".equals(str3))
      str1 = UUID.randomUUID().toString(); 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str2);
    stringBuilder2.append(str1);
    stringBuilder2.append(str4);
    return md5(stringBuilder2.toString());
  }
  
  public static String md5(String paramString) {
    try {
      for (paramString = (new BigInteger(1, MessageDigest.getInstance("MD5").digest(paramString.getBytes()))).toString(16); paramString.length() < 32; paramString = stringBuilder.toString()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0");
        stringBuilder.append(paramString);
      } 
      return paramString;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new RuntimeException(noSuchAlgorithmException);
    } 
  }
  
  private String readInstallationFile(File paramFile) throws IOException {
    byte[] arrayOfByte1;
    Exception exception;
    File file = null;
    byte[] arrayOfByte2 = null;
    try {
    
    } catch (Exception null) {
    
    } finally {
      Exception exception1;
      exception = null;
      arrayOfByte1 = arrayOfByte2;
    } 
    arrayOfByte2 = arrayOfByte1;
    exception.printStackTrace();
    if (arrayOfByte1 != null)
      arrayOfByte1.close(); 
    return "";
  }
  
  private void writeInstallationFile(Context paramContext, String paramString) {
    Context context2 = null;
    Context context3 = null;
    IOException iOException2 = null;
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(new File(paramContext.getFilesDir(), "INSTALLATION"));
      try {
      
      } catch (FileNotFoundException null) {
      
      } catch (IOException null) {
      
      } finally {
        String str;
        paramString = null;
        iOException2 = iOException;
      } 
    } catch (FileNotFoundException null) {
      paramContext = context3;
    } catch (IOException iOException1) {
      paramContext = context2;
      Context context = paramContext;
      iOException1.printStackTrace();
      if (paramContext != null) {
        paramContext.close();
        return;
      } 
    } finally {}
    Context context1 = paramContext;
    iOException1.printStackTrace();
    if (paramContext != null) {
      paramContext.close();
      return;
    } 
  }
  
  public String getBrand() {
    return this.brand;
  }
  
  public boolean getFirstRun() {
    return this.firstRun;
  }
  
  public String getPackagename() {
    return this.packagename;
  }
  
  public String getSdkVersion() {
    return this.sdkVersion;
  }
  
  public String getSysVersion() {
    return this.sysVersion;
  }
  
  public String getUniqueID() {
    return this.uniqueID;
  }
  
  public String getUniqueIdFromFile(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield uniqueID : Ljava/lang/String;
    //   6: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   9: ifeq -> 49
    //   12: new java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokevirtual getFilesDir : ()Ljava/io/File;
    //   20: ldc 'INSTALLATION'
    //   22: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload_0
    //   27: aload_0
    //   28: aload_1
    //   29: invokespecial readInstallationFile : (Ljava/io/File;)Ljava/lang/String;
    //   32: putfield uniqueID : Ljava/lang/String;
    //   35: goto -> 49
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual printStackTrace : ()V
    //   43: aload_0
    //   44: ldc 'uncreate'
    //   46: putfield uniqueID : Ljava/lang/String;
    //   49: aload_0
    //   50: getfield uniqueID : Ljava/lang/String;
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: areturn
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	58	finally
    //   26	35	38	java/io/IOException
    //   26	35	58	finally
    //   39	49	58	finally
    //   49	54	58	finally
  }
  
  public void init(Context paramContext) {
    if (paramContext == null)
      return; 
    this.brand = Build.MODEL.replace(" ", "");
    this.sysVersion = Build.VERSION.RELEASE;
    this.packagename = paramContext.getPackageName();
    this.uniqueID = getUniqueIdFromFile(paramContext);
    if (TextUtils.isEmpty(this.uniqueID)) {
      this.firstRun = true;
      this.uniqueID = generateUniquePsuedoID(paramContext);
      writeInstallationFile(paramContext, this.uniqueID);
    } 
  }
  
  public void setFirstRun(boolean paramBoolean) {
    this.firstRun = paramBoolean;
  }
  
  public void setSdkVersion(String paramString) {
    this.sdkVersion = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\stat\Dev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */