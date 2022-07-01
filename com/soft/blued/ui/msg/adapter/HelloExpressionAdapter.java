package com.soft.blued.ui.msg.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.ui.msg.model.HelloExpressionData;

public class HelloExpressionAdapter extends BaseQuickAdapter<HelloExpressionData, BaseViewHolder> {
  private IRequestHost a;
  
  public HelloExpressionAdapter(IRequestHost paramIRequestHost) {
    super(2131493548);
    this.a = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, HelloExpressionData paramHelloExpressionData) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297775);
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)imageView.getLayoutParams();
    if (paramBaseViewHolder.getAdapterPosition() == 0) {
      marginLayoutParams.leftMargin = DensityUtil.a(10.0F);
    } else {
      marginLayoutParams.leftMargin = 0;
    } 
    imageView.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
    ImageLoader.a(this.a, paramHelloExpressionData.gif).a(6.0F).a(2131233846).a(imageView);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\HelloExpressionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */