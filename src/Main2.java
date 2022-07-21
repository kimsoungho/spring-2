class Taxi {
    //  필드
    int aTaxiNumber;
    int maxPassengerNumber = 4; // 최대 승객수
    int currentPassengerNumber = 0; // 현재 승객수
    int aTaxiNumber2;//택시번호
    int gasLeft = 100; //주유량
    int basicDistance = 1; //기본거리
    int distanceToDestination; //목적지까지 거리
    String Location;
    int basicFare = 3000; //기본 요금
    int farForDistance = 1000; //거리당 요금

    String drivable = "운행중"; // 상태
    int mon=0;//누적 요금

    Taxi(int gasLeft) {
        this.aTaxiNumber = (int) (Math.random() * 10 + 1);
        this.aTaxiNumber2 = (int) (Math.random() * 10 + 1);
        System.out.println("taxi- " + aTaxiNumber);
        System.out.println("taxi- " + aTaxiNumber2);
        isDrivable(0);
    }
    boolean point(String i){
        Location += i;
        System.out.println("목적지 = "+i);
        return true;
    }
    boolean isOnBoardable() {
        return maxPassengerNumber >= currentPassengerNumber;
    }

    boolean druve_2() {
        System.out.println(drivable = "운행중");
        return true;
    }

    boolean druve_3() {
        System.out.println(drivable = "운행불가");
        return true;
    }

    boolean isDrivable(int a) {
        gasLeft +=a;

            System.out.println("주유량 = " + gasLeft);
        return true;
    }

    boolean onBoard() {
        if (isDrivable(0) && drivable.equals("운행중")) {
            System.out.println("일반");
        } else {

            drivable = "탑승 불가";
            System.out.println("운행불가");
            System.out.println("주유 필요");
        }
        return false;
    }


    int isFareTo(int distanceToDestination) {

        this.distanceToDestination = distanceToDestination;

        if (distanceToDestination > basicDistance) {
            basicFare += (distanceToDestination - basicDistance) * farForDistance;
        } else {
            return basicFare;
        }
        System.out.println("목적지까지 거리 = "+distanceToDestination+"km");
        System.out.println("최종 요금 = " + basicFare);
        mon+=basicFare;
        basicFare=3000;
        currentPassengerNumber=0;
        return basicFare;
    }

    int onBoard2(int passenger) {
        currentPassengerNumber += passenger;
        while (isOnBoardable()){
            if (drivable.equals("운행중")){
                System.out.println("탑승 승객 수 = " + passenger);
                System.out.println("잔여 승객 수 = "+(maxPassengerNumber-currentPassengerNumber));
                System.out.println("기본 요금 확인 = " +basicFare);

            }
            break;
        }
        if (!isOnBoardable()) {
            System.out.println("최대 승객 수 초과");
            currentPassengerNumber=0;

        }
        return currentPassengerNumber;

    }
    boolean mon(){
        System.out.println("누적 요금 = "+mon);

        return true;
    }

}

public class Main2 {
    public static void main(String[] args) {
        Taxi taxi = new Taxi(0);
        taxi.onBoard();
        System.out.println("------------------------------------");
        taxi.isDrivable(0);
        taxi.onBoard2(2);
        taxi.point("서울역");
        taxi.isFareTo(2);
        taxi.druve_2();
        System.out.println("------------------------------------");
        taxi.isDrivable(-80);
        taxi.mon();
        System.out.println("------------------------------------");
        taxi.onBoard2(5);
        System.out.println("------------------------------------");
        taxi.onBoard2(3);
        taxi.point("구로디지털단지역");
        taxi.isFareTo(12);
        System.out.println("------------------------------------");
        taxi.isDrivable(-20);
        taxi.druve_3();
        taxi.mon();

    }
}