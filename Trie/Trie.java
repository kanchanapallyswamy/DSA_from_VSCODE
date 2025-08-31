import java.util.ArrayList;
import java.util.List;
class TNode {
    TNode[] child = new TNode[26];
    boolean isEow;
}

class Trie {

    TNode root = new TNode();

    Trie() {
    }

    void insertWord(String word) {
        TNode current = root;
        char[] chars = word.toCharArray();

        for (char c : chars) {
            int index = c - 'a';
            if (current.child[index] == null) {
                current.child[index] = new TNode();
            }
            current = current.child[index];
        }

        current.isEow = true; // end of word
    }

    boolean hasWord(String word) {
        TNode current = root;
        char[] chars = word.toCharArray();

        for (char c : chars) {
            int index = c - 'a';
            if (current.child[index] == null) {
                return false;
            }
            current = current.child[index];
        }

        return current.isEow;
    }

    List<String> allWords() {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(root, result, sb);
        return result;
    }

    void helper(TNode node, List<String> list, StringBuilder sb) {
        if (node.isEow) {
            list.add(sb.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                sb.append((char) (i + 'a'));
                helper(node.child[i], list, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    List<String> getAllWordWithPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        TNode current = root;

        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            int index = c - 'a';
            if (current.child[index] == null) {
                return result; // no words with this prefix
            }
            current = current.child[index];
        }

        StringBuilder sb = new StringBuilder(prefix);
        helper(current, result, sb);
        return result;
    }
}
