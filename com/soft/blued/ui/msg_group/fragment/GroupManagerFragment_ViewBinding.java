package com.soft.blued.ui.msg_group.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.msg.customview.TranslationAnimHintView;

public class GroupManagerFragment_ViewBinding implements Unbinder {
  private GroupManagerFragment b;
  
  public GroupManagerFragment_ViewBinding(GroupManagerFragment paramGroupManagerFragment, View paramView) {
    this.b = paramGroupManagerFragment;
    paramGroupManagerFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramGroupManagerFragment.hintView = (TranslationAnimHintView)Utils.a(paramView, 2131297374, "field 'hintView'", TranslationAnimHintView.class);
    paramGroupManagerFragment.admin_list = (RecyclerView)Utils.a(paramView, 2131296424, "field 'admin_list'", RecyclerView.class);
  }
  
  public void unbind() {
    GroupManagerFragment groupManagerFragment = this.b;
    if (groupManagerFragment != null) {
      this.b = null;
      groupManagerFragment.title = null;
      groupManagerFragment.hintView = null;
      groupManagerFragment.admin_list = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\GroupManagerFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */