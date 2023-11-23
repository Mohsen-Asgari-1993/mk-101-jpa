package ir.maktabsharif101.jpaexample.service.impl;

import ir.maktabsharif101.jpaexample.base.service.BaseEntityServiceImpl;
import ir.maktabsharif101.jpaexample.domain.Wallet;
import ir.maktabsharif101.jpaexample.repository.WalletRepository;
import ir.maktabsharif101.jpaexample.service.WalletService;

public class WalletServiceImpl extends BaseEntityServiceImpl<Wallet, Long, WalletRepository>
        implements WalletService {

    public WalletServiceImpl(WalletRepository baseRepository) {
        super(baseRepository);
    }
}
