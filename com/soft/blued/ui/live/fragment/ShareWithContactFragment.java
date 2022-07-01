package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.listener.SessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.soft.blued.BluedConstant;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.SearchView;
import com.soft.blued.ui.live.adapter.ShareWithContactAdapter;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class ShareWithContactFragment extends BaseFragment implements View.OnClickListener {
  public ShareWithContactAdapter d;
  
  private Context e;
  
  private View f;
  
  private RenrenPullToRefreshListView g;
  
  private ListView h;
  
  private List<SessionModel> i;
  
  private LayoutInflater j;
  
  private int k;
  
  private int l = 10;
  
  private boolean m = true;
  
  private TextView n;
  
  private CommonTopTitleNoTrans o;
  
  private SearchView p;
  
  private SearchEditText q;
  
  private LinearLayout r;
  
  private LinearLayout s;
  
  private int t = 1;
  
  private String u = "";
  
  private ArrayList<String> v = new ArrayList<String>();
  
  private ShareWithContactSessionListener w = new ShareWithContactSessionListener();
  
  private void a() {
    this.o = (CommonTopTitleNoTrans)this.f.findViewById(2131300300);
    this.o.setCenterText(getString(2131755606));
    this.o.setLeftText(2131755726);
    this.o.setRightText(2131756206);
    this.o.setRightTextColor(2131100838);
    this.o.setLeftClickListener(this);
    this.o.setRightClickListener(this);
    if (this.t == 1)
      this.o.a(); 
  }
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, int paramInt2, String paramString, String[] paramArrayOfString) {
    Bundle bundle = new Bundle();
    bundle.putInt("maxCount", paramInt2);
    bundle.putString("bottomHintStr", paramString);
    ArrayList<String> arrayList = new ArrayList();
    if (paramArrayOfString != null && paramArrayOfString.length > 0)
      for (paramInt2 = 0; paramInt2 < paramArrayOfString.length; paramInt2++)
        arrayList.add(paramArrayOfString[paramInt2]);  
    if (arrayList.size() > 0)
      bundle.putStringArrayList("selectedIDS", arrayList); 
    TerminalActivity.a((Fragment)paramBaseFragment, ShareWithContactFragment.class, bundle, paramInt1);
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.k = 1; 
    if (this.k == 1)
      this.m = true; 
    if (!this.m) {
      int i = this.k;
      if (i != 1) {
        this.k = i - 1;
        AppMethods.a(this.e.getResources().getString(2131756083));
        this.g.j();
        this.g.q();
      } 
    } 
  }
  
  private void k() {
    this.s = (LinearLayout)this.f.findViewById(2131298878);
    this.s.setOnClickListener(this);
    if (LiveRoomPreferences.F()) {
      this.s.setVisibility(8);
    } else {
      this.s.setVisibility(4);
    } 
    this.n = (TextView)this.f.findViewById(2131300893);
    if (StringUtils.e(this.u)) {
      this.s.setVisibility(8);
    } else {
      this.s.setVisibility(0);
      this.s.startAnimation(AnimationUtils.loadAnimation(this.e, 2130772053));
      this.n.setText(this.u);
    } 
    this.r = (LinearLayout)this.f.findViewById(2131298986);
    this.g = (RenrenPullToRefreshListView)this.f.findViewById(2131298144);
    this.g.setRefreshEnabled(true);
    this.h = (ListView)this.g.getRefreshableView();
    this.h.setClipToPadding(false);
    this.h.setScrollBarStyle(33554432);
    this.h.setHeaderDividersEnabled(false);
    this.h.setDividerHeight(0);
    this.g.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            ShareWithContactFragment.a(this.a, 1);
            ShareWithContactFragment.a(this.a, false);
          }
          
          public void b() {
            ShareWithContactFragment.a(this.a);
            ShareWithContactFragment.a(this.a, false);
          }
        });
    this.g.setRefreshEnabled(false);
    this.j = LayoutInflater.from((Context)getActivity());
    this.p = (SearchView)this.j.inflate(2131494102, null);
    this.q = this.p.getEditView();
    this.p.setDelaymillis(0L);
    this.p.setOnSearchInfoListener(new SearchView.OnSearchInfoListener(this) {
          public void a() {
            ShareWithContactFragment.a(this.a, 1);
            ShareWithContactFragment.a(this.a, false);
          }
          
          public void a(String param1String) {
            this.a.d.a(param1String);
            this.a.d.notifyDataSetChanged();
          }
          
          public void b() {}
        });
    this.g.setOnScrollListener(new AbsListView.OnScrollListener(this) {
          public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {
            ShareWithContactFragment.b(this.a).clearFocus();
          }
        });
    this.h.addHeaderView((View)this.p);
  }
  
  private void l() {
    RenrenPullToRefreshListView renrenPullToRefreshListView = this.g;
    if (renrenPullToRefreshListView != null)
      renrenPullToRefreshListView.j(); 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867) {
        if (i != 2131298878)
          return; 
        this.s.setVisibility(8);
        LiveRoomPreferences.c(true);
        this.s.startAnimation(AnimationUtils.loadAnimation(this.e, 2130772054));
        return;
      } 
      Intent intent = new Intent();
      ArrayList<String> arrayList1 = new ArrayList();
      ArrayList<String> arrayList2 = new ArrayList();
      for (i = 0; i < this.i.size(); i++) {
        if (((SessionModel)this.i.get(i)).checked) {
          arrayList1.add(String.valueOf(((SessionModel)this.i.get(i)).sessionId));
          arrayList2.add(String.valueOf(((SessionModel)this.i.get(i)).sessionType));
        } 
      } 
      intent.putExtra("CHOOSED_UID", arrayList1.<String>toArray(new String[arrayList1.size()]));
      intent.putExtra("CHOOSED_TYPE", arrayList2.<String>toArray(new String[arrayList2.size()]));
      getActivity().setResult(-1, intent);
      getActivity().finish();
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    this.i = new ArrayList<SessionModel>();
    View view = this.f;
    if (view == null) {
      this.f = paramLayoutInflater.inflate(2131493317, paramViewGroup, false);
      if (getArguments() != null) {
        this.t = getArguments().getInt("maxCount");
        this.u = getArguments().getString("bottomHintStr");
        this.v = getArguments().getStringArrayList("selectedIDS");
      } 
      k();
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.f.getParent()).removeView(this.f);
    } 
    return this.f;
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.i.clear();
  }
  
  public void onStart() {
    super.onStart();
    ChatManager.getInstance().registerSessionListener((SessionListener)this.w);
  }
  
  public void onStop() {
    super.onStop();
    ChatManager.getInstance().unregisterSessionListener((SessionListener)this.w);
  }
  
  class ShareWithContactSessionListener extends StableSessionListListener {
    private ShareWithContactSessionListener(ShareWithContactFragment this$0) {}
    
    public void onUISessionDataChanged(List<SessionModel> param1List) {
      ChatHelperV4.c(param1List);
      if (ShareWithContactFragment.c(this.a).size() == 0) {
        ShareWithContactFragment.c(this.a).clear();
        List<SessionModel> list = param1List;
        if (param1List == null)
          list = new ArrayList<SessionModel>(); 
        for (int i = 0; i < list.size(); i++) {
          SessionModel sessionModel = list.get(i);
          sessionModel.checked = false;
          if (ShareWithContactFragment.d(this.a) != null && ShareWithContactFragment.d(this.a).size() > 0)
            for (int j = 0; j < ShareWithContactFragment.d(this.a).size(); j++) {
              if (((String)ShareWithContactFragment.d(this.a).get(j)).equals(String.valueOf(sessionModel.sessionId)))
                sessionModel.checked = true; 
            }  
          if (sessionModel.sessionType == 2) {
            ShareWithContactFragment.c(this.a).add(sessionModel);
          } else if (sessionModel.sessionType == 3 && !BluedConstant.a) {
            ShareWithContactFragment.c(this.a).add(sessionModel);
          } 
        } 
        ShareWithContactFragment shareWithContactFragment = this.a;
        shareWithContactFragment.d = new ShareWithContactAdapter((IRequestHost)shareWithContactFragment.w_(), ShareWithContactFragment.e(this.a), ShareWithContactFragment.c(this.a), ShareWithContactFragment.f(this.a));
        ShareWithContactFragment.g(this.a).setAdapter((ListAdapter)this.a.d);
        this.a.d.notifyDataSetChanged();
        if (ShareWithContactFragment.c(this.a).size() > 0) {
          if (ShareWithContactFragment.h(this.a) != null)
            ShareWithContactFragment.h(this.a).setVisibility(8); 
        } else if (ShareWithContactFragment.h(this.a) != null) {
          ShareWithContactFragment.h(this.a).setVisibility(0);
        } 
        ShareWithContactFragment.i(this.a);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\ShareWithContactFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */