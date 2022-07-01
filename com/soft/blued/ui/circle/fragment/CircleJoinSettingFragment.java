package com.soft.blued.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.ui.circle.presenter.CircleJoinSettingPresenter;
import com.soft.blued.utils.BluedPreferences;
import java.io.Serializable;

public class CircleJoinSettingFragment extends MvpFragment<CircleJoinSettingPresenter> {
  private boolean d = false;
  
  private String e = "";
  
  @BindView(2131297686)
  ImageView ivApply;
  
  @BindView(2131297748)
  ImageView ivDirect;
  
  @BindView(2131298709)
  LinearLayout llApply;
  
  @BindView(2131298776)
  LinearLayout llDirect;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  public static void a(Context paramContext, MyCircleModel paramMyCircleModel) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("circle_data", (Serializable)paramMyCircleModel);
    TerminalActivity.d(paramContext, CircleJoinSettingFragment.class, bundle);
  }
  
  public boolean V_() {
    k();
    return super.V_();
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    if (BluedPreferences.eA()) {
      this.ivDirect.setVisibility(0);
      this.ivApply.setVisibility(8);
    } else {
      this.ivDirect.setVisibility(8);
      this.ivApply.setVisibility(0);
    } 
    this.title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.k();
          }
        });
  }
  
  public void k() {
    if (this.d)
      ((CircleJoinSettingPresenter)s()).d(this.e); 
    getActivity().finish();
  }
  
  @OnClick({2131298776, 2131298709})
  public void onViewClicked(View paramView) {
    int i = paramView.getId();
    if (i != 2131298709) {
      if (i != 2131298776)
        return; 
      EventTrackFeed.f(FeedProtos.Event.CIRCLE_SETTINGS_PAGE_JOIN_ALL_CLICK, ((CircleJoinSettingPresenter)s()).m());
      this.ivDirect.setVisibility(0);
      this.ivApply.setVisibility(8);
      this.e = "1";
      this.d = true;
      BluedPreferences.W(this.e.equals("1"));
      return;
    } 
    EventTrackFeed.f(FeedProtos.Event.CIRCLE_SETTINGS_PAGE_JOIN_REPLY_CLICK, ((CircleJoinSettingPresenter)s()).m());
    this.ivDirect.setVisibility(8);
    this.ivApply.setVisibility(0);
    this.e = "0";
    this.d = true;
    BluedPreferences.W(this.e.equals("1"));
  }
  
  public int p() {
    return 2131493094;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleJoinSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */