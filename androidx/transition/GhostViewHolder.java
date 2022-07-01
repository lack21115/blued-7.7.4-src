package androidx.transition;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.ArrayList;

class GhostViewHolder extends FrameLayout {
  private ViewGroup a;
  
  private boolean b;
  
  GhostViewHolder(ViewGroup paramViewGroup) {
    super(paramViewGroup.getContext());
    setClipChildren(false);
    this.a = paramViewGroup;
    this.a.setTag(R.id.ghost_view_holder, this);
    ViewGroupUtils.a(this.a).add((View)this);
    this.b = true;
  }
  
  private int a(ArrayList<View> paramArrayList) {
    ArrayList<View> arrayList = new ArrayList();
    int i = getChildCount() - 1;
    int j = 0;
    while (j <= i) {
      int k = (j + i) / 2;
      a(((GhostViewPort)getChildAt(k)).c, arrayList);
      if (a(paramArrayList, arrayList)) {
        j = k + 1;
      } else {
        i = k - 1;
      } 
      arrayList.clear();
    } 
    return j;
  }
  
  static GhostViewHolder a(ViewGroup paramViewGroup) {
    return (GhostViewHolder)paramViewGroup.getTag(R.id.ghost_view_holder);
  }
  
  private static void a(View paramView, ArrayList<View> paramArrayList) {
    ViewParent viewParent = paramView.getParent();
    if (viewParent instanceof ViewGroup)
      a((View)viewParent, paramArrayList); 
    paramArrayList.add(paramView);
  }
  
  private static boolean a(View paramView1, View paramView2) {
    ViewGroup viewGroup = (ViewGroup)paramView1.getParent();
    int j = viewGroup.getChildCount();
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 21 && paramView1.getZ() != paramView2.getZ()) {
      if (paramView1.getZ() > paramView2.getZ())
        bool = true; 
      return bool;
    } 
    for (i = 0; i < j; i++) {
      View view = viewGroup.getChildAt(ViewGroupUtils.a(viewGroup, i));
      if (view == paramView1)
        return false; 
      if (view == paramView2)
        return true; 
    } 
    return true;
  }
  
  private static boolean a(ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2) {
    if (!paramArrayList1.isEmpty() && !paramArrayList2.isEmpty()) {
      boolean bool = false;
      if (paramArrayList1.get(0) != paramArrayList2.get(0))
        return true; 
      int j = Math.min(paramArrayList1.size(), paramArrayList2.size());
      for (int i = 1; i < j; i++) {
        View view1 = paramArrayList1.get(i);
        View view2 = paramArrayList2.get(i);
        if (view1 != view2)
          return a(view1, view2); 
      } 
      if (paramArrayList2.size() == j)
        bool = true; 
      return bool;
    } 
    return true;
  }
  
  void a() {
    if (this.b) {
      ViewGroupUtils.a(this.a).remove((View)this);
      ViewGroupUtils.a(this.a).add((View)this);
      return;
    } 
    throw new IllegalStateException("This GhostViewHolder is detached!");
  }
  
  void a(GhostViewPort paramGhostViewPort) {
    ArrayList<View> arrayList = new ArrayList();
    a(paramGhostViewPort.c, arrayList);
    int i = a(arrayList);
    if (i < 0 || i >= getChildCount()) {
      addView((View)paramGhostViewPort);
      return;
    } 
    addView((View)paramGhostViewPort, i);
  }
  
  public void onViewAdded(View paramView) {
    if (this.b) {
      super.onViewAdded(paramView);
      return;
    } 
    throw new IllegalStateException("This GhostViewHolder is detached!");
  }
  
  public void onViewRemoved(View paramView) {
    super.onViewRemoved(paramView);
    if ((getChildCount() == 1 && getChildAt(0) == paramView) || getChildCount() == 0) {
      this.a.setTag(R.id.ghost_view_holder, null);
      ViewGroupUtils.a(this.a).remove((View)this);
      this.b = false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\GhostViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */