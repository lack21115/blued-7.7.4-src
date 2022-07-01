package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;

final class CalendarStyle {
  final CalendarItemStyle a;
  
  final CalendarItemStyle b;
  
  final CalendarItemStyle c;
  
  final CalendarItemStyle d;
  
  final CalendarItemStyle e;
  
  final CalendarItemStyle f;
  
  final CalendarItemStyle g;
  
  final Paint h;
  
  CalendarStyle(Context paramContext) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(MaterialAttributes.a(paramContext, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R.styleable.MaterialCalendar);
    this.a = CalendarItemStyle.a(paramContext, typedArray.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
    this.g = CalendarItemStyle.a(paramContext, typedArray.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
    this.b = CalendarItemStyle.a(paramContext, typedArray.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
    this.c = CalendarItemStyle.a(paramContext, typedArray.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
    ColorStateList colorStateList = MaterialResources.a(paramContext, typedArray, R.styleable.MaterialCalendar_rangeFillColor);
    this.d = CalendarItemStyle.a(paramContext, typedArray.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
    this.e = CalendarItemStyle.a(paramContext, typedArray.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
    this.f = CalendarItemStyle.a(paramContext, typedArray.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
    this.h = new Paint();
    this.h.setColor(colorStateList.getDefaultColor());
    typedArray.recycle();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\CalendarStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */