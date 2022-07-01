package com.soft.blued.ui.msg;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.soft.blued.customview.HorizontalScrollView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.RiseNumberTextView;
import com.soft.blued.customview.VerticalTextView;
import com.soft.blued.ui.msg.customview.TranslationAnimHintView;

public class MsgFragment$HeaderViewHolder_ViewBinding implements Unbinder {
  private MsgFragment.HeaderViewHolder b;
  
  public MsgFragment$HeaderViewHolder_ViewBinding(MsgFragment.HeaderViewHolder paramHeaderViewHolder, View paramView) {
    this.b = paramHeaderViewHolder;
    paramHeaderViewHolder.ll_nodata_chats = (NoDataAndLoadFailView)Utils.a(paramView, 2131298988, "field 'll_nodata_chats'", NoDataAndLoadFailView.class);
    paramHeaderViewHolder.searchLayout = (ShapeLinearLayout)Utils.a(paramView, 2131299868, "field 'searchLayout'", ShapeLinearLayout.class);
    paramHeaderViewHolder.stub_push_remind = (ViewStub)Utils.a(paramView, 2131300042, "field 'stub_push_remind'", ViewStub.class);
    paramHeaderViewHolder.stub_push_remind_permanent = (ViewStub)Utils.a(paramView, 2131300043, "field 'stub_push_remind_permanent'", ViewStub.class);
    paramHeaderViewHolder.llHello = (LinearLayout)Utils.a(paramView, 2131298877, "field 'llHello'", LinearLayout.class);
    paramHeaderViewHolder.gtvHelloTitle = (TextView)Utils.a(paramView, 2131297330, "field 'gtvHelloTitle'", TextView.class);
    paramHeaderViewHolder.tvMore = (TextView)Utils.a(paramView, 2131301050, "field 'tvMore'", TextView.class);
    paramHeaderViewHolder.ivMore = (ImageView)Utils.a(paramView, 2131297863, "field 'ivMore'", ImageView.class);
    paramHeaderViewHolder.rvHello = (RecyclerView)Utils.a(paramView, 2131297370, "field 'rvHello'", RecyclerView.class);
    paramHeaderViewHolder.rlHelloEmpty = (RelativeLayout)Utils.a(paramView, 2131299710, "field 'rlHelloEmpty'", RelativeLayout.class);
    paramHeaderViewHolder.mScrollView = (HorizontalScrollView)Utils.a(paramView, 2131299842, "field 'mScrollView'", HorizontalScrollView.class);
    paramHeaderViewHolder.tvHelloMore = (VerticalTextView)Utils.a(paramView, 2131300889, "field 'tvHelloMore'", VerticalTextView.class);
    paramHeaderViewHolder.layoutNewHello = (ConstraintLayout)Utils.a(paramView, 2131298079, "field 'layoutNewHello'", ConstraintLayout.class);
    paramHeaderViewHolder.rtvMultiple = (RiseNumberTextView)Utils.a(paramView, 2131299764, "field 'rtvMultiple'", RiseNumberTextView.class);
    paramHeaderViewHolder.rtvNum = (RiseNumberTextView)Utils.a(paramView, 2131299765, "field 'rtvNum'", RiseNumberTextView.class);
    paramHeaderViewHolder.anim_hint_view = (TranslationAnimHintView)Utils.a(paramView, 2131296444, "field 'anim_hint_view'", TranslationAnimHintView.class);
  }
  
  public void unbind() {
    MsgFragment.HeaderViewHolder headerViewHolder = this.b;
    if (headerViewHolder != null) {
      this.b = null;
      headerViewHolder.ll_nodata_chats = null;
      headerViewHolder.searchLayout = null;
      headerViewHolder.stub_push_remind = null;
      headerViewHolder.stub_push_remind_permanent = null;
      headerViewHolder.llHello = null;
      headerViewHolder.gtvHelloTitle = null;
      headerViewHolder.tvMore = null;
      headerViewHolder.ivMore = null;
      headerViewHolder.rvHello = null;
      headerViewHolder.rlHelloEmpty = null;
      headerViewHolder.mScrollView = null;
      headerViewHolder.tvHelloMore = null;
      headerViewHolder.layoutNewHello = null;
      headerViewHolder.rtvMultiple = null;
      headerViewHolder.rtvNum = null;
      headerViewHolder.anim_hint_view = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\MsgFragment$HeaderViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */