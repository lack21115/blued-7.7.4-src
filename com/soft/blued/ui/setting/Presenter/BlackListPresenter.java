package com.soft.blued.ui.setting.Presenter;

import android.content.Context;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.setting.Contract.IBlackListContract;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.user.UserInfo;
import java.util.List;

public class BlackListPresenter implements IBlackListContract.IPresenter {
  BluedUIHttpResponse a = new BluedUIHttpResponse<BluedEntityA<BluedBlackList>>(this, this.d) {
      private boolean b;
      
      protected void a(BluedEntityA<BluedBlackList> param1BluedEntityA) {
        if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
          if (param1BluedEntityA.data.size() >= BlackListPresenter.a(this.a)) {
            BlackListPresenter.a(this.a, true);
            BlackListPresenter.b(this.a).a();
          } else {
            BlackListPresenter.a(this.a, false);
            BlackListPresenter.b(this.a).b();
          } 
          if (BlackListPresenter.c(this.a) == 1) {
            BlackListPresenter.a(this.a, param1BluedEntityA.data);
            BlackListPresenter.b(this.a).b(param1BluedEntityA.data);
            return;
          } 
          BlackListPresenter.d(this.a).addAll(param1BluedEntityA.data);
          BlackListPresenter.b(this.a).a(param1BluedEntityA.data);
        } 
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.b = true;
        if (BlackListPresenter.c(this.a) != 1)
          BlackListPresenter.e(this.a); 
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        BlackListPresenter.b(this.a).c();
        if (BlackListPresenter.d(this.a) == null || BlackListPresenter.d(this.a).size() == 0) {
          if (this.b) {
            BlackListPresenter.b(this.a).ba_();
          } else {
            BlackListPresenter.b(this.a).d();
          } 
        } else {
          BlackListPresenter.b(this.a).e();
        } 
        super.onUIFinish();
      }
    };
  
  private IBlackListContract.IView b;
  
  private Context c;
  
  private IRequestHost d;
  
  private int e = 10;
  
  private int f;
  
  private boolean g;
  
  private List<BluedBlackList> h;
  
  public BlackListPresenter(Context paramContext, IRequestHost paramIRequestHost, IBlackListContract.IView paramIView, int paramInt) {
    this.c = paramContext;
    this.d = paramIRequestHost;
    this.b = paramIView;
    if (paramInt > 0)
      this.e = paramInt; 
  }
  
  private void a(boolean paramBoolean) {
    String str1;
    if (paramBoolean)
      this.f = 1; 
    if (this.f == 1)
      this.g = true; 
    if (!this.g) {
      int i = this.f;
      if (i != 1) {
        this.f = i - 1;
        AppMethods.a(this.c.getResources().getString(2131756083));
        this.b.c();
        return;
      } 
    } 
    if (this.f != 1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append((this.f - 1) * 10);
      stringBuilder1.append("");
      str1 = stringBuilder1.toString();
    } else {
      str1 = "0";
    } 
    Context context = this.c;
    BluedUIHttpResponse bluedUIHttpResponse = this.a;
    String str2 = UserInfo.a().i().getUid();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.e);
    stringBuilder.append("");
    MineHttpUtils.g(context, bluedUIHttpResponse, str2, str1, stringBuilder.toString(), this.d);
  }
  
  public void b() {
    a(true);
  }
  
  public void bb_() {}
  
  public void c() {
    this.f++;
    a(false);
  }
  
  public void d() {
    if (4 == UserInfo.a().i().getVBadge() || 7 == UserInfo.a().i().getVBadge()) {
      this.b.a(false);
      return;
    } 
    this.b.a(true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\Presenter\BlackListPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */