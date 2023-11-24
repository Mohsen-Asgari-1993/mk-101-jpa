package ir.maktabsharif101.jpaexample.service.proxy;

import ir.maktabsharif101.jpaexample.domain.Wallet;
import ir.maktabsharif101.jpaexample.service.WalletService;
import ir.maktabsharif101.jpaexample.util.TransactionProvider;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class WalletProxyServiceImpl implements WalletService {

    private final WalletService walletOriginalService;

    private final String SERVICE_NAME = "walletService";

    @Override
    public Wallet save(Wallet wallet) {
        try {
            TransactionProvider.beginTransaction(SERVICE_NAME);
            wallet = walletOriginalService.save(wallet);
            TransactionProvider.commitTransaction(SERVICE_NAME);
            return wallet;
        } catch (Exception e) {
            TransactionProvider.rollbackTransaction();
            throw e;
        }
    }

    @Override
    public List<Wallet> findAll() {
        return walletOriginalService.findAll();
    }

    @Override
    public long count() {
        return walletOriginalService.count();
    }

    @Override
    public Optional<Wallet> findById(Long id) {
        return walletOriginalService.findById(id);
    }

    @Override
    public void deleteAll() {
        try {
            TransactionProvider.beginTransaction(SERVICE_NAME);
            walletOriginalService.deleteAll();
            TransactionProvider.commitTransaction(SERVICE_NAME);
        } catch (Exception e) {
            TransactionProvider.rollbackTransaction();
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            TransactionProvider.beginTransaction(SERVICE_NAME);
            walletOriginalService.deleteById(id);
            TransactionProvider.commitTransaction(SERVICE_NAME);
        } catch (Exception e) {
            TransactionProvider.rollbackTransaction();
            throw e;
        }
    }

    @Override
    public boolean existsById(Long id) {
        return walletOriginalService.existsById(id);
    }

    @Override
    public Wallet getMyWallet() {
        return walletOriginalService.getMyWallet();
    }
}
