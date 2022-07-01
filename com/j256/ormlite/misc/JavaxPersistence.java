package com.j256.ormlite.misc;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataPersisterManager;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseFieldConfig;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Collection;

public class JavaxPersistence {
  public static DatabaseFieldConfig createFieldConfig(DatabaseType paramDatabaseType, Field paramField) throws SQLException {
    Annotation[] arrayOfAnnotation = paramField.getAnnotations();
    int j = arrayOfAnnotation.length;
    int i = 0;
    Annotation annotation9 = null;
    Annotation annotation8 = null;
    Annotation annotation7 = null;
    Annotation annotation5 = null;
    Annotation annotation4 = null;
    Annotation annotation1 = null;
    Annotation annotation2 = null;
    Annotation annotation6 = null;
    Annotation annotation3 = null;
    while (i < j) {
      Annotation annotation = arrayOfAnnotation[i];
      Class<? extends Annotation> clazz = annotation.annotationType();
      if (clazz.getName().equals("javax.persistence.Column"))
        annotation9 = annotation; 
      if (clazz.getName().equals("javax.persistence.Basic"))
        annotation8 = annotation; 
      if (clazz.getName().equals("javax.persistence.Id"))
        annotation7 = annotation; 
      if (clazz.getName().equals("javax.persistence.GeneratedValue"))
        annotation6 = annotation; 
      if (clazz.getName().equals("javax.persistence.OneToOne"))
        annotation5 = annotation; 
      if (clazz.getName().equals("javax.persistence.ManyToOne"))
        annotation4 = annotation; 
      if (clazz.getName().equals("javax.persistence.JoinColumn"))
        annotation3 = annotation; 
      if (clazz.getName().equals("javax.persistence.Enumerated"))
        annotation1 = annotation; 
      if (clazz.getName().equals("javax.persistence.Version"))
        annotation2 = annotation; 
      i++;
    } 
    if (annotation9 == null && annotation8 == null && annotation7 == null && annotation5 == null && annotation4 == null && annotation1 == null && annotation2 == null)
      return null; 
    DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig();
    String str2 = paramField.getName();
    String str1 = str2;
    if (paramDatabaseType.isEntityNamesMustBeUpCase())
      str1 = str2.toUpperCase(); 
    databaseFieldConfig.setFieldName(str1);
    if (annotation9 != null)
      try {
        String str = (String)annotation9.getClass().getMethod("name", new Class[0]).invoke(annotation9, new Object[0]);
        if (str != null && str.length() > 0)
          databaseFieldConfig.setColumnName(str); 
        str = (String)annotation9.getClass().getMethod("columnDefinition", new Class[0]).invoke(annotation9, new Object[0]);
        if (str != null && str.length() > 0)
          databaseFieldConfig.setColumnDefinition(str); 
        databaseFieldConfig.setWidth(((Integer)annotation9.getClass().getMethod("length", new Class[0]).invoke(annotation9, new Object[0])).intValue());
        Boolean bool = (Boolean)annotation9.getClass().getMethod("nullable", new Class[0]).invoke(annotation9, new Object[0]);
        if (bool != null)
          databaseFieldConfig.setCanBeNull(bool.booleanValue()); 
        bool = (Boolean)annotation9.getClass().getMethod("unique", new Class[0]).invoke(annotation9, new Object[0]);
        if (bool != null)
          databaseFieldConfig.setUnique(bool.booleanValue()); 
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Problem accessing fields from the @Column annotation for field ");
        stringBuilder.append(paramField);
        throw SqlExceptionUtil.create(stringBuilder.toString(), exception);
      }  
    if (annotation8 != null)
      try {
        Boolean bool = (Boolean)annotation8.getClass().getMethod("optional", new Class[0]).invoke(annotation8, new Object[0]);
        if (bool == null) {
          databaseFieldConfig.setCanBeNull(true);
        } else {
          databaseFieldConfig.setCanBeNull(bool.booleanValue());
        } 
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Problem accessing fields from the @Basic annotation for field ");
        stringBuilder.append(paramField);
        throw SqlExceptionUtil.create(stringBuilder.toString(), exception);
      }  
    if (annotation7 != null)
      if (annotation6 == null) {
        databaseFieldConfig.setId(true);
      } else {
        databaseFieldConfig.setGeneratedId(true);
      }  
    if (annotation5 != null || annotation4 != null)
      if (Collection.class.isAssignableFrom(paramField.getType()) || ForeignCollection.class.isAssignableFrom(paramField.getType())) {
        databaseFieldConfig.setForeignCollection(true);
        if (annotation3 != null)
          try {
            String str = (String)annotation3.getClass().getMethod("name", new Class[0]).invoke(annotation3, new Object[0]);
            if (str != null && str.length() > 0)
              databaseFieldConfig.setForeignCollectionColumnName(str); 
            Object object = annotation3.getClass().getMethod("fetch", new Class[0]).invoke(annotation3, new Object[0]);
            if (object != null && object.toString().equals("EAGER"))
              databaseFieldConfig.setForeignCollectionEager(true); 
          } catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Problem accessing fields from the @JoinColumn annotation for field ");
            stringBuilder.append(paramField);
            throw SqlExceptionUtil.create(stringBuilder.toString(), exception);
          }  
      } else {
        databaseFieldConfig.setForeign(true);
        if (annotation3 != null)
          try {
            String str = (String)annotation3.getClass().getMethod("name", new Class[0]).invoke(annotation3, new Object[0]);
            if (str != null && str.length() > 0)
              databaseFieldConfig.setColumnName(str); 
            Boolean bool = (Boolean)annotation3.getClass().getMethod("nullable", new Class[0]).invoke(annotation3, new Object[0]);
            if (bool != null)
              databaseFieldConfig.setCanBeNull(bool.booleanValue()); 
            bool = (Boolean)annotation3.getClass().getMethod("unique", new Class[0]).invoke(annotation3, new Object[0]);
            if (bool != null)
              databaseFieldConfig.setUnique(bool.booleanValue()); 
          } catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Problem accessing fields from the @JoinColumn annotation for field ");
            stringBuilder.append(paramField);
            throw SqlExceptionUtil.create(stringBuilder.toString(), exception);
          }  
      }  
    if (annotation1 != null)
      try {
        Object object = annotation1.getClass().getMethod("value", new Class[0]).invoke(annotation1, new Object[0]);
        if (object != null && object.toString().equals("STRING")) {
          databaseFieldConfig.setDataType(DataType.ENUM_STRING);
        } else {
          databaseFieldConfig.setDataType(DataType.ENUM_INTEGER);
        } 
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Problem accessing fields from the @Enumerated annotation for field ");
        stringBuilder.append(paramField);
        throw SqlExceptionUtil.create(stringBuilder.toString(), exception);
      }  
    if (annotation2 != null)
      databaseFieldConfig.setVersion(true); 
    if (databaseFieldConfig.getDataPersister() == null)
      databaseFieldConfig.setDataPersister(DataPersisterManager.lookupForField(paramField)); 
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (DatabaseFieldConfig.findGetMethod(paramField, false) != null) {
      bool1 = bool2;
      if (DatabaseFieldConfig.findSetMethod(paramField, false) != null)
        bool1 = true; 
    } 
    databaseFieldConfig.setUseGetSet(bool1);
    return databaseFieldConfig;
  }
  
  public static String getEntityName(Class<?> paramClass) {
    Annotation[] arrayOfAnnotation = paramClass.getAnnotations();
    int j = arrayOfAnnotation.length;
    Annotation annotation = null;
    int i;
    for (i = 0; i < j; i++) {
      Annotation annotation1 = arrayOfAnnotation[i];
      if (annotation1.annotationType().getName().equals("javax.persistence.Entity"))
        annotation = annotation1; 
    } 
    if (annotation == null)
      return null; 
    try {
      String str = (String)annotation.getClass().getMethod("name", new Class[0]).invoke(annotation, new Object[0]);
      if (str != null) {
        i = str.length();
        if (i > 0)
          return str; 
      } 
      return null;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not get entity name from class ");
      stringBuilder.append(paramClass);
      throw new IllegalStateException(stringBuilder.toString(), exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\misc\JavaxPersistence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */