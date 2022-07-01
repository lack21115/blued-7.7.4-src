package org.chromium.components.variations.firstrun;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public final class VariationsSeedFetcher$SeedInfo {
  public String country;
  
  public String date;
  
  public boolean isGzipCompressed;
  
  public byte[] seedData;
  
  public String signature;
  
  public final Date parseDate() {
    return (new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US)).parse(this.date);
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("SeedInfo{signature=\"");
    stringBuilder.append(this.signature);
    stringBuilder.append("\" country=\"");
    stringBuilder.append(this.country);
    stringBuilder.append("\" date=\"");
    stringBuilder.append(this.date);
    stringBuilder.append(" isGzipCompressed=");
    stringBuilder.append(this.isGzipCompressed);
    stringBuilder.append(" seedData=");
    stringBuilder.append(Arrays.toString(this.seedData));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\variations\firstrun\VariationsSeedFetcher$SeedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */