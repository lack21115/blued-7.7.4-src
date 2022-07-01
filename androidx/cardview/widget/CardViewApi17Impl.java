package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

class CardViewApi17Impl extends CardViewBaseImpl {
  public void initStatic() {
    RoundRectDrawableWithShadow.a = new RoundRectDrawableWithShadow.RoundRectHelper(this) {
        public void drawRoundRect(Canvas param1Canvas, RectF param1RectF, float param1Float, Paint param1Paint) {
          param1Canvas.drawRoundRect(param1RectF, param1Float, param1Float, param1Paint);
        }
      };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\cardview\widget\CardViewApi17Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */