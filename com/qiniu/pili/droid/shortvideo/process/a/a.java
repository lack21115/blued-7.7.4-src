package com.qiniu.pili.droid.shortvideo.process.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLComposeItem;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFrame;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.encode.e;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.f;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import com.qiniu.pili.droid.shortvideo.gl.c.h;
import com.qiniu.pili.droid.shortvideo.gl.c.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a {
  private volatile long A;
  
  private volatile long B;
  
  private com.qiniu.pili.droid.shortvideo.encode.a.a C = new com.qiniu.pili.droid.shortvideo.encode.a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video encode output format retrieved: ");
        stringBuilder.append(param1MediaFormat);
        e.c("MultiItemComposer", stringBuilder.toString());
        a.a(this.a, param1MediaFormat);
        a.e(this.a);
      }
      
      public void a(Surface param1Surface) {
        e.t.c("MultiItemComposer", "encode surface created");
        a.a(this.a, param1Surface);
      }
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("muxer write video: ");
        stringBuilder.append(param1BufferInfo.presentationTimeUs);
        e.b("MultiItemComposer", stringBuilder.toString());
        if (a.f(this.a) != null) {
          long l;
          a.f(this.a).a(param1ByteBuffer, param1BufferInfo);
          a a1 = this.a;
          if (param1BufferInfo.presentationTimeUs > a.g(this.a)) {
            l = param1BufferInfo.presentationTimeUs;
          } else {
            l = a.g(this.a);
          } 
          a.a(a1, l);
          a.h(this.a);
        } 
      }
      
      public void a(boolean param1Boolean) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video encode started result: ");
        stringBuilder.append(param1Boolean);
        e.c("MultiItemComposer", stringBuilder.toString());
        if (param1Boolean) {
          if (a.a(this.a)) {
            a.b(this.a);
            return;
          } 
          if (a.c(this.a) == null) {
            a.a(this.a, 0, 0, 0, 0, (List)null);
            return;
          } 
        } else {
          a.a(this.a, 6);
        } 
      }
      
      public void b(boolean param1Boolean) {
        e.t.c("MultiItemComposer", "video encode stopped");
        a.d(this.a);
      }
    };
  
  private com.qiniu.pili.droid.shortvideo.encode.a.a D = new com.qiniu.pili.droid.shortvideo.encode.a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("audio encode output format retrieved: ");
        stringBuilder.append(param1MediaFormat);
        e.c("MultiItemComposer", stringBuilder.toString());
        a.b(this.a, param1MediaFormat);
        a.e(this.a);
      }
      
      public void a(Surface param1Surface) {}
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("muxer write audio: ");
        stringBuilder.append(param1BufferInfo.presentationTimeUs);
        e.b("MultiItemComposer", stringBuilder.toString());
        if (a.f(this.a) != null) {
          long l;
          a.f(this.a).b(param1ByteBuffer, param1BufferInfo);
          a a1 = this.a;
          if (param1BufferInfo.presentationTimeUs > a.i(this.a)) {
            l = param1BufferInfo.presentationTimeUs;
          } else {
            l = a.i(this.a);
          } 
          a.b(a1, l);
          a.h(this.a);
        } 
      }
      
      public void a(boolean param1Boolean) {
        if (!param1Boolean)
          a.a(this.a, 7); 
      }
      
      public void b(boolean param1Boolean) {
        e.t.c("MultiItemComposer", "audio encode stopped");
        a.d(this.a);
      }
    };
  
  private com.qiniu.pili.droid.shortvideo.gl.b.a.b E = new com.qiniu.pili.droid.shortvideo.gl.b.a.b(this) {
      volatile h a;
      
      volatile a.b b;
      
      public int a(int param1Int1, int param1Int2, int param1Int3, long param1Long, float[] param1ArrayOffloat) {
        long l1 = param1Long / 1000L;
        long l2 = a.k(this.c);
        PLComposeItem pLComposeItem = a.l(this.c).getFirst();
        l1 = pLComposeItem.getDurationMs() * 1000L - l1 - l2;
        if (l1 < pLComposeItem.getTransitionTimeMs() * 1000L) {
          if (this.a == null) {
            this.b = a.a(this.c, param1Int2, param1Int3);
            this.a = a.a(this.c, pLComposeItem.getTransitionTimeMs(), param1Int2, param1Int3, this.b.b(), this.b.c());
            a.c(this.c).a(a.m(this.c), a.n(this.c));
          } 
          a.o(this.c);
          param1Int3 = this.b.a();
          param1Int2 = param1Int3;
          if (param1Int3 > 0)
            param1Int2 = a.p(this.c).a(this.b.a()); 
          param1Int1 = this.a.a(param1Int1, param1Int2, l1 * 1000L);
        } 
        synchronized (a.q(this.c)) {
          a.a(this.c, true);
          a.q(this.c).notify();
          a.r(this.c).a(param1Long);
          return param1Int1;
        } 
      }
      
      public void a() {
        if (this.a != null) {
          this.a.f();
          this.a = null;
        } 
        if (this.b != null) {
          com.qiniu.pili.droid.shortvideo.c.a.b.a(this.b.a());
          this.b = null;
        } 
      }
      
      public void a(int param1Int1, int param1Int2) {}
      
      public void a(Object param1Object, Surface param1Surface) {
        if (a.a(this.c)) {
          a.j(this.c).a(new a.a());
          a.j(this.c).a(param1Surface);
          a.j(this.c).a();
        } 
      }
      
      public void b() {}
    };
  
  private final PLVideoSaveListener F = new PLVideoSaveListener(this) {
      public void onProgressUpdate(float param1Float) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onProgressUpdate: ");
        stringBuilder.append(param1Float);
        e.c("MultiItemComposer", stringBuilder.toString());
      }
      
      public void onSaveVideoCanceled() {
        e.t.c("MultiItemComposer", "onSaveVideoCanceled");
      }
      
      public void onSaveVideoFailed(int param1Int) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSaveVideoFailed: ");
        stringBuilder.append(param1Int);
        e.c("MultiItemComposer", stringBuilder.toString());
      }
      
      public void onSaveVideoSuccess(String param1String) {
        e e = e.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSaveVideoSuccess: ");
        stringBuilder.append(param1String);
        e.c("MultiItemComposer", stringBuilder.toString());
      }
    };
  
  private boolean a = false;
  
  private final Object b = new Object();
  
  private String c;
  
  private PLVideoSaveListener d;
  
  private PLVideoEncodeSetting e;
  
  private int f;
  
  private int g;
  
  private e h;
  
  private com.qiniu.pili.droid.shortvideo.gl.b.a i;
  
  private com.qiniu.pili.droid.shortvideo.d.b j;
  
  private com.qiniu.pili.droid.shortvideo.muxer.b k;
  
  private int l = 0;
  
  private int m = 0;
  
  private MediaFormat n;
  
  private MediaFormat o;
  
  private volatile Surface p;
  
  private volatile boolean q;
  
  private volatile boolean r;
  
  private volatile int s = -1;
  
  private long t;
  
  private long u = 0L;
  
  private LinkedList<PLComposeItem> v;
  
  private g w;
  
  private l x;
  
  private long y;
  
  private com.qiniu.pili.droid.shortvideo.process.audio.a z;
  
  private int a(f paramf) {
    MediaFormat mediaFormat = paramf.e();
    return mediaFormat.containsKey("rotation-degrees") ? mediaFormat.getInteger("rotation-degrees") : (mediaFormat.containsKey("rotation") ? mediaFormat.getInteger("rotation") : 0);
  }
  
  private h a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    h h = new h(paramLong);
    h.a(this.e.getVideoEncodingWidth(), this.e.getVideoEncodingHeight());
    h.a(paramInt1, paramInt2, paramInt3, paramInt4, PLDisplayMode.FIT);
    return h;
  }
  
  private b a(int paramInt1, int paramInt2) {
    return (this.v.size() <= 1) ? new b(this, 0, paramInt1, paramInt2) : a(this.v.get(1));
  }
  
  private b a(PLComposeItem paramPLComposeItem) {
    return (paramPLComposeItem == null) ? null : ((paramPLComposeItem.getItemType() == PLComposeItem.ItemType.VIDEO) ? b(paramPLComposeItem) : c(paramPLComposeItem));
  }
  
  private List<Long> a(f paramf, long paramLong) {
    List<Long> list2 = paramf.p();
    List<Long> list1 = list2;
    if (paramLong > 0L) {
      list1 = new ArrayList(list2.size());
      int i;
      for (i = 0; i < list2.size(); i++)
        list1.add(Long.valueOf(((Long)list2.get(i)).longValue() + paramLong)); 
    } 
    return list1;
  }
  
  private void a(int paramInt) {
    e e1 = e.t;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("exceptionalStop + ");
    stringBuilder.append(paramInt);
    e1.c("MultiItemComposer", stringBuilder.toString());
    this.s = paramInt;
    a();
    e();
    e1 = e.t;
    stringBuilder = new StringBuilder();
    stringBuilder.append("exceptionalStop - ");
    stringBuilder.append(paramInt);
    e1.c("MultiItemComposer", stringBuilder.toString());
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<Long> paramList) {
    this.i = new com.qiniu.pili.droid.shortvideo.gl.b.a(this.p, paramInt1, paramInt2, paramInt3, this.e.getVideoEncodingWidth(), this.e.getVideoEncodingHeight(), paramList);
    this.i.a(this.E);
    this.i.a(new com.qiniu.pili.droid.shortvideo.gl.b.a.a(this) {
          public void a() {
            if (!a.a(this.a))
              a.b(this.a); 
          }
        });
    this.i.b(paramInt4);
    this.i.a(PLDisplayMode.FIT);
    this.i.a();
  }
  
  private boolean a(String paramString) {
    if (paramString == null) {
      e.t.e("MultiItemComposer", "dest video path is wrong!");
      return false;
    } 
    File file = (new File(paramString)).getParentFile();
    if (!file.exists() && !file.mkdir()) {
      e e1 = e.t;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("failed to mkdir: ");
      stringBuilder.append(file.getAbsolutePath());
      e1.e("MultiItemComposer", stringBuilder.toString());
      return false;
    } 
    return true;
  }
  
  private boolean a(List<PLComposeItem> paramList, String paramString, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    PLVideoSaveListener pLVideoSaveListener = paramPLVideoSaveListener;
    if (paramPLVideoSaveListener == null)
      pLVideoSaveListener = this.F; 
    if (paramList == null || paramList.isEmpty() || paramString == null || paramPLVideoEncodeSetting == null) {
      e.t.e("MultiItemComposer", "compose: invalid params !");
      pLVideoSaveListener.onSaveVideoFailed(10);
      return false;
    } 
    if (!a(paramString)) {
      e.t.e("MultiItemComposer", "compose: destVideoPath is wrong!");
      return false;
    } 
    if (paramList.size() == 1) {
      e.t.d("MultiItemComposer", "compose: only one src videos, ignore !");
      pLVideoSaveListener.onSaveVideoFailed(10);
      return false;
    } 
    Iterator<PLComposeItem> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      if (((PLComposeItem)iterator.next()).getFilePath().equals(paramString)) {
        e.t.e("MultiItemComposer", "compose failed, the dest video path must be different with src videos !");
        pLVideoSaveListener.onSaveVideoFailed(10);
        return false;
      } 
    } 
    return true;
  }
  
  private int b(f paramf) {
    MediaFormat mediaFormat = paramf.e();
    return (!mediaFormat.containsKey("rotation-degrees") && !mediaFormat.containsKey("rotation")) ? paramf.m() : 0;
  }
  
  private g b(int paramInt1, int paramInt2) {
    g g1 = new g();
    g1.a(paramInt1, paramInt2);
    g1.b();
    return g1;
  }
  
  private b b(PLComposeItem paramPLComposeItem) {
    f f = new f(paramPLComposeItem.getFilePath());
    PLVideoFrame pLVideoFrame = f.a(0L, true);
    f.a();
    return new b(this, d.a(pLVideoFrame.toBitmap()), pLVideoFrame.getWidth(), pLVideoFrame.getHeight());
  }
  
  private void b() {
    if (this.x == null)
      this.x = c(this.f, this.g); 
    if (this.w == null)
      this.w = b(this.f, this.g); 
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<Long> paramList) {
    com.qiniu.pili.droid.shortvideo.gl.b.a.b b1 = this.E;
    if (b1 != null)
      b1.a(); 
    this.i.b(paramInt4);
    this.i.a(paramInt1, paramInt2, paramInt3, paramList);
  }
  
  private void b(String paramString) {
    f f = new f(paramString, true, false);
    this.j = new com.qiniu.pili.droid.shortvideo.d.b(f.c(), f.e());
    int i = a(f);
    int j = b(f);
    List<Long> list = a(f, this.t);
    if (this.i == null) {
      a(f.h(), f.i(), i, j, list);
      return;
    } 
    b(f.h(), f.i(), i, j, list);
  }
  
  private l c(int paramInt1, int paramInt2) {
    l l1 = new l();
    l1.a(paramInt1, paramInt2);
    l1.b();
    return l1;
  }
  
  private b c(PLComposeItem paramPLComposeItem) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramPLComposeItem.getFilePath(), options);
    int i = options.outWidth;
    int j = options.outHeight;
    return new b(this, com.qiniu.pili.droid.shortvideo.c.a.b.a(paramPLComposeItem.getFilePath(), this.f, this.g), i, j);
  }
  
  private void c() {
    this.v.poll();
    if (!this.v.isEmpty()) {
      i();
      return;
    } 
    this.h.c();
  }
  
  private void d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'MultiItemComposer'
    //   7: ldc_w 'startMuxer +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: aload_0
    //   15: getfield l : I
    //   18: iconst_1
    //   19: iadd
    //   20: putfield l : I
    //   23: aload_0
    //   24: getfield z : Lcom/qiniu/pili/droid/shortvideo/process/audio/a;
    //   27: invokevirtual d : ()Z
    //   30: ifeq -> 67
    //   33: aload_0
    //   34: getfield l : I
    //   37: iconst_2
    //   38: if_icmpge -> 67
    //   41: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   44: ldc 'MultiItemComposer'
    //   46: ldc_w 'not ready to start muxer.'
    //   49: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: invokevirtual wait : ()V
    //   56: goto -> 64
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual printStackTrace : ()V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: new com/qiniu/pili/droid/shortvideo/muxer/b
    //   71: dup
    //   72: invokespecial <init> : ()V
    //   75: putfield k : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   78: aload_0
    //   79: getfield k : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   82: aload_0
    //   83: getfield c : Ljava/lang/String;
    //   86: aload_0
    //   87: getfield n : Landroid/media/MediaFormat;
    //   90: aload_0
    //   91: getfield o : Landroid/media/MediaFormat;
    //   94: iconst_0
    //   95: invokevirtual a : (Ljava/lang/String;Landroid/media/MediaFormat;Landroid/media/MediaFormat;I)Z
    //   98: ifne -> 119
    //   101: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   104: ldc 'MultiItemComposer'
    //   106: ldc_w 'start muxer failed!'
    //   109: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_0
    //   113: invokevirtual a : ()V
    //   116: goto -> 134
    //   119: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   122: ldc 'MultiItemComposer'
    //   124: ldc_w 'start muxer success!'
    //   127: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: invokevirtual notify : ()V
    //   134: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   137: ldc 'MultiItemComposer'
    //   139: ldc_w 'startMuxer -'
    //   142: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: monitorexit
    //   147: return
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    // Exception table:
    //   from	to	target	type
    //   2	52	148	finally
    //   52	56	59	java/lang/InterruptedException
    //   52	56	148	finally
    //   60	64	148	finally
    //   67	116	148	finally
    //   119	134	148	finally
    //   134	145	148	finally
  }
  
  private void d(PLComposeItem paramPLComposeItem) {
    b b1 = a(paramPLComposeItem);
    b b2 = a(b1.b(), b1.c());
    h h = a(paramPLComposeItem.getTransitionTimeMs(), b1.b(), b1.c(), b2.b(), b2.c());
    b();
    long l2 = paramPLComposeItem.getDurationMs() * 1000L;
    long l1 = 0L;
    while (l1 <= l2 && !this.q) {
      int i = h.a(b1.a(), b2.a(), (l2 - l1) * 1000L);
      i = this.x.a(i);
      synchronized (d.a) {
        GLES20.glClear(16384);
        this.w.b(i);
        this.i.a(this.t * 1000L);
        this.h.a(this.t * 1000L);
        long l3 = this.y;
        l1 += l3;
        this.t += l3;
      } 
    } 
    com.qiniu.pili.droid.shortvideo.c.a.b.a(b1.a());
    com.qiniu.pili.droid.shortvideo.c.a.b.a(b2.a());
    h.f();
    c();
  }
  
  private void e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'MultiItemComposer'
    //   7: ldc_w 'stopMuxer +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield m : I
    //   17: istore_2
    //   18: iconst_1
    //   19: istore_1
    //   20: aload_0
    //   21: iload_2
    //   22: iconst_1
    //   23: iadd
    //   24: putfield m : I
    //   27: aload_0
    //   28: getfield z : Lcom/qiniu/pili/droid/shortvideo/process/audio/a;
    //   31: invokevirtual d : ()Z
    //   34: ifeq -> 59
    //   37: aload_0
    //   38: getfield m : I
    //   41: iconst_2
    //   42: if_icmpge -> 59
    //   45: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   48: ldc 'MultiItemComposer'
    //   50: ldc_w 'not ready to stop muxer.'
    //   53: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: aload_0
    //   60: getfield k : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   63: ifnull -> 404
    //   66: aload_0
    //   67: getfield k : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   70: invokevirtual a : ()Z
    //   73: ifeq -> 404
    //   76: goto -> 79
    //   79: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   82: astore #4
    //   84: new java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial <init> : ()V
    //   91: astore #5
    //   93: aload #5
    //   95: ldc_w 'stop muxer '
    //   98: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: iload_1
    //   103: ifeq -> 409
    //   106: ldc_w 'success'
    //   109: astore_3
    //   110: goto -> 113
    //   113: aload #5
    //   115: aload_3
    //   116: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload #4
    //   122: ldc 'MultiItemComposer'
    //   124: aload #5
    //   126: invokevirtual toString : ()Ljava/lang/String;
    //   129: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: getfield z : Lcom/qiniu/pili/droid/shortvideo/process/audio/a;
    //   136: invokevirtual c : ()V
    //   139: aload_0
    //   140: aconst_null
    //   141: putfield k : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   144: aload_0
    //   145: aconst_null
    //   146: putfield h : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   149: aload_0
    //   150: aconst_null
    //   151: putfield v : Ljava/util/LinkedList;
    //   154: aload_0
    //   155: aconst_null
    //   156: putfield n : Landroid/media/MediaFormat;
    //   159: aload_0
    //   160: aconst_null
    //   161: putfield o : Landroid/media/MediaFormat;
    //   164: aload_0
    //   165: aconst_null
    //   166: putfield j : Lcom/qiniu/pili/droid/shortvideo/d/b;
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield p : Landroid/view/Surface;
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield i : Lcom/qiniu/pili/droid/shortvideo/gl/b/a;
    //   179: aload_0
    //   180: iconst_0
    //   181: putfield l : I
    //   184: aload_0
    //   185: iconst_0
    //   186: putfield m : I
    //   189: aload_0
    //   190: lconst_0
    //   191: putfield t : J
    //   194: aload_0
    //   195: lconst_0
    //   196: putfield u : J
    //   199: aload_0
    //   200: iconst_0
    //   201: putfield r : Z
    //   204: aload_0
    //   205: lconst_0
    //   206: putfield A : J
    //   209: aload_0
    //   210: lconst_0
    //   211: putfield B : J
    //   214: aload_0
    //   215: getfield w : Lcom/qiniu/pili/droid/shortvideo/gl/c/g;
    //   218: ifnull -> 233
    //   221: aload_0
    //   222: getfield w : Lcom/qiniu/pili/droid/shortvideo/gl/c/g;
    //   225: invokevirtual f : ()V
    //   228: aload_0
    //   229: aconst_null
    //   230: putfield w : Lcom/qiniu/pili/droid/shortvideo/gl/c/g;
    //   233: aload_0
    //   234: getfield x : Lcom/qiniu/pili/droid/shortvideo/gl/c/l;
    //   237: ifnull -> 252
    //   240: aload_0
    //   241: getfield x : Lcom/qiniu/pili/droid/shortvideo/gl/c/l;
    //   244: invokevirtual f : ()V
    //   247: aload_0
    //   248: aconst_null
    //   249: putfield x : Lcom/qiniu/pili/droid/shortvideo/gl/c/l;
    //   252: aload_0
    //   253: getfield E : Lcom/qiniu/pili/droid/shortvideo/gl/b/a$b;
    //   256: invokeinterface a : ()V
    //   261: aload_0
    //   262: getfield q : Z
    //   265: ifeq -> 330
    //   268: aload_0
    //   269: iconst_0
    //   270: putfield q : Z
    //   273: new java/io/File
    //   276: dup
    //   277: aload_0
    //   278: getfield c : Ljava/lang/String;
    //   281: invokespecial <init> : (Ljava/lang/String;)V
    //   284: invokevirtual delete : ()Z
    //   287: pop
    //   288: aload_0
    //   289: invokespecial f : ()Z
    //   292: ifeq -> 318
    //   295: aload_0
    //   296: getfield s : I
    //   299: istore_1
    //   300: aload_0
    //   301: iconst_m1
    //   302: putfield s : I
    //   305: aload_0
    //   306: getfield d : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   309: iload_1
    //   310: invokeinterface onSaveVideoFailed : (I)V
    //   315: goto -> 385
    //   318: aload_0
    //   319: getfield d : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   322: invokeinterface onSaveVideoCanceled : ()V
    //   327: goto -> 385
    //   330: iload_1
    //   331: ifeq -> 360
    //   334: aload_0
    //   335: getfield d : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   338: fconst_1
    //   339: invokeinterface onProgressUpdate : (F)V
    //   344: aload_0
    //   345: getfield d : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   348: aload_0
    //   349: getfield c : Ljava/lang/String;
    //   352: invokeinterface onSaveVideoSuccess : (Ljava/lang/String;)V
    //   357: goto -> 385
    //   360: new java/io/File
    //   363: dup
    //   364: aload_0
    //   365: getfield c : Ljava/lang/String;
    //   368: invokespecial <init> : (Ljava/lang/String;)V
    //   371: invokevirtual delete : ()Z
    //   374: pop
    //   375: aload_0
    //   376: getfield d : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   379: iconst_3
    //   380: invokeinterface onSaveVideoFailed : (I)V
    //   385: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   388: ldc 'MultiItemComposer'
    //   390: ldc_w 'stopMuxer -'
    //   393: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload_0
    //   397: monitorexit
    //   398: return
    //   399: astore_3
    //   400: aload_0
    //   401: monitorexit
    //   402: aload_3
    //   403: athrow
    //   404: iconst_0
    //   405: istore_1
    //   406: goto -> 79
    //   409: ldc_w 'fail'
    //   412: astore_3
    //   413: goto -> 113
    // Exception table:
    //   from	to	target	type
    //   2	18	399	finally
    //   20	56	399	finally
    //   59	76	399	finally
    //   79	102	399	finally
    //   113	233	399	finally
    //   233	252	399	finally
    //   252	315	399	finally
    //   318	327	399	finally
    //   334	357	399	finally
    //   360	385	399	finally
    //   385	396	399	finally
  }
  
  private void e(PLComposeItem paramPLComposeItem) {
    b b1 = a(paramPLComposeItem);
    b b2 = a(b1.b(), b1.c());
    h h = a(paramPLComposeItem.getTransitionTimeMs(), b1.b(), b1.c(), b2.b(), b2.c());
    b();
    com.qiniu.pili.droid.shortvideo.b.a a1 = new com.qiniu.pili.droid.shortvideo.b.a();
    File file = new File(paramPLComposeItem.getFilePath());
    if (!file.exists())
      return; 
    try {
      FileInputStream fileInputStream = new FileInputStream(file);
      if (a1.a(fileInputStream, 0) == 0) {
        long l2 = 0L;
        long l1 = paramPLComposeItem.getDurationMs() * 1000L;
        a1.a();
        long l3 = (a1.a(a1.d()) * 1000);
        Bitmap bitmap = Bitmap.createBitmap(a1.e());
        int i = d.a(bitmap);
        while (l2 <= l1 && !this.q) {
          long l4 = l3;
          int j = i;
          if (l2 >= l3) {
            a1.a();
            l4 = l3 + (a1.a(a1.d()) * 1000);
            bitmap = Bitmap.createBitmap(a1.e());
            com.qiniu.pili.droid.shortvideo.c.a.b.a(i);
            j = d.a(bitmap);
            bitmap.recycle();
          } 
          i = h.a(j, b2.a(), (l1 - l2) * 1000L);
          i = this.x.a(i);
          synchronized (d.a) {
            GLES20.glClear(16384);
            this.w.b(i);
            this.i.a(this.t * 1000L);
            this.h.a(this.t * 1000L);
            l3 = this.y;
            l2 += l3;
            this.t += l3;
            l3 = l4;
            i = j;
          } 
        } 
        com.qiniu.pili.droid.shortvideo.c.a.b.a(i);
        com.qiniu.pili.droid.shortvideo.c.a.b.a(b1.a());
        com.qiniu.pili.droid.shortvideo.c.a.b.a(b2.a());
        bitmap.recycle();
        h.f();
        c();
      } 
      return;
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
      return;
    } 
  }
  
  private boolean f() {
    return (this.s >= 0);
  }
  
  private boolean g() {
    return (((PLComposeItem)this.v.getFirst()).getItemType() == PLComposeItem.ItemType.VIDEO);
  }
  
  private void h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield B : J
    //   6: aload_0
    //   7: getfield A : J
    //   10: ladd
    //   11: l2f
    //   12: aload_0
    //   13: getfield u : J
    //   16: l2f
    //   17: fdiv
    //   18: fstore_1
    //   19: aload_0
    //   20: getfield d : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   23: fload_1
    //   24: invokeinterface onProgressUpdate : (F)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	32	finally
  }
  
  private void i() {
    PLComposeItem pLComposeItem = this.v.getFirst();
    if (pLComposeItem.getItemType() == PLComposeItem.ItemType.VIDEO) {
      b(pLComposeItem.getFilePath());
      return;
    } 
    if (pLComposeItem.getItemType() == PLComposeItem.ItemType.IMAGE) {
      this.i.a(new Runnable(this, pLComposeItem) {
            public void run() {
              a.a(this.b, this.a);
            }
          });
      return;
    } 
    if (pLComposeItem.getItemType() == PLComposeItem.ItemType.GIF)
      this.i.a(new Runnable(this, pLComposeItem) {
            public void run() {
              a.b(this.b, this.a);
            }
          }); 
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield r : Z
    //   6: ifeq -> 35
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield q : Z
    //   14: aload_0
    //   15: getfield z : Lcom/qiniu/pili/droid/shortvideo/process/audio/a;
    //   18: invokevirtual b : ()V
    //   21: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   24: ldc 'MultiItemComposer'
    //   26: ldc_w 'cancel compose'
    //   29: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   32: goto -> 46
    //   35: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   38: ldc 'MultiItemComposer'
    //   40: ldc_w 'cancel compose failed'
    //   43: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	49	finally
    //   35	46	49	finally
  }
  
  public boolean a(List<PLComposeItem> paramList, String paramString1, PLVideoEncodeSetting paramPLVideoEncodeSetting, String paramString2, float paramFloat1, float paramFloat2, PLVideoSaveListener paramPLVideoSaveListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'MultiItemComposer'
    //   7: ldc_w 'compose +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield r : Z
    //   17: ifeq -> 35
    //   20: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   23: ldc 'MultiItemComposer'
    //   25: ldc_w 'compose already started'
    //   28: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_0
    //   36: aload_1
    //   37: aload_2
    //   38: aload_3
    //   39: aload #7
    //   41: invokespecial a : (Ljava/util/List;Ljava/lang/String;Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;)Z
    //   44: istore #8
    //   46: iload #8
    //   48: ifne -> 55
    //   51: aload_0
    //   52: monitorexit
    //   53: iconst_0
    //   54: ireturn
    //   55: aload_1
    //   56: invokeinterface iterator : ()Ljava/util/Iterator;
    //   61: astore #9
    //   63: aload #9
    //   65: invokeinterface hasNext : ()Z
    //   70: ifeq -> 106
    //   73: aload #9
    //   75: invokeinterface next : ()Ljava/lang/Object;
    //   80: checkcast com/qiniu/pili/droid/shortvideo/PLComposeItem
    //   83: astore #10
    //   85: aload_0
    //   86: aload_0
    //   87: getfield u : J
    //   90: aload #10
    //   92: invokevirtual getDurationMs : ()J
    //   95: ldc2_w 1000
    //   98: lmul
    //   99: ladd
    //   100: putfield u : J
    //   103: goto -> 63
    //   106: aload_0
    //   107: new java/util/LinkedList
    //   110: dup
    //   111: aload_1
    //   112: invokespecial <init> : (Ljava/util/Collection;)V
    //   115: putfield v : Ljava/util/LinkedList;
    //   118: aload_0
    //   119: aload_2
    //   120: putfield c : Ljava/lang/String;
    //   123: aload #7
    //   125: astore_2
    //   126: aload #7
    //   128: ifnonnull -> 136
    //   131: aload_0
    //   132: getfield F : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   135: astore_2
    //   136: aload_0
    //   137: aload_2
    //   138: putfield d : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   141: aload_0
    //   142: aload_3
    //   143: putfield e : Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;
    //   146: aload_0
    //   147: aload_0
    //   148: getfield e : Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;
    //   151: invokevirtual getVideoEncodingWidth : ()I
    //   154: putfield f : I
    //   157: aload_0
    //   158: aload_0
    //   159: getfield e : Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;
    //   162: invokevirtual getVideoEncodingHeight : ()I
    //   165: putfield g : I
    //   168: aload_0
    //   169: ldc2_w 1000000
    //   172: aload_3
    //   173: invokevirtual getVideoEncodingFps : ()I
    //   176: i2l
    //   177: ldiv
    //   178: putfield y : J
    //   181: aload_0
    //   182: new com/qiniu/pili/droid/shortvideo/encode/e
    //   185: dup
    //   186: aload_3
    //   187: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;)V
    //   190: putfield h : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   193: aload_0
    //   194: getfield h : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   197: aload_0
    //   198: getfield C : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   201: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/encode/a$a;)V
    //   204: aload_0
    //   205: getfield h : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   208: invokevirtual a : ()Z
    //   211: pop
    //   212: aload_0
    //   213: new com/qiniu/pili/droid/shortvideo/process/audio/a
    //   216: dup
    //   217: aload_1
    //   218: invokespecial <init> : (Ljava/util/List;)V
    //   221: putfield z : Lcom/qiniu/pili/droid/shortvideo/process/audio/a;
    //   224: aload_0
    //   225: getfield z : Lcom/qiniu/pili/droid/shortvideo/process/audio/a;
    //   228: aload_0
    //   229: getfield D : Lcom/qiniu/pili/droid/shortvideo/encode/a$a;
    //   232: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/encode/a$a;)V
    //   235: aload_0
    //   236: getfield z : Lcom/qiniu/pili/droid/shortvideo/process/audio/a;
    //   239: aload #4
    //   241: invokevirtual a : (Ljava/lang/String;)V
    //   244: aload_0
    //   245: getfield z : Lcom/qiniu/pili/droid/shortvideo/process/audio/a;
    //   248: fload #5
    //   250: fload #6
    //   252: invokevirtual a : (FF)V
    //   255: aload_0
    //   256: getfield z : Lcom/qiniu/pili/droid/shortvideo/process/audio/a;
    //   259: invokevirtual a : ()Z
    //   262: ifeq -> 277
    //   265: aload_0
    //   266: aload_0
    //   267: getfield u : J
    //   270: ldc2_w 2
    //   273: lmul
    //   274: putfield u : J
    //   277: aload_0
    //   278: iconst_1
    //   279: putfield r : Z
    //   282: getstatic com/qiniu/pili/droid/shortvideo/f/e.t : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   285: ldc 'MultiItemComposer'
    //   287: ldc_w 'compose -'
    //   290: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_0
    //   294: monitorexit
    //   295: iconst_1
    //   296: ireturn
    //   297: astore_1
    //   298: aload_0
    //   299: monitorexit
    //   300: aload_1
    //   301: athrow
    // Exception table:
    //   from	to	target	type
    //   2	31	297	finally
    //   35	46	297	finally
    //   55	63	297	finally
    //   63	103	297	finally
    //   106	123	297	finally
    //   131	136	297	finally
    //   136	277	297	finally
    //   277	293	297	finally
  }
  
  class a implements com.qiniu.pili.droid.shortvideo.d.b.c {
    private long b;
    
    private a(a this$0) {}
    
    public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
      if (param1Boolean) {
        a a1 = this.a;
        a.c(a1, a.k(a1) + this.b + (1000000 / a.s(this.a).getVideoEncodingFps()));
        a.t(this.a);
        return;
      } 
      this.b = param1Long1;
      synchronized (a.q(this.a)) {
        while (true) {
          param1Boolean = a.u(this.a);
          if (!param1Boolean) {
            try {
              a.q(this.a).wait();
            } catch (InterruptedException interruptedException) {
              interruptedException.printStackTrace();
            } 
            continue;
          } 
          a.a(this.a, false);
          if (a.v(this.a)) {
            e.t.c("MultiItemComposer", "cancel marked, stop video things now.");
            a.j(this.a).c();
            a.c(this.a).b();
            a.r(this.a).c();
          } 
          return;
        } 
      } 
    }
  }
  
  class b {
    private int b;
    
    private int c;
    
    private int d;
    
    public b(a this$0, int param1Int1, int param1Int2, int param1Int3) {
      this.b = param1Int1;
      this.c = param1Int2;
      this.d = param1Int3;
    }
    
    public int a() {
      return this.b;
    }
    
    public int b() {
      return this.c;
    }
    
    public int c() {
      return this.d;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\process\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */