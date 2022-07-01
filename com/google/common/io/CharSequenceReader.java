package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

final class CharSequenceReader extends Reader {
  private CharSequence a;
  
  private int b;
  
  private int c;
  
  public CharSequenceReader(CharSequence paramCharSequence) {
    this.a = (CharSequence)Preconditions.a(paramCharSequence);
  }
  
  private void a() throws IOException {
    if (this.a != null)
      return; 
    throw new IOException("reader closed");
  }
  
  private boolean b() {
    return (c() > 0);
  }
  
  private int c() {
    return this.a.length() - this.b;
  }
  
  public void close() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aconst_null
    //   4: putfield a : Ljava/lang/CharSequence;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public void mark(int paramInt) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iflt -> 11
    //   6: iconst_1
    //   7: istore_2
    //   8: goto -> 13
    //   11: iconst_0
    //   12: istore_2
    //   13: iload_2
    //   14: ldc 'readAheadLimit (%s) may not be negative'
    //   16: iload_1
    //   17: invokestatic a : (ZLjava/lang/String;I)V
    //   20: aload_0
    //   21: invokespecial a : ()V
    //   24: aload_0
    //   25: aload_0
    //   26: getfield b : I
    //   29: putfield c : I
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_3
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_3
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   13	32	35	finally
  }
  
  public boolean markSupported() {
    return true;
  }
  
  public int read() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial a : ()V
    //   6: aload_0
    //   7: invokespecial b : ()Z
    //   10: ifeq -> 41
    //   13: aload_0
    //   14: getfield a : Ljava/lang/CharSequence;
    //   17: astore_2
    //   18: aload_0
    //   19: getfield b : I
    //   22: istore_1
    //   23: aload_0
    //   24: iload_1
    //   25: iconst_1
    //   26: iadd
    //   27: putfield b : I
    //   30: aload_2
    //   31: iload_1
    //   32: invokeinterface charAt : (I)C
    //   37: istore_1
    //   38: goto -> 43
    //   41: iconst_m1
    //   42: istore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_1
    //   46: ireturn
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  public int read(CharBuffer paramCharBuffer) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic a : (Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: invokespecial a : ()V
    //   11: aload_0
    //   12: invokespecial b : ()Z
    //   15: istore #5
    //   17: iload #5
    //   19: ifne -> 26
    //   22: aload_0
    //   23: monitorexit
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_1
    //   27: invokevirtual remaining : ()I
    //   30: aload_0
    //   31: invokespecial c : ()I
    //   34: invokestatic min : (II)I
    //   37: istore_3
    //   38: iconst_0
    //   39: istore_2
    //   40: iload_2
    //   41: iload_3
    //   42: if_icmpge -> 86
    //   45: aload_0
    //   46: getfield a : Ljava/lang/CharSequence;
    //   49: astore #6
    //   51: aload_0
    //   52: getfield b : I
    //   55: istore #4
    //   57: aload_0
    //   58: iload #4
    //   60: iconst_1
    //   61: iadd
    //   62: putfield b : I
    //   65: aload_1
    //   66: aload #6
    //   68: iload #4
    //   70: invokeinterface charAt : (I)C
    //   75: invokevirtual put : (C)Ljava/nio/CharBuffer;
    //   78: pop
    //   79: iload_2
    //   80: iconst_1
    //   81: iadd
    //   82: istore_2
    //   83: goto -> 40
    //   86: aload_0
    //   87: monitorexit
    //   88: iload_3
    //   89: ireturn
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	90	finally
    //   26	38	90	finally
    //   45	79	90	finally
  }
  
  public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: iload_2
    //   4: iload_3
    //   5: iadd
    //   6: aload_1
    //   7: arraylength
    //   8: invokestatic a : (III)V
    //   11: aload_0
    //   12: invokespecial a : ()V
    //   15: aload_0
    //   16: invokespecial b : ()Z
    //   19: istore #6
    //   21: iload #6
    //   23: ifne -> 30
    //   26: aload_0
    //   27: monitorexit
    //   28: iconst_m1
    //   29: ireturn
    //   30: iload_3
    //   31: aload_0
    //   32: invokespecial c : ()I
    //   35: invokestatic min : (II)I
    //   38: istore #4
    //   40: iconst_0
    //   41: istore_3
    //   42: iload_3
    //   43: iload #4
    //   45: if_icmpge -> 89
    //   48: aload_0
    //   49: getfield a : Ljava/lang/CharSequence;
    //   52: astore #7
    //   54: aload_0
    //   55: getfield b : I
    //   58: istore #5
    //   60: aload_0
    //   61: iload #5
    //   63: iconst_1
    //   64: iadd
    //   65: putfield b : I
    //   68: aload_1
    //   69: iload_2
    //   70: iload_3
    //   71: iadd
    //   72: aload #7
    //   74: iload #5
    //   76: invokeinterface charAt : (I)C
    //   81: castore
    //   82: iload_3
    //   83: iconst_1
    //   84: iadd
    //   85: istore_3
    //   86: goto -> 42
    //   89: aload_0
    //   90: monitorexit
    //   91: iload #4
    //   93: ireturn
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	94	finally
    //   30	40	94	finally
    //   48	82	94	finally
  }
  
  public boolean ready() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial a : ()V
    //   6: aload_0
    //   7: monitorexit
    //   8: iconst_1
    //   9: ireturn
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	6	10	finally
  }
  
  public void reset() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial a : ()V
    //   6: aload_0
    //   7: aload_0
    //   8: getfield c : I
    //   11: putfield b : I
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	17	finally
  }
  
  public long skip(long paramLong) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lload_1
    //   3: lconst_0
    //   4: lcmp
    //   5: iflt -> 14
    //   8: iconst_1
    //   9: istore #4
    //   11: goto -> 17
    //   14: iconst_0
    //   15: istore #4
    //   17: iload #4
    //   19: ldc 'n (%s) may not be negative'
    //   21: lload_1
    //   22: invokestatic a : (ZLjava/lang/String;J)V
    //   25: aload_0
    //   26: invokespecial a : ()V
    //   29: aload_0
    //   30: invokespecial c : ()I
    //   33: i2l
    //   34: lload_1
    //   35: invokestatic min : (JJ)J
    //   38: l2i
    //   39: istore_3
    //   40: aload_0
    //   41: aload_0
    //   42: getfield b : I
    //   45: iload_3
    //   46: iadd
    //   47: putfield b : I
    //   50: iload_3
    //   51: i2l
    //   52: lstore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: lload_1
    //   56: lreturn
    //   57: astore #5
    //   59: aload_0
    //   60: monitorexit
    //   61: aload #5
    //   63: athrow
    // Exception table:
    //   from	to	target	type
    //   17	50	57	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\CharSequenceReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */