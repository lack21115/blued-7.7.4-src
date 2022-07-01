package com.soft.blued.ui.feed.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Space;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.ui.custom.SwitchPanelRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.emoticon.ui.EmoticonsIndicatorView;
import com.soft.blued.emoticon.ui.EmoticonsPageView;
import com.soft.blued.emoticon.ui.EmoticonsToolBarView;

public class CommentFragment_ViewBinding implements Unbinder {
  private CommentFragment b;
  
  private View c;
  
  private View d;
  
  public CommentFragment_ViewBinding(CommentFragment paramCommentFragment, View paramView) {
    this.b = paramCommentFragment;
    paramCommentFragment.keyboardLayout = (KeyboardListenLinearLayout)Utils.a(paramView, 2131297982, "field 'keyboardLayout'", KeyboardListenLinearLayout.class);
    paramCommentFragment.topBar = Utils.a(paramView, 2131300293, "field 'topBar'");
    paramCommentFragment.topTitle = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300300, "field 'topTitle'", CommonTopTitleNoTrans.class);
    paramCommentFragment.listView = (ListView)Utils.a(paramView, 2131298144, "field 'listView'", ListView.class);
    paramCommentFragment.keyboardView = Utils.a(paramView, 2131297985, "field 'keyboardView'");
    paramCommentFragment.refreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refreshLayout'", SmartRefreshLayout.class);
    paramCommentFragment.editView = (EditText)Utils.a(paramView, 2131296971, "field 'editView'", EditText.class);
    View view = Utils.a(paramView, 2131297397, "field 'iconEmoji' and method 'onViewClicked'");
    paramCommentFragment.iconEmoji = (ImageView)Utils.b(view, 2131297397, "field 'iconEmoji'", ImageView.class);
    this.c = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCommentFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    view = Utils.a(paramView, 2131299890, "field 'sendBtn' and method 'onViewClicked'");
    paramCommentFragment.sendBtn = (ShapeTextView)Utils.b(view, 2131299890, "field 'sendBtn'", ShapeTextView.class);
    this.d = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCommentFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramCommentFragment.inputLayoutUp = (LinearLayout)Utils.a(paramView, 2131297596, "field 'inputLayoutUp'", LinearLayout.class);
    paramCommentFragment.layoutCommentAll = (LinearLayout)Utils.a(paramView, 2131298052, "field 'layoutCommentAll'", LinearLayout.class);
    paramCommentFragment.layoutAlbum = (LinearLayout)Utils.a(paramView, 2131298043, "field 'layoutAlbum'", LinearLayout.class);
    paramCommentFragment.ivCommentHeader = (ImageView)Utils.a(paramView, 2131297733, "field 'ivCommentHeader'", ImageView.class);
    paramCommentFragment.spaceWithHeader = (Space)Utils.a(paramView, 2131300002, "field 'spaceWithHeader'", Space.class);
    paramCommentFragment.emoticonLayout = (LinearLayout)Utils.a(paramView, 2131296983, "field 'emoticonLayout'", LinearLayout.class);
    paramCommentFragment.viewEpv = (EmoticonsPageView)Utils.a(paramView, 2131301643, "field 'viewEpv'", EmoticonsPageView.class);
    paramCommentFragment.viewEiv = (EmoticonsIndicatorView)Utils.a(paramView, 2131301642, "field 'viewEiv'", EmoticonsIndicatorView.class);
    paramCommentFragment.viewEtv = (EmoticonsToolBarView)Utils.a(paramView, 2131301644, "field 'viewEtv'", EmoticonsToolBarView.class);
    paramCommentFragment.emoticonLayoutRoot = (SwitchPanelRelativeLayout)Utils.a(paramView, 2131296984, "field 'emoticonLayoutRoot'", SwitchPanelRelativeLayout.class);
    paramCommentFragment.flAnonymousComment = (FrameLayout)Utils.a(paramView, 2131297083, "field 'flAnonymousComment'", FrameLayout.class);
    paramCommentFragment.cbAnonymousComment = (CheckBox)Utils.a(paramView, 2131296666, "field 'cbAnonymousComment'", CheckBox.class);
  }
  
  public void unbind() {
    CommentFragment commentFragment = this.b;
    if (commentFragment != null) {
      this.b = null;
      commentFragment.keyboardLayout = null;
      commentFragment.topBar = null;
      commentFragment.topTitle = null;
      commentFragment.listView = null;
      commentFragment.keyboardView = null;
      commentFragment.refreshLayout = null;
      commentFragment.editView = null;
      commentFragment.iconEmoji = null;
      commentFragment.sendBtn = null;
      commentFragment.inputLayoutUp = null;
      commentFragment.layoutCommentAll = null;
      commentFragment.layoutAlbum = null;
      commentFragment.ivCommentHeader = null;
      commentFragment.spaceWithHeader = null;
      commentFragment.emoticonLayout = null;
      commentFragment.viewEpv = null;
      commentFragment.viewEiv = null;
      commentFragment.viewEtv = null;
      commentFragment.emoticonLayoutRoot = null;
      commentFragment.flAnonymousComment = null;
      commentFragment.cbAnonymousComment = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\CommentFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */