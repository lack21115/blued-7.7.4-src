package com.bun.miitmdid.d;

import android.text.TextUtils;
import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class b {
  public static final byte[] a;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    byte[] arrayOfByte = Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC6ZetPcgLCvLsvDWzA3TYpRhEO\nfncquhfl9utVX+VApfrknKvYInYzmxjhdAEay+Nn6NPJKGPkCt1D7VWbf0YPiLmo\noCTIsuc7czZOu9pBJYjOrqCZhhJsJucc3+T/un8KioD2CjkXy0EhNMJSuvo+tHJg\nTbiR4QuPcIU1YBLX4wIDAQAB".getBytes(), 0);
    return new String(Base64.encode(b(paramString.getBytes(), arrayOfByte), 2));
  }
  
  private static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(paramArrayOfbyte2);
    PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    cipher.init(1, publicKey);
    return cipher.doFinal(paramArrayOfbyte1);
  }
  
  public static byte[] b(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #6
    //   3: aload_0
    //   4: arraylength
    //   5: istore #7
    //   7: iload #7
    //   9: bipush #117
    //   11: if_icmpgt -> 20
    //   14: aload_0
    //   15: aload_1
    //   16: invokestatic a : ([B[B)[B
    //   19: areturn
    //   20: new java/util/ArrayList
    //   23: dup
    //   24: sipush #2048
    //   27: invokespecial <init> : (I)V
    //   30: astore #10
    //   32: bipush #117
    //   34: newarray byte
    //   36: astore #9
    //   38: iconst_0
    //   39: istore_3
    //   40: iconst_0
    //   41: istore #4
    //   43: iconst_0
    //   44: istore_2
    //   45: iload_3
    //   46: iload #7
    //   48: if_icmpge -> 227
    //   51: aload #9
    //   53: iload_2
    //   54: aload_0
    //   55: iload_3
    //   56: baload
    //   57: bastore
    //   58: iload_2
    //   59: iconst_1
    //   60: iadd
    //   61: istore_2
    //   62: iload_2
    //   63: bipush #117
    //   65: if_icmpeq -> 84
    //   68: aload #9
    //   70: astore #8
    //   72: iload #4
    //   74: istore #5
    //   76: iload_3
    //   77: iload #7
    //   79: iconst_1
    //   80: isub
    //   81: if_icmpne -> 192
    //   84: iload #4
    //   86: iconst_1
    //   87: iadd
    //   88: istore #5
    //   90: iload #5
    //   92: iconst_1
    //   93: if_icmpeq -> 136
    //   96: getstatic com/bun/miitmdid/d/b.a : [B
    //   99: astore #8
    //   101: aload #8
    //   103: arraylength
    //   104: istore #4
    //   106: iconst_0
    //   107: istore_2
    //   108: iload_2
    //   109: iload #4
    //   111: if_icmpge -> 136
    //   114: aload #10
    //   116: aload #8
    //   118: iload_2
    //   119: baload
    //   120: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   123: invokeinterface add : (Ljava/lang/Object;)Z
    //   128: pop
    //   129: iload_2
    //   130: iconst_1
    //   131: iadd
    //   132: istore_2
    //   133: goto -> 108
    //   136: aload #9
    //   138: aload_1
    //   139: invokestatic a : ([B[B)[B
    //   142: astore #8
    //   144: aload #8
    //   146: arraylength
    //   147: istore #4
    //   149: iconst_0
    //   150: istore_2
    //   151: iload_2
    //   152: iload #4
    //   154: if_icmpge -> 179
    //   157: aload #10
    //   159: aload #8
    //   161: iload_2
    //   162: baload
    //   163: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   166: invokeinterface add : (Ljava/lang/Object;)Z
    //   171: pop
    //   172: iload_2
    //   173: iconst_1
    //   174: iadd
    //   175: istore_2
    //   176: goto -> 151
    //   179: iload_3
    //   180: iload #7
    //   182: iconst_1
    //   183: isub
    //   184: if_icmpne -> 207
    //   187: aconst_null
    //   188: astore #8
    //   190: iconst_0
    //   191: istore_2
    //   192: iload_3
    //   193: iconst_1
    //   194: iadd
    //   195: istore_3
    //   196: aload #8
    //   198: astore #9
    //   200: iload #5
    //   202: istore #4
    //   204: goto -> 45
    //   207: bipush #117
    //   209: iload #7
    //   211: iload_3
    //   212: isub
    //   213: iconst_1
    //   214: isub
    //   215: invokestatic min : (II)I
    //   218: newarray byte
    //   220: astore #8
    //   222: iconst_0
    //   223: istore_2
    //   224: goto -> 192
    //   227: aload #10
    //   229: invokeinterface size : ()I
    //   234: newarray byte
    //   236: astore_0
    //   237: aload #10
    //   239: invokeinterface iterator : ()Ljava/util/Iterator;
    //   244: astore_1
    //   245: iload #6
    //   247: istore_2
    //   248: aload_1
    //   249: invokeinterface hasNext : ()Z
    //   254: ifeq -> 279
    //   257: aload_0
    //   258: iload_2
    //   259: aload_1
    //   260: invokeinterface next : ()Ljava/lang/Object;
    //   265: checkcast java/lang/Byte
    //   268: invokevirtual byteValue : ()B
    //   271: bastore
    //   272: iload_2
    //   273: iconst_1
    //   274: iadd
    //   275: istore_2
    //   276: goto -> 248
    //   279: aload_0
    //   280: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */