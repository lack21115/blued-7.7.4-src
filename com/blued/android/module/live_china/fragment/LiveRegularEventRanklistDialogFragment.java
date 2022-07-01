package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveRankGuestListItemAdapter;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.BluedLiveRankListData;
import com.blued.android.module.live_china.model.LiveEventRankExtra;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;

public class LiveRegularEventRanklistDialogFragment extends BaseDialogFragment {
  public static String a = "LID";
  
  ILiveHostDialog b;
  
  public RenrenPullToRefreshListView c;
  
  public ListView d;
  
  public LiveRankGuestListItemAdapter e;
  
  public TextView f;
  
  public Context g;
  
  public int h = 1;
  
  public boolean i = true;
  
  public View j;
  
  public View k;
  
  public View l;
  
  private long m;
  
  private String n;
  
  private void j() {
    if (getArguments() != null) {
      this.m = getArguments().getLong(a);
      this.n = getArguments().getString("activity_id");
    } 
  }
  
  public void a(ILiveHostDialog paramILiveHostDialog) {
    this.b = paramILiveHostDialog;
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.h = 1;
    } else {
      this.h++;
    } 
    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedLiveRankListData, LiveEventRankExtra>>(this) {
          boolean a = false;
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a = true;
            LiveRegularEventRanklistDialogFragment liveRegularEventRanklistDialogFragment = this.b;
            liveRegularEventRanklistDialogFragment.h--;
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            if (this.a) {
              this.b.h();
            } else if (this.b.e.getCount() == 0) {
              this.b.f();
            } else {
              this.b.i();
            } 
            if (this.b.i) {
              this.b.c.o();
            } else {
              this.b.c.p();
            } 
            this.b.c.q();
            this.b.c.j();
            this.a = false;
          }
          
          public void onUIStart() {
            super.onUIStart();
            if (this.b.h == 1)
              this.b.g(); 
          }
          
          public void onUIUpdate(BluedEntity<BluedLiveRankListData, LiveEventRankExtra> param1BluedEntity) {
            if (param1BluedEntity.extra != null) {
              if (!TextUtils.isEmpty(((LiveEventRankExtra)param1BluedEntity.extra).title))
                this.b.f.setText(((LiveEventRankExtra)param1BluedEntity.extra).title); 
              if (!TextUtils.isEmpty(((LiveEventRankExtra)param1BluedEntity.extra).label))
                this.b.e.a(((LiveEventRankExtra)param1BluedEntity.extra).label); 
            } 
            if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0)
              if (this.b.h == 1) {
                this.b.e.a(param1BluedEntity.data);
              } else {
                this.b.e.b(param1BluedEntity.data);
              }  
            this.b.i = param1BluedEntity.hasMore();
          }
        }this.h, String.valueOf(this.m), this.n, (IRequestHost)new ActivityFragmentActive(getLifecycle()));
  }
  
  public void f() {
    this.j.setVisibility(0);
    this.k.setVisibility(8);
    this.c.setVisibility(8);
    this.l.setVisibility(8);
  }
  
  public void g() {
    this.l.setVisibility(0);
    this.k.setVisibility(8);
    this.c.setVisibility(8);
    this.j.setVisibility(8);
  }
  
  public void h() {
    this.k.setVisibility(0);
    this.l.setVisibility(8);
    this.c.setVisibility(8);
    this.j.setVisibility(8);
  }
  
  public void i() {
    this.c.setVisibility(0);
    this.l.setVisibility(8);
    this.k.setVisibility(8);
    this.j.setVisibility(8);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    int i;
    boolean bool = LiveFloatManager.a().B();
    LayoutInflater layoutInflater = getActivity().getLayoutInflater();
    if (bool) {
      i = R.layout.dialog_live_regular_event_rank_land;
    } else {
      i = R.layout.dialog_live_regular_event_rank;
    } 
    View view = layoutInflater.inflate(i, null);
    Dialog dialog = new Dialog((Context)getActivity(), R.style.transparentFrameWindowStyleLive);
    dialog.requestWindowFeature(1);
    byte b = -1;
    if (bool) {
      dialog.setContentView(view, new ViewGroup.LayoutParams(DensityUtils.a((Context)getActivity(), 360.0F), -1));
    } else {
      dialog.setContentView(view, new ViewGroup.LayoutParams(-1, DensityUtils.a((Context)getActivity(), 290.0F)));
    } 
    Window window = dialog.getWindow();
    if (bool) {
      i = R.style.rank_menu_animstyle;
    } else {
      i = R.style.main_menu_animstyle;
    } 
    window.setWindowAnimations(i);
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.x = 0;
    layoutParams.y = getActivity().getWindowManager().getDefaultDisplay().getHeight();
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
    j();
    return dialog;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.g = (Context)getActivity();
    View view = paramLayoutInflater.inflate(R.layout.dialog_live_regular_event_rank, paramViewGroup);
    this.j = view.findViewById(R.id.ll_nodata);
    this.k = view.findViewById(R.id.ll_error);
    this.l = view.findViewById(R.id.loading_view);
    this.c = (RenrenPullToRefreshListView)view.findViewById(R.id.rptrlv_live_list);
    this.c.setRefreshEnabled(false);
    this.d = (ListView)this.c.getRefreshableView();
    this.f = (TextView)view.findViewById(R.id.tv_rank_title);
    this.c.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            this.a.a(true);
          }
          
          public void b() {
            this.a.a(false);
          }
        });
    this.d.setDivider(null);
    this.d.setSelector((Drawable)new ColorDrawable(0));
    this.e = new LiveRankGuestListItemAdapter((Fragment)this, new ArrayList(), true, false, (IRequestHost)a());
    this.d.setAdapter((ListAdapter)this.e);
    ILiveHostDialog iLiveHostDialog = this.b;
    if (iLiveHostDialog != null)
      iLiveHostDialog.a(); 
    this.c.postDelayed(new Runnable(this) {
          public void run() {
            this.a.c.k();
          }
        },  100L);
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    ILiveHostDialog iLiveHostDialog = this.b;
    if (iLiveHostDialog != null)
      iLiveHostDialog.b(); 
  }
  
  public static interface ILiveHostDialog {
    void a();
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveRegularEventRanklistDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */