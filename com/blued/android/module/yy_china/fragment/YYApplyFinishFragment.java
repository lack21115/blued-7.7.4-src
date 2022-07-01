package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

public class YYApplyFinishFragment extends MvpFragment<MvpPresenter> implements View.OnClickListener {
  ImageView d;
  
  TextView e;
  
  ImageView f;
  
  TextView g;
  
  TextView h;
  
  ShapeTextView i;
  
  RelativeLayout j;
  
  private int n;
  
  public static void a(Context paramContext, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putInt("apply_state", paramInt);
    TerminalActivity.d(paramContext, YYApplyFinishFragment.class, bundle);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.n = getArguments().getInt("apply_state");
    this.i = (ShapeTextView)this.l.findViewById(R.id.tv_create);
    this.e = (TextView)this.l.findViewById(R.id.tv_title_text);
    this.d = (ImageView)this.l.findViewById(R.id.iv_back_img);
    this.f = (ImageView)this.l.findViewById(R.id.iv_status_img);
    this.g = (TextView)this.l.findViewById(R.id.tv_apply_status);
    this.h = (TextView)this.l.findViewById(R.id.tv_apply_content);
    this.j = (RelativeLayout)this.l.findViewById(R.id.rl_title_layout);
    this.e.setText(getResources().getString(R.string.yy_apply_finish_title));
    this.i.setOnClickListener(this);
    this.d.setOnClickListener(this);
    int i = this.n;
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return; 
        this.f.setImageResource(R.drawable.icon_yy_apply_error);
        this.g.setText(getResources().getString(R.string.yy_apply_state_error));
        this.h.setText(getResources().getString(R.string.yy_apply_error_des));
        return;
      } 
      this.f.setImageResource(R.drawable.icon_yy_apply_ok);
      this.g.setText(getResources().getString(R.string.yy_apply_state_ok));
      this.h.setText(getResources().getString(R.string.yy_apply_ok_des));
      return;
    } 
    this.f.setImageResource(R.drawable.icon_yy_apply_ing);
    this.g.setText(getResources().getString(R.string.yy_apply_state_ing));
    this.h.setText(getResources().getString(R.string.yy_apply_ing_des));
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.tv_create) {
      C();
      return;
    } 
    if (paramView.getId() == R.id.iv_back_img)
      C(); 
  }
  
  public int p() {
    return R.layout.fragment_yy_apply_finish_layout;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\YYApplyFinishFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */