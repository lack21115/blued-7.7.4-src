package com.soft.blued.ui.find.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class DependentVIPSelectedFragment_ViewBinding implements Unbinder {
  private DependentVIPSelectedFragment b;
  
  public DependentVIPSelectedFragment_ViewBinding(DependentVIPSelectedFragment paramDependentVIPSelectedFragment, View paramView) {
    this.b = paramDependentVIPSelectedFragment;
    paramDependentVIPSelectedFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
  }
  
  public void unbind() {
    DependentVIPSelectedFragment dependentVIPSelectedFragment = this.b;
    if (dependentVIPSelectedFragment != null) {
      this.b = null;
      dependentVIPSelectedFragment.title = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\DependentVIPSelectedFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */