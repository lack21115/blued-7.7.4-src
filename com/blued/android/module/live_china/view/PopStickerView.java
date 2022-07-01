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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.manager.RecordingOnliveManager;
import com.blued.android.module.live_china.model.LiveRecordLevelStickerModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

public class PopStickerView {
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
  
  private StickerAdapter k;
  
  private LiveRecordLevelStickerModel l;
  
  public PopStickerView(RecordingOnliveFragment paramRecordingOnliveFragment, RecordingOnliveManager paramRecordingOnliveManager) {
    this.g = paramRecordingOnliveManager;
    this.f = paramRecordingOnliveFragment;
    this.b = paramRecordingOnliveFragment.getContext();
    d();
    e();
  }
  
  private String a(long paramLong) {
    long l1 = paramLong / 86400L;
    long l2 = paramLong % 86400L / 3600L;
    if (l1 <= 0L && l2 <= 0L) {
      paramLong /= 60L;
      return String.format(this.b.getResources().getString(R.string.live_sticker_times_short), new Object[] { Long.valueOf(paramLong) });
    } 
    return String.format(this.b.getResources().getString(R.string.live_sticker_times), new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
  }
  
  private void a(BluedEntityA<LiveRecordLevelStickerModel> paramBluedEntityA) {
    if (paramBluedEntityA != null && paramBluedEntityA.data != null && paramBluedEntityA.data.size() > 0) {
      List list = paramBluedEntityA.data;
      if (list != null) {
        StickerAdapter stickerAdapter = this.k;
        if (stickerAdapter != null) {
          stickerAdapter.n().clear();
          this.k.a(list);
          String str = LiveRoomPreferences.q();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("本地缓存code：");
          stringBuilder.append(str);
          Log.v("pk", stringBuilder.toString());
          if (!TextUtils.isEmpty(str))
            for (LiveRecordLevelStickerModel liveRecordLevelStickerModel : list) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("setDataToView ");
              stringBuilder1.append(liveRecordLevelStickerModel.id);
              stringBuilder1.append("__");
              stringBuilder1.append(str);
              Log.v("pk", stringBuilder1.toString());
              if (TextUtils.equals(liveRecordLevelStickerModel.id, str)) {
                Log.v("pk", "设置选中");
                liveRecordLevelStickerModel.isSelect = true;
                this.k.notifyDataSetChanged();
                this.l = liveRecordLevelStickerModel;
                String[] arrayOfString = LiveRoomPreferences.s().split("_");
                if (arrayOfString != null && arrayOfString.length == 2) {
                  int i = Integer.parseInt(arrayOfString[0]);
                  int j = Integer.parseInt(arrayOfString[1]);
                  this.f.cs.a(i, j, liveRecordLevelStickerModel);
                  this.f.cs.b(i, j, liveRecordLevelStickerModel);
                } 
                break;
              } 
            }  
        } 
      } 
    } 
  }
  
  private void e() {
    this.a = LayoutInflater.from(this.b);
    View view = this.a.inflate(R.layout.pop_window_record_level_sticker, null);
    this.c = view.findViewById(R.id.tv_bg);
    this.h = (PullToRefreshRecyclerView)view.findViewById(R.id.live_sticker_recycler_view);
    this.i = view.findViewById(R.id.ll_loading);
    this.j = (RecyclerView)this.h.getRefreshableView();
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.b, 3);
    this.j.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.k = new StickerAdapter(this);
    this.j.setAdapter((RecyclerView.Adapter)this.k);
    this.h.setRefreshEnabled(false);
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
    BluedUIHttpResponse<BluedEntityA<LiveRecordLevelStickerModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<LiveRecordLevelStickerModel>>(this, "RecordLevelSticker", (IRequestHost)this.f.w_()) {
        protected void a(BluedEntityA<LiveRecordLevelStickerModel> param1BluedEntityA) {
          PopStickerView.a(this.a, param1BluedEntityA);
        }
        
        protected void b(BluedEntityA<LiveRecordLevelStickerModel> param1BluedEntityA) {
          PopStickerView.a(this.a, param1BluedEntityA);
        }
        
        public void onUIFinish() {
          super.onUIFinish();
          PopStickerView.a(this.a).setVisibility(8);
        }
        
        public void onUIStart() {
          super.onUIStart();
          PopStickerView.a(this.a).setVisibility(0);
        }
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.f.u);
    stringBuilder.append("");
    LiveRoomHttpUtils.r(bluedUIHttpResponse, stringBuilder.toString());
  }
  
  public void a(LiveRecordLevelStickerModel paramLiveRecordLevelStickerModel) {
    if (paramLiveRecordLevelStickerModel == null)
      return; 
    StickerAdapter stickerAdapter = this.k;
    if (stickerAdapter != null) {
      List list = stickerAdapter.n();
      if (list != null)
        for (LiveRecordLevelStickerModel liveRecordLevelStickerModel : list) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("remove sticker ");
          stringBuilder.append(liveRecordLevelStickerModel.id);
          stringBuilder.append("__");
          stringBuilder.append(paramLiveRecordLevelStickerModel.id);
          Log.v("pk", stringBuilder.toString());
          if (TextUtils.equals(liveRecordLevelStickerModel.id, paramLiveRecordLevelStickerModel.id)) {
            liveRecordLevelStickerModel.isSelect = false;
            this.k.notifyDataSetChanged();
            LiveRoomPreferences.x("");
            break;
          } 
        }  
    } 
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
            PopStickerView.b(this.a).a();
          }
        },  300L);
  }
  
  public void d() {}
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopStickerView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
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
  
  class StickerAdapter extends BaseQuickAdapter<LiveRecordLevelStickerModel, BaseViewHolder> {
    private ImageView b;
    
    private ImageView c;
    
    private ImageView d;
    
    private TextView e;
    
    public StickerAdapter(PopStickerView this$0) {
      super(R.layout.sticker_view_item, null);
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, LiveRecordLevelStickerModel param1LiveRecordLevelStickerModel) {
      if (param1BaseViewHolder != null) {
        String str;
        this.b = (ImageView)param1BaseViewHolder.d(R.id.sticker_image);
        this.e = (TextView)param1BaseViewHolder.d(R.id.sticker_time_text);
        this.c = (ImageView)param1BaseViewHolder.d(R.id.sticker_image_bg);
        this.d = (ImageView)param1BaseViewHolder.d(R.id.sticker_from_source);
        if (param1LiveRecordLevelStickerModel.status == 1) {
          str = param1LiveRecordLevelStickerModel.icon;
        } else {
          str = param1LiveRecordLevelStickerModel.icon_disable;
        } 
        ImageLoader.a(null, str).a(this.b);
        if (param1LiveRecordLevelStickerModel.isSelect) {
          this.c.setVisibility(0);
        } else {
          this.c.setVisibility(8);
        } 
        if (param1LiveRecordLevelStickerModel.is_from_mall == 1) {
          this.d.setVisibility(0);
        } else {
          this.d.setVisibility(8);
        } 
        if (param1LiveRecordLevelStickerModel.is_from_mall == 1 && param1LiveRecordLevelStickerModel.rest_time > 0L) {
          this.e.setText(PopStickerView.a(this.a, param1LiveRecordLevelStickerModel.rest_time));
          this.e.setVisibility(0);
        } else {
          this.e.setVisibility(8);
          this.e.setText("");
        } 
        param1BaseViewHolder.a(R.id.sticker_root_layout, new View.OnClickListener(this, param1LiveRecordLevelStickerModel) {
              public void onClick(View param2View) {
                if (this.a.status == 1) {
                  if (this.a.isSelect) {
                    this.a.isSelect = false;
                    PopStickerView.c(this.b.a).b(null);
                    LiveRoomPreferences.x("");
                    PopStickerView.a(this.b.a, (LiveRecordLevelStickerModel)null);
                  } else {
                    for (int i = 0; i < PopStickerView.StickerAdapter.a(this.b).size(); i++)
                      ((LiveRecordLevelStickerModel)PopStickerView.StickerAdapter.b(this.b).get(i)).isSelect = false; 
                    this.a.isSelect = true;
                    PopStickerView.a(this.b.a, this.a);
                    PopStickerView.c(this.b.a).b(this.a);
                    if (this.a.is_from_mall == 1) {
                      this.a.is_used = 1;
                      PopStickerView.c(this.b.a).i(this.a.id);
                    } 
                    LiveRoomPreferences.x(this.a.id);
                  } 
                  this.b.notifyDataSetChanged();
                } else {
                  AppMethods.a(this.a.lock_message);
                } 
                PopStickerView.b(this.b.a).dismiss();
              }
            });
      } 
    }
  }
  
  class null implements View.OnClickListener {
    null(PopStickerView this$0, LiveRecordLevelStickerModel param1LiveRecordLevelStickerModel) {}
    
    public void onClick(View param1View) {
      if (this.a.status == 1) {
        if (this.a.isSelect) {
          this.a.isSelect = false;
          PopStickerView.c(this.b.a).b(null);
          LiveRoomPreferences.x("");
          PopStickerView.a(this.b.a, (LiveRecordLevelStickerModel)null);
        } else {
          for (int i = 0; i < PopStickerView.StickerAdapter.a(this.b).size(); i++)
            ((LiveRecordLevelStickerModel)PopStickerView.StickerAdapter.b(this.b).get(i)).isSelect = false; 
          this.a.isSelect = true;
          PopStickerView.a(this.b.a, this.a);
          PopStickerView.c(this.b.a).b(this.a);
          if (this.a.is_from_mall == 1) {
            this.a.is_used = 1;
            PopStickerView.c(this.b.a).i(this.a.id);
          } 
          LiveRoomPreferences.x(this.a.id);
        } 
        this.b.notifyDataSetChanged();
      } else {
        AppMethods.a(this.a.lock_message);
      } 
      PopStickerView.b(this.b.a).dismiss();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopStickerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */