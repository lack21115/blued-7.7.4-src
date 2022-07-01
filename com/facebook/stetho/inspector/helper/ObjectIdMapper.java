package com.facebook.stetho.inspector.helper;

import android.util.SparseArray;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class ObjectIdMapper {
  private SparseArray<Object> mIdToObjectMap = new SparseArray();
  
  private int mNextId = 1;
  
  private final Map<Object, Integer> mObjectToIdMap = new IdentityHashMap<Object, Integer>();
  
  protected final Object mSync = new Object();
  
  public void clear() {
    synchronized (this.mSync) {
      SparseArray<Object> sparseArray = this.mIdToObjectMap;
      this.mObjectToIdMap.clear();
      this.mIdToObjectMap = new SparseArray();
      int j = sparseArray.size();
      for (int i = 0; i < j; i++) {
        int k = sparseArray.keyAt(i);
        onUnmapped(sparseArray.valueAt(i), k);
      } 
      return;
    } 
  }
  
  public boolean containsId(int paramInt) {
    synchronized (this.mSync) {
      if (this.mIdToObjectMap.get(paramInt) != null)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_3} */
    return bool;
  }
  
  public boolean containsObject(Object paramObject) {
    synchronized (this.mSync) {
      return this.mObjectToIdMap.containsKey(paramObject);
    } 
  }
  
  @Nullable
  public Integer getIdForObject(Object paramObject) {
    synchronized (this.mSync) {
      paramObject = this.mObjectToIdMap.get(paramObject);
      return (Integer)paramObject;
    } 
  }
  
  @Nullable
  public Object getObjectForId(int paramInt) {
    synchronized (this.mSync) {
      return this.mIdToObjectMap.get(paramInt);
    } 
  }
  
  protected void onMapped(Object paramObject, int paramInt) {}
  
  protected void onUnmapped(Object paramObject, int paramInt) {}
  
  public int putObject(Object paramObject) {
    synchronized (this.mSync) {
      Integer integer = this.mObjectToIdMap.get(paramObject);
      if (integer != null)
        return integer.intValue(); 
      int i = this.mNextId;
      this.mNextId = i + 1;
      integer = Integer.valueOf(i);
      this.mObjectToIdMap.put(paramObject, integer);
      this.mIdToObjectMap.put(integer.intValue(), paramObject);
      onMapped(paramObject, integer.intValue());
      return integer.intValue();
    } 
  }
  
  @Nullable
  public Integer removeObject(Object paramObject) {
    synchronized (this.mSync) {
      Integer integer = this.mObjectToIdMap.remove(paramObject);
      if (integer == null)
        return null; 
      this.mIdToObjectMap.remove(integer.intValue());
      onUnmapped(paramObject, integer.intValue());
      return integer;
    } 
  }
  
  @Nullable
  public Object removeObjectById(int paramInt) {
    synchronized (this.mSync) {
      Object object = this.mIdToObjectMap.get(paramInt);
      if (object == null)
        return null; 
      this.mIdToObjectMap.remove(paramInt);
      this.mObjectToIdMap.remove(object);
      onUnmapped(object, paramInt);
      return object;
    } 
  }
  
  public int size() {
    synchronized (this.mSync) {
      return this.mObjectToIdMap.size();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\helper\ObjectIdMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */