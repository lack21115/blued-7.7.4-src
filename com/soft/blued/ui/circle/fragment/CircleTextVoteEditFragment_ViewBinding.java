package com.soft.blued.ui.circle.fragment;

import android.view.View;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class CircleTextVoteEditFragment_ViewBinding implements Unbinder {
  private CircleTextVoteEditFragment b;
  
  private View c;
  
  public CircleTextVoteEditFragment_ViewBinding(CircleTextVoteEditFragment paramCircleTextVoteEditFragment, View paramView) {
    this.b = paramCircleTextVoteEditFragment;
    paramCircleTextVoteEditFragment.keyboardRelativeLayout = (KeyboardListenLinearLayout)Utils.a(paramView, 2131297981, "field 'keyboardRelativeLayout'", KeyboardListenLinearLayout.class);
    paramCircleTextVoteEditFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramCircleTextVoteEditFragment.edtContent = (EditText)Utils.a(paramView, 2131296974, "field 'edtContent'", EditText.class);
    paramCircleTextVoteEditFragment.recyclerView = (RecyclerView)Utils.a(paramView, 2131299605, "field 'recyclerView'", RecyclerView.class);
    paramView = Utils.a(paramView, 2131300045, "field 'stvAddOption' and method 'onViewClicked'");
    paramCircleTextVoteEditFragment.stvAddOption = (ShapeTextView)Utils.b(paramView, 2131300045, "field 'stvAddOption'", ShapeTextView.class);
    this.c = paramView;
    paramView.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCircleTextVoteEditFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
  }
  
  public void unbind() {
    CircleTextVoteEditFragment circleTextVoteEditFragment = this.b;
    if (circleTextVoteEditFragment != null) {
      this.b = null;
      circleTextVoteEditFragment.keyboardRelativeLayout = null;
      circleTextVoteEditFragment.title = null;
      circleTextVoteEditFragment.edtContent = null;
      circleTextVoteEditFragment.recyclerView = null;
      circleTextVoteEditFragment.stvAddOption = null;
      this.c.setOnClickListener(null);
      this.c = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleTextVoteEditFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */