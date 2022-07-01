package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream extends FilterInputStream {
  private volatile byte[] a;
  
  private int b;
  
  private int c;
  
  private int d = -1;
  
  private int e;
  
  private final ArrayPool f;
  
  public RecyclableBufferedInputStream(InputStream paramInputStream, ArrayPool paramArrayPool) {
    this(paramInputStream, paramArrayPool, 65536);
  }
  
  RecyclableBufferedInputStream(InputStream paramInputStream, ArrayPool paramArrayPool, int paramInt) {
    super(paramInputStream);
    this.f = paramArrayPool;
    this.a = (byte[])paramArrayPool.a(paramInt, byte[].class);
  }
  
  private int a(InputStream paramInputStream, byte[] paramArrayOfbyte) throws IOException {
    int i = this.d;
    if (i != -1) {
      int k = this.e;
      int j = this.c;
      if (k - i < j) {
        byte[] arrayOfByte;
        if (i == 0 && j > paramArrayOfbyte.length && this.b == paramArrayOfbyte.length) {
          k = paramArrayOfbyte.length * 2;
          i = k;
          if (k > j)
            i = j; 
          arrayOfByte = (byte[])this.f.a(i, byte[].class);
          System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, paramArrayOfbyte.length);
          this.a = arrayOfByte;
          this.f.a(paramArrayOfbyte);
        } else {
          i = this.d;
          arrayOfByte = paramArrayOfbyte;
          if (i > 0) {
            System.arraycopy(paramArrayOfbyte, i, paramArrayOfbyte, 0, paramArrayOfbyte.length - i);
            arrayOfByte = paramArrayOfbyte;
          } 
        } 
        this.e -= this.d;
        this.d = 0;
        this.b = 0;
        i = this.e;
        j = paramInputStream.read(arrayOfByte, i, arrayOfByte.length - i);
        i = this.e;
        if (j > 0)
          i += j; 
        this.b = i;
        return j;
      } 
    } 
    i = paramInputStream.read(paramArrayOfbyte);
    if (i > 0) {
      this.d = -1;
      this.e = 0;
      this.b = i;
    } 
    return i;
  }
  
  private static IOException c() throws IOException {
    throw new IOException("BufferedInputStream is closed");
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield a : [B
    //   7: arraylength
    //   8: putfield c : I
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	14	finally
  }
  
  public int available() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield in : Ljava/io/InputStream;
    //   6: astore #4
    //   8: aload_0
    //   9: getfield a : [B
    //   12: ifnull -> 44
    //   15: aload #4
    //   17: ifnull -> 44
    //   20: aload_0
    //   21: getfield b : I
    //   24: istore_1
    //   25: aload_0
    //   26: getfield e : I
    //   29: istore_2
    //   30: aload #4
    //   32: invokevirtual available : ()I
    //   35: istore_3
    //   36: aload_0
    //   37: monitorexit
    //   38: iload_1
    //   39: iload_2
    //   40: isub
    //   41: iload_3
    //   42: iadd
    //   43: ireturn
    //   44: invokestatic c : ()Ljava/io/IOException;
    //   47: athrow
    //   48: astore #4
    //   50: aload_0
    //   51: monitorexit
    //   52: aload #4
    //   54: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	48	finally
    //   20	36	48	finally
    //   44	48	48	finally
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : [B
    //   6: ifnull -> 27
    //   9: aload_0
    //   10: getfield f : Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayPool;
    //   13: aload_0
    //   14: getfield a : [B
    //   17: invokeinterface a : (Ljava/lang/Object;)V
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield a : [B
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	30	finally
  }
  
  public void close() throws IOException {
    if (this.a != null) {
      this.f.a(this.a);
      this.a = null;
    } 
    InputStream inputStream = this.in;
    this.in = null;
    if (inputStream != null)
      inputStream.close(); 
  }
  
  public void mark(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield c : I
    //   7: iload_1
    //   8: invokestatic max : (II)I
    //   11: putfield c : I
    //   14: aload_0
    //   15: aload_0
    //   16: getfield e : I
    //   19: putfield d : I
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	25	finally
  }
  
  public boolean markSupported() {
    return true;
  }
  
  public int read() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : [B
    //   6: astore_3
    //   7: aload_0
    //   8: getfield in : Ljava/io/InputStream;
    //   11: astore_2
    //   12: aload_3
    //   13: ifnull -> 113
    //   16: aload_2
    //   17: ifnull -> 113
    //   20: aload_0
    //   21: getfield e : I
    //   24: aload_0
    //   25: getfield b : I
    //   28: if_icmplt -> 47
    //   31: aload_0
    //   32: aload_2
    //   33: aload_3
    //   34: invokespecial a : (Ljava/io/InputStream;[B)I
    //   37: istore_1
    //   38: iload_1
    //   39: iconst_m1
    //   40: if_icmpne -> 47
    //   43: aload_0
    //   44: monitorexit
    //   45: iconst_m1
    //   46: ireturn
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: aload_0
    //   51: getfield a : [B
    //   54: if_acmpeq -> 73
    //   57: aload_0
    //   58: getfield a : [B
    //   61: astore_2
    //   62: aload_2
    //   63: ifnull -> 69
    //   66: goto -> 73
    //   69: invokestatic c : ()Ljava/io/IOException;
    //   72: athrow
    //   73: aload_0
    //   74: getfield b : I
    //   77: aload_0
    //   78: getfield e : I
    //   81: isub
    //   82: ifle -> 109
    //   85: aload_0
    //   86: getfield e : I
    //   89: istore_1
    //   90: aload_0
    //   91: iload_1
    //   92: iconst_1
    //   93: iadd
    //   94: putfield e : I
    //   97: aload_2
    //   98: iload_1
    //   99: baload
    //   100: istore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: iload_1
    //   104: sipush #255
    //   107: iand
    //   108: ireturn
    //   109: aload_0
    //   110: monitorexit
    //   111: iconst_m1
    //   112: ireturn
    //   113: invokestatic c : ()Ljava/io/IOException;
    //   116: athrow
    //   117: astore_2
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_2
    //   121: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	117	finally
    //   20	38	117	finally
    //   49	62	117	finally
    //   69	73	117	finally
    //   73	97	117	finally
    //   113	117	117	finally
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : [B
    //   6: astore #8
    //   8: aload #8
    //   10: ifnull -> 384
    //   13: iload_3
    //   14: ifne -> 21
    //   17: aload_0
    //   18: monitorexit
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: getfield in : Ljava/io/InputStream;
    //   25: astore #10
    //   27: aload #10
    //   29: ifnull -> 380
    //   32: aload_0
    //   33: getfield e : I
    //   36: aload_0
    //   37: getfield b : I
    //   40: if_icmpge -> 141
    //   43: aload_0
    //   44: getfield b : I
    //   47: aload_0
    //   48: getfield e : I
    //   51: isub
    //   52: iload_3
    //   53: if_icmplt -> 62
    //   56: iload_3
    //   57: istore #4
    //   59: goto -> 73
    //   62: aload_0
    //   63: getfield b : I
    //   66: aload_0
    //   67: getfield e : I
    //   70: isub
    //   71: istore #4
    //   73: aload #8
    //   75: aload_0
    //   76: getfield e : I
    //   79: aload_1
    //   80: iload_2
    //   81: iload #4
    //   83: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   86: aload_0
    //   87: aload_0
    //   88: getfield e : I
    //   91: iload #4
    //   93: iadd
    //   94: putfield e : I
    //   97: iload #4
    //   99: iload_3
    //   100: if_icmpeq -> 136
    //   103: aload #10
    //   105: invokevirtual available : ()I
    //   108: istore #5
    //   110: iload #5
    //   112: ifne -> 118
    //   115: goto -> 136
    //   118: iload_2
    //   119: iload #4
    //   121: iadd
    //   122: istore #5
    //   124: iload_3
    //   125: iload #4
    //   127: isub
    //   128: istore_2
    //   129: iload #5
    //   131: istore #4
    //   133: goto -> 150
    //   136: aload_0
    //   137: monitorexit
    //   138: iload #4
    //   140: ireturn
    //   141: iload_3
    //   142: istore #5
    //   144: iload_2
    //   145: istore #4
    //   147: iload #5
    //   149: istore_2
    //   150: aload_0
    //   151: getfield d : I
    //   154: istore #6
    //   156: iconst_m1
    //   157: istore #5
    //   159: iload #6
    //   161: iconst_m1
    //   162: if_icmpne -> 211
    //   165: iload_2
    //   166: aload #8
    //   168: arraylength
    //   169: if_icmplt -> 211
    //   172: aload #10
    //   174: aload_1
    //   175: iload #4
    //   177: iload_2
    //   178: invokevirtual read : ([BII)I
    //   181: istore #7
    //   183: iload #7
    //   185: istore #6
    //   187: iload #7
    //   189: iconst_m1
    //   190: if_icmpne -> 339
    //   193: iload_2
    //   194: iload_3
    //   195: if_icmpne -> 201
    //   198: goto -> 206
    //   201: iload_3
    //   202: iload_2
    //   203: isub
    //   204: istore #5
    //   206: aload_0
    //   207: monitorexit
    //   208: iload #5
    //   210: ireturn
    //   211: aload_0
    //   212: aload #10
    //   214: aload #8
    //   216: invokespecial a : (Ljava/io/InputStream;[B)I
    //   219: istore #6
    //   221: iload #6
    //   223: iconst_m1
    //   224: if_icmpne -> 245
    //   227: iload_2
    //   228: iload_3
    //   229: if_icmpne -> 235
    //   232: goto -> 240
    //   235: iload_3
    //   236: iload_2
    //   237: isub
    //   238: istore #5
    //   240: aload_0
    //   241: monitorexit
    //   242: iload #5
    //   244: ireturn
    //   245: aload #8
    //   247: astore #9
    //   249: aload #8
    //   251: aload_0
    //   252: getfield a : [B
    //   255: if_acmpeq -> 276
    //   258: aload_0
    //   259: getfield a : [B
    //   262: astore #9
    //   264: aload #9
    //   266: ifnull -> 272
    //   269: goto -> 276
    //   272: invokestatic c : ()Ljava/io/IOException;
    //   275: athrow
    //   276: aload_0
    //   277: getfield b : I
    //   280: aload_0
    //   281: getfield e : I
    //   284: isub
    //   285: iload_2
    //   286: if_icmplt -> 295
    //   289: iload_2
    //   290: istore #5
    //   292: goto -> 306
    //   295: aload_0
    //   296: getfield b : I
    //   299: aload_0
    //   300: getfield e : I
    //   303: isub
    //   304: istore #5
    //   306: aload #9
    //   308: aload_0
    //   309: getfield e : I
    //   312: aload_1
    //   313: iload #4
    //   315: iload #5
    //   317: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   320: aload_0
    //   321: aload_0
    //   322: getfield e : I
    //   325: iload #5
    //   327: iadd
    //   328: putfield e : I
    //   331: iload #5
    //   333: istore #6
    //   335: aload #9
    //   337: astore #8
    //   339: iload_2
    //   340: iload #6
    //   342: isub
    //   343: istore_2
    //   344: iload_2
    //   345: ifne -> 352
    //   348: aload_0
    //   349: monitorexit
    //   350: iload_3
    //   351: ireturn
    //   352: aload #10
    //   354: invokevirtual available : ()I
    //   357: istore #5
    //   359: iload #5
    //   361: ifne -> 370
    //   364: aload_0
    //   365: monitorexit
    //   366: iload_3
    //   367: iload_2
    //   368: isub
    //   369: ireturn
    //   370: iload #4
    //   372: iload #6
    //   374: iadd
    //   375: istore #4
    //   377: goto -> 150
    //   380: invokestatic c : ()Ljava/io/IOException;
    //   383: athrow
    //   384: invokestatic c : ()Ljava/io/IOException;
    //   387: athrow
    //   388: astore_1
    //   389: aload_0
    //   390: monitorexit
    //   391: aload_1
    //   392: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	388	finally
    //   21	27	388	finally
    //   32	56	388	finally
    //   62	73	388	finally
    //   73	97	388	finally
    //   103	110	388	finally
    //   150	156	388	finally
    //   165	183	388	finally
    //   211	221	388	finally
    //   249	264	388	finally
    //   272	276	388	finally
    //   276	289	388	finally
    //   295	306	388	finally
    //   306	331	388	finally
    //   352	359	388	finally
    //   380	384	388	finally
    //   384	388	388	finally
  }
  
  public void reset() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : [B
    //   6: ifnull -> 80
    //   9: iconst_m1
    //   10: aload_0
    //   11: getfield d : I
    //   14: if_icmpeq -> 28
    //   17: aload_0
    //   18: aload_0
    //   19: getfield d : I
    //   22: putfield e : I
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: new java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: astore_1
    //   36: aload_1
    //   37: ldc 'Mark has been invalidated, pos: '
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_1
    //   44: aload_0
    //   45: getfield e : I
    //   48: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_1
    //   53: ldc ' markLimit: '
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_1
    //   60: aload_0
    //   61: getfield c : I
    //   64: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: new com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream$InvalidMarkException
    //   71: dup
    //   72: aload_1
    //   73: invokevirtual toString : ()Ljava/lang/String;
    //   76: invokespecial <init> : (Ljava/lang/String;)V
    //   79: athrow
    //   80: new java/io/IOException
    //   83: dup
    //   84: ldc 'Stream is closed'
    //   86: invokespecial <init> : (Ljava/lang/String;)V
    //   89: athrow
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	90	finally
    //   28	80	90	finally
    //   80	90	90	finally
  }
  
  public long skip(long paramLong) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lload_1
    //   3: lconst_1
    //   4: lcmp
    //   5: ifge -> 12
    //   8: aload_0
    //   9: monitorexit
    //   10: lconst_0
    //   11: lreturn
    //   12: aload_0
    //   13: getfield a : [B
    //   16: astore #8
    //   18: aload #8
    //   20: ifnull -> 212
    //   23: aload_0
    //   24: getfield in : Ljava/io/InputStream;
    //   27: astore #9
    //   29: aload #9
    //   31: ifnull -> 208
    //   34: aload_0
    //   35: getfield b : I
    //   38: aload_0
    //   39: getfield e : I
    //   42: isub
    //   43: i2l
    //   44: lload_1
    //   45: lcmp
    //   46: iflt -> 65
    //   49: aload_0
    //   50: aload_0
    //   51: getfield e : I
    //   54: i2l
    //   55: lload_1
    //   56: ladd
    //   57: l2i
    //   58: putfield e : I
    //   61: aload_0
    //   62: monitorexit
    //   63: lload_1
    //   64: lreturn
    //   65: aload_0
    //   66: getfield b : I
    //   69: i2l
    //   70: aload_0
    //   71: getfield e : I
    //   74: i2l
    //   75: lsub
    //   76: lstore #4
    //   78: aload_0
    //   79: aload_0
    //   80: getfield b : I
    //   83: putfield e : I
    //   86: aload_0
    //   87: getfield d : I
    //   90: iconst_m1
    //   91: if_icmpeq -> 191
    //   94: lload_1
    //   95: aload_0
    //   96: getfield c : I
    //   99: i2l
    //   100: lcmp
    //   101: ifgt -> 191
    //   104: aload_0
    //   105: aload #9
    //   107: aload #8
    //   109: invokespecial a : (Ljava/io/InputStream;[B)I
    //   112: istore_3
    //   113: iload_3
    //   114: iconst_m1
    //   115: if_icmpne -> 123
    //   118: aload_0
    //   119: monitorexit
    //   120: lload #4
    //   122: lreturn
    //   123: aload_0
    //   124: getfield b : I
    //   127: aload_0
    //   128: getfield e : I
    //   131: isub
    //   132: i2l
    //   133: lload_1
    //   134: lload #4
    //   136: lsub
    //   137: lcmp
    //   138: iflt -> 160
    //   141: aload_0
    //   142: aload_0
    //   143: getfield e : I
    //   146: i2l
    //   147: lload_1
    //   148: ladd
    //   149: lload #4
    //   151: lsub
    //   152: l2i
    //   153: putfield e : I
    //   156: aload_0
    //   157: monitorexit
    //   158: lload_1
    //   159: lreturn
    //   160: aload_0
    //   161: getfield b : I
    //   164: i2l
    //   165: lstore_1
    //   166: aload_0
    //   167: getfield e : I
    //   170: i2l
    //   171: lstore #6
    //   173: aload_0
    //   174: aload_0
    //   175: getfield b : I
    //   178: putfield e : I
    //   181: aload_0
    //   182: monitorexit
    //   183: lload #4
    //   185: lload_1
    //   186: ladd
    //   187: lload #6
    //   189: lsub
    //   190: lreturn
    //   191: aload #9
    //   193: lload_1
    //   194: lload #4
    //   196: lsub
    //   197: invokevirtual skip : (J)J
    //   200: lstore_1
    //   201: aload_0
    //   202: monitorexit
    //   203: lload #4
    //   205: lload_1
    //   206: ladd
    //   207: lreturn
    //   208: invokestatic c : ()Ljava/io/IOException;
    //   211: athrow
    //   212: invokestatic c : ()Ljava/io/IOException;
    //   215: athrow
    //   216: astore #8
    //   218: aload_0
    //   219: monitorexit
    //   220: aload #8
    //   222: athrow
    // Exception table:
    //   from	to	target	type
    //   12	18	216	finally
    //   23	29	216	finally
    //   34	61	216	finally
    //   65	113	216	finally
    //   123	156	216	finally
    //   160	181	216	finally
    //   191	201	216	finally
    //   208	212	216	finally
    //   212	216	216	finally
  }
  
  static class InvalidMarkException extends IOException {
    InvalidMarkException(String param1String) {
      super(param1String);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\RecyclableBufferedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */