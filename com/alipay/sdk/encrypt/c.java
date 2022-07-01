package com.alipay.sdk.encrypt;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class c {
  public static byte[] a(byte[] paramArrayOfbyte) throws IOException {
    try {
      GZIPOutputStream gZIPOutputStream;
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
    } finally {
      exception2 = null;
    } 
    Exception exception3 = null;
    Exception exception4 = exception2;
    Object object = null;
    Exception exception2 = exception3;
    byte[] arrayOfByte = paramArrayOfbyte;
    Exception exception1 = exception4;
  }
  
  public static byte[] b(byte[] paramArrayOfbyte) throws IOException {
    // Byte code:
    //   0: new java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial <init> : ([B)V
    //   8: astore_2
    //   9: new java/util/zip/GZIPInputStream
    //   12: dup
    //   13: aload_2
    //   14: invokespecial <init> : (Ljava/io/InputStream;)V
    //   17: astore #4
    //   19: sipush #4096
    //   22: newarray byte
    //   24: astore_0
    //   25: new java/io/ByteArrayOutputStream
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: astore #5
    //   34: aload #4
    //   36: aload_0
    //   37: iconst_0
    //   38: aload_0
    //   39: arraylength
    //   40: invokevirtual read : ([BII)I
    //   43: istore_1
    //   44: iload_1
    //   45: iconst_m1
    //   46: if_icmpeq -> 60
    //   49: aload #5
    //   51: aload_0
    //   52: iconst_0
    //   53: iload_1
    //   54: invokevirtual write : ([BII)V
    //   57: goto -> 34
    //   60: aload #5
    //   62: invokevirtual flush : ()V
    //   65: aload #5
    //   67: invokevirtual toByteArray : ()[B
    //   70: astore_0
    //   71: aload #5
    //   73: invokevirtual close : ()V
    //   76: aload #4
    //   78: invokevirtual close : ()V
    //   81: aload_2
    //   82: invokevirtual close : ()V
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: aload_2
    //   89: astore_3
    //   90: aload #5
    //   92: astore_2
    //   93: goto -> 134
    //   96: astore_0
    //   97: aconst_null
    //   98: astore #5
    //   100: aload_2
    //   101: astore_3
    //   102: aload #5
    //   104: astore_2
    //   105: goto -> 134
    //   108: astore_3
    //   109: aload_2
    //   110: astore_0
    //   111: aload_3
    //   112: astore_2
    //   113: goto -> 119
    //   116: astore_2
    //   117: aconst_null
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_3
    //   121: aload_2
    //   122: astore #5
    //   124: aconst_null
    //   125: astore #4
    //   127: aload_3
    //   128: astore_2
    //   129: aload_0
    //   130: astore_3
    //   131: aload #5
    //   133: astore_0
    //   134: aload_2
    //   135: invokevirtual close : ()V
    //   138: aload #4
    //   140: invokevirtual close : ()V
    //   143: aload_3
    //   144: invokevirtual close : ()V
    //   147: aload_0
    //   148: athrow
    //   149: astore_3
    //   150: goto -> 76
    //   153: astore_3
    //   154: goto -> 81
    //   157: astore_2
    //   158: aload_0
    //   159: areturn
    //   160: astore_2
    //   161: goto -> 138
    //   164: astore_2
    //   165: goto -> 143
    //   168: astore_2
    //   169: goto -> 147
    // Exception table:
    //   from	to	target	type
    //   0	9	116	finally
    //   9	19	108	finally
    //   19	34	96	finally
    //   34	44	87	finally
    //   49	57	87	finally
    //   60	71	87	finally
    //   71	76	149	java/lang/Exception
    //   76	81	153	java/lang/Exception
    //   81	85	157	java/lang/Exception
    //   134	138	160	java/lang/Exception
    //   138	143	164	java/lang/Exception
    //   143	147	168	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\encrypt\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */