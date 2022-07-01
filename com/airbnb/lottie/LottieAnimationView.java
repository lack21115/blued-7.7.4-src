package com.airbnb.lottie;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LottieAnimationView extends AppCompatImageView {
  private static final String a = LottieAnimationView.class.getSimpleName();
  
  private final LottieListener<LottieComposition> b = new LottieListener<LottieComposition>(this) {
      public void a(LottieComposition param1LottieComposition) {
        this.a.setComposition(param1LottieComposition);
      }
    };
  
  private final LottieListener<Throwable> c = new LottieListener<Throwable>(this) {
      public void a(Throwable param1Throwable) {
        throw new IllegalStateException("Unable to parse composition", param1Throwable);
      }
    };
  
  private final LottieDrawable d = new LottieDrawable();
  
  private String e;
  
  private int f;
  
  private boolean g = false;
  
  private boolean h = false;
  
  private boolean i = false;
  
  private RenderMode j = RenderMode.a;
  
  private Set<LottieOnCompositionLoadedListener> k = new HashSet<LottieOnCompositionLoadedListener>();
  
  private LottieTask<LottieComposition> l;
  
  private LottieComposition m;
  
  public LottieAnimationView(Context paramContext) {
    super(paramContext);
    a((AttributeSet)null);
  }
  
  public LottieAnimationView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public LottieAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet) {
    TypedArray typedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.LottieAnimationView);
    boolean bool1 = isInEditMode();
    boolean bool = false;
    if (!bool1) {
      bool1 = typedArray.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
      boolean bool2 = typedArray.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
      boolean bool3 = typedArray.hasValue(R.styleable.LottieAnimationView_lottie_url);
      if (!bool1 || !bool2) {
        if (bool1) {
          int i = typedArray.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
          if (i != 0)
            setAnimation(i); 
        } else if (bool2) {
          String str = typedArray.getString(R.styleable.LottieAnimationView_lottie_fileName);
          if (str != null)
            setAnimation(str); 
        } else if (bool3) {
          String str = typedArray.getString(R.styleable.LottieAnimationView_lottie_url);
          if (str != null)
            setAnimationFromUrl(str); 
        } 
      } else {
        throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
      } 
    } 
    if (typedArray.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
      this.h = true;
      this.i = true;
    } 
    if (typedArray.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false))
      this.d.e(-1); 
    if (typedArray.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode))
      setRepeatMode(typedArray.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1)); 
    if (typedArray.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount))
      setRepeatCount(typedArray.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1)); 
    if (typedArray.hasValue(R.styleable.LottieAnimationView_lottie_speed))
      setSpeed(typedArray.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0F)); 
    setImageAssetsFolder(typedArray.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
    setProgress(typedArray.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0F));
    a(typedArray.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
    if (typedArray.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
      SimpleColorFilter simpleColorFilter = new SimpleColorFilter(typedArray.getColor(R.styleable.LottieAnimationView_lottie_colorFilter, 0));
      KeyPath keyPath = new KeyPath(new String[] { "**" });
      LottieValueCallback<ColorFilter> lottieValueCallback = new LottieValueCallback(simpleColorFilter);
      a(keyPath, LottieProperty.B, lottieValueCallback);
    } 
    if (typedArray.hasValue(R.styleable.LottieAnimationView_lottie_scale))
      this.d.e(typedArray.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0F)); 
    typedArray.recycle();
    LottieDrawable lottieDrawable = this.d;
    if (Utils.a(getContext()) != 0.0F)
      bool = true; 
    lottieDrawable.a(Boolean.valueOf(bool));
    h();
  }
  
  private void f() {
    LottieTask<LottieComposition> lottieTask = this.l;
    if (lottieTask != null) {
      lottieTask.b(this.b);
      this.l.d(this.c);
    } 
  }
  
  private void g() {
    this.m = null;
    this.d.d();
  }
  
  private void h() {
    int i = null.a[this.j.ordinal()];
    byte b = 2;
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
          return; 
        LottieComposition lottieComposition = this.m;
        i = 0;
        if (lottieComposition == null || !lottieComposition.a() || Build.VERSION.SDK_INT >= 28) {
          lottieComposition = this.m;
          if (lottieComposition == null || lottieComposition.b() <= 4)
            i = 1; 
        } 
        if (i != 0) {
          i = b;
        } else {
          i = 1;
        } 
        setLayerType(i, null);
        return;
      } 
      setLayerType(1, null);
      return;
    } 
    setLayerType(2, null);
  }
  
  private void setCompositionTask(LottieTask<LottieComposition> paramLottieTask) {
    g();
    f();
    this.l = paramLottieTask.a(this.b).c(this.c);
  }
  
  public void a() {
    if (isShown()) {
      this.d.e();
      h();
      return;
    } 
    this.g = true;
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener) {
    this.d.a(paramAnimatorListener);
  }
  
  public void a(JsonReader paramJsonReader, String paramString) {
    setCompositionTask(LottieCompositionFactory.a(paramJsonReader, paramString));
  }
  
  public <T> void a(KeyPath paramKeyPath, T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    this.d.a(paramKeyPath, paramT, paramLottieValueCallback);
  }
  
  public void a(String paramString1, String paramString2) {
    a(new JsonReader(new StringReader(paramString1)), paramString2);
  }
  
  public void a(boolean paramBoolean) {
    this.d.a(paramBoolean);
  }
  
  public void b() {
    if (isShown()) {
      this.d.g();
      h();
      return;
    } 
    this.g = true;
  }
  
  public void buildDrawingCache(boolean paramBoolean) {
    super.buildDrawingCache(paramBoolean);
    if (getLayerType() == 1 && getDrawingCache(paramBoolean) == null)
      setRenderMode(RenderMode.b); 
  }
  
  public boolean c() {
    return this.d.n();
  }
  
  public void d() {
    this.g = false;
    this.d.s();
    h();
  }
  
  public void e() {
    this.h = false;
    this.g = false;
    this.d.t();
    h();
  }
  
  public LottieComposition getComposition() {
    return this.m;
  }
  
  public long getDuration() {
    LottieComposition lottieComposition = this.m;
    return (lottieComposition != null) ? (long)lottieComposition.e() : 0L;
  }
  
  public int getFrame() {
    return this.d.k();
  }
  
  public String getImageAssetsFolder() {
    return this.d.b();
  }
  
  public float getMaxFrame() {
    return this.d.i();
  }
  
  public float getMinFrame() {
    return this.d.h();
  }
  
  public PerformanceTracker getPerformanceTracker() {
    return this.d.c();
  }
  
  public float getProgress() {
    return this.d.u();
  }
  
  public int getRepeatCount() {
    return this.d.m();
  }
  
  public int getRepeatMode() {
    return this.d.l();
  }
  
  public float getScale() {
    return this.d.q();
  }
  
  public float getSpeed() {
    return this.d.j();
  }
  
  public void invalidateDrawable(Drawable paramDrawable) {
    Drawable drawable = getDrawable();
    LottieDrawable lottieDrawable = this.d;
    if (drawable == lottieDrawable) {
      super.invalidateDrawable(lottieDrawable);
      return;
    } 
    super.invalidateDrawable(paramDrawable);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (this.i && this.h)
      a(); 
  }
  
  protected void onDetachedFromWindow() {
    if (c()) {
      d();
      this.h = true;
    } 
    super.onDetachedFromWindow();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    this.e = savedState.a;
    if (!TextUtils.isEmpty(this.e))
      setAnimation(this.e); 
    this.f = savedState.b;
    int i = this.f;
    if (i != 0)
      setAnimation(i); 
    setProgress(savedState.c);
    if (savedState.d)
      a(); 
    this.d.a(savedState.e);
    setRepeatMode(savedState.f);
    setRepeatCount(savedState.g);
  }
  
  protected Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = this.e;
    savedState.b = this.f;
    savedState.c = this.d.u();
    savedState.d = this.d.n();
    savedState.e = this.d.b();
    savedState.f = this.d.l();
    savedState.g = this.d.m();
    return (Parcelable)savedState;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt) {
    if (this.d == null)
      return; 
    if (isShown()) {
      if (this.g) {
        b();
        this.g = false;
        return;
      } 
    } else if (c()) {
      e();
      this.g = true;
    } 
  }
  
  public void setAnimation(int paramInt) {
    this.f = paramInt;
    this.e = null;
    setCompositionTask(LottieCompositionFactory.a(getContext(), paramInt));
  }
  
  public void setAnimation(String paramString) {
    this.e = paramString;
    this.f = 0;
    setCompositionTask(LottieCompositionFactory.b(getContext(), paramString));
  }
  
  @Deprecated
  public void setAnimationFromJson(String paramString) {
    a(paramString, (String)null);
  }
  
  public void setAnimationFromUrl(String paramString) {
    setCompositionTask(LottieCompositionFactory.a(getContext(), paramString));
  }
  
  public void setComposition(LottieComposition paramLottieComposition) {
    if (L.a) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Set Composition \n");
      stringBuilder.append(paramLottieComposition);
      Log.v(str, stringBuilder.toString());
    } 
    this.d.setCallback((Drawable.Callback)this);
    this.m = paramLottieComposition;
    boolean bool = this.d.a(paramLottieComposition);
    h();
    if (getDrawable() == this.d && !bool)
      return; 
    setImageDrawable((Drawable)null);
    setImageDrawable(this.d);
    requestLayout();
    Iterator<LottieOnCompositionLoadedListener> iterator = this.k.iterator();
    while (iterator.hasNext())
      ((LottieOnCompositionLoadedListener)iterator.next()).a(paramLottieComposition); 
  }
  
  public void setFontAssetDelegate(FontAssetDelegate paramFontAssetDelegate) {
    this.d.a(paramFontAssetDelegate);
  }
  
  public void setFrame(int paramInt) {
    this.d.c(paramInt);
  }
  
  public void setImageAssetDelegate(ImageAssetDelegate paramImageAssetDelegate) {
    this.d.a(paramImageAssetDelegate);
  }
  
  public void setImageAssetsFolder(String paramString) {
    this.d.a(paramString);
  }
  
  public void setImageBitmap(Bitmap paramBitmap) {
    f();
    super.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable) {
    f();
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageResource(int paramInt) {
    f();
    super.setImageResource(paramInt);
  }
  
  public void setMaxFrame(int paramInt) {
    this.d.b(paramInt);
  }
  
  public void setMaxFrame(String paramString) {
    this.d.c(paramString);
  }
  
  public void setMaxProgress(float paramFloat) {
    this.d.b(paramFloat);
  }
  
  public void setMinAndMaxFrame(String paramString) {
    this.d.d(paramString);
  }
  
  public void setMinFrame(int paramInt) {
    this.d.a(paramInt);
  }
  
  public void setMinFrame(String paramString) {
    this.d.b(paramString);
  }
  
  public void setMinProgress(float paramFloat) {
    this.d.a(paramFloat);
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean) {
    this.d.b(paramBoolean);
  }
  
  public void setProgress(float paramFloat) {
    this.d.d(paramFloat);
  }
  
  public void setRenderMode(RenderMode paramRenderMode) {
    this.j = paramRenderMode;
    h();
  }
  
  public void setRepeatCount(int paramInt) {
    this.d.e(paramInt);
  }
  
  public void setRepeatMode(int paramInt) {
    this.d.d(paramInt);
  }
  
  public void setScale(float paramFloat) {
    this.d.e(paramFloat);
    if (getDrawable() == this.d) {
      setImageDrawable((Drawable)null);
      setImageDrawable(this.d);
    } 
  }
  
  public void setSpeed(float paramFloat) {
    this.d.c(paramFloat);
  }
  
  public void setTextDelegate(TextDelegate paramTextDelegate) {
    this.d.a(paramTextDelegate);
  }
  
  static class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public LottieAnimationView.SavedState a(Parcel param2Parcel) {
          return new LottieAnimationView.SavedState(param2Parcel);
        }
        
        public LottieAnimationView.SavedState[] a(int param2Int) {
          return new LottieAnimationView.SavedState[param2Int];
        }
      };
    
    String a;
    
    int b;
    
    float c;
    
    boolean d;
    
    String e;
    
    int f;
    
    int g;
    
    private SavedState(Parcel param1Parcel) {
      super(param1Parcel);
      this.a = param1Parcel.readString();
      this.c = param1Parcel.readFloat();
      int i = param1Parcel.readInt();
      boolean bool = true;
      if (i != 1)
        bool = false; 
      this.d = bool;
      this.e = param1Parcel.readString();
      this.f = param1Parcel.readInt();
      this.g = param1Parcel.readInt();
    }
    
    SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public LottieAnimationView.SavedState a(Parcel param1Parcel) {
      return new LottieAnimationView.SavedState(param1Parcel);
    }
    
    public LottieAnimationView.SavedState[] a(int param1Int) {
      return new LottieAnimationView.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\LottieAnimationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */