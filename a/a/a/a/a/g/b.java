package a.a.a.a.a.g;

import a.a.a.a.a.e.e;
import a.a.a.a.a.f.c;
import android.content.Context;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import android.os.Build;
import com.qiniu.pili.droid.streaming.MicrophoneStreamingSetting;
import java.nio.ByteBuffer;

public final class b implements Runnable {
  public volatile c a = c.a;
  
  public volatile a.a.a.a.a.f.a b = a.a.a.a.a.f.a.a;
  
  public long c = 0L;
  
  public long d = 0L;
  
  public long e = 0L;
  
  public int f = 0;
  
  public boolean g;
  
  public byte[] h;
  
  public boolean i = true;
  
  public MicrophoneStreamingSetting j;
  
  public a k;
  
  public c l = new c();
  
  public AudioRecord m;
  
  public ByteBuffer n;
  
  public AcousticEchoCanceler o;
  
  public Context p;
  
  public int q;
  
  public b(MicrophoneStreamingSetting paramMicrophoneStreamingSetting, a parama) {
    this.k = parama;
    this.j = paramMicrophoneStreamingSetting;
  }
  
  public int a() {
    return 2;
  }
  
  public final long a(long paramLong1, long paramLong2) {
    if (!this.j.b())
      return paramLong1; 
    long l2 = paramLong2 * 1000000L / this.j.getReqSampleRate();
    paramLong1 -= l2;
    if (this.e == 0L) {
      this.d = paramLong1;
      this.e = 0L;
    } 
    long l1 = this.d + this.e * 1000000L / this.j.getReqSampleRate();
    if (paramLong1 - l1 >= l2 * 2L) {
      this.d = paramLong1;
      this.e = 0L;
    } else {
      paramLong1 = l1;
    } 
    this.e += paramLong2;
    return paramLong1;
  }
  
  public void a(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : La/a/a/a/a/f/c;
    //   6: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   9: if_acmpne -> 25
    //   12: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   15: ldc 'AudioManager'
    //   17: ldc 'startRecording failed as already being running'
    //   19: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield a : La/a/a/a/a/f/c;
    //   29: getstatic a/a/a/a/a/f/c.d : La/a/a/a/a/f/c;
    //   32: if_acmpne -> 60
    //   35: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   38: ldc 'AudioManager'
    //   40: ldc 'set pending action as START'
    //   42: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: aload_1
    //   47: putfield p : Landroid/content/Context;
    //   50: aload_0
    //   51: getstatic a/a/a/a/a/f/a.b : La/a/a/a/a/f/a;
    //   54: putfield b : La/a/a/a/a/f/a;
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: aload_0
    //   61: getfield a : La/a/a/a/a/f/c;
    //   64: getstatic a/a/a/a/a/f/c.b : La/a/a/a/a/f/c;
    //   67: if_acmpne -> 83
    //   70: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   73: ldc 'AudioManager'
    //   75: ldc 'startRecording failed as it is starting'
    //   77: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   86: ldc 'AudioManager'
    //   88: ldc 'startRecording +'
    //   90: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_0
    //   94: getstatic a/a/a/a/a/f/c.b : La/a/a/a/a/f/c;
    //   97: putfield a : La/a/a/a/a/f/c;
    //   100: aload_0
    //   101: lconst_0
    //   102: putfield c : J
    //   105: aload_0
    //   106: lconst_0
    //   107: putfield e : J
    //   110: aload_0
    //   111: lconst_0
    //   112: putfield d : J
    //   115: iconst_1
    //   116: istore_2
    //   117: aload_0
    //   118: iconst_1
    //   119: putfield i : Z
    //   122: aload_0
    //   123: getfield j : Lcom/qiniu/pili/droid/streaming/MicrophoneStreamingSetting;
    //   126: invokevirtual getChannelConfig : ()I
    //   129: bipush #12
    //   131: if_icmpne -> 136
    //   134: iconst_2
    //   135: istore_2
    //   136: aload_0
    //   137: iload_2
    //   138: putfield q : I
    //   141: aload_0
    //   142: invokevirtual e : ()Z
    //   145: ifeq -> 166
    //   148: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   151: ldc 'AudioManager'
    //   153: ldc 'SCO enabled. register'
    //   155: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload_0
    //   159: getfield l : La/a/a/a/a/g/c;
    //   162: aload_1
    //   163: invokevirtual a : (Landroid/content/Context;)V
    //   166: new java/lang/Thread
    //   169: dup
    //   170: aload_0
    //   171: ldc 'AudioManager'
    //   173: invokespecial <init> : (Ljava/lang/Runnable;Ljava/lang/String;)V
    //   176: astore_1
    //   177: aload_1
    //   178: bipush #10
    //   180: invokevirtual setPriority : (I)V
    //   183: aload_1
    //   184: invokevirtual start : ()V
    //   187: aload_0
    //   188: monitorexit
    //   189: return
    //   190: astore_1
    //   191: aload_0
    //   192: monitorexit
    //   193: aload_1
    //   194: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	190	finally
    //   25	57	190	finally
    //   60	80	190	finally
    //   83	115	190	finally
    //   117	122	190	finally
    //   122	134	190	finally
    //   136	166	190	finally
    //   166	187	190	finally
  }
  
  public void a(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public final void b() {
    if (this.b == a.a.a.a.a.f.a.b) {
      a(this.p);
    } else if (this.b == a.a.a.a.a.f.a.c) {
      b(this.p);
    } 
    this.b = a.a.a.a.a.f.a.a;
  }
  
  public void b(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : La/a/a/a/a/f/c;
    //   6: getstatic a/a/a/a/a/f/c.a : La/a/a/a/a/f/c;
    //   9: if_acmpne -> 25
    //   12: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   15: ldc 'AudioManager'
    //   17: ldc 'stopRecording failed as not being running'
    //   19: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield a : La/a/a/a/a/f/c;
    //   29: getstatic a/a/a/a/a/f/c.b : La/a/a/a/a/f/c;
    //   32: if_acmpne -> 60
    //   35: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   38: ldc 'AudioManager'
    //   40: ldc 'set pending action as STOP'
    //   42: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: aload_1
    //   47: putfield p : Landroid/content/Context;
    //   50: aload_0
    //   51: getstatic a/a/a/a/a/f/a.c : La/a/a/a/a/f/a;
    //   54: putfield b : La/a/a/a/a/f/a;
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: aload_0
    //   61: getfield a : La/a/a/a/a/f/c;
    //   64: getstatic a/a/a/a/a/f/c.d : La/a/a/a/a/f/c;
    //   67: if_acmpne -> 83
    //   70: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   73: ldc 'AudioManager'
    //   75: ldc 'stopRecording failed as it is stopping'
    //   77: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   86: ldc 'AudioManager'
    //   88: ldc 'stopRecording +'
    //   90: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_0
    //   94: getstatic a/a/a/a/a/f/c.d : La/a/a/a/a/f/c;
    //   97: putfield a : La/a/a/a/a/f/c;
    //   100: aload_0
    //   101: invokevirtual e : ()Z
    //   104: ifeq -> 125
    //   107: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   110: ldc 'AudioManager'
    //   112: ldc 'SCO enabled. unregister'
    //   114: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload_0
    //   118: getfield l : La/a/a/a/a/g/c;
    //   121: aload_1
    //   122: invokevirtual b : (Landroid/content/Context;)V
    //   125: aload_0
    //   126: monitorexit
    //   127: return
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	128	finally
    //   25	57	128	finally
    //   60	80	128	finally
    //   83	125	128	finally
  }
  
  public final void b(boolean paramBoolean) {
    ByteBuffer byteBuffer = this.n;
    if (byteBuffer == null) {
      e.g.e("AudioManager", "AudioRecord read buffer is null !!!");
      return;
    } 
    if (this.k == null) {
      e.g.e("AudioManager", "callback listener is null !!!");
      return;
    } 
    byteBuffer.clear();
    int i = this.m.read(this.n, this.q * 2048);
    if (this.i) {
      boolean bool;
      this.i = false;
      a a1 = this.k;
      if (i < 0) {
        bool = true;
      } else {
        bool = false;
      } 
      a1.c(bool);
    } 
    if (i < 0) {
      this.a = c.a;
      this.k.b(i);
      return;
    } 
    if (i > 0) {
      if (this.g) {
        byte[] arrayOfByte = this.h;
        if (arrayOfByte == null || arrayOfByte.length < i) {
          e e = e.g;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("mute on, new temp zero byte array: ");
          stringBuilder.append(i);
          e.c("AudioManager", stringBuilder.toString());
          this.h = new byte[i];
        } 
        this.n.put(this.h, 0, i);
        this.n.clear();
      } else if (this.h != null) {
        e.g.c("AudioManager", "mute off");
        this.h = null;
      } 
      long l = System.nanoTime() / 1000L;
      this.c = l;
      l = a(l, (i / this.q / 2));
      this.c = l;
      this.k.a(this.n, i, l, paramBoolean);
      return;
    } 
    e.g.d("AudioManager", "AudioRecord read audioDataLength: 0");
  }
  
  public final void c() {
    this.f = AudioRecord.getMinBufferSize(this.j.getReqSampleRate(), this.j.getChannelConfig(), 2);
    this.m = new AudioRecord(this.j.getAudioSource(), this.j.getReqSampleRate(), this.j.getChannelConfig(), 2, this.f * 4);
    if (f() && Build.VERSION.SDK_INT >= 16) {
      AcousticEchoCanceler acousticEchoCanceler = AcousticEchoCanceler.create(this.m.getAudioSessionId());
      this.o = acousticEchoCanceler;
      if (acousticEchoCanceler != null) {
        e.g.c("AudioManager", "set echo canceler enabled");
        this.o.setEnabled(true);
      } 
    } 
  }
  
  public final void d() {
    AudioRecord audioRecord = this.m;
    if (audioRecord != null && audioRecord.getState() != 0) {
      if (this.m.getRecordingState() != 1)
        try {
          this.m.stop();
        } catch (IllegalStateException illegalStateException) {
          e e = e.g;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("e.msg:");
          stringBuilder.append(illegalStateException.getMessage());
          e.d("AudioManager", stringBuilder.toString());
        }  
      e.g.c("AudioManager", "releaseAudioRecord");
      this.m.release();
    } 
    if (this.o != null) {
      e.g.c("AudioManager", "set echo canceler disabled");
      this.o.setEnabled(false);
      this.o.release();
    } 
  }
  
  public final boolean e() {
    MicrophoneStreamingSetting microphoneStreamingSetting = this.j;
    return (microphoneStreamingSetting != null && microphoneStreamingSetting.isBluetoothSCOEnabled());
  }
  
  public final boolean f() {
    MicrophoneStreamingSetting microphoneStreamingSetting = this.j;
    return (microphoneStreamingSetting != null && microphoneStreamingSetting.a());
  }
  
  public void run() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual c : ()V
    //   4: aload_0
    //   5: getfield m : Landroid/media/AudioRecord;
    //   8: invokevirtual startRecording : ()V
    //   11: aload_0
    //   12: aload_0
    //   13: getfield f : I
    //   16: iconst_4
    //   17: imul
    //   18: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   21: putfield n : Ljava/nio/ByteBuffer;
    //   24: aload_0
    //   25: monitorenter
    //   26: aload_0
    //   27: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   30: putfield a : La/a/a/a/a/f/c;
    //   33: aload_0
    //   34: invokevirtual b : ()V
    //   37: aload_0
    //   38: monitorexit
    //   39: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   42: ldc 'AudioManager'
    //   44: ldc_w 'startRecording -'
    //   47: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield a : La/a/a/a/a/f/c;
    //   54: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   57: if_acmpne -> 68
    //   60: aload_0
    //   61: iconst_0
    //   62: invokevirtual b : (Z)V
    //   65: goto -> 50
    //   68: aload_0
    //   69: iconst_1
    //   70: invokevirtual b : (Z)V
    //   73: aload_0
    //   74: invokevirtual d : ()V
    //   77: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   80: ldc 'AudioManager'
    //   82: ldc_w 'stopRecording -'
    //   85: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_0
    //   89: monitorenter
    //   90: aload_0
    //   91: getstatic a/a/a/a/a/f/c.a : La/a/a/a/a/f/c;
    //   94: putfield a : La/a/a/a/a/f/c;
    //   97: aload_0
    //   98: invokevirtual b : ()V
    //   101: aload_0
    //   102: monitorexit
    //   103: return
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: astore_1
    //   115: goto -> 208
    //   118: astore_1
    //   119: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   122: astore_2
    //   123: new java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial <init> : ()V
    //   130: astore_3
    //   131: aload_3
    //   132: ldc_w 'startRecording error. e.msg:'
    //   135: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_3
    //   140: aload_1
    //   141: invokevirtual getMessage : ()Ljava/lang/String;
    //   144: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_2
    //   149: ldc 'AudioManager'
    //   151: aload_3
    //   152: invokevirtual toString : ()Ljava/lang/String;
    //   155: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload_0
    //   159: getfield k : La/a/a/a/a/g/b$a;
    //   162: ifnull -> 176
    //   165: aload_0
    //   166: getfield k : La/a/a/a/a/g/b$a;
    //   169: bipush #-100
    //   171: invokeinterface b : (I)V
    //   176: aload_0
    //   177: monitorenter
    //   178: aload_0
    //   179: getstatic a/a/a/a/a/f/c.a : La/a/a/a/a/f/c;
    //   182: putfield a : La/a/a/a/a/f/c;
    //   185: aload_0
    //   186: invokevirtual b : ()V
    //   189: aload_0
    //   190: monitorexit
    //   191: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   194: ldc 'AudioManager'
    //   196: ldc_w 'startRecording -'
    //   199: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   202: return
    //   203: astore_1
    //   204: aload_0
    //   205: monitorexit
    //   206: aload_1
    //   207: athrow
    //   208: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   211: ldc 'AudioManager'
    //   213: ldc_w 'startRecording -'
    //   216: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_1
    //   220: athrow
    // Exception table:
    //   from	to	target	type
    //   0	26	118	java/lang/Exception
    //   0	26	114	finally
    //   26	39	109	finally
    //   90	103	104	finally
    //   105	107	104	finally
    //   110	112	109	finally
    //   112	114	118	java/lang/Exception
    //   112	114	114	finally
    //   119	123	114	finally
    //   123	176	114	finally
    //   176	178	114	finally
    //   178	191	203	finally
    //   204	206	203	finally
    //   206	208	114	finally
  }
  
  public static interface a {
    void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long, boolean param1Boolean);
    
    void b(int param1Int);
    
    void c(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */