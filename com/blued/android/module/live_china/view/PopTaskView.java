package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.TaskModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class PopTaskView {
  private LayoutInflater a;
  
  private Context b;
  
  private View c;
  
  private View d;
  
  private MyPopupWindow e;
  
  private View f;
  
  private RecyclerView g;
  
  private MyAdapter h;
  
  private String i;
  
  private String j;
  
  public PopTaskView(Context paramContext) {
    this.b = paramContext;
    b();
  }
  
  private void a(TaskModel paramTaskModel) {
    if (!TextUtils.isEmpty(this.i))
      EventTrackLive.a(LiveProtos.Event.LIVE_TASK_AWARD_CLICK, this.i, this.j, EventTrackLive.a(paramTaskModel.task_id)); 
    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<TaskModel>>(this, paramTaskModel) {
          public void a(BluedEntityA<TaskModel> param1BluedEntityA) {
            if (param1BluedEntityA.getSingleData() == null)
              return; 
            this.a.status = 2;
            PopTaskView.c(this.b).notifyDataSetChanged();
            if (!TextUtils.isEmpty(((TaskModel)param1BluedEntityA.getSingleData()).copywriting))
              AppMethods.a(((TaskModel)param1BluedEntityA.getSingleData()).copywriting); 
            if (this.a.task_id == 1 || this.a.task_id == 2)
              LiveEventBus.get("live_msg_daily_task_complete").post(Integer.valueOf(this.a.task_id)); 
            LiveEventBus.get("live_refresh_gift_list").post(Boolean.valueOf(true));
          }
          
          public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
            return super.onUIFailure(param1Int, param1String1, param1String2);
          }
          
          public void onUIFinish() {
            PopTaskView.c(this.b).notifyDataSetChanged();
          }
        }LiveRoomInfo.a().f(), String.valueOf(paramTaskModel.task_id));
  }
  
  private void b() {
    this.a = LayoutInflater.from(this.b);
    View view = this.a.inflate(R.layout.pop_window_live_task, null);
    this.c = view.findViewById(R.id.tv_bg);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a();
          }
        });
    this.d = view.findViewById(R.id.content);
    this.d.setVisibility(8);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.d.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a();
          }
        });
    this.f = this.d.findViewById(R.id.loading);
    this.g = (RecyclerView)this.d.findViewById(R.id.recycler_view);
    this.g.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(this.b));
    this.h = new MyAdapter(this);
    this.g.setAdapter((RecyclerView.Adapter)this.h);
    this.e = new MyPopupWindow(this, view, -1, -1, true);
    this.e.setBackgroundDrawable(this.b.getResources().getDrawable(17170445));
    this.e.setTouchable(true);
    this.e.setOutsideTouchable(true);
    this.e.setFocusable(true);
    this.e.update();
  }
  
  private void c() {
    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<TaskModel>>(this) {
          public void a(BluedEntityA<TaskModel> param1BluedEntityA) {
            if (param1BluedEntityA.hasData()) {
              PopTaskView.b(this.a).setVisibility(0);
              PopTaskView.c(this.a).c(param1BluedEntityA.data);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
            return super.onUIFailure(param1Int, param1String1, param1String2);
          }
          
          public void onUIFinish() {
            PopTaskView.a(this.a).setVisibility(4);
          }
          
          public void onUIStart() {
            super.onUIStart();
            PopTaskView.a(this.a).setVisibility(0);
            PopTaskView.b(this.a).setVisibility(8);
          }
        });
  }
  
  public void a() {
    LiveEventBus.get("live_show_dialog").post(Boolean.valueOf(false));
    this.d.setVisibility(8);
    this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out));
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopTaskView.d(this.a).a();
          }
        },  300L);
  }
  
  public void a(long paramLong, String paramString) {
    if (paramLong == 0L)
      return; 
    this.i = String.valueOf(paramLong);
    this.j = paramString;
    EventTrackLive.a(LiveProtos.Event.LIVE_TASK_BTN_CLICK, this.i, this.j);
    LiveEventBus.get("live_show_dialog").post(Boolean.valueOf(true));
    this.c.clearAnimation();
    this.d.clearAnimation();
    if (this.e.isShowing())
      this.e.a(); 
    this.e.showAtLocation(this.d, 81, 0, 0);
    this.d.setVisibility(0);
    this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in));
    c();
  }
  
  class MyAdapter extends BaseQuickAdapter<TaskModel, BaseViewHolder> {
    public MyAdapter(PopTaskView this$0) {
      super(R.layout.item_live_task, null);
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, TaskModel param1TaskModel) {
      ImageView imageView = (ImageView)param1BaseViewHolder.d(R.id.iv_icon);
      TextView textView1 = (TextView)param1BaseViewHolder.d(R.id.tv_name);
      TextView textView2 = (TextView)param1BaseViewHolder.d(R.id.tv_prize);
      ShapeTextView shapeTextView = (ShapeTextView)param1BaseViewHolder.d(R.id.tv_status);
      ImageLoader.a(null, param1TaskModel.task_icon).a(imageView);
      textView1.setText(param1TaskModel.task_name);
      textView2.setText(param1TaskModel.task_prize);
      int i = param1TaskModel.status;
      if (i != 0) {
        if (i != 1) {
          if (i == 2) {
            ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, R.color.syc_dark_b, R.color.syc_dark_b);
            shapeTextView.setText(this.k.getString(R.string.live_daily_task_completed));
            shapeTextView.setTextColor(this.k.getResources().getColor(R.color.syc_w));
          } 
        } else {
          ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, R.color.syc_w_996AFB, R.color.syc_w_465CF2);
          shapeTextView.setText(this.k.getString(R.string.live_daily_task_receive));
          shapeTextView.setTextColor(this.k.getResources().getColor(R.color.syc_b));
        } 
      } else {
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, R.color.syc_E2E2E2, R.color.syc_E2E2E2);
        shapeTextView.setText(this.k.getString(R.string.live_daily_task_unfinished));
        shapeTextView.setTextColor(this.k.getResources().getColor(R.color.syc_b));
      } 
      shapeTextView.setOnClickListener(new View.OnClickListener(this, param1TaskModel) {
            public void onClick(View param2View) {
              if (this.a.status == 1)
                PopTaskView.a(this.b.a, this.a); 
            }
          });
    }
  }
  
  class null implements View.OnClickListener {
    null(PopTaskView this$0, TaskModel param1TaskModel) {}
    
    public void onClick(View param1View) {
      if (this.a.status == 1)
        PopTaskView.a(this.b.a, this.a); 
    }
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopTaskView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.a();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopTaskView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */