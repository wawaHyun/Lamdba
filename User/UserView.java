
package User;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserView {
    public static void userMain(Scanner sc) throws SQLException {
        UserController ctrl = new UserController();
        ctrl.addUsers();
        System.out.println(ctrl.addUsers());
        while (true){
            System.out.println(" ");
            System.out.println("0-back main menu, 1-join(save), 2-login, 3-Long id search(findById), " +
                    "4-PW update, 5-member delete, 6-member list(findAll), 7-member total of number, " +
                    "8-NL name search(findUsersByName), 9-NL name search(findUsersByNameFromMap)," +
                    "10-job search(findUsersByJob), 11-job search(findUsersByJob), 12-getOne(String id)," +
                    "13-getUserMap, 14-Check membership registration(existsById), 15-test, 16-Repository");
            switch (sc.next()){
                case "0":
                    return;
                case "1" :
                    ctrl.save(); //join
                    break;
                case "2" :
                    System.out.println(ctrl.login(sc));
                    break;
                case "3" :
                    System.out.println(ctrl.findById(sc));
                    break;
                case "4" :
                    System.out.println(ctrl.updatePassword(sc));
                    break;
                case "5" :
                    System.out.println(ctrl.delete(sc));
                    break;
                case "6" :
                    ctrl.findAll().forEach(i-> System.out.println(i));
                    break;
                case "7" :
                    System.out.println("total of number is "+ctrl.count());
                    break;
                case "8" :
                    System.out.println(ctrl.findUsersByName(sc));
                    break;
                case "9":
                    System.out.println(ctrl.findUsersByNameFromMap(sc));
                    break;
                case "10" :
                    System.out.println(ctrl.findUsersByJob(sc));
                    break;
                case "11" :
//                    ctrl.findUsersByJobFromMap(sc).forEach(i-> System.out.println(i));
                    System.out.println(ctrl.findUsersByJobFromMap(sc));
                    break;
                case "12" :
                    System.out.println(ctrl.getOne(sc));
                    break;
                case "13" :
                    System.out.println(ctrl.getUserMap());
                    break;
                case "14" :
                    System.out.println(ctrl.existsById(sc));
                    break;
                case "15" :
                    System.out.println(ctrl.test());
                    break;
                case "16" :
                    ctrl.findUsers();
//                    System.out.println(ctrl.findUsers());
                    break;

            }
        }



    }
}