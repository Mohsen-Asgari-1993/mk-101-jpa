package ir.maktabsharif101.jpaexample.service.impl;

import ir.maktabsharif101.jpaexample.base.service.BaseEntityServiceImpl;
import ir.maktabsharif101.jpaexample.domain.Wallet;
import ir.maktabsharif101.jpaexample.domain.enumeration.UserType;
import ir.maktabsharif101.jpaexample.repository.WalletRepository;
import ir.maktabsharif101.jpaexample.service.WalletService;
import ir.maktabsharif101.jpaexample.util.SecurityContext;

public class WalletServiceImpl extends BaseEntityServiceImpl<Wallet, Long, WalletRepository>
        implements WalletService {

    public WalletServiceImpl(WalletRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public Wallet getMyWallet() {
        if (!SecurityContext.isAnyoneAuthenticated()) {
            throw new RuntimeException("access denied");
        }

        if (!UserType.CUSTOMER.name().equals(SecurityContext.getCurrentUserType())) {
            throw new RuntimeException("access denied: only customers can use this method");
        }

        return baseRepository.findByCustomerId(
                SecurityContext.getCurrentUserId()
        );
    }
}
