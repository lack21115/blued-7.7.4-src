package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class LiveMakeLoverStartView implements View.OnClickListener {
  public View a;
  
  public View b;
  
  public Context c;
  
  private MyPopupWindow d;
  
  private LinearLayout e;
  
  private TextView f;
  
  private TextView g;
  
  private CountDownTimer h;
  
  private PlayingOnliveFragment i;
  
  private void c() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.a.startAnimation((Animation)alphaAnimation);
    this.b.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_bottom_out));
  }
  
  private void d() {
    BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this, (IRequestHost)this.i.w_()) {
        public void onUIFinish() {
          super.onUIFinish();
          LiveMakeLoverStartView.d(this.a).setVisibility(8);
        }
        
        public void onUIStart() {
          super.onUIStart();
          LiveMakeLoverStartView.d(this.a).setVisibility(0);
        }
        
        public void onUIUpdate(BluedEntity param1BluedEntity) {
          this.a.b();
          this.a.a();
          (LiveMakeLoverStartView.e(this.a)).q.a(1);
          (LiveMakeLoverStartView.e(this.a)).bP.setState(0);
        }
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.i.u);
    stringBuilder.append("");
    LiveRoomHttpUtils.k(bluedUIHttpResponse, stringBuilder.toString());
  }
  
  private void e() {
    LiveRoomInfo.a().a(new PermissionCallbacks(this) {
          public void a(String[] param1ArrayOfString) {
            LiveMsgSendManager.a().b("关闭权限");
            this.a.b();
            LiveMakeLoverStartView.g(this.a);
          }
          
          public void aa_() {
            LiveMsgSendManager.a().b("开启权限");
            this.a.a();
            BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendModel>>(this, (IRequestHost)LiveMakeLoverStartView.e(this.a).w_()) {
                public void onFailure(Throwable param2Throwable, int param2Int, String param2String) {
                  super.onFailure(param2Throwable, param2Int, param2String);
                  AppInfo.n().post(new Runnable(this) {
                        public void run() {
                          LiveMakeLoverStartView.f(this.a.a.a).setEnabled(true);
                          (LiveMakeLoverStartView.e(this.a.a.a)).bP.setState(0);
                          (LiveMakeLoverStartView.e(this.a.a.a)).q.a(1);
                        }
                      });
                }
                
                public void onUIFinish() {
                  super.onUIFinish();
                  LiveMakeLoverStartView.d(this.a.a).setVisibility(8);
                  this.a.a.b();
                }
                
                public void onUIStart() {
                  super.onUIStart();
                  LiveMakeLoverStartView.d(this.a.a).setVisibility(0);
                }
                
                public void onUIUpdate(BluedEntity<LiveFriendModel, LiveFriendModel> param2BluedEntity) {}
              };
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((LiveMakeLoverStartView.e(this.a)).u);
            stringBuilder.append("");
            LiveRoomHttpUtils.j(bluedUIHttpResponse, stringBuilder.toString());
          }
        });
  }
  
  public void a() {
    CountDownTimer countDownTimer = this.h;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
  }
  
  public void a(ILiveConnectionAnimListener paramILiveConnectionAnimListener) {
    AppInfo.n().postDelayed(new Runnable(this, paramILiveConnectionAnimListener) {
          public void run() {
            LiveMakeLoverStartView.c(this.b).a();
            ILiveConnectionAnimListener iLiveConnectionAnimListener = this.a;
            if (iLiveConnectionAnimListener != null)
              iLiveConnectionAnimListener.a(); 
          }
        }320L);
    c();
    this.b.setVisibility(8);
  }
  
  public void b() {
    a((ILiveConnectionAnimListener)null);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.live_make_lover_start_cancel) {
      d();
      return;
    } 
    if (paramView.getId() == R.id.live_make_lover_start_now) {
      this.g.setEnabled(false);
      e();
    } 
  }
  
  class MyPopupWindow extends PopupWindow {
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.b();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveMakeLoverStartView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */