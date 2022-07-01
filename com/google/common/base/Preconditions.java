package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Preconditions {
  public static int a(int paramInt1, int paramInt2) {
    return a(paramInt1, paramInt2, "index");
  }
  
  public static int a(int paramInt1, int paramInt2, @NullableDecl String paramString) {
    if (paramInt1 >= 0 && paramInt1 < paramInt2)
      return paramInt1; 
    throw new IndexOutOfBoundsException(c(paramInt1, paramInt2, paramString));
  }
  
  @NonNullDecl
  public static <T> T a(@NonNullDecl T paramT) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException();
  }
  
  @NonNullDecl
  public static <T> T a(@NonNullDecl T paramT, @NullableDecl Object paramObject) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  @NonNullDecl
  public static <T> T a(@NonNullDecl T paramT, @NullableDecl String paramString, @NullableDecl Object paramObject) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(Strings.a(paramString, new Object[] { paramObject }));
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 >= 0 && paramInt2 >= paramInt1 && paramInt2 <= paramInt3)
      return; 
    throw new IndexOutOfBoundsException(b(paramInt1, paramInt2, paramInt3));
  }
  
  public static void a(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException();
  }
  
  public static void a(boolean paramBoolean, @NullableDecl Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static void a(boolean paramBoolean, @NullableDecl String paramString, char paramChar) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(Strings.a(paramString, new Object[] { Character.valueOf(paramChar) }));
  }
  
  public static void a(boolean paramBoolean, @NullableDecl String paramString, char paramChar, @NullableDecl Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(Strings.a(paramString, new Object[] { Character.valueOf(paramChar), paramObject }));
  }
  
  public static void a(boolean paramBoolean, @NullableDecl String paramString, int paramInt) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(Strings.a(paramString, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public static void a(boolean paramBoolean, @NullableDecl String paramString, int paramInt1, int paramInt2) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(Strings.a(paramString, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  public static void a(boolean paramBoolean, @NullableDecl String paramString, long paramLong) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(Strings.a(paramString, new Object[] { Long.valueOf(paramLong) }));
  }
  
  public static void a(boolean paramBoolean, @NullableDecl String paramString, @NullableDecl Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(Strings.a(paramString, new Object[] { paramObject }));
  }
  
  public static void a(boolean paramBoolean, @NullableDecl String paramString, @NullableDecl Object paramObject, int paramInt) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(Strings.a(paramString, new Object[] { paramObject, Integer.valueOf(paramInt) }));
  }
  
  public static void a(boolean paramBoolean, @NullableDecl String paramString, @NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(Strings.a(paramString, new Object[] { paramObject1, paramObject2 }));
  }
  
  public static void a(boolean paramBoolean, @NullableDecl String paramString, @NullableDecl Object paramObject1, @NullableDecl Object paramObject2, @NullableDecl Object paramObject3, @NullableDecl Object paramObject4) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(Strings.a(paramString, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
  }
  
  public static int b(int paramInt1, int paramInt2) {
    return b(paramInt1, paramInt2, "index");
  }
  
  public static int b(int paramInt1, int paramInt2, @NullableDecl String paramString) {
    if (paramInt1 >= 0 && paramInt1 <= paramInt2)
      return paramInt1; 
    throw new IndexOutOfBoundsException(d(paramInt1, paramInt2, paramString));
  }
  
  private static String b(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt1 < 0 || paramInt1 > paramInt3) ? d(paramInt1, paramInt3, "start index") : ((paramInt2 < 0 || paramInt2 > paramInt3) ? d(paramInt2, paramInt3, "end index") : Strings.a("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
  }
  
  public static void b(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException();
  }
  
  public static void b(boolean paramBoolean, @NullableDecl Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(String.valueOf(paramObject));
  }
  
  public static void b(boolean paramBoolean, @NullableDecl String paramString, int paramInt) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(Strings.a(paramString, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public static void b(boolean paramBoolean, @NullableDecl String paramString, @NullableDecl Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(Strings.a(paramString, new Object[] { paramObject }));
  }
  
  public static void b(boolean paramBoolean, @NullableDecl String paramString, @NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(Strings.a(paramString, new Object[] { paramObject1, paramObject2 }));
  }
  
  private static String c(int paramInt1, int paramInt2, @NullableDecl String paramString) {
    if (paramInt1 < 0)
      return Strings.a("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) }); 
    if (paramInt2 >= 0)
      return Strings.a("%s (%s) must be less than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("negative size: ");
    stringBuilder.append(paramInt2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private static String d(int paramInt1, int paramInt2, @NullableDecl String paramString) {
    if (paramInt1 < 0)
      return Strings.a("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) }); 
    if (paramInt2 >= 0)
      return Strings.a("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("negative size: ");
    stringBuilder.append(paramInt2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */