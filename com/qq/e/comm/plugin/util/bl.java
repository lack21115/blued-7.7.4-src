package com.qq.e.comm.plugin.util;

import android.util.Base64;
import com.qq.e.comm.plugin.f.a;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

public class bl {
  public static String a(String paramString) {
    return (paramString == null) ? null : Base64.encodeToString(a(paramString.getBytes(a.a)), 2);
  }
  
  public static byte[] a(byte[] paramArrayOfbyte) {
    ByteArrayOutputStream byteArrayOutputStream;
    GZIPOutputStream gZIPOutputStream = null;
    if (paramArrayOfbyte != null) {
      GZIPOutputStream gZIPOutputStream1;
      Exception exception1;
      if (paramArrayOfbyte.length == 0)
        return paramArrayOfbyte; 
      byteArrayOutputStream = new ByteArrayOutputStream();
      try {
        GZIPOutputStream gZIPOutputStream3 = new GZIPOutputStream(byteArrayOutputStream);
      } catch (Exception null) {
      
      } finally {
        Exception exception2;
        exception1 = null;
        gZIPOutputStream1 = gZIPOutputStream2;
      } 
      GZIPOutputStream gZIPOutputStream2 = gZIPOutputStream1;
      exception1.printStackTrace();
      if (gZIPOutputStream1 != null) {
        try {
          gZIPOutputStream1.close();
          byteArrayOutputStream.close();
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        return null;
      } 
    } else {
      return (byte[])exception;
    } 
    byteArrayOutputStream.close();
  }
  
  public static byte[] b(byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: aload_0
    //   6: ifnull -> 207
    //   9: aload_0
    //   10: arraylength
    //   11: ifne -> 17
    //   14: goto -> 207
    //   17: new java/io/ByteArrayInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial <init> : ([B)V
    //   25: astore #5
    //   27: new java/io/ByteArrayOutputStream
    //   30: dup
    //   31: invokespecial <init> : ()V
    //   34: astore #6
    //   36: sipush #1024
    //   39: newarray byte
    //   41: astore #7
    //   43: new java/util/zip/GZIPInputStream
    //   46: dup
    //   47: aload #5
    //   49: invokespecial <init> : (Ljava/io/InputStream;)V
    //   52: astore_2
    //   53: aload_2
    //   54: astore_0
    //   55: aload_2
    //   56: aload #7
    //   58: invokevirtual read : ([B)I
    //   61: istore_1
    //   62: iload_1
    //   63: iconst_m1
    //   64: if_icmpeq -> 81
    //   67: aload_2
    //   68: astore_0
    //   69: aload #6
    //   71: aload #7
    //   73: iconst_0
    //   74: iload_1
    //   75: invokevirtual write : ([BII)V
    //   78: goto -> 53
    //   81: aload_2
    //   82: astore_0
    //   83: aload #6
    //   85: invokevirtual flush : ()V
    //   88: aload_2
    //   89: astore_0
    //   90: aload #6
    //   92: invokevirtual toByteArray : ()[B
    //   95: astore_3
    //   96: aload_3
    //   97: astore_0
    //   98: aload_2
    //   99: invokevirtual close : ()V
    //   102: aload_3
    //   103: astore_0
    //   104: aload #5
    //   106: invokevirtual close : ()V
    //   109: aload_3
    //   110: astore_0
    //   111: aload #6
    //   113: invokevirtual close : ()V
    //   116: aload_3
    //   117: areturn
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual printStackTrace : ()V
    //   123: aload_0
    //   124: areturn
    //   125: astore_2
    //   126: goto -> 177
    //   129: astore_3
    //   130: goto -> 142
    //   133: astore_2
    //   134: aload_3
    //   135: astore_0
    //   136: goto -> 177
    //   139: astore_3
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: astore_0
    //   144: aload_3
    //   145: invokevirtual printStackTrace : ()V
    //   148: aload_2
    //   149: ifnull -> 159
    //   152: aload #4
    //   154: astore_0
    //   155: aload_2
    //   156: invokevirtual close : ()V
    //   159: aload #4
    //   161: astore_0
    //   162: aload #5
    //   164: invokevirtual close : ()V
    //   167: aload #4
    //   169: astore_0
    //   170: aload #6
    //   172: invokevirtual close : ()V
    //   175: aconst_null
    //   176: areturn
    //   177: aload_0
    //   178: ifnull -> 188
    //   181: aload_0
    //   182: invokevirtual close : ()V
    //   185: goto -> 188
    //   188: aload #5
    //   190: invokevirtual close : ()V
    //   193: aload #6
    //   195: invokevirtual close : ()V
    //   198: goto -> 205
    //   201: aload_0
    //   202: invokevirtual printStackTrace : ()V
    //   205: aload_2
    //   206: athrow
    //   207: aload_0
    //   208: areturn
    //   209: astore_0
    //   210: goto -> 201
    // Exception table:
    //   from	to	target	type
    //   43	53	139	java/lang/Exception
    //   43	53	133	finally
    //   55	62	129	java/lang/Exception
    //   55	62	125	finally
    //   69	78	129	java/lang/Exception
    //   69	78	125	finally
    //   83	88	129	java/lang/Exception
    //   83	88	125	finally
    //   90	96	129	java/lang/Exception
    //   90	96	125	finally
    //   98	102	118	java/lang/Exception
    //   104	109	118	java/lang/Exception
    //   111	116	118	java/lang/Exception
    //   144	148	125	finally
    //   155	159	118	java/lang/Exception
    //   162	167	118	java/lang/Exception
    //   170	175	118	java/lang/Exception
    //   181	185	209	java/lang/Exception
    //   188	198	209	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */