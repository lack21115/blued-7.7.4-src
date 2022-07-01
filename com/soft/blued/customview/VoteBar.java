package com.soft.blued.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.framework.utils.DensityUtils;

public class VoteBar extends View {
  private Context a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private boolean j = false;
  
  private Paint k;
  
  private Paint l;
  
  public VoteBar(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public VoteBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private Paint a(boolean paramBoolean) {
    Paint paint = new Paint();
    if (paramBoolean) {
      paint.setColor(this.a.getResources().getColor(2131100622));
    } else {
      paint.setColor(this.a.getResources().getColor(2131100623));
    } 
    paint.setStyle(Paint.Style.FILL);
    paint.setStrokeWidth(1.0F);
    paint.setAntiAlias(true);
    return paint;
  }
  
  private Path a(int paramInt) {
    Point point1 = new Point(this.f, this.g + this.e * 2);
    Path path = new Path();
    path.moveTo(point1.x, point1.y);
    int i = this.f;
    float f1 = i;
    int j = this.g;
    float f2 = j;
    int k = this.e;
    path.arcTo(new RectF(f1, f2, (i + k * 2), (j + k * 2)), 180.0F, 90.0F);
    Point point2 = new Point(this.f + this.e * 2 + paramInt, this.g);
    path.lineTo(point2.x, point2.y);
    point2 = new Point(getShortLineWidth() + this.f + this.e * 2 + paramInt, this.i);
    path.lineTo(point2.x, point2.y);
    point2 = new Point(this.f + this.e * 2, this.i);
    path.lineTo(point2.x, point2.y);
    paramInt = this.f;
    f1 = paramInt;
    i = this.i;
    j = this.e;
    path.arcTo(new RectF(f1, (i - j * 2), (paramInt + j * 2), i), 90.0F, 90.0F);
    path.lineTo(point1.x, point1.y);
    return path;
  }
  
  private Path b(int paramInt) {
    Point point1 = new Point(this.h, this.i - this.e * 2);
    Path path = new Path();
    path.moveTo(point1.x, point1.y);
    int i = this.h;
    int j = this.e;
    float f = (i - j * 2);
    int k = this.i;
    path.arcTo(new RectF(f, (k - j * 2), i, k), 0.0F, 90.0F);
    Point point2 = new Point(this.h - paramInt - this.e * 2, this.i);
    path.lineTo(point2.x, point2.y);
    point2 = new Point(this.h - paramInt - this.e * 2 - getShortLineWidth(), this.g);
    path.lineTo(point2.x, point2.y);
    point2 = new Point(this.h - this.e * 2, this.g);
    path.lineTo(point2.x, point2.y);
    paramInt = this.h;
    i = this.e;
    f = (paramInt - i * 2);
    j = this.g;
    path.arcTo(new RectF(f, j, paramInt, (j + i * 2)), 270.0F, 90.0F);
    path.lineTo(point1.x, point1.y);
    return path;
  }
  
  private Path getRoundSquarePath() {
    Path path = new Path();
    Point point1 = new Point(this.f, this.g + this.e * 2);
    Point point2 = new Point(this.h - this.e * 2, this.g);
    Point point3 = new Point(this.h, this.i - this.e * 2);
    Point point4 = new Point(this.f + this.e * 2, this.i);
    path.moveTo(point1.x, point1.y);
    int i = this.f;
    float f1 = i;
    int j = this.g;
    float f2 = j;
    int k = this.e;
    path.arcTo(new RectF(f1, f2, (i + k * 2), (j + k * 2)), 180.0F, 90.0F);
    path.lineTo(point2.x, point2.y);
    i = this.h;
    j = this.e;
    f1 = (i - j * 2);
    k = this.g;
    path.arcTo(new RectF(f1, k, i, (k + j * 2)), 270.0F, 90.0F);
    path.lineTo(point3.x, point3.y);
    i = this.h;
    j = this.e;
    f1 = (i - j * 2);
    k = this.i;
    path.arcTo(new RectF(f1, (k - j * 2), i, k), 0.0F, 90.0F);
    path.lineTo(point4.x, point4.y);
    i = this.f;
    f1 = i;
    j = this.i;
    k = this.e;
    path.arcTo(new RectF(f1, (j - k * 2), (i + k * 2), j), 90.0F, 90.0F);
    path.lineTo(point1.x, point1.y);
    return path;
  }
  
  private int getShortLineWidth() {
    return (int)((this.i - this.g) * 0.26794919243112D);
  }
  
  public void a(Context paramContext) {
    this.a = paramContext;
    if ("en".equals(BlueAppLocal.a())) {
      this.d = DensityUtils.a(this.a, 70.0F);
    } else {
      this.d = DensityUtils.a(this.a, 47.0F);
    } 
    this.e = DensityUtils.a(this.a, 5.0F);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    if (!this.j) {
      this.f = getPaddingLeft();
      this.g = getPaddingTop();
      this.h = getWidth() - getPaddingRight();
      this.i = getHeight() - getPaddingBottom();
      this.k = a(true);
      this.l = a(false);
      int k = this.d;
      this.c = k;
      this.b = k;
      this.j = true;
    } 
    int i = this.c;
    int j = this.d;
    if (i == j && this.b == j) {
      paramCanvas.drawPath(a(i), this.k);
      paramCanvas.drawPath(b(this.b), this.l);
      return;
    } 
    if (this.c == 0) {
      paramCanvas.drawPath(getRoundSquarePath(), this.l);
      return;
    } 
    i = this.b;
    if (i == 0) {
      paramCanvas.drawPath(getRoundSquarePath(), this.k);
      return;
    } 
    paramCanvas.drawPath(b(i), this.l);
    paramCanvas.drawPath(a(this.c), this.k);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\VoteBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */