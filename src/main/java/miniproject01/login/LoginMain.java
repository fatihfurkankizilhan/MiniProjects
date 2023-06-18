package miniproject01.login;

import java.util.Scanner;

public class LoginMain {
    /*
    Project :   Bir siteye uye olma ve giris yapma sayfasi tasarimi



                menu:               kullaniciya islem secimi icin menu goster


               uye olma (register):kullanicidan ad soyad kullanici adi e mail ve sifre bilgileri aliniz
                                   kullanici adi email sifre birer listede tutulur
                                   ayni kullanici adi veya email kabul edilmez

               giris(login) :      kullanici adi email ve sifre girilir
                                   kullanici adi veya email bulanumazsa kayitli degil uye olun uyarisi verilir
                                   kullanici adi email ile ayni indekste kayitli sifre dogrulanirsa siteye giris yapilir


              e mail validation:   bosluk icermemeli
                                   @icermeli
                                   gmail.com,hotmail.com veya yahoo.com ile bitmeli
                                   mailin kullanici adi kisminda (@dan once) sadece kucuk buyuk harf rakam yada semboller olabilir

              password validation: bosluk icermemeli
                                  en az 6 karekter olmali
                                  en az bir kucuk harf icermeli
                                  en az bir buyuk harf icermeli
                                  en az bir rakam icermeli
                                  en az bir sembol icermeli


     */

    public static void main(String[] args) {
        start();






    }//main

    public static void start(){
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();


        int select = 0;
        do {
            userService.showMenu();
            select = scanner.nextInt();
            switch (select){
                case 1:
                    userService.register();
                    break;
                case 2:
                    userService.login();
                    break;
                case 3:
                    System.out.println("Iyi gunler dileriz");
                    break;
                default:
                    System.out.println("Hatali giris yaptiniz tekrar deneyiniz");
            }
        }while (select!=3);

    }


}//class


