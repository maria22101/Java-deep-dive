package task_1_with_interface.view;

import task_1_with_interface.model.entity.Deposit;
import task_1_with_interface.model.entity.DepositTerminable;
import task_1_with_interface.model.entity.DepositWithReplenishment;

import java.math.RoundingMode;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static task_1.view.TextConstants.*;

/**
 * @author Maria Bilous
 */
public class View {

    static String REQUEST_BUNDLE_NAME = "request";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    REQUEST_BUNDLE_NAME,
                    new Locale("ua", "UA")); // Ukrainian
//                    new Locale("en")); // English

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printSign(String sign) {
        System.out.print(sign);
    }

    public void printRequest(String request) {
        printMessage(bundle.getString(request));
    }

    public String concatenatedString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String s : message) {
            concatString.append(s);
        }
        return new String(concatString);
    }

    public String basicDepositFields(Deposit d) {
        return concatenatedString(
                bundle.getString(SUM), EQUALS_SIGN, d.sum().toString(), SPACE_SIGN,
                bundle.getString(INTEREST_RATE), EQUALS_SIGN,
                d.interestRate().setScale(2, RoundingMode.HALF_UP).toString(), SPACE_SIGN,
                bundle.getString(PERIOD), EQUALS_SIGN, String.valueOf(d.periodInDays()), SPACE_SIGN,
                bundle.getString(BANK), EQUALS_SIGN, d.bank().toString());
    }

    public void displayBasicDepositFields(List<Deposit> list) {
        list.forEach(d -> {
            System.out.println(Stream.of(basicDepositFields(d))
                    .collect(Collectors.joining(SPACE_SIGN, DEPOSIT_LINE_START, DEPOSIT_LINE_END)));
        });
    }

    public void displayTerminableDeposits(List<DepositTerminable> list) {
        list.forEach(d -> {
            String terminableDepositFields = concatenatedString(
                    basicDepositFields(d), SPACE_SIGN,
                    bundle.getString(DAYS_PASSED_BEFORE_TERMINATION), EQUALS_SIGN,
                    String.valueOf(d.getDaysPassedBeforeTermination()), SPACE_SIGN,
                    bundle.getString(INTEREST_RATE_FOR_TERMINATION), EQUALS_SIGN,
                    d.getInterestRateForTermination().setScale(2, RoundingMode.HALF_UP).toString());

            System.out.println(Stream.of(terminableDepositFields)
                    .collect(Collectors.joining(SPACE_SIGN, DEPOSIT_LINE_START, DEPOSIT_LINE_END)));
        });
    }

    public void displayReplenishedDeposits(List<DepositWithReplenishment> list) {
        list.forEach(d -> {
            String replenishDepositFields = concatenatedString(
                    basicDepositFields(d), SPACE_SIGN,
                    bundle.getString(DAYS_LEFT_TILL_PERIOD_END), EQUALS_SIGN,
                    String.valueOf(d.getDaysLeftTillEndOfPeriod()), SPACE_SIGN,
                    bundle.getString(REPLENISHMENT_SUM), EQUALS_SIGN,
                    d.getReplenishmentSum().setScale(2, RoundingMode.HALF_UP).toString());

            System.out.println(Stream.of(replenishDepositFields)
                    .collect(Collectors.joining(SPACE_SIGN, DEPOSIT_LINE_START, DEPOSIT_LINE_END)));
        });
    }
}