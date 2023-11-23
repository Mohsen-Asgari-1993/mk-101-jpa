package ir.maktabsharif101.jpaexample.repository;

import ir.maktabsharif101.jpaexample.base.repository.BaseEntityRepository;
import ir.maktabsharif101.jpaexample.domain.Wallet;

public interface WalletRepository extends BaseEntityRepository<Wallet, Long> {

    Wallet findByCustomerId(Long customerId);

}
