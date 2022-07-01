package com.blued.android.module.yy_china.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYRankAdapter;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRankModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.presenter.YYRankItemPresenter;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.List;

public class YYRankItemFragment extends MvpFragment<YYRankItemPresenter> {
  private RecyclerView d;
  
  private FrameLayout e;
  
  private ImageView f;
  
  private TextView g;
  
  private TextView h;
  
  private ImageView i;
  
  private TextView j;
  
  private TextView n;
  
  private ImageView o;
  
  private TextView p;
  
  private TextView q;
  
  private SmartRefreshLayout r;
  
  private LinearLayout s;
  
  private LinearLayout t;
  
  private LinearLayout u;
  
  private LinearLayout v;
  
  private LinearLayout w;
  
  private ShapeTextView x;
  
  private YYRankAdapter y;
  
  private void l() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    this.d.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.d.addItemDecoration(new RecyclerView.ItemDecoration(this) {
          public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
            param1Rect.bottom = DensityUtils.a(this.a.getContext(), 16.0F);
          }
        });
    this.y = new YYRankAdapter(this);
    this.d.setAdapter((RecyclerView.Adapter)this.y);
  }
  
  public boolean A() {
    return true;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = (RecyclerView)this.l.findViewById(R.id.rank_list_view);
    this.e = (FrameLayout)this.l.findViewById(R.id.fl_no_layout);
    this.f = (ImageView)this.l.findViewById(R.id.iv_no_2);
    this.g = (TextView)this.l.findViewById(R.id.tv_name_no2);
    this.h = (TextView)this.l.findViewById(R.id.tv_wandou_no2);
    this.i = (ImageView)this.l.findViewById(R.id.iv_no_1);
    this.j = (TextView)this.l.findViewById(R.id.tv_name_no1);
    this.n = (TextView)this.l.findViewById(R.id.tv_wandou_no1);
    this.o = (ImageView)this.l.findViewById(R.id.iv_no_3);
    this.p = (TextView)this.l.findViewById(R.id.tv_name_no3);
    this.q = (TextView)this.l.findViewById(R.id.tv_wandou_no3);
    this.r = (SmartRefreshLayout)this.l.findViewById(R.id.refresh_view);
    this.s = (LinearLayout)this.l.findViewById(R.id.ll_no2_view);
    this.t = (LinearLayout)this.l.findViewById(R.id.ll_no1_view);
    this.u = (LinearLayout)this.l.findViewById(R.id.ll_no3_view);
    this.v = (LinearLayout)this.l.findViewById(R.id.ll_hasdata_view);
    this.w = (LinearLayout)this.l.findViewById(R.id.ll_nodata_view);
    this.x = (ShapeTextView)this.l.findViewById(R.id.tv_send_gift);
    if (StatusBarHelper.a())
      ((LinearLayout.LayoutParams)this.r.getLayoutParams()).topMargin = DensityUtils.a(getContext(), 44.0F) + StatusBarHelper.a(getContext()); 
    this.r.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((YYRankItemPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((YYRankItemPresenter)this.a.s()).e();
          }
        });
    this.x.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.getParentFragment() instanceof YYRankFragment) {
              LiveEventBus.get("show_gift_view").post("");
              ((YYRankFragment)this.a.getParentFragment()).dismiss();
            } 
          }
        });
    l();
  }
  
  public void a(YYRankModel paramYYRankModel) {
    if (this.v.getVisibility() != 0) {
      this.v.setVisibility(0);
      this.w.setVisibility(8);
    } 
    this.t.setVisibility(0);
    ImageLoader.a((IRequestHost)w_(), paramYYRankModel.avatar).a(R.drawable.user_bg_round).a(this.i);
    this.j.setText(paramYYRankModel.name);
    TextView textView = this.n;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramYYRankModel.beans);
    stringBuilder.append("弯豆");
    textView.setText(stringBuilder.toString());
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    if (paramString == null)
      return; 
    byte b = -1;
    int i = paramString.hashCode();
    if (i != -1290256561) {
      if (i == 623698297 && paramString.equals("_load_type_loadmore_"))
        b = 1; 
    } else if (paramString.equals("_load_type_refresh_")) {
      b = 0;
    } 
    if (b != 0) {
      if (b != 1)
        return; 
      this.r.h();
      return;
    } 
    this.r.g();
  }
  
  public void a(List<YYRankModel> paramList) {
    this.y.c(paramList);
  }
  
  public void b(YYRankModel paramYYRankModel) {
    this.s.setVisibility(0);
    ImageLoader.a((IRequestHost)w_(), paramYYRankModel.avatar).a(R.drawable.user_bg_round).a(this.f);
    this.g.setText(paramYYRankModel.name);
    TextView textView = this.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramYYRankModel.beans);
    stringBuilder.append("弯豆");
    textView.setText(stringBuilder.toString());
  }
  
  public void c(YYRankModel paramYYRankModel) {
    this.u.setVisibility(0);
    ImageLoader.a((IRequestHost)w_(), paramYYRankModel.avatar).a(R.drawable.user_bg_round).a(this.o);
    this.p.setText(paramYYRankModel.name);
    TextView textView = this.q;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramYYRankModel.beans);
    stringBuilder.append("弯豆");
    textView.setText(stringBuilder.toString());
  }
  
  public void k() {
    this.v.setVisibility(8);
    this.w.setVisibility(0);
  }
  
  public int p() {
    return R.layout.fragment_yy_rank_item_layout;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (s() != null && paramBoolean) {
      ChatRoomProtos.Event event;
      if (((YYRankItemPresenter)s()).m() == 0) {
        Logger.e("YYRankItemFragment", new Object[] { "setUserVisibleHint 获赠榜 。。。 " });
        event = ChatRoomProtos.Event.CHAT_ROOM_LIST_PAGE_GET_SHOW;
      } else {
        Logger.e("YYRankItemFragment", new Object[] { "setUserVisibleHint 赠送榜 。。。 " });
        event = ChatRoomProtos.Event.CHAT_ROOM_LIST_PAGE_SEND_SHOW;
      } 
      YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel != null && event != null)
        EventTrackYY.a(event, yYRoomModel.room_id, yYRoomModel.uid); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setUserVisibleHint position = ");
      stringBuilder.append(((YYRankItemPresenter)s()).m());
      Logger.e("YYRankItemFragment", new Object[] { stringBuilder.toString() });
    } 
  }
  
  public void x() {
    super.x();
    this.r.b(true);
  }
  
  public void y() {
    super.y();
    this.r.b(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\YYRankItemFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */