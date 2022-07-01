package com.soft.blued.ui.discover.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.FloatFooterView;

public class ImageFeedFragment_ViewBinding implements Unbinder {
  private ImageFeedFragment b;
  
  public ImageFeedFragment_ViewBinding(ImageFeedFragment paramImageFeedFragment, View paramView) {
    this.b = paramImageFeedFragment;
    paramImageFeedFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramImageFeedFragment.mRecyclerView = (RecyclerView)Utils.a(paramView, 2131299605, "field 'mRecyclerView'", RecyclerView.class);
    paramImageFeedFragment.mRefreshLayout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'mRefreshLayout'", SmartRefreshLayout.class);
    paramImageFeedFragment.llFeedPost = (FloatFooterView)Utils.a(paramView, 2131298800, "field 'llFeedPost'", FloatFooterView.class);
  }
  
  public void unbind() {
    ImageFeedFragment imageFeedFragment = this.b;
    if (imageFeedFragment != null) {
      this.b = null;
      imageFeedFragment.title = null;
      imageFeedFragment.mRecyclerView = null;
      imageFeedFragment.mRefreshLayout = null;
      imageFeedFragment.llFeedPost = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\ImageFeedFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */