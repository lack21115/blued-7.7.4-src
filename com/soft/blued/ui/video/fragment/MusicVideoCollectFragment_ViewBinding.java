package com.soft.blued.ui.video.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.FloatFooterView;

public class MusicVideoCollectFragment_ViewBinding implements Unbinder {
  private MusicVideoCollectFragment b;
  
  private View c;
  
  private View d;
  
  private View e;
  
  private View f;
  
  public MusicVideoCollectFragment_ViewBinding(MusicVideoCollectFragment paramMusicVideoCollectFragment, View paramView) {
    this.b = paramMusicVideoCollectFragment;
    paramMusicVideoCollectFragment.topTitle = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300300, "field 'topTitle'", CommonTopTitleNoTrans.class);
    View view = Utils.a(paramView, 2131297868, "field 'ivMusicBg' and method 'onViewClicked'");
    paramMusicVideoCollectFragment.ivMusicBg = (ImageView)Utils.b(view, 2131297868, "field 'ivMusicBg'", ImageView.class);
    this.c = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramMusicVideoCollectFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramMusicVideoCollectFragment.ivMusicPlay = (ImageView)Utils.a(paramView, 2131297869, "field 'ivMusicPlay'", ImageView.class);
    paramMusicVideoCollectFragment.tvMusicName = (TextView)Utils.a(paramView, 2131301068, "field 'tvMusicName'", TextView.class);
    view = Utils.a(paramView, 2131301066, "field 'tvMusicAuthor' and method 'onViewClicked'");
    paramMusicVideoCollectFragment.tvMusicAuthor = (TextView)Utils.b(view, 2131301066, "field 'tvMusicAuthor'", TextView.class);
    this.d = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramMusicVideoCollectFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    view = Utils.a(paramView, 2131297866, "field 'ivMusicAuthor' and method 'onViewClicked'");
    paramMusicVideoCollectFragment.ivMusicAuthor = (ImageView)Utils.b(view, 2131297866, "field 'ivMusicAuthor'", ImageView.class);
    this.e = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramMusicVideoCollectFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramMusicVideoCollectFragment.ivCollection = (ImageView)Utils.a(paramView, 2131297732, "field 'ivCollection'", ImageView.class);
    paramMusicVideoCollectFragment.tvCollection = (TextView)Utils.a(paramView, 2131300648, "field 'tvCollection'", TextView.class);
    view = Utils.a(paramView, 2131299975, "field 'sllCollection' and method 'onViewClicked'");
    paramMusicVideoCollectFragment.sllCollection = (ShapeLinearLayout)Utils.b(view, 2131299975, "field 'sllCollection'", ShapeLinearLayout.class);
    this.f = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramMusicVideoCollectFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramMusicVideoCollectFragment.layoutMusic = (FrameLayout)Utils.a(paramView, 2131298072, "field 'layoutMusic'", FrameLayout.class);
    paramMusicVideoCollectFragment.appbar = (AppBarLayout)Utils.a(paramView, 2131296447, "field 'appbar'", AppBarLayout.class);
    paramMusicVideoCollectFragment.recyclerView = (RecyclerView)Utils.a(paramView, 2131299605, "field 'recyclerView'", RecyclerView.class);
    paramMusicVideoCollectFragment.coordinator = (CoordinatorLayout)Utils.a(paramView, 2131296843, "field 'coordinator'", CoordinatorLayout.class);
    paramMusicVideoCollectFragment.refreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refreshLayout'", SmartRefreshLayout.class);
    paramMusicVideoCollectFragment.llFeedPost = (FloatFooterView)Utils.a(paramView, 2131298800, "field 'llFeedPost'", FloatFooterView.class);
  }
  
  public void unbind() {
    MusicVideoCollectFragment musicVideoCollectFragment = this.b;
    if (musicVideoCollectFragment != null) {
      this.b = null;
      musicVideoCollectFragment.topTitle = null;
      musicVideoCollectFragment.ivMusicBg = null;
      musicVideoCollectFragment.ivMusicPlay = null;
      musicVideoCollectFragment.tvMusicName = null;
      musicVideoCollectFragment.tvMusicAuthor = null;
      musicVideoCollectFragment.ivMusicAuthor = null;
      musicVideoCollectFragment.ivCollection = null;
      musicVideoCollectFragment.tvCollection = null;
      musicVideoCollectFragment.sllCollection = null;
      musicVideoCollectFragment.layoutMusic = null;
      musicVideoCollectFragment.appbar = null;
      musicVideoCollectFragment.recyclerView = null;
      musicVideoCollectFragment.coordinator = null;
      musicVideoCollectFragment.refreshLayout = null;
      musicVideoCollectFragment.llFeedPost = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      this.f.setOnClickListener(null);
      this.f = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\fragment\MusicVideoCollectFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */