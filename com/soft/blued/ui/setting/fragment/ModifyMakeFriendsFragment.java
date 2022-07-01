package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.setting.adapter.UserLabelAdapterNew;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.ui.user.model.UserTagAll;
import java.util.ArrayList;
import java.util.List;

public class ModifyMakeFriendsFragment extends BaseFragment implements View.OnClickListener {
  private Context d;
  
  private View e;
  
  private PullToRefreshRecyclerView f;
  
  private UserLabelAdapterNew g;
  
  private Dialog h;
  
  private List<UserTag> i = new ArrayList<UserTag>();
  
  private ArrayList<String> j = new ArrayList<String>();
  
  public static void a(BaseFragment paramBaseFragment, ArrayList<String> paramArrayList, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putStringArrayList("choosedList", paramArrayList);
    TerminalActivity.a((Fragment)paramBaseFragment, ModifyMakeFriendsFragment.class, bundle, paramInt);
  }
  
  private void m() {
    Bundle bundle = getArguments();
    if (bundle != null && bundle.getStringArrayList("choosedList") != null)
      this.j.addAll(bundle.getStringArrayList("choosedList")); 
  }
  
  private void n() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.setCenterText(getString(2131757836));
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.setRightClickListener(this);
    commonTopTitleNoTrans.setRightText(2131756206);
    commonTopTitleNoTrans.e();
    commonTopTitleNoTrans.setRightTextColor(2131100838);
  }
  
  private void o() {
    this.h = DialogUtils.a((Context)getActivity());
    this.f = (PullToRefreshRecyclerView)this.e.findViewById(2131297349);
    RecyclerView recyclerView = (RecyclerView)this.f.getRefreshableView();
    this.f.setRefreshEnabled(false);
    recyclerView.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(this.d, 1));
    this.g = new UserLabelAdapterNew(this.d);
    recyclerView.setAdapter((RecyclerView.Adapter)this.g);
    this.g.a(new UserLabelAdapterNew.OnItemClickListener(this) {
          public void a(UserTag param1UserTag, int param1Int) {
            if (((UserTag)param1UserTag.tagList.get(param1Int)).chooseable) {
              if (((UserTag)param1UserTag.tagList.get(param1Int)).checked == 1) {
                ((UserTag)param1UserTag.tagList.get(param1Int)).checked = 0;
              } else {
                ModifyMakeFriendsFragment modifyMakeFriendsFragment = this.a;
                int i = modifyMakeFriendsFragment.a(ModifyMakeFriendsFragment.a(modifyMakeFriendsFragment));
                if (i < 5) {
                  ((UserTag)param1UserTag.tagList.get(param1Int)).checked = 1;
                } else if (i == 5) {
                  AppMethods.d(2131757866);
                } 
              } 
              ModifyMakeFriendsFragment.a(this.a).notifyDataSetChanged();
            } 
          }
        });
  }
  
  public int a(UserLabelAdapterNew paramUserLabelAdapterNew) {
    List<UserTag> list = paramUserLabelAdapterNew.n();
    int j = 0;
    int i;
    for (i = 0; j < list.size(); i = k) {
      UserTag userTag = list.get(j);
      int k = i;
      if (userTag != null) {
        k = i;
        if (userTag.tagList != null) {
          k = 0;
          while (k < userTag.tagList.size()) {
            int m = i;
            if (((UserTag)userTag.tagList.get(k)).checked == 1)
              m = i + 1; 
            k++;
            i = m;
          } 
          k = i;
        } 
      } 
      j++;
    } 
    return i;
  }
  
  public void a() {
    this.j.clear();
    for (int i = 0; i < this.g.n().size(); i++) {
      UserTag userTag = this.g.n().get(i);
      if (userTag != null && userTag.tagList != null)
        for (UserTag userTag1 : userTag.tagList) {
          if (userTag1.checked == 1)
            this.j.add(userTag1.id); 
        }  
    } 
  }
  
  public void a(ArrayList<String> paramArrayList, List<UserTag> paramList) {
    if (paramArrayList != null && paramArrayList.size() > 0 && paramList != null) {
      int i;
      for (i = 0; i < paramList.size(); i++)
        ((UserTag)paramList.get(i)).checked = 0; 
      for (i = 0; i < paramArrayList.size(); i++) {
        String str = paramArrayList.get(i);
        int j;
        for (j = 0; j < paramList.size(); j++) {
          UserTag userTag = paramList.get(j);
          if (userTag != null && TextUtils.equals(userTag.id, str))
            userTag.checked = 1; 
        } 
      } 
    } 
  }
  
  public ArrayList<String> k() {
    List<UserTag> list = this.g.n();
    ArrayList<String> arrayList = new ArrayList();
    for (int i = 0; i < list.size(); i++) {
      UserTag userTag = list.get(i);
      if (userTag != null && userTag.tagList != null)
        for (UserTag userTag1 : userTag.tagList) {
          if (userTag1.checked == 1)
            arrayList.add(userTag1.name); 
        }  
    } 
    return arrayList;
  }
  
  public void l() {
    FindHttpUtils.a(this.d, new BluedUIHttpResponse<BluedEntityA<UserTagAll>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<UserTagAll> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              ModifyMakeFriendsFragment.a(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).i_want);
              ModifyMakeFriendsFragment modifyMakeFriendsFragment = this.a;
              modifyMakeFriendsFragment.a(ModifyMakeFriendsFragment.b(modifyMakeFriendsFragment), ModifyMakeFriendsFragment.c(this.a));
              ModifyMakeFriendsFragment.a(this.a).a(new UserTag(ModifyMakeFriendsFragment.c(this.a)));
            } 
          }
          
          public void onUIFinish() {
            DialogUtils.b(ModifyMakeFriendsFragment.d(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ModifyMakeFriendsFragment.d(this.a));
          }
        }(IRequestHost)w_());
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      a();
      Intent intent = new Intent();
      intent.putExtra("choosed_make_friends_list", this.j);
      intent.putExtra("CHOOSED_MAKE_FRIENDS_LIST_NAME", k());
      getActivity().setResult(-1, intent);
      getActivity().finish();
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493340, paramViewGroup, false);
      m();
      o();
      n();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\ModifyMakeFriendsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */