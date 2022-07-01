package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

public class DoubleSerializer implements ObjectSerializer {
  public static final DoubleSerializer instance = new DoubleSerializer();
  
  private DecimalFormat decimalFormat = null;
  
  public DoubleSerializer() {}
  
  public DoubleSerializer(String paramString) {
    this(new DecimalFormat(paramString));
  }
  
  public DoubleSerializer(DecimalFormat paramDecimalFormat) {
    this.decimalFormat = paramDecimalFormat;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    paramObject2 = paramJSONSerializer.out;
    if (paramObject1 == null) {
      if (paramObject2.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
        paramObject2.write(48);
        return;
      } 
      paramObject2.writeNull();
      return;
    } 
    double d = ((Double)paramObject1).doubleValue();
    if (Double.isNaN(d) || Double.isInfinite(d)) {
      paramObject2.writeNull();
      return;
    } 
    Object object = this.decimalFormat;
    if (object == null) {
      paramObject1 = Double.toString(d);
      object = paramObject1;
      if (paramObject1.endsWith(".0"))
        object = paramObject1.substring(0, paramObject1.length() - 2); 
    } else {
      object = object.format(d);
    } 
    paramObject2.append((CharSequence)object);
    if (paramObject2.isEnabled(SerializerFeature.WriteClassName)) {
      paramObject2.write(68);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\DoubleSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */