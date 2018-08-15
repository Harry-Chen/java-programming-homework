import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LinkedListAdder {

    private static LinkedList<Integer> generateList(String s) {
        var list =  List.of(s.split("\\s+"))
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(LinkedList::new));
        Collections.reverse(list);
        return list;
    }

    private static LinkedList<Integer> add(LinkedList<Integer> a, LinkedList<Integer> b) {

        var result = new LinkedList<Integer>();
        var i = a.listIterator();
        var j = b.listIterator();
        while (i.hasNext() || j.hasNext()) {
            if (i.hasNext() && j.hasNext()) {
                result.add(i.next() + j.next());
            } else if (i.hasNext()) {
                result.add(i.next());
            } else {
                result.add(j.next());
            }
        }

        var k = result.listIterator();
        while (k.hasNext()) {
            var now = k.next();
            if (now >= 10) {
                k.set(now - 10);
                if (k.nextIndex() == result.size()) {
                    k.add(1);
                } else {
                    var next = k.next();
                    k.set(next + 1);
                    k.previous();
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        var in = new Scanner(System.in);
        var a = generateList(in.nextLine().trim());
        var b = generateList(in.nextLine().trim());
        var c= add(a, b);
        Collections.reverse(c);
        // System.out.println(String.join(" ", c.stream().map(String::valueOf).collect(Collectors.toList())));
        c.forEach(i -> System.out.print(i + " "));
    }
}
