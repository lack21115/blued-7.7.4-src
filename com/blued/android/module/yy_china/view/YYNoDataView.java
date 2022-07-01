package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.module.yy_china.R;

public class YYNoDataView extends FrameLayout {
  private ImageView a;
  
  private TextView b;
  
  public YYNoDataView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYNoDataView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYNoDataView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_nodata, (ViewGroup)this, true);
    this.a = (ImageView)findViewById(R.id.img_nodata);
    this.b = (TextView)findViewById(R.id.tv_nodata);
  }
  
  public void setNoDataImg(int paramInt) {
    this.a.setImageResource(paramInt);
  }
  
  public void setNoDataStr(int paramInt) {
    this.b.setText(getContext().getResources().getString(paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYNoDataView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */