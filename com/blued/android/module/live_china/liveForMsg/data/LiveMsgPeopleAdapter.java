package com.blued.android.module.live_china.liveForMsg.data;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

public class LiveMsgPeopleAdapter extends BaseQuickAdapter<ProfileData, BaseViewHolder> {
  private Context a;
  
  public LiveMsgPeopleAdapter(Context paramContext) {
    super(R.layout.item_live_msg_people, new ArrayList());
    this.a = paramContext;
  }
  
  private void b() {
    if (LiveRoomManager.a().p() == null)
      return; 
    if (LiveRoomManager.a().p().size() > 50) {
      ArrayList arrayList = new ArrayList();
      for (int i = 0; i < 50; i++)
        arrayList.add(LiveRoomManager.a().p().get(i)); 
      LiveRoomManager.a().p().clear();
      LiveRoomManager.a().p().addAll(arrayList);
    } 
  }
  
  public void a() {
    b();
    ArrayList arrayList = new ArrayList();
    arrayList.addAll(LiveRoomManager.a().q());
    arrayList.addAll(LiveRoomManager.a().p());
    c(arrayList);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, ProfileData paramProfileData) {
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(R.id.item_avatar);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(R.id.item_avatar_v);
    View view = paramBaseViewHolder.d(R.id.item_avatar_empty);
    ImageView imageView3 = (ImageView)paramBaseViewHolder.d(R.id.item_avatar_liang);
    FrameLayout frameLayout = (FrameLayout)paramBaseViewHolder.d(R.id.item_rank_bg);
    ImageLoader.a(null, AvatarUtils.a(1, paramProfileData.avatar)).a(R.drawable.user_bg_round).c().a(imageView1);
    imageView2.setVisibility(8);
    LiveRoomInfo.a().a(imageView2, paramProfileData.vBadge);
    if (paramProfileData.liangType >= 2) {
      imageView3.setVisibility(0);
      if (imageView2.getVisibility() == 0) {
        imageView3.setImageResource(R.drawable.live_viewer_v_liang);
      } else {
        imageView3.setImageResource(R.drawable.live_viewer_liang);
      } 
      view.setVisibility(0);
    } else {
      imageView3.setVisibility(8);
      view.setVisibility(8);
    } 
    if (paramProfileData.liveViewerRank == 1) {
      frameLayout.setBackgroundResource(R.drawable.live_viewer_rank_1);
    } else if (paramProfileData.liveViewerRank == 2) {
      frameLayout.setBackgroundResource(R.drawable.live_viewer_rank_2);
    } else if (paramProfileData.liveViewerRank == 3) {
      frameLayout.setBackgroundResource(R.drawable.live_viewer_rank_3);
    } else {
      frameLayout.setBackgroundResource(R.color.transparent);
    } 
    paramBaseViewHolder.itemView.setOnClickListener(new View.OnClickListener(this, paramProfileData) {
          public void onClick(View param1View) {
            if (this.a != null) {
              LiveRoomUserModel liveRoomUserModel = new LiveRoomUserModel();
              liveRoomUserModel.uid = String.valueOf(this.a.uid);
              liveRoomUserModel.avatar = this.a.avatar;
              LiveSetDataObserver.a().a(liveRoomUserModel);
            } 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\liveForMsg\data\LiveMsgPeopleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */