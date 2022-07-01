package com.soft.blued.ui.live;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.model.DecryptJson;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFansRelationForShareModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.shortvideo.permission.PermissionHelper;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.message.MessageProtos;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.feed.fragment.LiveClipPhotoFragment;
import com.soft.blued.ui.find.model.FindRecommendData;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.live.fragment.LiveApplyImproveFragment;
import com.soft.blued.ui.live.fragment.ShareWithContactFragment;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.pay.BeansPrePayFragment;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.BaseShareToPlatform;
import com.soft.blued.ui.share_custom.Model.BaseShareEntity;
import com.soft.blued.ui.share_custom.Model.ShareEntity;
import com.soft.blued.ui.share_custom.ShareToPlatform;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.NetworkUtils;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.ShareCoreUtils;
import com.soft.blued.utils.ShareUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

public class LiveRoomInfoChannel {
  public static List<LiveRoomData> a(List<BluedLiveListData> paramList, String paramString) {
    ArrayList<LiveRoomData> arrayList = new ArrayList();
    if (paramList != null)
      for (BluedLiveListData bluedLiveListData : paramList) {
        boolean bool;
        String str2;
        String str3;
        String str1 = bluedLiveListData.uid;
        UserBasicModel userBasicModel = bluedLiveListData.anchor;
        if (userBasicModel != null) {
          String str = str1;
          if (TextUtils.isEmpty(str1))
            str = userBasicModel.uid; 
          str2 = userBasicModel.name;
          str3 = userBasicModel.avatar;
          bool = userBasicModel.vbadge;
          str1 = str;
          str = str3;
          str3 = str;
        } else {
          String str = str1;
          str2 = "";
          str3 = str2;
          bool = false;
          str1 = str;
        } 
        LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(bluedLiveListData.lid, 0L), bluedLiveListData.screen_pattern, paramString, str1, str2, str3, bool);
        if (!TextUtils.isEmpty(bluedLiveListData.live_play))
          liveRoomData.live_url = bluedLiveListData.live_play; 
        arrayList.add(liveRoomData);
      }  
    return arrayList;
  }
  
  public static void a() {
    if (!LiveRoomInfo.b())
      LiveRoomInfo.a().a(c()); 
  }
  
  public static void a(Context paramContext, LiveRoomData paramLiveRoomData) {
    a(paramContext, paramLiveRoomData, -1, new ArrayList<LiveRoomData>());
  }
  
  public static void a(Context paramContext, LiveRoomData paramLiveRoomData, int paramInt, List<LiveRoomData> paramList) {
    if (AudioChannelManager.e().h()) {
      AppMethods.a(paramContext.getResources().getText(2131759450));
      return;
    } 
    a();
    PlayingOnliveFragment.a(paramContext, paramLiveRoomData, paramInt, paramList);
  }
  
  private static UserRelationshipUtils.IAddOrRemoveAttentionDone b(LiveUserRelationshipUtils.IAddOrRemoveAttentionDone paramIAddOrRemoveAttentionDone) {
    return new UserRelationshipUtils.IAddOrRemoveAttentionDone(paramIAddOrRemoveAttentionDone) {
        public void a() {
          this.a.R_();
        }
        
        public void a(String param1String) {
          this.a.a(param1String);
        }
        
        public void b() {
          this.a.d();
        }
        
        public void b(String param1String) {
          this.a.b(param1String);
        }
        
        public void c() {
          this.a.e();
        }
      };
  }
  
  public static List<LiveRoomData> b(List<FindRecommendData> paramList, String paramString) {
    ArrayList<LiveRoomData> arrayList = new ArrayList();
    if (paramList != null)
      for (FindRecommendData findRecommendData : paramList) {
        int i = findRecommendData.uid;
        arrayList.add(new LiveRoomData(StringUtils.a(findRecommendData.live, 0L), 0, paramString, String.valueOf(i), "", "", 0));
      }  
    return arrayList;
  }
  
  private static ILiveRoomInfoCallBack c() {
    return new ILiveRoomInfoCallBack() {
        public String A() {
          return H5Url.a(53);
        }
        
        public String B() {
          return H5Url.a(58);
        }
        
        public boolean C() {
          return FlexDebugSevConfig.a().e();
        }
        
        public boolean D() {
          return BluedConfig.b().J();
        }
        
        public CharSequence a(CharSequence param1CharSequence, String param1String, LiveRoomConstants.ClickAtLinkListener param1ClickAtLinkListener) {
          return StringUtils.a(param1CharSequence, true, false, false, new TypefaceUtils.ClickAtLinkListener(this, param1ClickAtLinkListener) {
                public void a(String param2String1, String param2String2) {
                  this.a.a(param2String1, param2String2);
                }
              }true, param1String, "");
        }
        
        public String a() {
          return UserInfo.a().i().getName();
        }
        
        public String a(Context param1Context, TextView param1TextView, String param1String) {
          return UserRelationshipUtils.a(param1Context, param1TextView, param1String);
        }
        
        public String a(String param1String) {
          return AreaUtils.a(param1String, BlueAppLocal.c());
        }
        
        public String a(String param1String, boolean param1Boolean) {
          return StringUtils.a(param1String, BlueAppLocal.c(), param1Boolean);
        }
        
        public void a(double param1Double) {
          UserInfo.a().a(param1Double);
        }
        
        public void a(int param1Int) {
          UserInfo.a().i().setRich_level(param1Int);
        }
        
        public void a(Activity param1Activity) {
          ActivityChangeAnimationUtils.i(param1Activity);
        }
        
        public void a(Context param1Context) {
          HomeArgumentHelper.a(param1Context, "live", null);
        }
        
        public void a(Context param1Context, int param1Int) {
          BeansPrePayFragment.a(param1Context, param1Int);
        }
        
        public void a(Context param1Context, TextView param1TextView, int param1Int1, int param1Int2) {
          TypefaceUtils.b(param1Context, param1TextView, param1Int1, param1Int2);
        }
        
        public void a(Context param1Context, TextView param1TextView, LiveRoomUserModel param1LiveRoomUserModel, int param1Int) {
          UserBasicModel userBasicModel = new UserBasicModel();
          userBasicModel.vip_grade = param1LiveRoomUserModel.vip_grade;
          userBasicModel.is_hide_vip_look = param1LiveRoomUserModel.is_hide_vip_look;
          userBasicModel.is_vip_annual = param1LiveRoomUserModel.is_vip_annual;
          UserRelationshipUtils.a(param1Context, param1TextView, userBasicModel, param1Int);
        }
        
        public void a(Context param1Context, PayOption._pay_list param1_pay_list, String param1String) {
          if (param1_pay_list == null)
            return; 
          BluedURIRouterAdapter.startVIPPay(param1Context, String.valueOf(param1_pay_list.id), "", "", "", param1String, param1String);
        }
        
        public void a(Context param1Context, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone param1IAddOrRemoveAttentionDone, String param1String1, String param1String2, IRequestHost param1IRequestHost) {
          UserHttpUtils.b(param1Context, LiveRoomInfoChannel.a(param1IAddOrRemoveAttentionDone), param1String1, param1String2, param1IRequestHost);
        }
        
        public void a(Context param1Context, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone param1IAddOrRemoveAttentionDone, String param1String1, String param1String2, String param1String3, IRequestHost param1IRequestHost, boolean param1Boolean) {
          UserRelationshipUtils.a(param1Context, LiveRoomInfoChannel.a(param1IAddOrRemoveAttentionDone), param1String1, param1String2, param1String3, param1IRequestHost, param1Boolean);
        }
        
        public void a(Context param1Context, LiveRoomData param1LiveRoomData, String param1String1, String param1String2, String param1String3, String param1String4, Bitmap param1Bitmap) {
          BaseShareEntity.ShareLiveData shareLiveData = new BaseShareEntity.ShareLiveData();
          shareLiveData.a = UserInfo.a().i().getName();
          shareLiveData.j = param1String2;
          shareLiveData.c = param1String3;
          shareLiveData.d = UserInfo.a().i().getAvatar();
          shareLiveData.e = param1Bitmap;
          shareLiveData.f = UserInfo.a().i().getUid();
          shareLiveData.g = param1String1;
          shareLiveData.b = param1String4;
          ShareUtils.a().a(param1Context, shareLiveData);
        }
        
        public void a(Context param1Context, String param1String) {
          UserInfoFragmentNew.a(param1Context, LiveRoomManager.a().e(), "");
        }
        
        public void a(Context param1Context, String param1String, TextView param1TextView, ImageView param1ImageView, boolean param1Boolean) {
          UserRelationshipUtils.a(param1Context, param1String, param1TextView, param1ImageView, param1Boolean);
        }
        
        public void a(Context param1Context, String param1String1, String param1String2, long param1Long, IRequestHost param1IRequestHost) {
          MsgCommonUtils.a(param1Context, param1String1, param1String2, param1Long, param1IRequestHost);
        }
        
        public void a(Context param1Context, String param1String1, String param1String2, String param1String3, int param1Int1, int param1Int2) {
          UserBasicModel userBasicModel = new UserBasicModel();
          userBasicModel.uid = param1String1;
          userBasicModel.name = param1String2;
          userBasicModel.avatar = param1String3;
          userBasicModel.is_show_vip_page = param1Int1;
          if (param1Int2 == 1) {
            UserInfoFragmentNew.a(param1Context, userBasicModel, "", false, new MsgSourceEntity(MessageProtos.StrangerSource.LIVE, ""));
            return;
          } 
          if (param1Int2 == 2)
            UserInfoFragmentNew.a(param1Context, userBasicModel, "", false, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, "")); 
        }
        
        public void a(Context param1Context, String param1String1, String param1String2, String param1String3, String param1String4) {
          ShareEntity shareEntity = new ShareEntity();
          shareEntity.flag = 1;
          shareEntity.netImgUrl = param1String1;
          shareEntity.linkUrl = param1String2;
          shareEntity.fileUrl = param1String1;
          shareEntity.title = param1String3;
          shareEntity.content = param1String4;
          shareEntity.mainBody = param1String4;
          shareEntity.shareType = 0;
          shareEntity.shareFrom = 6;
          BaseShareToPlatform.PopWindowSetting popWindowSetting = new BaseShareToPlatform.PopWindowSetting();
          popWindowSetting.a = true;
          popWindowSetting.b = false;
          (new ShareToPlatform(param1Context, null, popWindowSetting, null)).b(shareEntity);
        }
        
        public void a(Context param1Context, boolean param1Boolean, LiveRoomData param1LiveRoomData, Bitmap param1Bitmap, String param1String) {
          BaseShareEntity.ShareLiveData shareLiveData = new BaseShareEntity.ShareLiveData();
          shareLiveData.i = param1Boolean;
          shareLiveData.a = "";
          shareLiveData.d = "";
          shareLiveData.f = "";
          if (!LiveRoomManager.a().l()) {
            shareLiveData.a = (LiveRoomManager.a().h()).profile.name;
            shareLiveData.d = (LiveRoomManager.a().h()).profile.avatar;
            shareLiveData.f = (LiveRoomManager.a().h()).profile.uid;
          } 
          shareLiveData.c = "";
          shareLiveData.e = param1Bitmap;
          if (param1LiveRoomData != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1LiveRoomData.lid);
            stringBuilder.append("");
            shareLiveData.h = stringBuilder.toString();
          } 
          shareLiveData.b = param1String;
          shareLiveData.l = new ShareOptionRecyclerAdapter.ShareOptionsItemClickListener(this, param1Boolean) {
              public void onItemClick(int param2Int) {
                LiveRoomInfoChannel.b();
                boolean bool2 = true;
                boolean bool1 = bool2;
                switch (param2Int) {
                  default:
                    bool1 = bool2;
                    break;
                  case 2131756078:
                  case 2131758767:
                    bool1 = false;
                    break;
                  case 2131758870:
                  case 2131758878:
                  case 2131758885:
                  case 2131758888:
                    break;
                } 
                if (this.a && bool1) {
                  LiveFloatManager.a().G();
                  LiveRefreshUIObserver.a().b(false);
                } 
              }
            };
          shareLiveData.k = new ShareCoreUtils.ShareBackLister(this, param1Boolean) {
              public void a(String param2String) {
                if (LiveFloatManager.a().B()) {
                  AppInfo.n().postDelayed(new Runnable(this) {
                        public void run() {
                          LiveSetDataObserver.a().m();
                        }
                      },  3000L);
                  return;
                } 
                LiveSetDataObserver.a().m();
              }
              
              public void b(String param2String) {}
              
              public void c(String param2String) {}
              
              public void d(String param2String) {
                if (this.a)
                  LiveFloatManager.a().s(); 
              }
            };
          ShareUtils.a().a(param1Context, shareLiveData);
        }
        
        public void a(Bitmap param1Bitmap, long param1Long, Context param1Context, KeyboardListenLinearLayout param1KeyboardListenLinearLayout) {
          ShareUtils.a().a(param1Bitmap, param1Long, param1Context, (View)param1KeyboardListenLinearLayout);
        }
        
        public void a(ImageView param1ImageView, int param1Int) {
          UserRelationshipUtils.a(param1ImageView, param1Int, 1);
        }
        
        public void a(ImageView param1ImageView, LiveRoomUserModel param1LiveRoomUserModel) {
          UserBasicModel userBasicModel = new UserBasicModel();
          userBasicModel.vip_grade = param1LiveRoomUserModel.vip_grade;
          userBasicModel.is_hide_vip_look = param1LiveRoomUserModel.is_hide_vip_look;
          userBasicModel.is_vip_annual = param1LiveRoomUserModel.is_vip_annual;
          userBasicModel.vip_exp_lvl = param1LiveRoomUserModel.vip_exp_lvl;
          UserRelationshipUtils.a(param1ImageView, userBasicModel);
        }
        
        public void a(ChattingModel param1ChattingModel1, ChattingModel param1ChattingModel2) {
          ReflectionUtils.a(param1ChattingModel1, param1ChattingModel2);
        }
        
        public void a(ChattingModel param1ChattingModel, boolean param1Boolean) {
          ChatHelperV4.a().a(param1ChattingModel, param1Boolean);
        }
        
        public void a(BaseFragment param1BaseFragment, String param1String1, String param1String2, int param1Int) {
          LiveClipPhotoFragment liveClipPhotoFragment = new LiveClipPhotoFragment();
          Bundle bundle = new Bundle();
          bundle.putString("photo_path", param1String2);
          bundle.putInt("select_photo", param1Int);
          bundle.putString("select_http_url", param1String1);
          liveClipPhotoFragment.setArguments(bundle);
          liveClipPhotoFragment.show(param1BaseFragment.getFragmentManager(), "liveMakeLoverOkDialog");
        }
        
        public void a(PermissionCallbacks param1PermissionCallbacks) {
          PermissionHelper.c(param1PermissionCallbacks);
        }
        
        public void a(RecordingOnliveFragment param1RecordingOnliveFragment, int param1Int1, int param1Int2, String param1String, String[] param1ArrayOfString) {
          ShareWithContactFragment.a((BaseFragment)param1RecordingOnliveFragment, param1Int1, 8, param1String, param1ArrayOfString);
        }
        
        public void a(String param1String, boolean param1Boolean, IRequestHost param1IRequestHost) {
          PayHttpUtils.a(param1String, Boolean.valueOf(param1Boolean), 1, new BluedUIHttpResponse<BluedEntityA<PayRemaining>>(this, param1IRequestHost) {
                protected void a(BluedEntityA<PayRemaining> param2BluedEntityA) {
                  if (param2BluedEntityA != null && param2BluedEntityA.data != null && param2BluedEntityA.data.size() > 0) {
                    if (BluedHttpUtils.a(param2BluedEntityA.code, param2BluedEntityA.message)) {
                      PayRemaining payRemaining = param2BluedEntityA.data.get(0);
                      try {
                        String str = AesCrypto.c(payRemaining._);
                        LiveRoomPreferences.c(((DecryptJson)AppInfo.f().fromJson(str, DecryptJson.class)).token);
                        return;
                      } catch (Exception exception) {
                        return;
                      } 
                    } 
                    AppMethods.d(2131756584);
                    return;
                  } 
                  AppMethods.d(2131756584);
                }
              }param1IRequestHost);
        }
        
        public boolean a(Context param1Context, View.OnClickListener param1OnClickListener) {
          return PopMenuUtils.a(param1Context, param1OnClickListener);
        }
        
        public String b() {
          return (UserInfo.a().i()).avatar;
        }
        
        public String b(String param1String, boolean param1Boolean) {
          return StringUtils.b(param1String, BlueAppLocal.c(), param1Boolean);
        }
        
        public void b(Context param1Context, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone param1IAddOrRemoveAttentionDone, String param1String1, String param1String2, IRequestHost param1IRequestHost) {
          UserHttpUtils.a(param1Context, LiveRoomInfoChannel.a(param1IAddOrRemoveAttentionDone), param1String1, param1String2, param1IRequestHost);
        }
        
        public void b(Context param1Context, String param1String) {
          WebViewShowInfoFragment.show(param1Context, param1String, -1);
        }
        
        public boolean b(Context param1Context) {
          return BluedApplicationLike.isMainApplication(AppInfo.d());
        }
        
        public boolean b(String param1String) {
          return UserRelationshipUtils.a(param1String);
        }
        
        public String c() {
          return (UserInfo.a().k() != null) ? (UserInfo.a().k()).avatar : "";
        }
        
        public String c(Context param1Context, String param1String) {
          return UserRelationshipUtils.c(param1Context, param1String);
        }
        
        public void c(Context param1Context) {
          LiveApplyImproveFragment.a(param1Context);
        }
        
        public String d() {
          return UserInfo.a().i().getUid();
        }
        
        public boolean e() {
          return BluedPreferences.cZ();
        }
        
        public String f() {
          return UserInfo.a().i().getAccess_token();
        }
        
        public int g() {
          return UserInfo.a().i().getRich_level();
        }
        
        public int h() {
          return UserInfo.a().i().getVBadge();
        }
        
        public boolean i() {
          return BluedHttpUrl.h();
        }
        
        public String j() {
          return BluedHttpUrl.n();
        }
        
        public String k() {
          return BluedHttpUrl.w();
        }
        
        public String l() {
          return NetworkUtils.d();
        }
        
        public String m() {
          return DeviceUtils.d();
        }
        
        public String n() {
          return BluedHttpUrl.o();
        }
        
        public boolean o() {
          int i = (UserInfo.a().i()).is_invisible_half;
          boolean bool = true;
          if (i != 1) {
            if ((UserInfo.a().i()).is_invisible_all == 1)
              return true; 
            bool = false;
          } 
          return bool;
        }
        
        public void p() {
          UserInfoDataObserver.a().b();
        }
        
        public boolean q() {
          return BluedApplicationLike.isAppOnForeground();
        }
        
        public boolean r() {
          return BluedConfig.b().g();
        }
        
        public boolean s() {
          return BluedConfig.b().x();
        }
        
        public String t() {
          return H5Url.a(25);
        }
        
        public String u() {
          return H5Url.a(10);
        }
        
        public String v() {
          return H5Url.a(24, new Object[] { EncryptTool.b(LiveRoomInfo.a().f()) });
        }
        
        public String w() {
          return H5Url.a(34);
        }
        
        public String x() {
          return H5Url.a(47);
        }
        
        public String y() {
          return H5Url.a(47);
        }
        
        public String z() {
          return H5Url.a(51);
        }
      };
  }
  
  private static void d() {
    LiveRoomHttpUtils.o(new BluedUIHttpResponse<BluedEntityA<LiveFansRelationForShareModel>>() {
          protected void a(BluedEntityA<LiveFansRelationForShareModel> param1BluedEntityA) {}
          
          public boolean onUIFailure(int param1Int, String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("postLiveFansRelationForShare fail:");
            stringBuilder.append(param1String);
            Log.i("xpp", stringBuilder.toString());
            return true;
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\LiveRoomInfoChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */