package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;

public class ContentFrameLayout extends FrameLayout {
  private TypedValue a;
  
  private TypedValue b;
  
  private TypedValue c;
  
  private TypedValue d;
  
  private TypedValue e;
  
  private TypedValue f;
  
  private final Rect g = new Rect();
  
  private OnAttachListener h;
  
  public ContentFrameLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void dispatchFitSystemWindows(Rect paramRect) {
    fitSystemWindows(paramRect);
  }
  
  public TypedValue getFixedHeightMajor() {
    if (this.e == null)
      this.e = new TypedValue(); 
    return this.e;
  }
  
  public TypedValue getFixedHeightMinor() {
    if (this.f == null)
      this.f = new TypedValue(); 
    return this.f;
  }
  
  public TypedValue getFixedWidthMajor() {
    if (this.c == null)
      this.c = new TypedValue(); 
    return this.c;
  }
  
  public TypedValue getFixedWidthMinor() {
    if (this.d == null)
      this.d = new TypedValue(); 
    return this.d;
  }
  
  public TypedValue getMinWidthMajor() {
    if (this.a == null)
      this.a = new TypedValue(); 
    return this.a;
  }
  
  public TypedValue getMinWidthMinor() {
    if (this.b == null)
      this.b = new TypedValue(); 
    return this.b;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    OnAttachListener onAttachListener = this.h;
    if (onAttachListener != null)
      onAttachListener.onAttachedFromWindow(); 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    OnAttachListener onAttachListener = this.h;
    if (onAttachListener != null)
      onAttachListener.onDetachedFromWindow(); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getContext : ()Landroid/content/Context;
    //   4: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   7: invokevirtual getDisplayMetrics : ()Landroid/util/DisplayMetrics;
    //   10: astore #11
    //   12: aload #11
    //   14: getfield widthPixels : I
    //   17: istore #4
    //   19: aload #11
    //   21: getfield heightPixels : I
    //   24: istore #5
    //   26: iconst_1
    //   27: istore #8
    //   29: iload #4
    //   31: iload #5
    //   33: if_icmpge -> 42
    //   36: iconst_1
    //   37: istore #4
    //   39: goto -> 45
    //   42: iconst_0
    //   43: istore #4
    //   45: iload_1
    //   46: invokestatic getMode : (I)I
    //   49: istore #9
    //   51: iload_2
    //   52: invokestatic getMode : (I)I
    //   55: istore #7
    //   57: iload #9
    //   59: ldc -2147483648
    //   61: if_icmpne -> 197
    //   64: iload #4
    //   66: ifeq -> 78
    //   69: aload_0
    //   70: getfield d : Landroid/util/TypedValue;
    //   73: astore #10
    //   75: goto -> 84
    //   78: aload_0
    //   79: getfield c : Landroid/util/TypedValue;
    //   82: astore #10
    //   84: aload #10
    //   86: ifnull -> 197
    //   89: aload #10
    //   91: getfield type : I
    //   94: ifeq -> 197
    //   97: aload #10
    //   99: getfield type : I
    //   102: iconst_5
    //   103: if_icmpne -> 121
    //   106: aload #10
    //   108: aload #11
    //   110: invokevirtual getDimension : (Landroid/util/DisplayMetrics;)F
    //   113: fstore_3
    //   114: fload_3
    //   115: f2i
    //   116: istore #5
    //   118: goto -> 155
    //   121: aload #10
    //   123: getfield type : I
    //   126: bipush #6
    //   128: if_icmpne -> 152
    //   131: aload #10
    //   133: aload #11
    //   135: getfield widthPixels : I
    //   138: i2f
    //   139: aload #11
    //   141: getfield widthPixels : I
    //   144: i2f
    //   145: invokevirtual getFraction : (FF)F
    //   148: fstore_3
    //   149: goto -> 114
    //   152: iconst_0
    //   153: istore #5
    //   155: iload #5
    //   157: ifle -> 197
    //   160: iload #5
    //   162: aload_0
    //   163: getfield g : Landroid/graphics/Rect;
    //   166: getfield left : I
    //   169: aload_0
    //   170: getfield g : Landroid/graphics/Rect;
    //   173: getfield right : I
    //   176: iadd
    //   177: isub
    //   178: iload_1
    //   179: invokestatic getSize : (I)I
    //   182: invokestatic min : (II)I
    //   185: ldc 1073741824
    //   187: invokestatic makeMeasureSpec : (II)I
    //   190: istore #6
    //   192: iconst_1
    //   193: istore_1
    //   194: goto -> 202
    //   197: iload_1
    //   198: istore #6
    //   200: iconst_0
    //   201: istore_1
    //   202: iload_2
    //   203: istore #5
    //   205: iload #7
    //   207: ldc -2147483648
    //   209: if_icmpne -> 349
    //   212: iload #4
    //   214: ifeq -> 226
    //   217: aload_0
    //   218: getfield e : Landroid/util/TypedValue;
    //   221: astore #10
    //   223: goto -> 232
    //   226: aload_0
    //   227: getfield f : Landroid/util/TypedValue;
    //   230: astore #10
    //   232: iload_2
    //   233: istore #5
    //   235: aload #10
    //   237: ifnull -> 349
    //   240: iload_2
    //   241: istore #5
    //   243: aload #10
    //   245: getfield type : I
    //   248: ifeq -> 349
    //   251: aload #10
    //   253: getfield type : I
    //   256: iconst_5
    //   257: if_icmpne -> 275
    //   260: aload #10
    //   262: aload #11
    //   264: invokevirtual getDimension : (Landroid/util/DisplayMetrics;)F
    //   267: fstore_3
    //   268: fload_3
    //   269: f2i
    //   270: istore #7
    //   272: goto -> 309
    //   275: aload #10
    //   277: getfield type : I
    //   280: bipush #6
    //   282: if_icmpne -> 306
    //   285: aload #10
    //   287: aload #11
    //   289: getfield heightPixels : I
    //   292: i2f
    //   293: aload #11
    //   295: getfield heightPixels : I
    //   298: i2f
    //   299: invokevirtual getFraction : (FF)F
    //   302: fstore_3
    //   303: goto -> 268
    //   306: iconst_0
    //   307: istore #7
    //   309: iload_2
    //   310: istore #5
    //   312: iload #7
    //   314: ifle -> 349
    //   317: iload #7
    //   319: aload_0
    //   320: getfield g : Landroid/graphics/Rect;
    //   323: getfield top : I
    //   326: aload_0
    //   327: getfield g : Landroid/graphics/Rect;
    //   330: getfield bottom : I
    //   333: iadd
    //   334: isub
    //   335: iload_2
    //   336: invokestatic getSize : (I)I
    //   339: invokestatic min : (II)I
    //   342: ldc 1073741824
    //   344: invokestatic makeMeasureSpec : (II)I
    //   347: istore #5
    //   349: aload_0
    //   350: iload #6
    //   352: iload #5
    //   354: invokespecial onMeasure : (II)V
    //   357: aload_0
    //   358: invokevirtual getMeasuredWidth : ()I
    //   361: istore #7
    //   363: iload #7
    //   365: ldc 1073741824
    //   367: invokestatic makeMeasureSpec : (II)I
    //   370: istore #6
    //   372: iload_1
    //   373: ifne -> 515
    //   376: iload #9
    //   378: ldc -2147483648
    //   380: if_icmpne -> 515
    //   383: iload #4
    //   385: ifeq -> 397
    //   388: aload_0
    //   389: getfield b : Landroid/util/TypedValue;
    //   392: astore #10
    //   394: goto -> 403
    //   397: aload_0
    //   398: getfield a : Landroid/util/TypedValue;
    //   401: astore #10
    //   403: aload #10
    //   405: ifnull -> 515
    //   408: aload #10
    //   410: getfield type : I
    //   413: ifeq -> 515
    //   416: aload #10
    //   418: getfield type : I
    //   421: iconst_5
    //   422: if_icmpne -> 439
    //   425: aload #10
    //   427: aload #11
    //   429: invokevirtual getDimension : (Landroid/util/DisplayMetrics;)F
    //   432: fstore_3
    //   433: fload_3
    //   434: f2i
    //   435: istore_1
    //   436: goto -> 472
    //   439: aload #10
    //   441: getfield type : I
    //   444: bipush #6
    //   446: if_icmpne -> 470
    //   449: aload #10
    //   451: aload #11
    //   453: getfield widthPixels : I
    //   456: i2f
    //   457: aload #11
    //   459: getfield widthPixels : I
    //   462: i2f
    //   463: invokevirtual getFraction : (FF)F
    //   466: fstore_3
    //   467: goto -> 433
    //   470: iconst_0
    //   471: istore_1
    //   472: iload_1
    //   473: istore_2
    //   474: iload_1
    //   475: ifle -> 496
    //   478: iload_1
    //   479: aload_0
    //   480: getfield g : Landroid/graphics/Rect;
    //   483: getfield left : I
    //   486: aload_0
    //   487: getfield g : Landroid/graphics/Rect;
    //   490: getfield right : I
    //   493: iadd
    //   494: isub
    //   495: istore_2
    //   496: iload #7
    //   498: iload_2
    //   499: if_icmpge -> 515
    //   502: iload_2
    //   503: ldc 1073741824
    //   505: invokestatic makeMeasureSpec : (II)I
    //   508: istore_2
    //   509: iload #8
    //   511: istore_1
    //   512: goto -> 520
    //   515: iconst_0
    //   516: istore_1
    //   517: iload #6
    //   519: istore_2
    //   520: iload_1
    //   521: ifeq -> 531
    //   524: aload_0
    //   525: iload_2
    //   526: iload #5
    //   528: invokespecial onMeasure : (II)V
    //   531: return
  }
  
  public void setAttachListener(OnAttachListener paramOnAttachListener) {
    this.h = paramOnAttachListener;
  }
  
  public void setDecorPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.g.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (ViewCompat.isLaidOut((View)this))
      requestLayout(); 
  }
  
  public static interface OnAttachListener {
    void onAttachedFromWindow();
    
    void onDetachedFromWindow();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\ContentFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */