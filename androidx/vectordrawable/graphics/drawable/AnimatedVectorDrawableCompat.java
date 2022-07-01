package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {
  AnimatedVectorDrawableDelegateState a;
  
  ArrayList<Animatable2Compat.AnimationCallback> b = null;
  
  final Drawable.Callback c = new Drawable.Callback(this) {
      public void invalidateDrawable(Drawable param1Drawable) {
        this.a.invalidateSelf();
      }
      
      public void scheduleDrawable(Drawable param1Drawable, Runnable param1Runnable, long param1Long) {
        this.a.scheduleSelf(param1Runnable, param1Long);
      }
      
      public void unscheduleDrawable(Drawable param1Drawable, Runnable param1Runnable) {
        this.a.unscheduleSelf(param1Runnable);
      }
    };
  
  private AnimatedVectorDrawableCompatState e;
  
  private Context f;
  
  private ArgbEvaluator g = null;
  
  private Animator.AnimatorListener h = null;
  
  AnimatedVectorDrawableCompat() {
    this((Context)null, (AnimatedVectorDrawableCompatState)null, (Resources)null);
  }
  
  private AnimatedVectorDrawableCompat(Context paramContext) {
    this(paramContext, (AnimatedVectorDrawableCompatState)null, (Resources)null);
  }
  
  private AnimatedVectorDrawableCompat(Context paramContext, AnimatedVectorDrawableCompatState paramAnimatedVectorDrawableCompatState, Resources paramResources) {
    this.f = paramContext;
    if (paramAnimatedVectorDrawableCompatState != null) {
      this.e = paramAnimatedVectorDrawableCompatState;
      return;
    } 
    this.e = new AnimatedVectorDrawableCompatState(paramContext, paramAnimatedVectorDrawableCompatState, this.c, paramResources);
  }
  
  private void a() {
    if (this.h != null) {
      this.e.c.removeListener(this.h);
      this.h = null;
    } 
  }
  
  private void a(Animator paramAnimator) {
    if (paramAnimator instanceof AnimatorSet) {
      ArrayList<Animator> arrayList = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (arrayList != null)
        for (int i = 0; i < arrayList.size(); i++)
          a(arrayList.get(i));  
    } 
    if (paramAnimator instanceof ObjectAnimator) {
      ObjectAnimator objectAnimator = (ObjectAnimator)paramAnimator;
      String str = objectAnimator.getPropertyName();
      if ("fillColor".equals(str) || "strokeColor".equals(str)) {
        if (this.g == null)
          this.g = new ArgbEvaluator(); 
        objectAnimator.setEvaluator((TypeEvaluator)this.g);
      } 
    } 
  }
  
  private void a(String paramString, Animator paramAnimator) {
    paramAnimator.setTarget(this.e.b.a(paramString));
    if (Build.VERSION.SDK_INT < 21)
      a(paramAnimator); 
    if (this.e.d == null) {
      this.e.d = new ArrayList<Animator>();
      this.e.e = new ArrayMap();
    } 
    this.e.d.add(paramAnimator);
    this.e.e.put(paramAnimator, paramString);
  }
  
  private static boolean a(AnimatedVectorDrawable paramAnimatedVectorDrawable, Animatable2Compat.AnimationCallback paramAnimationCallback) {
    return paramAnimatedVectorDrawable.unregisterAnimationCallback(paramAnimationCallback.a());
  }
  
  private static void b(AnimatedVectorDrawable paramAnimatedVectorDrawable, Animatable2Compat.AnimationCallback paramAnimationCallback) {
    paramAnimatedVectorDrawable.registerAnimationCallback(paramAnimationCallback.a());
  }
  
  public static void clearAnimationCallbacks(Drawable paramDrawable) {
    if (!(paramDrawable instanceof android.graphics.drawable.Animatable))
      return; 
    if (Build.VERSION.SDK_INT >= 24) {
      ((AnimatedVectorDrawable)paramDrawable).clearAnimationCallbacks();
      return;
    } 
    ((AnimatedVectorDrawableCompat)paramDrawable).clearAnimationCallbacks();
  }
  
  public static AnimatedVectorDrawableCompat create(Context paramContext, int paramInt) {
    if (Build.VERSION.SDK_INT >= 24) {
      AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(paramContext);
      animatedVectorDrawableCompat.d = ResourcesCompat.getDrawable(paramContext.getResources(), paramInt, paramContext.getTheme());
      animatedVectorDrawableCompat.d.setCallback(animatedVectorDrawableCompat.c);
      animatedVectorDrawableCompat.a = new AnimatedVectorDrawableDelegateState(animatedVectorDrawableCompat.d.getConstantState());
      return animatedVectorDrawableCompat;
    } 
    Resources resources = paramContext.getResources();
    try {
      XmlResourceParser xmlResourceParser = resources.getXml(paramInt);
      AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
      while (true) {
        paramInt = xmlResourceParser.next();
        if (paramInt != 2 && paramInt != 1)
          continue; 
        break;
      } 
      if (paramInt == 2)
        return createFromXmlInner(paramContext, paramContext.getResources(), (XmlPullParser)xmlResourceParser, attributeSet, paramContext.getTheme()); 
      throw new XmlPullParserException("No start tag found");
    } catch (XmlPullParserException xmlPullParserException) {
      Log.e("AnimatedVDCompat", "parser error", (Throwable)xmlPullParserException);
    } catch (IOException iOException) {
      Log.e("AnimatedVDCompat", "parser error", iOException);
    } 
    return null;
  }
  
  public static AnimatedVectorDrawableCompat createFromXmlInner(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(paramContext);
    animatedVectorDrawableCompat.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return animatedVectorDrawableCompat;
  }
  
  public static void registerAnimationCallback(Drawable paramDrawable, Animatable2Compat.AnimationCallback paramAnimationCallback) {
    if (paramDrawable != null) {
      if (paramAnimationCallback == null)
        return; 
      if (!(paramDrawable instanceof android.graphics.drawable.Animatable))
        return; 
      if (Build.VERSION.SDK_INT >= 24) {
        b((AnimatedVectorDrawable)paramDrawable, paramAnimationCallback);
        return;
      } 
      ((AnimatedVectorDrawableCompat)paramDrawable).registerAnimationCallback(paramAnimationCallback);
    } 
  }
  
  public static boolean unregisterAnimationCallback(Drawable paramDrawable, Animatable2Compat.AnimationCallback paramAnimationCallback) {
    return (paramDrawable != null) ? ((paramAnimationCallback == null) ? false : (!(paramDrawable instanceof android.graphics.drawable.Animatable) ? false : ((Build.VERSION.SDK_INT >= 24) ? a((AnimatedVectorDrawable)paramDrawable, paramAnimationCallback) : ((AnimatedVectorDrawableCompat)paramDrawable).unregisterAnimationCallback(paramAnimationCallback)))) : false;
  }
  
  public void applyTheme(Resources.Theme paramTheme) {
    if (this.d != null)
      DrawableCompat.applyTheme(this.d, paramTheme); 
  }
  
  public boolean canApplyTheme() {
    return (this.d != null) ? DrawableCompat.canApplyTheme(this.d) : false;
  }
  
  public void clearAnimationCallbacks() {
    if (this.d != null) {
      ((AnimatedVectorDrawable)this.d).clearAnimationCallbacks();
      return;
    } 
    a();
    ArrayList<Animatable2Compat.AnimationCallback> arrayList = this.b;
    if (arrayList == null)
      return; 
    arrayList.clear();
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.d != null) {
      this.d.draw(paramCanvas);
      return;
    } 
    this.e.b.draw(paramCanvas);
    if (this.e.c.isStarted())
      invalidateSelf(); 
  }
  
  public int getAlpha() {
    return (this.d != null) ? DrawableCompat.getAlpha(this.d) : this.e.b.getAlpha();
  }
  
  public int getChangingConfigurations() {
    return (this.d != null) ? this.d.getChangingConfigurations() : (super.getChangingConfigurations() | this.e.a);
  }
  
  public ColorFilter getColorFilter() {
    return (this.d != null) ? DrawableCompat.getColorFilter(this.d) : this.e.b.getColorFilter();
  }
  
  public Drawable.ConstantState getConstantState() {
    return (this.d != null && Build.VERSION.SDK_INT >= 24) ? new AnimatedVectorDrawableDelegateState(this.d.getConstantState()) : null;
  }
  
  public int getIntrinsicHeight() {
    return (this.d != null) ? this.d.getIntrinsicHeight() : this.e.b.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth() {
    return (this.d != null) ? this.d.getIntrinsicWidth() : this.e.b.getIntrinsicWidth();
  }
  
  public int getOpacity() {
    return (this.d != null) ? this.d.getOpacity() : this.e.b.getOpacity();
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet) throws XmlPullParserException, IOException {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, (Resources.Theme)null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    if (this.d != null) {
      DrawableCompat.inflate(this.d, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    } 
    int i = paramXmlPullParser.getEventType();
    int j = paramXmlPullParser.getDepth();
    while (i != 1 && (paramXmlPullParser.getDepth() >= j + 1 || i != 3)) {
      if (i == 2) {
        TypedArray typedArray;
        String str = paramXmlPullParser.getName();
        if ("animated-vector".equals(str)) {
          typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.e);
          i = typedArray.getResourceId(0, 0);
          if (i != 0) {
            VectorDrawableCompat vectorDrawableCompat = VectorDrawableCompat.create(paramResources, i, paramTheme);
            vectorDrawableCompat.a(false);
            vectorDrawableCompat.setCallback(this.c);
            if (this.e.b != null)
              this.e.b.setCallback(null); 
            this.e.b = vectorDrawableCompat;
          } 
          typedArray.recycle();
        } else if ("target".equals(typedArray)) {
          typedArray = paramResources.obtainAttributes(paramAttributeSet, AndroidResources.f);
          String str1 = typedArray.getString(0);
          i = typedArray.getResourceId(1, 0);
          if (i != 0) {
            Context context = this.f;
            if (context != null) {
              a(str1, AnimatorInflaterCompat.loadAnimator(context, i));
            } else {
              typedArray.recycle();
              throw new IllegalStateException("Context can't be null when inflating animators");
            } 
          } 
          typedArray.recycle();
        } 
      } 
      i = paramXmlPullParser.next();
    } 
    this.e.setupAnimatorSet();
  }
  
  public boolean isAutoMirrored() {
    return (this.d != null) ? DrawableCompat.isAutoMirrored(this.d) : this.e.b.isAutoMirrored();
  }
  
  public boolean isRunning() {
    return (this.d != null) ? ((AnimatedVectorDrawable)this.d).isRunning() : this.e.c.isRunning();
  }
  
  public boolean isStateful() {
    return (this.d != null) ? this.d.isStateful() : this.e.b.isStateful();
  }
  
  public Drawable mutate() {
    if (this.d != null)
      this.d.mutate(); 
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect) {
    if (this.d != null) {
      this.d.setBounds(paramRect);
      return;
    } 
    this.e.b.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt) {
    return (this.d != null) ? this.d.setLevel(paramInt) : this.e.b.setLevel(paramInt);
  }
  
  protected boolean onStateChange(int[] paramArrayOfint) {
    return (this.d != null) ? this.d.setState(paramArrayOfint) : this.e.b.setState(paramArrayOfint);
  }
  
  public void registerAnimationCallback(Animatable2Compat.AnimationCallback paramAnimationCallback) {
    if (this.d != null) {
      b((AnimatedVectorDrawable)this.d, paramAnimationCallback);
      return;
    } 
    if (paramAnimationCallback == null)
      return; 
    if (this.b == null)
      this.b = new ArrayList<Animatable2Compat.AnimationCallback>(); 
    if (this.b.contains(paramAnimationCallback))
      return; 
    this.b.add(paramAnimationCallback);
    if (this.h == null)
      this.h = (Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            ArrayList<Animatable2Compat.AnimationCallback> arrayList = new ArrayList<Animatable2Compat.AnimationCallback>(this.a.b);
            int j = arrayList.size();
            for (int i = 0; i < j; i++)
              ((Animatable2Compat.AnimationCallback)arrayList.get(i)).onAnimationEnd(this.a); 
          }
          
          public void onAnimationStart(Animator param1Animator) {
            ArrayList<Animatable2Compat.AnimationCallback> arrayList = new ArrayList<Animatable2Compat.AnimationCallback>(this.a.b);
            int j = arrayList.size();
            for (int i = 0; i < j; i++)
              ((Animatable2Compat.AnimationCallback)arrayList.get(i)).onAnimationStart(this.a); 
          }
        }; 
    this.e.c.addListener(this.h);
  }
  
  public void setAlpha(int paramInt) {
    if (this.d != null) {
      this.d.setAlpha(paramInt);
      return;
    } 
    this.e.b.setAlpha(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean) {
    if (this.d != null) {
      DrawableCompat.setAutoMirrored(this.d, paramBoolean);
      return;
    } 
    this.e.b.setAutoMirrored(paramBoolean);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    if (this.d != null) {
      this.d.setColorFilter(paramColorFilter);
      return;
    } 
    this.e.b.setColorFilter(paramColorFilter);
  }
  
  public void setTint(int paramInt) {
    if (this.d != null) {
      DrawableCompat.setTint(this.d, paramInt);
      return;
    } 
    this.e.b.setTint(paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList) {
    if (this.d != null) {
      DrawableCompat.setTintList(this.d, paramColorStateList);
      return;
    } 
    this.e.b.setTintList(paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    if (this.d != null) {
      DrawableCompat.setTintMode(this.d, paramMode);
      return;
    } 
    this.e.b.setTintMode(paramMode);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    if (this.d != null)
      return this.d.setVisible(paramBoolean1, paramBoolean2); 
    this.e.b.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void start() {
    if (this.d != null) {
      ((AnimatedVectorDrawable)this.d).start();
      return;
    } 
    if (this.e.c.isStarted())
      return; 
    this.e.c.start();
    invalidateSelf();
  }
  
  public void stop() {
    if (this.d != null) {
      ((AnimatedVectorDrawable)this.d).stop();
      return;
    } 
    this.e.c.end();
  }
  
  public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback paramAnimationCallback) {
    if (this.d != null)
      a((AnimatedVectorDrawable)this.d, paramAnimationCallback); 
    ArrayList<Animatable2Compat.AnimationCallback> arrayList = this.b;
    if (arrayList == null || paramAnimationCallback == null)
      return false; 
    boolean bool = arrayList.remove(paramAnimationCallback);
    if (this.b.size() == 0)
      a(); 
    return bool;
  }
  
  static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {
    int a;
    
    VectorDrawableCompat b;
    
    AnimatorSet c;
    
    ArrayList<Animator> d;
    
    ArrayMap<Animator, String> e;
    
    public AnimatedVectorDrawableCompatState(Context param1Context, AnimatedVectorDrawableCompatState param1AnimatedVectorDrawableCompatState, Drawable.Callback param1Callback, Resources param1Resources) {
      if (param1AnimatedVectorDrawableCompatState != null) {
        this.a = param1AnimatedVectorDrawableCompatState.a;
        VectorDrawableCompat vectorDrawableCompat = param1AnimatedVectorDrawableCompatState.b;
        int i = 0;
        if (vectorDrawableCompat != null) {
          Drawable.ConstantState constantState = vectorDrawableCompat.getConstantState();
          if (param1Resources != null) {
            this.b = (VectorDrawableCompat)constantState.newDrawable(param1Resources);
          } else {
            this.b = (VectorDrawableCompat)constantState.newDrawable();
          } 
          this.b = (VectorDrawableCompat)this.b.mutate();
          this.b.setCallback(param1Callback);
          this.b.setBounds(param1AnimatedVectorDrawableCompatState.b.getBounds());
          this.b.a(false);
        } 
        ArrayList<Animator> arrayList = param1AnimatedVectorDrawableCompatState.d;
        if (arrayList != null) {
          int j = arrayList.size();
          this.d = new ArrayList<Animator>(j);
          this.e = new ArrayMap(j);
          while (i < j) {
            Animator animator2 = param1AnimatedVectorDrawableCompatState.d.get(i);
            Animator animator1 = animator2.clone();
            String str = (String)param1AnimatedVectorDrawableCompatState.e.get(animator2);
            animator1.setTarget(this.b.a(str));
            this.d.add(animator1);
            this.e.put(animator1, str);
            i++;
          } 
          setupAnimatorSet();
        } 
      } 
    }
    
    public int getChangingConfigurations() {
      return this.a;
    }
    
    public Drawable newDrawable() {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
    
    public Drawable newDrawable(Resources param1Resources) {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
    
    public void setupAnimatorSet() {
      if (this.c == null)
        this.c = new AnimatorSet(); 
      this.c.playTogether(this.d);
    }
  }
  
  static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {
    private final Drawable.ConstantState a;
    
    public AnimatedVectorDrawableDelegateState(Drawable.ConstantState param1ConstantState) {
      this.a = param1ConstantState;
    }
    
    public boolean canApplyTheme() {
      return this.a.canApplyTheme();
    }
    
    public int getChangingConfigurations() {
      return this.a.getChangingConfigurations();
    }
    
    public Drawable newDrawable() {
      AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
      animatedVectorDrawableCompat.d = this.a.newDrawable();
      animatedVectorDrawableCompat.d.setCallback(animatedVectorDrawableCompat.c);
      return animatedVectorDrawableCompat;
    }
    
    public Drawable newDrawable(Resources param1Resources) {
      AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
      animatedVectorDrawableCompat.d = this.a.newDrawable(param1Resources);
      animatedVectorDrawableCompat.d.setCallback(animatedVectorDrawableCompat.c);
      return animatedVectorDrawableCompat;
    }
    
    public Drawable newDrawable(Resources param1Resources, Resources.Theme param1Theme) {
      AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
      animatedVectorDrawableCompat.d = this.a.newDrawable(param1Resources, param1Theme);
      animatedVectorDrawableCompat.d.setCallback(animatedVectorDrawableCompat.c);
      return animatedVectorDrawableCompat;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\vectordrawable\graphics\drawable\AnimatedVectorDrawableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */