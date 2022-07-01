package com.alipay.sdk.packet;

import com.alipay.sdk.cons.a;
import com.alipay.sdk.encrypt.e;
import com.alipay.sdk.encrypt.f;
import com.alipay.sdk.util.n;
import java.util.Locale;

public final class c {
  private boolean a;
  
  private String b;
  
  public c(boolean paramBoolean) {
    this.a = paramBoolean;
    this.b = n.a(24);
  }
  
  private static int a(String paramString) {
    return Integer.parseInt(paramString);
  }
  
  private static String a(int paramInt) {
    return String.format(Locale.getDefault(), "%05d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  private static byte[] a(String paramString1, String paramString2) {
    return e.a(paramString1, paramString2);
  }
  
  private static byte[] a(String paramString1, byte[] paramArrayOfbyte, String paramString2) {
    return f.a(paramString1, paramArrayOfbyte, paramString2);
  }
  
  private static byte[] a(byte[]... paramVarArgs) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #7
    //   3: aload_0
    //   4: ifnull -> 245
    //   7: aload_0
    //   8: arraylength
    //   9: ifne -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new java/io/ByteArrayOutputStream
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore #4
    //   23: new java/io/DataOutputStream
    //   26: dup
    //   27: aload #4
    //   29: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   32: astore #6
    //   34: aload #4
    //   36: astore_3
    //   37: aload #6
    //   39: astore #5
    //   41: aload_0
    //   42: arraylength
    //   43: istore_2
    //   44: iconst_0
    //   45: istore_1
    //   46: iload_1
    //   47: iload_2
    //   48: if_icmpge -> 98
    //   51: aload_0
    //   52: iload_1
    //   53: aaload
    //   54: astore #8
    //   56: aload #4
    //   58: astore_3
    //   59: aload #6
    //   61: astore #5
    //   63: aload #6
    //   65: aload #8
    //   67: arraylength
    //   68: invokestatic a : (I)Ljava/lang/String;
    //   71: invokevirtual getBytes : ()[B
    //   74: invokevirtual write : ([B)V
    //   77: aload #4
    //   79: astore_3
    //   80: aload #6
    //   82: astore #5
    //   84: aload #6
    //   86: aload #8
    //   88: invokevirtual write : ([B)V
    //   91: iload_1
    //   92: iconst_1
    //   93: iadd
    //   94: istore_1
    //   95: goto -> 46
    //   98: aload #4
    //   100: astore_3
    //   101: aload #6
    //   103: astore #5
    //   105: aload #6
    //   107: invokevirtual flush : ()V
    //   110: aload #4
    //   112: astore_3
    //   113: aload #6
    //   115: astore #5
    //   117: aload #4
    //   119: invokevirtual toByteArray : ()[B
    //   122: astore #8
    //   124: aload #4
    //   126: invokevirtual close : ()V
    //   129: aload #6
    //   131: astore_0
    //   132: aload #8
    //   134: astore_3
    //   135: aload_0
    //   136: invokevirtual close : ()V
    //   139: aload_3
    //   140: areturn
    //   141: astore_3
    //   142: aload #6
    //   144: astore_0
    //   145: aload_3
    //   146: astore #6
    //   148: goto -> 185
    //   151: astore_0
    //   152: aconst_null
    //   153: astore #5
    //   155: aload #4
    //   157: astore_3
    //   158: goto -> 222
    //   161: astore #6
    //   163: aconst_null
    //   164: astore_0
    //   165: goto -> 185
    //   168: astore_0
    //   169: aconst_null
    //   170: astore_3
    //   171: aload_3
    //   172: astore #5
    //   174: goto -> 222
    //   177: astore #6
    //   179: aconst_null
    //   180: astore #4
    //   182: aload #4
    //   184: astore_0
    //   185: aload #4
    //   187: astore_3
    //   188: aload_0
    //   189: astore #5
    //   191: aload #6
    //   193: invokestatic a : (Ljava/lang/Throwable;)V
    //   196: aload #4
    //   198: ifnull -> 209
    //   201: aload #4
    //   203: invokevirtual close : ()V
    //   206: goto -> 209
    //   209: aload_0
    //   210: ifnull -> 219
    //   213: aload #7
    //   215: astore_3
    //   216: goto -> 135
    //   219: aconst_null
    //   220: areturn
    //   221: astore_0
    //   222: aload_3
    //   223: ifnull -> 233
    //   226: aload_3
    //   227: invokevirtual close : ()V
    //   230: goto -> 233
    //   233: aload #5
    //   235: ifnull -> 243
    //   238: aload #5
    //   240: invokevirtual close : ()V
    //   243: aload_0
    //   244: athrow
    //   245: aconst_null
    //   246: areturn
    //   247: astore_0
    //   248: aload #8
    //   250: astore_3
    //   251: aload #6
    //   253: astore_0
    //   254: goto -> 135
    //   257: astore_0
    //   258: aload_3
    //   259: areturn
    //   260: astore_3
    //   261: goto -> 209
    //   264: astore_3
    //   265: goto -> 233
    //   268: astore_3
    //   269: goto -> 243
    // Exception table:
    //   from	to	target	type
    //   14	23	177	java/lang/Exception
    //   14	23	168	finally
    //   23	34	161	java/lang/Exception
    //   23	34	151	finally
    //   41	44	141	java/lang/Exception
    //   41	44	221	finally
    //   63	77	141	java/lang/Exception
    //   63	77	221	finally
    //   84	91	141	java/lang/Exception
    //   84	91	221	finally
    //   105	110	141	java/lang/Exception
    //   105	110	221	finally
    //   117	124	141	java/lang/Exception
    //   117	124	221	finally
    //   124	129	247	java/lang/Exception
    //   135	139	257	java/lang/Exception
    //   191	196	221	finally
    //   201	206	260	java/lang/Exception
    //   226	230	264	java/lang/Exception
    //   238	243	268	java/lang/Exception
  }
  
  private static byte[] b(String paramString1, byte[] paramArrayOfbyte, String paramString2) {
    return f.b(paramString1, paramArrayOfbyte, paramString2);
  }
  
  public b a(d paramd, String paramString) {
    // Byte code:
    //   0: new java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual b : ()[B
    //   8: invokespecial <init> : ([B)V
    //   11: astore #6
    //   13: aload #6
    //   15: astore #4
    //   17: iconst_5
    //   18: newarray byte
    //   20: astore #5
    //   22: aload #6
    //   24: astore #4
    //   26: aload #6
    //   28: aload #5
    //   30: invokevirtual read : ([B)I
    //   33: pop
    //   34: aload #6
    //   36: astore #4
    //   38: new java/lang/String
    //   41: dup
    //   42: aload #5
    //   44: invokespecial <init> : ([B)V
    //   47: invokestatic a : (Ljava/lang/String;)I
    //   50: newarray byte
    //   52: astore #5
    //   54: aload #6
    //   56: astore #4
    //   58: aload #6
    //   60: aload #5
    //   62: invokevirtual read : ([B)I
    //   65: pop
    //   66: aload #6
    //   68: astore #4
    //   70: new java/lang/String
    //   73: dup
    //   74: aload #5
    //   76: invokespecial <init> : ([B)V
    //   79: astore #7
    //   81: aload #6
    //   83: astore #4
    //   85: iconst_5
    //   86: newarray byte
    //   88: astore #5
    //   90: aload #6
    //   92: astore #4
    //   94: aload #6
    //   96: aload #5
    //   98: invokevirtual read : ([B)I
    //   101: pop
    //   102: aload #6
    //   104: astore #4
    //   106: new java/lang/String
    //   109: dup
    //   110: aload #5
    //   112: invokespecial <init> : ([B)V
    //   115: invokestatic a : (Ljava/lang/String;)I
    //   118: istore_3
    //   119: iload_3
    //   120: ifle -> 215
    //   123: aload #6
    //   125: astore #4
    //   127: iload_3
    //   128: newarray byte
    //   130: astore #8
    //   132: aload #6
    //   134: astore #4
    //   136: aload #6
    //   138: aload #8
    //   140: invokevirtual read : ([B)I
    //   143: pop
    //   144: aload #8
    //   146: astore #5
    //   148: aload #6
    //   150: astore #4
    //   152: aload_0
    //   153: getfield a : Z
    //   156: ifeq -> 175
    //   159: aload #6
    //   161: astore #4
    //   163: aload_0
    //   164: getfield b : Ljava/lang/String;
    //   167: aload #8
    //   169: aload_2
    //   170: invokestatic b : (Ljava/lang/String;[BLjava/lang/String;)[B
    //   173: astore #5
    //   175: aload #5
    //   177: astore_2
    //   178: aload #6
    //   180: astore #4
    //   182: aload_1
    //   183: invokevirtual a : ()Z
    //   186: ifeq -> 199
    //   189: aload #6
    //   191: astore #4
    //   193: aload #5
    //   195: invokestatic b : ([B)[B
    //   198: astore_2
    //   199: aload #6
    //   201: astore #4
    //   203: new java/lang/String
    //   206: dup
    //   207: aload_2
    //   208: invokespecial <init> : ([B)V
    //   211: astore_1
    //   212: goto -> 217
    //   215: aconst_null
    //   216: astore_1
    //   217: aload #6
    //   219: invokevirtual close : ()V
    //   222: aload_1
    //   223: astore_2
    //   224: goto -> 287
    //   227: aload_1
    //   228: astore_2
    //   229: goto -> 287
    //   232: astore #5
    //   234: aload #6
    //   236: astore_2
    //   237: aload #7
    //   239: astore_1
    //   240: goto -> 266
    //   243: astore #5
    //   245: aconst_null
    //   246: astore_1
    //   247: aload #6
    //   249: astore_2
    //   250: goto -> 266
    //   253: astore_1
    //   254: aconst_null
    //   255: astore #4
    //   257: goto -> 310
    //   260: astore #5
    //   262: aconst_null
    //   263: astore_2
    //   264: aload_2
    //   265: astore_1
    //   266: aload_2
    //   267: astore #4
    //   269: aload #5
    //   271: invokestatic a : (Ljava/lang/Throwable;)V
    //   274: aload_2
    //   275: ifnull -> 282
    //   278: aload_2
    //   279: invokevirtual close : ()V
    //   282: aconst_null
    //   283: astore_2
    //   284: aload_1
    //   285: astore #7
    //   287: aload #7
    //   289: ifnonnull -> 298
    //   292: aload_2
    //   293: ifnonnull -> 298
    //   296: aconst_null
    //   297: areturn
    //   298: new com/alipay/sdk/packet/b
    //   301: dup
    //   302: aload #7
    //   304: aload_2
    //   305: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   308: areturn
    //   309: astore_1
    //   310: aload #4
    //   312: ifnull -> 320
    //   315: aload #4
    //   317: invokevirtual close : ()V
    //   320: aload_1
    //   321: athrow
    //   322: astore_2
    //   323: goto -> 227
    //   326: astore_2
    //   327: goto -> 282
    //   330: astore_2
    //   331: goto -> 320
    // Exception table:
    //   from	to	target	type
    //   0	13	260	java/lang/Exception
    //   0	13	253	finally
    //   17	22	243	java/lang/Exception
    //   17	22	309	finally
    //   26	34	243	java/lang/Exception
    //   26	34	309	finally
    //   38	54	243	java/lang/Exception
    //   38	54	309	finally
    //   58	66	243	java/lang/Exception
    //   58	66	309	finally
    //   70	81	243	java/lang/Exception
    //   70	81	309	finally
    //   85	90	232	java/lang/Exception
    //   85	90	309	finally
    //   94	102	232	java/lang/Exception
    //   94	102	309	finally
    //   106	119	232	java/lang/Exception
    //   106	119	309	finally
    //   127	132	232	java/lang/Exception
    //   127	132	309	finally
    //   136	144	232	java/lang/Exception
    //   136	144	309	finally
    //   152	159	232	java/lang/Exception
    //   152	159	309	finally
    //   163	175	232	java/lang/Exception
    //   163	175	309	finally
    //   182	189	232	java/lang/Exception
    //   182	189	309	finally
    //   193	199	232	java/lang/Exception
    //   193	199	309	finally
    //   203	212	232	java/lang/Exception
    //   203	212	309	finally
    //   217	222	322	java/lang/Exception
    //   269	274	309	finally
    //   278	282	326	java/lang/Exception
    //   315	320	330	java/lang/Exception
  }
  
  public d a(b paramb, boolean paramBoolean, String paramString) {
    if (paramb == null)
      return null; 
    byte[] arrayOfByte3 = paramb.a().getBytes();
    byte[] arrayOfByte2 = paramb.b().getBytes();
    byte[] arrayOfByte1 = arrayOfByte2;
    boolean bool = paramBoolean;
    if (paramBoolean)
      try {
        arrayOfByte1 = com.alipay.sdk.encrypt.c.a(arrayOfByte2);
        bool = paramBoolean;
      } catch (Exception exception) {
        bool = false;
        arrayOfByte1 = arrayOfByte2;
      }  
    if (this.a) {
      arrayOfByte1 = a(new byte[][] { arrayOfByte3, a(this.b, a.e), a(this.b, arrayOfByte1, paramString) });
    } else {
      arrayOfByte1 = a(new byte[][] { arrayOfByte3, arrayOfByte1 });
    } 
    return new d(bool, arrayOfByte1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\packet\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */