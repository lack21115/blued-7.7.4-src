package com.soft.blued.ui.video.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.SearchView;

public class MyMusicCollectionFragment_ViewBinding implements Unbinder {
  private MyMusicCollectionFragment b;
  
  public MyMusicCollectionFragment_ViewBinding(MyMusicCollectionFragment paramMyMusicCollectionFragment, View paramView) {
    this.b = paramMyMusicCollectionFragment;
    paramMyMusicCollectionFragment.topTitle = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300300, "field 'topTitle'", CommonTopTitleNoTrans.class);
    paramMyMusicCollectionFragment.searchView = (SearchView)Utils.a(paramView, 2131299874, "field 'searchView'", SearchView.class);
    paramMyMusicCollectionFragment.tvMyCollection = (TextView)Utils.a(paramView, 2131301076, "field 'tvMyCollection'", TextView.class);
    paramMyMusicCollectionFragment.layoutMusic = (ConstraintLayout)Utils.a(paramView, 2131298072, "field 'layoutMusic'", ConstraintLayout.class);
    paramMyMusicCollectionFragment.appbar = (AppBarLayout)Utils.a(paramView, 2131296447, "field 'appbar'", AppBarLayout.class);
    paramMyMusicCollectionFragment.recyclerView = (RecyclerView)Utils.a(paramView, 2131299605, "field 'recyclerView'", RecyclerView.class);
    paramMyMusicCollectionFragment.coordinator = (CoordinatorLayout)Utils.a(paramView, 2131296843, "field 'coordinator'", CoordinatorLayout.class);
    paramMyMusicCollectionFragment.refreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refreshLayout'", SmartRefreshLayout.class);
    paramMyMusicCollectionFragment.rlSquare = (LinearLayout)Utils.a(paramView, 2131299730, "field 'rlSquare'", LinearLayout.class);
  }
  
  public void unbind() {
    MyMusicCollectionFragment myMusicCollectionFragment = this.b;
    if (myMusicCollectionFragment != null) {
      this.b = null;
      myMusicCollectionFragment.topTitle = null;
      myMusicCollectionFragment.searchView = null;
      myMusicCollectionFragment.tvMyCollection = null;
      myMusicCollectionFragment.layoutMusic = null;
      myMusicCollectionFragment.appbar = null;
      myMusicCollectionFragment.recyclerView = null;
      myMusicCollectionFragment.coordinator = null;
      myMusicCollectionFragment.refreshLayout = null;
      myMusicCollectionFragment.rlSquare = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\fragment\MyMusicCollectionFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */