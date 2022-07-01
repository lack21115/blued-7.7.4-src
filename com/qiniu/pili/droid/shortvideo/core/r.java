package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.PLShortVideoTrimmer;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.g;
import com.qiniu.pili.droid.shortvideo.f.j;
import com.qiniu.pili.droid.shortvideo.muxer.FFMP4Demuxer;
import com.qiniu.pili.droid.shortvideo.muxer.FFMP4Muxer;
import java.io.File;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

public class r {
  private Context a;
  
  private q b;
  
  private PLShortVideoTrimmer.TRIM_MODE c;
  
  private volatile boolean d;
  
  private String e;
  
  private String f;
  
  private long g;
  
  private double h = 1.0D;
  
  private PLVideoSaveListener i;
  
  public r(Context paramContext, String paramString1, String paramString2) {
    e.p.c("ShortVideoTrimmerCore", "init +");
    paramContext = paramContext.getApplicationContext();
    l.a(paramContext);
    this.a = paramContext;
    this.e = paramString1;
    this.f = l.a(paramContext, paramString2);
    this.g = g.a(paramString1);
    e e = e.n;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("src video duration in Ms: ");
    stringBuilder.append(this.g);
    e.c("ShortVideoTrimmerCore", stringBuilder.toString());
    e.p.c("ShortVideoTrimmerCore", "init -");
  }
  
  private void a(long paramLong1, long paramLong2) {
    FFMP4Muxer fFMP4Muxer = new FFMP4Muxer();
    FFMP4Demuxer fFMP4Demuxer = new FFMP4Demuxer();
    if (!fFMP4Demuxer.a(this.e)) {
      if (this.i != null) {
        e.p.e("ShortVideoTrimmerCore", "demuxer open file failed !");
        this.i.onSaveVideoFailed(0);
        QosManager.a().a(0);
      } 
      return;
    } 
    if (!fFMP4Muxer.a(this.f, fFMP4Demuxer)) {
      fFMP4Demuxer.l();
      if (this.i != null) {
        e.p.e("ShortVideoTrimmerCore", "muxer start failed !");
        this.i.onSaveVideoFailed(0);
        QosManager.a().a(0);
      } 
      return;
    } 
    (new Thread(new a(this, fFMP4Muxer, fFMP4Demuxer, paramLong1, paramLong2))).start();
  }
  
  private void b(long paramLong1, long paramLong2) {
    this.b = new q(this.a, this.e, this.f);
    this.b.a(paramLong1, paramLong2);
    this.b.a(this.h);
    this.b.a(this.i);
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Lcom/qiniu/pili/droid/shortvideo/PLShortVideoTrimmer$TRIM_MODE;
    //   6: getstatic com/qiniu/pili/droid/shortvideo/PLShortVideoTrimmer$TRIM_MODE.FAST : Lcom/qiniu/pili/droid/shortvideo/PLShortVideoTrimmer$TRIM_MODE;
    //   9: if_acmpne -> 20
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield d : Z
    //   17: goto -> 34
    //   20: aload_0
    //   21: getfield b : Lcom/qiniu/pili/droid/shortvideo/core/q;
    //   24: ifnull -> 34
    //   27: aload_0
    //   28: getfield b : Lcom/qiniu/pili/droid/shortvideo/core/q;
    //   31: invokevirtual a : ()V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	37	finally
    //   20	34	37	finally
  }
  
  public void a(double paramDouble) {
    if (j.a(paramDouble)) {
      e e = e.p;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("set speed to: ");
      stringBuilder.append(paramDouble);
      e.c("ShortVideoTrimmerCore", stringBuilder.toString());
      this.h = paramDouble;
      return;
    } 
    e.p.d("ShortVideoTrimmerCore", "only support multiple of 2 !!!");
  }
  
  public void a(long paramLong1, long paramLong2, PLShortVideoTrimmer.TRIM_MODE paramTRIM_MODE, PLVideoSaveListener paramPLVideoSaveListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/core/u;
    //   5: getstatic com/qiniu/pili/droid/shortvideo/core/b$a.Z : Lcom/qiniu/pili/droid/shortvideo/core/b$a;
    //   8: aload #6
    //   10: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/core/b$a;Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;)Z
    //   13: istore #7
    //   15: iload #7
    //   17: ifne -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield e : Ljava/lang/String;
    //   27: ifnonnull -> 43
    //   30: getstatic com/qiniu/pili/droid/shortvideo/f/e.p : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   33: ldc 'ShortVideoTrimmerCore'
    //   35: ldc 'src file path is null, return now.'
    //   37: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: aload_0
    //   44: aload #6
    //   46: putfield i : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   49: lload_1
    //   50: lconst_0
    //   51: lcmp
    //   52: ifgt -> 106
    //   55: lload_3
    //   56: aload_0
    //   57: getfield g : J
    //   60: lcmp
    //   61: iflt -> 106
    //   64: aload_0
    //   65: getfield h : D
    //   68: dconst_1
    //   69: dcmpl
    //   70: ifne -> 106
    //   73: getstatic com/qiniu/pili/droid/shortvideo/f/e.p : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   76: ldc 'ShortVideoTrimmerCore'
    //   78: ldc 'trim range is the whole file, return the original file.'
    //   80: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: getfield i : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   87: ifnull -> 103
    //   90: aload_0
    //   91: getfield i : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   94: aload_0
    //   95: getfield e : Ljava/lang/String;
    //   98: invokeinterface onSaveVideoSuccess : (Ljava/lang/String;)V
    //   103: aload_0
    //   104: monitorexit
    //   105: return
    //   106: lload_1
    //   107: ldc2_w 1000
    //   110: lmul
    //   111: lstore_1
    //   112: lload_3
    //   113: ldc2_w 1000
    //   116: lmul
    //   117: lstore_3
    //   118: aload_0
    //   119: aload #5
    //   121: putfield c : Lcom/qiniu/pili/droid/shortvideo/PLShortVideoTrimmer$TRIM_MODE;
    //   124: getstatic com/qiniu/pili/droid/shortvideo/f/e.p : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   127: astore #6
    //   129: new java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial <init> : ()V
    //   136: astore #8
    //   138: aload #8
    //   140: ldc 'except trim from time Us: '
    //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload #8
    //   148: lload_1
    //   149: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload #8
    //   155: ldc ' - '
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload #8
    //   163: lload_3
    //   164: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload #8
    //   170: ldc ' mode: '
    //   172: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload #8
    //   178: aload #5
    //   180: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload #6
    //   186: ldc 'ShortVideoTrimmerCore'
    //   188: aload #8
    //   190: invokevirtual toString : ()Ljava/lang/String;
    //   193: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload #5
    //   198: getstatic com/qiniu/pili/droid/shortvideo/PLShortVideoTrimmer$TRIM_MODE.FAST : Lcom/qiniu/pili/droid/shortvideo/PLShortVideoTrimmer$TRIM_MODE;
    //   201: if_acmpne -> 213
    //   204: aload_0
    //   205: lload_1
    //   206: lload_3
    //   207: invokespecial a : (JJ)V
    //   210: goto -> 219
    //   213: aload_0
    //   214: lload_1
    //   215: lload_3
    //   216: invokespecial b : (JJ)V
    //   219: aload_0
    //   220: monitorexit
    //   221: return
    //   222: astore #5
    //   224: aload_0
    //   225: monitorexit
    //   226: aload #5
    //   228: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	222	finally
    //   23	40	222	finally
    //   43	49	222	finally
    //   55	103	222	finally
    //   118	210	222	finally
    //   213	219	222	finally
  }
  
  public void b() {}
  
  public JSONObject c() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("operation_trim_video", 1);
      jSONObject.put("data_type", QosManager.a.c);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  class a implements Runnable {
    private FFMP4Muxer b;
    
    private FFMP4Demuxer c;
    
    private long d;
    
    private long e;
    
    public a(r this$0, FFMP4Muxer param1FFMP4Muxer, FFMP4Demuxer param1FFMP4Demuxer, long param1Long1, long param1Long2) {
      this.b = param1FFMP4Muxer;
      this.c = param1FFMP4Demuxer;
      this.d = param1Long1;
      this.e = param1Long2;
    }
    
    public void run() {
      int i = this.c.a();
      int j = this.c.b();
      if (i >= 0) {
        this.c.a(i, this.d / 1000L, 1);
      } else if (j >= 0) {
        this.c.a(j, this.d / 1000L, 1);
      } 
      while (true) {
        long l = this.c.i();
        if (l != 0L) {
          boolean bool;
          if (r.a(this.a)) {
            e.n.c("ShortVideoTrimmerCore", "trim video canceled");
            this.c.l();
            this.b.a();
            (new File(r.b(this.a))).delete();
            if (r.c(this.a) != null)
              r.c(this.a).onSaveVideoCanceled(); 
            return;
          } 
          int k = this.c.a(l);
          byte[] arrayOfByte = this.c.b(l);
          int m = this.c.c(l);
          if (this.c.d(l) == 1) {
            bool = true;
          } else {
            bool = false;
          } 
          long l1 = this.c.e(l);
          long l2 = this.c.f(l);
          int n = (int)this.c.g(l);
          l = this.c.a(k, l1);
          i = this.c.g();
          j = this.c.h();
          if (k == this.c.b()) {
            i = this.c.e();
            j = this.c.f();
          } 
          if (l >= this.e && k == this.c.a())
            break; 
          ByteBuffer byteBuffer = ByteBuffer.allocateDirect(m);
          byteBuffer.put(arrayOfByte);
          byteBuffer.clear();
          this.b.a(k, byteBuffer, byteBuffer.capacity(), bool, l1, l2, n, i, j);
          if (r.c(this.a) != null && k == this.c.a()) {
            PLVideoSaveListener pLVideoSaveListener = r.c(this.a);
            l1 = this.d;
            pLVideoSaveListener.onProgressUpdate((float)(l - l1) * 1.0F / (float)(this.e - l1));
          } 
          continue;
        } 
        break;
      } 
      if (r.c(this.a) != null)
        r.c(this.a).onProgressUpdate(1.0F); 
      this.c.l();
      if (this.b.a()) {
        if (r.c(this.a) != null) {
          r.c(this.a).onSaveVideoSuccess(r.b(this.a));
          return;
        } 
      } else if (r.c(this.a) != null) {
        r.c(this.a).onSaveVideoFailed(0);
        QosManager.a().a(0);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */