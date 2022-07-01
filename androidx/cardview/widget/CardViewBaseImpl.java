package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

class CardViewBaseImpl implements CardViewImpl {
  final RectF a = new RectF();
  
  private RoundRectDrawableWithShadow a(Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3) {
    return new RoundRectDrawableWithShadow(paramContext.getResources(), paramColorStateList, paramFloat1, paramFloat2, paramFloat3);
  }
  
  private RoundRectDrawableWithShadow a(CardViewDelegate paramCardViewDelegate) {
    return (RoundRectDrawableWithShadow)paramCardViewDelegate.getCardBackground();
  }
  
  public ColorStateList getBackgroundColor(CardViewDelegate paramCardViewDelegate) {
    return a(paramCardViewDelegate).f();
  }
  
  public float getElevation(CardViewDelegate paramCardViewDelegate) {
    return a(paramCardViewDelegate).b();
  }
  
  public float getMaxElevation(CardViewDelegate paramCardViewDelegate) {
    return a(paramCardViewDelegate).c();
  }
  
  public float getMinHeight(CardViewDelegate paramCardViewDelegate) {
    return a(paramCardViewDelegate).e();
  }
  
  public float getMinWidth(CardViewDelegate paramCardViewDelegate) {
    return a(paramCardViewDelegate).d();
  }
  
  public float getRadius(CardViewDelegate paramCardViewDelegate) {
    return a(paramCardViewDelegate).a();
  }
  
  public void initStatic() {
    RoundRectDrawableWithShadow.a = new RoundRectDrawableWithShadow.RoundRectHelper(this) {
        public void drawRoundRect(Canvas param1Canvas, RectF param1RectF, float param1Float, Paint param1Paint) {
          float f1 = 2.0F * param1Float;
          float f2 = param1RectF.width() - f1 - 1.0F;
          float f3 = param1RectF.height();
          if (param1Float >= 1.0F) {
            float f4 = param1Float + 0.5F;
            RectF rectF = this.a.a;
            float f5 = -f4;
            rectF.set(f5, f5, f4, f4);
            int i = param1Canvas.save();
            param1Canvas.translate(param1RectF.left + f4, param1RectF.top + f4);
            param1Canvas.drawArc(this.a.a, 180.0F, 90.0F, true, param1Paint);
            param1Canvas.translate(f2, 0.0F);
            param1Canvas.rotate(90.0F);
            param1Canvas.drawArc(this.a.a, 180.0F, 90.0F, true, param1Paint);
            param1Canvas.translate(f3 - f1 - 1.0F, 0.0F);
            param1Canvas.rotate(90.0F);
            param1Canvas.drawArc(this.a.a, 180.0F, 90.0F, true, param1Paint);
            param1Canvas.translate(f2, 0.0F);
            param1Canvas.rotate(90.0F);
            param1Canvas.drawArc(this.a.a, 180.0F, 90.0F, true, param1Paint);
            param1Canvas.restoreToCount(i);
            param1Canvas.drawRect(param1RectF.left + f4 - 1.0F, param1RectF.top, param1RectF.right - f4 + 1.0F, param1RectF.top + f4, param1Paint);
            param1Canvas.drawRect(param1RectF.left + f4 - 1.0F, param1RectF.bottom - f4, param1RectF.right - f4 + 1.0F, param1RectF.bottom, param1Paint);
          } 
          param1Canvas.drawRect(param1RectF.left, param1RectF.top + param1Float, param1RectF.right, param1RectF.bottom - param1Float, param1Paint);
        }
      };
  }
  
  public void initialize(CardViewDelegate paramCardViewDelegate, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3) {
    RoundRectDrawableWithShadow roundRectDrawableWithShadow = a(paramContext, paramColorStateList, paramFloat1, paramFloat2, paramFloat3);
    roundRectDrawableWithShadow.a(paramCardViewDelegate.getPreventCornerOverlap());
    paramCardViewDelegate.setCardBackground(roundRectDrawableWithShadow);
    updatePadding(paramCardViewDelegate);
  }
  
  public void onCompatPaddingChanged(CardViewDelegate paramCardViewDelegate) {}
  
  public void onPreventCornerOverlapChanged(CardViewDelegate paramCardViewDelegate) {
    a(paramCardViewDelegate).a(paramCardViewDelegate.getPreventCornerOverlap());
    updatePadding(paramCardViewDelegate);
  }
  
  public void setBackgroundColor(CardViewDelegate paramCardViewDelegate, ColorStateList paramColorStateList) {
    a(paramCardViewDelegate).a(paramColorStateList);
  }
  
  public void setElevation(CardViewDelegate paramCardViewDelegate, float paramFloat) {
    a(paramCardViewDelegate).b(paramFloat);
  }
  
  public void setMaxElevation(CardViewDelegate paramCardViewDelegate, float paramFloat) {
    a(paramCardViewDelegate).c(paramFloat);
    updatePadding(paramCardViewDelegate);
  }
  
  public void setRadius(CardViewDelegate paramCardViewDelegate, float paramFloat) {
    a(paramCardViewDelegate).a(paramFloat);
    updatePadding(paramCardViewDelegate);
  }
  
  public void updatePadding(CardViewDelegate paramCardViewDelegate) {
    Rect rect = new Rect();
    a(paramCardViewDelegate).a(rect);
    paramCardViewDelegate.setMinWidthHeightInternal((int)Math.ceil(getMinWidth(paramCardViewDelegate)), (int)Math.ceil(getMinHeight(paramCardViewDelegate)));
    paramCardViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\cardview\widget\CardViewBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */