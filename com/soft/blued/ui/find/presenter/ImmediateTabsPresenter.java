package com.soft.blued.ui.find.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.ui.find.contract.ImmediateTabsContract;
import com.soft.blued.ui.find.model.ImmediateTabModel;
import java.util.List;

public class ImmediateTabsPresenter implements ImmediateTabsContract.IPresenter {
  private ImmediateTabsContract.IView a;
  
  private IRequestHost b;
  
  public void b() {
    NearbyHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<ImmediateTabModel>>(this, this.b) {
          public void a(BluedEntityA<ImmediateTabModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData() && param1BluedEntityA.data.get(0) != null) {
              List list = ((ImmediateTabModel)param1BluedEntityA.data.get(0)).conf;
              if (list != null && list.size() > 0)
                ImmediateTabsPresenter.a(this.a).a(((ImmediateTabModel)param1BluedEntityA.data.get(0)).conf); 
            } 
          }
        }this.b, "main");
  }
  
  public void bb_() {
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\presenter\ImmediateTabsPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */