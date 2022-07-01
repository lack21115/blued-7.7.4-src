package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import com.blued.android.module.live.base.view.GiftHitLoadingView;
import com.blued.android.module.yy_china.R;

public class YYGiftHitLoadingView extends GiftHitLoadingView {
  public YYGiftHitLoadingView(Context paramContext) {
    super(paramContext);
  }
  
  public YYGiftHitLoadingView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public void setResources(int paramInt) {
    switch (paramInt) {
      default:
        this.a.setImageResource(0);
        this.a.setVisibility(8);
        setLoadFloorVisibility(0);
        return;
      case 9:
        this.a.setImageResource(R.drawable.animation0);
        return;
      case 8:
        this.a.setImageResource(R.drawable.animation1);
        return;
      case 7:
        this.a.setImageResource(R.drawable.animation2);
        return;
      case 6:
        this.a.setImageResource(R.drawable.animation3);
        return;
      case 5:
        this.a.setImageResource(R.drawable.animation4);
        return;
      case 4:
        this.a.setImageResource(R.drawable.animation5);
        return;
      case 3:
        this.a.setImageResource(R.drawable.animation6);
        return;
      case 2:
        break;
    } 
    this.a.setImageResource(R.drawable.animation7);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYGiftHitLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */