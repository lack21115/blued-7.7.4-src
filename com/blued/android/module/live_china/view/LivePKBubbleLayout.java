package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.blued.android.framework.utils.DensityUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class LivePKBubbleLayout extends BubbleLayout {
  private List<BubbleLayout.Bubble> a = Collections.synchronizedList(new ArrayList<BubbleLayout.Bubble>());
  
  private Random b = new Random();
  
  private int c;
  
  private int d;
  
  private Context e;
  
  private Paint f = new Paint();
  
  private int g;
  
  private int h;
  
  private int i;
  
  public LivePKBubbleLayout(Context paramContext) {
    super(paramContext);
  }
  
  public LivePKBubbleLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public LivePKBubbleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt) {
    if (paramInt <= 0)
      return; 
    this.f.reset();
    this.f.setColor(6723993);
    this.c = getWidth();
    this.d = getHeight();
    BubbleLayout.Bubble bubble = new BubbleLayout.Bubble();
    TextView textView = new TextView(this.e);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("+");
    stringBuilder.append(paramInt);
    textView.setText(stringBuilder.toString());
    if (paramInt > 0 && paramInt <= 20) {
      textView.setTextColor(Color.parseColor("#ffb119"));
      textView.setTextSize(18.0F);
    } else if (paramInt > 20 && paramInt < 100) {
      textView.setTextColor(Color.parseColor("#ff873e"));
      textView.setTextSize(22.0F);
    } else {
      textView.setTextColor(Color.parseColor("#f65e4a"));
      textView.setTextSize(28.0F);
    } 
    boolean bool = true;
    textView.setDrawingCacheEnabled(true);
    textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
    Bitmap bitmap = Bitmap.createBitmap(textView.getDrawingCache());
    textView.destroyDrawingCache();
    bubble.e = bitmap;
    bubble.c(8.0F);
    bubble.c = 0.08F;
    paramInt = this.c - textView.getMeasuredWidth();
    if (paramInt > 0) {
      paramInt = this.b.nextInt(paramInt);
    } else {
      paramInt = this.c;
    } 
    bubble.a(paramInt);
    bubble.b((this.d - DensityUtils.a(this.e, 12.0F)));
    float f = this.b.nextFloat();
    while (true) {
      float f1 = f - 1.0F;
      if (f1 >= -0.25D || f1 <= -0.7F) {
        f = this.b.nextFloat();
        continue;
      } 
      if (this.b.nextInt(2) == 0) {
        paramInt = bool;
      } else {
        paramInt = 0;
      } 
      f = f1;
      if (paramInt == 0)
        f = f1 * -1.0F; 
      bubble.d(f * 3.0F);
      bubble.a = bubble.e();
      post(new Runnable(this, bubble) {
            public void run() {
              if (LivePKBubbleLayout.a(this.b).size() <= 50)
                LivePKBubbleLayout.a(this.b).add(this.a); 
              this.b.invalidate();
            }
          });
      return;
    } 
  }
  
  public void a(Context paramContext) {
    this.e = paramContext;
    this.i = DensityUtils.a(this.e, 65.0F);
    this.g = DensityUtils.a(this.e, 28.0F);
    this.h = DensityUtils.a(this.e, 17.0F);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.a.size() > 0) {
      Iterator<BubbleLayout.Bubble> iterator = this.a.iterator();
      while (iterator.hasNext()) {
        BubbleLayout.Bubble bubble = iterator.next();
        if (bubble == null)
          continue; 
        if (bubble.c() - bubble.d() <= 0.0F) {
          iterator.remove();
          continue;
        } 
        float f1 = (this.c - this.g) - bubble.b();
        float f2 = this.i;
        if (bubble.e() >= 0.0F) {
          if (f1 <= 0.0F)
            bubble.d(-bubble.e()); 
        } else if (f2 - f1 <= 0.0F) {
          bubble.d(-bubble.e());
        } 
        bubble.a();
        this.f.setAlpha(bubble.d);
        if (bubble.b < 1.0F) {
          Matrix matrix1 = new Matrix();
          matrix1.postScale(bubble.b * 1.0F, bubble.b * 1.0F, 1.0F, 1.0F);
          matrix1.postTranslate(bubble.b(), bubble.c());
          if (bubble.e != null)
            paramCanvas.drawBitmap(bubble.e, matrix1, this.f); 
          bubble.b += bubble.c;
          bubble.b(bubble.c() - 5.0F);
          bubble.a(bubble.b() - 3.5F);
          continue;
        } 
        Matrix matrix = new Matrix();
        matrix.postScale(1.0F, 1.0F, 1.0F, 1.0F);
        matrix.postTranslate(bubble.b(), bubble.c());
        if (bubble.e != null)
          paramCanvas.drawBitmap(bubble.e, matrix, this.f); 
        bubble.a(bubble.b() + bubble.e());
        bubble.b(bubble.c() - bubble.d());
      } 
      invalidate();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LivePKBubbleLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */