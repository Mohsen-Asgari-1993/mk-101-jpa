package ir.maktabsharif101.jpaexample.util;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class SemaphoreUtil {

    private SemaphoreUtil() {
    }

    private static final Semaphore newCustomerSemaphore = new Semaphore(1);

    @SneakyThrows
    public static void acquireNewCustomerSemaphore() {
        newCustomerSemaphore.acquire();
    }

    public static void releaseNewCustomerSemaphore() {
        newCustomerSemaphore.release();
    }

}
