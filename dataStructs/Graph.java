package dataStructs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

class Graph{
    static class GraphNode
    {
        char nodeId;
        LinkedList<Character> neighbors = new LinkedList();
        GraphNode(char id, char[] neighborIds){
            try {
                nodeId = id;
                for (int i = 0; i < neighborIds.length; i++) {
                    neighbors.add(neighborIds[i]);
                }
            }
            catch (Exception e){
                System.err.println(e);
            }
        }
        public void printNode(){
            System.out.println("Node:" +nodeId);
            ListIterator<Character> iterator = neighbors.listIterator();
            try{
                while(iterator.hasNext())
                    System.out.println("->"+ iterator.next());
            }
            catch(Exception e){
                System.err.println(e);
            }
        }
    }
    int nodeCount = 0;
    HashMap nodes;

    Graph(int nc){
        nodeCount = nc;
        nodes = new HashMap<Character, GraphNode>(nodeCount);
    }
    int size(){
        return nodeCount;
    }

    void initGraphNodes(char id, char[] neighborsIds){
        GraphNode node = new GraphNode(id, neighborsIds);
        nodes.put(id, node);
    }
    void addNewGraphNodes(GraphNode graphNode){
        nodeCount++;
        nodes.put(graphNode.nodeId, graphNode);
    }
    void printGraph(){
        Iterator<HashMap> iterator = nodes.entrySet().iterator();
        while(iterator.hasNext()){
            HashMap.Entry pair = (HashMap.Entry) iterator.next();
            GraphNode node = (GraphNode)pair.getValue();
            node.printNode();
        }

    }
    public static void main(String args[]){
        Graph g = new Graph(3);
        char [] neighborsList;
        neighborsList = new char[]{'b', 'c'};
        g.initGraphNodes('a',neighborsList);
        //neighborsList = {'c'};
        g.initGraphNodes('b',neighborsList);
        //neighborsList = {'a', 'b'};
        g.initGraphNodes('c',neighborsList);
        g.printGraph();
    }

}