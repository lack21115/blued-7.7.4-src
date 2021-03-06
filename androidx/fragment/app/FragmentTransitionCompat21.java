package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

class FragmentTransitionCompat21 extends FragmentTransitionImpl {
  private static boolean a(Transition paramTransition) {
    return (!a(paramTransition.getTargetIds()) || !a(paramTransition.getTargetNames()) || !a(paramTransition.getTargetTypes()));
  }
  
  public void addTarget(Object paramObject, View paramView) {
    if (paramObject != null)
      ((Transition)paramObject).addTarget(paramView); 
  }
  
  public void addTargets(Object paramObject, ArrayList<View> paramArrayList) {
    paramObject = paramObject;
    if (paramObject == null)
      return; 
    boolean bool = paramObject instanceof TransitionSet;
    int j = 0;
    int i = 0;
    if (bool) {
      paramObject = paramObject;
      j = paramObject.getTransitionCount();
      while (i < j) {
        addTargets(paramObject.getTransitionAt(i), paramArrayList);
        i++;
      } 
    } else if (!a((Transition)paramObject) && a(paramObject.getTargets())) {
      int k = paramArrayList.size();
      for (i = j; i < k; i++)
        paramObject.addTarget(paramArrayList.get(i)); 
    } 
  }
  
  public void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject) {
    TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject);
  }
  
  public boolean canHandle(Object paramObject) {
    return paramObject instanceof Transition;
  }
  
  public Object cloneTransition(Object paramObject) {
    return (paramObject != null) ? ((Transition)paramObject).clone() : null;
  }
  
  public Object mergeTransitionsInSequence(Object paramObject1, Object paramObject2, Object paramObject3) {
    paramObject1 = paramObject1;
    paramObject2 = paramObject2;
    paramObject3 = paramObject3;
    if (paramObject1 != null && paramObject2 != null) {
      paramObject1 = (new TransitionSet()).addTransition((Transition)paramObject1).addTransition((Transition)paramObject2).setOrdering(1);
    } else if (paramObject1 == null) {
      if (paramObject2 != null) {
        paramObject1 = paramObject2;
      } else {
        paramObject1 = null;
      } 
    } 
    if (paramObject3 != null) {
      paramObject2 = new TransitionSet();
      if (paramObject1 != null)
        paramObject2.addTransition((Transition)paramObject1); 
      paramObject2.addTransition((Transition)paramObject3);
      return paramObject2;
    } 
    return paramObject1;
  }
  
  public Object mergeTransitionsTogether(Object paramObject1, Object paramObject2, Object paramObject3) {
    TransitionSet transitionSet = new TransitionSet();
    if (paramObject1 != null)
      transitionSet.addTransition((Transition)paramObject1); 
    if (paramObject2 != null)
      transitionSet.addTransition((Transition)paramObject2); 
    if (paramObject3 != null)
      transitionSet.addTransition((Transition)paramObject3); 
    return transitionSet;
  }
  
  public void removeTarget(Object paramObject, View paramView) {
    if (paramObject != null)
      ((Transition)paramObject).removeTarget(paramView); 
  }
  
  public void replaceTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2) {
    paramObject = paramObject;
    boolean bool = paramObject instanceof TransitionSet;
    int j = 0;
    int i = 0;
    if (bool) {
      paramObject = paramObject;
      j = paramObject.getTransitionCount();
      while (i < j) {
        replaceTargets(paramObject.getTransitionAt(i), paramArrayList1, paramArrayList2);
        i++;
      } 
    } else if (!a((Transition)paramObject)) {
      List list = paramObject.getTargets();
      if (list != null && list.size() == paramArrayList1.size() && list.containsAll(paramArrayList1)) {
        if (paramArrayList2 == null) {
          i = 0;
        } else {
          i = paramArrayList2.size();
        } 
        while (j < i) {
          paramObject.addTarget(paramArrayList2.get(j));
          j++;
        } 
        for (i = paramArrayList1.size() - 1; i >= 0; i--)
          paramObject.removeTarget(paramArrayList1.get(i)); 
      } 
    } 
  }
  
  public void scheduleHideFragmentView(Object paramObject, View paramView, ArrayList<View> paramArrayList) {
    ((Transition)paramObject).addListener(new Transition.TransitionListener(this, paramView, paramArrayList) {
          public void onTransitionCancel(Transition param1Transition) {}
          
          public void onTransitionEnd(Transition param1Transition) {
            param1Transition.removeListener(this);
            this.a.setVisibility(8);
            int j = this.b.size();
            for (int i = 0; i < j; i++)
              ((View)this.b.get(i)).setVisibility(0); 
          }
          
          public void onTransitionPause(Transition param1Transition) {}
          
          public void onTransitionResume(Transition param1Transition) {}
          
          public void onTransitionStart(Transition param1Transition) {}
        });
  }
  
  public void scheduleRemoveTargets(Object paramObject1, Object paramObject2, ArrayList<View> paramArrayList1, Object paramObject3, ArrayList<View> paramArrayList2, Object paramObject4, ArrayList<View> paramArrayList3) {
    ((Transition)paramObject1).addListener(new Transition.TransitionListener(this, paramObject2, paramArrayList1, paramObject3, paramArrayList2, paramObject4, paramArrayList3) {
          public void onTransitionCancel(Transition param1Transition) {}
          
          public void onTransitionEnd(Transition param1Transition) {
            param1Transition.removeListener(this);
          }
          
          public void onTransitionPause(Transition param1Transition) {}
          
          public void onTransitionResume(Transition param1Transition) {}
          
          public void onTransitionStart(Transition param1Transition) {
            Object object = this.a;
            if (object != null)
              this.g.replaceTargets(object, this.b, (ArrayList<View>)null); 
            object = this.c;
            if (object != null)
              this.g.replaceTargets(object, this.d, (ArrayList<View>)null); 
            object = this.e;
            if (object != null)
              this.g.replaceTargets(object, this.f, (ArrayList<View>)null); 
          }
        });
  }
  
  public void setEpicenter(Object paramObject, Rect paramRect) {
    if (paramObject != null)
      ((Transition)paramObject).setEpicenterCallback(new Transition.EpicenterCallback(this, paramRect) {
            public Rect onGetEpicenter(Transition param1Transition) {
              Rect rect = this.a;
              return (rect == null || rect.isEmpty()) ? null : this.a;
            }
          }); 
  }
  
  public void setEpicenter(Object paramObject, View paramView) {
    if (paramView != null) {
      paramObject = paramObject;
      Rect rect = new Rect();
      a(paramView, rect);
      paramObject.setEpicenterCallback(new Transition.EpicenterCallback(this, rect) {
            public Rect onGetEpicenter(Transition param1Transition) {
              return this.a;
            }
          });
    } 
  }
  
  public void setSharedElementTargets(Object paramObject, View paramView, ArrayList<View> paramArrayList) {
    paramObject = paramObject;
    List<View> list = paramObject.getTargets();
    list.clear();
    int j = paramArrayList.size();
    int i;
    for (i = 0; i < j; i++)
      a(list, paramArrayList.get(i)); 
    list.add(paramView);
    paramArrayList.add(paramView);
    addTargets(paramObject, paramArrayList);
  }
  
  public void swapSharedElementTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2) {
    paramObject = paramObject;
    if (paramObject != null) {
      paramObject.getTargets().clear();
      paramObject.getTargets().addAll(paramArrayList2);
      replaceTargets(paramObject, paramArrayList1, paramArrayList2);
    } 
  }
  
  public Object wrapTransitionInSet(Object paramObject) {
    if (paramObject == null)
      return null; 
    TransitionSet transitionSet = new TransitionSet();
    transitionSet.addTransition((Transition)paramObject);
    return transitionSet;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\FragmentTransitionCompat21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */