package com.soft.blued.ui.photo.camera.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.media.selector.fragment.MediaBaseFragment;
import com.blued.android.module.media.selector.present.MediaBasePresent;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.ui.photo.camera.contract.ICameraView;
import com.soft.blued.ui.photo.camera.presenter.CameraPresenter;
import com.soft.blued.ui.photo.camera.view.BluedCameraView;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;

public class CameraFragment extends MediaBaseFragment<ICameraView, CameraPresenter> implements View.OnClickListener, ICameraView {
  private View d;
  
  private RelativeLayout g;
  
  private BluedCameraView h;
  
  private View i;
  
  private View j;
  
  private View k;
  
  private TextView l;
  
  private Dialog m;
  
  private Dialog n;
  
  private int o;
  
  public static void a(Object paramObject, int paramInt1, int paramInt2) {
    Context context;
    if (paramObject instanceof Fragment) {
      context = ((Fragment)paramObject).getContext();
    } else {
      context = (Context)paramObject;
    } 
    if (context == null)
      return; 
    PermissionHelper.b(new PermissionCallbacks(paramInt1, paramObject, paramInt2) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            Bundle bundle = new Bundle();
            bundle.putInt("from", this.a);
            Object object = this.b;
            if (object instanceof Activity) {
              TerminalActivity.a((Context)object, CameraFragment.class, bundle, this.c);
              return;
            } 
            if (object instanceof Fragment) {
              TerminalActivity.a((Fragment)object, CameraFragment.class, bundle, this.c);
              return;
            } 
            TerminalActivity.d((Context)object, CameraFragment.class, null);
          }
        });
  }
  
  private void l() {
    AppUtils.a(AppInfo.d());
    BluedPreferences.b(0L);
  }
  
  private void m() {
    this.m = DialogUtils.a(getContext(), false);
  }
  
  private void n() {
    ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
    int i = AppInfo.l - DensityUtils.a(getContext(), 60.0F);
    int j = (int)(i / 1.0F);
    layoutParams.width = i;
    layoutParams.height = j;
    this.g.setLayoutParams(layoutParams);
  }
  
  private void o() {
    CommonAlertDialog.a((Context)getActivity(), "", this.f.getResources().getString(2131755375), this.f.getResources().getString(2131755374), -$$Lambda$CameraFragment$cNtQLnHegC9Y5JD6JCP1Rwp6PIk.INSTANCE, this.f.getResources().getString(2131755380), null, null);
  }
  
  private void p() {
    View view = this.i;
    if (view != null)
      view.setEnabled(false); 
  }
  
  private void q() {
    View view = this.i;
    if (view != null)
      view.setEnabled(true); 
  }
  
  public void B() {}
  
  public boolean V_() {
    View view = this.i;
    if (view == null || view.isEnabled())
      o(); 
    return true;
  }
  
  public void a(String paramString) {
    ((TextView)this.d.findViewById(2131301409)).setText(paramString);
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      Dialog dialog1 = this.m;
      if (dialog1 != null)
        DialogUtils.a(dialog1); 
      p();
      return;
    } 
    Dialog dialog = this.m;
    if (dialog != null)
      DialogUtils.b(dialog); 
    q();
  }
  
  public boolean a(Bundle paramBundle) {
    return false;
  }
  
  public boolean aX_() {
    BluedCameraView bluedCameraView = this.h;
    return (bluedCameraView != null) ? bluedCameraView.f() : false;
  }
  
  public BluedCameraView b() {
    return this.h;
  }
  
  public void b(Bundle paramBundle) {
    this.g = (RelativeLayout)this.d.findViewById(2131296629);
    this.h = (BluedCameraView)this.d.findViewById(2131296623);
    this.i = this.d.findViewById(2131300180);
    this.i.setOnClickListener(this);
    this.l = (TextView)this.d.findViewById(2131296631);
    this.j = this.d.findViewById(2131296349);
    this.j.setOnClickListener(new -$$Lambda$CameraFragment$z9L90BEEyyX5-6x8PrcJgBxn-Fc(this));
    this.k = this.d.findViewById(2131297436);
    this.k.setOnClickListener(new -$$Lambda$CameraFragment$abQmg6U2n-ERCZj3pRaq1IdjxNg(this));
    m();
    n();
  }
  
  public void b(String paramString) {
    TextView textView = this.l;
    if (textView != null)
      textView.setText(paramString); 
  }
  
  public void b(boolean paramBoolean) {
    a(false);
  }
  
  public void d() {
    BluedCameraView bluedCameraView = this.h;
    if (bluedCameraView != null && bluedCameraView.f()) {
      this.h.e();
      p();
    } 
  }
  
  public void e() {
    if (this.n == null)
      this.n = (Dialog)CommonAlertDialog.a(getContext(), null, getString(2131755723), getString(2131756086), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              CameraFragment.a(this.a);
            }
          },  new DialogInterface.OnDismissListener(this) {
            public void onDismiss(DialogInterface param1DialogInterface) {
              CameraFragment.a(this.a);
            }
          },  0); 
    this.n.show();
  }
  
  public boolean g() {
    BluedCameraView bluedCameraView = this.h;
    return (bluedCameraView != null) ? bluedCameraView.d() : false;
  }
  
  public BaseFragment h() {
    return (BaseFragment)this;
  }
  
  public void i() {
    RelativeLayout relativeLayout = this.g;
    if (relativeLayout != null) {
      BluedCameraView bluedCameraView = this.h;
      if (bluedCameraView != null) {
        relativeLayout.removeView((View)bluedCameraView);
        this.g.addView((View)this.h);
      } 
    } 
  }
  
  protected CameraPresenter k() {
    return new CameraPresenter();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131300180)
      return; 
    if (this.e != null)
      ((CameraPresenter)this.e).c(); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131492935, paramViewGroup, false);
      if (getArguments() != null)
        this.o = getArguments().getInt("from"); 
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    return this.d;
  }
  
  public void onDestroy() {
    BluedCameraView bluedCameraView = this.h;
    if (bluedCameraView != null)
      bluedCameraView.h(); 
    super.onDestroy();
  }
  
  public void onPause() {
    BluedCameraView bluedCameraView = this.h;
    if (bluedCameraView != null)
      bluedCameraView.g(); 
    super.onPause();
  }
  
  public void onResume() {
    super.onResume();
    i();
    if (this.h != null && this.e != null)
      this.h.a((BluedCameraView.OperationCallback)this.e); 
  }
  
  public void y() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\camera\fragment\CameraFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */