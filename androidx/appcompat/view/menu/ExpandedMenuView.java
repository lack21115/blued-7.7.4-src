package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.TintTypedArray;

public final class ExpandedMenuView extends ListView implements AdapterView.OnItemClickListener, MenuBuilder.ItemInvoker, MenuView {
  private static final int[] a = new int[] { 16842964, 16843049 };
  
  private MenuBuilder b;
  
  private int c;
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet);
    setOnItemClickListener(this);
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, a, paramInt, 0);
    if (tintTypedArray.hasValue(0))
      setBackgroundDrawable(tintTypedArray.getDrawable(0)); 
    if (tintTypedArray.hasValue(1))
      setDivider(tintTypedArray.getDrawable(1)); 
    tintTypedArray.recycle();
  }
  
  public int getWindowAnimations() {
    return this.c;
  }
  
  public void initialize(MenuBuilder paramMenuBuilder) {
    this.b = paramMenuBuilder;
  }
  
  public boolean invokeItem(MenuItemImpl paramMenuItemImpl) {
    return this.b.performItemAction((MenuItem)paramMenuItemImpl, 0);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    setChildrenDrawingCacheEnabled(false);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    invokeItem((MenuItemImpl)getAdapter().getItem(paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\ExpandedMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */