import java.util.*;

public class LCRankTransformAMatrix {
    public static void main(String[] args) {

        LCRankTransformAMatrix runner = new LCRankTransformAMatrix();

        int[][] input = { {1, 2}, {3, 4} };
        printMatrix(runner.matrixRankTransform(input)); // Ans: [[1,2],[2,3]]

        int[][] input2 = { {7, 7},{7, 7} };
        printMatrix(runner.matrixRankTransform(input2)); // [[1,1],[1,1]]

        int[][] input3 = {{20,-21,14},{-19,4,19},{22,-47,24},{-19,4,19}};
        printMatrix(runner.matrixRankTransform(input3)); // [[4,2,3],[1,3,4],[5,1,6],[1,3,4]]

        int[][] input4 = {{7,3,6},{1,4,5},{9,8,2}};
        printMatrix(runner.matrixRankTransform(input4)); // [[5,1,4],[1,2,3],[6,3,1]]

        int[][] input5 = {{-37,-50,-3,44},{-37,46,13,-32},{47,-42,-3,-40},{-17,-22,-39,24}};
        printMatrix(runner.matrixRankTransform(input5)); // [[2,1,4,6],[2,6,5,4],[5,2,4,3],[4,3,1,5]]
    }

    static void printMatrix(int[][] rankMatrix) {
        System.out.print("[");
        for (int i = 0; i < rankMatrix.length; i++) {
            System.out.print(Arrays.toString(rankMatrix[i]));
            if (i != rankMatrix.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] rankMatrix = new int[rows][cols];

        // Create a TreeMap with the matrix cell values as keys since it stores keys in ASCENDING order
        TreeMap<Integer, ArrayList<Coordinate>> coordinatesByVal = new TreeMap<Integer, ArrayList<Coordinate>>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int val = matrix[r][c];
                if (coordinatesByVal.get(val) == null) {
                    ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
                    coordinates.add(new Coordinate(r, c));
                    coordinatesByVal.put(val, coordinates);
                } else {
                    coordinatesByVal.get(val).add(new Coordinate(r, c));
                }
            }
        }

        // Create an array to store max for each row and col; cols start after rows
        int[] maxRowColValues = new int[rows + cols];

        // Assign ranks to coordinates of each val starting from lowest val
        for (int val: coordinatesByVal.keySet()) {
            ArrayList<Coordinate> coordinatesWithSameVal = coordinatesByVal.get(val);
            
            // Create a copy of maxRowColValues to make edits here; O(rows + cols)
            int[] maxRowColValuesClone = new int[rows + cols];
            for (int i = 0; i < maxRowColValues.length; i++) {
                maxRowColValuesClone[i] = maxRowColValues[i];
            }

            DisjointSet disjointSet = new DisjointSet(rows + cols); // each row and each col is now a subset of itself; O(rows + cols)

            for (Coordinate coordinate: coordinatesWithSameVal) {
                disjointSet.uniteSubsets(coordinate.x, coordinate.y + rows); // rows is added because 0 to rows-1 is for x-coordinates
                // Total time over complete matrix: O([rows + cols] log2([rows + cols]))
            }

            // Group coordinates with same root
            HashMap<Node, ArrayList<Coordinate>> coordinatesByRoot = new HashMap<Node, ArrayList<Coordinate>>();
            for (Coordinate coordinate: coordinatesWithSameVal) {
                Node root = disjointSet.findRoot(coordinate.x); // y val is already united with x, so no need to find it
                if (coordinatesByRoot.get(root) == null) {
                    ArrayList<Coordinate> nodes = new ArrayList<Coordinate>();
                    nodes.add(coordinate);
                    coordinatesByRoot.put(root, nodes);
                } else {
                    coordinatesByRoot.get(root).add(coordinate);
                }
            }

            // Get maxRowColVal of each group and assign it to their rankMatrix cell
            for (Node root: coordinatesByRoot.keySet()) {
                ArrayList<Coordinate> groupCoordinates = coordinatesByRoot.get(root);

                // Get maxRowColVal of each group
                int maxRankOfGroup = 0;
                for (Coordinate coordinate: groupCoordinates) {
                    int x = coordinate.x, y = coordinate.y;
                    maxRankOfGroup = Math.max(maxRankOfGroup, Math.max(maxRowColValues[x], maxRowColValues[y + rows]));
                }

                // Assign new rank to each coordinate and then to all row-col values
                for (Coordinate coordinate: groupCoordinates) {
                    System.out.println("Assigning rank " + (maxRankOfGroup + 1) + " to [" + coordinate.x + ", " + coordinate.y + "]");
                    rankMatrix[coordinate.x][coordinate.y] = maxRankOfGroup + 1;
                    maxRowColValues[coordinate.x] = maxRankOfGroup + 1;
                    maxRowColValues[coordinate.y + rows] = maxRankOfGroup + 1;
                }
            }
        }
        return rankMatrix;
    }

    class Coordinate {
        int x, y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Node {
        int parent;
        int rank;

        Node(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    class DisjointSet {
        Node[] subsets;

        DisjointSet(int numOfSubsetsAtStart) {
            this.subsets = new Node[numOfSubsetsAtStart];
            for (int i = 0; i < numOfSubsetsAtStart; i++) {
                subsets[i] = new Node(i, 1);
            }
        }

        // Find root parent of a number; this is essentially the "FIND" function of Union-Find
        Node findRoot(int num) {
            if (subsets[num].parent == num) {
                return subsets[num];
            } else {
                Node root = findRoot(subsets[num].parent);
                subsets[num].parent = root.parent; // This is path compression
                return root;
            }
        }

        // This is essentially "UNION BY RANK"; hence unions take log2(number of subsets)
        void uniteSubsets(int val1, int val2) {
            Node root1 = findRoot(val1);
            Node root2 = findRoot(val2);

            if (root1.rank < root2.rank) {
                // Since root2 has higher rank, root1 should be added as a child, otherwise root1's rank will be even higher
                root1.parent = root2.parent; // BTW root2.parent will always be its index in subsets array
                // No need to increase rank of root2, since its anyways higher
            } else if (root2.rank > root1.rank) {
                root2.parent = root1.parent; // No need to increase rank of root1, since its anyways higher
            } else {
                root1.parent = root2.parent;
                root2.rank++; // Both have same rank, hence the rank of the new parent needs to be increased
            }
        }
    }
}
