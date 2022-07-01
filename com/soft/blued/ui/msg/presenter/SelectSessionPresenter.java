package com.soft.blued.ui.msg.presenter;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import java.util.List;

public class SelectSessionPresenter extends MvpPresenter {
  public void a(IFetchDataListener paramIFetchDataListener) {
    ChatManager.getInstance().getSessionModelList(new FetchDataListener<List<SessionModel>>(this, paramIFetchDataListener) {
          public void a(List<SessionModel> param1List) {
            ChatHelperV4.a(param1List, true);
            this.a.a("data_session", param1List);
          }
        });
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\presenter\SelectSessionPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */