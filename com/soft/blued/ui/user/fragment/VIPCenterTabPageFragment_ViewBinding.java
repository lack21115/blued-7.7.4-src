package com.soft.blued.ui.user.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.LabeledTextView;

public class VIPCenterTabPageFragment_ViewBinding implements Unbinder {
  private VIPCenterTabPageFragment b;
  
  public VIPCenterTabPageFragment_ViewBinding(VIPCenterTabPageFragment paramVIPCenterTabPageFragment, View paramView) {
    this.b = paramVIPCenterTabPageFragment;
    paramVIPCenterTabPageFragment.listView = (RecyclerView)Utils.a(paramView, 2131298144, "field 'listView'", RecyclerView.class);
    paramVIPCenterTabPageFragment.vipServiceTerms = (LabeledTextView)Utils.a(paramView, 2131301712, "field 'vipServiceTerms'", LabeledTextView.class);
    paramVIPCenterTabPageFragment.vipProtocolTerms = (LabeledTextView)Utils.a(paramView, 2131301711, "field 'vipProtocolTerms'", LabeledTextView.class);
    paramVIPCenterTabPageFragment.vipHelpCenter = (LabeledTextView)Utils.a(paramView, 2131301705, "field 'vipHelpCenter'", LabeledTextView.class);
    paramVIPCenterTabPageFragment.vipOrderRecord = (LabeledTextView)Utils.a(paramView, 2131301706, "field 'vipOrderRecord'", LabeledTextView.class);
    paramVIPCenterTabPageFragment.vipPrivacyClause = (LabeledTextView)Utils.a(paramView, 2131301707, "field 'vipPrivacyClause'", LabeledTextView.class);
    paramVIPCenterTabPageFragment.tvBuyBtn = (TextView)Utils.a(paramView, 2131300598, "field 'tvBuyBtn'", TextView.class);
    paramVIPCenterTabPageFragment.llBuy = (CardView)Utils.a(paramView, 2131298736, "field 'llBuy'", CardView.class);
    paramVIPCenterTabPageFragment.scrollView = (NestedScrollView)Utils.a(paramView, 2131299842, "field 'scrollView'", NestedScrollView.class);
    paramVIPCenterTabPageFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131299441, "field 'title'", CommonTopTitleNoTrans.class);
    paramVIPCenterTabPageFragment.titleHover = (CommonTopTitleNoTrans)Utils.a(paramView, 2131299442, "field 'titleHover'", CommonTopTitleNoTrans.class);
    paramVIPCenterTabPageFragment.vipProtocolExpLvl = Utils.a(paramView, 2131301710, "field 'vipProtocolExpLvl'");
    paramVIPCenterTabPageFragment.tvProtocolExpLvlBtmLine = Utils.a(paramView, 2131301207, "field 'tvProtocolExpLvlBtmLine'");
    paramVIPCenterTabPageFragment.imgHeaderBg = (ImageView)Utils.a(paramView, 2131297491, "field 'imgHeaderBg'", ImageView.class);
    paramVIPCenterTabPageFragment.imgVIPTitle = (ImageView)Utils.a(paramView, 2131297583, "field 'imgVIPTitle'", ImageView.class);
    paramVIPCenterTabPageFragment.viewBtmBanner = Utils.a(paramView, 2131301623, "field 'viewBtmBanner'");
  }
  
  public void unbind() {
    VIPCenterTabPageFragment vIPCenterTabPageFragment = this.b;
    if (vIPCenterTabPageFragment != null) {
      this.b = null;
      vIPCenterTabPageFragment.listView = null;
      vIPCenterTabPageFragment.vipServiceTerms = null;
      vIPCenterTabPageFragment.vipProtocolTerms = null;
      vIPCenterTabPageFragment.vipHelpCenter = null;
      vIPCenterTabPageFragment.vipOrderRecord = null;
      vIPCenterTabPageFragment.vipPrivacyClause = null;
      vIPCenterTabPageFragment.tvBuyBtn = null;
      vIPCenterTabPageFragment.llBuy = null;
      vIPCenterTabPageFragment.scrollView = null;
      vIPCenterTabPageFragment.title = null;
      vIPCenterTabPageFragment.titleHover = null;
      vIPCenterTabPageFragment.vipProtocolExpLvl = null;
      vIPCenterTabPageFragment.tvProtocolExpLvlBtmLine = null;
      vIPCenterTabPageFragment.imgHeaderBg = null;
      vIPCenterTabPageFragment.imgVIPTitle = null;
      vIPCenterTabPageFragment.viewBtmBanner = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\VIPCenterTabPageFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */