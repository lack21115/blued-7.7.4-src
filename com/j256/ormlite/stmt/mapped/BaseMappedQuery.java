package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseMappedQuery<T, ID> extends BaseMappedStatement<T, ID> implements GenericRowMapper<T> {
  private Map<String, Integer> columnPositions = null;
  
  private Object parent = null;
  
  private Object parentId = null;
  
  protected final FieldType[] resultsFieldTypes;
  
  protected BaseMappedQuery(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType1, FieldType[] paramArrayOfFieldType2) {
    super(paramTableInfo, paramString, paramArrayOfFieldType1);
    this.resultsFieldTypes = paramArrayOfFieldType2;
  }
  
  public T mapRow(DatabaseResults paramDatabaseResults) throws SQLException {
    Object object1 = this.columnPositions;
    Map<String, Integer> map = (Map<String, Integer>)object1;
    if (object1 == null)
      map = new HashMap<String, Integer>(); 
    ObjectCache objectCache = paramDatabaseResults.getObjectCache();
    if (objectCache != null) {
      Object object = this.idField.resultToJava(paramDatabaseResults, map);
      object = objectCache.get(this.clazz, object);
      if (object != null)
        return (T)object; 
    } 
    Object object2 = this.tableInfo.createObject();
    FieldType[] arrayOfFieldType = this.resultsFieldTypes;
    int k = arrayOfFieldType.length;
    object1 = null;
    int i = 0;
    int j;
    for (j = 0; i < k; j = m) {
      int m;
      FieldType fieldType = arrayOfFieldType[i];
      if (fieldType.isForeignCollection()) {
        m = 1;
      } else {
        Object object = fieldType.resultToJava(paramDatabaseResults, map);
        if (object != null && this.parent != null && fieldType.getField().getType() == this.parent.getClass() && object.equals(this.parentId)) {
          fieldType.assignField(object2, this.parent, true, objectCache);
        } else {
          fieldType.assignField(object2, object, false, objectCache);
        } 
        m = j;
        if (fieldType == this.idField) {
          object1 = object;
          m = j;
        } 
      } 
      i++;
    } 
    if (j)
      for (FieldType fieldType : this.resultsFieldTypes) {
        if (fieldType.isForeignCollection()) {
          BaseForeignCollection baseForeignCollection = fieldType.buildForeignCollection(object2, object1);
          if (baseForeignCollection != null)
            fieldType.assignField(object2, baseForeignCollection, false, objectCache); 
        } 
      }  
    if (objectCache != null && object1 != null)
      objectCache.put(this.clazz, object1, object2); 
    if (this.columnPositions == null)
      this.columnPositions = map; 
    return (T)object2;
  }
  
  public void setParentInformation(Object paramObject1, Object paramObject2) {
    this.parent = paramObject1;
    this.parentId = paramObject2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\mapped\BaseMappedQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */