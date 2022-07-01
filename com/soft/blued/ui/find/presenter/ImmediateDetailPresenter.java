package com.soft.blued.ui.find.presenter;

import android.content.Context;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.model.BluedMyExtra;
import com.soft.blued.ui.find.contract.ImmediateDetailContract;
import com.soft.blued.ui.find.model.ImmediateTabModel;
import com.soft.blued.ui.find.model.ImmediateUserModel;
import java.util.List;

public class ImmediateDetailPresenter implements ImmediateDetailContract.IPresenter {
  private Context a;
  
  private ImmediateDetailContract.IView b;
  
  private IRequestHost c;
  
  private String d;
  
  private String e;
  
  private int f;
  
  public void b() {
    NearbyHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<ImmediateTabModel>>(this, this.c) {
          public void a(BluedEntityA<ImmediateTabModel> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                if (param1BluedEntityA.hasData()) {
                  ImmediateTabModel immediateTabModel = param1BluedEntityA.data.get(0);
                  List list = ((ImmediateTabModel)param1BluedEntityA.data.get(0)).conf;
                  if (list != null && list.size() > 0) {
                    ImmediateDetailPresenter.a(this.a).a(immediateTabModel);
                    return;
                  } 
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
              }  
          }
        }this.c, "");
  }
  
  public void bb_() {
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\presenter\ImmediateDetailPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */