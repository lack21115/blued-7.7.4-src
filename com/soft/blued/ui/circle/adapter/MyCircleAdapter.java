package com.soft.blued.ui.circle.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.utils.TimeAndDateUtils;

public class MyCircleAdapter extends BaseQuickAdapter<MyCircleModel, BaseViewHolder> {
  private ImageView a;
  
  private IRequestHost b;
  
  public MyCircleAdapter(IRequestHost paramIRequestHost) {
    super(2131493610, null);
    this.b = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, MyCircleModel paramMyCircleModel) {
    if (paramBaseViewHolder != null) {
      this.a = (ImageView)paramBaseViewHolder.d(2131299337);
      if (paramMyCircleModel.isHotBase) {
        this.a.setImageResource(2131232353);
      } else {
        ImageLoader.a(this.b, paramMyCircleModel.cover).a(2131231281).a(this.a);
      } 
      if (!TextUtils.isEmpty(paramMyCircleModel.circle_id) && !paramMyCircleModel.isDraw) {
        boolean bool;
        FeedProtos.Event event = FeedProtos.Event.CIRCLE_DRAW;
        String str = paramMyCircleModel.circle_id;
        FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.FIND_CIRCLE_MINE;
        boolean bool1 = paramMyCircleModel.isJoin();
        if (paramMyCircleModel.allow_join == 0) {
          bool = true;
        } else {
          bool = false;
        } 
        EventTrackFeed.a(event, str, circleSource, bool1, bool, paramMyCircleModel.classify_id);
        paramMyCircleModel.isDraw = true;
      } 
      paramBaseViewHolder.a(2131299340, paramMyCircleModel.title);
      long l = TimeAndDateUtils.b(paramMyCircleModel.last_update_time);
      if (l > 0L) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TimeAndDateUtils.c(this.k, l));
        stringBuilder.append(this.k.getString(2131755961));
        paramBaseViewHolder.a(2131301464, stringBuilder.toString());
        return;
      } 
      paramBaseViewHolder.a(2131301464, "");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\adapter\MyCircleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */