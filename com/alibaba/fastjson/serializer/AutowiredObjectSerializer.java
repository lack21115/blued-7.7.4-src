package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;
import java.util.Set;

public interface AutowiredObjectSerializer extends ObjectSerializer {
  Set<Type> getAutowiredFor();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\AutowiredObjectSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */