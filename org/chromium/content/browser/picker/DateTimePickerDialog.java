package org.chromium.content.browser.picker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.chromium.content.R;

public final class DateTimePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, DatePicker.OnDateChangedListener, TimePicker.OnTimeChangedListener {
  private final DateTimePickerDialog$OnDateTimeSetListener mCallBack;
  
  private final DatePicker mDatePicker;
  
  private final long mMaxTimeMillis;
  
  private final long mMinTimeMillis;
  
  private final TimePicker mTimePicker;
  
  public DateTimePickerDialog(Context paramContext, DateTimePickerDialog$OnDateTimeSetListener paramDateTimePickerDialog$OnDateTimeSetListener, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, double paramDouble1, double paramDouble2) {
    super(paramContext, 0);
    DateTimePickerDialog$WorkaroundContextForSamsungLDateTimeBug dateTimePickerDialog$WorkaroundContextForSamsungLDateTimeBug;
    this.mMinTimeMillis = (long)paramDouble1;
    this.mMaxTimeMillis = (long)paramDouble2;
    this.mCallBack = paramDateTimePickerDialog$OnDateTimeSetListener;
    setButton(-1, paramContext.getText(R.string.date_picker_dialog_set), this);
    setButton(-2, paramContext.getText(17039360), null);
    setIcon(0);
    setTitle(paramContext.getText(R.string.date_time_picker_dialog_title));
    if (Build.VERSION.SDK_INT == 21 || Build.VERSION.SDK_INT == 22)
      dateTimePickerDialog$WorkaroundContextForSamsungLDateTimeBug = new DateTimePickerDialog$WorkaroundContextForSamsungLDateTimeBug(paramContext, (byte)0); 
    View view = ((LayoutInflater)dateTimePickerDialog$WorkaroundContextForSamsungLDateTimeBug.getSystemService("layout_inflater")).inflate(R.layout.date_time_picker_dialog, null);
    setView(view);
    this.mDatePicker = (DatePicker)view.findViewById(R.id.date_picker);
    DateDialogNormalizer.normalize(this.mDatePicker, this, paramInt1, paramInt2, paramInt3, this.mMinTimeMillis, this.mMaxTimeMillis);
    this.mTimePicker = (TimePicker)view.findViewById(R.id.time_picker);
    this.mTimePicker.setIs24HourView(Boolean.valueOf(paramBoolean));
    setHour(this.mTimePicker, paramInt4);
    setMinute(this.mTimePicker, paramInt5);
    this.mTimePicker.setOnTimeChangedListener(this);
    onTimeChanged(this.mTimePicker, this.mTimePicker.getCurrentHour().intValue(), this.mTimePicker.getCurrentMinute().intValue());
  }
  
  private static void setHour(TimePicker paramTimePicker, int paramInt) {
    paramTimePicker.setCurrentHour(Integer.valueOf(paramInt));
  }
  
  private static void setMinute(TimePicker paramTimePicker, int paramInt) {
    paramTimePicker.setCurrentMinute(Integer.valueOf(paramInt));
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt) {
    if (this.mCallBack != null) {
      this.mDatePicker.clearFocus();
      this.mTimePicker.clearFocus();
      this.mCallBack.onDateTimeSet$2da1b2cd(this.mDatePicker.getYear(), this.mDatePicker.getMonth(), this.mDatePicker.getDayOfMonth(), this.mTimePicker.getCurrentHour().intValue(), this.mTimePicker.getCurrentMinute().intValue());
    } 
  }
  
  public final void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3) {
    if (this.mTimePicker != null)
      onTimeChanged(this.mTimePicker, this.mTimePicker.getCurrentHour().intValue(), this.mTimePicker.getCurrentMinute().intValue()); 
  }
  
  public final void onTimeChanged(TimePicker paramTimePicker, int paramInt1, int paramInt2) {
    paramInt1 = this.mDatePicker.getYear();
    paramInt2 = this.mDatePicker.getMonth();
    int i = this.mDatePicker.getDayOfMonth();
    paramTimePicker = this.mTimePicker;
    long l1 = this.mMinTimeMillis;
    long l2 = this.mMaxTimeMillis;
    GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    gregorianCalendar.clear();
    gregorianCalendar.set(paramInt1, paramInt2, i, paramTimePicker.getCurrentHour().intValue(), paramTimePicker.getCurrentMinute().intValue(), 0);
    if (gregorianCalendar.getTimeInMillis() < l1) {
      gregorianCalendar.setTimeInMillis(l1);
    } else if (gregorianCalendar.getTimeInMillis() > l2) {
      gregorianCalendar.setTimeInMillis(l2);
    } 
    setHour(paramTimePicker, gregorianCalendar.get(11));
    setMinute(paramTimePicker, gregorianCalendar.get(12));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\DateTimePickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */