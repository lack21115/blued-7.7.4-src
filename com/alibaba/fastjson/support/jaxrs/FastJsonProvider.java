package com.alibaba.fastjson.support.jaxrs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
public class FastJsonProvider implements MessageBodyReader<Object>, MessageBodyWriter<Object> {
  private Class<?>[] clazzes = null;
  
  public Feature[] features = new Feature[0];
  
  public ParserConfig parserConfig = ParserConfig.getGlobalInstance();
  
  public SerializeConfig serializeConfig = SerializeConfig.getGlobalInstance();
  
  public Map<Class<?>, SerializeFilter> serializeFilters;
  
  public SerializerFeature[] serializerFeatures = new SerializerFeature[0];
  
  @Context
  UriInfo uriInfo;
  
  public FastJsonProvider() {}
  
  public FastJsonProvider(Class<?>[] paramArrayOfClass) {
    this.clazzes = paramArrayOfClass;
  }
  
  public long getSize(Object paramObject, Class<?> paramClass, Type paramType, Annotation[] paramArrayOfAnnotation, MediaType paramMediaType) {
    return -1L;
  }
  
  protected boolean hasMatchingMediaType(MediaType paramMediaType) {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramMediaType != null) {
      String str = paramMediaType.getSubtype();
      bool1 = bool2;
      if (!"json".equalsIgnoreCase(str)) {
        bool1 = bool2;
        if (!str.endsWith("+json")) {
          bool1 = bool2;
          if (!"javascript".equals(str)) {
            if ("x-javascript".equals(str))
              return true; 
            bool1 = false;
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  public boolean isReadable(Class<?> paramClass, Type paramType, Annotation[] paramArrayOfAnnotation, MediaType paramMediaType) {
    return !hasMatchingMediaType(paramMediaType) ? false : isValidType(paramClass, paramArrayOfAnnotation);
  }
  
  protected boolean isValidType(Class<?> paramClass, Annotation[] paramArrayOfAnnotation) {
    if (paramClass == null)
      return false; 
    Class<?>[] arrayOfClass = this.clazzes;
    if (arrayOfClass != null) {
      int j = arrayOfClass.length;
      for (int i = 0; i < j; i++) {
        if (arrayOfClass[i] == paramClass)
          return true; 
      } 
      return false;
    } 
    return true;
  }
  
  public boolean isWriteable(Class<?> paramClass, Type paramType, Annotation[] paramArrayOfAnnotation, MediaType paramMediaType) {
    return !hasMatchingMediaType(paramMediaType) ? false : isValidType(paramClass, paramArrayOfAnnotation);
  }
  
  public Object readFrom(Class<Object> paramClass, Type paramType, Annotation[] paramArrayOfAnnotation, MediaType paramMediaType, MultivaluedMap<String, String> paramMultivaluedMap, InputStream paramInputStream) throws IOException, WebApplicationException {
    try {
      String str = IOUtils.toString(paramInputStream);
    } catch (Exception exception) {
      exception = null;
    } 
    return (exception == null) ? null : JSON.parseObject((String)exception, paramClass, this.parserConfig, JSON.DEFAULT_PARSER_FEATURE, this.features);
  }
  
  public void writeTo(Object paramObject, Class<?> paramClass, Type paramType, Annotation[] paramArrayOfAnnotation, MediaType paramMediaType, MultivaluedMap<String, Object> paramMultivaluedMap, OutputStream paramOutputStream) throws IOException, WebApplicationException {
    SerializerFeature[] arrayOfSerializerFeature2 = this.serializerFeatures;
    UriInfo uriInfo = this.uriInfo;
    SerializerFeature[] arrayOfSerializerFeature1 = arrayOfSerializerFeature2;
    if (uriInfo != null) {
      arrayOfSerializerFeature1 = arrayOfSerializerFeature2;
      if (uriInfo.getQueryParameters().containsKey("pretty"))
        if (arrayOfSerializerFeature2 == null) {
          arrayOfSerializerFeature1 = new SerializerFeature[1];
          arrayOfSerializerFeature1[0] = SerializerFeature.PrettyFormat;
        } else {
          List<SerializerFeature> list = Arrays.asList(arrayOfSerializerFeature2);
          list.add(SerializerFeature.PrettyFormat);
          arrayOfSerializerFeature1 = list.<SerializerFeature>toArray(arrayOfSerializerFeature2);
        }  
    } 
    Map<Class<?>, SerializeFilter> map = this.serializeFilters;
    if (map != null) {
      SerializeFilter serializeFilter = map.get(paramClass);
    } else {
      paramClass = null;
    } 
    paramObject = JSON.toJSONString(paramObject, (SerializeFilter)paramClass, arrayOfSerializerFeature1);
    if (paramObject != null)
      paramOutputStream.write(paramObject.getBytes()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\support\jaxrs\FastJsonProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */