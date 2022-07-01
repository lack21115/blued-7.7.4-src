package com.soft.blued.ui.msg_group.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.utils.ToastUtils;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.ui.msg_group.model.GroupMemberModel;

public class GroupMemberPresenter extends MvpPresenter {
  public static final String h = GroupMemberPresenter.class.getSimpleName();
  
  public int i = 1;
  
  int j = 20;
  
  public String k;
  
  public String l = "joined";
  
  public int m;
  
  boolean n;
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    MsgGroupHttpUtils.a(g(), this.k, this.l, this.i, this.j, new BluedUIHttpResponse<BluedEntityA<GroupMemberModel>>(this, g(), paramIFetchDataListener) {
          protected void a(BluedEntityA<GroupMemberModel> param1BluedEntityA) {
            if (param1BluedEntityA.hasData()) {
              this.a.a("data_member", param1BluedEntityA.data);
              this.b.n = param1BluedEntityA.hasMore();
            } 
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (!param1Boolean) {
              GroupMemberPresenter groupMemberPresenter = this.b;
              groupMemberPresenter.i--;
            } 
            this.a.a(param1Boolean);
            if (param1Boolean && !this.b.n)
              this.a.b(); 
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.a();
          }
        });
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null) {
      this.k = paramBundle1.getString("group_id");
      this.m = paramBundle1.getInt("group_role");
    } 
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.i = 1;
    this.n = true;
    c(paramIFetchDataListener);
  }
  
  public void a(String paramString, int paramInt, int... paramVarArgs) {
    MsgGroupHttpUtils.a(g(), this.k, paramString, paramInt, new BluedUIHttpResponse<BluedEntityA>(this, g(), paramInt, paramVarArgs) {
          protected void a(BluedEntityA param1BluedEntityA) {}
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            ToastUtils.a(AppInfo.d().getString(2131756644));
            if (param1Boolean) {
              int i = this.a;
              if (i == 4) {
                this.c.b("data_delete");
                return;
              } 
              if (i == 2) {
                int[] arrayOfInt = this.b;
                if (arrayOfInt != null && arrayOfInt.length > 0) {
                  this.c.a("data_set_manager", Integer.valueOf(arrayOfInt[0]));
                  return;
                } 
              } else if (i == 1) {
                this.c.i();
              } 
            } 
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
        });
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.i++;
    c(paramIFetchDataListener);
  }
  
  public void d(String paramString) {
    MsgGroupHttpUtils.a(g(), this.k, paramString, new BluedUIHttpResponse<BluedEntityA<GroupMemberModel>>(this, g()) {
          protected void a(BluedEntityA<GroupMemberModel> param1BluedEntityA) {
            if (param1BluedEntityA.hasData())
              this.a.a("data_search", param1BluedEntityA.data); 
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            this.a.a("update_no_data_view", new Boolean(param1Boolean));
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\presenter\GroupMemberPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */