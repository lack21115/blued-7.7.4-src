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
import com.soft.blued.ui.setting.View.UserLabelToolBarView;
import com.soft.blued.ui.setting.adapter.UserLabelAdapterNew;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.ui.user.model.UserTagAll;
import java.util.ArrayList;
import java.util.List;

public class ModifyUserLabelFragment extends BaseFragment implements View.OnClickListener {
  private Context d;
  
  private View e;
  
  private Dialog f;
  
  private CustomViewPager g;
  
  private UserLabelToolBarView h;
  
  private List<String> i = new ArrayList<String>();
  
  private List<View> j = new ArrayList<View>();
  
  private LabelPagerAdapter k;
  
  private ArrayList<String> l = new ArrayList<String>();
  
  private int m;
  
  private UserLabelAdapterNew n;
  
  private UserLabelAdapterNew o;
  
  private UserLabelAdapterNew p;
  
  private UserLabelAdapterNew q;
  
  private ViewPager.OnPageChangeListener r = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
      
      public void onPageSelected(int param1Int) {
        ModifyUserLabelFragment.i(this.a).setToolBtnSelect(param1Int);
      }
    };
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, ArrayList<String> paramArrayList, int paramInt2) {
    Bundle bundle = new Bundle();
    bundle.putStringArrayList("choosedList", paramArrayList);
    bundle.putInt("position", paramInt1);
    TerminalActivity.a((Fragment)paramBaseFragment, ModifyUserLabelFragment.class, bundle, paramInt2);
  }
  
  private void l() {
    Bundle bundle = getArguments();
    if (bundle.getStringArrayList("choosedList") != null)
      this.l.addAll(bundle.getStringArrayList("choosedList")); 
    this.m = bundle.getInt("position");
    for (String str : this.d.getResources().getStringArray(2130903112))
      this.i.add(str); 
  }
  
  private void m() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.setCenterText(getString(2131758168));
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.setRightClickListener(this);
    commonTopTitleNoTrans.setRightText(2131756206);
    commonTopTitleNoTrans.e();
    commonTopTitleNoTrans.setCenterTextColor(2131100838);
    commonTopTitleNoTrans.setRightTextColor(2131100838);
  }
  
  private void n() {
    this.f = DialogUtils.a((Context)getActivity());
    this.h = (UserLabelToolBarView)this.e.findViewById(2131301576);
    this.g = (CustomViewPager)this.e.findViewById(2131301672);
    this.g.setOnPageChangeListener(this.r);
    this.k = new LabelPagerAdapter(this);
    this.g.setAdapter(this.k);
    this.g.setCurrentItem(this.m);
    this.h.setOnToolBarItemClickListener(new UserLabelToolBarView.OnToolBarItemClickListener(this) {
          public void a(int param1Int) {
            ModifyUserLabelFragment.a(this.a).setCurrentItem(param1Int);
          }
        });
    this.n = new UserLabelAdapterNew(this.d);
    this.o = new UserLabelAdapterNew(this.d);
    this.p = new UserLabelAdapterNew(this.d);
    this.q = new UserLabelAdapterNew(this.d);
    this.n.a(new UserLabelAdapterNew.OnItemClickListener(this) {
          public void a(UserTag param1UserTag, int param1Int) {
            if (((UserTag)param1UserTag.tagList.get(param1Int)).chooseable) {
              if (((UserTag)param1UserTag.tagList.get(param1Int)).checked == 1) {
                ((UserTag)param1UserTag.tagList.get(param1Int)).checked = 0;
              } else {
                ((UserTag)param1UserTag.tagList.get(param1Int)).checked = 1;
                for (int i = 0; i < param1UserTag.tagList.size(); i++) {
                  if (i != param1Int)
                    ((UserTag)param1UserTag.tagList.get(i)).checked = 0; 
                } 
              } 
              ModifyUserLabelFragment.b(this.a).notifyDataSetChanged();
            } 
          }
        });
    this.o.a(new UserLabelAdapterNew.OnItemClickListener(this) {
          public void a(UserTag param1UserTag, int param1Int) {
            if (((UserTag)param1UserTag.tagList.get(param1Int)).chooseable) {
              if (((UserTag)param1UserTag.tagList.get(param1Int)).checked == 1) {
                ((UserTag)param1UserTag.tagList.get(param1Int)).checked = 0;
              } else {
                ModifyUserLabelFragment modifyUserLabelFragment = this.a;
                int i = modifyUserLabelFragment.a(ModifyUserLabelFragment.c(modifyUserLabelFragment));
                if (i < 5) {
                  ((UserTag)param1UserTag.tagList.get(param1Int)).checked = 1;
                } else if (i == 5) {
                  AppMethods.d(2131757866);
                } 
              } 
              this.a.a(param1UserTag.tagList.get(param1Int), param1UserTag.tagList);
              ModifyUserLabelFragment.c(this.a).notifyDataSetChanged();
            } 
          }
        });
    this.p.a(new UserLabelAdapterNew.OnItemClickListener(this) {
          public void a(UserTag param1UserTag, int param1Int) {
            if (((UserTag)param1UserTag.tagList.get(param1Int)).chooseable) {
              if (((UserTag)param1UserTag.tagList.get(param1Int)).checked == 1) {
                ((UserTag)param1UserTag.tagList.get(param1Int)).checked = 0;
              } else {
                ModifyUserLabelFragment modifyUserLabelFragment = this.a;
                int i = modifyUserLabelFragment.a(ModifyUserLabelFragment.d(modifyUserLabelFragment));
                if (i < 5) {
                  ((UserTag)param1UserTag.tagList.get(param1Int)).checked = 1;
                } else if (i == 5) {
                  AppMethods.d(2131757866);
                } 
              } 
              ModifyUserLabelFragment.d(this.a).notifyDataSetChanged();
            } 
          }
        });
    this.q.a(new UserLabelAdapterNew.OnItemClickListener(this) {
          public void a(UserTag param1UserTag, int param1Int) {
            if (((UserTag)param1UserTag.tagList.get(param1Int)).chooseable) {
              if (((UserTag)param1UserTag.tagList.get(param1Int)).checked == 1) {
                ((UserTag)param1UserTag.tagList.get(param1Int)).checked = 0;
              } else {
                ModifyUserLabelFragment modifyUserLabelFragment = this.a;
                int i = modifyUserLabelFragment.a(ModifyUserLabelFragment.e(modifyUserLabelFragment));
                if (i < 5) {
                  ((UserTag)param1UserTag.tagList.get(param1Int)).checked = 1;
                } else if (i == 5) {
                  AppMethods.d(2131757866);
                } 
              } 
              ModifyUserLabelFragment.e(this.a).notifyDataSetChanged();
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
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt == 3)
            List list1 = this.q.n(); 
        } else {
          List list1 = this.p.n();
        } 
      } else {
        List list1 = this.o.n();
      } 
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
              List<UserTag> list6 = ((UserTagAll)param1BluedEntityA.data.get(0)).sports;
              List<UserTag> list7 = ((UserTagAll)param1BluedEntityA.data.get(0)).art;
              List<UserTag> list8 = ((UserTagAll)param1BluedEntityA.data.get(0)).leisure;
              List<UserTag> list9 = ((UserTagAll)param1BluedEntityA.data.get(0)).food;
              List<UserTag> list10 = ((UserTagAll)param1BluedEntityA.data.get(0)).fashion;
              List<UserTag> list11 = ((UserTagAll)param1BluedEntityA.data.get(0)).collection;
              List<UserTag> list12 = ((UserTagAll)param1BluedEntityA.data.get(0)).pets;
              List<UserTag> list13 = ((UserTagAll)param1BluedEntityA.data.get(0)).technology;
              List<UserTag> list2 = ((UserTagAll)param1BluedEntityA.data.get(0)).books;
              List<UserTag> list3 = ((UserTagAll)param1BluedEntityA.data.get(0)).movies;
              List<UserTag> list4 = ((UserTagAll)param1BluedEntityA.data.get(0)).music;
              List<UserTag> list5 = ((UserTagAll)param1BluedEntityA.data.get(0)).type;
              List<UserTag> list1 = ((UserTagAll)param1BluedEntityA.data.get(0)).character;
              ModifyUserLabelFragment modifyUserLabelFragment = this.a;
              modifyUserLabelFragment.a(ModifyUserLabelFragment.j(modifyUserLabelFragment), list5);
              modifyUserLabelFragment = this.a;
              modifyUserLabelFragment.a(ModifyUserLabelFragment.j(modifyUserLabelFragment), list1);
              modifyUserLabelFragment = this.a;
              modifyUserLabelFragment.a(ModifyUserLabelFragment.j(modifyUserLabelFragment), list6);
              modifyUserLabelFragment = this.a;
              modifyUserLabelFragment.a(ModifyUserLabelFragment.j(modifyUserLabelFragment), list7);
              modifyUserLabelFragment = this.a;
              modifyUserLabelFragment.a(ModifyUserLabelFragment.j(modifyUserLabelFragment), list8);
              modifyUserLabelFragment = this.a;
              modifyUserLabelFragment.a(ModifyUserLabelFragment.j(modifyUserLabelFragment), list9);
              modifyUserLabelFragment = this.a;
              modifyUserLabelFragment.a(ModifyUserLabelFragment.j(modifyUserLabelFragment), list10);
              modifyUserLabelFragment = this.a;
              modifyUserLabelFragment.a(ModifyUserLabelFragment.j(modifyUserLabelFragment), list11);
              modifyUserLabelFragment = this.a;
              modifyUserLabelFragment.a(ModifyUserLabelFragment.j(modifyUserLabelFragment), list12);
              modifyUserLabelFragment = this.a;
              modifyUserLabelFragment.a(ModifyUserLabelFragment.j(modifyUserLabelFragment), list13);
              modifyUserLabelFragment = this.a;
              modifyUserLabelFragment.a(ModifyUserLabelFragment.j(modifyUserLabelFragment), list2);
              modifyUserLabelFragment = this.a;
              modifyUserLabelFragment.a(ModifyUserLabelFragment.j(modifyUserLabelFragment), list3);
              modifyUserLabelFragment = this.a;
              modifyUserLabelFragment.a(ModifyUserLabelFragment.j(modifyUserLabelFragment), list4);
              ArrayList<UserTag> arrayList = new ArrayList();
              arrayList.add(new UserTag(ModifyUserLabelFragment.h(this.a).getResources().getString(2131758804), 1));
              arrayList.add(new UserTag(list6));
              arrayList.add(new UserTag(ModifyUserLabelFragment.h(this.a).getResources().getString(2131755354), 1));
              arrayList.add(new UserTag(list7));
              arrayList.add(new UserTag(ModifyUserLabelFragment.h(this.a).getResources().getString(2131757111), 1));
              arrayList.add(new UserTag(list8));
              arrayList.add(new UserTag(ModifyUserLabelFragment.h(this.a).getResources().getString(2131756549), 1));
              arrayList.add(new UserTag(list9));
              arrayList.add(new UserTag(ModifyUserLabelFragment.h(this.a).getResources().getString(2131756387), 1));
              arrayList.add(new UserTag(list10));
              arrayList.add(new UserTag(ModifyUserLabelFragment.h(this.a).getResources().getString(2131756040), 1));
              arrayList.add(new UserTag(list11));
              arrayList.add(new UserTag(ModifyUserLabelFragment.h(this.a).getResources().getString(2131758377), 1));
              arrayList.add(new UserTag(list12));
              arrayList.add(new UserTag(ModifyUserLabelFragment.h(this.a).getResources().getString(2131759006), 1));
              arrayList.add(new UserTag(list13));
              list6 = new ArrayList<UserTag>();
              list6.add(new UserTag(ModifyUserLabelFragment.h(this.a).getResources().getString(2131755669), 1));
              list6.add(new UserTag(list2));
              list6.add(new UserTag(ModifyUserLabelFragment.h(this.a).getResources().getString(2131757937), 1));
              list6.add(new UserTag(list3));
              list6.add(new UserTag(ModifyUserLabelFragment.h(this.a).getResources().getString(2131758143), 1));
              list6.add(new UserTag(list4));
              ModifyUserLabelFragment.b(this.a).a(new UserTag(list5));
              ModifyUserLabelFragment.c(this.a).a(new UserTag(list1));
              ModifyUserLabelFragment.d(this.a).a(arrayList);
              ModifyUserLabelFragment.e(this.a).a(list6);
            } 
          }
          
          public void onUIFinish() {
            DialogUtils.b(ModifyUserLabelFragment.k(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ModifyUserLabelFragment.k(this.a));
          }
        }(IRequestHost)w_());
  }
  
  public void a(UserTag paramUserTag, List<UserTag> paramList) {
    if (paramUserTag.exclude_id != null) {
      if (paramUserTag.exclude_id.length == 0)
        return; 
      if (paramUserTag.checked == 1) {
        for (int i = 0; i < paramUserTag.exclude_id.length; i++) {
          int j;
          for (j = 0; j < paramList.size(); j++) {
            if (paramUserTag.exclude_id[i].equals(((UserTag)paramList.get(j)).id))
              ((UserTag)paramList.get(j)).chooseable = false; 
          } 
        } 
      } else {
        for (int i = 0; i < paramUserTag.exclude_id.length; i++) {
          int j;
          for (j = 0; j < paramList.size(); j++) {
            if (paramUserTag.exclude_id[i].equals(((UserTag)paramList.get(j)).id))
              ((UserTag)paramList.get(j)).chooseable = true; 
          } 
        } 
      } 
    } 
  }
  
  public void a(ArrayList<String> paramArrayList, List<UserTag> paramList) {
    if (paramList != null) {
      int i;
      for (i = 0; i < paramList.size(); i++)
        ((UserTag)paramList.get(i)).checked = 0; 
      if (paramArrayList != null && paramArrayList.size() > 0)
        for (i = 0; i < paramArrayList.size(); i++) {
          String str = paramArrayList.get(i);
          int j;
          for (j = 0; j < paramList.size(); j++) {
            UserTag userTag = paramList.get(j);
            if (userTag != null && TextUtils.equals(userTag.id, str)) {
              userTag.checked = 1;
              a(userTag, paramList);
            } 
          } 
        }  
    } 
  }
  
  public void k() {
    int j;
    this.l.clear();
    byte b = 0;
    int i;
    for (i = 0; i < this.n.n().size(); i++) {
      UserTag userTag = this.n.n().get(i);
      if (userTag != null && userTag.tagList != null)
        for (UserTag userTag1 : userTag.tagList) {
          if (userTag1.checked == 1)
            this.l.add(userTag1.id); 
        }  
    } 
    for (i = 0; i < this.o.n().size(); i++) {
      UserTag userTag = this.o.n().get(i);
      if (userTag != null && userTag.tagList != null)
        for (UserTag userTag1 : userTag.tagList) {
          if (userTag1.checked == 1)
            this.l.add(userTag1.id); 
        }  
    } 
    i = 0;
    while (true) {
      j = b;
      if (i < this.p.n().size()) {
        UserTag userTag = this.p.n().get(i);
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
    while (j < this.q.n().size()) {
      UserTag userTag = this.q.n().get(j);
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
      intent.putExtra("choosed_label_list", this.l);
      intent.putExtra("choosed_shape_list_name", a(0));
      intent.putExtra("choosed_personality_list_name", a(1));
      intent.putExtra("choosed_hobby_list_name", a(2));
      intent.putExtra("choosed_douban_list_name", a(3));
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
      this.e = paramLayoutInflater.inflate(2131493338, paramViewGroup, false);
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
    LabelPagerAdapter(ModifyUserLabelFragment this$0) {}
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return ModifyUserLabelFragment.f(this.a).size();
    }
    
    public int getItemPosition(Object param1Object) {
      return -2;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      while (ModifyUserLabelFragment.g(this.a).size() < ModifyUserLabelFragment.f(this.a).size()) {
        View view1 = LayoutInflater.from(ModifyUserLabelFragment.h(this.a)).inflate(2131494214, param1ViewGroup, false);
        ModifyUserLabelFragment.g(this.a).add(view1);
      } 
      View view = ModifyUserLabelFragment.g(this.a).get(param1Int);
      PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView)view.findViewById(2131301573);
      RecyclerView recyclerView = (RecyclerView)pullToRefreshRecyclerView.getRefreshableView();
      pullToRefreshRecyclerView.setRefreshEnabled(false);
      recyclerView.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(ModifyUserLabelFragment.h(this.a), 1));
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int != 2) {
            if (param1Int == 3 && recyclerView.getAdapter() == null)
              recyclerView.setAdapter((RecyclerView.Adapter)ModifyUserLabelFragment.e(this.a)); 
          } else if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter((RecyclerView.Adapter)ModifyUserLabelFragment.d(this.a));
          } 
        } else if (recyclerView.getAdapter() == null) {
          recyclerView.setAdapter((RecyclerView.Adapter)ModifyUserLabelFragment.c(this.a));
        } 
      } else if (recyclerView.getAdapter() == null) {
        recyclerView.setAdapter((RecyclerView.Adapter)ModifyUserLabelFragment.b(this.a));
      } 
      if (view.getParent() != null)
        ((ViewGroup)view.getParent()).removeView(view); 
      param1ViewGroup.addView(ModifyUserLabelFragment.g(this.a).get(param1Int));
      return view;
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\ModifyUserLabelFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */