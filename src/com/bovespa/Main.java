package com.bovespa;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws Exception {
        Stock[] stocks = new Stock[20];
        Stream<String> lines = Files.lines(Paths.get("COTAHIST_A2016_MIN.txt"));
        lines.forEach(new Consumer<String>() {
            private int i = 0;

            @Override
            public void accept(String line) {
                if (line.startsWith("01")) {
                    Stock stock = new Stock();
                    stock.setCode(line.substring(12, 24).trim());
                    stock.setDate(LocalDate.parse(line.substring(2, 10), DateTimeFormatter.ofPattern("yyyyMMdd")));
                    stock.setOpenPrice(new BigDecimal(line.substring(56, 67) + "." + line.substring(67, 69)));
                    stock.setClosePrice(new BigDecimal(line.substring(108, 119) + "." + line.substring(119, 121)));
                    stock.setMaxPrice(new BigDecimal(line.substring(69, 80) + "." + line.substring(80, 82)));
                    stock.setMinPrice(new BigDecimal(line.substring(82, 93) + "." + line.substring(93, 95)));
                    System.out.println(stock.getCode());
                    System.out.println(stock.getDate());
                    System.out.println(stock.getOpenPrice());
                    System.out.println(stock.getClosePrice());
                    System.out.println(stock.getMaxPrice());
                    System.out.println(stock.getMinPrice());
                    stocks[i++] = stock;
                }
            }
        });
        lines.close();
    }
}
