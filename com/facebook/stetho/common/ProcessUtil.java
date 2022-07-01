package com.facebook.stetho.common;

import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.Nullable;

public class ProcessUtil {
  private static final int CMDLINE_BUFFER_SIZE = 64;
  
  private static String sProcessName;
  
  private static boolean sProcessNameRead;
  
  @Nullable
  public static String getProcessName() {
    // Byte code:
    //   0: ldc com/facebook/stetho/common/ProcessUtil
    //   2: monitorenter
    //   3: getstatic com/facebook/stetho/common/ProcessUtil.sProcessNameRead : Z
    //   6: ifne -> 19
    //   9: iconst_1
    //   10: putstatic com/facebook/stetho/common/ProcessUtil.sProcessNameRead : Z
    //   13: invokestatic readProcessName : ()Ljava/lang/String;
    //   16: putstatic com/facebook/stetho/common/ProcessUtil.sProcessName : Ljava/lang/String;
    //   19: getstatic com/facebook/stetho/common/ProcessUtil.sProcessName : Ljava/lang/String;
    //   22: astore_0
    //   23: ldc com/facebook/stetho/common/ProcessUtil
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/facebook/stetho/common/ProcessUtil
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    //   34: astore_0
    //   35: goto -> 19
    // Exception table:
    //   from	to	target	type
    //   3	13	28	finally
    //   13	19	34	java/io/IOException
    //   13	19	28	finally
    //   19	23	28	finally
  }
  
  private static int indexOf(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, byte paramByte) {
    for (paramInt1 = 0; paramInt1 < paramArrayOfbyte.length; paramInt1++) {
      if (paramArrayOfbyte[paramInt1] == paramByte)
        return paramInt1; 
    } 
    return -1;
  }
  
  private static String readProcessName() throws IOException {
    int i;
    byte[] arrayOfByte = new byte[64];
    FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
    int j = 0;
    try {
      i = fileInputStream.read(arrayOfByte);
    } finally {
      arrayOfByte = null;
    } 
    Util.close(fileInputStream, 0x1 ^ i);
    throw arrayOfByte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\ProcessUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */