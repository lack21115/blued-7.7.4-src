package a.a.a.a.a.a.j.h;

import a.a.a.a.a.e.e;
import a.a.a.a.a.e.f;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;

public abstract class a {
  public Handler a;
  
  public String b;
  
  public int c;
  
  public volatile boolean d;
  
  public volatile boolean e = true;
  
  public Context f;
  
  public a.a.a.a.a.b.c g;
  
  public a.a.a.a.a.a.b h;
  
  public int i = 200;
  
  public boolean j = true;
  
  public final Object k = new Object();
  
  public Runnable l = new a(this);
  
  public Runnable m = new b(this);
  
  public Runnable n = new c(this);
  
  public a(Context paramContext, a.a.a.a.a.b.c paramc, a.a.a.a.a.a.b paramb) {
    this.f = paramContext;
    this.g = paramc;
    this.h = paramb;
  }
  
  public static Bitmap a(String paramString, f paramf) {
    if (paramf == null || paramf.a() <= 0 || paramf.b() <= 0)
      return BitmapFactory.decodeFile(paramString); 
    BitmapFactory.Options options = new BitmapFactory.Options();
    boolean bool = true;
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, options);
    options.inJustDecodeBounds = false;
    int i = options.outWidth;
    int j = options.outHeight;
    e e2 = e.f;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("loadSuitableBitmap, bitmap size = ");
    stringBuilder2.append(i);
    stringBuilder2.append("x");
    stringBuilder2.append(j);
    e2.c("PictureStreamingManager", stringBuilder2.toString());
    i /= paramf.a();
    j /= paramf.b();
    if (i >= j)
      i = j; 
    if (i <= 0)
      i = bool; 
    options.inSampleSize = i;
    e e1 = e.f;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("loadSuitableBitmap, inSampleSize = ");
    stringBuilder1.append(i);
    e1.c("PictureStreamingManager", stringBuilder1.toString());
    return BitmapFactory.decodeFile(paramString, options);
  }
  
  public final Bitmap a(int paramInt, f paramf) {
    if (paramf == null || paramf.a() <= 0 || paramf.b() <= 0)
      return BitmapFactory.decodeResource(this.f.getResources(), paramInt); 
    BitmapFactory.Options options = new BitmapFactory.Options();
    boolean bool = true;
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(this.f.getResources(), paramInt, options);
    options.inJustDecodeBounds = false;
    int i = options.outWidth;
    int j = options.outHeight;
    e e2 = e.f;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("loadSuitableBitmap, bitmap size = ");
    stringBuilder2.append(i);
    stringBuilder2.append("x");
    stringBuilder2.append(j);
    e2.c("PictureStreamingManager", stringBuilder2.toString());
    i /= paramf.a();
    j /= paramf.b();
    if (i >= j)
      i = j; 
    if (i <= 0)
      i = bool; 
    options.inSampleSize = i;
    e e1 = e.f;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("loadSuitableBitmap, inSampleSize = ");
    stringBuilder1.append(i);
    e1.c("PictureStreamingManager", stringBuilder1.toString());
    return BitmapFactory.decodeResource(this.f.getResources(), paramInt, options);
  }
  
  public abstract void a();
  
  public void a(float paramFloat) {
    if (paramFloat <= 0.0F || paramFloat > 30.0F)
      e.d.e("PictureStreamingManager", "Error: fps range: 0-30"); 
    this.i = (int)(1000.0F / paramFloat);
  }
  
  public void a(int paramInt) {
    if (paramInt <= 0) {
      e.d.e("PictureStreamingManager", "Error: resourceId error!");
      return;
    } 
    this.b = null;
    this.c = paramInt;
    if (c())
      b(a(paramInt, this.h.a())); 
  }
  
  public abstract void a(Bitmap paramBitmap);
  
  public void a(String paramString) {
    if (paramString == null) {
      e.d.e("PictureStreamingManager", "Error: filePath cannot be empty!");
      return;
    } 
    this.c = -1;
    this.b = paramString;
    if (c())
      b(a(paramString, this.h.a())); 
  }
  
  public void a(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public abstract void b();
  
  public abstract void b(Bitmap paramBitmap);
  
  public void b(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Z
    //   6: ifne -> 22
    //   9: getstatic a/a/a/a/a/e/e.c : La/a/a/a/a/e/e;
    //   12: ldc 'PictureStreamingManager'
    //   14: ldc 'not working !!!'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: iload_1
    //   24: putfield j : Z
    //   27: aload_0
    //   28: getfield a : Landroid/os/Handler;
    //   31: aload_0
    //   32: getfield m : Ljava/lang/Runnable;
    //   35: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   38: pop
    //   39: aload_0
    //   40: getfield k : Ljava/lang/Object;
    //   43: astore_2
    //   44: aload_2
    //   45: monitorenter
    //   46: aload_0
    //   47: getfield d : Z
    //   50: istore_1
    //   51: iload_1
    //   52: ifeq -> 70
    //   55: aload_0
    //   56: getfield k : Ljava/lang/Object;
    //   59: invokevirtual wait : ()V
    //   62: goto -> 70
    //   65: astore_3
    //   66: aload_3
    //   67: invokevirtual printStackTrace : ()V
    //   70: aload_2
    //   71: monitorexit
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: astore_3
    //   76: aload_2
    //   77: monitorexit
    //   78: aload_3
    //   79: athrow
    //   80: astore_2
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_2
    //   84: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	80	finally
    //   22	46	80	finally
    //   46	51	75	finally
    //   55	62	65	java/lang/InterruptedException
    //   55	62	75	finally
    //   66	70	75	finally
    //   70	72	75	finally
    //   76	78	75	finally
    //   78	80	80	finally
  }
  
  public boolean c() {
    return this.d;
  }
  
  public boolean d() {
    return this.e;
  }
  
  public void e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Z
    //   6: ifeq -> 22
    //   9: getstatic a/a/a/a/a/e/e.c : La/a/a/a/a/e/e;
    //   12: ldc 'PictureStreamingManager'
    //   14: ldc 'already working !!!'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield f : Landroid/content/Context;
    //   26: ifnull -> 120
    //   29: aload_0
    //   30: getfield h : La/a/a/a/a/a/b;
    //   33: ifnonnull -> 39
    //   36: goto -> 120
    //   39: new android/os/HandlerThread
    //   42: dup
    //   43: ldc 'PictureStreamingManager'
    //   45: invokespecial <init> : (Ljava/lang/String;)V
    //   48: astore_2
    //   49: aload_2
    //   50: invokevirtual start : ()V
    //   53: new android/os/Handler
    //   56: dup
    //   57: aload_2
    //   58: invokevirtual getLooper : ()Landroid/os/Looper;
    //   61: invokespecial <init> : (Landroid/os/Looper;)V
    //   64: astore_2
    //   65: aload_0
    //   66: aload_2
    //   67: putfield a : Landroid/os/Handler;
    //   70: aload_2
    //   71: aload_0
    //   72: getfield l : Ljava/lang/Runnable;
    //   75: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   78: pop
    //   79: aload_0
    //   80: getfield k : Ljava/lang/Object;
    //   83: astore_2
    //   84: aload_2
    //   85: monitorenter
    //   86: aload_0
    //   87: getfield d : Z
    //   90: istore_1
    //   91: iload_1
    //   92: ifne -> 110
    //   95: aload_0
    //   96: getfield k : Ljava/lang/Object;
    //   99: invokevirtual wait : ()V
    //   102: goto -> 110
    //   105: astore_3
    //   106: aload_3
    //   107: invokevirtual printStackTrace : ()V
    //   110: aload_2
    //   111: monitorexit
    //   112: aload_0
    //   113: monitorexit
    //   114: return
    //   115: astore_3
    //   116: aload_2
    //   117: monitorexit
    //   118: aload_3
    //   119: athrow
    //   120: getstatic a/a/a/a/a/e/e.c : La/a/a/a/a/e/e;
    //   123: ldc 'PictureStreamingManager'
    //   125: ldc 'something is null !!!'
    //   127: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: monitorexit
    //   132: return
    //   133: astore_2
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_2
    //   137: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	133	finally
    //   22	36	133	finally
    //   39	86	133	finally
    //   86	91	115	finally
    //   95	102	105	java/lang/InterruptedException
    //   95	102	115	finally
    //   106	110	115	finally
    //   110	112	115	finally
    //   116	118	115	finally
    //   118	120	133	finally
    //   120	130	133	finally
  }
  
  public class a implements Runnable {
    public a(a this$0) {}
    
    public void run() {
      Bitmap bitmap;
      e.c.c("PictureStreamingManager", "starting picture streaming +");
      if (a.a(this.a) != null)
        a.a(this.a).k(); 
      a a1 = this.a;
      null = a1.b;
      if (null != null) {
        bitmap = a.b(null, a.b(a1).a());
      } else {
        bitmap = a.a((a)bitmap, ((a)bitmap).c, a.b((a)bitmap).a());
      } 
      this.a.a(bitmap);
      a.d(this.a).post(a.c(this.a));
      synchronized (a.e(this.a)) {
        a.a(this.a, true);
        a.e(this.a).notify();
        e.c.c("PictureStreamingManager", "starting picture streaming -");
        return;
      } 
    }
  }
  
  public class b implements Runnable {
    public b(a this$0) {}
    
    public void run() {
      e.c.c("PictureStreamingManager", "stopping picture streaming +");
      a.d(this.a).getLooper().quit();
      this.a.b();
      if (a.f(this.a) && a.a(this.a) != null) {
        a.a(this.a).a(a.b(this.a));
        a.a(this.a).a(true);
      } 
      synchronized (a.e(this.a)) {
        a.a(this.a, false);
        a.e(this.a).notify();
        e.c.c("PictureStreamingManager", "stopping picture streaming -");
        return;
      } 
    }
  }
  
  public class c implements Runnable {
    public c(a this$0) {}
    
    public void run() {
      this.a.a();
      a.d(this.a).postDelayed(this, a.g(this.a));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\j\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */