package dataStructs;

import java.util.HashMap;
import java.util.Iterator;

public class LongestKSubSequence{
    char [] sequence;
    LongestKSubSequence(String seq) {
        sequence = new char[seq.length()];
        sequence = seq.toCharArray();

    }

    void printKSubSequence(int k){
        HashMap map = new HashMap<Character, Integer>();

        try{
            for(int i=0;i<sequence.length;i ++)
            {
                Integer count = (Integer) map.get(sequence[i]);
                if(count != null){
                    map.put(sequence[i], count+1);
                }
                else{
                    //First occurrence
                    map.put(sequence[i], 1);
                }
            }
            Iterator<HashMap> iterator = map.entrySet().iterator();

            for(int i=0; i< sequence.length;i++){
                Integer count = (Integer) map.get(sequence[i]);
                if(count != null && count >= k){
                    System.out.print(sequence[i]);
                }
            }


        }
        catch (Exception e){
            System.err.println(e.getStackTrace());
        }

    }
    public static void main(String args[]){
        String s = "ababbc";
        LongestKSubSequence longestKSubSequence = new LongestKSubSequence(s);
        longestKSubSequence.printKSubSequence(2);


    }
}