package com.soft.blued.ui.setting.Presenter;

import android.content.Context;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.ToastUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.setting.Contract.IPrivacySettingContract;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import java.util.Map;

public class PrivacySettingPresenter implements IPrivacySettingContract.IPresenter {
  public String a = "";
  
  public String b = "";
  
  private IPrivacySettingContract.IView c;
  
  private Context d;
  
  private IRequestHost e;
  
  private Map<String, String> f;
  
  private boolean g = false;
  
  private boolean h = false;
  
  private boolean i = false;
  
  private boolean j = true;
  
  private boolean k = false;
  
  private boolean l = false;
  
  private boolean m = false;
  
  private boolean n = false;
  
  private boolean o = true;
  
  private boolean p = false;
  
  private BluedUIHttpResponse q = new BluedUIHttpResponse<BluedEntityA<BluedBlackList.privacySettingEntity>>(this, "my_privacy_setting", this.e) {
      protected BluedEntityA<BluedBlackList.privacySettingEntity> a(String param1String) {
        return (BluedEntityA<BluedBlackList.privacySettingEntity>)super.parseData(param1String);
      }
      
      protected void a(BluedEntityA<BluedBlackList.privacySettingEntity> param1BluedEntityA) {
        super.onUICache((BluedEntity)param1BluedEntityA);
        PrivacySettingPresenter.a(this.a, param1BluedEntityA);
      }
      
      public void b(BluedEntityA<BluedBlackList.privacySettingEntity> param1BluedEntityA) {
        PrivacySettingPresenter.a(this.a, param1BluedEntityA);
      }
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        super.onFailure(param1Throwable, param1Int, param1String);
      }
    };
  
  public PrivacySettingPresenter(Context paramContext, IRequestHost paramIRequestHost, IPrivacySettingContract.IView paramIView) {
    this.c = paramIView;
    this.d = paramContext;
    this.e = paramIRequestHost;
    this.f = BluedHttpTools.a();
  }
  
  private void a(BluedEntityA<BluedBlackList.privacySettingEntity> paramBluedEntityA) {
    if (paramBluedEntityA != null)
      try {
        if (paramBluedEntityA.data != null && paramBluedEntityA.data.size() > 0) {
          boolean bool1;
          int i = ((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).is_access_follows;
          boolean bool2 = true;
          if (i == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          this.g = bool1;
          this.c.f(this.g);
          if (((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).is_access_followers == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          this.i = bool1;
          this.c.g(this.i);
          if (((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).is_global_view_secretly == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          this.h = bool1;
          this.c.h(this.h);
          if (((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).is_invisible_map == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          this.j = bool1;
          this.c.i(this.j);
          if (((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).forbid_selected_viewing == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          this.n = bool1;
          this.c.m(this.n);
          if (((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).is_hide_last_operate == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          this.k = bool1;
          this.c.j(this.k);
          if (((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).is_hide_distance == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          this.l = bool1;
          this.c.k(this.l);
          if (((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).is_traceless_access == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          this.m = bool1;
          this.c.l(this.m);
          if (((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).is_invisible_half == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          this.o = bool1;
          this.a = ((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).stealth_distance;
          this.c.b(this.o, this.a);
          if (((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).is_un_disturb == 1) {
            bool1 = bool2;
          } else {
            bool1 = false;
          } 
          this.p = bool1;
          this.c.n(this.p);
          UserInfo.a().i().setBlackCount(String.valueOf(((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).black_count));
          UserInfo.a().i().setBlackMax(String.valueOf(((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).black_allowed_count));
          IPrivacySettingContract.IView iView = this.c;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).black_count);
          stringBuilder1.append("");
          String str = stringBuilder1.toString();
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).black_allowed_count);
          stringBuilder2.append("");
          iView.a(str, stringBuilder2.toString());
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        AppMethods.a(AppInfo.d().getResources().getString(2131756082));
      }  
  }
  
  public void a(boolean paramBoolean) {
    e(paramBoolean);
    ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
          public void a(BluedEntityA<Object> param1BluedEntityA) {
            if (param1BluedEntityA == null)
              try {
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                UserInfoDataObserver.a().b();
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              }  
            UserInfoDataObserver.a().b();
          }
        },  UserInfo.a().i().getUid(), this.f);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    d(paramBoolean1);
    ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<AppConfigModel.VIPRight>>(this, paramBoolean2, paramBoolean1) {
          public void a(BluedEntityA<AppConfigModel.VIPRight> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              PrivacySettingPresenter privacySettingPresenter = this.c;
              int i = ((AppConfigModel.VIPRight)param1BluedEntityA.getSingleData()).is_global_view_secretly;
              boolean bool = true;
              if (i != 1)
                bool = false; 
              PrivacySettingPresenter.a(privacySettingPresenter, bool);
              if (PrivacySettingPresenter.a(this.c) instanceof com.soft.blued.ui.home.HomeActivity) {
                BluedPreferences.S(PrivacySettingPresenter.b(this.c));
                Context context = PrivacySettingPresenter.a(this.c);
                if (PrivacySettingPresenter.b(this.c)) {
                  i = 2131758079;
                } else {
                  i = 2131758078;
                } 
                ToastUtils.a(context.getString(i));
              } else {
                BluedPreferences.S(false);
              } 
              if (!PrivacySettingPresenter.b(this.c))
                ChatManager.getInstance().clearAllSecretLook(); 
            } 
            try {
              if (this.a)
                if (param1BluedEntityA != null) {
                  AppMethods.a(AppInfo.d().getResources().getString(2131758444));
                } else {
                  AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                }  
              BluedPreferences.v(this.b);
              LiveEventBus.get("sync_secret_look_state").post(Boolean.valueOf(this.b));
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              AppMethods.a(AppInfo.d().getResources().getString(2131756082));
              return;
            } 
          }
        }UserInfo.a().i().getUid(), this.f);
  }
  
  public void b() {
    BluedUIHttpResponse bluedUIHttpResponse = this.q;
    if (bluedUIHttpResponse != null)
      bluedUIHttpResponse.refresh(); 
  }
  
  public void b(boolean paramBoolean) {
    if (this.g != paramBoolean) {
      String str;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      } 
      this.f.put("is_access_follows", str);
    } 
  }
  
  public void bb_() {}
  
  public void c() {
    ProfileHttpUtils.a(this.d, this.q, UserInfo.a().i().getUid(), this.e);
  }
  
  public void c(boolean paramBoolean) {
    if (this.i != paramBoolean) {
      String str;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      } 
      this.f.put("is_access_followers", str);
    } 
  }
  
  public void d() {
    try {
      int i = Integer.parseInt(UserInfo.a().i().getBlackCount());
      int j = Integer.parseInt(UserInfo.a().i().getBlackMax());
      IPrivacySettingContract.IView iView = this.c;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(i);
      stringBuilder1.append("");
      String str = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(j);
      stringBuilder2.append("");
      iView.a(str, stringBuilder2.toString());
      return;
    } catch (Exception exception) {
      this.c.a("0", this.d.getResources().getString(2131755642));
      return;
    } 
  }
  
  public void d(boolean paramBoolean) {
    if (this.c instanceof com.soft.blued.ui.msg.MsgFragment || this.h != paramBoolean) {
      String str;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      } 
      this.f.put("is_global_view_secretly", str);
    } 
  }
  
  public void e() {
    boolean bool1 = this.c.M();
    boolean bool2 = this.c.N();
    if (bool2)
      this.f.put("stealth_distance", BluedPreferences.Z()); 
    if (this.f.size() > 0)
      ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this, bool1, bool2) {
            public void a(BluedEntityA<Object> param1BluedEntityA) {
              if (param1BluedEntityA != null) {
                AppMethods.a(AppInfo.d().getResources().getString(2131758444));
                if (this.a) {
                  (UserInfo.a().i()).is_invisible_all = 1;
                } else {
                  (UserInfo.a().i()).is_invisible_all = 0;
                } 
                if (this.b) {
                  (UserInfo.a().i()).is_invisible_half = 1;
                } else {
                  (UserInfo.a().i()).is_invisible_half = 0;
                } 
              } else {
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
              } 
              UserInfoDataObserver.a().b();
            }
          }UserInfo.a().i().getUid(), this.f); 
  }
  
  public void e(boolean paramBoolean) {
    if (this.j != paramBoolean) {
      String str;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      } 
      this.f.put("is_invisible_map", str);
    } 
  }
  
  public void f(boolean paramBoolean) {
    if (this.n != paramBoolean) {
      String str;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      } 
      this.f.put("forbid_selected_viewing", str);
    } 
  }
  
  public void g(boolean paramBoolean) {
    if (this.k != paramBoolean) {
      String str;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      } 
      this.f.put("is_hide_last_operate", str);
    } 
  }
  
  public void h(boolean paramBoolean) {
    if (this.l != paramBoolean) {
      String str;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      } 
      this.f.put("is_hide_distance", str);
    } 
  }
  
  public void i(boolean paramBoolean) {
    if (this.m != paramBoolean) {
      String str;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      } 
      this.f.put("is_traceless_access", str);
    } 
  }
  
  public void j(boolean paramBoolean) {
    if (this.o != paramBoolean || !this.b.equals(this.a)) {
      String str;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      } 
      this.f.put("is_invisible_half", str);
      this.f.put("stealth_distance", this.b);
    } 
  }
  
  public void k(boolean paramBoolean) {
    if (this.p != paramBoolean) {
      String str;
      Map<String, String> map = this.f;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      } 
      map.put("is_un_disturb", str);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\Presenter\PrivacySettingPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */