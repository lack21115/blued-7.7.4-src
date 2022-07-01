package com.soft.blued.ui.discover.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.SearchView;

public class SuperTopicFragment_ViewBinding implements Unbinder {
  private SuperTopicFragment b;
  
  private View c;
  
  private View d;
  
  public SuperTopicFragment_ViewBinding(SuperTopicFragment paramSuperTopicFragment, View paramView) {
    this.b = paramSuperTopicFragment;
    paramSuperTopicFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramSuperTopicFragment.searchView = (SearchView)Utils.a(paramView, 2131299874, "field 'searchView'", SearchView.class);
    View view = Utils.a(paramView, 2131301087, "field 'tvMyTopic' and method 'onViewClicked'");
    paramSuperTopicFragment.tvMyTopic = (TextView)Utils.b(view, 2131301087, "field 'tvMyTopic'", TextView.class);
    this.c = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramSuperTopicFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramSuperTopicFragment.linearLayout = (LinearLayout)Utils.a(paramView, 2131298127, "field 'linearLayout'", LinearLayout.class);
    paramSuperTopicFragment.recyclerView = (RecyclerView)Utils.a(paramView, 2131299605, "field 'recyclerView'", RecyclerView.class);
    paramSuperTopicFragment.refreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refreshLayout'", SmartRefreshLayout.class);
    paramSuperTopicFragment.stvCreateSuperTopic = (ShapeTextView)Utils.a(paramView, 2131300079, "field 'stvCreateSuperTopic'", ShapeTextView.class);
    paramSuperTopicFragment.ivCreateSuperTopic = (ImageView)Utils.a(paramView, 2131297736, "field 'ivCreateSuperTopic'", ImageView.class);
    paramView = Utils.a(paramView, 2131297102, "field 'flCreateSuperTopic' and method 'onViewClicked'");
    paramSuperTopicFragment.flCreateSuperTopic = (FrameLayout)Utils.b(paramView, 2131297102, "field 'flCreateSuperTopic'", FrameLayout.class);
    this.d = paramView;
    paramView.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramSuperTopicFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
  }
  
  public void unbind() {
    SuperTopicFragment superTopicFragment = this.b;
    if (superTopicFragment != null) {
      this.b = null;
      superTopicFragment.title = null;
      superTopicFragment.searchView = null;
      superTopicFragment.tvMyTopic = null;
      superTopicFragment.linearLayout = null;
      superTopicFragment.recyclerView = null;
      superTopicFragment.refreshLayout = null;
      superTopicFragment.stvCreateSuperTopic = null;
      superTopicFragment.ivCreateSuperTopic = null;
      superTopicFragment.flCreateSuperTopic = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\SuperTopicFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */