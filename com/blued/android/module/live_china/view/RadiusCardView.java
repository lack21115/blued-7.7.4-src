package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.blued.android.module.live_china.R;
import com.google.android.material.card.MaterialCardView;

public class RadiusCardView extends MaterialCardView {
  private float e;
  
  private float f;
  
  private float g;
  
  private float h;
  
  public RadiusCardView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.materialCardViewStyle);
  }
  
  public RadiusCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setRadius(0.0F);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RadiusCardView);
    this.e = typedArray.getDimension(R.styleable.RadiusCardView_rcv_topLeftRadiu, 0.0F);
    this.f = typedArray.getDimension(R.styleable.RadiusCardView_rcv_topRightRadiu, 0.0F);
    this.g = typedArray.getDimension(R.styleable.RadiusCardView_rcv_bottomRightRadiu, 0.0F);
    this.h = typedArray.getDimension(R.styleable.RadiusCardView_rcv_bottomLeftRadiu, 0.0F);
    setBackground((Drawable)new ColorDrawable());
  }
  
  private RectF getRectF() {
    Rect rect = new Rect();
    getDrawingRect(rect);
    return new RectF(rect);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    Path path = new Path();
    RectF rectF = getRectF();
    float f1 = this.e;
    float f2 = this.f;
    float f3 = this.g;
    float f4 = this.h;
    Path.Direction direction = Path.Direction.CW;
    path.addRoundRect(rectF, new float[] { f1, f1, f2, f2, f3, f3, f4, f4 }, direction);
    paramCanvas.clipPath(path, Region.Op.INTERSECT);
    super.onDraw(paramCanvas);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\RadiusCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */