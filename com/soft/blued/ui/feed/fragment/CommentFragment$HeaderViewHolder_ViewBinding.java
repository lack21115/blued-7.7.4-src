package com.soft.blued.ui.feed.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.NoDataAndLoadFailView;

public class CommentFragment$HeaderViewHolder_ViewBinding implements Unbinder {
  private CommentFragment.HeaderViewHolder b;
  
  public CommentFragment$HeaderViewHolder_ViewBinding(CommentFragment.HeaderViewHolder paramHeaderViewHolder, View paramView) {
    this.b = paramHeaderViewHolder;
    paramHeaderViewHolder.rlComment = Utils.a(paramView, 2131299696, "field 'rlComment'");
    paramHeaderViewHolder.imgHeader = (ImageView)Utils.a(paramView, 2131297362, "field 'imgHeader'", ImageView.class);
    paramHeaderViewHolder.timeView = (TextView)Utils.a(paramView, 2131300267, "field 'timeView'", TextView.class);
    paramHeaderViewHolder.nameView = (TextView)Utils.a(paramView, 2131299358, "field 'nameView'", TextView.class);
    paramHeaderViewHolder.contentView = (TextView)Utils.a(paramView, 2131296838, "field 'contentView'", TextView.class);
    paramHeaderViewHolder.imgVerify = (ImageView)Utils.a(paramView, 2131297575, "field 'imgVerify'", ImageView.class);
    paramHeaderViewHolder.imgLike = (ImageView)Utils.a(paramView, 2131297461, "field 'imgLike'", ImageView.class);
    paramHeaderViewHolder.tvLikeCount = (TextView)Utils.a(paramView, 2131300653, "field 'tvLikeCount'", TextView.class);
    paramHeaderViewHolder.ivLevel = (ImageView)Utils.a(paramView, 2131297820, "field 'ivLevel'", ImageView.class);
    paramHeaderViewHolder.imgVIPIcon = (ImageView)Utils.a(paramView, 2131297581, "field 'imgVIPIcon'", ImageView.class);
    paramHeaderViewHolder.noDataView = (NoDataAndLoadFailView)Utils.a(paramView, 2131299389, "field 'noDataView'", NoDataAndLoadFailView.class);
    paramHeaderViewHolder.ll_img = (LinearLayout)Utils.a(paramView, 2131298890, "field 'll_img'", LinearLayout.class);
    paramHeaderViewHolder.ivAnonymous = (ImageView)Utils.a(paramView, 2131297682, "field 'ivAnonymous'", ImageView.class);
  }
  
  public void unbind() {
    CommentFragment.HeaderViewHolder headerViewHolder = this.b;
    if (headerViewHolder != null) {
      this.b = null;
      headerViewHolder.rlComment = null;
      headerViewHolder.imgHeader = null;
      headerViewHolder.timeView = null;
      headerViewHolder.nameView = null;
      headerViewHolder.contentView = null;
      headerViewHolder.imgVerify = null;
      headerViewHolder.imgLike = null;
      headerViewHolder.tvLikeCount = null;
      headerViewHolder.ivLevel = null;
      headerViewHolder.imgVIPIcon = null;
      headerViewHolder.noDataView = null;
      headerViewHolder.ll_img = null;
      headerViewHolder.ivAnonymous = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\CommentFragment$HeaderViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */