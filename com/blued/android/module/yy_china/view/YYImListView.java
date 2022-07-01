package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYImMsgAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.observer.IMMessageObserver;
import java.util.Iterator;
import java.util.List;

public class YYImListView extends RelativeLayout implements View.OnClickListener, FollowStatusObserver, IMMessageObserver {
  private BaseYYStudioFragment a;
  
  private RecyclerView b;
  
  private ShapeTextView c;
  
  private YYImMsgAdapter d;
  
  private LinearLayoutManager e;
  
  private boolean f = false;
  
  private int g;
  
  private int h = 100;
  
  public YYImListView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYImListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYImListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_im_list_view, (ViewGroup)this, true);
    this.b = (RecyclerView)findViewById(R.id.im_list_view);
    this.c = (ShapeTextView)findViewById(R.id.tv_new_msg);
    this.c.setOnClickListener(this);
    this.e = new LinearLayoutManager(getContext());
    this.e.setOrientation(1);
    this.b.setLayoutManager((RecyclerView.LayoutManager)this.e);
    this.b.addItemDecoration(new RecyclerView.ItemDecoration(this) {
          public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
            param1Rect.bottom = DensityUtils.a(this.a.getContext(), 4.0F);
          }
        });
    this.b.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
            RecyclerView.LayoutManager layoutManager = param1RecyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager))
              return; 
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager)layoutManager;
            YYImListView.a(this.a, linearLayoutManager.findLastVisibleItemPosition());
            if (!param1RecyclerView.canScrollVertically(1) && YYImListView.a(this.a) == YYImListView.b(this.a).getItemCount() - 1) {
              YYImListView.a(this.a, true);
            } else {
              YYImListView.a(this.a, false);
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onScrolled isLast = ");
            stringBuilder.append(YYImListView.c(this.a));
            Logger.e("onMessage", new Object[] { stringBuilder.toString() });
            if (YYImListView.c(this.a)) {
              if (YYImListView.d(this.a).getVisibility() == 0) {
                YYImListView.b(this.a, false);
                return;
              } 
            } else {
              YYImListView.b(this.a, false);
            } 
          }
        });
  }
  
  private void a(boolean paramBoolean) {
    byte b;
    ShapeTextView shapeTextView = this.c;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    shapeTextView.setVisibility(b);
  }
  
  private void b(int paramInt) {
    this.b.scrollToPosition(paramInt);
  }
  
  public void a(int paramInt) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    Iterator iterator = yYRoomModel.getImDatas().iterator();
    while (iterator.hasNext()) {
      if (((YYImModel)iterator.next()).type == paramInt) {
        iterator.remove();
        break;
      } 
    } 
    this.d.notifyDataSetChanged();
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.a = paramBaseYYStudioFragment;
    this.d = new YYImMsgAdapter(paramBaseYYStudioFragment);
    this.d.a(this.b);
    this.b.setAdapter((RecyclerView.Adapter)this.d);
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      List list = yYRoomModel.getImDatas();
      this.d.c(list);
      if (list.size() > 0)
        paramBaseYYStudioFragment.a(new Runnable(this) {
              public void run() {
                YYImListView yYImListView = this.a;
                YYImListView.b(yYImListView, YYImListView.e(yYImListView).getItemCount() - 1);
              }
            }50L); 
    } 
  }
  
  public void a(YYImModel paramYYImModel) {
    this.a.a(new Runnable(this) {
          public void run() {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel == null)
              return; 
            int i = yYRoomModel.getImDatas().size();
            if (i >= YYImListView.f(this.a))
              yYRoomModel.getImDatas().remove(0); 
            YYImListView.e(this.a).notifyDataSetChanged();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("notifMessage isLast = ");
            stringBuilder.append(YYImListView.c(this.a));
            Logger.e("onMessage", new Object[] { stringBuilder.toString() });
            if (!YYImListView.c(this.a) && i > 3) {
              YYImListView.b(this.a, true);
              return;
            } 
            YYImListView yYImListView = this.a;
            YYImListView.b(yYImListView, YYImListView.e(yYImListView).getItemCount() - 1);
          }
        });
  }
  
  public void a(String paramString1, String paramString2) {
    if (TextUtils.equals(paramString2, "1") || TextUtils.equals(paramString2, "3"))
      a(-3); 
  }
  
  public void b(YYImModel paramYYImModel) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    yYRoomModel.getImDatas().remove(paramYYImModel);
    this.d.notifyDataSetChanged();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    Logger.e("observer", new Object[] { "onAttachedToWindow ... " });
    YYObserverManager.a().a(this);
    YYObserverManager.a().a(this);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.tv_new_msg) {
      a(false);
      b(this.d.getItemCount() - 1);
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    Logger.e("observer", new Object[] { "onDetachedFromWindow ... " });
    YYObserverManager.a().b(this);
    YYObserverManager.a().b(this);
    this.d.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYImListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */