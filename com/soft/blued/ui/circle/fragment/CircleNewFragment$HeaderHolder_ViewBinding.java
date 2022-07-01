package com.soft.blued.ui.circle.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class CircleNewFragment$HeaderHolder_ViewBinding implements Unbinder {
  private CircleNewFragment.HeaderHolder b;
  
  public CircleNewFragment$HeaderHolder_ViewBinding(CircleNewFragment.HeaderHolder paramHeaderHolder, View paramView) {
    this.b = paramHeaderHolder;
    paramHeaderHolder.mHeaderNewBaseAll = (LinearLayout)Utils.a(paramView, 2131299336, "field 'mHeaderNewBaseAll'", LinearLayout.class);
    paramHeaderHolder.mHeaderJoinImage = (ImageView)Utils.a(paramView, 2131299338, "field 'mHeaderJoinImage'", ImageView.class);
    paramHeaderHolder.mHeaderRecyclerView = (RecyclerView)Utils.a(paramView, 2131299347, "field 'mHeaderRecyclerView'", RecyclerView.class);
    paramHeaderHolder.newBaseTitle = Utils.a(paramView, 2131299378, "field 'newBaseTitle'");
    paramHeaderHolder.mHeaderRecommendMore = (LinearLayout)Utils.a(paramView, 2131299342, "field 'mHeaderRecommendMore'", LinearLayout.class);
    paramHeaderHolder.mHeaderRecommendRecyclerView = (RecyclerView)Utils.a(paramView, 2131299343, "field 'mHeaderRecommendRecyclerView'", RecyclerView.class);
    paramHeaderHolder.mNewBaseLayout = (RelativeLayout)Utils.a(paramView, 2131299339, "field 'mNewBaseLayout'", RelativeLayout.class);
    paramHeaderHolder.mNewBaseRecommendLayout = (RelativeLayout)Utils.a(paramView, 2131299341, "field 'mNewBaseRecommendLayout'", RelativeLayout.class);
    paramHeaderHolder.llRankLayout = (LinearLayout)Utils.a(paramView, 2131299034, "field 'llRankLayout'", LinearLayout.class);
    paramHeaderHolder.tvRankUpdateTime = (TextView)Utils.a(paramView, 2131301222, "field 'tvRankUpdateTime'", TextView.class);
    paramHeaderHolder.llRank1 = (LinearLayout)Utils.a(paramView, 2131299031, "field 'llRank1'", LinearLayout.class);
    paramHeaderHolder.tvRankTitle1 = (TextView)Utils.a(paramView, 2131301219, "field 'tvRankTitle1'", TextView.class);
    paramHeaderHolder.rankIcon1 = (ImageView)Utils.a(paramView, 2131299564, "field 'rankIcon1'", ImageView.class);
    paramHeaderHolder.llRank2 = (LinearLayout)Utils.a(paramView, 2131299032, "field 'llRank2'", LinearLayout.class);
    paramHeaderHolder.tvRankTitle2 = (TextView)Utils.a(paramView, 2131301220, "field 'tvRankTitle2'", TextView.class);
    paramHeaderHolder.rankIcon2 = (ImageView)Utils.a(paramView, 2131299565, "field 'rankIcon2'", ImageView.class);
    paramHeaderHolder.llRank3 = (LinearLayout)Utils.a(paramView, 2131299033, "field 'llRank3'", LinearLayout.class);
    paramHeaderHolder.tvRankTitle3 = (TextView)Utils.a(paramView, 2131301221, "field 'tvRankTitle3'", TextView.class);
    paramHeaderHolder.rankIcon3 = (ImageView)Utils.a(paramView, 2131299566, "field 'rankIcon3'", ImageView.class);
  }
  
  public void unbind() {
    CircleNewFragment.HeaderHolder headerHolder = this.b;
    if (headerHolder != null) {
      this.b = null;
      headerHolder.mHeaderNewBaseAll = null;
      headerHolder.mHeaderJoinImage = null;
      headerHolder.mHeaderRecyclerView = null;
      headerHolder.newBaseTitle = null;
      headerHolder.mHeaderRecommendMore = null;
      headerHolder.mHeaderRecommendRecyclerView = null;
      headerHolder.mNewBaseLayout = null;
      headerHolder.mNewBaseRecommendLayout = null;
      headerHolder.llRankLayout = null;
      headerHolder.tvRankUpdateTime = null;
      headerHolder.llRank1 = null;
      headerHolder.tvRankTitle1 = null;
      headerHolder.rankIcon1 = null;
      headerHolder.llRank2 = null;
      headerHolder.tvRankTitle2 = null;
      headerHolder.rankIcon2 = null;
      headerHolder.llRank3 = null;
      headerHolder.tvRankTitle3 = null;
      headerHolder.rankIcon3 = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleNewFragment$HeaderHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */