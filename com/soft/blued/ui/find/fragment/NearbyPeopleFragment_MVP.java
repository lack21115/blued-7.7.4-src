package com.soft.blued.ui.find.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.ab_test.models.ShortEntranceExtra;
import com.soft.blued.ui.find.model.CallHelloModel;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.ui.find.model.FindDataExtra;
import com.soft.blued.ui.find.model.NearbyChatRoomModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.live.model.LiveTwoFloorModel;
import java.util.List;

public final class NearbyPeopleFragment_MVP implements MvpDispatcher {
  private void a(NearbyPeopleFragment paramNearbyPeopleFragment, String paramString) {
    byte b;
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 1898457338:
        if (paramString.equals("two_level_no_data")) {
          b = 7;
          break;
        } 
      case 1142667098:
        if (paramString.equals("people_data")) {
          b = 2;
          break;
        } 
      case 251971121:
        if (paramString.equals("advert_float")) {
          b = 9;
          break;
        } 
      case -19144837:
        if (paramString.equals("home_refresh")) {
          b = 1;
          break;
        } 
      case -80385857:
        if (paramString.equals(" header_two_level")) {
          b = 5;
          break;
        } 
      case -642481257:
        if (paramString.equals("refresh_num_plus")) {
          b = 4;
          break;
        } 
      case -775555338:
        if (paramString.equals("people_data_refresh")) {
          b = 8;
          break;
        } 
      case -1224280924:
        if (paramString.equals("list_mode")) {
          b = 3;
          break;
        } 
      case -1672731668:
        if (paramString.equals("sort_by_view")) {
          b = 0;
          break;
        } 
      case -1885331828:
        if (paramString.equals("make_friend_recommend")) {
          b = 6;
          break;
        } 
      case -2004909280:
        if (paramString.equals(" prepare_to_play")) {
          b = 10;
          break;
        } 
    } 
    switch (b) {
      default:
        return;
      case 10:
        paramNearbyPeopleFragment.k();
        return;
      case 9:
        paramNearbyPeopleFragment.n();
        return;
      case 8:
        paramNearbyPeopleFragment.J();
        return;
      case 7:
        paramNearbyPeopleFragment.I();
        return;
      case 6:
        paramNearbyPeopleFragment.G();
        return;
      case 5:
        paramNearbyPeopleFragment.l();
        return;
      case 4:
        paramNearbyPeopleFragment.H();
        return;
      case 3:
        paramNearbyPeopleFragment.E();
        return;
      case 2:
        paramNearbyPeopleFragment.F();
        return;
      case 1:
        paramNearbyPeopleFragment.K();
        return;
      case 0:
        break;
    } 
    paramNearbyPeopleFragment.m();
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List<Object> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      Boolean bool = (Boolean)paramList.get(0);
      if (bool != null) {
        switch (paramString.hashCode()) {
          default:
            b = -1;
            break;
          case 1830947994:
            if (paramString.equals("entry_data_cache")) {
              b = 10;
              break;
            } 
          case 1806801587:
            if (paramString.equals("notify_model")) {
              b = 2;
              break;
            } 
          case 1699571193:
            if (paramString.equals("count_update")) {
              b = 9;
              break;
            } 
          case 1493910251:
            if (paramString.equals("people_data_extra"))
              break; 
          case 1142667098:
            if (paramString.equals("people_data")) {
              b = 1;
              break;
            } 
          case 728777408:
            if (paramString.equals(" show_chat_room")) {
              b = 7;
              break;
            } 
          case 281008081:
            if (paramString.equals("two_level")) {
              b = 6;
              break;
            } 
          case 178651836:
            if (paramString.equals("map_find")) {
              b = 12;
              break;
            } 
          case -229759782:
            if (paramString.equals("set_call_data_update")) {
              b = 8;
              break;
            } 
          case -1222166226:
            if (paramString.equals("people_data_extra_cache")) {
              b = 5;
              break;
            } 
          case -1635309026:
            if (paramString.equals("set_time_update")) {
              b = 11;
              break;
            } 
          case -1754129423:
            if (paramString.equals("selected_tab")) {
              b = 4;
              break;
            } 
          case -1965811881:
            if (paramString.equals("entry_data")) {
              b = 3;
              break;
            } 
        } 
        switch (b) {
          case 12:
            if (Boolean.class.isInstance(bool)) {
              paramMvpFragment.a(bool);
              return;
            } 
            break;
          case 11:
            if (CallHelloModel.class.isInstance(bool)) {
              paramMvpFragment.a((CallHelloModel)bool);
              return;
            } 
            break;
          case 10:
            if (ShortEntranceExtra.class.isInstance(bool)) {
              paramMvpFragment.b((ShortEntranceExtra)bool);
              return;
            } 
            break;
          case 9:
            if (CallHelloModel.class.isInstance(bool)) {
              paramMvpFragment.b((CallHelloModel)bool);
              return;
            } 
            break;
          case 8:
            if (CallMeStatusData.class.isInstance(bool)) {
              paramMvpFragment.a((CallMeStatusData)bool);
              return;
            } 
            break;
          case 7:
            if (NearbyChatRoomModel.class.isInstance(bool)) {
              paramMvpFragment.a((NearbyChatRoomModel)bool);
              return;
            } 
            break;
          case 6:
            if (LiveTwoFloorModel.class.isInstance(bool)) {
              paramMvpFragment.b((List)paramList);
              return;
            } 
            break;
          case 5:
            if (FindDataExtra.class.isInstance(bool)) {
              paramMvpFragment.b((FindDataExtra)bool);
              return;
            } 
            break;
          case 4:
            if (String.class.isInstance(bool)) {
              paramMvpFragment.e((String)bool);
              return;
            } 
            break;
          case 3:
            if (ShortEntranceExtra.class.isInstance(bool)) {
              paramMvpFragment.a((ShortEntranceExtra)bool);
              return;
            } 
            break;
          case 2:
            if (Integer.class.isInstance(bool)) {
              paramMvpFragment.a((Integer)bool);
              return;
            } 
            break;
          case 1:
            if (UserFindResult.class.isInstance(bool)) {
              paramMvpFragment.a((List)paramList);
              return;
            } 
            break;
          case 0:
            if (FindDataExtra.class.isInstance(bool)) {
              paramMvpFragment.a((FindDataExtra)bool);
              return;
            } 
            break;
        } 
      } 
    } 
    a((NearbyPeopleFragment)paramMvpFragment, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyPeopleFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */