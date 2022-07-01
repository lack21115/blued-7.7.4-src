package com.blued.android.module.live_china.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.module.live_china.R;

public class BubbleTextView extends AppCompatTextView {
  private BubbleDrawable a;
  
  private float b;
  
  private float c;
  
  private float d;
  
  private float e;
  
  private int f;
  
  private BubbleDrawable.ArrowLocation g;
  
  private boolean h;
  
  public BubbleTextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public BubbleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a() {
    a(getWidth(), getHeight());
  }
  
  private void a(int paramInt1, int paramInt2) {
    a(0, paramInt1, 0, paramInt2);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    RectF rectF = new RectF(paramInt1, paramInt3, paramInt2, paramInt4);
    this.a = (new BubbleDrawable.Builder()).a(rectF).a(this.g).a(BubbleDrawable.BubbleType.a).b(this.c).c(this.d).a(this.b).a(this.f).d(this.e).a(this.h).a();
  }
  
  private void a(AttributeSet paramAttributeSet) {
    if (paramAttributeSet != null) {
      TypedArray typedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.BubbleView);
      this.b = typedArray.getDimension(R.styleable.BubbleView_arrowWidth, BubbleDrawable.Builder.a);
      this.d = typedArray.getDimension(R.styleable.BubbleView_arrowHeight, BubbleDrawable.Builder.b);
      this.c = typedArray.getDimension(R.styleable.BubbleView_angle, BubbleDrawable.Builder.c);
      this.e = typedArray.getDimension(R.styleable.BubbleView_arrowPosition, BubbleDrawable.Builder.d);
      this.f = typedArray.getColor(R.styleable.BubbleView_bubbleColor, BubbleDrawable.Builder.e);
      this.g = BubbleDrawable.ArrowLocation.a(typedArray.getInt(R.styleable.BubbleView_arrowLocation, 0));
      this.h = typedArray.getBoolean(R.styleable.BubbleView_arrowCenter, false);
      typedArray.recycle();
    } 
    b();
  }
  
  private void b() {
    int i = getPaddingLeft();
    int j = getPaddingRight();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    int n = null.a[this.g.ordinal()];
    if (n != 1) {
      if (n != 2) {
        if (n != 3) {
          if (n == 4)
            m = (int)(m + this.d); 
        } else {
          k = (int)(k + this.d);
        } 
      } else {
        j = (int)(j + this.b);
      } 
    } else {
      i = (int)(i + this.b);
    } 
    setPadding(i, k, j, m);
  }
  
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    BubbleDrawable bubbleDrawable = this.a;
    if (bubbleDrawable != null)
      bubbleDrawable.draw(paramCanvas); 
    super.onDraw(paramCanvas);
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 > 0 && paramInt2 > 0)
      a(paramInt1, paramInt2); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\bubbleview\BubbleTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */