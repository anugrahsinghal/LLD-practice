package lld.practice.property;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.out;

public class PropertyHuntApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var commandDispatcher = new CommandDispatcher(
                sc,
                new ShortListRepo(),
                new UserRepo(),
                new ListingRepo()
        );

        while (true) {
            out.println("Input");
            final String in = sc.nextLine();
            if (Objects.equals(in, "exit")) {
                break;
            }
            out.println("Got input -- " + in);

            final String res = commandDispatcher.process(in);

            out.println(res);
        }

        sc.close();
    }

}
