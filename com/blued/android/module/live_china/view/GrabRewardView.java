package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveGrabRewardFansGrayDlgFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveRewardExtraModel;
import com.blued.android.module.live_china.model.LiveRewardListModel;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.RewardErrorModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveRewardStatusObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class GrabRewardView extends FrameLayout implements View.OnClickListener, LiveRewardStatusObserver.ILiveRewardStatusObserver {
  public BaseFragment a;
  
  public boolean b;
  
  private View c;
  
  private Context d;
  
  private LayoutInflater e;
  
  private RecordingOnliveFragment f;
  
  private PlayingOnliveBaseModeFragment g;
  
  private ImageView h;
  
  private LinearLayout i;
  
  private TextView j;
  
  private TextView k;
  
  private Chronometer l;
  
  private long m;
  
  private CountDownTimer n;
  
  private CountDownTimer o;
  
  private LiveRewardModel p;
  
  private Handler q = new Handler();
  
  public GrabRewardView(Context paramContext) {
    super(paramContext);
    this.d = paramContext;
    i();
  }
  
  public GrabRewardView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
    i();
  }
  
  private void c() {
    this.l.setVisibility(0);
    this.i.setVisibility(8);
    this.j.setVisibility(8);
    this.k.setVisibility(8);
  }
  
  private void d() {
    this.l.setVisibility(8);
    this.i.setVisibility(0);
    this.j.setVisibility(8);
    this.k.setVisibility(8);
  }
  
  private void e() {
    this.l.setVisibility(8);
    this.i.setVisibility(8);
    this.j.setVisibility(0);
    this.k.setVisibility(8);
  }
  
  private void f() {
    this.l.setVisibility(8);
    this.i.setVisibility(8);
    this.j.setVisibility(8);
    this.k.setVisibility(0);
  }
  
  private void g() {
    CountDownTimer countDownTimer = this.o;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
  }
  
  private void h() {
    CountDownTimer countDownTimer = this.n;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
  }
  
  private void i() {
    this.e = LayoutInflater.from(this.d);
    this.c = this.e.inflate(R.layout.live_grab_reward_layout, (ViewGroup)this, true);
    this.h = (ImageView)this.c.findViewById(R.id.grab_reward_image);
    this.i = (LinearLayout)this.c.findViewById(R.id.grab_reward_btn);
    this.j = (TextView)this.c.findViewById(R.id.got_reward_btn);
    this.k = (TextView)this.c.findViewById(R.id.robbed_reward_btn);
    this.l = (Chronometer)this.c.findViewById(R.id.grab_reward_chronometer);
    setVisibility(8);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
  }
  
  private void j() {
    if (this.a.getParentFragment() != null && this.a.getParentFragment().isAdded()) {
      LiveGrabRewardFansGrayDlgFragment liveGrabRewardFansGrayDlgFragment = new LiveGrabRewardFansGrayDlgFragment();
      liveGrabRewardFansGrayDlgFragment.setCancelable(true);
      liveGrabRewardFansGrayDlgFragment.show(this.a.getParentFragment().getChildFragmentManager(), liveGrabRewardFansGrayDlgFragment.d());
    } 
  }
  
  public void a() {
    Logger.a("drb", new Object[] { "mLiveRewardModel.start_second = ", Long.valueOf(this.p.start_second) });
    Logger.a("drb", new Object[] { "mLiveRewardModel.remaining_millisecond = ", Long.valueOf(this.p.remaining_millisecond) });
    if (this.p.remaining_millisecond > 0L) {
      long l = this.p.remaining_millisecond % 1000L;
      AppInfo.n().postDelayed(new Runnable(this, l) {
            public void run() {
              GrabRewardView grabRewardView = this.b;
              GrabRewardView.a(grabRewardView, (new CountDownTimer(this, (GrabRewardView.a(grabRewardView)).remaining_millisecond - this.a, 1000L) {
                    public void onFinish() {
                      Logger.a("drb", new Object[] { "红包开抢" });
                      if (!this.a.b.b) {
                        GrabRewardView.d(this.a.b);
                        return;
                      } 
                      GrabRewardView.b(this.a.b).setVisibility(8);
                    }
                    
                    public void onTick(long param2Long) {
                      param2Long = param2Long / 1000L + 1L;
                      GrabRewardView.b(this.a.b).setText(LiveTimeAndDateUtils.a(param2Long, false));
                      GrabRewardView.c(this.a.b);
                      Logger.a("drb", new Object[] { "红包开抢倒计时：", Long.valueOf(param2Long) });
                    }
                  }).start());
            }
          }l);
      return;
    } 
    this.o = (new CountDownTimer(this, this.p.start_second * 1000L, 1000L) {
        public void onFinish() {
          Logger.a("drb", new Object[] { "红包开抢" });
          if (!this.a.b) {
            GrabRewardView.d(this.a);
            return;
          } 
          GrabRewardView.b(this.a).setVisibility(8);
        }
        
        public void onTick(long param1Long) {
          param1Long = param1Long / 1000L + 1L;
          GrabRewardView.b(this.a).setText(LiveTimeAndDateUtils.a(param1Long, false));
          GrabRewardView.c(this.a);
          Logger.a("drb", new Object[] { "红包开抢倒计时：", Long.valueOf(param1Long) });
        }
      }).start();
  }
  
  public void a(int paramInt) {
    this.p.status = paramInt;
    setRewardView(paramInt);
  }
  
  public void a(BaseFragment paramBaseFragment) {
    this.a = paramBaseFragment;
    if (paramBaseFragment instanceof RecordingOnliveFragment) {
      this.b = true;
      this.f = (RecordingOnliveFragment)paramBaseFragment;
      this.m = this.f.u;
      return;
    } 
    if (paramBaseFragment instanceof PlayingOnliveBaseModeFragment) {
      this.b = false;
      this.g = (PlayingOnliveBaseModeFragment)paramBaseFragment;
      this.m = this.g.y;
    } 
  }
  
  public void a(LiveRewardModel paramLiveRewardModel, IGrabRewardListener paramIGrabRewardListener) {
    if (paramLiveRewardModel == null)
      return; 
    LiveRewardModel liveRewardModel = this.p;
    if (liveRewardModel != null && TextUtils.equals(liveRewardModel.hongbao_id, paramLiveRewardModel.hongbao_id))
      return; 
    this.p = paramLiveRewardModel;
    setVisibility(0);
    g();
    h();
    if (paramLiveRewardModel.start_second > 0L) {
      a();
    } else {
      setRewardView(paramLiveRewardModel.status);
    } 
    Logger.a("drb", new Object[] { "mLiveRewardModel is_anim = ", Integer.valueOf(paramLiveRewardModel.is_anim) });
    if (this.a instanceof PlayingOnliveBaseModeFragment && paramLiveRewardModel.status == 0 && paramLiveRewardModel.is_anim == 1) {
      LiveGiftModel liveGiftModel = new LiveGiftModel();
      liveGiftModel.anim_code = "hongbao";
      PlayingOnliveBaseModeFragment playingOnliveBaseModeFragment = this.g;
      if (playingOnliveBaseModeFragment != null && playingOnliveBaseModeFragment.w != null)
        this.g.w.d(liveGiftModel); 
    } 
    LiveRefreshUIObserver.a().b();
    b();
  }
  
  public void a(String paramString1, long paramLong, String paramString2, String paramString3) {
    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<LiveRewardListModel, LiveRewardExtraModel>>(this, (IRequestHost)this.a.w_(), paramString3) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            AppInfo.n().post(new Runnable(this, param1Throwable, param1Int, param1String) {
                  public void run() {
                    this.d.b.a(this.a, this.b, this.c);
                  }
                });
          }
          
          public void onUIFinish() {}
          
          public void onUIStart() {
            super.onUIStart();
          }
          
          public void onUIUpdate(BluedEntity<LiveRewardListModel, LiveRewardExtraModel> param1BluedEntity) {
            try {
              if (param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
                LiveRewardListModel liveRewardListModel = param1BluedEntity.data.get(0);
                PopRewardListView.a(this.b.a, GrabRewardView.a(this.b), liveRewardListModel, null);
                if (!TextUtils.isEmpty(this.a))
                  LiveSetDataObserver.a().c((GrabRewardView.a(this.b)).pwd); 
              } 
              return;
            } catch (Exception exception) {
              return;
            } 
          }
          
          public BluedEntity<LiveRewardListModel, LiveRewardExtraModel> parseData(String param1String) {
            return super.parseData(param1String);
          }
        }paramString1, String.valueOf(paramLong), paramString2, paramString3);
  }
  
  public void a(Throwable paramThrowable, int paramInt, String paramString) {
    Pair pair = BluedHttpUtils.a(paramThrowable, paramInt, paramString);
    RewardErrorModel rewardErrorModel = new RewardErrorModel();
    rewardErrorModel.throwable = paramThrowable;
    rewardErrorModel.statusCode = paramInt;
    rewardErrorModel.content = paramString;
    if (((Integer)pair.first).intValue() == 4032014) {
      PopRewardListView.a(this.a, this.p, null, rewardErrorModel);
      return;
    } 
    if (((Integer)pair.first).intValue() == 4032021) {
      PopRewardListView.a(this.a, this.p, null, rewardErrorModel);
      return;
    } 
    if (((Integer)pair.first).intValue() == 4032022) {
      PopRewardListView.a(this.a, this.p, null, rewardErrorModel);
      return;
    } 
    if (((Integer)pair.first).intValue() == 4032015) {
      AppMethods.a(this.d.getString(R.string.live_live_receive_conditions_toast), true);
      return;
    } 
    if (((Integer)pair.first).intValue() == 4034003) {
      j();
      return;
    } 
    BluedHttpUtils.b(paramThrowable, paramInt, paramString);
  }
  
  public void b() {
    this.n = (new CountDownTimer(this, 1000L * this.p.end_second, 1000L) {
        public void onFinish() {
          this.a.setVisibility(8);
          LiveRefreshUIObserver.a().c();
        }
        
        public void onTick(long param1Long) {
          param1Long /= 1000L;
        }
      }).start();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    LiveRewardStatusObserver.a().a(this);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.grab_reward_image || paramView.getId() == R.id.grab_reward_btn) {
      if (this.l.getVisibility() == 0) {
        if (TextUtils.equals("3", this.p.condition)) {
          AppMethods.d(R.string.live_reward_fans_after_count_down);
          return;
        } 
        AppMethods.d(R.string.live_reward_after_count_down);
        return;
      } 
      if (this.b) {
        PopRewardListView.a(this.a, this.p);
        return;
      } 
      Logger.a("drb", new Object[] { "mLiveRewardModel.status = ", Integer.valueOf(this.p.status) });
      if (this.p.status == 1) {
        PopRewardListView.a(this.a, this.p);
        return;
      } 
      if (this.p.status == 2) {
        PopRewardListView.a(this.a, this.p);
        return;
      } 
      if (!TextUtils.isEmpty(this.p.pwd) && !this.p.hasPwdTip) {
        PopRewardListView.a(this.a, this.p).a(new PopRewardListView.OnPopEventCallBack(this) {
              public void a(boolean param1Boolean) {
                (GrabRewardView.a(this.a)).hasPwdTip = param1Boolean;
                if (param1Boolean) {
                  GrabRewardView grabRewardView = this.a;
                  grabRewardView.a((GrabRewardView.a(grabRewardView)).hongbao_id, GrabRewardView.e(this.a), "", (GrabRewardView.a(this.a)).pwd);
                } 
              }
            });
        return;
      } 
      a(this.p.hongbao_id, this.m, "", this.p.pwd);
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    g();
    h();
    LiveRewardStatusObserver.a().b(this);
  }
  
  public void setData(LiveRewardModel paramLiveRewardModel) {
    a(paramLiveRewardModel, (IGrabRewardListener)null);
  }
  
  public void setRewardView(int paramInt) {
    if (!this.b) {
      if (paramInt == 0) {
        d();
        return;
      } 
      if (paramInt == 1) {
        e();
        return;
      } 
      if (paramInt == 2)
        f(); 
    } 
  }
  
  public static interface IGrabRewardListener {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\GrabRewardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */