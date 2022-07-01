package com.soft.blued.ui.msg_group.pop;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.ui.msg_group.adapter.CircleGroupAdapter;
import com.soft.blued.ui.msg_group.fragment.GroupInfoFragment;
import com.soft.blued.ui.msg_group.model.GroupInfoModel;
import java.util.List;

public class CircleGroupListPop extends BottomPopupView {
  private List<GroupInfoModel> b;
  
  private IRequestHost c;
  
  public CircleGroupListPop(Context paramContext, List<GroupInfoModel> paramList, IRequestHost paramIRequestHost) {
    super(paramContext);
    this.b = paramList;
    this.c = paramIRequestHost;
  }
  
  public void a(Context paramContext) {
    (new XPopup.Builder(paramContext)).a((BasePopupView)this).h();
  }
  
  public void b() {
    super.b();
    RecyclerView recyclerView = (RecyclerView)findViewById(2131297296);
    recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext(), 0, false));
    CircleGroupAdapter circleGroupAdapter = new CircleGroupAdapter(this.b, this.c);
    circleGroupAdapter.a(new -$$Lambda$CircleGroupListPop$_udqE997JY_bOFeZuW43uBFDMXQ(this));
    recyclerView.setAdapter((RecyclerView.Adapter)circleGroupAdapter);
  }
  
  public int getImplLayoutId() {
    return 2131494033;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\pop\CircleGroupListPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */