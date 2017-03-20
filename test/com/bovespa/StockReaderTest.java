package com.bovespa;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    @Test
    public void readPetrobrasTest() throws Exception {
        StockReader stockReader = new StockReader();
        Stock[] stocks = stockReader.read("COTAHIST_A2016.TXT");
        for (Stock stock : stocks) {
            LocalDate date = stock.getDate();
            if (date.getYear() == 2016 && date.getMonthValue() == 3 && date.getDayOfMonth() == 21
                    && stock.getCode().equals("PETR4")) {
                System.out.println(stock.getOpenPrice());
                break;
            }
        }
    }

    @Test
    public void readValeTest() throws Exception {
        StockReader stockReader = new StockReader();
        Stock[] stocks = stockReader.read("COTAHIST_A2016.TXT");
        int days = 0;
        BigDecimal result = BigDecimal.ZERO;
        for (Stock stock : stocks) {
            LocalDate date = stock.getDate();
            if (stock.getCode().equals("VALE5") && date.getYear() == 2016 && date.getMonthValue() == 4) {
                days++;
                result = result.add(stock.getClosePrice());
            }
        }
        System.out.println(result.divide(BigDecimal.valueOf(days)));
    }
}
