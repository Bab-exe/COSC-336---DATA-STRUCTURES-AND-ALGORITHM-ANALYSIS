class Assignment7{

    public static void main(String[] args) {
        Adj_List_Graph a = new Adj_List_Graph(5);
        a.addEdge(0, 1);
        a.addEdge(2, 3);
        a.addEdge(4, 5);
        a.addEdge(6, 7);

        a.printGraph();
    }
}