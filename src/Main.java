class Bus {
    //  필드
    int busNumber;
    int busNumber2;// 버스 번호
    int maxPassengerNumber = 30; // 최대 승객수
    int currentPassengerNumber = 0; // 현재 승객수
    int gasRemaining = 0; // 주유량
    String status = "운행중"; // 상태


    Bus() {
        this.busNumber = (int) (Math.random() * 10 + 1);
        this.busNumber2 = (int) (Math.random() * 10 + 1);
        System.out.println("버스번호:" + busNumber);
        System.out.println("버스번호:" + busNumber2);
    }


    boolean isLeftGas() {
        return gasRemaining >= 10;
    }

    boolean isOnBoardable() {
        return maxPassengerNumber >= currentPassengerNumber;
    }

    boolean drive(int i) {
        gasRemaining += i;
        if (isLeftGas()) {
            System.out.println("주유량 = " + gasRemaining);
            return true;
        }

        if (!isLeftGas()) {
            System.out.println("주유량 = " + gasRemaining);
            System.out.println(status = "차고지행");

        }
        return true;
    }

    boolean druve_2 () {
        System.out.println(status = "차고지행");
        return true;
    }
    boolean druve_3 () {
        System.out.println(status = "운행중");
        return true;
    }






    //  승객 탑승
    int onBoard(int passenger) {
        currentPassengerNumber += passenger;
        while (isOnBoardable()) {
            if (status.equals("운행중")) {
                System.out.println("탑승 승객 수 = " + passenger);
                System.out.println("잔여 승객 수 = "+(maxPassengerNumber-currentPassengerNumber));
                System.out.println("요금 확인 ="+ (passenger*1000));

            }
            break;
        }
        if (!isOnBoardable()) {
            System.out.println("최대 승객 수 초과");
        }
        return currentPassengerNumber;

    }

}

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus();
        System.out.println(bus.status);
        bus.onBoard(2);
        System.out.println("--------------------------------------");
        bus.drive(50);
        System.out.println("--------------------------------------");
        bus.druve_2();
        bus.drive(10);
        System.out.println("--------------------------------------");
        bus.druve_3();
        bus.onBoard(5);
        System.out.println("--------------------------------------");
        bus.drive(-55);
    }
}

