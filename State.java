public class State {
    int x, y, cost;
    public State parent;

    public State(int x, int y) {
        this.x = x;
        this.y = y;
        cost = 0;
        parent = null;
    }

    public State(int x, int y, int pathCost, State ParentState) {
        this.x = x;
        this.y = y;
        cost = pathCost;
        parent = ParentState;
    }

     //Had some assistance from : https://stackabuse.com/javas-object-methods-equals-object/
    public boolean equals(Object o) {
        if(!(o instanceof State)) {
            return false;
        }
        State state = (State) o;
        return x == state.x && y == state.y;
    }
}
