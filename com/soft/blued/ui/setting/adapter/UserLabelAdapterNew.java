package com.soft.blued.ui.setting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.live.base.view.FlowLayout;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.user.model.UserTag;
import java.util.ArrayList;

public class UserLabelAdapterNew extends BaseMultiItemQuickAdapter<UserTag, BaseViewHolder> {
  private Context a;
  
  private OnItemClickListener b;
  
  public UserLabelAdapterNew(Context paramContext) {
    super(new ArrayList());
    this.a = paramContext;
    a();
  }
  
  private void a() {
    b(0, 2131493668);
    b(1, 2131493672);
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, UserTag paramUserTag) {
    paramBaseViewHolder.a(2131301575, paramUserTag.name);
  }
  
  private void c(BaseViewHolder paramBaseViewHolder, UserTag paramUserTag) {
    FlowLayout flowLayout = (FlowLayout)paramBaseViewHolder.d(2131301572);
    if (paramUserTag.tagList != null && paramUserTag.tagList.size() > 0) {
      flowLayout.removeAllViews();
      for (int i = 0; i < paramUserTag.tagList.size(); i++) {
        View view = LayoutInflater.from(this.a).inflate(2131494215, null);
        TextView textView = (TextView)view.findViewById(2131301371);
        textView.setText(((UserTag)paramUserTag.tagList.get(i)).name);
        if (((UserTag)paramUserTag.tagList.get(i)).checked == 0) {
          textView.setBackgroundResource(2131234361);
          textView.setTextColor(BluedSkinUtils.a(this.a, 2131100838));
        } else {
          textView.setBackgroundResource(2131234362);
          textView.setTextColor(BluedSkinUtils.a(this.a, 2131100838));
        } 
        if (!((UserTag)paramUserTag.tagList.get(i)).chooseable) {
          textView.setBackgroundResource(2131234361);
          textView.setTextColor(BluedSkinUtils.a(this.a, 2131100842));
        } else {
          textView.setBackground(textView.getBackground());
          textView.setTextColor(textView.getTextColors());
        } 
        flowLayout.addView(view);
      } 
      flowLayout.setOnItemClickListener(new FlowLayout.OnItemClickListener(this, paramUserTag) {
            public void a(View param1View, int param1Int) {
              if (UserLabelAdapterNew.a(this.b) != null)
                UserLabelAdapterNew.a(this.b).a(this.a, param1Int); 
            }
          });
    } 
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
  
  public void a(OnItemClickListener paramOnItemClickListener) {
    this.b = paramOnItemClickListener;
  }
  
  public static interface OnItemClickListener {
    void a(UserTag param1UserTag, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\adapter\UserLabelAdapterNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */