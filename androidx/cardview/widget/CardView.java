package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.R;

public class CardView extends FrameLayout {
  private static final int[] e = new int[] { 16842801 };
  
  private static final CardViewImpl f;
  
  int a;
  
  int b;
  
  final Rect c;
  
  final Rect d;
  
  private boolean g;
  
  private boolean h;
  
  private final CardViewDelegate i;
  
  static {
    if (Build.VERSION.SDK_INT >= 21) {
      f = new CardViewApi21Impl();
    } else if (Build.VERSION.SDK_INT >= 17) {
      f = new CardViewApi17Impl();
    } else {
      f = new CardViewBaseImpl();
    } 
    f.initStatic();
  }
  
  public CardView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.cardViewStyle);
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    ColorStateList colorStateList;
    this.c = new Rect();
    this.d = new Rect();
    this.i = new CardViewDelegate(this) {
        private Drawable b;
        
        public Drawable getCardBackground() {
          return this.b;
        }
        
        public View getCardView() {
          return (View)this.a;
        }
        
        public boolean getPreventCornerOverlap() {
          return this.a.getPreventCornerOverlap();
        }
        
        public boolean getUseCompatPadding() {
          return this.a.getUseCompatPadding();
        }
        
        public void setCardBackground(Drawable param1Drawable) {
          this.b = param1Drawable;
          this.a.setBackgroundDrawable(param1Drawable);
        }
        
        public void setMinWidthHeightInternal(int param1Int1, int param1Int2) {
          if (param1Int1 > this.a.a)
            CardView.a(this.a, param1Int1); 
          if (param1Int2 > this.a.b)
            CardView.b(this.a, param1Int2); 
        }
        
        public void setShadowPadding(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
          this.a.d.set(param1Int1, param1Int2, param1Int3, param1Int4);
          CardView cardView = this.a;
          CardView.a(cardView, param1Int1 + cardView.c.left, param1Int2 + this.a.c.top, param1Int3 + this.a.c.right, param1Int4 + this.a.c.bottom);
        }
      };
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CardView, paramInt, R.style.CardView);
    if (typedArray.hasValue(R.styleable.CardView_cardBackgroundColor)) {
      colorStateList = typedArray.getColorStateList(R.styleable.CardView_cardBackgroundColor);
    } else {
      TypedArray typedArray1 = getContext().obtainStyledAttributes(e);
      paramInt = typedArray1.getColor(0, 0);
      typedArray1.recycle();
      float[] arrayOfFloat = new float[3];
      Color.colorToHSV(paramInt, arrayOfFloat);
      if (arrayOfFloat[2] > 0.5F) {
        paramInt = getResources().getColor(R.color.cardview_light_background);
      } else {
        paramInt = getResources().getColor(R.color.cardview_dark_background);
      } 
      colorStateList = ColorStateList.valueOf(paramInt);
    } 
    float f3 = typedArray.getDimension(R.styleable.CardView_cardCornerRadius, 0.0F);
    float f2 = typedArray.getDimension(R.styleable.CardView_cardElevation, 0.0F);
    float f1 = typedArray.getDimension(R.styleable.CardView_cardMaxElevation, 0.0F);
    this.g = typedArray.getBoolean(R.styleable.CardView_cardUseCompatPadding, false);
    this.h = typedArray.getBoolean(R.styleable.CardView_cardPreventCornerOverlap, true);
    paramInt = typedArray.getDimensionPixelSize(R.styleable.CardView_contentPadding, 0);
    this.c.left = typedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingLeft, paramInt);
    this.c.top = typedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingTop, paramInt);
    this.c.right = typedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingRight, paramInt);
    this.c.bottom = typedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingBottom, paramInt);
    if (f2 > f1)
      f1 = f2; 
    this.a = typedArray.getDimensionPixelSize(R.styleable.CardView_android_minWidth, 0);
    this.b = typedArray.getDimensionPixelSize(R.styleable.CardView_android_minHeight, 0);
    typedArray.recycle();
    f.initialize(this.i, paramContext, colorStateList, f3, f2, f1);
  }
  
  public ColorStateList getCardBackgroundColor() {
    return f.getBackgroundColor(this.i);
  }
  
  public float getCardElevation() {
    return f.getElevation(this.i);
  }
  
  public int getContentPaddingBottom() {
    return this.c.bottom;
  }
  
  public int getContentPaddingLeft() {
    return this.c.left;
  }
  
  public int getContentPaddingRight() {
    return this.c.right;
  }
  
  public int getContentPaddingTop() {
    return this.c.top;
  }
  
  public float getMaxCardElevation() {
    return f.getMaxElevation(this.i);
  }
  
  public boolean getPreventCornerOverlap() {
    return this.h;
  }
  
  public float getRadius() {
    return f.getRadius(this.i);
  }
  
  public boolean getUseCompatPadding() {
    return this.g;
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    if (!(f instanceof CardViewApi21Impl)) {
      int i = View.MeasureSpec.getMode(paramInt1);
      if (i == Integer.MIN_VALUE || i == 1073741824)
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(f.getMinWidth(this.i)), View.MeasureSpec.getSize(paramInt1)), i); 
      i = View.MeasureSpec.getMode(paramInt2);
      if (i == Integer.MIN_VALUE || i == 1073741824)
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(f.getMinHeight(this.i)), View.MeasureSpec.getSize(paramInt2)), i); 
      super.onMeasure(paramInt1, paramInt2);
      return;
    } 
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCardBackgroundColor(int paramInt) {
    f.setBackgroundColor(this.i, ColorStateList.valueOf(paramInt));
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList) {
    f.setBackgroundColor(this.i, paramColorStateList);
  }
  
  public void setCardElevation(float paramFloat) {
    f.setElevation(this.i, paramFloat);
  }
  
  public void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.c.set(paramInt1, paramInt2, paramInt3, paramInt4);
    f.updatePadding(this.i);
  }
  
  public void setMaxCardElevation(float paramFloat) {
    f.setMaxElevation(this.i, paramFloat);
  }
  
  public void setMinimumHeight(int paramInt) {
    this.b = paramInt;
    super.setMinimumHeight(paramInt);
  }
  
  public void setMinimumWidth(int paramInt) {
    this.a = paramInt;
    super.setMinimumWidth(paramInt);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPreventCornerOverlap(boolean paramBoolean) {
    if (paramBoolean != this.h) {
      this.h = paramBoolean;
      f.onPreventCornerOverlapChanged(this.i);
    } 
  }
  
  public void setRadius(float paramFloat) {
    f.setRadius(this.i, paramFloat);
  }
  
  public void setUseCompatPadding(boolean paramBoolean) {
    if (this.g != paramBoolean) {
      this.g = paramBoolean;
      f.onCompatPaddingChanged(this.i);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\cardview\widget\CardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */