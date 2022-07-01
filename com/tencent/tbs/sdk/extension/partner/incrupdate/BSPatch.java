package com.tencent.tbs.sdk.extension.partner.incrupdate;

import android.content.Context;
import com.tencent.tbs.sdk.extension.partner.incrupdate.a.e;
import java.io.File;
import java.util.ArrayList;

public class BSPatch {
  private static boolean a = false;
  
  private static BSPatch b;
  
  private e c = null;
  
  private boolean d = false;
  
  private String e = "";
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static BSPatch a(Context paramContext) {
    if (b == null) {
      b = new BSPatch();
      b.b(paramContext.getApplicationContext());
    } 
    return b;
  }
  
  private static native int apkPatch(String paramString1, String paramString2, String paramString3);
  
  private void b(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/tbs/sdk/extension/partner/incrupdate/BSPatch
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield c : Lcom/tencent/tbs/sdk/extension/partner/incrupdate/a/e;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnonnull -> 124
    //   12: aload_0
    //   13: new com/tencent/tbs/sdk/extension/partner/incrupdate/a/e
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: putfield c : Lcom/tencent/tbs/sdk/extension/partner/incrupdate/a/e;
    //   23: new java/io/File
    //   26: dup
    //   27: aload_1
    //   28: invokestatic getTbsFolderDir : (Landroid/content/Context;)Ljava/io/File;
    //   31: ldc 'core_share'
    //   33: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   36: astore_1
    //   37: aload_1
    //   38: invokevirtual isDirectory : ()Z
    //   41: ifeq -> 124
    //   44: new java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial <init> : ()V
    //   51: astore_2
    //   52: aload_2
    //   53: aload_1
    //   54: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   57: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_2
    //   62: getstatic java/io/File.separator : Ljava/lang/String;
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_2
    //   70: ldc 'libTbsPatch.so'
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_2
    //   77: invokevirtual toString : ()Ljava/lang/String;
    //   80: invokestatic load : (Ljava/lang/String;)V
    //   83: iconst_1
    //   84: putstatic com/tencent/tbs/sdk/extension/partner/incrupdate/BSPatch.a : Z
    //   87: goto -> 124
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual printStackTrace : ()V
    //   95: aload_0
    //   96: aload_1
    //   97: invokevirtual getMessage : ()Ljava/lang/String;
    //   100: putfield e : Ljava/lang/String;
    //   103: goto -> 124
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual printStackTrace : ()V
    //   111: aload_0
    //   112: aload_1
    //   113: invokevirtual getMessage : ()Ljava/lang/String;
    //   116: putfield e : Ljava/lang/String;
    //   119: aload_0
    //   120: iconst_1
    //   121: putfield d : Z
    //   124: ldc com/tencent/tbs/sdk/extension/partner/incrupdate/BSPatch
    //   126: monitorexit
    //   127: return
    //   128: astore_1
    //   129: ldc com/tencent/tbs/sdk/extension/partner/incrupdate/BSPatch
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	128	finally
    //   12	87	106	java/lang/UnsatisfiedLinkError
    //   12	87	90	java/lang/Throwable
    //   12	87	128	finally
    //   91	103	128	finally
    //   107	124	128	finally
    //   124	127	128	finally
    //   129	132	128	finally
  }
  
  private void b(String paramString1, String paramString2) {
    File file = new File(paramString1);
    if (file.exists())
      file.delete(); 
    file = new File(paramString2);
    if (file.exists())
      file.delete(); 
  }
  
  public int a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    byte b1;
    this.e = "not set errormsg";
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramString2);
    stringBuilder1.append(".qar");
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString1);
    stringBuilder2.append(".qar");
    String str2 = stringBuilder2.toString();
    try {
      if (a(paramContext, paramString1, str2)) {
        a.a("start apkPatch");
        b1 = apkPatch(str2, str1, paramString3);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("after apkPatch,native return:");
        stringBuilder.append(b1);
        a.a(stringBuilder.toString());
      } else {
        b1 = -2;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      this.e = exception.getMessage();
      b1 = -3;
    } catch (Error error) {
      error.printStackTrace();
      this.e = error.getMessage();
      b1 = -4;
    } 
    byte b2 = b1;
    if (b1 == 0)
      if (a(str1, paramString2)) {
        b2 = 0;
      } else {
        b2 = -1;
      }  
    b(str2, str1);
    return b2;
  }
  
  public String a() {
    return this.e;
  }
  
  boolean a(Context paramContext, String paramString1, String paramString2) {
    a.a("start createQar");
    boolean bool2 = false;
    boolean bool1 = bool2;
    try {
      StringBuilder stringBuilder;
      if (this.c == null) {
        bool1 = bool2;
        stringBuilder = new StringBuilder();
        bool1 = bool2;
        stringBuilder.append(this.e);
        bool1 = bool2;
        stringBuilder.append(" ,qar file is null");
        bool1 = bool2;
        this.e = stringBuilder.toString();
        return false;
      } 
      bool1 = bool2;
      ArrayList<String> arrayList = new ArrayList();
      bool1 = bool2;
      arrayList.add("assets/channel.ini");
      bool1 = bool2;
      arrayList.add("assets/exclude");
      bool1 = bool2;
      arrayList.add("META-INF/");
      bool1 = bool2;
      this.c.a(arrayList);
      bool1 = bool2;
      bool2 = this.c.a((Context)stringBuilder, paramString1, paramString2);
      bool1 = bool2;
      a.a("after createQar");
      return bool2;
    } catch (Throwable throwable) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("create createQar exception:");
      stringBuilder.append(throwable.getMessage());
      a.a(stringBuilder.toString());
      this.e = throwable.getMessage();
      throwable.printStackTrace();
      return bool1;
    } 
  }
  
  boolean a(String paramString1, String paramString2) {
    (new File(paramString2)).delete();
    try {
      if (this.c == null) {
        this.e = "doRestoreQar file is null";
        return false;
      } 
      return this.c.a(paramString1, paramString2);
    } catch (Throwable throwable) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("doRestoreQar Throwable:");
      stringBuilder.append(throwable.getMessage());
      a.a(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("restoreQar throwable:");
      stringBuilder.append(throwable.getMessage());
      this.e = stringBuilder.toString();
      throwable.printStackTrace();
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\incrupdate\BSPatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */