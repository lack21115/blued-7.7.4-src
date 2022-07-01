package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveManagerAdapter;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.LiveUserinfoModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class LiveManagerDialogFragment extends BaseDialogFragment {
  public Context a;
  
  public ListView b;
  
  public LiveManagerAdapter c;
  
  public LiveRankGuestDialogFragment.ILiveGuestDialog d;
  
  private LinearLayout e;
  
  private View f;
  
  private View g;
  
  private ProgressBar h;
  
  private TextView i;
  
  private Long j;
  
  private void g() {
    if (getArguments() != null)
      this.j = Long.valueOf(getArguments().getLong("KEY_LID")); 
  }
  
  public void a(LiveRankGuestDialogFragment.ILiveGuestDialog paramILiveGuestDialog) {
    this.d = paramILiveGuestDialog;
  }
  
  public void f() {
    LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<LiveUserinfoModel>>(this, (IRequestHost)a()) {
          boolean a = false;
          
          protected void a(BluedEntityA<LiveUserinfoModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData())
              this.b.c.a(param1BluedEntityA.data); 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a = true;
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            if (this.a) {
              LiveManagerDialogFragment.a(this.b).setVisibility(8);
              LiveManagerDialogFragment.b(this.b).setVisibility(0);
              LiveManagerDialogFragment.c(this.b).setVisibility(8);
              this.b.b.setVisibility(4);
            } else if (this.b.c.getCount() == 0) {
              LiveManagerDialogFragment.a(this.b).setVisibility(0);
              LiveManagerDialogFragment.b(this.b).setVisibility(8);
              LiveManagerDialogFragment.c(this.b).setVisibility(8);
              this.b.b.setVisibility(4);
            } else {
              LiveManagerDialogFragment.a(this.b).setVisibility(8);
              LiveManagerDialogFragment.b(this.b).setVisibility(8);
              LiveManagerDialogFragment.c(this.b).setVisibility(8);
              this.b.b.setVisibility(0);
            } 
            this.a = false;
          }
          
          public void onUIStart() {
            super.onUIStart();
            LiveManagerDialogFragment.a(this.b).setVisibility(8);
            LiveManagerDialogFragment.b(this.b).setVisibility(8);
            LiveManagerDialogFragment.c(this.b).setVisibility(0);
            this.b.b.setVisibility(4);
          }
        }(IRequestHost)a());
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    int i;
    this.a = (Context)getActivity();
    boolean bool = LiveFloatManager.a().B();
    LayoutInflater layoutInflater = getActivity().getLayoutInflater();
    if (bool) {
      i = R.layout.dialog_live_manager_list_land;
    } else {
      i = R.layout.dialog_live_manager_list;
    } 
    View view = layoutInflater.inflate(i, null);
    int j = DensityUtils.a((Context)getActivity(), 290.0F);
    Dialog dialog = new Dialog((Context)getActivity(), R.style.transparentFrameWindowStyleLive);
    dialog.requestWindowFeature(1);
    dialog.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    byte b = -1;
    if (bool) {
      dialog.setContentView(view, new ViewGroup.LayoutParams(DensityUtils.a((Context)getActivity(), 360.0F), -1));
    } else {
      dialog.setContentView(view, new ViewGroup.LayoutParams(-1, DensityUtils.a((Context)getActivity(), 290.0F)));
    } 
    Window window = dialog.getWindow();
    int k = getActivity().getWindowManager().getDefaultDisplay().getHeight();
    if (bool) {
      i = R.style.rank_menu_animstyle;
    } else {
      i = R.style.main_menu_animstyle;
    } 
    window.setWindowAnimations(i);
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.x = 0;
    layoutParams.y = k - j;
    if (bool) {
      i = DensityUtils.a((Context)getActivity(), 360.0F);
    } else {
      i = -1;
    } 
    layoutParams.width = i;
    if (bool) {
      i = b;
    } else {
      i = DensityUtils.a((Context)getActivity(), 290.0F);
    } 
    layoutParams.height = i;
    layoutParams.gravity = 5;
    dialog.onWindowAttributesChanged(layoutParams);
    g();
    return dialog;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    int i;
    boolean bool = LiveFloatManager.a().B();
    getDialog().getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    if (bool) {
      i = R.layout.dialog_live_manager_list_land;
    } else {
      i = R.layout.dialog_live_manager_list;
    } 
    View view = paramLayoutInflater.inflate(i, paramViewGroup);
    this.e = (LinearLayout)view.findViewById(R.id.dialog_layout);
    this.f = view.findViewById(R.id.ll_nodata);
    this.g = view.findViewById(R.id.ll_nodata_error);
    this.h = (ProgressBar)view.findViewById(R.id.loading_view);
    this.b = (ListView)view.findViewById(R.id.list_view);
    this.i = (TextView)view.findViewById(R.id.tv_reload);
    this.i.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.f();
          }
        });
    Context context = this.a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.j);
    stringBuilder.append("");
    this.c = new LiveManagerAdapter(context, stringBuilder.toString(), (IRequestHost)a());
    this.b.setAdapter((ListAdapter)this.c);
    f();
    LiveRankGuestDialogFragment.ILiveGuestDialog iLiveGuestDialog = this.d;
    if (iLiveGuestDialog != null)
      iLiveGuestDialog.y_(); 
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    LiveRankGuestDialogFragment.ILiveGuestDialog iLiveGuestDialog = this.d;
    if (iLiveGuestDialog != null)
      iLiveGuestDialog.z_(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveManagerDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */