package com.academy.lesson09;

public class PairContainer<T, V> {
    private T firstValue;
    private V secondValue;

    public T getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(T firstValue) {
        this.firstValue = firstValue;
    }

    public V getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(V secondValue) {
        this.secondValue = secondValue;
    }

    // Hard Code
    @Override
    public String toString() {
        if (firstValue.getClass().isArray() && secondValue.getClass().isArray()) {
//            return Arrays.toString((Object[]) firstValue) + "=>" + Arrays.toString((Object[]) secondValue);
            Object[] firstValueAsArray = (Object[]) firstValue;
            Object[] secondValueAsArray = (Object[]) secondValue;
            String result = "";
            for (int i = 0; i < firstValueAsArray.length && i < secondValueAsArray.length; i++) {
                result = result + firstValueAsArray[i] + "=>" + secondValueAsArray[i] + " ";
            }
            return result;
        }
        else
            return firstValue + "=>" + secondValue;
    }
}
