package com.soft.blued.ui.setting.adapter;

import android.util.Log;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.user.model.UserTag;
import java.util.ArrayList;

public class UserLabelAdapter extends BaseMultiItemQuickAdapter<UserTag, BaseViewHolder> {
  private TextView a;
  
  public UserLabelAdapter() {
    super(new ArrayList());
    a();
  }
  
  private void a() {
    b(0, 2131493667);
    b(1, 2131493672);
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, UserTag paramUserTag) {
    paramBaseViewHolder.a(2131301575, paramUserTag.name);
  }
  
  private void c(BaseViewHolder paramBaseViewHolder, UserTag paramUserTag) {
    this.a = (TextView)paramBaseViewHolder.d(2131301574);
    this.a.setText(paramUserTag.name);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bindLabelView:");
    stringBuilder.append(paramUserTag.name);
    stringBuilder.append(" -- ");
    stringBuilder.append(paramUserTag.checked);
    Log.v("drb", stringBuilder.toString());
    if (paramUserTag.checked == 1) {
      this.a.setBackgroundResource(2131234362);
      this.a.setTextColor(this.k.getResources().getColor(2131100728));
    } else {
      this.a.setBackgroundResource(2131234361);
      this.a.setTextColor(this.k.getResources().getColor(2131100838));
    } 
    if (!paramUserTag.chooseable) {
      this.a.setBackgroundResource(2131234361);
      this.a.setTextColor(this.k.getResources().getColor(2131100842));
      return;
    } 
    TextView textView = this.a;
    textView.setBackground(textView.getBackground());
    textView = this.a;
    textView.setTextColor(textView.getTextColors());
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, UserTag paramUserTag) {
    if (paramBaseViewHolder != null) {
      int i = paramBaseViewHolder.getItemViewType();
      if (i != 0) {
        if (i != 1)
          return; 
        b(paramBaseViewHolder, paramUserTag);
        return;
      } 
      c(paramBaseViewHolder, paramUserTag);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\adapter\UserLabelAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */