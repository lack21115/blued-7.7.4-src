package com.soft.blued.ui.yy_room.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYFollowedModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.yy_room.adapter.YYFollowedAdapter;
import com.soft.blued.ui.yy_room.presenter.YYFollowedPresenter;
import java.util.List;

public class YYFollowedFragment extends MvpFragment<YYFollowedPresenter> implements View.OnClickListener {
  private YYFollowedAdapter d;
  
  private int e;
  
  private NoDataAndLoadFailView f;
  
  @BindView(2131298984)
  NoDataAndLoadFailView llNoInternet;
  
  @BindView(2131299102)
  CommonTopTitleNoTrans llTitle;
  
  @BindView(2131299614)
  SmartRefreshLayout refreshFollowList;
  
  @BindView(2131299772)
  RecyclerView rvFollowList;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, YYFollowedFragment.class, new Bundle());
  }
  
  private void b(boolean paramBoolean) {
    if (this.d.n().size() <= 0) {
      if (paramBoolean) {
        this.llNoInternet.a();
        return;
      } 
      this.f.b();
    } 
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.e = DensityUtils.a(getContext(), 16.0F);
    this.llTitle.e();
    this.llTitle.a();
    this.llTitle.setLeftImg(2131232743);
    this.llTitle.setCenterText(getString(2131759439));
    this.llTitle.setLeftClickListener(this);
    this.llTitle.e();
    this.llTitle.setCenterTextColor(2131100838);
    if (this.d == null)
      this.d = new YYFollowedAdapter(getContext(), (IRequestHost)w_()); 
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    this.rvFollowList.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.rvFollowList.setAdapter((RecyclerView.Adapter)this.d);
    this.rvFollowList.addItemDecoration(new RecyclerView.ItemDecoration(this) {
          public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
            if (param1RecyclerView.getChildAdapterPosition(param1View) == 0)
              param1Rect.top = YYFollowedFragment.a(this.a); 
            param1Rect.bottom = YYFollowedFragment.a(this.a);
          }
        });
    this.f = new NoDataAndLoadFailView(getContext());
    this.d.e((View)this.f);
    this.d.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            YYFollowedModel.DataBean dataBean = YYFollowedFragment.b(this.a).a(param1Int);
            if (dataBean.is_on_live == 1) {
              YYRoomInfoManager.d().a((BaseFragmentActivity)this.a.getActivity(), dataBean.room_id, "chat_room_followed_list");
              return;
            } 
            UserInfoFragmentNew.a(this.a.getContext(), dataBean.uid, "CIRCLE_NOTE_DETAIL");
          }
        });
    this.refreshFollowList.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((YYFollowedPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((YYFollowedPresenter)this.a.s()).e();
          }
        });
    this.refreshFollowList.i();
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
      if (b == 1)
        this.refreshFollowList.h(); 
    } else {
      this.refreshFollowList.g();
    } 
    b(paramBoolean);
  }
  
  public void a(List<YYFollowedModel.DataBean> paramList) {
    this.d.c(paramList);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    C();
  }
  
  public int p() {
    return 2131493373;
  }
  
  public void x() {
    super.x();
    this.refreshFollowList.b(true);
  }
  
  public void y() {
    super.y();
    this.refreshFollowList.b(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\fragment\YYFollowedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */