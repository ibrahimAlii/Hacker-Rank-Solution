package datastructure;

/**
 * Andy and Lily love playing games with numbers and trees. Today they have a tree consisting of  nodes and  edges. Each edge  has an integer weight, .
 *
 * Before the game starts, Andy chooses an unordered pair of distinct nodes, , and uses all the edge weights present on the unique path from node  to node  to construct a list of numbers. For example, in the diagram below, Andy constructs a list from the edge weights along the path :
 *
 * image
 *
 * Andy then uses this list to play the following game with Lily:
 *
 * Two players move in alternating turns, and both players play optimally (meaning they will not make a move that causes them to lose the game if some better, winning move exists).
 * Andy always starts the game by removing a single integer from the list.
 * During each subsequent move, the current player removes an integer less than or equal to the integer removed in the last move.
 * The first player to be unable to move loses the game.
 * For example, if the list of integers is  and Andy starts the game by removing , the list becomes . Then, in Lily's move, she must remove a remaining integer less than or equal to  (i.e., , , , or ).
 *
 * The two friends decide to play  games, where each game is in the form of a tree. For each game, calculate the number of unordered pairs of nodes that Andy can choose to ensure he always wins the game.
 *
 * Input Format
 *
 * The first line contains a single integer, , denoting the number of games. The subsequent lines describe each game in the following format:
 *
 * The first line contains an integer, , denoting the number of nodes in the tree.
 * Each line  of the  subsequent lines contains three space-separated integers describing the respective values of , , and  for the  edge connecting nodes  and  with weight .
 * Constraints
 *
 * Sum of  over all games does not exceed
 * Scoring
 *
 * For  of score, the sum of  over all games does not exceed .
 * For  of score, the sum of  over all games does not exceed .
 * Output Format
 *
 * For each game, print an integer on a new line describing the number of unordered pairs Andy can choose to construct a list that allows him to win the game.
 *
 * Sample Input 0
 *
 * 3
 * 5
 * 1 2 2
 * 1 3 1
 * 3 4 1
 * 3 5 2
 * 5
 * 1 2 0
 * 2 3 2
 * 3 4 2
 * 4 5 0
 * 5
 * 1 2 0
 * 1 3 1
 * 3 4 0
 * 3 5 2
 * Sample Output 0
 *
 * 9
 * 8
 * 10
 * Explanation 0
 *
 * Andy and Lily play the following  games:
 *
 * The first game's tree looks like this:
 * image
 *
 * There are  ways to choose , and only one such pair causes Andy to lose the game. If he chooses the pair , the list is . Andy removes  in his first move, and Lily removes the remaining  in the next move; at this point, Andy has no remaining moves and Lily wins. Because Andy will win if he selects any of the other  pairs, we print  on a new line.
 *
 * The second game's tree looks like this:
 * image
 *
 * There are  ways to choose , and two pairs that cause Andy to lose the game:
 *
 * If Andy chooses , the list is . Andy removes  in his first move, and Lily removes the remaining  in the next move; at this point, Andy has no remaining moves and Lily wins.
 * If Andy chooses , the list is . Andy can remove either a  or a  in the first move, but either way Lily will make an optimal choice in her next move that causes Andy to lose. Andy will win if he selects any of the other  pairs, so we print  on a new line.
 * The third game's tree looks like this:
 * image
 * There are  ways to choose , and Andy will win the game regardless of which pair he chooses. Thus, we print  on a new line.
 */
public class NumberGameOnATree {

    static int numberGameOnATree(int n, int[][] edges) {
        int possibleGamesToWin = 0;



        return possibleGamesToWin;

    }

    public static void main(String[] args){

    }
}
