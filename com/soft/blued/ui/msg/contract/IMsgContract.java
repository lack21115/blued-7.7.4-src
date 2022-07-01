package com.soft.blued.ui.msg.contract;

import android.app.Activity;
import android.content.Context;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.setting.Contract.IPrivacySettingContract;
import java.util.List;

public class IMsgContract {
  public static interface IPresenter extends BasePresenter {}
  
  public static interface IView extends BaseView<IPrivacySettingContract.IPresenter> {
    Activity a();
    
    void a(float param1Float, int param1Int);
    
    void a(int param1Int);
    
    void a(SessionModel param1SessionModel, String[] param1ArrayOfString);
    
    void a(String param1String1, String param1String2);
    
    void a(List<UserFindResult> param1List, boolean param1Boolean);
    
    void a(boolean param1Boolean);
    
    void a(boolean param1Boolean, int param1Int);
    
    Context b();
    
    void b(boolean param1Boolean);
    
    void c();
    
    void d();
    
    String e();
    
    void f();
    
    void g();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\contract\IMsgContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */