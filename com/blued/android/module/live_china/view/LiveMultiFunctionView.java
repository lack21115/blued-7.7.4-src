package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveFunctionAdapter;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BluedLiveTopCard;
import com.blued.android.module.live_china.model.LiveFunctionModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.List;

public class LiveMultiFunctionView extends FrameLayout implements View.OnClickListener {
  public LiveEventListener a;
  
  private Context b;
  
  private LayoutInflater c;
  
  private View d;
  
  private View e;
  
  private View f;
  
  private RecyclerView g;
  
  private RecordingOnliveFragment h;
  
  private List<LiveFunctionModel> i = new ArrayList<LiveFunctionModel>();
  
  private LiveFunctionAdapter j;
  
  private CountDownTimer k;
  
  private boolean l;
  
  private boolean m = true;
  
  private boolean n;
  
  private boolean o;
  
  private boolean p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private int t = 1;
  
  private boolean u;
  
  private boolean v;
  
  private PopupWindow w;
  
  private int x = 0;
  
  public LiveMultiFunctionView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LiveMultiFunctionView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LiveMultiFunctionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
  }
  
  private PopupWindow a(String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, String paramString3, View.OnClickListener paramOnClickListener2) {
    View view = LayoutInflater.from(this.b).inflate(R.layout.pop_user_card_layout, null);
    TextView textView2 = (TextView)view.findViewById(R.id.tv_use_cancel);
    TextView textView3 = (TextView)view.findViewById(R.id.use_card_info);
    if (!TextUtils.isEmpty(paramString1))
      textView3.setText(paramString1); 
    textView2.setText(paramString2);
    if (paramOnClickListener1 != null) {
      textView2.setOnClickListener(paramOnClickListener1);
    } else {
      textView2.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              LiveMultiFunctionView.g(this.a).dismiss();
            }
          });
    } 
    TextView textView1 = (TextView)view.findViewById(R.id.tv_use_now);
    textView1.setText(paramString3);
    textView1.setOnClickListener(paramOnClickListener2);
    ((ImageView)view.findViewById(R.id.use_card_close)).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveMultiFunctionView.g(this.a).dismiss();
          }
        });
    if (this.w == null) {
      this.w = new PopupWindow(-1, -1);
      this.w.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      this.w.setOutsideTouchable(true);
      this.w.setFocusable(true);
    } 
    this.w.setContentView(view);
    this.w.update();
    this.w.showAtLocation(this.h.getActivity().getWindow().getDecorView(), 17, 0, 0);
    return this.w;
  }
  
  private void b(int paramInt) {
    EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_TOP_CARD_TOAST_SHOW, LiveRoomManager.a().b(), LiveRoomManager.a().e(), false);
    a(this.b.getResources().getString(R.string.live_card_use), this.b.getResources().getString(R.string.cancel), new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveMultiFunctionView.g(this.a).dismiss();
          }
        },  this.b.getResources().getString(R.string.live_use_now), new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_TOP_CARD_USE_CLICK, LiveRoomManager.a().b(), LiveRoomManager.a().e(), false);
            LiveMultiFunctionView.a(this.a, false);
          }
        });
  }
  
  private void b(boolean paramBoolean) {
    if (this.h.aQ())
      return; 
    this.o = paramBoolean;
    this.i = getFunctionData();
    this.j.a(this.i);
  }
  
  private void c(int paramInt) {
    this.x = paramInt / 6;
    if (paramInt % 6 > 0)
      this.x++; 
    String str = String.format(this.b.getResources().getString(R.string.live_card_waitting), new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.x) });
    EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_TOP_CARD_TOAST_SHOW, LiveRoomManager.a().b(), LiveRoomManager.a().e(), true);
    a(str, this.b.getResources().getString(R.string.cancel), new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveMultiFunctionView.g(this.a).dismiss();
          }
        },  this.b.getResources().getString(R.string.live_use_waitting), new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_TOP_CARD_USE_CLICK, LiveRoomManager.a().b(), LiveRoomManager.a().e(), true);
            LiveMultiFunctionView.a(this.a, true);
          }
        });
  }
  
  private void c(boolean paramBoolean) {
    LiveRoomHttpUtils.a(LiveRoomManager.a().b(), new BluedUIHttpResponse<BluedEntityA<BluedLiveTopCard>>(this, (IRequestHost)this.h.w_(), paramBoolean) {
          protected void a(BluedEntityA<BluedLiveTopCard> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null) {
              if (param1BluedEntityA.data.isEmpty())
                return; 
              BluedLiveTopCard bluedLiveTopCard = param1BluedEntityA.data.get(0);
              if (bluedLiveTopCard.count <= 0) {
                LiveMultiFunctionView.b(this.b, false);
              } else {
                this.b.a(bluedLiveTopCard.count);
              } 
              if (LiveMultiFunctionView.g(this.b) != null)
                LiveMultiFunctionView.g(this.b).dismiss(); 
              if (this.a) {
                if (LiveMultiFunctionView.h(this.b) < 3) {
                  LiveMsgSendManager.a().a((short)-10003, LiveMultiFunctionView.i(this.b).getResources().getString(R.string.live_use_card_later));
                  return;
                } 
                if (LiveMultiFunctionView.h(this.b) == 3) {
                  LiveMsgSendManager.a().a((short)-10003, LiveMultiFunctionView.i(this.b).getResources().getString(R.string.live_use_card_watting));
                  return;
                } 
                LiveMultiFunctionView.j(this.b);
                LiveMsgSendManager.a().a((short)-10002, LiveMultiFunctionView.i(this.b).getResources().getString(R.string.live_use_card_notice));
                return;
              } 
              if ((LiveMultiFunctionView.b(this.b)).R != null)
                (LiveMultiFunctionView.b(this.b)).R.setVisibility(0); 
              ToastUtils.a(LiveMultiFunctionView.i(this.b).getResources().getString(R.string.live_use_toast), 0);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (param1Int == 403021) {
              ToastUtils.a("正在使用中，请稍后再试", 0);
              return true;
            } 
            return super.onUIFailure(param1Int, param1String);
          }
        }(IRequestHost)this.h.w_());
  }
  
  private void i() {
    LiveRoomHttpUtils.g(new BluedUIHttpResponse<BluedEntityA<BluedLiveTopCard>>(this, (IRequestHost)this.h.w_()) {
          protected void a(BluedEntityA<BluedLiveTopCard> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null) {
              if (param1BluedEntityA.data.isEmpty())
                return; 
              BluedLiveTopCard bluedLiveTopCard = param1BluedEntityA.data.get(0);
              if (bluedLiveTopCard.queue_count <= 0) {
                LiveMultiFunctionView.d(this.a, bluedLiveTopCard.queue_count);
                return;
              } 
              LiveMultiFunctionView.e(this.a, bluedLiveTopCard.queue_count);
            } 
          }
        }(IRequestHost)this.h.w_());
  }
  
  private void j() {
    Logger.d("LiveMultiFunctionView", new Object[] { "run timmer_3 ... " });
    this.k = (new CountDownTimer(this, ((this.x - 3) * 60 * 1000), 1000L) {
        public void onFinish() {
          Logger.d("LiveMultiFunctionView", new Object[] { "run timmer_3 onFinish ... " });
          LiveMultiFunctionView.f(this.a, 0);
          LiveMsgSendManager.a().a((short)-10003, LiveMultiFunctionView.i(this.a).getResources().getString(R.string.live_use_card_watting));
        }
        
        public void onTick(long param1Long) {}
      }).start();
  }
  
  public void a() {
    a((LiveMultiFunctionListener)null);
  }
  
  public void a(int paramInt) {
    this.q = paramInt;
    if (paramInt <= 0) {
      b(false);
      return;
    } 
    b(true);
  }
  
  public void a(LiveMultiFunctionListener paramLiveMultiFunctionListener) {
    if (this.e.getVisibility() == 8)
      return; 
    this.e.setVisibility(8);
    Animation animation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out);
    this.e.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this, paramLiveMultiFunctionListener) {
          public void onAnimationEnd(Animation param1Animation) {
            this.b.setVisibility(8);
            LiveMultiFunctionView.LiveMultiFunctionListener liveMultiFunctionListener = this.a;
            if (liveMultiFunctionListener != null)
              liveMultiFunctionListener.onClose(); 
            if (this.b.a != null)
              this.b.a.onClose(); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  public void a(boolean paramBoolean) {
    if (this.h.aQ())
      return; 
    this.n = paramBoolean;
    this.i = getFunctionData();
    this.j.a(this.i);
  }
  
  public void a(boolean paramBoolean, RecordingOnliveFragment paramRecordingOnliveFragment) {
    int i;
    this.h = paramRecordingOnliveFragment;
    this.c = LayoutInflater.from(this.b);
    this.l = paramBoolean;
    LayoutInflater layoutInflater = this.c;
    if (paramBoolean) {
      i = R.layout.live_multi_function_view_land;
    } else {
      i = R.layout.live_multi_function_view;
    } 
    this.d = layoutInflater.inflate(i, (ViewGroup)this);
    this.e = this.d.findViewById(R.id.ll_content);
    this.f = this.d.findViewById(R.id.live_multi_function_layer);
    this.g = (RecyclerView)this.d.findViewById(R.id.rv_function_list);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.b, 4);
    this.g.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.j = new LiveFunctionAdapter(getContext());
    this.j.a(new BaseQuickAdapter.OnItemChildClickListener(this) {
          public void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            LiveFunctionModel liveFunctionModel = LiveMultiFunctionView.a(this.a).b(param1Int);
            if (liveFunctionModel != null) {
              if (liveFunctionModel.function_type == 0) {
                if (!LiveRoomManager.a().l())
                  EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().b(), LiveRoomManager.a().e(), LiveProtos.BoxType.BEAUTY_FEATURE); 
                EventTrackLive.a(LiveProtos.Event.LIVE_SETTING_BEAUTY_BTN_CLICK);
                this.a.a(new LiveMultiFunctionView.LiveMultiFunctionListener(this) {
                      public void onClose() {
                        LiveMultiFunctionView.b(this.a.a).am();
                      }
                    });
                return;
              } 
              if (liveFunctionModel.function_type == 1) {
                if (!LiveRoomManager.a().l())
                  EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().b(), LiveRoomManager.a().e(), LiveProtos.BoxType.CAMERA_FEATURE); 
                LiveMultiFunctionView.b(this.a).switchCamera(param1View);
                return;
              } 
              if (liveFunctionModel.function_type == 2) {
                if (!LiveRoomManager.a().l())
                  EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().b(), LiveRoomManager.a().e(), LiveProtos.BoxType.MIRROR_FEATURE); 
                LiveMultiFunctionView.b(this.a).ao();
                return;
              } 
              if (liveFunctionModel.function_type == 3) {
                LiveMultiFunctionView.b(this.a).an();
                return;
              } 
              if (liveFunctionModel.function_type == 4) {
                if (!LiveRoomManager.a().l())
                  EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().b(), LiveRoomManager.a().e(), LiveProtos.BoxType.TITLE_FEATURE); 
                if (LiveRoomManager.a().B()) {
                  AppMethods.d(R.string.live_game_tips);
                  return;
                } 
                EventTrackLive.a(LiveProtos.Event.LIVE_SETTING_TITLE_BTN_CLICK);
                this.a.a(new LiveMultiFunctionView.LiveMultiFunctionListener(this) {
                      public void onClose() {
                        (LiveMultiFunctionView.b(this.a.a)).cj.c();
                      }
                    });
                return;
              } 
              if (liveFunctionModel.function_type == 5) {
                if (!LiveRoomManager.a().l())
                  EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().b(), LiveRoomManager.a().e(), LiveProtos.BoxType.MAGIC_GESTURE); 
                this.a.a(new -$$Lambda$LiveMultiFunctionView$1$z4Y1hMIvEj_iu6S5LEdxyYb2Lsw(this));
                return;
              } 
              if (liveFunctionModel.function_type == 6) {
                if (!LiveRoomManager.a().l())
                  EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().b(), LiveRoomManager.a().e(), LiveProtos.BoxType.DECORATIVE_STICKER); 
                this.a.a(new -$$Lambda$LiveMultiFunctionView$1$EgI-yJgTFZfs5ZDGY-srPcyAlDo(this));
                return;
              } 
              if (liveFunctionModel.function_type == 7) {
                LiveMultiFunctionView.a(this.a, 0);
                liveFunctionModel.dot = LiveMultiFunctionView.c(this.a);
                LiveMultiFunctionView.a(this.a).notifyDataSetChanged();
                if (!LiveRoomManager.a().l())
                  EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().b(), LiveRoomManager.a().e(), LiveProtos.BoxType.SHOP_MALL); 
                this.a.a(new LiveMultiFunctionView.LiveMultiFunctionListener(this) {
                      public void onClose() {
                        if (LiveRoomInfo.a().j()) {
                          LiveMultiFunctionView.b(this.a.a).b("https://activity.blued.cn/hd/2020/free-shop?blued_mode=hide_nav", 0);
                          return;
                        } 
                        LiveMultiFunctionView.b(this.a.a).b("https://activity-test.blued.cn/hd/2020/free-shop?blued_mode=hide_nav", 0);
                      }
                    });
                return;
              } 
              if (liveFunctionModel.function_type == 8) {
                EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().b(), LiveRoomManager.a().e(), LiveProtos.BoxType.TOP_CARD_FEATURE);
                LiveMultiFunctionView.b(this.a, 0);
                liveFunctionModel.dot = LiveMultiFunctionView.d(this.a);
                LiveMultiFunctionView.a(this.a).notifyDataSetChanged();
                LiveMultiFunctionView.e(this.a);
                return;
              } 
              if (liveFunctionModel.function_type == 9) {
                EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().b(), LiveRoomManager.a().e(), LiveProtos.BoxType.MUSIC);
                LiveMultiFunctionView.c(this.a, 0);
                liveFunctionModel.dot = LiveMultiFunctionView.f(this.a);
                LiveMultiFunctionView.a(this.a).notifyDataSetChanged();
                this.a.a(new LiveMultiFunctionView.LiveMultiFunctionListener(this) {
                      public void onClose() {
                        LiveMultiFunctionView.b(this.a.a).bb();
                      }
                    });
              } 
            } 
          }
        });
    this.i = getFunctionData();
    this.j.a(this.i);
    this.g.setAdapter((RecyclerView.Adapter)this.j);
    this.f.setOnClickListener(this);
  }
  
  public boolean b() {
    return (getVisibility() == 0);
  }
  
  public void c() {
    h();
    setVisibility(0);
    this.e.setVisibility(0);
    this.e.clearAnimation();
    Animation animation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in);
    this.e.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {}
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  public void d() {
    this.m = false;
    this.i = getFunctionData();
    this.j.a(this.i);
  }
  
  public void e() {
    this.s = 1;
    a(true);
  }
  
  public void f() {
    this.r = 1;
    b(true);
  }
  
  public void g() {
    CountDownTimer countDownTimer = this.k;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
  }
  
  public List<LiveFunctionModel> getFunctionData() {
    ArrayList<LiveFunctionModel> arrayList = new ArrayList();
    if (this.l) {
      if (this.m)
        arrayList.add(new LiveFunctionModel(0, getResources().getString(R.string.live_beauty), R.drawable.live_beauty_open)); 
      arrayList.add(new LiveFunctionModel(1, getResources().getString(R.string.live_switch_camera), R.drawable.live_switch_carema));
      if (this.p) {
        int i;
        String str = getResources().getString(R.string.live_switch_flash_light);
        if (this.u) {
          i = R.drawable.flash_light_open;
        } else {
          i = R.drawable.flash_light_close;
        } 
        arrayList.add(new LiveFunctionModel(3, str, i));
      } else {
        int i;
        String str = getResources().getString(R.string.live_switch_mirror);
        if (this.v) {
          i = R.drawable.live_mirror_open;
        } else {
          i = R.drawable.live_mirror_close;
        } 
        arrayList.add(new LiveFunctionModel(2, str, i));
      } 
      arrayList.add(new LiveFunctionModel(4, getResources().getString(R.string.live_title_record), R.drawable.live_reset_titile));
      return arrayList;
    } 
    if (this.m)
      arrayList.add(new LiveFunctionModel(0, getResources().getString(R.string.live_beauty), R.drawable.live_beauty_open)); 
    arrayList.add(new LiveFunctionModel(1, getResources().getString(R.string.live_switch_camera), R.drawable.live_switch_carema));
    if (this.p) {
      int i;
      String str = getResources().getString(R.string.live_switch_flash_light);
      if (this.u) {
        i = R.drawable.flash_light_open;
      } else {
        i = R.drawable.flash_light_close;
      } 
      arrayList.add(new LiveFunctionModel(3, str, i));
    } else {
      int i;
      String str = getResources().getString(R.string.live_switch_mirror);
      if (this.v) {
        i = R.drawable.live_mirror_open;
      } else {
        i = R.drawable.live_mirror_close;
      } 
      arrayList.add(new LiveFunctionModel(2, str, i));
    } 
    arrayList.add(new LiveFunctionModel(4, getResources().getString(R.string.live_title_record), R.drawable.live_reset_titile));
    if (!this.h.aQ()) {
      arrayList.add(new LiveFunctionModel(5, getResources().getString(R.string.live_record_level_gesture), R.drawable.live_gesture_icon));
      arrayList.add(new LiveFunctionModel(6, getResources().getString(R.string.live_record_level_sticker), R.drawable.live_sticker_icon));
      if (this.n)
        arrayList.add(new LiveFunctionModel(7, getResources().getString(R.string.live_daily_task_mall), R.drawable.live_shop_titile, this.s)); 
      if (this.o) {
        LiveFunctionModel liveFunctionModel = new LiveFunctionModel(8, getResources().getString(R.string.live_title_topcard), R.drawable.live_top_card, this.r, this.q);
        liveFunctionModel.item_type = 1;
        arrayList.add(liveFunctionModel);
      } 
    } 
    arrayList.add(new LiveFunctionModel(9, getResources().getString(R.string.live_music), R.drawable.live_music_icon, this.t));
    return arrayList;
  }
  
  public void h() {
    this.i = getFunctionData();
    this.j.a(this.i);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.live_multi_function_layer)
      a((LiveMultiFunctionListener)null); 
  }
  
  public void setFlashLightBtnState(boolean paramBoolean) {
    LiveFunctionModel liveFunctionModel = this.j.a(3);
    if (liveFunctionModel == null)
      return; 
    this.u = paramBoolean;
    if (this.u) {
      liveFunctionModel.icon = R.drawable.flash_light_open;
    } else {
      liveFunctionModel.icon = R.drawable.flash_light_close;
    } 
    this.j.notifyDataSetChanged();
  }
  
  public void setFlashLightVisibility(int paramInt) {
    if (paramInt == 0) {
      this.p = true;
      this.i = getFunctionData();
      this.j.a(this.i);
      return;
    } 
    this.p = false;
    this.i = getFunctionData();
    this.j.a(this.i);
  }
  
  public void setLiveEventListener(LiveEventListener paramLiveEventListener) {
    this.a = paramLiveEventListener;
  }
  
  public void setMirrorBtnState(boolean paramBoolean) {
    LiveFunctionModel liveFunctionModel = this.j.a(2);
    if (liveFunctionModel == null)
      return; 
    this.v = paramBoolean;
    if (this.v) {
      liveFunctionModel.icon = R.drawable.live_mirror_open;
    } else {
      liveFunctionModel.icon = R.drawable.live_mirror_close;
    } 
    this.j.notifyDataSetChanged();
  }
  
  public static interface LiveEventListener {
    void onClose();
  }
  
  static interface LiveMultiFunctionListener {
    void onClose();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveMultiFunctionView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */