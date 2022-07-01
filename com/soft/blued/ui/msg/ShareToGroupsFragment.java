package com.soft.blued.ui.msg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.group.model.BluedMyGroupLists;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.ShareUtils;
import java.util.ArrayList;
import java.util.List;

public class ShareToGroupsFragment extends PreloadFragment {
  private Context o;
  
  private ShareToMsgEntity p;
  
  private GroupListAdapter q;
  
  private NoDataAndLoadFailView r;
  
  private ProgressBar s;
  
  private RecyclerView t;
  
  private PullToRefreshRecyclerView u;
  
  private List<BluedGroupLists> v;
  
  public static ShareToGroupsFragment a(Bundle paramBundle) {
    ShareToGroupsFragment shareToGroupsFragment = new ShareToGroupsFragment();
    if (paramBundle != null)
      shareToGroupsFragment.setArguments(paramBundle); 
    return shareToGroupsFragment;
  }
  
  private void t() {
    GroupHttpUtils.g(this.o, new BluedUIHttpResponse<BluedEntityA<BluedMyGroupLists>>(this) {
          protected void a(BluedEntityA<BluedMyGroupLists> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                if (param1BluedEntityA.hasData()) {
                  byte b;
                  List list1;
                  List list2;
                  BluedMyGroupLists bluedMyGroupLists = (BluedMyGroupLists)param1BluedEntityA.getSingleData();
                  if (bluedMyGroupLists != null) {
                    List list = bluedMyGroupLists.created;
                    list1 = bluedMyGroupLists.admin;
                    list2 = bluedMyGroupLists.joined;
                    b = 0;
                    if (list != null)
                      for (int i = 0; i < list.size(); i++) {
                        ((BluedCreatedGroupInfo)list.get(i)).type = 0;
                        ((BluedCreatedGroupInfo)list.get(i)).header_name = this.a.getResources().getString(2131758154);
                        ShareToGroupsFragment.c(this.a).add(list.get(i));
                      }  
                  } else {
                    ShareToGroupsFragment.d(this.a).a();
                    ShareToGroupsFragment.e(this.a).e((View)ShareToGroupsFragment.d(this.a));
                    ShareToGroupsFragment.e(this.a).c(null);
                    return;
                  } 
                  if (list1 != null) {
                    int i;
                    for (i = 0; i < list1.size(); i++) {
                      ((BluedCreatedGroupInfo)list1.get(i)).type = 1;
                      ((BluedCreatedGroupInfo)list1.get(i)).header_name = this.a.getResources().getString(2131758170);
                      ShareToGroupsFragment.c(this.a).add(list1.get(i));
                    } 
                  } 
                  if (list2 != null) {
                    int i;
                    for (i = b; i < list2.size(); i++) {
                      ((BluedCreatedGroupInfo)list2.get(i)).type = 2;
                      ((BluedCreatedGroupInfo)list2.get(i)).header_name = this.a.getResources().getString(2131758167);
                      ShareToGroupsFragment.c(this.a).add(list2.get(i));
                    } 
                  } 
                  if (ShareToGroupsFragment.c(this.a).size() == 0) {
                    ShareToGroupsFragment.d(this.a).a();
                    ShareToGroupsFragment.e(this.a).e((View)ShareToGroupsFragment.d(this.a));
                    ShareToGroupsFragment.e(this.a).c(null);
                    return;
                  } 
                  ShareToGroupsFragment.e(this.a).c(ShareToGroupsFragment.c(this.a));
                  return;
                } 
                ShareToGroupsFragment.d(this.a).a();
                ShareToGroupsFragment.e(this.a).e((View)ShareToGroupsFragment.d(this.a));
                ShareToGroupsFragment.e(this.a).c(null);
                return;
              } catch (Exception exception) {
                ShareToGroupsFragment.d(this.a).a();
                ShareToGroupsFragment.e(this.a).e((View)ShareToGroupsFragment.d(this.a));
                ShareToGroupsFragment.e(this.a).c(null);
                exception.printStackTrace();
                return;
              }  
            ShareToGroupsFragment.d(this.a).a();
            ShareToGroupsFragment.e(this.a).e((View)ShareToGroupsFragment.d(this.a));
            ShareToGroupsFragment.e(this.a).c(null);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            ShareToGroupsFragment.d(this.a).b();
            ShareToGroupsFragment.e(this.a).e((View)ShareToGroupsFragment.d(this.a));
            ShareToGroupsFragment.e(this.a).c(null);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            ShareToGroupsFragment.f(this.a).setVisibility(8);
            ShareToGroupsFragment.e(this.a).k();
          }
        }UserInfo.a().i().getUid(), (IRequestHost)w_());
  }
  
  public void a(View paramView) {
    this.v = new ArrayList<BluedGroupLists>();
    paramView = LayoutInflater.from(this.o).inflate(2131493316, (ViewGroup)paramView, true);
    this.s = (ProgressBar)paramView.findViewById(2131299526);
    this.u = (PullToRefreshRecyclerView)paramView.findViewById(2131299532);
    this.u.setRefreshEnabled(false);
    this.t = (RecyclerView)this.u.getRefreshableView();
    this.r = new NoDataAndLoadFailView(this.o);
    this.r.setNoDataImg(2131232644);
    this.r.setNoDataStr(2131759018);
    this.r.a();
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.o);
    this.q = new GroupListAdapter();
    this.t.addItemDecoration(new SectionDecoration(this, DensityUtils.a(this.o, 30.0F)));
    this.t.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.t.setAdapter((RecyclerView.Adapter)this.q);
    this.q.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            BluedGroupLists bluedGroupLists = param1BaseQuickAdapter.n().get(param1Int);
            if (bluedGroupLists == null)
              return; 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(this.a.getResources().getString(2131756611));
            stringBuilder.append("]");
            stringBuilder.append(bluedGroupLists.groups_name);
            String str = stringBuilder.toString();
            ShareUtils.a().a(ShareToGroupsFragment.a(this.a), Long.parseLong(bluedGroupLists.groups_gid), (short)3, bluedGroupLists.groups_name, bluedGroupLists.groups_avatar, bluedGroupLists.vbadge, 0, 0, 0, 0, ShareToGroupsFragment.b(this.a), str, (ShareToGroupsFragment.b(this.a)).gid);
          }
        });
    t();
  }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    this.o = paramContext;
    if (getArguments() != null)
      this.p = (ShareToMsgEntity)getArguments().get("share_entity"); 
  }
  
  class GroupListAdapter extends BaseQuickAdapter<BluedGroupLists, BaseViewHolder> {
    private TextView b;
    
    private ImageView c;
    
    private GroupListAdapter(ShareToGroupsFragment this$0) {
      super(2131493648, null);
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, BluedGroupLists param1BluedGroupLists) {
      if (param1BaseViewHolder != null && param1BluedGroupLists != null) {
        this.b = (TextView)param1BaseViewHolder.d(2131301088);
        this.c = (ImageView)param1BaseViewHolder.d(2131299684);
        if (!TextUtils.isEmpty(param1BluedGroupLists.groups_name)) {
          this.b.setText(param1BluedGroupLists.groups_name);
        } else {
          this.b.setVisibility(4);
        } 
        ImageLoader.a((IRequestHost)this.a.w_(), param1BluedGroupLists.groups_avatar).a(2131234356).c().a(this.c);
      } 
    }
  }
  
  class SectionDecoration extends RecyclerView.ItemDecoration {
    private int b;
    
    private int c;
    
    private int d;
    
    private int e;
    
    private Rect f = new Rect();
    
    private Paint g = new Paint(1);
    
    private final int h = 2131100533;
    
    private final int i = 2131100544;
    
    public SectionDecoration(ShareToGroupsFragment this$0, int param1Int) {
      this.b = param1Int;
      this.c = DensityUtils.d(ShareToGroupsFragment.a(this$0), 12.0F);
      this.d = DensityUtils.a(ShareToGroupsFragment.a(this$0), 11.0F);
      this.e = DensityUtils.a(ShareToGroupsFragment.a(this$0), 15.0F);
    }
    
    private void a(Canvas param1Canvas, int param1Int1, int param1Int2, View param1View, RecyclerView.LayoutParams param1LayoutParams, int param1Int3) {
      this.g.setColor(this.a.getResources().getColor(2131100533));
      param1Canvas.drawRect(param1Int1, (param1View.getTop() - param1LayoutParams.topMargin - this.b), param1Int2, (param1View.getTop() - param1LayoutParams.topMargin), this.g);
      this.g.setTextSize(this.c);
      this.g.setColor(this.a.getResources().getColor(2131100544));
      param1Canvas.drawText(((BluedGroupLists)ShareToGroupsFragment.c(this.a).get(param1Int3)).header_name, this.e, (param1View.getTop() - param1LayoutParams.topMargin - this.b - this.d - this.c), this.g);
    }
    
    public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
      super.getItemOffsets(param1Rect, param1View, param1RecyclerView, param1State);
      int i = ((RecyclerView.LayoutParams)param1View.getLayoutParams()).getViewLayoutPosition();
      if (i > -1 && ShareToGroupsFragment.c(this.a).size() > 0) {
        if (i == 0) {
          param1Rect.set(0, this.b, 0, 0);
          return;
        } 
        if (((BluedGroupLists)ShareToGroupsFragment.c(this.a).get(i)).header_name != null && !((BluedGroupLists)ShareToGroupsFragment.c(this.a).get(i)).header_name.equals(((BluedGroupLists)ShareToGroupsFragment.c(this.a).get(i - 1)).header_name)) {
          param1Rect.set(0, this.b, 0, 0);
          return;
        } 
        param1Rect.set(0, 0, 0, 0);
      } 
    }
    
    public void onDraw(Canvas param1Canvas, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
      super.onDraw(param1Canvas, param1RecyclerView, param1State);
      int j = param1RecyclerView.getPaddingLeft();
      int k = param1RecyclerView.getWidth() - param1RecyclerView.getPaddingRight();
      int m = param1RecyclerView.getChildCount();
      int i;
      for (i = 0; i < m; i++) {
        View view = param1RecyclerView.getChildAt(i);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        int n = layoutParams.getViewLayoutPosition();
        if (n > -1 && ShareToGroupsFragment.c(this.a).size() > 0)
          if (n == 0) {
            a(param1Canvas, j, k, view, layoutParams, n);
          } else if (((BluedGroupLists)ShareToGroupsFragment.c(this.a).get(n)).header_name != null && !((BluedGroupLists)ShareToGroupsFragment.c(this.a).get(n)).header_name.equals(((BluedGroupLists)ShareToGroupsFragment.c(this.a).get(n - 1)).header_name)) {
            a(param1Canvas, j, k, view, layoutParams, n);
          }  
      } 
    }
    
    public void onDrawOver(Canvas param1Canvas, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
      int i = ((LinearLayoutManager)param1RecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      if (i >= 0) {
        if (ShareToGroupsFragment.c(this.a).size() < 1)
          return; 
        String str = ((BluedGroupLists)ShareToGroupsFragment.c(this.a).get(i)).header_name;
        this.g.setColor(this.a.getResources().getColor(2131100533));
        param1Canvas.drawRect(param1RecyclerView.getPaddingLeft(), param1RecyclerView.getPaddingTop(), (param1RecyclerView.getRight() - param1RecyclerView.getPaddingRight()), (param1RecyclerView.getPaddingTop() + this.b), this.g);
        this.g.setColor(this.a.getResources().getColor(2131100544));
        float f = this.e;
        i = param1RecyclerView.getPaddingTop();
        int j = this.b;
        param1Canvas.drawText(str, f, (i + j - j - this.d - this.c), this.g);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\ShareToGroupsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */