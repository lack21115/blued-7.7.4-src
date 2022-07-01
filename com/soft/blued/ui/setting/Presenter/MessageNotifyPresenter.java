package com.soft.blued.ui.setting.Presenter;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.user.UserInfo;
import java.util.Map;

public class MessageNotifyPresenter extends MvpPresenter {
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void a(Map<String, String> paramMap) {
    if (paramMap != null) {
      if (paramMap.size() == 0)
        return; 
      MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
            public void a(BluedEntityA<Object> param1BluedEntityA) {}
          },  UserInfo.a().i().getUid(), paramMap, null);
    } 
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\Presenter\MessageNotifyPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */