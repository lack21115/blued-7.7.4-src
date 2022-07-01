package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.user.model.VIPCenterForJsonParse;
import com.soft.blued.ui.user.views.NonVIPRightView;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;

public class NonVIPRightAdapter extends BaseQuickAdapter<VIPCenterForJsonParse.NonVIPPriviledge, BaseViewHolder> {
  Context a;
  
  IRequestHost b;
  
  LayoutInflater c;
  
  int d;
  
  FragmentManager e;
  
  public NonVIPRightAdapter(Context paramContext, int paramInt, FragmentManager paramFragmentManager, IRequestHost paramIRequestHost) {
    super(2131493619, new ArrayList());
    this.a = paramContext;
    this.b = paramIRequestHost;
    this.d = paramInt;
    this.c = LayoutInflater.from(this.a);
    this.e = paramFragmentManager;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, VIPCenterForJsonParse.NonVIPPriviledge paramNonVIPPriviledge) {
    if (paramBaseViewHolder != null && paramNonVIPPriviledge != null) {
      View view = paramBaseViewHolder.d(2131298900);
      NonVIPRightView nonVIPRightView = (NonVIPRightView)paramBaseViewHolder.d(2131299396);
      int i = paramBaseViewHolder.getAdapterPosition();
      if (i == 0) {
        nonVIPRightView.a();
      } else {
        nonVIPRightView.b();
      } 
      if (i == this.n.size()) {
        view.setBackground(BluedSkinUtils.b(this.a, 2131234026));
      } else {
        view.setBackgroundColor(BluedSkinUtils.a(this.a, 2131100728));
      } 
      Logger.a("vip_right_set_non_list", this.n);
      nonVIPRightView.a(this.b, paramNonVIPPriviledge, this.d, this.e);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\NonVIPRightAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */