package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;

public class MotionSpec {
  private final SimpleArrayMap<String, MotionTiming> a = new SimpleArrayMap();
  
  private final SimpleArrayMap<String, PropertyValuesHolder[]> b = new SimpleArrayMap();
  
  public static MotionSpec a(Context paramContext, int paramInt) {
    try {
      Animator animator = AnimatorInflater.loadAnimator(paramContext, paramInt);
      if (animator instanceof AnimatorSet)
        return a(((AnimatorSet)animator).getChildAnimations()); 
      if (animator != null) {
        ArrayList<Animator> arrayList = new ArrayList();
        arrayList.add(animator);
        return a(arrayList);
      } 
      return null;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Can't load animation resource ID #0x");
      stringBuilder.append(Integer.toHexString(paramInt));
      Log.w("MotionSpec", stringBuilder.toString(), exception);
      return null;
    } 
  }
  
  public static MotionSpec a(Context paramContext, TypedArray paramTypedArray, int paramInt) {
    if (paramTypedArray.hasValue(paramInt)) {
      paramInt = paramTypedArray.getResourceId(paramInt, 0);
      if (paramInt != 0)
        return a(paramContext, paramInt); 
    } 
    return null;
  }
  
  private static MotionSpec a(List<Animator> paramList) {
    MotionSpec motionSpec = new MotionSpec();
    int j = paramList.size();
    for (int i = 0; i < j; i++)
      a(motionSpec, paramList.get(i)); 
    return motionSpec;
  }
  
  private static void a(MotionSpec paramMotionSpec, Animator paramAnimator) {
    ObjectAnimator objectAnimator;
    if (paramAnimator instanceof ObjectAnimator) {
      objectAnimator = (ObjectAnimator)paramAnimator;
      paramMotionSpec.a(objectAnimator.getPropertyName(), objectAnimator.getValues());
      paramMotionSpec.a(objectAnimator.getPropertyName(), MotionTiming.a((ValueAnimator)objectAnimator));
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Animator must be an ObjectAnimator: ");
    stringBuilder.append(objectAnimator);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private PropertyValuesHolder[] a(PropertyValuesHolder[] paramArrayOfPropertyValuesHolder) {
    PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[paramArrayOfPropertyValuesHolder.length];
    for (int i = 0; i < paramArrayOfPropertyValuesHolder.length; i++)
      arrayOfPropertyValuesHolder[i] = paramArrayOfPropertyValuesHolder[i].clone(); 
    return arrayOfPropertyValuesHolder;
  }
  
  public long a() {
    int j = this.a.size();
    long l = 0L;
    for (int i = 0; i < j; i++) {
      MotionTiming motionTiming = (MotionTiming)this.a.valueAt(i);
      l = Math.max(l, motionTiming.a() + motionTiming.b());
    } 
    return l;
  }
  
  public <T> ObjectAnimator a(String paramString, T paramT, Property<T, ?> paramProperty) {
    ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(paramT, d(paramString));
    objectAnimator.setProperty(paramProperty);
    b(paramString).a((Animator)objectAnimator);
    return objectAnimator;
  }
  
  public void a(String paramString, MotionTiming paramMotionTiming) {
    this.a.put(paramString, paramMotionTiming);
  }
  
  public void a(String paramString, PropertyValuesHolder[] paramArrayOfPropertyValuesHolder) {
    this.b.put(paramString, paramArrayOfPropertyValuesHolder);
  }
  
  public boolean a(String paramString) {
    return (this.a.get(paramString) != null);
  }
  
  public MotionTiming b(String paramString) {
    if (a(paramString))
      return (MotionTiming)this.a.get(paramString); 
    throw new IllegalArgumentException();
  }
  
  public boolean c(String paramString) {
    return (this.b.get(paramString) != null);
  }
  
  public PropertyValuesHolder[] d(String paramString) {
    if (c(paramString))
      return a((PropertyValuesHolder[])this.b.get(paramString)); 
    throw new IllegalArgumentException();
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof MotionSpec))
      return false; 
    paramObject = paramObject;
    return this.a.equals(((MotionSpec)paramObject).a);
  }
  
  public int hashCode() {
    return this.a.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('\n');
    stringBuilder.append(getClass().getName());
    stringBuilder.append('{');
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" timings: ");
    stringBuilder.append(this.a);
    stringBuilder.append("}\n");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\animation\MotionSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */