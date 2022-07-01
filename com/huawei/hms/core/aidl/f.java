package com.huawei.hms.core.aidl;

import android.os.Bundle;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class f extends e {
  protected List<Object> a(Type paramType, Bundle paramBundle) throws InstantiationException, IllegalAccessException {
    int j = paramBundle.getInt("_list_size_");
    ArrayList<Object> arrayList = new ArrayList(j);
    for (int i = 0; i < j; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("_list_item_");
      stringBuilder.append(i);
      Object object = paramBundle.get(stringBuilder.toString());
      if (object.getClass().isPrimitive() || object instanceof String || object instanceof java.io.Serializable) {
        arrayList.add(object);
      } else if (object instanceof Bundle) {
        object = object;
        int k = object.getInt("_val_type_", -1);
        if (k != 1) {
          if (k == 0) {
            arrayList.add(a((Bundle)object, ((Class<IMessageEntity>)((ParameterizedType)paramType).getActualTypeArguments()[0]).newInstance()));
          } else {
            throw new InstantiationException("Unknown type can not be supported");
          } 
        } else {
          throw new InstantiationException("Nested List can not be supported");
        } 
      } 
    } 
    return arrayList;
  }
  
  protected void a(String paramString, List paramList, Bundle paramBundle) {
    Bundle bundle = new Bundle();
    bundle.putInt("_val_type_", 1);
    bundle.putInt("_list_size_", paramList.size());
    int i;
    for (i = 0; i < paramList.size(); i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("_list_item_");
      stringBuilder.append(i);
      a(stringBuilder.toString(), paramList.get(i), bundle);
    } 
    paramBundle.putBundle(paramString, bundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\core\aidl\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */