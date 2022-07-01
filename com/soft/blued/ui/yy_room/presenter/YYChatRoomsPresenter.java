package com.soft.blued.ui.yy_room.presenter;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYBannerModel;
import com.blued.android.module.yy_china.model.YYChatRoomFollowedModel;
import com.blued.android.module.yy_china.model.YYLiveState;
import com.blued.android.module.yy_china.model.YYRoomExtraModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYTopicModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.List;

public class YYChatRoomsPresenter extends MvpPresenter {
  private List<YYTopicModel> h = new ArrayList<YYTopicModel>();
  
  private int i = 1;
  
  private String j = "0";
  
  private boolean k;
  
  private void r() {
    YYRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<YYTopicModel>>(this, g()) {
          protected void a(BluedEntityA<YYTopicModel> param1BluedEntityA) {
            super.onUICache((BluedEntity)param1BluedEntityA);
            Logger.e("cache", new Object[] { "yy topic list onUICache ... " });
          }
          
          protected void b(BluedEntityA<YYTopicModel> param1BluedEntityA) {
            Logger.e("cache", new Object[] { "yy topic list onUIUpdate ... " });
            if (param1BluedEntityA == null || !param1BluedEntityA.hasData()) {
              this.a.a("yy_topic_empty", false);
              return;
            } 
            YYChatRoomsPresenter.a(this.a, param1BluedEntityA.data);
            YYChatRoomsPresenter yYChatRoomsPresenter = this.a;
            yYChatRoomsPresenter.a("yy_topic_list", YYChatRoomsPresenter.a(yYChatRoomsPresenter), false);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            Logger.e("cache", new Object[] { "yy topic list onUIFailure ... " });
            this.a.a("yy_topic_list_error", false);
            return super.onUIFailure(param1Int, param1String);
          }
        }g());
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    super.a(paramLifecycleOwner);
    LiveEventBus.get("into_new_yy_room", String.class).observe(paramLifecycleOwner, new Observer<String>(this) {
          public void a(String param1String) {
            YYRoomInfoManager.d().a((BaseFragmentActivity)this.a.h(), param1String, "");
          }
        });
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.i = 1;
    r();
    m();
    o();
  }
  
  public void a(String paramString1, String paramString2) {
    YYRoomHttpUtils.a(paramString1, paramString2, new BluedUIHttpResponse<BluedEntityA<YYRoomModel>>(this, g(), paramString1) {
          protected void a(BluedEntityA<YYRoomModel> param1BluedEntityA) {
            this.b.a("yy_create_room", false);
            YYRoomModel yYRoomModel = (YYRoomModel)param1BluedEntityA.getSingleData();
            if (yYRoomModel != null) {
              if (yYRoomModel.mics != null && yYRoomModel.mics.size() > 0) {
                ((YYSeatMemberModel)yYRoomModel.mics.get(0)).is_open_mic = 2;
                if (yYRoomModel.isCPChannel())
                  ((YYSeatMemberModel)yYRoomModel.mics.get(0)).itemType = 1; 
              } 
              YYRoomInfoManager.d().a(yYRoomModel);
              YYRoomInfoManager.d().b((Context)this.b.h());
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            ToastUtils.a(param1String, 0);
            if (param1Int == 40380007)
              EventTrackYY.b(ChatRoomProtos.Event.CHAT_ROOM_NAME_INVALITE_SHOW, this.a); 
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            this.b.a("yy_loading_dismiss", false);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.b.a("yy_loading_show", false);
          }
        }g());
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    c(this.j, false);
  }
  
  public void c(String paramString, boolean paramBoolean) {
    this.j = paramString;
    if (paramBoolean)
      this.i = 1; 
    YYRoomHttpUtils.a(paramString, this.i, new BluedUIHttpResponse<BluedEntity<YYRoomModel, YYRoomExtraModel>>(this, g()) {
          public void onUICache(BluedEntity<YYRoomModel, YYRoomExtraModel> param1BluedEntity) {
            super.onUICache(param1BluedEntity);
            Logger.e("cache", new Object[] { "getRoomList onUICache ... " });
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            Logger.e("cache", new Object[] { "getRoomList onUIFinish ... " });
            this.a.a("yy_dismiss_room_list_loading", false);
          }
          
          public void onUIUpdate(BluedEntity<YYRoomModel, YYRoomExtraModel> param1BluedEntity) {
            Logger.e("cache", new Object[] { "getRoomList onUIUpdate ... " });
            if (param1BluedEntity == null || !param1BluedEntity.hasData()) {
              if (YYChatRoomsPresenter.b(this.a) == 1) {
                this.a.a("yy_room_w_list", param1BluedEntity.extra);
                this.a.a("yy_room_list_empty", false);
              } 
              YYChatRoomsPresenter.a(this.a, false);
              return;
            } 
            YYChatRoomsPresenter.a(this.a, param1BluedEntity.hasMore());
            if (YYChatRoomsPresenter.b(this.a) == 1) {
              this.a.a("yy_room_w_list", param1BluedEntity.extra);
              this.a.a("yy_room_new_list", param1BluedEntity.data, false);
            } else {
              this.a.a("yy_room_list", param1BluedEntity.data, false);
            } 
            if (YYChatRoomsPresenter.c(this.a)) {
              YYChatRoomsPresenter.d(this.a);
              this.a.a("yy_room_list_has_data", false);
              return;
            } 
            this.a.a("yy_room_list_no_data", false);
          }
        }g());
  }
  
  public boolean j() {
    return super.j();
  }
  
  public void m() {
    YYRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<YYBannerModel>>(this, g()) {
          protected void a(BluedEntityA<YYBannerModel> param1BluedEntityA) {
            if (param1BluedEntityA == null || !param1BluedEntityA.hasData()) {
              this.a.b("yy_room_banner_no_data");
              return;
            } 
            this.a.a("yy_room_banner_has_data", param1BluedEntityA.data, false);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a.b("yy_room_banner_no_data");
            return super.onUIFailure(param1Int, param1String);
          }
        }g());
  }
  
  public void n() {
    YYRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<YYLiveState>>(this, g()) {
          protected void a(BluedEntityA<YYLiveState> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              if (!param1BluedEntityA.hasData())
                return; 
              this.a.a("yy_live_apply_state", param1BluedEntityA.data.get(0), false);
            } 
          }
        }YYRoomInfoManager.d().c().c(), g());
  }
  
  public void o() {
    YYRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<YYChatRoomFollowedModel.DataBean>>(this, g()) {
          protected void a(BluedEntityA<YYChatRoomFollowedModel.DataBean> param1BluedEntityA) {
            if (param1BluedEntityA == null || !param1BluedEntityA.hasData()) {
              this.a.b("yy_followed_list_no_data");
              return;
            } 
            this.a.a("yy_followed_list", param1BluedEntityA.data, false);
          }
        }(UserInfo.a().i()).uid, g());
  }
  
  public List<YYTopicModel> p() {
    return this.h;
  }
  
  public String q() {
    return this.j;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\presenter\YYChatRoomsPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */