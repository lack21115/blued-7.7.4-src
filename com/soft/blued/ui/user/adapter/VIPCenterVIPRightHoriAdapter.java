package com.soft.blued.ui.user.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.vip.VipProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.setting.fragment.ChangeBluedIconFragment;
import com.soft.blued.ui.user.fragment.DynamicSkinFragment;
import com.soft.blued.ui.user.fragment.VipBubbleFragment;
import com.soft.blued.ui.user.fragment.VipInvisibleDialogFragment;
import com.soft.blued.ui.user.fragment.WidgetListFragment;
import com.soft.blued.ui.user.model.VIPRightOption;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.List;

public class VIPCenterVIPRightHoriAdapter extends BaseQuickAdapter<VIPRightOption, BaseViewHolder> {
  public IRequestHost a;
  
  int b;
  
  FragmentManager c;
  
  private VipInvisibleDialogFragment d;
  
  public VIPCenterVIPRightHoriAdapter(IRequestHost paramIRequestHost, List<VIPRightOption> paramList, int paramInt, FragmentManager paramFragmentManager) {
    super(2131493684, paramList);
    this.a = paramIRequestHost;
    this.b = paramInt;
    this.c = paramFragmentManager;
    this.d = new VipInvisibleDialogFragment();
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, VIPRightOption paramVIPRightOption) {
    if (paramBaseViewHolder != null) {
      if (paramVIPRightOption == null)
        return; 
      ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297463);
      TextView textView = (TextView)paramBaseViewHolder.d(2131301088);
      View view2 = paramBaseViewHolder.d(2131301679);
      View view1 = paramBaseViewHolder.d(2131297562);
      if (paramVIPRightOption.is_svip == 1) {
        view1.setVisibility(0);
      } else {
        view1.setVisibility(8);
      } 
      if (paramVIPRightOption.pid == 30 && !BluedPreferences.eo()) {
        view2.setVisibility(0);
        textView.setMaxWidth(DensityUtils.a(this.k, 71.0F));
      } else if (paramVIPRightOption.pid == 29 && !BluedPreferences.eq()) {
        view2.setVisibility(0);
        textView.setMaxWidth(DensityUtils.a(this.k, 71.0F));
      } else if (paramVIPRightOption.pid == 32 && !BluedPreferences.es()) {
        view2.setVisibility(0);
        textView.setMaxWidth(DensityUtils.a(this.k, 71.0F));
      } else {
        view2.setVisibility(8);
        textView.setMaxWidth(DensityUtils.a(this.k, 80.0F));
      } 
      ImageLoader.a(this.a, paramVIPRightOption.icon).a(imageView);
      if (!StringUtils.e(paramVIPRightOption.title)) {
        textView.setText(paramVIPRightOption.title);
        textView.setVisibility(0);
      } else {
        textView.setVisibility(8);
      } 
      if (paramVIPRightOption.pid == 4)
        this.d.a = paramVIPRightOption.title; 
      imageView.setOnClickListener(new -$$Lambda$VIPCenterVIPRightHoriAdapter$RVZbtzVzURr1K54gvIUJf-PklxM(this, paramVIPRightOption));
      textView.setOnClickListener(new -$$Lambda$VIPCenterVIPRightHoriAdapter$IWZ0CEvv-pcfCkxcyU8ZpzsYPnI(imageView));
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\VIPCenterVIPRightHoriAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */