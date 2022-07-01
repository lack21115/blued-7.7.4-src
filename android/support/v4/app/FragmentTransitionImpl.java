package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class FragmentTransitionImpl {
  static boolean containedBeforeIndex(List<View> paramList, View paramView, int paramInt) {
    for (int i = 0; i < paramInt; i++) {
      if (paramList.get(i) == paramView)
        return true; 
    } 
    return false;
  }
  
  protected static void getBoundsOnScreen(View paramView, Rect paramRect) {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  protected static boolean isNullOrEmpty(List paramList) {
    return (paramList == null || paramList.isEmpty());
  }
  
  static ArrayList prepareSetNameOverridesReordered(ArrayList<View> paramArrayList) {
    ArrayList<String> arrayList = new ArrayList();
    int j = paramArrayList.size();
    for (int i = 0; i < j; i++) {
      View view = paramArrayList.get(i);
      arrayList.add(ViewCompat.getTransitionName(view));
      ViewCompat.setTransitionName(view, null);
    } 
    return arrayList;
  }
  
  static void setNameOverridesReordered(View paramView, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, ArrayList paramArrayList3, Map paramMap) {
    int j = paramArrayList2.size();
    ArrayList<String> arrayList = new ArrayList();
    int i;
    for (i = 0; i < j; i++) {
      View view = paramArrayList1.get(i);
      String str = ViewCompat.getTransitionName(view);
      arrayList.add(str);
      if (str != null) {
        ViewCompat.setTransitionName(view, null);
        String str1 = (String)paramMap.get(str);
        int k;
        for (k = 0; k < j; k++) {
          if (str1.equals(paramArrayList3.get(k))) {
            ViewCompat.setTransitionName(paramArrayList2.get(k), str);
            break;
          } 
        } 
      } 
    } 
    OneShotPreDrawListener.add(paramView, new FragmentTransitionImpl$1(j, paramArrayList2, paramArrayList3, paramArrayList1, arrayList));
  }
  
  public abstract void addTarget(Object paramObject, View paramView);
  
  public abstract void addTargets(Object paramObject, ArrayList paramArrayList);
  
  public abstract void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject);
  
  public abstract boolean canHandle(Object paramObject);
  
  final void captureTransitioningViews(ArrayList<ViewGroup> paramArrayList, View paramView) {
    if (paramView.getVisibility() == 0) {
      ViewGroup viewGroup;
      if (paramView instanceof ViewGroup) {
        viewGroup = (ViewGroup)paramView;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
          paramArrayList.add(viewGroup);
          return;
        } 
        int j = viewGroup.getChildCount();
        for (int i = 0; i < j; i++)
          captureTransitioningViews(paramArrayList, viewGroup.getChildAt(i)); 
        return;
      } 
      paramArrayList.add(viewGroup);
    } 
  }
  
  public abstract Object cloneTransition(Object paramObject);
  
  final void findNamedViews(Map<String, View> paramMap, View paramView) {
    if (paramView.getVisibility() == 0) {
      String str = ViewCompat.getTransitionName(paramView);
      if (str != null)
        paramMap.put(str, paramView); 
      if (paramView instanceof ViewGroup) {
        ViewGroup viewGroup = (ViewGroup)paramView;
        int j = viewGroup.getChildCount();
        for (int i = 0; i < j; i++)
          findNamedViews(paramMap, viewGroup.getChildAt(i)); 
      } 
    } 
  }
  
  public abstract Object mergeTransitionsInSequence(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract Object mergeTransitionsTogether(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract void removeTarget(Object paramObject, View paramView);
  
  public abstract void replaceTargets(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2);
  
  public abstract void scheduleHideFragmentView(Object paramObject, View paramView, ArrayList paramArrayList);
  
  public abstract void scheduleRemoveTargets(Object paramObject1, Object paramObject2, ArrayList paramArrayList1, Object paramObject3, ArrayList paramArrayList2, Object paramObject4, ArrayList paramArrayList3);
  
  public abstract void setEpicenter(Object paramObject, Rect paramRect);
  
  public abstract void setEpicenter(Object paramObject, View paramView);
  
  public abstract void setSharedElementTargets(Object paramObject, View paramView, ArrayList paramArrayList);
  
  public abstract void swapSharedElementTargets(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2);
  
  public abstract Object wrapTransitionInSet(Object paramObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentTransitionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */