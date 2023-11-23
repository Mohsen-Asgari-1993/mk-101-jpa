package ir.maktabsharif101.jpaexample.service.impl;

import ir.maktabsharif101.jpaexample.service.RandomStringService;

import java.util.List;

public class RandomStringProxyServiceImpl implements RandomStringService {

    private final RandomStringService originalService = new RandomStringServiceImpl();

    private int counter = 0;

    private List<String> stringList;

    @Override
    public List<String> generateRandomStringList() {
        System.out.println("in proxy object");
        if (counter % 3 == 0) {
            stringList = originalService.generateRandomStringList();
        }
        counter++;
        return stringList;
    }
}
