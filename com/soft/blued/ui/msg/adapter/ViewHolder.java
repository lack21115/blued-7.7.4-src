package com.soft.blued.ui.msg.adapter;

import android.util.SparseArray;
import android.view.View;

public class ViewHolder {
  public static <T extends View> T a(View paramView, int paramInt) {
    SparseArray sparseArray2 = (SparseArray)paramView.getTag();
    SparseArray sparseArray1 = sparseArray2;
    if (sparseArray2 == null) {
      sparseArray1 = new SparseArray();
      paramView.setTag(sparseArray1);
    } 
    View view2 = (View)sparseArray1.get(paramInt);
    View view1 = view2;
    if (view2 == null) {
      view1 = paramView.findViewById(paramInt);
      sparseArray1.put(paramInt, view1);
    } 
    return (T)view1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\ViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */