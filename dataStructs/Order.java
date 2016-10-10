package dataStructs;
import java.io.BufferedReader;
import java.io.FileReader;


class Order {
    public static LinkedList l = new LinkedList();

    public static void main(String args[]) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line = br.readLine();
            System.out.println(line);
            int N = Integer.parseInt(line);
            char[][] results = new char[N][N];

            for (int i = 0; i < N; i++) {
                line = br.readLine();
                results[i] = line.toCharArray();
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.println(results[i][j]);
                    if(results[i][j] == 'W') {
                        l.addNode(i);
                        i = j;
                    }

                }
            }
            l.printList();
        } catch (Exception e) {
            System.err.println(e);
        }


    }
}
