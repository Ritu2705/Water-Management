import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class WaterManagement {
    static int totalGuests = 0;

    public static void allotWater(int apartmentType,String ratio,int noOfGuests) {
        int allotedWaterConsumption = 0;
        if (apartmentType == 2) {
            allotedWaterConsumption = 3 * 10 *  30;
        }
        if (apartmentType == 3) {
            allotedWaterConsumption = 5 * 10 *  30;
        }

        int tankerWaterConsumption = addGuests(noOfGuests) * 10 * 30;
        String[] arrOfRatio = ratio.split(":",2);
        int ratioOfCorporationWater = Integer.parseInt(arrOfRatio[0]);
        int ratioOfBorewellWater = Integer.parseInt(arrOfRatio[1]);
        int totalProportion = ratioOfCorporationWater + ratioOfBorewellWater;
        int corporationWaterConsumption = (ratioOfCorporationWater * allotedWaterConsumption)/totalProportion;
        int borewellWaterConsumption = (ratioOfBorewellWater * allotedWaterConsumption)/totalProportion;
        int overallWaterConsumption = corporationWaterConsumption + borewellWaterConsumption + tankerWaterConsumption;
//        System.out.println(corporationWaterConsumption);
//        System.out.println(borewellWaterConsumption);
//        System.out.println(tankerWaterConsumption);
//        System.out.println();
        System.out.println(bill(corporationWaterConsumption,borewellWaterConsumption,tankerWaterConsumption,overallWaterConsumption));
    }


    public static int addGuests(int noOfGuests) {
        totalGuests = totalGuests + noOfGuests;
        return totalGuests;
    }

    public static int tankerWaterBill(int tankerConsumption) {
        int remaining = tankerConsumption;
        int tankerBill = 0;
        //HashMap<Integer,Integer> h = new HashMap<>();


            if (tankerConsumption < 500) {
                tankerBill = tankerBill + (tankerConsumption * 2);
                return tankerBill;
            }
            else {
                tankerBill = tankerBill + (500 * 2);
            }
            remaining = remaining - 500;

            if(remaining != 0) {
                if (remaining < 1000) {
                    tankerBill = tankerBill + (remaining * 3);
                    return tankerBill;
                }
                else {
                    tankerBill = tankerBill + (1000 * 3);
                }
            }
            else {
                return tankerBill;
            }
            remaining = remaining - 1000;

            if (remaining != 0 ) {
                if (remaining < 1500) {
                    tankerBill = tankerBill + (remaining * 5);
                    return tankerBill;
                }
                else {
                    tankerBill = tankerBill + (1500 * 5);
                }
            }
            else {
                return tankerBill;
            }
            remaining = remaining - 1500;

            if (remaining != 0 ) {
                tankerBill = tankerBill + (remaining * 8);
                return tankerBill;
            }
            else {
                return tankerBill;
            }

    }

    public static String bill(long corporationWaterConsumption,long borewellWaterConsumption,int tankerWaterConsumption,
                           int overallWaterConsumption) {
        double totalBill = 0;
        totalBill = (1 * corporationWaterConsumption) + (1.5 * borewellWaterConsumption) + tankerWaterBill(tankerWaterConsumption);
        String bill = overallWaterConsumption + " " + String.valueOf((int)Math.floor(totalBill));
        return bill;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfGuests = 0;
        //List<String> allotWater = new ArrayList<>();
        System.out.println("Enter Apartment Type and Ratio");
        int apartmentType = sc.nextInt();
        String ratio = sc.next();
        System.out.println("Add guests?(yes/no)");
        while (sc.next().equals("yes")) {
            noOfGuests = noOfGuests + sc.nextInt();
            System.out.println("Add guests?(yes/no)");
        }

        System.out.print("Show Bill. Press Enter");
        sc.nextLine();
        if(sc.nextLine().equals("")) {
            allotWater(apartmentType,ratio,noOfGuests);
        }

        //allotWater(apartmentType,ratio,noOfGuests);
        //System.out.println(tankerWaterBill(2000));
        //System.out.println(bill());
    }
}
