package org.chromium.content.browser.picker;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.chromium.content.R;

public final class InputDialogContainer {
  private final Context mContext;
  
  AlertDialog mDialog;
  
  boolean mDialogAlreadyDismissed;
  
  final InputDialogContainer$InputActionDelegate mInputActionDelegate;
  
  public InputDialogContainer(Context paramContext, InputDialogContainer$InputActionDelegate paramInputDialogContainer$InputActionDelegate) {
    this.mContext = paramContext;
    this.mInputActionDelegate = paramInputDialogContainer$InputActionDelegate;
  }
  
  private boolean isDialogShowing() {
    return (this.mDialog != null && this.mDialog.isShowing());
  }
  
  private void showPickerDialog(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, double paramDouble1, double paramDouble2, double paramDouble3) {
    if (isDialogShowing())
      this.mDialog.dismiss(); 
    int i = (int)paramDouble3;
    if (paramInt1 == 8) {
      DatePickerDialogCompat datePickerDialogCompat = new DatePickerDialogCompat(this.mContext, new InputDialogContainer$DateListener(this, paramInt1), paramInt2, paramInt3, paramInt4);
      DateDialogNormalizer.normalize(datePickerDialogCompat.getDatePicker(), (DatePicker.OnDateChangedListener)datePickerDialogCompat, paramInt2, paramInt3, paramInt4, (long)paramDouble1, (long)paramDouble2);
      datePickerDialogCompat.setTitle(this.mContext.getText(R.string.date_picker_dialog_title));
      this.mDialog = (AlertDialog)datePickerDialogCompat;
    } else if (paramInt1 == 12) {
      if (i < 0 || i >= 60000) {
        this.mDialog = (AlertDialog)new TimePickerDialog(this.mContext, new InputDialogContainer$TimeListener(this, paramInt1), paramInt5, paramInt6, DateFormat.is24HourFormat(this.mContext));
      } else {
        this.mDialog = new MultiFieldTimePickerDialog(this.mContext, 0, paramInt5, paramInt6, paramInt7, paramInt8, (int)paramDouble1, (int)paramDouble2, i, DateFormat.is24HourFormat(this.mContext), new InputDialogContainer$FullTimeListener(this, paramInt1));
      } 
    } else if (paramInt1 == 9 || paramInt1 == 10) {
      this.mDialog = new DateTimePickerDialog(this.mContext, new InputDialogContainer$DateTimeListener(this, paramInt1), paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, DateFormat.is24HourFormat(this.mContext), paramDouble1, paramDouble2);
    } else if (paramInt1 == 11) {
      this.mDialog = new MonthPickerDialog(this.mContext, new InputDialogContainer$MonthOrWeekListener(this, paramInt1), paramInt2, paramInt3, paramDouble1, paramDouble2);
    } else if (paramInt1 == 13) {
      this.mDialog = new WeekPickerDialog(this.mContext, new InputDialogContainer$MonthOrWeekListener(this, paramInt1), paramInt2, paramInt9, paramDouble1, paramDouble2);
    } 
    this.mDialog.setButton(-1, this.mContext.getText(R.string.date_picker_dialog_set), (DialogInterface.OnClickListener)this.mDialog);
    this.mDialog.setButton(-2, this.mContext.getText(17039360), null);
    this.mDialog.setButton(-3, this.mContext.getText(R.string.date_picker_dialog_clear), new InputDialogContainer$4(this));
    this.mDialog.setOnDismissListener(new InputDialogContainer$5(this));
    this.mDialogAlreadyDismissed = false;
    this.mDialog.show();
  }
  
  final void dismissDialog() {
    if (isDialogShowing())
      this.mDialog.dismiss(); 
  }
  
  protected final void setFieldDateTimeValue(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9) {
    if (this.mDialogAlreadyDismissed)
      return; 
    this.mDialogAlreadyDismissed = true;
    if (paramInt1 == 11) {
      this.mInputActionDelegate.replaceDateTime(((paramInt2 - 1970) * 12 + paramInt3));
      return;
    } 
    if (paramInt1 == 13) {
      this.mInputActionDelegate.replaceDateTime(WeekPicker.createDateFromWeek(paramInt2, paramInt9).getTimeInMillis());
      return;
    } 
    if (paramInt1 == 12) {
      this.mInputActionDelegate.replaceDateTime((TimeUnit.HOURS.toMillis(paramInt5) + TimeUnit.MINUTES.toMillis(paramInt6) + TimeUnit.SECONDS.toMillis(paramInt7) + paramInt8));
      return;
    } 
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    calendar.clear();
    calendar.set(1, paramInt2);
    calendar.set(2, paramInt3);
    calendar.set(5, paramInt4);
    calendar.set(11, paramInt5);
    calendar.set(12, paramInt6);
    calendar.set(13, paramInt7);
    calendar.set(14, paramInt8);
    this.mInputActionDelegate.replaceDateTime(calendar.getTimeInMillis());
  }
  
  public final void showDialog(int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, DateTimeSuggestion[] paramArrayOfDateTimeSuggestion) {
    dismissDialog();
    if (paramArrayOfDateTimeSuggestion == null) {
      showPickerDialog(paramInt, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
      return;
    } 
    ListView listView = new ListView(this.mContext);
    DateTimeSuggestionListAdapter dateTimeSuggestionListAdapter = new DateTimeSuggestionListAdapter(this.mContext, Arrays.asList(paramArrayOfDateTimeSuggestion));
    listView.setAdapter((ListAdapter)dateTimeSuggestionListAdapter);
    listView.setOnItemClickListener(new InputDialogContainer$1(this, dateTimeSuggestionListAdapter, paramInt, paramDouble1, paramDouble2, paramDouble3, paramDouble4));
    int i = R.string.date_picker_dialog_title;
    if (paramInt == 12) {
      i = R.string.time_picker_dialog_title;
    } else if (paramInt == 9 || paramInt == 10) {
      i = R.string.date_time_picker_dialog_title;
    } else if (paramInt == 11) {
      i = R.string.month_picker_dialog_title;
    } else if (paramInt == 13) {
      i = R.string.week_picker_dialog_title;
    } 
    this.mDialog = (new AlertDialog.Builder(this.mContext)).setTitle(i).setView((View)listView).setNegativeButton(this.mContext.getText(17039360), new InputDialogContainer$2(this)).create();
    this.mDialog.setOnDismissListener(new InputDialogContainer$3(this));
    this.mDialogAlreadyDismissed = false;
    this.mDialog.show();
  }
  
  protected final void showPickerDialog(int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
    Calendar calendar;
    if (Double.isNaN(paramDouble1)) {
      calendar = Calendar.getInstance();
      calendar.set(14, 0);
    } else if (paramInt == 11) {
      calendar = MonthPicker.createDateFromValue(paramDouble1);
    } else if (paramInt == 13) {
      calendar = WeekPicker.createDateFromValue(paramDouble1);
    } else {
      calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
      calendar.setGregorianChange(new Date(Long.MIN_VALUE));
      calendar.setTimeInMillis((long)paramDouble1);
    } 
    if (paramInt == 8) {
      showPickerDialog(paramInt, calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0, 0, 0, paramDouble2, paramDouble3, paramDouble4);
      return;
    } 
    if (paramInt == 12) {
      showPickerDialog(paramInt, 0, 0, 0, calendar.get(11), calendar.get(12), 0, 0, 0, paramDouble2, paramDouble3, paramDouble4);
      return;
    } 
    if (paramInt == 9 || paramInt == 10) {
      showPickerDialog(paramInt, calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13), calendar.get(14), 0, paramDouble2, paramDouble3, paramDouble4);
      return;
    } 
    if (paramInt == 11) {
      showPickerDialog(paramInt, calendar.get(1), calendar.get(2), 0, 0, 0, 0, 0, 0, paramDouble2, paramDouble3, paramDouble4);
      return;
    } 
    if (paramInt == 13)
      showPickerDialog(paramInt, WeekPicker.getISOWeekYearForDate(calendar), 0, 0, 0, 0, 0, 0, WeekPicker.getWeekForDate(calendar), paramDouble2, paramDouble3, paramDouble4); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\InputDialogContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */