package com.blued.android.module.common.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LiveGiftIndicatorView extends LinearLayout {
  private Context a;
  
  private final List<ImageView> b = new ArrayList<ImageView>();
  
  private Bitmap c;
  
  private Bitmap d;
  
  private int e = 12;
  
  private int f;
  
  private int g;
  
  private int h;
  
  public LiveGiftIndicatorView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    setOrientation(0);
    this.f = DisplayUtil.a(paramContext, this.e);
  }
  
  private Bitmap getNormalImg() {
    if (this.d == null)
      this.d = BitmapFactory.decodeResource(getResources(), R.drawable.live_gift_indicator_point_nomal); 
    return this.d;
  }
  
  private Bitmap getSelectedImg() {
    if (this.c == null)
      this.c = BitmapFactory.decodeResource(getResources(), R.drawable.live_gift_indicator_point_select); 
    return this.c;
  }
  
  public void a(int paramInt) {
    for (int i = this.b.size(); i < paramInt; i++) {
      RelativeLayout relativeLayout = new RelativeLayout(this.a);
      int j = this.f;
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(j, j);
      RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams1.addRule(13);
      ImageView imageView = new ImageView(this.a);
      if (i == 0) {
        imageView.setImageBitmap(getSelectedImg());
      } else {
        imageView.setImageBitmap(getNormalImg());
      } 
      relativeLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams1);
      addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams);
      this.b.add(imageView);
    } 
  }
  
  public void b(int paramInt) {
    Iterator<ImageView> iterator = this.b.iterator();
    while (iterator.hasNext())
      ((ImageView)iterator.next()).setImageBitmap(getNormalImg()); 
    List<ImageView> list = this.b;
    if (list != null && list.size() > paramInt)
      ((ImageView)this.b.get(paramInt)).setImageBitmap(getSelectedImg()); 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    Bitmap bitmap = this.c;
    if (bitmap != null) {
      bitmap.recycle();
      this.c = null;
    } 
    bitmap = this.d;
    if (bitmap != null) {
      bitmap.recycle();
      this.d = null;
    } 
  }
  
  public void setIndicatorCount(int paramInt) {
    a(paramInt);
    for (int i = 0; i < this.b.size(); i++) {
      if (i >= paramInt) {
        ((ImageView)this.b.get(i)).setVisibility(8);
        ((View)((ImageView)this.b.get(i)).getParent()).setVisibility(8);
      } else {
        ((ImageView)this.b.get(i)).setVisibility(0);
        ((View)((ImageView)this.b.get(i)).getParent()).setVisibility(0);
      } 
    } 
  }
  
  public void setNormalImgRes(int paramInt) {
    this.g = paramInt;
    this.d = BitmapFactory.decodeResource(getResources(), this.g);
  }
  
  public void setSelectedImgRes(int paramInt) {
    this.h = paramInt;
    this.c = BitmapFactory.decodeResource(getResources(), this.h);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\view\LiveGiftIndicatorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */