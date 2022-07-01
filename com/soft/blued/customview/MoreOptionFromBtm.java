package com.soft.blued.customview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.blued.android.share.Constants;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.HelloHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.BaseShareEntity;
import com.soft.blued.ui.share_custom.Model.ShareEntity;
import com.soft.blued.ui.share_custom.Model.ShareOption;
import com.soft.blued.ui.share_custom.ShareToPlatform;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

public abstract class MoreOptionFromBtm extends BaseMoreOptionFromBtm {
  public ShareEntity f;
  
  private ShareToPlatform g = new ShareToPlatform(this.a, null, null, this.h);
  
  private ShareOptionRecyclerAdapter.ShareOptionsItemClickListener h;
  
  public MoreOptionFromBtm(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener) {
    super(paramContext, paramBoolean1, paramBoolean2, paramOnClickListener);
  }
  
  protected void a(int paramInt) {
    ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener = this.h;
    if (shareOptionsItemClickListener != null)
      shareOptionsItemClickListener.onItemClick(paramInt); 
    int i = this.f.shareFrom;
    String str2 = "";
    String str1 = str2;
    if (i == 6) {
      str1 = str2;
      if (!TextUtils.isEmpty(this.f.linkUrl))
        str1 = this.f.linkUrl; 
    } 
    if (!StringUtils.e(str1) && str1.toLowerCase().contains(H5Url.a(35).toLowerCase()) && paramInt != 2131758767 && paramInt != 2131756078 && paramInt != 2131756440)
      HelloHttpUtils.a(); 
    if (!UserRelationshipUtils.a(this.c)) {
      i = -1;
      switch (paramInt) {
        case 2131758888:
          EventTrackFeed.a(FeedProtos.Event.SHARE_TO_CLICK, FeedProtos.ShareChannel.SHARE_FRIEND_CLUB, EventTrackFeed.a(this.f), str1);
          i = 4;
          this.f.platFormName = Constants.WechatMomentsNAME;
          break;
        case 2131758885:
          EventTrackFeed.a(FeedProtos.Event.SHARE_TO_CLICK, FeedProtos.ShareChannel.SHARE_WECHAT, EventTrackFeed.a(this.f), str1);
          i = 3;
          this.f.platFormName = Constants.WechatNAME;
          break;
        case 2131758878:
          EventTrackFeed.a(FeedProtos.Event.SHARE_TO_CLICK, FeedProtos.ShareChannel.SHARE_WEIBO, EventTrackFeed.a(this.f), str1);
          i = 2;
          this.f.platFormName = Constants.SinaWeiboNAME;
          break;
        case 2131758870:
          EventTrackFeed.a(FeedProtos.Event.SHARE_TO_CLICK, FeedProtos.ShareChannel.SHARE_QQ, EventTrackFeed.a(this.f), str1);
          i = 5;
          this.f.platFormName = Constants.QQNAME;
          break;
        case 2131758767:
          EventTrackFeed.a(FeedProtos.Event.SHARE_TO_CLICK, FeedProtos.ShareChannel.SHARE_FRIEND, EventTrackFeed.a(this.f), str1);
          i = 0;
          this.f.platFormName = Constants.BLUED_GROUP_AND_PEOPLE;
          break;
        case 2131758763:
          super.a(paramInt);
          return;
        case 2131756078:
          EventTrackFeed.a(FeedProtos.Event.SHARE_TO_CLICK, FeedProtos.ShareChannel.SHARE_FEED, EventTrackFeed.a(this.f), str1);
          i = 1;
          this.f.platFormName = Constants.BLUED_FEED;
          break;
      } 
      InstantLog.a(ShareToPlatform.c(this.f), i, str1, ShareToPlatform.d(this.f));
      this.g.a(this.f);
      super.a(paramInt);
    } 
  }
  
  public void a(ShareEntity paramShareEntity, ShareOptionRecyclerAdapter.ShareOptionsItemClickListener paramShareOptionsItemClickListener) {
    this.f = paramShareEntity;
    this.h = paramShareOptionsItemClickListener;
    a((BaseShareEntity)paramShareEntity);
  }
  
  public void a(List<ShareOption> paramList1, List<ShareOption> paramList2) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\MoreOptionFromBtm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */