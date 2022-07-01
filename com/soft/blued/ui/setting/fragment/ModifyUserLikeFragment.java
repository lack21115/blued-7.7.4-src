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
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
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
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.setting.View.UserLikeToolBarView;
import com.soft.blued.ui.setting.adapter.UserLabelAdapterNew;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.ui.user.model.UserTagAll;
import java.util.ArrayList;
import java.util.List;

public class ModifyUserLikeFragment extends BaseFragment implements View.OnClickListener {
  private Context d;
  
  private View e;
  
  private Dialog f;
  
  private CustomViewPager g;
  
  private UserLikeToolBarView h;
  
  private List<String> i = new ArrayList<String>();
  
  private List<View> j = new ArrayList<View>();
  
  private LabelPagerAdapter k;
  
  private ArrayList<String> l = new ArrayList<String>();
  
  private int m;
  
  private UserLabelAdapterNew n;
  
  private UserLabelAdapterNew o;
  
  private ViewPager.OnPageChangeListener p = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
      
      public void onPageSelected(int param1Int) {
        ModifyUserLikeFragment.g(this.a).setToolBtnSelect(param1Int);
      }
    };
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, ArrayList<String> paramArrayList, int paramInt2) {
    Bundle bundle = new Bundle();
    bundle.putStringArrayList("choosedList", paramArrayList);
    bundle.putInt("position", paramInt1);
    TerminalActivity.a((Fragment)paramBaseFragment, ModifyUserLikeFragment.class, bundle, paramInt2);
  }
  
  private void l() {
    Bundle bundle = getArguments();
    if (bundle.getStringArrayList("choosedList") != null)
      this.l.addAll(bundle.getStringArrayList("choosedList")); 
    this.m = bundle.getInt("position");
    for (String str : this.d.getResources().getStringArray(2130903113))
      this.i.add(str); 
  }
  
  private void m() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.setCenterText(getString(2131756388));
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.setRightClickListener(this);
    commonTopTitleNoTrans.setRightText(2131756206);
    commonTopTitleNoTrans.setRightTextColor(2131100838);
  }
  
  private void n() {
    this.f = DialogUtils.a((Context)getActivity());
    this.h = (UserLikeToolBarView)this.e.findViewById(2131301577);
    this.g = (CustomViewPager)this.e.findViewById(2131301672);
    this.g.setOnPageChangeListener(this.p);
    this.k = new LabelPagerAdapter(this);
    this.g.setAdapter(this.k);
    this.g.setCurrentItem(this.m);
    this.h.setOnToolBarItemClickListener(new UserLikeToolBarView.OnToolBarItemClickListener(this) {
          public void a(int param1Int) {
            ModifyUserLikeFragment.a(this.a).setCurrentItem(param1Int);
          }
        });
    this.n = new UserLabelAdapterNew(this.d);
    this.o = new UserLabelAdapterNew(this.d);
    this.n.a(new UserLabelAdapterNew.OnItemClickListener(this) {
          public void a(UserTag param1UserTag, int param1Int) {
            if (((UserTag)param1UserTag.tagList.get(param1Int)).chooseable) {
              if (((UserTag)param1UserTag.tagList.get(param1Int)).checked == 1) {
                ((UserTag)param1UserTag.tagList.get(param1Int)).checked = 0;
              } else {
                ModifyUserLikeFragment modifyUserLikeFragment = this.a;
                int i = modifyUserLikeFragment.a(ModifyUserLikeFragment.b(modifyUserLikeFragment));
                if (i < 5) {
                  ((UserTag)param1UserTag.tagList.get(param1Int)).checked = 1;
                } else if (i == 5) {
                  AppMethods.d(2131757866);
                } 
              } 
              ModifyUserLikeFragment.b(this.a).notifyDataSetChanged();
            } 
          }
        });
    this.o.a(new UserLabelAdapterNew.OnItemClickListener(this) {
          public void a(UserTag param1UserTag, int param1Int) {
            if (((UserTag)param1UserTag.tagList.get(param1Int)).chooseable) {
              if (((UserTag)param1UserTag.tagList.get(param1Int)).checked == 1) {
                ((UserTag)param1UserTag.tagList.get(param1Int)).checked = 0;
              } else {
                ModifyUserLikeFragment modifyUserLikeFragment = this.a;
                int i = modifyUserLikeFragment.a(ModifyUserLikeFragment.c(modifyUserLikeFragment));
                if (i < 5) {
                  ((UserTag)param1UserTag.tagList.get(param1Int)).checked = 1;
                } else if (i == 5) {
                  AppMethods.d(2131757866);
                } 
              } 
              ModifyUserLikeFragment.c(this.a).notifyDataSetChanged();
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
  
  public ArrayList<String> a(int paramInt) {
    List<UserTag> list = new ArrayList();
    if (paramInt != 0) {
      if (paramInt == 1)
        List list1 = this.o.n(); 
    } else {
      list = this.n.n();
    } 
    ArrayList<String> arrayList = new ArrayList();
    for (paramInt = 0; paramInt < list.size(); paramInt++) {
      UserTag userTag = list.get(paramInt);
      if (userTag != null && userTag.tagList != null)
        for (UserTag userTag1 : userTag.tagList) {
          if (userTag1.checked == 1)
            arrayList.add(userTag1.name); 
        }  
    } 
    return arrayList;
  }
  
  public void a() {
    FindHttpUtils.a(this.d, new BluedUIHttpResponse<BluedEntityA<UserTagAll>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<UserTagAll> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              List<UserTag> list2 = ((UserTagAll)param1BluedEntityA.data.get(0)).love_type;
              List<UserTag> list1 = ((UserTagAll)param1BluedEntityA.data.get(0)).love_character;
              ModifyUserLikeFragment modifyUserLikeFragment = this.a;
              modifyUserLikeFragment.a(ModifyUserLikeFragment.h(modifyUserLikeFragment), list2);
              modifyUserLikeFragment = this.a;
              modifyUserLikeFragment.a(ModifyUserLikeFragment.h(modifyUserLikeFragment), list1);
              ModifyUserLikeFragment.b(this.a).a(new UserTag(list2));
              ModifyUserLikeFragment.c(this.a).a(new UserTag(list1));
            } 
          }
          
          public void onUIFinish() {
            DialogUtils.b(ModifyUserLikeFragment.i(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ModifyUserLikeFragment.i(this.a));
          }
        }(IRequestHost)w_());
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
  
  public void k() {
    int j;
    this.l.clear();
    byte b = 0;
    int i = 0;
    while (true) {
      j = b;
      if (i < this.n.n().size()) {
        UserTag userTag = this.n.n().get(i);
        if (userTag != null && userTag.tagList != null)
          for (UserTag userTag1 : userTag.tagList) {
            if (userTag1.checked == 1)
              this.l.add(userTag1.id); 
          }  
        i++;
        continue;
      } 
      break;
    } 
    while (j < this.o.n().size()) {
      UserTag userTag = this.o.n().get(j);
      if (userTag != null && userTag.tagList != null)
        for (UserTag userTag1 : userTag.tagList) {
          if (userTag1.checked == 1)
            this.l.add(userTag1.id); 
        }  
      j++;
    } 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      k();
      Intent intent = new Intent();
      intent.putExtra("choosed_like_list", this.l);
      intent.putExtra("choosed_like_shape_list_name", a(0));
      intent.putExtra("choosed_like_personality_list_name", a(1));
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
      this.e = paramLayoutInflater.inflate(2131493339, paramViewGroup, false);
      l();
      n();
      m();
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  class LabelPagerAdapter extends PagerAdapter {
    LabelPagerAdapter(ModifyUserLikeFragment this$0) {}
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return ModifyUserLikeFragment.d(this.a).size();
    }
    
    public int getItemPosition(Object param1Object) {
      return -2;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      while (ModifyUserLikeFragment.e(this.a).size() < ModifyUserLikeFragment.d(this.a).size()) {
        View view1 = LayoutInflater.from(ModifyUserLikeFragment.f(this.a)).inflate(2131494214, param1ViewGroup, false);
        ModifyUserLikeFragment.e(this.a).add(view1);
      } 
      View view = ModifyUserLikeFragment.e(this.a).get(param1Int);
      PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView)view.findViewById(2131301573);
      RecyclerView recyclerView = (RecyclerView)pullToRefreshRecyclerView.getRefreshableView();
      recyclerView.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(ModifyUserLikeFragment.f(this.a), 1));
      pullToRefreshRecyclerView.setRefreshEnabled(false);
      if (param1Int != 0) {
        if (param1Int == 1 && recyclerView.getAdapter() == null)
          recyclerView.setAdapter((RecyclerView.Adapter)ModifyUserLikeFragment.c(this.a)); 
      } else if (recyclerView.getAdapter() == null) {
        recyclerView.setAdapter((RecyclerView.Adapter)ModifyUserLikeFragment.b(this.a));
      } 
      if (view.getParent() != null)
        ((ViewGroup)view.getParent()).removeView(view); 
      param1ViewGroup.addView(ModifyUserLikeFragment.e(this.a).get(param1Int));
      return view;
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\ModifyUserLikeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */