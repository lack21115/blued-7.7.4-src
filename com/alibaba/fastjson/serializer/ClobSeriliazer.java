package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.sql.SQLException;

public class ClobSeriliazer implements ObjectSerializer {
  public static final ClobSeriliazer instance = new ClobSeriliazer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    if (paramObject1 == null)
      try {
        paramJSONSerializer.writeNull();
        return;
      } catch (SQLException sQLException) {
        throw new IOException("write clob error", sQLException);
      }  
    paramObject1 = ((Clob)paramObject1).getCharacterStream();
    paramObject2 = new StringWriter();
    char[] arrayOfChar = new char[1024];
    while (true) {
      paramInt = paramObject1.read(arrayOfChar);
      if (paramInt != -1) {
        paramObject2.write(arrayOfChar, 0, paramInt);
        continue;
      } 
      paramObject1.close();
      sQLException.write(paramObject2.toString());
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\ClobSeriliazer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */