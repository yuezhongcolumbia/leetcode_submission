/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int row = rand7();
        int col = rand7();
        int idx = (row - 1 )* 7 + col;

        
        if (idx > 40 ) return rand10();

        return idx % 10 + 1;




    }
}