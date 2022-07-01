package com.google.protobuf;

import java.util.Map;

class MapFieldSchemaLite implements MapFieldSchema {
  private static <K, V> int getSerializedSizeLite(int paramInt, Object paramObject1, Object paramObject2) {
    MapFieldLite mapFieldLite = (MapFieldLite)paramObject1;
    paramObject1 = paramObject2;
    boolean bool = mapFieldLite.isEmpty();
    int i = 0;
    if (bool)
      return 0; 
    paramObject2 = mapFieldLite.entrySet().iterator();
    while (paramObject2.hasNext()) {
      Map.Entry entry = paramObject2.next();
      i += paramObject1.computeMessageSize(paramInt, entry.getKey(), entry.getValue());
    } 
    return i;
  }
  
  private static <K, V> MapFieldLite<K, V> mergeFromLite(Object paramObject1, Object paramObject2) {
    MapFieldLite mapFieldLite = (MapFieldLite)paramObject1;
    paramObject2 = paramObject2;
    paramObject1 = mapFieldLite;
    if (!paramObject2.isEmpty()) {
      paramObject1 = mapFieldLite;
      if (!mapFieldLite.isMutable())
        paramObject1 = mapFieldLite.mutableCopy(); 
      paramObject1.mergeFrom((MapFieldLite)paramObject2);
    } 
    return (MapFieldLite<K, V>)paramObject1;
  }
  
  public Map<?, ?> forMapData(Object paramObject) {
    return (MapFieldLite)paramObject;
  }
  
  public MapEntryLite.Metadata<?, ?> forMapMetadata(Object paramObject) {
    return ((MapEntryLite<?, ?>)paramObject).getMetadata();
  }
  
  public Map<?, ?> forMutableMapData(Object paramObject) {
    return (MapFieldLite)paramObject;
  }
  
  public int getSerializedSize(int paramInt, Object paramObject1, Object paramObject2) {
    return getSerializedSizeLite(paramInt, paramObject1, paramObject2);
  }
  
  public boolean isImmutable(Object paramObject) {
    return ((MapFieldLite)paramObject).isMutable() ^ true;
  }
  
  public Object mergeFrom(Object paramObject1, Object paramObject2) {
    return mergeFromLite(paramObject1, paramObject2);
  }
  
  public Object newMapField(Object paramObject) {
    return MapFieldLite.emptyMapField().mutableCopy();
  }
  
  public Object toImmutable(Object paramObject) {
    ((MapFieldLite)paramObject).makeImmutable();
    return paramObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\MapFieldSchemaLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */