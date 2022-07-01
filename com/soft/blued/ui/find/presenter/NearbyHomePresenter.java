package com.soft.blued.ui.find.presenter;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.find.model.CityLocation;
import com.soft.blued.ui.find.model.HomeTopTabModel;
import com.soft.blued.ui.find.model.NearbyFeedCity;
import com.soft.blued.ui.find.observer.NearbyViewModel;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.user.model.VipInvisibleSettingModel;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import java.util.List;

public class NearbyHomePresenter extends MvpPresenter {
  public boolean h;
  
  public boolean i;
  
  public List<HomeTopTabModel> j;
  
  private void n() {
    ProfileHttpUtils.a((Context)h(), new BluedUIHttpResponse<BluedEntityA<VipInvisibleSettingModel>>(this, g()) {
          protected void a(BluedEntityA<VipInvisibleSettingModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              boolean bool1;
              boolean bool2;
              boolean bool3;
              boolean bool4;
              List<VipInvisibleSettingModel> list = param1BluedEntityA.data;
              boolean bool5 = false;
              VipInvisibleSettingModel vipInvisibleSettingModel = list.get(0);
              if (vipInvisibleSettingModel.is_invisible_all == 1) {
                bool1 = true;
              } else {
                bool1 = false;
              } 
              if (vipInvisibleSettingModel.is_age_stealth == 1) {
                bool2 = true;
              } else {
                bool2 = false;
              } 
              if (vipInvisibleSettingModel.is_stealth_distance == 1) {
                bool3 = true;
              } else {
                bool3 = false;
              } 
              if (vipInvisibleSettingModel.is_role_stealth == 1) {
                bool4 = true;
              } else {
                bool4 = false;
              } 
              if (bool4 || bool3 || bool2 || bool1)
                bool5 = true; 
              Boolean bool = Boolean.valueOf(bool5);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("--setDataToUI INVISIBLE_STATE:");
              stringBuilder.append(bool);
              stringBuilder.append(" -- ");
              stringBuilder.append(this.a.g().isActive());
              Log.v("drb", stringBuilder.toString());
              this.a.a("invisible_state", bool);
            } 
          }
        }UserInfo.a().i().getUid(), g());
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    this.j = BluedConfig.b().c((Context)paramFragmentActivity);
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    super.a(paramLifecycleOwner);
    LiveEventBus.get("nearby_activity", BluedADExtra.class).observe(paramLifecycleOwner, new Observer<BluedADExtra>(this) {
          public void a(BluedADExtra param1BluedADExtra) {
            Log.v("drb", "KEY_EVENT_NEARBY_ACTIVITY onChanged");
            this.a.a("nearby_activity", param1BluedADExtra, false);
          }
        });
    LiveEventBus.get("INVISIBLE_DISTANCE", Boolean.class).observe(paramLifecycleOwner, new Observer<Boolean>(this) {
          public void a(Boolean param1Boolean) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onChanged:");
            stringBuilder.append(param1Boolean);
            Log.v("drb", stringBuilder.toString());
            this.a.a("invisible_state", param1Boolean);
          }
        });
    LiveEventBus.get("is_click_on_header", Boolean.class).observe(paramLifecycleOwner, new Observer<Boolean>(this) {
          public void a(Boolean param1Boolean) {
            this.a.i = param1Boolean.booleanValue();
          }
        });
    LiveEventBus.get("set_tip_visibility", Boolean.class).observe(paramLifecycleOwner, new Observer<Boolean>(this) {
          public void a(Boolean param1Boolean) {
            this.a.a("set_tip_visibility", false);
          }
        });
    LiveEventBus.get("is_show_tip", Boolean.class).observe(paramLifecycleOwner, new Observer<Boolean>(this) {
          public void a(Boolean param1Boolean) {
            this.a.h = BluedPreferences.at((UserInfo.a().i()).uid);
            String str = BluedPreferences.ev();
            boolean bool2 = TextUtils.isEmpty(str);
            boolean bool1 = false;
            if (!bool2) {
              String[] arrayOfString = str.split("-");
              int i = Integer.valueOf(arrayOfString[0]).intValue();
              int j = Integer.valueOf(arrayOfString[1]).intValue();
              bool1 = this.a.a(i, j, i, j);
            } 
            if (((UserInfo.a().i()).is_user_reactive == 1 || bool1) && !this.a.h && !this.a.i)
              this.a.b("is_show_tip"); 
          }
        });
    if (HomeActivity.c != null) {
      NearbyViewModel nearbyViewModel = (NearbyViewModel)ViewModelProviders.of((FragmentActivity)HomeActivity.c).get(NearbyViewModel.class);
      nearbyViewModel.a.observe(paramLifecycleOwner, new -$$Lambda$NearbyHomePresenter$roIZP6wkXK6_lRi5M8tLzXsLhi0(this));
      nearbyViewModel.c.observe(paramLifecycleOwner, new -$$Lambda$NearbyHomePresenter$n4VmhW-EuZl7MShnZgzWl2MqDW8(this));
      nearbyViewModel.d.observe(paramLifecycleOwner, new -$$Lambda$NearbyHomePresenter$WY-JyIXucRS4rXKyt2aWNGnXthc(this));
    } 
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    Log.v("drb", "onFetchData---");
    n();
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    long l = System.currentTimeMillis();
    Time time1 = new Time();
    time1.set(l);
    Time time2 = new Time();
    time2.set(l);
    time2.hour = paramInt1;
    time2.minute = paramInt2;
    Time time3 = new Time();
    time3.set(l);
    time3.hour = paramInt3;
    time3.minute = paramInt4;
    boolean bool = time2.before(time3);
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bool) {
      time2.set(time2.toMillis(true) - 86400000L);
      bool = bool1;
      if (!time1.before(time2)) {
        bool = bool1;
        if (!time1.after(time3))
          bool = true; 
      } 
      time3 = new Time();
      time3.set(time2.toMillis(true) + 86400000L);
      if (!time1.before(time3))
        return true; 
    } else {
      bool = bool2;
      if (!time1.before(time2)) {
        bool = bool2;
        if (!time1.after(time3))
          return true; 
      } 
    } 
    return bool;
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void m() {
    String str1 = NearbyFeedCity.getInstance().getLongitude();
    String str2 = NearbyFeedCity.getInstance().getLatitude();
    FindHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<CityLocation>>(this, g()) {
          protected void a(BluedEntityA<CityLocation> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              boolean bool1;
              BluedPreferences.al(((CityLocation)param1BluedEntityA.getSingleData()).city_code);
              for (HomeTopTabModel homeTopTabModel : this.a.j) {
                if (homeTopTabModel.tab_id == 2) {
                  String str = BluedPreferences.dA();
                  homeTopTabModel.tab_title = NearbyFeedCity.getCityTitle((Context)this.a.h(), str);
                } 
              } 
              int i = ((CityLocation)param1BluedEntityA.getSingleData()).has_verify_mobile;
              boolean bool2 = true;
              if (i == 1) {
                bool1 = true;
              } else {
                bool1 = false;
              } 
              BluedPreferences.N(bool1);
              if (((CityLocation)param1BluedEntityA.getSingleData()).has_used_mobile == 1) {
                bool1 = bool2;
              } else {
                bool1 = false;
              } 
              BluedPreferences.O(bool1);
              this.a.a("home_city_code", false);
            } 
          }
        }str1, str2, g());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\presenter\NearbyHomePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */