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
public class heaps_min_max {
    public static void main(String[] args) {
        int a[] = {5,7,8,1,2,4,9};
         BST root = buildTree(a);
        TreePrinter<BST> printer = new TreePrinter<>(n->""+n.data, n->n.left, n->n.right);
        printer.printTree(root);
        System.out.println();
        System.out.println("MAX HEAP : ");
        Maxbuildheap(a);
        BST root1 = buildTree(a);
        printer.printTree(root1);
        System.out.println();
        // int idx = 6;
        // int update = 100;
        // System.out.println("Update value " + a[idx] +" with the value "+update+" follws max heap : [Increase Key ]");
        // System.out.println("after updating : ");
        // increaseKeyMax(a,idx,update);
        // BST root5 = buildTree(a);
        // printer.printTree(root5);
        // System.out.println();
        // int idx1=2;
        // int update1=3;
        // System.out.println("Update value " + a[idx1] +" with the value "+update1+" follws max heap : [decrease Key ]");
        // System.out.println("after updating : ");
        // decreaseKeyMax(a,idx1,update1);
        // BST root6 = buildTree(a);
        // printer.printTree(root6);
        System.out.println();
        // System.out.println("MIN HEAP");
        // Minbuildheap(a);
        // BST root2 = buildTree(a);
        // printer.printTree(root2);
        System.out.println();
        // System.out.println("Sorting in descending order : ");
        // Minheapsort(a);
        // BST root3 = buildTree(a);
        // printer.printTree(root3);
        // System.out.println();
        System.out.println("Sorting in ascending order : ");
        Maxheapsort(a);
        BST root4 = buildTree(a);
        printer.printTree(root4);
    }
    public static void decreaseKeyMax(int a[],int idx,int update){
        a[idx] = update;
       Maxheapify(a, idx, a.length);
        return ;
    }
    public static void increaseKeyMax(int a[],int idx,int update){
        a[idx] = update;
        while(idx > 0 && a[idx] > a[idx/2 - 1]){
            int temp = a[idx];
            a[idx]=a[idx/2 - 1];
            a[idx/2 - 1]=temp;
            idx = idx/2 - 1;
        }
        return ;
    }
    public static void Maxheapsort(int a[]){
        Maxbuildheap(a);
        int  n = a.length;
        for(int i = n - 1 ;i >= 0 ;i--){
                int temp = a[0];
                a[0] = a[i];
                a[i] = temp;
                Maxheapify(a, i, 0);
        }
    }
    public static void Maxheapify(int a[],int n,int bdx){
        int ni = bdx;
        int lci = 2*ni + 1 , rci = 2*ni + 2;
        if(lci < n && a[lci] > a[ni]) ni = lci;
        if(rci < n && a[rci] > a[ni]) ni = rci;
        if(bdx == ni)return ;
        int temp = a[ni];
        a[ni] = a[bdx];
        a[bdx] = temp;
        Maxheapify(a,n,ni);
    }
    public static void Maxbuildheap(int a[]) {
        int n = a.length;
        for(int i = (n / 2 )-1; i >= 0; i--)
        Maxheapify(a,n,i);
        
    }
    // public static void Minheapsort(int a[]){
    //     Minbuildheap(a);
    //     int  n = a.length;
    //     for(int i = n - 1 ;i > 0 ;i--){
    //             int temp = a[0];
    //             a[0] = a[i];
    //             a[i] = temp;
    //             Minheapify(a, i, 0);
    //     }
    // }
    // public static void Minheapify(int a[],int n,int bdx){
    //     int ni = bdx;
    //     int lci = 2*ni + 1 , rci = 2*ni + 2;
    //     if(lci < n && a[lci] < a[ni]) ni = lci;
    //     if(rci < n && a[rci] < a[ni]) ni = rci;
    //     if(bdx == ni)return ;
    //     int temp = a[ni];
    //     a[ni] = a[bdx];
    //     a[bdx] = temp;
    //     Minheapify(a,n,ni);
    // }
    // public static void Minbuildheap(int a[]) {
    //     int n = a.length;
    //     for(int i = (n / 2 )-1; i >= 0; i--)
    //             Minheapify(a,n,i);
        
    // }
    public static BST buildTree(int[] lst) {
       

    if (lst.length == 0 || lst[0] == -1) return null;

    BST root = new BST(lst[0]);
    Queue<BST> q = new LinkedList<>();
    q.add(root);

    int i = 1;
    while (!q.isEmpty() && i < lst.length) {
        BST curr = q.poll();
        if (lst[i] != -1) {
            curr.left = new BST(lst[i]);
            q.add(curr.left);
        }
        i++;
        if (i < lst.length && lst[i] != -1) {
            curr.right = new BST(lst[i]);
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


