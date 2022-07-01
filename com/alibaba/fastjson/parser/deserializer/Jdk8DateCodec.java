package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Jdk8DateCodec implements ObjectDeserializer, ObjectSerializer {
  public static final Jdk8DateCodec instance = new Jdk8DateCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 4) {
      paramObject = jSONLexer.stringVal();
      jSONLexer.nextToken();
      return (T)((paramType == LocalDateTime.class) ? LocalDateTime.parse((CharSequence)paramObject) : ((paramType == LocalDate.class) ? LocalDate.parse((CharSequence)paramObject) : ((paramType == LocalTime.class) ? LocalTime.parse((CharSequence)paramObject) : ((paramType == ZonedDateTime.class) ? ZonedDateTime.parse((CharSequence)paramObject) : ((paramType == OffsetDateTime.class) ? OffsetDateTime.parse((CharSequence)paramObject) : ((paramType == OffsetTime.class) ? OffsetTime.parse((CharSequence)paramObject) : ((paramType == ZoneId.class) ? ZoneId.of((String)paramObject) : ((paramType == Period.class) ? Period.parse((CharSequence)paramObject) : ((paramType == Duration.class) ? Duration.parse((CharSequence)paramObject) : ((paramType == Instant.class) ? Instant.parse((CharSequence)paramObject) : null))))))))));
    } 
    throw new UnsupportedOperationException();
  }
  
  public int getFastMatchToken() {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      serializeWriter.writeNull();
      return;
    } 
    serializeWriter.writeString(paramObject1.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\Jdk8DateCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */