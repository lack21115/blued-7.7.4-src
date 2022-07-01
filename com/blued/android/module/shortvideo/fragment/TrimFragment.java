package com.blued.android.module.shortvideo.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.ITrimBottomCallback;
import com.blued.android.module.shortvideo.contract.ITrimView;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.TrimDataModel;
import com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent;
import com.blued.android.module.shortvideo.presenter.TrimPresenter;
import com.blued.android.module.shortvideo.utils.DialogUtils;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.blued.android.module.shortvideo.view.RangeSeekBar;
import com.blued.android.module.shortvideo.view.TrimNewBottomView;
import java.io.Serializable;

public class TrimFragment extends ShortVideoBaseFragment<ITrimView, TrimPresenter> implements View.OnClickListener, ITrimBottomCallback, ITrimView {
  private VideoView e;
  
  private RelativeLayout f;
  
  private ImageView s;
  
  private Dialog t;
  
  private TrimNewBottomView u;
  
  public static void a(Object paramObject, String paramString, int paramInt1, int paramInt2) {
    Bundle bundle = new Bundle();
    CommonModel commonModel = new CommonModel();
    commonModel.setVideoPath(paramString);
    commonModel.setOriginalVideoPath(paramString);
    commonModel.setFrom(paramInt1);
    bundle.putSerializable("commont_model", (Serializable)commonModel);
    TerminalActivity.a(bundle);
    if (paramObject instanceof Activity) {
      TerminalActivity.a((Context)paramObject, TrimFragment.class, bundle, paramInt2);
      return;
    } 
    if (paramObject instanceof Fragment) {
      TerminalActivity.a((Fragment)paramObject, TrimFragment.class, bundle, paramInt2);
      return;
    } 
    if (paramObject instanceof android.app.Application)
      TerminalActivity.d((Context)paramObject, TrimFragment.class, bundle); 
  }
  
  public boolean V_() {
    u();
    return false;
  }
  
  public BaseFragment a() {
    return (BaseFragment)this;
  }
  
  protected TrimPresenter a(Bundle paramBundle) {
    return new TrimPresenter(paramBundle);
  }
  
  public void a(double paramDouble) {
    TrimNewBottomView trimNewBottomView = this.u;
    if (trimNewBottomView != null)
      trimNewBottomView.a(paramDouble); 
  }
  
  public void a(float paramFloat) {}
  
  public void a(View paramView) {
    c(true);
    if (this.p != null)
      this.p.a(paramView, 200); 
  }
  
  public void a(RecyclerView.OnScrollListener paramOnScrollListener) {
    TrimNewBottomView trimNewBottomView = this.u;
    if (trimNewBottomView != null)
      trimNewBottomView.a(paramOnScrollListener); 
  }
  
  public void a(TrimDataModel paramTrimDataModel) {
    TrimNewBottomView trimNewBottomView = this.u;
    if (trimNewBottomView != null)
      trimNewBottomView.a(this, paramTrimDataModel); 
  }
  
  public void a(RangeSeekBar.OnRangeSeekBarChangeListener paramOnRangeSeekBarChangeListener) {
    TrimNewBottomView trimNewBottomView = this.u;
    if (trimNewBottomView != null)
      trimNewBottomView.setOnRangeSeekBarChangeListener(paramOnRangeSeekBarChangeListener); 
  }
  
  public void ag_() {
    TrimNewBottomView trimNewBottomView = this.u;
    if (trimNewBottomView != null)
      trimNewBottomView.e(); 
  }
  
  public VideoView b() {
    return this.e;
  }
  
  public void b(int paramInt) {
    if (this.p != null) {
      if (this.p.k())
        this.p.l(); 
      this.p.b(paramInt);
    } 
  }
  
  protected void b(Bundle paramBundle) {
    this.f = (RelativeLayout)this.r.findViewById(R.id.layoutTop);
    StatusBarHelper.a((Activity)getActivity(), (View)this.f);
    this.s = (ImageView)this.r.findViewById(R.id.btnBack);
    this.u = (TrimNewBottomView)this.r.findViewById(R.id.stv_trim_bottom_v);
    this.e = (VideoView)this.r.findViewById(R.id.stv_trim_preview);
    this.t = DialogUtils.a(getContext());
  }
  
  public void c(int paramInt) {
    TrimNewBottomView trimNewBottomView = this.u;
    if (trimNewBottomView != null)
      trimNewBottomView.a(paramInt); 
  }
  
  public void c(boolean paramBoolean) {
    if (paramBoolean) {
      this.t.show();
      return;
    } 
    this.t.dismiss();
  }
  
  public long d() {
    TrimNewBottomView trimNewBottomView = this.u;
    return (trimNewBottomView != null) ? trimNewBottomView.getSelectedMinValue() : 0L;
  }
  
  public void d_(int paramInt) {
    if (this.p != null)
      this.p.a(paramInt); 
  }
  
  public long e() {
    TrimNewBottomView trimNewBottomView = this.u;
    return (trimNewBottomView != null) ? trimNewBottomView.getSelectedMaxValue() : 0L;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if (paramInt1 != 200)
        return; 
      getActivity().setResult(-1, paramIntent);
      getActivity().finish();
    } 
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.btnBack) {
      StvViewUtils.a((View)this.s);
      u();
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    if (this.r == null) {
      a(paramLayoutInflater, R.layout.activity_stv_trim, paramViewGroup, paramBundle);
    } else if (this.r.getParent() != null) {
      ((ViewGroup)this.r.getParent()).removeView((View)this.r);
    } 
    return (View)this.r;
  }
  
  public void onDestroy() {
    super.onDestroy();
    TrimNewBottomView trimNewBottomView = this.u;
    if (trimNewBottomView != null)
      trimNewBottomView.d(); 
  }
  
  public void onPause() {
    super.onPause();
    TrimNewBottomView trimNewBottomView = this.u;
    if (trimNewBottomView != null)
      trimNewBottomView.b(); 
  }
  
  public void onResume() {
    super.onResume();
    TrimNewBottomView trimNewBottomView = this.u;
    if (trimNewBottomView != null)
      trimNewBottomView.a(); 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle != null) {
      CommonModel commonModel = new CommonModel();
      commonModel.copyModel(this.p.h());
      TrimDataModel.SerializableData serializableData = new TrimDataModel.SerializableData();
      serializableData.a(this.p.i());
      paramBundle.putSerializable("commont_model", (Serializable)commonModel);
      paramBundle.putSerializable("serializeble_data", (Serializable)serializableData);
    } 
  }
  
  protected void t() {
    this.s.setOnClickListener(this);
    StvViewUtils.e(getContext(), (View)this.f);
  }
  
  public void u() {
    ab_();
    TrimNewBottomView trimNewBottomView = this.u;
    if (trimNewBottomView != null)
      trimNewBottomView.c(); 
    getActivity().finish();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\fragment\TrimFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */