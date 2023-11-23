package ir.maktabsharif101.jpaexample.service.impl;

import ir.maktabsharif101.jpaexample.service.RandomStringService;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomStringServiceImpl implements RandomStringService {

    public List<String> generateRandomStringList() {
        System.out.println("in original object");
        List<String> strings = new ArrayList<>();
        int nextInt = ThreadLocalRandom.current().nextInt(5, 10);
        for (int i = 0; i < nextInt; i++) {
            strings.add(
                    RandomStringUtils.randomAlphabetic(5)
            );
        }
        return strings;
    }

}
