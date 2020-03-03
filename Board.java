import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Board {
    BufferedReader data;

    public Board(String fileName) {
        try {
            data = new BufferedReader(new FileReader(fileName));
            data.close();
        } catch (IOException e) {
            System.err.println("Unable to open " + fileName + " to read.");
            e.printStackTrace();
        }
    }

    public static char[][] designBoardFromFile(String fileName) {
        char[][] board = new char[0][0];

        try {
            int i = 0; //rows
            int j = 0; //columns
            int ArraySize = 0;
            FileReader fr = new FileReader(fileName);
            String line = " ";
            char[] emptyStates;
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    ArraySize = Integer.valueOf(line);
                    board = new char[ArraySize][ArraySize];
                    ++i;
                } else {
                    emptyStates = line.toCharArray();
                    j = 0;
                    //Range Based forloop
                    for (char emptyState : emptyStates) {
                        board[i - 1][j] = emptyState;
                        ++j;
                    }
                    ++i;
                }
            }
        } catch (IOException e) {
            System.err.println("Unable to open: " + fileName + "Try again!");
            e.printStackTrace();
        }
        return board;
    }

    public static void DisplayBoard( char[][] nXn) {

        System.out.println();
        for (int i = 0; i < nXn.length; ++i) {
            for (int j = 0; j < nXn.length; ++j) {
                if (j == nXn.length - 1) {
                    System.out.print(nXn[i][j] + "\n");
                    continue;
                }
                System.out.print(nXn[i][j]);
            }
        }
    }

    public static State getInitialPosition(char[][] nXn) {
        State state = null;
        for (int i = 0; i < nXn.length; ++i) {
            for (int j = 0; j < nXn.length; ++j) {
                if (nXn[i][j] == 'i') {
                    state = new State(i, j);
                    System.out.println(state);
                }
            }
        }
        return state;
    }

    public static State getGoalState(char[][] nXn) {
        State state = null;
        for (int i = 0; i < nXn.length; ++i) {
            for (int j = 0; j < nXn.length; ++j) {
                if (nXn[i][j] == 'g') {
                    state = new State(i, j);
                }
            }
        }
        return state;
    }

    public static ArrayList<State> getNeighbors(State state, char[][] nXn) {
        ArrayList<State> space = new ArrayList<>();
        int i = state.x;
        int j = state.y;

        if (j - 1 >= 0 && nXn[i][j - 1] != '+') {
            space.add(new State(i, j - 1, state.cost + 1, state));
        }

        if (j + 1 <= nXn.length && nXn[i][j + 1] != '+') {
            space.add(new State(i, j + 1, state.cost + 1, state));
        }

        if (i - 1 >= 0 && nXn[i - 1][j] != '+') {
            space.add(new State(i - 1, j, state.cost + 1, state));
        }

        if (i + 1 <= nXn.length && nXn[i + 1][j] != '+') {
            space.add(new State(i + 1, j, state.cost + 1, state));
        }
        return space;
    }
}
