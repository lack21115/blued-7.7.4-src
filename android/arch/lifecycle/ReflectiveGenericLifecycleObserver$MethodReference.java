package android.arch.lifecycle;

import java.lang.reflect.Method;

final class ReflectiveGenericLifecycleObserver$MethodReference {
  final int mCallType;
  
  final Method mMethod;
  
  ReflectiveGenericLifecycleObserver$MethodReference(int paramInt, Method paramMethod) {
    this.mCallType = paramInt;
    this.mMethod = paramMethod;
    this.mMethod.setAccessible(true);
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      return (this.mCallType == ((ReflectiveGenericLifecycleObserver$MethodReference)paramObject).mCallType && this.mMethod.getName().equals(((ReflectiveGenericLifecycleObserver$MethodReference)paramObject).mMethod.getName()));
    } 
    return false;
  }
  
  public final int hashCode() {
    return this.mCallType * 31 + this.mMethod.getName().hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\arch\lifecycle\ReflectiveGenericLifecycleObserver$MethodReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */