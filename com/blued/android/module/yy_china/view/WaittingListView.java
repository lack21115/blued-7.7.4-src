package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.WaittingAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.ClickApplyHandleListener;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

public class WaittingListView extends LinearLayout {
  private RecyclerView a;
  
  private SmartRefreshLayout b;
  
  private int c;
  
  private WaittingAdapter d;
  
  private BaseYYStudioFragment e;
  
  private YYNoDataView f;
  
  private int g = 1;
  
  public WaittingListView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public WaittingListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public WaittingListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    this.c = DensityUtils.a(getContext(), 16.0F);
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_waitting_list_view, (ViewGroup)this, true);
    this.a = (RecyclerView)findViewById(R.id.recycler_view);
    this.b = (SmartRefreshLayout)findViewById(R.id.refresh_view);
    this.f = new YYNoDataView(getContext());
    this.f.setNoDataImg(R.drawable.icon_nodata_img);
    this.f.setNoDataStr(R.string.yy_no_person);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    this.a.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.a.addItemDecoration(new RecyclerView.ItemDecoration(this) {
          public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
            if (param1RecyclerView.getChildAdapterPosition(param1View) == 0)
              param1Rect.top = WaittingListView.a(this.a); 
            param1Rect.bottom = WaittingListView.a(this.a);
          }
        });
    this.b.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            WaittingListView.b(this.a);
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            WaittingListView.a(this.a, 1);
            WaittingListView.b(this.a);
          }
        });
  }
  
  private void a(YYAudienceModel paramYYAudienceModel, int paramInt1, int paramInt2) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    if (!yYRoomModel.enableRequestMic()) {
      ToastUtils.a("相亲交友活动已开始，不可以同意用户上麦喽！", 0);
      return;
    } 
    if (paramInt1 == 1) {
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_MIKE_USER_ACCEPT_CLICK, yYRoomModel.room_id, yYRoomModel.uid, paramYYAudienceModel.getUid());
    } else {
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_MIKE_USER_REFUSE_CLICK, yYRoomModel.room_id, yYRoomModel.uid, paramYYAudienceModel.getUid());
    } 
    YYRoomHttpUtils.c(yYRoomModel.room_id, paramYYAudienceModel.getUid(), paramInt1, new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)this.e.w_(), paramInt2) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            WaittingListView.e(this.b).a(this.a);
            YYObserverManager.a().b(WaittingListView.e(this.b).n().size());
          }
        }(IRequestHost)this.e.w_());
  }
  
  private void getWattingList() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYRoomHttpUtils.d(yYRoomModel.room_id, this.g, new BluedUIHttpResponse<BluedEntity<YYAudienceModel, BluedEntityBaseExtra>>(this, (IRequestHost)this.e.w_(), yYRoomModel) {
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            WaittingListView.c(this.b).g();
            WaittingListView.c(this.b).h();
          }
          
          public void onUIUpdate(BluedEntity<YYAudienceModel, BluedEntityBaseExtra> param1BluedEntity) {
            if (param1BluedEntity == null)
              return; 
            if (WaittingListView.d(this.b) == 1) {
              this.a.setWaittingCount(param1BluedEntity.extra.total);
              YYObserverManager.a().b(param1BluedEntity.extra.total);
            } 
            if (param1BluedEntity != null) {
              if (!param1BluedEntity.hasData())
                return; 
              if (WaittingListView.d(this.b) == 1) {
                WaittingListView.e(this.b).c(param1BluedEntity.data);
              } else {
                WaittingListView.e(this.b).a(param1BluedEntity.data);
              } 
              if (param1BluedEntity.hasMore()) {
                WaittingListView.f(this.b);
                WaittingListView.c(this.b).b(true);
                return;
              } 
              WaittingListView.c(this.b).b(false);
            } 
          }
        }(IRequestHost)this.e.w_());
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.e = paramBaseYYStudioFragment;
    this.d = new WaittingAdapter(paramBaseYYStudioFragment);
    this.a.setAdapter((RecyclerView.Adapter)this.d);
    this.d.e((View)this.f);
    this.d.a(new ClickApplyHandleListener(this) {
          public void a(YYAudienceModel param1YYAudienceModel, int param1Int1, int param1Int2) {
            WaittingListView.a(this.a, param1YYAudienceModel, param1Int1, param1Int2);
          }
        });
    paramBaseYYStudioFragment.a(new Runnable(this) {
          public void run() {
            WaittingListView.c(this.a).i();
          }
        },  300L);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.e = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\WaittingListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */