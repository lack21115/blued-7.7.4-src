package com.soft.blued.ui.group.contract;

import android.os.Bundle;
import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;

public class IGroupInfoContract {
  public static interface IPresenter extends BasePresenter {}
  
  public static interface IView extends BaseView<IPresenter> {
    Bundle a();
    
    void a(BluedCreatedGroupInfo param1BluedCreatedGroupInfo);
    
    void a(String param1String);
    
    void a(boolean param1Boolean);
    
    void a(String[] param1ArrayOfString);
    
    void aJ_();
    
    void aK_();
    
    void b();
    
    void d();
    
    void e();
    
    void h();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\contract\IGroupInfoContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */