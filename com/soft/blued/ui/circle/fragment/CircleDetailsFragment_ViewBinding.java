package com.soft.blued.ui.circle.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.FloatFooterView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.RotateLayout;
import com.soft.blued.customview.TextViewFixTouchForDynamic;
import com.soft.blued.ui.circle.view.CircleJoinView;
import com.soft.blued.ui.circle.view.GroupJoinView;

public class CircleDetailsFragment_ViewBinding implements Unbinder {
  private CircleDetailsFragment b;
  
  public CircleDetailsFragment_ViewBinding(CircleDetailsFragment paramCircleDetailsFragment, View paramView) {
    this.b = paramCircleDetailsFragment;
    paramCircleDetailsFragment.ivTopBg = (ImageView)Utils.a(paramView, 2131297947, "field 'ivTopBg'", ImageView.class);
    paramCircleDetailsFragment.imgTopBg = (ImageView)Utils.a(paramView, 2131297568, "field 'imgTopBg'", ImageView.class);
    paramCircleDetailsFragment.rotateLayout = (RotateLayout)Utils.a(paramView, 2131299756, "field 'rotateLayout'", RotateLayout.class);
    paramCircleDetailsFragment.header = (ClassicsHeader)Utils.a(paramView, 2131297358, "field 'header'", ClassicsHeader.class);
    paramCircleDetailsFragment.flTopWhite = (FrameLayout)Utils.a(paramView, 2131297168, "field 'flTopWhite'", FrameLayout.class);
    paramCircleDetailsFragment.tvTopWhite = (TextView)Utils.a(paramView, 2131301439, "field 'tvTopWhite'", TextView.class);
    paramCircleDetailsFragment.titleScrollBg = Utils.a(paramView, 2131300283, "field 'titleScrollBg'");
    paramCircleDetailsFragment.titleScrollLeft = (ImageView)Utils.a(paramView, 2131300284, "field 'titleScrollLeft'", ImageView.class);
    paramCircleDetailsFragment.tvNameScroll = (TextView)Utils.a(paramView, 2131301093, "field 'tvNameScroll'", TextView.class);
    paramCircleDetailsFragment.tvNumberScroll = (TextView)Utils.a(paramView, 2131301128, "field 'tvNumberScroll'", TextView.class);
    paramCircleDetailsFragment.llTitleScroll = (LinearLayout)Utils.a(paramView, 2131299104, "field 'llTitleScroll'", LinearLayout.class);
    paramCircleDetailsFragment.layoutTitleScroll = (FrameLayout)Utils.a(paramView, 2131298097, "field 'layoutTitleScroll'", FrameLayout.class);
    paramCircleDetailsFragment.imgHeader = (ImageView)Utils.a(paramView, 2131297490, "field 'imgHeader'", ImageView.class);
    paramCircleDetailsFragment.flHeaderBottom = (FrameLayout)Utils.a(paramView, 2131297111, "field 'flHeaderBottom'", FrameLayout.class);
    paramCircleDetailsFragment.tvName = (TextView)Utils.a(paramView, 2131301088, "field 'tvName'", TextView.class);
    paramCircleDetailsFragment.tvNumber = (TextView)Utils.a(paramView, 2131301127, "field 'tvNumber'", TextView.class);
    paramCircleDetailsFragment.llActiveList = (LinearLayout)Utils.a(paramView, 2131298694, "field 'llActiveList'", LinearLayout.class);
    paramCircleDetailsFragment.ivActiveList = (ImageView)Utils.a(paramView, 2131297669, "field 'ivActiveList'", ImageView.class);
    paramCircleDetailsFragment.tvActiveList = (TextView)Utils.a(paramView, 2131300484, "field 'tvActiveList'", TextView.class);
    paramCircleDetailsFragment.ivActiveListHelp = (ImageView)Utils.a(paramView, 2131297670, "field 'ivActiveListHelp'", ImageView.class);
    paramCircleDetailsFragment.llActiveHeaderAll = (LinearLayout)Utils.a(paramView, 2131298692, "field 'llActiveHeaderAll'", LinearLayout.class);
    paramCircleDetailsFragment.llActiveHeader = (LinearLayout)Utils.a(paramView, 2131298691, "field 'llActiveHeader'", LinearLayout.class);
    paramCircleDetailsFragment.llTitle = (LinearLayout)Utils.a(paramView, 2131299102, "field 'llTitle'", LinearLayout.class);
    paramCircleDetailsFragment.cjvJoin = (CircleJoinView)Utils.a(paramView, 2131296752, "field 'cjvJoin'", CircleJoinView.class);
    paramCircleDetailsFragment.tvContent = (TextViewFixTouchForDynamic)Utils.a(paramView, 2131300663, "field 'tvContent'", TextViewFixTouchForDynamic.class);
    paramCircleDetailsFragment.flContent = (FrameLayout)Utils.a(paramView, 2131297099, "field 'flContent'", FrameLayout.class);
    paramCircleDetailsFragment.clHeader = (ConstraintLayout)Utils.a(paramView, 2131296761, "field 'clHeader'", ConstraintLayout.class);
    paramCircleDetailsFragment.tvIsTopTitle1 = (TextView)Utils.a(paramView, 2131300922, "field 'tvIsTopTitle1'", TextView.class);
    paramCircleDetailsFragment.llIsTop1 = (LinearLayout)Utils.a(paramView, 2131298896, "field 'llIsTop1'", LinearLayout.class);
    paramCircleDetailsFragment.tvIsTopTitle2 = (TextView)Utils.a(paramView, 2131300923, "field 'tvIsTopTitle2'", TextView.class);
    paramCircleDetailsFragment.llIsTop2 = (LinearLayout)Utils.a(paramView, 2131298897, "field 'llIsTop2'", LinearLayout.class);
    paramCircleDetailsFragment.tvIsTopTitle3 = (TextView)Utils.a(paramView, 2131300924, "field 'tvIsTopTitle3'", TextView.class);
    paramCircleDetailsFragment.llIsTop3 = (LinearLayout)Utils.a(paramView, 2131298898, "field 'llIsTop3'", LinearLayout.class);
    paramCircleDetailsFragment.topLine = Utils.a(paramView, 2131300299, "field 'topLine'");
    paramCircleDetailsFragment.sllIsTop = (ShapeLinearLayout)Utils.a(paramView, 2131299976, "field 'sllIsTop'", ShapeLinearLayout.class);
    paramCircleDetailsFragment.stvNew = (ShapeTextView)Utils.a(paramView, 2131300104, "field 'stvNew'", ShapeTextView.class);
    paramCircleDetailsFragment.stvHot = (ShapeTextView)Utils.a(paramView, 2131300099, "field 'stvHot'", ShapeTextView.class);
    paramCircleDetailsFragment.stvEssence = (ShapeTextView)Utils.a(paramView, 2131300089, "field 'stvEssence'", ShapeTextView.class);
    paramCircleDetailsFragment.sllTab = (ShapeLinearLayout)Utils.a(paramView, 2131299981, "field 'sllTab'", ShapeLinearLayout.class);
    paramCircleDetailsFragment.sllListTitle = (ShapeLinearLayout)Utils.a(paramView, 2131299978, "field 'sllListTitle'", ShapeLinearLayout.class);
    paramCircleDetailsFragment.appbar = (AppBarLayout)Utils.a(paramView, 2131296447, "field 'appbar'", AppBarLayout.class);
    paramCircleDetailsFragment.recyclerView = (RecyclerView)Utils.a(paramView, 2131299605, "field 'recyclerView'", RecyclerView.class);
    paramCircleDetailsFragment.coordinator = (CoordinatorLayout)Utils.a(paramView, 2131296843, "field 'coordinator'", CoordinatorLayout.class);
    paramCircleDetailsFragment.refreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refreshLayout'", SmartRefreshLayout.class);
    paramCircleDetailsFragment.titleStill = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300285, "field 'titleStill'", CommonTopTitleNoTrans.class);
    paramCircleDetailsFragment.ffvPost = (FloatFooterView)Utils.a(paramView, 2131297053, "field 'ffvPost'", FloatFooterView.class);
    paramCircleDetailsFragment.imgGuide = (ImageView)Utils.a(paramView, 2131297488, "field 'imgGuide'", ImageView.class);
    paramCircleDetailsFragment.cjvJoinScroll = (CircleJoinView)Utils.a(paramView, 2131296753, "field 'cjvJoinScroll'", CircleJoinView.class);
    paramCircleDetailsFragment.ivNumberScroll = (ImageView)Utils.a(paramView, 2131297881, "field 'ivNumberScroll'", ImageView.class);
    paramCircleDetailsFragment.ivNumber = (ImageView)Utils.a(paramView, 2131297880, "field 'ivNumber'", ImageView.class);
    paramCircleDetailsFragment.ivAdBanner = (ImageView)Utils.a(paramView, 2131297671, "field 'ivAdBanner'", ImageView.class);
    paramCircleDetailsFragment.mRootView = (FrameLayout)Utils.a(paramView, 2131299753, "field 'mRootView'", FrameLayout.class);
    paramCircleDetailsFragment.sclNoPermission = (ShapeConstraintLayout)Utils.a(paramView, 2131299914, "field 'sclNoPermission'", ShapeConstraintLayout.class);
    paramCircleDetailsFragment.noPermissionView = (NoDataAndLoadFailView)Utils.a(paramView, 2131299391, "field 'noPermissionView'", NoDataAndLoadFailView.class);
    paramCircleDetailsFragment.ivNoPermission = (ImageView)Utils.a(paramView, 2131297879, "field 'ivNoPermission'", ImageView.class);
    paramCircleDetailsFragment.cjvJoinView = (CircleJoinView)Utils.a(paramView, 2131296755, "field 'cjvJoinView'", CircleJoinView.class);
    paramCircleDetailsFragment.cjvJoinStroke = (ShapeLinearLayout)Utils.a(paramView, 2131296754, "field 'cjvJoinStroke'", ShapeLinearLayout.class);
    paramCircleDetailsFragment.group_join = (GroupJoinView)Utils.a(paramView, 2131297295, "field 'group_join'", GroupJoinView.class);
  }
  
  public void unbind() {
    CircleDetailsFragment circleDetailsFragment = this.b;
    if (circleDetailsFragment != null) {
      this.b = null;
      circleDetailsFragment.ivTopBg = null;
      circleDetailsFragment.imgTopBg = null;
      circleDetailsFragment.rotateLayout = null;
      circleDetailsFragment.header = null;
      circleDetailsFragment.flTopWhite = null;
      circleDetailsFragment.tvTopWhite = null;
      circleDetailsFragment.titleScrollBg = null;
      circleDetailsFragment.titleScrollLeft = null;
      circleDetailsFragment.tvNameScroll = null;
      circleDetailsFragment.tvNumberScroll = null;
      circleDetailsFragment.llTitleScroll = null;
      circleDetailsFragment.layoutTitleScroll = null;
      circleDetailsFragment.imgHeader = null;
      circleDetailsFragment.flHeaderBottom = null;
      circleDetailsFragment.tvName = null;
      circleDetailsFragment.tvNumber = null;
      circleDetailsFragment.llActiveList = null;
      circleDetailsFragment.ivActiveList = null;
      circleDetailsFragment.tvActiveList = null;
      circleDetailsFragment.ivActiveListHelp = null;
      circleDetailsFragment.llActiveHeaderAll = null;
      circleDetailsFragment.llActiveHeader = null;
      circleDetailsFragment.llTitle = null;
      circleDetailsFragment.cjvJoin = null;
      circleDetailsFragment.tvContent = null;
      circleDetailsFragment.flContent = null;
      circleDetailsFragment.clHeader = null;
      circleDetailsFragment.tvIsTopTitle1 = null;
      circleDetailsFragment.llIsTop1 = null;
      circleDetailsFragment.tvIsTopTitle2 = null;
      circleDetailsFragment.llIsTop2 = null;
      circleDetailsFragment.tvIsTopTitle3 = null;
      circleDetailsFragment.llIsTop3 = null;
      circleDetailsFragment.topLine = null;
      circleDetailsFragment.sllIsTop = null;
      circleDetailsFragment.stvNew = null;
      circleDetailsFragment.stvHot = null;
      circleDetailsFragment.stvEssence = null;
      circleDetailsFragment.sllTab = null;
      circleDetailsFragment.sllListTitle = null;
      circleDetailsFragment.appbar = null;
      circleDetailsFragment.recyclerView = null;
      circleDetailsFragment.coordinator = null;
      circleDetailsFragment.refreshLayout = null;
      circleDetailsFragment.titleStill = null;
      circleDetailsFragment.ffvPost = null;
      circleDetailsFragment.imgGuide = null;
      circleDetailsFragment.cjvJoinScroll = null;
      circleDetailsFragment.ivNumberScroll = null;
      circleDetailsFragment.ivNumber = null;
      circleDetailsFragment.ivAdBanner = null;
      circleDetailsFragment.mRootView = null;
      circleDetailsFragment.sclNoPermission = null;
      circleDetailsFragment.noPermissionView = null;
      circleDetailsFragment.ivNoPermission = null;
      circleDetailsFragment.cjvJoinView = null;
      circleDetailsFragment.cjvJoinStroke = null;
      circleDetailsFragment.group_join = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleDetailsFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */