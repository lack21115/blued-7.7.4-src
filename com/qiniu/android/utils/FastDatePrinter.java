package com.qiniu.android.utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public final class FastDatePrinter {
  public static final int FULL = 0;
  
  public static final int LONG = 1;
  
  private static final int MAX_DIGITS = 10;
  
  public static final int MEDIUM = 2;
  
  public static final int SHORT = 3;
  
  private final Locale mLocale;
  
  private transient int mMaxLengthEstimate;
  
  private final String mPattern;
  
  private transient Rule[] mRules;
  
  private final TimeZone mTimeZone;
  
  public FastDatePrinter(String paramString, TimeZone paramTimeZone, Locale paramLocale) {
    this.mPattern = paramString;
    this.mTimeZone = paramTimeZone;
    this.mLocale = paramLocale;
    init();
  }
  
  private static void appendDigits(Appendable paramAppendable, int paramInt) throws IOException {
    paramAppendable.append((char)(paramInt / 10 + 48));
    paramAppendable.append((char)(paramInt % 10 + 48));
  }
  
  private static void appendFullDigits(Appendable paramAppendable, int paramInt1, int paramInt2) throws IOException {
    if (paramInt1 < 10000) {
      byte b;
      if (paramInt1 < 1000) {
        if (paramInt1 < 100) {
          if (paramInt1 < 10) {
            b = 1;
          } else {
            b = 2;
          } 
        } else {
          b = 3;
        } 
      } else {
        b = 4;
      } 
      for (paramInt2 -= b; paramInt2 > 0; paramInt2--)
        paramAppendable.append('0'); 
      paramInt2 = paramInt1;
      if (b != 1) {
        paramInt2 = paramInt1;
        if (b != 2) {
          paramInt2 = paramInt1;
          if (b != 3) {
            if (b != 4)
              return; 
            paramAppendable.append((char)(paramInt1 / 1000 + 48));
            paramInt2 = paramInt1 % 1000;
          } 
          if (paramInt2 >= 100) {
            paramAppendable.append((char)(paramInt2 / 100 + 48));
            paramInt2 %= 100;
          } else {
            paramAppendable.append('0');
          } 
        } 
        if (paramInt2 >= 10) {
          paramAppendable.append((char)(paramInt2 / 10 + 48));
          paramInt2 %= 10;
        } else {
          paramAppendable.append('0');
        } 
      } 
      paramAppendable.append((char)(paramInt2 + 48));
      return;
    } 
    char[] arrayOfChar = new char[10];
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (true) {
      j = paramInt2;
      if (i != 0) {
        arrayOfChar[paramInt1] = (char)(i % 10 + 48);
        i /= 10;
        paramInt1++;
        continue;
      } 
      break;
    } 
    while (true) {
      paramInt2 = paramInt1;
      if (paramInt1 < j) {
        paramAppendable.append('0');
        j--;
        continue;
      } 
      break;
    } 
    while (true) {
      if (--paramInt2 >= 0) {
        paramAppendable.append(arrayOfChar[paramInt2]);
        continue;
      } 
      break;
    } 
  }
  
  private <B extends Appendable> B applyRules(Calendar paramCalendar, B paramB) {
    try {
      Rule[] arrayOfRule = this.mRules;
      int j = arrayOfRule.length;
      for (int i = 0; i < j; i++)
        arrayOfRule[i].appendTo((Appendable)paramB, paramCalendar); 
      return paramB;
    } catch (IOException iOException) {
      return paramB;
    } 
  }
  
  private String applyRulesToString(Calendar paramCalendar) {
    return ((StringBuilder)applyRules(paramCalendar, new StringBuilder(this.mMaxLengthEstimate))).toString();
  }
  
  private void init() {
    List<Rule> list = parsePattern();
    this.mRules = list.<Rule>toArray(new Rule[list.size()]);
    int j = this.mRules.length;
    int i = 0;
    while (true) {
      if (--j >= 0) {
        i += this.mRules[j].estimateLength();
        continue;
      } 
      this.mMaxLengthEstimate = i;
      return;
    } 
  }
  
  private Calendar newCalendar() {
    return Calendar.getInstance(this.mTimeZone, this.mLocale);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    init();
  }
  
  @Deprecated
  protected StringBuffer applyRules(Calendar paramCalendar, StringBuffer paramStringBuffer) {
    return applyRules(paramCalendar, paramStringBuffer);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof FastDatePrinter;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (this.mPattern.equals(((FastDatePrinter)paramObject).mPattern)) {
      bool = bool1;
      if (this.mTimeZone.equals(((FastDatePrinter)paramObject).mTimeZone)) {
        bool = bool1;
        if (this.mLocale.equals(((FastDatePrinter)paramObject).mLocale))
          bool = true; 
      } 
    } 
    return bool;
  }
  
  public <B extends Appendable> B format(long paramLong, B paramB) {
    Calendar calendar = newCalendar();
    calendar.setTimeInMillis(paramLong);
    return applyRules(calendar, paramB);
  }
  
  public <B extends Appendable> B format(Calendar paramCalendar, B paramB) {
    Calendar calendar = paramCalendar;
    if (!paramCalendar.getTimeZone().equals(this.mTimeZone)) {
      calendar = (Calendar)paramCalendar.clone();
      calendar.setTimeZone(this.mTimeZone);
    } 
    return applyRules(calendar, paramB);
  }
  
  public <B extends Appendable> B format(Date paramDate, B paramB) {
    Calendar calendar = newCalendar();
    calendar.setTime(paramDate);
    return applyRules(calendar, paramB);
  }
  
  public String format(long paramLong) {
    Calendar calendar = newCalendar();
    calendar.setTimeInMillis(paramLong);
    return applyRulesToString(calendar);
  }
  
  String format(Object paramObject) {
    if (paramObject instanceof Date)
      return format((Date)paramObject); 
    if (paramObject instanceof Calendar)
      return format((Calendar)paramObject); 
    if (paramObject instanceof Long)
      return format(((Long)paramObject).longValue()); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unknown class: ");
    if (paramObject == null) {
      paramObject = "<null>";
    } else {
      paramObject = paramObject.getClass().getName();
    } 
    stringBuilder.append((String)paramObject);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public String format(Calendar paramCalendar) {
    return ((StringBuilder)format(paramCalendar, new StringBuilder(this.mMaxLengthEstimate))).toString();
  }
  
  public String format(Date paramDate) {
    Calendar calendar = newCalendar();
    calendar.setTime(paramDate);
    return applyRulesToString(calendar);
  }
  
  public StringBuffer format(long paramLong, StringBuffer paramStringBuffer) {
    Calendar calendar = newCalendar();
    calendar.setTimeInMillis(paramLong);
    return applyRules(calendar, paramStringBuffer);
  }
  
  @Deprecated
  public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition) {
    if (paramObject instanceof Date)
      return format((Date)paramObject, paramStringBuffer); 
    if (paramObject instanceof Calendar)
      return format((Calendar)paramObject, paramStringBuffer); 
    if (paramObject instanceof Long)
      return format(((Long)paramObject).longValue(), paramStringBuffer); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unknown class: ");
    if (paramObject == null) {
      paramObject = "<null>";
    } else {
      paramObject = paramObject.getClass().getName();
    } 
    stringBuilder.append((String)paramObject);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public StringBuffer format(Calendar paramCalendar, StringBuffer paramStringBuffer) {
    return format(paramCalendar.getTime(), paramStringBuffer);
  }
  
  public StringBuffer format(Date paramDate, StringBuffer paramStringBuffer) {
    Calendar calendar = newCalendar();
    calendar.setTime(paramDate);
    return applyRules(calendar, paramStringBuffer);
  }
  
  public Locale getLocale() {
    return this.mLocale;
  }
  
  public int getMaxLengthEstimate() {
    return this.mMaxLengthEstimate;
  }
  
  public String getPattern() {
    return this.mPattern;
  }
  
  public TimeZone getTimeZone() {
    return this.mTimeZone;
  }
  
  public int hashCode() {
    return this.mPattern.hashCode() + (this.mTimeZone.hashCode() + this.mLocale.hashCode() * 13) * 13;
  }
  
  protected List<Rule> parsePattern() {
    DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
    ArrayList<Rule> arrayList = new ArrayList();
    String[] arrayOfString3 = dateFormatSymbols.getEras();
    String[] arrayOfString4 = dateFormatSymbols.getMonths();
    String[] arrayOfString5 = dateFormatSymbols.getShortMonths();
    String[] arrayOfString1 = dateFormatSymbols.getWeekdays();
    String[] arrayOfString2 = dateFormatSymbols.getShortWeekdays();
    String[] arrayOfString6 = dateFormatSymbols.getAmPmStrings();
    int j = this.mPattern.length();
    int[] arrayOfInt = new int[1];
    for (int i = 0; i < j; i = k + 1) {
      TimeZoneNumberRule timeZoneNumberRule;
      Iso8601_Rule iso8601_Rule;
      NumberRule numberRule4;
      TextField textField3;
      NumberRule numberRule3;
      StringBuilder stringBuilder1;
      TextField textField2;
      NumberRule numberRule2;
      TextField textField1;
      NumberRule numberRule1;
      String str1;
      CharacterLiteral characterLiteral;
      StringLiteral stringLiteral;
      StringBuilder stringBuilder2;
      arrayOfInt[0] = i;
      String str2 = parseToken(this.mPattern, arrayOfInt);
      int k = arrayOfInt[0];
      i = str2.length();
      if (i == 0)
        return arrayList; 
      char c = str2.charAt(0);
      byte b = 4;
      switch (c) {
        default:
          switch (c) {
            default:
              switch (c) {
                default:
                  stringBuilder2 = new StringBuilder();
                  stringBuilder2.append("Illegal pattern component: ");
                  stringBuilder2.append(str2);
                  throw new IllegalArgumentException(stringBuilder2.toString());
                case 'Z':
                  if (i == 1) {
                    TimeZoneNumberRule timeZoneNumberRule1 = TimeZoneNumberRule.INSTANCE_NO_COLON;
                    break;
                  } 
                  if (i == 2) {
                    Iso8601_Rule iso8601_Rule1 = Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES;
                    break;
                  } 
                  timeZoneNumberRule = TimeZoneNumberRule.INSTANCE_COLON;
                  break;
                case 'Y':
                  break;
                case 'X':
                  iso8601_Rule = Iso8601_Rule.getRule(i);
                  break;
                case 'W':
                  break;
              } 
              numberRule4 = selectNumberRule(4, i);
              break;
            case 'H':
              numberRule4 = selectNumberRule(11, i);
              break;
            case 'G':
              textField3 = new TextField(0, arrayOfString3);
              break;
            case 'F':
              numberRule3 = selectNumberRule(8, i);
              break;
            case 'E':
              if (i < 4) {
                String[] arrayOfString = arrayOfString2;
              } else {
                stringBuilder1 = stringBuilder2;
              } 
              textField2 = new TextField(7, (String[])stringBuilder1);
              break;
            case 'D':
              numberRule2 = selectNumberRule(6, i);
              break;
          } 
        case 'y':
          if (i == 2) {
            numberRule2 = TwoDigitYearField.INSTANCE;
            break;
          } 
          if (i < 4)
            i = b; 
          numberRule2 = selectNumberRule(1, i);
          break;
        case 'w':
          numberRule2 = selectNumberRule(3, i);
          break;
        case 'u':
          numberRule2 = new DayInWeekField(selectNumberRule(7, i));
          break;
        case 's':
          numberRule2 = selectNumberRule(13, i);
          break;
        case 'm':
          numberRule2 = selectNumberRule(12, i);
          break;
        case 'k':
          numberRule2 = new TwentyFourHourField(selectNumberRule(11, i));
          break;
        case 'h':
          numberRule2 = new TwelveHourField(selectNumberRule(10, i));
          break;
        case 'd':
          numberRule2 = selectNumberRule(5, i);
          break;
        case 'a':
          textField1 = new TextField(9, arrayOfString6);
          break;
        case 'S':
          numberRule1 = selectNumberRule(14, i);
          break;
        case 'M':
          if (i >= 4) {
            TextField textField = new TextField(2, arrayOfString4);
            break;
          } 
          if (i == 3) {
            TextField textField = new TextField(2, arrayOfString5);
            break;
          } 
          if (i == 2) {
            numberRule1 = TwoDigitMonthField.INSTANCE;
            break;
          } 
          numberRule1 = UnpaddedMonthField.INSTANCE;
          break;
        case 'K':
          numberRule1 = selectNumberRule(10, i);
          break;
        case '\'':
          str1 = numberRule1.substring(1);
          if (str1.length() == 1) {
            characterLiteral = new CharacterLiteral(str1.charAt(0));
            break;
          } 
          stringLiteral = new StringLiteral((String)characterLiteral);
          break;
      } 
      arrayList.add(stringLiteral);
    } 
    return arrayList;
  }
  
  protected String parseToken(String paramString, int[] paramArrayOfint) {
    int j;
    StringBuilder stringBuilder = new StringBuilder();
    int i = paramArrayOfint[0];
    int k = paramString.length();
    char c = paramString.charAt(i);
    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
      stringBuilder.append(c);
      while (true) {
        int m = i + 1;
        j = i;
        if (m < k) {
          j = i;
          if (paramString.charAt(m) == c) {
            stringBuilder.append(c);
            i = m;
            continue;
          } 
        } 
        break;
      } 
    } else {
      stringBuilder.append('\'');
      int m = 0;
      while (true) {
        j = i;
        if (i < k) {
          c = paramString.charAt(i);
          if (c == '\'') {
            j = i + 1;
            if (j < k && paramString.charAt(j) == '\'') {
              stringBuilder.append(c);
              i = j;
            } else {
              m ^= 0x1;
            } 
          } else {
            if (m == 0 && ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
              j = i - 1;
              break;
            } 
            stringBuilder.append(c);
          } 
          i++;
          continue;
        } 
        break;
      } 
    } 
    paramArrayOfint[0] = j;
    return stringBuilder.toString();
  }
  
  protected NumberRule selectNumberRule(int paramInt1, int paramInt2) {
    return (NumberRule)((paramInt2 != 1) ? ((paramInt2 != 2) ? new PaddedNumberField(paramInt1, paramInt2) : new TwoDigitNumberField(paramInt1)) : new UnpaddedNumberField(paramInt1));
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("FastDatePrinter[");
    stringBuilder.append(this.mPattern);
    stringBuilder.append(",");
    stringBuilder.append(this.mLocale);
    stringBuilder.append(",");
    stringBuilder.append(this.mTimeZone.getID());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  static class CharacterLiteral implements Rule {
    private final char mValue;
    
    CharacterLiteral(char param1Char) {
      this.mValue = param1Char;
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      param1Appendable.append(this.mValue);
    }
    
    public int estimateLength() {
      return 1;
    }
  }
  
  static class DayInWeekField implements NumberRule {
    private final FastDatePrinter.NumberRule mRule;
    
    DayInWeekField(FastDatePrinter.NumberRule param1NumberRule) {
      this.mRule = param1NumberRule;
    }
    
    public void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      this.mRule.appendTo(param1Appendable, param1Int);
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      int i = 7;
      int j = param1Calendar.get(7);
      FastDatePrinter.NumberRule numberRule = this.mRule;
      if (j != 1)
        i = j - 1; 
      numberRule.appendTo(param1Appendable, i);
    }
    
    public int estimateLength() {
      return this.mRule.estimateLength();
    }
  }
  
  static class Iso8601_Rule implements Rule {
    static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
    
    static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);
    
    static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
    
    final int length;
    
    static {
    
    }
    
    Iso8601_Rule(int param1Int) {
      this.length = param1Int;
    }
    
    static Iso8601_Rule getRule(int param1Int) {
      if (param1Int != 1) {
        if (param1Int != 2) {
          if (param1Int == 3)
            return ISO8601_HOURS_COLON_MINUTES; 
          throw new IllegalArgumentException("invalid number of X");
        } 
        return ISO8601_HOURS_MINUTES;
      } 
      return ISO8601_HOURS;
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      int i = param1Calendar.get(15) + param1Calendar.get(16);
      if (i == 0) {
        param1Appendable.append("Z");
        return;
      } 
      if (i < 0) {
        param1Appendable.append('-');
        i = -i;
      } else {
        param1Appendable.append('+');
      } 
      int j = i / 3600000;
      FastDatePrinter.appendDigits(param1Appendable, j);
      int k = this.length;
      if (k < 5)
        return; 
      if (k == 6)
        param1Appendable.append(':'); 
      FastDatePrinter.appendDigits(param1Appendable, i / 60000 - j * 60);
    }
    
    public int estimateLength() {
      return this.length;
    }
  }
  
  static interface NumberRule extends Rule {
    void appendTo(Appendable param1Appendable, int param1Int) throws IOException;
  }
  
  static class PaddedNumberField implements NumberRule {
    private final int mField;
    
    private final int mSize;
    
    PaddedNumberField(int param1Int1, int param1Int2) {
      if (param1Int2 >= 3) {
        this.mField = param1Int1;
        this.mSize = param1Int2;
        return;
      } 
      throw new IllegalArgumentException();
    }
    
    public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      FastDatePrinter.appendFullDigits(param1Appendable, param1Int, this.mSize);
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      appendTo(param1Appendable, param1Calendar.get(this.mField));
    }
    
    public int estimateLength() {
      return this.mSize;
    }
  }
  
  static interface Rule {
    void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException;
    
    int estimateLength();
  }
  
  static class StringLiteral implements Rule {
    private final String mValue;
    
    StringLiteral(String param1String) {
      this.mValue = param1String;
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      param1Appendable.append(this.mValue);
    }
    
    public int estimateLength() {
      return this.mValue.length();
    }
  }
  
  static class TextField implements Rule {
    private final int mField;
    
    private final String[] mValues;
    
    TextField(int param1Int, String[] param1ArrayOfString) {
      this.mField = param1Int;
      this.mValues = param1ArrayOfString;
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      param1Appendable.append(this.mValues[param1Calendar.get(this.mField)]);
    }
    
    public int estimateLength() {
      int i = this.mValues.length;
      int j = 0;
      while (true) {
        int k = i - 1;
        if (k >= 0) {
          int m = this.mValues[k].length();
          i = k;
          if (m > j) {
            j = m;
            i = k;
          } 
          continue;
        } 
        return j;
      } 
    }
  }
  
  static class TimeZoneNumberRule implements Rule {
    static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
    
    static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
    
    final boolean mColon;
    
    TimeZoneNumberRule(boolean param1Boolean) {
      this.mColon = param1Boolean;
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      int i = param1Calendar.get(15) + param1Calendar.get(16);
      if (i < 0) {
        param1Appendable.append('-');
        i = -i;
      } else {
        param1Appendable.append('+');
      } 
      int j = i / 3600000;
      FastDatePrinter.appendDigits(param1Appendable, j);
      if (this.mColon)
        param1Appendable.append(':'); 
      FastDatePrinter.appendDigits(param1Appendable, i / 60000 - j * 60);
    }
    
    public int estimateLength() {
      return 5;
    }
  }
  
  static class TwelveHourField implements NumberRule {
    private final FastDatePrinter.NumberRule mRule;
    
    TwelveHourField(FastDatePrinter.NumberRule param1NumberRule) {
      this.mRule = param1NumberRule;
    }
    
    public void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      this.mRule.appendTo(param1Appendable, param1Int);
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      int j = param1Calendar.get(10);
      int i = j;
      if (j == 0)
        i = param1Calendar.getLeastMaximum(10) + 1; 
      this.mRule.appendTo(param1Appendable, i);
    }
    
    public int estimateLength() {
      return this.mRule.estimateLength();
    }
  }
  
  static class TwentyFourHourField implements NumberRule {
    private final FastDatePrinter.NumberRule mRule;
    
    TwentyFourHourField(FastDatePrinter.NumberRule param1NumberRule) {
      this.mRule = param1NumberRule;
    }
    
    public void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      this.mRule.appendTo(param1Appendable, param1Int);
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      int j = param1Calendar.get(11);
      int i = j;
      if (j == 0)
        i = param1Calendar.getMaximum(11) + 1; 
      this.mRule.appendTo(param1Appendable, i);
    }
    
    public int estimateLength() {
      return this.mRule.estimateLength();
    }
  }
  
  static class TwoDigitMonthField implements NumberRule {
    static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();
    
    public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      FastDatePrinter.appendDigits(param1Appendable, param1Int);
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      appendTo(param1Appendable, param1Calendar.get(2) + 1);
    }
    
    public int estimateLength() {
      return 2;
    }
  }
  
  static class TwoDigitNumberField implements NumberRule {
    private final int mField;
    
    TwoDigitNumberField(int param1Int) {
      this.mField = param1Int;
    }
    
    public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      if (param1Int < 100) {
        FastDatePrinter.appendDigits(param1Appendable, param1Int);
        return;
      } 
      FastDatePrinter.appendFullDigits(param1Appendable, param1Int, 2);
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      appendTo(param1Appendable, param1Calendar.get(this.mField));
    }
    
    public int estimateLength() {
      return 2;
    }
  }
  
  static class TwoDigitYearField implements NumberRule {
    static final TwoDigitYearField INSTANCE = new TwoDigitYearField();
    
    public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      FastDatePrinter.appendDigits(param1Appendable, param1Int);
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      appendTo(param1Appendable, param1Calendar.get(1) % 100);
    }
    
    public int estimateLength() {
      return 2;
    }
  }
  
  static class UnpaddedMonthField implements NumberRule {
    static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();
    
    public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      if (param1Int < 10) {
        param1Appendable.append((char)(param1Int + 48));
        return;
      } 
      FastDatePrinter.appendDigits(param1Appendable, param1Int);
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      appendTo(param1Appendable, param1Calendar.get(2) + 1);
    }
    
    public int estimateLength() {
      return 2;
    }
  }
  
  static class UnpaddedNumberField implements NumberRule {
    private final int mField;
    
    UnpaddedNumberField(int param1Int) {
      this.mField = param1Int;
    }
    
    public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      if (param1Int < 10) {
        param1Appendable.append((char)(param1Int + 48));
        return;
      } 
      if (param1Int < 100) {
        FastDatePrinter.appendDigits(param1Appendable, param1Int);
        return;
      } 
      FastDatePrinter.appendFullDigits(param1Appendable, param1Int, 1);
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      appendTo(param1Appendable, param1Calendar.get(this.mField));
    }
    
    public int estimateLength() {
      return 4;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\androi\\utils\FastDatePrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */