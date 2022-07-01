package com.soft.blued.ui.msg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.soft.blued.base.mvp.MVPBaseFragment;
import com.soft.blued.base.mvp.MVPBasePresent;
import com.soft.blued.customview.SpacesItemDecoration;
import com.soft.blued.ui.msg.contract.IChatBgSelectIView;
import com.soft.blued.ui.msg.presenter.ChatBgSelectPresent;

public class ChatBgSelectFragment extends MVPBaseFragment<IChatBgSelectIView, ChatBgSelectPresent> implements IChatBgSelectIView {
  private PullToRefreshRecyclerView m;
  
  private RecyclerView n;
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, long paramLong, short paramShort, int paramInt2) {
    Bundle bundle = new Bundle();
    bundle.putLong("passby_session_id", paramLong);
    bundle.putShort("passby_session_type", paramShort);
    bundle.putInt("from", paramInt1);
    TerminalActivity.a((Fragment)paramBaseFragment, ChatBgSelectFragment.class, bundle, paramInt2);
  }
  
  public void a(RecyclerView.Adapter paramAdapter) {
    RecyclerView recyclerView = this.n;
    if (recyclerView != null)
      recyclerView.setAdapter(paramAdapter); 
  }
  
  public boolean a(Bundle paramBundle) {
    return false;
  }
  
  public void b(Bundle paramBundle) {
    this.i.setCenterText(2131755591);
    this.i.a();
    this.m = (PullToRefreshRecyclerView)this.f.findViewById(2131299238);
    this.n = (RecyclerView)this.m.getRefreshableView();
    this.n.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(getContext(), 3));
    SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(DensityUtils.a(getContext(), 1.5F));
    spacesItemDecoration.a(5);
    spacesItemDecoration.a(true, true, true, true);
    spacesItemDecoration.a(0, DensityUtils.a(getContext(), 3.5F), 0, DensityUtils.a(getContext(), 3.5F));
    this.n.addItemDecoration((RecyclerView.ItemDecoration)spacesItemDecoration);
    this.m.setRefreshEnabled(false);
    this.m.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            if (ChatBgSelectFragment.a(this.a) != null)
              ((ChatBgSelectPresent)ChatBgSelectFragment.b(this.a)).e(); 
          }
        });
    a(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (ChatBgSelectFragment.c(this.a) != null)
              ((ChatBgSelectPresent)ChatBgSelectFragment.d(this.a)).e(); 
          }
        });
  }
  
  public void o() {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    return a(2131493085, paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  protected ChatBgSelectPresent r() {
    return new ChatBgSelectPresent();
  }
  
  public void s() {
    PullToRefreshRecyclerView pullToRefreshRecyclerView = this.m;
    if (pullToRefreshRecyclerView != null)
      pullToRefreshRecyclerView.j(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\ChatBgSelectFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */