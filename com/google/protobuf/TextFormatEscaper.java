package com.google.protobuf;

final class TextFormatEscaper {
  static String escapeBytes(ByteString paramByteString) {
    TextFormatEscaper$1 textFormatEscaper$1 = new TextFormatEscaper$1(paramByteString);
    StringBuilder stringBuilder = new StringBuilder(textFormatEscaper$1.size());
    for (int i = 0; i < textFormatEscaper$1.size(); i++) {
      byte b = textFormatEscaper$1.byteAt(i);
      if (b != 34) {
        if (b != 39) {
          if (b != 92) {
            switch (b) {
              default:
                if (b >= 32 && b <= 126) {
                  stringBuilder.append((char)b);
                  break;
                } 
                stringBuilder.append('\\');
                stringBuilder.append((char)((b >>> 6 & 0x3) + 48));
                stringBuilder.append((char)((b >>> 3 & 0x7) + 48));
                stringBuilder.append((char)((b & 0x7) + 48));
                break;
              case 13:
                stringBuilder.append("\\r");
                break;
              case 12:
                stringBuilder.append("\\f");
                break;
              case 11:
                stringBuilder.append("\\v");
                break;
              case 10:
                stringBuilder.append("\\n");
                break;
              case 9:
                stringBuilder.append("\\t");
                break;
              case 8:
                stringBuilder.append("\\b");
                break;
              case 7:
                stringBuilder.append("\\a");
                break;
            } 
          } else {
            stringBuilder.append("\\\\");
          } 
        } else {
          stringBuilder.append("\\'");
        } 
      } else {
        stringBuilder.append("\\\"");
      } 
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\TextFormatEscaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */