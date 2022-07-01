package com.soft.blued.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.ui.circle.presenter.CircleSettingPresenter;
import java.io.Serializable;

public class CircleSettingFragment extends MvpFragment<CircleSettingPresenter> {
  private Context d;
  
  private MyCircleModel e;
  
  @BindView(2131297818)
  ImageView ivJoinSettingIcon;
  
  @BindView(2131298893)
  LinearLayout llInfoSetting;
  
  @BindView(2131298904)
  LinearLayout llJoinSetting;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  @BindView(2131300938)
  TextView tvJoinSetting;
  
  public static void a(Context paramContext, MyCircleModel paramMyCircleModel) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("circle_data", (Serializable)paramMyCircleModel);
    TerminalActivity.d(paramContext, CircleSettingFragment.class, bundle);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = getContext();
    this.e = ((CircleSettingPresenter)s()).m();
    if ((((CircleSettingPresenter)s()).m()).is_disclosure == 0) {
      this.tvJoinSetting.setTextColor(this.d.getResources().getColor(2131100842));
      this.ivJoinSettingIcon.setImageDrawable(BluedSkinUtils.b(this.d, 2131232453));
    } 
    this.title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
  }
  
  @OnClick({2131298893, 2131298904})
  public void onViewClicked(View paramView) {
    int i = paramView.getId();
    if (i != 2131298893) {
      if (i != 2131298904)
        return; 
      if ((((CircleSettingPresenter)s()).m()).is_disclosure == 1) {
        EventTrackFeed.f(FeedProtos.Event.CIRCLE_SETTINGS_PAGE_JOIN_CLICK, ((CircleSettingPresenter)s()).n());
        CircleJoinSettingFragment.a(getContext(), this.e);
        return;
      } 
    } else {
      EventTrackFeed.f(FeedProtos.Event.CIRCLE_SETTINGS_PAGE_INFO_CLICK, ((CircleSettingPresenter)s()).n());
      CircleInfoSettingFragment.a(getContext(), ((CircleSettingPresenter)s()).m());
    } 
  }
  
  public int p() {
    return 2131493100;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */