package androidx.transition;

import android.view.View;

public abstract class VisibilityPropagation extends TransitionPropagation {
  private static final String[] a = new String[] { "android:visibilityPropagation:visibility", "android:visibilityPropagation:center" };
  
  private static int a(TransitionValues paramTransitionValues, int paramInt) {
    if (paramTransitionValues == null)
      return -1; 
    int[] arrayOfInt = (int[])paramTransitionValues.values.get("android:visibilityPropagation:center");
    return (arrayOfInt == null) ? -1 : arrayOfInt[paramInt];
  }
  
  public void captureValues(TransitionValues paramTransitionValues) {
    View view = paramTransitionValues.view;
    Integer integer2 = (Integer)paramTransitionValues.values.get("android:visibility:visibility");
    Integer integer1 = integer2;
    if (integer2 == null)
      integer1 = Integer.valueOf(view.getVisibility()); 
    paramTransitionValues.values.put("android:visibilityPropagation:visibility", integer1);
    int[] arrayOfInt = new int[2];
    view.getLocationOnScreen(arrayOfInt);
    arrayOfInt[0] = arrayOfInt[0] + Math.round(view.getTranslationX());
    arrayOfInt[0] = arrayOfInt[0] + view.getWidth() / 2;
    arrayOfInt[1] = arrayOfInt[1] + Math.round(view.getTranslationY());
    arrayOfInt[1] = arrayOfInt[1] + view.getHeight() / 2;
    paramTransitionValues.values.put("android:visibilityPropagation:center", arrayOfInt);
  }
  
  public String[] getPropagationProperties() {
    return a;
  }
  
  public int getViewVisibility(TransitionValues paramTransitionValues) {
    if (paramTransitionValues == null)
      return 8; 
    Integer integer = (Integer)paramTransitionValues.values.get("android:visibilityPropagation:visibility");
    return (integer == null) ? 8 : integer.intValue();
  }
  
  public int getViewX(TransitionValues paramTransitionValues) {
    return a(paramTransitionValues, 0);
  }
  
  public int getViewY(TransitionValues paramTransitionValues) {
    return a(paramTransitionValues, 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\VisibilityPropagation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */