package com.chad.library.adapter.base.listener;

import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class SimpleClickListener implements RecyclerView.OnItemTouchListener {
  public static String a = "SimpleClickListener";
  
  protected BaseQuickAdapter b;
  
  private RecyclerView c;
  
  private boolean d = false;
  
  private boolean e = false;
  
  private View f = null;
  
  private void a(MotionEvent paramMotionEvent, View paramView) {
    if (Build.VERSION.SDK_INT >= 21 && paramView != null && paramView.getBackground() != null)
      paramView.getBackground().setHotspot(paramMotionEvent.getRawX(), paramMotionEvent.getY() - paramView.getY()); 
  }
  
  private boolean a(int paramInt) {
    BaseQuickAdapter baseQuickAdapter = this.b;
    boolean bool = false;
    if (baseQuickAdapter == null) {
      RecyclerView recyclerView = this.c;
      if (recyclerView != null) {
        this.b = (BaseQuickAdapter)recyclerView.getAdapter();
      } else {
        return false;
      } 
    } 
    paramInt = this.b.getItemViewType(paramInt);
    if (paramInt == 1365 || paramInt == 273 || paramInt == 819 || paramInt == 546)
      bool = true; 
    return bool;
  }
  
  public abstract void a(BaseQuickAdapter paramBaseQuickAdapter, View paramView, int paramInt);
  
  public boolean a(View paramView, MotionEvent paramMotionEvent) {
    int[] arrayOfInt = new int[2];
    if (paramView != null) {
      if (!paramView.isShown())
        return false; 
      paramView.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[0];
      int j = arrayOfInt[1];
      if (paramMotionEvent.getRawX() >= i && paramMotionEvent.getRawX() <= (i + paramView.getWidth()) && paramMotionEvent.getRawY() >= j)
        return !(paramMotionEvent.getRawY() > (j + paramView.getHeight())); 
    } 
    return false;
  }
  
  public abstract void b(BaseQuickAdapter paramBaseQuickAdapter, View paramView, int paramInt);
  
  public abstract void c(BaseQuickAdapter paramBaseQuickAdapter, View paramView, int paramInt);
  
  public abstract void d(BaseQuickAdapter paramBaseQuickAdapter, View paramView, int paramInt);
  
  class ItemTouchHelperGestureListener implements GestureDetector.OnGestureListener {
    private RecyclerView b;
    
    private void a(View param1View) {
      if (param1View != null)
        param1View.postDelayed(new Runnable(this, param1View) {
              public void run() {
                View view = this.a;
                if (view != null)
                  view.setPressed(false); 
              }
            }50L); 
      SimpleClickListener.a(this.a, false);
      SimpleClickListener.a(this.a, (View)null);
    }
    
    public boolean onDown(MotionEvent param1MotionEvent) {
      SimpleClickListener.a(this.a, true);
      SimpleClickListener.a(this.a, this.b.findChildViewUnder(param1MotionEvent.getX(), param1MotionEvent.getY()));
      return false;
    }
    
    public boolean onFling(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
      return false;
    }
    
    public void onLongPress(MotionEvent param1MotionEvent) {
      // Byte code:
      //   0: aload_0
      //   1: getfield b : Landroidx/recyclerview/widget/RecyclerView;
      //   4: invokevirtual getScrollState : ()I
      //   7: ifeq -> 11
      //   10: return
      //   11: aload_0
      //   12: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   15: invokestatic a : (Lcom/chad/library/adapter/base/listener/SimpleClickListener;)Z
      //   18: ifeq -> 394
      //   21: aload_0
      //   22: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   25: invokestatic b : (Lcom/chad/library/adapter/base/listener/SimpleClickListener;)Landroid/view/View;
      //   28: ifnull -> 394
      //   31: aload_0
      //   32: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   35: invokestatic b : (Lcom/chad/library/adapter/base/listener/SimpleClickListener;)Landroid/view/View;
      //   38: iconst_0
      //   39: invokevirtual performHapticFeedback : (I)Z
      //   42: pop
      //   43: aload_0
      //   44: getfield b : Landroidx/recyclerview/widget/RecyclerView;
      //   47: aload_0
      //   48: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   51: invokestatic b : (Lcom/chad/library/adapter/base/listener/SimpleClickListener;)Landroid/view/View;
      //   54: invokevirtual getChildViewHolder : (Landroid/view/View;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
      //   57: checkcast com/chad/library/adapter/base/BaseViewHolder
      //   60: astore #4
      //   62: aload_0
      //   63: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   66: aload #4
      //   68: invokevirtual getLayoutPosition : ()I
      //   71: invokestatic a : (Lcom/chad/library/adapter/base/listener/SimpleClickListener;I)Z
      //   74: ifne -> 394
      //   77: aload #4
      //   79: invokevirtual x : ()Ljava/util/HashSet;
      //   82: astore_3
      //   83: aload #4
      //   85: invokevirtual w : ()Ljava/util/Set;
      //   88: astore #6
      //   90: aload_3
      //   91: ifnull -> 255
      //   94: aload_3
      //   95: invokeinterface size : ()I
      //   100: ifle -> 255
      //   103: aload_3
      //   104: invokeinterface iterator : ()Ljava/util/Iterator;
      //   109: astore #7
      //   111: aload #7
      //   113: invokeinterface hasNext : ()Z
      //   118: ifeq -> 255
      //   121: aload #7
      //   123: invokeinterface next : ()Ljava/lang/Object;
      //   128: checkcast java/lang/Integer
      //   131: astore #8
      //   133: aload_0
      //   134: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   137: invokestatic b : (Lcom/chad/library/adapter/base/listener/SimpleClickListener;)Landroid/view/View;
      //   140: aload #8
      //   142: invokevirtual intValue : ()I
      //   145: invokevirtual findViewById : (I)Landroid/view/View;
      //   148: astore #5
      //   150: aload_0
      //   151: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   154: aload #5
      //   156: aload_1
      //   157: invokevirtual a : (Landroid/view/View;Landroid/view/MotionEvent;)Z
      //   160: ifeq -> 111
      //   163: aload #5
      //   165: invokevirtual isEnabled : ()Z
      //   168: ifeq -> 111
      //   171: aload #6
      //   173: ifnull -> 191
      //   176: aload #6
      //   178: aload #8
      //   180: invokeinterface contains : (Ljava/lang/Object;)Z
      //   185: ifeq -> 191
      //   188: goto -> 250
      //   191: aload_0
      //   192: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   195: aload_1
      //   196: aload #5
      //   198: invokestatic a : (Lcom/chad/library/adapter/base/listener/SimpleClickListener;Landroid/view/MotionEvent;Landroid/view/View;)V
      //   201: aload_0
      //   202: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   205: astore #6
      //   207: aload #6
      //   209: aload #6
      //   211: getfield b : Lcom/chad/library/adapter/base/BaseQuickAdapter;
      //   214: aload #5
      //   216: aload #4
      //   218: invokevirtual getLayoutPosition : ()I
      //   221: aload_0
      //   222: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   225: getfield b : Lcom/chad/library/adapter/base/BaseQuickAdapter;
      //   228: invokevirtual o : ()I
      //   231: isub
      //   232: invokevirtual d : (Lcom/chad/library/adapter/base/BaseQuickAdapter;Landroid/view/View;I)V
      //   235: aload #5
      //   237: iconst_1
      //   238: invokevirtual setPressed : (Z)V
      //   241: aload_0
      //   242: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   245: iconst_1
      //   246: invokestatic b : (Lcom/chad/library/adapter/base/listener/SimpleClickListener;Z)Z
      //   249: pop
      //   250: iconst_1
      //   251: istore_2
      //   252: goto -> 257
      //   255: iconst_0
      //   256: istore_2
      //   257: iload_2
      //   258: ifne -> 394
      //   261: aload_0
      //   262: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   265: astore #5
      //   267: aload #5
      //   269: aload #5
      //   271: getfield b : Lcom/chad/library/adapter/base/BaseQuickAdapter;
      //   274: aload_0
      //   275: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   278: invokestatic b : (Lcom/chad/library/adapter/base/listener/SimpleClickListener;)Landroid/view/View;
      //   281: aload #4
      //   283: invokevirtual getLayoutPosition : ()I
      //   286: aload_0
      //   287: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   290: getfield b : Lcom/chad/library/adapter/base/BaseQuickAdapter;
      //   293: invokevirtual o : ()I
      //   296: isub
      //   297: invokevirtual b : (Lcom/chad/library/adapter/base/BaseQuickAdapter;Landroid/view/View;I)V
      //   300: aload_0
      //   301: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   304: astore #4
      //   306: aload #4
      //   308: aload_1
      //   309: aload #4
      //   311: invokestatic b : (Lcom/chad/library/adapter/base/listener/SimpleClickListener;)Landroid/view/View;
      //   314: invokestatic a : (Lcom/chad/library/adapter/base/listener/SimpleClickListener;Landroid/view/MotionEvent;Landroid/view/View;)V
      //   317: aload_0
      //   318: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   321: invokestatic b : (Lcom/chad/library/adapter/base/listener/SimpleClickListener;)Landroid/view/View;
      //   324: iconst_1
      //   325: invokevirtual setPressed : (Z)V
      //   328: aload_3
      //   329: ifnull -> 385
      //   332: aload_3
      //   333: invokeinterface iterator : ()Ljava/util/Iterator;
      //   338: astore_1
      //   339: aload_1
      //   340: invokeinterface hasNext : ()Z
      //   345: ifeq -> 385
      //   348: aload_1
      //   349: invokeinterface next : ()Ljava/lang/Object;
      //   354: checkcast java/lang/Integer
      //   357: astore_3
      //   358: aload_0
      //   359: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   362: invokestatic b : (Lcom/chad/library/adapter/base/listener/SimpleClickListener;)Landroid/view/View;
      //   365: aload_3
      //   366: invokevirtual intValue : ()I
      //   369: invokevirtual findViewById : (I)Landroid/view/View;
      //   372: astore_3
      //   373: aload_3
      //   374: ifnull -> 339
      //   377: aload_3
      //   378: iconst_0
      //   379: invokevirtual setPressed : (Z)V
      //   382: goto -> 339
      //   385: aload_0
      //   386: getfield a : Lcom/chad/library/adapter/base/listener/SimpleClickListener;
      //   389: iconst_1
      //   390: invokestatic b : (Lcom/chad/library/adapter/base/listener/SimpleClickListener;Z)Z
      //   393: pop
      //   394: return
    }
    
    public boolean onScroll(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
      return false;
    }
    
    public void onShowPress(MotionEvent param1MotionEvent) {
      if (SimpleClickListener.a(this.a) && SimpleClickListener.b(this.a) != null)
        SimpleClickListener.b(this.a, true); 
    }
    
    public boolean onSingleTapUp(MotionEvent param1MotionEvent) {
      if (SimpleClickListener.a(this.a) && SimpleClickListener.b(this.a) != null) {
        SimpleClickListener simpleClickListener;
        if (this.b.getScrollState() != 0)
          return false; 
        View view = SimpleClickListener.b(this.a);
        BaseViewHolder baseViewHolder = (BaseViewHolder)this.b.getChildViewHolder(view);
        if (SimpleClickListener.a(this.a, baseViewHolder.getLayoutPosition()))
          return false; 
        HashSet hashSet = baseViewHolder.y();
        Set set = baseViewHolder.w();
        if (hashSet != null && hashSet.size() > 0) {
          SimpleClickListener simpleClickListener1;
          for (Integer integer : hashSet) {
            View view1 = view.findViewById(integer.intValue());
            if (view1 != null) {
              if (this.a.a(view1, param1MotionEvent) && view1.isEnabled()) {
                if (set != null && set.contains(integer))
                  return false; 
                SimpleClickListener.a(this.a, param1MotionEvent, view1);
                view1.setPressed(true);
                simpleClickListener1 = this.a;
                simpleClickListener1.c(simpleClickListener1.b, view1, baseViewHolder.getLayoutPosition() - this.a.b.o());
                a(view1);
                return true;
              } 
              view1.setPressed(false);
            } 
          } 
          SimpleClickListener.a(this.a, (MotionEvent)simpleClickListener1, view);
          SimpleClickListener.b(this.a).setPressed(true);
          Iterator<Integer> iterator = hashSet.iterator();
          while (iterator.hasNext()) {
            View view1 = view.findViewById(((Integer)iterator.next()).intValue());
            if (view1 != null)
              view1.setPressed(false); 
          } 
          simpleClickListener = this.a;
          simpleClickListener.a(simpleClickListener.b, view, baseViewHolder.getLayoutPosition() - this.a.b.o());
        } else {
          SimpleClickListener.a(this.a, (MotionEvent)simpleClickListener, view);
          SimpleClickListener.b(this.a).setPressed(true);
          if (hashSet != null && hashSet.size() > 0) {
            Iterator<Integer> iterator = hashSet.iterator();
            while (iterator.hasNext()) {
              View view1 = view.findViewById(((Integer)iterator.next()).intValue());
              if (view1 != null)
                view1.setPressed(false); 
            } 
          } 
          simpleClickListener = this.a;
          simpleClickListener.a(simpleClickListener.b, view, baseViewHolder.getLayoutPosition() - this.a.b.o());
        } 
        a(view);
      } 
      return true;
    }
  }
  
  class null implements Runnable {
    null(SimpleClickListener this$0, View param1View) {}
    
    public void run() {
      View view = this.a;
      if (view != null)
        view.setPressed(false); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\chad\library\adapter\base\listener\SimpleClickListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */