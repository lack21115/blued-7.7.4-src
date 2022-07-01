package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.trackUtils.EventTrackLive;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.utils.LiveListDataUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

public class PKLiveRecyclerAdapter extends BaseQuickAdapter<BluedLiveListData, BaseViewHolder> {
  public Context a;
  
  public List<BluedLiveListData> b = new ArrayList<BluedLiveListData>();
  
  private IRequestHost c;
  
  public PKLiveRecyclerAdapter(Context paramContext) {
    super(2131493627, new ArrayList());
    this.a = paramContext;
  }
  
  public void a(IRequestHost paramIRequestHost, List<BluedLiveListData> paramList) {
    this.c = paramIRequestHost;
    this.b.clear();
    this.b.addAll(paramList);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedLiveListData paramBluedLiveListData) {
    if (paramBaseViewHolder != null) {
      FrameLayout frameLayout = (FrameLayout)paramBaseViewHolder.d(2131297133);
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)frameLayout.getLayoutParams();
      if (paramBaseViewHolder.getAdapterPosition() == 0) {
        layoutParams.leftMargin = DensityUtils.a(this.a, 5.0F);
        frameLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      } else {
        layoutParams.leftMargin = DensityUtils.a(this.a, 0.0F);
        frameLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      } 
      if (paramBluedLiveListData.anchor != null) {
        ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297489);
        ImageLoader.a(this.c, paramBluedLiveListData.anchor.avatar).a(2131234356).c().a(imageView1);
        imageView1.setOnClickListener(new View.OnClickListener(this, paramBluedLiveListData) {
              public void onClick(View param1View) {
                int i = this.a.link_type;
                if (i != 1) {
                  if (i == 2)
                    EventTrackLive.a(LiveProtos.Event.LIVE_HOME_INTERACTIVE_AREA_CLICK, LiveProtos.EnterType.FRIEND); 
                } else {
                  EventTrackLive.a(LiveProtos.Event.LIVE_HOME_INTERACTIVE_AREA_CLICK, LiveProtos.EnterType.PK);
                } 
                UserRelationshipUtils.a(this.b.a, this.a.anchor, Long.parseLong(this.a.lid), "live_list_pk", LiveListDataUtils.a(this.b.b));
              }
            });
      } 
      ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297509);
      int i = paramBluedLiveListData.link_type;
      if (i != 1) {
        if (i != 2)
          return; 
        imageView.setImageResource(2131232259);
        return;
      } 
      imageView.setImageResource(2131233231);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\adapter\PKLiveRecyclerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */