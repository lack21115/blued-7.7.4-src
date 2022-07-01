package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.yy_china.R;

public class YYStudioErrorFragment extends MvpFragment<MvpPresenter> {
  private ImageView d;
  
  private TextView e;
  
  private RelativeLayout f;
  
  private ImageView g;
  
  public static void a(Context paramContext, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("error_msg", paramString);
    TerminalActivity.a(bundle);
    TerminalActivity.b(bundle);
    TerminalActivity.d(paramContext, YYStudioErrorFragment.class, bundle);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = (ImageView)this.l.findViewById(R.id.img_right);
    this.e = (TextView)this.l.findViewById(R.id.tv_error);
    this.f = (RelativeLayout)this.l.findViewById(R.id.ll_common_title);
    this.g = (ImageView)this.l.findViewById(R.id.ctt_left);
    if (StatusBarHelper.a()) {
      this.f.setPadding(0, StatusBarHelper.a((Context)getActivity()), 0, 0);
      ((FrameLayout.LayoutParams)this.d.getLayoutParams()).topMargin = DensityUtils.a(getContext(), 35.0F) + StatusBarHelper.a(getContext());
    } 
    this.f.setBackgroundColor(getResources().getColor(R.color.transparent));
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
    String str = getArguments().getString("error_msg");
    this.e.setText(str);
  }
  
  public int p() {
    return R.layout.fragment_yy_studio_error_layout;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\YYStudioErrorFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */