package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

public class MarqueeTextView extends AppCompatTextView {
  public boolean a = false;
  
  private float b = 0.0F;
  
  private float c = 0.0F;
  
  private Paint d = null;
  
  private String e = "";
  
  private long f = 1000L;
  
  private int g = 2;
  
  private int h;
  
  private int i;
  
  private callbackListener j;
  
  private Runnable k = new Runnable(this) {
      public void run() {
        MarqueeTextView marqueeTextView = this.a;
        marqueeTextView.a = true;
        if (MarqueeTextView.a(marqueeTextView) != null)
          MarqueeTextView.a(this.a).a(MarqueeTextView.b(this.a)); 
        if (this.a.a) {
          MarqueeTextView.a(this.a, 1.0F);
          MarqueeTextView.c(this.a);
          this.a.invalidate();
        } 
      }
    };
  
  public MarqueeTextView(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public MarqueeTextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MarqueeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    setMaxWidth((paramContext.getResources().getDisplayMetrics()).widthPixels / 2);
    this.d = (Paint)getPaint();
    this.d.setColor(getTextColors().getColorForState(getDrawableState(), 0));
    this.e = getText().toString();
    if (TextUtils.isEmpty(this.e))
      return; 
    this.b = this.d.measureText(this.e);
    this.a = true;
  }
  
  public void a() {
    if (this.a)
      return; 
    removeCallbacks(this.k);
    this.a = true;
    this.i = 0;
    this.c = 0.0F;
    invalidate();
  }
  
  public void b() {
    if (!this.a)
      return; 
    removeCallbacks(this.k);
    this.a = false;
    this.i = 0;
    this.c = 0.0F;
    invalidate();
  }
  
  public void onDraw(Canvas paramCanvas) {
    Paint.FontMetricsInt fontMetricsInt = this.d.getFontMetricsInt();
    this.h = (paramCanvas.getHeight() - fontMetricsInt.bottom - fontMetricsInt.top) / 2;
    if (this.b <= paramCanvas.getWidth()) {
      paramCanvas.drawText(this.e, 0.0F, this.h, this.d);
      return;
    } 
    paramCanvas.drawText(this.e, -this.c, this.h, this.d);
    if (!this.a)
      return; 
    float f = this.c;
    if (f == 0.0F) {
      this.a = false;
      postDelayed(this.k, this.f);
      return;
    } 
    if (f > -this.g && f < 0.0F) {
      this.c = 0.0F;
    } else {
      this.c += this.g;
    } 
    if (this.c > this.b)
      this.c = -paramCanvas.getWidth(); 
    invalidate();
  }
  
  public void setListener(callbackListener paramcallbackListener) {
    this.j = paramcallbackListener;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType) {
    super.setText(paramCharSequence, paramBufferType);
    this.e = paramCharSequence.toString();
    this.b = getPaint().measureText(paramCharSequence.toString());
    this.c = 0.0F;
    a();
  }
  
  public void setTextColor(int paramInt) {
    super.setTextColor(paramInt);
    this.d.setColor(paramInt);
    a();
  }
  
  static interface callbackListener {
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\MarqueeTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */