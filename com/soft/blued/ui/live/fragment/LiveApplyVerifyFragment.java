package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.live.presenter.LiveApplyVerifyPresenter;
import java.io.Serializable;

public class LiveApplyVerifyFragment extends MvpFragment<LiveApplyVerifyPresenter> implements View.OnClickListener {
  private BluedLiveState d;
  
  private Context e;
  
  @BindView(2131300300)
  CommonTopTitleNoTrans top_title;
  
  @BindView(2131301394)
  TextView tv_tip_1;
  
  public static void a(Context paramContext, BluedLiveState paramBluedLiveState) {
    Bundle bundle = new Bundle();
    if (paramBluedLiveState != null)
      bundle.putSerializable("applyState", (Serializable)paramBluedLiveState); 
    TerminalActivity.d(paramContext, LiveApplyVerifyFragment.class, bundle);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.top_title.e();
    this.top_title.a();
    this.top_title.setLeftImgDrawable(BluedSkinUtils.b(this.e, 2131232743));
    this.top_title.setCenterText(getString(2131755104));
    this.top_title.setLeftClickListener(this);
    BluedLiveState bluedLiveState = this.d;
    if (bluedLiveState != null && bluedLiveState.is_easy_way == 0) {
      this.tv_tip_1.setText(getText(2131755085));
      return;
    } 
    this.tv_tip_1.setText(getText(2131755084));
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.e = getContext();
    if (getArguments() != null && getArguments().getSerializable("applyState") != null)
      this.d = (BluedLiveState)getArguments().getSerializable("applyState"); 
  }
  
  public int p() {
    return 2131493171;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveApplyVerifyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */