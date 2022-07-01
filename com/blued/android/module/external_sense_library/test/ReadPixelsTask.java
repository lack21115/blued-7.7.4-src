package com.blued.android.module.external_sense_library.test;

import android.os.AsyncTask;
import android.os.Process;
import android.util.Log;
import android.widget.ProgressBar;
import com.blued.android.core.AppMethods;
import com.blued.android.module.external_sense_library.test.gles.OffscreenSurface;

public class ReadPixelsTask extends AsyncTask<Void, Integer, Long> {
  private static final String a = ReadPixelsTask.class.getSimpleName();
  
  private int b;
  
  private int c;
  
  private int d;
  
  private ProgressBar e;
  
  private long a(OffscreenSurface paramOffscreenSurface) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual d : ()V
    //   4: aload_0
    //   5: getfield b : I
    //   8: aload_0
    //   9: getfield c : I
    //   12: imul
    //   13: iconst_4
    //   14: imul
    //   15: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   18: astore #14
    //   20: aload #14
    //   22: getstatic java/nio/ByteOrder.LITTLE_ENDIAN : Ljava/nio/ByteOrder;
    //   25: invokevirtual order : (Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   28: pop
    //   29: getstatic com/blued/android/module/external_sense_library/test/ReadPixelsTask.a : Ljava/lang/String;
    //   32: ldc 'Running...'
    //   34: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   37: pop
    //   38: fconst_1
    //   39: aload_0
    //   40: getfield d : I
    //   43: i2f
    //   44: fdiv
    //   45: fstore_2
    //   46: lconst_0
    //   47: lstore #10
    //   49: iconst_0
    //   50: istore #6
    //   52: aload_0
    //   53: getfield d : I
    //   56: istore #7
    //   58: iload #6
    //   60: iload #7
    //   62: if_icmpge -> 252
    //   65: iload #6
    //   67: iload #7
    //   69: bipush #8
    //   71: idiv
    //   72: irem
    //   73: ifne -> 92
    //   76: aload_0
    //   77: iconst_1
    //   78: anewarray java/lang/Integer
    //   81: dup
    //   82: iconst_0
    //   83: iload #6
    //   85: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   88: aastore
    //   89: invokevirtual publishProgress : ([Ljava/lang/Object;)V
    //   92: iload #6
    //   94: i2f
    //   95: fload_2
    //   96: fmul
    //   97: fstore_3
    //   98: fconst_1
    //   99: fload_3
    //   100: fsub
    //   101: fstore #4
    //   103: fload_3
    //   104: fload #4
    //   106: fadd
    //   107: fconst_2
    //   108: fdiv
    //   109: fstore #5
    //   111: fload_3
    //   112: fload #4
    //   114: fload #5
    //   116: fconst_1
    //   117: invokestatic glClearColor : (FFFF)V
    //   120: sipush #16384
    //   123: invokestatic glClear : (I)V
    //   126: sipush #3089
    //   129: invokestatic glEnable : (I)V
    //   132: aload_0
    //   133: getfield b : I
    //   136: istore #7
    //   138: iload #7
    //   140: iconst_4
    //   141: idiv
    //   142: istore #8
    //   144: aload_0
    //   145: getfield c : I
    //   148: istore #9
    //   150: iload #8
    //   152: iload #9
    //   154: iconst_4
    //   155: idiv
    //   156: iload #7
    //   158: iconst_2
    //   159: idiv
    //   160: iload #9
    //   162: iconst_2
    //   163: idiv
    //   164: invokestatic glScissor : (IIII)V
    //   167: fload #5
    //   169: fload #4
    //   171: fload_3
    //   172: fconst_1
    //   173: invokestatic glClearColor : (FFFF)V
    //   176: sipush #16384
    //   179: invokestatic glClear : (I)V
    //   182: sipush #3089
    //   185: invokestatic glDisable : (I)V
    //   188: invokestatic glFinish : ()V
    //   191: iconst_0
    //   192: iconst_0
    //   193: iconst_1
    //   194: iconst_1
    //   195: sipush #6408
    //   198: sipush #5121
    //   201: aload #14
    //   203: invokestatic glReadPixels : (IIIIIILjava/nio/Buffer;)V
    //   206: invokestatic nanoTime : ()J
    //   209: lstore #12
    //   211: iconst_0
    //   212: iconst_0
    //   213: aload_0
    //   214: getfield b : I
    //   217: aload_0
    //   218: getfield c : I
    //   221: sipush #6408
    //   224: sipush #5121
    //   227: aload #14
    //   229: invokestatic glReadPixels : (IIIIIILjava/nio/Buffer;)V
    //   232: lload #10
    //   234: invokestatic nanoTime : ()J
    //   237: lload #12
    //   239: lsub
    //   240: ladd
    //   241: lstore #10
    //   243: iload #6
    //   245: iconst_1
    //   246: iadd
    //   247: istore #6
    //   249: goto -> 52
    //   252: getstatic com/blued/android/module/external_sense_library/test/ReadPixelsTask.a : Ljava/lang/String;
    //   255: ldc 'done'
    //   257: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   260: pop
    //   261: invokestatic nanoTime : ()J
    //   264: lstore #12
    //   266: aload_1
    //   267: new java/io/File
    //   270: dup
    //   271: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   274: ldc 'test.png'
    //   276: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   279: invokevirtual a : (Ljava/io/File;)V
    //   282: getstatic com/blued/android/module/external_sense_library/test/ReadPixelsTask.a : Ljava/lang/String;
    //   285: astore_1
    //   286: new java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial <init> : ()V
    //   293: astore #14
    //   295: aload #14
    //   297: ldc 'Saved frame in '
    //   299: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload #14
    //   305: invokestatic nanoTime : ()J
    //   308: lload #12
    //   310: lsub
    //   311: ldc2_w 1000000
    //   314: ldiv
    //   315: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload #14
    //   321: ldc 'ms'
    //   323: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload_1
    //   328: aload #14
    //   330: invokevirtual toString : ()Ljava/lang/String;
    //   333: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   336: pop
    //   337: lload #10
    //   339: lreturn
    //   340: astore_1
    //   341: new java/lang/RuntimeException
    //   344: dup
    //   345: aload_1
    //   346: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   349: athrow
    // Exception table:
    //   from	to	target	type
    //   266	282	340	java/io/IOException
  }
  
  protected Long a(Void... paramVarArgs) {
    Exception exception;
    Void[] arrayOfVoid;
    Process.setThreadPriority(-2);
    try {
    
    } finally {
      exception = null;
      paramVarArgs = null;
    } 
    if (paramVarArgs != null)
      paramVarArgs.e(); 
    if (arrayOfVoid != null)
      arrayOfVoid.a(); 
    throw exception;
  }
  
  protected void a(Long paramLong) {
    String str = a;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("onPostExecute result=");
    stringBuilder2.append(paramLong);
    Log.d(str, stringBuilder2.toString());
    if (paramLong.longValue() < 0L) {
      AppMethods.a("没有保存完成");
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("保存中..");
    stringBuilder1.append(paramLong.longValue() / 1000L);
    AppMethods.a(stringBuilder1.toString());
  }
  
  protected void a(Integer... paramVarArgs) {
    this.e.setProgress(paramVarArgs[0].intValue());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\test\ReadPixelsTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */