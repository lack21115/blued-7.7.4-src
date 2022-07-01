package com.soft.blued.ui.yy_room.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.model.YYFollowedModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class YYFollowedAdapter extends BaseQuickAdapter<YYFollowedModel.DataBean, BaseViewHolder> {
  private IRequestHost a;
  
  public YYFollowedAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493708, new ArrayList());
    this.k = paramContext;
    this.a = paramIRequestHost;
  }
  
  public YYFollowedModel.DataBean a(int paramInt) {
    return (YYFollowedModel.DataBean)super.e(paramInt);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, YYFollowedModel.DataBean paramDataBean) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297979);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131301541);
    ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(2131301295);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131301542);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131301540);
    ImageLoader.a(this.a, paramDataBean.avatar).a(2131234356).a(10.0F).a(imageView);
    int i = paramDataBean.is_on_live;
    boolean bool = false;
    if (i == 1) {
      i = 0;
    } else {
      i = 8;
    } 
    shapeTextView.setVisibility(i);
    if (paramDataBean.is_on_live == 1) {
      i = 0;
    } else {
      i = 8;
    } 
    textView3.setVisibility(i);
    i = bool;
    if (paramDataBean.is_on_live == 1)
      i = 8; 
    textView1.setVisibility(i);
    if (paramDataBean.is_on_live == 1) {
      shapeTextView.setText(paramDataBean.room_type);
      textView2.setText(paramDataBean.name);
      textView3.setText(paramDataBean.room_name);
      return;
    } 
    textView2.setText(paramDataBean.name);
    textView1.setText(paramDataBean.last_on_time);
  }
  
  public void c(List<YYFollowedModel.DataBean> paramList) {
    super.c(paramList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\adapter\YYFollowedAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */