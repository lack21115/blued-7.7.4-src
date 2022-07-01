package com.j256.ormlite.field;

import com.j256.ormlite.field.types.EnumStringType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataPersisterManager {
  private static final DataPersister DEFAULT_ENUM_PERSISTER = (DataPersister)EnumStringType.getSingleton();
  
  private static final Map<String, DataPersister> builtInMap;
  
  private static List<DataPersister> registeredPersisters = null;
  
  static {
    builtInMap = new HashMap<String, DataPersister>();
    DataType[] arrayOfDataType = DataType.values();
    int j = arrayOfDataType.length;
    for (int i = 0; i < j; i++) {
      DataPersister dataPersister = arrayOfDataType[i].getDataPersister();
      if (dataPersister != null) {
        for (Class<?> clazz : dataPersister.getAssociatedClasses())
          builtInMap.put(clazz.getName(), dataPersister); 
        if (dataPersister.getAssociatedClassNames() != null)
          for (String str : dataPersister.getAssociatedClassNames())
            builtInMap.put(str, dataPersister);  
      } 
    } 
  }
  
  public static void clear() {
    registeredPersisters = null;
  }
  
  public static DataPersister lookupForField(Field paramField) {
    List<DataPersister> list = registeredPersisters;
    if (list != null)
      for (DataPersister dataPersister1 : list) {
        if (dataPersister1.isValidForField(paramField))
          return dataPersister1; 
        for (Class<?> clazz : dataPersister1.getAssociatedClasses()) {
          if (paramField.getType() == clazz)
            return dataPersister1; 
        } 
      }  
    DataPersister dataPersister = builtInMap.get(paramField.getType().getName());
    return (dataPersister != null) ? dataPersister : (paramField.getType().isEnum() ? DEFAULT_ENUM_PERSISTER : null);
  }
  
  public static void registerDataPersisters(DataPersister... paramVarArgs) {
    ArrayList<DataPersister> arrayList = new ArrayList();
    List<DataPersister> list = registeredPersisters;
    if (list != null)
      arrayList.addAll(list); 
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++)
      arrayList.add(paramVarArgs[i]); 
    registeredPersisters = arrayList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\DataPersisterManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */