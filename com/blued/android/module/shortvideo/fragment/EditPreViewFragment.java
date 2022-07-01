package com.blued.android.module.shortvideo.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.module.base.chat.ChatHelperV4Proxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IBaseView;
import com.blued.android.module.shortvideo.contract.IEditPreContentView;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.presenter.EditPreViewPresenter;
import com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import java.io.Serializable;

public class EditPreViewFragment extends ShortVideoBaseFragment<IBaseView, EditPreViewPresenter> implements View.OnClickListener, IBaseView, IEditPreContentView, EventObserver {
  private GLSurfaceView e;
  
  private RelativeLayout f;
  
  private ImageView s;
  
  private KeyboardListenLinearLayout t;
  
  private RelativeLayout u;
  
  private View v;
  
  private View w;
  
  private View x;
  
  private View y;
  
  private CommonModel z;
  
  public static void a(Object paramObject, Bundle paramBundle, int paramInt) {
    if (paramBundle == null)
      return; 
    TerminalActivity.a(paramBundle);
    TerminalActivity.b(paramBundle);
    if (paramObject instanceof Activity) {
      TerminalActivity.a((Context)paramObject, EditPreViewFragment.class, paramBundle, paramInt);
      return;
    } 
    if (paramObject instanceof Fragment) {
      TerminalActivity.a((Fragment)paramObject, EditPreViewFragment.class, paramBundle, paramInt);
      return;
    } 
    if (paramObject instanceof android.app.Application)
      TerminalActivity.d((Context)paramObject, EditPreViewFragment.class, paramBundle); 
  }
  
  private void b(KeyboardListenLinearLayout paramKeyboardListenLinearLayout) {
    a(paramKeyboardListenLinearLayout);
  }
  
  private void w() {
    if (this.f.getVisibility() == 0)
      StvViewUtils.f(getContext(), (View)this.f); 
  }
  
  private void x() {
    if (this.f.getVisibility() == 8) {
      this.f.setVisibility(0);
      StvViewUtils.e(getContext(), (View)this.f);
    } 
  }
  
  private void y() {
    v();
  }
  
  public boolean V_() {
    int i = this.p.o();
    if (i != 1) {
      if (i != 2) {
        ab_();
        if (this.p != null)
          this.p.g(); 
        getActivity().finish();
        return false;
      } 
      d();
      return true;
    } 
    y();
    return true;
  }
  
  public GLSurfaceView a() {
    return this.e;
  }
  
  protected EditPreViewPresenter a(Bundle paramBundle) {
    return new EditPreViewPresenter(paramBundle);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(CommonModel paramCommonModel) {
    Object object;
    if (paramCommonModel instanceof EditDataModel.SerializableData) {
      object = paramCommonModel;
      this.z = paramCommonModel;
    } else {
      object = null;
    } 
    this.u = (RelativeLayout)this.r.findViewById(R.id.activity_local_editor_bottombar);
    if (paramCommonModel.getFrom() >= 60) {
      this.u.setVisibility(0);
      this.v = this.r.findViewById(R.id.activity_local_editor_edit_less);
      this.w = this.r.findViewById(R.id.activity_local_editor_tip);
      this.x = this.r.findViewById(R.id.activity_local_editor_edit_more);
      this.y = this.r.findViewById(R.id.activity_local_editor_send);
      this.v.setOnClickListener(this);
      this.x.setOnClickListener(this);
      this.y.setOnClickListener(this);
      if (((EditDataModel.SerializableData)object).q < 2000L) {
        this.v.setVisibility(8);
        this.w.setVisibility(4);
        this.x.setVisibility(8);
        this.y.setVisibility(0);
        return;
      } 
      if (((EditDataModel.SerializableData)object).q > 60000L) {
        this.v.setVisibility(8);
        this.w.setVisibility(0);
        this.x.setVisibility(0);
        this.y.setVisibility(8);
        return;
      } 
      this.v.setVisibility(0);
      this.w.setVisibility(4);
      this.x.setVisibility(8);
      this.y.setVisibility(0);
      return;
    } 
    this.u.setVisibility(8);
  }
  
  public void a(EventType.VALUE paramVALUE) {
    switch (null.a[paramVALUE.ordinal()]) {
      default:
        return;
      case 5:
      case 6:
      case 7:
        x();
        return;
      case 4:
        c(true);
        return;
      case 1:
      case 2:
      case 3:
        break;
    } 
    w();
  }
  
  public BaseFragment b() {
    return (BaseFragment)this;
  }
  
  protected void b(Bundle paramBundle) {
    getActivity().getWindow().setSoftInputMode(16);
    this.t = (KeyboardListenLinearLayout)this.r.findViewById(R.id.keyboardLinearLayout);
    this.f = (RelativeLayout)this.r.findViewById(R.id.layoutTop);
    StatusBarHelper.a((Activity)getActivity(), (View)this.f);
    this.s = (ImageView)this.r.findViewById(R.id.btnBack);
    this.e = (GLSurfaceView)this.r.findViewById(R.id.stv_edit_preview);
  }
  
  public void d() {
    v();
  }
  
  public void e_(int paramInt) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if (paramInt1 != 300)
        return; 
      getActivity().setResult(-1, paramIntent);
      getActivity().finish();
    } 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == R.id.btnBack) {
      StvViewUtils.a((View)this.s);
      V_();
      return;
    } 
    if (i == R.id.activity_local_editor_edit_less || i == R.id.activity_local_editor_edit_more) {
      TrimFragment.a(this, this.z.getVideoPath(), this.z.getFrom(), 300);
      return;
    } 
    if (i == R.id.activity_local_editor_send) {
      Bundle bundle = new Bundle();
      bundle.putSerializable("serializeble_data", (Serializable)this.z);
      SaveVideoFragment.a(this, bundle, this.z.getFrom(), 300);
      return;
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    if (this.r == null) {
      a(paramLayoutInflater, R.layout.activity_stv_pre_edit, paramViewGroup, paramBundle);
      b(this.t);
      ChatHelperV4Proxy.a().c();
    } else if (this.r.getParent() != null) {
      ((ViewGroup)this.r.getParent()).removeView((View)this.r);
    } 
    return (View)this.r;
  }
  
  public void onDestroy() {
    super.onDestroy();
    ChatHelperV4Proxy.a().b();
    u();
  }
  
  public void onPause() {
    super.onPause();
    u();
  }
  
  public void onResume() {
    super.onResume();
    ObserverMgr.a().a(this);
  }
  
  protected void t() {
    this.s.setOnClickListener(this);
  }
  
  public void u() {
    ObserverMgr.a().b(this);
  }
  
  public void v() {
    this.p.a(0);
    x();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\fragment\EditPreViewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */