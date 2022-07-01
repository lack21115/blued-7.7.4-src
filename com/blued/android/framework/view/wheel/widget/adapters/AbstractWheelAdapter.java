package com.blued.android.framework.view.wheel.widget.adapters;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWheelAdapter implements WheelViewAdapter {
  private List<DataSetObserver> a;
  
  public View a(View paramView, ViewGroup paramViewGroup) {
    return null;
  }
  
  public void a(DataSetObserver paramDataSetObserver) {
    if (this.a == null)
      this.a = new LinkedList<DataSetObserver>(); 
    this.a.add(paramDataSetObserver);
  }
  
  public void b(DataSetObserver paramDataSetObserver) {
    List<DataSetObserver> list = this.a;
    if (list != null)
      list.remove(paramDataSetObserver); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\wheel\widget\adapters\AbstractWheelAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */