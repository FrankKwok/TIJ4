package com.github.frankkwok.tij4.util;

import java.util.HashMap;

/**
 * @author Frank Kwok on 2017/5/10.
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object object) {
        Class<?> type = object.getClass();
        if (!baseType.isAssignableFrom(type)) {
            throw new RuntimeException(object + " incorrect type: "
                    + type + ", should be type or subtype of "
                    + baseType);
        }
        countClass(object.getClass());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (Entry<Class<?>, Integer> pair : entrySet()) {
            builder.append(pair.getKey().getSimpleName());
            builder.append("=");
            builder.append(pair.getValue());
            builder.append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("}");
        return builder.toString();
    }

    private void countClass(Class<?> type) {
        put(type, getOrDefault(type, 0) + 1);
        Class<?> superType = type.getSuperclass();
        if (superType != null && baseType.isAssignableFrom(superType)) {
            countClass(superType);
        }
    }
}
