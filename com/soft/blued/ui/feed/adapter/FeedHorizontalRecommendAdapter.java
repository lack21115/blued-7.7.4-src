package com.soft.blued.ui.feed.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.customview.AvatarLivingAnimView;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.model.FeedRecommendUser;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.views.FollowStatusView;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

public class FeedHorizontalRecommendAdapter extends BaseQuickAdapter<FeedRecommendUser, BaseViewHolder> {
  private Context a;
  
  private IRequestHost b;
  
  public FeedHorizontalRecommendAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493640, null);
    this.a = paramContext;
    this.b = paramIRequestHost;
  }
  
  private void a(FeedRecommendUser paramFeedRecommendUser, String paramString) {
    UserHttpUtils.b(this.a, new UserRelationshipUtils.IAddOrRemoveAttentionDone(this, paramFeedRecommendUser) {
          public void a() {}
          
          public void a(String param1String) {
            this.a.relationship = param1String;
            this.b.notifyDataSetChanged();
          }
          
          public void b() {}
          
          public void b(String param1String) {}
          
          public void c() {
            this.a.relationship = "0";
            this.b.notifyDataSetChanged();
          }
        }paramString, "", this.b);
  }
  
  private void b() {
    if (e() != null)
      for (int i = 0; i < e().getChildCount(); i++)
        f(e().getChildAt(i));  
  }
  
  private void f(View paramView) {
    if (paramView != null) {
      paramView = paramView.findViewById(2131298685);
      if (paramView != null && paramView instanceof AvatarLivingAnimView)
        ((AvatarLivingAnimView)paramView).a(); 
    } 
  }
  
  public void a() {
    b();
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, FeedRecommendUser paramFeedRecommendUser) {
    if (paramBaseViewHolder != null && paramFeedRecommendUser != null) {
      String str1 = EncryptTool.a(paramFeedRecommendUser.uid);
      String str2 = EncryptTool.a(paramFeedRecommendUser.lid);
      ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297490);
      ImageLoader.a(this.b, AvatarUtils.a(1, paramFeedRecommendUser.avatar)).a(2131234356).c().a(imageView);
      imageView.setOnClickListener(new View.OnClickListener(this, str1, paramFeedRecommendUser, str2, imageView) {
            public void onClick(View param1View) {
              ArrayList<LiveRoomData> arrayList;
              boolean bool;
              FeedProtos.Event event = FeedProtos.Event.PLAZA_RECOMMEND_FOLLOW_USER_CLICK;
              String str = this.a;
              if (this.b.show_type == 0) {
                bool = true;
              } else {
                bool = false;
              } 
              EventTrackFeed.b(event, str, bool);
              UserBasicModel userBasicModel = new UserBasicModel();
              userBasicModel.uid = this.a;
              userBasicModel.name = this.b.name;
              userBasicModel.avatar = this.b.avatar;
              if (this.b.show_type == 0) {
                str = this.b.source;
                arrayList = new ArrayList();
                int i;
                for (i = 0; i < FeedHorizontalRecommendAdapter.a(this.e).size(); i++) {
                  boolean bool1;
                  String str1 = EncryptTool.a(((FeedRecommendUser)FeedHorizontalRecommendAdapter.b(this.e).get(i)).uid);
                  String str2 = EncryptTool.a(((FeedRecommendUser)FeedHorizontalRecommendAdapter.c(this.e).get(i)).lid);
                  long l = 0L;
                  if (!TextUtils.isEmpty(str2))
                    l = Long.parseLong(str2); 
                  if (((FeedRecommendUser)FeedHorizontalRecommendAdapter.d(this.e).get(i)).liveType == 1) {
                    bool1 = true;
                  } else {
                    bool1 = false;
                  } 
                  arrayList.add(new LiveRoomData(l, bool1, str, str1, ((FeedRecommendUser)FeedHorizontalRecommendAdapter.e(this.e).get(i)).name, ((FeedRecommendUser)FeedHorizontalRecommendAdapter.f(this.e).get(i)).avatar, ((FeedRecommendUser)FeedHorizontalRecommendAdapter.g(this.e).get(i)).vbadge));
                } 
                if (this.b.liveType == 1) {
                  i = 1;
                } else {
                  i = 0;
                } 
                LiveRoomData liveRoomData = new LiveRoomData(Long.parseLong(this.c), i, str, this.a, this.b.name, this.b.avatar, this.b.vbadge);
                LiveRoomInfoChannel.a(FeedHorizontalRecommendAdapter.h(this.e), liveRoomData, -1, arrayList);
                return;
              } 
              UserInfoFragmentNew.a(FeedHorizontalRecommendAdapter.h(this.e), (UserBasicModel)arrayList, "feed_horizontal_recommend", (View)this.d, null, new MsgSourceEntity(MessageProtos.StrangerSource.FIND_PLAZA_RECOMMEND_USER));
            }
          });
      int i = paramFeedRecommendUser.show_type;
      boolean bool = false;
      if (i == 0) {
        paramBaseViewHolder.b(2131298685, true);
        paramBaseViewHolder.b(2131297957, false);
      } else {
        paramBaseViewHolder.b(2131298685, false);
        paramBaseViewHolder.b(2131297957, true);
        UserRelationshipUtils.a((ImageView)paramBaseViewHolder.d(2131297957), paramFeedRecommendUser.vbadge, 3, 8);
      } 
      paramBaseViewHolder.a(2131301088, paramFeedRecommendUser.name);
      if (paramFeedRecommendUser.show_type == 0) {
        if (paramFeedRecommendUser.liveType == 1) {
          paramBaseViewHolder.b(2131301238, 2131757760);
        } else if (paramFeedRecommendUser.link_type == 1) {
          paramBaseViewHolder.b(2131301238, 2131757763);
        } else if (paramFeedRecommendUser.link_type == 2) {
          paramBaseViewHolder.b(2131301238, 2131757762);
        } else {
          paramBaseViewHolder.b(2131301238, 2131757761);
        } 
      } else {
        paramBaseViewHolder.a(2131301238, paramFeedRecommendUser.source);
      } 
      FollowStatusView followStatusView = (FollowStatusView)paramBaseViewHolder.d(2131297199);
      followStatusView.setRelationShip(paramFeedRecommendUser.relationship);
      followStatusView.b();
      if ("1".equalsIgnoreCase(paramFeedRecommendUser.relationship) || "3".equalsIgnoreCase(paramFeedRecommendUser.relationship))
        followStatusView.a(); 
      followStatusView.setOnClickListener(new -$$Lambda$FeedHorizontalRecommendAdapter$wrTNEyPN1C8toSyMxAm09bFGTeU(this, paramFeedRecommendUser.relationship, paramFeedRecommendUser, str1, imageView));
      if (!paramFeedRecommendUser.isShowed) {
        FeedProtos.Event event = FeedProtos.Event.PLAZA_RECOMMEND_FOLLOW_USER_SHOW;
        if (paramFeedRecommendUser.show_type == 0)
          bool = true; 
        EventTrackFeed.b(event, str1, bool);
        paramFeedRecommendUser.isShowed = true;
      } 
    } 
  }
  
  public void b(BaseViewHolder paramBaseViewHolder) {
    super.onViewRecycled((RecyclerView.ViewHolder)paramBaseViewHolder);
    if (paramBaseViewHolder != null)
      f(paramBaseViewHolder.z()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\FeedHorizontalRecommendAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */