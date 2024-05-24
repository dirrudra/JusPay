package questions;
import java.util.Scanner;

public class NearestMeetingCell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCells = scanner.nextInt();
        int[] cellEdges = new int[numberOfCells];
        for (int i = 0; i < numberOfCells; i++) {
            cellEdges[i] = scanner.nextInt();
        }
        int firstCellIndex = scanner.nextInt();
        int secondCellIndex = scanner.nextInt();
        System.out.println(nearestMeetingCellIndex(cellEdges, firstCellIndex, secondCellIndex, numberOfCells));
        scanner.close();
    }

    public static int nearestMeetingCellIndex(int[] cellEdges, int firstCellIndex, int secondCellIndex, int numberOfCells) {
        boolean[] visited = new boolean[numberOfCells];
        int firstIndex = firstCellIndex;
        int secondIndex = secondCellIndex;
        while (firstIndex != -1 && secondIndex != -1 && !visited[firstIndex] && !visited[secondIndex]) {
            visited[firstIndex] = true;
            visited[secondIndex] = true;
            firstIndex = cellEdges[firstIndex];
            secondIndex = cellEdges[secondIndex];
        }
        if (visited[firstIndex]) {
            return firstIndex;
        } else if (visited[secondIndex]) {
            return secondIndex;
        }
        return -1;
    }
}
