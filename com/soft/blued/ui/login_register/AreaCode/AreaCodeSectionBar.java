package com.soft.blued.ui.login_register.AreaCode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.soft.blued.ui.user.adapter.CountryAdapter;

public class AreaCodeSectionBar extends View {
  private String[] a = new String[0];
  
  private int b = 10;
  
  private int c = this.b + 4;
  
  private ListView d;
  
  private AreaCodeIndexer e;
  
  private int f;
  
  private Paint g;
  
  private Context h;
  
  public AreaCodeSectionBar(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AreaCodeSectionBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.h = paramContext;
    a();
  }
  
  public static int a(float paramFloat, Context paramContext) {
    return (int)((paramFloat * (paramContext.getResources().getDisplayMetrics()).densityDpi / 160.0F) + 0.5D);
  }
  
  private void a() {
    this.a = this.h.getResources().getStringArray(2130903045);
    this.b = a(this.b, getContext());
    this.c = a(this.c, getContext());
    this.g = new Paint();
    this.g.setColor(BluedSkinUtils.a(this.h, 2131100669));
    this.g.setTextSize(this.b);
    this.g.setTextAlign(Paint.Align.CENTER);
    this.g.setAntiAlias(true);
  }
  
  public void a(ListView paramListView, CountryAdapter paramCountryAdapter) {
    this.d = paramListView;
    if (paramCountryAdapter != null) {
      this.e = (AreaCodeIndexer)paramCountryAdapter;
      return;
    } 
    throw new RuntimeException("ListView must set Adapter or Adapter must implements Indexer interface");
  }
  
  protected void onDraw(Canvas paramCanvas) {
    int i = 0;
    while (true) {
      String[] arrayOfString = this.a;
      if (i < arrayOfString.length) {
        String str = String.valueOf(arrayOfString[i]);
        float f = (getMeasuredWidth() / 2);
        int j = this.c;
        paramCanvas.drawText(str, f, (j + i * j + this.f), this.g);
        i++;
        continue;
      } 
      super.onDraw(paramCanvas);
      return;
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    this.f = getMeasuredHeight() / 2 - this.c * this.a.length / 2;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int i;
    int j = ((int)paramMotionEvent.getY() - this.f) / this.c;
    String[] arrayOfString = this.a;
    if (j >= arrayOfString.length) {
      i = arrayOfString.length - 1;
    } else {
      i = j;
      if (j < 0)
        i = 0; 
    } 
    if (paramMotionEvent.getAction() == 0 || paramMotionEvent.getAction() == 2) {
      i = this.e.a(String.valueOf(this.a[i]));
      if (i == -1)
        return true; 
      this.d.setSelection(i);
    } 
    return true;
  }
  
  public void setListView(ListView paramListView) {
    this.d = paramListView;
    AreaCodeSelectorAdapter areaCodeSelectorAdapter = (AreaCodeSelectorAdapter)paramListView.getAdapter();
    if (areaCodeSelectorAdapter != null) {
      this.e = areaCodeSelectorAdapter;
      return;
    } 
    throw new RuntimeException("ListView must set Adapter or Adapter must implements Indexer interface");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\AreaCode\AreaCodeSectionBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */