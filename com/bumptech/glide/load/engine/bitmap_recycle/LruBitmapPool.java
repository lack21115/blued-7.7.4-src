package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool implements BitmapPool {
  private static final Bitmap.Config a = Bitmap.Config.ARGB_8888;
  
  private final LruPoolStrategy b;
  
  private final Set<Bitmap.Config> c;
  
  private final long d;
  
  private final BitmapTracker e;
  
  private long f;
  
  private long g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  public LruBitmapPool(long paramLong) {
    this(paramLong, f(), g());
  }
  
  LruBitmapPool(long paramLong, LruPoolStrategy paramLruPoolStrategy, Set<Bitmap.Config> paramSet) {
    this.d = paramLong;
    this.f = paramLong;
    this.b = paramLruPoolStrategy;
    this.c = paramSet;
    this.e = new NullBitmapTracker();
  }
  
  private void a(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : J
    //   6: lload_1
    //   7: lcmp
    //   8: ifle -> 158
    //   11: aload_0
    //   12: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   15: invokeinterface a : ()Landroid/graphics/Bitmap;
    //   20: astore_3
    //   21: aload_3
    //   22: ifnonnull -> 54
    //   25: ldc 'LruBitmapPool'
    //   27: iconst_5
    //   28: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   31: ifeq -> 46
    //   34: ldc 'LruBitmapPool'
    //   36: ldc 'Size mismatch, resetting'
    //   38: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   41: pop
    //   42: aload_0
    //   43: invokespecial e : ()V
    //   46: aload_0
    //   47: lconst_0
    //   48: putfield g : J
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: getfield e : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool$BitmapTracker;
    //   58: aload_3
    //   59: invokeinterface b : (Landroid/graphics/Bitmap;)V
    //   64: aload_0
    //   65: aload_0
    //   66: getfield g : J
    //   69: aload_0
    //   70: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   73: aload_3
    //   74: invokeinterface c : (Landroid/graphics/Bitmap;)I
    //   79: i2l
    //   80: lsub
    //   81: putfield g : J
    //   84: aload_0
    //   85: aload_0
    //   86: getfield k : I
    //   89: iconst_1
    //   90: iadd
    //   91: putfield k : I
    //   94: ldc 'LruBitmapPool'
    //   96: iconst_3
    //   97: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   100: ifeq -> 147
    //   103: new java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial <init> : ()V
    //   110: astore #4
    //   112: aload #4
    //   114: ldc 'Evicting bitmap='
    //   116: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload #4
    //   122: aload_0
    //   123: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   126: aload_3
    //   127: invokeinterface b : (Landroid/graphics/Bitmap;)Ljava/lang/String;
    //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: ldc 'LruBitmapPool'
    //   138: aload #4
    //   140: invokevirtual toString : ()Ljava/lang/String;
    //   143: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   146: pop
    //   147: aload_0
    //   148: invokespecial d : ()V
    //   151: aload_3
    //   152: invokevirtual recycle : ()V
    //   155: goto -> 2
    //   158: aload_0
    //   159: monitorexit
    //   160: return
    //   161: astore_3
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_3
    //   165: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	161	finally
    //   25	46	161	finally
    //   46	51	161	finally
    //   54	147	161	finally
    //   147	155	161	finally
  }
  
  private static void a(Bitmap.Config paramConfig) {
    if (Build.VERSION.SDK_INT < 26)
      return; 
    if (paramConfig != Bitmap.Config.HARDWARE)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot create a mutable Bitmap with config: ");
    stringBuilder.append(paramConfig);
    stringBuilder.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private static void b(Bitmap paramBitmap) {
    paramBitmap.setHasAlpha(true);
    c(paramBitmap);
  }
  
  private static Bitmap c(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    if (paramConfig == null)
      paramConfig = a; 
    return Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
  }
  
  private void c() {
    a(this.f);
  }
  
  private static void c(Bitmap paramBitmap) {
    if (Build.VERSION.SDK_INT >= 19)
      paramBitmap.setPremultiplied(true); 
  }
  
  private Bitmap d(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: invokestatic a : (Landroid/graphics/Bitmap$Config;)V
    //   6: aload_0
    //   7: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   10: astore #5
    //   12: aload_3
    //   13: ifnull -> 22
    //   16: aload_3
    //   17: astore #4
    //   19: goto -> 27
    //   22: getstatic com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.a : Landroid/graphics/Bitmap$Config;
    //   25: astore #4
    //   27: aload #5
    //   29: iload_1
    //   30: iload_2
    //   31: aload #4
    //   33: invokeinterface a : (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   38: astore #4
    //   40: aload #4
    //   42: ifnonnull -> 113
    //   45: ldc 'LruBitmapPool'
    //   47: iconst_3
    //   48: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   51: ifeq -> 100
    //   54: new java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial <init> : ()V
    //   61: astore #5
    //   63: aload #5
    //   65: ldc 'Missing bitmap='
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload #5
    //   73: aload_0
    //   74: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   77: iload_1
    //   78: iload_2
    //   79: aload_3
    //   80: invokeinterface b : (IILandroid/graphics/Bitmap$Config;)Ljava/lang/String;
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: ldc 'LruBitmapPool'
    //   91: aload #5
    //   93: invokevirtual toString : ()Ljava/lang/String;
    //   96: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   99: pop
    //   100: aload_0
    //   101: aload_0
    //   102: getfield i : I
    //   105: iconst_1
    //   106: iadd
    //   107: putfield i : I
    //   110: goto -> 160
    //   113: aload_0
    //   114: aload_0
    //   115: getfield h : I
    //   118: iconst_1
    //   119: iadd
    //   120: putfield h : I
    //   123: aload_0
    //   124: aload_0
    //   125: getfield g : J
    //   128: aload_0
    //   129: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   132: aload #4
    //   134: invokeinterface c : (Landroid/graphics/Bitmap;)I
    //   139: i2l
    //   140: lsub
    //   141: putfield g : J
    //   144: aload_0
    //   145: getfield e : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool$BitmapTracker;
    //   148: aload #4
    //   150: invokeinterface b : (Landroid/graphics/Bitmap;)V
    //   155: aload #4
    //   157: invokestatic b : (Landroid/graphics/Bitmap;)V
    //   160: ldc 'LruBitmapPool'
    //   162: iconst_2
    //   163: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   166: ifeq -> 215
    //   169: new java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial <init> : ()V
    //   176: astore #5
    //   178: aload #5
    //   180: ldc 'Get bitmap='
    //   182: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload #5
    //   188: aload_0
    //   189: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   192: iload_1
    //   193: iload_2
    //   194: aload_3
    //   195: invokeinterface b : (IILandroid/graphics/Bitmap$Config;)Ljava/lang/String;
    //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: ldc 'LruBitmapPool'
    //   206: aload #5
    //   208: invokevirtual toString : ()Ljava/lang/String;
    //   211: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   214: pop
    //   215: aload_0
    //   216: invokespecial d : ()V
    //   219: aload_0
    //   220: monitorexit
    //   221: aload #4
    //   223: areturn
    //   224: astore_3
    //   225: aload_0
    //   226: monitorexit
    //   227: aload_3
    //   228: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	224	finally
    //   22	27	224	finally
    //   27	40	224	finally
    //   45	100	224	finally
    //   100	110	224	finally
    //   113	160	224	finally
    //   160	215	224	finally
    //   215	219	224	finally
  }
  
  private void d() {
    if (Log.isLoggable("LruBitmapPool", 2))
      e(); 
  }
  
  private void e() {
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
    Log.v("LruBitmapPool", stringBuilder.toString());
  }
  
  private static LruPoolStrategy f() {
    return (LruPoolStrategy)((Build.VERSION.SDK_INT >= 19) ? new SizeConfigStrategy() : new AttributeStrategy());
  }
  
  private static Set<Bitmap.Config> g() {
    HashSet<? extends Bitmap.Config> hashSet = new HashSet(Arrays.asList((Object[])Bitmap.Config.values()));
    if (Build.VERSION.SDK_INT >= 19)
      hashSet.add(null); 
    if (Build.VERSION.SDK_INT >= 26)
      hashSet.remove(Bitmap.Config.HARDWARE); 
    return Collections.unmodifiableSet(hashSet);
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    Bitmap bitmap = d(paramInt1, paramInt2, paramConfig);
    if (bitmap != null) {
      bitmap.eraseColor(0);
      return bitmap;
    } 
    return c(paramInt1, paramInt2, paramConfig);
  }
  
  public void a() {
    if (Log.isLoggable("LruBitmapPool", 3))
      Log.d("LruBitmapPool", "clearMemory"); 
    a(0L);
  }
  
  public void a(int paramInt) {
    if (Log.isLoggable("LruBitmapPool", 3)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("trimMemory, level=");
      stringBuilder.append(paramInt);
      Log.d("LruBitmapPool", stringBuilder.toString());
    } 
    if (paramInt >= 40 || (Build.VERSION.SDK_INT >= 23 && paramInt >= 20)) {
      a();
      return;
    } 
    if (paramInt >= 20 || paramInt == 15) {
      a(b() / 2L);
      return;
    } 
  }
  
  public void a(Bitmap paramBitmap) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 282
    //   6: aload_1
    //   7: invokevirtual isRecycled : ()Z
    //   10: ifne -> 271
    //   13: aload_1
    //   14: invokevirtual isMutable : ()Z
    //   17: ifeq -> 171
    //   20: aload_0
    //   21: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   24: aload_1
    //   25: invokeinterface c : (Landroid/graphics/Bitmap;)I
    //   30: i2l
    //   31: aload_0
    //   32: getfield f : J
    //   35: lcmp
    //   36: ifgt -> 171
    //   39: aload_0
    //   40: getfield c : Ljava/util/Set;
    //   43: aload_1
    //   44: invokevirtual getConfig : ()Landroid/graphics/Bitmap$Config;
    //   47: invokeinterface contains : (Ljava/lang/Object;)Z
    //   52: ifne -> 58
    //   55: goto -> 171
    //   58: aload_0
    //   59: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   62: aload_1
    //   63: invokeinterface c : (Landroid/graphics/Bitmap;)I
    //   68: istore_2
    //   69: aload_0
    //   70: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   73: aload_1
    //   74: invokeinterface a : (Landroid/graphics/Bitmap;)V
    //   79: aload_0
    //   80: getfield e : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool$BitmapTracker;
    //   83: aload_1
    //   84: invokeinterface a : (Landroid/graphics/Bitmap;)V
    //   89: aload_0
    //   90: aload_0
    //   91: getfield j : I
    //   94: iconst_1
    //   95: iadd
    //   96: putfield j : I
    //   99: aload_0
    //   100: aload_0
    //   101: getfield g : J
    //   104: iload_2
    //   105: i2l
    //   106: ladd
    //   107: putfield g : J
    //   110: ldc 'LruBitmapPool'
    //   112: iconst_2
    //   113: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   116: ifeq -> 160
    //   119: new java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial <init> : ()V
    //   126: astore_3
    //   127: aload_3
    //   128: ldc_w 'Put bitmap in pool='
    //   131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_3
    //   136: aload_0
    //   137: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   140: aload_1
    //   141: invokeinterface b : (Landroid/graphics/Bitmap;)Ljava/lang/String;
    //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: ldc 'LruBitmapPool'
    //   152: aload_3
    //   153: invokevirtual toString : ()Ljava/lang/String;
    //   156: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   159: pop
    //   160: aload_0
    //   161: invokespecial d : ()V
    //   164: aload_0
    //   165: invokespecial c : ()V
    //   168: aload_0
    //   169: monitorexit
    //   170: return
    //   171: ldc 'LruBitmapPool'
    //   173: iconst_2
    //   174: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   177: ifeq -> 264
    //   180: new java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial <init> : ()V
    //   187: astore_3
    //   188: aload_3
    //   189: ldc_w 'Reject bitmap from pool, bitmap: '
    //   192: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_3
    //   197: aload_0
    //   198: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   201: aload_1
    //   202: invokeinterface b : (Landroid/graphics/Bitmap;)Ljava/lang/String;
    //   207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_3
    //   212: ldc_w ', is mutable: '
    //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_3
    //   220: aload_1
    //   221: invokevirtual isMutable : ()Z
    //   224: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_3
    //   229: ldc_w ', is allowed config: '
    //   232: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_3
    //   237: aload_0
    //   238: getfield c : Ljava/util/Set;
    //   241: aload_1
    //   242: invokevirtual getConfig : ()Landroid/graphics/Bitmap$Config;
    //   245: invokeinterface contains : (Ljava/lang/Object;)Z
    //   250: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: ldc 'LruBitmapPool'
    //   256: aload_3
    //   257: invokevirtual toString : ()Ljava/lang/String;
    //   260: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   263: pop
    //   264: aload_1
    //   265: invokevirtual recycle : ()V
    //   268: aload_0
    //   269: monitorexit
    //   270: return
    //   271: new java/lang/IllegalStateException
    //   274: dup
    //   275: ldc_w 'Cannot pool recycled bitmap'
    //   278: invokespecial <init> : (Ljava/lang/String;)V
    //   281: athrow
    //   282: new java/lang/NullPointerException
    //   285: dup
    //   286: ldc_w 'Bitmap must not be null'
    //   289: invokespecial <init> : (Ljava/lang/String;)V
    //   292: athrow
    //   293: aload_0
    //   294: monitorexit
    //   295: aload_1
    //   296: athrow
    //   297: astore_1
    //   298: goto -> 293
    // Exception table:
    //   from	to	target	type
    //   6	55	297	finally
    //   58	160	297	finally
    //   160	168	297	finally
    //   171	264	297	finally
    //   264	268	297	finally
    //   271	282	297	finally
    //   282	293	297	finally
  }
  
  public long b() {
    return this.f;
  }
  
  public Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    Bitmap bitmap2 = d(paramInt1, paramInt2, paramConfig);
    Bitmap bitmap1 = bitmap2;
    if (bitmap2 == null)
      bitmap1 = c(paramInt1, paramInt2, paramConfig); 
    return bitmap1;
  }
  
  static interface BitmapTracker {
    void a(Bitmap param1Bitmap);
    
    void b(Bitmap param1Bitmap);
  }
  
  static final class NullBitmapTracker implements BitmapTracker {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\bitmap_recycle\LruBitmapPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */