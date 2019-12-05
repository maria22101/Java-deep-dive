package task_1.view;

public class View {
    public static final String DEPOSITS_SORTED_BY_RATE = "Deposits sorted by rate: ";
    public static final String DEPOSITS_SORTED_BY_BANK = "Deposits sorted by bank: ";
    public static final String DEPOSITS_TERMINABLE = "Deposits terminable: ";
    public static final String DEPOSITS_WITH_REPLENISHMENT = "Deposits with replenishment: ";
    public static final String DEPOSITS_FOR_SUM = "Deposits that match your sum: ";
    public static final String REQUEST_SIGN = "-------";
    public static final String SPACE_BETWEEN_REQUESTS = "\n";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printSign(String sign) {
        System.out.print(sign);
    }
}
