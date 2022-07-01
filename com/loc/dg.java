package com.loc;

public final class dg {
  private static volatile dh a;
  
  public static void a(Throwable paramThrowable) {
    // Byte code:
    //   0: getstatic com/loc/cv.a : Z
    //   3: ifeq -> 68
    //   6: aload_0
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull -> 27
    //   12: aload_1
    //   13: instanceof java/net/UnknownHostException
    //   16: ifne -> 58
    //   19: aload_1
    //   20: invokevirtual getCause : ()Ljava/lang/Throwable;
    //   23: astore_1
    //   24: goto -> 8
    //   27: new java/io/StringWriter
    //   30: dup
    //   31: invokespecial <init> : ()V
    //   34: astore_1
    //   35: new java/io/PrintWriter
    //   38: dup
    //   39: aload_1
    //   40: invokespecial <init> : (Ljava/io/Writer;)V
    //   43: astore_2
    //   44: aload_0
    //   45: aload_2
    //   46: invokevirtual printStackTrace : (Ljava/io/PrintWriter;)V
    //   49: aload_2
    //   50: invokevirtual flush : ()V
    //   53: aload_1
    //   54: invokevirtual toString : ()Ljava/lang/String;
    //   57: pop
    //   58: getstatic com/loc/dg.a : Lcom/loc/dh;
    //   61: ifnull -> 68
    //   64: getstatic com/loc/dg.a : Lcom/loc/dh;
    //   67: astore_0
    //   68: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */