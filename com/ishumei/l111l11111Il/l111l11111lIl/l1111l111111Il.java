package com.ishumei.l111l11111Il.l111l11111lIl;

import com.ishumei.l111l1111llIl.l111l1111l1Il;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class l1111l111111Il {
  private static final int l111l11111I1l = 1896449818;
  
  private static final int l111l11111Il = -1091571699;
  
  public final long l1111l111111Il;
  
  public final long l111l11111lIl;
  
  private ByteBuffer l111l1111l1Il;
  
  private ByteBuffer l111l1111lI1l;
  
  private long l111l1111llIl;
  
  public l1111l111111Il() {}
  
  l1111l111111Il(ByteBuffer paramByteBuffer1, long paramLong1, long paramLong2, long paramLong3, ByteBuffer paramByteBuffer2) {
    this.l111l1111l1Il = paramByteBuffer1;
    this.l1111l111111Il = paramLong1;
    this.l111l11111lIl = paramLong2;
    this.l111l1111llIl = paramLong3;
    this.l111l1111lI1l = paramByteBuffer2;
  }
  
  public static l1111l111111Il l1111l111111Il(RandomAccessFile paramRandomAccessFile, l1111l111111Il paraml1111l111111Il) {
    byte[] arrayOfByte;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    ArrayList<X509Certificate[]> arrayList = new ArrayList();
    CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
    ByteBuffer byteBuffer = l111l11111lIl.l1111l111111Il(paraml1111l111111Il.l111l1111l1Il);
    while (byteBuffer.hasRemaining())
      arrayList.add(l1111l111111Il(l111l11111lIl.l1111l111111Il(byteBuffer), (Map)hashMap, certificateFactory)); 
    certificateFactory = null;
    if (hashMap.containsKey(Integer.valueOf(3))) {
      arrayOfByte = (byte[])hashMap.get(Integer.valueOf(3));
      long l = paramRandomAccessFile.length();
      if (arrayOfByte.length == 40) {
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(arrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer1.position(32);
        if (byteBuffer1.getLong() == l - paraml1111l111111Il.l111l11111lIl - paraml1111l111111Il.l1111l111111Il) {
          arrayOfByte = Arrays.copyOfRange(arrayOfByte, 0, 32);
        } else {
          throw new SecurityException("APK content size did not verify");
        } 
      } else {
        StringBuilder stringBuilder = new StringBuilder("Verity digest size is wrong: ");
        stringBuilder.append(arrayOfByte.length);
        throw new SecurityException(stringBuilder.toString());
      } 
    } 
    return new l1111l111111Il(arrayList.<X509Certificate[]>toArray(new X509Certificate[arrayList.size()][]), arrayOfByte);
  }
  
  public static l1111l111111Il l1111l111111Il(RandomAccessFile paramRandomAccessFile) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic l1111l111111Il : (Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   4: astore #13
    //   6: aload #13
    //   8: ifnull -> 551
    //   11: aload #13
    //   13: getfield first : Ljava/lang/Object;
    //   16: checkcast java/nio/ByteBuffer
    //   19: astore #12
    //   21: aload #13
    //   23: getfield second : Ljava/lang/Object;
    //   26: checkcast java/lang/Long
    //   29: invokevirtual longValue : ()J
    //   32: lstore_2
    //   33: lload_2
    //   34: ldc2_w 20
    //   37: lsub
    //   38: lstore #4
    //   40: lload #4
    //   42: lconst_0
    //   43: lcmp
    //   44: iflt -> 67
    //   47: aload_0
    //   48: lload #4
    //   50: invokevirtual seek : (J)V
    //   53: aload_0
    //   54: invokevirtual readInt : ()I
    //   57: ldc 1347094023
    //   59: if_icmpne -> 67
    //   62: iconst_1
    //   63: istore_1
    //   64: goto -> 69
    //   67: iconst_0
    //   68: istore_1
    //   69: iload_1
    //   70: ifne -> 540
    //   73: aload #12
    //   75: invokestatic l1111l111111Il : (Ljava/nio/ByteBuffer;)J
    //   78: lstore #4
    //   80: lload #4
    //   82: lload_2
    //   83: lcmp
    //   84: ifgt -> 496
    //   87: aload #12
    //   89: invokestatic l111l11111lIl : (Ljava/nio/ByteBuffer;)J
    //   92: lload #4
    //   94: ladd
    //   95: lload_2
    //   96: lcmp
    //   97: ifne -> 486
    //   100: lload #4
    //   102: ldc2_w 32
    //   105: lcmp
    //   106: iflt -> 457
    //   109: bipush #24
    //   111: invokestatic allocate : (I)Ljava/nio/ByteBuffer;
    //   114: astore #13
    //   116: aload #13
    //   118: getstatic java/nio/ByteOrder.LITTLE_ENDIAN : Ljava/nio/ByteOrder;
    //   121: invokevirtual order : (Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   124: pop
    //   125: aload_0
    //   126: lload #4
    //   128: aload #13
    //   130: invokevirtual capacity : ()I
    //   133: i2l
    //   134: lsub
    //   135: invokevirtual seek : (J)V
    //   138: aload_0
    //   139: aload #13
    //   141: invokevirtual array : ()[B
    //   144: aload #13
    //   146: invokevirtual arrayOffset : ()I
    //   149: aload #13
    //   151: invokevirtual capacity : ()I
    //   154: invokevirtual readFully : ([BII)V
    //   157: aload #13
    //   159: bipush #8
    //   161: invokevirtual getLong : (I)J
    //   164: ldc2_w 2334950737559900225
    //   167: lcmp
    //   168: ifne -> 447
    //   171: aload #13
    //   173: bipush #16
    //   175: invokevirtual getLong : (I)J
    //   178: ldc2_w 3617552046287187010
    //   181: lcmp
    //   182: ifne -> 447
    //   185: aload #13
    //   187: iconst_0
    //   188: invokevirtual getLong : (I)J
    //   191: lstore #6
    //   193: lload #6
    //   195: aload #13
    //   197: invokevirtual capacity : ()I
    //   200: i2l
    //   201: lcmp
    //   202: iflt -> 418
    //   205: lload #6
    //   207: ldc2_w 2147483639
    //   210: lcmp
    //   211: ifgt -> 418
    //   214: ldc2_w 8
    //   217: lload #6
    //   219: ladd
    //   220: l2i
    //   221: istore_1
    //   222: lload #4
    //   224: iload_1
    //   225: i2l
    //   226: lsub
    //   227: lstore #8
    //   229: lload #8
    //   231: lconst_0
    //   232: lcmp
    //   233: iflt -> 389
    //   236: iload_1
    //   237: invokestatic allocate : (I)Ljava/nio/ByteBuffer;
    //   240: astore #13
    //   242: aload #13
    //   244: getstatic java/nio/ByteOrder.LITTLE_ENDIAN : Ljava/nio/ByteOrder;
    //   247: invokevirtual order : (Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   250: pop
    //   251: aload_0
    //   252: lload #8
    //   254: invokevirtual seek : (J)V
    //   257: aload_0
    //   258: aload #13
    //   260: invokevirtual array : ()[B
    //   263: aload #13
    //   265: invokevirtual arrayOffset : ()I
    //   268: aload #13
    //   270: invokevirtual capacity : ()I
    //   273: invokevirtual readFully : ([BII)V
    //   276: aload #13
    //   278: iconst_0
    //   279: invokevirtual getLong : (I)J
    //   282: lstore #10
    //   284: lload #10
    //   286: lload #6
    //   288: lcmp
    //   289: ifne -> 346
    //   292: aload #13
    //   294: lload #8
    //   296: invokestatic valueOf : (J)Ljava/lang/Long;
    //   299: invokestatic create : (Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   302: astore_0
    //   303: aload_0
    //   304: getfield first : Ljava/lang/Object;
    //   307: checkcast java/nio/ByteBuffer
    //   310: astore #13
    //   312: aload_0
    //   313: getfield second : Ljava/lang/Object;
    //   316: checkcast java/lang/Long
    //   319: invokevirtual longValue : ()J
    //   322: lstore #6
    //   324: new com/ishumei/l111l11111Il/l111l11111lIl/l1111l111111Il
    //   327: dup
    //   328: aload #13
    //   330: ldc 1896449818
    //   332: invokestatic l1111l111111Il : (Ljava/nio/ByteBuffer;I)Ljava/nio/ByteBuffer;
    //   335: lload #6
    //   337: lload #4
    //   339: lload_2
    //   340: aload #12
    //   342: invokespecial <init> : (Ljava/nio/ByteBuffer;JJJLjava/nio/ByteBuffer;)V
    //   345: areturn
    //   346: new java/lang/StringBuilder
    //   349: dup
    //   350: ldc 'APK Signing Block sizes in header and footer do not match: '
    //   352: invokespecial <init> : (Ljava/lang/String;)V
    //   355: astore_0
    //   356: aload_0
    //   357: lload #10
    //   359: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload_0
    //   364: ldc ' vs '
    //   366: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload_0
    //   371: lload #6
    //   373: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: new java/io/IOException
    //   380: dup
    //   381: aload_0
    //   382: invokevirtual toString : ()Ljava/lang/String;
    //   385: invokespecial <init> : (Ljava/lang/String;)V
    //   388: athrow
    //   389: new java/lang/StringBuilder
    //   392: dup
    //   393: ldc 'APK Signing Block offset out of range: '
    //   395: invokespecial <init> : (Ljava/lang/String;)V
    //   398: astore_0
    //   399: aload_0
    //   400: lload #8
    //   402: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: new java/io/IOException
    //   409: dup
    //   410: aload_0
    //   411: invokevirtual toString : ()Ljava/lang/String;
    //   414: invokespecial <init> : (Ljava/lang/String;)V
    //   417: athrow
    //   418: new java/lang/StringBuilder
    //   421: dup
    //   422: ldc 'APK Signing Block size out of range: '
    //   424: invokespecial <init> : (Ljava/lang/String;)V
    //   427: astore_0
    //   428: aload_0
    //   429: lload #6
    //   431: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: new java/io/IOException
    //   438: dup
    //   439: aload_0
    //   440: invokevirtual toString : ()Ljava/lang/String;
    //   443: invokespecial <init> : (Ljava/lang/String;)V
    //   446: athrow
    //   447: new java/io/IOException
    //   450: dup
    //   451: ldc 'No APK Signing Block before ZIP Central Directory'
    //   453: invokespecial <init> : (Ljava/lang/String;)V
    //   456: athrow
    //   457: new java/lang/StringBuilder
    //   460: dup
    //   461: ldc 'APK too small for APK Signing Block. ZIP Central Directory offset: '
    //   463: invokespecial <init> : (Ljava/lang/String;)V
    //   466: astore_0
    //   467: aload_0
    //   468: lload #4
    //   470: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: new java/io/IOException
    //   477: dup
    //   478: aload_0
    //   479: invokevirtual toString : ()Ljava/lang/String;
    //   482: invokespecial <init> : (Ljava/lang/String;)V
    //   485: athrow
    //   486: new java/io/IOException
    //   489: dup
    //   490: ldc 'ZIP Central Directory is not immediately followed by End of Central Directory'
    //   492: invokespecial <init> : (Ljava/lang/String;)V
    //   495: athrow
    //   496: new java/lang/StringBuilder
    //   499: dup
    //   500: ldc_w 'ZIP Central Directory offset out of range: '
    //   503: invokespecial <init> : (Ljava/lang/String;)V
    //   506: astore_0
    //   507: aload_0
    //   508: lload #4
    //   510: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload_0
    //   515: ldc_w '. ZIP End of Central Directory offset: '
    //   518: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: aload_0
    //   523: lload_2
    //   524: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: new java/io/IOException
    //   531: dup
    //   532: aload_0
    //   533: invokevirtual toString : ()Ljava/lang/String;
    //   536: invokespecial <init> : (Ljava/lang/String;)V
    //   539: athrow
    //   540: new java/io/IOException
    //   543: dup
    //   544: ldc_w 'ZIP64 APK not supported'
    //   547: invokespecial <init> : (Ljava/lang/String;)V
    //   550: athrow
    //   551: new java/io/IOException
    //   554: dup
    //   555: ldc_w 'Not an APK file: ZIP End of Central Directory record not found'
    //   558: invokespecial <init> : (Ljava/lang/String;)V
    //   561: athrow
  }
  
  private static void l1111l111111Il(ByteBuffer paramByteBuffer) {
    while (paramByteBuffer.hasRemaining()) {
      ByteBuffer byteBuffer = l111l11111lIl.l1111l111111Il(paramByteBuffer);
      if (byteBuffer.getInt() == -1091571699)
        byteBuffer.getInt(); 
    } 
  }
  
  private static X509Certificate[] l1111l111111Il(ByteBuffer paramByteBuffer, Map<Integer, byte[]> paramMap, CertificateFactory paramCertificateFactory) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic l1111l111111Il : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   4: astore #6
    //   6: aload_0
    //   7: invokestatic l1111l111111Il : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   10: astore #4
    //   12: aload_0
    //   13: invokestatic l111l11111lIl : (Ljava/nio/ByteBuffer;)[B
    //   16: astore #7
    //   18: aload #4
    //   20: invokestatic l1111l111111Il : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual getInt : ()I
    //   28: istore_3
    //   29: aload_0
    //   30: invokestatic l111l11111lIl : (Ljava/nio/ByteBuffer;)[B
    //   33: astore #8
    //   35: iload_3
    //   36: sipush #513
    //   39: if_icmpeq -> 157
    //   42: iload_3
    //   43: sipush #514
    //   46: if_icmpeq -> 157
    //   49: iload_3
    //   50: sipush #769
    //   53: if_icmpeq -> 149
    //   56: iload_3
    //   57: sipush #1057
    //   60: if_icmpeq -> 141
    //   63: iload_3
    //   64: sipush #1059
    //   67: if_icmpeq -> 157
    //   70: iload_3
    //   71: sipush #1061
    //   74: if_icmpeq -> 149
    //   77: iload_3
    //   78: tableswitch default -> 108, 257 -> 141, 258 -> 141, 259 -> 141, 260 -> 141
    //   108: new java/lang/StringBuilder
    //   111: dup
    //   112: ldc_w 'Unknown signature algorithm: 0x'
    //   115: invokespecial <init> : (Ljava/lang/String;)V
    //   118: astore_0
    //   119: aload_0
    //   120: iload_3
    //   121: i2l
    //   122: invokestatic toHexString : (J)Ljava/lang/String;
    //   125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: new java/lang/IllegalArgumentException
    //   132: dup
    //   133: aload_0
    //   134: invokevirtual toString : ()Ljava/lang/String;
    //   137: invokespecial <init> : (Ljava/lang/String;)V
    //   140: athrow
    //   141: ldc_w 'RSA'
    //   144: astore #4
    //   146: goto -> 162
    //   149: ldc_w 'DSA'
    //   152: astore #4
    //   154: goto -> 162
    //   157: ldc_w 'EC'
    //   160: astore #4
    //   162: aconst_null
    //   163: astore #5
    //   165: iload_3
    //   166: sipush #513
    //   169: if_icmpeq -> 365
    //   172: iload_3
    //   173: sipush #514
    //   176: if_icmpeq -> 358
    //   179: iload_3
    //   180: sipush #769
    //   183: if_icmpeq -> 351
    //   186: iload_3
    //   187: sipush #1057
    //   190: if_icmpeq -> 344
    //   193: iload_3
    //   194: sipush #1059
    //   197: if_icmpeq -> 365
    //   200: iload_3
    //   201: sipush #1061
    //   204: if_icmpeq -> 351
    //   207: iload_3
    //   208: tableswitch default -> 240, 257 -> 308, 258 -> 280, 259 -> 344, 260 -> 273
    //   240: new java/lang/StringBuilder
    //   243: dup
    //   244: ldc_w 'Unknown signature algorithm: 0x'
    //   247: invokespecial <init> : (Ljava/lang/String;)V
    //   250: astore_0
    //   251: aload_0
    //   252: iload_3
    //   253: i2l
    //   254: invokestatic toHexString : (J)Ljava/lang/String;
    //   257: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: new java/lang/IllegalArgumentException
    //   264: dup
    //   265: aload_0
    //   266: invokevirtual toString : ()Ljava/lang/String;
    //   269: invokespecial <init> : (Ljava/lang/String;)V
    //   272: athrow
    //   273: ldc_w 'SHA512withRSA'
    //   276: astore_0
    //   277: goto -> 333
    //   280: new java/security/spec/PSSParameterSpec
    //   283: dup
    //   284: ldc_w 'SHA-512'
    //   287: ldc_w 'MGF1'
    //   290: getstatic java/security/spec/MGF1ParameterSpec.SHA512 : Ljava/security/spec/MGF1ParameterSpec;
    //   293: bipush #64
    //   295: iconst_1
    //   296: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/security/spec/AlgorithmParameterSpec;II)V
    //   299: astore #5
    //   301: ldc_w 'SHA512withRSA/PSS'
    //   304: astore_0
    //   305: goto -> 333
    //   308: new java/security/spec/PSSParameterSpec
    //   311: dup
    //   312: ldc_w 'SHA-256'
    //   315: ldc_w 'MGF1'
    //   318: getstatic java/security/spec/MGF1ParameterSpec.SHA256 : Ljava/security/spec/MGF1ParameterSpec;
    //   321: bipush #32
    //   323: iconst_1
    //   324: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/security/spec/AlgorithmParameterSpec;II)V
    //   327: astore #5
    //   329: ldc_w 'SHA256withRSA/PSS'
    //   332: astore_0
    //   333: aload_0
    //   334: aload #5
    //   336: invokestatic create : (Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   339: astore #5
    //   341: goto -> 372
    //   344: ldc_w 'SHA256withRSA'
    //   347: astore_0
    //   348: goto -> 333
    //   351: ldc_w 'SHA256withDSA'
    //   354: astore_0
    //   355: goto -> 333
    //   358: ldc_w 'SHA512withECDSA'
    //   361: astore_0
    //   362: goto -> 333
    //   365: ldc_w 'SHA256withECDSA'
    //   368: astore_0
    //   369: goto -> 333
    //   372: aload #5
    //   374: getfield first : Ljava/lang/Object;
    //   377: checkcast java/lang/String
    //   380: astore_0
    //   381: aload #5
    //   383: getfield second : Ljava/lang/Object;
    //   386: checkcast java/security/spec/AlgorithmParameterSpec
    //   389: astore #5
    //   391: aload #4
    //   393: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/KeyFactory;
    //   396: new java/security/spec/X509EncodedKeySpec
    //   399: dup
    //   400: aload #7
    //   402: invokespecial <init> : ([B)V
    //   405: invokevirtual generatePublic : (Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   408: astore #4
    //   410: aload_0
    //   411: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/Signature;
    //   414: astore_0
    //   415: aload_0
    //   416: aload #4
    //   418: invokevirtual initVerify : (Ljava/security/PublicKey;)V
    //   421: aload #5
    //   423: ifnull -> 432
    //   426: aload_0
    //   427: aload #5
    //   429: invokevirtual setParameter : (Ljava/security/spec/AlgorithmParameterSpec;)V
    //   432: aload_0
    //   433: aload #6
    //   435: invokevirtual update : (Ljava/nio/ByteBuffer;)V
    //   438: aload_0
    //   439: aload #8
    //   441: invokevirtual verify : ([B)Z
    //   444: pop
    //   445: aload #6
    //   447: invokevirtual clear : ()Ljava/nio/Buffer;
    //   450: pop
    //   451: aload #6
    //   453: invokestatic l1111l111111Il : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   456: astore #4
    //   458: new java/util/ArrayList
    //   461: dup
    //   462: invokespecial <init> : ()V
    //   465: astore_0
    //   466: aload #4
    //   468: invokestatic l1111l111111Il : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   471: astore #4
    //   473: aload_0
    //   474: aload #4
    //   476: invokevirtual getInt : ()I
    //   479: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   482: invokeinterface add : (Ljava/lang/Object;)Z
    //   487: pop
    //   488: aload #4
    //   490: invokestatic l111l11111lIl : (Ljava/nio/ByteBuffer;)[B
    //   493: astore_0
    //   494: iload_3
    //   495: sipush #513
    //   498: if_icmpeq -> 611
    //   501: iload_3
    //   502: sipush #514
    //   505: if_icmpeq -> 606
    //   508: iload_3
    //   509: sipush #769
    //   512: if_icmpeq -> 611
    //   515: iload_3
    //   516: sipush #1057
    //   519: if_icmpeq -> 601
    //   522: iload_3
    //   523: sipush #1059
    //   526: if_icmpeq -> 601
    //   529: iload_3
    //   530: sipush #1061
    //   533: if_icmpeq -> 601
    //   536: iload_3
    //   537: tableswitch default -> 568, 257 -> 611, 258 -> 606, 259 -> 611, 260 -> 606
    //   568: new java/lang/StringBuilder
    //   571: dup
    //   572: ldc_w 'Unknown signature algorithm: 0x'
    //   575: invokespecial <init> : (Ljava/lang/String;)V
    //   578: astore_0
    //   579: aload_0
    //   580: iload_3
    //   581: i2l
    //   582: invokestatic toHexString : (J)Ljava/lang/String;
    //   585: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: new java/lang/IllegalArgumentException
    //   592: dup
    //   593: aload_0
    //   594: invokevirtual toString : ()Ljava/lang/String;
    //   597: invokespecial <init> : (Ljava/lang/String;)V
    //   600: athrow
    //   601: iconst_3
    //   602: istore_3
    //   603: goto -> 613
    //   606: iconst_2
    //   607: istore_3
    //   608: goto -> 613
    //   611: iconst_1
    //   612: istore_3
    //   613: aload_1
    //   614: iload_3
    //   615: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   618: aload_0
    //   619: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   624: pop
    //   625: aload #6
    //   627: invokestatic l1111l111111Il : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   630: astore_0
    //   631: new java/util/ArrayList
    //   634: dup
    //   635: invokespecial <init> : ()V
    //   638: astore_1
    //   639: aload_0
    //   640: invokevirtual hasRemaining : ()Z
    //   643: ifeq -> 687
    //   646: aload_0
    //   647: invokestatic l111l11111lIl : (Ljava/nio/ByteBuffer;)[B
    //   650: astore #4
    //   652: aload_1
    //   653: new com/ishumei/l111l11111Il/l111l11111lIl/l111l11111Il
    //   656: dup
    //   657: aload_2
    //   658: new java/io/ByteArrayInputStream
    //   661: dup
    //   662: aload #4
    //   664: invokespecial <init> : ([B)V
    //   667: invokevirtual generateCertificate : (Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   670: checkcast java/security/cert/X509Certificate
    //   673: aload #4
    //   675: invokespecial <init> : (Ljava/security/cert/X509Certificate;[B)V
    //   678: invokeinterface add : (Ljava/lang/Object;)Z
    //   683: pop
    //   684: goto -> 639
    //   687: aload #6
    //   689: invokestatic l1111l111111Il : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   692: invokestatic l1111l111111Il : (Ljava/nio/ByteBuffer;)V
    //   695: aload_1
    //   696: iconst_0
    //   697: anewarray java/security/cert/X509Certificate
    //   700: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   705: checkcast [Ljava/security/cert/X509Certificate;
    //   708: areturn
  }
  
  public static class l1111l111111Il {
    public final X509Certificate[][] l1111l111111Il;
    
    private byte[] l111l11111lIl;
    
    public l1111l111111Il() {}
    
    public l1111l111111Il(X509Certificate[][] param1ArrayOfX509Certificate, byte[] param1ArrayOfbyte) {
      this.l1111l111111Il = param1ArrayOfX509Certificate;
      this.l111l11111lIl = param1ArrayOfbyte;
    }
    
    public static HashMap<String, String> l1111l111111Il(boolean param1Boolean) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      try {
        String str = l111l1111lI1l.l111l11111Il("9e919b8d90969bd1908cd1bd8a96939b");
        Field[] arrayOfField = l111l1111l1Il.l1111l111111Il(str);
        if (param1Boolean) {
          try {
            Object object = l111l1111l1Il.l1111l111111Il(str, l111l1111lI1l.l111l11111Il("989a8bac9a8d969e93"));
            if (object != null)
              hashMap.put(l111l1111lI1l.l111l11111Il("8c9a8d969e93a0af"), object.toString()); 
          } finally {}
          str = "9d909e8d9bd392909b9a93d38c9a8d969e93d39d8d9e919bd3929e918a999e9c8b8a8d9a8dd3999691989a8d8f8d96918bd39c8f8aa09e9d96d39c8f8aa09e9d96cd";
        } else {
          str = "9d909e8d9bd392909b9a93d39d8d9e919bd3929e918a999e9c8b8a8d9a8dd3999691989a8d8f8d96918bd39c8f8aa09e9d96d39c8f8aa09e9d96cd";
        } 
        str = l111l1111lI1l.l111l11111Il(str);
        int j = arrayOfField.length;
        for (int i = 0; i < j; i++) {
          Field field = arrayOfField[i];
          field.setAccessible(true);
          String str1 = field.getName().toLowerCase();
          if (str.contains(str1))
            hashMap.put(str1, field.get((Object)null).toString()); 
        } 
        return (HashMap)hashMap;
      } catch (Exception exception) {
        return (HashMap)hashMap;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l111l11111lIl\l1111l111111Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */