package com.soft.blued.ui.yy_room.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.model.YYChatRoomFollowedModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class YYFollowAdapter extends BaseQuickAdapter<YYChatRoomFollowedModel.DataBean, BaseViewHolder> {
  private IRequestHost a;
  
  public YYFollowAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493707, new ArrayList());
    this.k = paramContext;
    this.a = paramIRequestHost;
  }
  
  public YYChatRoomFollowedModel.DataBean a(int paramInt) {
    return (YYChatRoomFollowedModel.DataBean)super.e(paramInt);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, YYChatRoomFollowedModel.DataBean paramDataBean) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297798);
    ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(2131301295);
    TextView textView = (TextView)paramBaseViewHolder.d(2131301105);
    ImageLoader.a(this.a, paramDataBean.avatar).a(2131234356).a(10.0F).a(imageView);
    shapeTextView.setText(paramDataBean.room_type);
    textView.setText(paramDataBean.name);
  }
  
  public void c(List<YYChatRoomFollowedModel.DataBean> paramList) {
    super.c(paramList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\adapter\YYFollowAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */