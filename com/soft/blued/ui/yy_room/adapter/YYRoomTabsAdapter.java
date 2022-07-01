package com.soft.blued.ui.yy_room.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.yy_china.model.YYTopicModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

public class YYRoomTabsAdapter extends BaseQuickAdapter<YYTopicModel, BaseViewHolder> {
  private String a;
  
  public YYRoomTabsAdapter(Context paramContext, String paramString) {
    super(2131493726, new ArrayList());
    this.k = paramContext;
    this.a = paramString;
  }
  
  public void a(int paramInt) {
    if (paramInt >= n().size())
      return; 
    YYTopicModel yYTopicModel = n().get(paramInt);
    for (YYTopicModel yYTopicModel1 : n()) {
      if (TextUtils.equals(yYTopicModel1.type_id, yYTopicModel.type_id)) {
        yYTopicModel1.isChecked = true;
        continue;
      } 
      yYTopicModel1.isChecked = false;
    } 
    notifyDataSetChanged();
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, YYTopicModel paramYYTopicModel) {
    TextView textView = (TextView)paramBaseViewHolder.d(2131301368);
    textView.setText(paramYYTopicModel.room_type);
    View view = paramBaseViewHolder.d(2131299094);
    if (paramYYTopicModel.isChecked) {
      textView.setTextColor(BluedSkinUtils.a(this.k, 2131100838));
    } else {
      textView.setTextColor(BluedSkinUtils.a(this.k, 2131100844));
    } 
    if (paramBaseViewHolder.getAdapterPosition() == n().size() - 1) {
      view.setVisibility(8);
      return;
    } 
    view.setVisibility(0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\adapter\YYRoomTabsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */