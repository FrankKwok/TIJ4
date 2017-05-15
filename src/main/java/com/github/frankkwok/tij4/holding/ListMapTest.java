package com.github.frankkwok.tij4.holding;

import com.github.frankkwok.tij4.util.TextFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Page 320
 * Exercise 25: Create a Map<String,ArrayList<Integer>>. Use net.mindview.TextFile to open a text file and read it in a
 * word at a time (use "\\W+" as the second argument to the TextFile constructor). Count the words as you read them in,
 * and for each word in the file, record in the ArrayList<Integer> the word count associated with that word—this is, in
 * effect, the location in the file where that word was found.
 * <p>
 * Page 320
 * Exercise 26: Take the resulting Map from the previous exercise and re-create the order of the words as they appeared
 * in the original file.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class ListMapTest {
    public static void main(String[] args) {
        List<String> list = new TextFile(".gitignore", "\\W+");

        Map<String, ArrayList<Integer>> listMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            if (!listMap.keySet().contains(word)) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                listMap.put(word, arrayList);
            } else {
                listMap.get(word).add(i);
            }
        }

        System.out.println(listMap);

        StringBuilder builder = new StringBuilder();
        int position = 0;
        boolean end = false;

        while (!end) {
            int oldPosition = position;
            for (String word : listMap.keySet()) {
                if (listMap.get(word).contains(position)) {
                    position++;
                    builder.append(word);
                    builder.append(" ");
                }
            }
            if (oldPosition == position) {
                end = true;
            }
        }

        System.out.println(builder.toString());
    }
}
