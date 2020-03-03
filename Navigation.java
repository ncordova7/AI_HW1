import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Navigation  {
    String fileName;
    public State initialState, goalState;
    public PriorityQueue queue;


    public Navigation(String file ) {
        fileName = file;
    }

    public void relativePath(Distances distance, boolean useCost) {
        ArrayList<State> findNeighbors = new ArrayList<>();
        ArrayList<State> visited = new ArrayList<>();
        ArrayList<State> frontier = new ArrayList<>();
        HashSet<State> searchTree = new HashSet<>();

        char[][] route = Board.designBoardFromFile(fileName);

        State initialState = Board.getInitialPosition(route);
        State goalState = Board.getGoalState(route);

        if(route.length < 1) { return; }

        int path_Cost = 0;

        searchTree.add(initialState);
        visited.add(initialState);

        State current_State = initialState;
        State currState;

        while(!current_State.equals(goalState)) {
            findNeighbors = Board.getNeighbors(current_State, route);
            searchTree.addAll(findNeighbors);

            frontier.addAll(findNeighbors);
            frontier.removeAll(visited);

            if(useCost) {
                current_State = Distances.lowestCostState(frontier, goalState, distance);
            } else {
                current_State = Distances.lowestDistanceState(frontier, goalState, distance);
            }

            path_Cost = current_State.cost;
            visited.add(current_State);
        }

        current_State = current_State.parent;
        while(!current_State.equals(initialState)) {
            route[current_State.x][current_State.y] = 'o';
            current_State = current_State.parent;
        }

        Board.DisplayBoard(route);
        System.out.print("\nPath cost: " + path_Cost + "\nSearch tree size: " + searchTree.size() + '\n');
    }

}
