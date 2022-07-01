package com.ishumei.l111l11111Il;

import com.ishumei.l111l1111llIl.l111l1111l1Il;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import java.lang.reflect.Field;
import java.util.HashMap;

public final class l111l11111Il {
  public static HashMap<String, String> l1111l111111Il(boolean paramBoolean) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
      String str = l111l1111lI1l.l111l11111Il("9e919b8d90969bd1908cd1bd8a96939b");
      Field[] arrayOfField = l111l1111l1Il.l1111l111111Il(str);
      if (paramBoolean) {
        try {
          Object object = l111l1111l1Il.l1111l111111Il(str, l111l1111lI1l.l111l11111Il("989a8bac9a8d969e93"));
          if (object != null)
            hashMap.put(l111l1111lI1l.l111l11111Il("8c9a8d969e93a0af"), object.toString()); 
        } finally {}
        str = "9d909e8d9bd392909b9a93d38c9a8d969e93d39d8d9e919bd3929e918a999e9c8b8a8d9a8dd3999691989a8d8f8d96918bd39c8f8aa09e9d96d39c8f8aa09e9d96cd";
      } else {
        str = "9d909e8d9bd392909b9a93d39d8d9e919bd3929e918a999e9c8b8a8d9a8dd3999691989a8d8f8d96918bd39c8f8aa09e9d96d39c8f8aa09e9d96cd";
      } 
      str = l111l1111lI1l.l111l11111Il(str);
      int j = arrayOfField.length;
      for (int i = 0; i < j; i++) {
        Field field = arrayOfField[i];
        field.setAccessible(true);
        String str1 = field.getName().toLowerCase();
        if (str.contains(str1))
          hashMap.put(str1, field.get((Object)null).toString()); 
      } 
      return (HashMap)hashMap;
    } catch (Exception exception) {
      return (HashMap)hashMap;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l111l11111Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */