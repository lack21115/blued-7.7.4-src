package com.soft.blued.ui.msg.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.db.model.SessionSettingModel;

public class SelectSessionAdapter extends BaseQuickAdapter<SessionModel, BaseViewHolder> {
  private IRequestHost a;
  
  public SelectSessionAdapter(IRequestHost paramIRequestHost) {
    super(2131493645);
    this.a = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, SessionModel paramSessionModel) {
    String str2 = paramSessionModel.nickName;
    String str1 = str2;
    if (paramSessionModel.sessionSettingModel != null) {
      SessionSettingModel sessionSettingModel = (SessionSettingModel)paramSessionModel.sessionSettingModel;
      str1 = str2;
      if (!TextUtils.isEmpty(sessionSettingModel.getSessinoNote()))
        str1 = sessionSettingModel.getSessinoNote(); 
    } 
    paramBaseViewHolder.a(2131301088, str1);
    ((ImageView)paramBaseViewHolder.d(2131297902)).setSelected(paramSessionModel.checked);
    ImageLoader.a(this.a, paramSessionModel.avatar).c().a(2131234356).a((ImageView)paramBaseViewHolder.d(2131297804));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\SelectSessionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */