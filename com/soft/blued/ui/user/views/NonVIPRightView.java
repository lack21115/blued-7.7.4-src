package com.soft.blued.ui.user.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.ui.user.adapter.VIPCenterVIPRightHoriAdapter;
import com.soft.blued.ui.user.model.VIPCenterForJsonParse;
import com.soft.blued.ui.user.model.VIPRightOption;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;

public class NonVIPRightView extends LinearLayout {
  TextView a;
  
  TextView b;
  
  RecyclerView c;
  
  Context d;
  
  View e;
  
  public NonVIPRightView(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public NonVIPRightView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public NonVIPRightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    this.e = LayoutInflater.from(paramContext).inflate(2131493618, (ViewGroup)this);
    this.d = paramContext;
    c();
  }
  
  private void c() {
    this.a = (TextView)findViewById(2131301438);
    this.b = (TextView)findViewById(2131300868);
    this.c = (RecyclerView)findViewById(2131299789);
  }
  
  public void a() {
    this.a.setVisibility(8);
  }
  
  public void a(IRequestHost paramIRequestHost, VIPCenterForJsonParse.NonVIPPriviledge paramNonVIPPriviledge, int paramInt, FragmentManager paramFragmentManager) {
    if (paramNonVIPPriviledge != null && paramNonVIPPriviledge.privilege_list != null) {
      if (paramNonVIPPriviledge.privilege_list.size() <= 0)
        return; 
      ArrayList<VIPRightOption> arrayList = new ArrayList();
      int i;
      for (i = 0; i < paramNonVIPPriviledge.privilege_list.size(); i++) {
        VIPRightOption vIPRightOption = paramNonVIPPriviledge.privilege_list.get(i);
        if (paramInt == 2) {
          arrayList.add(vIPRightOption);
        } else if (vIPRightOption.is_svip != 1) {
          arrayList.add(vIPRightOption);
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("vip_right_non_list_");
      stringBuilder.append(paramInt);
      Logger.a(stringBuilder.toString(), arrayList);
      this.b.setText(paramNonVIPPriviledge.title);
      VIPCenterVIPRightHoriAdapter vIPCenterVIPRightHoriAdapter = new VIPCenterVIPRightHoriAdapter(paramIRequestHost, arrayList, paramInt, paramFragmentManager);
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.d);
      linearLayoutManager.setOrientation(0);
      this.c.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
      this.c.setAdapter((RecyclerView.Adapter)vIPCenterVIPRightHoriAdapter);
    } 
  }
  
  public void b() {
    this.a.setVisibility(0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\views\NonVIPRightView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */