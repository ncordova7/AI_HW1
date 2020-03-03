import java.io.BufferedReader;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Input file name(test file included");
            //return;
        }

        Navigation nav = new Navigation("test.txt");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int userChoice = 0;

        while (userChoice != 5) {
            SystemMenu();

            try {
                userChoice = Integer.parseInt(input.readLine());
            } catch (Exception e) {
                System.out.println("Path Selection (1-5)");
                continue;
            }

            if (userChoice < 1 || userChoice > 5) {
                System.out.println("Path Selection (1-5)");
                continue;
            }
            switch (userChoice) {
                case 1:
                    nav.relativePath(Distances.EUCLIDEAN, false);
                    break;
                    case 2:
                                        nav.relativePath(Distances.MANHATTAN, false);
                                        break;
                                    case 3:
                                        nav.relativePath(Distances.EUCLIDEAN, true);
                                        break;
                                    case 4:
                                        nav.relativePath(Distances.MANHATTAN, true);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }

                        public static void SystemMenu() {
                            System.out.print("\n 1. Euclidean distances \n " +
                                    "2. Manhattan distances \n " +
                                    "3. Euclidean distances with Path Cost \n " +
                                    "4. Manhattan distances with Path Cost " + "\n " +
                                    "5. Exit \n Choose an option 1-5: ");
                        }
                    }
