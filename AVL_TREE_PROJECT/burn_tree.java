import java.io.PrintStream;
import java.util.*;
import java.util.function.Function;
class BST{
    int data;
    BST left,right;
    public BST(int data){
        this.data=data;
    }
}

class Solution{
static List<List<Integer>> burn(BST root,int x){
    BST strt=null;
    if(root==null)return null;
    Map<BST,BST>mp=new HashMap<>();
    Queue<BST> q=new LinkedList<>();
    q.add(root);
    while(q.size()>0){
        BST k=q.poll();
        if(k.data==x){
            strt=k;
        }
        if(k.left!=null){
            q.add(k.left);
            mp.put(k.left,k);
        }
        if(k.right!=null){
            q.add(k.right);
            mp.put(k.right,k);
        }
}
    
    List<List<Integer>> outer=new ArrayList<>();
    Set<BST> st=new HashSet<>();
    q.add(strt);
    while(q.size()>0){
        int s=q.size();
        List<Integer> lst=new ArrayList<>();
    while(s-->0){
        BST k=q.poll();
        st.add(k);
        lst.add(k.data);
        if(k.left!=null && !st.contains(k.left))q.add(k.left);
        if(k.right!=null && !st.contains(k.right))q.add(k.right);
        if(mp.get(k) !=null ){
        if(!st.contains(mp.get(k)))q.add(mp.get(k));
        }
    }
        outer.add(lst);
        lst=new ArrayList<>();
}
        return outer;
}
static int d=0;
public static  int diameter(BST root){
        height(root);
        return d;
}

public static int height(BST root ){
    if(root==null)return 0;
    int l=height(root.left);
    int r=height(root.right);
    d=Math.max(1+l+r,d);
    return 1+Math.max(l,r);
}
}

class burn_tree {
    static Solution s = new Solution();
    public static void main(String[] args) {
        int a[]={1,2,4,-1,-1,5,-1,-1,3,-1,-1,6,-1};
        // int[] a = {10,15,20,18,6,28,21,9,-1,7,8,-1,-1,32,24,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,26,-1};
        List<Integer> lst=new ArrayList<>();
        for(int i:a)lst.add(i);
        BST root = buildTree(lst);
        TreePrinter<BST> printer = new TreePrinter<>(n->""+n.data, n->n.left, n->n.right);
       printer.printTree(root);
      //  System.out.println(s.diameter(root));
        System.out.println(" ");
        
        // List<List<Integer>> l=s.burn(root,10);
        // for(var i:l){
        //     for(var k:i){
        //         System.out.print(k+" ");
        //     }
        // }
        System.out.println();
        System.out.println();
        System.out.println();


        BST root1=null;
        root1=insert(a,0);
        TreePrinter<BST> p = new TreePrinter<>(n->""+n.data, n->n.left, n->n.right);
        printer.printTree(root1);


    
        System.out.println();
        // System.out.println(l.size()-1);
    
}
static BST insert(int arr[],int index){
    if (index >= arr.length || arr[index] == -1) {
            return null;
        }
        BST root = new BST(arr[index]);
        root.left = insert(arr, 2 * index + 1); 
        root.right = insert(arr, 2 * index + 2);

        return root;
    }
public static BST buildTree(List<Integer> lst) {
       

    if (lst.isEmpty() || lst.get(0) == -1) return null;

    BST root = new BST(lst.get(0));
    Queue<BST> q = new LinkedList<>();
    q.add(root);

    int i = 1;
    while (!q.isEmpty() && i < lst.size()) {
        BST curr = q.poll();
        if (lst.get(i) != -1) {
            curr.left = new BST(lst.get(i));
            q.add(curr.left);
        }
        i++;
        if (i < lst.size() && lst.get(i) != -1) {
            curr.right = new BST(lst.get(i));
            q.add(curr.right);
        }
        i++;
    }

    return root;
}
}




class TreePrinter<T> {

   private Function<T, String> getLabel;
   private Function<T, T> getLeft;
   private Function<T, T> getRight;

   private PrintStream outStream = System.out;

   private boolean squareBranches = false;
   private boolean lrAgnostic = false;
   private int hspace = 2;
   private int tspace = 1;

   public TreePrinter(Function<T, String> getLabel, Function<T, T> getLeft, Function<T, T> getRight) {
       this.getLabel = getLabel;
       this.getLeft = getLeft;
       this.getRight = getRight;
   }

   public void setPrintStream(PrintStream outStream) {
       this.outStream = outStream;
   }

   public void setSquareBranches(boolean squareBranches) { this.squareBranches = squareBranches; }

   public void setLrAgnostic(boolean lrAgnostic) { this.lrAgnostic = lrAgnostic; }

   public void setHspace(int hspace) { this.hspace = hspace; }

   public void setTspace(int tspace) { this.hspace = tspace; }

   /*
       Prints ascii representation of binary tree.
       Parameter hspace is minimum number of spaces between adjacent node labels.
       Parameter squareBranches, when set to true, results in branches being printed with ASCII box
       drawing characters.
    */
   public void printTree(T root) {
       List<TreeLine> treeLines = buildTreeLines(root);
       printTreeLines(treeLines);
   }

   /*
       Prints ascii representations of multiple trees across page.
       Parameter hspace is minimum number of spaces between adjacent node labels in a tree.
       Parameter tspace is horizontal distance between trees, as well as number of blank lines
       between rows of trees.
       Parameter lineWidth is maximum width of output
       Parameter squareBranches, when set to true, results in branches being printed with ASCII box
       drawing characters.
    */
   public void printTrees(List<T> trees, int lineWidth) {
       List<List<TreeLine>> allTreeLines = new ArrayList<>();
       int[] treeWidths = new int[trees.size()];
       int[] minLeftOffsets = new int[trees.size()];
       int[] maxRightOffsets = new int[trees.size()];
       for (int i = 0; i < trees.size(); i++) {
           T treeNode = trees.get(i);
           List<TreeLine> treeLines = buildTreeLines(treeNode);
           allTreeLines.add(treeLines);
           minLeftOffsets[i] = minLeftOffset(treeLines);
           maxRightOffsets[i] = maxRightOffset(treeLines);
           treeWidths[i] = maxRightOffsets[i] - minLeftOffsets[i] + 1;
       }

       int nextTreeIndex = 0;
       while (nextTreeIndex < trees.size()) {
           // print a row of trees starting at nextTreeIndex

           // first figure range of trees we can print for next row
           int sumOfWidths = treeWidths[nextTreeIndex];
           int endTreeIndex = nextTreeIndex + 1;
           while (endTreeIndex < trees.size() && sumOfWidths + tspace + treeWidths[endTreeIndex] < lineWidth) {
               sumOfWidths += (tspace + treeWidths[endTreeIndex]);
               endTreeIndex++;
           }
           endTreeIndex--;

           // find max number of lines for tallest tree
           int maxLines = allTreeLines.stream().mapToInt(list -> list.size()).max().orElse(0);

           // print trees line by line
           for (int i = 0; i < maxLines; i++) {
               for (int j = nextTreeIndex; j <= endTreeIndex; j++) {
                   List<TreeLine> treeLines = allTreeLines.get(j);
                   if (i >= treeLines.size()) {
                       System.out.print(spaces(treeWidths[j]));
                   } else {
                       int leftSpaces = -(minLeftOffsets[j] - treeLines.get(i).leftOffset);
                       int rightSpaces = maxRightOffsets[j] - treeLines.get(i).rightOffset;
                       System.out.print(spaces(leftSpaces) + treeLines.get(i).line + spaces(rightSpaces));
                   }
                   if (j < endTreeIndex) System.out.print(spaces(tspace));
               }
               System.out.println();
           }

           for (int i = 0; i < tspace; i++) {
               System.out.println();
           }

           nextTreeIndex = endTreeIndex + 1;
       }
   }

   private void printTreeLines(List<TreeLine> treeLines) {
       if (treeLines.size() > 0) {
           int minLeftOffset = minLeftOffset(treeLines);
           int maxRightOffset = maxRightOffset(treeLines);
           for (TreeLine treeLine : treeLines) {
               int leftSpaces = -(minLeftOffset - treeLine.leftOffset);
               int rightSpaces = maxRightOffset - treeLine.rightOffset;
               outStream.println(spaces(leftSpaces) + treeLine.line + spaces(rightSpaces));
           }
       }
   }

   private List<TreeLine> buildTreeLines(T root) {
       if (root == null) return Collections.emptyList();
       else {
           String rootLabel = getLabel.apply(root);
           List<TreeLine> leftTreeLines = buildTreeLines(getLeft.apply(root));
           List<TreeLine> rightTreeLines = buildTreeLines(getRight.apply(root));

           int leftCount = leftTreeLines.size();
           int rightCount = rightTreeLines.size();
           int minCount = Math.min(leftCount, rightCount);
           int maxCount = Math.max(leftCount, rightCount);

           // The left and right subtree print representations have jagged edges, and we essentially we have to
           // figure out how close together we can bring the left and right roots so that the edges just meet on
           // some line.  Then we add hspace, and round up to next odd number.
           int maxRootSpacing = 0;
           for (int i = 0; i < minCount; i++) {
               int spacing = leftTreeLines.get(i).rightOffset - rightTreeLines.get(i).leftOffset;
               if (spacing > maxRootSpacing) maxRootSpacing = spacing;
           }
           int rootSpacing = maxRootSpacing + hspace;
           if (rootSpacing % 2 == 0) rootSpacing++;
           // rootSpacing is now the number of spaces between the roots of the two subtrees

           List<TreeLine> allTreeLines = new ArrayList<>();

           // strip ANSI escape codes to get length of rendered string. Fixes wrong padding when labels use ANSI escapes for colored nodes.
           String renderedRootLabel = rootLabel.replaceAll("\\e\\[[\\d;]*[^\\d;]", "");

           // add the root and the two branches leading to the subtrees

           allTreeLines.add(new TreeLine(rootLabel, -(renderedRootLabel.length() - 1) / 2, renderedRootLabel.length() / 2));

           // also calculate offset adjustments for left and right subtrees
           int leftTreeAdjust = 0;
           int rightTreeAdjust = 0;

           if (leftTreeLines.isEmpty()) {
               if (!rightTreeLines.isEmpty()) {
                   // there's a right subtree only
                   if (squareBranches) {
                       if (lrAgnostic) {
                           allTreeLines.add(new TreeLine("\u2502", 0, 0));
                       } else {
                           allTreeLines.add(new TreeLine("\u2514\u2510", 0, 1));
                           rightTreeAdjust = 1;
                       }
                   } else {
                       allTreeLines.add(new TreeLine("\\", 1, 1));
                       rightTreeAdjust = 2;
                   }
               }
           } else if (rightTreeLines.isEmpty()) {
               // there's a left subtree only
               if (squareBranches) {
                   if (lrAgnostic) {
                       allTreeLines.add(new TreeLine("\u2502", 0, 0));
                   } else {
                       allTreeLines.add(new TreeLine("\u250C\u2518", -1, 0));
                       leftTreeAdjust = -1;
                   }
               } else {
                   allTreeLines.add(new TreeLine("/", -1, -1));
                   leftTreeAdjust = -2;
               }
           } else {
               // there's a left and right subtree
               if (squareBranches) {
                   int adjust = (rootSpacing / 2) + 1;
                   String horizontal = String.join("", Collections.nCopies(rootSpacing / 2, "\u2500"));
                   String branch = "\u250C" + horizontal + "\u2534" + horizontal + "\u2510";
                   allTreeLines.add(new TreeLine(branch, -adjust, adjust));
                   rightTreeAdjust = adjust;
                   leftTreeAdjust = -adjust;
               } else {
                   if (rootSpacing == 1) {
                       allTreeLines.add(new TreeLine("/ \\", -1, 1));
                       rightTreeAdjust = 2;
                       leftTreeAdjust = -2;
                   } else {
                       for (int i = 1; i < rootSpacing; i += 2) {
                           String branches = "/" + spaces(i) + "\\";
                           allTreeLines.add(new TreeLine(branches, -((i + 1) / 2), (i + 1) / 2));
                       }
                       rightTreeAdjust = (rootSpacing / 2) + 1;
                       leftTreeAdjust = -((rootSpacing / 2) + 1);
                   }
               }
           }

           // now add joined lines of subtrees, with appropriate number of separating spaces, and adjusting offsets

           for (int i = 0; i < maxCount; i++) {
               TreeLine leftLine, rightLine;
               if (i >= leftTreeLines.size()) {
                   // nothing remaining on left subtree
                   rightLine = rightTreeLines.get(i);
                   rightLine.leftOffset += rightTreeAdjust;
                   rightLine.rightOffset += rightTreeAdjust;
                   allTreeLines.add(rightLine);
               } else if (i >= rightTreeLines.size()) {
                   // nothing remaining on right subtree
                   leftLine = leftTreeLines.get(i);
                   leftLine.leftOffset += leftTreeAdjust;
                   leftLine.rightOffset += leftTreeAdjust;
                   allTreeLines.add(leftLine);
               } else {
                   leftLine = leftTreeLines.get(i);
                   rightLine = rightTreeLines.get(i);
                   int adjustedRootSpacing = (rootSpacing == 1 ? (squareBranches ? 1 : 3) : rootSpacing);
                   TreeLine combined = new TreeLine(leftLine.line + spaces(adjustedRootSpacing - leftLine.rightOffset + rightLine.leftOffset) + rightLine.line,
                           leftLine.leftOffset + leftTreeAdjust, rightLine.rightOffset + rightTreeAdjust);
                   allTreeLines.add(combined);
               }
           }
           return allTreeLines;
       }
   }

   private static int minLeftOffset(List<TreeLine> treeLines) {
       return treeLines.stream().mapToInt(l -> l.leftOffset).min().orElse(0);
   }

   private static int maxRightOffset(List<TreeLine> treeLines) {
       return treeLines.stream().mapToInt(l -> l.rightOffset).max().orElse(0);
   }

   private static String spaces(int n) {
       return String.join("", Collections.nCopies(n, " "));
   }

   private static class TreeLine {
       String line;
       int leftOffset;
       int rightOffset;

       TreeLine(String line, int leftOffset, int rightOffset) {
           this.line = line;
           this.leftOffset = leftOffset;
           this.rightOffset = rightOffset;
       }
   }
}


