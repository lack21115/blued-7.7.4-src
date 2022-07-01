package com.qiniu.android.dns.http;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.io.IOException;
import java.net.HttpURLConnection;

public class CloudflareHttpsDns implements IResolver {
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
    //   9: ldc 'https://cloudflare-dns.com/dns-query?type=A&name='
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
    //   43: ldc 'accept'
    //   45: ldc 'application/dns-json'
    //   47: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_1
    //   51: sipush #3000
    //   54: invokevirtual setConnectTimeout : (I)V
    //   57: aload_1
    //   58: sipush #10000
    //   61: invokevirtual setReadTimeout : (I)V
    //   64: aload_1
    //   65: invokevirtual getResponseCode : ()I
    //   68: sipush #200
    //   71: if_icmpeq -> 76
    //   74: aconst_null
    //   75: areturn
    //   76: aload_1
    //   77: invokestatic getStringResponse : (Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   80: astore_2
    //   81: aload_2
    //   82: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   85: ifeq -> 90
    //   88: aconst_null
    //   89: areturn
    //   90: new java/util/ArrayList
    //   93: dup
    //   94: invokespecial <init> : ()V
    //   97: astore_1
    //   98: new org/json/JSONObject
    //   101: dup
    //   102: aload_2
    //   103: invokespecial <init> : (Ljava/lang/String;)V
    //   106: ldc 'Answer'
    //   108: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   111: astore_2
    //   112: aload_2
    //   113: ifnonnull -> 248
    //   116: aconst_null
    //   117: areturn
    //   118: iload_3
    //   119: aload_2
    //   120: invokevirtual length : ()I
    //   123: if_icmpge -> 215
    //   126: aload_2
    //   127: iload_3
    //   128: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   131: astore #6
    //   133: aload #6
    //   135: ldc 'type'
    //   137: invokevirtual getInt : (Ljava/lang/String;)I
    //   140: iconst_1
    //   141: if_icmpne -> 203
    //   144: aload #6
    //   146: ldc 'data'
    //   148: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   151: astore #7
    //   153: aload #7
    //   155: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   158: istore #5
    //   160: iload #5
    //   162: ifne -> 203
    //   165: aload #6
    //   167: ldc 'TTL'
    //   169: invokevirtual getInt : (Ljava/lang/String;)I
    //   172: istore #4
    //   174: aload_1
    //   175: new com/qiniu/android/dns/Record
    //   178: dup
    //   179: aload #7
    //   181: iconst_1
    //   182: iload #4
    //   184: invokestatic currentTimeMillis : ()J
    //   187: ldc2_w 1000
    //   190: ldiv
    //   191: invokespecial <init> : (Ljava/lang/String;IIJ)V
    //   194: invokeinterface add : (Ljava/lang/Object;)Z
    //   199: pop
    //   200: goto -> 203
    //   203: iload_3
    //   204: iconst_1
    //   205: iadd
    //   206: istore_3
    //   207: goto -> 118
    //   210: astore_2
    //   211: aload_2
    //   212: invokevirtual printStackTrace : ()V
    //   215: aload_1
    //   216: invokeinterface size : ()I
    //   221: ifle -> 243
    //   224: aload_1
    //   225: aload_1
    //   226: invokeinterface size : ()I
    //   231: anewarray com/qiniu/android/dns/Record
    //   234: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   239: checkcast [Lcom/qiniu/android/dns/Record;
    //   242: areturn
    //   243: aconst_null
    //   244: areturn
    //   245: astore_1
    //   246: aconst_null
    //   247: areturn
    //   248: iconst_0
    //   249: istore_3
    //   250: goto -> 118
    // Exception table:
    //   from	to	target	type
    //   98	112	210	java/lang/Exception
    //   118	160	210	java/lang/Exception
    //   165	174	245	java/lang/Exception
    //   174	200	210	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dns\http\CloudflareHttpsDns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */