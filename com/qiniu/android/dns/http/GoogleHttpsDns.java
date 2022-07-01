package com.qiniu.android.dns.http;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.io.IOException;
import java.net.HttpURLConnection;

public class GoogleHttpsDns implements IResolver {
  private static String getStringResponse(HttpURLConnection paramHttpURLConnection) throws IOException {
    // Byte code:
    //   0: new java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #6
    //   9: aconst_null
    //   10: astore #4
    //   12: aconst_null
    //   13: astore_2
    //   14: aload_2
    //   15: astore_3
    //   16: aload_0
    //   17: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   20: astore #5
    //   22: aload #5
    //   24: astore_0
    //   25: goto -> 45
    //   28: astore_0
    //   29: goto -> 125
    //   32: aload_2
    //   33: astore_3
    //   34: aload #4
    //   36: astore_2
    //   37: aload_0
    //   38: invokevirtual getErrorStream : ()Ljava/io/InputStream;
    //   41: astore_0
    //   42: goto -> 25
    //   45: aload_0
    //   46: astore_3
    //   47: aload_0
    //   48: astore_2
    //   49: sipush #1024
    //   52: newarray byte
    //   54: astore #4
    //   56: aload_0
    //   57: astore_3
    //   58: aload_0
    //   59: astore_2
    //   60: aload_0
    //   61: aload #4
    //   63: invokevirtual read : ([B)I
    //   66: istore_1
    //   67: iload_1
    //   68: iconst_m1
    //   69: if_icmpeq -> 88
    //   72: aload_0
    //   73: astore_3
    //   74: aload_0
    //   75: astore_2
    //   76: aload #6
    //   78: aload #4
    //   80: iconst_0
    //   81: iload_1
    //   82: invokevirtual write : ([BII)V
    //   85: goto -> 56
    //   88: aload_0
    //   89: ifnull -> 112
    //   92: goto -> 108
    //   95: astore_0
    //   96: aload_2
    //   97: astore_3
    //   98: aload_0
    //   99: invokevirtual printStackTrace : ()V
    //   102: aload_2
    //   103: ifnull -> 112
    //   106: aload_2
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual close : ()V
    //   112: new java/lang/String
    //   115: dup
    //   116: aload #6
    //   118: invokevirtual toByteArray : ()[B
    //   121: invokespecial <init> : ([B)V
    //   124: areturn
    //   125: aload_3
    //   126: ifnull -> 133
    //   129: aload_3
    //   130: invokevirtual close : ()V
    //   133: aload_0
    //   134: athrow
    //   135: astore_3
    //   136: goto -> 32
    // Exception table:
    //   from	to	target	type
    //   16	22	135	java/io/IOException
    //   16	22	28	finally
    //   37	42	95	java/io/IOException
    //   37	42	28	finally
    //   49	56	95	java/io/IOException
    //   49	56	28	finally
    //   60	67	95	java/io/IOException
    //   60	67	28	finally
    //   76	85	95	java/io/IOException
    //   76	85	28	finally
    //   98	102	28	finally
  }
  
  public Record[] resolve(Domain paramDomain, NetworkInfo paramNetworkInfo) throws IOException {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 'https://dns.google.com/resolve?name='
    //   11: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_2
    //   16: aload_1
    //   17: getfield domain : Ljava/lang/String;
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: new java/net/URL
    //   27: dup
    //   28: aload_2
    //   29: invokevirtual toString : ()Ljava/lang/String;
    //   32: invokespecial <init> : (Ljava/lang/String;)V
    //   35: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   38: checkcast java/net/HttpURLConnection
    //   41: astore_1
    //   42: aload_1
    //   43: sipush #3000
    //   46: invokevirtual setConnectTimeout : (I)V
    //   49: aload_1
    //   50: sipush #10000
    //   53: invokevirtual setReadTimeout : (I)V
    //   56: aload_1
    //   57: invokevirtual getResponseCode : ()I
    //   60: sipush #200
    //   63: if_icmpeq -> 68
    //   66: aconst_null
    //   67: areturn
    //   68: aload_1
    //   69: invokestatic getStringResponse : (Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   72: astore_2
    //   73: aload_2
    //   74: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   77: ifeq -> 82
    //   80: aconst_null
    //   81: areturn
    //   82: new java/util/ArrayList
    //   85: dup
    //   86: invokespecial <init> : ()V
    //   89: astore_1
    //   90: new org/json/JSONObject
    //   93: dup
    //   94: aload_2
    //   95: invokespecial <init> : (Ljava/lang/String;)V
    //   98: ldc 'Answer'
    //   100: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   103: astore_2
    //   104: aload_2
    //   105: ifnonnull -> 240
    //   108: aconst_null
    //   109: areturn
    //   110: iload_3
    //   111: aload_2
    //   112: invokevirtual length : ()I
    //   115: if_icmpge -> 207
    //   118: aload_2
    //   119: iload_3
    //   120: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   123: astore #6
    //   125: aload #6
    //   127: ldc 'type'
    //   129: invokevirtual getInt : (Ljava/lang/String;)I
    //   132: iconst_1
    //   133: if_icmpne -> 195
    //   136: aload #6
    //   138: ldc 'data'
    //   140: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   143: astore #7
    //   145: aload #7
    //   147: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   150: istore #5
    //   152: iload #5
    //   154: ifne -> 195
    //   157: aload #6
    //   159: ldc 'TTL'
    //   161: invokevirtual getInt : (Ljava/lang/String;)I
    //   164: istore #4
    //   166: aload_1
    //   167: new com/qiniu/android/dns/Record
    //   170: dup
    //   171: aload #7
    //   173: iconst_1
    //   174: iload #4
    //   176: invokestatic currentTimeMillis : ()J
    //   179: ldc2_w 1000
    //   182: ldiv
    //   183: invokespecial <init> : (Ljava/lang/String;IIJ)V
    //   186: invokeinterface add : (Ljava/lang/Object;)Z
    //   191: pop
    //   192: goto -> 195
    //   195: iload_3
    //   196: iconst_1
    //   197: iadd
    //   198: istore_3
    //   199: goto -> 110
    //   202: astore_2
    //   203: aload_2
    //   204: invokevirtual printStackTrace : ()V
    //   207: aload_1
    //   208: invokeinterface size : ()I
    //   213: ifle -> 235
    //   216: aload_1
    //   217: aload_1
    //   218: invokeinterface size : ()I
    //   223: anewarray com/qiniu/android/dns/Record
    //   226: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   231: checkcast [Lcom/qiniu/android/dns/Record;
    //   234: areturn
    //   235: aconst_null
    //   236: areturn
    //   237: astore_1
    //   238: aconst_null
    //   239: areturn
    //   240: iconst_0
    //   241: istore_3
    //   242: goto -> 110
    // Exception table:
    //   from	to	target	type
    //   90	104	202	java/lang/Exception
    //   110	152	202	java/lang/Exception
    //   157	166	237	java/lang/Exception
    //   166	192	202	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dns\http\GoogleHttpsDns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */