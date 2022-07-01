package com.blued.android.module.live_china.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BluedLiveTopCard;
import com.blued.android.module.live_china.model.LiveTaskListModel;
import com.blued.android.module.live_china.model.LiveTaskListModelExtra;
import com.blued.android.module.live_china.model.LiveTaskModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.List;

public class LiveAnchorTaskView extends FrameLayout implements View.OnClickListener {
  private LinearLayout a;
  
  private LinearLayout b;
  
  private CardView c;
  
  private PopupWindow d;
  
  private TaskDialogHolder e;
  
  private LayoutInflater f;
  
  private BaseFragment g;
  
  private String h;
  
  private boolean i;
  
  private LiveTaskModel j;
  
  private long k = 0L;
  
  public LiveAnchorTaskView(Context paramContext) {
    super(paramContext);
    d();
  }
  
  public LiveAnchorTaskView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public LiveAnchorTaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private void a(TextView paramTextView, int paramInt, Object... paramVarArgs) {
    paramTextView.setText(String.format(getContext().getResources().getString(paramInt), paramVarArgs));
  }
  
  private void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    LiveRoomHttpUtils.a(LiveRoomManager.a().b(), paramString, new BluedUIHttpResponse<BluedEntityA<BluedLiveTopCard>>(this, (IRequestHost)this.g.w_()) {
          protected void a(BluedEntityA<BluedLiveTopCard> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null) {
              if (param1BluedEntityA.data.isEmpty())
                return; 
              ToastUtils.a("领取成功", 0);
              this.a.getTaskList();
            } 
          }
        }(IRequestHost)this.g.w_());
  }
  
  private void a(List<LiveTaskListModel> paramList, LiveTaskListModelExtra paramLiveTaskListModelExtra) {
    EventTrackLive.a(LiveProtos.Event.LIVE_TASK_ENTER_SHOW, LiveRoomManager.a().c(), LiveRoomManager.a().e());
    View view = this.f.inflate(R.layout.live_pop_anchor_task, null);
    this.e = new TaskDialogHolder(this, view);
    b(paramList, paramLiveTaskListModelExtra);
    this.e.a.setOnClickListener(this);
    this.e.d.setOnClickListener(this);
    this.e.g.setOnClickListener(this);
    this.e.j.setOnClickListener(this);
    if (!this.i) {
      this.e.g.setVisibility(4);
      this.e.j.setVisibility(4);
      this.e.n.setVisibility(8);
      this.e.c.setVisibility(8);
      this.e.f.setVisibility(8);
      this.e.i.setVisibility(8);
      this.e.l.setVisibility(8);
    } else {
      this.e.g.setVisibility(0);
      this.e.j.setVisibility(0);
      this.e.n.setVisibility(0);
      this.e.c.setVisibility(0);
      this.e.f.setVisibility(0);
      this.e.i.setVisibility(0);
      this.e.l.setVisibility(0);
    } 
    int i = AppInfo.l - DensityUtils.a(getContext(), 38.0F) * 2;
    int j = (int)(i * 0.3D);
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.e.m.getLayoutParams();
    layoutParams.width = i;
    layoutParams.height = j;
    this.e.m.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.d = new PopupWindow(view, i, -2);
    this.d.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    this.d.setOutsideTouchable(true);
    this.d.setFocusable(true);
    this.d.update();
    this.d.showAtLocation(((Activity)getContext()).getWindow().getDecorView(), 17, 0, 0);
    this.k = System.currentTimeMillis();
  }
  
  private void b(List<LiveTaskListModel> paramList, LiveTaskListModelExtra paramLiveTaskListModelExtra) {
    if (paramList != null && !paramList.isEmpty()) {
      if (this.e == null)
        return; 
      for (LiveTaskListModel liveTaskListModel : paramList) {
        int i = liveTaskListModel.task_type;
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4)
                continue; 
              this.e.j.setTag(liveTaskListModel.task_id);
              this.e.k.setText(liveTaskListModel.task_text);
              this.e.l.setText(liveTaskListModel.task_reward_text);
              TaskDialogHolder taskDialogHolder1 = this.e;
              taskDialogHolder1.a(taskDialogHolder1.j, liveTaskListModel.task_status);
              continue;
            } 
            this.e.a.setTag(liveTaskListModel.task_id);
            this.e.b.setText(liveTaskListModel.task_text);
            this.e.c.setText(liveTaskListModel.task_reward_text);
            if (this.i) {
              TaskDialogHolder taskDialogHolder1 = this.e;
              taskDialogHolder1.a(taskDialogHolder1.a, liveTaskListModel.task_status);
              continue;
            } 
            this.e.a(paramLiveTaskListModelExtra.is_follow);
            continue;
          } 
          this.e.d.setTag(liveTaskListModel.task_id);
          this.e.e.setText(liveTaskListModel.task_text);
          this.e.f.setText(liveTaskListModel.task_reward_text);
          if (this.i) {
            TaskDialogHolder taskDialogHolder1 = this.e;
            taskDialogHolder1.a(taskDialogHolder1.d, liveTaskListModel.task_status);
            continue;
          } 
          this.e.a();
          continue;
        } 
        this.e.g.setTag(liveTaskListModel.task_id);
        this.e.h.setText(liveTaskListModel.task_text);
        this.e.i.setText(liveTaskListModel.task_reward_text);
        TaskDialogHolder taskDialogHolder = this.e;
        taskDialogHolder.a(taskDialogHolder.g, liveTaskListModel.task_status);
      } 
      if (paramLiveTaskListModelExtra != null)
        a(this.e.o, R.string.live_task_award_introduction, new Object[] { Integer.valueOf(paramLiveTaskListModelExtra.duration), Integer.valueOf(paramLiveTaskListModelExtra.duration), Integer.valueOf(paramLiveTaskListModelExtra.current_time) }); 
    } 
  }
  
  private void d() {
    this.f = LayoutInflater.from(getContext());
    this.f.inflate(R.layout.live_anchor_task_layout, (ViewGroup)this, true);
    this.c = (CardView)findViewById(R.id.live_task_root_view);
    this.a = (LinearLayout)findViewById(R.id.live_anchor_layout);
    this.b = (LinearLayout)findViewById(R.id.live_task_list);
    this.a.setOnClickListener(this);
  }
  
  public void a() {
    if (LiveRoomManager.a().h() == null)
      return; 
    LiveTaskModel liveTaskModel = LiveRoomManager.a().r();
    if (liveTaskModel != null && liveTaskModel.task_list != null) {
      int i;
      if (liveTaskModel.task_list.isEmpty())
        return; 
      this.j = liveTaskModel;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("mIsLandLayout = ");
      stringBuilder.append(LiveFloatManager.a().B());
      String str = stringBuilder.toString();
      byte b = 0;
      Logger.d("task", new Object[] { str });
      this.b.removeAllViews();
      if (LiveFloatManager.a().B()) {
        this.a.setVisibility(8);
      } else {
        this.a.setVisibility(0);
      } 
      BaseFragment baseFragment = this.g;
      if (baseFragment instanceof RecordingOnliveFragment && ((RecordingOnliveFragment)baseFragment).aQ()) {
        this.a.setVisibility(8);
        i = b;
      } else {
        baseFragment = this.g;
        i = b;
        if (baseFragment instanceof PlayingOnliveFragment) {
          i = b;
          if (((PlayingOnliveFragment)baseFragment).aF()) {
            this.a.setVisibility(8);
            i = b;
          } 
        } 
      } 
      while (i < liveTaskModel.task_list.size()) {
        String str1 = liveTaskModel.task_list.get(i);
        TextView textView = new TextView(getContext());
        textView.setText(str1);
        textView.setTextSize(9.0F);
        textView.setTextColor(getResources().getColor(R.color.syc_dark_b));
        this.b.addView((View)textView);
        i++;
      } 
    } 
  }
  
  public void a(int paramInt) {
    BaseFragment baseFragment = this.g;
    if (!(baseFragment instanceof RecordingOnliveFragment))
      return; 
    if (baseFragment instanceof RecordingOnliveFragment && ((RecordingOnliveFragment)baseFragment).aQ()) {
      this.c.setVisibility(8);
      return;
    } 
    int j = DensityUtils.a(getContext(), 55.0F);
    int i = j;
    if (((RecordingOnliveFragment)this.g).q.getVisibility() == 0) {
      i = j;
      if (paramInt != 0) {
        i = j;
        if (paramInt != 2) {
          i = j;
          if (paramInt != 3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("上麦管理 Height = ");
            stringBuilder.append(DensityUtils.a(getContext(), 55.0F));
            Logger.d("LiveAnchorTaskView", new Object[] { stringBuilder.toString() });
            i = j + DensityUtils.a(getContext(), 55.0F);
          } 
        } 
      } 
    } 
    j = i;
    if (((RecordingOnliveFragment)this.g).Q.getVisibility() == 0) {
      j = i;
      if (paramInt != 0) {
        j = i;
        if (paramInt != 2) {
          j = i;
          if (paramInt != 3) {
            ((RecordingOnliveFragment)this.g).Q.measure(0, 0);
            j = ((RecordingOnliveFragment)this.g).Q.getMeasuredHeight();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("活动图标 Height = ");
            stringBuilder.append(j);
            Logger.d("LiveAnchorTaskView", new Object[] { stringBuilder.toString() });
            j = i + j;
          } 
        } 
      } 
    } 
    if (paramInt == 2 || paramInt == 3) {
      paramInt = DensityUtils.a(getContext(), 187.0F);
      i = DensityUtils.a(getContext(), 64.0F);
      j = DensityUtils.a(getContext(), 20.0F) + paramInt + i;
    } 
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.c.getLayoutParams();
    layoutParams.gravity = 85;
    layoutParams.bottomMargin = j;
    this.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void a(BaseFragment paramBaseFragment, boolean paramBoolean) {
    this.g = paramBaseFragment;
    if (paramBoolean)
      setVisibility(0); 
    paramBaseFragment = this.g;
    if (paramBaseFragment instanceof RecordingOnliveFragment && ((RecordingOnliveFragment)paramBaseFragment).aQ()) {
      this.c.setVisibility(8);
    } else {
      paramBaseFragment = this.g;
      if (paramBaseFragment instanceof PlayingOnliveFragment && ((PlayingOnliveFragment)paramBaseFragment).aF())
        this.c.setVisibility(8); 
    } 
    this.i = this.g instanceof RecordingOnliveFragment;
    this.h = LiveRoomInfo.a().f();
    if (!this.i && LiveRoomManager.a().h() != null)
      this.h = LiveRoomManager.a().e(); 
  }
  
  public void b() {
    LiveTaskModel liveTaskModel = this.j;
    if (liveTaskModel != null && liveTaskModel.task_list != null) {
      if (this.j.task_list.isEmpty())
        return; 
      if (LiveFloatManager.a().B()) {
        this.a.setVisibility(8);
        return;
      } 
      this.a.setVisibility(0);
    } 
  }
  
  public void b(int paramInt) {
    BaseFragment baseFragment = this.g;
    if (!(baseFragment instanceof PlayingOnliveFragment))
      return; 
    if (baseFragment instanceof PlayingOnliveFragment && ((PlayingOnliveFragment)baseFragment).aF()) {
      this.c.setVisibility(8);
      return;
    } 
    int i = DensityUtils.a(getContext(), 55.0F);
    int j = i;
    if (((PlayingOnliveFragment)this.g).bT.getVisibility() == 0) {
      j = ((PlayingOnliveFragment)this.g).bT.getHeight();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("首充礼包 Height = ");
      stringBuilder1.append(j);
      Logger.d("LiveAnchorTaskView", new Object[] { stringBuilder1.toString() });
      j = i + j;
    } 
    i = j;
    if (((PlayingOnliveFragment)this.g).q.getVisibility() == 0) {
      i = j;
      if (paramInt != 0) {
        i = j;
        if (paramInt != 2) {
          i = j;
          if (paramInt != 3) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("上麦管理 Height = ");
            stringBuilder1.append(DensityUtils.a(getContext(), 55.0F));
            Logger.d("LiveAnchorTaskView", new Object[] { stringBuilder1.toString() });
            i = j + DensityUtils.a(getContext(), 55.0F);
          } 
        } 
      } 
    } 
    j = i;
    if (((PlayingOnliveFragment)this.g).aV.getVisibility() == 0) {
      j = i;
      if (paramInt != 0) {
        j = i;
        if (paramInt != 2) {
          j = i;
          if (paramInt != 3) {
            ((PlayingOnliveFragment)this.g).aV.measure(0, 0);
            j = ((PlayingOnliveFragment)this.g).aV.getMeasuredHeight();
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("活动图标 Height = ");
            stringBuilder1.append(j);
            Logger.d("LiveAnchorTaskView", new Object[] { stringBuilder1.toString() });
            j = i + j;
          } 
        } 
      } 
    } 
    if (paramInt == 2 || paramInt == 3) {
      paramInt = DensityUtils.a(getContext(), 187.0F);
      i = DensityUtils.a(getContext(), 64.0F);
      i = DensityUtils.a(getContext(), 20.0F) + paramInt + i;
    } else {
      i = j;
      if (paramInt == 1)
        i = j + DensityUtils.a(getContext(), 10.0F); 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bottomMargin = ");
    stringBuilder.append(i);
    Logger.d("LiveAnchorTaskView", new Object[] { stringBuilder.toString() });
    this.c.setVisibility(0);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
    layoutParams.gravity = 85;
    layoutParams.rightMargin = DensityUtils.a(getContext(), 10.0F);
    layoutParams.bottomMargin = i;
    this.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void c() {
    PopupWindow popupWindow = this.d;
    if (popupWindow != null)
      popupWindow.dismiss(); 
  }
  
  public void getTaskList() {
    LiveRoomHttpUtils.g(this.h, new BluedUIHttpResponse<BluedEntity<LiveTaskListModel, LiveTaskListModelExtra>>(this, (IRequestHost)this.g.w_()) {
          public void onUIUpdate(BluedEntity<LiveTaskListModel, LiveTaskListModelExtra> param1BluedEntity) {
            if (param1BluedEntity == null || param1BluedEntity.data == null || param1BluedEntity.data.isEmpty()) {
              LiveAnchorTaskView.a(this.a).setVisibility(8);
              return;
            } 
            if (LiveAnchorTaskView.b(this.a) != null && LiveAnchorTaskView.b(this.a).isShowing()) {
              LiveAnchorTaskView.a(this.a, param1BluedEntity.data, (LiveTaskListModelExtra)param1BluedEntity.extra);
              LiveAnchorTaskView.b(this.a).update();
              return;
            } 
            LiveAnchorTaskView.a(this.a).setVisibility(0);
            LiveAnchorTaskView.b(this.a, param1BluedEntity.data, (LiveTaskListModelExtra)param1BluedEntity.extra);
          }
        }(IRequestHost)this.g.w_());
  }
  
  public void onClick(View paramView) {
    PopupWindow popupWindow;
    String str;
    if (paramView.getId() == R.id.live_anchor_layout) {
      popupWindow = this.d;
      if (popupWindow != null && popupWindow.isShowing()) {
        if (System.currentTimeMillis() - this.k < 800L)
          return; 
        this.d.dismiss();
        return;
      } 
      EventTrackLive.a(LiveProtos.Event.LIVE_TASK_ENTER_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e());
      getTaskList();
      return;
    } 
    if (popupWindow.getId() == R.id.live_receive_fans) {
      str = (String)popupWindow.getTag();
      if (this.i) {
        a(str);
        EventTrackLive.b(LiveProtos.Event.LIVE_TASK_GET_CLICK, LiveRoomManager.a().c(), str);
        return;
      } 
      EventTrackLive.a(LiveProtos.Event.LIVE_TASK_FOLLOW_CLICK, LiveRoomManager.a().c(), str, LiveRoomManager.a().e());
      LiveSetDataObserver.a().k();
      getTaskList();
      return;
    } 
    if (str.getId() == R.id.live_receive_coin) {
      str = (String)str.getTag();
      if (!this.i) {
        PopupWindow popupWindow1 = this.d;
        if (popupWindow1 != null)
          popupWindow1.dismiss(); 
        EventTrackLive.a(LiveProtos.Event.LIVE_TASK_SEND_GIFT_CLICK, LiveRoomManager.a().c(), str, LiveRoomManager.a().e());
        LiveRefreshUIObserver.a().i();
        return;
      } 
      EventTrackLive.b(LiveProtos.Event.LIVE_TASK_GET_CLICK, LiveRoomManager.a().c(), str);
      a(str);
      return;
    } 
    if (str.getId() == R.id.live_receive_time) {
      str = (String)str.getTag();
      EventTrackLive.b(LiveProtos.Event.LIVE_TASK_GET_CLICK, LiveRoomManager.a().c(), str);
      a(str);
      return;
    } 
    if (str.getId() == R.id.live_receive_day) {
      str = (String)str.getTag();
      EventTrackLive.b(LiveProtos.Event.LIVE_TASK_GET_CLICK, LiveRoomManager.a().c(), str);
      a(str);
    } 
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt) {
    super.onVisibilityChanged(paramView, paramInt);
  }
  
  public class TaskDialogHolder {
    ShapeTextView a;
    
    TextView b;
    
    TextView c;
    
    ShapeTextView d;
    
    TextView e;
    
    TextView f;
    
    ShapeTextView g;
    
    TextView h;
    
    TextView i;
    
    ShapeTextView j;
    
    TextView k;
    
    TextView l;
    
    ImageView m;
    
    LinearLayout n;
    
    TextView o;
    
    TextView p;
    
    TextView q;
    
    TextView r;
    
    TextView s;
    
    public TaskDialogHolder(LiveAnchorTaskView this$0, View param1View) {
      this.a = (ShapeTextView)param1View.findViewById(R.id.live_receive_fans);
      this.b = (TextView)param1View.findViewById(R.id.live_fans_count);
      this.c = (TextView)param1View.findViewById(R.id.live_fans_award);
      this.d = (ShapeTextView)param1View.findViewById(R.id.live_receive_coin);
      this.e = (TextView)param1View.findViewById(R.id.live_coin_count);
      this.f = (TextView)param1View.findViewById(R.id.live_coin_award);
      this.g = (ShapeTextView)param1View.findViewById(R.id.live_receive_time);
      this.h = (TextView)param1View.findViewById(R.id.live_time_count);
      this.i = (TextView)param1View.findViewById(R.id.live_time_award);
      this.j = (ShapeTextView)param1View.findViewById(R.id.live_receive_day);
      this.k = (TextView)param1View.findViewById(R.id.live_day_count);
      this.l = (TextView)param1View.findViewById(R.id.live_day_award);
      this.p = (TextView)param1View.findViewById(R.id.live_fans_index);
      this.q = (TextView)param1View.findViewById(R.id.live_coin_index);
      this.r = (TextView)param1View.findViewById(R.id.live_time_index);
      this.s = (TextView)param1View.findViewById(R.id.live_day_index);
      this.m = (ImageView)param1View.findViewById(R.id.live_task_logo);
      this.n = (LinearLayout)param1View.findViewById(R.id.live_task_info_layout);
      this.o = (TextView)param1View.findViewById(R.id.live_task_introduction);
      if (!LiveAnchorTaskView.c(this$0)) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
        layoutParams.addRule(15);
        this.p.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        layoutParams = (RelativeLayout.LayoutParams)this.q.getLayoutParams();
        layoutParams.addRule(15);
        this.q.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        layoutParams = (RelativeLayout.LayoutParams)this.r.getLayoutParams();
        layoutParams.addRule(15);
        this.r.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        layoutParams = (RelativeLayout.LayoutParams)this.s.getLayoutParams();
        layoutParams.addRule(15);
        this.s.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      } 
    }
    
    public void a() {
      this.d.setEnabled(true);
      ShapeHelper.a((ShapeHelper.ShapeView)this.d, R.color.syc_w_996AFB, R.color.syc_w_465CF2);
      this.d.setText(this.t.getResources().getString(R.string.live_ranking_tips));
    }
    
    public void a(int param1Int) {
      String str;
      if (param1Int == 0) {
        this.a.setEnabled(true);
        ShapeHelper.a((ShapeHelper.ShapeView)this.a, R.color.syc_w_996AFB, R.color.syc_w_465CF2);
        str = this.t.getResources().getString(R.string.live_reward_follow);
      } else {
        this.a.setEnabled(false);
        ShapeHelper.a((ShapeHelper.ShapeView)this.a, R.color.syc_dark_z, R.color.syc_dark_z);
        str = this.t.getResources().getString(R.string.live_chat_followed);
      } 
      this.a.setText(str);
    }
    
    public void a(ShapeTextView param1ShapeTextView, int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int != 2)
            return; 
          param1ShapeTextView.setEnabled(false);
          ShapeHelper.a((ShapeHelper.ShapeView)param1ShapeTextView, R.color.syc_dark_z, R.color.syc_dark_z);
          param1ShapeTextView.setText(this.t.getContext().getResources().getString(R.string.live_box_receive_ok));
          return;
        } 
        param1ShapeTextView.setEnabled(true);
        ShapeHelper.a((ShapeHelper.ShapeView)param1ShapeTextView, R.color.syc_w_996AFB, R.color.syc_w_465CF2);
        param1ShapeTextView.setText(this.t.getContext().getResources().getString(R.string.live_box_receive));
        return;
      } 
      param1ShapeTextView.setEnabled(false);
      ShapeHelper.a((ShapeHelper.ShapeView)param1ShapeTextView, R.color.syc_dark_z, R.color.syc_dark_z);
      param1ShapeTextView.setText(this.t.getContext().getResources().getString(R.string.live_box_receive));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveAnchorTaskView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */