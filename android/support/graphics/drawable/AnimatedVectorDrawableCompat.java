package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public final class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {
  private AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState mAnimatedVectorState;
  
  private ArgbEvaluator mArgbEvaluator = null;
  
  final Drawable.Callback mCallback = new AnimatedVectorDrawableCompat$1(this);
  
  private Context mContext;
  
  AnimatedVectorDrawableCompat() {
    this((Context)null, (AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState)null, (Resources)null);
  }
  
  private AnimatedVectorDrawableCompat(Context paramContext) {
    this(paramContext, (AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState)null, (Resources)null);
  }
  
  private AnimatedVectorDrawableCompat(Context paramContext, AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState paramAnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState, Resources paramResources) {
    this.mContext = paramContext;
    if (paramAnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState != null) {
      this.mAnimatedVectorState = paramAnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState;
      return;
    } 
    this.mAnimatedVectorState = new AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState(paramAnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState, this.mCallback, paramResources);
  }
  
  public static AnimatedVectorDrawableCompat createFromXmlInner(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(paramContext);
    animatedVectorDrawableCompat.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return animatedVectorDrawableCompat;
  }
  
  private void setupColorAnimator(Animator paramAnimator) {
    if (paramAnimator instanceof AnimatorSet) {
      ArrayList<Animator> arrayList = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (arrayList != null)
        for (int i = 0; i < arrayList.size(); i++)
          setupColorAnimator(arrayList.get(i));  
    } 
    if (paramAnimator instanceof ObjectAnimator) {
      ObjectAnimator objectAnimator = (ObjectAnimator)paramAnimator;
      String str = objectAnimator.getPropertyName();
      if ("fillColor".equals(str) || "strokeColor".equals(str)) {
        if (this.mArgbEvaluator == null)
          this.mArgbEvaluator = new ArgbEvaluator(); 
        objectAnimator.setEvaluator((TypeEvaluator)this.mArgbEvaluator);
      } 
    } 
  }
  
  public final void applyTheme(Resources.Theme paramTheme) {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.applyTheme(this.mDelegateDrawable, paramTheme);
      return;
    } 
  }
  
  public final boolean canApplyTheme() {
    return (this.mDelegateDrawable != null) ? DrawableCompat.canApplyTheme(this.mDelegateDrawable) : false;
  }
  
  public final void draw(Canvas paramCanvas) {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.draw(paramCanvas);
      return;
    } 
    this.mAnimatedVectorState.mVectorDrawable.draw(paramCanvas);
    if (this.mAnimatedVectorState.mAnimatorSet.isStarted())
      invalidateSelf(); 
  }
  
  public final int getAlpha() {
    return (this.mDelegateDrawable != null) ? DrawableCompat.getAlpha(this.mDelegateDrawable) : this.mAnimatedVectorState.mVectorDrawable.getAlpha();
  }
  
  public final int getChangingConfigurations() {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.getChangingConfigurations() : (super.getChangingConfigurations() | this.mAnimatedVectorState.mChangingConfigurations);
  }
  
  public final Drawable.ConstantState getConstantState() {
    return (this.mDelegateDrawable != null && Build.VERSION.SDK_INT >= 24) ? new AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState()) : null;
  }
  
  public final int getIntrinsicHeight() {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.getIntrinsicHeight() : this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
  }
  
  public final int getIntrinsicWidth() {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.getIntrinsicWidth() : this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
  }
  
  public final int getOpacity() {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.getOpacity() : this.mAnimatedVectorState.mVectorDrawable.getOpacity();
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet) {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, (Resources.Theme)null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.inflate(this.mDelegateDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    } 
    int i = paramXmlPullParser.getEventType();
    int j = paramXmlPullParser.getDepth();
    while (i != 1 && (paramXmlPullParser.getDepth() >= j + 1 || i != 3)) {
      if (i == 2) {
        TypedArray typedArray;
        String str = paramXmlPullParser.getName();
        if ("animated-vector".equals(str)) {
          typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
          i = typedArray.getResourceId(0, 0);
          if (i != 0) {
            VectorDrawableCompat vectorDrawableCompat = VectorDrawableCompat.create(paramResources, i, paramTheme);
            vectorDrawableCompat.mAllowCaching = false;
            vectorDrawableCompat.setCallback(this.mCallback);
            if (this.mAnimatedVectorState.mVectorDrawable != null)
              this.mAnimatedVectorState.mVectorDrawable.setCallback(null); 
            this.mAnimatedVectorState.mVectorDrawable = vectorDrawableCompat;
          } 
          typedArray.recycle();
        } else if ("target".equals(typedArray)) {
          TypedArray typedArray1 = paramResources.obtainAttributes(paramAttributeSet, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
          String str1 = typedArray1.getString(0);
          i = typedArray1.getResourceId(1, 0);
          if (i != 0)
            if (this.mContext != null) {
              Animator animator;
              Context context = this.mContext;
              if (Build.VERSION.SDK_INT >= 24) {
                animator = AnimatorInflater.loadAnimator(context, i);
              } else {
                animator = AnimatorInflaterCompat.loadAnimator((Context)animator, animator.getResources(), animator.getTheme(), i, 1.0F);
              } 
              animator.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(str1));
              if (Build.VERSION.SDK_INT < 21)
                setupColorAnimator(animator); 
              if (AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.access$000(this.mAnimatedVectorState) == null) {
                AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.access$002(this.mAnimatedVectorState, new ArrayList());
                this.mAnimatedVectorState.mTargetNameMap = new ArrayMap();
              } 
              AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.access$000(this.mAnimatedVectorState).add(animator);
              this.mAnimatedVectorState.mTargetNameMap.put(animator, str1);
            } else {
              typedArray1.recycle();
              throw new IllegalStateException("Context can't be null when inflating animators");
            }  
          typedArray1.recycle();
        } 
      } 
      i = paramXmlPullParser.next();
    } 
    this.mAnimatedVectorState.setupAnimatorSet();
  }
  
  public final boolean isAutoMirrored() {
    return (this.mDelegateDrawable != null) ? DrawableCompat.isAutoMirrored(this.mDelegateDrawable) : this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
  }
  
  public final boolean isRunning() {
    return (this.mDelegateDrawable != null) ? ((AnimatedVectorDrawable)this.mDelegateDrawable).isRunning() : this.mAnimatedVectorState.mAnimatorSet.isRunning();
  }
  
  public final boolean isStateful() {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.isStateful() : this.mAnimatedVectorState.mVectorDrawable.isStateful();
  }
  
  public final Drawable mutate() {
    if (this.mDelegateDrawable != null)
      this.mDelegateDrawable.mutate(); 
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect) {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.setBounds(paramRect);
      return;
    } 
    this.mAnimatedVectorState.mVectorDrawable.setBounds(paramRect);
  }
  
  protected final boolean onLevelChange(int paramInt) {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.setLevel(paramInt) : this.mAnimatedVectorState.mVectorDrawable.setLevel(paramInt);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfint) {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.setState(paramArrayOfint) : this.mAnimatedVectorState.mVectorDrawable.setState(paramArrayOfint);
  }
  
  public final void setAlpha(int paramInt) {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.setAlpha(paramInt);
      return;
    } 
    this.mAnimatedVectorState.mVectorDrawable.setAlpha(paramInt);
  }
  
  public final void setAutoMirrored(boolean paramBoolean) {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.setAutoMirrored(this.mDelegateDrawable, paramBoolean);
      return;
    } 
    this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(paramBoolean);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.setColorFilter(paramColorFilter);
      return;
    } 
    this.mAnimatedVectorState.mVectorDrawable.setColorFilter(paramColorFilter);
  }
  
  public final void setTint(int paramInt) {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.setTint(this.mDelegateDrawable, paramInt);
      return;
    } 
    this.mAnimatedVectorState.mVectorDrawable.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList) {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.setTintList(this.mDelegateDrawable, paramColorStateList);
      return;
    } 
    this.mAnimatedVectorState.mVectorDrawable.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode) {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.setTintMode(this.mDelegateDrawable, paramMode);
      return;
    } 
    this.mAnimatedVectorState.mVectorDrawable.setTintMode(paramMode);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.setVisible(paramBoolean1, paramBoolean2); 
    this.mAnimatedVectorState.mVectorDrawable.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void start() {
    if (this.mDelegateDrawable != null) {
      ((AnimatedVectorDrawable)this.mDelegateDrawable).start();
      return;
    } 
    if (this.mAnimatedVectorState.mAnimatorSet.isStarted())
      return; 
    this.mAnimatedVectorState.mAnimatorSet.start();
    invalidateSelf();
  }
  
  public final void stop() {
    if (this.mDelegateDrawable != null) {
      ((AnimatedVectorDrawable)this.mDelegateDrawable).stop();
      return;
    } 
    this.mAnimatedVectorState.mAnimatorSet.end();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\graphics\drawable\AnimatedVectorDrawableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */