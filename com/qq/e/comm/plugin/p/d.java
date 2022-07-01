package com.qq.e.comm.plugin.p;

import android.graphics.Bitmap;
import android.graphics.Movie;
import android.util.LruCache;
import android.widget.ImageView;
import com.qq.e.comm.plugin.ac.g;
import com.qq.e.comm.plugin.j.b;
import com.qq.e.comm.plugin.j.b.f;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.k;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.util.FileUtil;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

final class d implements Runnable {
  private static final ConcurrentHashMap<String, Object> f = new ConcurrentHashMap<String, Object>();
  
  private static final b g = (new b.a()).a(false).a(10000).b(10000).a();
  
  private static final LruCache<String, SoftReference<Bitmap>> h = new LruCache(5);
  
  private final String a;
  
  private final WeakReference<ImageView> b;
  
  private final b c;
  
  private final File d;
  
  private final boolean e;
  
  public d(String paramString, ImageView paramImageView, b paramb, boolean paramBoolean) {
    this.a = paramString;
    this.b = new WeakReference<ImageView>(paramImageView);
    this.c = paramb;
    this.d = new File(aj.l(), FileUtil.getFileName(paramString));
    this.e = paramBoolean;
  }
  
  private void a() {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/p/d.f : Ljava/util/concurrent/ConcurrentHashMap;
    //   3: aload_0
    //   4: getfield a : Ljava/lang/String;
    //   7: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull -> 47
    //   15: aload_1
    //   16: monitorenter
    //   17: getstatic com/qq/e/comm/plugin/p/d.f : Ljava/util/concurrent/ConcurrentHashMap;
    //   20: aload_0
    //   21: getfield a : Ljava/lang/String;
    //   24: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   27: astore_2
    //   28: aload_2
    //   29: ifnull -> 39
    //   32: aload_2
    //   33: ldc2_w 5000
    //   36: invokevirtual wait : (J)V
    //   39: aload_1
    //   40: monitorexit
    //   41: return
    //   42: astore_2
    //   43: aload_1
    //   44: monitorexit
    //   45: aload_2
    //   46: athrow
    //   47: return
    //   48: astore_2
    //   49: goto -> 39
    // Exception table:
    //   from	to	target	type
    //   17	28	42	finally
    //   32	39	48	java/lang/InterruptedException
    //   32	39	42	finally
    //   39	41	42	finally
    //   43	45	42	finally
  }
  
  private void a(int paramInt, Exception paramException) {
    y.a(new Runnable(this, paramInt, paramException) {
          public void run() {
            if (d.a(this.c) != null)
              d.a(this.c).a(d.b(this.c), this.a, this.b); 
          }
        });
  }
  
  private void a(c paramc, boolean paramBoolean) {
    y.a(new Runnable(this, paramc, paramBoolean) {
          public void run() {
            ImageView imageView = d.c(this.c).get();
            if (imageView != null) {
              imageView.setScaleType(ImageView.ScaleType.FIT_XY);
              if (this.a.a() && imageView instanceof g) {
                ((g)imageView).a(this.a.b());
              } else if (this.a.c() != null) {
                imageView.setImageBitmap(this.a.c());
              } 
            } 
            if (d.a(this.c) != null) {
              e e = (new e.a()).a(this.a.c()).a(this.b).a(d.d(this.c)).a();
              d.a(this.c).a(d.b(this.c), imageView, e);
            } 
          }
        });
  }
  
  private boolean a(boolean paramBoolean) {
    if (this.e) {
      a(new c(), paramBoolean);
    } else {
      try {
        c c = c();
        if (c != null) {
          a(c, paramBoolean);
        } else {
          if (paramBoolean) {
            this.d.delete();
            return false;
          } 
          a(102, new Exception("DecodeFailed"));
        } 
      } catch (OutOfMemoryError outOfMemoryError) {
        a(101, new Exception(outOfMemoryError));
      } catch (Exception exception) {
        a(102, new Exception("DecodeFailed"));
      } 
    } 
    return true;
  }
  
  private void b() throws c {
    f f = new f(this.a, this.d, 1, g);
    if (f.c())
      return; 
    throw new c(f.a(), f.b());
  }
  
  private c c() throws OutOfMemoryError {
    Movie movie = k.b(this.d);
    if (movie != null)
      return new c(movie); 
    Bitmap bitmap = k.a(this.d, this.b.get());
    if (bitmap != null) {
      h.put(e(), new SoftReference<Bitmap>(bitmap));
      return new c(bitmap);
    } 
    return null;
  }
  
  private Bitmap d() {
    String str = e();
    SoftReference<Bitmap> softReference = (SoftReference)h.get(str);
    if (softReference != null) {
      Bitmap bitmap = softReference.get();
    } else {
      softReference = null;
    } 
    if (softReference != null) {
      SoftReference<Bitmap> softReference1 = softReference;
      if (softReference.isRecycled()) {
        h.remove(str);
        return null;
      } 
      return (Bitmap)softReference1;
    } 
    h.remove(str);
    return null;
  }
  
  private String e() {
    ImageView imageView = this.b.get();
    int i = k.a(imageView);
    int j = k.b(imageView);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append("_");
    stringBuilder.append(i);
    stringBuilder.append("_");
    stringBuilder.append(j);
    return stringBuilder.toString();
  }
  
  public void run() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial a : ()V
    //   4: aload_0
    //   5: getfield e : Z
    //   8: ifne -> 34
    //   11: aload_0
    //   12: invokespecial d : ()Landroid/graphics/Bitmap;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull -> 34
    //   20: aload_0
    //   21: new com/qq/e/comm/plugin/p/c
    //   24: dup
    //   25: aload_1
    //   26: invokespecial <init> : (Landroid/graphics/Bitmap;)V
    //   29: iconst_1
    //   30: invokespecial a : (Lcom/qq/e/comm/plugin/p/c;Z)V
    //   33: return
    //   34: aload_0
    //   35: getfield d : Ljava/io/File;
    //   38: invokevirtual exists : ()Z
    //   41: ifeq -> 52
    //   44: aload_0
    //   45: iconst_1
    //   46: invokespecial a : (Z)Z
    //   49: ifne -> 164
    //   52: getstatic com/qq/e/comm/plugin/p/d.f : Ljava/util/concurrent/ConcurrentHashMap;
    //   55: aload_0
    //   56: getfield a : Ljava/lang/String;
    //   59: new java/lang/Object
    //   62: dup
    //   63: invokespecial <init> : ()V
    //   66: invokevirtual putIfAbsent : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   69: pop
    //   70: getstatic com/qq/e/comm/plugin/p/d.f : Ljava/util/concurrent/ConcurrentHashMap;
    //   73: aload_0
    //   74: getfield a : Ljava/lang/String;
    //   77: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   80: astore_1
    //   81: aload_1
    //   82: monitorenter
    //   83: aload_0
    //   84: invokespecial b : ()V
    //   87: aload_0
    //   88: iconst_0
    //   89: invokespecial a : (Z)Z
    //   92: pop
    //   93: getstatic com/qq/e/comm/plugin/p/d.f : Ljava/util/concurrent/ConcurrentHashMap;
    //   96: aload_0
    //   97: getfield a : Ljava/lang/String;
    //   100: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: aload_1
    //   105: invokevirtual notifyAll : ()V
    //   108: goto -> 139
    //   111: astore_2
    //   112: goto -> 142
    //   115: astore_2
    //   116: aload_0
    //   117: aload_2
    //   118: invokevirtual a : ()I
    //   121: aload_2
    //   122: invokespecial a : (ILjava/lang/Exception;)V
    //   125: getstatic com/qq/e/comm/plugin/p/d.f : Ljava/util/concurrent/ConcurrentHashMap;
    //   128: aload_0
    //   129: getfield a : Ljava/lang/String;
    //   132: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   135: pop
    //   136: goto -> 104
    //   139: aload_1
    //   140: monitorexit
    //   141: return
    //   142: getstatic com/qq/e/comm/plugin/p/d.f : Ljava/util/concurrent/ConcurrentHashMap;
    //   145: aload_0
    //   146: getfield a : Ljava/lang/String;
    //   149: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: aload_1
    //   154: invokevirtual notifyAll : ()V
    //   157: aload_2
    //   158: athrow
    //   159: astore_2
    //   160: aload_1
    //   161: monitorexit
    //   162: aload_2
    //   163: athrow
    //   164: return
    // Exception table:
    //   from	to	target	type
    //   83	93	115	com/qq/e/comm/plugin/j/c
    //   83	93	111	finally
    //   93	104	159	finally
    //   104	108	159	finally
    //   116	125	111	finally
    //   125	136	159	finally
    //   139	141	159	finally
    //   142	159	159	finally
    //   160	162	159	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\p\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */