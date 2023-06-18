package miniproject01.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    List<String > userNameList = new ArrayList<>();
    List<String > emailList = new ArrayList<>();
    List<String > passwordList = new ArrayList<>();





    public void showMenu(){
        System.out.println("=====WELCOME=====");
        System.out.println("1-Uye Ol");
        System.out.println("2-Giris Yap");
        System.out.println("3-Cikis Yap");
        System.out.println("Seciminiz: ");
    }

    public void register(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ad-Soyad");
        String name = scanner.nextLine();

        String userName;
        boolean existUsername;

        do {
            System.out.println("Kullanici adini giriniz");
            userName =scanner.nextLine();
            existUsername = userNameList.contains(userName);
            if (existUsername){
                System.out.println("Username daha once kullanilmistir .Yeni bir username deneyiniz");
            }

        }while (existUsername);


        String email;
        boolean isValid;
        boolean existEmail;

        do {
            System.out.println("Email Giriniz");
            email = scanner.nextLine().trim();
            isValid=validateEmail(email);
            existEmail = emailList.contains(email);
            if (existEmail){
                isValid=false;
                System.out.println("Bu email daha once kullanilmistir.Yeni bir email deneyiniz");
            }

        }while (!isValid);

        String password;
        boolean isValidPsw;
        do {
            System.out.println("Sifre giriniz");
            password = scanner.nextLine();
            isValidPsw=validatePassword(password);

        }while (!isValidPsw);


        User user = new User(name,userName,email,password);
        userNameList.add(userName);
        emailList.add(email);
        passwordList.add(password);

        System.out.println(user);
        System.out.println("Tebrikler kayit isleminiz gerceklesmistir");
        System.out.println("Kulllanici veya email ve sifre ile sisteme giris yapabilirsiniz");

    }



    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kullanici adi veya Email giriniz");
        String userNameOrEmail = scanner.nextLine();

        boolean isMail =emailList.contains(userNameOrEmail);
        boolean isUsername = userNameList.contains(userNameOrEmail);

        if (isMail||isUsername) {

            while (true) {
                System.out.println("Sifre giriniz");
                String password = scanner.nextLine();

                int idx;
                if (isUsername) {
                    idx = userNameList.indexOf(userNameOrEmail);
                } else {
                    idx = emailList.indexOf(userNameOrEmail);
                }

                if (passwordList.get(idx).equals(password)) {
                    System.out.println("Sisteme giris yaptiniz");
                } else {
                    System.out.println("Sifreniz yanlis tekrar deneyiniz");
                }
            }

        }else {
            System.out.println("Sisteme kayitli kullanici bulunamadi");
        }


    }











    public static boolean validateEmail(String email){
        boolean isValid;
        boolean space =email.contains(" ");
        boolean isContainAt =email.contains("@");

        if (space){
            System.out.println("Email bosluk iceremez");
            isValid=false;
        } else if (!isContainAt) {
            System.out.println("Email @ icermelidir");
            isValid=false;
        }else {
            String firstPart = email.split("@")[0];
            String secondPart = email.split("@")[1];

            boolean checkStart =firstPart.replaceAll("[a-zA-Z0-9_.-]","").length()==0;
            boolean checkEnd =secondPart.equals("gmail.com")||
                    secondPart.equals("hotmail.com")||
                    secondPart.equals("yahoo.com");
            if (!checkStart){
                System.out.println("Email kucuk harf buyuk harf rakam ve semboller disinda karekter iceremez");
            } else if (!checkEnd) {
                System.out.println("Email gmail.com,hotmail.com,yahoo.com ile bitmeli ");
            }
            isValid = checkStart&&checkEnd;
        }
        return isValid;
    }

    public static boolean validatePassword(String password){

        boolean isValid;
        boolean space =password.contains(" ");
        boolean lengthGt6 =password.length()>=6;
        boolean existUpper =password.replaceAll("[^A-Z]","").length()>0;
        boolean existLower =password.replaceAll("[^a-z]","").length()>0;
        boolean existDigit =password.replaceAll("[^0-9]","").length()>0;
        boolean existSymbol =password.replaceAll("[\\p{Punct}]","").length()>0;

        if (space){
            System.out.println("Sifre bosluk iceremez");
        } else if (!lengthGt6) {
            System.out.println("Sifre en az 6 karakter icermeledir");
        } else if (!existUpper) {
            System.out.println("Sifre en az 1 buyuk harf icermeledir");
        } else if (!existLower) {
            System.out.println("Sifre en az 1 kucuk harf icermelidir");
        } else if (!existDigit) {
            System.out.println("Sifre en az 1 rakam icermelidir");
        } else if (existSymbol) {
            System.out.println("Sifre en az 1 sembol icermelidir");
        }

        isValid = !space&&lengthGt6&&existLower&&existDigit&&existSymbol&&existUpper;
        if (!isValid){
            System.out.println("Tekrar deneyiniz");
        }
        return isValid;


    }





}//Class
    