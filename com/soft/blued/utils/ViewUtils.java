package com.soft.blued.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ViewUtils {
  public static List<View> a(View paramView) {
    ArrayList<View> arrayList = new ArrayList();
    ArrayList<ViewGroup> arrayList1 = new ArrayList();
    if (paramView == null)
      return arrayList; 
    if (paramView instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      LinkedList<ViewGroup> linkedList = new LinkedList();
      linkedList.add(viewGroup);
      while (!linkedList.isEmpty()) {
        viewGroup = linkedList.removeFirst();
        if (viewGroup.isClickable() && viewGroup.hasOnClickListeners())
          arrayList1.add(viewGroup); 
        for (int i = viewGroup.getChildCount() - 1; i >= 0; i--) {
          if (viewGroup.getChildAt(i) instanceof ViewGroup) {
            linkedList.addLast((ViewGroup)viewGroup.getChildAt(i));
          } else if (viewGroup.getChildAt(i).isClickable() && viewGroup.getChildAt(i).hasOnClickListeners()) {
            arrayList.add(viewGroup.getChildAt(i));
          } 
        } 
      } 
    } 
    arrayList.addAll(arrayList1);
    return arrayList;
  }
  
  public static void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    if (paramRecyclerView != null && paramRecyclerView.getLayoutManager() != null && paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager && paramInt1 >= 0)
      ((LinearLayoutManager)paramRecyclerView.getLayoutManager()).scrollToPositionWithOffset(paramInt1, paramInt2); 
  }
  
  public static boolean a(View paramView, MotionEvent paramMotionEvent) {
    if (paramView != null) {
      if (paramMotionEvent == null)
        return false; 
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[0];
      int j = arrayOfInt[1];
      if (paramMotionEvent.getRawX() >= i && paramMotionEvent.getRawX() <= (i + paramView.getWidth()) && paramMotionEvent.getRawY() >= j)
        return !(paramMotionEvent.getRawY() > (j + paramView.getHeight())); 
    } 
    return false;
  }
  
  public static int[] a(RecyclerView paramRecyclerView) {
    int[] arrayOfInt = new int[2];
    if (paramRecyclerView != null && paramRecyclerView.getLayoutManager() != null && paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
      LinearLayoutManager linearLayoutManager = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
      View view = linearLayoutManager.getChildAt(0);
      if (view != null) {
        arrayOfInt[0] = linearLayoutManager.getPosition(view);
        arrayOfInt[1] = view.getTop();
      } 
    } 
    return arrayOfInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */