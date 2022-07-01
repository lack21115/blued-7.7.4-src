package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

public interface ExtraTypeProvider extends ParseProcess {
  Type getExtraType(Object paramObject, String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\ExtraTypeProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */