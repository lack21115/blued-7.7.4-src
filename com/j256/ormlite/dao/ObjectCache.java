package com.j256.ormlite.dao;

public interface ObjectCache {
  <T> void clear(Class<T> paramClass);
  
  void clearAll();
  
  <T, ID> T get(Class<T> paramClass, ID paramID);
  
  <T, ID> void put(Class<T> paramClass, ID paramID, T paramT);
  
  <T> void registerClass(Class<T> paramClass);
  
  <T, ID> void remove(Class<T> paramClass, ID paramID);
  
  <T> int size(Class<T> paramClass);
  
  int sizeAll();
  
  <T, ID> T updateId(Class<T> paramClass, ID paramID1, ID paramID2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\ObjectCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */