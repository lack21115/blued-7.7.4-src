package com.soft.blued.ui.group;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.stickygridheaders.StickyGridHeadersGridView;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.SearchView;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.adapter.GroupStickyHeaderGVAdapter;
import com.soft.blued.ui.group.model.BluedGroupTypeGridItem;
import com.soft.blued.ui.group.model.BluedGroupTypeTags;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class GroupSearchFragment extends KeyBoardFragment implements View.OnClickListener {
  public Dialog e;
  
  public List<BluedGroupTypeGridItem> f;
  
  public BluedUIHttpResponse o = new BluedUIHttpResponse<BluedEntityA<BluedGroupTypeTags>>(this) {
      protected void a(BluedEntityA<BluedGroupTypeTags> param1BluedEntityA) {
        try {
          if (param1BluedEntityA.hasData()) {
            GroupSearchFragment.c(this.a).add(param1BluedEntityA.getSingleData());
            new BluedGroupTypeTags.GroupsRecommend();
            ArrayList<BluedGroupTypeTags.GroupsRecommend> arrayList = new ArrayList();
            arrayList.add(((BluedGroupTypeTags)GroupSearchFragment.c(this.a).get(0)).getRecommend());
            arrayList.addAll(((BluedGroupTypeTags)GroupSearchFragment.c(this.a).get(0)).getClassify());
            for (int i = 0;; i++) {
              if (i < arrayList.size()) {
                for (int j = 0; j < ((BluedGroupTypeTags.GroupsClassify)arrayList.get(i)).getItem().size(); j++) {
                  BluedGroupTypeGridItem bluedGroupTypeGridItem = new BluedGroupTypeGridItem(((BluedGroupTypeTags.GroupsClassify)arrayList.get(i)).getType(), ((BluedGroupTypeTags.GroupsClassify)arrayList.get(i)).getItem().get(j), ((BluedGroupTypeTags.GroupsClassify)arrayList.get(i)).getName());
                  this.a.f.add(bluedGroupTypeGridItem);
                } 
              } else {
                GroupSearchFragment.d(this.a).notifyDataSetChanged();
                return;
              } 
            } 
          } 
          AppMethods.a(this.a.getResources().getString(2131756083));
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
          AppMethods.a(GroupSearchFragment.b(this.a).getResources().getString(2131756082));
          return;
        } 
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        DialogUtils.b(this.a.e);
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(this.a.e);
      }
    };
  
  private KeyboardListenLinearLayout p;
  
  private Context q;
  
  private StickyGridHeadersGridView r;
  
  private GroupStickyHeaderGVAdapter s;
  
  private SearchView t;
  
  private SearchEditText u;
  
  private List<BluedGroupTypeTags> v;
  
  private void t() {
    this.e = DialogUtils.a(this.q);
    this.v = new ArrayList<BluedGroupTypeTags>();
    this.f = new ArrayList<BluedGroupTypeGridItem>();
    this.r = (StickyGridHeadersGridView)this.p.findViewById(2131296470);
    if ((getResources().getConfiguration()).locale.getLanguage().equals("zh")) {
      this.r.setNumColumns(4);
    } else {
      this.r.setNumColumns(3);
    } 
    this.r.setHeadersIgnorePadding(true);
    this.s = new GroupStickyHeaderGVAdapter(this.q, this.f);
    this.r.setAdapter((ListAdapter)this.s);
    this.r.setAreHeadersSticky(true);
    this.r.setSelector((Drawable)new ColorDrawable(0));
    this.r.setCacheColorHint(0);
    this.r.setOnItemClickListener(new MyOnItemClickListener());
  }
  
  private void u() {
    this.t = (SearchView)this.p.findViewById(2131299874);
    this.u = this.t.getEditView();
    this.u.setImeOptions(3);
    this.t.setOnSearchInfoListener(new SearchView.OnSearchInfoListener(this) {
          public void a() {
            KeyboardUtils.a((Activity)this.a.getActivity());
            this.a.getActivity().finish();
          }
          
          public void a(String param1String) {}
          
          public void b() {}
        });
    this.u.setOnEditorActionListener(new TextView.OnEditorActionListener(this) {
          public boolean onEditorAction(TextView param1TextView, int param1Int, KeyEvent param1KeyEvent) {
            if (param1Int == 3) {
              if (!StringUtils.e(GroupSearchFragment.a(this.a).getText().toString())) {
                GroupSearchListFragment.a(GroupSearchFragment.b(this.a), GroupSearchFragment.a(this.a).getText().toString());
                ActivityChangeAnimationUtils.d((Activity)this.a.getActivity());
                return true;
              } 
              AppMethods.a(this.a.getResources().getString(2131756780));
            } 
            return false;
          }
        });
  }
  
  private void v() {
    GroupHttpUtils.i(this.q, this.o, "detail", (IRequestHost)w_());
  }
  
  public void e_(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      SearchView searchView = this.t;
      if (searchView != null) {
        searchView.a(false);
        return;
      } 
    } else {
      SearchView searchView = this.t;
      if (searchView != null)
        searchView.a(true); 
    } 
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131301302)
      return; 
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.q = (Context)getActivity();
    KeyboardListenLinearLayout keyboardListenLinearLayout = this.p;
    if (keyboardListenLinearLayout == null) {
      this.p = (KeyboardListenLinearLayout)paramLayoutInflater.inflate(2131493146, paramViewGroup, false);
      a(this.p);
      t();
      u();
      v();
    } else if (keyboardListenLinearLayout.getParent() != null) {
      ((ViewGroup)this.p.getParent()).removeView((View)this.p);
    } 
    return (View)this.p;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
  
  class MyOnItemClickListener implements AdapterView.OnItemClickListener {
    private MyOnItemClickListener(GroupSearchFragment this$0) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      if (param1Int >= 0) {
        if (param1Int > this.a.f.size())
          return; 
        if (!StringUtils.e(((BluedGroupTypeGridItem)this.a.f.get(param1Int)).getTags())) {
          GroupSearchFragment.a(this.a).setText(((BluedGroupTypeGridItem)this.a.f.get(param1Int)).getTags());
          GroupSearchFragment.a(this.a).setSelection(GroupSearchFragment.a(this.a).length());
        } 
        GroupSearchListFragment.a(GroupSearchFragment.b(this.a), GroupSearchFragment.a(this.a).getText().toString());
        ActivityChangeAnimationUtils.d((Activity)this.a.getActivity());
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupSearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */