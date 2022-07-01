package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionManager {
  static ArrayList<ViewGroup> a;
  
  private static Transition b = new AutoTransition();
  
  private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> e = new ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>>();
  
  private ArrayMap<Scene, Transition> c = new ArrayMap();
  
  private ArrayMap<Scene, ArrayMap<Scene, Transition>> d = new ArrayMap();
  
  static {
    a = new ArrayList<ViewGroup>();
  }
  
  static ArrayMap<ViewGroup, ArrayList<Transition>> a() {
    WeakReference<ArrayMap> weakReference1 = (WeakReference)e.get();
    if (weakReference1 != null) {
      ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap1 = weakReference1.get();
      if (arrayMap1 != null)
        return arrayMap1; 
    } 
    ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap = new ArrayMap();
    WeakReference<ArrayMap> weakReference2 = new WeakReference<ArrayMap>(arrayMap);
    e.set(weakReference2);
    return arrayMap;
  }
  
  private Transition a(Scene paramScene) {
    ViewGroup viewGroup = paramScene.getSceneRoot();
    if (viewGroup != null) {
      Scene scene = Scene.getCurrentScene(viewGroup);
      if (scene != null) {
        ArrayMap arrayMap = (ArrayMap)this.d.get(paramScene);
        if (arrayMap != null) {
          Transition transition1 = (Transition)arrayMap.get(scene);
          if (transition1 != null)
            return transition1; 
        } 
      } 
    } 
    Transition transition = (Transition)this.c.get(paramScene);
    return (transition != null) ? transition : b;
  }
  
  private static void a(ViewGroup paramViewGroup, Transition paramTransition) {
    if (paramTransition != null && paramViewGroup != null) {
      MultiListener multiListener = new MultiListener(paramTransition, paramViewGroup);
      paramViewGroup.addOnAttachStateChangeListener(multiListener);
      paramViewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
    } 
  }
  
  private static void a(Scene paramScene, Transition paramTransition) {
    ViewGroup viewGroup = paramScene.getSceneRoot();
    if (!a.contains(viewGroup)) {
      Scene scene = Scene.getCurrentScene(viewGroup);
      if (paramTransition == null) {
        if (scene != null)
          scene.exit(); 
        paramScene.enter();
        return;
      } 
      a.add(viewGroup);
      paramTransition = paramTransition.clone();
      paramTransition.c(viewGroup);
      if (scene != null && scene.a())
        paramTransition.b(true); 
      b(viewGroup, paramTransition);
      paramScene.enter();
      a(viewGroup, paramTransition);
    } 
  }
  
  private static void b(ViewGroup paramViewGroup, Transition paramTransition) {
    ArrayList arrayList = (ArrayList)a().get(paramViewGroup);
    if (arrayList != null && arrayList.size() > 0) {
      Iterator<Transition> iterator = arrayList.iterator();
      while (iterator.hasNext())
        ((Transition)iterator.next()).pause((View)paramViewGroup); 
    } 
    if (paramTransition != null)
      paramTransition.a(paramViewGroup, true); 
    Scene scene = Scene.getCurrentScene(paramViewGroup);
    if (scene != null)
      scene.exit(); 
  }
  
  public static void beginDelayedTransition(ViewGroup paramViewGroup) {
    beginDelayedTransition(paramViewGroup, null);
  }
  
  public static void beginDelayedTransition(ViewGroup paramViewGroup, Transition paramTransition) {
    if (!a.contains(paramViewGroup) && ViewCompat.isLaidOut((View)paramViewGroup)) {
      a.add(paramViewGroup);
      Transition transition = paramTransition;
      if (paramTransition == null)
        transition = b; 
      paramTransition = transition.clone();
      b(paramViewGroup, paramTransition);
      Scene.a(paramViewGroup, null);
      a(paramViewGroup, paramTransition);
    } 
  }
  
  public static void endTransitions(ViewGroup paramViewGroup) {
    a.remove(paramViewGroup);
    ArrayList<?> arrayList = (ArrayList)a().get(paramViewGroup);
    if (arrayList != null && !arrayList.isEmpty()) {
      arrayList = new ArrayList(arrayList);
      for (int i = arrayList.size() - 1; i >= 0; i--)
        ((Transition)arrayList.get(i)).b(paramViewGroup); 
    } 
  }
  
  public static void go(Scene paramScene) {
    a(paramScene, b);
  }
  
  public static void go(Scene paramScene, Transition paramTransition) {
    a(paramScene, paramTransition);
  }
  
  public void setTransition(Scene paramScene1, Scene paramScene2, Transition paramTransition) {
    ArrayMap arrayMap2 = (ArrayMap)this.d.get(paramScene2);
    ArrayMap arrayMap1 = arrayMap2;
    if (arrayMap2 == null) {
      arrayMap1 = new ArrayMap();
      this.d.put(paramScene2, arrayMap1);
    } 
    arrayMap1.put(paramScene1, paramTransition);
  }
  
  public void setTransition(Scene paramScene, Transition paramTransition) {
    this.c.put(paramScene, paramTransition);
  }
  
  public void transitionTo(Scene paramScene) {
    a(paramScene, a(paramScene));
  }
  
  static class MultiListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
    Transition a;
    
    ViewGroup b;
    
    MultiListener(Transition param1Transition, ViewGroup param1ViewGroup) {
      this.a = param1Transition;
      this.b = param1ViewGroup;
    }
    
    private void a() {
      this.b.getViewTreeObserver().removeOnPreDrawListener(this);
      this.b.removeOnAttachStateChangeListener(this);
    }
    
    public boolean onPreDraw() {
      ArrayList<?> arrayList1;
      a();
      if (!TransitionManager.a.remove(this.b))
        return true; 
      ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap = TransitionManager.a();
      ArrayList<?> arrayList2 = (ArrayList)arrayMap.get(this.b);
      ArrayList arrayList = null;
      if (arrayList2 == null) {
        arrayList1 = new ArrayList();
        arrayMap.put(this.b, arrayList1);
      } else {
        arrayList1 = arrayList2;
        if (arrayList2.size() > 0) {
          arrayList = new ArrayList(arrayList2);
          arrayList1 = arrayList2;
        } 
      } 
      arrayList1.add(this.a);
      this.a.addListener(new TransitionListenerAdapter(this, arrayMap) {
            public void onTransitionEnd(Transition param2Transition) {
              ((ArrayList)this.a.get(this.b.b)).remove(param2Transition);
              param2Transition.removeListener(this);
            }
          });
      this.a.a(this.b, false);
      if (arrayList != null) {
        Iterator<Transition> iterator = arrayList.iterator();
        while (iterator.hasNext())
          ((Transition)iterator.next()).resume((View)this.b); 
      } 
      this.a.a(this.b);
      return true;
    }
    
    public void onViewAttachedToWindow(View param1View) {}
    
    public void onViewDetachedFromWindow(View param1View) {
      a();
      TransitionManager.a.remove(this.b);
      ArrayList arrayList = (ArrayList)TransitionManager.a().get(this.b);
      if (arrayList != null && arrayList.size() > 0) {
        Iterator<Transition> iterator = arrayList.iterator();
        while (iterator.hasNext())
          ((Transition)iterator.next()).resume((View)this.b); 
      } 
      this.a.a(true);
    }
  }
  
  class null extends TransitionListenerAdapter {
    null(TransitionManager this$0, ArrayMap param1ArrayMap) {}
    
    public void onTransitionEnd(Transition param1Transition) {
      ((ArrayList)this.a.get(this.b.b)).remove(param1Transition);
      param1Transition.removeListener(this);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\TransitionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */