package com.blued.android.core.imagecache.glide;

import android.graphics.Bitmap;
import android.os.Build;
import com.blued.android.core.imagecache.ImageLoaderUtils;
import com.blued.android.core.utils.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool implements BitmapPool {
  private static final Bitmap.Config a = Bitmap.Config.ARGB_8888;
  
  private final LruPoolStrategy b;
  
  private final Set<Bitmap.Config> c;
  
  private final int d;
  
  private final BitmapTracker e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  public LruBitmapPool(int paramInt) {
    this(paramInt, e(), f());
  }
  
  LruBitmapPool(int paramInt, LruPoolStrategy paramLruPoolStrategy, Set<Bitmap.Config> paramSet) {
    this.d = paramInt;
    this.f = paramInt;
    this.b = paramLruPoolStrategy;
    this.c = paramSet;
    this.e = new NullBitmapTracker();
  }
  
  private Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Lcom/blued/android/core/imagecache/glide/LruPoolStrategy;
    //   6: astore #5
    //   8: aload_3
    //   9: ifnull -> 18
    //   12: aload_3
    //   13: astore #4
    //   15: goto -> 23
    //   18: getstatic com/blued/android/core/imagecache/glide/LruBitmapPool.a : Landroid/graphics/Bitmap$Config;
    //   21: astore #4
    //   23: aload #5
    //   25: iload_1
    //   26: iload_2
    //   27: aload #4
    //   29: invokeinterface a : (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   34: astore #4
    //   36: aload #4
    //   38: ifnonnull -> 106
    //   41: getstatic com/blued/android/core/imagecache/ImageLoaderUtils.a : Z
    //   44: ifeq -> 93
    //   47: new java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial <init> : ()V
    //   54: astore #5
    //   56: aload #5
    //   58: ldc 'Missing bitmap='
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload #5
    //   66: aload_0
    //   67: getfield b : Lcom/blued/android/core/imagecache/glide/LruPoolStrategy;
    //   70: iload_1
    //   71: iload_2
    //   72: aload_3
    //   73: invokeinterface b : (IILandroid/graphics/Bitmap$Config;)Ljava/lang/String;
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc 'LruBitmapPool'
    //   84: aload #5
    //   86: invokevirtual toString : ()Ljava/lang/String;
    //   89: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   92: pop
    //   93: aload_0
    //   94: aload_0
    //   95: getfield i : I
    //   98: iconst_1
    //   99: iadd
    //   100: putfield i : I
    //   103: goto -> 152
    //   106: aload_0
    //   107: aload_0
    //   108: getfield h : I
    //   111: iconst_1
    //   112: iadd
    //   113: putfield h : I
    //   116: aload_0
    //   117: aload_0
    //   118: getfield g : I
    //   121: aload_0
    //   122: getfield b : Lcom/blued/android/core/imagecache/glide/LruPoolStrategy;
    //   125: aload #4
    //   127: invokeinterface c : (Landroid/graphics/Bitmap;)I
    //   132: isub
    //   133: putfield g : I
    //   136: aload_0
    //   137: getfield e : Lcom/blued/android/core/imagecache/glide/LruBitmapPool$BitmapTracker;
    //   140: aload #4
    //   142: invokeinterface b : (Landroid/graphics/Bitmap;)V
    //   147: aload #4
    //   149: invokestatic b : (Landroid/graphics/Bitmap;)V
    //   152: getstatic com/blued/android/core/imagecache/ImageLoaderUtils.a : Z
    //   155: ifeq -> 204
    //   158: new java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial <init> : ()V
    //   165: astore #5
    //   167: aload #5
    //   169: ldc 'Get bitmap='
    //   171: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload #5
    //   177: aload_0
    //   178: getfield b : Lcom/blued/android/core/imagecache/glide/LruPoolStrategy;
    //   181: iload_1
    //   182: iload_2
    //   183: aload_3
    //   184: invokeinterface b : (IILandroid/graphics/Bitmap$Config;)Ljava/lang/String;
    //   189: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: ldc 'LruBitmapPool'
    //   195: aload #5
    //   197: invokevirtual toString : ()Ljava/lang/String;
    //   200: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   203: pop
    //   204: aload_0
    //   205: invokespecial c : ()V
    //   208: aload_0
    //   209: monitorexit
    //   210: aload #4
    //   212: areturn
    //   213: astore_3
    //   214: aload_0
    //   215: monitorexit
    //   216: aload_3
    //   217: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	213	finally
    //   18	23	213	finally
    //   23	36	213	finally
    //   41	93	213	finally
    //   93	103	213	finally
    //   106	152	213	finally
    //   152	204	213	finally
    //   204	208	213	finally
  }
  
  private void b() {
    b(this.f);
  }
  
  private void b(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : I
    //   6: iload_1
    //   7: if_icmple -> 146
    //   10: aload_0
    //   11: getfield b : Lcom/blued/android/core/imagecache/glide/LruPoolStrategy;
    //   14: invokeinterface a : ()Landroid/graphics/Bitmap;
    //   19: astore_2
    //   20: aload_2
    //   21: ifnonnull -> 50
    //   24: getstatic com/blued/android/core/imagecache/ImageLoaderUtils.a : Z
    //   27: ifeq -> 42
    //   30: ldc 'LruBitmapPool'
    //   32: ldc 'Size mismatch, resetting'
    //   34: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   37: pop
    //   38: aload_0
    //   39: invokespecial d : ()V
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield g : I
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield e : Lcom/blued/android/core/imagecache/glide/LruBitmapPool$BitmapTracker;
    //   54: aload_2
    //   55: invokeinterface b : (Landroid/graphics/Bitmap;)V
    //   60: aload_0
    //   61: aload_0
    //   62: getfield g : I
    //   65: aload_0
    //   66: getfield b : Lcom/blued/android/core/imagecache/glide/LruPoolStrategy;
    //   69: aload_2
    //   70: invokeinterface c : (Landroid/graphics/Bitmap;)I
    //   75: isub
    //   76: putfield g : I
    //   79: aload_0
    //   80: aload_0
    //   81: getfield k : I
    //   84: iconst_1
    //   85: iadd
    //   86: putfield k : I
    //   89: getstatic com/blued/android/core/imagecache/ImageLoaderUtils.a : Z
    //   92: ifeq -> 135
    //   95: new java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial <init> : ()V
    //   102: astore_3
    //   103: aload_3
    //   104: ldc 'Evicting bitmap='
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_3
    //   111: aload_0
    //   112: getfield b : Lcom/blued/android/core/imagecache/glide/LruPoolStrategy;
    //   115: aload_2
    //   116: invokeinterface b : (Landroid/graphics/Bitmap;)Ljava/lang/String;
    //   121: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: ldc 'LruBitmapPool'
    //   127: aload_3
    //   128: invokevirtual toString : ()Ljava/lang/String;
    //   131: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   134: pop
    //   135: aload_0
    //   136: invokespecial c : ()V
    //   139: aload_2
    //   140: invokevirtual recycle : ()V
    //   143: goto -> 2
    //   146: aload_0
    //   147: monitorexit
    //   148: return
    //   149: astore_2
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_2
    //   153: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	149	finally
    //   24	42	149	finally
    //   42	47	149	finally
    //   50	135	149	finally
    //   135	143	149	finally
  }
  
  private static void b(Bitmap paramBitmap) {
    paramBitmap.setHasAlpha(true);
    c(paramBitmap);
  }
  
  private void c() {
    if (ImageLoaderUtils.a)
      d(); 
  }
  
  private static void c(Bitmap paramBitmap) {
    if (Build.VERSION.SDK_INT >= 19)
      paramBitmap.setPremultiplied(true); 
  }
  
  private void d() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Hits=");
    stringBuilder.append(this.h);
    stringBuilder.append(", misses=");
    stringBuilder.append(this.i);
    stringBuilder.append(", puts=");
    stringBuilder.append(this.j);
    stringBuilder.append(", evictions=");
    stringBuilder.append(this.k);
    stringBuilder.append(", currentSize=");
    stringBuilder.append(this.g);
    stringBuilder.append(", maxSize=");
    stringBuilder.append(this.f);
    stringBuilder.append("\nStrategy=");
    stringBuilder.append(this.b);
    Log.a("LruBitmapPool", stringBuilder.toString());
  }
  
  private static LruPoolStrategy e() {
    return (LruPoolStrategy)((Build.VERSION.SDK_INT >= 19) ? new SizeConfigStrategy() : new AttributeStrategy());
  }
  
  private static Set<Bitmap.Config> f() {
    HashSet<? extends Bitmap.Config> hashSet = new HashSet();
    hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
    if (Build.VERSION.SDK_INT >= 19)
      hashSet.add(null); 
    return Collections.unmodifiableSet(hashSet);
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    Bitmap bitmap = b(paramInt1, paramInt2, paramConfig);
    if (bitmap != null)
      bitmap.eraseColor(0); 
    return bitmap;
  }
  
  public void a() {
    if (ImageLoaderUtils.a)
      Log.b("LruBitmapPool", "clearMemory"); 
    b(0);
  }
  
  public void a(int paramInt) {
    if (ImageLoaderUtils.a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("trimMemory, level=");
      stringBuilder.append(paramInt);
      Log.b("LruBitmapPool", stringBuilder.toString());
    } 
    if (paramInt >= 40) {
      a();
      return;
    } 
    if (paramInt >= 20)
      b(this.f / 2); 
  }
  
  public void a(Bitmap paramBitmap) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 27
    //   6: getstatic com/blued/android/core/imagecache/ImageLoaderUtils.a : Z
    //   9: istore_3
    //   10: iload_3
    //   11: ifne -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: new java/lang/NullPointerException
    //   20: dup
    //   21: ldc 'Bitmap must not be null'
    //   23: invokespecial <init> : (Ljava/lang/String;)V
    //   26: athrow
    //   27: aload_1
    //   28: invokevirtual isRecycled : ()Z
    //   31: ifeq -> 55
    //   34: getstatic com/blued/android/core/imagecache/ImageLoaderUtils.a : Z
    //   37: istore_3
    //   38: iload_3
    //   39: ifne -> 45
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: new java/lang/IllegalStateException
    //   48: dup
    //   49: ldc 'Cannot pool recycled bitmap'
    //   51: invokespecial <init> : (Ljava/lang/String;)V
    //   54: athrow
    //   55: aload_1
    //   56: invokevirtual isMutable : ()Z
    //   59: ifeq -> 211
    //   62: aload_0
    //   63: getfield b : Lcom/blued/android/core/imagecache/glide/LruPoolStrategy;
    //   66: aload_1
    //   67: invokeinterface c : (Landroid/graphics/Bitmap;)I
    //   72: aload_0
    //   73: getfield f : I
    //   76: if_icmpgt -> 211
    //   79: aload_0
    //   80: getfield c : Ljava/util/Set;
    //   83: aload_1
    //   84: invokevirtual getConfig : ()Landroid/graphics/Bitmap$Config;
    //   87: invokeinterface contains : (Ljava/lang/Object;)Z
    //   92: ifne -> 98
    //   95: goto -> 211
    //   98: aload_0
    //   99: getfield b : Lcom/blued/android/core/imagecache/glide/LruPoolStrategy;
    //   102: aload_1
    //   103: invokeinterface c : (Landroid/graphics/Bitmap;)I
    //   108: istore_2
    //   109: aload_0
    //   110: getfield b : Lcom/blued/android/core/imagecache/glide/LruPoolStrategy;
    //   113: aload_1
    //   114: invokeinterface a : (Landroid/graphics/Bitmap;)V
    //   119: aload_0
    //   120: getfield e : Lcom/blued/android/core/imagecache/glide/LruBitmapPool$BitmapTracker;
    //   123: aload_1
    //   124: invokeinterface a : (Landroid/graphics/Bitmap;)V
    //   129: aload_0
    //   130: aload_0
    //   131: getfield j : I
    //   134: iconst_1
    //   135: iadd
    //   136: putfield j : I
    //   139: aload_0
    //   140: aload_0
    //   141: getfield g : I
    //   144: iload_2
    //   145: iadd
    //   146: putfield g : I
    //   149: getstatic com/blued/android/core/imagecache/ImageLoaderUtils.a : Z
    //   152: ifeq -> 200
    //   155: new java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial <init> : ()V
    //   162: astore #4
    //   164: aload #4
    //   166: ldc_w 'Put bitmap in pool='
    //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload #4
    //   175: aload_0
    //   176: getfield b : Lcom/blued/android/core/imagecache/glide/LruPoolStrategy;
    //   179: aload_1
    //   180: invokeinterface b : (Landroid/graphics/Bitmap;)Ljava/lang/String;
    //   185: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: ldc 'LruBitmapPool'
    //   191: aload #4
    //   193: invokevirtual toString : ()Ljava/lang/String;
    //   196: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   199: pop
    //   200: aload_0
    //   201: invokespecial c : ()V
    //   204: aload_0
    //   205: invokespecial b : ()V
    //   208: aload_0
    //   209: monitorexit
    //   210: return
    //   211: getstatic com/blued/android/core/imagecache/ImageLoaderUtils.a : Z
    //   214: ifeq -> 309
    //   217: new java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial <init> : ()V
    //   224: astore #4
    //   226: aload #4
    //   228: ldc_w 'Reject bitmap from pool, bitmap: '
    //   231: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload #4
    //   237: aload_0
    //   238: getfield b : Lcom/blued/android/core/imagecache/glide/LruPoolStrategy;
    //   241: aload_1
    //   242: invokeinterface b : (Landroid/graphics/Bitmap;)Ljava/lang/String;
    //   247: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload #4
    //   253: ldc_w ', is mutable: '
    //   256: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload #4
    //   262: aload_1
    //   263: invokevirtual isMutable : ()Z
    //   266: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload #4
    //   272: ldc_w ', is allowed config: '
    //   275: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload #4
    //   281: aload_0
    //   282: getfield c : Ljava/util/Set;
    //   285: aload_1
    //   286: invokevirtual getConfig : ()Landroid/graphics/Bitmap$Config;
    //   289: invokeinterface contains : (Ljava/lang/Object;)Z
    //   294: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: ldc 'LruBitmapPool'
    //   300: aload #4
    //   302: invokevirtual toString : ()Ljava/lang/String;
    //   305: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   308: pop
    //   309: aload_1
    //   310: invokevirtual recycle : ()V
    //   313: aload_0
    //   314: monitorexit
    //   315: return
    //   316: astore_1
    //   317: aload_0
    //   318: monitorexit
    //   319: aload_1
    //   320: athrow
    // Exception table:
    //   from	to	target	type
    //   6	10	316	finally
    //   17	27	316	finally
    //   27	38	316	finally
    //   45	55	316	finally
    //   55	95	316	finally
    //   98	200	316	finally
    //   200	208	316	finally
    //   211	309	316	finally
    //   309	313	316	finally
  }
  
  static interface BitmapTracker {
    void a(Bitmap param1Bitmap);
    
    void b(Bitmap param1Bitmap);
  }
  
  static class NullBitmapTracker implements BitmapTracker {
    public void a(Bitmap param1Bitmap) {}
    
    public void b(Bitmap param1Bitmap) {}
  }
  
  static class ThrowingBitmapTracker implements BitmapTracker {
    private final Set<Bitmap> a = Collections.synchronizedSet(new HashSet<Bitmap>());
    
    public void a(Bitmap param1Bitmap) {
      if (!this.a.contains(param1Bitmap)) {
        this.a.add(param1Bitmap);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Can't add already added bitmap: ");
      stringBuilder.append(param1Bitmap);
      stringBuilder.append(" [");
      stringBuilder.append(param1Bitmap.getWidth());
      stringBuilder.append("x");
      stringBuilder.append(param1Bitmap.getHeight());
      stringBuilder.append("]");
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public void b(Bitmap param1Bitmap) {
      if (this.a.contains(param1Bitmap)) {
        this.a.remove(param1Bitmap);
        return;
      } 
      throw new IllegalStateException("Cannot remove bitmap not in tracker");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\glide\LruBitmapPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */