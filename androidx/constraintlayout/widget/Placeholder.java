package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class Placeholder extends View {
  private int a = -1;
  
  private View b = null;
  
  private int c = 4;
  
  public Placeholder(Context paramContext) {
    super(paramContext);
    a((AttributeSet)null);
  }
  
  public Placeholder(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public Placeholder(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  public Placeholder(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet) {
    setVisibility(this.c);
    this.a = -1;
    if (paramAttributeSet != null) {
      TypedArray typedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_placeholder);
      int j = typedArray.getIndexCount();
      for (int i = 0; i < j; i++) {
        int k = typedArray.getIndex(i);
        if (k == R.styleable.ConstraintLayout_placeholder_content) {
          this.a = typedArray.getResourceId(k, this.a);
        } else if (k == R.styleable.ConstraintLayout_placeholder_emptyVisibility) {
          this.c = typedArray.getInt(k, this.c);
        } 
      } 
    } 
  }
  
  public View getContent() {
    return this.b;
  }
  
  public int getEmptyVisibility() {
    return this.c;
  }
  
  public void onDraw(Canvas paramCanvas) {
    if (isInEditMode()) {
      paramCanvas.drawRGB(223, 223, 223);
      Paint paint = new Paint();
      paint.setARGB(255, 210, 210, 210);
      paint.setTextAlign(Paint.Align.CENTER);
      paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
      Rect rect = new Rect();
      paramCanvas.getClipBounds(rect);
      paint.setTextSize(rect.height());
      int i = rect.height();
      int j = rect.width();
      paint.setTextAlign(Paint.Align.LEFT);
      paint.getTextBounds("?", 0, 1, rect);
      paramCanvas.drawText("?", j / 2.0F - rect.width() / 2.0F - rect.left, i / 2.0F + rect.height() / 2.0F - rect.bottom, paint);
    } 
  }
  
  public void setContentId(int paramInt) {
    if (this.a == paramInt)
      return; 
    View view = this.b;
    if (view != null) {
      view.setVisibility(0);
      ((ConstraintLayout.LayoutParams)this.b.getLayoutParams()).h = false;
      this.b = null;
    } 
    this.a = paramInt;
    if (paramInt != -1) {
      view = ((View)getParent()).findViewById(paramInt);
      if (view != null)
        view.setVisibility(8); 
    } 
  }
  
  public void setEmptyVisibility(int paramInt) {
    this.c = paramInt;
  }
  
  public void updatePostMeasure(ConstraintLayout paramConstraintLayout) {
    if (this.b == null)
      return; 
    ConstraintLayout.LayoutParams layoutParams1 = (ConstraintLayout.LayoutParams)getLayoutParams();
    ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams)this.b.getLayoutParams();
    layoutParams2.s.setVisibility(0);
    layoutParams1.s.setWidth(layoutParams2.s.getWidth());
    layoutParams1.s.setHeight(layoutParams2.s.getHeight());
    layoutParams2.s.setVisibility(8);
  }
  
  public void updatePreLayout(ConstraintLayout paramConstraintLayout) {
    if (this.a == -1 && !isInEditMode())
      setVisibility(this.c); 
    this.b = paramConstraintLayout.findViewById(this.a);
    View view = this.b;
    if (view != null) {
      ((ConstraintLayout.LayoutParams)view.getLayoutParams()).h = true;
      this.b.setVisibility(0);
      setVisibility(0);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\widget\Placeholder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */