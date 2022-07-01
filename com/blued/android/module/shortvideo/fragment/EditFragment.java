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
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.base.chat.ChatHelperV4Proxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.ICoverSlideListener;
import com.blued.android.module.shortvideo.contract.IEditContentView;
import com.blued.android.module.shortvideo.contract.IEditView;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.presenter.EditPresenter;
import com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent;
import com.blued.android.module.shortvideo.utils.DialogUtils;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.blued.android.module.shortvideo.view.ConfigView;
import com.blued.android.module.shortvideo.view.CoverView;
import com.blued.android.module.shortvideo.view.EditMainView;
import com.blued.android.module.shortvideo.view.EditVolumeView;
import com.blued.android.module.shortvideo.view.FilterView;
import java.io.Serializable;

public class EditFragment extends ShortVideoBaseFragment<IEditView, EditPresenter> implements View.OnClickListener, ICoverSlideListener, IEditContentView, IEditView, EventObserver {
  private TextView A;
  
  private KeyboardListenLinearLayout B;
  
  protected FilterView e;
  
  protected CoverView f;
  
  private GLSurfaceView s;
  
  private ConfigView t;
  
  private EditMainView u;
  
  private EditVolumeView v;
  
  private Dialog w;
  
  private RelativeLayout x;
  
  private ImageView y;
  
  private View z;
  
  public static void a(Object paramObject, CommonModel paramCommonModel, int paramInt) {
    Bundle bundle = new Bundle();
    CommonModel commonModel = new CommonModel();
    commonModel.copyModel(paramCommonModel);
    bundle.putSerializable("commont_model", (Serializable)commonModel);
    TerminalActivity.a(bundle);
    TerminalActivity.b(bundle);
    if (paramObject instanceof Activity) {
      TerminalActivity.a((Context)paramObject, EditFragment.class, bundle, paramInt);
      return;
    } 
    if (paramObject instanceof Fragment) {
      TerminalActivity.a((Fragment)paramObject, EditFragment.class, bundle, paramInt);
      return;
    } 
    if (paramObject instanceof android.app.Application)
      TerminalActivity.d((Context)paramObject, EditFragment.class, bundle); 
  }
  
  public static void a(Object paramObject, String paramString1, String paramString2, int paramInt) {
    boolean bool = paramObject instanceof Fragment;
    if (bool) {
      ((Fragment)paramObject).getContext();
    } else {
      Context context = (Context)paramObject;
    } 
    if (Build.VERSION.SDK_INT < 18) {
      AppMethods.d(R.string.stv_low_version_prompt);
      return;
    } 
    EditDataModel.SerializableData serializableData = new EditDataModel.SerializableData();
    serializableData.m = paramString2;
    serializableData.setFrom(2);
    serializableData.setVideoPath(paramString1);
    serializableData.setOriginalVideoPath(paramString1);
    serializableData.setCanDeleteVideoFile(false);
    Bundle bundle = new Bundle();
    bundle.putSerializable("serializeble_data", (Serializable)serializableData);
    TerminalActivity.a(bundle);
    TerminalActivity.b(bundle);
    if (paramObject instanceof Activity) {
      TerminalActivity.a((Context)paramObject, EditFragment.class, bundle, paramInt);
      return;
    } 
    if (bool) {
      TerminalActivity.a((Fragment)paramObject, EditFragment.class, bundle, paramInt);
      return;
    } 
    if (paramObject instanceof android.app.Application)
      TerminalActivity.d((Context)paramObject, EditFragment.class, bundle); 
  }
  
  private void b(KeyboardListenLinearLayout paramKeyboardListenLinearLayout) {
    a(paramKeyboardListenLinearLayout);
  }
  
  private void w() {
    if (this.x.getVisibility() == 0)
      StvViewUtils.f(getContext(), (View)this.x); 
  }
  
  private void x() {
    if (this.x.getVisibility() == 8) {
      this.x.setVisibility(0);
      StvViewUtils.e(getContext(), (View)this.x);
    } 
  }
  
  private void y() {
    v();
  }
  
  public boolean V_() {
    int i = this.p.r();
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            ab_();
            if (this.p != null)
              this.p.g(); 
            getActivity().finish();
            return false;
          } 
          e();
          return true;
        } 
        ad_();
        return true;
      } 
      d();
      return true;
    } 
    y();
    return true;
  }
  
  public GLSurfaceView a() {
    return this.s;
  }
  
  protected EditPresenter a(Bundle paramBundle) {
    return new EditPresenter(paramBundle);
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    this.t.a(paramInt1, paramInt2, paramInt3);
    this.f.a(paramInt1, paramInt2, paramInt3);
    this.u.a(paramInt1, paramInt2, paramInt3);
    this.e.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(CommonModel paramCommonModel) {
    this.t.a(paramCommonModel);
    this.t.d(((EditDataModel.SerializableData)paramCommonModel).a());
    this.f.a(this);
    this.u.a(this.p);
    this.e.a(paramCommonModel);
    this.v.a(this.p);
    if (StringUtils.a(paramCommonModel.getMusicName())) {
      this.z.setVisibility(8);
      return;
    } 
    View view = this.z;
    int i = 0;
    view.setVisibility(0);
    StringBuilder stringBuilder = new StringBuilder(paramCommonModel.getMusicName());
    stringBuilder.append(stringBuilder);
    while (i < 10) {
      stringBuilder.append("    ");
      stringBuilder.append(stringBuilder);
      i++;
    } 
    this.A.setText(stringBuilder);
    this.A.setLines(1);
    this.A.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    this.A.setSingleLine(true);
    this.A.setSelected(true);
    this.A.setFocusable(true);
    this.A.setFocusableInTouchMode(true);
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
  
  public void ad_() {
    this.f.d();
    v();
  }
  
  public BaseFragment b() {
    return (BaseFragment)this;
  }
  
  public void b(int paramInt) {
    if (this.p != null)
      this.p.a(paramInt); 
  }
  
  protected void b(Bundle paramBundle) {
    getActivity().getWindow().setSoftInputMode(16);
    this.B = (KeyboardListenLinearLayout)this.r.findViewById(R.id.keyboardLinearLayout);
    this.x = (RelativeLayout)this.r.findViewById(R.id.layoutTop);
    StatusBarHelper.a((Activity)getActivity(), (View)this.x);
    this.y = (ImageView)this.r.findViewById(R.id.btnBack);
    this.s = (GLSurfaceView)this.r.findViewById(R.id.stv_edit_preview);
    this.u = (EditMainView)this.r.findViewById(R.id.stv_main_view);
    this.t = (ConfigView)this.r.findViewById(R.id.stv_config_view);
    this.v = (EditVolumeView)this.r.findViewById(R.id.stv_volume_view);
    this.e = (FilterView)this.r.findViewById(R.id.stv_filter_view);
    this.f = (CoverView)this.r.findViewById(R.id.stv_cover_view);
    this.w = DialogUtils.a(getContext());
    this.z = this.r.findViewById(R.id.lay_music);
    this.A = (TextView)this.r.findViewById(R.id.tv_music);
  }
  
  public void c(boolean paramBoolean) {
    if (paramBoolean) {
      this.w.show();
      return;
    } 
    this.w.dismiss();
  }
  
  public void d() {
    v();
    this.e.d();
  }
  
  public void e() {
    this.v.d();
    v();
  }
  
  public void e_(int paramInt) {}
  
  public EditPresenter getPresenter() {
    return this.p;
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.btnBack) {
      StvViewUtils.a((View)this.y);
      V_();
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    if (this.r == null) {
      a(paramLayoutInflater, R.layout.activity_stv_edit, paramViewGroup, paramBundle);
      b(this.B);
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
    this.u.f();
    this.e.k();
    this.f.k();
    this.t.A();
    this.v.k();
  }
  
  public void onPause() {
    super.onPause();
    u();
    this.u.d();
    this.e.i();
    this.f.i();
    this.t.y();
    this.v.i();
  }
  
  public void onResume() {
    super.onResume();
    ObserverMgr.a().a(this);
    this.u.c();
    this.e.h();
    this.f.h();
    this.t.x();
    this.v.h();
  }
  
  protected void t() {
    this.y.setOnClickListener(this);
  }
  
  public void u() {
    ObserverMgr.a().b(this);
    this.u.e();
    this.e.j();
    this.f.j();
    this.t.z();
    this.v.j();
  }
  
  public void v() {
    this.p.b(0);
    this.t.v();
    x();
    this.u.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\fragment\EditFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */