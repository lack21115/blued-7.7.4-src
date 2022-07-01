package com.qiniu.pili.droid.shortvideo.core;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Handler;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import com.qiniu.pili.droid.shortvideo.PLImageView;
import com.qiniu.pili.droid.shortvideo.PLPositionTransition;
import com.qiniu.pili.droid.shortvideo.PLTextView;
import com.qiniu.pili.droid.shortvideo.PLTransition;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.encode.e;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.j;
import com.qiniu.pili.droid.shortvideo.gl.a.d;
import com.qiniu.pili.droid.shortvideo.gl.a.f;
import com.qiniu.pili.droid.shortvideo.gl.c.f;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import com.qiniu.pili.droid.shortvideo.gl.c.m;
import com.qiniu.pili.droid.shortvideo.muxer.b;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class s implements Runnable {
  private static final PLVideoSaveListener x = new PLVideoSaveListener() {
      public void onProgressUpdate(float param1Float) {
        e e = e.v;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onProgressUpdate: ");
        stringBuilder.append(param1Float);
        e.c("TransitionMakerCore", stringBuilder.toString());
      }
      
      public void onSaveVideoCanceled() {
        e.v.c("TransitionMakerCore", "onSaveVideoCanceled");
      }
      
      public void onSaveVideoFailed(int param1Int) {
        e e = e.v;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSaveVideoFailed: ");
        stringBuilder.append(param1Int);
        e.c("TransitionMakerCore", stringBuilder.toString());
      }
      
      public void onSaveVideoSuccess(String param1String) {
        e e = e.v;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSaveVideoSuccess: ");
        stringBuilder.append(param1String);
        e.c("TransitionMakerCore", stringBuilder.toString());
      }
    };
  
  private ViewGroup a;
  
  private PLVideoEncodeSetting b;
  
  private String c;
  
  private PLVideoSaveListener d;
  
  private f e;
  
  private d f;
  
  private g g;
  
  private f h;
  
  private volatile Surface i;
  
  private b j;
  
  private e k;
  
  private MediaFormat l;
  
  private volatile boolean m;
  
  private volatile boolean n;
  
  private volatile boolean o;
  
  private long p;
  
  private long q;
  
  private long r;
  
  private int s;
  
  private Hashtable<View, a> t = new Hashtable<View, a>();
  
  private Hashtable<View, AnimatorSet> u = new Hashtable<View, AnimatorSet>();
  
  private Handler v = new Handler();
  
  private com.qiniu.pili.droid.shortvideo.encode.a.a w = new com.qiniu.pili.droid.shortvideo.encode.a.a(this) {
      public void a(MediaFormat param1MediaFormat) {
        e.v.c("TransitionMakerCore", "video onEncodedFormatChanged ");
        s.a(this.a, param1MediaFormat);
        s.e(this.a);
      }
      
      public void a(Surface param1Surface) {
        e.v.c("TransitionMakerCore", "video onSurfaceCreated ");
        s.a(this.a, param1Surface);
        (new Thread(this.a)).start();
      }
      
      public void a(ByteBuffer param1ByteBuffer, MediaCodec.BufferInfo param1BufferInfo) {
        if (s.f(this.a)) {
          s.g(this.a).a(param1ByteBuffer, param1BufferInfo);
          e e1 = e.v;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("writeVideo ");
          stringBuilder1.append(param1BufferInfo.presentationTimeUs);
          e1.b("TransitionMakerCore", stringBuilder1.toString());
          s.c(this.a).onProgressUpdate((float)param1BufferInfo.presentationTimeUs * 1.0F / (float)s.h(this.a));
          return;
        } 
        e e = e.v;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video frame not write  ");
        stringBuilder.append(param1BufferInfo.presentationTimeUs);
        e.b("TransitionMakerCore", stringBuilder.toString());
      }
      
      public void a(boolean param1Boolean) {
        e e = e.v;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("encode started result: ");
        stringBuilder.append(param1Boolean);
        e.c("TransitionMakerCore", stringBuilder.toString());
        if (!param1Boolean)
          s.c(this.a).onSaveVideoFailed(6); 
      }
      
      public void b(boolean param1Boolean) {
        e.v.c("TransitionMakerCore", "encode stopped");
        s.a(this.a, (MediaFormat)null);
        s.d(this.a);
      }
    };
  
  public s(ViewGroup paramViewGroup, PLVideoEncodeSetting paramPLVideoEncodeSetting) {
    this.a = paramViewGroup;
    this.b = paramPLVideoEncodeSetting;
    l.a(paramViewGroup.getContext().getApplicationContext());
  }
  
  private g a(int paramInt1, int paramInt2) {
    g g1 = new g();
    g1.a(paramInt1, paramInt2);
    g1.b();
    return g1;
  }
  
  private m a(View paramView, a parama) {
    m m = new m(parama.b);
    m.a(false);
    m.a(paramView.getAlpha());
    m.b((int)paramView.getRotation());
    m.b(parama.c / this.a.getWidth(), parama.d / this.a.getHeight());
    Iterator<PLTransition> iterator = parama.a.iterator();
    while (iterator.hasNext())
      m.a(iterator.next()); 
    m.a(this.b.getVideoEncodingWidth(), this.b.getVideoEncodingHeight());
    m.b();
    return m;
  }
  
  private boolean a(String paramString) {
    if (paramString == null) {
      e.v.e("TransitionMakerCore", "dest video path is wrong!");
      return false;
    } 
    File file = (new File(paramString)).getParentFile();
    if (!file.exists() && !file.mkdir()) {
      e e1 = e.v;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("failed to mkdir: ");
      stringBuilder.append(file.getAbsolutePath());
      e1.e("TransitionMakerCore", stringBuilder.toString());
      return false;
    } 
    return true;
  }
  
  private f b(int paramInt1, int paramInt2) {
    f f1 = new f();
    f1.a(paramInt1, paramInt2);
    f1.b();
    return f1;
  }
  
  private void g() {
    Iterator<Map.Entry> iterator = this.u.entrySet().iterator();
    while (iterator.hasNext()) {
      AnimatorSet animatorSet = (AnimatorSet)((Map.Entry)iterator.next()).getValue();
      animatorSet.cancel();
      animatorSet.start();
    } 
  }
  
  private void h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield l : Landroid/media/MediaFormat;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: new com/qiniu/pili/droid/shortvideo/muxer/b
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putfield j : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   25: aload_0
    //   26: getfield j : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   29: aload_0
    //   30: getfield c : Ljava/lang/String;
    //   33: aload_0
    //   34: getfield l : Landroid/media/MediaFormat;
    //   37: aconst_null
    //   38: iconst_0
    //   39: invokevirtual a : (Ljava/lang/String;Landroid/media/MediaFormat;Landroid/media/MediaFormat;I)Z
    //   42: ifne -> 59
    //   45: getstatic com/qiniu/pili/droid/shortvideo/f/e.v : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   48: ldc 'TransitionMakerCore'
    //   50: ldc_w 'start output muxer failed!'
    //   53: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   56: goto -> 75
    //   59: aload_0
    //   60: iconst_1
    //   61: putfield n : Z
    //   64: getstatic com/qiniu/pili/droid/shortvideo/f/e.v : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   67: ldc 'TransitionMakerCore'
    //   69: ldc_w 'start output muxer success!'
    //   72: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	78	finally
    //   14	56	78	finally
    //   59	75	78	finally
  }
  
  private void i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield l : Landroid/media/MediaFormat;
    //   6: ifnonnull -> 132
    //   9: aload_0
    //   10: getfield n : Z
    //   13: ifne -> 19
    //   16: goto -> 132
    //   19: aload_0
    //   20: getfield j : Lcom/qiniu/pili/droid/shortvideo/muxer/b;
    //   23: invokevirtual a : ()Z
    //   26: istore_1
    //   27: aload_0
    //   28: getfield m : Z
    //   31: ifeq -> 61
    //   34: new java/io/File
    //   37: dup
    //   38: aload_0
    //   39: getfield c : Ljava/lang/String;
    //   42: invokespecial <init> : (Ljava/lang/String;)V
    //   45: invokevirtual delete : ()Z
    //   48: pop
    //   49: aload_0
    //   50: getfield d : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   53: invokeinterface onSaveVideoCanceled : ()V
    //   58: goto -> 108
    //   61: aload_0
    //   62: getfield d : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   65: fconst_1
    //   66: invokeinterface onProgressUpdate : (F)V
    //   71: iload_1
    //   72: ifeq -> 91
    //   75: aload_0
    //   76: getfield d : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   79: aload_0
    //   80: getfield c : Ljava/lang/String;
    //   83: invokeinterface onSaveVideoSuccess : (Ljava/lang/String;)V
    //   88: goto -> 108
    //   91: aload_0
    //   92: getfield d : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   95: iconst_3
    //   96: invokeinterface onSaveVideoFailed : (I)V
    //   101: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/core/QosManager;
    //   104: iconst_3
    //   105: invokevirtual a : (I)V
    //   108: aload_0
    //   109: iconst_0
    //   110: putfield n : Z
    //   113: aload_0
    //   114: iconst_0
    //   115: putfield o : Z
    //   118: getstatic com/qiniu/pili/droid/shortvideo/f/e.v : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   121: ldc 'TransitionMakerCore'
    //   123: ldc_w 'save stopped !'
    //   126: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: monitorexit
    //   131: return
    //   132: aload_0
    //   133: monitorexit
    //   134: return
    //   135: astore_2
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_2
    //   139: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	135	finally
    //   19	58	135	finally
    //   61	71	135	finally
    //   75	88	135	finally
    //   91	108	135	finally
    //   108	129	135	finally
  }
  
  public void a() {
    this.v.removeCallbacksAndMessages(null);
    this.t.clear();
    Iterator<Map.Entry> iterator = this.u.entrySet().iterator();
    while (iterator.hasNext()) {
      AnimatorSet animatorSet = (AnimatorSet)((Map.Entry)iterator.next()).getValue();
      animatorSet.end();
      animatorSet.cancel();
    } 
    this.u.clear();
    this.a.removeAllViews();
  }
  
  public void a(int paramInt) {
    this.r = (paramInt * 1000);
  }
  
  public void a(View paramView, PLTransition paramPLTransition) {
    if (this.t.containsKey(paramView)) {
      ((a)this.t.get(paramView)).a.add(paramPLTransition);
      return;
    } 
    LinkedList<PLTransition> linkedList = new LinkedList();
    linkedList.add(paramPLTransition);
    a a1 = new a(this, linkedList);
    this.t.put(paramView, a1);
  }
  
  public void a(PLImageView paramPLImageView) {
    this.a.addView((View)paramPLImageView);
  }
  
  public void a(PLTextView paramPLTextView) {
    this.a.addView((View)paramPLTextView);
  }
  
  public void a(String paramString, PLVideoSaveListener paramPLVideoSaveListener) {
    e.v.c("TransitionMakerCore", "save +");
    if (!u.a().a(b.a.ag, paramPLVideoSaveListener))
      return; 
    if (this.o) {
      e.v.e("TransitionMakerCore", "transition make: save already started");
      return;
    } 
    if (!a(paramString)) {
      e.v.e("TransitionMakerCore", "transition make: dstVideoPath is wrong!");
      return;
    } 
    this.o = true;
    this.c = paramString;
    this.q = 0L;
    this.m = false;
    for (Map.Entry<View, a> entry : this.t.entrySet()) {
      View view = (View)entry.getKey();
      float f1 = this.b.getVideoEncodingWidth() / this.a.getWidth();
      Bitmap bitmap = j.a(view);
      Matrix matrix = new Matrix();
      matrix.postScale(f1, f1);
      bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
      ((a)entry.getValue()).b = bitmap;
      for (PLTransition pLTransition : ((a)entry.getValue()).a) {
        if (pLTransition instanceof PLPositionTransition)
          ((PLPositionTransition)pLTransition).a(this.a.getWidth(), this.a.getHeight()); 
      } 
    } 
    PLVideoSaveListener pLVideoSaveListener = paramPLVideoSaveListener;
    if (paramPLVideoSaveListener == null)
      pLVideoSaveListener = x; 
    this.d = pLVideoSaveListener;
    this.p = 1000000L / this.b.getVideoEncodingFps();
    this.k = new e(this.b);
    this.k.a(this.w);
    this.k.a();
    e.v.c("TransitionMakerCore", "save -");
  }
  
  public void b() {
    this.v.removeCallbacksAndMessages(null);
    Iterator<Map.Entry> iterator = this.u.entrySet().iterator();
    while (iterator.hasNext()) {
      AnimatorSet animatorSet = (AnimatorSet)((Map.Entry)iterator.next()).getValue();
      animatorSet.end();
      animatorSet.cancel();
    } 
  }
  
  public void b(int paramInt) {
    this.a.setBackgroundColor(paramInt);
    this.s = paramInt;
  }
  
  public void c() {
    long l = this.r / 1000L;
    Runnable runnable = new Runnable(this, l) {
        public void run() {
          s.a(this.b);
          s.b(this.b).postDelayed(this, this.a);
        }
      };
    if (!this.u.isEmpty()) {
      g();
      this.v.removeCallbacksAndMessages(null);
      this.v.postDelayed(runnable, l);
      return;
    } 
    if (!this.t.isEmpty()) {
      for (Map.Entry<View, a> entry : this.t.entrySet()) {
        View view = (View)entry.getKey();
        a a1 = (a)entry.getValue();
        a1.c = view.getX();
        a1.d = view.getY();
        LinkedList<PLTransition> linkedList = a1.a;
        ArrayList<Animator> arrayList = new ArrayList();
        AnimatorSet animatorSet = new AnimatorSet();
        Iterator<PLTransition> iterator = linkedList.iterator();
        while (iterator.hasNext())
          arrayList.add(((PLTransition)iterator.next()).a(view)); 
        animatorSet.playTogether(arrayList);
        animatorSet.start();
        this.u.put(view, animatorSet);
      } 
      this.v.postDelayed(runnable, l);
    } 
  }
  
  public void d() {
    e.v.c("TransitionMakerCore", "cancel save");
    this.m = true;
  }
  
  public void e() {
    this.v.removeCallbacksAndMessages(null);
  }
  
  public JSONObject f() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("operation_transition_make", 1);
      jSONObject.put("data_type", QosManager.a.c);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public void run() {
    int i;
    this.f = new d(null, 1);
    d d1 = this.f;
    Surface surface = this.i;
    boolean bool = false;
    this.e = new f(d1, surface, false);
    this.e.b();
    this.g = a(this.b.getVideoEncodingWidth(), this.b.getVideoEncodingHeight());
    this.h = b(this.b.getVideoEncodingWidth(), this.b.getVideoEncodingHeight());
    int k = d.a(null, this.b.getVideoEncodingWidth(), this.b.getVideoEncodingHeight(), 6408);
    m[] arrayOfM = new m[this.t.size()];
    Iterator<Map.Entry> iterator = this.t.entrySet().iterator();
    int j = 0;
    while (true) {
      i = k;
      if (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        arrayOfM[j] = a((View)entry.getKey(), (a)entry.getValue());
        j++;
        continue;
      } 
      break;
    } 
    while (true) {
      j = bool;
      if (this.q <= this.r) {
        j = bool;
        if (!this.m) {
          GLES20.glClear(16384);
          i = this.h.a(i, Color.red(this.s) / 255.0F, Color.green(this.s) / 255.0F, Color.blue(this.s) / 255.0F);
          long l = this.q * 1000L;
          for (j = 0; j < arrayOfM.length; j++)
            i = arrayOfM[j].a(i, l); 
          this.g.b(i);
          this.e.a(l);
          this.e.c();
          this.k.a(l);
          this.q += this.p;
          continue;
        } 
      } 
      break;
    } 
    while (j < arrayOfM.length) {
      arrayOfM[j].f();
      j++;
    } 
    this.g.f();
    this.h.f();
    this.e.d();
    this.f.a();
    this.k.c();
  }
  
  class a {
    LinkedList<PLTransition> a;
    
    Bitmap b;
    
    float c;
    
    float d;
    
    public a(s this$0, LinkedList<PLTransition> param1LinkedList) {
      this.a = param1LinkedList;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */