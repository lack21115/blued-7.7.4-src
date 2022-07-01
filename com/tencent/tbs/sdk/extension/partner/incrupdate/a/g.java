package com.tencent.tbs.sdk.extension.partner.incrupdate.a;

import android.content.Context;
import com.tencent.tbs.sdk.extension.partner.incrupdate.a.a.b;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;

public abstract class g {
  protected HashMap<String, Long> a = new HashMap<String, Long>();
  
  protected f b = new f();
  
  protected d c = new d();
  
  protected List<String> d = null;
  
  protected List<String> e = null;
  
  protected abstract List<b> a(d paramd);
  
  protected abstract List<b> a(f paramf);
  
  protected void a(OutputStream paramOutputStream) {
    this.b.a(b.a);
    f f1 = this.b;
    f1.a(a(f1));
    this.b.a(paramOutputStream);
  }
  
  protected void a(OutputStream paramOutputStream, InputStream paramInputStream, byte[] paramArrayOfbyte) {
    this.c.a(paramOutputStream, paramInputStream, paramArrayOfbyte);
  }
  
  protected void a(OutputStream paramOutputStream, ZipEntry paramZipEntry, int paramInt) {
    this.c.a(paramInt, paramZipEntry.getName(), paramZipEntry.getSize(), paramZipEntry.getCrc(), paramZipEntry.getMethod());
    d d1 = this.c;
    d1.a(a(d1));
    this.c.a(paramOutputStream);
  }
  
  protected void a(List<String> paramList) {
    this.d = paramList;
  }
  
  protected abstract boolean a(Context paramContext, File paramFile1, File paramFile2);
  
  protected boolean a(String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #4
    //   3: iconst_0
    //   4: istore_3
    //   5: iconst_0
    //   6: istore_2
    //   7: aconst_null
    //   8: astore #7
    //   10: aconst_null
    //   11: astore #5
    //   13: new java/util/zip/ZipFile
    //   16: dup
    //   17: aload_1
    //   18: invokespecial <init> : (Ljava/lang/String;)V
    //   21: astore_1
    //   22: iload #4
    //   24: istore_3
    //   25: aload_1
    //   26: invokevirtual entries : ()Ljava/util/Enumeration;
    //   29: astore #5
    //   31: iload #4
    //   33: istore_3
    //   34: aload #5
    //   36: invokeinterface hasMoreElements : ()Z
    //   41: ifeq -> 346
    //   44: iload #4
    //   46: istore_3
    //   47: aload #5
    //   49: invokeinterface nextElement : ()Ljava/lang/Object;
    //   54: checkcast java/util/zip/ZipEntry
    //   57: astore #6
    //   59: iload #4
    //   61: istore_3
    //   62: aload #6
    //   64: invokevirtual getName : ()Ljava/lang/String;
    //   67: astore #7
    //   69: aload #7
    //   71: ifnull -> 31
    //   74: iload #4
    //   76: istore_3
    //   77: aload #7
    //   79: ldc '../'
    //   81: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   84: ifeq -> 90
    //   87: goto -> 31
    //   90: iload #4
    //   92: istore_3
    //   93: aload #6
    //   95: invokevirtual getCrc : ()J
    //   98: aload_0
    //   99: getfield a : Ljava/util/HashMap;
    //   102: aload #7
    //   104: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast java/lang/Long
    //   110: invokevirtual longValue : ()J
    //   113: lcmp
    //   114: ifeq -> 31
    //   117: goto -> 120
    //   120: iload_2
    //   121: istore_3
    //   122: aload_0
    //   123: getfield a : Ljava/util/HashMap;
    //   126: invokevirtual clear : ()V
    //   129: aload_1
    //   130: invokevirtual close : ()V
    //   133: iload_2
    //   134: ireturn
    //   135: astore #6
    //   137: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   140: astore_1
    //   141: new java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial <init> : ()V
    //   148: astore #5
    //   150: aload #5
    //   152: ldc 'Error while closing zip file'
    //   154: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload #5
    //   160: aload #6
    //   162: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_1
    //   167: aload #5
    //   169: invokevirtual toString : ()Ljava/lang/String;
    //   172: invokevirtual println : (Ljava/lang/String;)V
    //   175: iload_2
    //   176: ireturn
    //   177: astore #6
    //   179: aload_1
    //   180: astore #5
    //   182: aload #6
    //   184: astore_1
    //   185: goto -> 289
    //   188: astore #6
    //   190: goto -> 202
    //   193: astore_1
    //   194: goto -> 289
    //   197: astore #6
    //   199: aload #7
    //   201: astore_1
    //   202: aload_1
    //   203: astore #5
    //   205: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   208: astore #7
    //   210: aload_1
    //   211: astore #5
    //   213: new java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial <init> : ()V
    //   220: astore #8
    //   222: aload_1
    //   223: astore #5
    //   225: aload #8
    //   227: ldc 'Error opening zip file'
    //   229: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_1
    //   234: astore #5
    //   236: aload #8
    //   238: aload #6
    //   240: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_1
    //   245: astore #5
    //   247: aload #7
    //   249: aload #8
    //   251: invokevirtual toString : ()Ljava/lang/String;
    //   254: invokevirtual println : (Ljava/lang/String;)V
    //   257: aload_1
    //   258: ifnull -> 287
    //   261: aload_1
    //   262: invokevirtual close : ()V
    //   265: iload_3
    //   266: ireturn
    //   267: astore #6
    //   269: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   272: astore_1
    //   273: new java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial <init> : ()V
    //   280: astore #5
    //   282: iload_3
    //   283: istore_2
    //   284: goto -> 150
    //   287: iload_3
    //   288: ireturn
    //   289: aload #5
    //   291: ifnull -> 344
    //   294: aload #5
    //   296: invokevirtual close : ()V
    //   299: goto -> 344
    //   302: astore #5
    //   304: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   307: astore #6
    //   309: new java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial <init> : ()V
    //   316: astore #7
    //   318: aload #7
    //   320: ldc 'Error while closing zip file'
    //   322: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload #7
    //   328: aload #5
    //   330: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload #6
    //   336: aload #7
    //   338: invokevirtual toString : ()Ljava/lang/String;
    //   341: invokevirtual println : (Ljava/lang/String;)V
    //   344: aload_1
    //   345: athrow
    //   346: iconst_1
    //   347: istore_2
    //   348: goto -> 120
    // Exception table:
    //   from	to	target	type
    //   13	22	197	java/io/IOException
    //   13	22	193	finally
    //   25	31	188	java/io/IOException
    //   25	31	177	finally
    //   34	44	188	java/io/IOException
    //   34	44	177	finally
    //   47	59	188	java/io/IOException
    //   47	59	177	finally
    //   62	69	188	java/io/IOException
    //   62	69	177	finally
    //   77	87	188	java/io/IOException
    //   77	87	177	finally
    //   93	117	188	java/io/IOException
    //   93	117	177	finally
    //   122	129	188	java/io/IOException
    //   122	129	177	finally
    //   129	133	135	java/io/IOException
    //   205	210	193	finally
    //   213	222	193	finally
    //   225	233	193	finally
    //   236	244	193	finally
    //   247	257	193	finally
    //   261	265	267	java/io/IOException
    //   294	299	302	java/io/IOException
  }
  
  protected abstract boolean a(String paramString1, String paramString2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\incrupdate\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */