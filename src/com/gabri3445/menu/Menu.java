package com.gabri3445.menu;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    /**
     *
     * @param actions Usage: <br>
     *                Map<Integer, MenuOption> actions = Map.of( <br>
     *             0, new Arguments(new Foo()::Bar, "Description for Bar"), <br>
     *             1, new Arguments(new Bar()::Foo, "Description for Foo")
     */
    public void executeMenu(@NotNull Map<Integer, Arguments> actions) {
        int exitNumber = actions.size();
        int choice = -1;
        do {
            actions.forEach((key, value) -> System.out.println("[" + key + "] " + value.description));
            System.out.println("[" + exitNumber + "] Exit");
            try {
                choice = scanner.nextInt();
            } catch (RuntimeException e) {
                System.out.println("Enter a number");
            }
            if (actions.containsKey(choice)) {
                actions.get(choice).action.run();
            }
        } while (choice != exitNumber);
    }

    public class Arguments {
        protected Runnable action;
        protected String description;

        public Arguments(Runnable action, String description) {
            this.action = action;
            this.description = description;
        }
    }
}
