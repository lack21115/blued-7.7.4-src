package com.qiniu.pili.droid.shortvideo.transcoder;

import android.graphics.BitmapFactory;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLComposeItem;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.c.a.b;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.encode.c;
import com.qiniu.pili.droid.shortvideo.encode.e;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.f;
import com.qiniu.pili.droid.shortvideo.gl.a.d;
import com.qiniu.pili.droid.shortvideo.gl.a.f;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import com.qiniu.pili.droid.shortvideo.gl.c.h;
import com.qiniu.pili.droid.shortvideo.gl.c.l;
import com.qiniu.pili.droid.shortvideo.muxer.b;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a implements Runnable {
  private static final PLVideoSaveListener E = new PLVideoSaveListener() {
      public void onProgressUpdate(float param1Float) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onProgressUpdate: ");
        stringBuilder.append(param1Float);
        e.c("MultiImageComposer", stringBuilder.toString());
      }
      
      public void onSaveVideoCanceled() {
        e.t.c("MultiImageComposer", "onSaveVideoCanceled");
      }
      
      public void onSaveVideoFailed(int param1Int) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSaveVideoFailed: ");
        stringBuilder.append(param1Int);
        e.c("MultiImageComposer", stringBuilder.toString());
      }
      
      public void onSaveVideoSuccess(String param1String) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSaveVideoSuccess: ");
        stringBuilder.append(param1String);
        e.c("MultiImageComposer", stringBuilder.toString());
      }
    };
  
  private d A;
  
  private PLDisplayMode B = PLDisplayMode.FIT;
  
  private com.qiniu.pili.droid.shortvideo.encode.a.a C = new com.qiniu.pili.droid.shortvideo.encode.a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("got video format:");
        stringBuilder.append(param1MediaFormat);
        e.c("MultiImageComposer", stringBuilder.toString());
        a.a(this.a, param1MediaFormat);
        a.b(this.a);
      }
      
      public void a(Surface param1Surface) {
        a.a(this.a, param1Surface);
        (new Thread(this.a)).start();
      }
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        if (a.c(this.a) != null) {
          e e1 = e.t;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("write video ");
          stringBuilder1.append(param1BufferInfo.presentationTimeUs);
          e1.b("MultiImageComposer", stringBuilder1.toString());
          a.c(this.a).a(param1ByteBuffer, param1BufferInfo);
          a.e(this.a).onProgressUpdate((float)param1BufferInfo.presentationTimeUs * 1.0F / (float)a.d(this.a));
          return;
        } 
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video frame not write  ");
        stringBuilder.append(param1BufferInfo.presentationTimeUs);
        e.b("MultiImageComposer", stringBuilder.toString());
      }
      
      public void a(boolean param1Boolean) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video encode started result: ");
        stringBuilder.append(param1Boolean);
        e.c("MultiImageComposer", stringBuilder.toString());
        if (!param1Boolean)
          a.a(this.a, 6); 
      }
      
      public void b(boolean param1Boolean) {
        e.t.c("MultiImageComposer", "video encode stopped");
        a.a(this.a, (MediaFormat)null);
        a.a(this.a);
      }
    };
  
  private com.qiniu.pili.droid.shortvideo.encode.a.a D = new com.qiniu.pili.droid.shortvideo.encode.a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("got audio format:");
        stringBuilder.append(param1MediaFormat);
        e.c("MultiImageComposer", stringBuilder.toString());
        a.b(this.a, param1MediaFormat);
        a.b(this.a);
      }
      
      public void a(Surface param1Surface) {}
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        if (a.c(this.a) != null) {
          e e1 = e.t;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("write audio: ");
          stringBuilder1.append(param1BufferInfo.presentationTimeUs);
          e1.b("MultiImageComposer", stringBuilder1.toString());
          a.c(this.a).b(param1ByteBuffer, param1BufferInfo);
          return;
        } 
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("audio frame not write  ");
        stringBuilder.append(param1BufferInfo.presentationTimeUs);
        e.b("MultiImageComposer", stringBuilder.toString());
      }
      
      public void a(boolean param1Boolean) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("audio encode started: ");
        stringBuilder.append(param1Boolean);
        e.c("MultiImageComposer", stringBuilder.toString());
        if (!param1Boolean) {
          a.a(this.a, 7);
          return;
        } 
        f f = new f(a.f(this.a), false, true);
        a.a(this.a, new b(f.d(), f.f()));
        a.g(this.a).a(new a.a());
        a.g(this.a).a(a.h(this.a));
        a.g(this.a).a();
      }
      
      public void b(boolean param1Boolean) {
        e.t.c("MultiImageComposer", "audio encode stopped.");
        a.b(this.a, (MediaFormat)null);
        a.a(this.a);
      }
    };
  
  private PLVideoSaveListener a;
  
  private b b;
  
  private int c = 0;
  
  private int d = 0;
  
  private e e;
  
  private c f;
  
  private MediaFormat g;
  
  private MediaFormat h;
  
  private b i;
  
  private volatile Surface j;
  
  private LinkedList<PLComposeItem> k;
  
  private String l;
  
  private int m;
  
  private int n;
  
  private long o;
  
  private long p;
  
  private long q;
  
  private String r;
  
  private boolean s;
  
  private volatile boolean t;
  
  private volatile boolean u;
  
  private volatile int v = -1;
  
  private f w;
  
  private g x;
  
  private l y;
  
  private int z;
  
  private g a(int paramInt1, int paramInt2) {
    g g1 = new g();
    g1.a(paramInt1, paramInt2);
    g1.b();
    return g1;
  }
  
  private h a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    h h = new h(paramLong);
    h.a(this.m, this.n);
    h.a(paramInt1, paramInt2, paramInt3, paramInt4, this.B);
    return h;
  }
  
  private void a(int paramInt) {
    e e1 = e.t;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("exceptionalStop + ");
    stringBuilder.append(paramInt);
    e1.c("MultiImageComposer", stringBuilder.toString());
    this.v = paramInt;
    a();
    c();
    e1 = e.t;
    stringBuilder = new StringBuilder();
    stringBuilder.append("exceptionalStop - ");
    stringBuilder.append(paramInt);
    e1.c("MultiImageComposer", stringBuilder.toString());
  }
  
  private void a(PLComposeItem paramPLComposeItem, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    e.t.c("MultiImageComposer", "compose once +");
    int i = b.a(paramPLComposeItem.getFilePath(), this.m, this.n);
    if (i == 0) {
      e.t.e("MultiImageComposer", "compose once error, the texture id is 0!");
      return;
    } 
    h h = a(paramPLComposeItem.getTransitionTimeMs(), paramInt1, paramInt2, paramInt3, paramInt4);
    long l2 = paramPLComposeItem.getDurationMs();
    long l1 = 0L;
    while (l1 <= l2 * 1000L && !this.u) {
      boolean bool;
      if (l1 == 0L) {
        bool = true;
      } else {
        bool = false;
      } 
      long l3 = this.p * 1000L;
      paramInt1 = h.a(this.z, i, l3, bool);
      paramInt1 = this.y.a(paramInt1);
      GLES20.glClear(16384);
      this.x.b(paramInt1);
      this.w.a(l3);
      this.w.c();
      this.e.a(l3);
      l3 = this.o;
      l1 += l3;
      this.p += l3;
    } 
    b.a(this.z);
    this.z = i;
    h.f();
    e.t.c("MultiImageComposer", "compose once -");
  }
  
  private boolean a(String paramString) {
    if (paramString == null) {
      e.t.e("MultiImageComposer", "dst video path is wrong!");
      return false;
    } 
    File file = (new File(paramString)).getParentFile();
    if (!file.exists() && !file.mkdir()) {
      e e1 = e.t;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("failed to mkdir: ");
      stringBuilder.append(file.getAbsolutePath());
      e1.e("MultiImageComposer", stringBuilder.toString());
      return false;
    } 
    return true;
  }
  
  private boolean a(List<PLComposeItem> paramList, String paramString, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    PLVideoSaveListener pLVideoSaveListener = paramPLVideoSaveListener;
    if (paramPLVideoSaveListener == null)
      pLVideoSaveListener = E; 
    if (paramList == null || paramList.isEmpty() || paramString == null || paramPLVideoEncodeSetting == null) {
      e.t.e("MultiImageComposer", "compose: invalid params !");
      pLVideoSaveListener.onSaveVideoFailed(10);
      return false;
    } 
    if (!a(paramString)) {
      e.t.e("MultiImageComposer", "compose: dstVideoPath is wrong!");
      return false;
    } 
    Iterator<PLComposeItem> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      if (((PLComposeItem)iterator.next()).getFilePath().equals(paramString)) {
        e.t.e("MultiImageComposer", "compose failed, the dst video path must be different with src path !");
        pLVideoSaveListener.onSaveVideoFailed(10);
        return false;
      } 
    } 
    return true;
  }
  
  private l b(int paramInt1, int paramInt2) {
    l l1 = new l();
    l1.a(paramInt1, paramInt2);
    l1.b();
    return l1;
  }
  
  private boolean b() {
    return (this.v >= 0);
  }
  
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'MultiImageComposer'
    //   7: ldc_w 'stopMuxer +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield d : I
    //   17: istore_2
    //   18: iconst_1
    //   19: istore_1
    //   20: aload_0
    //   21: iload_2
    //   22: iconst_1
    //   23: iadd
    //   24: putfield d : I
    //   27: aload_0
    //   28: getfield f : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   31: ifnull -> 56
    //   34: aload_0
    //   35: getfield d : I
    //   38: iconst_2
    //   39: if_icmpge -> 56
    //   42: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   45: ldc 'MultiImageComposer'
    //   47: ldc_w 'not ready to stop muxer.'
    //   50: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: getfield b : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   60: ifnull -> 362
    //   63: aload_0
    //   64: getfield b : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   67: invokevirtual a : ()Z
    //   70: ifeq -> 362
    //   73: goto -> 76
    //   76: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   79: astore #4
    //   81: new java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial <init> : ()V
    //   88: astore #5
    //   90: aload #5
    //   92: ldc_w 'stop muxer '
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: iload_1
    //   100: ifeq -> 367
    //   103: ldc_w 'success'
    //   106: astore_3
    //   107: goto -> 110
    //   110: aload #5
    //   112: aload_3
    //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload #4
    //   119: ldc 'MultiImageComposer'
    //   121: aload #5
    //   123: invokevirtual toString : ()Ljava/lang/String;
    //   126: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield b : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield e : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   139: aload_0
    //   140: aconst_null
    //   141: putfield f : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   144: aload_0
    //   145: aconst_null
    //   146: putfield k : Ljava/util/LinkedList;
    //   149: aload_0
    //   150: aconst_null
    //   151: putfield h : Landroid/media/MediaFormat;
    //   154: aload_0
    //   155: aconst_null
    //   156: putfield g : Landroid/media/MediaFormat;
    //   159: aload_0
    //   160: aconst_null
    //   161: putfield i : Lcom/qiniu/pili/droid/shortvideo/d/b;
    //   164: aload_0
    //   165: aconst_null
    //   166: putfield j : Landroid/view/Surface;
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield w : Lcom/qiniu/pili/droid/shortvideo/gl/a/f;
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield y : Lcom/qiniu/pili/droid/shortvideo/gl/c/l;
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield x : Lcom/qiniu/pili/droid/shortvideo/gl/c/g;
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield A : Lcom/qiniu/pili/droid/shortvideo/gl/a/d;
    //   189: aload_0
    //   190: iconst_0
    //   191: putfield c : I
    //   194: aload_0
    //   195: iconst_0
    //   196: putfield d : I
    //   199: aload_0
    //   200: lconst_0
    //   201: putfield q : J
    //   204: aload_0
    //   205: lconst_0
    //   206: putfield p : J
    //   209: aload_0
    //   210: iconst_0
    //   211: putfield z : I
    //   214: aload_0
    //   215: iconst_0
    //   216: putfield t : Z
    //   219: aload_0
    //   220: getfield u : Z
    //   223: ifeq -> 288
    //   226: aload_0
    //   227: iconst_0
    //   228: putfield u : Z
    //   231: new java/io/File
    //   234: dup
    //   235: aload_0
    //   236: getfield l : Ljava/lang/String;
    //   239: invokespecial <init> : (Ljava/lang/String;)V
    //   242: invokevirtual delete : ()Z
    //   245: pop
    //   246: aload_0
    //   247: invokespecial b : ()Z
    //   250: ifeq -> 276
    //   253: aload_0
    //   254: getfield v : I
    //   257: istore_1
    //   258: aload_0
    //   259: iconst_m1
    //   260: putfield v : I
    //   263: aload_0
    //   264: getfield a : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   267: iload_1
    //   268: invokeinterface onSaveVideoFailed : (I)V
    //   273: goto -> 343
    //   276: aload_0
    //   277: getfield a : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   280: invokeinterface onSaveVideoCanceled : ()V
    //   285: goto -> 343
    //   288: iload_1
    //   289: ifeq -> 318
    //   292: aload_0
    //   293: getfield a : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   296: fconst_1
    //   297: invokeinterface onProgressUpdate : (F)V
    //   302: aload_0
    //   303: getfield a : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   306: aload_0
    //   307: getfield l : Ljava/lang/String;
    //   310: invokeinterface onSaveVideoSuccess : (Ljava/lang/String;)V
    //   315: goto -> 343
    //   318: new java/io/File
    //   321: dup
    //   322: aload_0
    //   323: getfield l : Ljava/lang/String;
    //   326: invokespecial <init> : (Ljava/lang/String;)V
    //   329: invokevirtual delete : ()Z
    //   332: pop
    //   333: aload_0
    //   334: getfield a : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   337: iconst_3
    //   338: invokeinterface onSaveVideoFailed : (I)V
    //   343: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   346: ldc 'MultiImageComposer'
    //   348: ldc_w 'stopMuxer -'
    //   351: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   354: aload_0
    //   355: monitorexit
    //   356: return
    //   357: astore_3
    //   358: aload_0
    //   359: monitorexit
    //   360: aload_3
    //   361: athrow
    //   362: iconst_0
    //   363: istore_1
    //   364: goto -> 76
    //   367: ldc_w 'fail'
    //   370: astore_3
    //   371: goto -> 110
    // Exception table:
    //   from	to	target	type
    //   2	18	357	finally
    //   20	53	357	finally
    //   56	73	357	finally
    //   76	99	357	finally
    //   110	273	357	finally
    //   276	285	357	finally
    //   292	315	357	finally
    //   318	343	357	finally
    //   343	354	357	finally
  }
  
  private void d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'MultiImageComposer'
    //   7: ldc_w 'startMuxer +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield u : Z
    //   17: ifeq -> 34
    //   20: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   23: ldc 'MultiImageComposer'
    //   25: ldc_w 'composer is already canceled'
    //   28: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: aload_0
    //   36: getfield c : I
    //   39: iconst_1
    //   40: iadd
    //   41: putfield c : I
    //   44: aload_0
    //   45: getfield f : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   48: ifnull -> 85
    //   51: aload_0
    //   52: getfield c : I
    //   55: iconst_2
    //   56: if_icmpge -> 85
    //   59: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   62: ldc 'MultiImageComposer'
    //   64: ldc_w 'not ready to start muxer.'
    //   67: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: invokevirtual wait : ()V
    //   74: goto -> 82
    //   77: astore_1
    //   78: aload_1
    //   79: invokevirtual printStackTrace : ()V
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: new com/qiniu/pili/droid/shortvideo/muxer/b
    //   89: dup
    //   90: invokespecial <init> : ()V
    //   93: putfield b : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   96: aload_0
    //   97: getfield b : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   100: aload_0
    //   101: getfield l : Ljava/lang/String;
    //   104: aload_0
    //   105: getfield h : Landroid/media/MediaFormat;
    //   108: aload_0
    //   109: getfield g : Landroid/media/MediaFormat;
    //   112: iconst_0
    //   113: invokevirtual a : (Ljava/lang/String;Landroid/media/MediaFormat;Landroid/media/MediaFormat;I)Z
    //   116: ifne -> 137
    //   119: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   122: ldc 'MultiImageComposer'
    //   124: ldc_w 'start muxer failed!'
    //   127: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: invokevirtual a : ()V
    //   134: goto -> 152
    //   137: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   140: ldc 'MultiImageComposer'
    //   142: ldc_w 'start muxer success!'
    //   145: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_0
    //   149: invokevirtual notify : ()V
    //   152: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   155: ldc 'MultiImageComposer'
    //   157: ldc_w 'startMuxer -'
    //   160: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_0
    //   164: monitorexit
    //   165: return
    //   166: astore_1
    //   167: aload_0
    //   168: monitorexit
    //   169: aload_1
    //   170: athrow
    // Exception table:
    //   from	to	target	type
    //   2	31	166	finally
    //   34	70	166	finally
    //   70	74	77	java/lang/InterruptedException
    //   70	74	166	finally
    //   78	82	166	finally
    //   85	134	166	finally
    //   137	152	166	finally
    //   152	163	166	finally
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield t : Z
    //   6: ifeq -> 28
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'MultiImageComposer'
    //   14: ldc_w 'cancel compose'
    //   17: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield u : Z
    //   25: goto -> 39
    //   28: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   31: ldc 'MultiImageComposer'
    //   33: ldc_w 'cancel compose failed'
    //   36: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	42	finally
    //   28	39	42	finally
  }
  
  public boolean a(List<PLComposeItem> paramList, String paramString1, boolean paramBoolean, String paramString2, PLDisplayMode paramPLDisplayMode, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'MultiImageComposer'
    //   7: ldc_w 'compose +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield t : Z
    //   17: ifeq -> 35
    //   20: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   23: ldc 'MultiImageComposer'
    //   25: ldc_w 'compose already started'
    //   28: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_0
    //   36: aload_1
    //   37: aload #4
    //   39: aload #6
    //   41: aload #7
    //   43: invokespecial a : (Ljava/util/List;Ljava/lang/String;Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;)Z
    //   46: istore #8
    //   48: iload #8
    //   50: ifne -> 57
    //   53: aload_0
    //   54: monitorexit
    //   55: iconst_0
    //   56: ireturn
    //   57: aload_1
    //   58: invokeinterface iterator : ()Ljava/util/Iterator;
    //   63: astore #9
    //   65: aload #9
    //   67: invokeinterface hasNext : ()Z
    //   72: ifeq -> 108
    //   75: aload #9
    //   77: invokeinterface next : ()Ljava/lang/Object;
    //   82: checkcast com/qiniu/pili/droid/shortvideo/PLComposeItem
    //   85: astore #10
    //   87: aload_0
    //   88: aload_0
    //   89: getfield q : J
    //   92: aload #10
    //   94: invokevirtual getDurationMs : ()J
    //   97: ldc2_w 1000
    //   100: lmul
    //   101: ladd
    //   102: putfield q : J
    //   105: goto -> 65
    //   108: aload_0
    //   109: new java/util/LinkedList
    //   112: dup
    //   113: aload_1
    //   114: invokespecial <init> : (Ljava/util/Collection;)V
    //   117: putfield k : Ljava/util/LinkedList;
    //   120: aload_0
    //   121: aload #4
    //   123: putfield l : Ljava/lang/String;
    //   126: aload #7
    //   128: ifnonnull -> 372
    //   131: getstatic com/qiniu/pili/droid/shortvideo/transcoder/a.E : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   134: astore_1
    //   135: goto -> 138
    //   138: aload_0
    //   139: aload_1
    //   140: putfield a : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   143: aload_0
    //   144: aload #6
    //   146: invokevirtual getVideoEncodingWidth : ()I
    //   149: putfield m : I
    //   152: aload_0
    //   153: aload #6
    //   155: invokevirtual getVideoEncodingHeight : ()I
    //   158: putfield n : I
    //   161: aload_0
    //   162: ldc2_w 1000000
    //   165: aload #6
    //   167: invokevirtual getVideoEncodingFps : ()I
    //   170: i2l
    //   171: ldiv
    //   172: putfield o : J
    //   175: aload_0
    //   176: aload #5
    //   178: putfield B : Lcom/qiniu/pili/droid/shortvideo/PLDisplayMode;
    //   181: aload_0
    //   182: aload_2
    //   183: putfield r : Ljava/lang/String;
    //   186: aload_0
    //   187: iload_3
    //   188: putfield s : Z
    //   191: new com/qiniu/pili/droid/shortvideo/f/f
    //   194: dup
    //   195: aload_2
    //   196: iconst_0
    //   197: iconst_1
    //   198: invokespecial <init> : (Ljava/lang/String;ZZ)V
    //   201: astore_2
    //   202: aload_2
    //   203: invokevirtual f : ()Landroid/media/MediaFormat;
    //   206: ifnull -> 315
    //   209: aload_2
    //   210: invokevirtual f : ()Landroid/media/MediaFormat;
    //   213: astore_1
    //   214: new com/qiniu/pili/droid/shortvideo/PLAudioEncodeSetting
    //   217: dup
    //   218: invokespecial <init> : ()V
    //   221: astore #4
    //   223: aload #4
    //   225: aload_2
    //   226: invokevirtual n : ()I
    //   229: invokevirtual setChannels : (I)Lcom/qiniu/pili/droid/shortvideo/PLAudioEncodeSetting;
    //   232: pop
    //   233: aload #4
    //   235: aload_2
    //   236: invokevirtual o : ()I
    //   239: invokevirtual setSampleRate : (I)Lcom/qiniu/pili/droid/shortvideo/PLAudioEncodeSetting;
    //   242: pop
    //   243: aload_0
    //   244: new com/qiniu/pili/droid/shortvideo/encode/c
    //   247: dup
    //   248: aload #4
    //   250: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/PLAudioEncodeSetting;)V
    //   253: putfield f : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   256: aload_0
    //   257: getfield f : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   260: aload_0
    //   261: getfield D : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   264: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/encode/a$a;)V
    //   267: aload_0
    //   268: getfield f : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   271: invokevirtual a : ()Z
    //   274: pop
    //   275: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   278: astore_2
    //   279: new java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial <init> : ()V
    //   286: astore #4
    //   288: aload #4
    //   290: ldc_w 'found audio format: '
    //   293: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload #4
    //   299: aload_1
    //   300: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_2
    //   305: ldc 'MultiImageComposer'
    //   307: aload #4
    //   309: invokevirtual toString : ()Ljava/lang/String;
    //   312: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload_0
    //   316: new com/qiniu/pili/droid/shortvideo/encode/e
    //   319: dup
    //   320: aload #6
    //   322: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;)V
    //   325: putfield e : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   328: aload_0
    //   329: getfield e : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   332: aload_0
    //   333: getfield C : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   336: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/encode/a$a;)V
    //   339: aload_0
    //   340: getfield e : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   343: invokevirtual a : ()Z
    //   346: pop
    //   347: aload_0
    //   348: iconst_1
    //   349: putfield t : Z
    //   352: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   355: ldc 'MultiImageComposer'
    //   357: ldc_w 'compose -'
    //   360: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload_0
    //   364: monitorexit
    //   365: iconst_1
    //   366: ireturn
    //   367: astore_1
    //   368: aload_0
    //   369: monitorexit
    //   370: aload_1
    //   371: athrow
    //   372: aload #7
    //   374: astore_1
    //   375: goto -> 138
    // Exception table:
    //   from	to	target	type
    //   2	31	367	finally
    //   35	48	367	finally
    //   57	65	367	finally
    //   65	105	367	finally
    //   108	126	367	finally
    //   131	135	367	finally
    //   138	315	367	finally
    //   315	363	367	finally
  }
  
  public void run() {
    e.t.c("MultiImageComposer", "run +");
    this.A = new d(null, 1);
    d d1 = this.A;
    Surface surface = this.j;
    int j = 0;
    this.w = new f(d1, surface, false);
    this.w.b();
    this.x = a(this.m, this.n);
    this.y = b(this.m, this.n);
    Iterator<PLComposeItem> iterator = this.k.iterator();
    int i = 0;
    while (iterator.hasNext()) {
      PLComposeItem pLComposeItem = iterator.next();
      if (this.u)
        break; 
      BitmapFactory.Options options = new BitmapFactory.Options();
      options.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(pLComposeItem.getFilePath(), options);
      int k = j;
      if (!j)
        k = options.outWidth; 
      j = i;
      if (!i)
        j = options.outHeight; 
      int m = options.outWidth;
      i = options.outHeight;
      a(pLComposeItem, k, j, m, i);
      j = m;
    } 
    this.w.d();
    this.y.f();
    this.x.f();
    this.A.a();
    this.e.c();
    e.t.c("MultiImageComposer", "run -");
  }
  
  class a implements b.c {
    private a(a this$0) {}
    
    public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
      if (param1Boolean || param1Long2 >= a.d(this.a) || a.i(this.a)) {
        a.g(this.a).c();
        a.j(this.a).c();
        return;
      } 
      a.j(this.a).a(param1ByteBuffer, param1Int, param1Long2);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\transcoder\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */