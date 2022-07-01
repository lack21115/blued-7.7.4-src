package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class FragmentTransitionImpl {
  static String a(Map<String, String> paramMap, String paramString) {
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      if (paramString.equals(entry.getValue()))
        return (String)entry.getKey(); 
    } 
    return null;
  }
  
  protected static void a(List<View> paramList, View paramView) {
    int j = paramList.size();
    if (a(paramList, paramView, j))
      return; 
    paramList.add(paramView);
    for (int i = j; i < paramList.size(); i++) {
      paramView = paramList.get(i);
      if (paramView instanceof ViewGroup) {
        ViewGroup viewGroup = (ViewGroup)paramView;
        int m = viewGroup.getChildCount();
        for (int k = 0; k < m; k++) {
          View view = viewGroup.getChildAt(k);
          if (!a(paramList, view, j))
            paramList.add(view); 
        } 
      } 
    } 
  }
  
  public static boolean a(List paramList) {
    return (paramList == null || paramList.isEmpty());
  }
  
  private static boolean a(List<View> paramList, View paramView, int paramInt) {
    for (int i = 0; i < paramInt; i++) {
      if (paramList.get(i) == paramView)
        return true; 
    } 
    return false;
  }
  
  ArrayList<String> a(ArrayList<View> paramArrayList) {
    ArrayList<String> arrayList = new ArrayList();
    int j = paramArrayList.size();
    for (int i = 0; i < j; i++) {
      View view = paramArrayList.get(i);
      arrayList.add(ViewCompat.getTransitionName(view));
      ViewCompat.setTransitionName(view, null);
    } 
    return arrayList;
  }
  
  protected void a(View paramView, Rect paramRect) {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  void a(View paramView, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, ArrayList<String> paramArrayList, Map<String, String> paramMap) {
    int j = paramArrayList2.size();
    ArrayList<String> arrayList = new ArrayList();
    int i;
    for (i = 0; i < j; i++) {
      View view = paramArrayList1.get(i);
      String str = ViewCompat.getTransitionName(view);
      arrayList.add(str);
      if (str != null) {
        ViewCompat.setTransitionName(view, null);
        String str1 = paramMap.get(str);
        int k;
        for (k = 0; k < j; k++) {
          if (str1.equals(paramArrayList.get(k))) {
            ViewCompat.setTransitionName(paramArrayList2.get(k), str);
            break;
          } 
        } 
      } 
    } 
    OneShotPreDrawListener.add(paramView, new Runnable(this, j, paramArrayList2, paramArrayList, paramArrayList1, arrayList) {
          public void run() {
            for (int i = 0; i < this.a; i++) {
              ViewCompat.setTransitionName(this.b.get(i), this.c.get(i));
              ViewCompat.setTransitionName(this.d.get(i), this.e.get(i));
            } 
          }
        });
  }
  
  void a(View paramView, ArrayList<View> paramArrayList, Map<String, String> paramMap) {
    OneShotPreDrawListener.add(paramView, new Runnable(this, paramArrayList, paramMap) {
          public void run() {
            int j = this.a.size();
            for (int i = 0; i < j; i++) {
              View view = this.a.get(i);
              String str = ViewCompat.getTransitionName(view);
              if (str != null)
                ViewCompat.setTransitionName(view, FragmentTransitionImpl.a(this.b, str)); 
            } 
          }
        });
  }
  
  void a(ViewGroup paramViewGroup, ArrayList<View> paramArrayList, Map<String, String> paramMap) {
    OneShotPreDrawListener.add((View)paramViewGroup, new Runnable(this, paramArrayList, paramMap) {
          public void run() {
            int j = this.a.size();
            for (int i = 0; i < j; i++) {
              View view = this.a.get(i);
              String str = ViewCompat.getTransitionName(view);
              ViewCompat.setTransitionName(view, (String)this.b.get(str));
            } 
          }
        });
  }
  
  void a(ArrayList<View> paramArrayList, View paramView) {
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
          a(paramArrayList, viewGroup.getChildAt(i)); 
      } else {
        paramArrayList.add(viewGroup);
      } 
    } 
  }
  
  void a(Map<String, View> paramMap, View paramView) {
    if (paramView.getVisibility() == 0) {
      String str = ViewCompat.getTransitionName(paramView);
      if (str != null)
        paramMap.put(str, paramView); 
      if (paramView instanceof ViewGroup) {
        ViewGroup viewGroup = (ViewGroup)paramView;
        int j = viewGroup.getChildCount();
        for (int i = 0; i < j; i++)
          a(paramMap, viewGroup.getChildAt(i)); 
      } 
    } 
  }
  
  public abstract void addTarget(Object paramObject, View paramView);
  
  public abstract void addTargets(Object paramObject, ArrayList<View> paramArrayList);
  
  public abstract void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject);
  
  public abstract boolean canHandle(Object paramObject);
  
  public abstract Object cloneTransition(Object paramObject);
  
  public abstract Object mergeTransitionsInSequence(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract Object mergeTransitionsTogether(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract void removeTarget(Object paramObject, View paramView);
  
  public abstract void replaceTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  public abstract void scheduleHideFragmentView(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  public abstract void scheduleRemoveTargets(Object paramObject1, Object paramObject2, ArrayList<View> paramArrayList1, Object paramObject3, ArrayList<View> paramArrayList2, Object paramObject4, ArrayList<View> paramArrayList3);
  
  public abstract void setEpicenter(Object paramObject, Rect paramRect);
  
  public abstract void setEpicenter(Object paramObject, View paramView);
  
  public abstract void setSharedElementTargets(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  public abstract void swapSharedElementTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  public abstract Object wrapTransitionInSet(Object paramObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\FragmentTransitionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */