package com.google.j2objc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE})
public @interface AutoreleasePool {}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\j2objc\annotations\AutoreleasePool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */