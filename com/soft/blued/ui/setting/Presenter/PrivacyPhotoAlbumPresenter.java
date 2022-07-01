package com.soft.blued.ui.setting.Presenter;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;

public class PrivacyPhotoAlbumPresenter implements PrivacyPhotoAlbumContract.IPresenter {
  private static final String a = PrivacyPhotoAlbumPresenter.class.getSimpleName();
  
  private Context b;
  
  private PrivacyPhotoAlbumContract.IView c;
  
  private IRequestHost d;
  
  private Dialog e;
  
  private boolean f;
  
  private BluedUIHttpResponse g = new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(this) {
      public void a(BluedEntityA<UserInfoEntity> param1BluedEntityA) {
        if (param1BluedEntityA != null) {
          DialogUtils.b(PrivacyPhotoAlbumPresenter.e(this.a));
          UserInfoEntity userInfoEntity = param1BluedEntityA.data.get(0);
          if (userInfoEntity != null) {
            if (userInfoEntity.album != null) {
              UserInfo.a().i().setAlbum(userInfoEntity.album);
              return;
            } 
          } else {
            AppMethods.d(2131756584);
            return;
          } 
        } else {
          AppMethods.d(2131756584);
        } 
      }
    };
  
  public PrivacyPhotoAlbumPresenter(Context paramContext, PrivacyPhotoAlbumContract.IView paramIView, IRequestHost paramIRequestHost) {
    if (paramContext != null && paramIView != null) {
      this.b = paramContext;
      this.c = paramIView;
      this.d = paramIRequestHost;
      this.e = DialogUtils.a(this.b);
    } 
  }
  
  public void a(int paramInt1, int paramInt2) {
    ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<UserFindResult>>(this, paramInt1) {
          protected BluedEntityA<UserFindResult> a(String param1String) {
            Logger.a(PrivacyPhotoAlbumPresenter.e(), new Object[] { "getAuthedUserList, content:", param1String });
            return (BluedEntityA<UserFindResult>)super.parseData(param1String);
          }
          
          public void a(BluedEntityA<UserFindResult> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                PrivacyPhotoAlbumPresenter.a(this.b, param1BluedEntityA.hasMore());
                PrivacyPhotoAlbumPresenter.a(this.b).a(param1BluedEntityA.data);
                return;
              } catch (android.content.res.Resources.NotFoundException notFoundException) {
                notFoundException.printStackTrace();
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              }  
            AppMethods.a(AppInfo.d().getResources().getString(2131756082));
          }
          
          public void onUIFinish() {
            if (this.a == 1)
              PrivacyPhotoAlbumPresenter.a(this.b).c(); 
            PrivacyPhotoAlbumPresenter.a(this.b).b();
          }
          
          public void onUIStart() {
            if (this.a == 1)
              PrivacyPhotoAlbumPresenter.a(this.b).d(); 
          }
        }UserInfo.a().i().getUid(), paramInt1, paramInt2, null);
  }
  
  public void a(String paramString) {
    ProfileHttpUtils.b(this.b, new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>(this, this.d, paramString) {
          protected void a(BluedEntityA<BluedLoginResult> param1BluedEntityA) {
            AppMethods.d(2131756181);
            PrivacyPhotoAlbumPresenter.a(this.b).a(this.a);
            UserInfoDataObserver.a().b();
            UserHttpUtils.a(PrivacyPhotoAlbumPresenter.b(this.b), PrivacyPhotoAlbumPresenter.c(this.b), UserInfo.a().i().getName(), PrivacyPhotoAlbumPresenter.d(this.b));
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(PrivacyPhotoAlbumPresenter.e(this.b));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(PrivacyPhotoAlbumPresenter.e(this.b));
          }
        }paramString, this.d);
  }
  
  public void a(String paramString, int paramInt) {
    ProfileHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<Object>>(this, paramInt) {
          protected BluedEntityA<Object> a(String param1String) {
            Logger.a(PrivacyPhotoAlbumPresenter.e(), new Object[] { "deleteAuthedUser, content:", param1String });
            return (BluedEntityA<Object>)super.parseData(param1String);
          }
          
          public void a(BluedEntityA<Object> param1BluedEntityA) {
            if (param1BluedEntityA == null)
              try {
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              }  
            PrivacyPhotoAlbumPresenter.a(this.b).a(this.a);
          }
          
          public void onUIFinish() {
            PrivacyPhotoAlbumPresenter.a(this.b).c();
          }
          
          public void onUIStart() {
            PrivacyPhotoAlbumPresenter.a(this.b).d();
          }
        }UserInfo.a().i().getUid(), paramString, null);
  }
  
  public void a(boolean paramBoolean) {
    String str;
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    } 
    ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this, paramBoolean) {
          protected BluedEntityA<Object> a(String param1String) {
            Logger.a(PrivacyPhotoAlbumPresenter.e(), new Object[] { "setPrivacyPhotoAlbumSetting, content:", param1String });
            return (BluedEntityA<Object>)super.parseData(param1String);
          }
          
          public void a(BluedEntityA<Object> param1BluedEntityA) {
            if (param1BluedEntityA == null)
              try {
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              }  
            BluedPreferences.B(this.a);
            if (this.a) {
              AppMethods.a(PrivacyPhotoAlbumPresenter.b(this.b).getResources().getString(2131755300));
              return;
            } 
            AppMethods.a(PrivacyPhotoAlbumPresenter.b(this.b).getResources().getString(2131755299));
          }
          
          public void onUIFinish() {
            PrivacyPhotoAlbumPresenter.a(this.b).c();
          }
          
          public void onUIStart() {
            PrivacyPhotoAlbumPresenter.a(this.b).d();
          }
        }UserInfo.a().i().getUid(), str, null);
  }
  
  public void b() {
    ProfileHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
          protected BluedEntityA<Object> a(String param1String) {
            Logger.a(PrivacyPhotoAlbumPresenter.e(), new Object[] { "deleteAllAuthedUsers, content:", param1String });
            return (BluedEntityA<Object>)super.parseData(param1String);
          }
          
          public void a(BluedEntityA<Object> param1BluedEntityA) {
            if (param1BluedEntityA == null)
              try {
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              }  
            PrivacyPhotoAlbumPresenter.a(this.a).a();
          }
          
          public void onUIFinish() {
            PrivacyPhotoAlbumPresenter.a(this.a).c();
          }
          
          public void onUIStart() {
            PrivacyPhotoAlbumPresenter.a(this.a).d();
          }
        }UserInfo.a().i().getUid(), null);
  }
  
  public void bb_() {
    d();
  }
  
  public boolean c() {
    return this.f;
  }
  
  public void d() {
    ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<BluedBlackList.privacySettingEntity>>(this) {
          protected BluedEntityA<BluedBlackList.privacySettingEntity> a(String param1String) {
            Logger.a(PrivacyPhotoAlbumPresenter.e(), new Object[] { "getPrivacyPhotoAlbumSetting, content:", param1String });
            return (BluedEntityA<BluedBlackList.privacySettingEntity>)super.parseData(param1String);
          }
          
          public void a(BluedEntityA<BluedBlackList.privacySettingEntity> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                if (param1BluedEntityA.hasData())
                  return; 
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              } catch (android.content.res.Resources.NotFoundException notFoundException) {
                notFoundException.printStackTrace();
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              }  
            AppMethods.a(AppInfo.d().getResources().getString(2131756082));
          }
        }UserInfo.a().i().getUid(), null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\Presenter\PrivacyPhotoAlbumPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */