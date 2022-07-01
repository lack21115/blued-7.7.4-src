package c.t.maploc.lite.tsa;

import android.os.Handler;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public final class h implements Runnable {
  volatile boolean a;
  
  final LinkedBlockingQueue b = new LinkedBlockingQueue(3);
  
  final j c;
  
  volatile Handler d;
  
  long e;
  
  long f;
  
  h(j paramj) {
    this.c = paramj;
    this.a = false;
  }
  
  static String a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("https://lbs.map.qq.com/loc");
    stringBuilder.append("?c=1");
    stringBuilder.append("&mars=0");
    stringBuilder.append("&obs=");
    stringBuilder.append(paramInt);
    return stringBuilder.toString();
  }
  
  private void a(i parami) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 5
    //   4: return
    //   5: aload_1
    //   6: invokestatic d : (Lc/t/maploc/lite/tsa/i;)I
    //   9: pop
    //   10: aload_0
    //   11: getfield b : Ljava/util/concurrent/LinkedBlockingQueue;
    //   14: invokevirtual iterator : ()Ljava/util/Iterator;
    //   17: astore_3
    //   18: aload_3
    //   19: invokeinterface hasNext : ()Z
    //   24: ifeq -> 51
    //   27: aload_3
    //   28: invokeinterface next : ()Ljava/lang/Object;
    //   33: checkcast c/t/maploc/lite/tsa/i
    //   36: invokestatic c : (Lc/t/maploc/lite/tsa/i;)I
    //   39: aload_1
    //   40: invokestatic c : (Lc/t/maploc/lite/tsa/i;)I
    //   43: if_icmpne -> 18
    //   46: iconst_1
    //   47: istore_2
    //   48: goto -> 53
    //   51: iconst_0
    //   52: istore_2
    //   53: aload_1
    //   54: invokestatic e : (Lc/t/maploc/lite/tsa/i;)I
    //   57: ifle -> 90
    //   60: iload_2
    //   61: ifne -> 90
    //   64: new java/lang/StringBuilder
    //   67: dup
    //   68: ldc 'retryIfNeed: times='
    //   70: invokespecial <init> : (Ljava/lang/String;)V
    //   73: aload_1
    //   74: invokestatic e : (Lc/t/maploc/lite/tsa/i;)I
    //   77: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_0
    //   82: getfield b : Ljava/util/concurrent/LinkedBlockingQueue;
    //   85: aload_1
    //   86: invokevirtual offer : (Ljava/lang/Object;)Z
    //   89: pop
    //   90: return
  }
  
  static byte[] a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return null; 
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
    try {
      deflaterOutputStream.write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
      deflaterOutputStream.finish();
      deflaterOutputStream.flush();
    } finally {}
    try {
      deflaterOutputStream.close();
    } finally {}
  }
  
  private void b() {
    this.e = 0L;
    this.f = 0L;
  }
  
  private static byte[] b(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return null; 
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
    InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
    byte[] arrayOfByte = new byte[1024];
    paramArrayOfbyte = new byte[0];
    int i = 0;
    try {
      while (true) {
        int m = inflaterInputStream.read(arrayOfByte);
        int k = i;
        byte[] arrayOfByte1 = paramArrayOfbyte;
        if (m > 0) {
          k = i + m;
          arrayOfByte1 = new byte[k];
          System.arraycopy(paramArrayOfbyte, 0, arrayOfByte1, 0, paramArrayOfbyte.length);
          System.arraycopy(arrayOfByte, 0, arrayOfByte1, paramArrayOfbyte.length, m);
        } 
        i = k;
        paramArrayOfbyte = arrayOfByte1;
        if (m <= 0) {
          byteArrayInputStream.close();
          inflaterInputStream.close();
          return arrayOfByte1;
        } 
      } 
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public final void a() {
    if (!this.a)
      return; 
    this.a = false;
    this.b.clear();
    this.b.offer(i.a);
    this.d = null;
    b();
  }
  
  public final void run() {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Ljava/util/concurrent/LinkedBlockingQueue;
    //   4: astore #8
    //   6: aload_0
    //   7: getfield a : Z
    //   10: ifeq -> 358
    //   13: aload #8
    //   15: invokevirtual take : ()Ljava/lang/Object;
    //   18: checkcast c/t/maploc/lite/tsa/i
    //   21: astore #5
    //   23: getstatic c/t/maploc/lite/tsa/i.a : Lc/t/maploc/lite/tsa/i;
    //   26: aload #5
    //   28: if_acmpne -> 32
    //   31: return
    //   32: new java/lang/StringBuilder
    //   35: dup
    //   36: ldc 'request:'
    //   38: invokespecial <init> : (Ljava/lang/String;)V
    //   41: aload #5
    //   43: getfield c : Ljava/lang/String;
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: invokestatic currentTimeMillis : ()J
    //   53: lstore_1
    //   54: aload #5
    //   56: invokestatic b : (Lc/t/maploc/lite/tsa/i;)Ljava/lang/String;
    //   59: aload #5
    //   61: invokestatic a : (Lc/t/maploc/lite/tsa/i;)[B
    //   64: invokestatic a : (Ljava/lang/String;[B)Landroid/os/Bundle;
    //   67: astore #9
    //   69: aload #9
    //   71: ldc 'data_bytes'
    //   73: invokevirtual getByteArray : (Ljava/lang/String;)[B
    //   76: astore #7
    //   78: aload #7
    //   80: astore #6
    //   82: aload #5
    //   84: invokestatic c : (Lc/t/maploc/lite/tsa/i;)I
    //   87: iconst_1
    //   88: if_icmpne -> 107
    //   91: aload #7
    //   93: astore #6
    //   95: aload #7
    //   97: ifnull -> 107
    //   100: aload #7
    //   102: invokestatic b : ([B)[B
    //   105: astore #6
    //   107: aload #6
    //   109: ifnull -> 379
    //   112: new java/lang/String
    //   115: dup
    //   116: aload #6
    //   118: aload #9
    //   120: ldc 'data_charset'
    //   122: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   125: invokespecial <init> : ([BLjava/lang/String;)V
    //   128: astore #6
    //   130: goto -> 133
    //   133: aload #9
    //   135: ldc 'data_charset'
    //   137: invokevirtual remove : (Ljava/lang/String;)V
    //   140: aload #9
    //   142: ldc 'data_bytes'
    //   144: invokevirtual remove : (Ljava/lang/String;)V
    //   147: aload #9
    //   149: ldc 'result'
    //   151: aload #6
    //   153: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload #9
    //   158: ldc 'result'
    //   160: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   163: astore #6
    //   165: invokestatic currentTimeMillis : ()J
    //   168: lload_1
    //   169: lsub
    //   170: lstore_3
    //   171: new java/lang/StringBuilder
    //   174: dup
    //   175: ldc 'cost:'
    //   177: invokespecial <init> : (Ljava/lang/String;)V
    //   180: astore #7
    //   182: aload #7
    //   184: lload_3
    //   185: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload #7
    //   191: ldc ',result:'
    //   193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload #7
    //   199: aload #6
    //   201: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload #5
    //   207: lload_1
    //   208: putfield d : J
    //   211: iconst_1
    //   212: aload #5
    //   214: invokestatic c : (Lc/t/maploc/lite/tsa/i;)I
    //   217: if_icmpne -> 6
    //   220: ldc '{}'
    //   222: aload #6
    //   224: invokevirtual equals : (Ljava/lang/Object;)Z
    //   227: ifne -> 276
    //   230: aload_0
    //   231: getfield d : Landroid/os/Handler;
    //   234: ifnull -> 6
    //   237: aload_0
    //   238: getfield d : Landroid/os/Handler;
    //   241: sipush #2003
    //   244: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   247: astore #7
    //   249: aload #7
    //   251: lload_3
    //   252: l2i
    //   253: putfield arg1 : I
    //   256: aload #7
    //   258: aload #6
    //   260: aload #5
    //   262: invokestatic create : (Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   265: putfield obj : Ljava/lang/Object;
    //   268: aload #7
    //   270: invokevirtual sendToTarget : ()V
    //   273: goto -> 6
    //   276: new java/io/IOException
    //   279: dup
    //   280: ldc 'loc result is "{}"'
    //   282: invokespecial <init> : (Ljava/lang/String;)V
    //   285: athrow
    //   286: goto -> 297
    //   289: goto -> 6
    //   292: aconst_null
    //   293: astore #5
    //   295: lconst_0
    //   296: lstore_1
    //   297: invokestatic currentTimeMillis : ()J
    //   300: lstore_3
    //   301: new java/lang/StringBuilder
    //   304: dup
    //   305: ldc 'cost:'
    //   307: invokespecial <init> : (Ljava/lang/String;)V
    //   310: astore #6
    //   312: aload #6
    //   314: lload_3
    //   315: lload_1
    //   316: lsub
    //   317: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload #6
    //   323: ldc_w ',run: io error'
    //   326: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_0
    //   331: aload #5
    //   333: invokespecial a : (Lc/t/maploc/lite/tsa/i;)V
    //   336: aload_0
    //   337: getfield d : Landroid/os/Handler;
    //   340: ifnull -> 6
    //   343: aload_0
    //   344: getfield d : Landroid/os/Handler;
    //   347: sipush #2004
    //   350: lconst_0
    //   351: invokevirtual sendEmptyMessageDelayed : (IJ)Z
    //   354: pop
    //   355: goto -> 6
    //   358: return
    //   359: astore #5
    //   361: goto -> 289
    //   364: astore #5
    //   366: goto -> 292
    //   369: astore #6
    //   371: goto -> 295
    //   374: astore #6
    //   376: goto -> 286
    //   379: ldc '{}'
    //   381: astore #6
    //   383: goto -> 133
    // Exception table:
    //   from	to	target	type
    //   13	23	359	java/lang/InterruptedException
    //   13	23	364	java/io/IOException
    //   13	23	359	finally
    //   23	31	359	java/lang/InterruptedException
    //   23	31	369	java/io/IOException
    //   23	31	359	finally
    //   32	54	359	java/lang/InterruptedException
    //   32	54	369	java/io/IOException
    //   32	54	359	finally
    //   54	78	359	java/lang/InterruptedException
    //   54	78	374	java/io/IOException
    //   54	78	359	finally
    //   82	91	359	java/lang/InterruptedException
    //   82	91	374	java/io/IOException
    //   82	91	359	finally
    //   100	107	359	java/lang/InterruptedException
    //   100	107	374	java/io/IOException
    //   100	107	359	finally
    //   112	130	359	java/lang/InterruptedException
    //   112	130	374	java/io/IOException
    //   112	130	359	finally
    //   133	273	359	java/lang/InterruptedException
    //   133	273	374	java/io/IOException
    //   133	273	359	finally
    //   276	286	359	java/lang/InterruptedException
    //   276	286	374	java/io/IOException
    //   276	286	359	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */