package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import java.lang.reflect.Field;

public class StrokeTextView extends AppCompatTextView {
  public StrokeTextView(Context paramContext) {
    super(paramContext);
  }
  
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private void setTextColorUseReflection(int paramInt) {
    try {
      Field field = TextView.class.getDeclaredField("mCurTextColor");
      field.setAccessible(true);
      field.set(this, Integer.valueOf(paramInt));
      field.setAccessible(false);
    } catch (NoSuchFieldException noSuchFieldException) {
      noSuchFieldException.printStackTrace();
    } catch (IllegalArgumentException illegalArgumentException) {
      illegalArgumentException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } 
    getPaint().setColor(paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    TextPaint textPaint = getPaint();
    setTextColorUseReflection(-1);
    textPaint.setStrokeWidth(3.0F);
    textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    textPaint.setFakeBoldText(true);
    textPaint.setShadowLayer(1.0F, 0.0F, 0.0F, 0);
    super.onDraw(paramCanvas);
    setTextColorUseReflection(Color.parseColor("#ffd542"));
    textPaint.setStrokeWidth(0.0F);
    textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    textPaint.setFakeBoldText(false);
    textPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    super.onDraw(paramCanvas);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\StrokeTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */