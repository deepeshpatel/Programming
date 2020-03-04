package com.sutra.algo.sequence.number;

class NumberGeneratorParams {

    String symbols;
    int size;
    int startFrom;
    int skipEvery;

    NumberGeneratorParams(String symbols, int size, int startFrom, int skipEvery) {
        init(symbols, size, startFrom, skipEvery);
    }

    NumberGeneratorParams(int base, int size, int startFrom, int skipEvery) {

        char[] numericSymbols = new char[base];

        for(int i=0; i<base && i<10; i++) {
            numericSymbols[i] = (char) (i + '0');
        }

        for(int i=10; i<base; i++) {
            numericSymbols[i] = (char) ('A' + (i-10));
        }

        init(new String(numericSymbols), size, startFrom, skipEvery);
    }

    private void init(String symbols, int size, int startFrom, int skipEvery) {
        this.symbols = symbols;
        this.size = size;
        this.startFrom = startFrom;
        this.skipEvery = skipEvery;
    }

}
