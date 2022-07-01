package com.j256.ormlite.field;

import com.j256.ormlite.field.types.BigDecimalNumericType;
import com.j256.ormlite.field.types.BigDecimalStringType;
import com.j256.ormlite.field.types.BigIntegerType;
import com.j256.ormlite.field.types.BooleanObjectType;
import com.j256.ormlite.field.types.BooleanType;
import com.j256.ormlite.field.types.ByteArrayType;
import com.j256.ormlite.field.types.ByteObjectType;
import com.j256.ormlite.field.types.ByteType;
import com.j256.ormlite.field.types.CharType;
import com.j256.ormlite.field.types.CharacterObjectType;
import com.j256.ormlite.field.types.DateLongType;
import com.j256.ormlite.field.types.DateStringType;
import com.j256.ormlite.field.types.DateTimeType;
import com.j256.ormlite.field.types.DateType;
import com.j256.ormlite.field.types.DoubleObjectType;
import com.j256.ormlite.field.types.DoubleType;
import com.j256.ormlite.field.types.EnumIntegerType;
import com.j256.ormlite.field.types.EnumStringType;
import com.j256.ormlite.field.types.FloatObjectType;
import com.j256.ormlite.field.types.FloatType;
import com.j256.ormlite.field.types.IntType;
import com.j256.ormlite.field.types.IntegerObjectType;
import com.j256.ormlite.field.types.LongObjectType;
import com.j256.ormlite.field.types.LongStringType;
import com.j256.ormlite.field.types.LongType;
import com.j256.ormlite.field.types.SerializableType;
import com.j256.ormlite.field.types.ShortObjectType;
import com.j256.ormlite.field.types.ShortType;
import com.j256.ormlite.field.types.SqlDateType;
import com.j256.ormlite.field.types.StringBytesType;
import com.j256.ormlite.field.types.StringType;
import com.j256.ormlite.field.types.TimeStampType;
import com.j256.ormlite.field.types.UuidType;

public enum DataType {
  BIG_DECIMAL,
  BIG_DECIMAL_NUMERIC,
  BIG_INTEGER,
  BOOLEAN,
  BOOLEAN_OBJ,
  BYTE,
  BYTE_ARRAY,
  BYTE_OBJ,
  CHAR,
  CHAR_OBJ,
  DATE,
  DATE_LONG,
  DATE_STRING,
  DATE_TIME,
  DOUBLE,
  DOUBLE_OBJ,
  ENUM_INTEGER,
  ENUM_STRING,
  FLOAT,
  FLOAT_OBJ,
  INTEGER,
  INTEGER_OBJ,
  LONG,
  LONG_OBJ,
  LONG_STRING,
  SERIALIZABLE,
  SHORT,
  SHORT_OBJ,
  SQL_DATE,
  STRING((DataPersister)StringType.getSingleton()),
  STRING_BYTES((DataPersister)StringType.getSingleton()),
  TIME_STAMP((DataPersister)StringType.getSingleton()),
  UNKNOWN((DataPersister)StringType.getSingleton()),
  UUID((DataPersister)StringType.getSingleton());
  
  private final DataPersister dataPersister;
  
  static {
    LONG_STRING = new DataType("LONG_STRING", 1, (DataPersister)LongStringType.getSingleton());
    STRING_BYTES = new DataType("STRING_BYTES", 2, (DataPersister)StringBytesType.getSingleton());
    BOOLEAN = new DataType("BOOLEAN", 3, (DataPersister)BooleanType.getSingleton());
    BOOLEAN_OBJ = new DataType("BOOLEAN_OBJ", 4, (DataPersister)BooleanObjectType.getSingleton());
    DATE = new DataType("DATE", 5, (DataPersister)DateType.getSingleton());
    DATE_LONG = new DataType("DATE_LONG", 6, (DataPersister)DateLongType.getSingleton());
    DATE_STRING = new DataType("DATE_STRING", 7, (DataPersister)DateStringType.getSingleton());
    CHAR = new DataType("CHAR", 8, (DataPersister)CharType.getSingleton());
    CHAR_OBJ = new DataType("CHAR_OBJ", 9, (DataPersister)CharacterObjectType.getSingleton());
    BYTE = new DataType("BYTE", 10, (DataPersister)ByteType.getSingleton());
    BYTE_ARRAY = new DataType("BYTE_ARRAY", 11, (DataPersister)ByteArrayType.getSingleton());
    BYTE_OBJ = new DataType("BYTE_OBJ", 12, (DataPersister)ByteObjectType.getSingleton());
    SHORT = new DataType("SHORT", 13, (DataPersister)ShortType.getSingleton());
    SHORT_OBJ = new DataType("SHORT_OBJ", 14, (DataPersister)ShortObjectType.getSingleton());
    INTEGER = new DataType("INTEGER", 15, (DataPersister)IntType.getSingleton());
    INTEGER_OBJ = new DataType("INTEGER_OBJ", 16, (DataPersister)IntegerObjectType.getSingleton());
    LONG = new DataType("LONG", 17, (DataPersister)LongType.getSingleton());
    LONG_OBJ = new DataType("LONG_OBJ", 18, (DataPersister)LongObjectType.getSingleton());
    FLOAT = new DataType("FLOAT", 19, (DataPersister)FloatType.getSingleton());
    FLOAT_OBJ = new DataType("FLOAT_OBJ", 20, (DataPersister)FloatObjectType.getSingleton());
    DOUBLE = new DataType("DOUBLE", 21, (DataPersister)DoubleType.getSingleton());
    DOUBLE_OBJ = new DataType("DOUBLE_OBJ", 22, (DataPersister)DoubleObjectType.getSingleton());
    SERIALIZABLE = new DataType("SERIALIZABLE", 23, (DataPersister)SerializableType.getSingleton());
    ENUM_STRING = new DataType("ENUM_STRING", 24, (DataPersister)EnumStringType.getSingleton());
    ENUM_INTEGER = new DataType("ENUM_INTEGER", 25, (DataPersister)EnumIntegerType.getSingleton());
    UUID = new DataType("UUID", 26, (DataPersister)UuidType.getSingleton());
    BIG_INTEGER = new DataType("BIG_INTEGER", 27, (DataPersister)BigIntegerType.getSingleton());
    BIG_DECIMAL = new DataType("BIG_DECIMAL", 28, (DataPersister)BigDecimalStringType.getSingleton());
    BIG_DECIMAL_NUMERIC = new DataType("BIG_DECIMAL_NUMERIC", 29, (DataPersister)BigDecimalNumericType.getSingleton());
    DATE_TIME = new DataType("DATE_TIME", 30, (DataPersister)DateTimeType.getSingleton());
    SQL_DATE = new DataType("SQL_DATE", 31, (DataPersister)SqlDateType.getSingleton());
    TIME_STAMP = new DataType("TIME_STAMP", 32, (DataPersister)TimeStampType.getSingleton());
    UNKNOWN = new DataType("UNKNOWN", 33, null);
    $VALUES = new DataType[] { 
        STRING, LONG_STRING, STRING_BYTES, BOOLEAN, BOOLEAN_OBJ, DATE, DATE_LONG, DATE_STRING, CHAR, CHAR_OBJ, 
        BYTE, BYTE_ARRAY, BYTE_OBJ, SHORT, SHORT_OBJ, INTEGER, INTEGER_OBJ, LONG, LONG_OBJ, FLOAT, 
        FLOAT_OBJ, DOUBLE, DOUBLE_OBJ, SERIALIZABLE, ENUM_STRING, ENUM_INTEGER, UUID, BIG_INTEGER, BIG_DECIMAL, BIG_DECIMAL_NUMERIC, 
        DATE_TIME, SQL_DATE, TIME_STAMP, UNKNOWN };
  }
  
  DataType(DataPersister paramDataPersister) {
    this.dataPersister = paramDataPersister;
  }
  
  public DataPersister getDataPersister() {
    return this.dataPersister;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\DataType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */