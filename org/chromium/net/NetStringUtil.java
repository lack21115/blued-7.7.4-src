package org.chromium.net;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.text.Normalizer;
import java.util.Locale;
import org.chromium.base.annotations.CalledByNative;

public class NetStringUtil {
  @CalledByNative
  private static String convertToUnicode(ByteBuffer paramByteBuffer, String paramString) {
    try {
      return Charset.forName(paramString).newDecoder().decode(paramByteBuffer).toString();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  @CalledByNative
  private static String convertToUnicodeAndNormalize(ByteBuffer paramByteBuffer, String paramString) {
    String str = convertToUnicode(paramByteBuffer, paramString);
    return (str == null) ? null : Normalizer.normalize(str, Normalizer.Form.NFC);
  }
  
  @CalledByNative
  private static String convertToUnicodeWithSubstitutions(ByteBuffer paramByteBuffer, String paramString) {
    try {
      CharsetDecoder charsetDecoder = Charset.forName(paramString).newDecoder();
      charsetDecoder.onMalformedInput(CodingErrorAction.REPLACE);
      charsetDecoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
      charsetDecoder.replaceWith("�");
      return charsetDecoder.decode(paramByteBuffer).toString();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  @CalledByNative
  private static String toUpperCase(String paramString) {
    try {
      return paramString.toUpperCase(Locale.getDefault());
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\NetStringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */