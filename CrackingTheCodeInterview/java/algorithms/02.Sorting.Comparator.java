// Comparators are used to compare two objects. In this challenge,
// you'll create a comparator and use it to sort an array.
// The Player class is provided in the editor below; it has two fields:
//
// A string, name.
// An integer, score.
// Given an array of  Player objects, write a comparator that sorts them in
// order of decreasing score; if  or more players have the same score, sort
// those players alphabetically by name.
// To do this, you must create a Checker class that implements the Comparator
// interface, then write an int compare(Player a, Player b) method implementing
// the Comparator.compare(T o1, T o2) method.

// Sample Input
//
// 5
// amy 100
// david 100
// heraldo 50
// aakansha 75
// aleksa 150
// Sample Output
//
// aleksa 150
// amy 100
// david 100
// aakansha 75
// heraldo 50


import java.util.*;

// Write your Checker class here
class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if(a.score != b.score) {
            return b.score - a.score;
        }
        // Compares two strings lexicographically. The comparison is based on the Unicode value of each character in the strings.
        // The character sequence represented by this String object is compared lexicographically to the character sequence represented by the argument string.
        // The result is a negative integer if this String object lexicographically precedes the argument string.
        // The result is a positive integer if this String object lexicographically follows the argument string.
        return a.name.compareTo(b.name);
    }
}


class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
