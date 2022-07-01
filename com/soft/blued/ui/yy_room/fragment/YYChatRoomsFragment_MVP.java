package com.soft.blued.ui.yy_room.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.yy_china.model.YYBannerModel;
import com.blued.android.module.yy_china.model.YYChatRoomFollowedModel;
import com.blued.android.module.yy_china.model.YYLiveState;
import com.blued.android.module.yy_china.model.YYRoomExtraModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYTopicModel;
import java.util.List;

public final class YYChatRoomsFragment_MVP implements MvpDispatcher {
  private void a(YYChatRoomsFragment paramYYChatRoomsFragment, String paramString) {
    byte b;
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 1381733278:
        if (paramString.equals("yy_topic_empty")) {
          b = 2;
          break;
        } 
      case 1213119052:
        if (paramString.equals("yy_room_list_no_data")) {
          b = 0;
          break;
        } 
      case 1115730806:
        if (paramString.equals("yy_topic_list_error")) {
          b = 9;
          break;
        } 
      case 1036635546:
        if (paramString.equals("yy_room_banner_no_data")) {
          b = 7;
          break;
        } 
      case 994218911:
        if (paramString.equals("yy_create_room")) {
          b = 10;
          break;
        } 
      case 290457311:
        if (paramString.equals("yy_loading_show")) {
          b = 6;
          break;
        } 
      case -32559957:
        if (paramString.equals("yy_dismiss_room_list_loading")) {
          b = 1;
          break;
        } 
      case -856253135:
        if (paramString.equals("yy_room_list_empty")) {
          b = 4;
          break;
        } 
      case -1740872856:
        if (paramString.equals("yy_loading_dismiss")) {
          b = 8;
          break;
        } 
      case -1887054901:
        if (paramString.equals("yy_room_list_has_data")) {
          b = 5;
          break;
        } 
      case -1951334217:
        if (paramString.equals("yy_followed_list_no_data")) {
          b = 3;
          break;
        } 
    } 
    switch (b) {
      default:
        return;
      case 10:
        paramYYChatRoomsFragment.I();
        return;
      case 9:
        paramYYChatRoomsFragment.n();
        return;
      case 8:
        paramYYChatRoomsFragment.H();
        return;
      case 7:
        paramYYChatRoomsFragment.k();
        return;
      case 6:
        paramYYChatRoomsFragment.G();
        return;
      case 5:
        paramYYChatRoomsFragment.x();
        return;
      case 4:
        paramYYChatRoomsFragment.E();
        return;
      case 3:
        paramYYChatRoomsFragment.l();
        return;
      case 2:
        paramYYChatRoomsFragment.m();
        return;
      case 1:
        paramYYChatRoomsFragment.F();
        return;
      case 0:
        break;
    } 
    paramYYChatRoomsFragment.y();
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List<Object> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      YYLiveState yYLiveState = (YYLiveState)paramList.get(0);
      if (yYLiveState != null) {
        switch (paramString.hashCode()) {
          default:
            b = -1;
            break;
          case 1845892141:
            if (paramString.equals("yy_topic_list")) {
              b = 1;
              break;
            } 
          case 1789778723:
            if (paramString.equals("yy_room_list")) {
              b = 2;
              break;
            } 
          case 1581065186:
            if (paramString.equals("yy_room_new_list")) {
              b = 6;
              break;
            } 
          case 1231891005:
            if (paramString.equals("yy_room_banner_has_data")) {
              b = 3;
              break;
            } 
          case 1206303886:
            if (paramString.equals("yy_followed_list"))
              break; 
          case -937925396:
            if (paramString.equals("yy_live_apply_state")) {
              b = 5;
              break;
            } 
          case -1999062869:
            if (paramString.equals("yy_room_w_list")) {
              b = 4;
              break;
            } 
        } 
        switch (b) {
          case 6:
            if (YYRoomModel.class.isInstance(yYLiveState)) {
              paramMvpFragment.e((List)paramList);
              return;
            } 
            break;
          case 5:
            if (YYLiveState.class.isInstance(yYLiveState)) {
              paramMvpFragment.a(yYLiveState);
              return;
            } 
            break;
          case 4:
            if (YYRoomExtraModel.class.isInstance(yYLiveState)) {
              paramMvpFragment.a((YYRoomExtraModel)yYLiveState);
              return;
            } 
            break;
          case 3:
            if (YYBannerModel.class.isInstance(yYLiveState)) {
              paramMvpFragment.a((List)paramList);
              return;
            } 
            break;
          case 2:
            if (YYRoomModel.class.isInstance(yYLiveState)) {
              paramMvpFragment.d((List)paramList);
              return;
            } 
            break;
          case 1:
            if (YYTopicModel.class.isInstance(yYLiveState)) {
              paramMvpFragment.c((List)paramList);
              return;
            } 
            break;
          case 0:
            if (YYChatRoomFollowedModel.DataBean.class.isInstance(yYLiveState)) {
              paramMvpFragment.b((List)paramList);
              return;
            } 
            break;
        } 
      } 
    } 
    a((YYChatRoomsFragment)paramMvpFragment, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\fragment\YYChatRoomsFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */