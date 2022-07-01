package com.facebook.stetho.dumpapp;

import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.SocketLikeHandler;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class DumpappSocketLikeHandler implements SocketLikeHandler {
  public static final byte[] PROTOCOL_MAGIC = new byte[] { 68, 85, 77, 80 };
  
  public static final int PROTOCOL_VERSION = 1;
  
  private final Dumper mDumper;
  
  public DumpappSocketLikeHandler(Dumper paramDumper) {
    this.mDumper = paramDumper;
  }
  
  static void dump(Dumper paramDumper, Framer paramFramer, String[] paramArrayOfString) throws IOException {
    try {
      paramFramer.writeExitCode(paramDumper.dump(paramFramer.getStdin(), paramFramer.getStdout(), paramFramer.getStderr(), paramArrayOfString));
      return;
    } catch (DumpappOutputBrokenException dumpappOutputBrokenException) {
      return;
    } 
  }
  
  private void establishConversation(DataInputStream paramDataInputStream) throws IOException {
    byte[] arrayOfByte = new byte[4];
    paramDataInputStream.readFully(arrayOfByte);
    if (Arrays.equals(PROTOCOL_MAGIC, arrayOfByte)) {
      int i = paramDataInputStream.readInt();
      if (i == 1)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Expected version=1; got=");
      stringBuilder.append(i);
      throw logAndThrowProtocolException(stringBuilder.toString());
    } 
    throw logAndThrowProtocolException("Incompatible protocol, are you using an old dumpapp script?");
  }
  
  private static IOException logAndThrowProtocolException(String paramString) throws IOException {
    LogUtil.w(paramString);
    throw new IOException(paramString);
  }
  
  private String[] readArgs(Framer paramFramer) throws IOException {
    // Byte code:
    //   0: aload_1
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual readFrameType : ()B
    //   6: istore_2
    //   7: iload_2
    //   8: bipush #33
    //   10: if_icmpne -> 51
    //   13: aload_1
    //   14: invokevirtual readInt : ()I
    //   17: istore_3
    //   18: iload_3
    //   19: anewarray java/lang/String
    //   22: astore #4
    //   24: iconst_0
    //   25: istore_2
    //   26: iload_2
    //   27: iload_3
    //   28: if_icmpge -> 46
    //   31: aload #4
    //   33: iload_2
    //   34: aload_1
    //   35: invokevirtual readString : ()Ljava/lang/String;
    //   38: aastore
    //   39: iload_2
    //   40: iconst_1
    //   41: iadd
    //   42: istore_2
    //   43: goto -> 26
    //   46: aload_1
    //   47: monitorexit
    //   48: aload #4
    //   50: areturn
    //   51: new java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial <init> : ()V
    //   58: astore #4
    //   60: aload #4
    //   62: ldc 'Expected enter frame, got: '
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload #4
    //   70: iload_2
    //   71: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: new com/facebook/stetho/dumpapp/DumpappFramingException
    //   78: dup
    //   79: aload #4
    //   81: invokevirtual toString : ()Ljava/lang/String;
    //   84: invokespecial <init> : (Ljava/lang/String;)V
    //   87: athrow
    //   88: astore #4
    //   90: aload_1
    //   91: monitorexit
    //   92: aload #4
    //   94: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	88	finally
    //   13	24	88	finally
    //   31	39	88	finally
    //   46	48	88	finally
    //   51	88	88	finally
    //   90	92	88	finally
  }
  
  public void onAccepted(SocketLike paramSocketLike) throws IOException {
    DataInputStream dataInputStream = new DataInputStream(paramSocketLike.getInput());
    establishConversation(dataInputStream);
    Framer framer = new Framer(dataInputStream, paramSocketLike.getOutput());
    String[] arrayOfString = readArgs(framer);
    dump(this.mDumper, framer, arrayOfString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\dumpapp\DumpappSocketLikeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */