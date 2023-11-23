package ir.maktabsharif101.jpaexample.util;

import ir.maktabsharif101.jpaexample.repository.*;
import ir.maktabsharif101.jpaexample.repository.impl.*;
import ir.maktabsharif101.jpaexample.service.*;
import ir.maktabsharif101.jpaexample.service.impl.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@SuppressWarnings("unused")
public class ApplicationContext {

    private static final EntityManager entityManager =
            Persistence.createEntityManagerFactory(
                    "default"
            ).createEntityManager();

    private AddressRepository addressRepository;

    private AdminRepository adminRepository;

    private CustomerRepository customerRepository;

    private PermissionRepository permissionRepository;

    private RoleRepository roleRepository;

    private UserRepository userRepository;

    private WalletRepository walletRepository;

    private AddressService addressService;

    private AdminService adminService;

    private CustomerService customerService;

    private PermissionService permissionService;

    private RoleService roleService;

    private UserService userService;

    private WalletService walletService;

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public AddressRepository getAddressRepository() {
        if (addressRepository == null) {
            addressRepository = new AddressRepositoryImpl(entityManager);
        }
        return addressRepository;
    }

    public AdminRepository getAdminRepository() {
        if (adminRepository == null) {
            adminRepository = new AdminRepositoryImpl(entityManager);
        }
        return adminRepository;
    }

    public CustomerRepository getCustomerRepository() {
        if (customerRepository == null) {
            customerRepository = new CustomerRepositoryImpl(entityManager);
        }
        return customerRepository;
    }

    public PermissionRepository getPermissionRepository() {
        if (permissionRepository == null) {
            permissionRepository = new PermissionRepositoryImpl(entityManager);
        }
        return permissionRepository;
    }

    public RoleRepository getRoleRepository() {
        if (roleRepository == null) {
            roleRepository = new RoleRepositoryImpl(entityManager);
        }
        return roleRepository;
    }

    public UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl(entityManager);
        }
        return userRepository;
    }

    public WalletRepository getWalletRepository() {
        if (walletRepository == null) {
            walletRepository = new WalletRepositoryImpl(entityManager);
        }
        return walletRepository;
    }

    public AddressService getAddressService() {
        if (addressService == null) {
            addressService = new AddressServiceImpl(
                    getAddressRepository()
            );
        }
        return addressService;
    }

    public AdminService getAdminService() {
        if (adminService == null) {
            adminService = new AdminServiceImpl(
                    getAdminRepository()
            );
        }
        return adminService;
    }

    public CustomerService getCustomerService() {
        if (customerService == null) {
            customerService = new CustomerServiceImpl(
                    getCustomerRepository()
            );
        }
        return customerService;
    }

    public PermissionService getPermissionService() {
        if (permissionService == null) {
            permissionService = new PermissionServiceImpl(
                    getPermissionRepository()
            );
        }
        return permissionService;
    }

    public RoleService getRoleService() {
        if (roleService == null) {
            roleService = new RoleServiceImpl(
                    getRoleRepository()
            );
        }
        return roleService;
    }

    public UserService getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl(
                    getUserRepository()
            );
        }
        return userService;
    }

    public WalletService getWalletService() {
        if (walletService == null) {
            walletService = new WalletServiceImpl(
                    getWalletRepository()
            );
        }
        return walletService;
    }
}
