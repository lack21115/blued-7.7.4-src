package com.blued.android.module.shortvideo.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.base.chat.ChatHelperV4Proxy;
import com.blued.android.module.base.live.LiveFloatManagerProxy;
import com.blued.android.module.base.ui.PopMenuFromCenterProxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IShineView;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.observer.ReturnObserver;
import com.blued.android.module.shortvideo.permission.PermissionHelper;
import com.blued.android.module.shortvideo.presenter.ShinePresenter;
import com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent;
import com.blued.android.module.shortvideo.utils.DialogUtils;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.blued.android.module.shortvideo.view.ConfigView;
import com.blued.android.module.shortvideo.view.ControllerView;
import com.blued.android.module.shortvideo.view.FilterView;
import com.blued.android.module.shortvideo.view.FocusIndicator;
import com.blued.android.module.shortvideo.view.SectionProgressBar;
import com.blued.android.module.shortvideo.view.StvCustomDialog;
import com.blued.android.module.shortvideo.view.TimeDownView;
import java.io.Serializable;

public class ShineFragment extends ShortVideoBaseFragment<IShineView, ShinePresenter> implements View.OnClickListener, IShineView, EventObserver, ReturnObserver {
  private StvCustomDialog A;
  
  private View B;
  
  private View C;
  
  private ImageView D;
  
  private ImageView E;
  
  private ImageView F;
  
  private TextView G;
  
  private TextView H;
  
  private TextView I;
  
  private TextView J;
  
  private TextView K;
  
  private FocusIndicator e;
  
  private RelativeLayout f;
  
  private ControllerView s;
  
  private ConfigView t;
  
  private FilterView u;
  
  private TimeDownView v;
  
  private boolean w;
  
  private GLSurfaceView x;
  
  private SectionProgressBar y;
  
  private Dialog z;
  
  private void A() {
    if (this.f.getVisibility() == 8) {
      this.f.setVisibility(0);
      StvViewUtils.e(getContext(), (View)this.f);
    } 
  }
  
  public static void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3) {
    Context context;
    if (paramObject instanceof Fragment) {
      context = ((Fragment)paramObject).getContext();
    } else {
      context = (Context)paramObject;
    } 
    if (context == null)
      return; 
    if (Build.VERSION.SDK_INT < 18) {
      AppMethods.d(R.string.stv_low_version_prompt);
      return;
    } 
    if (!PopMenuFromCenterProxy.a().a(context) && !LiveFloatManagerProxy.a().a(context))
      PermissionHelper.c(new PermissionCallbacks(paramInt1, paramInt2, paramObject, paramInt3) {
            public void a(String[] param1ArrayOfString) {}
            
            public void aa_() {
              Bundle bundle = new Bundle();
              CommonModel commonModel = new CommonModel();
              commonModel.setFrom(this.a);
              commonModel.setCurrentPage(this.b);
              bundle.putSerializable("commont_model", (Serializable)commonModel);
              TerminalActivity.a(bundle);
              TerminalActivity.b(bundle);
              Object object = this.c;
              if (object instanceof Activity) {
                TerminalActivity.a((Context)object, ShineFragment.class, bundle, this.d);
                return;
              } 
              if (object instanceof Fragment) {
                TerminalActivity.a((Fragment)object, ShineFragment.class, bundle, this.d);
                return;
              } 
              if (object instanceof android.app.Application)
                TerminalActivity.d((Context)object, ShineFragment.class, bundle); 
            }
          }); 
  }
  
  public static void a(Object paramObject, int paramInt1, String paramString1, String paramString2, int paramInt2) {
    Context context;
    if (paramObject instanceof Fragment) {
      context = ((Fragment)paramObject).getContext();
    } else {
      context = (Context)paramObject;
    } 
    if (context == null)
      return; 
    if (Build.VERSION.SDK_INT < 18) {
      AppMethods.d(R.string.stv_low_version_prompt);
      return;
    } 
    if (!PopMenuFromCenterProxy.a().a(context) && !LiveFloatManagerProxy.a().a(context))
      PermissionHelper.c(new PermissionCallbacks(paramInt1, paramString1, paramString2, paramObject, paramInt2) {
            public void a(String[] param1ArrayOfString) {}
            
            public void aa_() {
              Bundle bundle = new Bundle();
              CommonModel commonModel = new CommonModel();
              commonModel.setFrom(this.a);
              commonModel.setMusicPath(this.b);
              commonModel.setMusicName(this.c);
              bundle.putSerializable("commont_model", (Serializable)commonModel);
              TerminalActivity.a(bundle);
              TerminalActivity.b(bundle);
              Object object = this.d;
              if (object instanceof Activity) {
                TerminalActivity.a((Context)object, ShineFragment.class, bundle, this.e);
                return;
              } 
              if (object instanceof Fragment) {
                TerminalActivity.a((Fragment)object, ShineFragment.class, bundle, this.e);
                return;
              } 
              if (object instanceof android.app.Application)
                TerminalActivity.d((Context)object, ShineFragment.class, bundle); 
            }
          }); 
  }
  
  private void v() {
    this.B = LayoutInflater.from(getContext()).inflate(R.layout.layout_stv_common_dialog, null);
    this.G = (TextView)this.B.findViewById(R.id.tv_title);
    this.G.setVisibility(8);
    this.I = (TextView)this.B.findViewById(R.id.tv_cancel);
    this.I.setText(R.string.stv_cancel);
    this.H = (TextView)this.B.findViewById(R.id.tv_ok);
    this.H.setText(R.string.stv_sure);
    this.J = (TextView)this.B.findViewById(R.id.tv_des);
    this.z = DialogUtils.a(getContext());
  }
  
  private void w() {
    c(true);
    this.p.t();
  }
  
  private void x() {
    this.p.w();
    this.e.d();
  }
  
  private void y() {
    this.w ^= 0x1;
    this.p.a(this.w);
    this.E.setActivated(this.w);
  }
  
  private void z() {
    if (this.f.getVisibility() == 0)
      StvViewUtils.f(getContext(), (View)this.f); 
  }
  
  public GLSurfaceView a() {
    return this.x;
  }
  
  protected ShinePresenter a(Bundle paramBundle) {
    return new ShinePresenter(paramBundle);
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    this.s.a(paramInt1, paramInt2, paramInt3);
    this.t.a(paramInt1, paramInt2, paramInt3);
    this.u.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean) {
    if (paramBoolean)
      b(false); 
    this.s.a(paramInt, paramLong);
    this.t.a(paramInt, paramLong);
  }
  
  public void a(CommonModel paramCommonModel) {
    this.v.a(this.p);
    this.s.a(this.p);
    this.t.a(paramCommonModel);
    this.u.a(paramCommonModel);
    if (StringUtils.a(paramCommonModel.getMusicName())) {
      this.C.setVisibility(8);
      return;
    } 
    View view = this.C;
    int i = 0;
    view.setVisibility(0);
    StringBuilder stringBuilder = new StringBuilder(paramCommonModel.getMusicName());
    stringBuilder.append(stringBuilder);
    while (i < 10) {
      stringBuilder.append("    ");
      stringBuilder.append(stringBuilder);
      i++;
    } 
    this.K.setText(stringBuilder);
    this.K.setLines(1);
    this.K.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    this.K.setSingleLine(true);
    this.K.setSelected(true);
    this.K.setFocusable(true);
    this.K.setFocusableInTouchMode(true);
  }
  
  public void a(EventType.VALUE paramVALUE) {
    switch (null.a[paramVALUE.ordinal()]) {
      default:
        return;
      case 10:
        if (this.p != null) {
          this.p.h();
          return;
        } 
        return;
      case 9:
        if (this.y.i()) {
          c_(3);
          return;
        } 
        if (this.p != null) {
          this.p.i();
          return;
        } 
        return;
      case 8:
        if (this.y.i()) {
          c_(2);
          return;
        } 
        if (this.p != null) {
          this.p.j();
          return;
        } 
        return;
      case 5:
        c(false);
      case 6:
      case 7:
        A();
        return;
      case 4:
        b(true);
        A();
        return;
      case 3:
        w();
        return;
      case 1:
      case 2:
        break;
    } 
    z();
  }
  
  public void a(EventType.VALUE paramVALUE, boolean paramBoolean) {
    if (paramBoolean) {
      int i = null.a[paramVALUE.ordinal()];
      if (i != 4) {
        if (i != 11)
          return; 
        z();
        return;
      } 
      A();
    } 
  }
  
  public FocusIndicator ae_() {
    return this.e;
  }
  
  public void af_() {}
  
  public BaseFragment b() {
    return (BaseFragment)this;
  }
  
  protected void b(Bundle paramBundle) {
    v();
    this.y = (SectionProgressBar)this.r.findViewById(R.id.record_progressbar);
    this.x = (GLSurfaceView)this.r.findViewById(R.id.preview);
    this.f = (RelativeLayout)this.r.findViewById(R.id.layoutTop);
    StatusBarHelper.a((Activity)getActivity(), (View)this.f);
    this.D = (ImageView)this.r.findViewById(R.id.btnBack);
    this.E = (ImageView)this.r.findViewById(R.id.switch_flash);
    this.F = (ImageView)this.r.findViewById(R.id.switch_camera);
    this.e = (FocusIndicator)this.r.findViewById(R.id.focus_indicator);
    this.s = (ControllerView)this.r.findViewById(R.id.stv_controller_view);
    this.t = (ConfigView)this.r.findViewById(R.id.stv_config_view);
    this.u = (FilterView)this.r.findViewById(R.id.stv_filter_view);
    this.v = (TimeDownView)this.r.findViewById(R.id.stv_timedown_view);
    this.v.setVisibility(0);
    this.C = this.r.findViewById(R.id.lay_music);
    this.K = (TextView)this.r.findViewById(R.id.tv_music);
  }
  
  public void c() {
    byte b;
    ImageView imageView = this.E;
    if (this.p.B()) {
      b = 0;
    } else {
      b = 8;
    } 
    imageView.setVisibility(b);
    this.w = false;
    this.E.setActivated(this.w);
    this.s.f();
  }
  
  public void c(boolean paramBoolean) {
    Dialog dialog = this.z;
    if (dialog != null) {
      if (paramBoolean) {
        dialog.show();
        return;
      } 
      dialog.dismiss();
    } 
  }
  
  public void c_(int paramInt) {
    if (this.A == null) {
      this.A = new StvCustomDialog(getContext(), R.style.TranslucentBackground);
      this.A.requestWindowFeature(1);
      this.A.getWindow().setFlags(1024, 1024);
      this.A.setContentView(this.B);
      this.A.setCancelable(false);
    } 
    StvCustomDialog stvCustomDialog = this.A;
    if (stvCustomDialog != null && stvCustomDialog.isShowing())
      this.A.dismiss(); 
    this.I.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            ShineFragment.a(this.a).dismiss();
          }
        });
    this.H.setOnClickListener(new View.OnClickListener(this, paramInt) {
          public void onClick(View param1View) {
            ShineFragment.a(this.b).dismiss();
            ShineFragment.b(this.b).a(false);
            if (this.b.p != null) {
              this.b.p.r();
              this.b.p.v();
            } 
            int i = this.a;
            if (i != 2) {
              if (i != 3) {
                this.b.getActivity().finish();
                return;
              } 
              if (this.b.p != null) {
                this.b.p.i();
                return;
              } 
            } else if (this.b.p != null) {
              this.b.p.j();
            } 
          }
        });
    this.J.setText(getString(R.string.stv_switch_channel_title));
    this.A.a(new StvCustomDialog.OnBackCallBack(this) {
          public void a() {}
        });
  }
  
  public void d() {
    this.u.d();
    A();
    this.t.v();
    this.s.a();
    if (this.p.n() != 5)
      this.y.a(); 
  }
  
  public SectionProgressBar e() {
    return this.y;
  }
  
  public void onClick(View paramView) {
    StvViewUtils.a(paramView);
    int i = paramView.getId();
    if (i == R.id.btnBack) {
      V_();
      return;
    } 
    if (i == R.id.switch_flash) {
      y();
      return;
    } 
    if (i == R.id.switch_camera)
      x(); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    getActivity().getWindow().setSoftInputMode(19);
    getActivity().getWindow().setFlags(1024, 1024);
    a(paramLayoutInflater, R.layout.activity_stv_shoot_v, paramViewGroup, paramBundle);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(o);
    stringBuilder.append("ShineFragment onCreate()");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    ChatHelperV4Proxy.a().c();
    return (View)this.r;
  }
  
  public void onDestroy() {
    super.onDestroy();
    ChatHelperV4Proxy.a().b();
    this.y.f();
    this.s.g();
    this.t.A();
    this.u.k();
    this.v.f();
    u();
  }
  
  public void onPause() {
    super.onPause();
    A();
    this.y.d();
    this.s.d();
    this.t.y();
    this.u.i();
    this.v.d();
    u();
  }
  
  public void onResume() {
    super.onResume();
    ObserverMgr.a().a(this);
    ObserverMgr.a().a(this);
    this.y.c();
    this.s.c();
    this.t.x();
    this.u.h();
    this.v.c();
  }
  
  protected void t() {
    this.D.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.F.setOnClickListener(this);
  }
  
  public void u() {
    ObserverMgr.a().b(this);
    ObserverMgr.a().b(this);
    this.y.e();
    this.s.e();
    this.t.z();
    this.u.j();
    this.v.e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\fragment\ShineFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */