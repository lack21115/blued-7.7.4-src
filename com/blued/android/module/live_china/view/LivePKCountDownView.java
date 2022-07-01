package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;

public class LivePKCountDownView extends FrameLayout implements View.OnClickListener {
  public ImageView a;
  
  public int b;
  
  public int c = 5;
  
  private Context d;
  
  private LayoutInflater e;
  
  private View f;
  
  private View g;
  
  private TextView h;
  
  private Chronometer i;
  
  private ImageView j;
  
  private BaseFragment k;
  
  private CountDownTimer l;
  
  private CountDownTimer m;
  
  public LivePKCountDownView(Context paramContext) {
    this(paramContext, null);
  }
  
  public LivePKCountDownView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LivePKCountDownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = paramContext;
    g();
  }
  
  private void g() {
    this.e = LayoutInflater.from(this.d);
    this.f = this.e.inflate(R.layout.live_pk_count_down_layout, (ViewGroup)this);
    this.a = (ImageView)this.f.findViewById(R.id.live_pk_count_down_close);
    this.g = this.f.findViewById(R.id.live_pk_count_down_layout);
    this.h = (TextView)this.f.findViewById(R.id.live_pk_count_down_punish);
    this.i = (Chronometer)this.f.findViewById(R.id.live_pk_count_down_chronometer);
    this.j = (ImageView)this.f.findViewById(R.id.iv_pk);
    this.i.setText("00:00");
    this.a.setOnClickListener(this);
  }
  
  private void h() {
    Logger.b("pk", new Object[] { "stopPK --------------" });
    BaseFragment baseFragment = this.k;
    if (baseFragment instanceof RecordingOnliveFragment) {
      ((RecordingOnliveFragment)baseFragment).aT();
    } else if (baseFragment instanceof PlayingOnliveFragment) {
      ((PlayingOnliveFragment)baseFragment).G();
    } 
    setCurrentModel(0);
  }
  
  public void a(long paramLong) {
    this.h.setVisibility(0);
    this.j.setVisibility(8);
    this.i.setTextColor(getResources().getColor(R.color.syc_dark_f5a300));
    c();
    this.l = (new CountDownTimer(this, paramLong * 1000L, 500L) {
        public void onFinish() {
          LivePKCountDownView.a(this.a);
        }
        
        public void onTick(long param1Long) {
          param1Long /= 1000L;
          LivePKCountDownView.c(this.a).setText(LiveTimeAndDateUtils.a(param1Long + 1L, false));
        }
      }).start();
    if (paramLong > 0L)
      setCurrentModel(2); 
  }
  
  public void a(LiveFriendModel paramLiveFriendModel) {
    this.h.setVisibility(8);
    this.j.setVisibility(0);
    this.i.setTextColor(getResources().getColor(R.color.syc_dark_b));
    c();
    this.l = (new CountDownTimer(this, paramLiveFriendModel.countdown * 1000L, 500L) {
        public void onFinish() {
          this.a.e();
        }
        
        public void onTick(long param1Long) {
          param1Long /= 1000L;
          LivePKCountDownView.c(this.a).setText(LiveTimeAndDateUtils.a(param1Long + 1L, false));
        }
      }).start();
    setCurrentModel(1);
  }
  
  public void a(boolean paramBoolean) {
    if (!a()) {
      View view = LayoutInflater.from(this.d).inflate(R.layout.live_exit_pk_tips, null);
      CustomDialog customDialog = new CustomDialog(this.d);
      customDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
      customDialog.a(view, null);
      TextView textView1 = (TextView)view.findViewById(R.id.tips_message);
      TextView textView2 = (TextView)view.findViewById(R.id.tips_confirm);
      TextView textView3 = (TextView)view.findViewById(R.id.tips_cancel);
      textView1.setText(R.string.live_pk_exit);
      textView2.setOnClickListener(new View.OnClickListener(this, customDialog, paramBoolean) {
            public void onClick(View param1View) {
              this.a.dismiss();
              this.c.b();
              LivePKCountDownView.a(this.c);
              if (this.b && LivePKCountDownView.b(this.c) instanceof RecordingOnliveFragment)
                ((RecordingOnliveFragment)LivePKCountDownView.b(this.c)).J(); 
            }
          });
      textView3.setOnClickListener(new View.OnClickListener(this, customDialog) {
            public void onClick(View param1View) {
              this.a.dismiss();
            }
          });
      return;
    } 
    Context context = this.d;
    CommonAlertDialog.a(context, "", context.getString(R.string.live_pk_exit_punish), this.d.getString(R.string.live_window_permisson_cancel), null, this.d.getString(R.string.biao_v4_ok), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            this.a.b();
            LivePKCountDownView.a(this.a);
            InstantLog.a("live_pk_end_afterphase");
          }
        },  null);
  }
  
  public boolean a() {
    return (this.b == 2);
  }
  
  public void b() {
    LiveRoomHttpUtils.d(new BluedUIHttpResponse(this) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        });
  }
  
  public void c() {
    CountDownTimer countDownTimer = this.l;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
  }
  
  public void d() {
    CountDownTimer countDownTimer = this.m;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
  }
  
  public void e() {
    d();
    this.m = (new CountDownTimer(this, (this.c * 1000), 500L) {
        public void onFinish() {
          if (LivePKCountDownView.b(this.a) != null && LivePKCountDownView.b(this.a).w_() != null && LivePKCountDownView.b(this.a).w_().isActive())
            CommonAlertDialog.a(LivePKCountDownView.d(this.a), null, "", LivePKCountDownView.d(this.a).getString(R.string.live_pk_time_out), LivePKCountDownView.d(this.a).getString(R.string.sure), new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    LivePKCountDownView.a(this.a.a);
                  }
                },  null, true); 
        }
        
        public void onTick(long param1Long) {}
      }).start();
  }
  
  public void f() {
    d();
    c();
  }
  
  public int getCurrentModel() {
    return this.b;
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.live_pk_count_down_close && this.k instanceof RecordingOnliveFragment)
      a(false); 
  }
  
  public void setCurrentModel(int paramInt) {
    this.b = paramInt;
  }
  
  public void setData(BaseFragment paramBaseFragment) {
    this.k = paramBaseFragment;
    if (paramBaseFragment instanceof PlayingOnliveFragment)
      this.a.setVisibility(8); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LivePKCountDownView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */