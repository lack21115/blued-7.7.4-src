package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TabTitleTrackIndicatorWithNew extends TabTitleTrackIndicatorWithDot {
  public TabTitleTrackIndicatorWithNew(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public TabTitleTrackIndicatorWithNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt, String paramString) {
    View view = LayoutInflater.from(getContext()).inflate(2131493661, null);
    ColorTrackView colorTrackView = (ColorTrackView)view.findViewById(2131296795);
    colorTrackView.setText(paramString);
    colorTrackView.setTextSize(this.o);
    colorTrackView.setTextOriginColor(this.q);
    colorTrackView.setTextChangeColor(this.r);
    colorTrackView.setFocusable(true);
    if (paramInt == 0) {
      colorTrackView.setProgress(1.0F);
      colorTrackView.setTextSize(this.p);
    } 
    this.x.add(colorTrackView);
    LinearLayout linearLayout = (LinearLayout)view.findViewById(2131298932);
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)this.c);
    linearLayout.setPadding(this.k, this.m, this.l, this.n);
    ImageView imageView2 = (ImageView)view.findViewById(2131297469);
    imageView2.setVisibility(4);
    if (this.y != null)
      this.y.add(imageView2); 
    ImageView imageView1 = (ImageView)view.findViewById(2131297573);
    if (this.B) {
      imageView1.setVisibility(4);
    } else {
      imageView1.setVisibility(8);
    } 
    if (this.z != null)
      this.z.add(imageView1); 
    linearLayout.setOnClickListener(new View.OnClickListener(this, paramInt) {
          public void onClick(View param1View) {
            TabTitleTrackIndicatorWithNew tabTitleTrackIndicatorWithNew = this.b;
            tabTitleTrackIndicatorWithNew.A = true;
            tabTitleTrackIndicatorWithNew.f.setCurrentItem(this.a);
          }
        });
    this.e.addView((View)linearLayout);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\TabTitleTrackIndicatorWithNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */