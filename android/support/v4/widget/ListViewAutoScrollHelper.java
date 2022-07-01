package android.support.v4.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

public final class ListViewAutoScrollHelper extends AutoScrollHelper {
  private final ListView mTarget;
  
  public ListViewAutoScrollHelper(ListView paramListView) {
    super((View)paramListView);
    this.mTarget = paramListView;
  }
  
  public final boolean canTargetScrollHorizontally$134632() {
    return false;
  }
  
  public final boolean canTargetScrollVertically(int paramInt) {
    ListView listView = this.mTarget;
    int i = listView.getCount();
    if (i == 0)
      return false; 
    int j = listView.getChildCount();
    int k = listView.getFirstVisiblePosition();
    if (paramInt > 0) {
      if (k + j >= i)
        return !(listView.getChildAt(j - 1).getBottom() <= listView.getHeight()); 
    } else {
      return (paramInt < 0) ? (!(k <= 0 && listView.getChildAt(0).getTop() >= 0)) : false;
    } 
    return true;
  }
  
  public final void scrollTargetBy$255f295(int paramInt) {
    ListView listView = this.mTarget;
    if (Build.VERSION.SDK_INT >= 19) {
      listView.scrollListBy(paramInt);
      return;
    } 
    int i = listView.getFirstVisiblePosition();
    if (i != -1) {
      View view = listView.getChildAt(0);
      if (view != null)
        listView.setSelectionFromTop(i, view.getTop() - paramInt); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\widget\ListViewAutoScrollHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */