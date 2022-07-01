package com.blued.android.similarity_operation_provider;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.core.utils.SafeUtils;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.base.game_center.GameCenterProxy;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.live_china.fragment.LiveLiangPayFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.yy_china.fragment.YYApplyFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.vip.VipProtos;
import com.huawei.android.hms.agent.common.ActivityMgr;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.emoticon.manager.EmotionManager;
import com.soft.blued.log.mobevent.MobEventUtils;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.sdk.ui.SDKPayFragment;
import com.soft.blued.ui.circle.fragment.CircleAddPostFragment;
import com.soft.blued.ui.circle.fragment.CircleDetailsFragment;
import com.soft.blued.ui.circle.fragment.CircleNewFragment;
import com.soft.blued.ui.circle.fragment.CirclePostDetailsFragment;
import com.soft.blued.ui.circle.fragment.CircleTypeListFragment;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.discover.fragment.NearbyModuleUsersFragment;
import com.soft.blued.ui.discover.fragment.ShineVideoListFragment;
import com.soft.blued.ui.discover.fragment.ShineVideoListIndepFragment;
import com.soft.blued.ui.discover.fragment.SuperTopicFragment;
import com.soft.blued.ui.discover.observer.DiscoverSquareViewModel;
import com.soft.blued.ui.discover.observer.LiveTagsSetSelectedTab;
import com.soft.blued.ui.feed.fragment.FeedDetailsFragment;
import com.soft.blued.ui.feed.fragment.FeedPostFragment;
import com.soft.blued.ui.feed.fragment.SuperTopicDetailFragment;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.find.fragment.FindSearchMapActivity;
import com.soft.blued.ui.find.fragment.FindSearchMapDialogFragment;
import com.soft.blued.ui.find.fragment.HelloOpenDialogFragment;
import com.soft.blued.ui.find.fragment.NearbyLiveFragment;
import com.soft.blued.ui.find.fragment.VisitHistoryFragment;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.observer.NearbyFindSetSelectedTab;
import com.soft.blued.ui.find.observer.NearbyPeopleTabSelectedObserver;
import com.soft.blued.ui.find.observer.VisitRecordSelectedTabObserver;
import com.soft.blued.ui.group.GroupSearchListFragment;
import com.soft.blued.ui.group.UserGroupListsFragment;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.live.fragment.LiveApplyFragment;
import com.soft.blued.ui.live.fragment.LiveApplyImproveFragment;
import com.soft.blued.ui.live.fragment.LiveApplySimpleFragment;
import com.soft.blued.ui.live.fragment.LiveJoinFansFragment;
import com.soft.blued.ui.live.fragment.LiveYYImproveFragment;
import com.soft.blued.ui.msg.DialogSkipFragment;
import com.soft.blued.ui.msg.MsgBoxSettingDialogFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.customview.GlobalTaskFloatManager;
import com.soft.blued.ui.msg.fragment.HelloFragment;
import com.soft.blued.ui.msg.model.ChannelModel;
import com.soft.blued.ui.pay.BeansPrePayFragment;
import com.soft.blued.ui.setting.fragment.AboutBluedFragment;
import com.soft.blued.ui.setting.fragment.BlacklistFragment;
import com.soft.blued.ui.setting.fragment.ChangeBluedIconFragment;
import com.soft.blued.ui.setting.fragment.FeedbackFragment;
import com.soft.blued.ui.setting.fragment.HelpCenterFragment;
import com.soft.blued.ui.setting.fragment.LanguageSelectFragment;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.setting.fragment.PasswordSettingFragment;
import com.soft.blued.ui.setting.fragment.PersonalVerifyFragment;
import com.soft.blued.ui.setting.fragment.PrivacySettingFragment;
import com.soft.blued.ui.setting.fragment.RemindSettingFragment;
import com.soft.blued.ui.setting.fragment.SettingFragment;
import com.soft.blued.ui.setting.fragment.ShowVerifyFragment;
import com.soft.blued.ui.share_custom.Model.ShareEntity;
import com.soft.blued.ui.tag_show.UserTagCombineFragment;
import com.soft.blued.ui.user.fragment.FollowedAndFansFragment;
import com.soft.blued.ui.user.fragment.InterestGalleryFragment;
import com.soft.blued.ui.user.fragment.PayPreOrderFragment;
import com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.fragment.VIPBuyFragment;
import com.soft.blued.ui.user.fragment.VIPCenterNewFragment;
import com.soft.blued.ui.user.model.GoodsOptionBasic;
import com.soft.blued.ui.user.model.VerifyStatus;
import com.soft.blued.ui.user.observer.FollowAndFansSelectedTabObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.video.fragment.VideoScanFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.ui.yy_room.fragment.YYChatRoomsFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.CalendarProviderUtil;
import com.soft.blued.utils.FlutterRouter;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class BluedURIRouterAdapter {
  private static final String TAG = BluedURIRouterAdapter.class.getSimpleName();
  
  public static boolean addCalendarEvent(Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3) {
    CalendarProviderUtil.a(paramContext, paramString1, paramString2, paramLong1 * 1000L, paramLong2 * 1000L, paramLong3, paramInt1, paramInt2, paramInt3);
    return true;
  }
  
  public static boolean buyLiveLiang(Context paramContext, String paramString, int paramInt, long paramLong) {
    LiveLiangPayFragment.a(paramContext, paramString, paramInt, paramLong);
    return true;
  }
  
  public static boolean checkCloseAccountResult(Context paramContext, String paramString) {
    UserRelationshipUtils.a(paramContext, paramString);
    return true;
  }
  
  public static boolean commonPay(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, int paramInt5, String paramString4) {
    GoodsOptionBasic goodsOptionBasic = new GoodsOptionBasic();
    goodsOptionBasic.id = paramInt1;
    goodsOptionBasic.c_id = paramInt4;
    goodsOptionBasic.feed_id = paramString4;
    goodsOptionBasic.alipay_contract = paramInt2;
    goodsOptionBasic.wx_contract = paramInt3;
    paramString4 = paramString2;
    if (TextUtils.equals(paramString2, "mine_shadow"))
      paramString4 = paramString3; 
    if (paramInt5 != 1) {
      if (paramInt5 != 2) {
        if (paramInt5 != 3) {
          if (paramInt5 != 4) {
            PayPreOrderFragment.a(paramContext, goodsOptionBasic, paramString1, paramString4, 0);
            return true;
          } 
          PayPreOrderFragment.a(paramContext, goodsOptionBasic, paramString1, paramString4, 3);
          return true;
        } 
        PayPreOrderFragment.a(paramContext, goodsOptionBasic, paramString1, paramString4, 4);
        return true;
      } 
      PayPreOrderFragment.a(paramContext, goodsOptionBasic, paramString1, paramString4, 2);
      return true;
    } 
    PayPreOrderFragment.a(paramContext, goodsOptionBasic, paramString1, paramString4, 1);
    return true;
  }
  
  public static boolean downloadedEmotionPack(Context paramContext, String paramString) {
    if (!TextUtils.isEmpty(paramString))
      EmotionManager.a(paramString); 
    return true;
  }
  
  public static boolean exposurePaidCallback(Context paramContext, int paramInt, String paramString) {
    if (paramInt == 1 && !BluedPreferences.ey().equals(paramString)) {
      BluedPreferences.az(paramString);
      MobEventUtils.a();
    } 
    if (paramInt == 1) {
      LiveEventBus.get("close_flutter").post(Boolean.valueOf(true));
      PayUtils.a(paramContext, "", paramString);
    } 
    return true;
  }
  
  public static boolean goBuyBeansFromLiving(Context paramContext, int paramInt) {
    LiveRefreshUIObserver.a().a(paramInt);
    return true;
  }
  
  public static boolean goBuyCallCharge(Context paramContext, String paramString) {
    EventTrackGuy.a(paramString);
    PrivilegeBuyDialogFragment.a(paramContext, 9, paramString);
    return true;
  }
  
  public static boolean goCallOpen(Context paramContext, int paramInt) {
    HelloOpenDialogFragment.a(paramContext, paramInt, 0);
    return true;
  }
  
  public static boolean goChatAndOpenMsgBox(FragmentManager paramFragmentManager, int paramInt) {
    MsgBoxSettingDialogFragment msgBoxSettingDialogFragment = new MsgBoxSettingDialogFragment();
    Bundle bundle = new Bundle();
    bundle.putInt("vipFrom", paramInt);
    msgBoxSettingDialogFragment.setArguments(bundle);
    msgBoxSettingDialogFragment.show(paramFragmentManager, "");
    return true;
  }
  
  public static boolean liveGiftPackageBack(Context paramContext, String paramString, int paramInt) {
    LiveRefreshUIObserver.a().a(paramString, paramInt);
    return true;
  }
  
  public static boolean openAbout(Context paramContext) {
    TerminalActivity.d(paramContext, AboutBluedFragment.class, null);
    return true;
  }
  
  public static boolean openAppIconChange(Context paramContext) {
    ChangeBluedIconFragment.a(paramContext);
    return true;
  }
  
  public static boolean openAvChatDial(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2) {
    try {
      ChannelModel channelModel = new ChannelModel();
      if (paramInt1 != 1) {
        if (paramInt1 != 2)
          return false; 
        channelModel.callType = 0;
      } else {
        channelModel.callType = 1;
      } 
      channelModel.remoteUid = Integer.valueOf(EncryptTool.a(paramString1)).intValue();
      channelModel.remoteUserName = URLDecoder.decode(paramString2, "UTF-8");
      channelModel.remoteUserHead = URLDecoder.decode(paramString3, "UTF-8");
      DialogSkipFragment.a(paramContext, channelModel);
      return true;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
      return false;
    } 
  }
  
  public static boolean openAvChatReceive(Context paramContext, long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3) {
    try {
      ChannelModel channelModel = new ChannelModel();
      if (paramInt1 != 1) {
        if (paramInt1 != 2)
          return false; 
        channelModel.callType = 2;
      } else {
        channelModel.callType = 3;
      } 
      channelModel.channelId = paramString1;
      channelModel.remoteUid = Integer.valueOf(EncryptTool.a(paramString2)).intValue();
      channelModel.remoteUserName = URLDecoder.decode(paramString3, "UTF-8");
      channelModel.remoteUserHead = URLDecoder.decode(paramString4, "UTF-8");
      channelModel.chat_sdk_type = paramInt2;
      if (System.currentTimeMillis() / 1000L - paramLong < 60L) {
        DialogSkipFragment.a(paramContext, channelModel);
        return true;
      } 
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
    } 
    return false;
  }
  
  public static boolean openBaseExplore(Context paramContext) {
    CircleTypeListFragment.e.a(paramContext, CircleConstants.CIRCLE_FROM_PAGE.LINK, CircleConstants.CIRCLE_FROM_PAGE.LINK);
    return true;
  }
  
  @Deprecated
  public static boolean openBluedPay(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {
    SDKPayFragment.a(paramContext, 0L, paramInt, null, null, paramString1, paramString2, paramString3, paramString4);
    return true;
  }
  
  public static boolean openChargePage(Context paramContext, int paramInt) {
    BeansPrePayFragment.a(paramContext, paramInt);
    return true;
  }
  
  public static boolean openCircleApplyJoin(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt) {
    boolean bool;
    paramString1 = EncryptTool.a(paramString1);
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    CircleMethods.joinCircle(paramContext, paramString1, paramString3, paramString2, bool, true);
    return true;
  }
  
  public static boolean openCircleDetail(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3) {
    paramString = EncryptTool.a(paramString);
    if (paramInt2 != 1)
      CircleNewFragment.a(paramContext); 
    CircleDetailsFragment.a(paramContext, paramString, paramInt1, CircleConstants.CIRCLE_FROM_PAGE.LINK, paramInt3);
    return true;
  }
  
  public static boolean openCirclePage(Context paramContext) {
    CircleNewFragment.a(paramContext);
    return true;
  }
  
  public static boolean openCirclePost(Context paramContext, String paramString1, String paramString2, String paramString3) {
    CircleAddPostFragment.a(paramContext, EncryptTool.a(paramString1), paramString2, paramString3);
    return true;
  }
  
  public static boolean openCirclePostDetail(Context paramContext, String paramString1, String paramString2, int paramInt) {
    if (!TextUtils.isEmpty(paramString1))
      CircleDetailsFragment.a(paramContext, paramString1, 0, CircleConstants.CIRCLE_FROM_PAGE.LINK, paramInt); 
    CirclePostDetailsFragment.a(paramContext, paramString2, FeedProtos.NoteSource.CIRCLE_HOT);
    return true;
  }
  
  public static boolean openDiscoveryNotice(Context paramContext) {
    Bundle bundle = new Bundle();
    bundle.putString("to_message_tab", "0");
    HomeArgumentHelper.a(paramContext, "msg", bundle);
    return true;
  }
  
  public static boolean openDiscoveryNoticeZan(Context paramContext) {
    Bundle bundle = new Bundle();
    bundle.putString("to_message_tab", "0");
    HomeArgumentHelper.a(paramContext, "msg", bundle);
    return true;
  }
  
  public static boolean openDiscoveryPage(Context paramContext, int paramInt1, int paramInt2) {
    HomeArgumentHelper.a(paramContext, "feed", null);
    AppInfo.n().postDelayed(new Runnable(paramInt1) {
          public void run() {
            if (HomeActivity.c != null)
              ((DiscoverSquareViewModel)ViewModelProviders.of((FragmentActivity)HomeActivity.c).get(DiscoverSquareViewModel.class)).a.postValue(Integer.valueOf(this.a)); 
          }
        },  500L);
    return true;
  }
  
  public static boolean openEmotionShop(Context paramContext, int paramInt) {
    FlutterRouter.a(paramContext, paramInt);
    return true;
  }
  
  public static boolean openFans(Context paramContext) {
    LiveJoinFansFragment.a(paramContext);
    return true;
  }
  
  public static boolean openFeedDetailPage(Context paramContext, String paramString, int paramInt) {
    if (!TextUtils.isEmpty(paramString)) {
      BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
      bluedIngSelfFeed.feed_id = paramString;
      bluedIngSelfFeed.is_ads = paramInt;
      FeedDetailsFragment.a(paramContext, bluedIngSelfFeed, 7, 0);
      return true;
    } 
    return false;
  }
  
  public static boolean openFeedPost(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {
    String str;
    try {
      paramString4 = URLDecoder.decode(paramString4, "UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      str = "";
    } 
    ShareEntity shareEntity = new ShareEntity();
    shareEntity.content = paramString1;
    shareEntity.netImgUrl = paramString2;
    shareEntity.shareType = 1;
    boolean bool = paramContext instanceof Activity;
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool) {
      if (paramInt == 1)
        bool1 = true; 
      FeedPostFragment.a(paramContext, shareEntity, paramString3, str, bool1);
      return true;
    } 
    if (BluedApplicationLike.getForeActivity() != null) {
      Activity activity = BluedApplicationLike.getForeActivity();
      bool1 = bool2;
      if (paramInt == 1)
        bool1 = true; 
      FeedPostFragment.a((Context)activity, shareEntity, paramString3, str, bool1);
      return true;
    } 
    return false;
  }
  
  public static boolean openFeedback(Context paramContext) {
    FeedbackFragment.a(paramContext);
    return true;
  }
  
  public static boolean openFlashVideo(Context paramContext) {
    return true;
  }
  
  public static boolean openFlutterFeedExposure(Context paramContext, String paramString1, String paramString2) {
    FlutterRouter.a(paramContext, EncryptTool.a(paramString1), paramString2);
    return true;
  }
  
  public static boolean openFollowAndFans(Context paramContext, int paramInt) {
    FollowedAndFansFragment.a(paramContext, UserInfo.a().i().getUid());
    AppInfo.n().postDelayed(new Runnable(paramInt) {
          public void run() {
            FollowAndFansSelectedTabObserver.a().a(this.a);
          }
        },  500L);
    return true;
  }
  
  public static boolean openGameHall(Context paramContext) {
    GameCenterProxy.a().a(paramContext, null);
    return true;
  }
  
  public static boolean openGroupInfoPage(Context paramContext, String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      GroupInfoFragment.a(paramContext, paramString);
      return true;
    } 
    return false;
  }
  
  public static boolean openGroupNotification(Context paramContext) {
    Bundle bundle = new Bundle();
    bundle.putString("arg_open_homeactivity_ope", "ope_group_notification");
    bundle.putString("to_message_tab", "0");
    HomeArgumentHelper.a(paramContext, "msg", bundle);
    return true;
  }
  
  public static boolean openHelloDetail(Context paramContext, String paramString) {
    if (!StringUtils.e(paramString))
      try {
        HelloFragment.a(paramContext, URLDecoder.decode(paramString, "UTF-8"));
        return true;
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
      }  
    return false;
  }
  
  public static boolean openHelpCenter(Context paramContext) {
    HelpCenterFragment.a(paramContext);
    return true;
  }
  
  public static boolean openHomePageToLiveList(Context paramContext, int paramInt, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("arg_open_homeactivity_ope", "ope_livelist");
    bundle.putString("live_from", "web");
    HomeArgumentHelper.a(paramContext, "live", bundle);
    AppInfo.n().postDelayed(new Runnable(paramString) {
          public void run() {
            LiveTagsSetSelectedTab.a().a(this.a);
          }
        },  1000L);
    return true;
  }
  
  public static boolean openHomepageMessage(Context paramContext) {
    HomeArgumentHelper.a(paramContext, "msg", null);
    return true;
  }
  
  public static boolean openHomepageMine(Context paramContext) {
    HomeArgumentHelper.a(paramContext, "mine", null);
    return true;
  }
  
  @Deprecated
  public static boolean openHotMan(Context paramContext) {
    NearbyModuleUsersFragment.a(paramContext);
    return true;
  }
  
  public static boolean openLangRenSha(Context paramContext) {
    return true;
  }
  
  public static boolean openLangeageSetting(Context paramContext) {
    LanguageSelectFragment.a(paramContext);
    return true;
  }
  
  public static boolean openLiveApply(Context paramContext) {
    TerminalActivity.d(paramContext, LiveApplyFragment.class, null);
    return true;
  }
  
  public static boolean openLiveHB(Context paramContext) {
    FlutterRouter.b(paramContext);
    return true;
  }
  
  public static boolean openLiveImprovePage(Context paramContext) {
    LiveApplyImproveFragment.a(paramContext);
    return true;
  }
  
  public static boolean openLivePlayPage(Context paramContext, long paramLong, String paramString1, String paramString2) {
    if (LiveRoomManager.a().C())
      return true; 
    Bundle bundle = new Bundle();
    bundle.putString("arg_open_homeactivity_ope", "ope_liveplay");
    bundle.putSerializable("live_anchor_model", (Serializable)new LiveRoomData(paramLong, 0, paramString2, paramString1, "", "", 0));
    HomeArgumentHelper.a(paramContext, "live", bundle);
    return true;
  }
  
  public static boolean openLiveRecommendMore(Context paramContext) {
    FlutterRouter.a(paramContext);
    return true;
  }
  
  public static boolean openLiveSimplePage(Context paramContext) {
    LiveApplySimpleFragment.a(paramContext, null);
    return true;
  }
  
  public static boolean openMapFind(Context paramContext) {
    AppInfo.n().postDelayed(new Runnable(paramContext) {
          public void run() {
            Activity activity;
            Context context = this.a;
            if (ActivityMgr.INST.getLastActivity() != null)
              activity = ActivityMgr.INST.getLastActivity(); 
            if (activity instanceof FragmentActivity) {
              Bundle bundle = new Bundle();
              TransparentActivity.a(bundle);
              FindSearchMapDialogFragment findSearchMapDialogFragment = new FindSearchMapDialogFragment();
              findSearchMapDialogFragment.setArguments(bundle);
              findSearchMapDialogFragment.show(((FragmentActivity)activity).getSupportFragmentManager(), "");
            } 
          }
        }200L);
    return true;
  }
  
  public static boolean openModifyProfile(Context paramContext, int paramInt) {
    boolean bool;
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    ModifyUserInfoFragment.a(paramContext, bool);
    return true;
  }
  
  public static boolean openMyBlacklist(Context paramContext) {
    TerminalActivity.d(paramContext, BlacklistFragment.class, null);
    return true;
  }
  
  public static boolean openMyGroup(Context paramContext) {
    TerminalActivity.d(paramContext, UserGroupListsFragment.class, null);
    return true;
  }
  
  public static boolean openNativeVIPCenter(Context paramContext, String paramString1, String paramString2) {
    if (StringUtils.e(paramString1)) {
      VIPCenterNewFragment.a(paramContext, -1, paramString2);
      return true;
    } 
    int i = SafeUtils.a(paramString1);
    if (i == 0 || i == 1) {
      i = 0;
      VIPCenterNewFragment.a(paramContext, i, paramString2);
      return true;
    } 
    i = 1;
    VIPCenterNewFragment.a(paramContext, i, paramString2);
    return true;
  }
  
  public static boolean openNearbyHomeTab(Context paramContext, int paramInt, String paramString) {
    HomeArgumentHelper.a(paramContext, "find", null);
    AppInfo.n().postDelayed(new Runnable(paramInt) {
          public void run() {
            NearbyFindSetSelectedTab.a().a(this.a);
          }
        },  500L);
    if (!TextUtils.isEmpty(paramString))
      AppInfo.n().postDelayed(new Runnable(paramString) {
            public void run() {
              NearbyPeopleTabSelectedObserver.a().a(this.a);
            }
          },  1000L); 
    return true;
  }
  
  public static boolean openNearbyModule(Context paramContext, int paramInt, String paramString) {
    if (paramInt == 0) {
      NearbyLiveFragment.a(paramContext);
    } else {
      String str;
      try {
        paramString = URLDecoder.decode(paramString, "UTF-8");
      } catch (Exception exception) {
        str = "";
      } 
      NearbyModuleUsersFragment.a(paramContext, paramInt, str);
    } 
    return true;
  }
  
  public static boolean openNearbyPage(Context paramContext, int paramInt) {
    HomeArgumentHelper.a(paramContext, "find", null);
    AppInfo.n().postDelayed(new Runnable(paramInt) {
          public void run() {
            NearbyFindSetSelectedTab.a().a(this.a);
          }
        },  500L);
    return true;
  }
  
  public static boolean openNewFans(Context paramContext) {
    ChatHelperV4.a().a(paramContext, 5L, 0L);
    return true;
  }
  
  public static boolean openNotificationSetting(Context paramContext) {
    TerminalActivity.d(paramContext, RemindSettingFragment.class, null);
    return true;
  }
  
  public static boolean openPasswordSetting(Context paramContext) {
    TerminalActivity.d(paramContext, PasswordSettingFragment.class, null);
    return true;
  }
  
  public static boolean openPasswordSettingPage(Context paramContext) {
    TerminalActivity.d(paramContext, PasswordSettingFragment.class, null);
    return true;
  }
  
  public static boolean openPersonalVerifyPage(Context paramContext) {
    String str1 = UserInfo.a().i().getAvatar();
    String str2 = UserInfo.a().i().getName();
    String str3 = UserInfo.a().i().getUid();
    VerifyStatus[] arrayOfVerifyStatus = UserInfo.a().i().getVerify();
    if (arrayOfVerifyStatus != null && arrayOfVerifyStatus.length > 0 && "1".equals((arrayOfVerifyStatus[0]).has_audited)) {
      ShowVerifyFragment.a(paramContext, str2, str1, (arrayOfVerifyStatus[0]).verified_time, str3, false);
    } else {
      PersonalVerifyFragment.a(paramContext);
    } 
    return true;
  }
  
  public static boolean openPictureLib(Context paramContext, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("tab_id", paramString);
    TerminalActivity.d(paramContext, InterestGalleryFragment.class, bundle);
    return true;
  }
  
  public static boolean openPrivacySetting(Context paramContext) {
    TerminalActivity.d(paramContext, PrivacySettingFragment.class, null);
    return true;
  }
  
  public static boolean openRightOption(Context paramContext) {
    VIPCenterNewFragment.a(paramContext, -1, "");
    return true;
  }
  
  public static boolean openScanPage(Context paramContext) {
    ShineVideoListFragment.a(paramContext);
    return true;
  }
  
  public static boolean openSearchGroup(Context paramContext, String paramString) {
    GroupSearchListFragment.a(paramContext, paramString);
    return true;
  }
  
  public static boolean openSetting(Context paramContext) {
    SettingFragment.a(paramContext);
    return true;
  }
  
  public static boolean openShadowSetting(Context paramContext) {
    FindSearchMapActivity.a(paramContext, 1);
    return true;
  }
  
  public static boolean openShineVideoDetail(Context paramContext, String paramString) {
    VideoScanFragment.a(paramContext, paramString);
    return true;
  }
  
  public static boolean openShineVideoList(Context paramContext) {
    ShineVideoListIndepFragment.a(paramContext);
    return true;
  }
  
  public static boolean openStartLive(Context paramContext, int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2) {
    RecordingOnliveFragment.a(paramContext, paramInt1, paramInt2, paramString1, paramInt3, paramString2);
    return true;
  }
  
  public static boolean openTagCombine(Context paramContext, String paramString1, String paramString2, int paramInt) {
    String str;
    try {
      paramString2 = URLDecoder.decode(paramString2, "UTF-8");
    } catch (Exception exception) {
      str = "";
    } 
    UserTagCombineFragment.a(paramContext, paramString1, str, paramInt);
    return true;
  }
  
  public static boolean openTopicPage(Context paramContext) {
    SuperTopicFragment.a(paramContext);
    return true;
  }
  
  public static boolean openTopicPage(Context paramContext, String paramString1, String paramString2) {
    if (LiveRoomManager.a().C())
      return true; 
    if (!TextUtils.isEmpty(paramString1)) {
      SuperTopicDetailFragment.a(paramContext, paramString1);
      return true;
    } 
    if (!TextUtils.isEmpty(paramString2)) {
      String str;
      try {
        paramString1 = URLDecoder.decode(paramString2, "UTF-8");
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        str = "";
      } 
      SuperTopicDetailFragment.b(paramContext, str);
      return true;
    } 
    return false;
  }
  
  public static boolean openUserInfoPage(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3) {
    UserBasicModel userBasicModel;
    if (LiveRoomManager.a().C())
      return true; 
    String str = paramString1;
    if (paramInt1 == 1) {
      str = paramString1;
      if (!TextUtils.isEmpty(paramString1))
        str = EncryptTool.a(paramString1); 
    } 
    if (!TextUtils.isEmpty(str)) {
      Bundle bundle = new Bundle();
      userBasicModel = new UserBasicModel();
      userBasicModel.uid = str;
      bundle.putSerializable("user", (Serializable)userBasicModel);
      bundle.putString("userfrom", paramString3);
      bundle.putInt("tab", paramInt2);
      TerminalActivity.a(bundle);
      TerminalActivity.d(paramContext, UserInfoFragmentNew.class, bundle);
      return true;
    } 
    if (!TextUtils.isEmpty((CharSequence)userBasicModel)) {
      String str1;
      Bundle bundle = new Bundle();
      try {
        paramString1 = URLDecoder.decode((String)userBasicModel, "UTF-8");
      } catch (Exception exception) {
        str1 = "";
      } 
      bundle.putString("nickname", str1);
      bundle.putBoolean("if_from_name", true);
      bundle.putString("userfrom", paramString3);
      bundle.putInt("tab", paramInt2);
      TerminalActivity.a(bundle);
      TerminalActivity.d(paramContext, UserInfoFragmentNew.class, bundle);
      return true;
    } 
    return false;
  }
  
  public static boolean openVIPBuyDialog(Context paramContext, int paramInt, String paramString) {
    return true;
  }
  
  public static boolean openVIPBuyPage(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic e : (Ljava/lang/String;)Z
    //   4: istore #9
    //   6: iconst_m1
    //   7: istore #8
    //   9: iload #9
    //   11: ifne -> 26
    //   14: aload_1
    //   15: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   18: invokevirtual intValue : ()I
    //   21: istore #6
    //   23: goto -> 29
    //   26: iconst_m1
    //   27: istore #6
    //   29: iload #8
    //   31: istore #7
    //   33: aload #5
    //   35: invokestatic e : (Ljava/lang/String;)Z
    //   38: ifne -> 51
    //   41: aload #5
    //   43: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   46: invokevirtual intValue : ()I
    //   49: istore #7
    //   51: aload_0
    //   52: iload #6
    //   54: aload #4
    //   56: iload #7
    //   58: getstatic com/blued/das/vip/VipProtos$FromType.UNKNOWN_FROM : Lcom/blued/das/vip/VipProtos$FromType;
    //   61: invokestatic a : (Landroid/content/Context;ILjava/lang/String;ILcom/blued/das/vip/VipProtos$FromType;)V
    //   64: iconst_1
    //   65: ireturn
    //   66: astore_1
    //   67: goto -> 26
    //   70: astore_1
    //   71: iload #8
    //   73: istore #7
    //   75: goto -> 51
    // Exception table:
    //   from	to	target	type
    //   14	23	66	java/lang/Exception
    //   41	51	70	java/lang/Exception
  }
  
  public static boolean openVIPBuyWithCoupon(Context paramContext, int paramInt, String paramString) {
    VIPBuyFragment.a(paramContext, paramInt, paramString, -1, VipProtos.FromType.UNKNOWN_FROM, true);
    return true;
  }
  
  public static boolean openVRVideo(Context paramContext) {
    Activity activity;
    Context context;
    if (paramContext instanceof android.app.Application) {
      if (BluedApplicationLike.getForeActivity() == null)
        return true; 
      activity = BluedApplicationLike.getForeActivity();
    } else {
      context = activity.getApplicationContext();
    } 
    ShortVideoProxy.e().b(context, 0, 0);
    return true;
  }
  
  public static boolean openVipLevel(Context paramContext) {
    FlutterRouter.c(paramContext);
    return true;
  }
  
  public static boolean openVisitRecord(Context paramContext, int paramInt) {
    TerminalActivity.d(paramContext, VisitHistoryFragment.class, null);
    AppInfo.n().postDelayed(new Runnable(paramInt) {
          public void run() {
            VisitRecordSelectedTabObserver.a().a(this.a);
          }
        },  500L);
    return true;
  }
  
  public static boolean openWawaGame(Context paramContext) {
    return true;
  }
  
  public static boolean openWawaRoom(Context paramContext, int paramInt) {
    return true;
  }
  
  public static boolean openWebView(Context paramContext, String paramString, int paramInt) {
    WebViewShowInfoFragment.show(paramContext, paramString, paramInt);
    return true;
  }
  
  public static boolean openYYApplyPage(Context paramContext) {
    YYApplyFragment.a(paramContext);
    return true;
  }
  
  public static boolean openYYChatRoom(Context paramContext, String paramString1, String paramString2) {
    AppInfo.n().postDelayed(new Runnable(paramContext, paramString1, paramString2) {
          public void run() {
            Activity activity;
            Context context = this.a;
            if (ActivityMgr.INST.getLastActivity() != null)
              activity = ActivityMgr.INST.getLastActivity(); 
            if (activity instanceof BaseFragmentActivity)
              YYRoomInfoManager.d().a((BaseFragmentActivity)activity, this.b, this.c); 
          }
        }200L);
    return true;
  }
  
  public static boolean openYYChatRoomList(Context paramContext, String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "web_chat_room"; 
    YYChatRoomsFragment.a(paramContext, str);
    return true;
  }
  
  public static boolean openYYImprovePage(Context paramContext) {
    LiveYYImproveFragment.a(paramContext);
    return true;
  }
  
  public static boolean promotionBeansPay(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9) {
    GoodsOptionBasic goodsOptionBasic = new GoodsOptionBasic();
    goodsOptionBasic.id = paramInt1;
    goodsOptionBasic.feed_id = paramString3;
    goodsOptionBasic.trade_type = paramString4;
    goodsOptionBasic.beans = paramInt2;
    goodsOptionBasic.aim = paramString5;
    goodsOptionBasic.promotion_type = paramString6;
    goodsOptionBasic.role = paramString7;
    goodsOptionBasic.age = paramString8;
    goodsOptionBasic.area = paramString9;
    PayPreOrderFragment.a(paramContext, goodsOptionBasic, paramString1, paramString2, 3);
    return true;
  }
  
  public static boolean removeEmotionPack(Context paramContext, String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1))
      EmotionManager.b(paramString1); 
    return true;
  }
  
  public static boolean showTaskFloatView(Context paramContext, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3) {
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("showTaskFloatView :jump_url: ");
    stringBuilder.append(paramString2);
    Logger.c(str, new Object[] { stringBuilder.toString() });
    if (!TextUtils.isEmpty(paramString2)) {
      Uri uri = BluedURIRouter.a().d(paramString2);
      if (uri != null) {
        BluedURIRouter.a().a(paramContext, uri);
      } else {
        WebViewShowInfoFragment.show(paramContext, paramString2, -1);
      } 
    } 
    GlobalTaskFloatManager.TaskInfo taskInfo = new GlobalTaskFloatManager.TaskInfo();
    taskInfo.task_id = paramInt1;
    taskInfo.task_name = paramString1;
    taskInfo.max = paramInt2;
    if (paramInt1 == 26) {
      taskInfo.progress = paramInt2;
    } else {
      taskInfo.progress = paramInt3;
    } 
    taskInfo.back_url = paramString3;
    GlobalTaskFloatManager.a().b(taskInfo);
    return true;
  }
  
  public static boolean startVIPPay(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    paramString2 = EncryptTool.a(paramString2);
    GoodsOptionBasic goodsOptionBasic = new GoodsOptionBasic();
    goodsOptionBasic.id = Integer.valueOf(paramString1).intValue();
    paramString1 = paramString5;
    if (TextUtils.isEmpty(paramString5))
      paramString1 = "my"; 
    PayPreOrderFragment.a(paramContext, goodsOptionBasic, paramString1, paramString2, paramString3, paramString4, paramString6);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\similarity_operation_provider\BluedURIRouterAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */