package com.blued.android.core.image;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.apng.AnimationRequestListener;
import com.blued.android.core.image.http.HttpRequestListener;
import com.blued.android.core.net.IRequestHost;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import java.util.ArrayList;

public class ImageWrapper {
  private RequestBuilder a;
  
  private IRequestHost b;
  
  private ImageLoadResult c;
  
  private int d = 0;
  
  private int e = 1;
  
  private ImageLoader.OnAnimationStateListener f;
  
  private int g = 0;
  
  private int h = 0;
  
  private int i = 0;
  
  private int j = 0;
  
  private int k = 0;
  
  private int[] l = null;
  
  private float m = 0.0F;
  
  private float n = 0.0F;
  
  private boolean o = true;
  
  private int p = 25;
  
  private int q = 0;
  
  private int r = 0;
  
  private Drawable s = null;
  
  private String t = null;
  
  protected ImageWrapper(IRequestHost paramIRequestHost, RequestBuilder paramRequestBuilder) {
    this.b = paramIRequestHost;
    this.a = paramRequestBuilder;
  }
  
  private ImageWrapper a(int paramInt1, boolean paramBoolean, int paramInt2) {
    boolean bool;
    this.d = paramInt1;
    BaseRequestOptions baseRequestOptions = this.a.b(DiskCacheStrategy.e);
    Option<Boolean> option = ImageLoaderOptions.b;
    if (paramInt1 == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    baseRequestOptions.b(option, Boolean.valueOf(bool)).d(paramBoolean ^ true).b(ImageLoaderOptions.c, Integer.valueOf(paramInt2));
    return this;
  }
  
  private void a(int paramInt1, int paramInt2) {
    this.h = paramInt1 | paramInt2 & this.h;
  }
  
  private void i() {
    if (this.h > 0) {
      ArrayList<Transformation> arrayList = j();
      if (arrayList.size() > 0)
        this.a.b(arrayList.<Transformation>toArray(new Transformation[0])); 
      if (4096 == this.h)
        this.a.b(DownsampleStrategy.d); 
    } 
    ImageLoadResult imageLoadResult = this.c;
    if (imageLoadResult != null)
      this.a.d((RequestListener)new HttpRequestListener(imageLoadResult)); 
    if (this.f != null || (this.d == 1 && this.e != 1) || (this.d == 2 && this.e > 0)) {
      AnimationRequestListener animationRequestListener = new AnimationRequestListener(this.e, this.f);
      if (this.c != null) {
        this.a.c((RequestListener)animationRequestListener);
      } else {
        this.a.d((RequestListener)animationRequestListener);
      } 
    } 
    int i = this.r;
    if (i != 0) {
      this.a.h(i);
    } else {
      Drawable drawable = this.s;
      if (drawable != null)
        this.a.b(drawable); 
    } 
    i = this.q;
    if (i != 0)
      this.a.f(i).g(this.q); 
    if (!TextUtils.isEmpty(this.t))
      this.a.b((RequestBuilder)ImageLoader.a(this.b).b(this.t).e(true)); 
    i = this.g;
    if (i > 0) {
      if (this.r != 0 || this.s != null) {
        this.a.b((TransitionOptions)DrawableTransitionOptions.a((new DrawableCrossFadeFactory.Builder(this.g)).a(true).a()));
        return;
      } 
      this.a.b((TransitionOptions)DrawableTransitionOptions.a(i));
      return;
    } 
  }
  
  private ArrayList<Transformation> j() {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #4
    //   9: aload_0
    //   10: getfield h : I
    //   13: istore_1
    //   14: sipush #4096
    //   17: iload_1
    //   18: if_icmpne -> 37
    //   21: aload #4
    //   23: new com/blued/android/core/image/transform/NinePatchTransformation
    //   26: dup
    //   27: invokespecial <init> : ()V
    //   30: invokevirtual add : (Ljava/lang/Object;)Z
    //   33: pop
    //   34: aload #4
    //   36: areturn
    //   37: iload_1
    //   38: sipush #240
    //   41: iand
    //   42: istore_2
    //   43: iload_1
    //   44: bipush #15
    //   46: iand
    //   47: istore_3
    //   48: iload_3
    //   49: iconst_3
    //   50: if_icmpeq -> 60
    //   53: iload_2
    //   54: istore_1
    //   55: iload_3
    //   56: iconst_4
    //   57: if_icmpne -> 69
    //   60: iload_2
    //   61: istore_1
    //   62: iload_2
    //   63: ifne -> 69
    //   66: bipush #32
    //   68: istore_1
    //   69: iload_1
    //   70: bipush #16
    //   72: if_icmpeq -> 154
    //   75: iload_1
    //   76: bipush #32
    //   78: if_icmpeq -> 124
    //   81: iload_1
    //   82: bipush #48
    //   84: if_icmpeq -> 90
    //   87: goto -> 189
    //   90: invokestatic a : ()Z
    //   93: ifeq -> 104
    //   96: ldc 'IMAGE'
    //   98: ldc 'ImageWrapper -- TRANSFORMATION_CROP_START_END'
    //   100: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   103: pop
    //   104: aload #4
    //   106: new com/blued/android/core/image/transform/CropWithStartEndTransformation
    //   109: dup
    //   110: aload_0
    //   111: getfield o : Z
    //   114: invokespecial <init> : (Z)V
    //   117: invokevirtual add : (Ljava/lang/Object;)Z
    //   120: pop
    //   121: goto -> 189
    //   124: invokestatic a : ()Z
    //   127: ifeq -> 138
    //   130: ldc 'IMAGE'
    //   132: ldc 'ImageWrapper -- TRANSFORMATION_CROP_CENTER'
    //   134: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   137: pop
    //   138: aload #4
    //   140: new com/bumptech/glide/load/resource/bitmap/CenterCrop
    //   143: dup
    //   144: invokespecial <init> : ()V
    //   147: invokevirtual add : (Ljava/lang/Object;)Z
    //   150: pop
    //   151: goto -> 189
    //   154: invokestatic a : ()Z
    //   157: ifeq -> 168
    //   160: ldc 'IMAGE'
    //   162: ldc 'ImageWrapper -- TRANSFORMATION_SQUARE_WITH_RATE'
    //   164: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   167: pop
    //   168: aload #4
    //   170: new com/blued/android/core/image/transform/CropSquareWithRateTransformation
    //   173: dup
    //   174: aload_0
    //   175: getfield m : F
    //   178: aload_0
    //   179: getfield n : F
    //   182: invokespecial <init> : (FF)V
    //   185: invokevirtual add : (Ljava/lang/Object;)Z
    //   188: pop
    //   189: sipush #256
    //   192: aload_0
    //   193: getfield h : I
    //   196: sipush #256
    //   199: iand
    //   200: if_icmpne -> 234
    //   203: invokestatic a : ()Z
    //   206: ifeq -> 217
    //   209: ldc 'IMAGE'
    //   211: ldc 'ImageWrapper -- TRANSFORMATION_BLUR'
    //   213: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   216: pop
    //   217: aload #4
    //   219: new com/blued/android/core/image/transform/BlurTransformation
    //   222: dup
    //   223: aload_0
    //   224: getfield p : I
    //   227: invokespecial <init> : (I)V
    //   230: invokevirtual add : (Ljava/lang/Object;)Z
    //   233: pop
    //   234: iload_3
    //   235: iconst_1
    //   236: if_icmpeq -> 434
    //   239: iload_3
    //   240: iconst_2
    //   241: if_icmpeq -> 389
    //   244: iload_3
    //   245: iconst_3
    //   246: if_icmpeq -> 348
    //   249: iload_3
    //   250: iconst_4
    //   251: if_icmpeq -> 257
    //   254: aload #4
    //   256: areturn
    //   257: invokestatic a : ()Z
    //   260: ifeq -> 272
    //   263: ldc 'IMAGE'
    //   265: ldc_w 'ImageWrapper -- TRANSFORMATION_ROUND_CORNER_MULTIPLE'
    //   268: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   271: pop
    //   272: aload_0
    //   273: getfield l : [I
    //   276: astore #5
    //   278: aload #5
    //   280: arraylength
    //   281: istore_2
    //   282: iconst_0
    //   283: istore_1
    //   284: iload_1
    //   285: iload_2
    //   286: if_icmpge -> 306
    //   289: aload #5
    //   291: iload_1
    //   292: iaload
    //   293: ifge -> 299
    //   296: aload #4
    //   298: areturn
    //   299: iload_1
    //   300: iconst_1
    //   301: iadd
    //   302: istore_1
    //   303: goto -> 284
    //   306: aload_0
    //   307: getfield l : [I
    //   310: astore #5
    //   312: aload #4
    //   314: new com/bumptech/glide/load/resource/bitmap/GranularRoundedCorners
    //   317: dup
    //   318: aload #5
    //   320: iconst_0
    //   321: iaload
    //   322: i2f
    //   323: aload #5
    //   325: iconst_1
    //   326: iaload
    //   327: i2f
    //   328: aload #5
    //   330: iconst_2
    //   331: iaload
    //   332: i2f
    //   333: aload #5
    //   335: iconst_3
    //   336: iaload
    //   337: i2f
    //   338: invokespecial <init> : (FFFF)V
    //   341: invokevirtual add : (Ljava/lang/Object;)Z
    //   344: pop
    //   345: aload #4
    //   347: areturn
    //   348: invokestatic a : ()Z
    //   351: ifeq -> 363
    //   354: ldc 'IMAGE'
    //   356: ldc_w 'ImageWrapper -- TRANSFORMATION_ROUND_CORNER'
    //   359: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   362: pop
    //   363: aload_0
    //   364: getfield k : I
    //   367: istore_1
    //   368: iload_1
    //   369: ifle -> 462
    //   372: aload #4
    //   374: new com/bumptech/glide/load/resource/bitmap/RoundedCorners
    //   377: dup
    //   378: iload_1
    //   379: invokespecial <init> : (I)V
    //   382: invokevirtual add : (Ljava/lang/Object;)Z
    //   385: pop
    //   386: aload #4
    //   388: areturn
    //   389: invokestatic a : ()Z
    //   392: ifeq -> 404
    //   395: ldc 'IMAGE'
    //   397: ldc_w 'ImageWrapper -- TRANSFORMATION_CIRCLE_WITH_BORDER'
    //   400: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   403: pop
    //   404: aload_0
    //   405: getfield i : I
    //   408: istore_1
    //   409: iload_1
    //   410: ifle -> 462
    //   413: aload #4
    //   415: new com/blued/android/core/image/transform/CropCircleWithBorderTransformation
    //   418: dup
    //   419: iload_1
    //   420: aload_0
    //   421: getfield j : I
    //   424: invokespecial <init> : (II)V
    //   427: invokevirtual add : (Ljava/lang/Object;)Z
    //   430: pop
    //   431: aload #4
    //   433: areturn
    //   434: invokestatic a : ()Z
    //   437: ifeq -> 449
    //   440: ldc 'IMAGE'
    //   442: ldc_w 'ImageWrapper -- TRANSFORMATION_CIRCLE'
    //   445: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   448: pop
    //   449: aload #4
    //   451: new com/bumptech/glide/load/resource/bitmap/CircleCrop
    //   454: dup
    //   455: invokespecial <init> : ()V
    //   458: invokevirtual add : (Ljava/lang/Object;)Z
    //   461: pop
    //   462: aload #4
    //   464: areturn
  }
  
  public ImageWrapper a() {
    this.a.b(DiskCacheStrategy.b).d(true);
    return this;
  }
  
  public ImageWrapper a(float paramFloat) {
    a(3, 15);
    this.k = AppMethods.a(paramFloat);
    return this;
  }
  
  public ImageWrapper a(float paramFloat1, float paramFloat2) {
    a(16, 240);
    this.m = paramFloat1;
    this.n = paramFloat2;
    return this;
  }
  
  public ImageWrapper a(float paramFloat, int paramInt) {
    a(2, 15);
    this.i = AppMethods.a(paramFloat);
    this.j = paramInt;
    return this;
  }
  
  public ImageWrapper a(int paramInt) {
    this.r = paramInt;
    return this;
  }
  
  public ImageWrapper a(ImageLoadResult paramImageLoadResult) {
    this.c = paramImageLoadResult;
    return this;
  }
  
  public ImageWrapper a(ImageLoader.OnAnimationStateListener paramOnAnimationStateListener) {
    this.f = paramOnAnimationStateListener;
    return this;
  }
  
  public ImageWrapper a(ImageOptions paramImageOptions) {
    if (paramImageOptions != null) {
      this.r = paramImageOptions.a;
      this.q = paramImageOptions.c;
      this.t = paramImageOptions.b;
    } 
    return this;
  }
  
  public ImageWrapper a(String paramString) {
    this.t = paramString;
    return this;
  }
  
  public ImageWrapper a(boolean paramBoolean, float paramFloat) {
    a(48, 240);
    this.o = paramBoolean;
    a(3, 15);
    this.k = AppMethods.a(paramFloat);
    return this;
  }
  
  public void a(ImageView paramImageView) {
    if (paramImageView != null) {
      i();
      this.a.a(paramImageView);
    } 
  }
  
  public void a(Target<Drawable> paramTarget) {
    if (paramTarget != null) {
      i();
      this.a.a(paramTarget);
    } 
  }
  
  public ImageWrapper b() {
    this.a.b(DiskCacheStrategy.b);
    return this;
  }
  
  public ImageWrapper b(int paramInt) {
    this.g = paramInt;
    return this;
  }
  
  public ImageWrapper c() {
    a(1, 15);
    return this;
  }
  
  public ImageWrapper c(int paramInt) {
    this.q = paramInt;
    return this;
  }
  
  public ImageWrapper d() {
    this.h |= 0x100;
    this.p = 25;
    return this;
  }
  
  public ImageWrapper d(int paramInt) {
    return a(1, true, paramInt);
  }
  
  public ImageWrapper e() {
    this.a.b(DiskCacheStrategy.c).e(-2147483648);
    return this;
  }
  
  public ImageWrapper e(int paramInt) {
    if (paramInt <= 0)
      paramInt = -1; 
    this.e = paramInt;
    return this;
  }
  
  public ImageWrapper f() {
    return a(1, true, 0);
  }
  
  public ImageWrapper g() {
    return a(1, false, hashCode());
  }
  
  public ImageWrapper h() {
    return a(2, true, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\ImageWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */