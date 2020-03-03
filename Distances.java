import java.util.Collection;
public enum Distances {
    EUCLIDEAN,
    MANHATTAN;

    public static State lowestCostState(Collection<State> states,
                                           State goalState, Distances distance) {
        State minState = null;
        double cost = 0, minCost = 999;
        for(State state : states) {
            // evaluation function g(n) + h(n)
            if(distance == Distances.MANHATTAN) {
                cost = state.cost + manhattan_distance(state, goalState);
            } else {
                cost = state.cost + euclidean_distance(state, goalState);
            }

            if(cost < minCost) {
                minState = state;
                minCost = cost;
            }
        }
        return minState;
    }

    public static State lowestDistanceState(Collection<State> states, State goalState, Distances d) {
        State minState = null;
        double distance, minDistance = 999;
        for(State state : states) {
            if(d == Distances.MANHATTAN) {
                distance = manhattan_distance(state, goalState);
            } else {
                distance = euclidean_distance(state, goalState);
            }
            if(distance < minDistance) {
                minState = state;
                minDistance = distance;
            }
        }
        return minState;
    }

    public static float euclidean_distance( State initialState, State goalState )
    {
        return (float) Math.sqrt(Math.pow((goalState.x - initialState.x), 2.0)
                + Math.pow((goalState.y - initialState.y), 2.0));
    }
    public static float manhattan_distance(State initialState, State goalState)
    {
        return Math.abs(initialState.x - goalState.x) + Math.abs(initialState.x - goalState.y);
    }
   }
