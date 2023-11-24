package ir.maktabsharif101.jpaexample.util;

import ir.maktabsharif101.jpaexample.repository.*;
import ir.maktabsharif101.jpaexample.repository.impl.*;
import ir.maktabsharif101.jpaexample.service.*;
import ir.maktabsharif101.jpaexample.service.impl.*;
import ir.maktabsharif101.jpaexample.service.proxy.CustomerProxyServiceImpl;
import ir.maktabsharif101.jpaexample.service.proxy.WalletProxyServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@SuppressWarnings("unused")
public class ApplicationContext {

    private static final EntityManager entityManager =
            Persistence.createEntityManagerFactory(
                    "default"
            ).createEntityManager();

    private static AddressRepository addressRepository;

    private static AdminRepository adminRepository;

    private static CustomerRepository customerRepository;

    private static PermissionRepository permissionRepository;

    private static RoleRepository roleRepository;

    private static UserRepository userRepository;

    private static WalletRepository walletRepository;

    private static AddressService addressService;

    private static AdminService adminService;

    private static CustomerService customerService;

    private static PermissionService permissionService;

    private static RoleService roleService;

    private static UserService userService;

    private static WalletService walletService;

    private static AuthenticationService authenticationService;

    private static CustomerService customerProxyService;

    private static WalletService walletProxyService;

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static AddressRepository getAddressRepository() {
        if (addressRepository == null) {
            addressRepository = new AddressRepositoryImpl(entityManager);
        }
        return addressRepository;
    }

    public static AdminRepository getAdminRepository() {
        if (adminRepository == null) {
            adminRepository = new AdminRepositoryImpl(entityManager);
        }
        return adminRepository;
    }

    public static CustomerRepository getCustomerRepository() {
        if (customerRepository == null) {
            customerRepository = new CustomerRepositoryImpl(entityManager);
        }
        return customerRepository;
    }

    public static PermissionRepository getPermissionRepository() {
        if (permissionRepository == null) {
            permissionRepository = new PermissionRepositoryImpl(entityManager);
        }
        return permissionRepository;
    }

    public static RoleRepository getRoleRepository() {
        if (roleRepository == null) {
            roleRepository = new RoleRepositoryImpl(entityManager);
        }
        return roleRepository;
    }

    public static UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl(entityManager);
        }
        return userRepository;
    }

    public static WalletRepository getWalletRepository() {
        if (walletRepository == null) {
            walletRepository = new WalletRepositoryImpl(entityManager);
        }
        return walletRepository;
    }

    public static AddressService getAddressService() {
        if (addressService == null) {
            addressService = new AddressServiceImpl(
                    getAddressRepository()
            );
        }
        return addressService;
    }

    public static AdminService getAdminService() {
        if (adminService == null) {
            adminService = new AdminServiceImpl(
                    getAdminRepository()
            );
        }
        return adminService;
    }

    public static CustomerService getCustomerService() {
        if (customerService == null) {
            customerService = new CustomerServiceImpl(
                    getCustomerRepository(),
                    getWalletProxyService()
            );
        }
        return customerService;
    }

    public static PermissionService getPermissionService() {
        if (permissionService == null) {
            permissionService = new PermissionServiceImpl(
                    getPermissionRepository()
            );
        }
        return permissionService;
    }

    public static RoleService getRoleService() {
        if (roleService == null) {
            roleService = new RoleServiceImpl(
                    getRoleRepository()
            );
        }
        return roleService;
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl(
                    getUserRepository()
            );
        }
        return userService;
    }

    public static WalletService getWalletService() {
        if (walletService == null) {
            walletService = new WalletServiceImpl(
                    getWalletRepository()
            );
        }
        return walletService;
    }

    public static AuthenticationService getAuthenticationService() {
        if (authenticationService == null) {
            authenticationService = new AuthenticationServiceImpl(
                    getUserService()
            );
        }
        return authenticationService;
    }

    public static CustomerService getCustomerProxyService() {
        if (customerProxyService == null) {
            customerProxyService = new CustomerProxyServiceImpl(
                    getCustomerService()
            );
        }
        return customerProxyService;
    }

    public static WalletService getWalletProxyService() {
        if (walletProxyService == null) {
            walletProxyService = new WalletProxyServiceImpl(
                    getWalletService()
            );
        }
        return walletProxyService;
    }
}
