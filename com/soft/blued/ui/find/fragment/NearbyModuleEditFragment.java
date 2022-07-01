package com.soft.blued.ui.find.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.ui.find.adapter.ModuleEditAdapterForListview;
import com.soft.blued.ui.find.model.NearbyModule;
import com.soft.blued.ui.find.observer.PeopleDataObserver;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.user.UserInfo;

public class NearbyModuleEditFragment extends BaseFragment {
  public Context d;
  
  public View e;
  
  public CommonTopTitleNoTrans f;
  
  public ListView g;
  
  public ModuleEditAdapterForListview h;
  
  public Dialog i;
  
  public NoDataAndLoadFailView j;
  
  public boolean k;
  
  public boolean l = false;
  
  public View.OnClickListener m = new View.OnClickListener(this) {
      public void onClick(View param1View) {
        this.a.n();
      }
    };
  
  BluedUIHttpResponse n = new BluedUIHttpResponse<BluedEntityA<NearbyModule>>(this, "nearby_module", (IRequestHost)w_()) {
      protected void a(BluedEntityA<NearbyModule> param1BluedEntityA) {
        this.a.a(param1BluedEntityA);
      }
      
      protected void b(BluedEntityA<NearbyModule> param1BluedEntityA) {
        this.a.a(param1BluedEntityA);
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a.k = true;
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        DialogUtils.b(this.a.i);
        if (this.a.k) {
          if (this.a.h.getCount() == 0) {
            this.a.j.b();
          } else {
            this.a.j.c();
          } 
        } else if (this.a.h.getCount() == 0) {
          this.a.j.a();
        } else {
          this.a.j.c();
        } 
        this.a.h.notifyDataSetChanged();
        super.onUIFinish();
        this.a.k = false;
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(this.a.i);
      }
    };
  
  public boolean V_() {
    l();
    return true;
  }
  
  public void a() {
    this.j = new NoDataAndLoadFailView(this.d);
    this.j.c();
    this.j.setFailBtnVisibility(0);
    this.j.setFailBtnListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.m();
          }
        });
    this.i = DialogUtils.a(this.d);
    this.g = (ListView)this.e.findViewById(2131299768);
    this.h = new ModuleEditAdapterForListview(this.d, this.m);
    this.g.setAdapter((ListAdapter)this.h);
    this.g.setEmptyView((View)this.j);
    this.h.notifyDataSetChanged();
    m();
  }
  
  public void a(BluedEntityA<NearbyModule> paramBluedEntityA) {
    if (paramBluedEntityA != null && paramBluedEntityA.data != null && paramBluedEntityA.data.size() > 0)
      this.h.a(paramBluedEntityA.data); 
  }
  
  public void k() {
    this.f = (CommonTopTitleNoTrans)this.e.findViewById(2131300273);
    this.f.a();
    this.f.setCenterText(2131759223);
    this.f.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.l();
          }
        });
    this.f.setRightClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.n();
          }
        });
  }
  
  public void l() {
    if (this.l)
      PeopleDataObserver.a().c(); 
    getActivity().finish();
  }
  
  public void m() {
    NearbyHttpUtils.a(this.n, "column", (IRequestHost)w_());
  }
  
  public void n() {
    NearbyHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<BluedLoginResult> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              UserInfo.a().i().setCustom(((BluedLoginResult)param1BluedEntityA.data.get(0)).getCustom());
              this.a.l = true;
            } 
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
        }(IRequestHost)w_(), this.h.a());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493252, paramViewGroup, false);
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.n.refresh();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyModuleEditFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */