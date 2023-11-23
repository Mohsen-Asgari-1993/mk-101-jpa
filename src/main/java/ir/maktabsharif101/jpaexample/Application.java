package ir.maktabsharif101.jpaexample;

import ir.maktabsharif101.jpaexample.service.AuthenticationService;
import ir.maktabsharif101.jpaexample.service.WalletService;
import ir.maktabsharif101.jpaexample.service.dto.LoginDTO;
import ir.maktabsharif101.jpaexample.util.ApplicationContext;

public class Application {

    public static void main(String[] args) {

        WalletService walletService = ApplicationContext.getWalletService();
        try {
            walletService.getMyWallet();
        } catch (Exception e) {
            e.printStackTrace();
        }

        AuthenticationService authenticationService = ApplicationContext.getAuthenticationService();
        authenticationService.authenticate(
                new LoginDTO(
                        "09121213333", "matmatmat"
                )
        );

        try {
            System.out.println(
                    walletService.getMyWallet()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
