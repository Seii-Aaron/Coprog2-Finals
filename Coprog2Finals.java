package Coprog2;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.time.*;

/*

 * Hi serrr
 * nag cram lang po ako sa paggawa nito HAHAHA
 * rineuse ko lang po old code ko, medyo spaghetti code na po yung mga bagong functions na nilagay ko
 * at hindi ko na ginawang try-catch yung lumang error-handling na ginamit ko (nested if-then statements) (nagana naman HAHAHA)
 * 
 * Salamat po ulet sa pagtuturo samin!!!
 * Goodluck po sa industry/work niyo!!
 * 
 */

public class Coprog2Finals {
    static Scanner scan = new Scanner(System.in);

    public static void partition (){
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void brandName(){
        partition();
        System.out.println("\t\t\t\t\t   Animo Apparels");
    }

    public static boolean isNumber(String userInput){
        Pattern numberPattern = Pattern.compile("^[0-9]+");
        Matcher isNumberMatcher = numberPattern.matcher(userInput.trim());
        boolean isNumber = isNumberMatcher.matches();
        return isNumber;
    }

    public static boolean emailValidation (String userEmail, String userEmailPassword, ArrayList<String> userName, ArrayList<String>userPassword){
        boolean userEmailValidity = false;
        for (int i = 0; i<userName.size(); i++){
            if (userEmail.equals(userName.get(i)) && userEmailPassword.equals(userPassword.get(i))){
                userEmailValidity =  true;
            }
        }
        return userEmailValidity;
    }

    public static boolean userNameValidation(String userInput){
        Pattern studentEmailPattern = Pattern.compile("^[a-z]+(_[a-z]+)?_[a-z]+@dlsl\\.edu\\.ph$");
        Pattern teacherEmailPattern = Pattern.compile("^[a-z]+(\\.[a-z]+)?\\.[a-z]+@dlsl\\.edu\\.ph$");
        Matcher userNameMatcher = studentEmailPattern.matcher(userInput);
        Matcher userNameMatcher2 = teacherEmailPattern.matcher(userInput);
        if (userNameMatcher.matches() || userNameMatcher2.matches()){
            return true;
        } else {
            return false;
        }
    }

    public static boolean userPasswordValidation(String userInput){
        Pattern userPasswordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$");
        Matcher userPasswordMatcher = userPasswordPattern.matcher(userInput);
        if (userPasswordMatcher.matches()){
            return true;
        } else {
            return false;
        }
    }

    public static void signUp(boolean hasLoggedIn, String userEmail, ArrayList<String> userName, ArrayList<String> userPassword){
        partition();
        System.out.println("\t\t\t\t\t   Sign-up Screen");
        partition();
        System.out.println("Welcome to Animo Apparels!");
        System.out.println("Kindly sign up your account to access the store.");
        while (true){
            partition();
            System.out.println("Please enter your De La Salle Lipa email that will serve as your username.");
            System.out.println("Kindly create a new password as well for your account.");
            partition();
            System.out.print("DLSL Email: ");
            String newUserName = scan.nextLine();
            if (userNameValidation(newUserName)){
                userName.add(newUserName);
                break;
            } else {
                partition();
                System.out.println("Please enter your correct De La Salle Lipa email.");
            }
        }
        while (true){
            System.out.print("New Password: ");
            String newPassword = scan.nextLine();
            if (userPasswordValidation(newPassword)){
                userPassword.add(newPassword);
                partition();
                System.out.println("Sign up successful!");
                System.out.println("Kindly proceed to the log-in page to access the store.");
                System.out.print("Press enter to continue. ");
                scan.nextLine();
                break;
            } else {
                partition();
                System.out.println("Password must be 8-20 characters long, has a number, has an uppercase letter");
                System.out.println("Password must not contain any special characters.");
            }
        }
    }

    public static void logIn(boolean hasLoggedIn, String userEmail, String userEmailPassword, ArrayList<String> userName, ArrayList<String> userPassword){
        partition();
        System.out.println("\t\t\t\t\t   Log-In Screen");
        partition();
        System.out.println("Welcome to Animo Apparels!");
        System.out.println("Please login to verify your identity.");
        while (!hasLoggedIn){                
            partition();
            System.out.println("Please enter your De La Salle Lipa email address and password.");
            System.out.print("DLSL Email Adress: ");
            userEmail = scan.nextLine();
            System.out.print("Password: ");
            userEmailPassword = scan.nextLine();
            partition();

            boolean isUserEmailValid = emailValidation(userEmail, userEmailPassword, userName, userPassword);
            if (isUserEmailValid){
                System.out.println("Successful Login!");
                System.out.println("Press enter to continue.");
                scan.nextLine();
                clearScreen();
                break;
            } else {
                System.out.println("Unsuccessful Login!");
                System.out.println("Please type in your correct DLSL email address and password.");
            }
        }
    }

    public static void displayMenu(){
        brandName();
        partition();
        System.out.println(" Welcome to Animo Apparels!");
        System.out.println(" To start, what would you like to do?");
        System.out.println("   1. Shop Items");
        System.out.println("   2. View Cart");
        System.out.println("   3. Edit Cart");
        System.out.println("   4. Clear Cart");
        System.out.println("   5. Learn More about Animo Apparels");
        System.out.println("   6. Proceed to checkout");
        System.out.println("   7. Log out");
    }

    public static char userInputMenuNumber(){
        char userMenuNumber = (' ');
        while (true) {
            partition();
            System.out.println("Please type ONLY the number corresponding to what you want to do.");
            System.out.print("Answer (1 - 7): ");
            String userMenuAnswer = scan.nextLine().trim();

            if (userMenuAnswer.length() == 1){
                userMenuNumber = userMenuAnswer.charAt(0);
                boolean userMenuNumberAnswer = Character.isDigit(userMenuNumber);
                if (userMenuNumberAnswer){
                    break;
                } else {
                    clearScreen();
                    displayMenu();
                    partition();
                    System.out.println("User input error.");
                }
            } else {
                clearScreen();
                displayMenu();
                partition();
                System.out.println("User input error.");
            }
        }
        return userMenuNumber;
    }

    public static void addNewItems(String product, int quantity, double price, ArrayList<String> itemsAvailable, ArrayList<Integer> itemsQuantity, ArrayList<Double> itemsPrice){
        itemsAvailable.add(product);
        itemsQuantity.add(quantity);
        itemsPrice.add(price);
    } 

    public static void shopItems(ArrayList<String> itemsAvailable, ArrayList<Integer> itemsQuantity, ArrayList<Double> itemsPrice, ArrayList<String> itemsBought, ArrayList<Integer> itemsBoughtQuantity, ArrayList<Double> itemsBoughtPrice){
        while (true){
            clearScreen();
            brandName();
            partition();
            System.out.println(" Code\tProduct Name\t\tItem Price\t\tAvailable Stock");
            for (int i = 0; i<itemsAvailable.size(); i++){
                System.out.print("  ");
                System.out.printf(i+1 + "\t %s\t\t P%.0f\t\t\t %d\n", itemsAvailable.get(i), itemsPrice.get(i), itemsQuantity.get(i));
            }
            partition();
            System.out.println("Type in the 'Code' of the item you want to buy.");
            System.out.println("Type 'exit' if you want to go back to the menu.");
            partition();
            System.out.println("What would you like to buy?");
            System.out.print("Answer: ");
            String buyItem = scan.nextLine();
            if (buyItem.trim().equalsIgnoreCase("exit")){
                break;
            }
            partition();

            if (isNumber(buyItem)){
                int buyItemIndex = Integer.parseInt(buyItem.trim());
                if (buyItemIndex>itemsAvailable.size()){
                    System.out.println("Transaction error.");
                    System.out.printf("Please type ONLY the item's code from 1 - %d\n", itemsAvailable.size());
                    System.out.print("Press enter to go back to the shop item menu. ");
                    scan.nextLine();
                } else if (buyItemIndex == 0){
                    System.out.println("Transaction error.");
                    System.out.printf("Please type ONLY the item's code from 1 - %d\n", itemsAvailable.size());
                    System.out.print("Press enter to go back to the shop item menu. ");
                    scan.nextLine();
                } else if (itemsQuantity.get(buyItemIndex-1) == 0){
                    System.out.printf("Sorry! Our '%s' is out of stock. \n", itemsAvailable.get(buyItemIndex-1));
                    System.out.println("Please select other items in the shop or type 'exit' to go back to the menu.");
                    partition();
                    System.out.println("Press enter to go back to the shop items menu.");
                    scan.nextLine();
                } else if (itemsQuantity.get(buyItemIndex-1) > 0) {
                    System.out.printf("Item:\n%s - P%.0f\n", itemsAvailable.get(buyItemIndex-1), itemsPrice.get(buyItemIndex-1));
                    partition();
                    System.out.println("How many would you like to buy?");
                    System.out.print("Quantity: ");
                    String buyItemQuantity = scan.nextLine();
                    if (isNumber(buyItemQuantity)){
                        int buyQuantity = Integer.parseInt(buyItemQuantity.trim());
                        if (buyQuantity <= itemsQuantity.get(buyItemIndex-1) && buyQuantity != 0){
                            partition();
                            System.out.printf("Are you sure you want to add this to your cart?: \n%d pc/s of %s for P%.0f\n", buyQuantity, itemsAvailable.get(buyItemIndex-1), itemsPrice.get(buyItemIndex-1)*buyQuantity);
                            partition();
                            System.out.print("Answer [yes/no]: ");
                            String buyItemConfirmation = scan.nextLine();
                            partition();
                            if (buyItemConfirmation.trim().equalsIgnoreCase("yes")){
                                itemsBought.add(itemsAvailable.get(buyItemIndex-1));
                                itemsBoughtQuantity.add(buyQuantity);
                                itemsBoughtPrice.add(itemsPrice.get(buyItemIndex-1));
                                itemsQuantity.set(buyItemIndex-1, itemsQuantity.get(buyItemIndex-1)-buyQuantity);
                                System.out.println("Item/s added to cart!");
                                System.out.println("Press enter to go back to the menu. ");
                                scan.nextLine();
                                break;
                            } else if (buyItemConfirmation.trim().equalsIgnoreCase("no")){
                                System.out.println("Transaction cancelled.");
                                System.out.println("Press enter to go back to the menu. ");
                                scan.nextLine();
                                break;
                            } else {
                                System.out.println("Transaction error.");
                                System.out.println("Please type ONLY 'yes' or 'no' next time.");
                                System.out.println("Press enter to go back to the shop items menu. ");
                                scan.nextLine();
                            }
                        } else if (buyQuantity > itemsQuantity.get(buyItemIndex-1)) {
                            partition();
                            System.out.println("Transaction error.");
                            System.out.printf("There are only %d in stock. \n", itemsQuantity.get(buyItemIndex-1));
                            System.out.println("You cannot buy more than that.");
                            partition();
                            System.out.println("Press enter to go back to the shop items menu. ");
                            scan.nextLine();
                        } else {
                            partition();
                            System.out.println("Transaction error.");
                            System.out.println("Please type ONLY the quantity you want to buy. (ex. 1, 4, 5, etc.)");
                            System.out.print("Press enter to go back to the shop item menu. ");
                            scan.nextLine();
                            partition();
                        }
                    } else {
                        partition();
                        System.out.println("Transaction error.");
                        System.out.println("Please type ONLY the quantity you want to buy. (ex. 1, 4, 5, etc.)");
                        System.out.print("Press enter to go back to the shop item menu. ");
                        scan.nextLine();
                        partition();
                    }
                } else {
                    System.out.println("Transaction error.");
                    System.out.println("Please type ONLY the 'Code' of the item or 'exit' if you want to go back to the menu.");
                    System.out.print("Press enter to re-type your answer. ");
                    scan.nextLine();
                    partition();
                }
            } else {
                System.out.println("Transaction error.");
                System.out.println("Please type ONLY the 'Code' of the item or 'exit' if you want to go back to the menu.");
                System.out.print("Press enter to re-type your answer. ");
                scan.nextLine();
                partition();
            }
        }
    }

    public static void receipt(ArrayList<String> itemsAvailable, ArrayList<Integer> itemsQuantity, ArrayList<Double> itemsPrice, ArrayList<String> itemsBought, ArrayList<Integer> itemsBoughtQuantity, ArrayList<Double> itemsBoughtPrice, File file, ArrayList<String> userName, Double grandTotal, Double payment, Double change){
        String partition = "-----------------------------------------------------------------------";
        LocalDateTime dateTime = LocalDateTime.now();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt", true))){
            writer.write("Start of Transaction.\n");
            writer.write(partition);
            writer.write("\n\t\t\t\t\t        Animo Apparels");
            writer.write("\n\t\t\t\t\t      " + userName);
            writer.write("\n\t\t\t\t\t" + dateTime + "\n");
            writer.write(partition);
            writer.write("\nQty\t\tItem\t\t\t\tPrice\t\t\tTotal Price\n");
            for (int i = 0; i<itemsBought.size(); i++){
                String receiptItemsFormatted = String.format(" %d\t\t%s\t\t P%.0f\t\t\t P%.0f\n", itemsBoughtQuantity.get(i), itemsBought.get(i), itemsBoughtPrice.get(i), itemsBoughtPrice.get(i)*itemsBoughtQuantity.get(i));
                grandTotal = itemsBoughtPrice.get(i)*itemsBoughtQuantity.get(i);
                writer.write(receiptItemsFormatted);
            }
            writer.write(partition);
            writer.write("\nGrand Total: P" + grandTotal);
            writer.write("\nPayment: " + payment);
            writer.write("\nChange: P" + change);
            writer.write("\n");
            writer.write(partition);
            writer.write("\nEnd of Transaction.");
            writer.write("\n\n\n\n");
        } catch (Exception e) {
            System.out.println("Failed to write to the transactions.txt file.");
            e.printStackTrace();
        }
    }

    public static void viewCart(ArrayList<String> itemsAvailable, ArrayList<Integer> itemsQuantity, ArrayList<Double> itemsPrice, ArrayList<String> itemsBought, ArrayList<Integer> itemsBoughtQuantity, ArrayList<Double> itemsBoughtPrice){
        brandName();
        partition();
        double grandTotal = 0;
        System.out.println(" Quantity\tProduct Name\t\tItem Price\t\tTotal Price");
        for (int i = 0; i<itemsBought.size(); i++){
            System.out.print("  ");
            System.out.printf(" %d\t\t%s\t\t P%.0f\t\t\t P%.0f\n", itemsBoughtQuantity.get(i), itemsBought.get(i), itemsBoughtPrice.get(i), itemsBoughtPrice.get(i)*itemsBoughtQuantity.get(i));
            grandTotal += itemsBoughtPrice.get(i)*itemsBoughtQuantity.get(i);
        }
        System.out.println(" \nGrand Total: P" + grandTotal);
        partition();
        System.out.println("Press enter to go back to the menu. ");
        scan.nextLine();
    }

    public static void editCart(ArrayList<String> itemsAvailable, ArrayList<Integer> itemsQuantity, ArrayList<Double> itemsPrice, ArrayList<String> itemsBought, ArrayList<Integer> itemsBoughtQuantity, ArrayList<Double> itemsBoughtPrice){
        brandName();
        partition();
        double grandTotal = 0;
        System.out.println(" Code\tQuantity\tProduct Name\t\tItem Price\t\tTotal Price");
        int x = 1;
        for (int i = 0; i<itemsBought.size(); i++){
            System.out.print("  ");
            System.out.printf(" " + x + "\t %d\t\t %s\t\t P%.0f\t\t\t P%.0f\n", itemsBoughtQuantity.get(i), itemsBought.get(i), itemsBoughtPrice.get(i), itemsBoughtPrice.get(i)*itemsBoughtQuantity.get(i));
            grandTotal += itemsBoughtPrice.get(i)*itemsBoughtQuantity.get(i);
            x++;
        }
        System.out.println(" \nGrand Total: P" + grandTotal);
        partition();
        boolean editCartStatus = true;
        if (itemsBought.size() == 0){
            editCartStatus = false;
            System.out.println("Your cart is empty.");
            System.out.println("No items to edit.");
            System.out.println("Press enter to go back to the menu.");
            scan.nextLine();
        }

        while (editCartStatus) {
            System.out.println("What do you want to do?");
            System.out.println(" 1. Update quantity of an item");
            System.out.println(" 2. Remove an Item");
            System.out.println(" 3. Exit to menu");
            partition();
            System.out.print("Answer: ");
            int answer = 0;
            try {
                answer = scan.nextInt();
            } catch (Exception e) {
                
            } finally {
                if (answer == 1){
                    scan.nextLine();
                    partition();
                    System.out.println("What item do you want to update the quantity of?");
                    System.out.println("Type 'exit' if you want to go back to the menu.");
                    System.out.println("Type ONLY the code of the item.");
                    System.out.print("Answer: ");
                    String answer22 = scan.nextLine();
                    if (answer22.equalsIgnoreCase("exit")){
                        editCartStatus = false;
                        break;
                    }

                    int answer2 = 0;
                    try {
                        answer2 = Integer.parseInt(answer22);
                    } catch (Exception e) {
                        
                    } finally {

                        if (answer2 <= itemsBought.size() && answer2 !=0){
                            String itemToUpdate = itemsBought.get(answer2-1);
                            int index2 = itemsAvailable.indexOf(itemToUpdate);
                            partition();
                            System.out.printf("Are you sure you want to update the quantity of Code %d, %s?\n", answer2, itemsBought.get(answer2-1));
                            System.out.print("Answer [yes/no]: ");
                            String answer5 = scan.nextLine();
                            if (answer5.equalsIgnoreCase("yes")){
                                partition();
                                System.out.printf("There are %d stocks left of this item including the ones in your cart.\n", itemsQuantity.get(index2) + itemsBoughtQuantity.get(answer2-1));
                                System.out.println("Please choose a quantity within that range.");
                                System.out.println("Type 'exit' if you want to go back to the menu.");
                                System.out.println("What new quantity would you like replace it with?");
                                System.out.print("Answer: ");
                                String answer66 = scan.nextLine();
                                if (answer66.equalsIgnoreCase("exit")) {
                                    editCartStatus = false;
                                    break;
                                }

                                int answer6 = 0;
                                try {
                                    answer6 = Integer.parseInt(answer66);
                                } catch (Exception e) {
                                    
                                } finally {
                                    if (answer6 <= itemsQuantity.get(index2) + itemsBoughtQuantity.get(answer2-1)){
                                        itemsQuantity.set(index2, itemsQuantity.get(index2) + itemsBoughtQuantity.get(answer2-1));
                                        itemsBoughtQuantity.set(answer2-1, answer6);
                                        itemsQuantity.set(index2, itemsQuantity.get(index2) - itemsBoughtQuantity.get(answer2-1));

                                        if (answer6 == 0){
                                            itemsBoughtQuantity.remove(answer2-1);
                                            itemsBought.remove(answer2-1);
                                            itemsBoughtPrice.remove(answer2-1);
                                        }
                                    } else {
                                        System.out.println("Please input a correct quantity next time within the range of stocks left.");
                                        System.out.println("Press enter to go back to the menu.");
                                        scan.nextLine();
                                        editCartStatus = false;
                                        break;
                                    }
                                }
                            } else {
                                partition();
                                System.out.println("Please type ONLY 'yes' or no' next time.");
                                System.out.println("Updating of item quantity cancelled.");
                                System.out.println("Press enter to go back to the menu.");
                                scan.nextLine();
                                editCartStatus = false;
                                break;
                            }
                        } else {
                            partition();
                            System.out.println("Invalid item code.");
                            System.out.println("Editing cart cancelled.");
                            System.out.println("Press enter to go back to the menu.");
                            scan.nextLine();
                            editCartStatus = false;
                            break;
                        }
                    }
                    partition();
                    System.out.println("Cart updated.");
                    partition();
                    System.out.println("Press enter to go back to the menu.");
                    scan.nextLine();
                    editCartStatus = false;
                } else if (answer == 2){
                    scan.nextLine();
                    while (true){
                        partition();
                        System.out.println("What item do you want to remove from your cart?");
                        System.out.println("Type 'exit' if you want to go back to the menu.");
                        System.out.println("Type ONLY the code of the item.");
                        System.out.print("Answer: ");
                        String answer33 = scan.nextLine();
                        if (answer33.equalsIgnoreCase("exit")){
                            editCartStatus=false;
                            break;
                        }

                        int answer3 = 0;
                        try {
                            answer3 = Integer.parseInt(answer33);
                        } catch (Exception e) {
                            
                        } finally {
                            if (answer3 <= itemsBought.size() && answer3 != 0){
                                partition();
                                System.out.printf("Are you sure you want to remove the orders of Code %d, %s?\n", answer3, itemsBought.get(answer3-1));
                                System.out.print("Answer [yes/no]: ");
                                String answer4 = scan.nextLine();
                                if (answer4.equalsIgnoreCase("yes")){
                                    String itemToRemove = itemsBought.get(answer3-1);
                                    int index = itemsAvailable.indexOf(itemToRemove);
                                    itemsQuantity.set(index, itemsBoughtQuantity.get(answer3-1) + itemsQuantity.get(index));
                                    itemsBought.remove(answer3-1);
                                    itemsBoughtPrice.remove(answer3-1);
                                    itemsBoughtQuantity.remove(answer3-1);
                                    partition();
                                    System.out.println("Item removed from cart.");
                                    System.out.println("Press enter to go back to the menu.");
                                    scan.nextLine();
                                    editCartStatus = false;
                                    break;
                                } else {
                                    partition();
                                    System.out.println("Please type ONLY 'yes' or no' next time.");
                                    System.out.println("Removal of item cancelled.");
                                    System.out.println("Press enter to go back to the menu.");
                                    scan.nextLine();
                                    editCartStatus = false;
                                    break;
                                }
                            }
                            partition();
                            System.out.println("Type ONLY the code of the item you want to remove.");
                            System.out.println("Press enter to re-type your answer.");
                            scan.nextLine();
                        }
                    }
                } else if (answer == 3){
                    scan.nextLine();
                    break;
                } else {
                    partition();
                    System.out.println("Please input ONLY '1', '2', or '3'.");
                    System.out.println("Press enter to re-type your answer.");
                    scan.nextLine();
                    partition();
                }
            }
        }
    }

    public static void clearCart(ArrayList<String> itemsAvailable, ArrayList<Integer> itemsQuantity, ArrayList<Double> itemsPrice, ArrayList<String> itemsBought, ArrayList<Integer> itemsBoughtQuantity, ArrayList<Double> itemsBoughtPrice){
        brandName();
        partition();
        double grandTotal = 0;
        System.out.println(" Quantity\tProduct Name\t\tItem Price\t\tTotal Price");
        for (int i = 0; i<itemsBought.size(); i++){
            System.out.print("  ");
            System.out.printf(" %d\t\t%s\t\t P%.0f\t\t\t P%.0f\n", itemsBoughtQuantity.get(i), itemsBought.get(i), itemsBoughtPrice.get(i), itemsBoughtPrice.get(i)*itemsBoughtQuantity.get(i));
            grandTotal += itemsBoughtPrice.get(i)*itemsBoughtQuantity.get(i);
        }
        System.out.println(" \nGrand Total: " + grandTotal);
        while (true){
            partition();
            System.out.println("Are you sure you want to remove all the items in your cart?");
            System.out.print("Answer [yes/no]: ");
            String clearCartConfirmation = scan.nextLine();
            if (clearCartConfirmation.trim().equalsIgnoreCase("yes")){
                if (itemsBought.size() == 0){
                    partition();
                    System.out.println("There is nothing to remove in your cart.");
                    System.out.print("Press enter to go back to the menu. ");
                    scan.nextLine();
                    break;
                }

                for (int i = 0; i<itemsBought.size(); i++){
                    String x = itemsBought.get(i);
                    for (int j = 0; j<itemsAvailable.size(); j++){
                        if (x.equals(itemsAvailable.get(j))){
                            int y = itemsAvailable.indexOf(itemsAvailable.get(j));
                            itemsQuantity.set(y, itemsBoughtQuantity.get(i) + itemsQuantity.get(y));
                        }
                    }
                }
                itemsBought.clear();
                itemsBoughtPrice.clear();
                itemsBoughtQuantity.clear();
                partition();
                System.out.println("All items removed from cart.");
                System.out.println("Press enter to go back to the menu. ");
                // System.out.println(itemsAvailable);
                // System.out.println(itemsPrice);
                // System.out.println(itemsQuantity);
                // System.out.println(itemsBought);
                // System.out.println(itemsBoughtPrice);
                // System.out.println(itemsBoughtQuantity);
                scan.nextLine();
                break;
            } else if (clearCartConfirmation.trim().equalsIgnoreCase("no")){
                partition();
                System.out.println("No items removed from cart.");
                System.out.print("Press enter to go back to the menu. ");
                scan.nextLine();
                break;
            } else {
                partition();
                System.out.println("Confirmation error.");
                System.out.println("Please type ONLY 'yes' or 'no'.");
                System.out.print("Press enter to redo your answer. ");
                scan.nextLine();
            }
        }
    }
    
    public static void learnMore(){
        brandName();
        partition();
        System.out.println(" About");
        System.out.println("  Welcome to Animo Apparels!");
        System.out.println("  We are a brand dedicated to showcase the Lasallian culture and fashion!");
        System.out.println("  Founded in 2000, our brand has offered our services to the Lasallian community for 25 years!");
        partition();
        System.out.println(" Goals and Commitments");
        System.out.println("  Aside from the services and products we offer, we are also dedicated to giving back to the community.");
        System.out.println("  Thus, we are committed to giving 10% of our profits to a charity each year!");
        partition();
        System.out.println("  So what are you waiting for?");
        System.out.println("  Come and buy from Animo Apparels!");
        partition();
        System.out.print(" Press enter to go back to the menu. ");
        scan.nextLine();
    }

    public static void checkoutItems(ArrayList<String> itemsAvailable, ArrayList<Integer> itemsQuantity, ArrayList<Double> itemsPrice, ArrayList<String> itemsBought, ArrayList<Integer> itemsBoughtQuantity, ArrayList<Double> itemsBoughtPrice, File file, ArrayList<String> userName){
        brandName();
        partition();
        double grandTotal = 0;
        System.out.println(" Quantity\tProduct Name\t\tItem Price\t\tTotal Price");
        for (int i = 0; i<itemsBought.size(); i++){
            System.out.print("  ");
            System.out.printf(" %d\t\t%s\t\t P%.0f\t\t\t P%.0f\n", itemsBoughtQuantity.get(i), itemsBought.get(i), itemsBoughtPrice.get(i), itemsBoughtPrice.get(i)*itemsBoughtQuantity.get(i));
            grandTotal += itemsBoughtPrice.get(i)*itemsBoughtQuantity.get(i);
        }
        while (true) {
            System.out.println(" Grand Total: " + grandTotal);
            partition();
            System.out.print("Please input your payment or type 'exit' if you want to cancel your transaction.\n");
            System.out.println("Your grand total is P" + grandTotal);
            System.out.print("Answer: ");
            String userPayment = scan.nextLine();
            
            if (isNumber(userPayment)){
                double payment = Double.parseDouble(userPayment.trim());
                if (payment >= grandTotal){
                    double change = payment - grandTotal;
                    partition();
                    System.out.println("Transaction completed.");
                    System.out.println("Grand Total: P" + grandTotal);
                    System.out.println("Payment: " + payment);
                    System.out.printf("Change: P%.2f \n", change);
                    partition();

                    while (true) {
                        System.out.println("Do you want a receipt?");
                        System.out.print("[yes/no]: ");
                        String receiptConfirmation = scan.nextLine();
                        if (receiptConfirmation.trim().equalsIgnoreCase("yes")){
                            partition();
                            receipt(itemsAvailable, itemsQuantity, itemsPrice, itemsBought, itemsBoughtQuantity, itemsBoughtPrice, file, userName, grandTotal, payment, change);
                            System.out.println("Receipt printed.");
                            partition();
                            break;
                        } else if (receiptConfirmation.trim().equalsIgnoreCase("no")){
                            partition();
                            System.out.println("No receipt printed.");
                            partition();
                            break;
                        } else {
                            System.out.println("Please answer 'yes' or 'no' ONLY.");
                            System.out.println("Press enter to re-type your answer.");
                            scan.nextLine();
                        }
                    }

                    
                    System.out.println("Do you want to do another transaction?");
                    System.out.print("[yes/no]: ");
                    String anotherTransaction = scan.nextLine();
                    if (anotherTransaction.trim().equalsIgnoreCase("yes")){
                        itemsBought.clear();
                        itemsBoughtQuantity.clear();
                        itemsBoughtPrice.clear();
                        break;
                    } else if (anotherTransaction.trim().equalsIgnoreCase("no")){
                        exitRegister();
                    } else {
                        partition();
                        System.out.println("Confirmation error.");
                        System.out.print("Press enter to go back to the menu. ");
                        scan.nextLine();
                        break;
                    }
                } else if (payment < grandTotal){
                    partition();
                    System.out.println("Payment NOT enough.");
                    System.out.println("Do you want to re-enter your payement?");
                    System.out.print("[yes/no]: ");
                    String redoPayment = scan.nextLine();
                    if (redoPayment.trim().equalsIgnoreCase("yes")){
                        partition();
                    } else if (redoPayment.trim().equalsIgnoreCase("no")){
                        partition();
                        System.out.println("Transaction cancelled.");
                        System.out.println("Press enter to go back to the menu.");
                        scan.nextLine();
                        break;
                    } else {
                        partition();
                        System.out.println("Confirmation error.");
                        System.out.println("Transaction cancelled.");
                        System.out.print("Press enter to go back to the menu. ");
                        scan.nextLine();
                        break;
                    }
                }
            } else if (userPayment.trim().equalsIgnoreCase("exit")) {
                partition();
                System.out.println("Transaction/payment cancelled.");
                System.out.print("Press enter to go back to the menu.");
                scan.nextLine();
                break;
            } else {
                partition();
                System.out.println("Transaction error.");
                System.out.println("Please type 'exit' if you want to cancel your transaction and go back to the menu.");
                System.out.println("Please input ONLY the amount you want to pay in pesos. (ex. 100, 199, etc.)");
                System.out.print("Press enter to retype your payment or answer. ");
                scan.nextLine();
                partition();
            }
        }
    }
    
    public static void exitRegister(){
        brandName();
        partition();
        System.out.println(" Thank you so much for shopping in Animo Apparels!");
        System.out.println(" We hope to see you again!");
        System.out.println(" Animo La Salle!");
        partition();
        scan.nextLine();
        System.exit(0);
    }


    public static void main(String[] args) {
        ArrayList<String> userName = new ArrayList<>();
        ArrayList<String> userPassword = new ArrayList<>();
        ArrayList<String> itemsAvailable = new ArrayList<>();
        ArrayList<Integer> itemsQuantity = new ArrayList<>();
        ArrayList<Double> itemsPrice = new ArrayList<>();
        addNewItems("Animo Hoodie", 15, 1499, itemsAvailable, itemsQuantity, itemsPrice);
        addNewItems("Animo T-Shirt", 20, 699, itemsAvailable, itemsQuantity, itemsPrice);
        addNewItems("Animo Headcap", 25, 499, itemsAvailable, itemsQuantity, itemsPrice);
        addNewItems("Animo ID Lace", 40, 149, itemsAvailable, itemsQuantity, itemsPrice);
        addNewItems("Animo Bracelet", 50, 99, itemsAvailable, itemsQuantity, itemsPrice);
        addNewItems("Animo Keychain", 60, 79, itemsAvailable, itemsQuantity, itemsPrice);
        ArrayList<String> itemsBought = new ArrayList<>();
        ArrayList<Integer> itemsBoughtQuantity = new ArrayList<>();
        ArrayList<Double> itemsBoughtPrice = new ArrayList<>();
        String userEmail = "";
        String userEmailPassword = "";
        boolean hasLoggedIn = false;
        File file = null;
        brandName();
        
        while (true){
            partition();
            System.out.println("Welcome to Animo Apparels!");
            System.out.println("To start, would you like to sign up a new account or log in to an existing account?");
            System.out.println("1. Sign Up");
            System.out.println("2. Log in");
            partition();
            System.out.print("Answer: ");
            String logInOrSignUp = scan.nextLine();
            if (isNumber(logInOrSignUp.trim())){
                int logOrSign = Integer.parseInt(logInOrSignUp.trim());
                if (logOrSign == 1){
                    signUp(hasLoggedIn, userEmail, userName, userPassword);
                } else if (logOrSign == 2){
                    logIn(hasLoggedIn, userEmail, userEmailPassword, userName, userPassword);;
                    break;
                } else {
                    System.out.println("Please type ONLY '1' to sign up or '2' to log in. ");
                    System.out.print("Press enter to continue. ");
                    scan.nextLine();
                }
            } else {
                System.out.println("Please type ONLY '1' to sign up or '2' to log in. ");
                System.out.print("Press enter to continue. ");
                scan.nextLine();
            }
            clearScreen();
        }

        partition();
        while (true){
            clearScreen();
            displayMenu();
            char menuStatus = userInputMenuNumber();
            if (menuStatus == '1') {
                clearScreen();
                shopItems(itemsAvailable, itemsQuantity, itemsPrice, itemsBought, itemsBoughtQuantity, itemsBoughtPrice);

            } else if (menuStatus == '2') {
                clearScreen();
                viewCart(itemsAvailable, itemsQuantity, itemsPrice, itemsBought, itemsBoughtQuantity, itemsBoughtPrice);

            } else if (menuStatus == '3'){
                clearScreen();
                editCart(itemsAvailable, itemsQuantity, itemsPrice, itemsBought, itemsBoughtQuantity, itemsBoughtPrice);
                
            } else if(menuStatus == '4') {
                clearScreen();
                clearCart(itemsAvailable, itemsQuantity, itemsPrice, itemsBought, itemsBoughtQuantity, itemsBoughtPrice);

            } else if (menuStatus == '5') {
                clearScreen();
                learnMore();

            } else if (menuStatus == '6') {
                clearScreen();
                checkoutItems(itemsAvailable, itemsQuantity, itemsPrice, itemsBought, itemsBoughtQuantity, itemsBoughtPrice, file, userName);

            } else if (menuStatus == '7') {
                clearScreen();
                exitRegister();

            } else {
                System.out.println("Error. Error. Error.");
            }
        }
    }
}
