package com.soft.blued.ui.login_register.View;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.ui.login_register.Contract.StartLoginVerifyContract;
import com.soft.blued.ui.login_register.adapter.VerifyAdapter;
import com.soft.blued.ui.login_register.model.AccountNumberVerifyModel;
import com.soft.blued.ui.login_register.presenter.StartLoginVerifyPresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StartLoginVerifyFragment extends BaseFragment implements View.OnClickListener, StartLoginVerifyContract.IView {
  private View d;
  
  private Bundle e;
  
  private Context f;
  
  private StartLoginVerifyContract.IPresenter g;
  
  private TextView h;
  
  private TextView i;
  
  private CommonTopTitleNoTrans j;
  
  private TextView k;
  
  private String l;
  
  private List<AccountNumberVerifyModel> m = new ArrayList<AccountNumberVerifyModel>();
  
  private PullToRefreshRecyclerView n;
  
  private RecyclerView o;
  
  private VerifyAdapter p;
  
  private void a() {
    this.j = (CommonTopTitleNoTrans)this.d.findViewById(2131296873);
    this.j.c();
    this.j.setCenterText("");
    this.j.e();
    this.j.setRightText(2131756021);
    this.j.setRightTextColor(2131100842);
    this.j.setTitleBackgroundDrawable(2131100728);
    this.j.setRightClickListener(this);
    this.i = (TextView)this.d.findViewById(2131301354);
    this.h = (TextView)this.d.findViewById(2131301170);
    this.h.setText(this.l);
    this.i.setOnClickListener(this);
    this.k = (TextView)this.d.findViewById(2131300518);
    this.k.setOnClickListener(new -$$Lambda$StartLoginVerifyFragment$RTM9zkDk7cLa4-XVl095N4BBTHs(this));
    this.n = (PullToRefreshRecyclerView)this.d.findViewById(2131298144);
    this.o = (RecyclerView)this.n.getRefreshableView();
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f);
    linearLayoutManager.setOrientation(1);
    this.o.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.p = new VerifyAdapter(this.f);
    this.o.setAdapter((RecyclerView.Adapter)this.p);
    this.n.setRefreshEnabled(false);
    this.p.c(this.m);
  }
  
  public static void a(Context paramContext, Bundle paramBundle) {
    TerminalActivity.d(paramContext, StartLoginVerifyFragment.class, paramBundle);
  }
  
  private void k() {
    this.e = getArguments();
    Bundle bundle = this.e;
    if (bundle != null) {
      String str1 = bundle.getString("login_mobile");
      String str2 = this.e.getString("relation_mobile");
      String str3 = this.e.getString("login_email");
      String str4 = this.e.getString("safe_email");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get login_mobile:");
      stringBuilder.append(str1);
      stringBuilder.append(" --  relation_mobile:");
      stringBuilder.append(str2);
      stringBuilder.append(" --  login_email:");
      stringBuilder.append(str3);
      stringBuilder.append(" --  safe_email:");
      stringBuilder.append(str4);
      Log.v("drb", stringBuilder.toString());
      if (!TextUtils.isEmpty(str1))
        this.m.add(new AccountNumberVerifyModel(str1, "login_mobile")); 
      if (!TextUtils.isEmpty(str2))
        this.m.add(new AccountNumberVerifyModel(str2, "relation_mobile")); 
      if (!TextUtils.isEmpty(str3))
        this.m.add(new AccountNumberVerifyModel(str3, "login_email")); 
      if (!TextUtils.isEmpty(str4))
        this.m.add(new AccountNumberVerifyModel(str4, "safe_email")); 
      if (this.m.size() > 0)
        ((AccountNumberVerifyModel)this.m.get(0)).isSelect = true; 
    } 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296867) {
      if (i != 2131301354)
        return; 
      if (this.p.n() != null) {
        Iterator<AccountNumberVerifyModel> iterator = this.p.n().iterator();
        while (iterator.hasNext()) {
          AccountNumberVerifyModel accountNumberVerifyModel = iterator.next();
          if (accountNumberVerifyModel.isSelect) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("put SAFE_DEVICE_TYPE:");
            stringBuilder.append(accountNumberVerifyModel.type);
            stringBuilder.append(" -- SAFE_DEVICE_NUMBER:");
            stringBuilder.append(accountNumberVerifyModel.number);
            Log.v("drb", stringBuilder.toString());
            this.e.putString("safe_device_type", accountNumberVerifyModel.type);
            this.e.putString("safe_device_number", accountNumberVerifyModel.number);
            break;
          } 
        } 
      } 
      this.g.a(this.e);
      return;
    } 
    a(new -$$Lambda$StartLoginVerifyFragment$DBurzLfthyABRYiCvCEIN2sKjJ4(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493325, paramViewGroup, false);
      this.g = (StartLoginVerifyContract.IPresenter)new StartLoginVerifyPresenter(this.f, this, (IRequestHost)w_());
      k();
      a();
    } else {
      ((ViewGroup)view.getParent()).removeView(this.d);
    } 
    return this.d;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public static interface TARGET {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\View\StartLoginVerifyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */