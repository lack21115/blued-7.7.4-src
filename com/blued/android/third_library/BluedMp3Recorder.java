package com.blued.android.third_library;

import android.os.Handler;

public class BluedMp3Recorder {
  private ErrorListener a;
  
  private Handler b;
  
  private boolean c = false;
  
  private String d;
  
  private volatile int e;
  
  public BluedMp3Recorder(String paramString) {
    this(paramString, null, null);
  }
  
  public BluedMp3Recorder(String paramString, ErrorListener paramErrorListener, Handler paramHandler) {
    this.d = paramString;
    this.a = paramErrorListener;
    this.b = paramHandler;
  }
  
  private void a(int paramInt, short[] paramArrayOfshort) {
    long l = 0L;
    for (int i = 0; i < paramInt; i++)
      l += (paramArrayOfshort[i] * paramArrayOfshort[i]); 
    this.e = Math.abs((int)(Math.log10(l / paramInt) * 10.0D));
  }
  
  private void e() {
    // Byte code:
    //   0: sipush #8000
    //   3: istore_1
    //   4: aconst_null
    //   5: astore #5
    //   7: iload_1
    //   8: bipush #16
    //   10: iconst_2
    //   11: invokestatic getMinBufferSize : (III)I
    //   14: istore #4
    //   16: ldc 44100
    //   18: istore_3
    //   19: new android/media/AudioRecord
    //   22: dup
    //   23: iconst_1
    //   24: iload_1
    //   25: bipush #16
    //   27: iconst_2
    //   28: iload #4
    //   30: iconst_2
    //   31: imul
    //   32: invokespecial <init> : (IIIII)V
    //   35: astore #6
    //   37: aload #6
    //   39: astore #5
    //   41: goto -> 64
    //   44: astore #6
    //   46: aload #6
    //   48: invokevirtual printStackTrace : ()V
    //   51: iload_1
    //   52: ldc 44100
    //   54: if_icmpeq -> 64
    //   57: iconst_1
    //   58: istore_2
    //   59: iload_3
    //   60: istore_1
    //   61: goto -> 66
    //   64: iconst_0
    //   65: istore_2
    //   66: iload_2
    //   67: ifne -> 328
    //   70: aload #5
    //   72: ifnonnull -> 84
    //   75: aload_0
    //   76: invokevirtual b : ()V
    //   79: aload_0
    //   80: invokespecial f : ()V
    //   83: return
    //   84: iload_1
    //   85: iconst_2
    //   86: imul
    //   87: iconst_5
    //   88: imul
    //   89: newarray short
    //   91: astore #7
    //   93: aload #7
    //   95: arraylength
    //   96: iconst_2
    //   97: imul
    //   98: i2d
    //   99: ldc2_w 1.25
    //   102: dmul
    //   103: ldc2_w 7200.0
    //   106: dadd
    //   107: d2i
    //   108: newarray byte
    //   110: astore #8
    //   112: new java/io/FileOutputStream
    //   115: dup
    //   116: new java/io/File
    //   119: dup
    //   120: aload_0
    //   121: getfield d : Ljava/lang/String;
    //   124: invokespecial <init> : (Ljava/lang/String;)V
    //   127: invokespecial <init> : (Ljava/io/File;)V
    //   130: astore #9
    //   132: new com/naman14/androidlame/LameBuilder
    //   135: dup
    //   136: invokespecial <init> : ()V
    //   139: iload_1
    //   140: invokevirtual a : (I)Lcom/naman14/androidlame/LameBuilder;
    //   143: iconst_1
    //   144: invokevirtual d : (I)Lcom/naman14/androidlame/LameBuilder;
    //   147: bipush #32
    //   149: invokevirtual c : (I)Lcom/naman14/androidlame/LameBuilder;
    //   152: iload_1
    //   153: invokevirtual b : (I)Lcom/naman14/androidlame/LameBuilder;
    //   156: invokevirtual a : ()Lcom/naman14/androidlame/AndroidLame;
    //   159: astore #6
    //   161: aload #5
    //   163: invokevirtual startRecording : ()V
    //   166: aload_0
    //   167: getfield c : Z
    //   170: ifeq -> 234
    //   173: aload #5
    //   175: aload #7
    //   177: iconst_0
    //   178: iload #4
    //   180: invokevirtual read : ([SII)I
    //   183: istore_1
    //   184: iload_1
    //   185: ifle -> 166
    //   188: aload_0
    //   189: iload_1
    //   190: aload #7
    //   192: invokespecial a : (I[S)V
    //   195: aload #6
    //   197: aload #7
    //   199: aload #7
    //   201: iload_1
    //   202: aload #8
    //   204: invokevirtual a : ([S[SI[B)I
    //   207: istore_1
    //   208: iload_1
    //   209: ifle -> 166
    //   212: aload #9
    //   214: aload #8
    //   216: iconst_0
    //   217: iload_1
    //   218: invokevirtual write : ([BII)V
    //   221: goto -> 166
    //   224: astore #10
    //   226: aload #10
    //   228: invokevirtual printStackTrace : ()V
    //   231: goto -> 166
    //   234: aload #6
    //   236: aload #8
    //   238: invokevirtual a : ([B)I
    //   241: istore_1
    //   242: iload_1
    //   243: ifle -> 270
    //   246: aload #9
    //   248: aload #8
    //   250: iconst_0
    //   251: iload_1
    //   252: invokevirtual write : ([BII)V
    //   255: aload #9
    //   257: invokevirtual close : ()V
    //   260: goto -> 270
    //   263: astore #7
    //   265: aload #7
    //   267: invokevirtual printStackTrace : ()V
    //   270: aload #5
    //   272: invokevirtual stop : ()V
    //   275: aload #5
    //   277: invokevirtual release : ()V
    //   280: goto -> 290
    //   283: astore #5
    //   285: aload #5
    //   287: invokevirtual printStackTrace : ()V
    //   290: aload #6
    //   292: invokevirtual a : ()V
    //   295: return
    //   296: astore #5
    //   298: aload #5
    //   300: invokevirtual printStackTrace : ()V
    //   303: aload_0
    //   304: invokevirtual b : ()V
    //   307: aload_0
    //   308: invokespecial f : ()V
    //   311: return
    //   312: astore #5
    //   314: aload #5
    //   316: invokevirtual printStackTrace : ()V
    //   319: aload_0
    //   320: invokevirtual b : ()V
    //   323: aload_0
    //   324: invokespecial f : ()V
    //   327: return
    //   328: goto -> 7
    // Exception table:
    //   from	to	target	type
    //   19	37	44	java/lang/IllegalArgumentException
    //   112	132	312	java/io/FileNotFoundException
    //   161	166	296	java/lang/IllegalStateException
    //   212	221	224	java/io/IOException
    //   246	260	263	java/io/IOException
    //   270	280	283	java/lang/IllegalStateException
  }
  
  private void f() {
    Handler handler = this.b;
    if (handler != null && this.a != null)
      handler.post(new Runnable(this) {
            public void run() {
              BluedMp3Recorder.b(this.a).a();
            }
          }); 
  }
  
  public void a() {
    if (this.c)
      return; 
    this.c = true;
    (new Thread(this) {
        public void run() {
          BluedMp3Recorder.a(this.a);
        }
      }).start();
  }
  
  public void b() {
    this.c = false;
  }
  
  public boolean c() {
    return this.c;
  }
  
  public int d() {
    return this.c ? this.e : 0;
  }
  
  public static interface ErrorListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\third_library\BluedMp3Recorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */