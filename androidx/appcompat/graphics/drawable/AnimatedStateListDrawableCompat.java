package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedStateListDrawableCompat extends StateListDrawable implements TintAwareDrawable {
  private static final String a = AnimatedStateListDrawableCompat.class.getSimpleName();
  
  private AnimatedStateListState b;
  
  private Transition c;
  
  private int d = -1;
  
  private int e = -1;
  
  private boolean f;
  
  public AnimatedStateListDrawableCompat() {
    this((AnimatedStateListState)null, (Resources)null);
  }
  
  AnimatedStateListDrawableCompat(AnimatedStateListState paramAnimatedStateListState, Resources paramResources) {
    super((StateListDrawable.StateListState)null);
    a(new AnimatedStateListState(paramAnimatedStateListState, this, paramResources));
    onStateChange(getState());
    jumpToCurrentState();
  }
  
  private void a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    int i = paramXmlPullParser.getDepth() + 1;
    while (true) {
      int j = paramXmlPullParser.next();
      if (j != 1) {
        int k = paramXmlPullParser.getDepth();
        if (k >= i || j != 3) {
          if (j != 2 || k > i)
            continue; 
          if (paramXmlPullParser.getName().equals("item")) {
            c(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
            continue;
          } 
          if (paramXmlPullParser.getName().equals("transition"))
            b(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme); 
          continue;
        } 
      } 
      break;
    } 
  }
  
  private void a(TypedArray paramTypedArray) {
    AnimatedStateListState animatedStateListState = this.b;
    if (Build.VERSION.SDK_INT >= 21)
      animatedStateListState.f |= paramTypedArray.getChangingConfigurations(); 
    animatedStateListState.setVariablePadding(paramTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, animatedStateListState.k));
    animatedStateListState.setConstantSize(paramTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, animatedStateListState.n));
    animatedStateListState.setEnterFadeDuration(paramTypedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, animatedStateListState.C));
    animatedStateListState.setExitFadeDuration(paramTypedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, animatedStateListState.D));
    setDither(paramTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, animatedStateListState.z));
  }
  
  private int b(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    // Byte code:
    //   0: aload_2
    //   1: aload #5
    //   3: aload #4
    //   5: getstatic androidx/appcompat/resources/R$styleable.AnimatedStateListDrawableTransition : [I
    //   8: invokestatic obtainAttributes : (Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   11: astore #10
    //   13: aload #10
    //   15: getstatic androidx/appcompat/resources/R$styleable.AnimatedStateListDrawableTransition_android_fromId : I
    //   18: iconst_m1
    //   19: invokevirtual getResourceId : (II)I
    //   22: istore #6
    //   24: aload #10
    //   26: getstatic androidx/appcompat/resources/R$styleable.AnimatedStateListDrawableTransition_android_toId : I
    //   29: iconst_m1
    //   30: invokevirtual getResourceId : (II)I
    //   33: istore #7
    //   35: aload #10
    //   37: getstatic androidx/appcompat/resources/R$styleable.AnimatedStateListDrawableTransition_android_drawable : I
    //   40: iconst_m1
    //   41: invokevirtual getResourceId : (II)I
    //   44: istore #8
    //   46: iload #8
    //   48: ifle -> 65
    //   51: invokestatic get : ()Landroidx/appcompat/widget/ResourceManagerInternal;
    //   54: aload_1
    //   55: iload #8
    //   57: invokevirtual getDrawable : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   60: astore #11
    //   62: goto -> 68
    //   65: aconst_null
    //   66: astore #11
    //   68: aload #10
    //   70: getstatic androidx/appcompat/resources/R$styleable.AnimatedStateListDrawableTransition_android_reversible : I
    //   73: iconst_0
    //   74: invokevirtual getBoolean : (IZ)Z
    //   77: istore #9
    //   79: aload #10
    //   81: invokevirtual recycle : ()V
    //   84: aload #11
    //   86: astore #10
    //   88: aload #11
    //   90: ifnonnull -> 217
    //   93: aload_3
    //   94: invokeinterface next : ()I
    //   99: istore #8
    //   101: iload #8
    //   103: iconst_4
    //   104: if_icmpne -> 110
    //   107: goto -> 93
    //   110: iload #8
    //   112: iconst_2
    //   113: if_icmpne -> 179
    //   116: aload_3
    //   117: invokeinterface getName : ()Ljava/lang/String;
    //   122: ldc 'animated-vector'
    //   124: invokevirtual equals : (Ljava/lang/Object;)Z
    //   127: ifeq -> 145
    //   130: aload_1
    //   131: aload_2
    //   132: aload_3
    //   133: aload #4
    //   135: aload #5
    //   137: invokestatic createFromXmlInner : (Landroid/content/Context;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;
    //   140: astore #10
    //   142: goto -> 217
    //   145: getstatic android/os/Build$VERSION.SDK_INT : I
    //   148: bipush #21
    //   150: if_icmplt -> 167
    //   153: aload_2
    //   154: aload_3
    //   155: aload #4
    //   157: aload #5
    //   159: invokestatic createFromXmlInner : (Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;
    //   162: astore #10
    //   164: goto -> 217
    //   167: aload_2
    //   168: aload_3
    //   169: aload #4
    //   171: invokestatic createFromXmlInner : (Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)Landroid/graphics/drawable/Drawable;
    //   174: astore #10
    //   176: goto -> 217
    //   179: new java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial <init> : ()V
    //   186: astore_1
    //   187: aload_1
    //   188: aload_3
    //   189: invokeinterface getPositionDescription : ()Ljava/lang/String;
    //   194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_1
    //   199: ldc ': <transition> tag requires a 'drawable' attribute or child tag defining a drawable'
    //   201: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: new org/xmlpull/v1/XmlPullParserException
    //   208: dup
    //   209: aload_1
    //   210: invokevirtual toString : ()Ljava/lang/String;
    //   213: invokespecial <init> : (Ljava/lang/String;)V
    //   216: athrow
    //   217: aload #10
    //   219: ifnull -> 289
    //   222: iload #6
    //   224: iconst_m1
    //   225: if_icmpeq -> 250
    //   228: iload #7
    //   230: iconst_m1
    //   231: if_icmpeq -> 250
    //   234: aload_0
    //   235: getfield b : Landroidx/appcompat/graphics/drawable/AnimatedStateListDrawableCompat$AnimatedStateListState;
    //   238: iload #6
    //   240: iload #7
    //   242: aload #10
    //   244: iload #9
    //   246: invokevirtual a : (IILandroid/graphics/drawable/Drawable;Z)I
    //   249: ireturn
    //   250: new java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial <init> : ()V
    //   257: astore_1
    //   258: aload_1
    //   259: aload_3
    //   260: invokeinterface getPositionDescription : ()Ljava/lang/String;
    //   265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_1
    //   270: ldc_w ': <transition> tag requires 'fromId' & 'toId' attributes'
    //   273: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: new org/xmlpull/v1/XmlPullParserException
    //   280: dup
    //   281: aload_1
    //   282: invokevirtual toString : ()Ljava/lang/String;
    //   285: invokespecial <init> : (Ljava/lang/String;)V
    //   288: athrow
    //   289: new java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial <init> : ()V
    //   296: astore_1
    //   297: aload_1
    //   298: aload_3
    //   299: invokeinterface getPositionDescription : ()Ljava/lang/String;
    //   304: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_1
    //   309: ldc ': <transition> tag requires a 'drawable' attribute or child tag defining a drawable'
    //   311: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: new org/xmlpull/v1/XmlPullParserException
    //   318: dup
    //   319: aload_1
    //   320: invokevirtual toString : ()Ljava/lang/String;
    //   323: invokespecial <init> : (Ljava/lang/String;)V
    //   326: athrow
  }
  
  private boolean b(int paramInt) {
    int i;
    Transition transition = this.c;
    if (transition != null) {
      if (paramInt == this.d)
        return true; 
      if (paramInt == this.e && transition.canReverse()) {
        transition.reverse();
        this.d = this.e;
        this.e = paramInt;
        return true;
      } 
      i = this.d;
      transition.stop();
    } else {
      i = d();
    } 
    this.c = null;
    this.e = -1;
    this.d = -1;
    AnimatedStateListState animatedStateListState = this.b;
    int j = animatedStateListState.a(i);
    int k = animatedStateListState.a(paramInt);
    if (k != 0) {
      AnimatableTransition animatableTransition;
      if (j == 0)
        return false; 
      int m = animatedStateListState.a(j, k);
      if (m < 0)
        return false; 
      boolean bool = animatedStateListState.c(j, k);
      a(m);
      Drawable drawable = getCurrent();
      if (drawable instanceof AnimationDrawable) {
        boolean bool1 = animatedStateListState.b(j, k);
        AnimationDrawableTransition animationDrawableTransition = new AnimationDrawableTransition((AnimationDrawable)drawable, bool1, bool);
      } else if (drawable instanceof AnimatedVectorDrawableCompat) {
        AnimatedVectorDrawableTransition animatedVectorDrawableTransition = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat)drawable);
      } else {
        if (drawable instanceof Animatable) {
          animatableTransition = new AnimatableTransition((Animatable)drawable);
          animatableTransition.start();
          this.c = animatableTransition;
          this.e = i;
          this.d = paramInt;
          return true;
        } 
        return false;
      } 
      animatableTransition.start();
      this.c = animatableTransition;
      this.e = i;
      this.d = paramInt;
      return true;
    } 
    return false;
  }
  
  private int c(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    Context context;
    TypedArray typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableItem);
    int i = typedArray.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
    int j = typedArray.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
    if (j > 0) {
      context = (Context)ResourceManagerInternal.get().getDrawable(paramContext, j);
    } else {
      context = null;
    } 
    typedArray.recycle();
    int[] arrayOfInt = a(paramAttributeSet);
    paramContext = context;
    if (context == null)
      while (true) {
        j = paramXmlPullParser.next();
        if (j == 4)
          continue; 
        if (j == 2) {
          if (paramXmlPullParser.getName().equals("vector")) {
            VectorDrawableCompat vectorDrawableCompat = VectorDrawableCompat.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
            break;
          } 
          if (Build.VERSION.SDK_INT >= 21) {
            Drawable drawable = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
          } else {
            Drawable drawable = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
          } 
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append(paramXmlPullParser.getPositionDescription());
          stringBuilder.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
          throw new XmlPullParserException(stringBuilder.toString());
        } 
        if (stringBuilder != null)
          return this.b.a(arrayOfInt, (Drawable)stringBuilder, i); 
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramXmlPullParser.getPositionDescription());
        stringBuilder.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        throw new XmlPullParserException(stringBuilder.toString());
      }  
    if (stringBuilder != null)
      return this.b.a(arrayOfInt, (Drawable)stringBuilder, i); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramXmlPullParser.getPositionDescription());
    stringBuilder.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    throw new XmlPullParserException(stringBuilder.toString());
  }
  
  public static AnimatedStateListDrawableCompat create(Context paramContext, int paramInt, Resources.Theme paramTheme) {
    try {
      Resources resources = paramContext.getResources();
      XmlResourceParser xmlResourceParser = resources.getXml(paramInt);
      AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
      while (true) {
        paramInt = xmlResourceParser.next();
        if (paramInt != 2 && paramInt != 1)
          continue; 
        break;
      } 
      if (paramInt == 2)
        return createFromXmlInner(paramContext, resources, (XmlPullParser)xmlResourceParser, attributeSet, paramTheme); 
      throw new XmlPullParserException("No start tag found");
    } catch (XmlPullParserException xmlPullParserException) {
      Log.e(a, "parser error", (Throwable)xmlPullParserException);
    } catch (IOException iOException) {
      Log.e(a, "parser error", iOException);
    } 
    return null;
  }
  
  public static AnimatedStateListDrawableCompat createFromXmlInner(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws IOException, XmlPullParserException {
    AnimatedStateListDrawableCompat animatedStateListDrawableCompat;
    String str = paramXmlPullParser.getName();
    if (str.equals("animated-selector")) {
      animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
      animatedStateListDrawableCompat.inflate(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return animatedStateListDrawableCompat;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramXmlPullParser.getPositionDescription());
    stringBuilder.append(": invalid animated-selector tag ");
    stringBuilder.append((String)animatedStateListDrawableCompat);
    throw new XmlPullParserException(stringBuilder.toString());
  }
  
  private void e() {
    onStateChange(getState());
  }
  
  AnimatedStateListState a() {
    return new AnimatedStateListState(this.b, this, null);
  }
  
  void a(DrawableContainer.DrawableContainerState paramDrawableContainerState) {
    super.a(paramDrawableContainerState);
    if (paramDrawableContainerState instanceof AnimatedStateListState)
      this.b = (AnimatedStateListState)paramDrawableContainerState; 
  }
  
  public void addState(int[] paramArrayOfint, Drawable paramDrawable, int paramInt) {
    if (paramDrawable != null) {
      this.b.a(paramArrayOfint, paramDrawable, paramInt);
      onStateChange(getState());
      return;
    } 
    throw new IllegalArgumentException("Drawable must not be null");
  }
  
  public <T extends Drawable & Animatable> void addTransition(int paramInt1, int paramInt2, T paramT, boolean paramBoolean) {
    if (paramT != null) {
      this.b.a(paramInt1, paramInt2, (Drawable)paramT, paramBoolean);
      return;
    } 
    throw new IllegalArgumentException("Transition drawable must not be null");
  }
  
  public void inflate(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    TypedArray typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableCompat);
    setVisible(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
    a(typedArray);
    a(paramResources);
    typedArray.recycle();
    a(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    e();
  }
  
  public boolean isStateful() {
    return true;
  }
  
  public void jumpToCurrentState() {
    super.jumpToCurrentState();
    Transition transition = this.c;
    if (transition != null) {
      transition.stop();
      this.c = null;
      a(this.d);
      this.d = -1;
      this.e = -1;
    } 
  }
  
  public Drawable mutate() {
    if (!this.f && super.mutate() == this) {
      this.b.a();
      this.f = true;
    } 
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfint) {
    boolean bool1;
    int i = this.b.a(paramArrayOfint);
    if (i != d() && (b(i) || a(i))) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Drawable drawable = getCurrent();
    boolean bool2 = bool1;
    if (drawable != null)
      bool2 = bool1 | drawable.setState(paramArrayOfint); 
    return bool2;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (this.c != null && (bool || paramBoolean2)) {
      if (paramBoolean1) {
        this.c.start();
        return bool;
      } 
      jumpToCurrentState();
    } 
    return bool;
  }
  
  static class AnimatableTransition extends Transition {
    private final Animatable a;
    
    AnimatableTransition(Animatable param1Animatable) {
      this.a = param1Animatable;
    }
    
    public void start() {
      this.a.start();
    }
    
    public void stop() {
      this.a.stop();
    }
  }
  
  static class AnimatedStateListState extends StateListDrawable.StateListState {
    LongSparseArray<Long> a;
    
    SparseArrayCompat<Integer> b;
    
    AnimatedStateListState(AnimatedStateListState param1AnimatedStateListState, AnimatedStateListDrawableCompat param1AnimatedStateListDrawableCompat, Resources param1Resources) {
      super(param1AnimatedStateListState, param1AnimatedStateListDrawableCompat, param1Resources);
      if (param1AnimatedStateListState != null) {
        this.a = param1AnimatedStateListState.a;
        this.b = param1AnimatedStateListState.b;
        return;
      } 
      this.a = new LongSparseArray();
      this.b = new SparseArrayCompat();
    }
    
    private static long e(int param1Int1, int param1Int2) {
      long l = param1Int1;
      return param1Int2 | l << 32L;
    }
    
    int a(int param1Int) {
      return (param1Int < 0) ? 0 : ((Integer)this.b.get(param1Int, Integer.valueOf(0))).intValue();
    }
    
    int a(int param1Int1, int param1Int2) {
      long l = e(param1Int1, param1Int2);
      return (int)((Long)this.a.get(l, Long.valueOf(-1L))).longValue();
    }
    
    int a(int param1Int1, int param1Int2, Drawable param1Drawable, boolean param1Boolean) {
      long l1;
      int i = addChild(param1Drawable);
      long l2 = e(param1Int1, param1Int2);
      if (param1Boolean) {
        l1 = 8589934592L;
      } else {
        l1 = 0L;
      } 
      LongSparseArray<Long> longSparseArray = this.a;
      long l3 = i;
      longSparseArray.append(l2, Long.valueOf(l3 | l1));
      if (param1Boolean) {
        l2 = e(param1Int2, param1Int1);
        this.a.append(l2, Long.valueOf(0x100000000L | l3 | l1));
      } 
      return i;
    }
    
    int a(int[] param1ArrayOfint) {
      int i = b(param1ArrayOfint);
      return (i >= 0) ? i : b(StateSet.WILD_CARD);
    }
    
    int a(int[] param1ArrayOfint, Drawable param1Drawable, int param1Int) {
      int i = a(param1ArrayOfint, param1Drawable);
      this.b.put(i, Integer.valueOf(param1Int));
      return i;
    }
    
    void a() {
      this.a = this.a.clone();
      this.b = this.b.clone();
    }
    
    boolean b(int param1Int1, int param1Int2) {
      long l = e(param1Int1, param1Int2);
      return ((((Long)this.a.get(l, Long.valueOf(-1L))).longValue() & 0x100000000L) != 0L);
    }
    
    boolean c(int param1Int1, int param1Int2) {
      long l = e(param1Int1, param1Int2);
      return ((((Long)this.a.get(l, Long.valueOf(-1L))).longValue() & 0x200000000L) != 0L);
    }
    
    public Drawable newDrawable() {
      return new AnimatedStateListDrawableCompat(this, null);
    }
    
    public Drawable newDrawable(Resources param1Resources) {
      return new AnimatedStateListDrawableCompat(this, param1Resources);
    }
  }
  
  static class AnimatedVectorDrawableTransition extends Transition {
    private final AnimatedVectorDrawableCompat a;
    
    AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat param1AnimatedVectorDrawableCompat) {
      this.a = param1AnimatedVectorDrawableCompat;
    }
    
    public void start() {
      this.a.start();
    }
    
    public void stop() {
      this.a.stop();
    }
  }
  
  static class AnimationDrawableTransition extends Transition {
    private final ObjectAnimator a;
    
    private final boolean b;
    
    AnimationDrawableTransition(AnimationDrawable param1AnimationDrawable, boolean param1Boolean1, boolean param1Boolean2) {
      boolean bool;
      int i = param1AnimationDrawable.getNumberOfFrames();
      if (param1Boolean1) {
        bool = i - 1;
      } else {
        bool = false;
      } 
      if (param1Boolean1) {
        i = 0;
      } else {
        i--;
      } 
      AnimatedStateListDrawableCompat.FrameInterpolator frameInterpolator = new AnimatedStateListDrawableCompat.FrameInterpolator(param1AnimationDrawable, param1Boolean1);
      ObjectAnimator objectAnimator = ObjectAnimator.ofInt(param1AnimationDrawable, "currentIndex", new int[] { bool, i });
      if (Build.VERSION.SDK_INT >= 18)
        objectAnimator.setAutoCancel(true); 
      objectAnimator.setDuration(frameInterpolator.a());
      objectAnimator.setInterpolator(frameInterpolator);
      this.b = param1Boolean2;
      this.a = objectAnimator;
    }
    
    public boolean canReverse() {
      return this.b;
    }
    
    public void reverse() {
      this.a.reverse();
    }
    
    public void start() {
      this.a.start();
    }
    
    public void stop() {
      this.a.cancel();
    }
  }
  
  static class FrameInterpolator implements TimeInterpolator {
    private int[] a;
    
    private int b;
    
    private int c;
    
    FrameInterpolator(AnimationDrawable param1AnimationDrawable, boolean param1Boolean) {
      a(param1AnimationDrawable, param1Boolean);
    }
    
    int a() {
      return this.c;
    }
    
    int a(AnimationDrawable param1AnimationDrawable, boolean param1Boolean) {
      int k = param1AnimationDrawable.getNumberOfFrames();
      this.b = k;
      int[] arrayOfInt = this.a;
      if (arrayOfInt == null || arrayOfInt.length < k)
        this.a = new int[k]; 
      arrayOfInt = this.a;
      int i = 0;
      int j = 0;
      while (i < k) {
        if (param1Boolean) {
          m = k - i - 1;
        } else {
          m = i;
        } 
        int m = param1AnimationDrawable.getDuration(m);
        arrayOfInt[i] = m;
        j += m;
        i++;
      } 
      this.c = j;
      return j;
    }
    
    public float getInterpolation(float param1Float) {
      int j = (int)(param1Float * this.c + 0.5F);
      int k = this.b;
      int[] arrayOfInt = this.a;
      int i;
      for (i = 0; i < k && j >= arrayOfInt[i]; i++)
        j -= arrayOfInt[i]; 
      if (i < k) {
        param1Float = j / this.c;
      } else {
        param1Float = 0.0F;
      } 
      return i / k + param1Float;
    }
  }
  
  static abstract class Transition {
    private Transition() {}
    
    public boolean canReverse() {
      return false;
    }
    
    public void reverse() {}
    
    public abstract void start();
    
    public abstract void stop();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\graphics\drawable\AnimatedStateListDrawableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */