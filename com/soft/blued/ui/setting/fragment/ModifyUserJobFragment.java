package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.view.FlowLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.ui.user.model.UserTagAll;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.List;

public class ModifyUserJobFragment extends BaseFragment implements View.OnClickListener {
  private Context d;
  
  private View e;
  
  private Dialog f;
  
  private FlowLayout g;
  
  private LayoutInflater h;
  
  private ArrayList<String> i = new ArrayList<String>();
  
  private List<UserTag> j = new ArrayList<UserTag>();
  
  public static void a(BaseFragment paramBaseFragment, ArrayList<String> paramArrayList, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putStringArrayList("choosedList", paramArrayList);
    TerminalActivity.a((Fragment)paramBaseFragment, ModifyUserJobFragment.class, bundle, paramInt);
  }
  
  private void m() {
    Bundle bundle = getArguments();
    if (bundle != null && bundle.getStringArrayList("choosedList") != null)
      this.i.addAll(bundle.getStringArrayList("choosedList")); 
  }
  
  private void n() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.setCenterText(getString(2131757086));
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.setRightClickListener(this);
    commonTopTitleNoTrans.setRightText(2131756206);
    commonTopTitleNoTrans.setRightTextColor(2131100838);
  }
  
  private void o() {
    this.h = LayoutInflater.from(this.d);
    this.f = DialogUtils.a((Context)getActivity());
    this.g = (FlowLayout)this.e.findViewById(2131301571);
  }
  
  public ArrayList<String> a() {
    ArrayList<String> arrayList = new ArrayList();
    for (int i = 0; i < this.j.size(); i++) {
      if (((UserTag)this.j.get(i)).checked == 1)
        arrayList.add(((UserTag)this.j.get(i)).name); 
    } 
    return arrayList;
  }
  
  public void a(ArrayList<String> paramArrayList, List<UserTag> paramList) {
    if (paramArrayList != null && paramArrayList.size() > 0) {
      int i;
      for (i = 0; i < paramList.size(); i++)
        ((UserTag)paramList.get(i)).checked = 0; 
      for (i = 0; i < paramArrayList.size(); i++) {
        String str = paramArrayList.get(i);
        int j;
        for (j = 0; j < paramList.size(); j++) {
          if (((UserTag)paramList.get(j)).id.equals(str))
            ((UserTag)paramList.get(j)).checked = 1; 
        } 
      } 
    } 
  }
  
  public void a(List<UserTag> paramList) {
    if (paramList != null && paramList.size() > 0) {
      this.g.removeAllViews();
      for (int i = 0; i < paramList.size(); i++) {
        View view = this.h.inflate(2131494213, null);
        TextView textView = (TextView)view.findViewById(2131301371);
        textView.setText(((UserTag)paramList.get(i)).name);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name:");
        stringBuilder.append(((UserTag)paramList.get(i)).name);
        Log.v("drb", stringBuilder.toString());
        if (((UserTag)paramList.get(i)).checked == 0) {
          textView.setBackground(BluedSkinUtils.b(this.d, 2131234361));
          textView.setTextColor(BluedSkinUtils.a(this.d, 2131100838));
        } else {
          textView.setBackground(BluedSkinUtils.b(this.d, 2131234362));
          textView.setTextColor(BluedSkinUtils.a(this.d, 2131100728));
        } 
        this.g.addView(view);
      } 
      this.g.setOnItemClickListener(new FlowLayout.OnItemClickListener(this, paramList) {
            public void a(View param1View, int param1Int) {
              TextView textView;
              Logger.a("drb", new Object[] { "mFlowLayout onItemClick" });
              UserTag userTag = this.a.get(param1Int);
              if (userTag.checked == 0) {
                for (param1Int = 0; param1Int < this.a.size(); param1Int++) {
                  ((UserTag)this.a.get(param1Int)).checked = 0;
                  TextView textView1 = (TextView)ModifyUserJobFragment.a(this.b).getChildAt(param1Int).findViewById(2131301371);
                  textView1.setBackgroundResource(2131234361);
                  textView1.setTextColor(BluedSkinUtils.a(ModifyUserJobFragment.b(this.b), 2131100838));
                } 
                userTag.checked = 1;
                textView = (TextView)param1View.findViewById(2131301371);
                textView.setBackground(BluedSkinUtils.b(ModifyUserJobFragment.b(this.b), 2131234362));
                textView.setTextColor(BluedSkinUtils.a(ModifyUserJobFragment.b(this.b), 2131100728));
              } else {
                userTag.checked = 0;
                textView = (TextView)textView.findViewById(2131301371);
                textView.setBackground(BluedSkinUtils.b(ModifyUserJobFragment.b(this.b), 2131234361));
                textView.setTextColor(BluedSkinUtils.a(ModifyUserJobFragment.b(this.b), 2131100838));
              } 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("userTag.checked = ");
              stringBuilder.append(userTag.checked);
              Log.v("drb", stringBuilder.toString());
            }
          });
    } 
  }
  
  public void k() {
    this.i.clear();
    for (int i = 0; i < this.j.size(); i++) {
      if (((UserTag)this.j.get(i)).checked == 1)
        this.i.add(((UserTag)this.j.get(i)).id); 
    } 
  }
  
  public void l() {
    FindHttpUtils.a(this.d, new BluedUIHttpResponse<BluedEntityA<UserTagAll>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<UserTagAll> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              ModifyUserJobFragment.a(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).work);
              ModifyUserJobFragment modifyUserJobFragment = this.a;
              modifyUserJobFragment.a(ModifyUserJobFragment.c(modifyUserJobFragment), ModifyUserJobFragment.d(this.a));
              modifyUserJobFragment = this.a;
              modifyUserJobFragment.a(ModifyUserJobFragment.d(modifyUserJobFragment));
            } 
          }
          
          public void onUIFinish() {
            DialogUtils.b(ModifyUserJobFragment.e(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ModifyUserJobFragment.e(this.a));
          }
        }(IRequestHost)w_());
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      k();
      Intent intent = new Intent();
      intent.putExtra("choosed_job_list", this.i);
      intent.putExtra("choosed_job_list_name", a());
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
      this.e = paramLayoutInflater.inflate(2131493337, paramViewGroup, false);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\ModifyUserJobFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */