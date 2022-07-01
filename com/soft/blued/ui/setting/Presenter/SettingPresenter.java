package com.soft.blued.ui.setting.Presenter;

import android.content.Context;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.setting.Contract.SettingContract;
import com.soft.blued.ui.user.model.VerifyStatus;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.UserRelationshipUtils;

public class SettingPresenter implements SettingContract.IPresenter {
  private ActivityFragmentActive a;
  
  private Context b;
  
  private SettingContract.IView c;
  
  public SettingPresenter(SettingContract.IView paramIView, Context paramContext, ActivityFragmentActive paramActivityFragmentActive) {
    if (paramIView != null && paramContext != null && paramActivityFragmentActive != null) {
      this.c = paramIView;
      this.b = paramContext;
      this.a = paramActivityFragmentActive;
    } 
  }
  
  public void b() {
    if (UserInfo.a().i() != null) {
      String str1 = UserInfo.a().i().getAvatar();
      String str2 = UserInfo.a().i().getName();
      String str3 = UserInfo.a().i().getUid();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(UserInfo.a().i().getVBadge());
      stringBuilder.append("");
      String str4 = stringBuilder.toString();
      VerifyStatus[] arrayOfVerifyStatus = UserInfo.a().i().getVerify();
      this.c.a(arrayOfVerifyStatus, str4, str2, str1, str3);
    } 
  }
  
  public void bb_() {
    d();
  }
  
  public void c() {
    UserRelationshipUtils.a("", new int[0]);
  }
  
  public void d() {
    GroupHttpUtils.k(null, new BluedUIHttpResponse<BluedEntityA<VerifyStatus>>(this, (IRequestHost)this.a) {
          public void a(BluedEntityA<VerifyStatus> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                if (param1BluedEntityA.hasData()) {
                  VerifyStatus verifyStatus = param1BluedEntityA.data.get(0);
                  UserInfo.a().i().setVerify(new VerifyStatus[] { verifyStatus });
                  VerifyStatus[] arrayOfVerifyStatus = UserInfo.a().i().getVerify();
                  SettingPresenter.a(this.a).a(arrayOfVerifyStatus);
                  return;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
                SettingPresenter.a(this.a).a();
              }  
          }
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            SettingPresenter.a(this.a).a();
          }
        }UserInfo.a().i().getUid(), null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\Presenter\SettingPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */