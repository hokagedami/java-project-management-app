package org.codekage.pma.utils;

import java.util.Arrays;
import java.util.List;

public class EnumUtils {
    public static <T extends Enum<T>> List<T> getEnumList(Class<T> enumClass) {
        return Arrays.asList(enumClass.getEnumConstants());
    }
}
