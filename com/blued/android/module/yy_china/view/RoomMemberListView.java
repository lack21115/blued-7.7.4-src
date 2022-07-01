package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.RoomMemberAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.OnItemClickRoomMemberListener;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

public class RoomMemberListView extends LinearLayout implements FollowStatusObserver {
  private BaseYYStudioFragment a;
  
  private SmartRefreshLayout b;
  
  private RecyclerView c;
  
  private FrameLayout d;
  
  private RoomMemberAdapter e;
  
  private int f;
  
  private boolean g = false;
  
  private int h = 1;
  
  private int i;
  
  private YYNoDataView j;
  
  public RoomMemberListView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public RoomMemberListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RoomMemberListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    this.f = DensityUtils.a(getContext(), 16.0F);
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_room_members_layout, (ViewGroup)this, true);
    this.b = (SmartRefreshLayout)findViewById(R.id.refresh_view);
    this.c = (RecyclerView)findViewById(R.id.recycler_view);
    this.d = (FrameLayout)findViewById(R.id.fl_loading_view);
    this.j = new YYNoDataView(getContext());
    this.j.setNoDataImg(R.drawable.icon_nodata_img);
    this.j.setNoDataStr(R.string.yy_no_member);
    this.b.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            RoomMemberListView.a(this.a);
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            RoomMemberListView.a(this.a, 1);
            RoomMemberListView.a(this.a);
          }
        });
  }
  
  private void a(YYAudienceModel paramYYAudienceModel, int paramInt) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    if (!yYRoomModel.enableRequestMic()) {
      ToastUtils.a("相亲交友活动已开始，不可以邀请用户上麦喽！", 0);
      return;
    } 
    YYRoomHttpUtils.a(yYRoomModel.room_id, paramYYAudienceModel.getUid(), 0, new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)this.a.w_()) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            ToastUtils.a("邀请上麦已发出，等待确认", 0);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            RoomMemberListView.g(this.a).setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            RoomMemberListView.g(this.a).setVisibility(0);
          }
        }(IRequestHost)this.a.w_());
  }
  
  private void b() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYRoomHttpUtils.b(yYRoomModel.room_id, this.h, new BluedUIHttpResponse<BluedEntityA<YYAudienceModel>>(this, (IRequestHost)this.a.w_()) {
          protected void a(BluedEntityA<YYAudienceModel> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              if (!param1BluedEntityA.hasData())
                return; 
              if (RoomMemberListView.d(this.a) == 1) {
                RoomMemberListView.e(this.a).c(param1BluedEntityA.data);
              } else {
                RoomMemberListView.e(this.a).a(param1BluedEntityA.data);
              } 
              if (param1BluedEntityA.hasMore()) {
                RoomMemberListView.f(this.a);
                RoomMemberListView.c(this.a).b(true);
              } else {
                RoomMemberListView.c(this.a).b(false);
              } 
              RoomMemberListView.c(this.a).g();
              RoomMemberListView.c(this.a).h();
            } 
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            RoomMemberListView.c(this.a).g();
            RoomMemberListView.c(this.a).h();
          }
        }(IRequestHost)this.a.w_());
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment, int paramInt) {
    this.a = paramBaseYYStudioFragment;
    this.i = paramInt;
    this.e = new RoomMemberAdapter(paramBaseYYStudioFragment, paramInt);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    this.c.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.c.addItemDecoration(new RecyclerView.ItemDecoration(this) {
          public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
            if (param1RecyclerView.getChildAdapterPosition(param1View) == 0)
              param1Rect.top = RoomMemberListView.b(this.a); 
            param1Rect.bottom = RoomMemberListView.b(this.a);
          }
        });
    this.c.setAdapter((RecyclerView.Adapter)this.e);
    this.e.e((View)this.j);
    this.e.a(new OnItemClickRoomMemberListener(this, paramBaseYYStudioFragment) {
          public void a(YYAudienceModel param1YYAudienceModel, int param1Int) {
            if (TextUtils.equals(param1YYAudienceModel.relationship, "2") || TextUtils.equals("0", param1YYAudienceModel.relationship)) {
              YYRoomInfoManager.d().b(this.b.getContext(), param1YYAudienceModel.getUid(), "", (IRequestHost)this.a.w_());
              return;
            } 
            YYRoomInfoManager.d().a(this.b.getContext(), param1YYAudienceModel.getUid(), "", (IRequestHost)this.a.w_());
          }
          
          public void b(YYAudienceModel param1YYAudienceModel, int param1Int) {
            RoomMemberListView.a(this.b, param1YYAudienceModel, param1Int);
          }
        });
    this.g = true;
    paramBaseYYStudioFragment.a(new Runnable(this) {
          public void run() {
            RoomMemberListView.c(this.a).i();
          }
        },  300L);
  }
  
  public void a(String paramString1, String paramString2) {
    int i = this.e.a(paramString1);
    ((YYAudienceModel)this.e.n().get(i)).relationship = paramString2;
    this.e.notifyItemChanged(i);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    Logger.e("observer", new Object[] { "RoomMemberListView onAttachedToWindow ... " });
    YYObserverManager.a().a(this);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    Logger.e("observer", new Object[] { "RoomMemberListView onDetachedFromWindow ... " });
    YYObserverManager.a().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\RoomMemberListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */