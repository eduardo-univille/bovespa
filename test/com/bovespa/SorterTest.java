package com.bovespa;

import org.junit.Test;

public class SorterTest {
    @Test
    public void sorterTest() throws Exception {
        StockReader stockReader = new StockReader();
        Stock[] stocks = stockReader.read("C:/Users/TEMP/COTAHIST_A2016.TXT");

        long start = System.currentTimeMillis();

        Sorter sorter = new Sorter();
        sorter.sort(stocks);

        long end = System.currentTimeMillis();

        System.out.println((end - start) - 1000);

        for (Stock stock : stocks) {
            System.out.println(stock.getCode());
        }
    }
}
