package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class TypeParameter<T> extends TypeCapture<T> {
  final TypeVariable<?> a;
  
  protected TypeParameter() {
    Type type = a();
    Preconditions.a(type instanceof TypeVariable, "%s should be a type variable.", type);
    this.a = (TypeVariable)type;
  }
  
  public final boolean equals(@NullableDecl Object paramObject) {
    if (paramObject instanceof TypeParameter) {
      paramObject = paramObject;
      return this.a.equals(((TypeParameter)paramObject).a);
    } 
    return false;
  }
  
  public final int hashCode() {
    return this.a.hashCode();
  }
  
  public String toString() {
    return this.a.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\reflect\TypeParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */