package com.soft.blued.ui.circle.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class CircleNewFragment_ViewBinding implements Unbinder {
  private CircleNewFragment b;
  
  public CircleNewFragment_ViewBinding(CircleNewFragment paramCircleNewFragment, View paramView) {
    this.b = paramCircleNewFragment;
    paramCircleNewFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramCircleNewFragment.recyclerView = (RecyclerView)Utils.a(paramView, 2131299605, "field 'recyclerView'", RecyclerView.class);
    paramCircleNewFragment.refreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refreshLayout'", SmartRefreshLayout.class);
    paramCircleNewFragment.skeleton = Utils.a(paramView, 2131299968, "field 'skeleton'");
  }
  
  public void unbind() {
    CircleNewFragment circleNewFragment = this.b;
    if (circleNewFragment != null) {
      this.b = null;
      circleNewFragment.title = null;
      circleNewFragment.recyclerView = null;
      circleNewFragment.refreshLayout = null;
      circleNewFragment.skeleton = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleNewFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */