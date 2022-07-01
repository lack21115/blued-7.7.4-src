package com.qiniu.pili.droid.shortvideo.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLMixAudioFile;
import com.qiniu.pili.droid.shortvideo.PLSpeedTimeRange;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.PLWatermarkSetting;
import com.qiniu.pili.droid.shortvideo.encode.e;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.g;
import com.qiniu.pili.droid.shortvideo.f.j;
import com.qiniu.pili.droid.shortvideo.gl.c.d;
import com.qiniu.pili.droid.shortvideo.process.audio.MultiAudioMixer;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.AudioMixer;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class q {
  private volatile boolean A;
  
  private com.qiniu.pili.droid.shortvideo.muxer.b B;
  
  private int C = 0;
  
  private int D = 0;
  
  private int E;
  
  private PLVideoEncodeSetting F;
  
  private com.qiniu.pili.droid.shortvideo.gl.b.a G;
  
  private volatile boolean H;
  
  private int I;
  
  private int J;
  
  private int K;
  
  private com.qiniu.pili.droid.shortvideo.transcoder.audio.a L;
  
  private PLVideoSaveListener M;
  
  private PLVideoFilterListener N;
  
  private volatile boolean O;
  
  private volatile boolean P;
  
  private volatile int Q = -1;
  
  private long R;
  
  private long S;
  
  private long T;
  
  private volatile boolean U;
  
  private int V;
  
  private int W;
  
  private int X;
  
  private int Y;
  
  private int Z;
  
  private Context a;
  
  private com.qiniu.pili.droid.shortvideo.gl.b.a.b aA = new com.qiniu.pili.droid.shortvideo.gl.b.a.b(this) {
      private void c() {
        synchronized (q.aa(this.a)) {
          while (true) {
            boolean bool = q.ab(this.a);
            if (!bool) {
              try {
                q.aa(this.a).wait();
              } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
              } 
              continue;
            } 
            q.b(this.a, false);
            if (q.ac(this.a) > 0) {
              q.u(this.a).d(q.ac(this.a));
              q.b(this.a, 0);
            } 
            return;
          } 
        } 
      }
      
      private void d() {
        synchronized (q.ad(this.a)) {
          q.c(this.a, true);
          q.ad(this.a).notify();
          return;
        } 
      }
      
      public int a(int param1Int1, int param1Int2, int param1Int3, long param1Long, float[] param1ArrayOffloat) {
        if (q.d(this.a))
          c(); 
        d();
        e e = e.s;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("rendered video frame count: ");
        stringBuilder.append(q.ae(this.a));
        stringBuilder.append(" timestampNs ");
        stringBuilder.append(param1Long);
        e.b("ShortVideoTranscoderCore", stringBuilder.toString());
        if (!q.af(this.a))
          q.s(this.a).a(param1Long); 
        int i = param1Int1;
        if (q.Y(this.a) != null) {
          int j = q.Y(this.a).onDrawFrame(param1Int1, param1Int2, param1Int3, param1Long, param1ArrayOffloat);
          i = param1Int1;
          if (j > 0)
            i = j; 
        } 
        param1Int1 = i;
        if (q.ag(this.a) != null) {
          if (q.Z(this.a) == null) {
            q q1 = this.a;
            q.a(q1, q.a(q1, q.ag(q1), param1Int2, param1Int3));
          } 
          param1Int1 = q.Z(this.a).a(i);
        } 
        return param1Int1;
      }
      
      public void a() {
        if (q.Y(this.a) != null)
          q.Y(this.a).onSurfaceDestroy(); 
        if (q.Z(this.a) != null) {
          q.Z(this.a).f();
          q.a(this.a, (d)null);
        } 
      }
      
      public void a(int param1Int1, int param1Int2) {
        e e = e.s;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("surface changed width: ");
        stringBuilder.append(param1Int1);
        stringBuilder.append(" height: ");
        stringBuilder.append(param1Int2);
        e.c("ShortVideoTranscoderCore", stringBuilder.toString());
        if (q.Y(this.a) != null)
          q.Y(this.a).onSurfaceChanged(param1Int1, param1Int2); 
      }
      
      public void a(Object param1Object, Surface param1Surface) {
        if (q.T(this.a)) {
          param1Object = this.a;
          q.a((q)param1Object, (com.qiniu.pili.droid.shortvideo.d.b)new com.qiniu.pili.droid.shortvideo.d.a(q.a((q)param1Object), q.b(this.a)));
        } else {
          param1Object = this.a;
          q.a((q)param1Object, new com.qiniu.pili.droid.shortvideo.d.b(q.a((q)param1Object), q.b(this.a)));
        } 
        q.U(this.a).a(param1Surface);
        q.U(this.a).a(q.V(this.a));
        q.U(this.a).a(q.W(this.a));
        if (q.d(this.a))
          q.U(this.a).a(q.X(this.a)); 
        q.U(this.a).a(q.c(this.a), q.w(this.a), q.d(this.a));
        if (q.Y(this.a) != null)
          q.Y(this.a).onSurfaceCreated(); 
      }
      
      public void b() {
        d();
      }
    };
  
  private com.qiniu.pili.droid.shortvideo.d.b.c aB = new com.qiniu.pili.droid.shortvideo.d.b.c(this) {
      public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
        // Byte code:
        //   0: iload #7
        //   2: ifeq -> 29
        //   5: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
        //   8: ldc 'ShortVideoTranscoderCore'
        //   10: ldc 'received eos frame, mark video encoder to stop.'
        //   12: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
        //   15: aload_0
        //   16: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
        //   19: invokestatic s : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Lcom/qiniu/pili/droid/shortvideo/encode/e;
        //   22: invokevirtual c : ()Z
        //   25: pop
        //   26: goto -> 182
        //   29: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
        //   32: astore_1
        //   33: new java/lang/StringBuilder
        //   36: dup
        //   37: invokespecial <init> : ()V
        //   40: astore #8
        //   42: aload #8
        //   44: ldc 'extracted video frame count: '
        //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   49: pop
        //   50: aload #8
        //   52: aload_0
        //   53: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
        //   56: invokestatic ah : (Lcom/qiniu/pili/droid/shortvideo/core/q;)I
        //   59: invokevirtual append : (I)Ljava/lang/StringBuilder;
        //   62: pop
        //   63: aload #8
        //   65: ldc ' timestampUs '
        //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   70: pop
        //   71: aload #8
        //   73: lload_3
        //   74: invokevirtual append : (J)Ljava/lang/StringBuilder;
        //   77: pop
        //   78: aload_1
        //   79: ldc 'ShortVideoTranscoderCore'
        //   81: aload #8
        //   83: invokevirtual toString : ()Ljava/lang/String;
        //   86: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
        //   89: aload_0
        //   90: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
        //   93: invokestatic ad : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Ljava/lang/Object;
        //   96: astore_1
        //   97: aload_1
        //   98: monitorenter
        //   99: aload_0
        //   100: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
        //   103: invokestatic ai : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Z
        //   106: istore #7
        //   108: iload #7
        //   110: ifne -> 136
        //   113: aload_0
        //   114: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
        //   117: invokestatic ad : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Ljava/lang/Object;
        //   120: invokevirtual wait : ()V
        //   123: goto -> 99
        //   126: astore #8
        //   128: aload #8
        //   130: invokevirtual printStackTrace : ()V
        //   133: goto -> 99
        //   136: aload_0
        //   137: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
        //   140: iconst_0
        //   141: invokestatic c : (Lcom/qiniu/pili/droid/shortvideo/core/q;Z)Z
        //   144: pop
        //   145: aload_1
        //   146: monitorexit
        //   147: aload_0
        //   148: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
        //   151: invokestatic d : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Z
        //   154: ifeq -> 182
        //   157: aload_0
        //   158: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
        //   161: invokestatic P : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
        //   164: lload_3
        //   165: l2f
        //   166: fconst_1
        //   167: fmul
        //   168: aload_0
        //   169: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
        //   172: invokestatic O : (Lcom/qiniu/pili/droid/shortvideo/core/q;)J
        //   175: l2f
        //   176: fdiv
        //   177: invokeinterface onProgressUpdate : (F)V
        //   182: aload_0
        //   183: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
        //   186: invokestatic d : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Z
        //   189: ifeq -> 233
        //   192: aload_0
        //   193: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
        //   196: invokestatic aj : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Z
        //   199: ifeq -> 233
        //   202: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
        //   205: ldc 'ShortVideoTranscoderCore'
        //   207: ldc 'low memory to reverse, process has been canceled !'
        //   209: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
        //   212: aload_0
        //   213: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
        //   216: invokestatic P : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
        //   219: bipush #15
        //   221: invokeinterface onSaveVideoFailed : (I)V
        //   226: aload_0
        //   227: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
        //   230: invokevirtual a : ()V
        //   233: aload_0
        //   234: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
        //   237: invokestatic ak : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Z
        //   240: ifeq -> 260
        //   243: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
        //   246: ldc 'ShortVideoTranscoderCore'
        //   248: ldc 'received cancel, mark video encoder to stop.'
        //   250: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
        //   253: aload_0
        //   254: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
        //   257: invokestatic al : (Lcom/qiniu/pili/droid/shortvideo/core/q;)V
        //   260: return
        //   261: astore #8
        //   263: aload_1
        //   264: monitorexit
        //   265: aload #8
        //   267: athrow
        // Exception table:
        //   from	to	target	type
        //   99	108	261	finally
        //   113	123	126	java/lang/InterruptedException
        //   113	123	261	finally
        //   128	133	261	finally
        //   136	147	261	finally
        //   263	265	261	finally
      }
    };
  
  private com.qiniu.pili.droid.shortvideo.d.b.a aC = new com.qiniu.pili.droid.shortvideo.d.b.a(this) {
      public void a(int param1Int) {
        if (param1Int != 16) {
          if (param1Int != 20) {
            q.a(this.a, param1Int, true);
            return;
          } 
          e.s.d("ShortVideoTranscoderCore", "decode exception!");
          q.a(this.a, param1Int, false);
          return;
        } 
        e.s.d("ShortVideoTranscoderCore", "not support multiple media codec!");
        q.f(this.a, true);
        this.a.a();
        q.al(this.a);
      }
    };
  
  private com.qiniu.pili.droid.shortvideo.d.b.e aD = new com.qiniu.pili.droid.shortvideo.d.b.e(this) {
      public void a(int param1Int) {
        synchronized (q.aa(this.a)) {
          q.b(this.a, param1Int);
          q.b(this.a, true);
          q.aa(this.a).notify();
          return;
        } 
      }
    };
  
  private final PLVideoSaveListener aE = new PLVideoSaveListener(this) {
      public void onProgressUpdate(float param1Float) {
        e e = e.s;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onProgressUpdate: ");
        stringBuilder.append(param1Float);
        e.c("ShortVideoTranscoderCore", stringBuilder.toString());
      }
      
      public void onSaveVideoCanceled() {
        e.s.c("ShortVideoTranscoderCore", "onSaveVideoCanceled");
      }
      
      public void onSaveVideoFailed(int param1Int) {
        e e = e.s;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSaveVideoFailed: ");
        stringBuilder.append(param1Int);
        e.c("ShortVideoTranscoderCore", stringBuilder.toString());
      }
      
      public void onSaveVideoSuccess(String param1String) {
        e e = e.s;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSaveVideoSuccess: ");
        stringBuilder.append(param1String);
        e.c("ShortVideoTranscoderCore", stringBuilder.toString());
      }
    };
  
  private double aa = 1.0D;
  
  private a ab;
  
  private ArrayList<PLSpeedTimeRange> ac;
  
  private volatile int ad;
  
  private boolean ae;
  
  private int af;
  
  private AudioMixer ag;
  
  private ByteBuffer ah;
  
  private int ai;
  
  private boolean aj;
  
  private Object ak = new Object();
  
  private boolean al;
  
  private Object am = new Object();
  
  private List<PLMixAudioFile> an;
  
  private MultiAudioMixer ao;
  
  private volatile long ap;
  
  private volatile long aq;
  
  private int ar;
  
  private int as;
  
  private int at;
  
  private int au;
  
  private d av;
  
  private PLWatermarkSetting aw;
  
  private JSONObject ax = new JSONObject();
  
  private com.qiniu.pili.droid.shortvideo.encode.a.a ay = new com.qiniu.pili.droid.shortvideo.encode.a.a(this) {
      private long b;
      
      private long c;
      
      public void a(MediaFormat param1MediaFormat) {
        e e = e.s;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video encode format: ");
        stringBuilder.append(param1MediaFormat);
        e.c("ShortVideoTranscoderCore", stringBuilder.toString());
        q.f(this.a, param1MediaFormat);
        q.K(this.a);
      }
      
      public void a(Surface param1Surface) {
        LinkedList<Long> linkedList = new LinkedList();
        while (true) {
          long l = q.a(this.a).getSampleTime();
          q.a(this.a).getSampleTrackIndex();
          boolean bool = q.d(this.a);
          int i = 1;
          int j = 0;
          if (bool ? (l >= q.c(this.a) && l <= q.w(this.a)) : (l >= q.c(this.a)))
            i = 0; 
          if (i) {
            linkedList.add(Long.valueOf(l));
            e e = e.s;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cache video timestamp: ");
            stringBuilder.append(l);
            e.b("ShortVideoTranscoderCore", stringBuilder.toString());
          } 
          if (!q.a(this.a).advance()) {
            Collections.sort(linkedList);
            List list = linkedList;
            if (q.d(this.a))
              list = q.a(this.a, linkedList); 
            if (q.b(this.a).containsKey("rotation-degrees")) {
              i = q.b(this.a).getInteger("rotation-degrees");
            } else {
              i = j;
              if (q.b(this.a).containsKey("rotation"))
                i = q.b(this.a).getInteger("rotation"); 
            } 
            q q1 = this.a;
            q.a(q1, new com.qiniu.pili.droid.shortvideo.gl.b.a(param1Surface, q.b(q1).getInteger("width"), q.b(this.a).getInteger("height"), i, q.q(this.a).getVideoEncodingWidth(), q.q(this.a).getVideoEncodingHeight(), list));
            q.u(this.a).a(q.x(this.a));
            q.u(this.a).a(q.t(this.a));
            q.u(this.a).a(q.y(this.a));
            q.u(this.a).c(q.z(this.a));
            if (q.A(this.a) > 0 && g.f(q.h(this.a)) > q.A(this.a))
              q.u(this.a).a(q.A(this.a)); 
            if (q.B(this.a) > 0 && q.C(this.a) > 0)
              q.u(this.a).a(q.D(this.a), q.E(this.a), q.B(this.a), q.C(this.a)); 
            if (q.F(this.a) != 0) {
              q.u(this.a).a(q.F(this.a), q.G(this.a), q.H(this.a));
              com.qiniu.pili.droid.shortvideo.gl.b.a a1 = q.u(this.a);
              if (q.I(this.a)) {
                q q2 = this.a;
                i = q.a(q2, q.J(q2));
              } else {
                i = q.J(this.a);
              } 
              a1.b(i);
            } else {
              q.u(this.a).a(q.H(this.a));
              j = g.d(q.h(this.a)) - i;
              com.qiniu.pili.droid.shortvideo.gl.b.a a1 = q.u(this.a);
              i = j;
              if (q.I(this.a))
                i = q.a(this.a, j); 
              a1.b(i);
            } 
            q.u(this.a).a();
            return;
          } 
        } 
      }
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        e e = e.s;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("encoded video frame count: ");
        stringBuilder.append(q.L(this.a));
        stringBuilder.append(" info.presentationTimeUs ");
        stringBuilder.append(param1BufferInfo.presentationTimeUs);
        e.b("ShortVideoTranscoderCore", stringBuilder.toString());
        if (q.M(this.a) != null) {
          if (q.N(this.a) != null) {
            double d1;
            double d2 = 1.0D;
            Iterator<PLSpeedTimeRange> iterator = q.N(this.a).iterator();
            while (true) {
              d1 = d2;
              if (iterator.hasNext()) {
                PLSpeedTimeRange pLSpeedTimeRange = iterator.next();
                if (pLSpeedTimeRange.isIncludeTimeUs(param1BufferInfo.presentationTimeUs)) {
                  d1 = pLSpeedTimeRange.getSpeed();
                  break;
                } 
                continue;
              } 
              break;
            } 
            long l = param1BufferInfo.presentationTimeUs;
            param1BufferInfo.presentationTimeUs = this.b + (long)((param1BufferInfo.presentationTimeUs - this.c) / d1);
            this.b = param1BufferInfo.presentationTimeUs;
            this.c = l;
          } 
          q.M(this.a).a(param1ByteBuffer, param1BufferInfo);
          if (!q.d(this.a)) {
            boolean bool;
            if (q.n(this.a) == null && q.k(this.a) == null && !q.e(this.a)) {
              bool = true;
            } else {
              bool = false;
            } 
            if (bool) {
              float f = (float)param1BufferInfo.presentationTimeUs * 1.0F / (float)q.O(this.a);
              q.P(this.a).onProgressUpdate(f);
              return;
            } 
            q.a(this.a, param1BufferInfo.presentationTimeUs);
            q.Q(this.a);
          } 
        } 
      }
      
      public void a(boolean param1Boolean) {
        e e = e.s;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video encode started result: ");
        stringBuilder.append(param1Boolean);
        e.c("ShortVideoTranscoderCore", stringBuilder.toString());
        if (!param1Boolean) {
          if (q.q(this.a).getBitrateMode() == PLVideoEncodeSetting.BitrateMode.CONSTANT_QUALITY_PRIORITY && q.b(this.a).containsKey("profile") && q.b(this.a).getInteger("profile") == 8) {
            e.s.d("ShortVideoTranscoderCore", "no support CONSTANT_QUALITY_PRIORITY , change it to QUALITY_PRIORITY and restart again!");
            q.q(this.a).setProfileMode(g.a(q.b(this.a).getInteger("profile")));
            q.q(this.a).setEncodingBitrateMode(PLVideoEncodeSetting.BitrateMode.QUALITY_PRIORITY);
            q q1 = this.a;
            q.a(q1, new e(q.q(q1)));
            q.s(this.a).a(q.r(this.a));
            q.s(this.a).a(q.t(this.a));
            q.s(this.a).a();
            return;
          } 
          q.a(this.a, 6, true);
        } 
      }
      
      public void b(boolean param1Boolean) {
        if (param1Boolean) {
          e.s.e("ShortVideoTranscoderCore", "video encoder exceptional stopped !");
          q.a(this.a, 19, true);
          return;
        } 
        e.s.c("ShortVideoTranscoderCore", "video encode stopped");
        if (q.u(this.a) != null)
          q.u(this.a).b(); 
        q.a(this.a).release();
        q.v(this.a);
      }
    };
  
  private com.qiniu.pili.droid.shortvideo.encode.a.a az = new com.qiniu.pili.droid.shortvideo.encode.a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e e = e.s;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("audio encode format: ");
        stringBuilder.append(param1MediaFormat);
        e.c("ShortVideoTranscoderCore", stringBuilder.toString());
        q.g(this.a, param1MediaFormat);
        q.K(this.a);
      }
      
      public void a(Surface param1Surface) {}
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        e e = e.s;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("encoded audio frame: ");
        stringBuilder.append(param1BufferInfo.presentationTimeUs);
        e.b("ShortVideoTranscoderCore", stringBuilder.toString());
        if (q.M(this.a) != null) {
          q.M(this.a).b(param1ByteBuffer, param1BufferInfo);
          if (!q.d(this.a)) {
            q.b(this.a, param1BufferInfo.presentationTimeUs);
            q.Q(this.a);
          } 
        } 
      }
      
      public void a(boolean param1Boolean) {
        e e = e.s;
        null = new StringBuilder();
        null.append("audio encode started result: ");
        null.append(param1Boolean);
        e.c("ShortVideoTranscoderCore", null.toString());
        if (!param1Boolean) {
          q.a(this.a, 7, true);
          return;
        } 
        synchronized (q.R(this.a)) {
          q.a(this.a, true);
          if (!q.e(this.a)) {
            q.a(this.a, new a());
            q.S(this.a).a(q.t(this.a));
            if (q.N(this.a) != null)
              q.S(this.a).a(true); 
            q.S(this.a).a(new a.a(this) {
                  public void a(ByteBuffer param2ByteBuffer, int param2Int, long param2Long) {
                    q.l(this.a.a).a(param2ByteBuffer, param2Int, param2Long);
                  }
                });
          } 
          q.R(this.a).notify();
          return;
        } 
      }
      
      public void b(boolean param1Boolean) {
        e.s.c("ShortVideoTranscoderCore", "audio encode stopped");
        if (q.i(this.a) != null)
          q.i(this.a).release(); 
        if (q.k(this.a) != null)
          q.k(this.a).release(); 
        if (q.p(this.a) != null)
          q.p(this.a).a(); 
        q.v(this.a);
      }
    };
  
  private String b;
  
  private String c;
  
  private boolean d = false;
  
  private boolean e = false;
  
  private boolean f = false;
  
  private final Object g = new Object();
  
  private final Object h = new Object();
  
  private Object i;
  
  private MediaExtractor j;
  
  private MediaExtractor k;
  
  private MediaExtractor l;
  
  private MediaFormat m;
  
  private MediaFormat n;
  
  private MediaFormat o;
  
  private MediaFormat p;
  
  private Object q = new Object();
  
  private com.qiniu.pili.droid.shortvideo.d.b r;
  
  private com.qiniu.pili.droid.shortvideo.d.b s;
  
  private com.qiniu.pili.droid.shortvideo.d.b t;
  
  private Thread u;
  
  private MediaFormat v;
  
  private MediaFormat w;
  
  private e x;
  
  private com.qiniu.pili.droid.shortvideo.encode.c y;
  
  private Object z = new Object();
  
  public q(Context paramContext, String paramString1, String paramString2) {
    e.s.c("ShortVideoTranscoderCore", "init +");
    this.a = paramContext.getApplicationContext();
    l.a(this.a);
    QosManager.a().a(QosManager.KeyPoint.transcode_init);
    this.b = paramString1;
    this.c = l.a(this.a, paramString2);
    this.R = 0L;
    long l = g.a(this.b) * 1000L;
    this.S = l;
    this.T = l;
    this.af = g.b(this.b) * g.c(this.b) * 4;
    e e1 = e.s;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("transcode from: ");
    stringBuilder.append(paramString1);
    stringBuilder.append(" to ");
    stringBuilder.append(paramString2);
    e1.c("ShortVideoTranscoderCore", stringBuilder.toString());
    e.s.c("ShortVideoTranscoderCore", "init -");
  }
  
  private int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
    if (paramInt2 != -1 && paramInt1 < paramInt2 && paramByteBuffer.capacity() >= paramInt2) {
      paramByteBuffer.position(0);
      paramByteBuffer.limit(paramInt2);
      return paramInt2;
    } 
    return paramInt1;
  }
  
  private d a(PLWatermarkSetting paramPLWatermarkSetting, int paramInt1, int paramInt2) {
    Bitmap bitmap2 = paramPLWatermarkSetting.getBitmap();
    Bitmap bitmap1 = bitmap2;
    if (bitmap2 == null)
      bitmap1 = BitmapFactory.decodeResource(this.a.getResources(), paramPLWatermarkSetting.getResourceId()); 
    d d1 = new d(bitmap1);
    d1.a(paramPLWatermarkSetting.getAlpha() / 255.0F);
    d1.b(paramPLWatermarkSetting.getX(), paramPLWatermarkSetting.getY());
    if (paramPLWatermarkSetting.getWidth() > 0.0F && paramPLWatermarkSetting.getHeight() > 0.0F)
      d1.a(paramPLWatermarkSetting.getWidth(), paramPLWatermarkSetting.getHeight()); 
    d1.a(paramInt1, paramInt2);
    d1.b();
    return d1;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3) {
    b(paramInt1, paramInt2, paramInt3);
    if (this.F == null) {
      this.F = new PLVideoEncodeSetting(this.a);
      this.F.setEncodingBitrate(paramInt3);
      if (this.m.containsKey("frame-rate")) {
        int j = this.m.getInteger("frame-rate");
        paramInt3 = this.E;
        if (paramInt3 > 0 && j > paramInt3) {
          paramInt3 = 1;
        } else {
          paramInt3 = 0;
        } 
        PLVideoEncodeSetting pLVideoEncodeSetting1 = this.F;
        if (paramInt3 != 0)
          j = this.E; 
        pLVideoEncodeSetting1.setEncodingFps(j);
      } 
      e e1 = e.s;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("config video encoder: ");
      stringBuilder.append(this.F.getVideoEncodingFps());
      stringBuilder.append(" fps");
      e1.c("ShortVideoTranscoderCore", stringBuilder.toString());
      if (this.m.containsKey("i-frame-interval")) {
        PLVideoEncodeSetting pLVideoEncodeSetting1 = this.F;
        pLVideoEncodeSetting1.setIFrameInterval(pLVideoEncodeSetting1.getVideoEncodingFps() * this.m.getInteger("i-frame-interval"));
      } 
      e1 = e.s;
      stringBuilder = new StringBuilder();
      stringBuilder.append("config video encoder: I Interval:");
      stringBuilder.append(this.F.getIFrameInterval());
      e1.c("ShortVideoTranscoderCore", stringBuilder.toString());
    } 
    if (this.V != 0) {
      paramInt3 = this.X;
    } else {
      paramInt3 = g.d(this.b);
    } 
    int i = paramInt3;
    if (h())
      i = c(paramInt3); 
    PLVideoEncodeSetting pLVideoEncodeSetting = this.F;
    if (i == 0 || i == 180) {
      paramInt3 = paramInt1;
    } else {
      paramInt3 = paramInt2;
    } 
    if (i == 0 || i == 180)
      paramInt1 = paramInt2; 
    pLVideoEncodeSetting.setPreferredEncodingSize(paramInt3, paramInt1);
    if (this.m.containsKey("profile") && this.m.getInteger("profile") == 8) {
      this.F.setProfileMode(PLVideoEncodeSetting.ProfileMode.BASELINE);
      this.F.setEncodingBitrateMode(PLVideoEncodeSetting.BitrateMode.CONSTANT_QUALITY_PRIORITY);
      e.s.c("ShortVideoTranscoderCore", "source video's profile is high, change it to baseline and set bitrate mode to CONSTANT_QUALITY_PRIORITY !");
    } 
    this.x = new e(this.F);
    this.x.a(this.ay);
    this.x.a(this.aa);
    this.x.a();
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    e e1 = e.s;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("exceptionalStop + ");
    stringBuilder.append(paramInt);
    e1.e("ShortVideoTranscoderCore", stringBuilder.toString());
    this.Q = paramInt;
    a();
    if (paramBoolean)
      g(); 
    e1 = e.s;
    stringBuilder = new StringBuilder();
    stringBuilder.append("exceptionalStop - ");
    stringBuilder.append(paramInt);
    e1.e("ShortVideoTranscoderCore", stringBuilder.toString());
  }
  
  private void a(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: getfield ac : Ljava/util/ArrayList;
    //   4: invokevirtual iterator : ()Ljava/util/Iterator;
    //   7: astore #5
    //   9: aload #5
    //   11: invokeinterface hasNext : ()Z
    //   16: ifeq -> 49
    //   19: aload #5
    //   21: invokeinterface next : ()Ljava/lang/Object;
    //   26: checkcast com/qiniu/pili/droid/shortvideo/PLSpeedTimeRange
    //   29: astore #6
    //   31: aload #6
    //   33: lload_1
    //   34: invokevirtual isIncludeTimeUs : (J)Z
    //   37: ifeq -> 9
    //   40: aload #6
    //   42: invokevirtual getSpeed : ()D
    //   45: dstore_3
    //   46: goto -> 51
    //   49: dconst_1
    //   50: dstore_3
    //   51: aload_0
    //   52: getfield ab : Lcom/qiniu/pili/droid/shortvideo/core/a;
    //   55: invokevirtual a : ()D
    //   58: dload_3
    //   59: dcmpl
    //   60: ifeq -> 78
    //   63: aload_0
    //   64: getfield ab : Lcom/qiniu/pili/droid/shortvideo/core/a;
    //   67: invokevirtual b : ()V
    //   70: aload_0
    //   71: getfield ab : Lcom/qiniu/pili/droid/shortvideo/core/a;
    //   74: dload_3
    //   75: invokevirtual a : (D)V
    //   78: return
  }
  
  private void a(MediaFormat paramMediaFormat) {
    char c1;
    int i = paramMediaFormat.getInteger("sample-rate");
    int j = paramMediaFormat.getInteger("channel-count");
    if (paramMediaFormat.containsKey("bitrate")) {
      c1 = paramMediaFormat.getInteger("bitrate");
    } else {
      c1 = '걄';
    } 
    PLAudioEncodeSetting pLAudioEncodeSetting = new PLAudioEncodeSetting();
    pLAudioEncodeSetting.setSampleRate(i);
    pLAudioEncodeSetting.setChannels(j);
    pLAudioEncodeSetting.setBitrate(c1);
    this.y = new com.qiniu.pili.droid.shortvideo.encode.c(pLAudioEncodeSetting);
    this.y.a(this.az);
    this.y.a();
    synchronized (this.z) {
      while (true) {
        boolean bool = this.A;
        if (!bool) {
          try {
            this.z.wait();
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          } 
          continue;
        } 
        return;
      } 
    } 
  }
  
  private void a(MediaFormat paramMediaFormat, com.qiniu.pili.droid.shortvideo.d.b.c paramc) {
    long l1 = this.L.e().a();
    long l2 = this.L.e().b();
    if (e()) {
      this.t = (com.qiniu.pili.droid.shortvideo.d.b)new com.qiniu.pili.droid.shortvideo.d.a(this.l, paramMediaFormat);
    } else {
      this.t = new com.qiniu.pili.droid.shortvideo.d.b(this.l, paramMediaFormat);
    } 
    this.t.a(paramc);
    this.t.a(new com.qiniu.pili.droid.shortvideo.d.b.d(this, paramMediaFormat) {
          public void a(MediaFormat param1MediaFormat) {
            if (param1MediaFormat != null && !param1MediaFormat.containsKey("bitrate") && this.a.containsKey("bitrate"))
              param1MediaFormat.setInteger("bitrate", this.a.getInteger("bitrate")); 
            e e = e.s;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("got music audio decoder format: ");
            stringBuilder.append(param1MediaFormat);
            e.c("ShortVideoTranscoderCore", stringBuilder.toString());
            if (q.n(this.b) != null)
              synchronized (q.m(this.b)) {
                while (true) {
                  MediaFormat mediaFormat = q.o(this.b);
                  if (mediaFormat == null) {
                    try {
                      q.m(this.b).wait();
                    } catch (InterruptedException interruptedException) {
                      interruptedException.printStackTrace();
                    } 
                    continue;
                  } 
                  q.a(this.b, new AudioMixer());
                  q.p(this.b).a(q.o(this.b).getInteger("sample-rate"), q.o(this.b).getInteger("channel-count"), param1MediaFormat.getInteger("sample-rate"), param1MediaFormat.getInteger("channel-count"));
                  q.p(this.b).a(q.j(this.b).f().a(), q.j(this.b).f().b());
                  return;
                } 
              }  
            q.e(this.b, param1MediaFormat);
          }
        });
    this.t.a(this.L.b());
    this.t.a(l1 * 1000L, l2 * 1000L);
  }
  
  private void a(MediaFormat paramMediaFormat1, com.qiniu.pili.droid.shortvideo.d.b.c paramc, MediaFormat paramMediaFormat2) {
    if (e()) {
      this.s = (com.qiniu.pili.droid.shortvideo.d.b)new com.qiniu.pili.droid.shortvideo.d.a(this.k, paramMediaFormat1);
    } else {
      this.s = new com.qiniu.pili.droid.shortvideo.d.b(this.k, paramMediaFormat1);
    } 
    this.s.a(paramc);
    this.s.a(new com.qiniu.pili.droid.shortvideo.d.b.d(this, paramMediaFormat1, paramMediaFormat2) {
          public void a(MediaFormat param1MediaFormat) {
            if (param1MediaFormat != null && !param1MediaFormat.containsKey("bitrate") && this.a.containsKey("bitrate"))
              param1MediaFormat.setInteger("bitrate", this.a.getInteger("bitrate")); 
            e e = e.s;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("got src audio decoder format: ");
            stringBuilder.append(param1MediaFormat);
            e.c("ShortVideoTranscoderCore", stringBuilder.toString());
            synchronized (q.m(this.c)) {
              q.d(this.c, param1MediaFormat);
              q.m(this.c).notify();
              q.e(this.c, param1MediaFormat);
              param1MediaFormat = this.b;
              if (param1MediaFormat != null) {
                null = this.c;
                q.a((q)null, param1MediaFormat, new q.a());
              } 
              return;
            } 
          }
        });
    this.s.a(this.R, this.S);
  }
  
  private boolean a(String paramString) {
    String[] arrayOfString = c.b;
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (arrayOfString[i].equals(paramString))
        return true; 
    } 
    return false;
  }
  
  private int b(MediaFormat paramMediaFormat) {
    return (paramMediaFormat != null && paramMediaFormat.containsKey("mime") && paramMediaFormat.getString("mime").equals("audio/mp4a-latm") && paramMediaFormat.containsKey("channel-count")) ? (paramMediaFormat.getInteger("channel-count") * 2 * 1024) : -1;
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3) {
    String str2;
    if (this.m == null)
      return; 
    try {
      MediaMetadataRetriever mediaMetadataRetriever;
      this.ax.put("transcode_time", System.currentTimeMillis());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.m.getInteger("width"));
      stringBuilder.append(" X ");
      stringBuilder.append(this.m.getInteger("height"));
      String str3 = stringBuilder.toString();
      this.ax.put("original_video_size", str3);
      boolean bool = this.m.containsKey("bitrate");
      String str6 = null;
      if (bool) {
        str4 = String.valueOf(this.m.getInteger("bitrate"));
      } else {
        str4 = null;
      } 
      if (str4 == null) {
        MediaMetadataRetriever mediaMetadataRetriever1 = new MediaMetadataRetriever();
        mediaMetadataRetriever1.setDataSource(this.b);
        str4 = mediaMetadataRetriever1.extractMetadata(20);
      } else {
        str3 = null;
      } 
      String str5 = str4;
      if (str4 == null)
        str5 = "null"; 
      this.ax.put("original_bitrate", str5);
      String str4 = str6;
      if (this.m.containsKey("durationUs"))
        str4 = String.valueOf(this.m.getLong("durationUs") / 1000L); 
      if (str4 == null) {
        str4 = str3;
        if (str3 == null) {
          mediaMetadataRetriever = new MediaMetadataRetriever();
          mediaMetadataRetriever.setDataSource(this.b);
        } 
        str3 = mediaMetadataRetriever.extractMetadata(9);
      } else {
        MediaMetadataRetriever mediaMetadataRetriever1 = mediaMetadataRetriever;
      } 
    } catch (Exception exception1) {
      return;
    } 
    Exception exception2 = exception1;
    if (exception1 == null)
      str2 = "null"; 
    this.ax.put("duration", str2);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt1);
    stringBuilder1.append(" X ");
    stringBuilder1.append(paramInt2);
    String str1 = stringBuilder1.toString();
    this.ax.put("dst_video_size", str1);
    JSONObject jSONObject = this.ax;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt3);
    stringBuilder2.append("");
    jSONObject.put("dst_bitrate", stringBuilder2.toString());
  }
  
  private int c(int paramInt) {
    return j.b(paramInt + this.Y);
  }
  
  private List<Long> c(List<Long> paramList) {
    LinkedList<Long> linkedList = new LinkedList();
    long l = ((Long)paramList.get(paramList.size() - 1)).longValue();
    Collections.reverse(paramList);
    for (int i = 0; i < paramList.size(); i++)
      linkedList.add(Long.valueOf(l - ((Long)paramList.get(i)).longValue())); 
    return linkedList;
  }
  
  private void c() {
    MediaFormat mediaFormat = new MediaFormat();
    mediaFormat.setInteger("sample-rate", 44100);
    mediaFormat.setInteger("channel-count", 1);
    a(mediaFormat);
    this.ao = new MultiAudioMixer();
    this.ao.a(this.an, new MultiAudioMixer.a(this) {
          public void a() {
            q.l(this.a).c();
          }
          
          public void a(int param1Int) {
            e e = e.q;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("multi audio mix failed error : ");
            stringBuilder.append(param1Int);
            e.d(stringBuilder.toString());
            q.l(this.a).c();
          }
          
          public void a(byte[] param1ArrayOfbyte, long param1Long) {
            q.l(this.a).a(ByteBuffer.wrap(param1ArrayOfbyte), param1ArrayOfbyte.length, param1Long);
          }
        });
  }
  
  private void d() {
    this.T = this.S - this.R;
    ArrayList<PLSpeedTimeRange> arrayList = this.ac;
    if (arrayList != null) {
      for (PLSpeedTimeRange pLSpeedTimeRange : arrayList)
        this.T = this.T - pLSpeedTimeRange.getRangeTimeMs() * 1000L + (long)((pLSpeedTimeRange.getRangeTimeMs() * 1000L) / pLSpeedTimeRange.getSpeed()); 
    } else {
      this.T = (long)(this.T / this.aa);
    } 
    e e1 = e.s;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mDurationUs is updated to : ");
    stringBuilder.append(this.T);
    e1.c("ShortVideoTranscoderCore", stringBuilder.toString());
  }
  
  private boolean e() {
    return (Build.VERSION.SDK_INT >= 23 && !this.ae && !a(j.b()));
  }
  
  private void f() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'ShortVideoTranscoderCore'
    //   7: ldc_w 'startMuxer +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield O : Z
    //   17: ifeq -> 34
    //   20: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   23: ldc 'ShortVideoTranscoderCore'
    //   25: ldc_w 'transcode is already canceled'
    //   28: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: aload_0
    //   36: getfield C : I
    //   39: iconst_1
    //   40: iadd
    //   41: putfield C : I
    //   44: aload_0
    //   45: getfield y : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   48: ifnull -> 85
    //   51: aload_0
    //   52: getfield C : I
    //   55: iconst_2
    //   56: if_icmpge -> 85
    //   59: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   62: ldc 'ShortVideoTranscoderCore'
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
    //   93: putfield B : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   96: aload_0
    //   97: getfield B : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   100: aload_0
    //   101: getfield c : Ljava/lang/String;
    //   104: aload_0
    //   105: getfield v : Landroid/media/MediaFormat;
    //   108: aload_0
    //   109: getfield w : Landroid/media/MediaFormat;
    //   112: iconst_0
    //   113: invokevirtual a : (Ljava/lang/String;Landroid/media/MediaFormat;Landroid/media/MediaFormat;I)Z
    //   116: ifne -> 137
    //   119: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   122: ldc 'ShortVideoTranscoderCore'
    //   124: ldc_w 'start muxer failed!'
    //   127: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: invokevirtual a : ()V
    //   134: goto -> 152
    //   137: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   140: ldc 'ShortVideoTranscoderCore'
    //   142: ldc_w 'start muxer success!'
    //   145: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_0
    //   149: invokevirtual notify : ()V
    //   152: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   155: ldc 'ShortVideoTranscoderCore'
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
  
  private void g() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'ShortVideoTranscoderCore'
    //   7: ldc_w 'stopMuxer +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield D : I
    //   17: istore_2
    //   18: iconst_1
    //   19: istore_1
    //   20: aload_0
    //   21: iload_2
    //   22: iconst_1
    //   23: iadd
    //   24: putfield D : I
    //   27: aload_0
    //   28: getfield y : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   31: ifnull -> 56
    //   34: aload_0
    //   35: getfield D : I
    //   38: iconst_2
    //   39: if_icmpge -> 56
    //   42: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   45: ldc 'ShortVideoTranscoderCore'
    //   47: ldc_w 'not ready to stop muxer.'
    //   50: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: getfield B : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   60: ifnull -> 530
    //   63: aload_0
    //   64: getfield B : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   67: invokevirtual a : ()Z
    //   70: ifeq -> 530
    //   73: goto -> 76
    //   76: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   79: astore #8
    //   81: new java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial <init> : ()V
    //   88: astore #9
    //   90: aload #9
    //   92: ldc_w 'stop muxer '
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: iload_1
    //   100: ifeq -> 535
    //   103: ldc_w 'success'
    //   106: astore #7
    //   108: goto -> 111
    //   111: aload #9
    //   113: aload #7
    //   115: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload #8
    //   121: ldc 'ShortVideoTranscoderCore'
    //   123: aload #9
    //   125: invokevirtual toString : ()Ljava/lang/String;
    //   128: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield B : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   136: aload_0
    //   137: aconst_null
    //   138: putfield x : Lcom/qiniu/pili/droid/shortvideo/encode/e;
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield y : Lcom/qiniu/pili/droid/shortvideo/encode/c;
    //   146: aload_0
    //   147: aconst_null
    //   148: putfield ao : Lcom/qiniu/pili/droid/shortvideo/process/audio/MultiAudioMixer;
    //   151: aload_0
    //   152: aconst_null
    //   153: putfield j : Landroid/media/MediaExtractor;
    //   156: aload_0
    //   157: aconst_null
    //   158: putfield k : Landroid/media/MediaExtractor;
    //   161: aload_0
    //   162: aconst_null
    //   163: putfield l : Landroid/media/MediaExtractor;
    //   166: aload_0
    //   167: aconst_null
    //   168: putfield r : Lcom/qiniu/pili/droid/shortvideo/d/b;
    //   171: aload_0
    //   172: aconst_null
    //   173: putfield s : Lcom/qiniu/pili/droid/shortvideo/d/b;
    //   176: aload_0
    //   177: aconst_null
    //   178: putfield t : Lcom/qiniu/pili/droid/shortvideo/d/b;
    //   181: aload_0
    //   182: aconst_null
    //   183: putfield G : Lcom/qiniu/pili/droid/shortvideo/gl/b/a;
    //   186: aload_0
    //   187: aconst_null
    //   188: putfield ag : Lcom/qiniu/pili/droid/shortvideo/transcoder/audio/AudioMixer;
    //   191: aload_0
    //   192: aconst_null
    //   193: putfield ah : Ljava/nio/ByteBuffer;
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield ab : Lcom/qiniu/pili/droid/shortvideo/core/a;
    //   201: aload_0
    //   202: aconst_null
    //   203: putfield v : Landroid/media/MediaFormat;
    //   206: aload_0
    //   207: aconst_null
    //   208: putfield w : Landroid/media/MediaFormat;
    //   211: aload_0
    //   212: aconst_null
    //   213: putfield m : Landroid/media/MediaFormat;
    //   216: aload_0
    //   217: aconst_null
    //   218: putfield n : Landroid/media/MediaFormat;
    //   221: aload_0
    //   222: aconst_null
    //   223: putfield o : Landroid/media/MediaFormat;
    //   226: aload_0
    //   227: aconst_null
    //   228: putfield p : Landroid/media/MediaFormat;
    //   231: aload_0
    //   232: iconst_0
    //   233: putfield I : I
    //   236: aload_0
    //   237: iconst_0
    //   238: putfield J : I
    //   241: aload_0
    //   242: iconst_0
    //   243: putfield K : I
    //   246: aload_0
    //   247: iconst_0
    //   248: putfield C : I
    //   251: aload_0
    //   252: iconst_0
    //   253: putfield D : I
    //   256: aload_0
    //   257: lconst_0
    //   258: putfield ap : J
    //   261: aload_0
    //   262: lconst_0
    //   263: putfield aq : J
    //   266: aload_0
    //   267: iconst_0
    //   268: putfield ae : Z
    //   271: aload_0
    //   272: iconst_0
    //   273: putfield H : Z
    //   276: aload_0
    //   277: iconst_0
    //   278: putfield A : Z
    //   281: aload_0
    //   282: getfield O : Z
    //   285: ifeq -> 371
    //   288: aload_0
    //   289: iconst_0
    //   290: putfield O : Z
    //   293: new java/io/File
    //   296: dup
    //   297: aload_0
    //   298: getfield c : Ljava/lang/String;
    //   301: invokespecial <init> : (Ljava/lang/String;)V
    //   304: invokevirtual delete : ()Z
    //   307: pop
    //   308: aload_0
    //   309: getfield P : Z
    //   312: ifne -> 334
    //   315: aload_0
    //   316: invokespecial j : ()Z
    //   319: ifne -> 334
    //   322: aload_0
    //   323: getfield M : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   326: invokeinterface onSaveVideoCanceled : ()V
    //   331: goto -> 473
    //   334: aload_0
    //   335: invokespecial j : ()Z
    //   338: ifeq -> 473
    //   341: aload_0
    //   342: getfield Q : I
    //   345: istore_1
    //   346: aload_0
    //   347: iconst_m1
    //   348: putfield Q : I
    //   351: aload_0
    //   352: getfield M : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   355: iload_1
    //   356: invokeinterface onSaveVideoFailed : (I)V
    //   361: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/core/QosManager;
    //   364: iload_1
    //   365: invokevirtual a : (I)V
    //   368: goto -> 473
    //   371: aload_0
    //   372: getfield M : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   375: fconst_1
    //   376: invokeinterface onProgressUpdate : (F)V
    //   381: iload_1
    //   382: ifeq -> 456
    //   385: aload_0
    //   386: getfield M : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   389: aload_0
    //   390: getfield c : Ljava/lang/String;
    //   393: invokeinterface onSaveVideoSuccess : (Ljava/lang/String;)V
    //   398: aload_0
    //   399: getfield ax : Lorg/json/JSONObject;
    //   402: ldc_w 'transcode_time'
    //   405: invokevirtual getLong : (Ljava/lang/String;)J
    //   408: lstore_3
    //   409: invokestatic currentTimeMillis : ()J
    //   412: lstore #5
    //   414: aload_0
    //   415: getfield ax : Lorg/json/JSONObject;
    //   418: ldc_w 'transcode_time'
    //   421: lload #5
    //   423: lload_3
    //   424: lsub
    //   425: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   428: pop
    //   429: aload_0
    //   430: getfield ax : Lorg/json/JSONObject;
    //   433: ldc_w 'data_type'
    //   436: getstatic com/qiniu/pili/droid/shortvideo/core/QosManager$a.b : Lcom/qiniu/pili/droid/shortvideo/core/QosManager$a;
    //   439: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   442: pop
    //   443: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/core/QosManager;
    //   446: aload_0
    //   447: getfield ax : Lorg/json/JSONObject;
    //   450: invokevirtual a : (Lorg/json/JSONObject;)V
    //   453: goto -> 473
    //   456: aload_0
    //   457: getfield M : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   460: iconst_3
    //   461: invokeinterface onSaveVideoFailed : (I)V
    //   466: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/core/QosManager;
    //   469: iconst_3
    //   470: invokevirtual a : (I)V
    //   473: aload_0
    //   474: getfield P : Z
    //   477: ifeq -> 504
    //   480: aload_0
    //   481: iconst_0
    //   482: putfield P : Z
    //   485: aload_0
    //   486: getfield M : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   489: bipush #16
    //   491: invokeinterface onSaveVideoFailed : (I)V
    //   496: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/core/QosManager;
    //   499: bipush #16
    //   501: invokevirtual a : (I)V
    //   504: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   507: ldc 'ShortVideoTranscoderCore'
    //   509: ldc_w 'stopMuxer -'
    //   512: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   515: aload_0
    //   516: monitorexit
    //   517: return
    //   518: astore #7
    //   520: aload_0
    //   521: monitorexit
    //   522: aload #7
    //   524: athrow
    //   525: astore #7
    //   527: goto -> 473
    //   530: iconst_0
    //   531: istore_1
    //   532: goto -> 76
    //   535: ldc_w 'fail'
    //   538: astore #7
    //   540: goto -> 111
    // Exception table:
    //   from	to	target	type
    //   2	18	518	finally
    //   20	53	518	finally
    //   56	73	518	finally
    //   76	99	518	finally
    //   111	331	518	finally
    //   334	368	518	finally
    //   371	381	518	finally
    //   385	398	518	finally
    //   398	453	525	java/lang/Exception
    //   398	453	518	finally
    //   456	473	518	finally
    //   473	504	518	finally
    //   504	515	518	finally
  }
  
  private boolean h() {
    int i = Math.abs(this.Y);
    return (i == 90 || i == 180 || i == 270);
  }
  
  private void i() {
    e.s.c("ShortVideoTranscoderCore", "stopVideoStuff");
    if (this.ae)
      this.G.c(); 
    this.r.c();
    this.x.c();
  }
  
  private boolean j() {
    return (this.Q >= 0);
  }
  
  private boolean k() {
    boolean bool;
    ActivityManager activityManager = (ActivityManager)this.a.getSystemService("activity");
    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
    activityManager.getMemoryInfo(memoryInfo);
    long l1 = (this.af * 10);
    if (memoryInfo.availMem - memoryInfo.threshold - l1 <= 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    e e1 = e.s;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("availMem: ");
    long l2 = memoryInfo.availMem;
    long l3 = 1048576L;
    stringBuilder.append(l2 / l3);
    stringBuilder.append("M, threshold: ");
    stringBuilder.append(memoryInfo.threshold / l3);
    stringBuilder.append("M, leftMem: ");
    stringBuilder.append((memoryInfo.availMem - memoryInfo.threshold) / l3);
    stringBuilder.append("M, safeMem: ");
    stringBuilder.append(l1 / l3);
    stringBuilder.append("M, oneFrame: ");
    stringBuilder.append(this.af / 1048576);
    e1.b("ShortVideoTranscoderCore", stringBuilder.toString());
    return bool;
  }
  
  private boolean l() {
    List<PLMixAudioFile> list = this.an;
    return (list != null && list.size() >= 2);
  }
  
  private void m() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield aq : J
    //   6: aload_0
    //   7: getfield ap : J
    //   10: ladd
    //   11: l2f
    //   12: aload_0
    //   13: getfield T : J
    //   16: ldc2_w 2
    //   19: lmul
    //   20: l2f
    //   21: fdiv
    //   22: fstore_1
    //   23: aload_0
    //   24: getfield M : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   27: fload_1
    //   28: invokeinterface onProgressUpdate : (F)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   2	33	36	finally
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield H : Z
    //   6: ifeq -> 46
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'ShortVideoTranscoderCore'
    //   14: ldc_w 'cancelTranscode'
    //   17: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield O : Z
    //   25: aload_0
    //   26: getfield ao : Lcom/qiniu/pili/droid/shortvideo/process/audio/MultiAudioMixer;
    //   29: ifnull -> 39
    //   32: aload_0
    //   33: getfield ao : Lcom/qiniu/pili/droid/shortvideo/process/audio/MultiAudioMixer;
    //   36: invokevirtual a : ()V
    //   39: aload_0
    //   40: invokevirtual notify : ()V
    //   43: goto -> 57
    //   46: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   49: ldc 'ShortVideoTranscoderCore'
    //   51: ldc_w 'cancelTranscode failed'
    //   54: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   2	39	60	finally
    //   39	43	60	finally
    //   46	57	60	finally
  }
  
  public void a(double paramDouble) {
    this.ac = null;
    this.aa = paramDouble;
    d();
  }
  
  public void a(int paramInt) {
    this.Z = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!u.a().a(b.a.W))
      return; 
    this.ar = paramInt1;
    this.as = paramInt2;
    this.at = paramInt3;
    this.au = paramInt4;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, PLVideoFilterListener paramPLVideoFilterListener, boolean paramBoolean) {
    this.V = paramInt1;
    this.W = paramInt2;
    this.X = paramInt3;
    a(paramPLVideoFilterListener, paramBoolean);
  }
  
  public void a(long paramLong1, long paramLong2) {
    this.R = paramLong1;
    this.S = paramLong2;
    d();
    e e1 = e.s;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("set range to: ");
    stringBuilder.append(paramLong1);
    stringBuilder.append("-");
    stringBuilder.append(paramLong2);
    stringBuilder.append(" duration: ");
    stringBuilder.append(this.T);
    e1.c("ShortVideoTranscoderCore", stringBuilder.toString());
  }
  
  public void a(PLVideoEncodeSetting paramPLVideoEncodeSetting) {
    this.F = paramPLVideoEncodeSetting;
  }
  
  public void a(PLVideoFilterListener paramPLVideoFilterListener, boolean paramBoolean) {
    this.N = paramPLVideoFilterListener;
    this.U = paramBoolean;
  }
  
  public void a(PLWatermarkSetting paramPLWatermarkSetting) {
    this.aw = paramPLWatermarkSetting;
  }
  
  public void a(com.qiniu.pili.droid.shortvideo.transcoder.audio.a parama) {
    this.L = parama;
  }
  
  public void a(Object paramObject) {
    this.i = paramObject;
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean) {
    com.qiniu.pili.droid.shortvideo.transcoder.audio.a a1 = new com.qiniu.pili.droid.shortvideo.transcoder.audio.a();
    a1.a(paramString);
    a1.a(paramBoolean);
    a1.a((int)g.a(paramString));
    a1.a(new d(paramLong1, paramLong2));
    a(a1);
  }
  
  public void a(List<PLSpeedTimeRange> paramList) {
    this.ac = new ArrayList<PLSpeedTimeRange>(paramList);
    this.aa = 1.0D;
    d();
    e.s.c("ShortVideoTranscoderCore", "setSpeedTimeRanges : reset mSpeed to 1.0 ");
  }
  
  public void a(boolean paramBoolean) {
    e e1 = e.s;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setMuteEnabled: ");
    stringBuilder.append(paramBoolean);
    e1.c("ShortVideoTranscoderCore", stringBuilder.toString());
    this.e = paramBoolean;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, PLVideoSaveListener paramPLVideoSaveListener) {
    if (!u.a().a(b.a.Y, paramPLVideoSaveListener))
      return false; 
    this.Y = paramInt4;
    return a(paramInt1, paramInt2, paramInt3, paramPLVideoSaveListener);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, PLVideoSaveListener paramPLVideoSaveListener) {
    if (!u.a().a(b.a.af, paramPLVideoSaveListener))
      return false; 
    this.Y = paramInt4;
    return a(paramInt1, paramInt2, paramInt3, paramBoolean, paramPLVideoSaveListener);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, PLVideoSaveListener paramPLVideoSaveListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'ShortVideoTranscoderCore'
    //   7: ldc_w 'transcode +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload #4
    //   15: astore #7
    //   17: aload #4
    //   19: ifnonnull -> 28
    //   22: aload_0
    //   23: getfield aE : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   26: astore #7
    //   28: aload_0
    //   29: aload #7
    //   31: putfield M : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   34: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/core/u;
    //   37: getstatic com/qiniu/pili/droid/shortvideo/core/b$a.X : Lcom/qiniu/pili/droid/shortvideo/core/b$a;
    //   40: aload_0
    //   41: getfield M : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   44: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/core/b$a;Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;)Z
    //   47: istore #6
    //   49: iload #6
    //   51: ifne -> 58
    //   54: aload_0
    //   55: monitorexit
    //   56: iconst_0
    //   57: ireturn
    //   58: aload_0
    //   59: getfield b : Ljava/lang/String;
    //   62: aload_0
    //   63: getfield c : Ljava/lang/String;
    //   66: invokevirtual equals : (Ljava/lang/Object;)Z
    //   69: ifeq -> 98
    //   72: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   75: ldc 'ShortVideoTranscoderCore'
    //   77: ldc_w 'the dst video path must be different with src video path, please check the constructor's param!'
    //   80: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: getfield M : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   87: bipush #14
    //   89: invokeinterface onSaveVideoFailed : (I)V
    //   94: aload_0
    //   95: monitorexit
    //   96: iconst_0
    //   97: ireturn
    //   98: aload_0
    //   99: getfield H : Z
    //   102: ifeq -> 120
    //   105: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   108: ldc 'ShortVideoTranscoderCore'
    //   110: ldc_w 'transcode already started +'
    //   113: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_0
    //   117: monitorexit
    //   118: iconst_0
    //   119: ireturn
    //   120: aload_0
    //   121: iconst_1
    //   122: putfield H : Z
    //   125: iload_1
    //   126: invokestatic b : (I)I
    //   129: istore_1
    //   130: iload_2
    //   131: invokestatic b : (I)I
    //   134: istore_2
    //   135: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   138: astore #4
    //   140: new java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial <init> : ()V
    //   147: astore #7
    //   149: aload #7
    //   151: ldc_w 'dst bitrate: '
    //   154: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload #7
    //   160: iload_3
    //   161: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload #7
    //   167: ldc_w ' dst width: '
    //   170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload #7
    //   176: iload_1
    //   177: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload #7
    //   183: ldc_w ' dst height: '
    //   186: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload #7
    //   192: iload_2
    //   193: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload #7
    //   199: ldc_w ' rotate by: '
    //   202: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload #7
    //   208: aload_0
    //   209: getfield Y : I
    //   212: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload #4
    //   218: ldc 'ShortVideoTranscoderCore'
    //   220: aload #7
    //   222: invokevirtual toString : ()Ljava/lang/String;
    //   225: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload_0
    //   229: new android/media/MediaExtractor
    //   232: dup
    //   233: invokespecial <init> : ()V
    //   236: putfield j : Landroid/media/MediaExtractor;
    //   239: aload_0
    //   240: getfield j : Landroid/media/MediaExtractor;
    //   243: aload_0
    //   244: getfield b : Ljava/lang/String;
    //   247: invokevirtual setDataSource : (Ljava/lang/String;)V
    //   250: aload_0
    //   251: getfield j : Landroid/media/MediaExtractor;
    //   254: ldc_w 'video/'
    //   257: invokestatic a : (Landroid/media/MediaExtractor;Ljava/lang/String;)I
    //   260: istore #5
    //   262: iload #5
    //   264: ifge -> 293
    //   267: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   270: ldc 'ShortVideoTranscoderCore'
    //   272: ldc_w 'cannot find video in file!'
    //   275: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   278: aload_0
    //   279: getfield M : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   282: bipush #13
    //   284: invokeinterface onSaveVideoFailed : (I)V
    //   289: aload_0
    //   290: monitorexit
    //   291: iconst_0
    //   292: ireturn
    //   293: new java/lang/Thread
    //   296: dup
    //   297: new com/qiniu/pili/droid/shortvideo/core/q$1
    //   300: dup
    //   301: aload_0
    //   302: iload #5
    //   304: iload_1
    //   305: iload_2
    //   306: iload_3
    //   307: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/core/q;IIII)V
    //   310: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   313: invokevirtual start : ()V
    //   316: aload_0
    //   317: monitorexit
    //   318: iconst_1
    //   319: ireturn
    //   320: astore #4
    //   322: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   325: astore #7
    //   327: new java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial <init> : ()V
    //   334: astore #8
    //   336: aload #8
    //   338: ldc_w 'file video setDataSource failed: '
    //   341: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload #8
    //   347: aload #4
    //   349: invokevirtual getMessage : ()Ljava/lang/String;
    //   352: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload #7
    //   358: ldc 'ShortVideoTranscoderCore'
    //   360: aload #8
    //   362: invokevirtual toString : ()Ljava/lang/String;
    //   365: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   368: aload_0
    //   369: monitorexit
    //   370: iconst_0
    //   371: ireturn
    //   372: astore #4
    //   374: aload_0
    //   375: monitorexit
    //   376: aload #4
    //   378: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	372	finally
    //   22	28	372	finally
    //   28	49	372	finally
    //   58	94	372	finally
    //   98	116	372	finally
    //   120	239	372	finally
    //   239	250	320	java/io/IOException
    //   239	250	372	finally
    //   250	262	372	finally
    //   267	289	372	finally
    //   293	316	372	finally
    //   322	368	372	finally
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, PLVideoSaveListener paramPLVideoSaveListener) {
    if (!u.a().a(b.a.af, paramPLVideoSaveListener))
      return false; 
    this.ae = paramBoolean;
    return a(paramInt1, paramInt2, paramInt3, paramPLVideoSaveListener);
  }
  
  public boolean a(PLVideoSaveListener paramPLVideoSaveListener) {
    int i = this.Z;
    if (i == 0 || i == 180) {
      i = g.b(this.b);
    } else {
      i = g.c(this.b);
    } 
    int j = this.Z;
    if (j == 0 || j == 180) {
      j = g.c(this.b);
      return a(i, j, g.e(this.b), paramPLVideoSaveListener);
    } 
    j = g.b(this.b);
    return a(i, j, g.e(this.b), paramPLVideoSaveListener);
  }
  
  public JSONObject b() {
    boolean bool;
    if (this.at == 0) {
      bool = false;
    } else {
      bool = true;
    } 
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("operation_transcode_clip_video", bool);
      jSONObject.put("operation_transcode_video", 1);
      jSONObject.put("data_type", QosManager.a.c);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public void b(int paramInt) {
    if (paramInt > 0)
      this.E = paramInt; 
  }
  
  public void b(List<PLMixAudioFile> paramList) {
    this.an = paramList;
  }
  
  class a implements com.qiniu.pili.droid.shortvideo.d.b.c {
    private boolean b = false;
    
    private int c;
    
    private a(q this$0) {}
    
    private boolean a() {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   4: invokestatic ap : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Ljava/lang/Object;
      //   7: astore_2
      //   8: aload_2
      //   9: monitorenter
      //   10: aload_0
      //   11: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   14: invokestatic l : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Lcom/qiniu/pili/droid/shortvideo/encode/c;
      //   17: invokevirtual l : ()Z
      //   20: ifeq -> 53
      //   23: aload_0
      //   24: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   27: invokestatic at : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Z
      //   30: istore_1
      //   31: iload_1
      //   32: ifne -> 48
      //   35: aload_0
      //   36: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   39: invokestatic ap : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Ljava/lang/Object;
      //   42: invokevirtual wait : ()V
      //   45: goto -> 23
      //   48: iconst_1
      //   49: istore_1
      //   50: goto -> 55
      //   53: iconst_0
      //   54: istore_1
      //   55: iload_1
      //   56: ifeq -> 71
      //   59: aload_0
      //   60: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   63: iconst_0
      //   64: invokestatic d : (Lcom/qiniu/pili/droid/shortvideo/core/q;Z)Z
      //   67: pop
      //   68: goto -> 92
      //   71: aload_0
      //   72: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   75: invokestatic ao : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Lcom/qiniu/pili/droid/shortvideo/d/b;
      //   78: invokevirtual c : ()Z
      //   81: pop
      //   82: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
      //   85: ldc 'ShortVideoTranscoderCore'
      //   87: ldc 'src audio eof, so stop music audio too.'
      //   89: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
      //   92: aload_2
      //   93: monitorexit
      //   94: iload_1
      //   95: ireturn
      //   96: astore_3
      //   97: aload_2
      //   98: monitorexit
      //   99: aload_3
      //   100: athrow
      //   101: astore_3
      //   102: goto -> 53
      // Exception table:
      //   from	to	target	type
      //   10	23	96	finally
      //   23	31	96	finally
      //   35	45	101	java/lang/InterruptedException
      //   35	45	96	finally
      //   59	68	96	finally
      //   71	92	96	finally
      //   92	94	96	finally
      //   97	99	96	finally
    }
    
    private boolean a(ByteBuffer param1ByteBuffer, int param1Int) {
      if (!this.b && !a())
        return false; 
      while (q.p(this.a).a(q.au(this.a), q.av(this.a))) {
        b();
        if (!a())
          return false; 
      } 
      q.p(this.a).b(param1ByteBuffer, param1Int);
      this.b = true;
      return true;
    }
    
    private void b() {
      synchronized (q.aq(this.a)) {
        q.e(this.a, true);
        q.aq(this.a).notify();
        return;
      } 
    }
    
    public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
      if (this.c == 0) {
        q q1 = this.a;
        this.c = q.h(q1, q.an(q1));
      } 
      param1Int = q.a(this.a, param1ByteBuffer, param1Int, this.c);
      e e = e.s;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("music audio frame size: ");
      stringBuilder.append(param1Int);
      stringBuilder.append(" ts: ");
      stringBuilder.append(param1Long1);
      stringBuilder.append(" eof: ");
      stringBuilder.append(param1Boolean);
      e.b("ShortVideoTranscoderCore", stringBuilder.toString());
      q.a(this.a, Thread.currentThread());
      if (param1Boolean) {
        e.s.c("ShortVideoTranscoderCore", "music audio eof, keep producing silent frames for mixing until src audio end.");
        param1ByteBuffer = ByteBuffer.allocateDirect(param1ByteBuffer.capacity());
        while (a(param1ByteBuffer, param1ByteBuffer.capacity()));
      } else {
        a(param1ByteBuffer, param1Int);
      } 
    }
  }
  
  class b implements com.qiniu.pili.droid.shortvideo.d.b.c {
    private int b;
    
    private b(q this$0) {}
    
    private void a() {
      synchronized (q.ap(this.a)) {
        q.d(this.a, true);
        q.ap(this.a).notify();
        return;
      } 
    }
    
    private void b() {
      synchronized (q.aq(this.a)) {
        while (true) {
          boolean bool = q.ar(this.a);
          if (!bool) {
            try {
              q.aq(this.a).wait();
            } catch (InterruptedException interruptedException) {
              return;
            } 
            continue;
          } 
          q.e(this.a, false);
          return;
        } 
      } 
    }
    
    public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: getfield b : I
      //   4: ifne -> 27
      //   7: aload_0
      //   8: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   11: astore #8
      //   13: aload_0
      //   14: aload #8
      //   16: aload #8
      //   18: invokestatic am : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Landroid/media/MediaFormat;
      //   21: invokestatic h : (Lcom/qiniu/pili/droid/shortvideo/core/q;Landroid/media/MediaFormat;)I
      //   24: putfield b : I
      //   27: aload_0
      //   28: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   31: aload_1
      //   32: iload_2
      //   33: aload_0
      //   34: getfield b : I
      //   37: invokestatic a : (Lcom/qiniu/pili/droid/shortvideo/core/q;Ljava/nio/ByteBuffer;II)I
      //   40: istore_2
      //   41: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
      //   44: astore #8
      //   46: new java/lang/StringBuilder
      //   49: dup
      //   50: invokespecial <init> : ()V
      //   53: astore #9
      //   55: aload #9
      //   57: ldc 'src audio frame size: '
      //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   62: pop
      //   63: aload #9
      //   65: iload_2
      //   66: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   69: pop
      //   70: aload #9
      //   72: ldc ' ts: '
      //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: pop
      //   78: aload #9
      //   80: lload_3
      //   81: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   84: pop
      //   85: aload #9
      //   87: ldc ' eof: '
      //   89: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   92: pop
      //   93: aload #9
      //   95: iload #7
      //   97: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   100: pop
      //   101: aload #8
      //   103: ldc 'ShortVideoTranscoderCore'
      //   105: aload #9
      //   107: invokevirtual toString : ()Ljava/lang/String;
      //   110: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
      //   113: aload_0
      //   114: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   117: invokestatic ap : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Ljava/lang/Object;
      //   120: astore #8
      //   122: aload #8
      //   124: monitorenter
      //   125: iload #7
      //   127: ifne -> 205
      //   130: aload_0
      //   131: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   134: invokestatic ak : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Z
      //   137: ifeq -> 143
      //   140: goto -> 205
      //   143: aload #8
      //   145: monitorexit
      //   146: aload_0
      //   147: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   150: aload_1
      //   151: invokestatic a : (Lcom/qiniu/pili/droid/shortvideo/core/q;Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
      //   154: pop
      //   155: aload_0
      //   156: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   159: iload_2
      //   160: invokestatic c : (Lcom/qiniu/pili/droid/shortvideo/core/q;I)I
      //   163: pop
      //   164: aload_0
      //   165: invokespecial a : ()V
      //   168: aload_0
      //   169: invokespecial b : ()V
      //   172: aload_0
      //   173: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   176: invokestatic N : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Ljava/util/ArrayList;
      //   179: ifnull -> 191
      //   182: aload_0
      //   183: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   186: lload #5
      //   188: invokestatic c : (Lcom/qiniu/pili/droid/shortvideo/core/q;J)V
      //   191: aload_0
      //   192: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   195: invokestatic S : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Lcom/qiniu/pili/droid/shortvideo/core/a;
      //   198: aload_1
      //   199: iload_2
      //   200: lload_3
      //   201: invokevirtual c : (Ljava/nio/ByteBuffer;IJ)V
      //   204: return
      //   205: getstatic com/qiniu/pili/droid/shortvideo/f/e.s : Lcom/qiniu/pili/droid/shortvideo/f/e;
      //   208: astore #9
      //   210: new java/lang/StringBuilder
      //   213: dup
      //   214: invokespecial <init> : ()V
      //   217: astore #10
      //   219: aload #10
      //   221: ldc 'received '
      //   223: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   226: pop
      //   227: iload #7
      //   229: ifeq -> 317
      //   232: ldc 'eof'
      //   234: astore_1
      //   235: goto -> 238
      //   238: aload #10
      //   240: aload_1
      //   241: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   244: pop
      //   245: aload #10
      //   247: ldc ', mark audio encoder to stop.'
      //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   252: pop
      //   253: aload #9
      //   255: ldc 'ShortVideoTranscoderCore'
      //   257: aload #10
      //   259: invokevirtual toString : ()Ljava/lang/String;
      //   262: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
      //   265: aload_0
      //   266: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   269: invokestatic n : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Lcom/qiniu/pili/droid/shortvideo/d/b;
      //   272: invokevirtual c : ()Z
      //   275: pop
      //   276: aload_0
      //   277: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   280: invokestatic l : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Lcom/qiniu/pili/droid/shortvideo/encode/c;
      //   283: invokevirtual c : ()Z
      //   286: pop
      //   287: aload_0
      //   288: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   291: invokestatic as : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Ljava/lang/Thread;
      //   294: ifnull -> 307
      //   297: aload_0
      //   298: getfield a : Lcom/qiniu/pili/droid/shortvideo/core/q;
      //   301: invokestatic as : (Lcom/qiniu/pili/droid/shortvideo/core/q;)Ljava/lang/Thread;
      //   304: invokevirtual interrupt : ()V
      //   307: aload #8
      //   309: monitorexit
      //   310: return
      //   311: astore_1
      //   312: aload #8
      //   314: monitorexit
      //   315: aload_1
      //   316: athrow
      //   317: ldc 'cancel'
      //   319: astore_1
      //   320: goto -> 238
      // Exception table:
      //   from	to	target	type
      //   130	140	311	finally
      //   143	146	311	finally
      //   205	227	311	finally
      //   238	307	311	finally
      //   307	310	311	finally
      //   312	315	311	finally
    }
  }
  
  class c implements com.qiniu.pili.droid.shortvideo.d.b.c {
    private int b;
    
    private c(q this$0) {}
    
    public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
      String str;
      if (this.b == 0) {
        MediaFormat mediaFormat;
        if (q.am(this.a) != null) {
          mediaFormat = q.am(this.a);
        } else {
          mediaFormat = q.an(this.a);
        } 
        this.b = q.h(this.a, mediaFormat);
      } 
      param1Int = q.a(this.a, param1ByteBuffer, param1Int, this.b);
      e e = e.s;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("audio frame size: ");
      stringBuilder.append(param1Int);
      stringBuilder.append(" ts: ");
      stringBuilder.append(param1Long2);
      stringBuilder.append(" eof: ");
      stringBuilder.append(param1Boolean);
      e.b("ShortVideoTranscoderCore", stringBuilder.toString());
      if (param1Boolean || q.ak(this.a) || (q.ao(this.a) != null && param1Long2 >= q.O(this.a))) {
        if (param1Boolean) {
          str = "eof";
        } else if (q.ak(this.a)) {
          str = "cancel";
        } else {
          str = "music exceed video duration";
        } 
        e = e.s;
        stringBuilder = new StringBuilder();
        stringBuilder.append("received ");
        stringBuilder.append(str);
        stringBuilder.append(", mark audio encoder to stop.");
        e.c("ShortVideoTranscoderCore", stringBuilder.toString());
        if (q.n(this.a) != null)
          q.n(this.a).c(); 
        if (q.ao(this.a) != null)
          q.ao(this.a).c(); 
        q.l(this.a).c();
        return;
      } 
      if (q.N(this.a) != null)
        q.c(this.a, param1Long2); 
      q.S(this.a).c((ByteBuffer)str, param1Int, param1Long2);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */