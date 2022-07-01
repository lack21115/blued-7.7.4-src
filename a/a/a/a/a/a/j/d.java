package a.a.a.a.a.a.j;

import a.a.a.a.a.a.h.h;
import a.a.a.a.a.b.i.g;
import a.a.a.a.a.b.i.j;
import a.a.a.a.a.b.i.o;
import a.a.a.a.a.b.i.p;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.qiniu.pili.droid.streaming.FrameCapturedCallback;
import com.qiniu.pili.droid.streaming.PreviewAppearance;
import com.qiniu.pili.droid.streaming.SurfaceTextureCallback2;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;

public class d extends f {
  public h a;
  
  public a.a.a.a.a.a.h.d b;
  
  public e c;
  
  public j d;
  
  public p e;
  
  public o f;
  
  public g g;
  
  public List<WeakReference<View>> h = new LinkedList<WeakReference<View>>();
  
  public WeakHashMap<View, ViewGroup> i = new WeakHashMap<View, ViewGroup>();
  
  public WeakHashMap<View, a.a.a.a.a.b.i.d> j = new WeakHashMap<View, a.a.a.a.a.b.i.d>();
  
  public WeakHashMap<View, Pair<Integer, Integer>> k = new WeakHashMap<View, Pair<Integer, Integer>>();
  
  public volatile boolean l;
  
  public final Object m = new Object();
  
  public volatile boolean n;
  
  public int o;
  
  public int p;
  
  public SurfaceTextureCallback2 q;
  
  public volatile e r;
  
  public WeakReference<GLSurfaceView> s;
  
  public void a() {
    synchronized (this.m) {
      Iterator<WeakReference<View>> iterator = this.h.iterator();
      while (iterator.hasNext()) {
        View view = ((WeakReference<View>)iterator.next()).get();
        iterator.remove();
        if (this.r != null && view != null)
          this.r.sendMessage(this.r.obtainMessage(5, view)); 
      } 
      return;
    } 
  }
  
  public void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : La/a/a/a/a/a/j/e;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull -> 16
    //   11: aload_2
    //   12: iload_1
    //   13: invokevirtual a : (I)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	19	finally
    //   11	16	19	finally
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void a(d paramd) {
    this.i.put(paramd.a, paramd.b);
    c(paramd.a);
  }
  
  public final void a(f paramf) {
    // Byte code:
    //   0: aload_1
    //   1: getfield a : Landroid/view/View;
    //   4: astore_3
    //   5: aload_0
    //   6: getfield m : Ljava/lang/Object;
    //   9: astore #4
    //   11: aload #4
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield h : Ljava/util/List;
    //   18: invokeinterface iterator : ()Ljava/util/Iterator;
    //   23: astore #5
    //   25: aload #5
    //   27: invokeinterface hasNext : ()Z
    //   32: ifeq -> 122
    //   35: aload #5
    //   37: invokeinterface next : ()Ljava/lang/Object;
    //   42: checkcast java/lang/ref/WeakReference
    //   45: invokevirtual get : ()Ljava/lang/Object;
    //   48: aload_3
    //   49: if_acmpne -> 25
    //   52: iconst_1
    //   53: istore_2
    //   54: goto -> 57
    //   57: aload #4
    //   59: monitorexit
    //   60: iload_2
    //   61: ifeq -> 115
    //   64: aload_1
    //   65: getfield b : Z
    //   68: ifeq -> 110
    //   71: aload_0
    //   72: aload_3
    //   73: invokevirtual e : (Landroid/view/View;)V
    //   76: iconst_1
    //   77: newarray boolean
    //   79: astore_1
    //   80: aload_3
    //   81: new a/a/a/a/a/a/j/d$b
    //   84: dup
    //   85: aload_0
    //   86: aload_1
    //   87: invokespecial <init> : (La/a/a/a/a/a/j/d;[Z)V
    //   90: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   93: pop
    //   94: aload_1
    //   95: iconst_0
    //   96: baload
    //   97: ifne -> 103
    //   100: goto -> 94
    //   103: aload_0
    //   104: aload_3
    //   105: invokevirtual c : (Landroid/view/View;)La/a/a/a/a/b/i/d;
    //   108: pop
    //   109: return
    //   110: aload_0
    //   111: aload_3
    //   112: invokevirtual d : (Landroid/view/View;)V
    //   115: return
    //   116: astore_1
    //   117: aload #4
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: iconst_0
    //   123: istore_2
    //   124: goto -> 57
    // Exception table:
    //   from	to	target	type
    //   14	25	116	finally
    //   25	52	116	finally
    //   57	60	116	finally
    //   117	120	116	finally
  }
  
  public void a(f.a parama) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 19
    //   6: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   9: ldc 'TextureMovieTransfer'
    //   11: ldc 'config is null when startEncoding'
    //   13: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield t : La/a/a/a/a/f/c;
    //   23: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   26: if_acmpne -> 42
    //   29: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   32: ldc 'TextureMovieTransfer'
    //   34: ldc 'startEncoding failed as already being running'
    //   36: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: getfield t : La/a/a/a/a/f/c;
    //   46: getstatic a/a/a/a/a/f/c.d : La/a/a/a/a/f/c;
    //   49: if_acmpne -> 77
    //   52: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   55: ldc 'TextureMovieTransfer'
    //   57: ldc 'set pending action as START'
    //   59: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_0
    //   63: getstatic a/a/a/a/a/f/a.b : La/a/a/a/a/f/a;
    //   66: putfield u : La/a/a/a/a/f/a;
    //   69: aload_0
    //   70: aload_1
    //   71: putfield x : La/a/a/a/a/a/j/f$a;
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: aload_0
    //   78: getfield t : La/a/a/a/a/f/c;
    //   81: getstatic a/a/a/a/a/f/c.b : La/a/a/a/a/f/c;
    //   84: if_acmpne -> 122
    //   87: aload_0
    //   88: getfield u : La/a/a/a/a/f/a;
    //   91: getstatic a/a/a/a/a/f/a.c : La/a/a/a/a/f/a;
    //   94: if_acmpne -> 119
    //   97: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   100: ldc 'TextureMovieTransfer'
    //   102: ldc 'set pending action as RESTART'
    //   104: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: getstatic a/a/a/a/a/f/a.d : La/a/a/a/a/f/a;
    //   111: putfield u : La/a/a/a/a/f/a;
    //   114: aload_0
    //   115: aload_1
    //   116: putfield x : La/a/a/a/a/a/j/f$a;
    //   119: aload_0
    //   120: monitorexit
    //   121: return
    //   122: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   125: ldc 'TextureMovieTransfer'
    //   127: ldc 'startEncoding +'
    //   129: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: aload_1
    //   134: putfield w : La/a/a/a/a/a/j/f$a;
    //   137: aload_0
    //   138: getstatic a/a/a/a/a/f/c.b : La/a/a/a/a/f/c;
    //   141: putfield t : La/a/a/a/a/f/c;
    //   144: new android/os/HandlerThread
    //   147: dup
    //   148: ldc 'TextureMovieTransfer'
    //   150: invokespecial <init> : (Ljava/lang/String;)V
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual start : ()V
    //   158: aload_0
    //   159: new a/a/a/a/a/a/j/d$e
    //   162: dup
    //   163: aload_1
    //   164: invokevirtual getLooper : ()Landroid/os/Looper;
    //   167: aload_0
    //   168: invokespecial <init> : (Landroid/os/Looper;La/a/a/a/a/a/j/d;)V
    //   171: putfield r : La/a/a/a/a/a/j/d$e;
    //   174: aload_0
    //   175: getfield r : La/a/a/a/a/a/j/d$e;
    //   178: iconst_0
    //   179: invokevirtual sendEmptyMessage : (I)Z
    //   182: pop
    //   183: aload_0
    //   184: monitorexit
    //   185: return
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    // Exception table:
    //   from	to	target	type
    //   6	16	186	finally
    //   19	39	186	finally
    //   42	74	186	finally
    //   77	119	186	finally
    //   122	183	186	finally
  }
  
  public void a(View paramView) {
    if (paramView == null) {
      a.a.a.a.a.e.e.f.d("TextureMovieTransfer", "view is null, cannot remove");
      return;
    } 
    synchronized (this.m) {
      for (WeakReference<View> weakReference : this.h) {
        if (weakReference.get() == paramView) {
          this.h.remove(weakReference);
          if (this.r != null)
            this.r.sendMessage(this.r.obtainMessage(5, paramView)); 
          break;
        } 
      } 
      return;
    } 
  }
  
  public final void a(View paramView, a.a.a.a.a.b.i.d paramd) {
    Pair pair = this.k.get(paramView);
    WeakReference<GLSurfaceView> weakReference = this.s;
    if (weakReference != null) {
      GLSurfaceView gLSurfaceView = weakReference.get();
    } else {
      weakReference = null;
    } 
    if (pair != null && weakReference != null) {
      int i = weakReference.getWidth();
      int k = weakReference.getHeight();
      int m = ((Integer)pair.first).intValue();
      int n = ((Integer)pair.second).intValue();
      ViewGroup viewGroup2 = this.i.get(paramView);
      ViewGroup viewGroup1 = (ViewGroup)paramView.getParent();
      float f2 = 0.0F;
      float f1 = 0.0F;
      while (viewGroup2 != null && viewGroup1 != null && viewGroup1 != viewGroup2) {
        f2 += viewGroup1.getX();
        f1 += viewGroup1.getY();
        viewGroup1 = (ViewGroup)viewGroup1.getParent();
      } 
      paramd.a(paramView.getAlpha());
      paramd.a((int)paramView.getRotation());
      float f5 = paramView.getX();
      float f4 = paramView.getScaleX();
      float f3 = m;
      float f6 = (1.0F - f4) * f3 / 2.0F;
      f4 = i;
      f2 = (f5 + f2 + f6) / f4;
      f5 = paramView.getY();
      float f7 = paramView.getScaleY();
      f6 = n;
      f7 = (1.0F - f7) * f6 / 2.0F;
      float f8 = k;
      paramd.b(f2, (f5 + f1 + f7) / f8);
      paramd.a(paramView.getScaleX() * f3 / f4, paramView.getScaleY() * f6 / f8);
    } 
  }
  
  public void a(View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      a.a.a.a.a.e.e.f.d("TextureMovieTransfer", "view is null, cannot add");
      return;
    } 
    synchronized (this.m) {
      Iterator<WeakReference<View>> iterator = this.h.iterator();
      while (iterator.hasNext()) {
        if (((WeakReference<View>)iterator.next()).get() == paramView) {
          a.a.a.a.a.e.e.f.d("TextureMovieTransfer", "view already existed in list!");
          return;
        } 
      } 
      this.h.add(new WeakReference<View>(paramView));
      if (this.r != null)
        this.r.sendMessage(this.r.obtainMessage(4, new d(this, paramView, paramViewGroup))); 
      return;
    } 
  }
  
  public void a(View paramView, boolean paramBoolean) {
    if (paramView == null) {
      a.a.a.a.a.e.e.f.d("TextureMovieTransfer", "view is null, cannot refresh");
      return;
    } 
    if (this.r != null)
      this.r.sendMessage(this.r.obtainMessage(6, new f(this, paramView, paramBoolean))); 
  }
  
  public final void a(FrameCapturedCallback paramFrameCapturedCallback) {
    h h1 = this.a;
    if (h1 != null)
      paramFrameCapturedCallback.onFrameCaptured(h1.f()); 
  }
  
  public final void a(PreviewAppearance paramPreviewAppearance, int paramInt1, int paramInt2, WatermarkSetting paramWatermarkSetting) {
    p p1 = new p();
    this.e = p1;
    if (paramPreviewAppearance != null) {
      p1.a(paramInt1, paramInt2, paramPreviewAppearance.x, paramPreviewAppearance.y, paramPreviewAppearance.w, paramPreviewAppearance.h, paramWatermarkSetting);
      return;
    } 
    p1.a(paramInt1, paramInt2, paramWatermarkSetting);
  }
  
  public void a(SurfaceTextureCallback2 paramSurfaceTextureCallback2) {
    this.q = paramSurfaceTextureCallback2;
  }
  
  public void a(WatermarkSetting paramWatermarkSetting) {
    f.a a = this.w;
    if (a == null)
      return; 
    a.a(paramWatermarkSetting);
    this.r.post(new a(this, paramWatermarkSetting));
  }
  
  public final void a(Object paramObject, a.a.a.a.a.a.i.c paramc) {
    a.a.a.a.a.e.e.f.c("TextureMovieTransfer", "prepareEncoder");
    try {
      this.c = new e(paramc);
      try {
        this.b = new a.a.a.a.a.a.h.d(paramObject, 1);
        paramObject = new h(this.b, this.c.e(), true);
        this.a = (h)paramObject;
        paramObject.d();
        paramObject = this.w;
        a.a.a.a.a.e.f f1 = ((f.a)paramObject).a.d().a();
        this.o = f1.a();
        this.p = f1.b();
        if (this.q != null) {
          this.q.onSurfaceCreated();
          this.q.onSurfaceChanged(this.o, this.p);
        } 
        int k = ((f.a)paramObject).b;
        int i = ((f.a)paramObject).c;
        if (((f.a)paramObject).e == 90 || ((f.a)paramObject).e == 270) {
          k = ((f.a)paramObject).c;
          i = ((f.a)paramObject).b;
        } 
        j j1 = new j();
        this.d = j1;
        j1.a(k, i);
        o o1 = new o();
        this.f = o1;
        o1.a(this.o, this.p, true);
        PreviewAppearance previewAppearance = ((f.a)paramObject).o;
        if (previewAppearance != null) {
          this.f.a(k, i, previewAppearance.x, previewAppearance.y, previewAppearance.w, previewAppearance.h, previewAppearance.scaleType);
        } else {
          this.f.a(k, i, 0.0F, 0.0F, 1.0F, 1.0F, PreviewAppearance.ScaleType.FULL);
        } 
        this.j.clear();
        this.k.clear();
        synchronized (this.m) {
          Iterator<WeakReference<View>> iterator = this.h.iterator();
          while (iterator.hasNext()) {
            View view = ((WeakReference<View>)iterator.next()).get();
            if (view != null) {
              c(view);
              continue;
            } 
            iterator.remove();
          } 
          if (((f.a)paramObject).h != null)
            a(previewAppearance, this.o, this.p, ((f.a)paramObject).h); 
          paramObject = new g();
          this.g = (g)paramObject;
          paramObject.a(this.o, this.p);
          return;
        } 
      } catch (Exception exception) {
        a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("exception:");
        stringBuilder.append(exception.getMessage());
        e1.d("TextureMovieTransfer", stringBuilder.toString());
        return;
      } 
    } catch (IOException iOException) {
      throw new RuntimeException(iOException);
    } 
  }
  
  public void a(WeakReference<GLSurfaceView> paramWeakReference) {
    this.s = paramWeakReference;
  }
  
  public boolean a(boolean paramBoolean) {
    f.a a = this.w;
    if (a != null) {
      a.a(paramBoolean);
      return true;
    } 
    a.a.a.a.a.e.e.f.e("TextureMovieTransfer", "setEncodingMirror failed.");
    return false;
  }
  
  public e b() {
    return this.r;
  }
  
  public Bitmap b(View paramView) {
    paramView.post(new c(this, paramView));
    while (!this.n);
    this.n = false;
    Bitmap bitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    paramView.layout(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    paramView.draw(canvas);
    return bitmap;
  }
  
  public final void b(int paramInt, long paramLong, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : La/a/a/a/a/a/j/e;
    //   4: astore #7
    //   6: aload #7
    //   8: ifnull -> 402
    //   11: aload #7
    //   13: iconst_0
    //   14: invokevirtual a : (Z)V
    //   17: aload_0
    //   18: getfield g : La/a/a/a/a/b/i/g;
    //   21: ifnull -> 337
    //   24: aload_0
    //   25: getfield a : La/a/a/a/a/a/h/h;
    //   28: ifnonnull -> 34
    //   31: goto -> 337
    //   34: aload_0
    //   35: getfield w : La/a/a/a/a/a/j/f$a;
    //   38: getfield m : Z
    //   41: istore #4
    //   43: getstatic a/a/a/a/a/a/h/f.d : Ljava/lang/Object;
    //   46: astore #7
    //   48: aload #7
    //   50: monitorenter
    //   51: iload #4
    //   53: ifeq -> 69
    //   56: aload_0
    //   57: getfield d : La/a/a/a/a/b/i/j;
    //   60: iload_1
    //   61: invokevirtual d : (I)I
    //   64: istore #5
    //   66: goto -> 80
    //   69: aload_0
    //   70: getfield f : La/a/a/a/a/b/i/o;
    //   73: iconst_0
    //   74: iload_1
    //   75: invokevirtual a : (II)I
    //   78: istore #5
    //   80: aload #7
    //   82: monitorexit
    //   83: aload_0
    //   84: getfield m : Ljava/lang/Object;
    //   87: astore #9
    //   89: aload #9
    //   91: monitorenter
    //   92: aload_0
    //   93: getfield h : Ljava/util/List;
    //   96: invokeinterface iterator : ()Ljava/util/Iterator;
    //   101: astore #10
    //   103: aload #10
    //   105: invokeinterface hasNext : ()Z
    //   110: ifeq -> 209
    //   113: aload #10
    //   115: invokeinterface next : ()Ljava/lang/Object;
    //   120: checkcast java/lang/ref/WeakReference
    //   123: invokevirtual get : ()Ljava/lang/Object;
    //   126: checkcast android/view/View
    //   129: astore #11
    //   131: aload #11
    //   133: ifnull -> 199
    //   136: aload_0
    //   137: getfield j : Ljava/util/WeakHashMap;
    //   140: aload #11
    //   142: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   145: checkcast a/a/a/a/a/b/i/d
    //   148: astore #8
    //   150: aload #8
    //   152: ifnonnull -> 166
    //   155: aload_0
    //   156: aload #11
    //   158: invokevirtual c : (Landroid/view/View;)La/a/a/a/a/b/i/d;
    //   161: astore #7
    //   163: goto -> 187
    //   166: aload #8
    //   168: astore #7
    //   170: aload_0
    //   171: getfield l : Z
    //   174: ifeq -> 187
    //   177: aload_0
    //   178: aload #11
    //   180: invokevirtual d : (Landroid/view/View;)V
    //   183: aload #8
    //   185: astore #7
    //   187: aload #7
    //   189: iload #5
    //   191: invokevirtual b : (I)I
    //   194: istore #5
    //   196: goto -> 103
    //   199: aload #10
    //   201: invokeinterface remove : ()V
    //   206: goto -> 103
    //   209: aload #9
    //   211: monitorexit
    //   212: iload #5
    //   214: istore_1
    //   215: iload #4
    //   217: ifeq -> 231
    //   220: aload_0
    //   221: getfield f : La/a/a/a/a/b/i/o;
    //   224: iconst_0
    //   225: iload #5
    //   227: invokevirtual a : (II)I
    //   230: istore_1
    //   231: aload_0
    //   232: getfield e : La/a/a/a/a/b/i/p;
    //   235: astore #7
    //   237: aload #7
    //   239: ifnull -> 248
    //   242: aload #7
    //   244: iload_1
    //   245: invokevirtual a : (I)V
    //   248: aload_0
    //   249: getfield q : Lcom/qiniu/pili/droid/streaming/SurfaceTextureCallback2;
    //   252: astore #7
    //   254: iload_1
    //   255: istore #5
    //   257: aload #7
    //   259: ifnull -> 295
    //   262: aload #7
    //   264: iload_1
    //   265: aload_0
    //   266: getfield o : I
    //   269: aload_0
    //   270: getfield p : I
    //   273: getstatic a/a/a/a/a/a/h/f.c : [F
    //   276: invokeinterface onDrawFrame : (III[F)I
    //   281: istore #6
    //   283: iload_1
    //   284: istore #5
    //   286: iload #6
    //   288: ifle -> 295
    //   291: iload #6
    //   293: istore #5
    //   295: aload_0
    //   296: getfield g : La/a/a/a/a/b/i/g;
    //   299: iload #5
    //   301: invokevirtual b : (I)V
    //   304: aload_0
    //   305: getfield a : La/a/a/a/a/a/h/h;
    //   308: lload_2
    //   309: invokevirtual a : (J)V
    //   312: aload_0
    //   313: getfield a : La/a/a/a/a/a/h/h;
    //   316: invokevirtual e : ()Z
    //   319: pop
    //   320: return
    //   321: astore #7
    //   323: aload #9
    //   325: monitorexit
    //   326: aload #7
    //   328: athrow
    //   329: astore #8
    //   331: aload #7
    //   333: monitorexit
    //   334: aload #8
    //   336: athrow
    //   337: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   340: astore #7
    //   342: new java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial <init> : ()V
    //   349: astore #8
    //   351: aload #8
    //   353: ldc_w 'ERROR. handleFrameAvailable mTextureDrawer:'
    //   356: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload #8
    //   362: aload_0
    //   363: getfield g : La/a/a/a/a/b/i/g;
    //   366: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload #8
    //   372: ldc_w ',mInputWindowSurface:'
    //   375: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload #8
    //   381: aload_0
    //   382: getfield a : La/a/a/a/a/a/h/h;
    //   385: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload #7
    //   391: ldc 'TextureMovieTransfer'
    //   393: aload #8
    //   395: invokevirtual toString : ()Ljava/lang/String;
    //   398: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   401: return
    //   402: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   405: astore #7
    //   407: new java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial <init> : ()V
    //   414: astore #8
    //   416: aload #8
    //   418: ldc_w 'ERROR. handleFrameAvailable mVideoEncoder:'
    //   421: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload #8
    //   427: aload_0
    //   428: getfield c : La/a/a/a/a/a/j/e;
    //   431: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload #7
    //   437: ldc 'TextureMovieTransfer'
    //   439: aload #8
    //   441: invokevirtual toString : ()Ljava/lang/String;
    //   444: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   447: return
    // Exception table:
    //   from	to	target	type
    //   56	66	329	finally
    //   69	80	329	finally
    //   80	83	329	finally
    //   92	103	321	finally
    //   103	131	321	finally
    //   136	150	321	finally
    //   155	163	321	finally
    //   170	183	321	finally
    //   187	196	321	finally
    //   199	206	321	finally
    //   209	212	321	finally
    //   323	326	321	finally
    //   331	334	329	finally
  }
  
  public void b(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield t : La/a/a/a/a/f/c;
    //   6: getstatic a/a/a/a/a/f/c.a : La/a/a/a/a/f/c;
    //   9: if_acmpne -> 26
    //   12: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   15: ldc 'TextureMovieTransfer'
    //   17: ldc_w 'stopEncoding failed as not being running'
    //   20: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield t : La/a/a/a/a/f/c;
    //   30: getstatic a/a/a/a/a/f/c.b : La/a/a/a/a/f/c;
    //   33: if_acmpne -> 57
    //   36: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   39: ldc 'TextureMovieTransfer'
    //   41: ldc_w 'set pending action as STOP'
    //   44: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_0
    //   48: getstatic a/a/a/a/a/f/a.c : La/a/a/a/a/f/a;
    //   51: putfield u : La/a/a/a/a/f/a;
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: aload_0
    //   58: getfield t : La/a/a/a/a/f/c;
    //   61: getstatic a/a/a/a/a/f/c.d : La/a/a/a/a/f/c;
    //   64: if_acmpne -> 98
    //   67: aload_0
    //   68: getfield u : La/a/a/a/a/f/a;
    //   71: getstatic a/a/a/a/a/f/a.b : La/a/a/a/a/f/a;
    //   74: if_acmpne -> 95
    //   77: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   80: ldc 'TextureMovieTransfer'
    //   82: ldc_w 'clear pending start action'
    //   85: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_0
    //   89: getstatic a/a/a/a/a/f/a.a : La/a/a/a/a/f/a;
    //   92: putfield u : La/a/a/a/a/f/a;
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   101: ldc 'TextureMovieTransfer'
    //   103: ldc_w 'stopEncoding +'
    //   106: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: getstatic a/a/a/a/a/f/c.d : La/a/a/a/a/f/c;
    //   113: putfield t : La/a/a/a/a/f/c;
    //   116: aload_0
    //   117: getfield r : La/a/a/a/a/a/j/d$e;
    //   120: aload_0
    //   121: getfield r : La/a/a/a/a/a/j/d$e;
    //   124: iconst_1
    //   125: iload_1
    //   126: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   129: invokevirtual obtainMessage : (ILjava/lang/Object;)Landroid/os/Message;
    //   132: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   135: pop
    //   136: aload_0
    //   137: monitorexit
    //   138: return
    //   139: astore_2
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_2
    //   143: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	139	finally
    //   26	54	139	finally
    //   57	95	139	finally
    //   98	136	139	finally
  }
  
  public final a.a.a.a.a.b.i.d c(View paramView) {
    Bitmap bitmap = b(paramView);
    this.k.put(paramView, new Pair(Integer.valueOf(paramView.getWidth()), Integer.valueOf(paramView.getHeight())));
    a.a.a.a.a.b.i.d d1 = new a.a.a.a.a.b.i.d(bitmap);
    d1.a(this.o, this.p);
    a(paramView, d1);
    d1.a();
    this.j.put(paramView, d1);
    return d1;
  }
  
  public final void c() {
    // Byte code:
    //   0: aload_0
    //   1: getfield w : La/a/a/a/a/a/j/f$a;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: getfield i : Ljava/lang/Object;
    //   10: aload_1
    //   11: getfield a : La/a/a/a/a/a/i/c;
    //   14: invokevirtual a : (Ljava/lang/Object;La/a/a/a/a/a/i/c;)V
    //   17: aload_0
    //   18: getfield v : La/a/a/a/a/a/c;
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull -> 32
    //   26: aload_1
    //   27: invokeinterface d : ()V
    //   32: aload_0
    //   33: lconst_0
    //   34: putfield y : J
    //   37: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   40: ldc 'TextureMovieTransfer'
    //   42: ldc_w 'startEncoding -'
    //   45: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_0
    //   49: monitorenter
    //   50: aload_0
    //   51: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   54: putfield t : La/a/a/a/a/f/c;
    //   57: aload_0
    //   58: invokevirtual e : ()V
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Exception table:
    //   from	to	target	type
    //   50	63	64	finally
    //   65	67	64	finally
  }
  
  public final void d() {
    a.a.a.a.a.e.e.f.c("TextureMovieTransfer", "releaseEncoder");
    e e1 = this.c;
    if (e1 != null) {
      e1.b();
      this.c = null;
    } 
    SurfaceTextureCallback2 surfaceTextureCallback2 = this.q;
    if (surfaceTextureCallback2 != null)
      surfaceTextureCallback2.onSurfaceDestroyed(); 
    h h1 = this.a;
    if (h1 != null) {
      h1.g();
      this.a = null;
    } 
    a.a.a.a.a.a.h.d d1 = this.b;
    if (d1 != null) {
      d1.b();
      this.b = null;
    } 
  }
  
  public final void d(View paramView) {
    a.a.a.a.a.b.i.d d1 = this.j.get(paramView);
    if (d1 != null) {
      a(paramView, d1);
      d1.b();
    } 
  }
  
  public void d(boolean paramBoolean) {
    this.l = paramBoolean;
  }
  
  public final void e(View paramView) {
    this.i.remove(paramView);
    a.a.a.a.a.b.i.d d1 = this.j.remove(paramView);
    if (d1 != null)
      d1.h(); 
    this.k.remove(paramView);
  }
  
  public final void e(boolean paramBoolean) {
    // Byte code:
    //   0: invokestatic myLooper : ()Landroid/os/Looper;
    //   3: invokevirtual quit : ()V
    //   6: aload_0
    //   7: getfield c : La/a/a/a/a/a/j/e;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull -> 31
    //   15: iload_1
    //   16: ifeq -> 31
    //   19: aload_2
    //   20: invokevirtual a : ()V
    //   23: aload_0
    //   24: getfield c : La/a/a/a/a/a/j/e;
    //   27: iconst_1
    //   28: invokevirtual a : (Z)V
    //   31: aload_0
    //   32: invokevirtual d : ()V
    //   35: aload_0
    //   36: getfield v : La/a/a/a/a/a/c;
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull -> 50
    //   44: aload_2
    //   45: invokeinterface a : ()V
    //   50: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   53: ldc 'TextureMovieTransfer'
    //   55: ldc_w 'stopEncoding -'
    //   58: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: monitorenter
    //   63: aload_0
    //   64: getstatic a/a/a/a/a/f/c.a : La/a/a/a/a/f/c;
    //   67: putfield t : La/a/a/a/a/f/c;
    //   70: aload_0
    //   71: invokevirtual e : ()V
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_2
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_2
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   63	76	77	finally
    //   78	80	77	finally
  }
  
  public final void f(View paramView) {
    e(paramView);
  }
  
  public class a implements Runnable {
    public a(d this$0, WatermarkSetting param1WatermarkSetting) {}
    
    public void run() {
      if (d.a(this.b) != null) {
        d.a(this.b).a();
        d.a(this.b, (p)null);
      } 
      if (this.a != null) {
        a.a.a.a.a.e.f f = this.b.w.a.d().a();
        d d1 = this.b;
        d.a(d1, d1.w.o, f.a(), f.b(), this.a);
      } 
    }
  }
  
  public class b implements Runnable {
    public b(d this$0, boolean[] param1ArrayOfboolean) {}
    
    public void run() {
      this.a[0] = true;
    }
  }
  
  public class c implements Runnable {
    public c(d this$0, View param1View) {}
    
    public void run() {
      if (this.a.getWidth() != 0 && this.a.getHeight() != 0) {
        a.a.a.a.a.e.e e = a.a.a.a.a.e.e.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("view size already got width: ");
        stringBuilder.append(this.a.getWidth());
        stringBuilder.append(" height: ");
        stringBuilder.append(this.a.getHeight());
        e.c("TextureMovieTransfer", stringBuilder.toString());
        d.a(this.b, true);
        return;
      } 
      this.a.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }
    
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
      public a(d.c this$0) {}
      
      public void onGlobalLayout() {
        a.a.a.a.a.e.e e = a.a.a.a.a.e.e.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("view size monitor got width: ");
        stringBuilder.append(this.a.a.getWidth());
        stringBuilder.append(" height: ");
        stringBuilder.append(this.a.a.getHeight());
        e.c("TextureMovieTransfer", stringBuilder.toString());
        d.a(this.a.b, true);
      }
    }
  }
  
  public class a implements ViewTreeObserver.OnGlobalLayoutListener {
    public a(d this$0) {}
    
    public void onGlobalLayout() {
      a.a.a.a.a.e.e e = a.a.a.a.a.e.e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("view size monitor got width: ");
      stringBuilder.append(this.a.a.getWidth());
      stringBuilder.append(" height: ");
      stringBuilder.append(this.a.a.getHeight());
      e.c("TextureMovieTransfer", stringBuilder.toString());
      d.a(this.a.b, true);
    }
  }
  
  public class d {
    public View a;
    
    public ViewGroup b;
    
    public d(d this$0, View param1View, ViewGroup param1ViewGroup) {
      this.a = param1View;
      this.b = param1ViewGroup;
    }
  }
  
  public static class e extends Handler {
    public WeakReference<d> a;
    
    public e(Looper param1Looper, d param1d) {
      super(param1Looper);
      this.a = new WeakReference<d>(param1d);
    }
    
    public void handleMessage(Message param1Message) {
      StringBuilder stringBuilder1;
      int j;
      long l;
      boolean bool;
      int i = param1Message.what;
      Object object = param1Message.obj;
      d d = this.a.get();
      a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.f;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("EncoderHandler what:");
      stringBuilder2.append(i);
      stringBuilder2.append(",encoder=");
      stringBuilder2.append(d);
      e1.b("TextureMovieTransfer", stringBuilder2.toString());
      if (d == null) {
        a.a.a.a.a.e.e.f.d("TextureMovieTransfer", "EncoderHandler.handleMessage: encoder is null");
        return;
      } 
      switch (i) {
        default:
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Unhandled msg what=");
          stringBuilder1.append(i);
          throw new RuntimeException(stringBuilder1.toString());
        case 6:
          d.a(d, (d.f)((Message)stringBuilder1).obj);
          return;
        case 5:
          d.a(d, (View)((Message)stringBuilder1).obj);
          return;
        case 4:
          d.a(d, (d.d)((Message)stringBuilder1).obj);
          return;
        case 3:
          d.a(d, (FrameCapturedCallback)((Message)stringBuilder1).obj);
          return;
        case 2:
          i = ((Message)stringBuilder1).arg1;
          l = ((Long)object).longValue();
          j = ((Message)stringBuilder1).arg2;
          bool = true;
          if (j != 1)
            bool = false; 
          d.a(d, i, l, bool);
          return;
        case 1:
          d.b(d, ((Boolean)object).booleanValue());
          return;
        case 0:
          break;
      } 
      d.b(d);
    }
  }
  
  public class f {
    public View a;
    
    public boolean b;
    
    public f(d this$0, View param1View, boolean param1Boolean) {
      this.a = param1View;
      this.b = param1Boolean;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\j\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */