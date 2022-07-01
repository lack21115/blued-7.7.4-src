package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.InputStream;

public class StreamEncoder implements Encoder<InputStream> {
  private final ArrayPool a;
  
  public StreamEncoder(ArrayPool paramArrayPool) {
    this.a = paramArrayPool;
  }
  
  public boolean a(InputStream paramInputStream, File paramFile, Options paramOptions) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayPool;
    //   4: ldc 65536
    //   6: ldc [B
    //   8: invokeinterface a : (ILjava/lang/Class;)Ljava/lang/Object;
    //   13: checkcast [B
    //   16: astore #9
    //   18: iconst_0
    //   19: istore #7
    //   21: iconst_0
    //   22: istore #6
    //   24: aconst_null
    //   25: astore #8
    //   27: aconst_null
    //   28: astore_3
    //   29: new java/io/FileOutputStream
    //   32: dup
    //   33: aload_2
    //   34: invokespecial <init> : (Ljava/io/File;)V
    //   37: astore_2
    //   38: aload_1
    //   39: aload #9
    //   41: invokevirtual read : ([B)I
    //   44: istore #4
    //   46: iload #4
    //   48: iconst_m1
    //   49: if_icmpeq -> 64
    //   52: aload_2
    //   53: aload #9
    //   55: iconst_0
    //   56: iload #4
    //   58: invokevirtual write : ([BII)V
    //   61: goto -> 38
    //   64: aload_2
    //   65: invokevirtual close : ()V
    //   68: iconst_1
    //   69: istore #5
    //   71: iconst_1
    //   72: istore #6
    //   74: aload_2
    //   75: invokevirtual close : ()V
    //   78: iload #6
    //   80: istore #5
    //   82: goto -> 149
    //   85: astore_1
    //   86: aload_2
    //   87: astore_3
    //   88: goto -> 163
    //   91: astore_3
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: astore_2
    //   96: goto -> 107
    //   99: astore_1
    //   100: goto -> 163
    //   103: astore_2
    //   104: aload #8
    //   106: astore_1
    //   107: aload_1
    //   108: astore_3
    //   109: ldc 'StreamEncoder'
    //   111: iconst_3
    //   112: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   115: ifeq -> 129
    //   118: aload_1
    //   119: astore_3
    //   120: ldc 'StreamEncoder'
    //   122: ldc 'Failed to encode data onto the OutputStream'
    //   124: aload_2
    //   125: invokestatic d : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   128: pop
    //   129: iload #6
    //   131: istore #5
    //   133: aload_1
    //   134: ifnull -> 149
    //   137: iload #7
    //   139: istore #5
    //   141: aload_1
    //   142: invokevirtual close : ()V
    //   145: iload #6
    //   147: istore #5
    //   149: aload_0
    //   150: getfield a : Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayPool;
    //   153: aload #9
    //   155: invokeinterface a : (Ljava/lang/Object;)V
    //   160: iload #5
    //   162: ireturn
    //   163: aload_3
    //   164: ifnull -> 171
    //   167: aload_3
    //   168: invokevirtual close : ()V
    //   171: aload_0
    //   172: getfield a : Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayPool;
    //   175: aload #9
    //   177: invokeinterface a : (Ljava/lang/Object;)V
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: goto -> 149
    //   188: astore_2
    //   189: goto -> 171
    // Exception table:
    //   from	to	target	type
    //   29	38	103	java/io/IOException
    //   29	38	99	finally
    //   38	46	91	java/io/IOException
    //   38	46	85	finally
    //   52	61	91	java/io/IOException
    //   52	61	85	finally
    //   64	68	91	java/io/IOException
    //   64	68	85	finally
    //   74	78	184	java/io/IOException
    //   109	118	99	finally
    //   120	129	99	finally
    //   141	145	184	java/io/IOException
    //   167	171	188	java/io/IOException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\StreamEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */