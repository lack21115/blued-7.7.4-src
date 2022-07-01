package com.soft.blued.ui.share_custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.share.Constants;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.HelloHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.fragment.FeedPostFragment;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.BaseShareEntity;
import com.soft.blued.ui.share_custom.Model.ShareEntity;
import com.soft.blued.utils.BitmapUtils;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.ShareCoreUtils;
import com.soft.blued.utils.StringUtils;

public class ShareToPlatform extends BaseShareToPlatform {
  private ShareEntity c;
  
  public ShareToPlatform(Context paramContext, ShareCoreUtils.ShareBackLister paramShareBackLister, BaseShareToPlatform.PopWindowSetting paramPopWindowSetting, ShareOptionRecyclerAdapter.ShareOptionsItemClickListener paramShareOptionsItemClickListener) {
    super(paramContext, paramShareBackLister, paramPopWindowSetting, paramShareOptionsItemClickListener);
  }
  
  private Bitmap a(View paramView) {
    paramView.setDrawingCacheEnabled(true);
    paramView.buildDrawingCache();
    return Bitmap.createBitmap(paramView.getDrawingCache(), 0, 0, AppInfo.l, DensityUtils.a(this.a, 189.0F), null, false);
  }
  
  private void a(ShareEntity paramShareEntity, int paramInt) {
    boolean bool1;
    boolean bool2;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    UserBasicModel userBasicModel = paramShareEntity.c;
    String str8 = "";
    if (userBasicModel != null && paramShareEntity.c.uid != null) {
      str1 = paramShareEntity.c.uid;
    } else {
      str1 = "";
    } 
    if (paramShareEntity.a != null && paramShareEntity.a.feed_id != null) {
      str2 = paramShareEntity.a.feed_id;
    } else {
      str2 = "";
    } 
    if (paramShareEntity.a != null && paramShareEntity.a.super_did != null) {
      str3 = paramShareEntity.a.super_did;
    } else {
      str3 = "";
    } 
    if (paramShareEntity.a != null && paramShareEntity.a.in_promotion == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (paramShareEntity.a != null && paramShareEntity.a.recommend_text != null) {
      str4 = paramShareEntity.a.recommend_text;
    } else {
      str4 = "";
    } 
    if (paramShareEntity.a != null && paramShareEntity.a.circle_id != null) {
      str5 = paramShareEntity.a.circle_id;
    } else {
      str5 = "";
    } 
    if (paramShareEntity.a != null && paramShareEntity.a.is_anonym == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramShareEntity.i != null && paramShareEntity.i.h != null) {
      str6 = paramShareEntity.i.h;
    } else {
      str6 = "";
    } 
    String str7 = str8;
    if (paramShareEntity.shareFrom == 6) {
      str7 = str8;
      if (!TextUtils.isEmpty(paramShareEntity.linkUrl))
        str7 = paramShareEntity.linkUrl; 
    } 
    if (!TextUtils.isEmpty(str7) && str7.toLowerCase().contains(H5Url.a(33).toLowerCase()) && paramInt != 2131758767 && paramInt != 2131756078 && paramInt != 2131756440)
      HelloHttpUtils.a(); 
    if (paramInt == 2131758767) {
      EventTrackFeed.a(FeedProtos.Event.SHARE_TO_CLICK, FeedProtos.ShareChannel.SHARE_FRIEND, str1, str2, str3, str6, str5, EventTrackFeed.a(paramShareEntity), str7, bool1, str4, bool2);
      InstantLog.a(c(paramShareEntity), 0, str7, d(paramShareEntity));
      return;
    } 
    if (paramInt == 2131756078) {
      EventTrackFeed.a(FeedProtos.Event.SHARE_TO_CLICK, FeedProtos.ShareChannel.SHARE_FEED, str1, str2, str3, str6, str5, EventTrackFeed.a(paramShareEntity), str7, bool1, str4, bool2);
      InstantLog.a(c(paramShareEntity), 1, str7, d(paramShareEntity));
      return;
    } 
    if (paramInt == 2131758878) {
      EventTrackFeed.a(FeedProtos.Event.SHARE_TO_CLICK, FeedProtos.ShareChannel.SHARE_WEIBO, str1, str2, str3, str6, str5, EventTrackFeed.a(paramShareEntity), str7, bool1, str4, bool2);
      InstantLog.a(c(paramShareEntity), 2, str7, d(paramShareEntity));
      return;
    } 
    if (paramInt == 2131758885) {
      EventTrackFeed.a(FeedProtos.Event.SHARE_TO_CLICK, FeedProtos.ShareChannel.SHARE_WECHAT, str1, str2, str3, str6, str5, EventTrackFeed.a(paramShareEntity), str7, bool1, str4, bool2);
      InstantLog.a(c(paramShareEntity), 3, str7, d(paramShareEntity));
      return;
    } 
    if (paramInt == 2131758888) {
      EventTrackFeed.a(FeedProtos.Event.SHARE_TO_CLICK, FeedProtos.ShareChannel.SHARE_FRIEND_CLUB, str1, str2, str3, str6, str5, EventTrackFeed.a(paramShareEntity), str7, bool1, str4, bool2);
      InstantLog.a(c(paramShareEntity), 4, str7, d(paramShareEntity));
      return;
    } 
    if (paramInt == 2131758870) {
      EventTrackFeed.a(FeedProtos.Event.SHARE_TO_CLICK, FeedProtos.ShareChannel.SHARE_QQ, str1, str2, str3, str6, str5, EventTrackFeed.a(paramShareEntity), str7, bool1, str4, bool2);
      InstantLog.a(c(paramShareEntity), 5, str7, d(paramShareEntity));
      return;
    } 
    if (paramInt == 2131756440) {
      EventTrackFeed.a(FeedProtos.Event.SHARE_TO_CLICK, FeedProtos.ShareChannel.SHARE_FORWARD, str1, str2, str3, str6, str5, EventTrackFeed.a(paramShareEntity), str7, bool1, str4, bool2);
      InstantLog.d(paramShareEntity.f, paramShareEntity.a, paramShareEntity.g, paramShareEntity.h);
    } 
  }
  
  public static int c(ShareEntity paramShareEntity) {
    switch (paramShareEntity.shareFrom) {
      default:
        return -1;
      case 8:
        return 5;
      case 6:
      case 9:
        return 4;
      case 5:
        return 6;
      case 4:
        return 1;
      case 3:
        return 2;
      case 2:
        return 0;
      case 1:
        break;
    } 
    return 3;
  }
  
  private void c() {
    if (!PopMenuUtils.a(this.a)) {
      if (this.c.shareFrom != 6) {
        ShareEntity shareEntity = this.c;
        shareEntity.title = shareEntity.content;
      } 
      if (this.c.shareFrom == 8) {
        this.c.j.setDrawingCacheEnabled(false);
        String str = RecyclingUtils.e("photo");
        BitmapUtils.a(a(this.c.j), str, 100);
        ChildImageInfo childImageInfo = new ChildImageInfo();
        childImageInfo.mImagePath = str;
        SelectPhotoManager.a().a(childImageInfo);
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.title = AppInfo.d().getString(2131756444);
        shareEntity.shareType = 1;
        FeedPostFragment.a(this.a, shareEntity);
        return;
      } 
      FeedPostFragment.a(this.a, this.c);
    } 
  }
  
  public static String d(ShareEntity paramShareEntity) {
    int i = paramShareEntity.shareFrom;
    if (i != 3)
      if (i != 4) {
        if (i != 8)
          return ""; 
      } else {
        return paramShareEntity.a.feed_id;
      }  
    return paramShareEntity.i.h;
  }
  
  public void a() {
    if (!PopMenuUtils.a(this.a)) {
      if (this.c.a != null) {
        BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
        if (this.c.a.repost != null && this.c.a.repost.feed_is_delete == 1)
          return; 
        if (this.c.a.is_repost == 1) {
          bluedIngSelfFeed.feed_id = this.c.a.feed_id;
          bluedIngSelfFeed.repost = this.c.a.repost;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("//");
          stringBuilder.append(StringUtils.c(this.c.a.user_name, this.c.a.feed_uid));
          stringBuilder.append(":");
          stringBuilder.append(this.c.a.feed_content);
          bluedIngSelfFeed.feed_content = stringBuilder.toString();
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("RepostToFeed feed_id :");
          stringBuilder.append(this.c.a.feed_id);
          Log.v("drb", stringBuilder.toString());
          bluedIngSelfFeed.feed_id = this.c.a.feed_id;
          bluedIngSelfFeed.repost = this.c.a;
          bluedIngSelfFeed.feed_content = "";
          if (this.c.shareFrom == 11)
            bluedIngSelfFeed.repost.is_share_circle = 1; 
        } 
        FeedPostFragment.a(this.a, bluedIngSelfFeed);
        return;
      } 
      if (this.c.b != null)
        FeedPostFragment.a(this.a, this.c.b); 
    } 
  }
  
  protected void a(int paramInt, ShareCoreUtils.ShareBackLister paramShareBackLister, BaseShareToPlatform.PopWindowSetting paramPopWindowSetting) {
    if (paramInt == 2131756440) {
      a();
    } else if (paramInt == 2131756078) {
      c();
    } else if (paramInt == 2131758767) {
      b();
    } 
    a(this.c, paramInt);
    super.a(paramInt, paramShareBackLister, paramPopWindowSetting);
  }
  
  public void a(ShareEntity paramShareEntity) {
    this.c = paramShareEntity;
    if (!TextUtils.isEmpty(this.c.platFormName) && this.c.platFormName.equals(Constants.BLUED_FEED)) {
      c();
    } else if (!TextUtils.isEmpty(this.c.platFormName) && this.c.platFormName.equals(Constants.REPOST_FEED)) {
      a();
    } else if (!TextUtils.isEmpty(this.c.platFormName) && this.c.platFormName.equals(Constants.BLUED_GROUP_AND_PEOPLE)) {
      b();
    } 
    b((BaseShareEntity)paramShareEntity);
  }
  
  protected void a(String paramString) {
    String str;
    if (this.c.shareFrom == 6) {
      str = this.c.linkUrl;
    } else {
      str = "";
    } 
    byte b = -1;
    if (TextUtils.equals(paramString, Constants.SinaWeiboNAME)) {
      b = 2;
    } else if (TextUtils.equals(paramString, Constants.QQNAME)) {
      b = 5;
    } else if (TextUtils.equals(paramString, Constants.WechatNAME)) {
      b = 3;
    } else if (TextUtils.equals(paramString, Constants.WechatMomentsNAME)) {
      b = 4;
    } 
    InstantLog.b(c(this.c), b, str, d(this.c));
    super.a(paramString);
  }
  
  protected void b() {
    StringBuilder stringBuilder;
    if ((this.c.shareFrom == 6 || this.c.shareFrom == 9) && PopMenuUtils.a(this.a))
      return; 
    ShareToMsgEntity shareToMsgEntity = new ShareToMsgEntity();
    int i = this.c.shareFrom;
    String str = "1";
    switch (i) {
      default:
        shareToMsgEntity.title = this.c.title;
        shareToMsgEntity.name = this.c.content;
        shareToMsgEntity.image = this.c.netImgUrl;
        shareToMsgEntity.description = this.c.mainBody;
        shareToMsgEntity.url = this.c.linkUrl;
        shareToMsgEntity.type = this.c.shareType;
        shareToMsgEntity.share_from = this.c.shareFrom;
        ChatHelperV4.a().a(this.a, shareToMsgEntity);
        return;
      case 12:
        shareToMsgEntity.title = this.c.title;
        shareToMsgEntity.name = this.c.content;
        shareToMsgEntity.image = this.c.netImgUrl;
        shareToMsgEntity.description = this.c.mainBody;
        shareToMsgEntity.url = this.c.linkUrl;
        shareToMsgEntity.sessionId = Long.valueOf(this.c.i.h).longValue();
        break;
      case 11:
        shareToMsgEntity.title = String.format(this.a.getResources().getString(2131755453), new Object[] { this.c.title });
        if (this.c.a != null) {
          shareToMsgEntity.name = this.c.a.feed_pure_content;
          shareToMsgEntity.gid = this.c.a.feed_id;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("http://native.blued.cn/?action=base_post_detail&post_id=");
          stringBuilder1.append(this.c.a.feed_id);
          stringBuilder1.append("&base_id=");
          stringBuilder1.append(this.c.a.circle_id);
          shareToMsgEntity.url = stringBuilder1.toString();
          if (this.c.a.is_video_posts == 1 && this.c.a.feed_videos != null && this.c.a.feed_videos.length > 0) {
            shareToMsgEntity.image = this.c.a.feed_videos[0];
            break;
          } 
          if (this.c.a.feed_pics != null && this.c.a.feed_pics.length > 0)
            shareToMsgEntity.image = this.c.a.feed_pics[0]; 
        } 
        break;
      case 10:
        stringBuilder = new StringBuilder();
        stringBuilder.append("http://native.blued.cn/?action=topic&id=");
        stringBuilder.append(this.c.b.super_did);
        stringBuilder.append("&from=msg");
        shareToMsgEntity.url = stringBuilder.toString();
        shareToMsgEntity.title = this.a.getResources().getString(2131758746);
        shareToMsgEntity.name = this.c.b.name;
        shareToMsgEntity.image = this.c.b.avatar;
        break;
      case 9:
        if (this.c.flag == 0) {
          shareToMsgEntity.image = this.c.fileUrl;
          break;
        } 
        shareToMsgEntity.image = this.c.netImgUrl;
        break;
      case 6:
        shareToMsgEntity.title = this.a.getResources().getString(2131755459);
        shareToMsgEntity.name = this.c.title;
        if (this.c.flag == 0) {
          shareToMsgEntity.image = this.c.fileUrl;
        } else {
          shareToMsgEntity.image = this.c.netImgUrl;
        } 
        shareToMsgEntity.description = "";
        shareToMsgEntity.url = this.c.linkUrl;
        break;
      case 4:
        shareToMsgEntity.title = this.a.getResources().getString(2131755454);
        if (this.c.a != null) {
          if (TextUtils.isEmpty(this.c.a.feed_content)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.c.a.user_name);
            stringBuilder.append(this.a.getResources().getString(2131755451));
            shareToMsgEntity.name = stringBuilder.toString();
          } else {
            shareToMsgEntity.name = this.c.a.feed_content;
          } 
          stringBuilder = new StringBuilder();
          stringBuilder.append("http://native.blued.cn/?action=feed&fid=");
          stringBuilder.append(EncryptTool.b(this.c.a.feed_id));
          stringBuilder.append("&ads=");
          stringBuilder.append(this.c.a.is_ads);
          shareToMsgEntity.url = stringBuilder.toString();
          if ("1".equals(this.c.a.is_videos) && this.c.a.feed_videos != null && this.c.a.feed_videos.length > 0) {
            shareToMsgEntity.image = this.c.a.feed_videos[0];
            break;
          } 
          if (this.c.a.feed_pics != null && this.c.a.feed_pics.length > 0)
            shareToMsgEntity.image = this.c.a.feed_pics[0]; 
        } 
        break;
      case 3:
        shareToMsgEntity.title = this.c.title;
        shareToMsgEntity.name = this.c.content;
        shareToMsgEntity.image = this.c.netImgUrl;
        shareToMsgEntity.description = this.c.mainBody;
        shareToMsgEntity.url = this.c.linkUrl;
        shareToMsgEntity.sessionId = Long.valueOf(this.c.i.h).longValue();
        break;
      case 2:
        if (this.c.d != null) {
          shareToMsgEntity.gid = this.c.d.groups_gid;
          String str1 = str;
          if (!"1".equals(this.c.d.groups_is_admins))
            if ("1".equals(this.c.d.groups_is_created)) {
              str1 = str;
            } else {
              str1 = "0";
            }  
          shareToMsgEntity.isCreatorOrAdmin = str1;
          shareToMsgEntity.name = this.c.d.groups_name;
          shareToMsgEntity.description = this.c.d.groups_description;
        } 
        shareToMsgEntity.url = this.c.linkUrl;
        shareToMsgEntity.title = this.a.getResources().getString(2131755457);
      case 1:
        shareToMsgEntity.title = this.a.getResources().getString(2131755455);
        if (this.c.c != null) {
          shareToMsgEntity.name = this.c.c.name;
          shareToMsgEntity.description = this.c.c.description;
          stringBuilder = new StringBuilder();
          stringBuilder.append("http://native.blued.cn/?action=profile&uid=");
          stringBuilder.append(this.c.c.uid);
          shareToMsgEntity.url = stringBuilder.toString();
          shareToMsgEntity.image = this.c.netImgUrl;
        } 
        break;
    } 
    shareToMsgEntity.type = this.c.shareType;
    shareToMsgEntity.share_from = this.c.shareFrom;
    ChatHelperV4.a().a(this.a, shareToMsgEntity);
  }
  
  public void b(ShareEntity paramShareEntity) {
    this.c = paramShareEntity;
    a((BaseShareEntity)paramShareEntity);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\share_custom\ShareToPlatform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */