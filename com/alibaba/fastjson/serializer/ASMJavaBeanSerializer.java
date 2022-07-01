package com.alibaba.fastjson.serializer;

public abstract class ASMJavaBeanSerializer implements ObjectSerializer {
  protected JavaBeanSerializer nature;
  
  public ASMJavaBeanSerializer(Class<?> paramClass) {
    this.nature = new JavaBeanSerializer(paramClass);
  }
  
  public JavaBeanSerializer getJavaBeanSerializer() {
    return this.nature;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\ASMJavaBeanSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */