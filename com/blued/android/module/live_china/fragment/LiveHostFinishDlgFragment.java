package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveCloseItemAdapter;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BluedLiveRankListData;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.live_china.model.LiveCloseModel;
import com.blued.android.module.live_china.model.LiveConsumeEntity;
import com.blued.android.module.live_china.model.LiveConsumeExtra;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;

public class LiveHostFinishDlgFragment extends SimpleFragment {
  private View A;
  
  private TextView B;
  
  private TextView C;
  
  private ProgressBar D;
  
  private ImageView E;
  
  private TextView F;
  
  private TextView G;
  
  private TextView H;
  
  public ProgressBar h;
  
  public RenrenPullToRefreshListView i;
  
  public View j;
  
  public LiveCloseItemAdapter k;
  
  public ListView l;
  
  public TextView m;
  
  public TextView n;
  
  public TextView o;
  
  public TextView p;
  
  public TextView q;
  
  public TextView r;
  
  public LinearLayout s;
  
  public TextView t;
  
  public Button u;
  
  public ImageView v;
  
  public List<BluedLiveRankListData> w = new ArrayList<BluedLiveRankListData>();
  
  public int x = 1;
  
  public boolean y = true;
  
  private View z;
  
  private void u() {
    EventTrackLive.a(LiveProtos.Event.ANCHOR_END_PAGE_CONFIRM_CLICK, LiveRoomManager.a().c());
    getActivity().finish();
    if (LiveRoomManager.a().B())
      LiveRoomInfo.a().a(getContext()); 
  }
  
  private void v() {
    EventTrackLive.a(LiveProtos.Event.ANCHOR_END_PAGE_RECORD_SHARE_CLICK, LiveRoomManager.a().c());
    if (getParentFragment() != null && getParentFragment() instanceof RecordingOnliveFragment)
      ((RecordingOnliveFragment)getParentFragment()).bi(); 
  }
  
  private void w() {
    EventTrackLive.a(LiveProtos.Event.ANCHOR_END_PAGE_EXPERIENCE_QUESTION_CLICK, LiveRoomManager.a().c());
    LiveRoomInfo.a().b((Context)getActivity(), LiveRoomInfo.a().x());
  }
  
  private void x() {
    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<LiveCloseModel>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<LiveCloseModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
              LiveCloseModel liveCloseModel = (LiveCloseModel)param1BluedEntityA.getSingleData();
              if (liveCloseModel.info != null) {
                EventTrackLive.a(LiveProtos.Event.ANCHOR_END_PAGE_SHOW, LiveRoomManager.a().c(), (int)liveCloseModel.info.total_beans, (int)liveCloseModel.info.current_beans, liveCloseModel.info.total_watch_count, liveCloseModel.info.liked, liveCloseModel.info.top_watch_count, liveCloseModel.info.live_time);
                if (liveCloseModel.info.total_beans > 0L) {
                  this.a.q.setText(CommonStringUtils.a(liveCloseModel.info.total_beans));
                } else {
                  this.a.q.setText(CommonStringUtils.a(LiveRoomManager.a().m()));
                } 
                if (liveCloseModel.info.current_beans > 0L) {
                  this.a.r.setText(CommonStringUtils.a(liveCloseModel.info.current_beans));
                } else {
                  this.a.r.setText(CommonStringUtils.a(LiveRoomManager.a().n()));
                } 
                this.a.m.setText(CommonStringUtils.a(liveCloseModel.info.total_watch_count));
                this.a.n.setText(CommonStringUtils.a(liveCloseModel.info.liked));
                this.a.o.setText(CommonStringUtils.a(liveCloseModel.info.top_watch_count));
                this.a.p.setText(LiveTimeAndDateUtils.a(liveCloseModel.info.live_time, true));
              } 
              if (liveCloseModel.level != null) {
                float f1;
                int i;
                LiveHostFinishDlgFragment.a(this.a).setText(CommonStringUtils.a(liveCloseModel.level.income_exp));
                if (liveCloseModel.level.double_exp == 0.0F) {
                  LiveHostFinishDlgFragment.b(this.a).setText("");
                } else {
                  TextView textView1 = LiveHostFinishDlgFragment.b(this.a);
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("【 翻倍卡增加经验");
                  stringBuilder.append(CommonStringUtils.a(liveCloseModel.level.double_exp));
                  stringBuilder.append(" 】");
                  textView1.setText(stringBuilder.toString());
                } 
                TextView textView = LiveHostFinishDlgFragment.c(this.a);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Lv.");
                stringBuilder2.append(liveCloseModel.level.level);
                textView.setText(stringBuilder2.toString());
                if (liveCloseModel.level.next_level == -1) {
                  LiveHostFinishDlgFragment.d(this.a).setText("Lv.Max");
                } else {
                  textView = LiveHostFinishDlgFragment.d(this.a);
                  stringBuilder2 = new StringBuilder();
                  stringBuilder2.append("Lv.");
                  stringBuilder2.append(liveCloseModel.level.next_level);
                  textView.setText(stringBuilder2.toString());
                } 
                LiveHostFinishDlgFragment.e(this.a).setText(CommonStringUtils.a(liveCloseModel.level.exp));
                if (liveCloseModel.level.exp - liveCloseModel.level.pre_exp < liveCloseModel.level.income_exp) {
                  i = 0;
                  f1 = LiveUtils.c(liveCloseModel.level.exp, liveCloseModel.level.pre_exp, liveCloseModel.level.next_exp);
                } else {
                  i = LiveUtils.a(liveCloseModel.level.exp, liveCloseModel.level.income_exp, liveCloseModel.level.pre_exp, liveCloseModel.level.next_exp);
                  f1 = LiveUtils.b(liveCloseModel.level.income_exp, liveCloseModel.level.pre_exp, liveCloseModel.level.next_exp);
                } 
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("本场经验百分比:");
                stringBuilder1.append(f1);
                Log.v("pk", stringBuilder1.toString());
                float f2 = f1;
                if (f1 > 1.0F)
                  f2 = 1.0F; 
                LiveHostFinishDlgFragment.f(this.a).setProgress(i);
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append("主播之前的经验进度:");
                stringBuilder1.append(i);
                Log.v("pk", stringBuilder1.toString());
                int j = LiveHostFinishDlgFragment.f(this.a).getWidth();
                int k = LiveHostFinishDlgFragment.e(this.a).getWidth();
                int m = LiveHostFinishDlgFragment.c(this.a).getWidth();
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append("进度条总宽度:");
                stringBuilder1.append(j);
                Log.v("pk", stringBuilder1.toString());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)LiveHostFinishDlgFragment.g(this.a).getLayoutParams();
                if (liveCloseModel.level.next_level == -1) {
                  layoutParams.width = j;
                } else {
                  layoutParams.width = (int)(j * f2);
                  stringBuilder2 = new StringBuilder();
                  stringBuilder2.append("最终进度条的宽度 = ");
                  stringBuilder2.append(layoutParams.width);
                  Log.v("pk", stringBuilder2.toString());
                  if (i > 0) {
                    layoutParams.leftMargin = (int)(j * i * 0.01D);
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("最终进度条距左侧的距离 = ");
                    stringBuilder2.append(layoutParams.leftMargin);
                    Log.v("pk", stringBuilder2.toString());
                  } 
                } 
                float f3 = f2;
                LiveHostFinishDlgFragment.g(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                f2 = (float)(i * 0.01D + f3);
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("之前经验+本场经验:");
                stringBuilder2.append(f2);
                Log.v("pk", stringBuilder2.toString());
                LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams)LiveHostFinishDlgFragment.e(this.a).getLayoutParams();
                if (liveCloseModel.level.next_level == -1) {
                  layoutParams1.gravity = 5;
                  f1 = f2;
                } else {
                  f1 = f2;
                  if (f2 > 1.0F)
                    f1 = 1.0F; 
                  layoutParams1.leftMargin = (int)(j * f1) + m + DensityUtils.a(this.a.getContext(), 5.0F) - k / 2;
                } 
                if (AppInfo.m()) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("主播之前的经验进度:");
                  stringBuilder.append(i);
                  stringBuilder.append("\n 主播当前等级:");
                  stringBuilder.append(liveCloseModel.level.level);
                  stringBuilder.append("\n主播下一等级:");
                  stringBuilder.append(liveCloseModel.level.next_level);
                  stringBuilder.append("\n当前等级开始的经验值:");
                  stringBuilder.append(liveCloseModel.level.pre_exp);
                  stringBuilder.append("\n下一等级开始的经验值:");
                  stringBuilder.append(liveCloseModel.level.next_exp);
                  stringBuilder.append("\n主播当前经验值:");
                  stringBuilder.append(liveCloseModel.level.exp);
                  stringBuilder.append("\n本场获得经验值:");
                  stringBuilder.append(liveCloseModel.level.income_exp);
                  stringBuilder.append("\n进度条总宽度:");
                  stringBuilder.append(j);
                  stringBuilder.append("\n本场经验百分比:");
                  stringBuilder.append(f3);
                  stringBuilder.append("\n最终进度条的宽度 = ");
                  stringBuilder.append(layoutParams.width);
                  stringBuilder.append("\n最终进度条距左侧的距离 = ");
                  stringBuilder.append(layoutParams.leftMargin);
                  stringBuilder.append("\ntip宽度 = ");
                  stringBuilder.append(k);
                  stringBuilder.append("\ncurrent宽度 = ");
                  stringBuilder.append(m);
                  stringBuilder.append("\ntip距左侧的距离 = ");
                  stringBuilder.append(layoutParams1.leftMargin);
                  stringBuilder.append("\n之前经验+本场经验:");
                  stringBuilder.append(f1);
                  String str = stringBuilder.toString();
                  CommonAlertDialog.a((Context)this.a.getActivity(), "", str, this.a.getString(R.string.biao_v4_ok), null, this.a.getString(R.string.cancel), null, null);
                } 
                LiveHostFinishDlgFragment.e(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
              } 
              if ((LiveRoomManager.a().h()).beans_current_count != 0.0D)
                this.a.t(); 
            } 
          }
        }LiveRoomManager.a().c());
  }
  
  public boolean V_() {
    u();
    return true;
  }
  
  public int k() {
    return R.layout.fragment_live_host_finish;
  }
  
  public void l() {}
  
  public void n() {
    this.d.setOnClickListener(-$$Lambda$LiveHostFinishDlgFragment$w8uvVLqAaSoTUPpTihwCXIN4RHU.INSTANCE);
    this.h = (ProgressBar)this.d.findViewById(R.id.live_end_des_loading_view);
    this.i = (RenrenPullToRefreshListView)this.d.findViewById(R.id.lv_rank_list);
    this.i.setRefreshEnabled(false);
    this.i.setOnPullDownListener(new MyPullDownListener(this));
    this.z = getLayoutInflater().inflate(R.layout.live_end_details_layout, null, false);
    this.j = getLayoutInflater().inflate(R.layout.nodata_show_live_rank, null, false);
    this.m = (TextView)this.z.findViewById(R.id.live_all_count_view);
    this.n = (TextView)this.z.findViewById(R.id.live_all_like_view);
    this.o = (TextView)this.z.findViewById(R.id.live_same_count_view);
    this.p = (TextView)this.z.findViewById(R.id.live_time_view);
    this.q = (TextView)this.z.findViewById(R.id.live_all_dou_view);
    this.r = (TextView)this.z.findViewById(R.id.live_this_dou_view);
    this.A = this.z.findViewById(R.id.live_record_this_faq);
    this.B = (TextView)this.z.findViewById(R.id.record_current_level);
    this.C = (TextView)this.z.findViewById(R.id.record_current_ex_tip);
    this.D = (ProgressBar)this.z.findViewById(R.id.record_end_progress);
    this.E = (ImageView)this.z.findViewById(R.id.record_current_ex_progress);
    this.F = (TextView)this.z.findViewById(R.id.record_next_level);
    this.G = (TextView)this.z.findViewById(R.id.live_record_this_ex);
    this.H = (TextView)this.z.findViewById(R.id.tv_double_exp);
    this.l = (ListView)this.i.getRefreshableView();
    this.l.setDivider(null);
    this.l.setSelector((Drawable)new ColorDrawable(0));
    TextView textView = (TextView)this.j.findViewById(R.id.no_data_view);
    textView.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.live_close_rank_nodata_icon), null, null);
    textView.setTextSize(13.0F);
    textView.setTextColor(getResources().getColor(R.color.nafio_k));
    this.k = new LiveCloseItemAdapter(getContext(), this.w, true, (IRequestHost)w_());
    this.l.setAdapter((ListAdapter)this.k);
    this.l.addHeaderView(this.z);
    this.s = (LinearLayout)this.d.findViewById(R.id.screenshot_layout);
    this.t = (TextView)this.d.findViewById(R.id.anchor_share_btn);
    this.u = (Button)this.d.findViewById(R.id.live_exit_des_sure_btn);
    this.v = (ImageView)this.d.findViewById(R.id.background_header);
    this.u.setOnClickListener(new -$$Lambda$LiveHostFinishDlgFragment$wl3TEf385ZQQdzW5Is36_a2wsa0(this));
    this.t.setOnClickListener(new -$$Lambda$LiveHostFinishDlgFragment$-Erc_tCwOGQ7Oapu4Z_T4k957Pg(this));
    this.A.setOnClickListener(new -$$Lambda$LiveHostFinishDlgFragment$AvJIaIxZBSBpLnRjiwEddjiDBxY(this));
  }
  
  public void q() {
    super.q();
    ImageLoader.a((IRequestHost)w_(), LiveRoomInfo.a().d()).d().a(this.v);
    s();
    x();
  }
  
  public void r() {
    if (this.x == 1)
      this.y = true; 
    if (!this.y) {
      int i = this.x;
      if (i != 1) {
        this.x = i - 1;
        AppMethods.a(getString(R.string.common_nomore_data));
        this.i.j();
        return;
      } 
    } 
    s();
  }
  
  public void s() {
    if (this.w == null)
      return; 
    LiveRoomHttpUtils.a(getContext(), LiveRoomInfo.a().f(), LiveRoomManager.a().b(), this.x, new BluedUIHttpResponse<LiveConsumeEntity<BluedLiveRankListData>>(this, (IRequestHost)w_()) {
          public void a(LiveConsumeEntity<BluedLiveRankListData> param1LiveConsumeEntity) {
            CommonStringUtils.d(String.valueOf(((LiveConsumeExtra)param1LiveConsumeEntity.extra).beans));
            if (param1LiveConsumeEntity.data != null && param1LiveConsumeEntity.data.size() > 0) {
              if (param1LiveConsumeEntity.hasMore()) {
                LiveHostFinishDlgFragment liveHostFinishDlgFragment = this.a;
                liveHostFinishDlgFragment.y = true;
                liveHostFinishDlgFragment.i.o();
              } else {
                LiveHostFinishDlgFragment liveHostFinishDlgFragment = this.a;
                liveHostFinishDlgFragment.y = false;
                liveHostFinishDlgFragment.i.p();
              } 
              if (this.a.x == 1)
                this.a.w.clear(); 
              this.a.w.addAll(param1LiveConsumeEntity.data);
              this.a.k.notifyDataSetChanged();
              return;
            } 
            if (this.a.x == 1) {
              this.a.w.clear();
              this.a.k.notifyDataSetChanged();
              this.a.j.setVisibility(0);
              this.a.l.addHeaderView(this.a.j);
            } 
            if (this.a.x != 1) {
              LiveHostFinishDlgFragment liveHostFinishDlgFragment = this.a;
              liveHostFinishDlgFragment.x--;
            } 
            this.a.i.p();
          }
          
          public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1Int);
            stringBuilder.append(", ");
            stringBuilder.append(param1String1);
            Logger.a("onFailure, error:", new Object[] { stringBuilder.toString() });
            this.a.a(new Runnable(this) {
                  public void run() {
                    this.a.a.k.notifyDataSetChanged();
                    this.a.a.j.setVisibility(0);
                    this.a.a.l.addHeaderView(this.a.a.j);
                  }
                });
            return super.onUIFailure(param1Int, param1String1, param1String2);
          }
          
          public void onUIFinish() {
            Logger.a("onFinish", new Object[0]);
            this.a.i.j();
            this.a.i.q();
            this.a.h.setVisibility(8);
          }
        }(IRequestHost)w_());
  }
  
  public void t() {
    LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<BluedLiveState>>(this, (IRequestHost)w_()) {
          public void a(BluedEntityA<BluedLiveState> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.getSingleData() != null) {
              BluedLiveState bluedLiveState = (BluedLiveState)param1BluedEntityA.getSingleData();
              if (bluedLiveState.idcard_verify_status != 1 || bluedLiveState.has_bankcard != 1)
                CommonAlertDialog.a((Context)this.a.getActivity(), this.a.getString(R.string.live_apply_improve_title), this.a.getString(R.string.live_apply_improve_des), this.a.getString(R.string.live_apply_improve_ok), new DialogInterface.OnClickListener(this) {
                      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                        LiveRoomInfo.a().c((Context)this.a.a.getActivity());
                      }
                    },  this.a.getString(R.string.live_apply_improve_cancel), null, null); 
            } 
          }
        }LiveRoomInfo.a().f(), (IRequestHost)w_());
  }
  
  public class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
    public MyPullDownListener(LiveHostFinishDlgFragment this$0) {}
    
    public void a() {
      LiveHostFinishDlgFragment liveHostFinishDlgFragment = this.a;
      liveHostFinishDlgFragment.x = 1;
      liveHostFinishDlgFragment.r();
    }
    
    public void b() {
      LiveHostFinishDlgFragment liveHostFinishDlgFragment = this.a;
      liveHostFinishDlgFragment.x++;
      this.a.r();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveHostFinishDlgFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */