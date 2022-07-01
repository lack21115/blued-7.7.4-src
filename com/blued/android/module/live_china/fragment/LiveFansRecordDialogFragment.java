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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveFansPrivilegeAdapater;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;

public class LiveFansRecordDialogFragment extends BaseDialogFragment implements View.OnClickListener, LiveFansReNameDialogFragment.ILiveFansEditDialog {
  public static int d;
  
  private View A;
  
  private View B;
  
  private View C;
  
  private ProgressBar D;
  
  private View E;
  
  private View F;
  
  private View G;
  
  private View H;
  
  private View I;
  
  private RecyclerView J;
  
  private LiveFansPrivilegeAdapater K;
  
  private boolean L;
  
  private ViewPager.OnPageChangeListener M = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
      
      public void onPageSelected(int param1Int) {
        LiveFansRecordDialogFragment.a(this.a, param1Int);
        LiveFansRecordDialogFragment liveFansRecordDialogFragment = this.a;
        liveFansRecordDialogFragment.a(LiveFansRecordDialogFragment.b(liveFansRecordDialogFragment));
      }
    };
  
  public Context a;
  
  public int b = 3;
  
  public View c;
  
  public LiveFansReNameDialogFragment e;
  
  public LiveFansWebDialogFragment f;
  
  private ViewPager g;
  
  private MyAdapter h;
  
  private int i;
  
  private long j;
  
  private String k;
  
  private ILiveFansRecordDialog l;
  
  private View m;
  
  private View n;
  
  private ImageView o;
  
  private TextView p;
  
  private View q;
  
  private View r;
  
  private View s;
  
  private View t;
  
  private TextView u;
  
  private TextView v;
  
  private TextView w;
  
  private TextView x;
  
  private TextView y;
  
  private TextView z;
  
  private void a(LiveFansInfoModel paramLiveFansInfoModel) {
    if (paramLiveFansInfoModel == null)
      return; 
    this.m.setVisibility(0);
    this.x.setText(String.format(getString(R.string.live_fans_info_num), new Object[] { Integer.valueOf(paramLiveFansInfoModel.member_active) }));
    this.y.setText(String.format(getString(R.string.live_fans_info_num), new Object[] { Integer.valueOf(paramLiveFansInfoModel.member_today) }));
    this.z.setText(String.format(getString(R.string.live_fans_info_num), new Object[] { Integer.valueOf(paramLiveFansInfoModel.member_total) }));
    this.g.setAdapter((PagerAdapter)this.h);
    this.g.setOffscreenPageLimit(3);
    this.g.addOnPageChangeListener(this.M);
    a(0);
  }
  
  private void h() {
    if (getArguments() != null) {
      this.k = getArguments().getString("uid");
      this.j = getArguments().getLong("lid");
    } 
  }
  
  private void i() {
    this.o = (ImageView)this.c.findViewById(R.id.iv_fans_member);
    this.o.setVisibility(8);
    this.p = (TextView)this.c.findViewById(R.id.tv_fans_title);
    this.E = this.c.findViewById(R.id.iv_fans_edit);
    this.E.setVisibility(0);
    this.q = this.c.findViewById(R.id.iv_fans_qa);
    this.q.setVisibility(0);
  }
  
  private void j() {
    this.H = this.c.findViewById(R.id.ll_fans_error);
    this.H.setVisibility(8);
    this.m = this.c.findViewById(R.id.ll_main_view);
    this.m.setVisibility(8);
    this.g = (ViewPager)this.c.findViewById(R.id.dialog_rank_viewpager);
    this.h = new MyAdapter(this, getChildFragmentManager());
    this.r = this.c.findViewById(R.id.ll_active);
    this.s = this.c.findViewById(R.id.ll_today);
    this.t = this.c.findViewById(R.id.ll_all);
    this.u = (TextView)this.c.findViewById(R.id.tv_active_title);
    this.v = (TextView)this.c.findViewById(R.id.tv_today_title);
    this.w = (TextView)this.c.findViewById(R.id.tv_all_title);
    this.x = (TextView)this.c.findViewById(R.id.tv_active_num);
    this.y = (TextView)this.c.findViewById(R.id.tv_today_num);
    this.z = (TextView)this.c.findViewById(R.id.tv_all_num);
    this.A = this.c.findViewById(R.id.ll_active_line);
    this.B = this.c.findViewById(R.id.ll_today_line);
    this.C = this.c.findViewById(R.id.ll_all_line);
    this.I = this.c.findViewById(R.id.empty_view);
    this.I.setOnClickListener(this);
  }
  
  private void k() {
    this.n.setVisibility(0);
    this.J.setAdapter((RecyclerView.Adapter)this.K);
  }
  
  private void l() {
    this.H.setVisibility(0);
    this.E.setVisibility(8);
  }
  
  private void m() {
    this.n = this.c.findViewById(R.id.ll_privilege);
    this.n.setVisibility(8);
    this.F = this.c.findViewById(R.id.view_height_9);
    this.F.setVisibility(8);
    this.G = this.c.findViewById(R.id.view_height_25);
    this.G.setVisibility(0);
    this.J = (RecyclerView)this.c.findViewById(R.id.rv_privilege);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.a, 3);
    this.J.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.K = new LiveFansPrivilegeAdapater(this.a, 0);
  }
  
  public void a(int paramInt) {
    this.g.setCurrentItem(paramInt);
    if (paramInt == 0) {
      this.u.setTextColor(getResources().getColor(R.color.syc_dark_h));
      this.v.setTextColor(getResources().getColor(R.color.syc_dark_j));
      this.w.setTextColor(getResources().getColor(R.color.syc_dark_j));
      this.x.setTextColor(getResources().getColor(R.color.syc_dark_h));
      this.y.setTextColor(getResources().getColor(R.color.syc_dark_j));
      this.z.setTextColor(getResources().getColor(R.color.syc_dark_j));
      this.A.setVisibility(0);
      this.B.setVisibility(4);
      this.C.setVisibility(4);
      return;
    } 
    if (paramInt == 1) {
      this.u.setTextColor(getResources().getColor(R.color.syc_dark_j));
      this.v.setTextColor(getResources().getColor(R.color.syc_dark_h));
      this.w.setTextColor(getResources().getColor(R.color.syc_dark_j));
      this.x.setTextColor(getResources().getColor(R.color.syc_dark_j));
      this.y.setTextColor(getResources().getColor(R.color.syc_dark_h));
      this.z.setTextColor(getResources().getColor(R.color.syc_dark_j));
      this.A.setVisibility(4);
      this.B.setVisibility(0);
      this.C.setVisibility(4);
      return;
    } 
    if (paramInt == 2) {
      this.u.setTextColor(getResources().getColor(R.color.syc_dark_j));
      this.v.setTextColor(getResources().getColor(R.color.syc_dark_j));
      this.w.setTextColor(getResources().getColor(R.color.syc_dark_h));
      this.x.setTextColor(getResources().getColor(R.color.syc_dark_j));
      this.y.setTextColor(getResources().getColor(R.color.syc_dark_j));
      this.z.setTextColor(getResources().getColor(R.color.syc_dark_h));
      this.A.setVisibility(4);
      this.B.setVisibility(4);
      this.C.setVisibility(0);
    } 
  }
  
  public void a(ILiveFansRecordDialog paramILiveFansRecordDialog) {
    this.l = paramILiveFansRecordDialog;
  }
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void f() {
    String str = this.k;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.j);
    stringBuilder.append("");
    LiveRoomHttpUtils.b(str, stringBuilder.toString(), new BluedUIHttpResponse<BluedEntityA<LiveFansInfoModel>>(this, (IRequestHost)a()) {
          protected void a(BluedEntityA<LiveFansInfoModel> param1BluedEntityA) {
            if (!LiveFansRecordDialogFragment.c(this.a))
              return; 
            LiveFansRecordDialogFragment.d(this.a).setVisibility(8);
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              LiveFansInfoModel liveFansInfoModel = param1BluedEntityA.data.get(0);
              LiveRoomManager.a().a(liveFansInfoModel);
              LiveFansRecordDialogFragment.e(this.a).setText(String.format(this.a.getString(R.string.live_fans_owner), new Object[] { liveFansInfoModel.anchor_name }));
              if (liveFansInfoModel.member_total > 0) {
                LiveFansRecordDialogFragment.a(this.a, liveFansInfoModel);
                return;
              } 
              LiveFansRecordDialogFragment.f(this.a);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (!LiveFansRecordDialogFragment.c(this.a))
              return true; 
            LiveFansRecordDialogFragment.d(this.a).setVisibility(8);
            LiveFansRecordDialogFragment.g(this.a);
            AppMethods.a(param1String);
            return true;
          }
        }(IRequestHost)a());
  }
  
  public void g() {
    this.f = new LiveFansWebDialogFragment();
    Bundle bundle = new Bundle();
    bundle.putString("url", LiveRoomInfo.a().C());
    bundle.putInt("type", 0);
    this.f.setArguments(bundle);
    this.f.show(getFragmentManager(), "webDialog");
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == R.id.ll_active) {
      EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_ACTIVE_CLICK, String.valueOf(this.j));
      a(0);
      return;
    } 
    if (i == R.id.ll_today) {
      EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_TODAY_CLICK, String.valueOf(this.j));
      a(1);
      return;
    } 
    if (i == R.id.ll_all) {
      EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_ALL_CLICK, String.valueOf(this.j));
      a(2);
      return;
    } 
    if (i == R.id.iv_fans_edit) {
      String str;
      EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_EDIT_NAME_CLICK, String.valueOf(this.j));
      if (LiveRoomManager.a().i() != null && (LiveRoomManager.a().i()).apply == 1) {
        AppMethods.d(R.string.live_fans_name_modify_tip);
        return;
      } 
      this.e = new LiveFansReNameDialogFragment();
      Bundle bundle = new Bundle();
      bundle.putLong("lid", this.j);
      if (LiveRoomManager.a().i() != null) {
        str = (LiveRoomManager.a().i()).name;
      } else {
        str = "";
      } 
      bundle.putString("name", str);
      this.e.setArguments(bundle);
      this.e.a(this);
      this.e.show(getFragmentManager(), "liveFansEditDialog");
      return;
    } 
    if (i == R.id.iv_fans_qa) {
      EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_QA_CLICK, String.valueOf(this.j));
      g();
      return;
    } 
    if (i == R.id.empty_view)
      dismiss(); 
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    this.a = (Context)getActivity();
    View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_fans_record, null);
    int i = DensityUtils.a((Context)getActivity(), 360.0F);
    Dialog dialog = new Dialog((Context)getActivity(), R.style.transparentFrameWindowStyleLive);
    dialog.requestWindowFeature(1);
    dialog.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    dialog.setContentView(view, new ViewGroup.LayoutParams(-1, i));
    Window window = dialog.getWindow();
    window.setWindowAnimations(R.style.main_menu_animstyle);
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.width = -1;
    layoutParams.height = i;
    layoutParams.x = 0;
    layoutParams.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - i;
    dialog.onWindowAttributesChanged(layoutParams);
    h();
    return dialog;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    getDialog().getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    this.c = paramLayoutInflater.inflate(R.layout.dialog_live_fans_record, paramViewGroup);
    this.D = (ProgressBar)this.c.findViewById(R.id.loading_view);
    this.D.setVisibility(0);
    i();
    j();
    m();
    f();
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.q.setOnClickListener(this);
    ILiveFansRecordDialog iLiveFansRecordDialog = this.l;
    if (iLiveFansRecordDialog != null)
      iLiveFansRecordDialog.a(); 
    this.L = true;
    return this.c;
  }
  
  public void onDestroy() {
    super.onDestroy();
    ILiveFansRecordDialog iLiveFansRecordDialog = this.l;
    if (iLiveFansRecordDialog != null)
      iLiveFansRecordDialog.D_(); 
  }
  
  public void onDestroyView() {
    this.L = false;
    super.onDestroyView();
  }
  
  public void onPause() {
    super.onPause();
    LiveFansReNameDialogFragment liveFansReNameDialogFragment = this.e;
    if (liveFansReNameDialogFragment != null) {
      Dialog dialog = liveFansReNameDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.e.dismiss(); 
    } 
    LiveFansWebDialogFragment liveFansWebDialogFragment = this.f;
    if (liveFansWebDialogFragment != null) {
      Dialog dialog = liveFansWebDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.f.dismiss(); 
    } 
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString) {
    try {
      ReflectionUtils.a(this, "mDismissed", Boolean.valueOf(false));
      ReflectionUtils.a(this, "mShownByMe", Boolean.valueOf(true));
      FragmentTransaction fragmentTransaction = paramFragmentManager.beginTransaction();
      fragmentTransaction.add((Fragment)this, paramString);
      fragmentTransaction.commitAllowingStateLoss();
      return;
    } catch (Exception exception) {
      super.show(paramFragmentManager, paramString);
      return;
    } 
  }
  
  public void v_() {}
  
  public static interface ILiveFansRecordDialog {
    void D_();
    
    void a();
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    FragmentManager a;
    
    public MyAdapter(LiveFansRecordDialogFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
      this.a = param1FragmentManager;
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return this.b.b;
    }
    
    public Fragment getItem(int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int != 2)
            return null; 
          Bundle bundle2 = new Bundle();
          bundle2.putInt("index", 2);
          bundle2.putLong("lid", LiveFansRecordDialogFragment.a(this.b));
          LiveFansRecordMemberFragment liveFansRecordMemberFragment2 = new LiveFansRecordMemberFragment();
          liveFansRecordMemberFragment2.setArguments(bundle2);
          return (Fragment)liveFansRecordMemberFragment2;
        } 
        Bundle bundle1 = new Bundle();
        bundle1.putInt("index", 1);
        bundle1.putLong("lid", LiveFansRecordDialogFragment.a(this.b));
        LiveFansRecordMemberFragment liveFansRecordMemberFragment1 = new LiveFansRecordMemberFragment();
        liveFansRecordMemberFragment1.setArguments(bundle1);
        return (Fragment)liveFansRecordMemberFragment1;
      } 
      Bundle bundle = new Bundle();
      bundle.putInt("index", 0);
      bundle.putLong("lid", LiveFansRecordDialogFragment.a(this.b));
      LiveFansRecordMemberFragment liveFansRecordMemberFragment = new LiveFansRecordMemberFragment();
      liveFansRecordMemberFragment.setArguments(bundle);
      return (Fragment)liveFansRecordMemberFragment;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveFansRecordDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */