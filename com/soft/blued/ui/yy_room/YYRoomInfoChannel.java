package com.soft.blued.ui.yy_room;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.listener.ClickAtLinkListener;
import com.blued.android.module.yy_china.listener.IAddBlackListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.das.message.MessageProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.model.LogData;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.live.fragment.LiveYYImproveFragment;
import com.soft.blued.ui.login_register.LinkMobileFragment;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.pay.BeansPrePayFragment;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.BaseShareEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.ui.yy_room.fragment.YYInviteFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.ShareCoreUtils;
import com.soft.blued.utils.ShareUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.Map;

public class YYRoomInfoChannel {
  public static void a() {
    if (!YYRoomInfoManager.d().a())
      YYRoomInfoManager.d().a(b()); 
  }
  
  private static IYYRoomInfoCallback b() {
    return new IYYRoomInfoCallback() {
        public CharSequence a(CharSequence param1CharSequence, String param1String, ClickAtLinkListener param1ClickAtLinkListener) {
          return StringUtils.b(param1CharSequence, true, true, false, new TypefaceUtils.ClickAtLinkListener(this, param1ClickAtLinkListener) {
                public void a(String param2String1, String param2String2) {
                  this.a.a(param2String1, param2String2);
                }
              }true, param1String, "");
        }
        
        public String a() {
          return UserInfo.a().i().getName();
        }
        
        public String a(int param1Int) {
          return (param1Int != -1) ? "" : H5Url.a(57);
        }
        
        public void a(Context param1Context) {
          TerminalActivity.d(param1Context, LinkMobileFragment.class, null);
        }
        
        public void a(Context param1Context, EditText param1EditText, int param1Int1, int param1Int2, String param1String, Map<String, String> param1Map) {
          MsgCommonUtils.a(param1Context, param1EditText, param1Int1, param1Int2, param1String, param1Map);
        }
        
        public void a(Context param1Context, FragmentManager param1FragmentManager, YYRoomModel param1YYRoomModel, Bitmap param1Bitmap, String param1String) {
          ShareToMsgEntity shareToMsgEntity = new ShareToMsgEntity();
          shareToMsgEntity.title = param1String;
          shareToMsgEntity.name = "";
          shareToMsgEntity.image = param1YYRoomModel.avatar;
          shareToMsgEntity.description = "";
          shareToMsgEntity.url = "";
          shareToMsgEntity.type = 12;
          shareToMsgEntity.sessionId = Long.valueOf(param1YYRoomModel.room_id).longValue();
          YYInviteFragment yYInviteFragment = new YYInviteFragment();
          Bundle bundle = new Bundle();
          bundle.putSerializable("share_type", Integer.valueOf(0));
          bundle.putParcelable("share_entity", (Parcelable)shareToMsgEntity);
          bundle.putString("share_yy_type_name", param1YYRoomModel.room_type);
          bundle.putString("share_yy_type_id", param1YYRoomModel.type_id);
          yYInviteFragment.setArguments(bundle);
          yYInviteFragment.show(param1FragmentManager, "InviteDialog");
        }
        
        public void a(Context param1Context, YYRoomModel param1YYRoomModel, Bitmap param1Bitmap, String param1String) {
          BaseShareEntity.ShareLiveData shareLiveData = new BaseShareEntity.ShareLiveData();
          shareLiveData.i = false;
          shareLiveData.a = "";
          shareLiveData.d = "";
          shareLiveData.f = "";
          shareLiveData.c = "";
          shareLiveData.e = param1Bitmap;
          if (param1YYRoomModel != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1YYRoomModel.room_id);
            stringBuilder.append("");
            shareLiveData.h = stringBuilder.toString();
            shareLiveData.a = param1YYRoomModel.name;
            shareLiveData.d = param1YYRoomModel.avatar;
            shareLiveData.f = param1YYRoomModel.uid;
          } 
          shareLiveData.b = param1String;
          shareLiveData.l = new ShareOptionRecyclerAdapter.ShareOptionsItemClickListener(this) {
              public void onItemClick(int param2Int) {
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
                if (bool1) {
                  LiveFloatManager.a().G();
                  LiveRefreshUIObserver.a().b(false);
                } 
              }
            };
          shareLiveData.k = new ShareCoreUtils.ShareBackLister(this) {
              public void a(String param2String) {
                AppInfo.n().postDelayed(new Runnable(this) {
                      public void run() {
                        LiveSetDataObserver.a().m();
                      }
                    },  3000L);
              }
              
              public void b(String param2String) {}
              
              public void c(String param2String) {}
              
              public void d(String param2String) {}
            };
          ShareUtils.a().b(param1Context, shareLiveData);
        }
        
        public void a(Context param1Context, String param1String, int param1Int) {
          WebViewShowInfoFragment.show(param1Context, param1String, param1Int);
        }
        
        public void a(Context param1Context, String param1String1, String param1String2, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone param1IAddOrRemoveAttentionDone, IRequestHost param1IRequestHost) {
          UserHttpUtils.b(param1Context, YYRoomInfoChannel.a(param1IAddOrRemoveAttentionDone), param1String1, param1String2, param1IRequestHost);
        }
        
        public void a(Context param1Context, String param1String1, String param1String2, String param1String3) {
          LogData logData = new LogData();
          logData.g = "none";
          MsgSourceEntity msgSourceEntity = new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, "");
          ChatHelperV4.a().a(param1Context, StringUtils.a(param1String1, -1L), param1String2, param1String3, 0, 0, 0, 0, "", false, 0, 0, logData, msgSourceEntity);
        }
        
        public void a(Context param1Context, String param1String1, String param1String2, String param1String3, int param1Int1, int param1Int2) {
          UserBasicModel userBasicModel = new UserBasicModel();
          userBasicModel.uid = param1String1;
          userBasicModel.name = param1String2;
          userBasicModel.avatar = param1String3;
          userBasicModel.is_show_vip_page = param1Int1;
          if (param1Int2 == 2) {
            UserInfoFragmentNew.a(param1Context, userBasicModel, "", false, new MsgSourceEntity(MessageProtos.StrangerSource.LIVE, ""));
            return;
          } 
          if (param1Int2 == 2)
            UserInfoFragmentNew.a(param1Context, userBasicModel, "", false, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, "")); 
        }
        
        public boolean a(Context param1Context, View.OnClickListener param1OnClickListener) {
          return PopMenuUtils.a(param1Context, param1OnClickListener);
        }
        
        public String b() {
          return (UserInfo.a().i()).avatar;
        }
        
        public void b(Context param1Context) {
          LiveYYImproveFragment.a(param1Context);
        }
        
        public void b(Context param1Context, String param1String1, String param1String2, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone param1IAddOrRemoveAttentionDone, IRequestHost param1IRequestHost) {
          UserHttpUtils.a(param1Context, YYRoomInfoChannel.a(param1IAddOrRemoveAttentionDone), param1String1, param1String2, param1IRequestHost);
        }
        
        public String c() {
          return UserInfo.a().i().getUid();
        }
        
        public void c(Context param1Context) {
          BeansPrePayFragment.a(param1Context, 7);
        }
        
        public boolean d() {
          return BluedHttpUrl.h();
        }
        
        public String e() {
          return BluedHttpUrl.n();
        }
        
        public String f() {
          return BluedHttpUrl.o();
        }
        
        public String g() {
          return "https://www.blued.cn/live/agreement";
        }
        
        public String h() {
          return H5Url.a(56);
        }
        
        public String i() {
          return LoginRegisterTools.b();
        }
      };
  }
  
  private static UserRelationshipUtils.IAddOrRemoveAttentionDone b(LiveUserRelationshipUtils.IAddOrRemoveAttentionDone paramIAddOrRemoveAttentionDone) {
    return new UserRelationshipUtils.IAddOrRemoveAttentionDone(paramIAddOrRemoveAttentionDone) {
        public void a() {
          LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone = this.a;
          if (iAddOrRemoveAttentionDone != null)
            iAddOrRemoveAttentionDone.R_(); 
        }
        
        public void a(String param1String) {
          LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone = this.a;
          if (iAddOrRemoveAttentionDone != null)
            iAddOrRemoveAttentionDone.a(param1String); 
        }
        
        public void b() {
          LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone = this.a;
          if (iAddOrRemoveAttentionDone != null)
            iAddOrRemoveAttentionDone.d(); 
        }
        
        public void b(String param1String) {
          LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone = this.a;
          if (iAddOrRemoveAttentionDone != null)
            iAddOrRemoveAttentionDone.b(param1String); 
        }
        
        public void c() {
          LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone = this.a;
          if (iAddOrRemoveAttentionDone != null)
            iAddOrRemoveAttentionDone.e(); 
        }
      };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\YYRoomInfoChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */