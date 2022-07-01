package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.external_sense_library.contract.ISetStickerListener;
import com.blued.android.module.external_sense_library.manager.StickerDataManager;
import com.blued.android.module.external_sense_library.model.ErrorCode;
import com.blued.android.module.external_sense_library.model.StickerBaseModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.manager.RecordingOnliveManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveRecordLevelGestureModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class PopGestureView {
  private LayoutInflater a;
  
  private Context b;
  
  private View c;
  
  private View d;
  
  private MyPopupWindow e;
  
  private RecordingOnliveFragment f;
  
  private RecordingOnliveManager g;
  
  private PullToRefreshRecyclerView h;
  
  private View i;
  
  private RecyclerView j;
  
  private GestureAdapter k;
  
  private ImageView l;
  
  private LiveRecordLevelGestureModel m;
  
  private GestureTip n = new GestureTip(this);
  
  public PopGestureView(RecordingOnliveFragment paramRecordingOnliveFragment, RecordingOnliveManager paramRecordingOnliveManager) {
    this.g = paramRecordingOnliveManager;
    this.f = paramRecordingOnliveFragment;
    this.b = paramRecordingOnliveFragment.getContext();
    g();
  }
  
  private void a(BluedEntityA<LiveRecordLevelGestureModel> paramBluedEntityA) {
    if (paramBluedEntityA != null && paramBluedEntityA.data != null && paramBluedEntityA.data.size() > 0) {
      List list = paramBluedEntityA.data;
      if (list != null) {
        GestureAdapter gestureAdapter = this.k;
        if (gestureAdapter != null) {
          gestureAdapter.n().clear();
          this.k.a(list);
          ArrayList<StickerBaseModel> arrayList = new ArrayList();
          for (LiveRecordLevelGestureModel liveRecordLevelGestureModel : list) {
            StickerBaseModel stickerBaseModel = new StickerBaseModel();
            stickerBaseModel.name = liveRecordLevelGestureModel.code;
            stickerBaseModel.path = liveRecordLevelGestureModel.resource;
            arrayList.add(stickerBaseModel);
          } 
          StickerDataManager.init(arrayList, null);
          String str = LiveRoomPreferences.r();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("setDataToView code:");
          stringBuilder.append(str);
          Log.v("pk", stringBuilder.toString());
          if (!TextUtils.isEmpty(str) && list != null)
            for (LiveRecordLevelGestureModel liveRecordLevelGestureModel : list) {
              if (TextUtils.equals(str, liveRecordLevelGestureModel.code)) {
                this.m = liveRecordLevelGestureModel;
                liveRecordLevelGestureModel.isSelect = true;
                if (this.g != null) {
                  LiveGiftModel liveGiftModel = new LiveGiftModel();
                  liveGiftModel.anim_code = liveRecordLevelGestureModel.code;
                  liveGiftModel.resource_url = liveRecordLevelGestureModel.resource;
                  this.g.a(liveGiftModel, new ISetStickerListener(this) {
                        public void onFailed(ErrorCode.PlayStickerCode param1PlayStickerCode, String param1String) {
                          StringBuilder stringBuilder = new StringBuilder();
                          stringBuilder.append("setDataToView onFailed:");
                          stringBuilder.append(param1PlayStickerCode);
                          stringBuilder.append(" -- ");
                          stringBuilder.append(param1String);
                          Log.v("pk", stringBuilder.toString());
                        }
                        
                        public void onSetSticker() {
                          Log.v("pk", "setDataToView onSetSticker");
                        }
                      });
                } 
                break;
              } 
            }  
        } 
      } 
    } 
  }
  
  private void a(String paramString) {
    this.l.setVisibility(0);
    ImageLoader.a((IRequestHost)this.f.w_(), paramString).a(this.l);
    AppInfo.n().removeCallbacks(this.n);
    AppInfo.n().postDelayed(this.n, 5000L);
  }
  
  private void g() {
    this.a = LayoutInflater.from(this.b);
    View view = this.a.inflate(R.layout.pop_window_record_level_gesture, null);
    this.c = view.findViewById(R.id.tv_bg);
    this.h = (PullToRefreshRecyclerView)view.findViewById(R.id.live_gesture_recycler_view);
    this.l = (ImageView)view.findViewById(R.id.live_gesture_tip_view);
    this.i = view.findViewById(R.id.ll_loading);
    this.j = (RecyclerView)this.h.getRefreshableView();
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.b);
    linearLayoutManager.setOrientation(0);
    this.j.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.k = new GestureAdapter(this);
    this.j.setAdapter((RecyclerView.Adapter)this.k);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.c();
          }
        });
    this.d = view.findViewById(R.id.ll_content);
    this.d.setVisibility(8);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.e = new MyPopupWindow(this, view, -1, -1, true);
    this.e.setBackgroundDrawable(this.b.getResources().getDrawable(17170445));
    this.e.setTouchable(true);
    this.e.setOutsideTouchable(true);
    this.e.setFocusable(true);
    this.e.update();
  }
  
  public void a() {
    BluedUIHttpResponse<BluedEntityA<LiveRecordLevelGestureModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<LiveRecordLevelGestureModel>>(this, "RecordLevelGesture", (IRequestHost)this.f.w_()) {
        protected void a(BluedEntityA<LiveRecordLevelGestureModel> param1BluedEntityA) {
          PopGestureView.a(this.a, param1BluedEntityA);
        }
        
        protected void b(BluedEntityA<LiveRecordLevelGestureModel> param1BluedEntityA) {
          PopGestureView.a(this.a, param1BluedEntityA);
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIFinish() {
          super.onUIFinish();
          PopGestureView.a(this.a).setVisibility(8);
        }
        
        public void onUIStart() {
          super.onUIStart();
          PopGestureView.a(this.a).setVisibility(0);
        }
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.f.u);
    stringBuilder.append("");
    LiveRoomHttpUtils.s(bluedUIHttpResponse, stringBuilder.toString());
  }
  
  public void b() {
    RecordingOnliveFragment recordingOnliveFragment = this.f;
    if (recordingOnliveFragment != null)
      recordingOnliveFragment.Q(); 
    this.c.clearAnimation();
    this.d.clearAnimation();
    if (this.e.isShowing())
      this.e.a(); 
    this.e.showAtLocation(this.d, 81, 0, 0);
    this.d.setVisibility(0);
    Animation animation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in);
    this.d.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.a();
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  public void c() {
    RecordingOnliveFragment recordingOnliveFragment = this.f;
    if (recordingOnliveFragment != null)
      recordingOnliveFragment.R(); 
    this.d.setVisibility(8);
    this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out));
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopGestureView.b(this.a).a();
          }
        },  300L);
  }
  
  public void d() {
    String str = LiveRoomPreferences.r();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("initData code:");
    stringBuilder.append(str);
    Log.v("pk", stringBuilder.toString());
    if (!TextUtils.isEmpty(str)) {
      GestureAdapter gestureAdapter = this.k;
      if (gestureAdapter != null && gestureAdapter.n() != null)
        for (LiveRecordLevelGestureModel liveRecordLevelGestureModel : this.k.n()) {
          if (TextUtils.equals(str, liveRecordLevelGestureModel.code)) {
            liveRecordLevelGestureModel.isSelect = true;
            LiveGiftModel liveGiftModel = new LiveGiftModel();
            liveGiftModel.anim_code = liveRecordLevelGestureModel.code;
            liveGiftModel.resource_url = liveRecordLevelGestureModel.resource;
            this.g.a(liveGiftModel, new ISetStickerListener(this) {
                  public void onFailed(ErrorCode.PlayStickerCode param1PlayStickerCode, String param1String) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("initData onFailed:");
                    stringBuilder.append(param1PlayStickerCode);
                    stringBuilder.append(" -- ");
                    stringBuilder.append(param1String);
                    Log.v("pk", stringBuilder.toString());
                  }
                  
                  public void onSetSticker() {
                    Log.v("pk", "initData onSetSticker");
                  }
                });
            break;
          } 
        }  
    } 
  }
  
  public void e() {
    if (this.m != null)
      this.g.a(null, null); 
  }
  
  public void f() {
    if (this.m != null) {
      LiveGiftModel liveGiftModel = new LiveGiftModel();
      liveGiftModel.anim_code = this.m.code;
      liveGiftModel.resource_url = this.m.resource;
      this.g.a(liveGiftModel, new ISetStickerListener(this) {
            public void onFailed(ErrorCode.PlayStickerCode param1PlayStickerCode, String param1String) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("start onFailed:");
              stringBuilder.append(param1PlayStickerCode);
              stringBuilder.append(" -- ");
              stringBuilder.append(param1String);
              Log.v("pk", stringBuilder.toString());
            }
            
            public void onSetSticker() {
              Log.v("pk", "start onSetSticker");
            }
          });
    } 
  }
  
  class GestureAdapter extends BaseQuickAdapter<LiveRecordLevelGestureModel, BaseViewHolder> {
    private ImageView b;
    
    private ImageView c;
    
    private TextView d;
    
    public GestureAdapter(PopGestureView this$0) {
      super(R.layout.gesture_view_item, null);
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, LiveRecordLevelGestureModel param1LiveRecordLevelGestureModel) {
      if (param1BaseViewHolder != null) {
        this.b = (ImageView)param1BaseViewHolder.d(R.id.guest_image);
        this.c = (ImageView)param1BaseViewHolder.d(R.id.guest_image_bg);
        this.d = (TextView)param1BaseViewHolder.d(R.id.guest_text);
        if (param1LiveRecordLevelGestureModel.status == 1) {
          ImageLoader.a(null, param1LiveRecordLevelGestureModel.icon).a(this.b);
        } else {
          ImageLoader.a(null, param1LiveRecordLevelGestureModel.icon_disable).a(this.b);
        } 
        param1BaseViewHolder.a(R.id.guest_text, param1LiveRecordLevelGestureModel.title);
        if (param1LiveRecordLevelGestureModel.isSelect) {
          this.c.setVisibility(0);
        } else {
          this.c.setVisibility(8);
        } 
        param1BaseViewHolder.a(R.id.guest_root_layout, new View.OnClickListener(this, param1LiveRecordLevelGestureModel) {
              public void onClick(View param2View) {
                if (this.a.status == 1) {
                  if (this.a.isSelect) {
                    this.a.isSelect = false;
                    PopGestureView.c(this.b.a).a(null, null);
                    PopGestureView.a(this.b.a, (LiveRecordLevelGestureModel)null);
                    LiveRoomPreferences.y("");
                  } else {
                    PopGestureView.a(this.b.a, this.a);
                    for (int i = 0; i < PopGestureView.GestureAdapter.a(this.b).size(); i++)
                      ((LiveRecordLevelGestureModel)PopGestureView.GestureAdapter.b(this.b).get(i)).isSelect = false; 
                    LiveRecordLevelGestureModel liveRecordLevelGestureModel = this.a;
                    liveRecordLevelGestureModel.isSelect = true;
                    LiveRoomPreferences.y(liveRecordLevelGestureModel.code);
                    if (!(PopGestureView.d(this.b.a)).P) {
                      LiveGiftModel liveGiftModel = new LiveGiftModel();
                      liveGiftModel.anim_code = this.a.code;
                      liveGiftModel.resource_url = this.a.resource;
                      PopGestureView.c(this.b.a).a(liveGiftModel, new ISetStickerListener(this) {
                            public void onFailed(ErrorCode.PlayStickerCode param3PlayStickerCode, String param3String) {
                              StringBuilder stringBuilder = new StringBuilder();
                              stringBuilder.append("onFailed:");
                              stringBuilder.append(param3PlayStickerCode);
                              stringBuilder.append(" -- ");
                              stringBuilder.append(param3String);
                              Log.v("pk", stringBuilder.toString());
                            }
                            
                            public void onSetSticker() {
                              Log.v("pk", "onSetSticker");
                            }
                          });
                      PopGestureView.a(this.b.a, this.a.tips_url);
                    } 
                  } 
                  this.b.notifyDataSetChanged();
                  return;
                } 
                AppMethods.a(this.a.lock_message);
              }
            });
      } 
    }
  }
  
  class null implements View.OnClickListener {
    null(PopGestureView this$0, LiveRecordLevelGestureModel param1LiveRecordLevelGestureModel) {}
    
    public void onClick(View param1View) {
      if (this.a.status == 1) {
        if (this.a.isSelect) {
          this.a.isSelect = false;
          PopGestureView.c(this.b.a).a(null, null);
          PopGestureView.a(this.b.a, (LiveRecordLevelGestureModel)null);
          LiveRoomPreferences.y("");
        } else {
          PopGestureView.a(this.b.a, this.a);
          for (int i = 0; i < PopGestureView.GestureAdapter.a(this.b).size(); i++)
            ((LiveRecordLevelGestureModel)PopGestureView.GestureAdapter.b(this.b).get(i)).isSelect = false; 
          LiveRecordLevelGestureModel liveRecordLevelGestureModel = this.a;
          liveRecordLevelGestureModel.isSelect = true;
          LiveRoomPreferences.y(liveRecordLevelGestureModel.code);
          if (!(PopGestureView.d(this.b.a)).P) {
            LiveGiftModel liveGiftModel = new LiveGiftModel();
            liveGiftModel.anim_code = this.a.code;
            liveGiftModel.resource_url = this.a.resource;
            PopGestureView.c(this.b.a).a(liveGiftModel, new ISetStickerListener(this) {
                  public void onFailed(ErrorCode.PlayStickerCode param3PlayStickerCode, String param3String) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onFailed:");
                    stringBuilder.append(param3PlayStickerCode);
                    stringBuilder.append(" -- ");
                    stringBuilder.append(param3String);
                    Log.v("pk", stringBuilder.toString());
                  }
                  
                  public void onSetSticker() {
                    Log.v("pk", "onSetSticker");
                  }
                });
            PopGestureView.a(this.b.a, this.a.tips_url);
          } 
        } 
        this.b.notifyDataSetChanged();
        return;
      } 
      AppMethods.a(this.a.lock_message);
    }
  }
  
  class null implements ISetStickerListener {
    public void onFailed(ErrorCode.PlayStickerCode param1PlayStickerCode, String param1String) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onFailed:");
      stringBuilder.append(param1PlayStickerCode);
      stringBuilder.append(" -- ");
      stringBuilder.append(param1String);
      Log.v("pk", stringBuilder.toString());
    }
    
    public void onSetSticker() {
      Log.v("pk", "onSetSticker");
    }
  }
  
  class GestureTip implements Runnable {
    GestureTip(PopGestureView this$0) {}
    
    public void run() {
      PopGestureView.e(this.a).setVisibility(8);
      PopGestureView.e(this.a).startAnimation(AnimationUtils.loadAnimation(PopGestureView.f(this.a), R.anim.push_center_out));
    }
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopGestureView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.c();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopGestureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */