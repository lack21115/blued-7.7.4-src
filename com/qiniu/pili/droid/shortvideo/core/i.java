package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.f.b;
import com.qiniu.pili.droid.shortvideo.f.c;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.muxer.b;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Stack;

public class i {
  private b a;
  
  private Context b;
  
  private Stack<h> c;
  
  private h d;
  
  private File e;
  
  private MediaFormat f;
  
  private MediaFormat g;
  
  private volatile boolean h;
  
  private PLRecordSetting i;
  
  private PLVideoEncodeSetting j;
  
  private PLAudioEncodeSetting k;
  
  private long l;
  
  private long m;
  
  private int n;
  
  private int o;
  
  private long p;
  
  private long q;
  
  private a r;
  
  private PLVideoSaveListener s;
  
  private volatile boolean t;
  
  private String u;
  
  private double v;
  
  private long w;
  
  public i(Context paramContext, PLRecordSetting paramPLRecordSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting) {
    File file1;
    this.c = new Stack<h>();
    this.h = false;
    this.l = 0L;
    this.m = 0L;
    this.p = -1L;
    this.q = -1L;
    this.u = null;
    this.v = 1.0D;
    this.b = paramContext.getApplicationContext();
    this.i = paramPLRecordSetting;
    this.k = paramPLAudioEncodeSetting;
    this.e = this.i.getVideoCacheDir();
    File file2 = this.e;
    if (file2 == null || (!file2.exists() && !this.e.mkdirs()))
      this.e = paramContext.getFilesDir(); 
    if (this.i.getVideoFilepath() == null) {
      file1 = this.e;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("pl-concated-");
      stringBuilder.append(System.currentTimeMillis());
      stringBuilder.append(".mp4");
      file1 = new File(file1, stringBuilder.toString());
      this.i.setVideoFilepath(file1.getAbsolutePath());
      return;
    } 
    PLRecordSetting pLRecordSetting = this.i;
    pLRecordSetting.setVideoFilepath(l.a((Context)file1, pLRecordSetting.getVideoFilepath()));
  }
  
  public i(Context paramContext, PLRecordSetting paramPLRecordSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting, PLVideoEncodeSetting paramPLVideoEncodeSetting) {
    this(paramContext, paramPLRecordSetting, paramPLAudioEncodeSetting);
    this.j = paramPLVideoEncodeSetting;
  }
  
  private MediaFormat a(MediaExtractor paramMediaExtractor, String paramString) {
    int k = paramMediaExtractor.getTrackCount();
    for (int j = 0; j < k; j++) {
      MediaFormat mediaFormat = paramMediaExtractor.getTrackFormat(j);
      if (mediaFormat.getString("mime").startsWith(paramString))
        return mediaFormat; 
    } 
    return null;
  }
  
  private boolean a(h paramh) {
    MediaExtractor mediaExtractor = new MediaExtractor();
    try {
      mediaExtractor.setDataSource(paramh.a.getAbsolutePath());
      MediaFormat mediaFormat1 = a(mediaExtractor, "audio/");
      MediaFormat mediaFormat2 = a(mediaExtractor, "video/");
      if (mediaFormat1 == null) {
        e.d.e("SectionManager", "Cannot get media format on recoverFromDraft");
        return false;
      } 
      b(mediaFormat1);
      if (h() && mediaFormat2 == null) {
        e.d.e("SectionManager", "Cannot get media format on recoverFromDraft");
        return false;
      } 
      a(mediaFormat2);
      return true;
    } catch (IOException iOException) {
      e.d.e("SectionManager", "Invalid data source");
      return false;
    } 
  }
  
  private void b(long paramLong) {
    if (this.p == -1L)
      this.p = paramLong; 
    if (paramLong > this.q)
      this.q = paramLong; 
  }
  
  private long g() {
    int j;
    int k;
    if (h()) {
      j = 1000;
      k = this.j.getVideoEncodingFps();
    } else {
      j = 1024000;
      k = this.k.getSamplerate();
    } 
    return (j / k);
  }
  
  private boolean h() {
    return (this.j != null);
  }
  
  private int i() {
    return h() ? this.j.getRotationInMetadata() : 0;
  }
  
  public void a(double paramDouble) {
    this.v = paramDouble;
  }
  
  public void a(long paramLong) {
    this.w = paramLong;
  }
  
  public void a(MediaFormat paramMediaFormat) {
    this.g = paramMediaFormat;
  }
  
  public void a(PLVideoSaveListener paramPLVideoSaveListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield t : Z
    //   7: aload_0
    //   8: aload_1
    //   9: putfield s : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   12: new java/lang/Thread
    //   15: dup
    //   16: new com/qiniu/pili/droid/shortvideo/core/i$1
    //   19: dup
    //   20: aload_0
    //   21: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/core/i;)V
    //   24: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   27: invokevirtual start : ()V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	33	finally
  }
  
  public void a(a parama) {
    this.r = parama;
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Z
    //   6: ifeq -> 107
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: astore_3
    //   13: new java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: astore #4
    //   22: aload #4
    //   24: ldc_w 'video write to muxer size:'
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload #4
    //   33: aload_2
    //   34: getfield size : I
    //   37: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload #4
    //   43: ldc_w ' ts:'
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload #4
    //   52: aload_2
    //   53: getfield presentationTimeUs : J
    //   56: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_3
    //   61: ldc 'SectionManager'
    //   63: aload #4
    //   65: invokevirtual toString : ()Ljava/lang/String;
    //   68: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: aload_2
    //   73: getfield presentationTimeUs : J
    //   76: ldc2_w 1000
    //   79: ldiv
    //   80: invokespecial b : (J)V
    //   83: aload_0
    //   84: getfield a : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   87: aload_1
    //   88: aload_2
    //   89: invokevirtual a : (Ljava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   92: aload_0
    //   93: getfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   96: astore_1
    //   97: aload_1
    //   98: aload_1
    //   99: getfield g : I
    //   102: iconst_1
    //   103: iadd
    //   104: putfield g : I
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Exception table:
    //   from	to	target	type
    //   2	107	110	finally
  }
  
  public boolean a() {
    return (this.f != null && (this.g != null || !h()));
  }
  
  public boolean a(b paramb) {
    this.u = paramb.a();
    this.c = paramb.b();
    null = this.c.iterator();
    while (null.hasNext()) {
      if (!((h)null.next()).a.exists()) {
        this.c.clear();
        return false;
      } 
    } 
    this.d = this.c.lastElement();
    if (!a(this.d)) {
      this.c.clear();
      this.d = null;
      return false;
    } 
    for (h h1 : this.c)
      this.m += h1.e; 
    this.i = paramb.h();
    this.j = paramb.e();
    return true;
  }
  
  public boolean a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Z
    //   6: ifeq -> 24
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'SectionManager'
    //   14: ldc_w 'begin section failed, in working state'
    //   17: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iconst_0
    //   23: ireturn
    //   24: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   27: ldc 'SectionManager'
    //   29: ldc_w 'begin section +'
    //   32: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: invokevirtual a : ()Z
    //   39: ifne -> 57
    //   42: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   45: ldc 'SectionManager'
    //   47: ldc_w 'beginSection failed, format not set !'
    //   50: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_0
    //   54: monitorexit
    //   55: iconst_0
    //   56: ireturn
    //   57: invokestatic currentTimeMillis : ()J
    //   60: lstore_2
    //   61: aload_0
    //   62: getfield e : Ljava/io/File;
    //   65: astore #4
    //   67: aload_1
    //   68: ifnull -> 74
    //   71: goto -> 108
    //   74: new java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial <init> : ()V
    //   81: astore_1
    //   82: aload_1
    //   83: ldc_w 'pl-section-'
    //   86: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: lload_2
    //   92: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_1
    //   97: ldc '.mp4'
    //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_1
    //   104: invokevirtual toString : ()Ljava/lang/String;
    //   107: astore_1
    //   108: new java/io/File
    //   111: dup
    //   112: aload #4
    //   114: aload_1
    //   115: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   118: astore_1
    //   119: aload_0
    //   120: new com/qiniu/pili/droid/shortvideo/muxer/b
    //   123: dup
    //   124: invokespecial <init> : ()V
    //   127: putfield a : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   130: aload_0
    //   131: getfield a : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   134: aload_1
    //   135: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   138: aload_0
    //   139: getfield g : Landroid/media/MediaFormat;
    //   142: aload_0
    //   143: getfield f : Landroid/media/MediaFormat;
    //   146: aload_0
    //   147: invokespecial i : ()I
    //   150: invokevirtual a : (Ljava/lang/String;Landroid/media/MediaFormat;Landroid/media/MediaFormat;I)Z
    //   153: ifne -> 171
    //   156: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   159: ldc 'SectionManager'
    //   161: ldc_w 'beginSection failed, start failed !'
    //   164: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload_0
    //   168: monitorexit
    //   169: iconst_0
    //   170: ireturn
    //   171: aload_0
    //   172: new com/qiniu/pili/droid/shortvideo/core/h
    //   175: dup
    //   176: invokespecial <init> : ()V
    //   179: putfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   182: aload_0
    //   183: getfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   186: aload_1
    //   187: putfield a : Ljava/io/File;
    //   190: aload_0
    //   191: getfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   194: aload_0
    //   195: getfield a : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   198: invokevirtual b : ()I
    //   201: putfield c : I
    //   204: aload_0
    //   205: getfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   208: aload_0
    //   209: getfield a : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   212: invokevirtual c : ()I
    //   215: putfield b : I
    //   218: aload_0
    //   219: iconst_1
    //   220: putfield h : Z
    //   223: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   226: astore #4
    //   228: new java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial <init> : ()V
    //   235: astore #5
    //   237: aload #5
    //   239: ldc_w 'begin section - '
    //   242: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload #5
    //   248: aload_1
    //   249: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload #4
    //   255: ldc 'SectionManager'
    //   257: aload #5
    //   259: invokevirtual toString : ()Ljava/lang/String;
    //   262: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload_0
    //   266: monitorexit
    //   267: iconst_1
    //   268: ireturn
    //   269: astore_1
    //   270: aload_0
    //   271: monitorexit
    //   272: aload_1
    //   273: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	269	finally
    //   24	53	269	finally
    //   57	67	269	finally
    //   74	108	269	finally
    //   108	167	269	finally
    //   171	265	269	finally
  }
  
  public boolean a(String paramString, PLCameraSetting paramPLCameraSetting, PLMicrophoneSetting paramPLMicrophoneSetting, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting, PLFaceBeautySetting paramPLFaceBeautySetting, PLRecordSetting paramPLRecordSetting) {
    if (this.c.size() == 0)
      return false; 
    if (paramString != null) {
      if (paramString.isEmpty())
        return false; 
      this.u = paramString;
      b b1 = new b(paramString);
      b1.a(paramString);
      b1.a(this.c);
      b1.a(paramPLCameraSetting);
      b1.a(paramPLMicrophoneSetting);
      b1.a(paramPLVideoEncodeSetting);
      b1.a(paramPLAudioEncodeSetting);
      b1.a(paramPLFaceBeautySetting);
      b1.a(paramPLRecordSetting);
      return c.a(this.b).a(b1);
    } 
    return false;
  }
  
  public boolean a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Z
    //   6: ifeq -> 24
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'SectionManager'
    //   14: ldc_w 'mIsWorking, cannot delete !!!'
    //   17: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_0
    //   25: getfield u : Ljava/lang/String;
    //   28: ifnonnull -> 42
    //   31: new java/util/Stack
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: astore_2
    //   39: goto -> 60
    //   42: aload_0
    //   43: getfield b : Landroid/content/Context;
    //   46: invokestatic a : (Landroid/content/Context;)Lcom/qiniu/pili/droid/shortvideo/f/c;
    //   49: aload_0
    //   50: getfield u : Ljava/lang/String;
    //   53: invokevirtual a : (Ljava/lang/String;)Lcom/qiniu/pili/droid/shortvideo/f/b;
    //   56: invokevirtual b : ()Ljava/util/Stack;
    //   59: astore_2
    //   60: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   63: ldc 'SectionManager'
    //   65: ldc_w 'clear sections +'
    //   68: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: getfield c : Ljava/util/Stack;
    //   75: invokevirtual iterator : ()Ljava/util/Iterator;
    //   78: astore_3
    //   79: aload_3
    //   80: invokeinterface hasNext : ()Z
    //   85: ifeq -> 220
    //   88: aload_3
    //   89: invokeinterface next : ()Ljava/lang/Object;
    //   94: checkcast com/qiniu/pili/droid/shortvideo/core/h
    //   97: astore #4
    //   99: aload_2
    //   100: aload #4
    //   102: invokevirtual contains : (Ljava/lang/Object;)Z
    //   105: ifeq -> 111
    //   108: goto -> 79
    //   111: aload #4
    //   113: getfield a : Ljava/io/File;
    //   116: invokevirtual delete : ()Z
    //   119: ifeq -> 171
    //   122: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   125: astore #5
    //   127: new java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial <init> : ()V
    //   134: astore #6
    //   136: aload #6
    //   138: ldc_w 'deleted section:'
    //   141: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload #6
    //   147: aload #4
    //   149: getfield a : Ljava/io/File;
    //   152: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload #5
    //   158: ldc 'SectionManager'
    //   160: aload #6
    //   162: invokevirtual toString : ()Ljava/lang/String;
    //   165: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   168: goto -> 79
    //   171: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   174: astore #5
    //   176: new java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial <init> : ()V
    //   183: astore #6
    //   185: aload #6
    //   187: ldc_w 'deleted section failed:'
    //   190: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload #6
    //   196: aload #4
    //   198: getfield a : Ljava/io/File;
    //   201: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload #5
    //   207: ldc 'SectionManager'
    //   209: aload #6
    //   211: invokevirtual toString : ()Ljava/lang/String;
    //   214: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   217: goto -> 79
    //   220: aload_0
    //   221: getfield c : Ljava/util/Stack;
    //   224: invokevirtual clear : ()V
    //   227: iload_1
    //   228: ifeq -> 253
    //   231: aload_0
    //   232: getfield r : Lcom/qiniu/pili/droid/shortvideo/core/i$a;
    //   235: ifnull -> 253
    //   238: aload_0
    //   239: getfield r : Lcom/qiniu/pili/droid/shortvideo/core/i$a;
    //   242: aload_0
    //   243: getfield l : J
    //   246: lconst_0
    //   247: iconst_0
    //   248: invokeinterface b : (JJI)V
    //   253: aload_0
    //   254: lconst_0
    //   255: putfield l : J
    //   258: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   261: ldc 'SectionManager'
    //   263: ldc_w 'clear sections -'
    //   266: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   269: aload_0
    //   270: monitorexit
    //   271: iconst_1
    //   272: ireturn
    //   273: astore_2
    //   274: aload_0
    //   275: monitorexit
    //   276: aload_2
    //   277: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	273	finally
    //   24	39	273	finally
    //   42	60	273	finally
    //   60	79	273	finally
    //   79	108	273	finally
    //   111	168	273	finally
    //   171	217	273	finally
    //   220	227	273	finally
    //   231	253	273	finally
    //   253	269	273	finally
  }
  
  public void b(MediaFormat paramMediaFormat) {
    this.f = paramMediaFormat;
  }
  
  public void b(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Z
    //   6: ifeq -> 107
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: astore_3
    //   13: new java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: astore #4
    //   22: aload #4
    //   24: ldc_w 'audio write to muxer size:'
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload #4
    //   33: aload_2
    //   34: getfield size : I
    //   37: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload #4
    //   43: ldc_w ' ts:'
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload #4
    //   52: aload_2
    //   53: getfield presentationTimeUs : J
    //   56: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_3
    //   61: ldc 'SectionManager'
    //   63: aload #4
    //   65: invokevirtual toString : ()Ljava/lang/String;
    //   68: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: aload_2
    //   73: getfield presentationTimeUs : J
    //   76: ldc2_w 1000
    //   79: ldiv
    //   80: invokespecial b : (J)V
    //   83: aload_0
    //   84: getfield a : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   87: aload_1
    //   88: aload_2
    //   89: invokevirtual b : (Ljava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   92: aload_0
    //   93: getfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   96: astore_1
    //   97: aload_1
    //   98: aload_1
    //   99: getfield f : I
    //   102: iconst_1
    //   103: iadd
    //   104: putfield f : I
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Exception table:
    //   from	to	target	type
    //   2	107	110	finally
  }
  
  public boolean b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Z
    //   6: ifeq -> 291
    //   9: aload_0
    //   10: getfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   13: ifnonnull -> 19
    //   16: goto -> 291
    //   19: aload_0
    //   20: getfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   23: getfield f : I
    //   26: ifle -> 316
    //   29: aload_0
    //   30: getfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   33: getfield g : I
    //   36: ifgt -> 311
    //   39: aload_0
    //   40: invokespecial h : ()Z
    //   43: ifne -> 316
    //   46: goto -> 311
    //   49: aload_0
    //   50: getfield a : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   53: invokevirtual a : ()Z
    //   56: ifeq -> 255
    //   59: iload_1
    //   60: ifeq -> 255
    //   63: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   66: ldc 'SectionManager'
    //   68: ldc_w 'end section +'
    //   71: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_0
    //   75: getfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   78: aload_0
    //   79: getfield p : J
    //   82: putfield d : J
    //   85: aload_0
    //   86: getfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   89: aload_0
    //   90: getfield q : J
    //   93: aload_0
    //   94: getfield p : J
    //   97: lsub
    //   98: aload_0
    //   99: invokespecial g : ()J
    //   102: ladd
    //   103: putfield e : J
    //   106: aload_0
    //   107: ldc2_w -1
    //   110: putfield p : J
    //   113: aload_0
    //   114: ldc2_w -1
    //   117: putfield q : J
    //   120: aload_0
    //   121: aload_0
    //   122: getfield l : J
    //   125: aload_0
    //   126: getfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   129: getfield e : J
    //   132: ladd
    //   133: putfield l : J
    //   136: aload_0
    //   137: getfield c : Ljava/util/Stack;
    //   140: aload_0
    //   141: getfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   144: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
    //   147: pop
    //   148: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   151: astore_2
    //   152: new java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial <init> : ()V
    //   159: astore_3
    //   160: aload_3
    //   161: ldc_w 'end section - '
    //   164: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_3
    //   169: aload_0
    //   170: getfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   173: getfield a : Ljava/io/File;
    //   176: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_3
    //   181: ldc_w ', '
    //   184: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_3
    //   189: aload_0
    //   190: getfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   193: getfield e : J
    //   196: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_3
    //   201: ldc_w 'Ms'
    //   204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_2
    //   209: ldc 'SectionManager'
    //   211: aload_3
    //   212: invokevirtual toString : ()Ljava/lang/String;
    //   215: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_0
    //   219: getfield r : Lcom/qiniu/pili/droid/shortvideo/core/i$a;
    //   222: ifnull -> 282
    //   225: aload_0
    //   226: getfield r : Lcom/qiniu/pili/droid/shortvideo/core/i$a;
    //   229: aload_0
    //   230: getfield d : Lcom/qiniu/pili/droid/shortvideo/core/h;
    //   233: getfield e : J
    //   236: aload_0
    //   237: getfield l : J
    //   240: aload_0
    //   241: getfield c : Ljava/util/Stack;
    //   244: invokevirtual size : ()I
    //   247: invokeinterface a : (JJI)V
    //   252: goto -> 282
    //   255: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   258: ldc 'SectionManager'
    //   260: ldc_w 'end section failed, so no data saved !!!'
    //   263: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload_0
    //   267: getfield r : Lcom/qiniu/pili/droid/shortvideo/core/i$a;
    //   270: ifnull -> 282
    //   273: aload_0
    //   274: getfield r : Lcom/qiniu/pili/droid/shortvideo/core/i$a;
    //   277: invokeinterface i : ()V
    //   282: aload_0
    //   283: iconst_0
    //   284: putfield h : Z
    //   287: aload_0
    //   288: monitorexit
    //   289: iconst_1
    //   290: ireturn
    //   291: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   294: ldc 'SectionManager'
    //   296: ldc_w 'end section failed, not in working state'
    //   299: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload_0
    //   303: monitorexit
    //   304: iconst_0
    //   305: ireturn
    //   306: astore_2
    //   307: aload_0
    //   308: monitorexit
    //   309: aload_2
    //   310: athrow
    //   311: iconst_1
    //   312: istore_1
    //   313: goto -> 49
    //   316: iconst_0
    //   317: istore_1
    //   318: goto -> 49
    // Exception table:
    //   from	to	target	type
    //   2	16	306	finally
    //   19	46	306	finally
    //   49	59	306	finally
    //   63	252	306	finally
    //   255	282	306	finally
    //   282	287	306	finally
    //   291	302	306	finally
  }
  
  public boolean c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Z
    //   6: ifeq -> 24
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'SectionManager'
    //   14: ldc_w 'mIsWorking, cannot delete !!!'
    //   17: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_0
    //   25: getfield c : Ljava/util/Stack;
    //   28: invokevirtual isEmpty : ()Z
    //   31: ifeq -> 49
    //   34: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   37: ldc 'SectionManager'
    //   39: ldc_w 'no sections, delete failed !'
    //   42: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: monitorexit
    //   47: iconst_0
    //   48: ireturn
    //   49: aload_0
    //   50: getfield c : Ljava/util/Stack;
    //   53: invokevirtual pop : ()Ljava/lang/Object;
    //   56: checkcast com/qiniu/pili/droid/shortvideo/core/h
    //   59: astore_1
    //   60: aload_1
    //   61: getfield a : Ljava/io/File;
    //   64: invokevirtual delete : ()Z
    //   67: ifeq -> 137
    //   70: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   73: astore_2
    //   74: new java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial <init> : ()V
    //   81: astore_3
    //   82: aload_3
    //   83: ldc_w 'deleted section: '
    //   86: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_3
    //   91: aload_1
    //   92: getfield a : Ljava/io/File;
    //   95: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_3
    //   100: ldc_w ', '
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_3
    //   108: aload_1
    //   109: getfield e : J
    //   112: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_3
    //   117: ldc_w 'Ms'
    //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_2
    //   125: ldc 'SectionManager'
    //   127: aload_3
    //   128: invokevirtual toString : ()Ljava/lang/String;
    //   131: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   134: goto -> 176
    //   137: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   140: astore_2
    //   141: new java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial <init> : ()V
    //   148: astore_3
    //   149: aload_3
    //   150: ldc_w 'deleted section failed:'
    //   153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_3
    //   158: aload_1
    //   159: getfield a : Ljava/io/File;
    //   162: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_2
    //   167: ldc 'SectionManager'
    //   169: aload_3
    //   170: invokevirtual toString : ()Ljava/lang/String;
    //   173: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload_0
    //   177: aload_0
    //   178: getfield l : J
    //   181: aload_1
    //   182: getfield e : J
    //   185: lsub
    //   186: putfield l : J
    //   189: aload_0
    //   190: getfield r : Lcom/qiniu/pili/droid/shortvideo/core/i$a;
    //   193: ifnull -> 220
    //   196: aload_0
    //   197: getfield r : Lcom/qiniu/pili/droid/shortvideo/core/i$a;
    //   200: aload_1
    //   201: getfield e : J
    //   204: aload_0
    //   205: getfield l : J
    //   208: aload_0
    //   209: getfield c : Ljava/util/Stack;
    //   212: invokevirtual size : ()I
    //   215: invokeinterface b : (JJI)V
    //   220: aload_0
    //   221: monitorexit
    //   222: iconst_1
    //   223: ireturn
    //   224: astore_1
    //   225: aload_0
    //   226: monitorexit
    //   227: aload_1
    //   228: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	224	finally
    //   24	45	224	finally
    //   49	134	224	finally
    //   137	176	224	finally
    //   176	220	224	finally
  }
  
  public long d() {
    return this.q - this.p + g();
  }
  
  public void e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield t : Z
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
  
  public void f() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/Stack;
    //   6: invokevirtual isEmpty : ()Z
    //   9: ifeq -> 50
    //   12: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   15: ldc 'SectionManager'
    //   17: ldc_w 'no section exist to concat'
    //   20: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   27: ifnull -> 47
    //   30: aload_0
    //   31: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   34: iconst_2
    //   35: invokeinterface onSaveVideoFailed : (I)V
    //   40: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/core/QosManager;
    //   43: iconst_2
    //   44: invokevirtual a : (I)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield i : Lcom/qiniu/pili/droid/shortvideo/PLRecordSetting;
    //   54: invokevirtual getVideoFilepath : ()Ljava/lang/String;
    //   57: astore #11
    //   59: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   62: astore #10
    //   64: new java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: astore #12
    //   73: aload #12
    //   75: ldc_w 'concat sections + to: '
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload #12
    //   84: aload #11
    //   86: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload #10
    //   92: ldc 'SectionManager'
    //   94: aload #12
    //   96: invokevirtual toString : ()Ljava/lang/String;
    //   99: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   102: new com/qiniu/pili/droid/shortvideo/muxer/b
    //   105: dup
    //   106: invokespecial <init> : ()V
    //   109: astore #12
    //   111: aload #12
    //   113: aload #11
    //   115: aload_0
    //   116: getfield g : Landroid/media/MediaFormat;
    //   119: aload_0
    //   120: getfield f : Landroid/media/MediaFormat;
    //   123: aload_0
    //   124: invokespecial i : ()I
    //   127: invokevirtual a : (Ljava/lang/String;Landroid/media/MediaFormat;Landroid/media/MediaFormat;I)Z
    //   130: pop
    //   131: ldc_w 2097152
    //   134: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   137: astore #13
    //   139: aload_0
    //   140: iconst_0
    //   141: putfield n : I
    //   144: aload_0
    //   145: iconst_0
    //   146: putfield o : I
    //   149: lconst_0
    //   150: lstore #4
    //   152: iconst_0
    //   153: istore_1
    //   154: iload_1
    //   155: aload_0
    //   156: getfield c : Ljava/util/Stack;
    //   159: invokevirtual size : ()I
    //   162: if_icmpge -> 889
    //   165: aload_0
    //   166: getfield c : Ljava/util/Stack;
    //   169: iload_1
    //   170: invokevirtual get : (I)Ljava/lang/Object;
    //   173: checkcast com/qiniu/pili/droid/shortvideo/core/h
    //   176: astore #14
    //   178: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   181: astore #10
    //   183: new java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial <init> : ()V
    //   190: astore #15
    //   192: aload #15
    //   194: ldc_w 'concating section:'
    //   197: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload #15
    //   203: aload #14
    //   205: getfield a : Ljava/io/File;
    //   208: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload #10
    //   214: ldc 'SectionManager'
    //   216: aload #15
    //   218: invokevirtual toString : ()Ljava/lang/String;
    //   221: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   224: new android/media/MediaExtractor
    //   227: dup
    //   228: invokespecial <init> : ()V
    //   231: astore #15
    //   233: aload #15
    //   235: aload #14
    //   237: getfield a : Ljava/io/File;
    //   240: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   243: invokevirtual setDataSource : (Ljava/lang/String;)V
    //   246: iconst_0
    //   247: istore_2
    //   248: iload_2
    //   249: aload #15
    //   251: invokevirtual getTrackCount : ()I
    //   254: if_icmpge -> 355
    //   257: aload #15
    //   259: iload_2
    //   260: invokevirtual getTrackFormat : (I)Landroid/media/MediaFormat;
    //   263: ldc 'mime'
    //   265: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   268: astore #10
    //   270: aload #10
    //   272: ldc_w 'video'
    //   275: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   278: ifeq -> 290
    //   281: aload #14
    //   283: iload_2
    //   284: putfield c : I
    //   287: goto -> 1033
    //   290: aload #10
    //   292: ldc_w 'audio'
    //   295: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   298: ifeq -> 310
    //   301: aload #14
    //   303: iload_2
    //   304: putfield b : I
    //   307: goto -> 1033
    //   310: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   313: astore #10
    //   315: new java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial <init> : ()V
    //   322: astore #16
    //   324: aload #16
    //   326: ldc_w 'Unknown mimeType in section '
    //   329: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload #16
    //   335: iload_1
    //   336: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload #10
    //   342: ldc 'SectionManager'
    //   344: aload #16
    //   346: invokevirtual toString : ()Ljava/lang/String;
    //   349: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   352: goto -> 1033
    //   355: aload #15
    //   357: aload #14
    //   359: getfield b : I
    //   362: invokevirtual selectTrack : (I)V
    //   365: aload #14
    //   367: getfield c : I
    //   370: iflt -> 1040
    //   373: aload #15
    //   375: aload #14
    //   377: getfield c : I
    //   380: invokevirtual selectTrack : (I)V
    //   383: goto -> 1040
    //   386: aload_0
    //   387: getfield t : Z
    //   390: ifeq -> 447
    //   393: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   396: ldc 'SectionManager'
    //   398: ldc_w 'concat canceled'
    //   401: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   404: aload #15
    //   406: invokevirtual release : ()V
    //   409: aload #12
    //   411: invokevirtual a : ()Z
    //   414: pop
    //   415: new java/io/File
    //   418: dup
    //   419: aload #11
    //   421: invokespecial <init> : (Ljava/lang/String;)V
    //   424: invokevirtual delete : ()Z
    //   427: pop
    //   428: aload_0
    //   429: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   432: ifnull -> 444
    //   435: aload_0
    //   436: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   439: invokeinterface onSaveVideoCanceled : ()V
    //   444: aload_0
    //   445: monitorexit
    //   446: return
    //   447: aload #15
    //   449: aload #13
    //   451: iconst_0
    //   452: invokevirtual readSampleData : (Ljava/nio/ByteBuffer;I)I
    //   455: istore_2
    //   456: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   459: astore #10
    //   461: new java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial <init> : ()V
    //   468: astore #16
    //   470: aload #16
    //   472: ldc_w 'read sample size:'
    //   475: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload #16
    //   481: iload_2
    //   482: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload #10
    //   488: ldc 'SectionManager'
    //   490: aload #16
    //   492: invokevirtual toString : ()Ljava/lang/String;
    //   495: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   498: iload_2
    //   499: ifge -> 516
    //   502: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   505: ldc 'SectionManager'
    //   507: ldc_w 'EOF, no more encoded samples.'
    //   510: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   513: goto -> 607
    //   516: new android/media/MediaCodec$BufferInfo
    //   519: dup
    //   520: invokespecial <init> : ()V
    //   523: astore #10
    //   525: aload #10
    //   527: aload #15
    //   529: invokevirtual getSampleTime : ()J
    //   532: lload #6
    //   534: ladd
    //   535: putfield presentationTimeUs : J
    //   538: aload #10
    //   540: aload #15
    //   542: invokevirtual getSampleFlags : ()I
    //   545: putfield flags : I
    //   548: aload #10
    //   550: iconst_0
    //   551: putfield offset : I
    //   554: aload #10
    //   556: iload_2
    //   557: putfield size : I
    //   560: getstatic android/os/Build$VERSION.SDK_INT : I
    //   563: bipush #21
    //   565: if_icmplt -> 575
    //   568: aload #13
    //   570: iconst_0
    //   571: invokevirtual position : (I)Ljava/nio/Buffer;
    //   574: pop
    //   575: aload #10
    //   577: getfield presentationTimeUs : J
    //   580: lstore #4
    //   582: lload #4
    //   584: l2f
    //   585: aload_0
    //   586: getfield m : J
    //   589: aload_0
    //   590: getfield w : J
    //   593: ladd
    //   594: ldc2_w 1000
    //   597: lmul
    //   598: l2f
    //   599: ldc_w 1.01
    //   602: fmul
    //   603: fcmpl
    //   604: iflt -> 638
    //   607: aload_0
    //   608: invokespecial g : ()J
    //   611: lstore #6
    //   613: lload #6
    //   615: invokestatic signum : (J)I
    //   618: pop
    //   619: aload #15
    //   621: invokevirtual release : ()V
    //   624: lload #4
    //   626: lload #6
    //   628: ldc2_w 1000
    //   631: lmul
    //   632: ladd
    //   633: lstore #4
    //   635: goto -> 1061
    //   638: aload #15
    //   640: invokevirtual getSampleTrackIndex : ()I
    //   643: aload #14
    //   645: getfield c : I
    //   648: if_icmpne -> 1056
    //   651: iconst_1
    //   652: istore_2
    //   653: goto -> 656
    //   656: iload_2
    //   657: ifeq -> 669
    //   660: aload #12
    //   662: invokevirtual b : ()I
    //   665: istore_3
    //   666: goto -> 675
    //   669: aload #12
    //   671: invokevirtual c : ()I
    //   674: istore_3
    //   675: aload #12
    //   677: iload_3
    //   678: aload #13
    //   680: aload #10
    //   682: invokevirtual a : (ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   685: aload_0
    //   686: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   689: ifnull -> 728
    //   692: iload_2
    //   693: ifne -> 703
    //   696: aload_0
    //   697: invokespecial h : ()Z
    //   700: ifne -> 728
    //   703: aload_0
    //   704: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   707: aload #10
    //   709: getfield presentationTimeUs : J
    //   712: l2f
    //   713: ldc_w 1000.0
    //   716: fdiv
    //   717: aload_0
    //   718: getfield l : J
    //   721: l2f
    //   722: fdiv
    //   723: invokeinterface onProgressUpdate : (F)V
    //   728: aload #15
    //   730: invokevirtual advance : ()Z
    //   733: pop
    //   734: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   737: astore #16
    //   739: new java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial <init> : ()V
    //   746: astore #17
    //   748: aload #17
    //   750: ldc_w 'transferred '
    //   753: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: iload_2
    //   758: ifeq -> 808
    //   761: new java/lang/StringBuilder
    //   764: dup
    //   765: invokespecial <init> : ()V
    //   768: astore #10
    //   770: aload_0
    //   771: getfield o : I
    //   774: iconst_1
    //   775: iadd
    //   776: istore_2
    //   777: aload_0
    //   778: iload_2
    //   779: putfield o : I
    //   782: aload #10
    //   784: iload_2
    //   785: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   788: pop
    //   789: aload #10
    //   791: ldc_w 'th video'
    //   794: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: pop
    //   798: aload #10
    //   800: invokevirtual toString : ()Ljava/lang/String;
    //   803: astore #10
    //   805: goto -> 848
    //   808: new java/lang/StringBuilder
    //   811: dup
    //   812: invokespecial <init> : ()V
    //   815: astore #10
    //   817: aload_0
    //   818: getfield n : I
    //   821: iconst_1
    //   822: iadd
    //   823: istore_2
    //   824: aload_0
    //   825: iload_2
    //   826: putfield n : I
    //   829: aload #10
    //   831: iload_2
    //   832: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   835: pop
    //   836: aload #10
    //   838: ldc_w 'th audio'
    //   841: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: goto -> 798
    //   848: aload #17
    //   850: aload #10
    //   852: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: pop
    //   856: aload #16
    //   858: ldc 'SectionManager'
    //   860: aload #17
    //   862: invokevirtual toString : ()Ljava/lang/String;
    //   865: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   868: goto -> 386
    //   871: astore #10
    //   873: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   876: ldc 'SectionManager'
    //   878: aload #10
    //   880: invokevirtual getMessage : ()Ljava/lang/String;
    //   883: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   886: goto -> 1061
    //   889: aload_0
    //   890: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   893: ifnull -> 906
    //   896: aload_0
    //   897: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   900: fconst_1
    //   901: invokeinterface onProgressUpdate : (F)V
    //   906: aload #12
    //   908: invokevirtual a : ()Z
    //   911: ifeq -> 935
    //   914: aload_0
    //   915: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   918: ifnull -> 959
    //   921: aload_0
    //   922: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   925: aload #11
    //   927: invokeinterface onSaveVideoSuccess : (Ljava/lang/String;)V
    //   932: goto -> 959
    //   935: aload_0
    //   936: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   939: ifnull -> 959
    //   942: aload_0
    //   943: getfield s : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   946: iconst_0
    //   947: invokeinterface onSaveVideoFailed : (I)V
    //   952: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/core/QosManager;
    //   955: iconst_0
    //   956: invokevirtual a : (I)V
    //   959: getstatic com/qiniu/pili/droid/shortvideo/f/e.n : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   962: astore #10
    //   964: new java/lang/StringBuilder
    //   967: dup
    //   968: invokespecial <init> : ()V
    //   971: astore #11
    //   973: aload #11
    //   975: ldc_w 'concat sections - total transferred audio frames: '
    //   978: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: pop
    //   982: aload #11
    //   984: aload_0
    //   985: getfield n : I
    //   988: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   991: pop
    //   992: aload #11
    //   994: ldc_w ' video frames: '
    //   997: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: pop
    //   1001: aload #11
    //   1003: aload_0
    //   1004: getfield o : I
    //   1007: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1010: pop
    //   1011: aload #10
    //   1013: ldc 'SectionManager'
    //   1015: aload #11
    //   1017: invokevirtual toString : ()Ljava/lang/String;
    //   1020: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   1023: aload_0
    //   1024: monitorexit
    //   1025: return
    //   1026: astore #10
    //   1028: aload_0
    //   1029: monitorexit
    //   1030: aload #10
    //   1032: athrow
    //   1033: iload_2
    //   1034: iconst_1
    //   1035: iadd
    //   1036: istore_2
    //   1037: goto -> 248
    //   1040: ldc2_w -1
    //   1043: lstore #8
    //   1045: lload #4
    //   1047: lstore #6
    //   1049: lload #8
    //   1051: lstore #4
    //   1053: goto -> 386
    //   1056: iconst_0
    //   1057: istore_2
    //   1058: goto -> 656
    //   1061: iload_1
    //   1062: iconst_1
    //   1063: iadd
    //   1064: istore_1
    //   1065: goto -> 154
    // Exception table:
    //   from	to	target	type
    //   2	47	1026	finally
    //   50	149	1026	finally
    //   154	233	1026	finally
    //   233	246	871	java/io/IOException
    //   233	246	1026	finally
    //   248	287	1026	finally
    //   290	307	1026	finally
    //   310	352	1026	finally
    //   355	383	1026	finally
    //   386	444	1026	finally
    //   447	498	1026	finally
    //   502	513	1026	finally
    //   516	575	1026	finally
    //   575	607	1026	finally
    //   607	613	1026	finally
    //   619	624	1026	finally
    //   638	651	1026	finally
    //   660	666	1026	finally
    //   669	675	1026	finally
    //   675	692	1026	finally
    //   696	703	1026	finally
    //   703	728	1026	finally
    //   728	757	1026	finally
    //   761	798	1026	finally
    //   798	805	1026	finally
    //   808	845	1026	finally
    //   848	868	1026	finally
    //   873	886	1026	finally
    //   889	906	1026	finally
    //   906	932	1026	finally
    //   935	959	1026	finally
    //   959	1023	1026	finally
  }
  
  public static interface a {
    void a(long param1Long1, long param1Long2, int param1Int);
    
    void b(long param1Long1, long param1Long2, int param1Int);
    
    void i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */