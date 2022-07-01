package com.soft.blued.ui.feed.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.model.AttentionLiveRecommendData;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import java.util.ArrayList;
import java.util.List;

public class AttentionRecommendLiveAdapter extends BaseQuickAdapter<AttentionLiveRecommendData, BaseViewHolder> {
  private IRequestHost a;
  
  public AttentionRecommendLiveAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493416);
    this.a = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, AttentionLiveRecommendData paramAttentionLiveRecommendData) {
    if (paramBaseViewHolder != null) {
      if (paramAttentionLiveRecommendData == null)
        return; 
      ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297362);
      ImageLoader.a(this.a, paramAttentionLiveRecommendData.pic_url).c().a(2131234358).a(imageView);
      paramBaseViewHolder.d(2131296768).setOnClickListener(new View.OnClickListener(this, paramAttentionLiveRecommendData) {
            public void onClick(View param1View) {
              EventTrackFeed.c(FeedProtos.Event.LIVE_FIND_PLAZA_FOLLOW_ROOM_CLICK, this.a.lid, this.a.uid);
              ArrayList<LiveRoomData> arrayList = new ArrayList();
              int i;
              for (i = 0; i < AttentionRecommendLiveAdapter.a(this.b).size(); i++) {
                boolean bool;
                String str = EncryptTool.a(((AttentionLiveRecommendData)AttentionRecommendLiveAdapter.b(this.b).get(i)).uid);
                long l1 = Long.parseLong(EncryptTool.a(((AttentionLiveRecommendData)AttentionRecommendLiveAdapter.c(this.b).get(i)).lid));
                if (((AttentionLiveRecommendData)AttentionRecommendLiveAdapter.d(this.b).get(i)).live_type == 1) {
                  bool = true;
                } else {
                  bool = false;
                } 
                arrayList.add(new LiveRoomData(l1, bool, "follow_top_live", str, ((AttentionLiveRecommendData)AttentionRecommendLiveAdapter.e(this.b).get(i)).title, ((AttentionLiveRecommendData)AttentionRecommendLiveAdapter.f(this.b).get(i)).pic_url, 0));
              } 
              long l = Long.parseLong(this.a.lid);
              if (this.a.live_type == 1) {
                i = 1;
              } else {
                i = 0;
              } 
              LiveRoomData liveRoomData = new LiveRoomData(l, i, "follow_top_live", this.a.uid, this.a.title, this.a.pic_url, 0);
              LiveRoomInfoChannel.a(AttentionRecommendLiveAdapter.g(this.b), liveRoomData, -1, arrayList);
            }
          });
      paramBaseViewHolder.a(2131301088, paramAttentionLiveRecommendData.title);
      if (!paramAttentionLiveRecommendData.isShowed) {
        EventTrackFeed.c(FeedProtos.Event.LIVE_FIND_PLAZA_FOLLOW_ROOM_SHOW, paramAttentionLiveRecommendData.lid, paramAttentionLiveRecommendData.uid);
        paramAttentionLiveRecommendData.isShowed = true;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\AttentionRecommendLiveAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */