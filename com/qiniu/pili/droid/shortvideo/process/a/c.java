package com.qiniu.pili.droid.shortvideo.process.a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLMixAudioFile;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoMixItem;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.encode.e;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.f;
import com.qiniu.pili.droid.shortvideo.gl.a.d;
import com.qiniu.pili.droid.shortvideo.gl.a.f;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import com.qiniu.pili.droid.shortvideo.muxer.b;
import com.qiniu.pili.droid.shortvideo.process.audio.MultiAudioMixer;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class c implements Runnable {
  public static String a = "MultiVideoMixer";
  
  private int A = 0;
  
  private com.qiniu.pili.droid.shortvideo.encode.a.a B = new com.qiniu.pili.droid.shortvideo.encode.a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e e = e.x;
        String str = c.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("audio encode format: ");
        stringBuilder.append(param1MediaFormat);
        e.c(str, stringBuilder.toString());
        c.a(this.a, param1MediaFormat);
        c.d(this.a);
      }
      
      public void a(Surface param1Surface) {}
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        e e = e.x;
        String str = c.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("encoded audio frame: ");
        stringBuilder.append(param1BufferInfo.presentationTimeUs);
        e.b(str, stringBuilder.toString());
        if (c.e(this.a) != null)
          c.e(this.a).b(param1ByteBuffer, param1BufferInfo); 
      }
      
      public void a(boolean param1Boolean) {
        e e = e.x;
        String str = c.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("audio encode started result: ");
        stringBuilder.append(param1Boolean);
        e.c(str, stringBuilder.toString());
        if (!param1Boolean) {
          c.a(this.a, 7);
          return;
        } 
        c.b(this.a);
      }
      
      public void b(boolean param1Boolean) {
        e.x.c(c.a, "audio encode stopped");
        c.c(this.a);
      }
    };
  
  private com.qiniu.pili.droid.shortvideo.encode.a.a C = new com.qiniu.pili.droid.shortvideo.encode.a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e e = e.x;
        String str = c.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("got video format:");
        stringBuilder.append(param1MediaFormat);
        e.c(str, stringBuilder.toString());
        c.b(this.a, param1MediaFormat);
        c.d(this.a);
      }
      
      public void a(Surface param1Surface) {
        c.a(this.a, param1Surface);
        (new Thread(this.a)).start();
      }
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        if (c.e(this.a) != null) {
          e e = e.x;
          String str = c.a;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("video encoded frame size:");
          stringBuilder.append(param1BufferInfo.size);
          stringBuilder.append(" ts:");
          stringBuilder.append(param1BufferInfo.presentationTimeUs);
          e.b(str, stringBuilder.toString());
          c.e(this.a).a(param1ByteBuffer, param1BufferInfo);
          c.j(this.a).onProgressUpdate((float)param1BufferInfo.presentationTimeUs * 1.0F / (float)(c.i(this.a) * 1000L));
        } 
      }
      
      public void a(boolean param1Boolean) {
        e e = e.x;
        String str = c.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video encode started result: ");
        stringBuilder.append(param1Boolean);
        e.c(str, stringBuilder.toString());
        if (!param1Boolean)
          c.a(this.a, 6); 
      }
      
      public void b(boolean param1Boolean) {
        e.x.c(c.a, "video encode stopped");
        c.b(this.a, null);
        c.c(this.a);
      }
    };
  
  private final PLVideoSaveListener D = new PLVideoSaveListener(this) {
      public void onProgressUpdate(float param1Float) {
        e e = e.x;
        String str = c.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onProgressUpdate: ");
        stringBuilder.append(param1Float);
        e.c(str, stringBuilder.toString());
      }
      
      public void onSaveVideoCanceled() {
        e.x.c(c.a, "onSaveVideoCanceled");
      }
      
      public void onSaveVideoFailed(int param1Int) {
        e e = e.x;
        String str = c.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSaveVideoFailed: ");
        stringBuilder.append(param1Int);
        e.c(str, stringBuilder.toString());
      }
      
      public void onSaveVideoSuccess(String param1String) {
        e e = e.x;
        String str = c.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSaveVideoSuccess: ");
        stringBuilder.append(param1String);
        e.c(str, stringBuilder.toString());
      }
    };
  
  private PLVideoEncodeSetting b;
  
  private LinkedList<PLVideoMixItem> c;
  
  private LinkedList<e> d;
  
  private f e;
  
  private g f;
  
  private d g;
  
  private volatile Surface h;
  
  private e i;
  
  private PLVideoSaveListener j;
  
  private b k;
  
  private String l;
  
  private MediaFormat m;
  
  private MediaFormat n;
  
  private long o;
  
  private volatile long p;
  
  private int q;
  
  private CountDownLatch r;
  
  private volatile boolean s;
  
  private volatile boolean t;
  
  private volatile boolean u;
  
  private volatile int v = -1;
  
  private List<PLMixAudioFile> w;
  
  private MultiAudioMixer x;
  
  private com.qiniu.pili.droid.shortvideo.encode.c y;
  
  private int z = 0;
  
  private PLMixAudioFile a(PLVideoMixItem paramPLVideoMixItem) {
    f f1 = new f(paramPLVideoMixItem.getVideoPath());
    if (f1.f() == null) {
      f1.a();
      return null;
    } 
    PLMixAudioFile pLMixAudioFile = new PLMixAudioFile(paramPLVideoMixItem.getVideoPath(), false);
    pLMixAudioFile.setLooping(paramPLVideoMixItem.isLooping());
    pLMixAudioFile.setOffsetInVideo((paramPLVideoMixItem.getStartTimeMs() * 1000));
    pLMixAudioFile.setVolume(paramPLVideoMixItem.getVolume());
    if (paramPLVideoMixItem.isLooping())
      pLMixAudioFile.setDurationInVideo(this.o * 1000L); 
    return pLMixAudioFile;
  }
  
  private void a(int paramInt) {
    e e1 = e.x;
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("exceptionalStop + ");
    stringBuilder.append(paramInt);
    e1.e(str, stringBuilder.toString());
    a();
    k();
    e1 = e.x;
    str = a;
    stringBuilder = new StringBuilder();
    stringBuilder.append("exceptionalStop - ");
    stringBuilder.append(paramInt);
    e1.e(str, stringBuilder.toString());
  }
  
  private boolean a(String paramString) {
    if (paramString == null) {
      e.x.e(a, "dest video path is wrong!");
      return false;
    } 
    File file = (new File(paramString)).getParentFile();
    if (!file.exists() && !file.mkdir()) {
      e e1 = e.x;
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("failed to mkdir: ");
      stringBuilder.append(file.getAbsolutePath());
      e1.e(str, stringBuilder.toString());
      return false;
    } 
    return true;
  }
  
  private boolean a(List<PLVideoMixItem> paramList, String paramString, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    PLVideoSaveListener pLVideoSaveListener = paramPLVideoSaveListener;
    if (paramPLVideoSaveListener == null)
      pLVideoSaveListener = this.D; 
    if (paramList == null || paramList.isEmpty() || paramList.size() <= 1 || paramString == null || paramPLVideoEncodeSetting == null) {
      e.x.e(a, "mix: invalid params !");
      pLVideoSaveListener.onSaveVideoFailed(10);
      return false;
    } 
    if (!a(paramString)) {
      e.x.e(a, "mix: destVideoPath is wrong!");
      pLVideoSaveListener.onSaveVideoFailed(10);
      return false;
    } 
    for (PLVideoMixItem pLVideoMixItem : paramList) {
      if (pLVideoMixItem == null) {
        e.x.e(a, "mix failed, item is null !");
        pLVideoSaveListener.onSaveVideoFailed(10);
        return false;
      } 
      if (pLVideoMixItem.getVideoPath().equals(paramString)) {
        e.x.e(a, "mix failed, the dest video path must be different with src videos !");
        pLVideoSaveListener.onSaveVideoFailed(10);
        return false;
      } 
    } 
    return true;
  }
  
  private void b() {
    this.g = new d(null, 1);
    this.e = new f(this.g, this.h, false);
    this.e.b();
    this.f = d.b(this.b.getVideoEncodingWidth(), this.b.getVideoEncodingHeight());
    this.q = d.a(null, this.b.getVideoEncodingWidth(), this.b.getVideoEncodingHeight(), 6408);
  }
  
  private void c() {
    this.r = new CountDownLatch(this.c.size());
    this.d = new LinkedList<e>();
    for (PLVideoMixItem pLVideoMixItem : this.c) {
      e e1 = new e(pLVideoMixItem, this.b.getVideoEncodingWidth(), this.b.getVideoEncodingHeight());
      e1.a(new a(this, pLVideoMixItem.getVideoPath(), pLVideoMixItem.getStartTimeMs()));
      this.d.add(e1);
      e1.a();
    } 
  }
  
  private void d() {
    try {
      this.r.await();
      return;
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
      return;
    } 
  }
  
  private void e() {
    long l = 1000000L / this.b.getVideoEncodingFps();
    while (this.p <= this.o * 1000L && !this.t) {
      Iterator<e> iterator = this.d.iterator();
      boolean bool = true;
      while (iterator.hasNext()) {
        e e2 = iterator.next();
        a a1 = (a)e2.b();
        while (!a1.b() && a1.a());
        if (bool) {
          this.q = e2.a(this.q, true);
          bool = false;
          continue;
        } 
        this.q = e2.a(this.q, false);
      } 
      this.f.b(this.q);
      this.e.a(this.p * 1000L);
      this.e.c();
      this.i.a(this.p * 1000L);
      e e1 = e.x;
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("mixVideoFrame, mix timestamp is : ");
      stringBuilder.append(this.p);
      e1.b(str, stringBuilder.toString());
      this.p += l;
    } 
    this.s = true;
  }
  
  private void f() {
    for (int i = 0; i < this.d.size(); i++)
      ((e)this.d.get(i)).d(); 
  }
  
  private void g() {
    this.e.d();
    this.f.f();
    this.g.a();
  }
  
  private void h() {
    MediaFormat mediaFormat = new MediaFormat();
    int i = 44100;
    mediaFormat.setInteger("sample-rate", 44100);
    mediaFormat.setInteger("channel-count", 1);
    int j = mediaFormat.getInteger("sample-rate");
    int k = mediaFormat.getInteger("channel-count");
    if (mediaFormat.containsKey("bitrate"))
      i = mediaFormat.getInteger("bitrate"); 
    PLAudioEncodeSetting pLAudioEncodeSetting = new PLAudioEncodeSetting();
    pLAudioEncodeSetting.setSampleRate(j);
    pLAudioEncodeSetting.setChannels(k);
    pLAudioEncodeSetting.setBitrate(i);
    this.y = new com.qiniu.pili.droid.shortvideo.encode.c(pLAudioEncodeSetting);
    this.y.a(this.B);
    this.y.a();
  }
  
  private void i() {
    this.x = new MultiAudioMixer();
    this.x.a(this.o);
    this.x.a(this.w, new MultiAudioMixer.a(this) {
          public void a() {
            c.a(this.a).c();
          }
          
          public void a(int param1Int) {
            e e = e.x;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("multi audio mix failed error : ");
            stringBuilder.append(param1Int);
            e.d(stringBuilder.toString());
            c.a(this.a).c();
          }
          
          public void a(byte[] param1ArrayOfbyte, long param1Long) {
            c.a(this.a).a(ByteBuffer.wrap(param1ArrayOfbyte), param1ArrayOfbyte.length, param1Long);
          }
        });
  }
  
  private void j() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.x : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: getstatic com/qiniu/pili/droid/shortvideo/process/a/c.a : Ljava/lang/String;
    //   8: ldc_w 'startMuxer +'
    //   11: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: aload_0
    //   16: getfield z : I
    //   19: iconst_1
    //   20: iadd
    //   21: putfield z : I
    //   24: aload_0
    //   25: getfield y : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   28: ifnull -> 66
    //   31: aload_0
    //   32: getfield z : I
    //   35: iconst_2
    //   36: if_icmpge -> 66
    //   39: getstatic com/qiniu/pili/droid/shortvideo/f/e.x : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   42: getstatic com/qiniu/pili/droid/shortvideo/process/a/c.a : Ljava/lang/String;
    //   45: ldc_w 'not ready to start muxer.'
    //   48: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_0
    //   52: invokevirtual wait : ()V
    //   55: goto -> 63
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual printStackTrace : ()V
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: aload_0
    //   67: new com/qiniu/pili/droid/shortvideo/muxer/b
    //   70: dup
    //   71: invokespecial <init> : ()V
    //   74: putfield k : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   77: aload_0
    //   78: getfield k : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   81: aload_0
    //   82: getfield l : Ljava/lang/String;
    //   85: aload_0
    //   86: getfield n : Landroid/media/MediaFormat;
    //   89: aload_0
    //   90: getfield m : Landroid/media/MediaFormat;
    //   93: iconst_0
    //   94: invokevirtual a : (Ljava/lang/String;Landroid/media/MediaFormat;Landroid/media/MediaFormat;I)Z
    //   97: ifne -> 119
    //   100: getstatic com/qiniu/pili/droid/shortvideo/f/e.x : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   103: getstatic com/qiniu/pili/droid/shortvideo/process/a/c.a : Ljava/lang/String;
    //   106: ldc_w 'start muxer failed!'
    //   109: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_0
    //   113: invokevirtual a : ()V
    //   116: goto -> 135
    //   119: getstatic com/qiniu/pili/droid/shortvideo/f/e.x : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   122: getstatic com/qiniu/pili/droid/shortvideo/process/a/c.a : Ljava/lang/String;
    //   125: ldc_w 'start muxer success!'
    //   128: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: invokevirtual notify : ()V
    //   135: getstatic com/qiniu/pili/droid/shortvideo/f/e.x : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   138: getstatic com/qiniu/pili/droid/shortvideo/process/a/c.a : Ljava/lang/String;
    //   141: ldc_w 'startMuxer -'
    //   144: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload_0
    //   148: monitorexit
    //   149: return
    //   150: astore_1
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_1
    //   154: athrow
    // Exception table:
    //   from	to	target	type
    //   2	51	150	finally
    //   51	55	58	java/lang/InterruptedException
    //   51	55	150	finally
    //   59	63	150	finally
    //   66	116	150	finally
    //   119	135	150	finally
    //   135	147	150	finally
  }
  
  private void k() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.x : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: getstatic com/qiniu/pili/droid/shortvideo/process/a/c.a : Ljava/lang/String;
    //   8: ldc_w 'stopMuxer +'
    //   11: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield A : I
    //   18: istore_2
    //   19: iconst_1
    //   20: istore_1
    //   21: aload_0
    //   22: iload_2
    //   23: iconst_1
    //   24: iadd
    //   25: putfield A : I
    //   28: aload_0
    //   29: getfield y : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   32: ifnull -> 58
    //   35: aload_0
    //   36: getfield A : I
    //   39: iconst_2
    //   40: if_icmpge -> 58
    //   43: getstatic com/qiniu/pili/droid/shortvideo/f/e.x : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   46: getstatic com/qiniu/pili/droid/shortvideo/process/a/c.a : Ljava/lang/String;
    //   49: ldc_w 'not ready to stop muxer.'
    //   52: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: aload_0
    //   59: getfield k : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   62: ifnull -> 409
    //   65: aload_0
    //   66: getfield k : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   69: invokevirtual a : ()Z
    //   72: ifeq -> 409
    //   75: goto -> 78
    //   78: getstatic com/qiniu/pili/droid/shortvideo/f/e.x : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   81: astore #4
    //   83: getstatic com/qiniu/pili/droid/shortvideo/process/a/c.a : Ljava/lang/String;
    //   86: astore #5
    //   88: new java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial <init> : ()V
    //   95: astore #6
    //   97: aload #6
    //   99: ldc_w 'stop muxer '
    //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: iload_1
    //   107: ifeq -> 414
    //   110: ldc_w 'success'
    //   113: astore_3
    //   114: goto -> 117
    //   117: aload #6
    //   119: aload_3
    //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload #4
    //   126: aload #5
    //   128: aload #6
    //   130: invokevirtual toString : ()Ljava/lang/String;
    //   133: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_0
    //   137: aconst_null
    //   138: putfield k : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield i : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   146: aload_0
    //   147: aconst_null
    //   148: putfield y : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   151: aload_0
    //   152: getfield c : Ljava/util/LinkedList;
    //   155: ifnull -> 170
    //   158: aload_0
    //   159: getfield c : Ljava/util/LinkedList;
    //   162: invokevirtual clear : ()V
    //   165: aload_0
    //   166: aconst_null
    //   167: putfield c : Ljava/util/LinkedList;
    //   170: aload_0
    //   171: getfield w : Ljava/util/List;
    //   174: ifnull -> 191
    //   177: aload_0
    //   178: getfield w : Ljava/util/List;
    //   181: invokeinterface clear : ()V
    //   186: aload_0
    //   187: aconst_null
    //   188: putfield w : Ljava/util/List;
    //   191: aload_0
    //   192: getfield d : Ljava/util/LinkedList;
    //   195: ifnull -> 210
    //   198: aload_0
    //   199: getfield d : Ljava/util/LinkedList;
    //   202: invokevirtual clear : ()V
    //   205: aload_0
    //   206: aconst_null
    //   207: putfield d : Ljava/util/LinkedList;
    //   210: aload_0
    //   211: aconst_null
    //   212: putfield n : Landroid/media/MediaFormat;
    //   215: aload_0
    //   216: aconst_null
    //   217: putfield m : Landroid/media/MediaFormat;
    //   220: aload_0
    //   221: aconst_null
    //   222: putfield h : Landroid/view/Surface;
    //   225: aload_0
    //   226: aconst_null
    //   227: putfield e : Lcom/qiniu/pili/droid/shortvideo/gl/a/f;
    //   230: aload_0
    //   231: aconst_null
    //   232: putfield f : Lcom/qiniu/pili/droid/shortvideo/gl/c/g;
    //   235: aload_0
    //   236: aconst_null
    //   237: putfield g : Lcom/qiniu/pili/droid/shortvideo/gl/a/d;
    //   240: aload_0
    //   241: lconst_0
    //   242: putfield p : J
    //   245: aload_0
    //   246: iconst_0
    //   247: putfield u : Z
    //   250: aload_0
    //   251: iconst_0
    //   252: putfield s : Z
    //   255: aload_0
    //   256: iconst_0
    //   257: putfield A : I
    //   260: aload_0
    //   261: iconst_0
    //   262: putfield z : I
    //   265: aload_0
    //   266: getfield t : Z
    //   269: ifeq -> 334
    //   272: aload_0
    //   273: iconst_0
    //   274: putfield t : Z
    //   277: new java/io/File
    //   280: dup
    //   281: aload_0
    //   282: getfield l : Ljava/lang/String;
    //   285: invokespecial <init> : (Ljava/lang/String;)V
    //   288: invokevirtual delete : ()Z
    //   291: pop
    //   292: aload_0
    //   293: invokespecial l : ()Z
    //   296: ifeq -> 322
    //   299: aload_0
    //   300: getfield v : I
    //   303: istore_1
    //   304: aload_0
    //   305: iconst_m1
    //   306: putfield v : I
    //   309: aload_0
    //   310: getfield j : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   313: iload_1
    //   314: invokeinterface onSaveVideoFailed : (I)V
    //   319: goto -> 389
    //   322: aload_0
    //   323: getfield j : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   326: invokeinterface onSaveVideoCanceled : ()V
    //   331: goto -> 389
    //   334: iload_1
    //   335: ifeq -> 364
    //   338: aload_0
    //   339: getfield j : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   342: fconst_1
    //   343: invokeinterface onProgressUpdate : (F)V
    //   348: aload_0
    //   349: getfield j : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   352: aload_0
    //   353: getfield l : Ljava/lang/String;
    //   356: invokeinterface onSaveVideoSuccess : (Ljava/lang/String;)V
    //   361: goto -> 389
    //   364: new java/io/File
    //   367: dup
    //   368: aload_0
    //   369: getfield l : Ljava/lang/String;
    //   372: invokespecial <init> : (Ljava/lang/String;)V
    //   375: invokevirtual delete : ()Z
    //   378: pop
    //   379: aload_0
    //   380: getfield j : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   383: iconst_3
    //   384: invokeinterface onSaveVideoFailed : (I)V
    //   389: getstatic com/qiniu/pili/droid/shortvideo/f/e.x : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   392: getstatic com/qiniu/pili/droid/shortvideo/process/a/c.a : Ljava/lang/String;
    //   395: ldc_w 'stopMuxer -'
    //   398: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   401: aload_0
    //   402: monitorexit
    //   403: return
    //   404: astore_3
    //   405: aload_0
    //   406: monitorexit
    //   407: aload_3
    //   408: athrow
    //   409: iconst_0
    //   410: istore_1
    //   411: goto -> 78
    //   414: ldc_w 'fail'
    //   417: astore_3
    //   418: goto -> 117
    // Exception table:
    //   from	to	target	type
    //   2	19	404	finally
    //   21	55	404	finally
    //   58	75	404	finally
    //   78	106	404	finally
    //   117	170	404	finally
    //   170	191	404	finally
    //   191	210	404	finally
    //   210	319	404	finally
    //   322	331	404	finally
    //   338	361	404	finally
    //   364	389	404	finally
    //   389	401	404	finally
  }
  
  private boolean l() {
    return (this.v >= 0);
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield u : Z
    //   6: ifeq -> 43
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.x : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: getstatic com/qiniu/pili/droid/shortvideo/process/a/c.a : Ljava/lang/String;
    //   15: ldc_w 'cancel mix'
    //   18: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield t : Z
    //   26: aload_0
    //   27: getfield x : Lcom/qiniu/pili/droid/shortvideo/process/audio/MultiAudioMixer;
    //   30: ifnull -> 55
    //   33: aload_0
    //   34: getfield x : Lcom/qiniu/pili/droid/shortvideo/process/audio/MultiAudioMixer;
    //   37: invokevirtual a : ()V
    //   40: goto -> 55
    //   43: getstatic com/qiniu/pili/droid/shortvideo/f/e.x : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   46: getstatic com/qiniu/pili/droid/shortvideo/process/a/c.a : Ljava/lang/String;
    //   49: ldc_w 'cancel mix failed'
    //   52: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Exception table:
    //   from	to	target	type
    //   2	40	58	finally
    //   43	55	58	finally
  }
  
  public boolean a(List<PLVideoMixItem> paramList, String paramString, long paramLong, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.x : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: getstatic com/qiniu/pili/droid/shortvideo/process/a/c.a : Ljava/lang/String;
    //   8: ldc_w 'mixItems +'
    //   11: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: aload_1
    //   16: aload_2
    //   17: aload #5
    //   19: aload #6
    //   21: invokespecial a : (Ljava/util/List;Ljava/lang/String;Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;)Z
    //   24: istore #7
    //   26: iload #7
    //   28: ifne -> 35
    //   31: aload_0
    //   32: monitorexit
    //   33: iconst_0
    //   34: ireturn
    //   35: aload #6
    //   37: astore #8
    //   39: aload #6
    //   41: ifnonnull -> 50
    //   44: aload_0
    //   45: getfield D : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   48: astore #8
    //   50: aload_0
    //   51: aload #8
    //   53: putfield j : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   56: aload_0
    //   57: getfield u : Z
    //   60: ifeq -> 89
    //   63: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   66: getstatic com/qiniu/pili/droid/shortvideo/process/a/c.a : Ljava/lang/String;
    //   69: ldc_w 'mix already started +'
    //   72: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_0
    //   76: getfield j : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   79: iconst_1
    //   80: invokeinterface onSaveVideoFailed : (I)V
    //   85: aload_0
    //   86: monitorexit
    //   87: iconst_0
    //   88: ireturn
    //   89: aload_0
    //   90: aload #5
    //   92: putfield b : Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;
    //   95: aload_0
    //   96: new java/util/LinkedList
    //   99: dup
    //   100: aload_1
    //   101: invokespecial <init> : (Ljava/util/Collection;)V
    //   104: putfield c : Ljava/util/LinkedList;
    //   107: aload_0
    //   108: new java/util/LinkedList
    //   111: dup
    //   112: invokespecial <init> : ()V
    //   115: putfield w : Ljava/util/List;
    //   118: aload_0
    //   119: aload_2
    //   120: putfield l : Ljava/lang/String;
    //   123: aload_0
    //   124: lload_3
    //   125: putfield o : J
    //   128: aload_1
    //   129: invokeinterface iterator : ()Ljava/util/Iterator;
    //   134: astore_1
    //   135: aload_1
    //   136: invokeinterface hasNext : ()Z
    //   141: ifeq -> 176
    //   144: aload_0
    //   145: aload_1
    //   146: invokeinterface next : ()Ljava/lang/Object;
    //   151: checkcast com/qiniu/pili/droid/shortvideo/PLVideoMixItem
    //   154: invokespecial a : (Lcom/qiniu/pili/droid/shortvideo/PLVideoMixItem;)Lcom/qiniu/pili/droid/shortvideo/PLMixAudioFile;
    //   157: astore_2
    //   158: aload_2
    //   159: ifnull -> 135
    //   162: aload_0
    //   163: getfield w : Ljava/util/List;
    //   166: aload_2
    //   167: invokeinterface add : (Ljava/lang/Object;)Z
    //   172: pop
    //   173: goto -> 135
    //   176: aload_0
    //   177: new com/qiniu/pili/droid/shortvideo/encode/e
    //   180: dup
    //   181: aload #5
    //   183: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;)V
    //   186: putfield i : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   189: aload_0
    //   190: getfield i : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   193: aload_0
    //   194: getfield C : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   197: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/encode/a$a;)V
    //   200: aload_0
    //   201: getfield i : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   204: invokevirtual a : ()Z
    //   207: pop
    //   208: aload_0
    //   209: iconst_1
    //   210: putfield u : Z
    //   213: getstatic com/qiniu/pili/droid/shortvideo/f/e.x : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   216: getstatic com/qiniu/pili/droid/shortvideo/process/a/c.a : Ljava/lang/String;
    //   219: ldc_w 'mixItems +'
    //   222: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload_0
    //   226: monitorexit
    //   227: iconst_1
    //   228: ireturn
    //   229: astore_1
    //   230: aload_0
    //   231: monitorexit
    //   232: aload_1
    //   233: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	229	finally
    //   44	50	229	finally
    //   50	85	229	finally
    //   89	135	229	finally
    //   135	158	229	finally
    //   162	173	229	finally
    //   176	225	229	finally
  }
  
  public void run() {
    h();
    b();
    c();
    d();
    e();
    f();
    g();
    this.i.c();
  }
  
  class a implements b.c {
    private volatile long b;
    
    private long c;
    
    private String d;
    
    public a(c this$0, String param1String, long param1Long) {
      this.d = param1String;
      this.c = param1Long;
    }
    
    public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
      e e = e.x;
      String str = c.a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("video decode frame, elapseTimestampUs : ");
      stringBuilder.append(param1Long2);
      stringBuilder.append(" curMixDurationUs : ");
      stringBuilder.append(c.f(this.a));
      stringBuilder.append(" path : ");
      stringBuilder.append(this.d);
      e.b(str, stringBuilder.toString());
      c.g(this.a).countDown();
      if (param1Boolean) {
        param1Long1 = Long.MAX_VALUE;
      } else {
        param1Long1 = this.c * 1000L + param1Long2;
      } 
      this.b = param1Long1;
      while (b() && !c.h(this.a));
      while (!a() && !c.h(this.a));
    }
    
    public boolean a() {
      return (c.f(this.a) > this.b);
    }
    
    public boolean b() {
      return (c.f(this.a) < this.c * 1000L);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\process\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */