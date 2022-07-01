package com.soft.blued.ui.circle.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.ui.markdown.MarkdownView;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.soft.blued.ui.circle.view.CircleTextVoteView;

public class CirclePostDetailsFragment$HeaderHolder_ViewBinding implements Unbinder {
  private CirclePostDetailsFragment.HeaderHolder b;
  
  public CirclePostDetailsFragment$HeaderHolder_ViewBinding(CirclePostDetailsFragment.HeaderHolder paramHeaderHolder, View paramView) {
    this.b = paramHeaderHolder;
    paramHeaderHolder.iv_level = (ImageView)Utils.a(paramView, 2131297820, "field 'iv_level'", ImageView.class);
    paramHeaderHolder.iv_anonymous = (ImageView)Utils.a(paramView, 2131297682, "field 'iv_anonymous'", ImageView.class);
    paramHeaderHolder.img_blued_medal = (ImageView)Utils.a(paramView, 2131297447, "field 'img_blued_medal'", ImageView.class);
    paramHeaderHolder.header_view = (ImageView)Utils.a(paramView, 2131297362, "field 'header_view'", ImageView.class);
    paramHeaderHolder.img_verify = (ImageView)Utils.a(paramView, 2131297575, "field 'img_verify'", ImageView.class);
    paramHeaderHolder.tv_name = (TextView)Utils.a(paramView, 2131301088, "field 'tv_name'", TextView.class);
    paramHeaderHolder.tv_time = (TextView)Utils.a(paramView, 2131301386, "field 'tv_time'", TextView.class);
    paramHeaderHolder.markdownView = (MarkdownView)Utils.a(paramView, 2131299200, "field 'markdownView'", MarkdownView.class);
    paramHeaderHolder.videoView = (PLVideoPageView)Utils.a(paramView, 2131301607, "field 'videoView'", PLVideoPageView.class);
    paramHeaderHolder.cardVideo = (CardView)Utils.a(paramView, 2131296658, "field 'cardVideo'", CardView.class);
    paramHeaderHolder.circleTextVote = (CircleTextVoteView)Utils.a(paramView, 2131296751, "field 'circleTextVote'", CircleTextVoteView.class);
    paramHeaderHolder.tv_comment_cnt = (TextView)Utils.a(paramView, 2131300650, "field 'tv_comment_cnt'", TextView.class);
    paramHeaderHolder.rl_content = (RelativeLayout)Utils.a(paramView, 2131299697, "field 'rl_content'", RelativeLayout.class);
    paramHeaderHolder.ll_refresh = (LinearLayout)Utils.a(paramView, 2131299045, "field 'll_refresh'", LinearLayout.class);
  }
  
  public void unbind() {
    CirclePostDetailsFragment.HeaderHolder headerHolder = this.b;
    if (headerHolder != null) {
      this.b = null;
      headerHolder.iv_level = null;
      headerHolder.iv_anonymous = null;
      headerHolder.img_blued_medal = null;
      headerHolder.header_view = null;
      headerHolder.img_verify = null;
      headerHolder.tv_name = null;
      headerHolder.tv_time = null;
      headerHolder.markdownView = null;
      headerHolder.videoView = null;
      headerHolder.cardVideo = null;
      headerHolder.circleTextVote = null;
      headerHolder.tv_comment_cnt = null;
      headerHolder.rl_content = null;
      headerHolder.ll_refresh = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CirclePostDetailsFragment$HeaderHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */