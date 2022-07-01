package com.google.protobuf;

import java.util.Map;

class MapFieldSchemaFull implements MapFieldSchema {
  private static <K, V> int getSerializedSizeFull(int paramInt, Object paramObject1, Object paramObject2) {
    int i = 0;
    if (paramObject1 == null)
      return 0; 
    Map map = ((MapField)paramObject1).getMap();
    paramObject1 = paramObject2;
    if (map.isEmpty())
      return 0; 
    paramObject2 = map.entrySet().iterator();
    while (paramObject2.hasNext()) {
      Map.Entry entry = paramObject2.next();
      i += CodedOutputStream.computeTagSize(paramInt) + CodedOutputStream.computeLengthDelimitedFieldSize(MapEntryLite.computeSerializedSize(paramObject1.getMetadata(), entry.getKey(), entry.getValue()));
    } 
    return i;
  }
  
  private static <K, V> Object mergeFromFull(Object paramObject1, Object paramObject2) {
    paramObject1 = paramObject1;
    paramObject2 = paramObject2;
    if (!paramObject1.isMutable())
      paramObject1.copy(); 
    paramObject1.mergeFrom((MapField)paramObject2);
    return paramObject1;
  }
  
  public Map<?, ?> forMapData(Object paramObject) {
    return ((MapField<?, ?>)paramObject).getMap();
  }
  
  public MapEntryLite.Metadata<?, ?> forMapMetadata(Object paramObject) {
    return ((MapEntry<?, ?>)paramObject).getMetadata();
  }
  
  public Map<?, ?> forMutableMapData(Object paramObject) {
    return ((MapField<?, ?>)paramObject).getMutableMap();
  }
  
  public int getSerializedSize(int paramInt, Object paramObject1, Object paramObject2) {
    return getSerializedSizeFull(paramInt, paramObject1, paramObject2);
  }
  
  public boolean isImmutable(Object paramObject) {
    return ((MapField)paramObject).isMutable() ^ true;
  }
  
  public Object mergeFrom(Object paramObject1, Object paramObject2) {
    return mergeFromFull(paramObject1, paramObject2);
  }
  
  public Object newMapField(Object paramObject) {
    return MapField.newMapField((MapEntry<?, ?>)paramObject);
  }
  
  public Object toImmutable(Object paramObject) {
    ((MapField)paramObject).makeImmutable();
    return paramObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\MapFieldSchemaFull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */