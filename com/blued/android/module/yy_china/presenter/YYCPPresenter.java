package com.blued.android.module.yy_china.presenter;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.IPopShowAndDismissListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.BlindMatchUserModel;
import com.blued.android.module.yy_china.model.BlindMatchUserPairModel;
import com.blued.android.module.yy_china.model.YYCPStepModel;
import com.blued.android.module.yy_china.model.YYMsgBlindPublishExtra;
import com.blued.android.module.yy_china.model.YYMsgBlindResultExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.PopupwindowFactory;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYCPGuideView;
import com.blued.android.module.yy_china.view.YYSelectCPListView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class YYCPPresenter {
  private BaseYYStudioFragment a;
  
  private PopupWindow b;
  
  private Handler c;
  
  private List<BlindMatchUserPairModel> d;
  
  public YYCPPresenter(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.a = paramBaseYYStudioFragment;
    this.c = new AnimHandler();
  }
  
  private void a(int paramInt) {
    if (paramInt >= 1) {
      if (paramInt > 3)
        return; 
      View view = d();
      if (view == null)
        return; 
      TextView textView1 = (TextView)view.findViewById(R.id.cp_step_name);
      TextView textView2 = (TextView)view.findViewById(R.id.cp_step_content);
      ImageView imageView = (ImageView)view.findViewById(R.id.cp_step_icon);
      textView1.setText(c(paramInt));
      textView2.setText(d(paramInt));
      a(view, imageView, null, null, null, paramInt);
    } 
  }
  
  private void a(int paramInt, BlindMatchUserPairModel paramBlindMatchUserPairModel) {
    if (paramInt != 4)
      return; 
    if (paramBlindMatchUserPairModel.source != null) {
      if (paramBlindMatchUserPairModel.target == null)
        return; 
      View view = e();
      if (view == null)
        return; 
      ImageView imageView1 = (ImageView)view.findViewById(R.id.iv_cp_heart);
      ImageView imageView2 = (ImageView)view.findViewById(R.id.iv_source);
      ImageView imageView3 = (ImageView)view.findViewById(R.id.iv_target);
      CardView cardView = (CardView)view.findViewById(R.id.ll_cp_1);
      ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout)view.findViewById(R.id.ll_cp_2);
      ImageView imageView4 = (ImageView)view.findViewById(R.id.cp_step_icon);
      ImageLoader.a((IRequestHost)this.a.w_(), paramBlindMatchUserPairModel.source.avatar).a(R.drawable.user_bg_round).a(imageView2);
      ImageLoader.a((IRequestHost)this.a.w_(), paramBlindMatchUserPairModel.target.avatar).a(R.drawable.user_bg_round).a(imageView3);
      a(view, imageView4, imageView1, (View)cardView, (View)shapeFrameLayout, paramInt);
    } 
  }
  
  private void a(View paramView1, ImageView paramImageView1, ImageView paramImageView2, View paramView2, View paramView3, int paramInt) {
    long l;
    PopupWindow popupWindow = this.b;
    if (popupWindow != null && popupWindow.isShowing()) {
      this.b.dismiss();
      this.b = null;
      f();
      l = 300L;
    } else {
      l = 0L;
    } 
    this.a.a(new Runnable(this, paramView1, paramInt, paramImageView1, paramImageView2, paramView2, paramView3) {
          public void run() {
            if (YYCPPresenter.a(this.g) == null)
              return; 
            YYCPPresenter.a(this.g).H();
            YYCPPresenter yYCPPresenter = this.g;
            YYCPPresenter.a(yYCPPresenter, (new PopupwindowFactory.Builder(YYCPPresenter.a(yYCPPresenter).getContext())).a(this.a).a(17).c(-2).b(-2).d(R.color.syc_66000000).e(R.style.yy_pop_scale_anim).a(false).a(new IPopShowAndDismissListener(this) {
                    public void a() {
                      if (YYCPPresenter.c(this.a.g) != null)
                        YYCPPresenter.c(this.a.g).sendEmptyMessageDelayed(10, YYCPPresenter.c(this.a.g, this.a.b)); 
                      if (this.a.c != null)
                        ImageLoader.c((IRequestHost)YYCPPresenter.a(this.a.g).w_(), YYCPPresenter.d(this.a.g, this.a.b)).d(this.a.b).a().a(this.a.c); 
                      if (this.a.d != null)
                        ImageLoader.c((IRequestHost)YYCPPresenter.a(this.a.g).w_(), "cp_show_heart.png").d(this.a.b).a().a(this.a.d); 
                      if (this.a.e != null && this.a.f != null) {
                        this.a.e.setVisibility(0);
                        this.a.e.startAnimation(AnimationUtils.loadAnimation(YYCPPresenter.a(this.a.g).getContext(), R.anim.yy_cp_match_left));
                        this.a.f.setVisibility(0);
                        this.a.f.startAnimation(AnimationUtils.loadAnimation(YYCPPresenter.a(this.a.g).getContext(), R.anim.yy_cp_match_right));
                      } 
                    }
                    
                    public void b() {
                      YYCPPresenter.d(this.a.g);
                      if (this.a.b == 2 && YYRoomInfoManager.d().b(YYRoomInfoManager.d().e()) && !YYRoomInfoManager.d().m())
                        YYCPPresenter.e(this.a.g); 
                      if (YYCPPresenter.c(this.a.g) != null && YYCPPresenter.b(this.a.g) != null && !YYCPPresenter.b(this.a.g).isEmpty())
                        YYCPPresenter.a(this.a.g, 4, YYCPPresenter.b(this.a.g).remove(0)); 
                    }
                  }).h());
          }
        }l);
  }
  
  private void b(int paramInt) {
    a(LayoutInflater.from(this.a.getContext()).inflate(R.layout.dialog_cp_nothing_anim, null), null, null, null, null, paramInt);
  }
  
  private String c(int paramInt) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? ((paramInt != 4) ? "" : e(R.string.yy_blind_step_result)) : e(R.string.yy_blind_step_publish)) : e(R.string.yy_blind_step_heart)) : e(R.string.yy_blind_step_introduction);
  }
  
  private void c() {
    BaseYYStudioFragment baseYYStudioFragment = this.a;
    if (baseYYStudioFragment == null)
      return; 
    YYSelectCPListView yYSelectCPListView = new YYSelectCPListView(baseYYStudioFragment.getContext());
    yYSelectCPListView.a(this.a);
    this.a.a((View)yYSelectCPListView, -2);
  }
  
  private View d() {
    return LayoutInflater.from(this.a.getContext()).inflate(R.layout.dialog_cp_step_anim, null);
  }
  
  private String d(int paramInt) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? "" : e(R.string.yy_blind_start_publish)) : e(R.string.yy_blind_start_heart)) : e(R.string.yy_blind_start_introduction);
  }
  
  private View e() {
    return LayoutInflater.from(this.a.getContext()).inflate(R.layout.dialog_cp_last_step_anim, null);
  }
  
  private String e(int paramInt) {
    return this.a.getContext().getResources().getString(paramInt);
  }
  
  private String f(int paramInt) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? ((paramInt != 4) ? "" : "cp_show_match.png") : "cp_show_like.png") : "cp_select_like.png") : "cp_show_myself.png";
  }
  
  private void f() {
    Handler handler = this.c;
    if (handler != null)
      handler.removeCallbacksAndMessages(null); 
  }
  
  private long g(int paramInt) {
    return (paramInt != 1 && paramInt != 2 && paramInt != 3) ? ((paramInt != 4) ? 0L : 6000L) : 3000L;
  }
  
  public void a() {
    BaseYYStudioFragment baseYYStudioFragment = this.a;
    if (baseYYStudioFragment == null)
      return; 
    YYCPGuideView yYCPGuideView = new YYCPGuideView(baseYYStudioFragment.getContext());
    this.a.a((View)yYCPGuideView, -2);
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    LiveEventBus.get("update_cp_step", YYCPStepModel.class).observe(paramLifecycleOwner, new Observer<YYCPStepModel>(this) {
          public void a(YYCPStepModel param1YYCPStepModel) {
            if (param1YYCPStepModel != null) {
              if (YYCPPresenter.a(this.a) == null)
                return; 
              (YYCPPresenter.a(this.a)).x.a(param1YYCPStepModel.present_step, param1YYCPStepModel.next_step, true);
              if (param1YYCPStepModel.present_step == 0)
                (YYCPPresenter.a(this.a)).x.a(); 
              if (param1YYCPStepModel.resend)
                return; 
              YYCPPresenter.a(this.a, param1YYCPStepModel.present_step);
            } 
          }
        });
    LiveEventBus.get("show_blind_publish", YYMsgBlindPublishExtra.class).observe(paramLifecycleOwner, new Observer<YYMsgBlindPublishExtra>(this) {
          public void a(YYMsgBlindPublishExtra param1YYMsgBlindPublishExtra) {
            if (param1YYMsgBlindPublishExtra != null) {
              if (YYCPPresenter.a(this.a) == null)
                return; 
              (YYCPPresenter.a(this.a)).x.a(param1YYMsgBlindPublishExtra.present_step, param1YYMsgBlindPublishExtra.next_step, true);
              (YYCPPresenter.a(this.a)).x.a(null);
              if (param1YYMsgBlindPublishExtra.resend)
                return; 
              YYCPPresenter.a(this.a, param1YYMsgBlindPublishExtra.present_step);
            } 
          }
        });
    LiveEventBus.get("show_blind_result", YYMsgBlindResultExtra.class).observe(paramLifecycleOwner, new Observer<YYMsgBlindResultExtra>(this) {
          public void a(YYMsgBlindResultExtra param1YYMsgBlindResultExtra) {
            if (param1YYMsgBlindResultExtra != null) {
              if (YYCPPresenter.a(this.a) == null)
                return; 
              YYCPPresenter.a(this.a, param1YYMsgBlindResultExtra.match_users);
              (YYCPPresenter.a(this.a)).x.a(param1YYMsgBlindResultExtra.present_step, param1YYMsgBlindResultExtra.next_step, true);
              if (param1YYMsgBlindResultExtra.seats != null && !param1YYMsgBlindResultExtra.seats.isEmpty())
                (YYCPPresenter.a(this.a)).x.a(null); 
              if (!param1YYMsgBlindResultExtra.resend)
                if (YYCPPresenter.b(this.a) != null && !YYCPPresenter.b(this.a).isEmpty()) {
                  YYCPPresenter.c(this.a).sendEmptyMessage(11);
                } else {
                  YYCPPresenter.b(this.a, param1YYMsgBlindResultExtra.present_step);
                }  
              YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
              if (yYRoomModel != null) {
                ArrayList<HashMap<Object, Object>> arrayList = new ArrayList();
                HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                for (BlindMatchUserPairModel blindMatchUserPairModel : YYCPPresenter.b(this.a)) {
                  hashMap.clear();
                  MsgPackHelper.putMapValue(hashMap, "target", blindMatchUserPairModel.source.uid);
                  MsgPackHelper.putMapValue(hashMap, "match", blindMatchUserPairModel.target.uid);
                  arrayList.add(hashMap);
                } 
                String str = AppInfo.f().toJson(arrayList);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("match json: ");
                stringBuilder.append(str);
                LogUtils.d("event", stringBuilder.toString());
                EventTrackYY.g(ChatRoomProtos.Event.CHAT_ROOM_CP_MATCH_SUCCEED, yYRoomModel.room_id, yYRoomModel.uid, str);
              } 
            } 
          }
        });
    LiveEventBus.get("show_blind_heart", BlindMatchUserModel.class).observe(paramLifecycleOwner, new Observer<BlindMatchUserModel>(this) {
          public void a(BlindMatchUserModel param1BlindMatchUserModel) {
            if (param1BlindMatchUserModel != null) {
              if (YYCPPresenter.a(this.a) == null)
                return; 
              (YYCPPresenter.a(this.a)).x.a(null);
            } 
          }
        });
  }
  
  public void b() {
    List<BlindMatchUserPairModel> list = this.d;
    if (list != null)
      list.clear(); 
    PopupWindow popupWindow = this.b;
    if (popupWindow != null) {
      popupWindow.dismiss();
      this.b = null;
    } 
    f();
    this.c = null;
  }
  
  class AnimHandler extends Handler {
    private AnimHandler(YYCPPresenter this$0) {}
    
    public void handleMessage(Message param1Message) {
      super.handleMessage(param1Message);
      int i = param1Message.what;
      if (i != 10) {
        if (i != 11)
          return; 
        if (YYCPPresenter.b(this.a) != null) {
          if (YYCPPresenter.b(this.a).isEmpty())
            return; 
          YYCPPresenter yYCPPresenter = this.a;
          YYCPPresenter.a(yYCPPresenter, 4, YYCPPresenter.b(yYCPPresenter).remove(0));
          return;
        } 
        return;
      } 
      if (YYCPPresenter.f(this.a) != null) {
        YYCPPresenter.f(this.a).dismiss();
        YYCPPresenter.a(this.a, (PopupWindow)null);
        YYCPPresenter.d(this.a);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\presenter\YYCPPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */