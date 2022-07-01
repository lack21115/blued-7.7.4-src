package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.SearchTaskTool;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.setting.adapter.GoodFriendsListAdapter;
import com.soft.blued.ui.setting.model.BluedBlackList;
import java.util.List;

public class FriendslistFragment extends PreloadFragment implements View.OnClickListener, SearchTaskTool.TaskListener {
  private TextView A;
  
  private SearchEditText B;
  
  private NoDataAndLoadFailView C;
  
  BluedUIHttpResponse o = new BluedUIHttpResponse<BluedEntityA<BluedBlackList>>(this) {
      boolean a;
      
      protected BluedEntityA<BluedBlackList> a(String param1String) {
        return (BluedEntityA<BluedBlackList>)super.parseData(param1String);
      }
      
      public void a(BluedEntityA<BluedBlackList> param1BluedEntityA) {
        if (param1BluedEntityA != null)
          try {
            if (param1BluedEntityA.hasMore()) {
              FriendslistFragment.b(this.b, true);
              FriendslistFragment.a(this.b).o();
            } else {
              FriendslistFragment.b(this.b, false);
              FriendslistFragment.a(this.b).p();
            } 
          } catch (Exception exception) {} 
        if (exception != null && ((BluedEntityA)exception).data != null && ((BluedEntityA)exception).data.size() > 0) {
          if (FriendslistFragment.e(this.b) == 1) {
            FriendslistFragment.d(this.b).a(((BluedEntityA)exception).data, "");
            FriendslistFragment.a(this.b, ((BluedEntityA)exception).data);
            return;
          } 
          FriendslistFragment.d(this.b).b(((BluedEntityA)exception).data, "");
          FriendslistFragment.f(this.b).addAll(((BluedEntityA)exception).data);
          return;
        } 
        if (FriendslistFragment.e(this.b) == 1) {
          FriendslistFragment.d(this.b).a(((BluedEntityA)exception).data, "");
          FriendslistFragment.a(this.b, ((BluedEntityA)exception).data);
        } 
        if (FriendslistFragment.e(this.b) != 1) {
          FriendslistFragment.g(this.b);
          FriendslistFragment.b(this.b, false);
          FriendslistFragment.a(this.b).p();
          FriendslistFragment.a(this.b).j();
          FriendslistFragment.a(this.b).q();
        } 
        if (FriendslistFragment.f(this.b).size() != 0) {
          AppMethods.a(FriendslistFragment.h(this.b).getResources().getString(2131756083));
          return;
        } 
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        if (FriendslistFragment.e(this.b) != 1)
          FriendslistFragment.g(this.b); 
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        FriendslistFragment.a(this.b).j();
        FriendslistFragment.a(this.b).q();
        if (FriendslistFragment.f(this.b) == null || FriendslistFragment.f(this.b).size() == 0) {
          FriendslistFragment.a(this.b).setVisibility(8);
          if (this.a) {
            FriendslistFragment.i(this.b).b();
          } else {
            FriendslistFragment.i(this.b).a();
          } 
        } else {
          FriendslistFragment.a(this.b).setVisibility(0);
          FriendslistFragment.i(this.b).c();
        } 
        FriendslistFragment.d(this.b).notifyDataSetChanged();
        this.a = false;
      }
    };
  
  private Context p;
  
  private View q;
  
  private RenrenPullToRefreshListView r;
  
  private ListView s;
  
  private List<BluedBlackList> t;
  
  private LayoutInflater u;
  
  private GoodFriendsListAdapter v;
  
  private int w;
  
  private int x = 20;
  
  private boolean y = true;
  
  private TextView z;
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.w = 1; 
    if (this.w == 1)
      this.y = true; 
    if (!this.y) {
      int i = this.w;
      if (i != 1) {
        this.w = i - 1;
        AppMethods.a(this.p.getResources().getString(2131756083));
        this.r.j();
        this.r.q();
        return;
      } 
    } 
    Context context = this.p;
    BluedUIHttpResponse bluedUIHttpResponse = this.o;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.w);
    stringBuilder1.append("");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.x);
    stringBuilder2.append("");
    MineHttpUtils.b(context, bluedUIHttpResponse, str, stringBuilder2.toString(), (IRequestHost)w_());
  }
  
  private void b(String paramString) {
    MineHttpUtils.b(this.p, new BluedUIHttpResponse<BluedEntityA<BluedBlackList>>(this) {
          protected void a(BluedEntityA<BluedBlackList> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              GoodFriendsListAdapter goodFriendsListAdapter = FriendslistFragment.d(this.a);
              List list = param1BluedEntityA.data;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(FriendslistFragment.c(this.a).getText());
              stringBuilder.append("");
              goodFriendsListAdapter.a(list, stringBuilder.toString());
            } else {
              FriendslistFragment.d(this.a).a(null, "");
            } 
            FriendslistFragment.a(this.a).p();
          }
        }paramString, (IRequestHost)w_());
  }
  
  private void t() {
    this.C = (NoDataAndLoadFailView)this.q.findViewById(2131298986);
    this.r = (RenrenPullToRefreshListView)this.q.findViewById(2131298144);
    this.r.setRefreshEnabled(true);
    this.s = (ListView)this.r.getRefreshableView();
    this.s.setClipToPadding(false);
    this.s.setScrollBarStyle(33554432);
    this.s.setHeaderDividersEnabled(false);
    this.s.setDividerHeight(0);
    this.r.postDelayed(new Runnable(this) {
          public void run() {
            FriendslistFragment.a(this.a).k();
          }
        },  100L);
    this.v = new GoodFriendsListAdapter(this.p, (IRequestHost)w_());
    this.r.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            FriendslistFragment.a(this.a, 1);
            FriendslistFragment.a(this.a, false);
          }
          
          public void b() {
            FriendslistFragment.b(this.a);
            FriendslistFragment.a(this.a, false);
          }
        });
    this.s.setAdapter((ListAdapter)this.v);
  }
  
  public void a(View paramView) {
    this.p = (Context)getActivity();
    this.q = paramView;
    this.u = LayoutInflater.from(this.p);
    View view = this.u.inflate(2131493242, null);
    ((ViewGroup)paramView).addView(view);
    t();
  }
  
  public void a(String paramString) {
    try {
      if (paramString.length() == 0) {
        this.w = 1;
        a(false);
        return;
      } 
      this.A.setVisibility(0);
      this.z.setVisibility(0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("");
      b(stringBuilder.toString());
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131301302)
        return; 
      this.A.setVisibility(8);
      this.z.setVisibility(8);
      this.B.setText("");
      AppMethods.a((View)this.B);
      this.B.clearFocus();
      this.w = 1;
      a(false);
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\FriendslistFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */