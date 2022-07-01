package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.c;
import com.bytedance.sdk.a.a.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class j implements Closeable {
  private static final Logger b = Logger.getLogger(e.class.getName());
  
  final d.b a;
  
  private final d c;
  
  private final boolean d;
  
  private final c e;
  
  private int f;
  
  private boolean g;
  
  j(d paramd, boolean paramBoolean) {
    this.c = paramd;
    this.d = paramBoolean;
    this.e = new c();
    this.a = new d.b(this.e);
    this.f = 16384;
  }
  
  private static void a(d paramd, int paramInt) throws IOException {
    paramd.i(paramInt >>> 16 & 0xFF);
    paramd.i(paramInt >>> 8 & 0xFF);
    paramd.i(paramInt & 0xFF);
  }
  
  private void b(int paramInt, long paramLong) throws IOException {
    while (paramLong > 0L) {
      boolean bool;
      int i = (int)Math.min(this.f, paramLong);
      long l = i;
      paramLong -= l;
      if (paramLong == 0L) {
        bool = true;
      } else {
        bool = false;
      } 
      a(paramInt, i, (byte)9, bool);
      this.c.a_(this.e, l);
    } 
  }
  
  public void a() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Z
    //   6: ifne -> 85
    //   9: aload_0
    //   10: getfield d : Z
    //   13: istore_1
    //   14: iload_1
    //   15: ifne -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: getstatic com/bytedance/sdk/a/b/a/e/j.b : Ljava/util/logging/Logger;
    //   24: getstatic java/util/logging/Level.FINE : Ljava/util/logging/Level;
    //   27: invokevirtual isLoggable : (Ljava/util/logging/Level;)Z
    //   30: ifeq -> 57
    //   33: getstatic com/bytedance/sdk/a/b/a/e/j.b : Ljava/util/logging/Logger;
    //   36: ldc '>> CONNECTION %s'
    //   38: iconst_1
    //   39: anewarray java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: getstatic com/bytedance/sdk/a/b/a/e/e.a : Lcom/bytedance/sdk/a/a/f;
    //   47: invokevirtual e : ()Ljava/lang/String;
    //   50: aastore
    //   51: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   54: invokevirtual fine : (Ljava/lang/String;)V
    //   57: aload_0
    //   58: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   61: getstatic com/bytedance/sdk/a/b/a/e/e.a : Lcom/bytedance/sdk/a/a/f;
    //   64: invokevirtual h : ()[B
    //   67: invokeinterface c : ([B)Lcom/bytedance/sdk/a/a/d;
    //   72: pop
    //   73: aload_0
    //   74: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   77: invokeinterface flush : ()V
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: new java/io/IOException
    //   88: dup
    //   89: ldc 'closed'
    //   91: invokespecial <init> : (Ljava/lang/String;)V
    //   94: athrow
    //   95: astore_2
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	95	finally
    //   21	57	95	finally
    //   57	82	95	finally
    //   85	95	95	finally
  }
  
  void a(int paramInt1, byte paramByte, c paramc, int paramInt2) throws IOException {
    a(paramInt1, paramInt2, (byte)0, paramByte);
    if (paramInt2 > 0)
      this.c.a_(paramc, paramInt2); 
  }
  
  public void a(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2) throws IOException {
    if (b.isLoggable(Level.FINE))
      b.fine(e.a(false, paramInt1, paramInt2, paramByte1, paramByte2)); 
    int i = this.f;
    if (paramInt2 <= i) {
      if ((Integer.MIN_VALUE & paramInt1) == 0) {
        a(this.c, paramInt2);
        this.c.i(paramByte1 & 0xFF);
        this.c.i(paramByte2 & 0xFF);
        this.c.g(paramInt1 & Integer.MAX_VALUE);
        return;
      } 
      throw e.a("reserved bit set: %s", new Object[] { Integer.valueOf(paramInt1) });
    } 
    throw e.a("FRAME_SIZE_ERROR length > %d: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
  }
  
  public void a(int paramInt1, int paramInt2, List<c> paramList) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Z
    //   6: ifne -> 123
    //   9: aload_0
    //   10: getfield a : Lcom/bytedance/sdk/a/b/a/e/d$b;
    //   13: aload_3
    //   14: invokevirtual a : (Ljava/util/List;)V
    //   17: aload_0
    //   18: getfield e : Lcom/bytedance/sdk/a/a/c;
    //   21: invokevirtual b : ()J
    //   24: lstore #7
    //   26: aload_0
    //   27: getfield f : I
    //   30: iconst_4
    //   31: isub
    //   32: i2l
    //   33: lload #7
    //   35: invokestatic min : (JJ)J
    //   38: l2i
    //   39: istore #5
    //   41: iload #5
    //   43: i2l
    //   44: lstore #9
    //   46: lload #7
    //   48: lload #9
    //   50: lcmp
    //   51: istore #6
    //   53: iload #6
    //   55: ifne -> 138
    //   58: iconst_4
    //   59: istore #4
    //   61: goto -> 64
    //   64: aload_0
    //   65: iload_1
    //   66: iload #5
    //   68: iconst_4
    //   69: iadd
    //   70: iconst_5
    //   71: iload #4
    //   73: invokevirtual a : (IIBB)V
    //   76: aload_0
    //   77: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   80: iload_2
    //   81: ldc 2147483647
    //   83: iand
    //   84: invokeinterface g : (I)Lcom/bytedance/sdk/a/a/d;
    //   89: pop
    //   90: aload_0
    //   91: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   94: aload_0
    //   95: getfield e : Lcom/bytedance/sdk/a/a/c;
    //   98: lload #9
    //   100: invokeinterface a_ : (Lcom/bytedance/sdk/a/a/c;J)V
    //   105: iload #6
    //   107: ifle -> 120
    //   110: aload_0
    //   111: iload_1
    //   112: lload #7
    //   114: lload #9
    //   116: lsub
    //   117: invokespecial b : (IJ)V
    //   120: aload_0
    //   121: monitorexit
    //   122: return
    //   123: new java/io/IOException
    //   126: dup
    //   127: ldc 'closed'
    //   129: invokespecial <init> : (Ljava/lang/String;)V
    //   132: athrow
    //   133: astore_3
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_3
    //   137: athrow
    //   138: iconst_0
    //   139: istore #4
    //   141: goto -> 64
    // Exception table:
    //   from	to	target	type
    //   2	41	133	finally
    //   64	105	133	finally
    //   110	120	133	finally
    //   123	133	133	finally
  }
  
  public void a(int paramInt, long paramLong) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Z
    //   6: ifne -> 73
    //   9: lload_2
    //   10: lconst_0
    //   11: lcmp
    //   12: ifeq -> 56
    //   15: lload_2
    //   16: ldc2_w 2147483647
    //   19: lcmp
    //   20: ifgt -> 56
    //   23: aload_0
    //   24: iload_1
    //   25: iconst_4
    //   26: bipush #8
    //   28: iconst_0
    //   29: invokevirtual a : (IIBB)V
    //   32: aload_0
    //   33: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   36: lload_2
    //   37: l2i
    //   38: invokeinterface g : (I)Lcom/bytedance/sdk/a/a/d;
    //   43: pop
    //   44: aload_0
    //   45: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   48: invokeinterface flush : ()V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: ldc 'windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s'
    //   58: iconst_1
    //   59: anewarray java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: lload_2
    //   65: invokestatic valueOf : (J)Ljava/lang/Long;
    //   68: aastore
    //   69: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/IllegalArgumentException;
    //   72: athrow
    //   73: new java/io/IOException
    //   76: dup
    //   77: ldc 'closed'
    //   79: invokespecial <init> : (Ljava/lang/String;)V
    //   82: athrow
    //   83: astore #4
    //   85: aload_0
    //   86: monitorexit
    //   87: aload #4
    //   89: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	83	finally
    //   23	53	83	finally
    //   56	73	83	finally
    //   73	83	83	finally
  }
  
  public void a(int paramInt, b paramb) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Z
    //   6: ifne -> 59
    //   9: aload_2
    //   10: getfield g : I
    //   13: iconst_m1
    //   14: if_icmpeq -> 51
    //   17: aload_0
    //   18: iload_1
    //   19: iconst_4
    //   20: iconst_3
    //   21: iconst_0
    //   22: invokevirtual a : (IIBB)V
    //   25: aload_0
    //   26: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   29: aload_2
    //   30: getfield g : I
    //   33: invokeinterface g : (I)Lcom/bytedance/sdk/a/a/d;
    //   38: pop
    //   39: aload_0
    //   40: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   43: invokeinterface flush : ()V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: new java/lang/IllegalArgumentException
    //   54: dup
    //   55: invokespecial <init> : ()V
    //   58: athrow
    //   59: new java/io/IOException
    //   62: dup
    //   63: ldc 'closed'
    //   65: invokespecial <init> : (Ljava/lang/String;)V
    //   68: athrow
    //   69: astore_2
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_2
    //   73: athrow
    // Exception table:
    //   from	to	target	type
    //   2	48	69	finally
    //   51	59	69	finally
    //   59	69	69	finally
  }
  
  public void a(int paramInt, b paramb, byte[] paramArrayOfbyte) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Z
    //   6: ifne -> 93
    //   9: aload_2
    //   10: getfield g : I
    //   13: iconst_m1
    //   14: if_icmpeq -> 83
    //   17: aload_0
    //   18: iconst_0
    //   19: aload_3
    //   20: arraylength
    //   21: bipush #8
    //   23: iadd
    //   24: bipush #7
    //   26: iconst_0
    //   27: invokevirtual a : (IIBB)V
    //   30: aload_0
    //   31: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   34: iload_1
    //   35: invokeinterface g : (I)Lcom/bytedance/sdk/a/a/d;
    //   40: pop
    //   41: aload_0
    //   42: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   45: aload_2
    //   46: getfield g : I
    //   49: invokeinterface g : (I)Lcom/bytedance/sdk/a/a/d;
    //   54: pop
    //   55: aload_3
    //   56: arraylength
    //   57: ifle -> 71
    //   60: aload_0
    //   61: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   64: aload_3
    //   65: invokeinterface c : ([B)Lcom/bytedance/sdk/a/a/d;
    //   70: pop
    //   71: aload_0
    //   72: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   75: invokeinterface flush : ()V
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: ldc 'errorCode.httpCode == -1'
    //   85: iconst_0
    //   86: anewarray java/lang/Object
    //   89: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/IllegalArgumentException;
    //   92: athrow
    //   93: new java/io/IOException
    //   96: dup
    //   97: ldc 'closed'
    //   99: invokespecial <init> : (Ljava/lang/String;)V
    //   102: athrow
    //   103: astore_2
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_2
    //   107: athrow
    // Exception table:
    //   from	to	target	type
    //   2	71	103	finally
    //   71	80	103	finally
    //   83	93	103	finally
    //   93	103	103	finally
  }
  
  public void a(n paramn) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Z
    //   6: ifne -> 60
    //   9: aload_0
    //   10: aload_1
    //   11: aload_0
    //   12: getfield f : I
    //   15: invokevirtual d : (I)I
    //   18: putfield f : I
    //   21: aload_1
    //   22: invokevirtual c : ()I
    //   25: iconst_m1
    //   26: if_icmpeq -> 40
    //   29: aload_0
    //   30: getfield a : Lcom/bytedance/sdk/a/b/a/e/d$b;
    //   33: aload_1
    //   34: invokevirtual c : ()I
    //   37: invokevirtual a : (I)V
    //   40: aload_0
    //   41: iconst_0
    //   42: iconst_0
    //   43: iconst_4
    //   44: iconst_1
    //   45: invokevirtual a : (IIBB)V
    //   48: aload_0
    //   49: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   52: invokeinterface flush : ()V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: new java/io/IOException
    //   63: dup
    //   64: ldc 'closed'
    //   66: invokespecial <init> : (Ljava/lang/String;)V
    //   69: athrow
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Exception table:
    //   from	to	target	type
    //   2	40	70	finally
    //   40	57	70	finally
    //   60	70	70	finally
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Z
    //   6: ifne -> 64
    //   9: iload_1
    //   10: ifeq -> 81
    //   13: iconst_1
    //   14: istore #4
    //   16: goto -> 19
    //   19: aload_0
    //   20: iconst_0
    //   21: bipush #8
    //   23: bipush #6
    //   25: iload #4
    //   27: invokevirtual a : (IIBB)V
    //   30: aload_0
    //   31: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   34: iload_2
    //   35: invokeinterface g : (I)Lcom/bytedance/sdk/a/a/d;
    //   40: pop
    //   41: aload_0
    //   42: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   45: iload_3
    //   46: invokeinterface g : (I)Lcom/bytedance/sdk/a/a/d;
    //   51: pop
    //   52: aload_0
    //   53: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   56: invokeinterface flush : ()V
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: new java/io/IOException
    //   67: dup
    //   68: ldc 'closed'
    //   70: invokespecial <init> : (Ljava/lang/String;)V
    //   73: athrow
    //   74: astore #5
    //   76: aload_0
    //   77: monitorexit
    //   78: aload #5
    //   80: athrow
    //   81: iconst_0
    //   82: istore #4
    //   84: goto -> 19
    // Exception table:
    //   from	to	target	type
    //   2	9	74	finally
    //   19	61	74	finally
    //   64	74	74	finally
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, List<c> paramList) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Z
    //   6: ifne -> 20
    //   9: aload_0
    //   10: iload_1
    //   11: iload_2
    //   12: aload #4
    //   14: invokevirtual a : (ZILjava/util/List;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: new java/io/IOException
    //   23: dup
    //   24: ldc 'closed'
    //   26: invokespecial <init> : (Ljava/lang/String;)V
    //   29: athrow
    //   30: astore #4
    //   32: aload_0
    //   33: monitorexit
    //   34: aload #4
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	30	finally
    //   20	30	30	finally
  }
  
  public void a(boolean paramBoolean, int paramInt1, c paramc, int paramInt2) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Z
    //   6: ifne -> 33
    //   9: iconst_0
    //   10: istore #5
    //   12: iload_1
    //   13: ifeq -> 20
    //   16: iconst_1
    //   17: i2b
    //   18: istore #5
    //   20: aload_0
    //   21: iload_2
    //   22: iload #5
    //   24: aload_3
    //   25: iload #4
    //   27: invokevirtual a : (IBLcom/bytedance/sdk/a/a/c;I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: new java/io/IOException
    //   36: dup
    //   37: ldc 'closed'
    //   39: invokespecial <init> : (Ljava/lang/String;)V
    //   42: athrow
    //   43: astore_3
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_3
    //   47: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	43	finally
    //   20	30	43	finally
    //   33	43	43	finally
  }
  
  void a(boolean paramBoolean, int paramInt, List<c> paramList) throws IOException {
    if (!this.g) {
      byte b1;
      this.a.a(paramList);
      long l1 = this.e.b();
      int i = (int)Math.min(this.f, l1);
      long l2 = i;
      int k = l1 cmp l2;
      if (k == 0) {
        b1 = 4;
      } else {
        b1 = 0;
      } 
      byte b2 = b1;
      if (paramBoolean)
        b2 = (byte)(b1 | 0x1); 
      a(paramInt, i, (byte)1, b2);
      this.c.a_(this.e, l2);
      if (k > 0)
        b(paramInt, l1 - l2); 
      return;
    } 
    throw new IOException("closed");
  }
  
  public void b() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Z
    //   6: ifne -> 21
    //   9: aload_0
    //   10: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   13: invokeinterface flush : ()V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: new java/io/IOException
    //   24: dup
    //   25: ldc 'closed'
    //   27: invokespecial <init> : (Ljava/lang/String;)V
    //   30: athrow
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	31	finally
    //   21	31	31	finally
  }
  
  public void b(n paramn) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Z
    //   6: ifne -> 85
    //   9: aload_1
    //   10: invokevirtual b : ()I
    //   13: istore_3
    //   14: iconst_0
    //   15: istore_2
    //   16: aload_0
    //   17: iconst_0
    //   18: iload_3
    //   19: bipush #6
    //   21: imul
    //   22: iconst_4
    //   23: iconst_0
    //   24: invokevirtual a : (IIBB)V
    //   27: iload_2
    //   28: bipush #10
    //   30: if_icmpge -> 73
    //   33: aload_1
    //   34: iload_2
    //   35: invokevirtual a : (I)Z
    //   38: ifne -> 100
    //   41: goto -> 126
    //   44: aload_0
    //   45: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   48: iload_3
    //   49: invokeinterface h : (I)Lcom/bytedance/sdk/a/a/d;
    //   54: pop
    //   55: aload_0
    //   56: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   59: aload_1
    //   60: iload_2
    //   61: invokevirtual b : (I)I
    //   64: invokeinterface g : (I)Lcom/bytedance/sdk/a/a/d;
    //   69: pop
    //   70: goto -> 126
    //   73: aload_0
    //   74: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   77: invokeinterface flush : ()V
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: new java/io/IOException
    //   88: dup
    //   89: ldc 'closed'
    //   91: invokespecial <init> : (Ljava/lang/String;)V
    //   94: athrow
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    //   100: iload_2
    //   101: iconst_4
    //   102: if_icmpne -> 110
    //   105: iconst_3
    //   106: istore_3
    //   107: goto -> 44
    //   110: iload_2
    //   111: bipush #7
    //   113: if_icmpne -> 121
    //   116: iconst_4
    //   117: istore_3
    //   118: goto -> 44
    //   121: iload_2
    //   122: istore_3
    //   123: goto -> 44
    //   126: iload_2
    //   127: iconst_1
    //   128: iadd
    //   129: istore_2
    //   130: goto -> 27
    // Exception table:
    //   from	to	target	type
    //   2	14	95	finally
    //   16	27	95	finally
    //   33	41	95	finally
    //   44	70	95	finally
    //   73	82	95	finally
    //   85	95	95	finally
  }
  
  public int c() {
    return this.f;
  }
  
  public void close() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield g : Z
    //   7: aload_0
    //   8: getfield c : Lcom/bytedance/sdk/a/a/d;
    //   11: invokeinterface close : ()V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	19	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\e\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */