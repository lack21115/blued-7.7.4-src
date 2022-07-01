package com.alibaba.mtl.log.e;

import android.content.Context;
import java.io.File;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class k {
  static File a;
  
  static FileChannel a;
  
  static FileLock a;
  
  public static boolean c(Context paramContext) {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/e/k
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/e/k.a : Ljava/io/File;
    //   6: ifnonnull -> 55
    //   9: new java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore_3
    //   17: aload_3
    //   18: aload_0
    //   19: invokevirtual getFilesDir : ()Ljava/io/File;
    //   22: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_3
    //   27: getstatic java/io/File.separator : Ljava/lang/String;
    //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_3
    //   35: ldc 'ap.Lock'
    //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: new java/io/File
    //   44: dup
    //   45: aload_3
    //   46: invokevirtual toString : ()Ljava/lang/String;
    //   49: invokespecial <init> : (Ljava/lang/String;)V
    //   52: putstatic com/alibaba/mtl/log/e/k.a : Ljava/io/File;
    //   55: getstatic com/alibaba/mtl/log/e/k.a : Ljava/io/File;
    //   58: invokevirtual exists : ()Z
    //   61: istore_2
    //   62: iload_2
    //   63: istore_1
    //   64: iload_2
    //   65: ifne -> 78
    //   68: getstatic com/alibaba/mtl/log/e/k.a : Ljava/io/File;
    //   71: invokevirtual createNewFile : ()Z
    //   74: istore_1
    //   75: goto -> 78
    //   78: iload_1
    //   79: ifne -> 87
    //   82: ldc com/alibaba/mtl/log/e/k
    //   84: monitorexit
    //   85: iconst_1
    //   86: ireturn
    //   87: getstatic com/alibaba/mtl/log/e/k.a : Ljava/nio/channels/FileChannel;
    //   90: astore_0
    //   91: aload_0
    //   92: ifnonnull -> 121
    //   95: new java/io/RandomAccessFile
    //   98: dup
    //   99: getstatic com/alibaba/mtl/log/e/k.a : Ljava/io/File;
    //   102: ldc 'rw'
    //   104: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   107: invokevirtual getChannel : ()Ljava/nio/channels/FileChannel;
    //   110: putstatic com/alibaba/mtl/log/e/k.a : Ljava/nio/channels/FileChannel;
    //   113: goto -> 121
    //   116: ldc com/alibaba/mtl/log/e/k
    //   118: monitorexit
    //   119: iconst_0
    //   120: ireturn
    //   121: getstatic com/alibaba/mtl/log/e/k.a : Ljava/nio/channels/FileChannel;
    //   124: invokevirtual tryLock : ()Ljava/nio/channels/FileLock;
    //   127: astore_3
    //   128: aload_3
    //   129: astore_0
    //   130: aload_3
    //   131: ifnull -> 145
    //   134: aload_3
    //   135: putstatic com/alibaba/mtl/log/e/k.a : Ljava/nio/channels/FileLock;
    //   138: ldc com/alibaba/mtl/log/e/k
    //   140: monitorexit
    //   141: iconst_1
    //   142: ireturn
    //   143: aconst_null
    //   144: astore_0
    //   145: new java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial <init> : ()V
    //   152: astore_3
    //   153: aload_3
    //   154: ldc 'mLock:'
    //   156: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_3
    //   161: aload_0
    //   162: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: ldc 'TAG'
    //   168: aload_3
    //   169: invokevirtual toString : ()Ljava/lang/String;
    //   172: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   175: pop
    //   176: ldc com/alibaba/mtl/log/e/k
    //   178: monitorexit
    //   179: iconst_0
    //   180: ireturn
    //   181: astore_0
    //   182: ldc com/alibaba/mtl/log/e/k
    //   184: monitorexit
    //   185: aload_0
    //   186: athrow
    //   187: astore_0
    //   188: iload_2
    //   189: istore_1
    //   190: goto -> 78
    //   193: astore_0
    //   194: goto -> 116
    //   197: astore_0
    //   198: goto -> 143
    // Exception table:
    //   from	to	target	type
    //   3	55	181	finally
    //   55	62	181	finally
    //   68	75	187	java/io/IOException
    //   68	75	181	finally
    //   87	91	181	finally
    //   95	113	193	java/lang/Exception
    //   95	113	181	finally
    //   121	128	197	finally
    //   134	138	197	finally
    //   145	176	181	finally
  }
  
  public static void release() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/e/k
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/e/k.a : Ljava/nio/channels/FileLock;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull -> 31
    //   11: getstatic com/alibaba/mtl/log/e/k.a : Ljava/nio/channels/FileLock;
    //   14: invokevirtual release : ()V
    //   17: aconst_null
    //   18: putstatic com/alibaba/mtl/log/e/k.a : Ljava/nio/channels/FileLock;
    //   21: goto -> 31
    //   24: astore_0
    //   25: aconst_null
    //   26: putstatic com/alibaba/mtl/log/e/k.a : Ljava/nio/channels/FileLock;
    //   29: aload_0
    //   30: athrow
    //   31: getstatic com/alibaba/mtl/log/e/k.a : Ljava/nio/channels/FileChannel;
    //   34: astore_0
    //   35: aload_0
    //   36: ifnull -> 59
    //   39: getstatic com/alibaba/mtl/log/e/k.a : Ljava/nio/channels/FileChannel;
    //   42: invokevirtual close : ()V
    //   45: aconst_null
    //   46: putstatic com/alibaba/mtl/log/e/k.a : Ljava/nio/channels/FileChannel;
    //   49: goto -> 59
    //   52: astore_0
    //   53: aconst_null
    //   54: putstatic com/alibaba/mtl/log/e/k.a : Ljava/nio/channels/FileChannel;
    //   57: aload_0
    //   58: athrow
    //   59: ldc com/alibaba/mtl/log/e/k
    //   61: monitorexit
    //   62: return
    //   63: astore_0
    //   64: ldc com/alibaba/mtl/log/e/k
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    //   69: astore_0
    //   70: goto -> 17
    //   73: astore_0
    //   74: goto -> 45
    // Exception table:
    //   from	to	target	type
    //   3	7	63	finally
    //   11	17	69	java/io/IOException
    //   11	17	24	finally
    //   17	21	63	finally
    //   25	31	63	finally
    //   31	35	63	finally
    //   39	45	73	java/lang/Exception
    //   39	45	52	finally
    //   45	49	63	finally
    //   53	59	63	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */