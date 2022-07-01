package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;

public class FalsifyFooter extends InternalAbstract implements RefreshFooter {
  private RefreshKernel a;
  
  public FalsifyFooter(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FalsifyFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(RefreshKernel paramRefreshKernel, int paramInt1, int paramInt2) {
    this.a = paramRefreshKernel;
    paramRefreshKernel.a().h(false);
  }
  
  public void a(RefreshLayout paramRefreshLayout, int paramInt1, int paramInt2) {
    RefreshKernel refreshKernel = this.a;
    if (refreshKernel != null) {
      refreshKernel.a(RefreshState.a);
      this.a.a(RefreshState.p);
    } 
  }
  
  public boolean a(boolean paramBoolean) {
    return false;
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    super.dispatchDraw(paramCanvas);
    if (isInEditMode()) {
      int i = DensityUtil.a(5.0F);
      Paint paint = new Paint();
      paint.setStyle(Paint.Style.STROKE);
      paint.setColor(-858993460);
      paint.setStrokeWidth(DensityUtil.a(1.0F));
      float f = i;
      paint.setPathEffect((PathEffect)new DashPathEffect(new float[] { f, f, f, f }, 1.0F));
      paramCanvas.drawRect(f, f, (getWidth() - i), (getBottom() - i), paint);
      TextView textView = new TextView(getContext());
      textView.setText(getResources().getString(R.string.srl_component_falsify, new Object[] { getClass().getSimpleName(), Float.valueOf(DensityUtil.a(getHeight())) }));
      textView.setTextColor(-858993460);
      textView.setGravity(17);
      textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
      textView.layout(0, 0, getWidth(), getHeight());
      textView.draw(paramCanvas);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\footer\FalsifyFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */