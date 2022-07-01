package com.soft.blued.ui.msg.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.msg.pop.BottomMenuPop;
import com.soft.blued.utils.StringUtils;
import java.util.List;

public class BottomMenuAdapter extends BaseQuickAdapter<BottomMenuPop.MenuItemInfo, BaseViewHolder> {
  public BottomMenuAdapter(List<BottomMenuPop.MenuItemInfo> paramList) {
    super(2131493628, paramList);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BottomMenuPop.MenuItemInfo paramMenuItemInfo) {
    TextView textView = (TextView)paramBaseViewHolder.d(2131300463);
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297390);
    imageView.setVisibility(8);
    if (!StringUtils.e(paramMenuItemInfo.a)) {
      textView.setText(paramMenuItemInfo.a);
      if (paramMenuItemInfo.a.equals(textView.getContext().getResources().getString(2131758011))) {
        imageView.setVisibility(0);
        imageView.setImageResource(2131232731);
      } 
    } 
    if (paramMenuItemInfo.b != 0)
      textView.setTextColor(BluedSkinUtils.a(this.k, paramMenuItemInfo.b)); 
    paramBaseViewHolder.d(2131299725).setOnClickListener(paramMenuItemInfo.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\BottomMenuAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */