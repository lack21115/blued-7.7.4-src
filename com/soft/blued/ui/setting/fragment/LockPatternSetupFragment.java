package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.constant.CommonConstants;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.LockIndicator;
import com.soft.blued.customview.LockPatternView;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class LockPatternSetupFragment extends BaseFragment implements View.OnClickListener, LockPatternView.OnPatternListener {
  private View d;
  
  private LockPatternView e;
  
  private LockIndicator f;
  
  private TextView g;
  
  private int h;
  
  private List<LockPatternView.Cell> i;
  
  private boolean j = false;
  
  private List<String> k = new ArrayList<String>();
  
  private boolean l = true;
  
  private void a(String paramString) {
    this.f.setPath(paramString);
  }
  
  private void k() {
    this.e = (LockPatternView)this.d.findViewById(2131299167);
    this.e.setOnPatternListener(this);
    this.f = (LockIndicator)this.d.findViewById(2131299165);
    this.g = (TextView)this.d.findViewById(2131299169);
  }
  
  private void l() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.d.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131756580));
    commonTopTitleNoTrans.setLeftClickListener(this);
  }
  
  private void m() {
    int i = this.h;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4)
            return; 
          if (this.j) {
            this.e.b();
            AppMethods.a(getResources().getString(2131757808));
            BluedPreferences.F(LockPatternView.a(this.i));
            a(new Runnable(this) {
                  public void run() {
                    Bundle bundle = this.a.getArguments();
                    if (bundle != null) {
                      String str = bundle.getString("FRAGMENT_NAME_KEY");
                      if (!StringUtils.e(str) && str.equals(GestureLockSettingFragment.class.getSimpleName()))
                        TerminalActivity.d((Context)this.a.getActivity(), GestureLockSettingFragment.class, null); 
                    } else {
                      CommonConstants.a = Boolean.valueOf(false);
                      BluedPreferences.z(true);
                    } 
                    this.a.getActivity().finish();
                  }
                }500L);
            return;
          } 
          this.e.setDisplayMode(LockPatternView.DisplayMode.c);
          this.e.c();
          return;
        } 
        this.e.a();
        this.e.c();
        return;
      } 
      this.e.b();
      return;
    } 
    this.i = null;
    this.j = false;
    this.e.a();
    this.e.c();
  }
  
  public boolean V_() {
    CommonConstants.a = Boolean.valueOf(false);
    getActivity().finish();
    return false;
  }
  
  public void a() {}
  
  public void a(List<LockPatternView.Cell> paramList) {}
  
  public void b() {}
  
  public void b(List<LockPatternView.Cell> paramList) {
    StringBuilder stringBuilder;
    if (paramList.size() < 4 && this.l) {
      this.g.setText(getResources().getText(2131756218));
      this.g.setTextColor(getResources().getColor(2131100173));
      this.e.setDisplayMode(LockPatternView.DisplayMode.c);
      this.h = 1;
      m();
      return;
    } 
    List<LockPatternView.Cell> list = this.i;
    int i = 0;
    if (list == null) {
      this.i = new ArrayList<LockPatternView.Cell>(paramList);
      this.g.setText(getResources().getText(2131756105));
      this.g.setTextColor(getResources().getColor(2131100335));
      this.h = 2;
      this.l = false;
      this.k.clear();
      for (LockPatternView.Cell cell : this.i)
        this.k.add(Integer.toString(cell.a() * 3 + cell.b() + 1)); 
      stringBuilder = new StringBuilder();
      while (i < this.k.size()) {
        stringBuilder.append(this.k.get(i));
        i++;
      } 
      a(stringBuilder.toString());
      if (this.h == 2) {
        this.h = 3;
        m();
      } 
      return;
    } 
    if (cell.equals(stringBuilder)) {
      this.j = true;
      this.h = 4;
      m();
      return;
    } 
    this.j = false;
    this.e.setDisplayMode(LockPatternView.DisplayMode.c);
    this.g.setText(getResources().getText(2131756106));
    this.g.setTextColor(getResources().getColor(2131100173));
    Animation animation = AnimationUtils.loadAnimation((Context)getActivity(), 2130772030);
    this.g.startAnimation(animation);
    this.h = 1;
    this.l = true;
    a("");
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            LockPatternSetupFragment.a(this.a);
          }
        },  500L);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    CommonConstants.a = Boolean.valueOf(false);
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493209, paramViewGroup, false);
      k();
      l();
      this.h = 1;
      m();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\LockPatternSetupFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */