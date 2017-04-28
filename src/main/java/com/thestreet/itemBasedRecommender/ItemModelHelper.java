package com.thestreet.itemBasedRecommender;

import java.lang.reflect.Array;

@SuppressWarnings (value="unchecked")
class ItemModelHelper {
    static <T> T[] unpack(Object array, Class<T> clazz) {
        if(array == null)
            return newArray(clazz, 0);

        T[] array2 = newArray(clazz, Array.getLength(array));
        for(int i=0;i<array2.length;i++)
            array2[i] = (T)Array.get(array, i);
        return array2;
    }

    private static <T> T[] newArray(Class<T> clazz, int size) {
        return (T[]) Array.newInstance(clazz, size);
    }
}
