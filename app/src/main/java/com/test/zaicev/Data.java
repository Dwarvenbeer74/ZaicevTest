package com.test.zaicev;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



public class Data {

    public @Nullable int[] decryptData(@NonNull int[] price,
                                       @IntRange(from = 1) int discount,
                                       @IntRange(from = 0) int offset,
                                       @IntRange(from = 1) int readLength) {
        int[] result = null;

        if (offset + readLength < price.length) {
            result = new int[readLength];
            float discountCoeff = (100f - discount)/100f;
            if (discountCoeff < 0) discountCoeff = 0;
            for (int i = 0; i <= readLength; i++) {
                result[i] = ((int) Math.floor(price[offset + i] * discountCoeff));
            }
        }

        return result;
    }
}
