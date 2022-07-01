package org.chromium.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.FIELD})
public @interface AccessedByNative {}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\annotations\AccessedByNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */