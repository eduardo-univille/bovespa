package com.bovespa;

import org.junit.Test;

public class StockReaderTest {
    @Test
    public void readTest() throws Exception {
        StockReader stockReader = new StockReader();
        Stock[] stocks = stockReader.read("COTAHIST_A2016_MIN.TXT");
        for (Stock stock : stocks) {
            System.out.println(stock.getCode());
        }
    }
}
