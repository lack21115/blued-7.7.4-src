package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.blued.android.framework.R;

public class PullToRefreshGridView extends PullToRefreshAdapterViewBase<GridView> {
  public PullToRefreshGridView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  protected final GridView b(Context paramContext, AttributeSet paramAttributeSet) {
    InternalGridView internalGridView;
    if (Build.VERSION.SDK_INT >= 9) {
      internalGridView = new InternalGridViewSDK9(this, paramContext, paramAttributeSet);
    } else {
      internalGridView = new InternalGridView(this, (Context)internalGridView, paramAttributeSet);
    } 
    internalGridView.setId(R.id.gridview);
    return internalGridView;
  }
  
  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
    return PullToRefreshBase.Orientation.a;
  }
  
  class InternalGridView extends GridView implements EmptyViewMethodAccessor {
    public InternalGridView(PullToRefreshGridView this$0, Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
    }
    
    public void setEmptyView(View param1View) {
      this.a.setEmptyView(param1View);
    }
    
    public void setEmptyViewInternal(View param1View) {
      super.setEmptyView(param1View);
    }
  }
  
  final class InternalGridViewSDK9 extends InternalGridView {
    public InternalGridViewSDK9(PullToRefreshGridView this$0, Context param1Context, AttributeSet param1AttributeSet) {
      super(this$0, param1Context, param1AttributeSet);
    }
    
    protected boolean overScrollBy(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, int param1Int8, boolean param1Boolean) {
      boolean bool = super.overScrollBy(param1Int1, param1Int2, param1Int3, param1Int4, param1Int5, param1Int6, param1Int7, param1Int8, param1Boolean);
      OverscrollHelper.a(this.b, param1Int1, param1Int3, param1Int2, param1Int4, param1Boolean);
      return bool;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\PullToRefreshGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */