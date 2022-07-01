package com.blued.android.framework.view.wheel.widget;

import android.view.View;
import android.widget.LinearLayout;
import java.util.LinkedList;
import java.util.List;

public class WheelRecycle {
  private List<View> a;
  
  private List<View> b;
  
  private WheelView c;
  
  public WheelRecycle(WheelView paramWheelView) {
    this.c = paramWheelView;
  }
  
  private View a(List<View> paramList) {
    if (paramList != null && paramList.size() > 0) {
      View view = paramList.get(0);
      paramList.remove(0);
      return view;
    } 
    return null;
  }
  
  private List<View> a(View paramView, List<View> paramList) {
    List<View> list = paramList;
    if (paramList == null)
      list = new LinkedList<View>(); 
    list.add(paramView);
    return list;
  }
  
  private void a(View paramView, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Lcom/blued/android/framework/view/wheel/widget/WheelView;
    //   4: invokevirtual getViewAdapter : ()Lcom/blued/android/framework/view/wheel/widget/adapters/WheelViewAdapter;
    //   7: invokeinterface a : ()I
    //   12: istore #4
    //   14: iload_2
    //   15: iflt -> 26
    //   18: iload_2
    //   19: istore_3
    //   20: iload_2
    //   21: iload #4
    //   23: if_icmplt -> 52
    //   26: iload_2
    //   27: istore_3
    //   28: aload_0
    //   29: getfield c : Lcom/blued/android/framework/view/wheel/widget/WheelView;
    //   32: invokevirtual c : ()Z
    //   35: ifne -> 52
    //   38: aload_0
    //   39: aload_0
    //   40: aload_1
    //   41: aload_0
    //   42: getfield b : Ljava/util/List;
    //   45: invokespecial a : (Landroid/view/View;Ljava/util/List;)Ljava/util/List;
    //   48: putfield b : Ljava/util/List;
    //   51: return
    //   52: iload_3
    //   53: ifge -> 64
    //   56: iload_3
    //   57: iload #4
    //   59: iadd
    //   60: istore_3
    //   61: goto -> 52
    //   64: aload_0
    //   65: aload_0
    //   66: aload_1
    //   67: aload_0
    //   68: getfield a : Ljava/util/List;
    //   71: invokespecial a : (Landroid/view/View;Ljava/util/List;)Ljava/util/List;
    //   74: putfield a : Ljava/util/List;
    //   77: return
  }
  
  public int a(LinearLayout paramLinearLayout, int paramInt, ItemsRange paramItemsRange) {
    int k = 0;
    int j = paramInt;
    int i = paramInt;
    paramInt = j;
    j = k;
    while (j < paramLinearLayout.getChildCount()) {
      int m;
      if (!paramItemsRange.a(paramInt)) {
        a(paramLinearLayout.getChildAt(j), paramInt);
        paramLinearLayout.removeViewAt(j);
        k = j;
        m = i;
        if (j == 0) {
          m = i + 1;
          k = j;
        } 
      } else {
        k = j + 1;
        m = i;
      } 
      paramInt++;
      j = k;
      i = m;
    } 
    return i;
  }
  
  public View a() {
    return a(this.a);
  }
  
  public View b() {
    return a(this.b);
  }
  
  public void c() {
    List<View> list = this.a;
    if (list != null)
      list.clear(); 
    list = this.b;
    if (list != null)
      list.clear(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\wheel\widget\WheelRecycle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */