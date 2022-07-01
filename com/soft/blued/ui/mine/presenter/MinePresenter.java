package com.soft.blued.ui.mine.presenter;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.mine.model.MineEntryInfo;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.user.UserInfo;
import java.util.List;
import java.util.Map;

public class MinePresenter extends MvpPresenter implements HomeTabClick.TabClickListener {
  private String h;
  
  private boolean i;
  
  private boolean j;
  
  private void d(IFetchDataListener paramIFetchDataListener) {
    MineHttpUtils.a(e(paramIFetchDataListener), UserInfo.a().i().getUid(), g());
  }
  
  private BluedUIHttpResponse e(IFetchDataListener paramIFetchDataListener) {
    return new BluedUIHttpResponse<BluedEntityA<MineEntryInfo>>(this, "my_page", g(), paramIFetchDataListener) {
        private void a(MineEntryInfo param1MineEntryInfo) {
          if (param1MineEntryInfo.user != null && UserInfo.a().i() != null) {
            (UserInfo.a().i()).vip_grade = param1MineEntryInfo.user.vip_grade;
            (UserInfo.a().i()).is_vip_annual = param1MineEntryInfo.user.is_vip_annual;
            (UserInfo.a().i()).is_show_vip_page = param1MineEntryInfo.user.is_show_vip_page;
            UserInfo.a().i().setBlackCount(param1MineEntryInfo.black_count);
            UserInfo.a().i().setBlackMax(param1MineEntryInfo.black_allowed_count);
            (UserInfo.a().i()).is_invisible_all = param1MineEntryInfo.user.is_invisible_all;
            (UserInfo.a().i()).is_invisible_half = param1MineEntryInfo.user.is_invisible_half;
            if (param1MineEntryInfo.user.vip_avatars != null && param1MineEntryInfo.user.vip_avatars.size() > 0)
              UserInfo.a().i().setVip_avatars(param1MineEntryInfo.user.vip_avatars); 
          } 
          UserInfoEntity userInfoEntity = param1MineEntryInfo.user;
          if (userInfoEntity != null && UserInfo.a().i() != null) {
            UserInfo.a().i().setName(userInfoEntity.name);
            UserInfo.a().i().setAvatar(userInfoEntity.avatar);
            UserInfo.a().i().setVBadge(userInfoEntity.vbadge);
            UserInfo.a().i().setFollowedCount(userInfoEntity.followed_count);
            UserInfo.a().i().setFollowerCount(userInfoEntity.followers_count);
            UserInfo.a().i().setMyTicktocksCount(userInfoEntity.my_ticktocks_count);
            UserInfo.a().i().setGroupsCount(userInfoEntity.groups_count);
            UserInfo.a().i().setRich_level(userInfoEntity.rich_level);
          } 
        }
        
        protected void a(BluedEntityA<MineEntryInfo> param1BluedEntityA) {
          super.onUICache((BluedEntity)param1BluedEntityA);
          if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
            a((MineEntryInfo)param1BluedEntityA.getSingleData());
            this.b.a("MY_PAGE", param1BluedEntityA.getSingleData());
            MinePresenter.a(this.b, ((MineEntryInfo)param1BluedEntityA.getSingleData()).getVipCenterUrl());
          } 
        }
        
        protected void b(BluedEntityA<MineEntryInfo> param1BluedEntityA) {
          if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
            a((MineEntryInfo)param1BluedEntityA.getSingleData());
            this.b.a("MY_PAGE", param1BluedEntityA.getSingleData());
          } 
        }
        
        public void onUIFinish(boolean param1Boolean) {
          onUIFinish();
          this.a.a(param1Boolean);
        }
      };
  }
  
  private BluedUIHttpResponse f(IFetchDataListener paramIFetchDataListener) {
    return new BluedUIHttpResponse<BluedEntityA<BluedBlackList.privacySettingEntity>>(this, "my_privacy_setting", g()) {
        private void c(BluedEntityA<BluedBlackList.privacySettingEntity> param1BluedEntityA) {
          if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
            MinePresenter minePresenter = this.a;
            List list = param1BluedEntityA.data;
            boolean bool2 = false;
            if (((BluedBlackList.privacySettingEntity)list.get(0)).is_hide_last_operate == 1) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            MinePresenter.a(minePresenter, bool1);
            minePresenter = this.a;
            boolean bool1 = bool2;
            if (((BluedBlackList.privacySettingEntity)param1BluedEntityA.data.get(0)).is_hide_distance == 1)
              bool1 = true; 
            MinePresenter.b(minePresenter, bool1);
          } 
        }
        
        protected BluedEntityA<BluedBlackList.privacySettingEntity> a(String param1String) {
          return (BluedEntityA<BluedBlackList.privacySettingEntity>)super.parseData(param1String);
        }
        
        protected void a(BluedEntityA<BluedBlackList.privacySettingEntity> param1BluedEntityA) {
          super.onUICache((BluedEntity)param1BluedEntityA);
          c(param1BluedEntityA);
        }
        
        public void b(BluedEntityA<BluedBlackList.privacySettingEntity> param1BluedEntityA) {
          c(param1BluedEntityA);
        }
        
        public void onUIFinish(boolean param1Boolean) {
          super.onUIFinish(param1Boolean);
          this.a.b("PRIVACY");
        }
      };
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    super.a(paramLifecycleOwner);
    HomeTabClick.a("mine", this);
    paramLifecycleOwner.getLifecycle().addObserver(new LifecycleObserver(this, paramLifecycleOwner) {
          @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
          public void onDestroy() {
            HomeTabClick.b("mine", this.b);
            this.a.getLifecycle().removeObserver(this);
          }
        });
    LiveEventBus.get("feed_avatar_widget", Integer.class).observe(paramLifecycleOwner, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            this.a.a("PRIVACY", param1Integer);
          }
        });
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    d(paramIFetchDataListener);
    c(paramIFetchDataListener);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    String str1;
    Map<String, String> map = BluedHttpTools.a();
    String str2 = "1";
    if (paramBoolean1) {
      str1 = "1";
    } else {
      str1 = "0";
    } 
    map.put("is_hide_last_operate", str1);
    if (paramBoolean2) {
      str1 = str2;
    } else {
      str1 = "0";
    } 
    map.put("is_hide_distance", str1);
    ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this, g(), paramBoolean1, paramBoolean2) {
          public void a(BluedEntityA<Object> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              AppMethods.a(AppInfo.d().getResources().getString(2131757808));
              MinePresenter.a(this.c, this.a);
              MinePresenter.b(this.c, this.b);
              this.c.b("PRIVACY");
            } else {
              AppMethods.a(AppInfo.d().getResources().getString(2131756082));
            } 
            UserInfoDataObserver.a().b();
          }
        }UserInfo.a().i().getUid(), map);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void c(IFetchDataListener paramIFetchDataListener) {
    ProfileHttpUtils.a((Context)h(), f(paramIFetchDataListener), UserInfo.a().i().getUid(), g());
  }
  
  public void c(String paramString) {
    if ("mine".equals(paramString))
      a("TAB_CLICK", false); 
  }
  
  public boolean c() {
    return true;
  }
  
  public void d(String paramString) {
    c(paramString);
  }
  
  public void k() {
    e((IFetchDataListener)null).refresh();
    f((IFetchDataListener)null).refresh();
  }
  
  public String[] l() {
    return new String[] { "MY_PAGE" };
  }
  
  public String m() {
    return this.h;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\mine\presenter\MinePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */