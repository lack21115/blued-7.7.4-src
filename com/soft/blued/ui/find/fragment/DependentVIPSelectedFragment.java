package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.utils.Logger;

public class DependentVIPSelectedFragment extends MvpFragment {
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, DependentVIPSelectedFragment.class, null);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.title.setLeftClickListener(new -$$Lambda$DependentVIPSelectedFragment$vJETfRoMuPgG4wgWdXcYhWAHX3c(this));
    this.title.a();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    Logger.a("DependentVIPSelectedFragment", "onViewCreated");
    NearbyPeopleTabPageVIPFragment nearbyPeopleTabPageVIPFragment = NearbyPeopleTabPageVIPFragment.r();
    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
    fragmentTransaction.replace(2131296830, (Fragment)nearbyPeopleTabPageVIPFragment);
    fragmentTransaction.commitAllowingStateLoss();
  }
  
  public int p() {
    return 2131493116;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\DependentVIPSelectedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */